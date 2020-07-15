package cn.edu.zucc.waimai.ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


import cn.edu.zucc.util.BaseException;
import cn.edu.zucc.model.address;
import cn.edu.zucc.waimai.comtrol.example.yaoqiu6;

public class FrmaddressManager_Add extends JDialog implements ActionListener{
	private address pub=null;
	
	private JPanel toolBar = new JPanel();
	private JPanel workPane = new JPanel();
	private Button btnOk = new Button("确定");
	private Button btnCancel = new Button("取消");
	private JLabel labelId = new JLabel("编号：");
	private JLabel labelProvince = new JLabel("省份：");
	private JLabel labelCity = new JLabel("市名：");
	private JLabel labelArea = new JLabel("区名：");
	private JLabel labelAddress = new JLabel("详细：");
	private JLabel labelLink = new JLabel("联系人：");
	private JLabel labelPhone = new JLabel("电话：");
	
	
	private JTextField edtId = new JTextField(20);
	private JTextField edtProvince = new JTextField(20);
	private JTextField edtCity = new JTextField(20);
	private JTextField edtArea = new JTextField(20);
	private JTextField edtAddress = new JTextField(20);
	private JTextField edtLink = new JTextField(20);
	private JTextField edtPhone = new JTextField(20);
	
	public FrmaddressManager_Add(FrmaddressManager f, String s, boolean b) {
		super(f, s, b);
		toolBar.setLayout(new FlowLayout(FlowLayout.RIGHT));
		toolBar.add(btnOk);
		toolBar.add(btnCancel);
		this.getContentPane().add(toolBar, BorderLayout.SOUTH);
		workPane.add(labelId);
		workPane.add(edtId);
		workPane.add(labelProvince);
		workPane.add(edtProvince);
		workPane.add(labelCity);
		workPane.add(edtCity);
		workPane.add(labelArea);
		workPane.add(edtArea);
		workPane.add(labelAddress);
		workPane.add(edtAddress);
		workPane.add(labelLink);
		workPane.add(edtLink);
		workPane.add(labelPhone);
		workPane.add(edtPhone);
		this.getContentPane().add(workPane, BorderLayout.CENTER);
		this.setSize(300, 180);
		// 屏幕居中显示
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		this.setLocation((int) (width - this.getWidth()) / 2,
				(int) (height - this.getHeight()) / 2);

		this.validate();
		this.btnOk.addActionListener(this);
		this.btnCancel.addActionListener(this);
	}



	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.btnCancel) {
			this.setVisible(false);
			return;
		}
		else if(e.getSource()==this.btnOk){
			
			pub=new address();
			pub.setAddress_id(Integer.parseInt(this.edtId.getText()));
			pub.setProvince(this.edtProvince.getText());
			pub.setCity(this.edtCity.getText());
			pub.setArea(this.edtArea.getText());
			pub.setAddress(this.edtAddress.getText());
			pub.setLink_people(this.edtLink.getText());
			pub.setPhone(this.edtPhone.getText());
			try {
				(new yaoqiu6()).createaddress(pub);
				this.setVisible(false);
			} catch (BaseException e1) {
				this.pub=null;
				JOptionPane.showMessageDialog(null, e1.getMessage(),"错误",JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
	public address getPub() {
		return pub;
	}
	

}
