package cn.edu.zucc.waimai.ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import cn.edu.zucc.util.BaseException;

import cn.edu.zucc.model.guanxinxi;
import cn.edu.zucc.waimai.comtrol.example.yaoqiu5;

public class FrmzhuceManager  extends JDialog implements ActionListener{
	private JPanel toolBar = new JPanel();
	private Button btnAdd = new Button("添加用户");
//	private Button btnResetPwd = new Button("重置密码");
//	private Button btnDelete = new Button("删除用户");
	private Object tblTitle[]={"账号","密码","类别"};
	private Object tblData[][];
	DefaultTableModel tablmod=new DefaultTableModel();
	private JTable userTable=new JTable(tablmod);
	private void reloadUserTable(){
		try {
			List<guanxinxi> users=(new yaoqiu5()).loadAllUsers(false);
			tblData =new Object[users.size()][3];
			for(int i=0;i<users.size();i++){
				tblData[i][0]=users.get(i).getYuangong_id();
				tblData[i][1]=users.get(i).getPassword();
				tblData[i][2]=users.get(i).getYuangong_name();
			}
			tablmod.setDataVector(tblData,tblTitle);
			this.userTable.validate();
			this.userTable.repaint();
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public FrmzhuceManager(FrmLogin f, String s, boolean b) {
		super(f, s, b);
		toolBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		toolBar.add(btnAdd);
//		toolBar.add(btnResetPwd);
//		toolBar.add(this.btnDelete);
		this.getContentPane().add(toolBar, BorderLayout.NORTH);
		//提取现有数据
		this.reloadUserTable();
		this.getContentPane().add(new JScrollPane(this.userTable), BorderLayout.CENTER);
		
		// 屏幕居中显示
		this.setSize(800, 600);
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		this.setLocation((int) (width - this.getWidth()) / 2,
				(int) (height - this.getHeight()) / 2);

		this.validate();

		this.btnAdd.addActionListener(this);
//		this.btnResetPwd.addActionListener(this);
//		this.btnDelete.addActionListener(this);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				//System.exit(0);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

//	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
//		if(e.getSource()==this.btnAdd){
//			FrmzhuceManager_Add dlg=new FrmzhuceManager_Add(this,"添加账号",true);
//			dlg.setVisible(true);
//			if(dlg.getUser()!=null){//刷新表格
//				this.reloadUserTable();
//			}
//		}
//	}
}





//		else if(e.getSource()==this.btnResetPwd){
//			int i=this.userTable.getSelectedRow();
//			if(i<0) {
//				JOptionPane.showMessageDialog(null,  "请选择账号","提示",JOptionPane.ERROR_MESSAGE);
//				return;
//			}
//			if(JOptionPane.showConfirmDialog(this,"确定重置密码吗？","确认",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
//				String userid=this.tblData[i][0].toString();
//				try {
//					(new yaoqiu5()).resetUserPwd(userid);
//					JOptionPane.showMessageDialog(null,  "密码重置完成","提示",JOptionPane.INFORMATION_MESSAGE);
//				} catch (BaseException e1) {
//					JOptionPane.showMessageDialog(null, e1.getMessage(),"错误",JOptionPane.ERROR_MESSAGE);
//				}
//				
//			}
//		}
		
		
		
		
//		else if(e.getSource()==this.btnDelete){
//			int i=this.userTable.getSelectedRow();
//			if(i<0) {
//				JOptionPane.showMessageDialog(null,  "请选择账号","提示",JOptionPane.ERROR_MESSAGE);
//				return;
//			}
//			if(JOptionPane.showConfirmDialog(this,"确定删除账号吗？","确认",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
//				String userid=this.tblData[i][0].toString();
//				try {
//					(new yaoqiu5()).deleteUser(userid);
//					this.reloadUserTable();
//				} catch (BaseException e1) {
//					JOptionPane.showMessageDialog(null, e1.getMessage(),"错误",JOptionPane.ERROR_MESSAGE);
//				}
//				
//			}
//		}
//	}


