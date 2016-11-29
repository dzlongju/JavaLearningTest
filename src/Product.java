/**
 * Created by duozhun on 2016/10/18.
 */
public class Product {
	public String name;
	public Double price;
	public String cate;
	public Product(String name ,Double price,String cate){
		this.name=name;
		this.price=price;
		this.cate =cate;
	}
	@Override
	public String toString() {
		return "{商品名: "  + name +
			",价格:" + price+",类目:" +cate+
			'}';
	}


}
