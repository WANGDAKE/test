package hkXmdd;
/**
 * С��������
 * @author Billrub
 */
public class XmddConfig {
//	public static String host ="10.2.30.218";	//����
	public static String host ="api.dev.xiaomadada.com";//����
	public static int port = 8282;	//����
	public static String path ="/paa/rest/api";
	public static int port8080 = 8080;
	public static String developHost = "api007.adt100.com";
	public static int developPort = 80;
	public static String Cookie = "acf_ticket=TGT-729-xphl7EakzdPwSBaSAhxe-";
	public static String account = "jinfeng@126.com";
	public static String passwd = "123456";
	
	public static String phone = "15757166396";
	public static String token = "";
	public static String skey = "81dc9bdb52";
	//public static String url ="http://api.dev.xiaomadada.com:8282/paa/rest/api";
    public static String url ="https://dev.xiaomadada.com/paa/rest/api";
	
	
	//�û���صĻ�����Ϣ
	public static String vcc = "6";//�û���ʹ���Ż�ȯ����
	public static String sex = "0";//�û��Ա�
	public static String birthday = "19890215";//�û�����
	public static String nickname = "�������ǳƣ�";//�û��ǳ�
	public static String freewashes = "0";//�û������ϴ������
	public static String avatar = "http://7xipxm.com1.z0.glb.clouddn.com/144801100714187d2292fa35f.png";//�û�ͷ���ַ
	public static String bankcredit = "0";//�û����п�����                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
	public static String favoriteShopno = "5";//�û��ղؼ����̻�����
	public static String favoriteShopname = "������ƽ�ϴ����";//�û��ղؼ�������1���̻�����
	public static String bankCardno = "0";//�û��󶨵����п�����
	public static String carno = "4";//�û��󶨵ĳ�������
	public static String licencenumber = "��M12345";//�û��󶨵ĳ����е�����1�����ƺ�
	public static String ak = "3823f6c12fce7520d1a53ff06a157c3c";//��ȡ�ٶ�����ʱ��AKֵ
	public static String key = "46490bba1b34bbcec8c4c1c0a89b2df5";//��ȡβ�����е�keyֵ
	public static String city = "hangzhou";//��ȡβ�ų���
	
	
	//����ѯ��
	//public static String count ="3";
	public static String lid="";//��ʷ��ʻ֤ͼƬid
	public static String driverpic="";//��ʻ֤ͼƬ��ַ
	public static String xunjiacid="";//ѯ�ۼ�¼id
	
	
	//���ͷ���
	public static String gid ="";//�Ϳ�id
	public static String tradeid ="";//�Ϳ���ֵ��ˮ��
	public static String cardid ="";//�������п�ID
	public static String orderid ="";//����֧��ʱ�Ķ���ID
	
	//�������
	public static String carbid ="";//����Ʒ��ID
	public static String carname ="";//����Ʒ��
	public static String carsid="";//������ϵid
	public static String carsname="";//������ϵ����
	public static String carmid="";//��������id
	public static String carmodel="";//������������
	public static String pid="";//ʡid
	public static String cid="";//��id
	public static String baoxianname ="";//���չ�˾����
	public static String carid ="";//����ID
	
	
	//�ҵ��Ż�ȯ
		public static String xc_count = "5";//�û�ϴ��ȯ������δʹ��+��ʧЧ��
		public static String xc_name = "test1��ϴ��ȯ";
		
		public static String bx_count = "1";//�û������Ż�ȯ������δʹ��+��ʧЧ��
		public static String bx_name = "��ͨ����ȯ100";
		
		public static String qt_count = "1";//�û������Ż�ȯ������δʹ��+��ʧЧ��
		public static String qt_name = "��ѻ�̥ȯ";
		
		public static String bankCouponName = "test����1��ϴ��ȯ";

	//ϴ��֧��
		public static String serverid=""; //���̵ķ���id
		public static String youhuiquancid="";//�Ż�ȯcid
		public static String zhifulicencenumber="";//֧��ʱ�ĳ��ƺ�
		public static String make="";//��������
		public static String model="";//������ϵ
		public static String washtradeid="";//ϴ����ˮ��
		public static String washorderid="";//ϴ������id
		public static String sensitiveword="";//�������д�
		
		
		//�˱�����
		public static String carpremiumid="";//�˱���¼id
		public static String tiananinscomp="";//�찲���չ�˾����
		public static String startdate="";//������
		public static String baoxianorderid="";//������
		
		//���ֳ���ֵ
		public static String mile="";//��ʻ���
		public static String modelid="";//����id
		public static String buydate="2015-03";//����ʱ��
		public static String scarid="";//����¼id
		public static String licenseno="";//���ƺ�
		public static String cityid="";//����id
		public static String evaluateids="";//������¼di
		public static String sellercityid="";//��������ID
		public static String channelengs="";//��������Ӣ������
		
	public void SetToken() throws Exception{
		this.token = Login.GetToken();
	}
	

	
	
}
