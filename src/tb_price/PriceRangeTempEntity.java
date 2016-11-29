package tb_price;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 * IntelliJ IDEA
 *
 * @author DzTangBin <br>
 */
public class PriceRangeTempEntity implements Serializable {
    @JsonIgnore
    private String shopId;
    @JsonIgnore
    private String catName1;
    @JsonIgnore
    private ArrayList<String> itemPriceList;
    //priceMax
    @JsonProperty
    private Double max;
    //priceMin
    @JsonProperty
    private Double min;
    // priceRangeResultArrayList
    @JsonProperty
    private List<PriceRangeResult> list;

    public List<PriceRangeResult> getList() {

        return list;
    }

    public void setList(ArrayList<PriceRangeResult> list) {

        this.list = list;
    }

    public String getShopId() {

        return shopId;
    }

    public void setShopId(String shopId) {

        this.shopId = shopId;
    }

    public String getCatName1() {

        return catName1;
    }

    public void setCatName1(String catName1) {

        this.catName1 = catName1;
    }

    public ArrayList<String> getItemPriceList() {

        return itemPriceList;
    }

    public void setItemPriceList(ArrayList<String> itemPriceList) {

        this.itemPriceList = itemPriceList;
    }

    public Double getMax() {

        return max;
    }

    public void setMax() {

        if (itemPriceList == null || itemPriceList.size() == 0) {
            max = 0.0;
        } else {
            max = arrayListMax(itemPriceList);
        }
    }

    public Double getMin() {

        return min;
    }

    public void setMin() {

        if (itemPriceList == null || itemPriceList.size() == 0) {
            min = 0.0;
        } else {
            min = arrayListMin(itemPriceList);
        }
    }

    private double arrayListMax(ArrayList<String> sampleList) {

        double maxNum = 0.0;
        int totalCount = sampleList.size();
        if (totalCount >= 1) {
            double max = Double.valueOf(sampleList.get(0));
            for (String aSampleList : sampleList) {
                double temp = Double.valueOf(aSampleList);
                if (temp > max) {
                    max = temp;
                }
            }
            maxNum = max;
        }
        return maxNum;
    }

    private double arrayListMin(ArrayList<String> sampleList) {

        double minNum = 0.0;
        int totalCount = sampleList.size();
        if (totalCount >= 1) {
            double min = Double.valueOf(sampleList.get(0));
            for (int i = 0; i < totalCount; i++) {
                double temp = Double.valueOf(sampleList.get(0));
                if (min > temp) {
                    min = temp;
                }
            }
            minNum = min;
        }
        return minNum;
    }

    public static class PriceRangeResult {
        public String getX() {

            return x;
        }

        public void setX(String x) {

            this.x = x;
        }

        public String getY() {

            return y;
        }

        public void setY(String y) {

            this.y = y;
        }

        // 价格范围
        @JsonProperty
        String x;
        // 商品数量
        @JsonProperty
        String y;

        PriceRangeResult() {

        }

        public PriceRangeResult(String x, String y) {

            final PriceRangeResult priceRangeResult = new PriceRangeResult();
            this.x = x;
            this.y = y;
        }
    }
}
