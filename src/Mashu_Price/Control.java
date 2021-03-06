package Mashu_Price;

import java.util.List;
public class Control {

    //类目表信息
    String[] catelist = {"网店/网络服务/软件",
        "包装",
        "电动车/配件/交通工具",
        "居家布艺",
        "五金/工具",
        "家庭/个人清洁工具",
        "模玩/动漫/周边/cos/桌游",
        "自行车/骑行装备/零配件",
        "节庆用品/礼品",
        "彩妆/香水/美妆工具",
        "鲜花速递/花卉仿真/绿植园艺",
        "厨房/烹饪用具",
        "收纳整理",
        "宠物/宠物食品及用品",
        "家居饰品",
        "饰品/流行首饰/时尚饰品新",
        "零食/坚果/特产",
        "粮油米面/南北干货/调味品",
        "餐饮具",
        "玩具/童车/益智/积木/模型",
        "居家日用",
        "美发护发/假发",
        "美容护肤/美体/精油",
        "个性定制/设计服务/DIY",
        "尿片/洗护/喂哺/推车床",
        "洗护清洁剂/卫生巾/纸/香薰",
        "女士内衣/男士内衣/家居服",
        "手表",
        "电子/电工",
        "床上用品",
        "童装/婴儿装/亲子装",
        "女装/女士精品",
        "服饰配件/皮带/帽子/围巾",
        "ZIPPO/瑞士军刀/眼镜",
        "孕妇装/孕产妇用品/营养",
        "汽车/用品/配件/改装",
        "运动/瑜伽/健身/球迷用品",
        "童鞋/婴儿鞋/亲子鞋",
        "运动包/户外包/配件",
        "女鞋",
        "男装",
        "箱包皮具/热销女包/男包",
        "咖啡/麦片/冲饮",
        "运动服/休闲服装",
        "流行男鞋",
        "运动鞋new",
        "家装主材",
        "户外/登山/野营/旅行用品",
        "珠宝/钻石/翡翠/黄金"
    };
    Double[] priceslist = {2.0,
        2.8,
        3.95,
        5.049609959,
        6.763636364,
        7.080151515,
        7.436,
        8.593333333,
        8.633448276,
        11.27222222,
        12.5,
        13.45928571,
        13.65580111,
        13.83,
        15.68090909,
        15.78871279,
        17.36125,
        18.13333333,
        19.1358209,
        19.68488372,
        20.22032609,
        21.145,
        23.93878788,
        23.95,
        34.49022727,
        38.2613198,
        41.34622567,
        52.25736842,
        58.33,
        74.178,
        76.46709267,
        81.12874182,
        81.54100433,
        93.6393578,
        96.35045117,
        109.1118182,
        109.2680038,
        154.2501149,
        185.0927556,
        189.1726093,
        199.2539982,
        204.9510895,
        226.3485356,
        287.3677014,
        353.2020548,
        452.52478,
        622.171261,
        627.0589622,
        899.0
    };

    public static void main(String[] args) {

        //获取类目平均价格表
        Control cc = new Control();
        String[] catelist = cc.catelist;
        Double[] priceslist = cc.priceslist;
//        获取店铺类目下的价格表
        GoodsList gl=new GoodsList(100);
        String[] shopcatelist = gl.catename;
        Double[] pl = gl.goodprice;
        Match m = new Match();
        List matchs = m.matching(shopcatelist, pl, catelist, priceslist);
        //分箱的标准：分成四个区间，区间生成由类目平均价格和参数生成
        //参数设置
        Double[] parameter = {0.666667, 2.5, 5.0};
        //分类目分箱，打印结果，并把结果放入列表 anaresult中
        FengXiang fx = new FengXiang();
        List anaresult = fx.feng(matchs, parameter);
    }
}




