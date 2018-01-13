import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import java.io.Writer;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Vector;



import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.custom.TableTree;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.TableColumn;

public class Rolmatform {

	
	
	protected Shell shell;
	private Text text;
	private Text text_1;
	private Table table;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Rolmatform window = new Rolmatform();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) 
				display.sleep();
			
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		Vector<Product> products=new Vector<Product>();

		shell = new Shell();
		shell.setSize(486, 449);
		shell.setText("SWT Application");
		//checkboxes
		//motor checkbox
		Button button = new Button(shell, SWT.CHECK);
		button.setBounds(363, 38, 93, 16);
		button.setText("\u0421\u0412\u0415\u0422. \u041E\u0422\u0412\u041E\u0420");
		//lightOpen checkbox
		Button button_1 = new Button(shell, SWT.CHECK);
		button_1.setBounds(363, 11, 93, 16);
		button_1.setText("\u041C\u041E\u0422\u041E\u0420");
		
		
		Table table = new Table(shell,SWT.MULTI| SWT.BORDER | SWT.FULL_SELECTION);
		table.setHeaderVisible(true);
		table.setBounds(10, 110, 446, 250);
		table.setLinesVisible(true);
		String [] columns = {"НОМЕР", "МОДЕЛ" , "ШИРОЧИНА", "ВИСОЧИНА" , "ЦВЯТ"};
		for(int i = 0; i<=4; i++)
		{
			TableColumn tc=new TableColumn(table, SWT.NONE);
			tc.setText(columns[i]);
			tc.setWidth(90);
			
		}
	
		
		
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(75, 11, 90, 21);
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(75, 38, 90, 21);
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(10, 14, 55, 15);
		lblNewLabel.setText("\u0428\u0438\u0440\u0438\u043D\u0430:");
		
		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setBounds(10, 41, 55, 15);
		lblNewLabel_1.setText("\u0412\u0438\u0441\u043E\u0447\u0438\u043D\u0430:");
		
		Button buttonA = new Button(shell, SWT.RADIO);
		buttonA.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				button.setVisible(false);
				button_1.setVisible(true);
			}
		});
		
		Button buttonC = new Button(shell, SWT.RADIO);
		buttonC.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				button.setVisible(true);
				button_1.setVisible(true);
			}
		});
		buttonC.setBounds(176, 38, 90, 16);
		buttonC.setText("\u0412\u0413\u0420\u0410\u0414\u0415\u041D\u0410");
		
		Button buttonB = new Button(shell, SWT.RADIO);
		buttonB.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				button_1.setVisible(false);
				button.setVisible(true);
			}
		});
		buttonB.setBounds(272, 11, 90, 16);
		buttonB.setText("\u0420\u041E\u041B.\u041A\u041E\u041C");
		
		Button buttonD = new Button(shell, SWT.RADIO);
		buttonD.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				button.setVisible(false);
				button_1.setVisible(false);
			}
		});
		buttonD.setBounds(272, 38, 90, 16);
		buttonD.setText("H55");
		
		Combo combo = new Combo(shell, SWT.NONE);
		combo.setItems(new String[] {"\u0411\u042F\u041B", "\u0421\u0418\u0412", "\u0410\u041D\u0422\u0420\u0410\u0426\u0418\u0422", "\u0417\u041B.\u0414\u042A\u0411", "\u041C\u0410\u0425\u0410\u0413\u041E\u041D", "\u041E\u0420\u0415\u0425", "\u0434\u0440\u0443\u0433"});
		combo.setBounds(75, 70, 91, 23);
		
		Label label = new Label(shell, SWT.NONE);
		label.setBounds(10, 78, 55, 15);
		label.setText("\u0426\u0432\u044F\u0442:");
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try
				 {
				     String filename= "reportFile.html";
				     Writer fw = new OutputStreamWriter(new FileOutputStream(filename), StandardCharsets.UTF_8); //the true will append the new data
				     fw.write("<meta charset=UTF-8/>");
				     for(Product p : products)
				     {
				    	 p.doCalculations();
				    	 p.print(fw);
				    	
				     }
				     fw.close();
				 }
				 catch(IOException ioe)
				 {
				     System.err.println("IOException: " + ioe.getMessage());
				 }
			}
		});
		btnNewButton.setBounds(10, 375, 446, 25);
		btnNewButton.setText("\u0418\u0417\u0427\u0418\u0421\u041B\u0418");
		
		
		
		
		
		
		
		buttonA.setBounds(176, 11, 90, 16);
		buttonA.setText("\u0410\u041B.\u0420\u041E\u041B");
		
		Button addButton = new Button(shell, SWT.NONE);
		addButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				
				
				
				String color=combo.getText();
				if(color!="" && text.getText()!="" && text_1.getText()!="")
				{
					
				double width = Double.parseDouble(text.getText());
				double height=Double.parseDouble(text_1.getText());
				
				if(buttonA.getSelection()) 
					products.add(new AluminRollerShutter(width,height,button_1.getSelection(), color ));
			
				if(buttonB.getSelection())
					products.add(new RollerMosquitoNet(width,height, color,button.getSelection() ));
			
				if(buttonC.getSelection())
					products.add(new IntegratedRollerShutter(width,height, button_1.getSelection(), color, button.getSelection() ));
			
				if(buttonD.getSelection())
					products.add(new H55(width, height, color)) ;
				
				TableItem ti = new TableItem(table, SWT.NONE);
				
				ti.setText(0,Integer.toString(products.lastElement().ID));
				ti.setText(1,products.lastElement().getType());
				ti.setText(2, Double.toString(products.lastElement().width));
				ti.setText(3, Double.toString(products.lastElement().height));
				ti.setText(4, products.lastElement().color);
				
				
				}else {
				MessageBox msg= new MessageBox(shell, SWT.ICON_WARNING);
				msg.setText("ГРЕШКА");
				msg.setMessage("ПОПЪЛНЕТЕ ВСИЧКИ ПОЛЕТА");
				msg.open();
				}
			}
		});
		addButton.setBounds(176, 68, 135, 25);
		addButton.setText("\u0414\u041E\u0411\u0410\u0412\u0418");
		
		//delete
		Button deleteButton = new Button(shell, SWT.NONE);
		deleteButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				int selectedIndex=table.getSelectionIndex();
				
				if(table.isSelected(selectedIndex)) {
				products.remove(selectedIndex);
				table.remove(selectedIndex);
				}
				
			}
			
			
		});
		deleteButton.setBounds(321, 68, 135, 25);
		deleteButton.setText("ИЗТРИВАНЕ");
		
		
		
		
		
		
		
		

	}
	private void refreshTable(Vector<Product> products)
	{
		for(Product p : products) {
		TableItem ti = new TableItem(table, SWT.NONE);
		
		ti.setText(0,Integer.toString(p.ID));
		ti.setText(1,p.getType());
		ti.setText(2, Double.toString(p.width));
		ti.setText(3, Double.toString(p.height));
		ti.setText(4, p.color);
		}
	}
}
