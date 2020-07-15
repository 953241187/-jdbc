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
		private JMenu menu_Manager=new JMenu("系统管理");
		private JMenu menu_lend=new JMenu("用户");
		
		
		private JMenuItem  menuItem_Zhuce=new JMenuItem("注册");
	    private JMenuItem  menuItem_UserManager=new JMenuItem("商家管理");
	    private JMenuItem  menuItem_ReaderTypeManager=new JMenuItem("用户管理");
	    private JMenuItem  menuItem_ReaderManager=new JMenuItem("骑手管理");
	    private JMenuItem  menuItem_PublisherManager=new JMenuItem("商品订单管理");
	    private JMenuItem  menuItem_BookManager=new JMenuItem("商品管理");
	    private JMenuItem menuItem_Manjian=new JMenuItem("满减方案管理");
	    private JMenuItem menuItem_Youhui=new JMenuItem("优惠券管理");
	    
	    private JMenuItem  menuItem_Lend=new JMenuItem("创建订单");
	    private JMenuItem  menuItem_Return=new JMenuItem("领取优惠券");
	    private JMenuItem  menuItem_Address=new JMenuItem("配送地址管理");
	    private JMenuItem  menuItem_Chongzhi=new JMenuItem("充值会员");

		
		
		private FrmLogin dlgLogin=null;
		private JPanel statusBar = new JPanel();
		public FrmMain(){
			this.setExtendedState(Frame.MAXIMIZED_BOTH);
			this.setTitle("外卖助手系统");
			dlgLogin=new FrmLogin(this,"登陆",true);
			dlgLogin.setVisible(true);
		    //菜单
			 if("管理员".equals(yaoqiu5.currentUser.getYuangong_name())) {		
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
			 if("用户".equals(yaoqiu5.currentUser.getYuangong_name())) {	
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
		    //状态栏
		    statusBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		    JLabel label=new JLabel("您好!"+yaoqiu5.currentUser);
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
//				FrmzhuceManager dlg=new FrmzhuceManager(this,"注册",true);
//				dlg.setVisible(true);
//			}
			 if(e.getSource()==this.menuItem_UserManager){
				FrmproductorManager dlg=new FrmproductorManager(this,"商家管理",true);
				dlg.setVisible(true);
			}
			else if(e.getSource()==this.menuItem_ReaderTypeManager){
				FrmuserManager dlg=new FrmuserManager(this,"用户管理",true);
				dlg.setVisible(true);
			}
			else if(e.getSource()==this.menuItem_ReaderManager){
				FrmriderManager dlg=new FrmriderManager(this,"骑手管理",true);
				dlg.setVisible(true);
			}
			else if(e.getSource()==this.menuItem_Address){
				FrmaddressManager dlg=new FrmaddressManager(this,"配送地址管理管理",true);
				dlg.setVisible(true);
			}
			else if(e.getSource()==this.menuItem_PublisherManager){
				FrmdingManager dlg=new FrmdingManager(this,"商品订单管理",true);
				dlg.setVisible(true);
			}
			else if(e.getSource()==this.menuItem_BookManager){
				FrmproductManager dlg=new FrmproductManager(this,"商品管理",true);
				dlg.setVisible(true);
			}
			else if(e.getSource()==this.menuItem_Manjian){
				FrmManjianManager dlg=new FrmManjianManager(this,"满减方案管理",true);
				dlg.setVisible(true);
			}
			else if(e.getSource()==this.menuItem_Youhui){
				FrmyouhuiManager dlg=new FrmyouhuiManager(this,"优惠券管理",true);
				dlg.setVisible(true);
			}
//			else if(e.getSource()==this.menuItem_Lend){
//				Frmxiadan dlg=new Frmxiadan(this,"创建订单",true);
//				dlg.setVisible(true);
//			}
			else if(e.getSource()==this.menuItem_Lend){
				FrmdingManager1 dlg=new FrmdingManager1(this,"商品订单管理",true);
				dlg.setVisible(true);
			}
			else if(e.getSource()==this.menuItem_Return){
				Frmlingquan dlg=new Frmlingquan(this,"领取优惠券",true);
				dlg.setVisible(true);
			}
			else if(e.getSource()==this.menuItem_Chongzhi){
				FrmChongzhi dlg=new FrmChongzhi(this,"注册会员",true);
				dlg.setVisible(true);
			}
		}
			
	}