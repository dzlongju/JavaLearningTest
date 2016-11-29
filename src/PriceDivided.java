import java.util.*;

/**
 * Created by duozhun on 2016/10/18.
 */

public class PriceDivided extends Auctionlist {
	List<CateAndPrice> cp = new ArrayList<CateAndPrice>();
	Map<String, String> catemap = new HashMap<String, String>();

	public void Cartmap() {
		//生成一个类目名与类目平均价格的集合

/**
 * 读txt文件
 */
//		File file = new File("C:\\Users\\duozhun\\Desktop\\avg_price.txt");
//		System.out.println(txt2String(file));

		//直接创建字符串,生成类目价格表
		String str = "网店/网络服务/软件:2;包装:2.8;电动车/配件/交通工具:3.95;居家布艺:5.049609959;五金/工具:6.763636364;家庭/个人清洁工具:7.080151515;模玩/动漫/周边/cos/桌游:7.436;自行车/骑行装备/零配件:8.593333333;节庆用品/礼品:8.633448276;彩妆/香水/美妆工具:11.27222222;鲜花速递/花卉仿真/绿植园艺:12.5;厨房/烹饪用具:13.45928571;收纳整理:13.65580111;宠物/宠物食品及用品:13.83;家居饰品:15.68090909;饰品/流行首饰/时尚饰品新:15.78871279;零食/坚果/特产:17.36125;粮油米面/南北干货/调味品:18.13333333;餐饮具:19.1358209;玩具/童车/益智/积木/模型:19.68488372;居家日用:20.22032609;美发护发/假发:21.145;美容护肤/美体/精油:23.93878788;个性定制/设计服务/DIY:23.95;尿片/洗护/喂哺/推车床:34.49022727;洗护清洁剂/卫生巾/纸/香薰:38.2613198;女士内衣/男士内衣/家居服:41.34622567;手表:52.25736842;电子/电工:58.33;床上用品:74.178;童装/婴儿装/亲子装:76.46709267;女装/女士精品:81.12874182;服饰配件/皮带/帽子/围巾:81.54100433;ZIPPO/瑞士军刀/眼镜:93.6393578;孕妇装/孕产妇用品/营养:96.35045117;汽车/用品/配件/改装:109.1118182;运动/瑜伽/健身/球迷用品:109.2680038;童鞋/婴儿鞋/亲子鞋:154.2501149;运动包/户外包/配件:185.0927556;女鞋:189.1726093;男装:199.2539982;箱包皮具/热销女包/男包:204.9510895;咖啡/麦片/冲饮:226.3485356;运动服/休闲服装:287.3677014;流行男鞋:353.2020548;运动鞋new:452.52478;家装主材:622.171261;户外/登山/野营/旅行用品:627.0589622;珠宝/钻石/翡翠/黄金:899;null:65961.43;";

		for ( String s : str.trim().split(";") ) {
			String[] ss = s.trim().split(":");
			String cate = ss[ 0 ].trim();
			String price = ss[ 1 ].trim();
			catemap.put(cate, price);
		}

		//生成类目价格区间(两倍均值的四分位)
		for ( Map.Entry<String, String> e : catemap.entrySet() ) {

			double x = Double.parseDouble(e.getValue());
			//加减乘除运算需要注意/
			//设置参数
			double x4 = x * 2;
			double x1 = x4 / 4; double x2 = x1 * 2; double x3 = x1 * 3;
//			System.out.println(e.getKey());
//			System.out.println(e.getValue());
			CateAndPrice cap = new CateAndPrice(e.getKey(), Double.parseDouble(e.getValue()), x1, x2, x3, x4);
			cp.add(cap);


		}
		//遍历类目平均价格list
		for ( Object ojc : cp ) {
			CateAndPrice app = ( CateAndPrice ) ojc;
			System.out.println("类目名称:" + app.cart + "---" + "平均价格:" + app.price + "---价格划分1:" + app.price_x1
				+ "---价格划分2:" + app.price_x2 + "---价格划分3:" + app.price_x3 + "---价格划分4:" + app.price_x4);

		}


	}

	//分箱方法(店铺嵌套类目价格区间)
	public void lrr1() {

		Auctionlist lrr = new Auctionlist();
		lrr.atPut();
		double x=0,x1=0,x2=0,x3=0,x4=0;
		int y1 = 0, y2 = 0, y3 = 0, y4 = 0, y5 = 0;
		int jishu[] = { y1, y2, y3, y4, y5 };
		Set<Map.Entry<String, List<Product>>> entrySet = lrr.auctions.entrySet();
		for ( Map.Entry<String, List<Product>> entry : entrySet ) {
			System.out.println("店铺名:" + entry.getKey());
			for ( Object obj : entry.getValue() ) {

				Product ss = ( Product ) obj;
				System.out.println("商品属性:" + ss.toString());
				if ( catemap.get(ss.cate) != null ) {
				 x = Double.parseDouble(catemap.get(ss.cate));
					 x4 = x * 2;
					 x1 = x4 / 4;  x2 = x1 * 2;  x3 = x1 * 3;
					if ( 0 < ss.price && ss.price < x1 ) {
						y1++;
					} else if ( x1 < ss.price && ss.price < x2 ) {
						y2++;
					} else if ( x2 < ss.price && ss.price < x3 ) {
						y3++;
					} else if ( x3 < ss.price && ss.price < x4 ) {
						y4++;
					} else if ( x4 < ss.price ) {
						y5++;
					}
				}else System.out.println("该商品类目不在类目表里:"+ss.toString());

			}
			System.out.println("价格区间["+ 0+"--"+x1+"]:"+ y1 +"---"+ "价格区间["+x1+"--"+x2+"]:" + y2);
			System.out.println("价格区间["+x2+"--"+x3+"]:" + y3 +"---"+ "价格区间["+x3+"--"+x4+"]:"
				+ y4 +"---"+ "价格区间["+x4+"<"+"]:" + y5);
		}

	}


	public static void main(String[] args) {
		PriceDivided rd = new PriceDivided();

		rd.Cartmap();
		rd.lrr1();

	}

}

