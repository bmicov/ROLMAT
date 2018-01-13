import java.io.FileWriter;
import java.io.Writer;

abstract class Product {
	protected double width;
	protected double height;
	protected int type;// type is int for easier sorting
	protected boolean isGoodMeasurements;
	protected int ID;
	protected String color;
	static int number;
	public double calculateArea()
	{
		return width*height;
	}
	public abstract void doCalculations();
	public abstract void print(Writer fw);
	
	protected String getType()
	{
		switch(type)
		{
		case 1: return "АРЩ";
		case 2: return "ВГР";
		case 3: return "РОЛКОМ";
		case 4: return "H55";
		default: return "АРЩ";
		}
	}
	protected int getID()
	{
		return ID;
	}
	
}
