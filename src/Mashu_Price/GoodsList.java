package Mashu_Price;

/**
 * IntelliJ IDEA
 *
 * @author DzTangBin <br>
 */
public class GoodsList {
    public Double[] goodprice;
    public String[] catename;
    public GoodsList(int b){
        this.catename= new String[]{"饰品/流行首饰/时尚饰品新", "居家日用", "居家日用", "收纳整理", "饰品/流行首饰/时尚饰品新", "居家日用", "居家日用", "饰品/流行首饰/时尚饰品新", "居家日用", "居家日用", "收纳整理", "收纳整理", "收纳整理", "收纳整理", "收纳整理", "饰品/流行首饰/时尚饰品新"};
        //生成店铺的价格列表
            this.goodprice = new Double[16];
            for (int i = 0; i < goodprice.length; i++) {
                Double temp = (Double) (Math.random() * b + 1);
                goodprice[i] = temp;
            }//将产生的数添加到数组

        }
    }


