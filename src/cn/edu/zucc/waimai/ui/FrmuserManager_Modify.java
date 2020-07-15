package cn.edu.zucc.waimai.ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


import cn.edu.zucc.util.BaseException;

import cn.edu.zucc.model.user;
import cn.edu.zucc.waimai.comtrol.example.yaoqiu4;

public class FrmuserManager_Modify extends JDialog implements ActionListener {
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
	
	public FrmuserManager_Modify(JDialog f, String s, boolean b, user p) {
		super(f, s, b);
		this.pub=p;
		toolBar.setLayout(new FlowLayout(FlowLayout.RIGHT));
		toolBar.add(btnOk);
		toolBar.add(btnCancel);
		this.getContentPane().add(toolBar, BorderLayout.SOUTH);
		workPane.add(labelId);
		this.edtId.setEnabled(false);
		this.edtId.setText(String.valueOf(p.getUser_id()));
		workPane.add(edtId);
		workPane.add(labelName);
		this.edtName.setText(p.getUser_name());
		workPane.add(edtName);
		workPane.add(labelSex);
		this.edtSex.setText(p.getUser_sex());
		workPane.add(edtSex);
		
		workPane.add(labelPhone);
		this.edtPhone.setText(p.getPhone_number());//保持原来的值在上面！！！！！！！！！！！
		workPane.add(edtPhone);
		
		workPane.add(labelEmail);
		this.edtEmail.setText(p.getEmail());
		workPane.add(edtEmail);
		
		workPane.add(labelCity);
		this.edtCity.setText(p.getCity());
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
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				FrmuserManager_Modify.this.pub=null;
			}
		});
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.btnCancel) {
			this.setVisible(false);
			this.pub=null;
			return;
		}
		else if(e.getSource()==this.btnOk){
			pub.setUser_id(Integer.parseInt(this.edtId.getText()));
			pub.setUser_name(this.edtName.getText());
			pub.setUser_sex(this.edtSex.getText());
			pub.setPhone_number(this.edtPhone.getText());
			pub.setEmail(this.edtEmail.getText());
			pub.setCity(this.edtCity.getText());
			try {
				(new yaoqiu4()).modifyPublisher(pub);
				this.setVisible(false);
			} catch (BaseException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(),"错误",JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
	public user getPub() {
		return pub;
	}
	

}
