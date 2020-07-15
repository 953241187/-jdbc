package cn.edu.zucc.waimai.ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


import cn.edu.zucc.model.product;
import cn.edu.zucc.model.productor;
import cn.edu.zucc.util.BaseException;
import cn.edu.zucc.waimai.comtrol.example.yaoqiu2;
import cn.edu.zucc.waimai.comtrol.example.yaoqiu3;

public class FrmproductManager_Modifyproduct extends JDialog implements ActionListener {
	private product book=null;
	
	private JPanel toolBar = new JPanel();
	private JPanel workPane = new JPanel();
	private Button btnOk = new Button("确定");
	private Button btnCancel = new Button("取消");
	private JLabel labelId = new JLabel("商品条码：");
	private JLabel labelName = new JLabel("商品名称：");
	private JLabel labelPrice = new JLabel("商品单价：");
	private JLabel labelPub = new JLabel("商品类别：");
	
	private JTextField edtId = new JTextField(20);
	private JTextField edtName = new JTextField(20);
	private JTextField edtPrice = new JTextField(20);
	private Map<String,productor> pubMap_name=new HashMap<String,productor>();
	private Map<String,productor> pubMap_id=new HashMap<String,productor>();
	
	
	private JComboBox cmbPub=null;
	public FrmproductManager_Modifyproduct(JDialog f, String s, boolean b,product book) {
		super(f, s, b);
		this.book=book;
		toolBar.setLayout(new FlowLayout(FlowLayout.RIGHT));
		toolBar.add(btnOk);
		toolBar.add(btnCancel);
		this.getContentPane().add(toolBar, BorderLayout.SOUTH);
		workPane.add(labelId);
		this.edtId.setText(book.getProduct_id());
		this.edtId.setEnabled(false);
		workPane.add(edtId);
		workPane.add(labelName);
		this.edtName.setText(book.getProduct_name());
		workPane.add(edtName);
		workPane.add(labelPrice);
		this.edtPrice.setText(book.getProduct_price()+"");
		workPane.add(edtPrice);
		workPane.add(labelPub);
		//提取读出版社信息
		try {
			List<productor> pubs=(new yaoqiu3()).loadAllPublisher();
			String[] strpubs=new String[pubs.size()+1];
			strpubs[0]="";
			int oldIndex=0;
			for(int i=0;i<pubs.size();i++){
				strpubs[i+1]=pubs.get(i).getProductor_name();
				if(book.getProductor_id()!=null && book.getProduct_id().equals(pubs.get(i).getProductor_id())) oldIndex=i+1;
				this.pubMap_id.put(pubs.get(i).getProductor_id(),pubs.get(i));
				this.pubMap_name.put(pubs.get(i).getProductor_name(), pubs.get(i));
			}
			this.cmbPub=new JComboBox(strpubs);
			this.cmbPub.setSelectedIndex(oldIndex);
			workPane.add(this.cmbPub);
			
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.getContentPane().add(workPane, BorderLayout.CENTER);
		this.setSize(360, 180);
		// 屏幕居中显示
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		this.setLocation((int) (width - this.getWidth()) / 2,
				(int) (height - this.getHeight()) / 2);

		this.validate();
		this.btnOk.addActionListener(this);
		this.btnCancel.addActionListener(this);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				FrmproductManager_Modifyproduct.this.book=null;
			}
		});
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.btnCancel) {
			this.setVisible(false);
			this.book=null;
			return;
		}
		else if(e.getSource()==this.btnOk){
			String name=this.edtName.getText();
			float price=0;
			try{
				price=Float.parseFloat(this.edtPrice.getText());
			}catch(Exception ex){
				JOptionPane.showMessageDialog(null, "单价输入不正确","错误",JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			book.setProduct_name(name);
			book.setProduct_price(price);
			if(this.cmbPub.getSelectedIndex()>0){
				productor p=this.pubMap_name.get(this.cmbPub.getSelectedItem().toString());
				if(p!=null) book.setProductor_id(p.getProductor_id());
			}
			else book.setProductor_id(null);
			
			
			try {
				(new yaoqiu2()).modifyBook(book);
				this.setVisible(false);
			} catch (BaseException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(),"错误",JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
	public product getBook() {
		return book;
	}
	
}
