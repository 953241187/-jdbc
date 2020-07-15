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

import cn.edu.zucc.model.address;
import cn.edu.zucc.model.qishou;
import cn.edu.zucc.util.BaseException;
import cn.edu.zucc.waimai.comtrol.example.yaoqiu6;
import cn.edu.zucc.waimai.comtrol.example.yaoqiu7;

public class FrmriderManager_Add extends JDialog implements ActionListener{
	private qishou pub=null;
	
	private JPanel toolBar = new JPanel();
	private JPanel workPane = new JPanel();
	private Button btnOk = new Button("确定");
	private Button btnCancel = new Button("取消");
	private JLabel labelId = new JLabel("编号：");
	private JLabel labelProvince = new JLabel("名字：");
//	private JLabel labelCity = new JLabel("状态：");

	private JTextField edtId = new JTextField(20);
	private JTextField edtProvince = new JTextField(20);
//	private JTextField edtCity = new JTextField(20);
	public FrmriderManager_Add(FrmriderManager f, String s, boolean b) throws BaseException{
		super(f, s, b);
		toolBar.setLayout(new FlowLayout(FlowLayout.RIGHT));
		toolBar.add(btnOk);
		toolBar.add(btnCancel);
		this.getContentPane().add(toolBar, BorderLayout.SOUTH);
		workPane.add(labelId);
		workPane.add(edtId);
		workPane.add(labelProvince);
		workPane.add(edtProvince);
//		workPane.add(labelCity);
//		workPane.add(edtCity);	
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
			
			pub=new qishou();
			pub.setQishou_id(Integer.parseInt(this.edtId.getText()));
			pub.setQishou_name(this.edtProvince.getText());
//			pub.setQishou_shengf(this.edtCity.getText());
			
			try {
				(new yaoqiu7()).createqishou(pub);
				this.setVisible(false);
			} catch (BaseException e1) {
				this.pub=null;
				JOptionPane.showMessageDialog(null, e1.getMessage(),"错误",JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
	public qishou getPub() {
		return pub;
	}

}
