import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class IntegratedRollerShutter extends Product {
	private double lamel;
	private double guide;
	private	double cover;
	private double ax;
	private boolean motor;
	private boolean lightOpen;
	
	IntegratedRollerShutter(double width, double height ,boolean motor, String color, boolean lightOpen)
	{
		type=2;
		this.width=width;
		this.height=height;
		this.motor=motor;
		this.color=color;
		this.lightOpen=lightOpen;
		number++;
		ID=number;
	}
	public void doCalculations()
	{
		
		if(width>300 || height>300) {isGoodMeasurements=false; return;}
		else isGoodMeasurements=true;
		lamel=width-9;
		if(lightOpen==false) guide=height-21;
		else guide=height;
		cover=width-2;
		if(motor=true) ax=width-10;
		else ax=width-8.5;
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
			  
			 if(motor)fw.write("<b>МОТОР</b>");
			  fw.write(" | ");

			 if(lightOpen) fw.write("<b>СВЕТ. ОТВОР</b>");
			 fw.write("<hr>");
			 
			}catch(IOException e)
			{
				 System.err.println("IOException: " + e.getMessage());
			}



			 
		 }

	}

