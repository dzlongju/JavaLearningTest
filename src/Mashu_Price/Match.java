package Mashu_Price;

import java.util.*;
/**
 * IntelliJ IDEA
 *
 * @author DzTangBin <br>
 */
public class Match {
    class MatchResult {
        public String catename;
        public Double cateprice;
        public List shoppriceresult;

        public MatchResult(String catename, Double cateprice) {
            this.catename = catename;
            this.cateprice = cateprice;
            this.shoppriceresult = new ArrayList();
        }
    }

    public List matching(String[] shopcatelist, Double[] pl, String[] catelist, Double[] priceslist) {
        //生成位置对应的平均价格数组
        Double avg_price = 0.001;
        Double[] avg_pricelist = new Double[shopcatelist.length];
        for (int i = 0; i < shopcatelist.length; i++) {
            for (int j = 0; j < catelist.length; j++) {
                if (shopcatelist[i].equals(catelist[j])) {
                    avg_price = priceslist[j];
                }
            }
            avg_pricelist[i] = avg_price;
        }
        //分类目
        //统计该商店有几个类目：kinds
        Set<String> kindsset = new HashSet<String>(Arrays.asList(shopcatelist));
        int kinds = kindsset.size();
        String[] kindayy = new String[kinds];
        List<String> kinday = new ArrayList<String>();
        //该店铺类目放入数组kindayy
        for (String k : kindsset) {
            kinday.add(k);
        }
        for (int i = 0; i < kinday.size(); i++) {
            kindayy[i] = kinday.get(i);
        }
        //将该店铺的价格按类目存放，放入list（matchresult)中，matchs中的每个元素为一个类目的价格列表（elments)，每个类目的价格列表中第一个元素是类目名称，第二个元素是类目均价,其他元素为类目下的价格
        List anaresult = new ArrayList();
        for (int i = 0; i < kinds; i++) {
            double d = 0.01;
            for (int j = 0; j < shopcatelist.length; j++) {
                if (kindayy[i].equals(shopcatelist[j])) {
                    d = avg_pricelist[j];
                }
            }
            Match m = new Match();
            MatchResult mr = m.new MatchResult(kindayy[i], d);
            for (int j = 0; j < pl.length; j++) {

                if (kindayy[i].equals(shopcatelist[j])) {

                    mr.shoppriceresult.add(pl[j]);
                }
            }
            anaresult.add(mr);
        }
        return anaresult;
    }
}