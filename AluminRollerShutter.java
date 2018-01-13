
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
public class AluminRollerShutter extends Product{
	private double lamel;
	private double guide;
	private double cover;
	private double ax;
	private boolean motor;
	
	
	AluminRollerShutter(double width, double height ,boolean motor, String color)
	{
		this.type=1;
		this.width=width;
		this.height=height;
		this.motor=motor;
		this.color=color;
		number++;
		ID=number;
	}

 public void doCalculations()
 {
	 if(height >280 || width >300) {isGoodMeasurements=false; return;}
	 else isGoodMeasurements=true;

	 lamel=width-7.5;
	 if(height<=150)
		 guide=height-13.7;
	 else
	 if(height>150 && height<=230)
		 guide=height-16.5;
	 else
	 if(height>230 && height <=280)
		 guide=height-18;
	 
	 cover=width-1;
	 if(motor==true) ax=width-8;
	 else ax=width-7;
	 
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
	 
	 
	 fw.write("<hr>");
	 
	}catch(IOException e)
	{
		 System.err.println("IOException: " + e.getMessage());
	}



	 
 }


}
