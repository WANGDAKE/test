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
 * ��ʷ�Ѿ���¼�ɹ����û��򿪷���
 * @author billrub
 */
public class TestCase_Login {
//	String token = GetCertification.token();
	static Logger logger = Logger.getLogger(MyHttpRequest.class);

	@Test(dataProvider = "data")
	public void request(String phone,String androidVersion,String iosVersion,String promontionNO,String province,String city,String district,
                       String longitude,String latitude,String pageno,String sShopName,String shopsNO) throws Exception {
		

	
		
		/**--------------------------------------------------------------------
		 * �û���½���̲���
		 * --------------------------------------------------------------------**/
		System.out.print("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ ���� �û���½���̲��� ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
	    //��ȡ�û���ȡtoken
		XmddConfig.phone=phone;
	    String token= Login.GetToken();	    
	    System.out.print("----------------------------------1�����������ȡtoken��"+token);	
	    XmddConfig.token =token;
/*	    XmddConfig xx = new XmddConfig();
	    xx.SetToken();	*/
	    
	    //��ȡ�û���֤��
	    JSONObject vcode= Login.GetVcode();	    
	    System.out.print("----------------------------------2�����������ȡ��֤�룺"+vcode.toString());
	    
	    //�û���½
	    JSONObject sLogin= Login.LoginByVcode();	    
	    System.out.print("----------------------------------3����֤���½�����"+sLogin.toString());	    
	    


	    
	   

	
	}
	
	 public String changeCharset(String str, String newCharset)
			   throws UnsupportedEncodingException {
		 if (str != null) {
			 //��Ĭ���ַ���������ַ�����
			 byte[] bs = str.getBytes();
			 //���µ��ַ����������ַ���
			 return new String(bs, newCharset);
		}
			 return null;
	}
	
	@DataProvider
	public Object[][] data() throws NoSuchAlgorithmException, UnsupportedEncodingException {
		return new Object[][] {
//		δ��½�û��򿪿ͻ���
		{"15858197676","2.2",//		android�汾��Ԥ��ֵ
			"2.2",//		ios�汾��Ԥ��ֵ
			"2",//		ϵͳ�������
			"�㽭ʡ","������","������",//		��ȡ��������������ĳ��ж�λ
			"120.180328","30.187704","1","����3��",//		���ݶ�λ��ȡ�̻����б��Nҳ���Լ����̻��б���Ӧ�ô��ڵ��̻�����
			"10",},//		�̻��б����̻�����Ԥ��ֵ		
		};
	}
	

}
