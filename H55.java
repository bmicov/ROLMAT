import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
public class H55 extends Product{
	private double lamel;
	private double guide;
	private double cover;
	private double ax;
	
	
	H55(double width, double height, String color)
	{
		this.type=4;
		this.width=width;
		this.height=height;
		this.color=color;
		number++;
		ID=number;
	}
	public void doCalculations()
	{
		lamel=width-9.5;
		guide=height-25;
		cover=width-1;
		ax=width-13;
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
			fw.write("Лам: <b>");
			 fw.write(Double.toString(lamel));
			 fw.write("</b> | ");
			
			 
			 fw.write("Вод: <b>");
			 fw.write(Double.toString(guide));
			 fw.write("</b> | ");
			 fw.write("Кап: <b>");
			

			 fw.write(Double.toString(cover));
			 fw.write("</b> | ");
			 fw.write("ОС: <b>");
			 fw.write(Double.toString(ax));
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

