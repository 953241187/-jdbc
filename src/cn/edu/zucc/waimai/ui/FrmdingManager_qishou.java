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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import cn.edu.zucc.model.qishou;
import cn.edu.zucc.model.qishourz;
import cn.edu.zucc.model.user;
import cn.edu.zucc.util.BaseException;
import cn.edu.zucc.waimai.comtrol.example.qishoufenpei;
import cn.edu.zucc.waimai.comtrol.example.yaoqiu4;

public class FrmdingManager_qishou extends JDialog implements ActionListener{
	private JPanel toolBar = new JPanel();
	private Button btnAdd = new Button("��ʼ����");
	private Button btnSong = new Button("�����ʹ�");
	private Button btnping = new Button("��������");
	private Object tblTitle[]={"���ֱ��","�������","��������","��������"};//�����ʹ�ʱ��
	private Object tblData[][];
	List<qishourz> users;
	DefaultTableModel tablmod=new DefaultTableModel();
	private JTable dataTable=new JTable(tablmod);	
	private void reloadTable(){
		try {
			users=(new qishoufenpei()).loadqishoufenpei();
			tblData =new Object[users.size()][4];
			for(int i=0;i<users.size();i++){
				tblData[i][0]=users.get(i).getQishou_id();
				tblData[i][1]=users.get(i).getDingdan_id();
				//tblData[i][2]=users.get(i).getDate();
				tblData[i][2]=users.get(i).getUser_id();
				tblData[i][3]=users.get(i).getUser_comment();
			}
			tablmod.setDataVector(tblData,tblTitle);
			this.dataTable.validate();
			this.dataTable.repaint();
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public FrmdingManager_qishou(FrmdingManager f, String s, boolean b) {
		super(f, s, b);
		toolBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		toolBar.add(btnAdd);
		toolBar.add(btnSong);
		toolBar.add(btnping);
	
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
		this.btnSong.addActionListener(this);
		this.btnping.addActionListener(this);
	
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				//System.exit(0);
			}
		});
	}


	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.btnAdd){
			FrmdingManager_qishou_add dlg=new FrmdingManager_qishou_add(this,"���ַ���",true);
			dlg.setVisible(true);
			if(dlg.getPub()!=null){//ˢ�±��
				this.reloadTable();
			}
		
		}
		if(e.getSource()==this.btnSong){
			FrmdingManager_qishou_song dlg=new FrmdingManager_qishou_song(this,"���ַ���",true);
			dlg.setVisible(true);
			if(dlg.getPub()!=null){//ˢ�±��
				this.reloadTable();
			}
		
		}
		
		if(e.getSource()==this.btnping){
			FrmdingManager_qishou_ping dlg=new FrmdingManager_qishou_ping(this,"���ַ���",true);
			dlg.setVisible(true);
			if(dlg.getPub()!=null){//ˢ�±��
				this.reloadTable();
			}
		
		}
	}


	public Object getPub() {
		// TODO Auto-generated method stub
		return null;
	}

}
