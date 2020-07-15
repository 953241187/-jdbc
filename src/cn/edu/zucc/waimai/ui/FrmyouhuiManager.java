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
import cn.edu.zucc.model.manjian;
import cn.edu.zucc.model.youhuiquan;
import cn.edu.zucc.waimai.comtrol.example.yaoqiu3;
import cn.edu.zucc.waimai.comtrol.example.yaoqiu9;

public class FrmyouhuiManager extends JDialog implements ActionListener {
	private JPanel toolBar = new JPanel();
	private Button btnAdd = new Button("����Ż�ȯ");
	private Button btnDelete = new Button("ɾ���Ż�ȯ");
	private Object tblTitle[]={"�Ż�ȯ���","�Ż�ȯ���","��ʼʱ��","����ʱ��"};
	private Object tblData[][];
	List<youhuiquan> pubs;
	DefaultTableModel tablmod=new DefaultTableModel();
	private JTable dataTable=new JTable(tablmod);
	private void reloadTable(){
		try {
			pubs=(new yaoqiu9()).loadyouhui();
			tblData =new Object[pubs.size()][4];
			for(int i=0;i<pubs.size();i++){
				tblData[i][0]=pubs.get(i).getYouhuiquan_id();
				tblData[i][1]=pubs.get(i). getYouhui_money();
				tblData[i][2]=pubs.get(i).getStart_time();
				tblData[i][3]=pubs.get(i).getHui_end_time();
			}
			tablmod.setDataVector(tblData,tblTitle);
			this.dataTable.validate();
			this.dataTable.repaint();
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public FrmyouhuiManager(FrmMain f, String s, boolean b) {
		super(f, s, b);
		toolBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		toolBar.add(btnAdd);
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
			FrmyouhuiManager_Add dlg=new FrmyouhuiManager_Add(this,"����̼�",true);
			dlg.setVisible(true);
			if(dlg.getPub()!=null){//ˢ�±��
				this.reloadTable();
			}
			
			else if(e.getSource()==this.btnDelete){
				int i=this.dataTable.getSelectedRow();
				if(i<0) {
					JOptionPane.showMessageDialog(null,  "��ѡ���̼�","��ʾ",JOptionPane.ERROR_MESSAGE);
					return;
				}
				youhuiquan p=this.pubs.get(i);
				if(JOptionPane.showConfirmDialog(this,"ȷ��ɾ��"+p.getYouhuiquan_id()+"��","ȷ��",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
					try {
						(new yaoqiu9()).deleteyouhuiquan(p.getYouhuiquan_id());
						this.reloadTable();
					} catch (BaseException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(),"����",JOptionPane.ERROR_MESSAGE);
					}
					
				}
			}
		
	}
	}
	}


