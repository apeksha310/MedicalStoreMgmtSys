package MedicalShop;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.ListIterator;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

public class MedicalShop {
		int fh,fw;
		public void mainFrame() {
			JFrame mainframe=new JFrame("Welcome To MedicalShop");//creating main frame
			mainframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
			mainframe.setLayout(null);
			mainframe.setBackground(new Color(55,215,132));
			mainframe.setForeground(new Color(55,215,132));
			mainframe.setIconImage(Toolkit.getDefaultToolkit().getImage(MedicalShop.class.getResource("/image/mshop.png")));
			fh=744;
			fw=1382;
			
			JPanel ContainerPanel=new JPanel();
			ContainerPanel.setBounds((fw/2)-635,(fh/2)-320,1250,600);
			ContainerPanel.setBackground(new Color(0,0,0,150));
			ContainerPanel.setLayout(null);
			

			////////////////code for border///////////////
			Font borderfont;
			TitledBorder titledborder;
			Border raisedbevel, loweredbevel, redline,compound;
			
			borderfont=new Font("BELL MT",Font.BOLD,20);
			raisedbevel = BorderFactory.createRaisedBevelBorder();
			loweredbevel = BorderFactory.createLoweredBevelBorder();
			redline = BorderFactory.createMatteBorder(3, 12, 3, 12, new Color(55,215,132));
			compound = BorderFactory.createCompoundBorder(raisedbevel, loweredbevel);
			compound = BorderFactory.createCompoundBorder(redline, compound);
	/////////////////////////new Record Panel///////////////////////////////
			Font nrfont=new Font("TIMES NEW ROMAN",Font.BOLD,16);
			JPanel newRecord=new JPanel();
			newRecord.setLayout(null);
			newRecord.setBackground(new Color(193,0,137));
			JPanel customer_panel = new JPanel();
			customer_panel.setBounds(20,20,1110,100);
			customer_panel.setBackground(new Color(0,0,0,170));
			customer_panel.setLayout(null);		
			
			titledborder= BorderFactory.createTitledBorder(compound,"Patients Details");
			titledborder.setTitleJustification(TitledBorder.CENTER);
			titledborder.setTitleFont(borderfont);
			titledborder.setTitleColor(Color.YELLOW);
			customer_panel.setBorder(titledborder);
			customer c_max=new customer();
			int max_bill=c_max.getMaxBillNo();
			
			JLabel nrl_custId = new JLabel("Bill Number           :");
			nrl_custId.setFont(nrfont);
			nrl_custId.setForeground(Color.YELLOW);
			nrl_custId.setBounds(100,25,250,25);
			
			JLabel nrl_transactionDate = new JLabel("Date   :");
			nrl_transactionDate.setFont(nrfont);
			nrl_transactionDate.setForeground(Color.YELLOW);
			nrl_transactionDate.setBounds(340,25,300,25);
			
			JTextField nrtf_custId = new JTextField();	
			nrtf_custId.setFont(nrfont);
			nrtf_custId.setBounds(240,25,80,25);
			nrtf_custId.setForeground(Color.RED);
			nrtf_custId.setEditable(false);
			nrtf_custId.setText("1");
			nrtf_custId.setHorizontalAlignment(JTextField.CENTER);
			nrtf_custId.setText(Integer.toString(++max_bill));
					
			JTextField nrtf_billdt = new JTextField();	
			nrtf_billdt.setFont(nrfont);
			nrtf_billdt.setBounds(404,25,126,25);
			nrtf_billdt.setForeground(Color.RED);
			nrtf_billdt.setEditable(false);
			nrtf_billdt.setText(new SimpleDateFormat("dd/MM/yyy").format(new Date()));
			nrtf_billdt.setHorizontalAlignment(JTextField.CENTER);
			
			JLabel nrl_custName = new JLabel("Patients Name        : ");
			nrl_custName.setFont(nrfont);
			nrl_custName.setForeground(Color.YELLOW);
			nrl_custName.setBounds(100,62,200,25);
			
			JTextField nrtf_custName = new JTextField();	
			nrtf_custName.setFont(nrfont);
			nrtf_custName.setBounds(240,62,290,25);
			nrtf_custName.setForeground(Color.RED);
			
			JLabel nrl_doctName = new JLabel("Doctor Name : ");
			nrl_doctName.setFont(nrfont);
			nrl_doctName.setForeground(Color.YELLOW);
			nrl_doctName.setBounds(605,25,200,25);
			
			JTextField nrtf_doctName = new JTextField();	
			nrtf_doctName.setFont(nrfont);
			nrtf_doctName.setBounds(735,25,250,25);
			nrtf_doctName.setForeground(Color.RED);
			
			JLabel nrl_custAddress = new JLabel("Address          : ");
			nrl_custAddress.setFont(nrfont);
			nrl_custAddress.setForeground(Color.YELLOW);
			nrl_custAddress.setBounds(605,62,200,25);
			
			JTextField nrtf_custAddress = new JTextField();	
			nrtf_custAddress.setFont(nrfont);
			nrtf_custAddress.setBounds(735,62,250,25);
			nrtf_custAddress.setForeground(Color.RED);
			
			customer_panel.add(nrl_custId);
			customer_panel.add(nrtf_custId);
			customer_panel.add(nrtf_billdt);
			customer_panel.add(nrl_custName);
			customer_panel.add(nrtf_custName);
			customer_panel.add(nrl_transactionDate);
			customer_panel.add(nrl_doctName);
			customer_panel.add(nrtf_doctName);
			customer_panel.add(nrl_custAddress);
			customer_panel.add(nrtf_custAddress);
			///////////////////////purchase Panel code////////////////////
			JTextField nrtfTotal;
			JTextField[][] nrtfArr=new JTextField[6][7];
			JLabel nrl_batchNo,nrl_medicineName,nrl_companyName,nrl_mfg,nrl_expiry,nrl_quantity,nrl_mrp,nrl_totalAmt;
			JButton nr_submit;
			
			nrl_batchNo=new JLabel("Batch No");
			nrl_batchNo.setFont(nrfont);
			nrl_batchNo.setForeground(Color.YELLOW);
			nrl_batchNo.setBounds(32,25,200,25);
			
			nrl_medicineName=new JLabel("Medicine Name");
			nrl_medicineName.setFont(nrfont);
			nrl_medicineName.setForeground(Color.YELLOW);
			nrl_medicineName.setBounds(177,25,200,25);
			
			nrl_companyName=new JLabel("Company");
			nrl_companyName.setFont(nrfont);
			nrl_companyName.setForeground(Color.YELLOW);
			nrl_companyName.setBounds(425,25,200,25);
			
			nrl_mfg=new JLabel("Mfg Date");
			nrl_mfg.setFont(nrfont);
			nrl_mfg.setForeground(Color.YELLOW);
			nrl_mfg.setBounds(605,25,200,25);
			
			nrl_expiry=new JLabel("Expiry Date");
			nrl_expiry.setFont(nrfont);
			nrl_expiry.setForeground(Color.YELLOW);
			nrl_expiry.setBounds(740,25,200,25);
			
			nrl_quantity=new JLabel("Quantity");
			nrl_quantity.setFont(nrfont);
			nrl_quantity.setForeground(Color.YELLOW);
			nrl_quantity.setBounds(870,25,200,25);
			
			nrl_mrp=new JLabel("MRP");
			nrl_mrp.setFont(nrfont);
			nrl_mrp.setForeground(Color.YELLOW);
			nrl_mrp.setBounds(1000,25,200,25);		
			/////Batch Number/////
			nrtfArr[0][0]=new JTextField();
			nrtfArr[0][0].setFont(nrfont);
			nrtfArr[0][0].setBounds(20,57,100,25);
			nrtfArr[0][0].setForeground(Color.RED);
			
			nrtfArr[1][0]=new JTextField();
			nrtfArr[1][0].setFont(nrfont);
			nrtfArr[1][0].setBounds(20,94,100,25);
			nrtfArr[1][0].setForeground(Color.RED);		
			
			nrtfArr[2][0]=new JTextField();
			nrtfArr[2][0].setFont(nrfont);
			nrtfArr[2][0].setBounds(20,131,100,25);
			nrtfArr[2][0].setForeground(Color.RED);
			
			nrtfArr[3][0]=new JTextField();
			nrtfArr[3][0].setFont(nrfont);
			nrtfArr[3][0].setBounds(20,168,100,25);
			nrtfArr[3][0].setForeground(Color.RED);
			
			nrtfArr[4][0]=new JTextField();
			nrtfArr[4][0].setFont(nrfont);
			nrtfArr[4][0].setBounds(20,205,100,25);
			nrtfArr[4][0].setForeground(Color.RED);
			
			nrtfArr[5][0]=new JTextField();
			nrtfArr[5][0].setFont(nrfont);
			nrtfArr[5][0].setBounds(20,242,100,25);
			nrtfArr[5][0].setForeground(Color.RED);
			/////Medicine Name/////
			nrtfArr[0][1]=new JTextField();
			nrtfArr[0][1].setFont(nrfont);
			nrtfArr[0][1].setBounds(140,57,200,25);
			nrtfArr[0][1].setForeground(Color.RED);
			nrtfArr[0][1].setEditable(false);
			
			nrtfArr[1][1]=new JTextField();
			nrtfArr[1][1].setFont(nrfont);
			nrtfArr[1][1].setBounds(140,94,200,25);
			nrtfArr[1][1].setForeground(Color.RED);
			nrtfArr[1][1].setEditable(false);
			
			nrtfArr[2][1]=new JTextField();
			nrtfArr[2][1].setFont(nrfont);
			nrtfArr[2][1].setBounds(140,131,200,25);
			nrtfArr[2][1].setForeground(Color.RED);
			nrtfArr[2][1].setEditable(false);
			
			nrtfArr[3][1]=new JTextField();
			nrtfArr[3][1].setFont(nrfont);
			nrtfArr[3][1].setBounds(140,168,200,25);
			nrtfArr[3][1].setForeground(Color.RED);
			nrtfArr[3][1].setEditable(false);
			
			nrtfArr[4][1]=new JTextField();
			nrtfArr[4][1].setFont(nrfont);
			nrtfArr[4][1].setBounds(140,205,200,25);
			nrtfArr[4][1].setForeground(Color.RED);
			nrtfArr[4][1].setEditable(false);
			
			nrtfArr[5][1]=new JTextField();
			nrtfArr[5][1].setFont(nrfont);
			nrtfArr[5][1].setBounds(140,242,200,25);
			nrtfArr[5][1].setForeground(Color.RED);
			nrtfArr[5][1].setEditable(false);
			/////Company Name/////
			nrtfArr[0][2]=new JTextField();
			nrtfArr[0][2].setFont(nrfont);
			nrtfArr[0][2].setBounds(360,57,200,25);
			nrtfArr[0][2].setForeground(Color.RED);
			nrtfArr[0][2].setEditable(false);
			
			nrtfArr[1][2]=new JTextField();
			nrtfArr[1][2].setFont(nrfont);
			nrtfArr[1][2].setBounds(360,94,200,25);
			nrtfArr[1][2].setForeground(Color.RED);
			nrtfArr[1][2].setEditable(false);
			
			nrtfArr[2][2]=new JTextField();
			nrtfArr[2][2].setFont(nrfont);
			nrtfArr[2][2].setBounds(360,131,200,25);
			nrtfArr[2][2].setForeground(Color.RED);
			nrtfArr[2][2].setEditable(false);
			
			nrtfArr[3][2]=new JTextField();
			nrtfArr[3][2].setFont(nrfont);
			nrtfArr[3][2].setBounds(360,168,200,25);
			nrtfArr[3][2].setForeground(Color.RED);
			nrtfArr[3][2].setEditable(false);
			
			nrtfArr[4][2]=new JTextField();
			nrtfArr[4][2].setFont(nrfont);
			nrtfArr[4][2].setBounds(360,205,200,25);
			nrtfArr[4][2].setForeground(Color.RED);
			nrtfArr[4][2].setEditable(false);
			
			nrtfArr[5][2]=new JTextField();
			nrtfArr[5][2].setFont(nrfont);
			nrtfArr[5][2].setBounds(360,242,200,25);
			nrtfArr[5][2].setForeground(Color.RED);
			nrtfArr[5][2].setEditable(false);
			/////Manufacturing Date/////
			nrtfArr[0][3]=new JTextField();
			nrtfArr[0][3].setFont(nrfont);
			nrtfArr[0][3].setBounds(580,57,125,25);
			nrtfArr[0][3].setForeground(Color.RED);
			nrtfArr[0][3].setEditable(false);
			
			nrtfArr[1][3]=new JTextField();
			nrtfArr[1][3].setFont(nrfont);
			nrtfArr[1][3].setBounds(580,94,125,25);
			nrtfArr[1][3].setForeground(Color.RED);
			nrtfArr[1][3].setEditable(false);
			
			nrtfArr[2][3]=new JTextField();
			nrtfArr[2][3].setFont(nrfont);
			nrtfArr[2][3].setBounds(580,131,125,25);
			nrtfArr[2][3].setForeground(Color.RED);
			nrtfArr[2][3].setEditable(false);
			
			nrtfArr[3][3]=new JTextField();
			nrtfArr[3][3].setFont(nrfont);
			nrtfArr[3][3].setBounds(580,168,125,25);
			nrtfArr[3][3].setForeground(Color.RED);
			nrtfArr[3][3].setEditable(false);
			
			nrtfArr[4][3]=new JTextField();
			nrtfArr[4][3].setFont(nrfont);
			nrtfArr[4][3].setBounds(580,205,125,25);
			nrtfArr[4][3].setForeground(Color.RED);
			nrtfArr[4][3].setEditable(false);
			
			nrtfArr[5][3]=new JTextField();
			nrtfArr[5][3].setFont(nrfont);
			nrtfArr[5][3].setBounds(580,242,125,25);
			nrtfArr[5][3].setForeground(Color.RED);
			nrtfArr[5][3].setEditable(false);
			/////Expiry Date/////
			nrtfArr[0][4]=new JTextField();
			nrtfArr[0][4].setFont(nrfont);
			nrtfArr[0][4].setBounds(725,57,125,25);
			nrtfArr[0][4].setForeground(Color.RED);
			nrtfArr[0][4].setEditable(false);
			
			nrtfArr[1][4]=new JTextField();
			nrtfArr[1][4].setFont(nrfont);
			nrtfArr[1][4].setBounds(725,94,125,25);
			nrtfArr[1][4].setForeground(Color.RED);
			nrtfArr[1][4].setEditable(false);
			
			nrtfArr[2][4]=new JTextField();
			nrtfArr[2][4].setFont(nrfont);
			nrtfArr[2][4].setBounds(725,131,125,25);
			nrtfArr[2][4].setForeground(Color.RED);
			nrtfArr[2][4].setEditable(false);
			
			nrtfArr[3][4]=new JTextField();
			nrtfArr[3][4].setFont(nrfont);
			nrtfArr[3][4].setBounds(725,168,125,25);
			nrtfArr[3][4].setForeground(Color.RED);
			nrtfArr[3][4].setEditable(false);
			
			nrtfArr[4][4]=new JTextField();
			nrtfArr[4][4].setFont(nrfont);
			nrtfArr[4][4].setBounds(725,205,125,25);
			nrtfArr[4][4].setForeground(Color.RED);
			nrtfArr[4][4].setEditable(false);
			
			nrtfArr[5][4]=new JTextField();
			nrtfArr[5][4].setFont(nrfont);
			nrtfArr[5][4].setBounds(725,242,125,25);
			nrtfArr[5][4].setForeground(Color.RED);
			nrtfArr[5][4].setEditable(false);
			/////Medicine Quantity/////
			nrtfArr[0][5]=new JTextField();
			nrtfArr[0][5].setFont(nrfont);
			nrtfArr[0][5].setBounds(870,57,70,25);
			nrtfArr[0][5].setForeground(Color.RED);
			
			nrtfArr[1][5]=new JTextField();
			nrtfArr[1][5].setFont(nrfont);
			nrtfArr[1][5].setBounds(870,94,70,25);
			nrtfArr[1][5].setForeground(Color.RED);
			
			nrtfArr[2][5]=new JTextField();
			nrtfArr[2][5].setFont(nrfont);
			nrtfArr[2][5].setBounds(870,131,70,25);
			nrtfArr[2][5].setForeground(Color.RED);
			
			nrtfArr[3][5]=new JTextField();
			nrtfArr[3][5].setFont(nrfont);
			nrtfArr[3][5].setBounds(870,168,70,25);
			nrtfArr[3][5].setForeground(Color.RED);
			
			nrtfArr[4][5]=new JTextField();
			nrtfArr[4][5].setFont(nrfont);
			nrtfArr[4][5].setBounds(870,205,70,25);
			nrtfArr[4][5].setForeground(Color.RED);
			
			nrtfArr[5][5]=new JTextField();
			nrtfArr[5][5].setFont(nrfont);
			nrtfArr[5][5].setBounds(870,242,70,25);
			nrtfArr[5][5].setForeground(Color.RED);
			/////MRP of Purchase/////
			nrtfArr[0][6]=new JTextField();
			nrtfArr[0][6].setFont(nrfont);
			nrtfArr[0][6].setBounds(960,57,130,25);
			nrtfArr[0][6].setForeground(Color.RED);
			nrtfArr[0][6].setEditable(false);

			nrtfArr[1][6]=new JTextField();
			nrtfArr[1][6].setFont(nrfont);
			nrtfArr[1][6].setBounds(960,94,130,25);
			nrtfArr[1][6].setForeground(Color.RED);
			nrtfArr[1][6].setEditable(false);
			
			nrtfArr[2][6]=new JTextField();
			nrtfArr[2][6].setFont(nrfont);
			nrtfArr[2][6].setBounds(960,131,130,25);
			nrtfArr[2][6].setForeground(Color.RED);
			nrtfArr[2][6].setEditable(false);
			
			nrtfArr[3][6]=new JTextField();
			nrtfArr[3][6].setFont(nrfont);
			nrtfArr[3][6].setBounds(960,168,130,25);
			nrtfArr[3][6].setForeground(Color.RED);
			nrtfArr[3][6].setEditable(false);
			
			nrtfArr[4][6]=new JTextField();
			nrtfArr[4][6].setFont(nrfont);
			nrtfArr[4][6].setBounds(960,205,130,25);
			nrtfArr[4][6].setForeground(Color.RED);
			nrtfArr[4][6].setEditable(false);
			
			nrtfArr[5][6]=new JTextField();
			nrtfArr[5][6].setFont(nrfont);
			nrtfArr[5][6].setBounds(960,242,130,25);
			nrtfArr[5][6].setForeground(Color.RED);
			nrtfArr[5][6].setEditable(false);
			
			nrl_totalAmt=new JLabel("Total Bill Amount : ");
			nrl_totalAmt.setFont(nrfont);
			nrl_totalAmt.setForeground(Color.YELLOW);
			nrl_totalAmt.setBounds(770,285,200,25);
			
			nrtfTotal=new JTextField();
			nrtfTotal.setFont(nrfont);
			nrtfTotal.setBounds(960,280,130,25);
			nrtfTotal.setForeground(Color.RED);
			nrtfTotal.setEditable(false);
			nrtfTotal.setHorizontalAlignment(JTextField.RIGHT);;
			
			nr_submit=new JButton("SUBMIT");
			nr_submit.setBounds(505,280,100,35);
			nr_submit.setForeground(Color.WHITE);
			nr_submit.setBackground(new Color(9,121,38));
			nr_submit.setFont(new Font("Bell MT",Font.BOLD,16));
			nr_submit.setFocusPainted(false);
			nr_submit.setBorderPainted(false);
			
			JPanel purches_panel = new JPanel();
			purches_panel.setBounds(20,120,1110,335);
			purches_panel.setBackground(new Color(0,0,0,170));
			purches_panel.setLayout(null);
			for(int i=0;i<6;i++)
			{
				for(int j=0;j<7;j++)
				{
					if((j==5)||(j==6))
					{
						nrtfArr[i][j].setHorizontalAlignment(JTextField.RIGHT);
						purches_panel.add(nrtfArr[i][j]);
					}
					else
					{
						nrtfArr[i][j].setHorizontalAlignment(JTextField.CENTER);
						purches_panel.add(nrtfArr[i][j]);
					}
				}
			}
			
			purches_panel.add(nrl_batchNo);
			purches_panel.add(nrl_medicineName);
			purches_panel.add(nrl_companyName);
			purches_panel.add(nrl_mfg);
			purches_panel.add(nrl_expiry);
			purches_panel.add(nrl_quantity);
			purches_panel.add(nrl_mrp);
			purches_panel.add(nrtfTotal);
			purches_panel.add(nrl_totalAmt);
			purches_panel.add(nr_submit);
			
			titledborder= BorderFactory.createTitledBorder(compound,"Purchase Details");
			titledborder.setTitleJustification(TitledBorder.CENTER);
			titledborder.setTitleFont(borderfont);
			titledborder.setTitleColor(Color.YELLOW);
			purches_panel.setBorder(titledborder);	

			nrtf_custName.addKeyListener(new KeyAdapter()
			{
				public void keyTyped(KeyEvent ke) 
				{
					char c=ke.getKeyChar();
					if(c=='\n')
						nrtf_custAddress.requestFocus();
				}
			});
			
			nrtf_custAddress.addKeyListener(new KeyAdapter()
			{
				public void keyTyped(KeyEvent ke) 
				{
					char c=ke.getKeyChar();
					if(c=='\n')
						nrtf_doctName.requestFocus();
				}
			});

			nrtf_doctName.addKeyListener(new KeyAdapter()
			{
				public void keyTyped(KeyEvent ke) 
				{
					char c=ke.getKeyChar();
					if(c=='\n')
						nrtfArr[0][0].requestFocus();
				}
			});
			for (int i=0;i<6;i++)	{
				nrtfArr[i][0].addKeyListener(new KeyAdapter() {
					public void keyTyped(KeyEvent ke) {
						char c=ke.getKeyChar();
						int j=0;
						if(ke.getSource()==nrtfArr[0][0])
							j=0;
						if(ke.getSource()==nrtfArr[1][0])
							j=1;
						if(ke.getSource()==nrtfArr[2][0])
							j=2;
						if(ke.getSource()==nrtfArr[3][0])
							j=3;
						if(ke.getSource()==nrtfArr[4][0])
							j=4;
						if(ke.getSource()==nrtfArr[5][0])
							j=5;
						if(c=='\n')
						{
							nrtfArr[j][5].requestFocus();
						}
					}
				});
				nrtfArr[i][5].addKeyListener(new KeyAdapter()
			    {
					@Override
					public void keyTyped(KeyEvent ke) 
					{
						char c=ke.getKeyChar();
						int j=0;
						if(ke.getSource()==nrtfArr[0][5])
							j=1;
						if(ke.getSource()==nrtfArr[1][5])
							j=2;
						if(ke.getSource()==nrtfArr[2][5])
							j=3;
						if(ke.getSource()==nrtfArr[3][5])
							j=4;
						if(ke.getSource()==nrtfArr[4][5])
							j=5;
						if(c=='\n')
						{
							nrtfArr[j][0].requestFocus();
						}
					}
				});
				nrtfArr[i][0].addFocusListener(new FocusAdapter()
				{
					public void focusLost(FocusEvent fe)
					{
						int j=0;
						if(fe.getSource()==nrtfArr[0][0])
							j=0;
						if(fe.getSource()==nrtfArr[1][0])
							j=1;
						if(fe.getSource()==nrtfArr[2][0])
							j=2;
						if(fe.getSource()==nrtfArr[3][0])
							j=3;
						if(fe.getSource()==nrtfArr[4][0])
							j=4;
						if(fe.getSource()==nrtfArr[5][0])
							j=5;
						int process=0;
						String getBatch=nrtfArr[j][0].getText().trim().trim();
						if((getBatch.replace(" ","").length())==0)	{
							for(int r=1;r<7;r++) {
								if((nrtfArr[j][r].getText().trim().trim().replace(" ","").length())!=0)
									nrtfArr[j][r].setText("");
							}
						}
						else	{
							block:	{
								for(int k=0;k<j;k++)	{
									for(int l=0;l<7;l++)	{
										String getValue=nrtfArr[k][l].getText().trim().trim();
										if((getValue.replace(" ","").length())==0)	{
											for(int p=0;p<6;p++)
												nrtfArr[j][p].setText("");												
											JOptionPane.showMessageDialog(null,"complete the previous Fields First");
											if((l==1)||(l==5))
												nrtfArr[k][l].requestFocus();
											else	{
												if(l<5)	{
													nrtfArr[k][0].requestFocus();
													l=0;
												}
												else	{
													nrtfArr[k][5].requestFocus();
												}
											}
											for(int m=k;m<j;m++)	{
												for(int n=l;n<7;n++)	{
													nrtfArr[m][n].setText("");
												}
											}
											process=1;
											break block;
										}
									}
								}	
							}
							if(process==0)	{
								stock st=new stock();
								st.batch_no=getBatch;
								if(st.isValidBatch())
								{
									stock gst=new stock();
									gst.batch_no=nrtfArr[j][0].getText().trim();
									LinkedList<stock> sll=new LinkedList<stock>();
									sll=gst.getStockDetails();
									ListIterator<stock> litr=sll.listIterator();
									gst=litr.next();
									SimpleDateFormat df=new SimpleDateFormat("MMM yyyy");
									nrtfArr[j][1].setText(gst.med_name);
									nrtfArr[j][2].setText(gst.comp_name);
									nrtfArr[j][3].setText(df.format(gst.mfg_dt));
									nrtfArr[j][4].setText(df.format(gst.exp_dt));
								}
								else
								{
									JOptionPane.showMessageDialog(null,"Entered Batch No is Invalid");
									nrtfArr[j][0].setText("");
									nrtfArr[j][0].requestFocus();
								}
							}
						}
					}
				});
				nrtfArr[i][5].addFocusListener(new FocusAdapter()
				{
					DecimalFormat df=new DecimalFormat("#.##");
					public void focusLost(FocusEvent ef)
					{	
						int j=0;
						if(ef.getSource()==nrtfArr[0][5])
							j=0;
						if(ef.getSource()==nrtfArr[1][5])
							j=1;
						if(ef.getSource()==nrtfArr[2][5])
							j=2;
						if(ef.getSource()==nrtfArr[3][5])
							j=3;
						if(ef.getSource()==nrtfArr[4][5])
							j=4;
						if(ef.getSource()==nrtfArr[5][5])
							j=5;
						try
						{						
							String getQty=nrtfArr[j][5].getText().trim().trim();
							if((getQty.replace(" ","").length())==0)	{
									if((nrtfArr[j][6].getText().trim().trim().replace(" ","").length())!=0)
										nrtfArr[j][6].setText("");
							}
							else	{ 
								String bat_ch=nrtfArr[j][0].getText().trim();
								String medi_name=nrtfArr[j][1].getText().trim();
								if((medi_name.replace(" ","").length())==0)	{
									nrtfArr[j][0].setText("");
									
									nrtfArr[j][0].requestFocus();
									nrtfArr[j][5].setText("");
									JOptionPane.showMessageDialog(null,"Please Enter The Batch Number First");
								}
								else	{	
									int intQty=Integer.parseInt(getQty);
									stock st=new stock();
									st.batch_no=bat_ch;
									LinkedList<stock> sll=new LinkedList<stock>();
									sll=st.getStockDetails();
									ListIterator<stock> litr=sll.listIterator();
									st=litr.next();
									double nrArr_unitMrp=st.price_per_unit;	
									int avaiStock=st.avai_in_stock;
									if(intQty<avaiStock)
									{
										nrtfArr[j][6].setText(df.format(nrArr_unitMrp*(double)intQty));
										if((nrtfTotal.getText().trim().replace(" ","").length())==0)
										{
											nrtfTotal.setText(df.format(nrArr_unitMrp*(double)intQty));
										}
										else
										{
											double calc_total=0;
											for(int x=0;x<=5;x++)
											{
												if((nrtfArr[x][6].getText().trim().replace(" ","").length())!=0)
													calc_total=calc_total+(Double.parseDouble(nrtfArr[x][6].getText().trim()));
											}
											nrtfTotal.setText(df.format(calc_total));
										}
									}
									else if(intQty>avaiStock)
									{									
										nrtfArr[j][5].setText(Integer.toString(avaiStock));
										nrtfArr[j][6].setText(df.format(nrArr_unitMrp*(double)avaiStock));
										if((nrtfTotal.getText().trim().replace(" ","").length())==0)
										{
											nrtfTotal.setText(df.format(nrArr_unitMrp*(double)avaiStock));
										}
										else
										{
											double calc_total=0;
											for(int x=0;x<=5;x++)
											{
												if((nrtfArr[x][6].getText().trim().replace(" ","").length())!=0)
													calc_total=calc_total+(Double.parseDouble(nrtfArr[x][6].getText().trim()));
											}
											nrtfTotal.setText(df.format(calc_total));
										}
										JOptionPane.showMessageDialog(null,"Out Of Stock\n Only "+avaiStock+" Available");
									}
									else if(intQty==avaiStock)
									{
										nrtfArr[j][6].setText(df.format(nrArr_unitMrp*(double)avaiStock));
										if((nrtfTotal.getText().trim().replace(" ","").length())==0)
										{
											nrtfTotal.setText(df.format(nrArr_unitMrp*(double)avaiStock));
										}
										else
										{
											double tempTotle=Double.parseDouble(nrtfTotal.getText().trim());
											nrtfTotal.setText(df.format((nrArr_unitMrp*(double)avaiStock)+tempTotle));
										}
									}
								}
							}
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}		
					}
				});
			}
			nr_submit.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e)	{
					int compField=0;
					int ctbt=0;
					for(int k=0;k<6;k++) {
						if((nrtfArr[k][0].getText().trim().replace(" ","").length())!=0){
							ctbt++;
							if((nrtfArr[k][5].getText().trim().replace(" ","").length())==0){
								compField=1;
								nrtfArr[k][5].requestFocus();
								JOptionPane.showMessageDialog(null,"Please Enter Quantity for\nBatch No='"+nrtfArr[k][0].getText()+"'");
							}
						}
					}
					if(ctbt>0)	{
						if(compField==0){
							if((nrtf_custName.getText().trim().replace(" ","").length())!=0)  {
								if((nrtf_custAddress.getText().trim().replace(" ","").length())!=0)	{
									int chkH1=0;
									for(int i=0;i<6;i++)  {
										if((nrtfArr[i][0].getText().trim().replace(" ","").length())!=0)  {
											medicine m=new medicine();
											m.med_name=nrtfArr[i][1].getText().trim();
											if(m.is_h1())
												chkH1=1;
										}
									}
									if(chkH1==0)	{
										double Tot_al=0;
										for(int d=0;d<6;d++)
											if(nrtfArr[d][6].getText().replace(" ","").length()>0)
												Tot_al=Tot_al+(Double.parseDouble(nrtfArr[d][6].getText()));
										customer c=new customer();									
										c.bill_no=Integer.parseInt(nrtf_custId.getText());
										c.cust_name=nrtf_custName.getText().trim().toUpperCase();
										c.cust_addr=nrtf_custAddress.getText().trim().toUpperCase();
										c.doct_name=nrtf_doctName.getText().trim().toUpperCase();
										c.bill_dt=new Date();
										c.bill_amt=Tot_al;
										int cust_ins=c.insertRecord();
										boolean insert_transaction=true;
										if(cust_ins!=0)	{
											for(int i=0;i<6;i++) {
												if((nrtfArr[i][0].getText().trim().replace(" ","").length())!=0){
													stock s=new stock();
													s.batch_no=nrtfArr[i][0].getText().trim();
													LinkedList<stock> sll=new LinkedList<stock>();
													sll=s.getStockDetails();
													ListIterator<stock> litr=sll.listIterator();
													s=litr.next();
													int ais=s.avai_in_stock;
													if(Integer.parseInt(nrtfArr[i][5].getText())>ais)
														nrtfArr[i][5].setText(Integer.toString(ais));
													transaction t=new transaction();
													t.bill_no=Integer.parseInt(nrtf_custId.getText().trim());
													t.batch=nrtfArr[i][0].getText().trim().toUpperCase();
													t.med_name=nrtfArr[i][1].getText().trim().toUpperCase();
													t.comp_name=nrtfArr[i][2].getText().trim().toUpperCase();
													t.mfg_dt=s.mfg_dt;
													t.exp_dt=s.exp_dt;
													t.quantity=Integer.parseInt(nrtfArr[i][5].getText().trim());
													t.tab_bill=Double.parseDouble(nrtfArr[i][6].getText().trim());
													int trans_ins=t.insert();
													if(trans_ins==1)	{
														if(ais>(Integer.parseInt(nrtfArr[i][5].getText().trim())))  {
															s.avai_in_stock=ais-(Integer.parseInt(nrtfArr[i][5].getText().trim()));
															s.updateAvailableInStock();
														}
														if((ais<(Integer.parseInt(nrtfArr[i][5].getText().trim())))||(ais==(Integer.parseInt(nrtfArr[i][5].getText().trim()))))	{
															s.deleteBatch();
														}
													}
													else {
														insert_transaction=false;
														break;
													}
												}
											}
											if((cust_ins==1)&&insert_transaction) {
												customer cb=new customer();
												int bill_no=cb.getMaxBillNo();
												bill_no+=1;
												nrtf_custId.setText(Integer.toString(bill_no));
												nrtf_custName.setText("");
												nrtf_custAddress.setText("");
												nrtf_doctName.setText("");
												nrtfTotal.setText("");
												for(int y=0;y<6;y++)
												{
													for(int z=0;z<7;z++)
													{
														nrtfArr[y][z].setText("");
													}
												}
												JOptionPane.showMessageDialog(null,"Submitted Successfully");
											}
											else {
												JOptionPane.showMessageDialog(null,"Problem While Submitting\nCheck the input values");
												h1_record delete_bill=new h1_record();
												delete_bill.bill_no=Integer.parseInt(nrtf_custId.getText());
												delete_bill.deleteBill();
											}
										}
									}
									else if((chkH1==1)&&((nrtf_doctName.getText().trim().replace(" ","").length())!=0))
									{
										
										double Tot_al=0;
										for(int d=0;d<6;d++)
											if(nrtfArr[d][6].getText().replace(" ","").length()>0)
												Tot_al=Tot_al+(Double.parseDouble(nrtfArr[d][6].getText()));
										customer c=new customer();									
										c.bill_no=Integer.parseInt(nrtf_custId.getText());
										c.cust_name=nrtf_custName.getText().trim().toUpperCase();
										c.cust_addr=nrtf_custAddress.getText().trim().toUpperCase();
										c.doct_name=nrtf_doctName.getText().trim().toUpperCase();
										c.bill_dt=new Date();
										c.bill_amt=Tot_al;
										int cust_ins=c.insertRecord();
										boolean insert_transaction=true;
										if(cust_ins!=0)
										{
											for(int i=0;i<6;i++)
											{
												if((nrtfArr[i][0].getText().trim().replace(" ","").length())!=0)
												{
													stock s=new stock();
													s.batch_no=nrtfArr[i][0].getText().trim();
													LinkedList<stock> sll=new LinkedList<stock>();
													sll=s.getStockDetails();
													ListIterator<stock> litr=sll.listIterator();
													s=litr.next();
													int ais=s.avai_in_stock;
													if(Integer.parseInt(nrtfArr[i][5].getText())>ais)
														nrtfArr[i][5].setText(Integer.toString(ais));
													transaction t=new transaction();
													t.bill_no=Integer.parseInt(nrtf_custId.getText().trim());
													t.batch=nrtfArr[i][0].getText().trim().toUpperCase();
													t.med_name=nrtfArr[i][1].getText().trim().toUpperCase();
													t.comp_name=nrtfArr[i][2].getText().trim().toUpperCase();
													t.mfg_dt=s.mfg_dt;
													t.exp_dt=s.exp_dt;
													t.quantity=Integer.parseInt(nrtfArr[i][5].getText().trim());
													t.tab_bill=Double.parseDouble(nrtfArr[i][6].getText().trim());
													int trans_ins=t.insert();
													
													if(trans_ins==1)  {																												
														if((s.med_type).equals("H1"))	{
															h1_record h=new h1_record();
															h.bill_no=Integer.parseInt(nrtf_custId.getText().trim());
															h.batch_no=nrtfArr[i][0].getText().trim().toUpperCase();
															h.qty_in_stock=ais-(Integer.parseInt(nrtfArr[i][5].getText().trim()));
															h.insert_h1();
														}
														if(ais>(Integer.parseInt(nrtfArr[i][5].getText().trim())))	{
															s.avai_in_stock=ais-(Integer.parseInt(nrtfArr[i][5].getText().trim()));
															s.updateAvailableInStock();
														}
														if((ais<(Integer.parseInt(nrtfArr[i][5].getText().trim())))||(ais==(Integer.parseInt(nrtfArr[i][5].getText().trim()))))	{
															s.deleteBatch();
														}
													}
													else {
														insert_transaction=false;
														break;
													}
												}
											}
											if((cust_ins==1)&&insert_transaction) {
												customer cb=new customer();
												int bill_no=cb.getMaxBillNo();
												bill_no+=1;
												nrtf_custId.setText(Integer.toString(bill_no));
												nrtf_custName.setText("");
												nrtf_custAddress.setText("");
												nrtf_doctName.setText("");
												nrtfTotal.setText("");
												for(int y=0;y<6;y++){
													for(int z=0;z<7;z++){
														nrtfArr[y][z].setText("");
													}
												}
												JOptionPane.showMessageDialog(null,"Submitted Successfully");
											}
											else {
												JOptionPane.showMessageDialog(null,"Problem While Submitting\nCheck the input values");
												h1_record delete_bill=new h1_record();
												delete_bill.bill_no=Integer.parseInt(nrtf_custId.getText());
												delete_bill.deleteBill();
											}
										}
									}
									else{
										JOptionPane.showMessageDialog(null,"Please Enter Doctor Name with Address\n in Form\" Dr.Doctor_name, Address\" ");											
										nrtf_doctName.requestFocus();
									}
								}
								else{
									JOptionPane.showMessageDialog(null,"Please Enter Customer Address");								
									nrtf_custAddress.requestFocus();
								}
							}
							else{
								JOptionPane.showMessageDialog(null,"Please Enter Customer Name");
								nrtf_custName.requestFocus();
							}
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null,"No Medicine is Selected");
					}
				}
			});
			newRecord.add(purches_panel);
			newRecord.add(customer_panel);
	/////////////////////////////Stock Update Panel////////////////////////////////////
			JPanel supanel;
			JLabel sul_infolebel,sul_batchNo,sul_expiry,sul_medname,sul_mfg,sul_noofpac,sul_checkMRP;
			JTextField sutf_batchNo,sutf_expiry,sutf_medname,sutf_noofpac,sutf_checkMRP;
			JButton su_submit;
			Font sufont=new Font("BELL MT",Font.BOLD,20);
			String[] monthsArr=new String[]{"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
			String[] yearArr=new String[5];
			String sugetYear;
			int suYear;
			JComboBox<?> monthCombo,yearCombo;

			
			JPanel stockUpdate = new JPanel();
			stockUpdate.setLayout(null);
			stockUpdate.setBackground(new Color(193,0,137));
			
			sul_infolebel=new JLabel("Enter The New Stock Details Here");
			Font lbl_font=new Font("ALGERIAN",Font.ITALIC,40);
			sul_infolebel.setFont(lbl_font);
			sul_infolebel.setForeground(Color.RED);
			sul_infolebel.setBounds(200,12,800,50);
			
			sul_medname=new JLabel("Medicine Name ");
			sul_medname.setFont(sufont);
			sul_medname.setForeground(Color.YELLOW);
			sul_medname.setBounds(150,25,400,35);
			
			sutf_medname=new JTextField();	
			sutf_medname.setFont(sufont);
			sutf_medname.setBounds(545,25,400,35);
			sutf_medname.setForeground(Color.RED);
			sutf_medname.setHorizontalAlignment(JTextField.CENTER);
			
			sul_batchNo=new JLabel("Batch Number ");
			sul_batchNo.setFont(sufont);
			sul_batchNo.setForeground(Color.YELLOW);
			sul_batchNo.setBounds(150,80,400,35);
			
			sutf_batchNo=new JTextField();	
			sutf_batchNo.setFont(sufont);
			sutf_batchNo.setBounds(545,80,400,35);
			sutf_batchNo.setForeground(Color.RED);
			sutf_batchNo.setHorizontalAlignment(JTextField.CENTER);
			
			sul_noofpac=new JLabel("Number Of Packets Added in Stock ");
			sul_noofpac.setFont(sufont);
			sul_noofpac.setForeground(Color.YELLOW);
			sul_noofpac.setBounds(150,135,400,35);
			
			sutf_noofpac=new JTextField();	
			sutf_noofpac.setFont(sufont);
			sutf_noofpac.setBounds(545,135,400,35);
			sutf_noofpac.setForeground(Color.RED);
			sutf_noofpac.setHorizontalAlignment(JTextField.CENTER);
			
			sul_mfg=new JLabel("Choose Manufacturing Date ");
			sul_mfg.setFont(sufont);
			sul_mfg.setForeground(Color.YELLOW);
			sul_mfg.setBounds(150,190,400,35);
			
			JComboBox<String> jComboBox = new JComboBox<String>(monthsArr);
			monthCombo=jComboBox;
			monthCombo.setBounds(545,190,150,35);
			monthCombo.setEditable(false);
			DefaultListCellRenderer listRenderer = new DefaultListCellRenderer();
	        listRenderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
	        monthCombo.setRenderer(listRenderer);
			monthCombo.setFont(sufont);
			monthCombo.setForeground(Color.RED);
			
			SimpleDateFormat yf= new SimpleDateFormat("yyyy");
			sugetYear=yf.format(new Date());
			suYear=Integer.parseInt(sugetYear);	
			int j=4;
			for(int i=0;i<5;i++)
			{
				int temp=suYear-j;
				yearArr[i]=Integer.toString(temp);
				j--;
			}
			
			yearCombo=new JComboBox<String>(yearArr);
			yearCombo.setBounds(795,190,150,35);
			yearCombo.setEditable(false);
			yearCombo.setRenderer(listRenderer);
			yearCombo.setFont(sufont);
			yearCombo.setForeground(Color.RED);
			
			sul_expiry=new JLabel("Check The Expiry Date ");
			sul_expiry.setFont(sufont);
			sul_expiry.setForeground(Color.YELLOW);
			sul_expiry.setBounds(150,245,400,35);
			
			sutf_expiry=new JTextField();	
			sutf_expiry.setFont(sufont);
			sutf_expiry.setBounds(545,245,400,35);
			sutf_expiry.setForeground(Color.RED);
			sutf_expiry.setEditable(false);
			sutf_expiry.setHorizontalAlignment(JTextField.CENTER);
			
			sul_checkMRP=new JLabel("Check The MRP For Entered Quantity ");
			sul_checkMRP.setFont(sufont);
			sul_checkMRP.setForeground(Color.YELLOW);
			sul_checkMRP.setBounds(150,300,400,35);
			
			sutf_checkMRP=new JTextField();	
			sutf_checkMRP.setFont(sufont);
			sutf_checkMRP.setBounds(545,300,400,35);
			sutf_checkMRP.setForeground(Color.RED);
			sutf_checkMRP.setEditable(false);
			sutf_checkMRP.setHorizontalAlignment(JTextField.CENTER);

			su_submit=new JButton("SUBMIT");
			su_submit.setBounds(495,355,100,35);
			su_submit.setForeground(Color.WHITE);
			su_submit.setBackground(new Color(9,121,38));
			su_submit.setFont(new Font("Bell MT",Font.BOLD,16));
			su_submit.setFocusPainted(false);
			su_submit.setBorderPainted(false);		
		
			supanel=new JPanel();
			supanel.setBounds(30,30,1090,410);
			supanel.setBackground(new Color(0,0,0,170));
			supanel.setLayout(null);
			stockUpdate.add(supanel);
			
			titledborder= BorderFactory.createTitledBorder(compound,"Enter The New Stock Details Here");
			titledborder.setTitleJustification(TitledBorder.CENTER);
			titledborder.setTitleFont(borderfont);
			titledborder.setTitleColor(Color.YELLOW);
			supanel.setBorder(titledborder);
			
			supanel.add(sul_medname);
			supanel.add(sutf_medname);
			supanel.add(sul_batchNo);
			supanel.add(sutf_batchNo);
			supanel.add(sul_noofpac);
			supanel.add(sutf_noofpac);
			supanel.add(sul_mfg);
			supanel.add(monthCombo);
			supanel.add(yearCombo);
			supanel.add(sul_expiry);
			supanel.add(sutf_expiry);
			supanel.add(sul_checkMRP);
			supanel.add(sutf_checkMRP);
			supanel.add(su_submit);
			
			sutf_medname.addKeyListener(new KeyAdapter()
			{
				public void keyTyped(KeyEvent ke) 
				{
					char c=ke.getKeyChar();
					if(c=='\n') {
						medicine ivm=new medicine();
						ivm.med_name=sutf_medname.getText().trim();
						if(!ivm.isValidMedicine())	{
							JOptionPane.showMessageDialog(null,"Entered Medicine name is Invalid");
							sutf_medname.setText("");
							sutf_medname.requestFocus();
						}
						else {
							sutf_batchNo.requestFocus();	
						}
					}
				}
			});
			
			sutf_batchNo.addKeyListener(new KeyAdapter()
			{
				public void keyTyped(KeyEvent ke) 
				{
					char c=ke.getKeyChar();
					if(c=='\n')
						sutf_noofpac.requestFocus();
				}
			});
			
			sutf_noofpac.addKeyListener(new KeyAdapter()
			{
				public void keyTyped(KeyEvent ke) 
				{
					char c=ke.getKeyChar();
					if(c=='\n')
						monthCombo.requestFocus();
				}
			});
			
			sutf_noofpac.addFocusListener(new FocusAdapter()
			{
				public void focusLost(FocusEvent e)
				{
					String med_name=sutf_medname.getText().trim();
					if((med_name.replace(" ","").length())==0)	{
						String ctnp=sutf_noofpac.getText().trim();
						if((ctnp.replace(" ","").length())!=0){
							JOptionPane.showMessageDialog(null,"Enter Medicine name First");
						}
					}
					else{
						try {
							Integer.parseInt(sutf_noofpac.getText());
							String ctnp=sutf_noofpac.getText().trim();
							medicine ivm=new medicine();
							ivm.med_name=med_name;
							if(!ivm.isValidMedicine()) {
								JOptionPane.showMessageDialog(null,"Entered Medicine name is Invalid");
								sutf_medname.setText("");
								sutf_medname.requestFocus();
							}else if((ctnp.replace(" ","").length())!=0) {
								medicine gm=new medicine();
								gm.med_name=med_name;
								LinkedList<medicine> lm=new LinkedList<medicine>();
								lm=gm.getMedInfo();
								ListIterator<medicine> litr=lm.listIterator();
								gm=litr.next();
								
								int noofpac=Integer.parseInt(ctnp);
								double calc_mrp=gm.price_per_unit*(double)(gm.tab_per_packet*noofpac);
								DecimalFormat df=new DecimalFormat("#.##");
								String setvmrp=df.format(calc_mrp);
								sutf_checkMRP.setText(setvmrp);	
								
								int ep=(gm.exp_period)-1;
								int yearsIncr=ep/12;
								int monthIncr=ep%12;
								String tempMonth=(String)monthCombo.getSelectedItem();
								String tempYear=(String)yearCombo.getSelectedItem();
								int intYear=Integer.parseInt(tempYear);
								int crmnt=0;
								for(int i=0;i<12;i++)
								{
									if(tempMonth==monthsArr[i])
									{
										crmnt=i;
									}
								}
								intYear+=yearsIncr;
								if((crmnt+monthIncr)>11)
									intYear++;
								tempMonth=monthsArr[((crmnt+monthIncr)%12)];
								df=new DecimalFormat("#.##");
								String setExp=tempMonth+" "+df.format(intYear);
								sutf_expiry.setText(setExp);
							} 
						}catch (Exception ez) {
							// TODO: handle exception
							JOptionPane.showMessageDialog(null,"The Quantity to add in stock Must be Integer");
							sutf_noofpac.setText("");
							sutf_noofpac.requestFocus();
						}							
					}					
				}
			});
			
			monthCombo.addItemListener(new ItemListener()	{
				public void itemStateChanged(ItemEvent ie)	{	
					String med_name=sutf_medname.getText().trim();
					medicine gm=new medicine();
					gm.med_name=med_name;
					if(med_name.length()>0) {
						LinkedList<medicine> lm=new LinkedList<medicine>();
						lm=gm.getMedInfo();
						ListIterator<medicine> litr=lm.listIterator();
						gm=litr.next();
					}
					int ep=(gm.exp_period)-1;
					
					int yearsIncr=ep/12;
					int monthIncr=ep%12;
					String tempMonth=(String)monthCombo.getSelectedItem();
					String tempYear=(String)yearCombo.getSelectedItem();
					int intYear=Integer.parseInt(tempYear);
					int crmnt=0;
					for(int i=0;i<12;i++)
					{
						if(tempMonth==monthsArr[i])
						{
							crmnt=i;
						}
					}
					intYear+=yearsIncr;
					if((crmnt+monthIncr)>11)
						intYear++;
					tempMonth=monthsArr[((crmnt+monthIncr)%12)];
					DecimalFormat df=new DecimalFormat("#.##");
					String setExp=tempMonth+" "+df.format(intYear);
					sutf_expiry.setText(setExp);
				}
			});
			yearCombo.addItemListener(new ItemListener()
			{
				public void itemStateChanged(ItemEvent ie)
				{
					String med_name=sutf_medname.getText().trim();
					medicine gm=new medicine();
					gm.med_name=med_name;
					if(med_name.length()>0){
						LinkedList<medicine> lm=new LinkedList<medicine>();
						lm=gm.getMedInfo();
						ListIterator<medicine> litr=lm.listIterator();
						gm=litr.next();
					}
					int ep=(gm.exp_period)-1;
					
					int yearsIncr=ep/12;
					int monthIncr=ep%12;
					String tempMonth=(String)monthCombo.getSelectedItem();
					String tempYear=(String)yearCombo.getSelectedItem();
					int intYear=Integer.parseInt(tempYear);
					int crmnt=0;
					for(int i=0;i<12;i++)
					{
						if(tempMonth==monthsArr[i])
						{
							crmnt=i;
						}
					}
					intYear+=yearsIncr;
					if((crmnt+monthIncr)>11)
						intYear++;
					tempMonth=monthsArr[((crmnt+monthIncr)%12)];
					DecimalFormat df=new DecimalFormat("#.##");
					String setExp=tempMonth+" "+df.format(intYear);
					sutf_expiry.setText(setExp);
				}
			});
			su_submit.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent am)
				{
					String med_name=sutf_medname.getText().trim();
					medicine gm=new medicine();
					gm.med_name=med_name;
					LinkedList<medicine> lm=new LinkedList<medicine>();
					lm=gm.getMedInfo();
					ListIterator<medicine> litr=lm.listIterator();
					gm=litr.next();
					int Stock_quantity=gm.tab_per_packet*(Integer.parseInt(sutf_noofpac.getText().trim()));
					String tempMonth=(String)monthCombo.getSelectedItem();
					String tempYear=(String)yearCombo.getSelectedItem();
					int yearsIncr=gm.exp_period/12;
					int monthIncr=gm.exp_period%12;
					int intYear=Integer.parseInt(tempYear);
					int crmnt=0;
					for(int i=0;i<12;i++)
					{
						if(tempMonth==monthsArr[i])
						{
							crmnt=i+1;
						}
					}
					String setMfg=intYear+"-"+crmnt+"-1";
					intYear+=yearsIncr;
					if((crmnt+monthIncr)>12)
						intYear++;
					int expMonth=(crmnt+monthIncr)%12;
					if(expMonth==0)
						expMonth=12;
					String setExp=intYear+"-"+expMonth+"-1";
					
					stock update_stock=new stock();
					update_stock.batch_no=sutf_batchNo.getText().trim().toUpperCase();
					update_stock.med_name=sutf_medname.getText().trim().toUpperCase();
					try {
						update_stock.mfg_dt=new SimpleDateFormat("yyyy-MM-dd").parse(setMfg);
						update_stock.exp_dt=new SimpleDateFormat("yyyy-MM-dd").parse(setExp);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					update_stock.avai_in_stock=Stock_quantity;
					if(update_stock.updateStock()==1)
					{
						JOptionPane.showMessageDialog(null,"Inserted Sucessfully");
						sutf_medname.setText("");
						sutf_batchNo.setText("");
						sutf_noofpac.setText("");
						monthCombo.setSelectedItem(monthsArr[1]);
						yearCombo.setSelectedItem(yearArr[1]);   
						sutf_expiry.setText("");
						sutf_checkMRP.setText("");
					}
				}
			});
	/////////////////////////////Unavailable Tabs//////////////////////////////////////
			JPanel Availability = new JPanel();
			Availability.setLayout(null);
			Availability.setBackground(new Color(193,0,137));
	//////////////////////////////Check Stock//////////////////////////////////////////
			JPanel viewStock=new JPanel();
			viewStock.setLayout(null);
	/////////////////////////////New Medicine Panel////////////////////////////////////
			JTextField amtf_medname,amtf_compname,amtf_notabpac,amtf_packmrp,amtf_expiryperiod;
			JLabel aml_medname,aml_compname,aml_notabpac,aml_medtype,aml_packmrp,aml_expiryperiod,aml_infolebel;
			JButton am_submit;
			Font amfont=new Font("BELL MT",Font.BOLD,20);
			
			JPanel addMedicine = new JPanel();
			addMedicine.setLayout(null);
			addMedicine.setBackground(new Color(193,0,137));
			
			aml_infolebel=new JLabel("Enter The New Medicine Details Here");
			Font amlbl_font=new Font("ALGERIAN",Font.ITALIC,40);
			aml_infolebel.setFont(amlbl_font);
			aml_infolebel.setForeground(Color.RED);
			aml_infolebel.setBounds(190,12,800,50);
			
			aml_medname=new JLabel("Medicine Name ");
			aml_medname.setFont(amfont);
			aml_medname.setForeground(Color.YELLOW);
			aml_medname.setBounds(150,25,400,35);
			
			amtf_medname=new JTextField();	
			amtf_medname.setFont(amfont);
			amtf_medname.setBounds(545,25,400,35);
			amtf_medname.setForeground(Color.RED);
			amtf_medname.setHorizontalAlignment(JTextField.CENTER);
			
			aml_compname=new JLabel("Company Name ");
			aml_compname.setFont(amfont);
			aml_compname.setForeground(Color.YELLOW);
			aml_compname.setBounds(150,80,400,35);
			
			amtf_compname=new JTextField();	
			amtf_compname.setFont(amfont);
			amtf_compname.setBounds(545,80,400,35);
			amtf_compname.setForeground(Color.RED);
			amtf_compname.setHorizontalAlignment(JTextField.CENTER);
			
			aml_notabpac=new JLabel("Number Of Tablets In Each Packet ");
			aml_notabpac.setFont(amfont);
			aml_notabpac.setForeground(Color.YELLOW);
			aml_notabpac.setBounds(150,135,400,35);
			
			amtf_notabpac=new JTextField();	
			amtf_notabpac.setFont(amfont);
			amtf_notabpac.setBounds(545,135,400,35);
			amtf_notabpac.setForeground(Color.RED);
			amtf_notabpac.setHorizontalAlignment(JTextField.CENTER);
			
			aml_medtype=new JLabel("Choose The Type Of Medicine ");
			aml_medtype.setFont(amfont);
			aml_medtype.setForeground(Color.YELLOW);
			aml_medtype.setBounds(150,190,400,35);
			
			ButtonGroup RadioGroup=new ButtonGroup();
			JRadioButton RadioRegular=new JRadioButton("Regular",true);
			RadioRegular.setBounds(590,190,100,35);
			RadioRegular.setFont(borderfont);
			RadioRegular.setBackground(Color.WHITE);
			RadioRegular.setForeground(Color.RED);
			
			JRadioButton RadioH1=new JRadioButton("H1");
			RadioH1.setBounds(795,190,100,35);
			RadioH1.setFont(borderfont);
			RadioH1.setBackground(Color.WHITE);
			RadioH1.setForeground(Color.RED);
			RadioGroup.add(RadioRegular);		
			RadioGroup.add(RadioH1);			
			
			aml_packmrp=new JLabel("MRP Of Single Packet ");
			aml_packmrp.setFont(amfont);
			aml_packmrp.setForeground(Color.YELLOW);
			aml_packmrp.setBounds(150,245,400,35);
			
			amtf_packmrp=new JTextField();	
			amtf_packmrp.setFont(amfont);
			amtf_packmrp.setBounds(545,245,400,35);
			amtf_packmrp.setForeground(Color.RED);
			amtf_packmrp.setHorizontalAlignment(JTextField.CENTER);
			
			aml_expiryperiod=new JLabel("Month Limit For Expiry ");
			aml_expiryperiod.setFont(amfont);
			aml_expiryperiod.setForeground(Color.YELLOW);
			aml_expiryperiod.setBounds(150,300,400,35);
			
			amtf_expiryperiod=new JTextField();	
			amtf_expiryperiod.setFont(amfont);
			amtf_expiryperiod.setBounds(545,300,400,35);
			amtf_expiryperiod.setForeground(Color.RED);
			amtf_expiryperiod.setHorizontalAlignment(JTextField.CENTER);
			
			am_submit=new JButton("SUBMIT");
			am_submit.setBounds(495,355,100,35);
			am_submit.setForeground(Color.WHITE);
			am_submit.setBackground(new Color(9,121,38));
			am_submit.setFont(new Font("Bell MT",Font.BOLD,16));
			am_submit.setFocusPainted(false);
			am_submit.setBorderPainted(false);	

			JButton amvs=new JButton("View Medicines");
			amvs.setBounds(870,363,200,35);
			amvs.setForeground(Color.WHITE);
			amvs.setBackground(new Color(9,121,38));
			amvs.setFont(new Font("Bell MT",Font.BOLD,16));
			amvs.setFocusPainted(false);
			amvs.setBorderPainted(false);
			
			JButton btam=new JButton("Add Medicine");
			btam.setBounds(870,363,200,35);
			btam.setForeground(Color.WHITE);
			btam.setBackground(new Color(9,121,38));
			btam.setFont(new Font("Bell MT",Font.BOLD,16));
			btam.setFocusPainted(false);
			btam.setBorderPainted(false);
			
			JPanel ampanel=new JPanel();
			ampanel.setBounds(30,30,1090,410);
			ampanel.setBackground(new Color(0,0,0,170));
			ampanel.setLayout(null);
			addMedicine.add(ampanel);
			
			JPanel srpanel=new JPanel();
			srpanel.setBounds(30,30,1090,410);
			srpanel.setBackground(new Color(0,0,0,170));
			srpanel.setLayout(null);
			addMedicine.add(srpanel);
			srpanel.setVisible(false);
			
			titledborder= BorderFactory.createTitledBorder(compound,"Enter The New Medicine Details Here");
			titledborder.setTitleJustification(TitledBorder.CENTER);
			titledborder.setTitleFont(borderfont);
			titledborder.setTitleColor(Color.YELLOW);
			ampanel.setBorder(titledborder);
			
			titledborder= BorderFactory.createTitledBorder(compound,"Medicine Details");
			titledborder.setTitleJustification(TitledBorder.CENTER);
			titledborder.setTitleFont(borderfont);
			titledborder.setTitleColor(Color.YELLOW);
			srpanel.setBorder(titledborder);
			
			addMedicine.add(aml_infolebel);
			ampanel.add(aml_medname);
			ampanel.add(amtf_medname);
			ampanel.add(aml_compname);
			ampanel.add(amtf_compname);
			ampanel.add(aml_notabpac);
			ampanel.add(amtf_notabpac);
			ampanel.add(aml_medtype);
			ampanel.add(RadioRegular);
			ampanel.add(RadioH1);
			ampanel.add(aml_packmrp);
			ampanel.add(amtf_packmrp);
			ampanel.add(aml_expiryperiod);
			ampanel.add(amtf_expiryperiod);
			ampanel.add(am_submit);
			ampanel.add(amvs);
			srpanel.add(btam);
			
			amtf_medname.addKeyListener(new KeyAdapter()
			{
				public void keyTyped(KeyEvent ke) 
				{
					char c=ke.getKeyChar();
					if(c=='\n')
						amtf_compname.requestFocus();
				}
			});
			
			amtf_compname.addKeyListener(new KeyAdapter()
			{
				public void keyTyped(KeyEvent ke) 
				{
					char c=ke.getKeyChar();
					if(c=='\n')
						amtf_notabpac.requestFocus();
				}
			});
			
			amtf_notabpac.addKeyListener(new KeyAdapter()
			{
				public void keyTyped(KeyEvent ke) 
				{
					char c=ke.getKeyChar();
					if(c=='\n')
						amtf_packmrp.requestFocus();
				}
			});
			
			amtf_packmrp.addKeyListener(new KeyAdapter()
			{
				public void keyTyped(KeyEvent ke) 
				{
					char c=ke.getKeyChar();
					if(c=='\n')
						amtf_expiryperiod.requestFocus();
				}
			});
			am_submit.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent am)
				{
					medicine add_medicine=new medicine();
					add_medicine.med_name=amtf_medname.getText().trim().toUpperCase();
					add_medicine.comp_name=amtf_compname.getText().trim().toUpperCase();
					add_medicine.tab_per_packet=Integer.parseInt(amtf_notabpac.getText());
					add_medicine.price_per_unit=Double.parseDouble(amtf_packmrp.getText())/(double)add_medicine.tab_per_packet;						
					add_medicine.exp_period=Integer.parseInt(amtf_expiryperiod.getText());
					if(RadioH1.isSelected())
						add_medicine.med_type="H1";
					else
						add_medicine.med_type="Regular";
				
					if(add_medicine.addMedicine()==1)
					{
						JOptionPane.showMessageDialog(null,"Inserted Sucessfully");
						amtf_medname.setText("");
						amtf_compname.setText("");
						amtf_notabpac.setText("");
						amtf_packmrp.setText("");
						amtf_expiryperiod.setText("");
						RadioRegular.setSelected(true);
					}
				}
			});
			amvs.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent vse)
				{		
					ampanel.setVisible(false);
					DefaultTableModel model = new DefaultTableModel();					
					model.addColumn("Medicine Name");
					model.addColumn("Company name");
					model.addColumn("Tabs per Packet");
					model.addColumn("Price per Unit");
					model.addColumn("Expiry Period");
					model.addColumn("Medicine Type");
					LinkedList<medicine> lm=new LinkedList<medicine>();
					medicine gm=new medicine();
					lm=gm.getMedInfo();
					ListIterator<medicine> litr=lm.listIterator();
					while(litr.hasNext())  {
						gm=litr.next();
						model.addRow(new Object[]{gm.med_name,gm.comp_name,gm.tab_per_packet,gm.price_per_unit,gm.exp_period,gm.med_type});
					}
					JTable table = new JTable(model);
					
					int[] columnsWidth = {172,172,172,172,172,172};
					int i = 0;
					for (int width : columnsWidth) 
					{
						TableColumn column = table.getColumnModel().getColumn(i++);
						column.setMinWidth(width);
						column.setMaxWidth(width);
						column.setPreferredWidth(width);
					}
					table.setFont(new Font("Calisto MT",Font.PLAIN,14));
					table.setSelectionBackground(Color.BLUE);
					table.setSelectionForeground(Color.WHITE);
					table.setRowHeight(30);
					table.setShowHorizontalLines(false);
					table.setShowVerticalLines(true);
					table.setAutoscrolls(true);
					
					JTableHeader hdr=table.getTableHeader();
					hdr.setFont(new Font("TIMES NEW ROMAN",Font.ITALIC+Font.ITALIC,14));
					hdr.setForeground(Color.WHITE);
					hdr.setBackground(new Color(130,52,145));
					
					JTextField h1tf = new JTextField();
					h1tf.setEditable(false);
					h1tf.setFont(new Font("TIMES NEW ROMAN",Font.ITALIC+Font.BOLD,13));
					h1tf.setBackground(Color.WHITE);
					h1tf.setForeground(Color.BLUE);
					DefaultCellEditor editor = new DefaultCellEditor(h1tf );
					table.setDefaultEditor(Object.class, editor);
					
					DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
					rightRenderer.setHorizontalAlignment(SwingConstants.CENTER);
					TableModel tableModel = table.getModel();
					DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)table.getTableHeader().getDefaultRenderer();
				    renderer.setHorizontalAlignment(JLabel.CENTER);
					for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++)
					{
						table.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
					}
					
					JScrollPane jsp=new JScrollPane(table);
					jsp.setBounds(20,35,1050,323);
					srpanel.removeAll();
					srpanel.add(jsp);
					srpanel.add(btam);
					srpanel.setVisible(true);
				}
			});	
			btam.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent vse)
				{
					srpanel.setVisible(false);
					ampanel.setVisible(true);
				}
			});
	/////////////////////////////Edit Medicine Panel//////////////////////////////////
			JPanel editPane;		
			JButton em_update,em_delete,emd_delete,emb_update;
			Font emfont=new Font("Bell MT",Font.BOLD,20);
			JTextField emtf_medName,emtf_tabppac,emtf_mrpppac,emtf_expPeriod,emtf_medDel,emtf_batchDel,emtf_batchno,emtf_qty;
			JLabel eml_medName,eml_tabppac,eml_mrpppac,eml_expPeriod,eml_medDel,eml_batchDel,eml_update,eml_delete,eml_batchno,eml_qty;
			
			JPanel editMedicine = new JPanel();
			editMedicine.setLayout(null);
			editMedicine.setBackground(new Color(193,0,137));
			
			eml_update=new JLabel("-: Update The Medicine Information Here :-");
			eml_update.setBounds(350,25,700,30);
			eml_update.setFont(emfont);
			eml_update.setForeground(Color.YELLOW);
			
			eml_medName=new JLabel("Enter Medicine Name                                                 :");
			eml_medName.setBounds(50,65,700,30);
			eml_medName.setFont(emfont);
			eml_medName.setForeground(Color.YELLOW);
			
			emtf_medName=new JTextField();	
			emtf_medName.setFont(emfont);
			emtf_medName.setBounds(690,65,350,30);
			emtf_medName.setForeground(Color.RED);		
			emtf_medName.setHorizontalAlignment(JTextField.CENTER);
			
			eml_tabppac=new JLabel("Tabs per Packet");
			eml_tabppac.setBounds(125,100,300,30);
			eml_tabppac.setFont(emfont);
			eml_tabppac.setForeground(Color.YELLOW);
			
			emtf_tabppac=new JTextField();	
			emtf_tabppac.setFont(emfont);
			emtf_tabppac.setBounds(50,130,300,30);
			emtf_tabppac.setForeground(Color.RED);
			emtf_tabppac.setHorizontalAlignment(JTextField.CENTER);
			
			eml_mrpppac=new JLabel("Packet MRP");
			eml_mrpppac.setBounds(480,100,200,30);
			eml_mrpppac.setFont(emfont);
			eml_mrpppac.setForeground(Color.YELLOW);
			
			emtf_mrpppac=new JTextField();	
			emtf_mrpppac.setFont(emfont);
			emtf_mrpppac.setBounds(395,130,300,30);
			emtf_mrpppac.setForeground(Color.RED);
			emtf_mrpppac.setHorizontalAlignment(JTextField.CENTER);
			
			eml_expPeriod=new JLabel("Expiry Period");
			eml_expPeriod.setBounds(825,100,300,30);
			eml_expPeriod.setFont(emfont);
			eml_expPeriod.setForeground(Color.YELLOW);
			
			emtf_expPeriod=new JTextField();	
			emtf_expPeriod.setFont(emfont);
			emtf_expPeriod.setBounds(740,130,300,30);
			emtf_expPeriod.setForeground(Color.RED);
			emtf_expPeriod.setHorizontalAlignment(JTextField.CENTER);
			
			em_update=new JButton("UPDATE");
			em_update.setBounds(50,170,990,30);
			em_update.setForeground(Color.WHITE);
			em_update.setBackground(new Color(9,121,38));
			em_update.setFont(new Font("Bell MT",Font.BOLD,16));
			em_update.setFocusPainted(false);
			em_update.setBorderPainted(false);	
			
			eml_batchno=new JLabel("Batch No  :");
			eml_batchno.setBounds(50,215,300,30);
			eml_batchno.setFont(emfont);
			eml_batchno.setForeground(Color.YELLOW);
			
			emtf_batchno=new JTextField();	
			emtf_batchno.setFont(emfont);
			emtf_batchno.setBounds(175,215,250,30);
			emtf_batchno.setForeground(Color.RED);
			emtf_batchno.setHorizontalAlignment(JTextField.CENTER);
			
			eml_qty=new JLabel("Quantity  :");
			eml_qty.setBounds(460,215,300,30);
			eml_qty.setFont(emfont);
			eml_qty.setForeground(Color.YELLOW);
			
			emtf_qty=new JTextField();	
			emtf_qty.setFont(emfont);
			emtf_qty.setBounds(575,215,250,30);
			emtf_qty.setForeground(Color.RED);
			emtf_qty.setHorizontalAlignment(JTextField.CENTER);

			emb_update=new JButton("UPDATE");
			emb_update.setBounds(890,215,150,30);
			emb_update.setForeground(Color.WHITE);
			emb_update.setBackground(new Color(9,121,38));
			emb_update.setFont(new Font("Bell MT",Font.BOLD,16));
			emb_update.setFocusPainted(false);
			emb_update.setBorderPainted(false);
			
			eml_delete=new JLabel("-: Delete The Medicine And Batch Here :-");
			eml_delete.setBounds(360,260,700,30);
			eml_delete.setFont(emfont);
			eml_delete.setForeground(Color.YELLOW);
			
			eml_medDel=new JLabel("Medicine Name                               :");
			eml_medDel.setBounds(50,300,355,30);
			eml_medDel.setFont(emfont);
			eml_medDel.setForeground(Color.YELLOW);
			
			emtf_medDel=new JTextField();	
			emtf_medDel.setFont(emfont);
			emtf_medDel.setBounds(395,300,300,30);
			emtf_medDel.setForeground(Color.RED);
			emtf_medDel.setHorizontalAlignment(JTextField.CENTER);
			
			em_delete=new JButton("DELETE");
			em_delete.setBounds(890,300,150,30);
			em_delete.setForeground(Color.WHITE);
			em_delete.setBackground(new Color(9,121,38));
			em_delete.setFont(new Font("Bell MT",Font.BOLD,16));
			em_delete.setFocusPainted(false);
			em_delete.setBorderPainted(false);
			
			eml_batchDel=new JLabel("Batch Number                                 :");
			eml_batchDel.setBounds(50,350,355,30);
			eml_batchDel.setFont(emfont);
			eml_batchDel.setForeground(Color.YELLOW);
			
			emtf_batchDel=new JTextField();	
			emtf_batchDel.setFont(emfont);
			emtf_batchDel.setBounds(395,350,300,30);
			emtf_batchDel.setForeground(Color.RED);		
			emtf_batchDel.setHorizontalAlignment(JTextField.CENTER);
			
			emd_delete=new JButton("DELETE");
			emd_delete.setBounds(890,350,150,30);
			emd_delete.setForeground(Color.WHITE);
			emd_delete.setBackground(new Color(9,121,38));
			emd_delete.setFont(new Font("Bell MT",Font.BOLD,16));
			emd_delete.setFocusPainted(false);
			emd_delete.setBorderPainted(false);
			
			editPane=new JPanel();
			editPane.setBounds(30,30,1090,410);
			editPane.setBackground(new Color(0,0,0,170));
			editPane.setLayout(null);
			
			titledborder= BorderFactory.createTitledBorder(compound,"Update Or Delete Medicine");
			titledborder.setTitleJustification(TitledBorder.CENTER);
			titledborder.setTitleFont(borderfont);
			titledborder.setTitleColor(Color.YELLOW);
			editPane.setBorder(titledborder);
			
			editPane.add(eml_update);
			editPane.add(eml_medName);
			editPane.add(emtf_medName);
			editPane.add(eml_tabppac);
			editPane.add(emtf_tabppac);
			editPane.add(eml_mrpppac);
			editPane.add(emtf_mrpppac);
			editPane.add(eml_expPeriod);
			editPane.add(emtf_expPeriod);
			editPane.add(eml_batchno);
			editPane.add(emtf_batchno);
			editPane.add(eml_qty);
			editPane.add(emtf_qty);
			editPane.add(eml_delete);
			editPane.add(eml_medDel);
			editPane.add(emtf_medDel);
			editPane.add(eml_batchDel);
			editPane.add(emtf_batchDel);		
			editPane.add(em_update);		
			editPane.add(emb_update);		
			editPane.add(em_delete);		
			editPane.add(emd_delete);		
			
			editMedicine.add(editPane);
			em_update.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ue) {
					if((emtf_medName.getText().replace(" ","").length())>0)  {
						medicine m=new medicine();
						m.comp_name=emtf_medName.getText().trim().toUpperCase();
						m.isValidMedicine();
						if(m.isValidMedicine())	{
							JOptionPane.showMessageDialog(null,"Entered Medicine Name is Invalid");
							emtf_medName.setText("");
							emtf_medName.requestFocus();
						}
						else	{
							medicine update_medicine=new medicine();
							update_medicine.med_name=emtf_medName.getText().toUpperCase();
							if((emtf_tabppac.getText().replace(" ","").length())>0)	
								update_medicine.tab_per_packet=Integer.parseInt(emtf_tabppac.getText());
							if((emtf_mrpppac.getText().replace(" ","").length())>0) 					
								update_medicine.price_per_unit=Double.parseDouble(emtf_mrpppac.getText());
							if((emtf_expPeriod.getText().replace(" ","").length())>0)
								update_medicine.exp_period=Integer.parseInt(emtf_expPeriod.getText());
							String clear_fields=update_medicine.updateMedicine();
							if(clear_fields.contains("a")) {
								emtf_tabppac.setText("");
								if(!(clear_fields.contains("b"))&&!(clear_fields.contains("c")))
									emtf_medName.setText("");
							}
							if(clear_fields.contains("b")) {
								emtf_mrpppac.setText("");
								if(!clear_fields.contains("c"))
									emtf_medName.setText("");
							}
							if(clear_fields.contains("c")) {
								emtf_expPeriod.setText("");
								emtf_medName.setText("");
							}
						}
					}
					else
					{
						if((emtf_tabppac.getText().replace(" ","").length())>0)	{
							JOptionPane.showMessageDialog(null,"Enter Medicine Name First");
							emtf_medName.requestFocus();
						}else if((emtf_mrpppac.getText().replace(" ","").length())>0){						
							JOptionPane.showMessageDialog(null,"Enter Medicine Name First");
							emtf_medName.requestFocus();
						} else if((emtf_expPeriod.getText().replace(" ","").length())>0){
							JOptionPane.showMessageDialog(null,"Enter Medicine Name First");
							emtf_medName.requestFocus();
						}
					}
				}
			});
			emb_update.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
					if(emtf_batchno.getText().replace(" ","").trim().length()>0)
					{
						if(emtf_qty.getText().replace(" ","").trim().length()>0)
						{
							stock update_avai_in_stock=new stock();
							update_avai_in_stock.avai_in_stock=Integer.parseInt(emtf_qty.getText());
							update_avai_in_stock.batch_no=emtf_batchno.getText().trim();
							if(update_avai_in_stock.isValidBatch())
							{
								int updated=update_avai_in_stock.updateAvailableInStock();
								if(updated==1)
								{
									JOptionPane.showMessageDialog(null,"Updated Successfully");
									emtf_batchno.setText("");
									emtf_qty.setText("");
								}
							}
							else
							{
								JOptionPane.showMessageDialog(null,"Entered Batch No. is Either Invalid\n or Deleted ");
								emtf_batchno.setText("");
								emtf_qty.setText("");
								emtf_batchno.requestFocus();
							}
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Enter the Quantity");							
							emtf_qty.requestFocus();
						}
					}
					else
					{					
						if(emtf_qty.getText().replace(" ","").trim().length()>0)
						{
							JOptionPane.showMessageDialog(null,"Please Enter Batch No. First");						
							emtf_batchno.requestFocus();
						}
					}					
				}
			});
			em_delete.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent de)
				{
					if((emtf_medDel.getText().replace(" ","").length())>0)
					{
						medicine del_med=new medicine();
						stock s=new stock();
						s.med_name=del_med.med_name=emtf_medDel.getText().trim();
						if(!del_med.isValidMedicine())	{
							JOptionPane.showMessageDialog(null,"Entered Medicine Name is Invalid");
							emtf_medDel.setText("");
							emtf_medDel.requestFocus();
						}
						else {
							if(!s.isMedicineAvailable())
							{
								int deleted=del_med.deleteMedicine();
								if(deleted==1)
								{
									JOptionPane.showMessageDialog(null,"Deleted Successfully");
									emtf_medDel.setText("");
								}
							}
							else
							{
								JOptionPane.showMessageDialog(null,"Anable to Delete\nMedicine Available In Stock");
								emtf_medDel.setText("");
							}
						}
					}
				}
			});
			emd_delete.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent be)
				{
					if((emtf_batchDel.getText().replace(" ","").length())>0) {
						stock delete_batch=new stock();
						delete_batch.batch_no=emtf_batchDel.getText().trim();
						if(!delete_batch.isValidBatch())	{
							JOptionPane.showMessageDialog(null,"Entered Batch Number is Invalid");
							emtf_batchDel.setText("");
							emtf_batchDel.requestFocus();
						}
						else	{
							if(delete_batch.deleteBatch()==1)	{
								JOptionPane.showMessageDialog(null,"Deleted Successfully");
								emtf_batchDel.setText("");
							}
						}
					}
				}
			});
	/////////////////////////////Show Bill Panel//////////////////////////////////////		
			JPanel showBill = new JPanel();
			showBill.setLayout(null);
			showBill.setBackground(new Color(193,0,137));
			////////////////////////////////////////////////////////////////////////////////////
			JPanel sbcustomer_panel,sbpurches_panel;
			JTextField sbtf_custName,sbtf_custAddress,sbtf_doctName,sbtf_billdt,sbtf_custId;
			JLabel sbl_custId,sbl_transactionDate,sbl_custAddress,sbl_custName,sbl_doctName;
			Font sbfont=new Font("TIMES NEW ROMAN",Font.BOLD,14);
			
			sbcustomer_panel=new JPanel();
			sbcustomer_panel.setBounds(20,20,1110,100);
			sbcustomer_panel.setBackground(new Color(0,0,0,170));
			sbcustomer_panel.setLayout(null);		
			
			titledborder= BorderFactory.createTitledBorder(compound,"Patients Details");
			titledborder.setTitleJustification(TitledBorder.CENTER);
			titledborder.setTitleFont(borderfont);
			titledborder.setTitleColor(Color.YELLOW);
			sbcustomer_panel.setBorder(titledborder);
			
			sbl_custId=new JLabel("Bill Number           :");
			sbl_custId.setFont(sbfont);
			sbl_custId.setForeground(Color.YELLOW);
			sbl_custId.setBounds(100,25,250,25);
			
			sbl_transactionDate=new JLabel("Date   :");
			sbl_transactionDate.setFont(sbfont);
			sbl_transactionDate.setForeground(Color.YELLOW);
			sbl_transactionDate.setBounds(340,25,300,25);
			
			sbtf_custId=new JTextField();	
			sbtf_custId.setFont(sbfont);
			sbtf_custId.setBounds(240,25,80,25);
			sbtf_custId.setForeground(Color.RED);
			sbtf_custId.setHorizontalAlignment(JTextField.CENTER);
					
			sbtf_billdt=new JTextField();	
			sbtf_billdt.setFont(sbfont);
			sbtf_billdt.setBounds(404,25,126,25);
			sbtf_billdt.setForeground(Color.RED);
			sbtf_billdt.setEditable(false);
			sbtf_billdt.setHorizontalAlignment(JTextField.CENTER);
			
			sbl_custName=new JLabel("Patients Name        : ");
			sbl_custName.setFont(sbfont);
			sbl_custName.setForeground(Color.YELLOW);
			sbl_custName.setBounds(100,62,200,25);
			sbl_custName.setHorizontalAlignment(JTextField.LEFT);
			
			sbtf_custName=new JTextField();	
			sbtf_custName.setFont(sbfont);
			sbtf_custName.setBounds(240,62,290,25);
			sbtf_custName.setForeground(Color.RED);
			sbtf_custName.setEditable(false);
			
			sbl_doctName=new JLabel("Doctor Name   : ");
			sbl_doctName.setFont(sbfont);
			sbl_doctName.setForeground(Color.YELLOW);
			sbl_doctName.setBounds(605,25,200,25);
			
			sbtf_doctName=new JTextField();	
			sbtf_doctName.setFont(sbfont);
			sbtf_doctName.setBounds(735,25,250,25);
			sbtf_doctName.setForeground(Color.RED);
			sbtf_doctName.setEditable(false);
			
			sbl_custAddress=new JLabel("Address          : ");
			sbl_custAddress.setFont(sbfont);
			sbl_custAddress.setForeground(Color.YELLOW);
			sbl_custAddress.setBounds(605,62,200,25);
			
			sbtf_custAddress=new JTextField();	
			sbtf_custAddress.setFont(sbfont);
			sbtf_custAddress.setBounds(735,62,250,25);
			sbtf_custAddress.setForeground(Color.RED);
			sbtf_custAddress.setEditable(false);
			
			sbcustomer_panel.add(sbl_custId);
			sbcustomer_panel.add(sbtf_custId);
			sbcustomer_panel.add(sbtf_billdt);
			sbcustomer_panel.add(sbl_custName);
			sbcustomer_panel.add(sbtf_custName);
			sbcustomer_panel.add(sbl_transactionDate);
			sbcustomer_panel.add(sbl_doctName);
			sbcustomer_panel.add(sbtf_doctName);
			sbcustomer_panel.add(sbl_custAddress);
			sbcustomer_panel.add(sbtf_custAddress);
			///////////////////////////////////////////////////////////////	
			JLabel sbl_totalAmt=new JLabel("Total Bill Amount : ");
			sbl_totalAmt.setFont(sbfont);
			sbl_totalAmt.setForeground(Color.YELLOW);
			sbl_totalAmt.setBounds(770,285,200,25);
			
			JTextField sbtfTotal=new JTextField();
			sbtfTotal.setFont(sbfont);
			sbtfTotal.setBounds(960,280,130,25);
			sbtfTotal.setForeground(Color.RED);
			sbtfTotal.setEditable(false);
			sbtfTotal.setHorizontalAlignment(JTextField.RIGHT);
			
			sbpurches_panel=new JPanel();
			sbpurches_panel.setBounds(20,120,1110,335);
			sbpurches_panel.setBackground(new Color(0,0,0,170));
			sbpurches_panel.setLayout(null);
			
			titledborder= BorderFactory.createTitledBorder(compound,"Purchase Details");
			titledborder.setTitleJustification(TitledBorder.CENTER);
			titledborder.setTitleFont(borderfont);
			titledborder.setTitleColor(Color.YELLOW);
			sbpurches_panel.setBorder(titledborder);
			
			JButton sb_view = new JButton("View");
			sb_view.setBounds(505,280,100,35);
			sb_view.setForeground(Color.WHITE);
			sb_view.setBackground(new Color(9,121,38));
			sb_view.setFont(new Font("Bell MT",Font.BOLD,16));
			sb_view.setFocusPainted(false);
			sb_view.setBorderPainted(false);
			
			sbpurches_panel.add(sbl_totalAmt);
			sbpurches_panel.add(sbtfTotal);
			sbpurches_panel.add(sb_view);
			///////////////////////////////////////////////////////////////
			sbtf_custId.addKeyListener(new KeyAdapter()
			{
				public void keyTyped(KeyEvent ke) 
				{
					char c=ke.getKeyChar();
					if(c=='\n')
						sbtf_billdt.requestFocus();
				}
			});
			showBill.add(sbcustomer_panel);
			showBill.add(sbpurches_panel);
			
			sb_view.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent be)
				{
					if((sbtf_custId.getText().replace(" ","").length())!=0)
					{
						customer cust_record=new customer();
						cust_record.bill_no=Integer.parseInt(sbtf_custId.getText());
						if(!cust_record.isValidCustomer())
						{
							JOptionPane.showMessageDialog(null,"Entered Bill No is Invalid");
						}
						else
						{
							LinkedList<customer> l=cust_record.getCustomer();
							ListIterator<customer> li=l.listIterator();
							cust_record=(customer) li.next();
							sbtf_custName.setText(cust_record.cust_name);
							sbtf_doctName.setText(cust_record.doct_name);
							sbtf_custAddress.setText(cust_record.cust_addr);
							SimpleDateFormat bdf=new SimpleDateFormat("dd-MM-yyyy");
							sbtf_billdt.setText(bdf.format(cust_record.bill_dt));
							sbtfTotal.setText(Double.toString(cust_record.bill_amt));
							
							DefaultTableModel model = new DefaultTableModel();
							model.addColumn("Batch No");
							model.addColumn("Medicine Name");
							model.addColumn("Company Name");
							model.addColumn("Mfg Date");
							model.addColumn("Expiry Date");
							model.addColumn("Quantity");
							model.addColumn("MRP");
							
							transaction gt=new transaction();
							gt.bill_no=Integer.parseInt(sbtf_custId.getText());
							LinkedList<transaction> lt=gt.getBillTransaction();
							ListIterator<transaction> litr=lt.listIterator();
							for(int i=0;i<7;++i)
							{
								if(litr.hasNext()) {
									gt=(transaction)litr.next();
									model.addRow(new Object[]{gt.batch,gt.med_name,gt.comp_name,gt.mfg_dt,gt.exp_dt,gt.quantity,gt.tab_bill});
								}
								else
								{
									model.addRow(new Object[]{" "," "," "," "," "," "});
								}
							}
							JTable table = new JTable(model);
							
							int[] columnsWidth = {110,220,220,145,145,90,140};
							int i = 0;
							for (int width : columnsWidth) 
							{
								TableColumn column = table.getColumnModel().getColumn(i++);
								column.setMinWidth(width);
								column.setMaxWidth(width);
								column.setPreferredWidth(width);
							}
							table.setFont(new Font("Calisto MT",Font.PLAIN,14));
							table.setSelectionBackground(Color.BLUE);
							table.setSelectionForeground(Color.WHITE);
							table.setRowHeight(30);
							table.setShowHorizontalLines(false);
							table.setShowVerticalLines(false);
							table.setAutoscrolls(true);
							
							JTableHeader hdr=table.getTableHeader();
							hdr.setFont(new Font("Trebuchet MS (Headings)",Font.ITALIC,18));
							hdr.setForeground(Color.WHITE);
							hdr.setBackground(new Color(130,52,145));
							
							JTextField sbtf = new JTextField();
							sbtf.setEditable(false);
							sbtf.setFont(new Font("TIMES NEW ROMAN",Font.ITALIC,13));
							sbtf.setBackground(Color.WHITE);
							sbtf.setForeground(Color.BLUE);
							DefaultCellEditor editor = new DefaultCellEditor(sbtf );
							table.setDefaultEditor(Object.class, editor);
							
							DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
							rightRenderer.setHorizontalAlignment(SwingConstants.CENTER);
							TableModel tableModel = table.getModel();
							DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)table.getTableHeader().getDefaultRenderer();
						    renderer.setHorizontalAlignment(JLabel.CENTER);
							for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++)
							{
								table.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
							}
							
							JScrollPane jsp=new JScrollPane(table);
							jsp.setBounds(20,32,1070,242);
							sbpurches_panel.remove(jsp);
							jsp.setBackground(Color.red);
							jsp.setForeground(Color.red);
							sbpurches_panel.add(jsp);
						}
					}
				}
			});
	///////////////////////////////All Transaction/////////////////////////////////
			JPanel transactionHistory=new JPanel();
			transactionHistory.setLayout(null);
	///////////////////////////////H1 Records//////////////////////////////////////
			JPanel h1Record=new JPanel();
			h1Record.setLayout(null);
	////////////////////////////JTabbedPane started Here///////////////////////////
			JTabbedPane jtbp = new JTabbedPane();
			jtbp.setBounds(50,50,1150,500);
			jtbp.setForeground(Color.RED);
			jtbp.setBackground(Color.YELLOW);
			jtbp.setOpaque(true);
			jtbp.setFont(new Font("Bell MT",Font.BOLD,17));
			
			jtbp.addChangeListener(new ChangeListener() 
			{
				public void stateChanged(ChangeEvent e) 
				{
					Font borderFont;
					TitledBorder titledBorder;
					Border raisedBevel, loweredBevel, redLine,Compound;
					
					if(jtbp.getSelectedIndex()==0)
					{
						nrtf_custName.requestFocus();
					}
					if(jtbp.getSelectedIndex()==1)
					{
						sutf_medname.requestFocus();
					}
					if(jtbp.getSelectedIndex()==2)
					{
						try
						{
							Availability.removeAll();						
					//////////////////////////////////////////////////////////////////////////////////////////////////	
							borderFont=new Font("BELL MT",Font.BOLD,20);
							raisedBevel = BorderFactory.createRaisedBevelBorder();
							loweredBevel = BorderFactory.createLoweredBevelBorder();
							redLine = BorderFactory.createMatteBorder(3, 12, 3, 6, new Color(55,215,132));
							Compound = BorderFactory.createCompoundBorder(raisedBevel, loweredBevel);
							Compound = BorderFactory.createCompoundBorder(redLine, Compound);				
							titledBorder= BorderFactory.createTitledBorder(Compound,"Out Of Stock");
							titledBorder.setTitleJustification(TitledBorder.CENTER);
							titledBorder.setTitleFont(borderFont);
							titledBorder.setTitleColor(Color.YELLOW);
							
							medicine gm=new medicine();
							LinkedList<medicine> lm=new LinkedList<medicine>();
							lm=gm.getMedInfo();
							ListIterator<medicine> litr=lm.listIterator();
							
							stock gst=new stock();
							LinkedList<stock> lgst=new LinkedList<stock>();
							lgst=gst.getStockDetails();
							ListIterator<stock> litr_gst=lgst.listIterator();
							
							LinkedList<String> unavailable_med=new LinkedList<String>();
							while(litr.hasNext())	{
								gm=litr.next();
								while(litr_gst.hasPrevious())
									litr_gst.previous();
								int flag=0;
								while(litr_gst.hasNext()) {
									gst=litr_gst.next();
									if(gm.med_name.equals(gst.med_name))	{
										flag=1;
										break;
									}
								}
								if(flag==0)	{
									unavailable_med.add(gm.med_name);
								}
							}
							DefaultTableModel modelOot = new DefaultTableModel();
							modelOot.addColumn("Medicine Name");
							ListIterator<String> litr_med=unavailable_med.listIterator();
							while(litr_med.hasNext()) {
								modelOot.addRow(new Object[]{litr_med.next()});
							}
							JTable tableOot= new JTable(modelOot);
							
							int[] columnsWidtho = {190};
							int io = 0;
							for (int width : columnsWidtho) 
							{
								TableColumn column = tableOot.getColumnModel().getColumn(io++);
								column.setMinWidth(width);
								column.setMaxWidth(width);
								column.setPreferredWidth(width);
							}
							tableOot.setFont(new Font("Calisto MT",Font.PLAIN,14));
							tableOot.setSelectionBackground(Color.BLUE);
							tableOot.setSelectionForeground(Color.WHITE);
							tableOot.setRowHeight(30);
							tableOot.setShowHorizontalLines(false);
							tableOot.setShowVerticalLines(false);
							tableOot.setAutoscrolls(true);
							
							JTableHeader hdro=tableOot.getTableHeader();
							hdro.setFont(new Font("Trebuchet MS (Headings)",Font.ITALIC,18));
							hdro.setForeground(Color.WHITE);
							hdro.setBackground(new Color(130,52,145));
							
							JTextField uttfo = new JTextField();
							uttfo.setEditable(false);
							uttfo.setFont(new Font("TIMES NEW ROMAN",Font.ITALIC,13));
							uttfo.setBackground(Color.WHITE);
							uttfo.setForeground(Color.BLUE);
							DefaultCellEditor editoro = new DefaultCellEditor(uttfo );
							tableOot.setDefaultEditor(Object.class, editoro);
							
							DefaultTableCellRenderer rightRenderero = new DefaultTableCellRenderer();
							rightRenderero.setHorizontalAlignment(SwingConstants.CENTER);
							TableModel tableModelo = tableOot.getModel();
							DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)tableOot.getTableHeader().getDefaultRenderer();
						    renderer.setHorizontalAlignment(JLabel.CENTER);
							for (int columnIndexo = 0; columnIndexo < tableModelo.getColumnCount(); columnIndexo++)
							{
								tableOot.getColumnModel().getColumn(columnIndexo).setCellRenderer(rightRenderero);
							}
							
							JScrollPane jspOot=new JScrollPane(tableOot);
							jspOot.setBounds(3,10,224,450);						
							jspOot.setForeground(Color.BLACK);						
							jspOot.setBackground(Color.BLACK);						
							jspOot.setBorder(titledBorder);
							Availability.add(jspOot);
				////////////////////////////////////////////////////////////////////////////////////////////////////////
							borderFont=new Font("BELL MT",Font.BOLD,20);
							raisedBevel = BorderFactory.createRaisedBevelBorder();
							loweredBevel = BorderFactory.createLoweredBevelBorder();
							redLine = BorderFactory.createMatteBorder(3, 6, 3, 6,Color.red);
							Compound = BorderFactory.createCompoundBorder(raisedBevel, loweredBevel);
							Compound = BorderFactory.createCompoundBorder(redLine, Compound);				
							titledBorder= BorderFactory.createTitledBorder(Compound,"Less Available");
							titledBorder.setTitleJustification(TitledBorder.CENTER);
							titledBorder.setTitleFont(borderFont);
							titledBorder.setTitleColor(Color.YELLOW);
							DefaultTableModel modelLa = new DefaultTableModel();
							modelLa.addColumn("Medicine Name");
							modelLa.addColumn("Quantity");
							while(litr_gst.hasPrevious())
								litr_gst.previous();
							while(litr_gst.hasNext())	{
								gst=litr_gst.next();
								if(!(gst.avai_in_stock>20))
									modelLa.addRow(new Object[]{gst.med_name,Integer.toString(gst.avai_in_stock)});
							}
							JTable tableLa = new JTable(modelLa);
							
							int[] columnsWidth = {200,108};
							int li = 0;
							for (int width : columnsWidth) 
							{
								TableColumn column = tableLa.getColumnModel().getColumn(li++);
								column.setMinWidth(width);
								column.setMaxWidth(width);
								column.setPreferredWidth(width);
							}
							tableLa.setFont(new Font("Calisto MT",Font.PLAIN,14));
							tableLa.setSelectionBackground(Color.BLUE);
							tableLa.setSelectionForeground(Color.WHITE);
							tableLa.setRowHeight(30);
							tableLa.setShowHorizontalLines(false);
							tableLa.setShowVerticalLines(false);
							tableLa.setAutoscrolls(true);
							
							JTableHeader hdrl=tableLa.getTableHeader();
							hdrl.setFont(new Font("Trebuchet MS (Headings)",Font.ITALIC,18));
							hdrl.setForeground(Color.WHITE);
							hdrl.setBackground(new Color(130,52,145));
							
							JTextField uttfla = new JTextField();
							uttfla.setEditable(false);
							uttfla.setFont(new Font("TIMES NEW ROMAN",Font.ITALIC,13));
							uttfla.setBackground(Color.WHITE);
							uttfla.setForeground(Color.BLUE);
							DefaultCellEditor editoar = new DefaultCellEditor(uttfla );
							tableLa.setDefaultEditor(Object.class, editoar);
							
							DefaultTableCellRenderer rightRendererLa = new DefaultTableCellRenderer();
							rightRendererLa.setHorizontalAlignment(SwingConstants.CENTER);
							TableModel tableLaModel = tableLa.getModel();
							DefaultTableCellRenderer renderer1 = (DefaultTableCellRenderer)tableLa.getTableHeader().getDefaultRenderer();
						    renderer1.setHorizontalAlignment(JLabel.CENTER);
							for (int columnIndexa= 0; columnIndexa < tableLaModel.getColumnCount(); columnIndexa++)
							{
								tableLa.getColumnModel().getColumn(columnIndexa).setCellRenderer(rightRendererLa);
							}
							JScrollPane jspLa=new JScrollPane(tableLa);
							jspLa.setBounds(227,10,337,450);
							jspLa.setForeground(Color.BLACK);						
							jspLa.setBackground(Color.BLACK);						
							jspLa.setBorder(titledBorder);
							Availability.add(jspLa);
				//////////////////////////////////////////////////////////////////////////////////////////////////////////
							borderFont=new Font("BELL MT",Font.BOLD,20);
							raisedBevel = BorderFactory.createRaisedBevelBorder();
							loweredBevel = BorderFactory.createLoweredBevelBorder();
							redLine = BorderFactory.createMatteBorder(3, 6, 3, 12, new Color(55,215,132));
							Compound = BorderFactory.createCompoundBorder(raisedBevel, loweredBevel);
							Compound = BorderFactory.createCompoundBorder(redLine, Compound);				
							titledBorder= BorderFactory.createTitledBorder(Compound,"Near to Expiry");
							titledBorder.setTitleJustification(TitledBorder.CENTER);
							titledBorder.setTitleFont(borderFont);
							titledBorder.setTitleColor(Color.YELLOW);
							Calendar calendar=new GregorianCalendar();
							int month=calendar.get(Calendar.MONTH);
							int year=calendar.get(Calendar.YEAR);
							month+=3;
							if(month>11)
							{
								++year;
								if(month==12)
									month=0;
								else if(month==13)
									month=1;
								else if(month==14)
									month=2;
							}
							String Strdt=year+"-"+month+"-"+1;

							DefaultTableModel modelExp = new DefaultTableModel();
							modelExp.addColumn("Batch");;
							modelExp.addColumn("Medicine Name");
							modelExp.addColumn("Expiry");
							SimpleDateFormat edf=new SimpleDateFormat("MMM yyyy");
							while(litr_gst.hasPrevious())
								litr_gst.previous();
							while(litr_gst.hasNext())	{
								gst=litr_gst.next();
								if(gst.exp_dt.compareTo(new SimpleDateFormat("yyyy-MM-dd").parse(Strdt))<0)							
									modelExp.addRow(new Object[]{gst.batch_no,gst.med_name,edf.format(gst.exp_dt)});
							}
							JTable tableExp = new JTable(modelExp);
							
							int[] columnsWidthExp = {150,245,150};
							int ei = 0;

							for (int width : columnsWidthExp) 
							{
								TableColumn column = tableExp.getColumnModel().getColumn(ei++);
								column.setMinWidth(width);
								column.setMaxWidth(width);
								column.setPreferredWidth(width);
							}
							tableExp.setFont(new Font("Calisto MT",Font.PLAIN,14));
							tableExp.setSelectionBackground(Color.BLUE);
							tableExp.setSelectionForeground(Color.WHITE);
							tableExp.setRowHeight(30);
							tableExp.setShowHorizontalLines(false);
							tableExp.setShowVerticalLines(false);
							tableExp.setAutoscrolls(true);
							
							JTableHeader hdrExp=tableExp.getTableHeader();
							hdrExp.setFont(new Font("Trebuchet MS (Headings)",Font.ITALIC,18));
							hdrExp.setForeground(Color.WHITE);
							hdrExp.setBackground(new Color(130,52,145));
							
							JTextField uttfExp = new JTextField();
							uttfExp.setEditable(false);
							uttfExp.setFont(new Font("TIMES NEW ROMAN",Font.ITALIC,13));
							uttfExp.setBackground(Color.WHITE);
							uttfExp.setForeground(Color.BLUE);
							DefaultCellEditor editorExp = new DefaultCellEditor(uttfExp );
							tableExp.setDefaultEditor(Object.class, editorExp);
							
							DefaultTableCellRenderer rightRendererExp = new DefaultTableCellRenderer();
							rightRendererExp.setHorizontalAlignment(SwingConstants.CENTER);
							TableModel tableExpModel = tableExp.getModel();
							DefaultTableCellRenderer renderer11 = (DefaultTableCellRenderer)tableExp.getTableHeader().getDefaultRenderer();
						    renderer11.setHorizontalAlignment(JLabel.CENTER);
							for (int columnIndex = 0; columnIndex < tableExpModel.getColumnCount(); columnIndex++)
							{
								tableExp.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRendererExp);
							}
							
							JScrollPane jspExp=new JScrollPane(tableExp);
							jspExp.setBounds(564,10,580,450);
							jspExp.setForeground(Color.BLACK);						
							jspExp.setBackground(Color.BLACK);						
							jspExp.setBorder(titledBorder);
							Availability.add(jspExp);
						}
						catch(Exception vsut)
						{
							vsut.printStackTrace();
						}
					}
					if(jtbp.getSelectedIndex()==3)
					{
						SimpleDateFormat ddf=new SimpleDateFormat("MMM yyyy");							
						DefaultTableModel model = new DefaultTableModel();
						model.addColumn("Medicine Name");
						model.addColumn("Company");
						model.addColumn("Batch");
						model.addColumn("MFG");
						model.addColumn("Expiry");
						model.addColumn("Available Quantity");
						
						stock rst=new stock();
						LinkedList<stock> lm=new LinkedList<stock>();
						lm=rst.getStockDetails();
						ListIterator<stock> litr=lm.listIterator();
						while(litr.hasNext())	{
							rst=litr.next();
							model.addRow(new Object[]{rst.med_name,rst.comp_name,rst.batch_no,ddf.format(rst.mfg_dt),ddf.format(rst.exp_dt),Integer.toString(rst.avai_in_stock)});
						}
						JTable table = new JTable(model);
						
						int[] columnsWidth = {191,191,191,191,191,191};
						int i = 0;
						
						for (int width : columnsWidth) 
						{
							TableColumn column = table.getColumnModel().getColumn(i++);
							column.setMinWidth(width);
							column.setMaxWidth(width);
							column.setPreferredWidth(width);
						}
						table.setFont(new Font("Calisto MT",Font.PLAIN,14));
						table.setSelectionBackground(Color.BLUE);
						table.setSelectionForeground(Color.WHITE);
						table.setRowHeight(30);
						table.setShowHorizontalLines(false);
						table.setShowVerticalLines(false);
						table.setAutoscrolls(true);
						
						JTableHeader hdr=table.getTableHeader();
						hdr.setFont(new Font("Trebuchet MS (Headings)",Font.ITALIC,18));
						hdr.setForeground(Color.WHITE);
						hdr.setBackground(new Color(130,52,145));
						
						JTextField svtf = new JTextField();
						svtf.setEditable(false);
						svtf.setFont(new Font("TIMES NEW ROMAN",Font.ITALIC,13));
						svtf.setBackground(Color.WHITE);
						svtf.setForeground(Color.BLUE);
						DefaultCellEditor editor = new DefaultCellEditor(svtf );
						table.setDefaultEditor(Object.class, editor);
						
						DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
						rightRenderer.setHorizontalAlignment(SwingConstants.CENTER);
						TableModel tableModel = table.getModel();
						DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)table.getTableHeader().getDefaultRenderer();
					    renderer.setHorizontalAlignment(JLabel.CENTER);
						for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++)
						{
							table.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
						}
						
						JScrollPane jsp=new JScrollPane(table);
						jsp.setBounds(0,0,1150,470);
						viewStock.removeAll();
						viewStock.add(jsp);
					}
					if(jtbp.getSelectedIndex()==7)
					{
						DefaultTableModel model = new DefaultTableModel();
						model.addColumn("Bill \n No");
						model.addColumn("Patients Name");
						model.addColumn("Address");
						model.addColumn("Doctor Name,Address");
						model.addColumn("Bill Date");
						model.addColumn("Bill Amount");
						customer cust_rec=new customer();
						LinkedList<customer> l=cust_rec.getCustomer();
						ListIterator<customer> li=l.listIterator();
						while(li.hasNext()) {
							cust_rec=(customer)li.next();
							model.addRow(new Object[]{Integer.toString(cust_rec.bill_no),cust_rec.cust_name,cust_rec.cust_addr,cust_rec.doct_name,new SimpleDateFormat("dd MMM yyyy").format(cust_rec.bill_dt),Double.toString(cust_rec.bill_amt)});
						}
						JTable table = new JTable(model);
						
						int[] columnsWidth = {100,320,180,320,100,130};
						int i = 0;

						
						for (int width : columnsWidth) 
						{
							TableColumn column = table.getColumnModel().getColumn(i++);
							column.setMinWidth(width);
							column.setMaxWidth(width);
							column.setPreferredWidth(width);
						}
						table.setFont(new Font("Calisto MT",Font.PLAIN,14));
						table.setSelectionBackground(Color.BLUE);
						table.setSelectionForeground(Color.WHITE);
						table.setRowHeight(30);
						table.setShowHorizontalLines(false);
						table.setShowVerticalLines(false);
						table.setAutoscrolls(true);
						
						JTableHeader hdr=table.getTableHeader();
						hdr.setFont(new Font("TIMES NEW ROMAN",Font.ITALIC+Font.ITALIC,18));
						hdr.setForeground(Color.WHITE);
						hdr.setBackground(new Color(130,52,145));
						
						JTextField tttf = new JTextField();
						tttf.setEditable(false);
						tttf.setFont(new Font("TIMES NEW ROMAN",Font.ITALIC+Font.BOLD,13));
						tttf.setBackground(Color.WHITE);
						tttf.setForeground(Color.BLUE);
						DefaultCellEditor editor = new DefaultCellEditor(tttf );
						table.setDefaultEditor(Object.class, editor);
						
						DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
						rightRenderer.setHorizontalAlignment(SwingConstants.CENTER);
						TableModel tableModel = table.getModel();
						DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)table.getTableHeader().getDefaultRenderer();
					    renderer.setHorizontalAlignment(JLabel.CENTER);
						for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++)
						{
							table.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
						}
						
						JScrollPane jsp=new JScrollPane(table);
						jsp.setBounds(0,0,1150,470);
						transactionHistory.removeAll();
						transactionHistory.add(jsp);
					}
					if(jtbp.getSelectedIndex()==8)
					{
						DefaultTableModel model = new DefaultTableModel();
						model.addColumn("Sr. No.");
						model.addColumn("bill No");
						model.addColumn("Bill Date");
						model.addColumn("Doctor_name");
						model.addColumn("Patients Name");
						model.addColumn("Patients Address");						
						model.addColumn("Medicine Name");
						model.addColumn("Batch");
						model.addColumn("Expiry");
						model.addColumn("Quantity");
						model.addColumn("Available Quantity");
						LinkedList<h1_record> lt=new LinkedList<h1_record>();
						h1_record gt=new h1_record();
						lt=gt.getH1Records();
						ListIterator<h1_record> litr=lt.listIterator();
						while(litr.hasNext()) {
							gt=litr.next();
							model.addRow(new Object[]{gt.sr_no,gt.bill_no,gt.bill_dt,gt.doct_name,gt.cust_name,gt.cust_addr,gt.med_name,gt.batch,new SimpleDateFormat("MMM yyyy").format(gt.exp_dt),gt.quantity,gt.qty_in_stock});
						}
						JTable table = new JTable(model);
						
						int[] columnsWidth = {50,50,90,160,180,180,180,80,80,40,40};
						int i = 0;

						for (int width : columnsWidth) 
						{
							TableColumn column = table.getColumnModel().getColumn(i++);
							column.setMinWidth(width);
							column.setMaxWidth(width);
							column.setPreferredWidth(width);
						}
						table.setFont(new Font("Calisto MT",Font.PLAIN,12));
						table.setSelectionBackground(Color.BLUE);
						table.setSelectionForeground(Color.WHITE);
						table.setRowHeight(30);
						table.setShowHorizontalLines(false);
						table.setShowVerticalLines(false);
						table.setAutoscrolls(true);
						
						JTableHeader hdr=table.getTableHeader();
						hdr.setFont(new Font("TIMES NEW ROMAN",Font.ITALIC+Font.ITALIC,14));
						hdr.setForeground(Color.WHITE);
						hdr.setBackground(new Color(130,52,145));
						
						JTextField h1tf = new JTextField();
						h1tf.setEditable(false);
						h1tf.setFont(new Font("TIMES NEW ROMAN",Font.ITALIC+Font.BOLD,13));
						h1tf.setBackground(Color.WHITE);
						h1tf.setForeground(Color.BLUE);
						DefaultCellEditor editor = new DefaultCellEditor(h1tf );
						table.setDefaultEditor(Object.class, editor);
						
						DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
						rightRenderer.setHorizontalAlignment(SwingConstants.CENTER);
						TableModel tableModel = table.getModel();
						DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)table.getTableHeader().getDefaultRenderer();
					    renderer.setHorizontalAlignment(JLabel.CENTER);
						for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++)
						{
							table.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
						}
						
						JScrollPane jsp=new JScrollPane(table);
						jsp.setBounds(0,0,1150,470);
						h1Record.removeAll();
						h1Record.add(jsp);
					}
				}
			});
			
			jtbp.add("New Record",newRecord);
			jtbp.add("Stock Update",stockUpdate);
			jtbp.add("Unavailable Tab",Availability);
			jtbp.add("Check Stock",viewStock);
			jtbp.add("Insert Tablet",addMedicine);
			jtbp.add("Edit Medicine",editMedicine);
			jtbp.add("View Bill",showBill);
			jtbp.add("Transaction History",transactionHistory);
			jtbp.add("H1 Records",h1Record);
			
			ContainerPanel.add(jtbp);
			
			JButton logout=new JButton("LOGOUT");
			logout.setBounds(1100,550,150,50);
			logout.setForeground(Color.WHITE);
			logout.setBackground(new Color(9,121,38));
			logout.setFont(new Font("Bell MT",Font.BOLD,16));
			logout.setFocusPainted(false);
			logout.setBorderPainted(false);
			
			logout.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					try
					{
						mainframe.setVisible(false);
						loginFrame();
					}
					catch(Exception ae)
					{
						ae.printStackTrace();
					}
				}
			});
			ContainerPanel.add(logout);
			mainframe.add(ContainerPanel);
			mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			mainframe.setVisible(true);
		}
		public void loginFrame()	{
			JFrame loginframe;
			JLabel id,password,lfbg_label;
			JTextField tf_id;
			JPasswordField pf_pwd;
			JButton LoginButton;
			int fh,fw;
			
			loginframe=new JFrame("Login Here");
			loginframe.setExtendedState(JFrame.MAXIMIZED_BOTH);			
			fh=744;
			fw=1382;
			loginframe.setIconImage(Toolkit.getDefaultToolkit().getImage(MedicalShop.class.getResource("/image/login.png")));
			
			UIManager.put("nimbusBase", new Color(185,105,201));
			UIManager.put("nimbusBlueGrey", new Color(130,52,145));
			UIManager.put("control", new Color(185,105,201));
			UIManager.put("Button.opaque",true);
			UIManager.put("OptionPane.foreground",new Color(144,244,156));
			UIManager.put("Button.setMargins",new Insets(0,0,0,0));
			UIManager.put("RadioButton.opaque",true);
			UIManager.put("Table.alternateRowColor", new Color(190,214,188));
			UIManager.put("Table.alternaterowcolor", new Color(130,52,145));
			UIManager.put("nimbusBlueGrey", new Color(130,52,145));
			
			try {
			    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
			        if ("Nimbus".equals(info.getName())) {
			            UIManager.setLookAndFeel(info.getClassName());
			            break;
			        }
			    }
			} catch (Exception ex) {
			    // If Nimbus is not available, you can set the GUI to another look and feel.
				ex.printStackTrace();
			}
			
			ImageIcon lfbg_image=new ImageIcon(Toolkit.getDefaultToolkit().getImage(MedicalShop.class.getResource("/image/bg.jpg")));//Setting Background of frame
			Image lfimg=lfbg_image.getImage();
			Image lftemp_img=lfimg.getScaledInstance(fw,fh,Image.SCALE_SMOOTH);
			lfbg_image=new ImageIcon(lftemp_img);
			lfbg_label=new JLabel("",lfbg_image,JLabel.CENTER);
			lfbg_label.setBounds(0,0,0,0);
			loginframe.getContentPane().add(lfbg_label);
			
			JPanel LoginPanel=new JPanel();
			LoginPanel.setBounds((fw/2)-200,(fh/2)-150,400,300);
			LoginPanel.setBackground(new Color(0,0,0,100));
			LoginPanel.setLayout(null);
			
			Font f=new Font("BELL MT",Font.BOLD,20);
			id=new JLabel("Login ID");
			id.setFont(f);
			id.setForeground(Color.YELLOW);
			id.setBounds(160,60,100,20);
			LoginPanel.add(id);
			
			f=new Font("GEORGIA",Font.BOLD,15);
			tf_id=new JTextField();	//Id Textfield
			tf_id.setFont(f);
			tf_id.setBounds(100,85,200,30);
			tf_id.setForeground(Color.RED);
			tf_id.setHorizontalAlignment(JTextField.CENTER);
			LoginPanel.add(tf_id);
		
			
			f=new Font("BELL MT",Font.BOLD,17);
			password=new JLabel("PASSWORD");
			password.setFont(f);
			password.setForeground(Color.YELLOW);
			password.setBounds(153,120,100,30);
			LoginPanel.add(password);
			
			f=new Font("BELL MT",Font.ITALIC,20);
			pf_pwd=new JPasswordField(); //Password PasswordField
			pf_pwd.setBounds(100,145,200,30);
			pf_pwd.setEchoChar('*');
			pf_pwd.setFont(f);
			pf_pwd.setHorizontalAlignment(JTextField.CENTER);
			LoginPanel.add(pf_pwd);		
			
			LoginButton=new JButton("Login");
			LoginButton.setBounds(150,195,100,35);
			LoginButton.setForeground(Color.WHITE);
			LoginButton.setBackground(new Color(9,121,38));
			LoginButton.setFont(new Font("Bell MT",Font.BOLD,16));
			LoginButton.setFocusPainted(false);
			LoginButton.setBorderPainted(false);
			LoginPanel.add(LoginButton);
			
			tf_id.addKeyListener(new KeyAdapter()
			{
				@Override
				public void keyTyped(KeyEvent e) 
				{
					char c=e.getKeyChar();
					if(c=='\n')
						pf_pwd.requestFocus();
				}
			});
			pf_pwd.addKeyListener(new KeyAdapter()
			{
				@Override
				public void keyTyped(KeyEvent e) 
				{
					char c=e.getKeyChar();
					if(c=='\n')
					LoginButton.requestFocus();
				}
			});
			LoginButton.addActionListener(new ActionListener()
			{
				@SuppressWarnings("deprecation")
				public void actionPerformed(ActionEvent a)
				{
					if(tf_id.getText().trim().equals("Dnyaneshwar"))
					{
						if(pf_pwd.getText().trim().equals("7057476985"))
						{
							loginframe.dispose();
							try 
							{
								loginframe.setVisible(false);
								mainFrame();
							}
							catch (Exception e) 
							{
								e.printStackTrace();
							}
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Invalid Id or Password");
							tf_id.setText("");
							pf_pwd.setText("");
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Invalid Id or Password");
						tf_id.setText("");
						pf_pwd.setText("");
					}
				}
			});
			lfbg_label.add(LoginPanel);		
			loginframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			loginframe.setVisible(true);		
		}
		public static void main(String[] args)	{
			try {
				MedicalShop nb=new MedicalShop();
				nb.loginFrame();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

