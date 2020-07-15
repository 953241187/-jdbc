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

import cn.edu.zucc.model.dingdan;
import cn.edu.zucc.util.BaseException;
import cn.edu.zucc.waimai.comtrol.example.yaoqiu11;

public class FrmdingManager1_cancel extends JDialog implements ActionListener{
	private dingdan ding=null;
	private JPanel toolBar = new JPanel();
	private JPanel workPane = new JPanel();
	private Button btnOk = new Button("确定");
	private Button btnCancel = new Button("取消");
	private JLabel labelPdtid = new JLabel("请输入要取消单的订单号:");
	
	private JTextField edtPdtid = new JTextField(20);
	public FrmdingManager1_cancel(FrmdingManager1 f, String s, boolean b) {
		super(f, s, b);
		toolBar.setLayout(new FlowLayout(FlowLayout.RIGHT));
		toolBar.add(btnOk);
		toolBar.add(btnCancel);
		this.getContentPane().add(toolBar, BorderLayout.SOUTH);
		workPane.add(labelPdtid);
		workPane.add(edtPdtid);
		
		
		
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
		
			ding=new dingdan();

			ding.setDingdan_id(Integer.parseInt(this.edtPdtid.getText()));
			try {
				(new yaoqiu11()).quxiaodingdan(ding);
				this.setVisible(false);
			} catch (BaseException e1) {
				this.ding=null;
				JOptionPane.showMessageDialog(null, e1.getMessage(),"错误",JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
	public dingdan getPub() {
		return ding;
	}
}
