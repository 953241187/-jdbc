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
import cn.edu.zucc.model.productor;
import cn.edu.zucc.waimai.comtrol.example.yaoqiu3;



	public class FrmproductorManager_AddPub extends JDialog implements ActionListener {
		private productor pub=null;
		
		private JPanel toolBar = new JPanel();
		private JPanel workPane = new JPanel();
		private Button btnOk = new Button("ȷ��");
		private Button btnCancel = new Button("ȡ��");
		private JLabel labelId = new JLabel("��ţ�");
		private JLabel labelName = new JLabel("���");
		private JLabel labelAddress = new JLabel("���ƣ�");
		
		private JTextField edtId = new JTextField(20);
		private JTextField edtName = new JTextField(20);
		private JTextField edtAddress = new JTextField(20);
		public FrmproductorManager_AddPub(JDialog f, String s, boolean b) {
			super(f, s, b);
			toolBar.setLayout(new FlowLayout(FlowLayout.RIGHT));
			toolBar.add(btnOk);
			toolBar.add(btnCancel);
			this.getContentPane().add(toolBar, BorderLayout.SOUTH);
			workPane.add(labelId);
			workPane.add(edtId);
			workPane.add(labelName);
			workPane.add(edtName);
			workPane.add(labelAddress);
			workPane.add(edtAddress);
			this.getContentPane().add(workPane, BorderLayout.CENTER);
			this.setSize(300, 180);
			// ��Ļ������ʾ
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
			
			pub=new productor();
			pub.setProductor_id(this.edtId.getText());
			pub.setProductor_name(this.edtName.getText());
			pub.setProductor_star(this.edtAddress.getText());
			try {
				(new yaoqiu3()).createPublisher(pub);
				this.setVisible(false);
			} catch (BaseException e1) {
				this.pub=null;
				JOptionPane.showMessageDialog(null, e1.getMessage(),"����",JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
	public productor getPub() {
		return pub;
	}

}
