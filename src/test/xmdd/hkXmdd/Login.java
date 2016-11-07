package hkXmdd;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import com.xmdd.util.SignUtil;

/**
 * @author billrub
 */
public class Login {
    
	public static Logger logger = Logger.getLogger(Login.class);
	 /**Title：用户获取token
	   * @throws Exception
	   */
	public static String GetToken() throws Exception {
		JSONObject res = new JSONObject();
		
		try {
			String reqData = "{\"id\":6,\"params\":{\"phone\":\""+XmddConfig.phone+"\"}}";	
//			JSONObject jsonReq = JSONObject.fromObject(reqData);
//			String signUtil = SignUtil.generateSign(jsonReq,XmddConfig.token,XmddConfig.skey);	
			res = HttpJson.search("post", XmddConfig.url+"/token/get", reqData);  
			
			return res.getString("token");
			
		}catch (Exception ex) {
			ex.printStackTrace();
			return res.getString("token");
        }
		
	}
	
	 /**Title：用户获取验证码
	   * @throws Exception
	   */
	public static JSONObject GetVcode() throws Exception {
		
		JSONObject res = new JSONObject();		
		String reqData = "{\"id\":6,\"params\":{\"phone\":\""+XmddConfig.phone+"\",\"token\":\""+XmddConfig.token+"\",\"type\":\"3\"}}";
		try{
			res = HttpJson.search("post", XmddConfig.url+"/vcode/get", reqData);  
		    return res;
		}catch (Exception ex) {
			ex.printStackTrace();
			return res;
        }	    
	}	
	
	 /**Title：用户验证码登陆
	   * @throws Exception
	   */
	public static JSONObject LoginByVcode() throws Exception {
		
		JSONObject res = new JSONObject();			
		String reqData = "{\"id\":9,\"params\":{" +
				"\"devicemodel\":\"samsung SM-N9109W\",\"version\":\"2.0.1\",\"deviceid\":\"d97a0ea257e97d37\"}}";
	    try{
	    	JSONObject jsonReq = JSONObject.fromObject(reqData);
			String signUtil = SignUtil.generateSign(jsonReq,XmddConfig.token,XmddConfig.skey);	
		    res = HttpJson.search("post", XmddConfig.url+"/auth/by-vcode", signUtil);  
		    return res;
	    }catch (Exception ex) {
			ex.printStackTrace();
			return res;
        }			
	}
  }
