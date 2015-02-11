package framesystem;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.ResultSet;
import java.sql.SQLException;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import dbconsole.MySQL;

public class FrameSystemView extends Frame implements ActionListener,WindowListener{
	
	private Button button = new Button("表示");
	CardLayout cardlayout;
	Panel panel1;
	Panel panel2;
	public FrameSystemView(FrameSystemController controller) {
		// TODO Auto-generated constructor stub
		panel1 = new Panel();
		panel2 = new Panel();
		addWindowListener(this);
		setTitle("DataBase");
		cardlayout = new CardLayout();
		setLayout(cardlayout);
		panel2.add(button,BorderLayout.CENTER);
		add(panel2);
		add(panel1);
		button.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==button){
			int Percentage,Year;
			String Country;
			ResultSet rs;	
			MySQL mysql = new MySQL();
			rs = mysql.selectAll();
			DefaultCategoryDataset data = new DefaultCategoryDataset();
			try { 
					   
					while(rs.next()){
					Percentage = rs.getInt("Percentage");	
					Country = rs.getString("Country");
		    		Year = rs.getInt("Year");
					data.addValue(Percentage, Country,""+Year);
		    		panel1.add(new Label("Percentage:"+Percentage+"/Country:"+ Country+"/Year:"+Year));  //データベースから取得、表示
	    			}
				} catch (SQLException Error) {
					// TODO Auto-generated catch block
				}
		    JFreeChart chart = ChartFactory.createLineChart("Export values in Japan","Year","％",data,PlotOrientation.VERTICAL,true,false,false);
		    ChartPanel cpanel = new ChartPanel(chart);
		    panel1.add(cpanel);
		    panel1.add(new Label("Reference from ”http://www.jftc.or.jp/kids/kids_news/japan/country.html”")); 
			cardlayout.next(this);
		
		
		}
	}
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}
