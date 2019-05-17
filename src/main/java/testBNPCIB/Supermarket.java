package main.java.testBNPCIB;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Supermarket {
	
	static double getCartAmount(Map<Product, Integer> cart) {
		double sum = 0.0;
		for(Map.Entry<Product, Integer> entry: cart.entrySet()) {
			Product p = entry.getKey();
			int quantity = entry.getValue();
			int qtyOffer = 0;
			double amountWithOffer = 0.0;
			double amountWithoutOffer = 0.0;
			if (p.getpOffer() != null) {
				// apply offer
				qtyOffer = p.getpOffer().getBuyNum()+p.getpOffer().getGetNum();
				amountWithOffer= p.getPrice()* p.getpOffer().getBuyNum() * (quantity/qtyOffer);
				amountWithoutOffer= p.getPrice()* (quantity%qtyOffer);
			}else
				amountWithoutOffer = p.getPrice()* quantity;
			
			sum+= amountWithOffer +amountWithoutOffer;
        }
		return sum;
	}
	
	public static void main(String[] args) {
		NumberFormat formatter = new DecimalFormat("#0.00");
		Map<Product, Integer> cart = new HashMap<Product, Integer>();
//		cart.put(new Product("Apple", 0.20, Offer.BUYONEGETONE), 4);
//		cart.put(new Product("Orange", 0.50), 3);
//		cart.put(new Product("Watermelon", 0.80, Offer.THREEPRICETWO), 5);
		cart.put(new Product("Apple", 2, Offer.THREEPRICETWO), 4); // 2*2*1+2*1
		cart.put(new Product("Orange", 3, Offer.THREEPRICETWO), 11); // 3*2*3+3*2
		cart.put(new Product("Watermelon", 5, Offer.BUYONEGETONE), 7); // 5*1*3 +5*1
		System.out.println(formatter.format(getCartAmount(cart)));
		
	}

}

class Product{
	private String name;
	private double price;
	Offer pOffer;
	
	public Product(String name, double price, Offer pOffer) {
		this.name = name;
		this.price = price;
		this.pOffer = pOffer;
	}
	
	public Product(String name, double price) {
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return price;
	}
	public Offer getpOffer() {
		return pOffer;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public void setpOffer(Offer pOffer) {
		this.pOffer = pOffer;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj instanceof Product) {
			Product po = (Product) obj;
			return Objects.equals(name,po.name)
				&& Objects.equals(price,po.price)
				&& Objects.equals(pOffer,po.pOffer);
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name, price, pOffer);
	}
}

enum Offer{
	BUYONEGETONE(1, 1),
	THREEPRICETWO(2, 1);
	private int buyNum;
	private int getNum;
	
	Offer(int buyNum, int getNum){
		this.buyNum = buyNum;
		this.getNum = getNum;
	}
	
	public int getBuyNum() {
		return buyNum;
	}
	public int getGetNum() {
		return getNum;
	}
}