package hkXmdd;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.testng.Assert;

import hkXmdd.WebClientDevWrapper;

public class HttpJson {
	// log4j中的对象，用于输出信息和记录Log
	static Logger logger = Logger.getLogger(HttpJson.class);

	public static JSONObject search(String path, String url, String reqData) throws Exception {

		HttpClient client = new DefaultHttpClient();

		// 将client 转换
		client = WebClientDevWrapper.wrapClient(client);

		HttpUriRequest request = null;
		if (path.equalsIgnoreCase("post")) {
			request = new HttpPost(url);
		} else if (path.equalsIgnoreCase("get")) {
			request = new HttpGet(url);
		} else if (path.equalsIgnoreCase("delete")) {
			request = new HttpDelete(url);
		} else if (path.equalsIgnoreCase("put")) {
			request = new HttpPut(url);
		} else
			Assert.fail("connection donnot support :" + path);
		StringEntity s = new StringEntity(reqData, "utf-8");
		s.setContentEncoding("UTF-8");
		s.setContentType("application/json");
		((HttpPost) request).setEntity(s);
		System.out.print("\n");
		logger.info("[request] " + request);
		HttpResponse response = client.execute(request);
		String resString = "";
		if (response.getEntity() != null)
			resString = EntityUtils.toString(response.getEntity(), "UTF-8");
		if (resString.isEmpty()) {
			int code = response.getStatusLine().getStatusCode();
			logger.info("INFO: Didn't get HTTP return entity, response code is: " + code);
			return null;
		} else {
			try {
				JSONObject responseJson = JSONObject.fromObject(resString);
				logger.info("[Response] " + responseJson);
				return responseJson;
			} catch (JSONException e) {
				e.printStackTrace();
				logger.warn("INFO: Http response is NOT JSON format, it is " + resString);
				return null;
			}

		}
	}

}
