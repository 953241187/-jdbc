package cn.edu.zucc.waimai.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


import cn.edu.zucc.waimai.comtrol.example.yaoqiu5;

public class FrmMain extends JFrame implements ActionListener {
	
		private JMenuBar menubar=new JMenuBar(); ;
		private JMenu menu_Manager=new JMenu("ϵͳ����");
		private JMenu menu_lend=new JMenu("�û�");
		
		
		private JMenuItem  menuItem_Zhuce=new JMenuItem("ע��");
	    private JMenuItem  menuItem_UserManager=new JMenuItem("�̼ҹ���");
	    private JMenuItem  menuItem_ReaderTypeManager=new JMenuItem("�û�����");
	    private JMenuItem  menuItem_ReaderManager=new JMenuItem("���ֹ���");
	    private JMenuItem  menuItem_PublisherManager=new JMenuItem("��Ʒ��������");
	    private JMenuItem  menuItem_BookManager=new JMenuItem("��Ʒ����");
	    private JMenuItem menuItem_Manjian=new JMenuItem("������������");
	    private JMenuItem menuItem_Youhui=new JMenuItem("�Ż�ȯ����");
	    
	    private JMenuItem  menuItem_Lend=new JMenuItem("��������");
	    private JMenuItem  menuItem_Return=new JMenuItem("��ȡ�Ż�ȯ");
	    private JMenuItem  menuItem_Address=new JMenuItem("���͵�ַ����");
	    private JMenuItem  menuItem_Chongzhi=new JMenuItem("��ֵ��Ա");

		
		
		private FrmLogin dlgLogin=null;
		private JPanel statusBar = new JPanel();
		public FrmMain(){
			this.setExtendedState(Frame.MAXIMIZED_BOTH);
			this.setTitle("��������ϵͳ");
			dlgLogin=new FrmLogin(this,"��½",true);
			dlgLogin.setVisible(true);
		    //�˵�
			 if("����Ա".equals(yaoqiu5.currentUser.getYuangong_name())) {		
//				menu_Manager.add(menuItem_Zhuce);
//				menuItem_Zhuce.addActionListener(this);
		    	menu_Manager.add(menuItem_UserManager);
		    	menuItem_UserManager.addActionListener(this);
		    	menu_Manager.add(menuItem_ReaderTypeManager);
		    	menuItem_ReaderTypeManager.addActionListener(this);
		    	menu_Manager.add(menuItem_ReaderManager);
		    	menuItem_ReaderManager.addActionListener(this);
		    	menu_Manager.add(menuItem_PublisherManager);		    			    	
		    	menuItem_PublisherManager.addActionListener(this);
		    	menu_Manager.add(menuItem_BookManager);
		    	menuItem_BookManager.addActionListener(this);
		    	menubar.add(menu_Manager);
		    	menu_Manager.add(menuItem_Manjian);
		    	menuItem_Manjian.addActionListener(this);
		    	menubar.add(menu_Manager);
		    	menu_Manager.add(menuItem_Youhui);
		    	menuItem_Youhui.addActionListener(this);
		    	menubar.add(menu_Manager);
			 }
			 if("�û�".equals(yaoqiu5.currentUser.getYuangong_name())) {	
		    menu_lend.add(this.menuItem_Lend);
		    menuItem_Lend.addActionListener(this);
		    menu_lend.add(this.menuItem_Return);
		    menuItem_Return.addActionListener(this);
		    menubar.add(menu_lend);
		    menu_lend.add(this.menuItem_Address);
		    menuItem_Address.addActionListener(this);
		    menu_lend.add(this.menuItem_Chongzhi);
		    menuItem_Chongzhi.addActionListener(this);
		    menubar.add(menu_lend);
			 }    
		  
		    this.setJMenuBar(menubar);
		    //״̬��
		    statusBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		    JLabel label=new JLabel("����!"+yaoqiu5.currentUser);
		    statusBar.add(label);
		    this.getContentPane().add(statusBar,BorderLayout.SOUTH);
		    this.addWindowListener(new WindowAdapter(){   
		    	public void windowClosing(WindowEvent e){ 
		    		System.exit(0);
	             }
	        });
		    this.setVisible(true);
		}
	    
	    
		public void actionPerformed(ActionEvent e) {
//			if(e.getSource()==this.menuItem_Zhuce){
//				FrmzhuceManager dlg=new FrmzhuceManager(this,"ע��",true);
//				dlg.setVisible(true);
//			}
			 if(e.getSource()==this.menuItem_UserManager){
				FrmproductorManager dlg=new FrmproductorManager(this,"�̼ҹ���",true);
				dlg.setVisible(true);
			}
			else if(e.getSource()==this.menuItem_ReaderTypeManager){
				FrmuserManager dlg=new FrmuserManager(this,"�û�����",true);
				dlg.setVisible(true);
			}
			else if(e.getSource()==this.menuItem_ReaderManager){
				FrmriderManager dlg=new FrmriderManager(this,"���ֹ���",true);
				dlg.setVisible(true);
			}
			else if(e.getSource()==this.menuItem_Address){
				FrmaddressManager dlg=new FrmaddressManager(this,"���͵�ַ�������",true);
				dlg.setVisible(true);
			}
			else if(e.getSource()==this.menuItem_PublisherManager){
				FrmdingManager dlg=new FrmdingManager(this,"��Ʒ��������",true);
				dlg.setVisible(true);
			}
			else if(e.getSource()==this.menuItem_BookManager){
				FrmproductManager dlg=new FrmproductManager(this,"��Ʒ����",true);
				dlg.setVisible(true);
			}
			else if(e.getSource()==this.menuItem_Manjian){
				FrmManjianManager dlg=new FrmManjianManager(this,"������������",true);
				dlg.setVisible(true);
			}
			else if(e.getSource()==this.menuItem_Youhui){
				FrmyouhuiManager dlg=new FrmyouhuiManager(this,"�Ż�ȯ����",true);
				dlg.setVisible(true);
			}
//			else if(e.getSource()==this.menuItem_Lend){
//				Frmxiadan dlg=new Frmxiadan(this,"��������",true);
//				dlg.setVisible(true);
//			}
			else if(e.getSource()==this.menuItem_Lend){
				FrmdingManager1 dlg=new FrmdingManager1(this,"��Ʒ��������",true);
				dlg.setVisible(true);
			}
			else if(e.getSource()==this.menuItem_Return){
				Frmlingquan dlg=new Frmlingquan(this,"��ȡ�Ż�ȯ",true);
				dlg.setVisible(true);
			}
			else if(e.getSource()==this.menuItem_Chongzhi){
				FrmChongzhi dlg=new FrmChongzhi(this,"ע���Ա",true);
				dlg.setVisible(true);
			}
		}
			
	}