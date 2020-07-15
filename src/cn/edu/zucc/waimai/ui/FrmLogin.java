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

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import cn.edu.zucc.wai.waimaiUtil;
import cn.edu.zucc.model.productor;
import cn.edu.zucc.waimai.comtrol.example.yaoqiu5;
import cn.edu.zucc.model.guanxinxi;
import cn.edu.zucc.wai.waimaiUtil;
import cn.edu.zucc.model.product;
import cn.edu.zucc.waimai.comtrol.example.yaoqiu5;
import cn.edu.zucc.waimai.itf.IPyaoqiu5;
import cn.edu.zucc.waimai.ui.FrmRegister;
import cn.edu.zucc.util.BaseException;


public class FrmLogin extends JDialog implements ActionListener {
	private JPanel toolBar = new JPanel();
	private JPanel workPane = new JPanel();
	private Button btnzhuce = new Button("ע��");
	private Button btnLogin = new Button("��½");
	private Button btnCancel = new Button("�˳�");
	private JLabel labelUser = new JLabel("�û���");
	private JLabel labelPwd = new JLabel("���룺");
	private JTextField edtUserId = new JTextField(20);
	private JPasswordField edtPwd = new JPasswordField(20);

	public FrmLogin(Frame f, String s, boolean b) {
		super(f, s, b);
		toolBar.setLayout(new FlowLayout(FlowLayout.RIGHT));
		toolBar.add(btnzhuce);
		toolBar.add(btnLogin);
		toolBar.add(btnCancel);
		this.getContentPane().add(toolBar, BorderLayout.SOUTH);
		workPane.add(labelUser);
		workPane.add(edtUserId);
		workPane.add(labelPwd);
		workPane.add(edtPwd);
		this.getContentPane().add(workPane, BorderLayout.CENTER);
		this.setSize(300, 140);
		// ��Ļ������ʾ
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		this.setLocation((int) (width - this.getWidth()) / 2,
				(int) (height - this.getHeight()) / 2);

		this.validate();
		btnzhuce.addActionListener(this);
		btnLogin.addActionListener(this);
		btnCancel.addActionListener(this);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btnzhuce) {
			FrmzhuceManager_Add dlg=new FrmzhuceManager_Add(this,"ע��",true);
			dlg.setVisible(true);
			
			
		}
		
		if (e.getSource() == this.btnLogin) {
			yaoqiu5 sum=new yaoqiu5();
			String userid=this.edtUserId.getText();
			String pwd=new String(this.edtPwd.getPassword());
			try {
				guanxinxi user=sum.loadUser(userid);
				if(pwd.equals(user.getPassword())){
					yaoqiu5.currentUser=user;
					setVisible(false);
				}
				else{
					JOptionPane.showMessageDialog(null,  "�������","������ʾ",JOptionPane.ERROR_MESSAGE);
				}
			} catch (BaseException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "������ʾ",JOptionPane.ERROR_MESSAGE);
			}
			
			
		} else if (e.getSource() == this.btnCancel) {
			System.exit(0);
		}
	}
	}
	 
	