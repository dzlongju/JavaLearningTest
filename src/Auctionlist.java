import java.util.*;

/**
 * Created by duozhun on 2016/10/18.
 */
public class Auctionlist {
	//用来承装商品列表(包括店铺,商品名,商品价格)


	public List<Product> list = new ArrayList<>();

	public Map<String,List<Product>> auctions ;
//初始化auctions属性
	public Auctionlist(){
		this.auctions = new HashMap<String,List<Product>>();
	}
	public void atPut(){
		String [] pds_name = {"柚子美衣","沐乃衣","森宿"};
		String [] st= {"毛衣1","毛衣2","毛衣3","毛衣4","连衣裙1","针织衫1","衬衫1","牛仔裤1","牛仔裤2","连衣裙2","夹克2","短裙1","T恤1"};
		for ( int j = 0 ; j<pds_name.length;j++ ){
	for ( int i = 0 ; i<st.length;i++ ){
		Product pts = new Product(st[i],(double)(1+Math.random()*(100-1+1)),"女装/女士精品");
		list.add(pts);

	}
	auctions.put(pds_name[j],list);
}
	}


	public void testEntrySet(){
		//通过entrySet方法,返回Map中的所有键值对
		Set<Map.Entry<String ,List<Product>>> entrySet = auctions.entrySet();
		for ( Map.Entry<String,List<Product>>entry:entrySet ){
			System.out.println("店铺名:"+entry.getKey());
			for ( Object obj : entry.getValue() ){
         Product ss = (Product) obj;
			System.out.println("商品属性:"+ss.toString());}
		}
	}

	public static void main(String[] args) {
		Auctionlist lrr = new Auctionlist();
		lrr.atPut();
		lrr.testEntrySet();
	}
}
