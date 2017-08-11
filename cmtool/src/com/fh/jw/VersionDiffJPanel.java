package com.fh.jw;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;

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
public class VersionDiffJPanel extends javax.swing.JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel jPanel1;
	private JButton jButton1;
	private JTextArea jTextEmailContext;
	private JFileChooser jFileChooser1;
	/**
	* Auto-generated main method to display this 
	* JPanel inside a new JFrame.
	*/
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new VersionDiffJPanel());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public VersionDiffJPanel() {
		super();
		initGUI();
	}
	private void initGUI() {
		try {
			setPreferredSize(new Dimension(567, 462));
			this.setLayout(null);
			{				
				jPanel1 = new JPanel();
				this.add(jPanel1);
				jPanel1.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
				jPanel1.setLayout(null);
				jPanel1.setBounds(0, 0, 567, 462);
				{
					jButton1 = new JButton();
					jPanel1.add(jButton1);
					jButton1.setText("开始对比");
					jButton1.setBounds(429, 229, 88, 24);
					jButton1.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							System.out.println(getVersionNum(jTextEmailContext.getText().toString()));
							}
						});
					
				}
				
				{
					JScrollPane JScrollPane_del = new JScrollPane();
					jPanel1.add(JScrollPane_del);
					JScrollPane_del.setBounds(51, 50, 423, 158);
					{
						jTextEmailContext = new JTextArea();
						JScrollPane_del.setViewportView(jTextEmailContext);
						jTextEmailContext.setText("");
						jTextEmailContext.setBounds(51, 50, 423, 158);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getVersionNum(String str)
	{
		StringBuffer restr=new StringBuffer();
		String[] strsplit=str.split("\n");
		int m=1;
		for(int i=0;i<strsplit.length;i++)
		{
			if(i%2==0)
			{
				restr.append("第"+m+"组:\n");
			}
			if(strsplit[i].indexOf("svn://jialiansvn.xgd.com/XGD-CXYW")>=0)
			{
				m++;
				String getcodeVersion=RuncmdCommand.runCMD("svn log -l1 "+strsplit[i].toString());
				String codeversion=getcodeVersion.substring(getcodeVersion.indexOf("r")+1,getcodeVersion.indexOf("|")-1);
				String codebugid=getcodeVersion.substring(getcodeVersion.indexOf("BugID:")+6,getcodeVersion.indexOf("BugID:")+11);
				restr.append("源代码的bugid是："+codebugid+",源代码的版本是："+codeversion+"\n");
			}
			if(strsplit[i].indexOf("svn://jialiansvn.xgd.com/xgd_rel")>=0)
			{
				String getrelVersion=RuncmdCommand.runCMD("svn log -l1 "+strsplit[i].toString());
				String relversion=getrelVersion.substring(getrelVersion.indexOf("svnversion:")+11,getrelVersion.indexOf("svnversion:")+17);
				String relbugid=getrelVersion.substring(getrelVersion.indexOf("bugidnum:")+9,getrelVersion.indexOf("bugidnum:")+14);
				restr.append("编译包的bugid是："+relbugid+",编译包的版本是："+relversion+"\n");
			}
		}
		return restr.toString();
	}
}