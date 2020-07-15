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

import cn.edu.zucc.model.qishourz;
import cn.edu.zucc.util.BaseException;
import cn.edu.zucc.waimai.comtrol.example.qishoufenpei;

public class FrmdingManager_qishou_ping extends JDialog implements ActionListener {
	private qishourz qishou=null;
	private JPanel toolBar = new JPanel();
	private JPanel workPane = new JPanel();
	
	private Button btnOk = new Button("确定");
	private Button btnCancel = new Button("取消");
	private JLabel labelQishou = new JLabel("骑手编号");
	private JLabel labelPdtid = new JLabel("用户评价");
	
	private JTextField edtQishou = new JTextField(20);
	private JTextField edtPdtid = new JTextField(20);
	public FrmdingManager_qishou_ping(FrmdingManager_qishou f, String s, boolean b) {
		super(f, s, b);
		toolBar.setLayout(new FlowLayout(FlowLayout.RIGHT));
		toolBar.add(btnOk);
		toolBar.add(btnCancel);
		this.getContentPane().add(toolBar, BorderLayout.SOUTH);
		workPane.add(labelQishou);
		workPane.add(edtQishou);
		
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.btnCancel) {
			this.setVisible(false);
			return;
		}
		else if(e.getSource()==this.btnOk){
			
			qishou=new qishourz();
			qishou.setQishou_id(Integer.parseInt(this.edtQishou.getText()));
			qishou.setUser_comment(this.edtPdtid.getText());
			
			try {
				(new qishoufenpei()).createqishoupingjia(qishou);
				this.setVisible(false);
			} catch (BaseException e1) {
				this.qishou=null;
				JOptionPane.showMessageDialog(null, e1.getMessage(),"错误",JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
	public qishourz getPub() {
		return qishou;
	}

}
