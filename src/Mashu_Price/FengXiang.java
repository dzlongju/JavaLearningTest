package Mashu_Price;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * IntelliJ IDEA
 *
 * @author DzTangBin <br>
 */
public class FengXiang {
    class FengXiangreult {
        public String catename;
        public List pricenum;

        public  FengXiangreult(String catename) {
            this.catename = catename;
            this.pricenum=new ArrayList();
        }
    }

    public List feng(List<Match.MatchResult> matchs, Double[] parameter) {
        List anaresult = new ArrayList();
        for (Match.MatchResult mr: matchs){
            //将每个类目的信息分开为 cate:类目名称， box1:类目平均价格，shop_cate_pricelist为该店铺该类目下的价格数组
            List elemnts = mr.shoppriceresult;
            double box1 = mr.cateprice;
            String cate = mr.catename;
            System.out.println("类目为：" + cate);
            Double[] shop_cate_pricelist = new Double[elemnts.size()];
            for (int i = 0; i < elemnts.size(); i++) {
                shop_cate_pricelist[i] = (Double) elemnts.get(i);
            }
            //获取分箱标准
            Double[] boxes = new Double[parameter.length];
            for (int i = 0; i < parameter.length; i++) {
                boxes[i] = parameter[i] * box1;
            }
            Arrays.sort(shop_cate_pricelist);
            //初始化位置
            int[] num = new int[parameter.length + 1];
            for (int i = 0; i < num.length; i++) {
                num[i] = shop_cate_pricelist.length;
            }

            //显示分箱标准
            for (int i = 0; i < parameter.length; i++) {
                System.out.println("box2:" + boxes[i]);
            }

            //显示价格列表
            for (double pi : shop_cate_pricelist) {
                System.out.println(pi);
            }
            //分箱过程
            for (int j = boxes.length - 1; j > -1; j--) {
                for (int i = 0; i < shop_cate_pricelist.length; i++) {
                    if (boxes[j] < shop_cate_pricelist[i]) {
                        num[j] = i;
                        break;
                    }
                }
            }
            int[] result = new int[boxes.length + 1];

            result[0] = num[0];
            for (int i = boxes.length - 1; i > -1; i--) {

                result[i + 1] = num[i + 1] - num[i];
            }
            //显示结果,并把结果保存在列表anaresult中
            FengXiang fx = new FengXiang();
            FengXiangreult fxr = fx.new FengXiangreult(cate);
            for (int n = 0; n < result.length; n++) {
                System.out.println("第" + (n + 1) + "区间有" + result[n] + "个");
            }

            for (int c = 0; c < result.length; c++) {
                fxr.pricenum.add(result[c]);
            }
            anaresult.add(fxr);
        }

        return anaresult;
    }
}
