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

import cn.edu.zucc.model.productor;
import cn.edu.zucc.model.user;
import cn.edu.zucc.util.BaseException;
import cn.edu.zucc.waimai.comtrol.example.yaoqiu4;

public class FrmproductorManager_ModifyPub  extends JDialog implements ActionListener {
	private productor pub=null;
	
	private JPanel toolBar = new JPanel();
	private JPanel workPane = new JPanel();
	private Button btnOk = new Button("确定");
	private Button btnCancel = new Button("取消");
	private JLabel labelId = new JLabel("商类编号：");
	private JLabel labelName = new JLabel("商品类别：");
	private JLabel labelSex = new JLabel("商家名称：");

	private JTextField edtId = new JTextField(20);
	private JTextField edtName = new JTextField(20);
	private JTextField edtSex = new JTextField(20);
	public FrmproductorManager_ModifyPub(FrmproductorManager f, String s, boolean b,productor p) {
		super(f, s, b);
		this.pub=p;
		toolBar.setLayout(new FlowLayout(FlowLayout.RIGHT));
		toolBar.add(btnOk);
		toolBar.add(btnCancel);
		this.getContentPane().add(toolBar, BorderLayout.SOUTH);
		workPane.add(labelId);
		this.edtId.setEnabled(false);
		this.edtId.setText(String.valueOf(p.getProductor_id()));
		workPane.add(edtId);
		workPane.add(labelName);
		this.edtName.setText(p.getProductor_name());
		workPane.add(edtName);
		workPane.add(labelSex);
		this.edtSex.setText(p.getProductor_star());
		workPane.add(edtSex);
		

		
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
				FrmproductorManager_ModifyPub.this.pub=null;
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
				pub.setProductor_id(this.edtId.getText());
				pub.setProductor_name(this.edtName.getText());
				pub.setProductor_star(this.edtSex.getText());
				try {
					(new yaoqiu4()).modifyproductor(pub);
					this.setVisible(false);
				} catch (BaseException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(),"错误",JOptionPane.ERROR_MESSAGE);
				}
			}
			
		}
		public productor getPub() {
			return pub;
		}

}
