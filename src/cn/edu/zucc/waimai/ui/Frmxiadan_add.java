package cn.edu.zucc.waimai.ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


import cn.edu.zucc.util.BaseException;
import cn.edu.zucc.waimai.comtrol.example.dingdanxq8;

import cn.edu.zucc.model.dingdanxq;
import cn.edu.zucc.model.dingdan;
import cn.edu.zucc.model.product;


public class Frmxiadan_add extends JDialog implements ActionListener {
	private dingdanxq dingdan=null;
	private dingdan ding=null;
	private JPanel toolBar = new JPanel();
	private JPanel workPane = new JPanel();
	private Button btnOk = new Button("确定");
	private Button btnCancel = new Button("取消");
	private JLabel labelPdtid = new JLabel("商品编号");
	private JLabel labelUser = new JLabel("用户编号");
	private JLabel labelDingid = new JLabel("订单编号");
	
	private JLabel labelName = new JLabel("商品数量：");
	
	private JTextField edtPdtid = new JTextField(20);
	private JTextField edtUser = new JTextField(20);
	private JTextField edtDingid = new JTextField(20);
	private JTextField edtName = new JTextField(20);

	
	public Frmxiadan_add(Frmxiadan f, String s, boolean b) {
		super(f, s, b);
		toolBar.setLayout(new FlowLayout(FlowLayout.RIGHT));
		toolBar.add(btnOk);
		toolBar.add(btnCancel);
		this.getContentPane().add(toolBar, BorderLayout.SOUTH);
		workPane.add(labelPdtid);
		workPane.add(edtPdtid);
		
		workPane.add(labelUser);
		workPane.add(edtUser);
		
		workPane.add(labelDingid);
		workPane.add(edtDingid);
	
		workPane.add(labelName);
		workPane.add(edtName);
		
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
			
			dingdan=new dingdanxq();
			ding=new dingdan();
			dingdan.setProduct_id(this.edtPdtid.getText());
			ding.setDingdan_id(Integer.parseInt(this.edtDingid.getText()));
			dingdan.setDing_count(Integer.parseInt(this.edtName.getText()));
			ding.setUser_id(Integer.parseInt(this.edtUser.getText()));
			
			try {
				(new dingdanxq8()).createding(dingdan,ding);
				this.setVisible(false);
			} catch (BaseException e1) {
				this.dingdan=null;
				JOptionPane.showMessageDialog(null, e1.getMessage(),"错误",JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
	public dingdanxq getPub() {
		return dingdan;
	}
		
	}

	