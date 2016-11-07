package hkXmdd;
/**
 * 小马达达配置
 * @author Billrub
 */
public class XmddConfig {
//	public static String host ="10.2.30.218";	//测试
	public static String host ="api.dev.xiaomadada.com";//外网
	public static int port = 8282;	//测试
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
	
	
	//用户相关的基本信息
	public static String vcc = "6";//用户可使用优惠券数量
	public static String sex = "0";//用户性别
	public static String birthday = "19890215";//用户生日
	public static String nickname = "请输入昵称！";//用户昵称
	public static String freewashes = "0";//用户可免费洗车数量
	public static String avatar = "http://7xipxm.com1.z0.glb.clouddn.com/144801100714187d2292fa35f.png";//用户头像地址
	public static String bankcredit = "0";//用户银行卡积分                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
	public static String favoriteShopno = "5";//用户收藏夹中商户数量
	public static String favoriteShopname = "张老五黄金洗车行";//用户收藏夹中其中1个商户名称
	public static String bankCardno = "0";//用户绑定的银行卡数量
	public static String carno = "4";//用户绑定的车辆数量
	public static String licencenumber = "云M12345";//用户绑定的车辆中的其中1辆车牌号
	public static String ak = "3823f6c12fce7520d1a53ff06a157c3c";//获取百度天气时的AK值
	public static String key = "46490bba1b34bbcec8c4c1c0a89b2df5";//获取尾号限行的key值
	public static String city = "hangzhou";//获取尾号城市
	
	
	//保险询价
	//public static String count ="3";
	public static String lid="";//历史行驶证图片id
	public static String driverpic="";//行驶证图片地址
	public static String xunjiacid="";//询价记录id
	
	
	//加油服务
	public static String gid ="";//油卡id
	public static String tradeid ="";//油卡充值流水号
	public static String cardid ="";//浙商银行卡ID
	public static String orderid ="";//浙商支付时的订单ID
	
	//爱车添加
	public static String carbid ="";//汽车品牌ID
	public static String carname ="";//汽车品牌
	public static String carsid="";//汽车车系id
	public static String carsname="";//汽车车系名称
	public static String carmid="";//汽车车型id
	public static String carmodel="";//汽车车型名称
	public static String pid="";//省id
	public static String cid="";//市id
	public static String baoxianname ="";//保险公司名称
	public static String carid ="";//车辆ID
	
	
	//我的优惠券
		public static String xc_count = "5";//用户洗车券数量（未使用+已失效）
		public static String xc_name = "test1分洗车券";
		
		public static String bx_count = "1";//用户保险优惠券数量（未使用+已失效）
		public static String bx_name = "普通代金券100";
		
		public static String qt_count = "1";//用户其他优惠券数量（未使用+已失效）
		public static String qt_name = "免费换胎券";
		
		public static String bankCouponName = "test浙商1分洗车券";

	//洗车支付
		public static String serverid=""; //店铺的服务id
		public static String youhuiquancid="";//优惠券cid
		public static String zhifulicencenumber="";//支付时的车牌号
		public static String make="";//汽车车型
		public static String model="";//汽车车系
		public static String washtradeid="";//洗车流水号
		public static String washorderid="";//洗车订单id
		public static String sensitiveword="";//评论敏感词
		
		
		//核保购险
		public static String carpremiumid="";//核保记录id
		public static String tiananinscomp="";//天安保险公司代码
		public static String startdate="";//起保日期
		public static String baoxianorderid="";//起保日期
		
		//二手车估值
		public static String mile="";//行驶里程
		public static String modelid="";//车型id
		public static String buydate="2015-03";//购车时间
		public static String scarid="";//车记录id
		public static String licenseno="";//车牌号
		public static String cityid="";//城市id
		public static String evaluateids="";//估车记录di
		public static String sellercityid="";//帮卖城市ID
		public static String channelengs="";//卖车渠道英文名称
		
	public void SetToken() throws Exception{
		this.token = Login.GetToken();
	}
	

	
	
}
