package com.fh.jw;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.PopupMenu;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.BorderFactory;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class HelpJPanel extends javax.swing.JPanel  {
	private JScrollPane jScrollPane1;
	private JPanel jPanel1;
	private JPopupMenu jPopupMenu1;
	private JTextPane text;
	private JLabel help;
	private JPanel jPanel2;
	private JPanel jPanel3;
	private JPanel jPanel4;
	private JPanel jPanel5;
	private JMenuItem jMenuItem1;

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	* Auto-generated main method to display this 
	* JPanel inside a new JFrame.
	*/
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new HelpJPanel());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public HelpJPanel() {
		super();
		initGUI();
		//String str=readHelpFile();
		readHelpFile rhf=new readHelpFile(text);
		Thread th= new Thread(rhf);
		th.start();
		//help.setText(str);
		//text.setText(str);
	}
	
	private void initGUI() {
		try {
			setPreferredSize(new Dimension(747, 705));
			BorderLayout thisLayout = new BorderLayout();
			this.setLayout(thisLayout);
			this.setBackground(new java.awt.Color(255,128,128));
			{
				jPanel1 = new JPanel();				
				this.add(jPanel1, BorderLayout.NORTH);
				jPanel1.setPreferredSize(new java.awt.Dimension(748, 26));				
			}
			{
				jPanel5 = new JPanel();				
				BorderLayout jPanel5Layout = new BorderLayout();
				jPanel5.setLayout(jPanel5Layout);
				this.add(jPanel5, BorderLayout.CENTER);
				jPanel5.setPreferredSize(new java.awt.Dimension(747, 24));
				jPanel5.setBackground(new java.awt.Color(235,215,255));
				{
					jScrollPane1 = new JScrollPane();
					jPanel5.add(jScrollPane1, BorderLayout.CENTER);
					jScrollPane1.setBounds(7, 7, 735, 693);
					jScrollPane1
						.setBackground(new java.awt.Color(255, 128, 128));
					jScrollPane1.setPreferredSize(new java.awt.Dimension(115, 85));
					{
						text = new JTextPane();
						jScrollPane1.setViewportView(text);
						text.setContentType("text/html");
						text.setPreferredSize(new java.awt.Dimension(214, 86));
						text.setBackground(new java.awt.Color(240,225,255));
						text.setEditable(false);
					}
				}
			}
			{
				jPanel2 = new JPanel();
				
				this.add(jPanel2, BorderLayout.EAST);
				jPanel2.setPreferredSize(new java.awt.Dimension(18, 653));
			}
			{
				jPanel3= new JPanel();
				
				this.add(jPanel3, BorderLayout.WEST);
				jPanel3.setPreferredSize(new java.awt.Dimension(18, 653));
			}
			{
				jPanel4 = new JPanel();				
				this.add(jPanel4, BorderLayout.SOUTH);
				jPanel4.setPreferredSize(new java.awt.Dimension(747, 19));
				jPanel4.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private String readHelpFile()
	{
		String str="";
		File xfile=new File(".\\data\\redme.txt");
		if(xfile.exists())
		{
			if(xfile.exists()){
				FileReader fr=null;;
				BufferedReader  br=null;
				try {
					fr = new FileReader(xfile);
					br= new BufferedReader(fr); 
					String line="";
					while((line=br.readLine())!=null)
					{	
						str=str+line+"<br>";
						//System.out.println(line);
					}
					br.close();
					fr.close();					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			//System.out.println(" STR:        "+str);
		}else
		{
			System.out.println("文件不存在!");
		}
		return str;	
	}

	public JTextPane getTextArea() {
		return text;
	}

	public void setTextArea(JTextPane text) {
		this.text = text;
	}	

	public String getTextText()
	{
		return text.getSelectedText();
	}

}

class readHelpFile extends Thread
{
	private JTextPane text=null;
	public readHelpFile(JTextPane text) {
		this.text=text;
	}

	public void run()
	{
		readHelpFile();
	}
	
	private String readHelpFile()
	{
		String str="";
		File xfile=new File(".\\data\\redme.txt");
		if(xfile.exists())
		{
			if(xfile.exists()){
				FileReader fr=null;;
				BufferedReader  br=null;
				try {
					fr = new FileReader(xfile);
					br= new BufferedReader(fr); 
					String line="";
					while((line=br.readLine())!=null)
					{	
						str=str+line+"<br>";				
					}
					br.close();
					fr.close();					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			//System.out.println(" STR:        "+str);
		}else
		{
			System.out.println("文件不存在!");
		}
		text.setText(str);
		return str;	
	}
}
