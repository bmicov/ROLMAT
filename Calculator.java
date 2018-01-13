import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Vector;


public class Calculator {
	private Vector<Product> productsToCalculate;
	Calculator()
	{
		productsToCalculate = new Vector<Product>();
	}
	
	public boolean addProduct(Product p)
	{
		return productsToCalculate.add(p);
	}
	public void exportCalculation()
	{
		 try
		 {
		     String filename= "reportFile.html";
		     FileWriter fw = new FileWriter(filename); //the true will append the new data
		     fw.write("<meta charset=utf-8>");
		     for(Product p : productsToCalculate)
		     	if(p.type==1)
		    	 p.print(fw);

		     fw.close();
		 }
		 catch(IOException ioe)
		 {
		     System.err.println("IOException: " + ioe.getMessage());
		 }
	}
	private void sortByType()
	{
		
		//gonna implement cointing sort with linkedlist 
		//i am going to make linked list for each type, because I am going to sort by type 
		int maxtype=0;
		for(Product p : productsToCalculate)
			if(p.type>maxtype)
				maxtype=p.type;
			Vector<LinkedList> llVector = new Vector<LinkedList>(maxtype);
			for(Product p : productsToCalculate)
			{
				llVector.get(p.type).add(p);// adding to list at position p.type
			}
			
			int iterateVector=0;
		for(LinkedList l : llVector)
		{
			int index=0;
			while((l.get(index))!=null)
			{
				productsToCalculate.insertElementAt((Product)l.get(index),iterateVector);
			}
		}
			
	}
}
