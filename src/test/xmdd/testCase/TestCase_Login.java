package testCase;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Date;

import hkXmdd.*;

import com.xmdd.util.SignUtil;

/**
 * 历史已经登录成功的用户打开访问
 * @author billrub
 */
public class TestCase_Login {
//	String token = GetCertification.token();
	static Logger logger = Logger.getLogger(MyHttpRequest.class);

	@Test(dataProvider = "data")
	public void request(String phone,String androidVersion,String iosVersion,String promontionNO,String province,String city,String district,
                       String longitude,String latitude,String pageno,String sShopName,String shopsNO) throws Exception {
		

	
		
		/**--------------------------------------------------------------------
		 * 用户登陆过程测试
		 * --------------------------------------------------------------------**/
		System.out.print("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 二、 用户登陆过程测试 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
	    //获取用户获取token
		XmddConfig.phone=phone;
	    String token= Login.GetToken();	    
	    System.out.print("----------------------------------1、向服务器获取token："+token);	
	    XmddConfig.token =token;
/*	    XmddConfig xx = new XmddConfig();
	    xx.SetToken();	*/
	    
	    //获取用户验证码
	    JSONObject vcode= Login.GetVcode();	    
	    System.out.print("----------------------------------2、向服务器获取验证码："+vcode.toString());
	    
	    //用户登陆
	    JSONObject sLogin= Login.LoginByVcode();	    
	    System.out.print("----------------------------------3、验证码登陆结果："+sLogin.toString());	    
	    


	    
	   

	
	}
	
	 public String changeCharset(String str, String newCharset)
			   throws UnsupportedEncodingException {
		 if (str != null) {
			 //用默认字符编码解码字符串。
			 byte[] bs = str.getBytes();
			 //用新的字符编码生成字符串
			 return new String(bs, newCharset);
		}
			 return null;
	}
	
	@DataProvider
	public Object[][] data() throws NoSuchAlgorithmException, UnsupportedEncodingException {
		return new Object[][] {
//		未登陆用户打开客户端
		{"15858197676","2.2",//		android版本号预期值
			"2.2",//		ios版本号预期值
			"2",//		系统广告数量
			"浙江省","杭州市","滨江区",//		获取限行与天气必须的城市定位
			"120.180328","30.187704","1","大叔3号",//		根据定位获取商户里列表第N页，以及在商户列表中应该存在的商户名称
			"10",},//		商户列表中商户数量预期值		
		};
	}
	

}
