package tb_price;

import com.google.common.collect.Lists;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.*;
/**
 * IntelliJ IDEA
 *
 * @author DzTangBin <br>
 */
public class PriceRange implements Serializable {
    private static HashMap<String, Double> catAvgPriceMap;
    private static String defaultCatNameKey = "DEFAULT";
    private static HashMap<String, List<Integer>> catPriceBlock = new HashMap<>();
    //设置分位数
    private static Double quantile = 0.5;
    //设置区间数 : 必须大于2
    private static Short blockNum = 5;

    //List(0.0,50.0,100.0,150.0,200.0)
    private static List<Integer> initRange(Double catAvgPrice) {

        final List<Integer> priceBlocks = Lists.newArrayList();
        // 小于5的情况  直接取 0 1 2 3 4 
        if (catAvgPrice < blockNum) {
            for (int i = 0; i < blockNum; i++) {
                priceBlocks.add(i);
            }
        } else {
            for (int i = 0; i < blockNum; i++) {
                final double blockDouble = i * catAvgPrice * quantile;
                int blockInteger = Integer.parseInt(new DecimalFormat("0").format(blockDouble));
                if (blockDouble > 10) {
                    // (41/10 + 1) * 10
                    blockInteger = (blockInteger / 10 + 1) * 10;
                }
                priceBlocks.add(blockInteger);
            }
        }

        return priceBlocks;
    }

    static {
        // 初始化 行业 平均价格
        catAvgPriceMap = new HashMap<String, Double>() {
            {
                put("网店/网络服务/软件", 2.0);
                put("包装", 2.8);
                put("电动车/配件/交通工具", 3.95);
                put("居家布艺", 5.049609959);
                put("五金/工具", 6.763636364);
                put("家庭/个人清洁工具", 7.080151515);
                put("模玩/动漫/周边/cos/桌游", 7.436);
                put("自行车/骑行装备/零配件", 8.593333333);
                put("节庆用品/礼品", 8.633448276);
                put("彩妆/香水/美妆工具", 11.27222222);
                put("鲜花速递/花卉仿真/绿植园艺", 12.5);
                put("厨房/烹饪用具", 13.45928571);
                put("收纳整理", 13.65580111);
                put("宠物/宠物食品及用品", 13.83);
                put("家居饰品", 15.68090909);
                put("饰品/流行首饰/时尚饰品新", 15.78871279);
                put("零食/坚果/特产", 17.36125);
                put("粮油米面/南北干货/调味品", 18.13333333);
                put("餐饮具", 19.1358209);
                put("玩具/童车/益智/积木/模型", 19.68488372);
                put("居家日用", 20.22032609);
                put("美发护发/假发", 21.145);
                put("美容护肤/美体/精油", 23.93878788);
                put("个性定制/设计服务/DIY", 23.95);
                put("尿片/洗护/喂哺/推车床", 34.49022727);
                put("洗护清洁剂/卫生巾/纸/香薰", 38.2613198);
                put("女士内衣/男士内衣/家居服", 41.34622567);
                put("手表", 52.25736842);
                put("电子/电工", 58.33);
                put("床上用品", 74.178);
                put("童装/婴儿装/亲子装", 76.46709267);
                put("女装/女士精品", 81.12874182);
                put("服饰配件/皮带/帽子/围巾", 81.54100433);
                put("ZIPPO/瑞士军刀/眼镜", 93.6393578);
                put("孕妇装/孕产妇用品/营养", 96.35045117);
                put("汽车/用品/配件/改装", 109.1118182);
                put("运动/瑜伽/健身/球迷用品", 109.2680038);
                put("童鞋/婴儿鞋/亲子鞋", 154.2501149);
                put("运动包/户外包/配件", 185.0927556);
                put("女鞋", 189.1726093);
                put("男装", 199.2539982);
                put("箱包皮具/热销女包/男包", 204.9510895);
                put("咖啡/麦片/冲饮", 226.3485356);
                put("运动服/休闲服装", 287.3677014);
                put("流行男鞋", 353.2020548);
                put("运动鞋new", 452.52478);
                put("家装主材", 622.171261);
                put("户外/登山/野营/旅行用品", 627.0589622);
                put("珠宝/钻石/翡翠/黄金", 899.0);
                // 未找到类目时,设置默认值

                put(defaultCatNameKey, 60.0);
            }
        };
        //通过类目平均价格 及 分位数 直接获得 类目及对应的间距范围
        catAvgPriceMap.forEach((k, v) -> catPriceBlock.put(k, initRange(v)));
    }

    public static List<PriceRangeTempEntity.PriceRangeResult> getPriceRange(String catName1, List<String> itemPriceList) {

        final ArrayList<PriceRangeTempEntity.PriceRangeResult> resultList = new ArrayList<>();

        //如果未找到类目则取默认值60
        catName1 = catAvgPriceMap.containsKey(catName1) ? catName1 : defaultCatNameKey;

        final Map<String, String> formattedResult = formatMapInt2String(calcPriceRange(catName1, itemPriceList), catPriceBlock.get(catName1));

        formattedResult.forEach((x, y) -> resultList.add(new PriceRangeTempEntity.PriceRangeResult(x, y)));

        return resultList;
    }

    // 假设类目平均价格是 100.0

    // Map<(0,0),(0,0),(0,0),(0,0),(0,0)>
    private static LinkedHashMap<Integer, Integer> initMap() {

        final LinkedHashMap<Integer, Integer> initMap = new LinkedHashMap<>();
        for (int i = 0; i < blockNum + 1; i++) {
            initMap.put(i, 0);
        }
        return initMap;
    }

    // 第几区间有几个
    // Map<(0,2),(1,3),(2,12),(3,22),(4,4)>
    private static LinkedHashMap<Integer, Integer> calcPriceRange(String catName1, List<String> itemPriceList) {

        LinkedHashMap<Integer, Integer> priceBlockNum = initMap();

        final List<Integer> priceRangeBlock = catPriceBlock.get(catName1);

        itemPriceList.stream().sorted().forEach(it -> {
            final Double price = Double.valueOf(it);

            //区间索引编号
            for (int blockIndex = 0; blockIndex < blockNum - 1; blockIndex++) {
                if (blockIndex != priceRangeBlock.size() - 1) {
                    if (price >= priceRangeBlock.get(blockIndex) && price < priceRangeBlock.get(blockIndex + 1)) {
                        priceBlockNum.put(blockIndex, priceBlockNum.get(blockIndex) + 1);
                        break;
                    }
                }
            }
        });
        return priceBlockNum;
    }

    // Map<(("0-40","2"),("40-80","3"),("80-120","12"),  .....  > 
    private static LinkedHashMap<String, String> formatMapInt2String(LinkedHashMap<Integer, Integer> originMap, List<Integer> priceRangeBlock) {
        // 分隔符      0 到 40 
        final String sep = "-";

        final LinkedHashMap<String, String> formattedMap = new LinkedHashMap<>();

        for (int blockIndex = 0; blockIndex < priceRangeBlock.size(); blockIndex++) {
            final String left = priceRangeBlock.get(blockIndex).toString();
            StringBuilder keyStr = new StringBuilder();
            keyStr.append(left).append(sep);
            if (blockIndex != priceRangeBlock.size() - 1) {

                final String right = priceRangeBlock.get(blockIndex + 1).toString();

                keyStr.append(right);
            }

            formattedMap.put(keyStr.toString(), originMap.get(blockIndex).toString());
        }

        return formattedMap;
    }
}
