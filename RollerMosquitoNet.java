import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
public class RollerMosquitoNet extends Product{
	private double cover;
	private double guide;
	private double bottomStick;
	private double net;
	private boolean lightOpen;
	
	RollerMosquitoNet(double width, double height, String color, boolean lightOpen)
	{
		type=3;
		this.width=width;
		this.height=height;
		this.color=color;
		this.lightOpen=lightOpen;
		number++;
		ID=number;
	}
	public void doCalculations()
	{
		if(lightOpen)
		{
			guide=height;
			cover=width+5.8;
			bottomStick=width;
			net=width+3.3;
		}
		else
		{
			guide=height-4.1;
			cover=width-0.6;
			bottomStick=width-6.5;
			net=width-3.3;
		}
	}
	public void print(Writer fw)
	{
		try{
				
			 fw.write(" | ");
			 fw.write(Integer.toString(ID));
			 fw.write(" | ");

			 fw.write("Ш: <b>");
			 fw.write(Double.toString(width));
			 fw.write("</b> | ");
			 fw.write("В: <b>");
			 fw.write(Double.toString(height));
			 fw.write("</b> | ");
			fw.write("Мрежа: <b>");
			 fw.write(Double.toString(net));
			 fw.write("</b> | ");
			
			 
			 fw.write("Вод: <b>");
			 fw.write(Double.toString(guide));
			 fw.write("</b> | ");
			 fw.write("Кап: <b>");
			

			 fw.write(Double.toString(cover));
			 fw.write("</b> | ");
			 fw.write("Долна гр.: <b>");
			 fw.write(Double.toString(bottomStick));
			 fw.write("</b> | ");
			 
			 fw.write("Цвят: <b>");
			 fw.write(color);
			 fw.write("</b>");
			 fw.write(" | ");
			  
			
			
			 
			 fw.write("<hr>");
			 
			}catch(IOException e)
			{
				 System.err.println("IOException: " + e.getMessage());
			}
	}
	
}
