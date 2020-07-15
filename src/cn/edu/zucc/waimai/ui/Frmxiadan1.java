package cn.edu.zucc.waimai.ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


import cn.edu.zucc.util.BaseException;

import cn.edu.zucc.waimai.comtrol.example.dingdanxq8;

import cn.edu.zucc.model.dingdanxq;
import cn.edu.zucc.model.product;



public class Frmxiadan1 extends JDialog implements ActionListener{
	private JPanel toolBar = new JPanel();
	private Button btnAdd = new Button("下单");
	private Object tblTitle[]= {"商品编号","商品名称","用户编号","价格","购买数量"};
	private Object tblData[][];
	List<product> books=null;
	//List<dingdanxq> dings=null;
	DefaultTableModel tablmod=new DefaultTableModel();
	private JTable dataTable=new JTable(tablmod);
	
	private void reloadTable(){
		try {
			books=(new dingdanxq8()).loaddingdanxq();
			//dings=(new dingdanxq8()).loaddingdanxq1();
			tblData =new Object[books.size()][5];
			for(int i=0;i<books.size();i++){
				tblData[i][0]=books.get(i).getProduct_id();
				tblData[i][1]=books.get(i).getProduct_name();
				tblData[i][2]=books.get(i).getUser_id();
				tblData[i][3]=books.get(i).getProduct_price();
				tblData[i][4]=books.get(i).getDing_count();
			}
			tablmod.setDataVector(tblData,tblTitle);
			this.dataTable.validate();
			this.dataTable.repaint();
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public Frmxiadan1(FrmdingManager1 frmdingManager, String s, boolean b) {
		super(frmdingManager, s, b);
		toolBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		toolBar.add(btnAdd);
		this.getContentPane().add(toolBar, BorderLayout.NORTH);
		//提取现有数据
		this.reloadTable();
		this.getContentPane().add(new JScrollPane(this.dataTable), BorderLayout.CENTER);
		
		// 屏幕居中显示
		this.setSize(800, 600);
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		this.setLocation((int) (width - this.getWidth()) / 2,
				(int) (height - this.getHeight()) / 2);

		this.validate();

		this.btnAdd.addActionListener(this);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				//System.exit(0);
			}
		});
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.btnAdd){
			Frmxiadan1_add dlg=new Frmxiadan1_add(this,"用户下单",true);
			dlg.setVisible(true);
			if(dlg.getPub()!=null){//刷新表格
				this.reloadTable();
			}
		
		}
	}


	public Object getPub() {
		// TODO Auto-generated method stub
		return null;
	}
}
