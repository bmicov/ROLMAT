import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.FileWriter;
import java.io.IOException;


public class Purchase {
	
	private Vector<Product> purchaseProducts;
	private String client;
	private double price;
	private Date date;
	private Date finishedUntil;
	private Calendar cal;
	
	Purchase(String client, double price){
		this.client=client;
		this.price=price;
		purchaseProducts=new Vector<Product>();
		//date stuffs
		this.cal=Calendar.getInstance();
		cal.setTimeZone(TimeZone.getTimeZone("GMT"));
		this.date=cal.getTime();
		cal.add(Calendar.DATE, 7);
		this.finishedUntil=cal.getTime();
		cal.add(Calendar.DATE, -7);
	}
	void addProduct(Product p){
		purchaseProducts.add(p);
	}
	void exportPurchase()
	{
		try{
		FileWriter filew = new FileWriter("PurchaseHistory.html",true);
		
		filew.write(date.toString());
		filew.write(client);
		filew.write(Double.toString(price));
		filew.write(finishedUntil.toString());
		for(Product p : purchaseProducts)
		{
			p.print(filew);
		}
		filew.close();
		}catch(IOException e){
			System.err.println("IOException: " + e.getMessage());
		}
		
	}
}
