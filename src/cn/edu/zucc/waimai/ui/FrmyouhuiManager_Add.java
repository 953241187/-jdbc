package cn.edu.zucc.waimai.ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


import cn.edu.zucc.model.user;
import cn.edu.zucc.model.youhuiquan;
import cn.edu.zucc.util.BaseException;
import cn.edu.zucc.waimai.comtrol.example.yaoqiu4;
import cn.edu.zucc.waimai.comtrol.example.yaoqiu9;

public class FrmyouhuiManager_Add extends JDialog implements ActionListener{
		private youhuiquan pub=null;
		
		private JPanel toolBar = new JPanel();
		private JPanel workPane = new JPanel();
		private Button btnOk = new Button("ȷ��");
		private Button btnCancel = new Button("ȡ��");
		private JLabel labelId = new JLabel("��ţ�");
		private JLabel labelMoney = new JLabel("��");
		private JLabel labelStart = new JLabel("��ʼ��");
		private JLabel labelEnd = new JLabel("������");
		
		private JTextField edtId = new JTextField(20);
		private JTextField edtMoney = new JTextField(20);
		private JTextField edtStart = new JTextField(20);
		private JTextField edtEnd = new JTextField(20);
		
		public FrmyouhuiManager_Add(FrmyouhuiManager f, String s, boolean b) {
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
			workPane.add(labelEnd);
			workPane.add(edtEnd);
			
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


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.btnCancel) {
			this.setVisible(false);
			return;
		}
		else if(e.getSource()==this.btnOk){
			
			pub=new youhuiquan();
			pub.setYouhuiquan_id(Integer.parseInt(this.edtId.getText()));
			pub.setYouhui_money(Float.valueOf(this.edtMoney.getText()));
			String a=this.edtStart.getText();
			String b=this.edtEnd.getText();
		
			try {
				(new yaoqiu9()).createyouhui(pub,a,b);
				this.setVisible(false);
			} catch (BaseException | ParseException e1) {
				this.pub=null;
				JOptionPane.showMessageDialog(null, e1.getMessage(),"����",JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
	public youhuiquan getPub() {
		return pub;
	}

}
