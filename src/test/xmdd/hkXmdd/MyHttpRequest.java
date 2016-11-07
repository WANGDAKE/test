package hkXmdd;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.MultipartPostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.testng.Assert;

import java.io.File;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;


/**
 * Http璇锋眰
 * @author WeiYating
 */
public class MyHttpRequest {
	//log4j涓殑瀵硅薄锛岀敤浜庤緭鍑轰俊鎭拰璁板綍Log
    
    static Logger logger = Logger.getLogger(MyHttpRequest.class);

    public static JSONObject search(Http httpRequest, String host, String confpath,String path, int port, CookieStore cookie) throws Exception {
    	//HttpUriRequest 鏄姹傚璞�
    	HttpUriRequest request = null;
    	//URIBuilder鐢ㄤ簬寤虹珛涓�涓猆rl瀵硅薄
        URIBuilder builder = new URIBuilder();
        path = confpath+path;
        
   //     HttpServletRequest myreq = (HttpServletRequest) new HttpRequest();
   //     myreq.getMethod();
        
        //寤虹珛涓�涓猽rl杩炴帴
        if (port == 0) {
                builder.setScheme("https").setHost(host).setPath(path);
        } else {
            builder.setScheme("http").setHost(host).setPort(port).setPath(path);
        }
        //璁剧疆url鍙傛暟
        List<Parameter> paras = httpRequest.getParameters();
        if (paras != null) {
            for (Parameter p : paras) {        	
                builder.setParameter(p.getName(), p.getValue().toString());
                /*if(p.getValue().equals("imageData")){
                	ByteArrayEntity b = new ByteArrayEntity(null);
                	
                }*/
               // System.out.println("http:"+p.getValue().toString());
            }
        }
        //鍒拌繖閲屼负姝紝url鍒涘缓濂戒簡銆備笅闈㈢殑logger.info("   [  post  ] " + url);浼氭墦鍗板嚭url鐨勮矾寰勶紝杩愯涓�涓嬪氨鑳界湅鍒拌姹傜殑url鏄�庝箞鏍风殑
        String url = builder.build().toString(); 
       // String url ="http://122.224.218.55:555/hzlqswserver/uploadUserImage.do?account=18667150226&accountType=1&clientType=android_1.0.0&timeStamp=1408956997198&imageData=[B@589e56&cid=RmZaZUNIcUwxaUdESGlwQ2NjSnZmY1dqRit2RGMydEwwbEtmQWFoTFloanVVQ3Y4ZE5zM2VnPT0%3D";
        //post.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
        
        //equalsIgnoreCase涓嶈�冭檻澶у皬鍐欒繘琛屾瘮杈冦��
        if (httpRequest.getConnection().equalsIgnoreCase("post")) {
            logger.info("   [  post  ] " + url);
            //鏍规嵁url	瀹炰緥鍖栦竴涓猵ost璇锋眰
            request = new HttpPost(url);
            request.setHeader("Client-Agent", "zqsw_android_1.0/720*1280/public");
            request.setHeader("user-id", "210000166372655");
            request.setHeader("phone-number", "");
            request.setHeader("userType", "1");
            request.setHeader("APIVersion", "1.0.0");
            request.setHeader("Action", "authenticateByOtherWay");
            request.setHeader("Account-Type","1");
            request.setHeader("client-imsi","");
           // request.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
        } else if (httpRequest.getConnection().equalsIgnoreCase("get")) {
            logger.info("   [  get   ] " + url);
            request = new HttpGet(url);
        } else if (httpRequest.getConnection().equalsIgnoreCase("delete")) {
            logger.info("   [ delete ] " + url);
            request = new HttpDelete(url);
        } else if (httpRequest.getConnection().equalsIgnoreCase("put")) {
            logger.info("   [  put   ] " + url);
            request = new HttpPut(url);
        } else
            Assert.fail("connection donnot support :" + httpRequest.getConnection());
        
        // header builder锛堝鏋滆鍚戞帴鍙ｅ彂閫佽嚜宸辫缃殑鏍囧ご锛岄渶瑕佽繖涓�備竴鑸笉闇�瑕侊級
        List<Parameter> headers = httpRequest.getHeaders();
        if (headers != null) {
            for (Parameter p : headers) {
                logger.info("   [ Header ] " + String.format("%1$-20s :     %2$s", p.getName(), p.getValue()));
                request.addHeader(p.getName(), p.getValue().toString());
            }
        }
        
        // entity builder锛堝鏋滆鍚戞帴鍙ｅ彂閫佽嚜宸辫缃殑娑堟伅瀹炰綋锛岄渶瑕佽繖涓�備竴鑸笉闇�瑕侊級
        List<Entity> entities = httpRequest.getEntity();
        if (entities != null) {
            for (Entity e : entities) {
                StringEntity se = new StringEntity(e.getValue(), "utf-8");
                if (httpRequest.getConnection().equalsIgnoreCase("post")) {
                    HttpPost post = (HttpPost) request;
                    post.setEntity(se);
                } else if (httpRequest.getConnection().equalsIgnoreCase("put")) {
                    HttpPut put = (HttpPut) request;
                    put.setEntity(se);
                }
            }
        }
        
        //DefaultHttpClient 缁ф壙浜� HttpClient鎺ュ彛
        DefaultHttpClient httpClient = new DefaultHttpClient();
        //璁剧疆cookie
        if (cookie != null) {
            httpClient.setCookieStore(cookie);
        }
        
        //鎵ц璇锋眰锛屽苟杩斿洖鍝嶅簲
        HttpResponse response = httpClient.execute(request);
        
        
        String resString = "";
        //浠庡搷搴斾腑鑾峰彇娑堟伅瀹炰綋,涓�鑸殑web搴旂敤绫讳技浜庤繖鏍风殑html锛氣��<html><head></head><body>adfasfa</body></html>鈥�
        //鎺ュ彛鐨勮瘽涓�鑸氨鏄繑鍥炲�煎拰杩斿洖淇℃伅锛屾病鏈塰tml浠ｇ爜锛堢敱鎺ュ彛绔帶鍒讹級
        if (response.getEntity() != null)
            resString = EntityUtils.toString(response.getEntity(), "UTF-8");
        logger.info("   [resString] " + resString);
        
        // 褰撴病鏈夊彲杩斿洖鐨凧SONObject鏃讹紝榛樿鎵撳嵃鍑篐ttp鍝嶅簲鐮�
        if (resString.isEmpty()) {
            int code = response.getStatusLine().getStatusCode();
            String status0 ="{\"status\":"+String.valueOf(code)+"}";
            
            logger.info("INFO: Didn't get HTTP return entity, response code is: " + code);
//            return null;
            JSONObject responseJson = JSONObject.fromObject(status0);
            
            logger.info("   [Response-Empty] " + responseJson);
            return responseJson;
        } else {
            try {
            	//灏嗚繑鍥炵殑瀹炰綋淇℃伅灏佽鎴恓son瀵硅薄
                JSONObject responseJson = JSONObject.fromObject(resString);
                logger.info("   [Response] " + responseJson);
                return responseJson;
            } catch (JSONException e) {
                e.printStackTrace();
                logger.warn("INFO: Http response is NOT JSON format, it is " + resString);
//                return null;
                JSONObject responseJson = JSONObject.fromObject("{\"status\":\""+resString.substring(0, 3)+"\"}");
                logger.info("   [Response-nojson] " + responseJson);
                return responseJson;
            }

        }
    }
    
    
    /**
     * 涓婁紶鏂囦欢
     * @param url
     * @param file
     * @return
     */
    public static JSONObject  multipartPostData(String url,File file){
    	MultipartPostMethod post = new MultipartPostMethod(url);
    	logger.info("鍙戦�乸ost " + url);
    	HttpClient client = new HttpClient();
    	String result = null;
    	try {
    		post.addParameter("media", file);
    		client.executeMethod(post);
    		result = post.getResponseBodyAsString();
    		logger .info(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return JSONObject.fromObject(result);
    }


}
