package cn.edu.zucc.waimai.ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


import cn.edu.zucc.util.BaseException;
import cn.edu.zucc.waimai.ui.FrmuserManager_Modify;
import cn.edu.zucc.model.productor;
import cn.edu.zucc.model.user;
import cn.edu.zucc.waimai.comtrol.example.yaoqiu4;

	    public class FrmuserManager extends JDialog implements ActionListener{
	    	private JPanel toolBar = new JPanel();
	    	private Button btnAdd = new Button("����û�");
	    	private Button btnModify = new Button("�޸��û�");
	    	private Button btnDelete = new Button("ɾ���û�");
	    	private Object tblTitle[]={"�û�ID","����","�Ա�","�绰","����","����","�Ƿ��Ա"};
	    	private Object tblData[][];
	    	List<user> users;
	    	DefaultTableModel tablmod=new DefaultTableModel();
	    	private JTable dataTable=new JTable(tablmod);
	    
	    	private void reloadTable(){
	    		try {
	    			users=(new yaoqiu4()).loadAllUsers();
	    			tblData =new Object[users.size()][7];
	    			for(int i=0;i<users.size();i++){
	    				tblData[i][0]=users.get(i).getUser_id()+"";
	    				tblData[i][1]=users.get(i).getUser_name();
	    				tblData[i][2]=users.get(i).getUser_sex();
	    				tblData[i][3]=users.get(i).getPhone_number();
	    				tblData[i][4]=users.get(i).getEmail();
	    				tblData[i][5]=users.get(i).getCity();
	    				tblData[i][6]=users.get(i).getShifouhuiyuan();
	    			}
	    			tablmod.setDataVector(tblData,tblTitle);
	    			this.dataTable.validate();
	    			this.dataTable.repaint();
	    		} catch (BaseException e) {
	    			// TODO Auto-generated catch block
	    			e.printStackTrace();
	    		}
	    	}
	    	
	public FrmuserManager(Frame f, String s, boolean b) {
		super(f, s, b);
		toolBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		toolBar.add(btnAdd);
		toolBar.add(btnModify);
		toolBar.add(this.btnDelete);
		this.getContentPane().add(toolBar, BorderLayout.NORTH);
		//��ȡ��������
		this.reloadTable();
		this.getContentPane().add(new JScrollPane(this.dataTable), BorderLayout.CENTER);
		
		// ��Ļ������ʾ
		this.setSize(800, 600);
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		this.setLocation((int) (width - this.getWidth()) / 2,
				(int) (height - this.getHeight()) / 2);

		this.validate();

		this.btnAdd.addActionListener(this);
		this.btnModify.addActionListener(this);
		this.btnDelete.addActionListener(this);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				//System.exit(0);
			}
		});
	    }



	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.btnAdd){
			FrmuserManager_Add dlg=new FrmuserManager_Add(this,"����û�",true);
			dlg.setVisible(true);
			if(dlg.getPub()!=null){//ˢ�±��
				this.reloadTable();
			}
		
		}
		else if(e.getSource()==this.btnModify){
			int i=this.dataTable.getSelectedRow();
			if(i<0) {
				JOptionPane.showMessageDialog(null,  "��ѡ���û�","��ʾ",JOptionPane.ERROR_MESSAGE);
				return;
			}
			user p=this.users.get(i);
			FrmuserManager_Modify dlg=new FrmuserManager_Modify(this,"�޸��û�",true,p);
			dlg.setVisible(true);
			if(dlg.getPub()!=null){//ˢ�±��
				this.reloadTable();
			}
		}
		else if(e.getSource()==this.btnDelete){
			int i=this.dataTable.getSelectedRow();
			if(i<0) {
				JOptionPane.showMessageDialog(null,  "��ѡ���û�","��ʾ",JOptionPane.ERROR_MESSAGE);
				return;
			}
			user p=this.users.get(i);
			if(JOptionPane.showConfirmDialog(this,"ȷ��ɾ��"+p.getUser_name()+"��","ȷ��",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
				try {
					(new yaoqiu4()).deleteuser(p.getUser_id());
					this.reloadTable();
				} catch (BaseException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(),"����",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		}
	}
}
