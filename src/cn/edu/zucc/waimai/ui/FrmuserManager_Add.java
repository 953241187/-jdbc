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

import cn.edu.zucc.model.user;
import cn.edu.zucc.waimai.comtrol.example.yaoqiu4;

public class FrmuserManager_Add extends JDialog implements ActionListener {
	private user pub=null;
	private JPanel toolBar = new JPanel();
	private JPanel workPane = new JPanel();
	private Button btnOk = new Button("确定");
	private Button btnCancel = new Button("取消");
	private JLabel labelId = new JLabel("编号：");
	private JLabel labelName = new JLabel("名字：");
	private JLabel labelSex = new JLabel("性别：");
	private JLabel labelPhone = new JLabel("电话：");
	private JLabel labelEmail = new JLabel("邮箱：");
	private JLabel labelCity = new JLabel("城市：");
	
	private JTextField edtId = new JTextField(20);
	private JTextField edtName = new JTextField(20);
	private JTextField edtSex = new JTextField(20);
	private JTextField edtPhone = new JTextField(20);
	private JTextField edtEmail = new JTextField(20);
	private JTextField edtCity = new JTextField(20);
	
	public FrmuserManager_Add(FrmuserManager f, String s, boolean b) {
		super(f, s, b);
		toolBar.setLayout(new FlowLayout(FlowLayout.RIGHT));
		toolBar.add(btnOk);
		toolBar.add(btnCancel);
		this.getContentPane().add(toolBar, BorderLayout.SOUTH);
		workPane.add(labelId);
		workPane.add(edtId);
		workPane.add(labelName);
		workPane.add(edtName);
		workPane.add(labelSex);
		workPane.add(edtSex);
		workPane.add(labelPhone);
		workPane.add(edtPhone);
		workPane.add(labelEmail);
		workPane.add(edtEmail);
		workPane.add(labelCity);
		workPane.add(edtCity);
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
			
			pub=new user();
			pub.setUser_id(Integer.parseInt(this.edtId.getText()));
			pub.setUser_name(this.edtName.getText());
			pub.setUser_sex(this.edtSex.getText());
			pub.setPhone_number(this.edtPhone.getText());
			pub.setEmail(this.edtEmail.getText());
			pub.setCity(this.edtCity.getText());
			try {
				(new yaoqiu4()).createuser(pub);
				this.setVisible(false);
			} catch (BaseException e1) {
				this.pub=null;
				JOptionPane.showMessageDialog(null, e1.getMessage(),"错误",JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
	public user getPub() {
		return pub;
	}

}
