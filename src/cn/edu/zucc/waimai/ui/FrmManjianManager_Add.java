package cn.edu.zucc.waimai.ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


import cn.edu.zucc.util.BaseException;
import cn.edu.zucc.waimai.comtrol.example.yaoqiu8;
import cn.edu.zucc.model.manjian;
import cn.edu.zucc.model.youhuiquan;

public class FrmManjianManager_Add extends JDialog implements ActionListener{
    private manjian pub=null;
	
	private JPanel toolBar = new JPanel();
	private JPanel workPane = new JPanel();
	private Button btnOk = new Button("确定");
	private Button btnCancel = new Button("取消");
	private JLabel labelId = new JLabel("编号：");
	private JLabel labelMoney = new JLabel("满足：");
	private JLabel labelStart = new JLabel("减少：");
	
	private JTextField edtId = new JTextField(20);
	private JTextField edtMoney = new JTextField(20);
	private JTextField edtStart = new JTextField(20);
	
	public FrmManjianManager_Add(FrmManjianManager f, String s, boolean b) {
		super(f, s, b);
		toolBar.setLayout(new FlowLayout(FlowLayout.RIGHT));
		toolBar.add(btnOk);
		toolBar.add(btnCancel);
		this.getContentPane().add(toolBar, BorderLayout.SOUTH);
		workPane.add(labelId);
		workPane.add(edtId);
		workPane.add(labelMoney);
		workPane.add(edtMoney);
		workPane.add(labelStart);
		workPane.add(edtStart);
	
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
			
			pub=new manjian();
			pub.setManjian_id(Integer.parseInt(this.edtId.getText()));
			pub.setManjian_money(Float.parseFloat(this.edtMoney.getText()));
			pub.setYouhui_money(Float.parseFloat(this.edtStart.getText()));
			try {
				(new yaoqiu8()).createmanjian(pub);
				this.setVisible(false);
			} catch (BaseException e1) {
				this.pub=null;
				JOptionPane.showMessageDialog(null, e1.getMessage(),"错误",JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
	public manjian getPub() {
		return pub;
	}

}
