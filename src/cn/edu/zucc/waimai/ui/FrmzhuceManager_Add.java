package cn.edu.zucc.waimai.ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


import cn.edu.zucc.util.BaseException;
import cn.edu.zucc.waimai.comtrol.example.yaoqiu5;
import cn.edu.zucc.model.guanxinxi;

public class FrmzhuceManager_Add extends JDialog implements ActionListener{
private guanxinxi user=null;
	
	private JPanel toolBar = new JPanel();
	private JPanel workPane = new JPanel();
	private Button btnOk = new Button("确定");
	private Button btnCancel = new Button("取消");
	private JLabel labelUserid = new JLabel("账号：");
	private JLabel labelUsername = new JLabel("密码：");
	private JLabel labelUsertype = new JLabel("类别：");
	
	private JTextField edtUserid = new JTextField(20);
	private JTextField edtUsername = new JTextField(20);
	private JComboBox cmbUsertype= new JComboBox(new String[] { "管理员", "用户"});
	public FrmzhuceManager_Add(FrmLogin f, String s, boolean b) {
		super(f, s, b);
		toolBar.setLayout(new FlowLayout(FlowLayout.RIGHT));
		toolBar.add(btnOk);
		toolBar.add(btnCancel);
		this.getContentPane().add(toolBar, BorderLayout.SOUTH);
		workPane.add(labelUserid);
		workPane.add(edtUserid);
		workPane.add(labelUsername);
		workPane.add(edtUsername);
		workPane.add(labelUsertype);
		workPane.add(cmbUsertype);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.btnCancel) {
			this.setVisible(false);
			return;
		}
		else if(e.getSource()==this.btnOk){
			if(this.cmbUsertype.getSelectedIndex()<0){
				JOptionPane.showMessageDialog(null,  "请选择账号类别","提示",JOptionPane.ERROR_MESSAGE);
				return;
			}
			String userid=this.edtUserid.getText();
			String password=this.edtUsername.getText();
			String usertype=this.cmbUsertype.getSelectedItem().toString();
			user=new guanxinxi();
			user.setYuangong_id(Integer.parseInt(userid));
			user.setPassword(password);
			user.setYuangong_name(usertype);
			try {
				(new yaoqiu5()).createUser(user);
				this.setVisible(false);
			} catch (BaseException e1) {
				this.user=null;
				JOptionPane.showMessageDialog(null, e1.getMessage(),"错误",JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
	public guanxinxi getUser() {
		return user;
	}
	

}
