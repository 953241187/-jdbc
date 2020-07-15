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

import cn.edu.zucc.model.manjian;
import cn.edu.zucc.model.youhuichiyou;
import cn.edu.zucc.util.BaseException;
import cn.edu.zucc.waimai.comtrol.example.yaoqiu10;
import cn.edu.zucc.waimai.comtrol.example.yaoqiu8;

public class Frmlingquan extends JDialog implements ActionListener{
	private JPanel toolBar = new JPanel();
	private Button btnAdd = new Button("�Ż�ȯ��ȡ");
	private Object tblTitle[]={"�Ż�ȯ���","�û����","�������"};
	private Object tblData[][];
	List<youhuichiyou> pubs;
	DefaultTableModel tablmod=new DefaultTableModel();
	private JTable dataTable=new JTable(tablmod);
	private void reloadTable(){
		try {
			pubs=(new yaoqiu10()).loadlingquan();
			tblData =new Object[pubs.size()][3];
			for(int i=0;i<pubs.size();i++){
				tblData[i][0]=pubs.get(i).getYouhuiquan_id();
				tblData[i][1]=pubs.get(i).getUser_id();
				tblData[i][2]=pubs.get(i).getDingdan_id();
			}
			tablmod.setDataVector(tblData,tblTitle);
			this.dataTable.validate();
			this.dataTable.repaint();
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Frmlingquan(FrmMain f, String s, boolean b) {
		super(f, s, b);
		toolBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		toolBar.add(btnAdd);
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
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				//System.exit(0);
			}
		});
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.btnAdd){
			FrmlingquanManager_add dlg=new FrmlingquanManager_add(this,"����̼�",true);
			dlg.setVisible(true);
			if(dlg.getPub()!=null){//ˢ�±��
				this.reloadTable();
			}
		}
		
	}

}
