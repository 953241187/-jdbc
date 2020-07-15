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
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import cn.edu.zucc.util.BaseException;
import cn.edu.zucc.waimai.comtrol.example.dingdan9;
import cn.edu.zucc.waimai.comtrol.example.qishoufenpei;
import cn.edu.zucc.model.dingdan;
import cn.edu.zucc.model.qishourz;


public class FrmdingManager1 extends JDialog implements ActionListener{
	private dingdan state=null;
	private JPanel toolBar = new JPanel();
	private Button btnCreate = new Button("��������");
	private Button btnBuy = new Button("������Ʒ");
	private Button btnQueren = new Button("�µ�");
	private Button btnCancel = new Button("ȡ������");
	private Button btnXq = new Button("��������");
	private Button btnPing = new Button("�û�����");
	
	private Object tblTitle[]={"�������","�û����","���ֱ��","ԭʼ�ܶ�","���ռ�","�������","�Ż�ȯ���","�µ�ʱ��","���͵�ַ���","����״̬","�û�����"};
	private Object tblData[][];
	List<dingdan> pubs;
	DefaultTableModel tablmod=new DefaultTableModel();
	private JTable dataTable=new JTable(tablmod);
	private String ȡ������;
	private void reloadTable(){
		try {
			pubs=(new dingdan9()).loadalldingdan();
			tblData =new Object[pubs.size()][12];
			for(int i=0;i<pubs.size();i++){
				tblData[i][0]=pubs.get(i).getDingdan_id();
//				tblData[i][1]=pubs.get(i).getPingjia_star();
				tblData[i][1]=pubs.get(i).getUser_id();
				tblData[i][2]=pubs.get(i).getQishou_id();
				tblData[i][3]=pubs.get(i).getYuanshi_money();
				tblData[i][4]=pubs.get(i).getJiesuan_money();
				tblData[i][5]=pubs.get(i).getManjian_id();
				tblData[i][6]=pubs.get(i).getYouhuiquan_id();
				tblData[i][7]=pubs.get(i).getPingjia_time();
				tblData[i][8]=pubs.get(i).getAddress_id();
				tblData[i][9]=pubs.get(i).getDing_state();
				tblData[i][10]=pubs.get(i).getPingjia_comment();
				
			}
			tablmod.setDataVector(tblData,tblTitle);
			this.dataTable.validate();
			this.dataTable.repaint();
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public FrmdingManager1(Frame f, String s, boolean b) {
		super(f, s, b);
		toolBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		toolBar.add(btnCreate);
		toolBar.add(btnBuy);
		toolBar.add(btnQueren);
		toolBar.add(btnCancel);
		toolBar.add(btnXq);
		toolBar.add(btnPing);
		
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
		this.btnCreate.addActionListener(this);
		this.btnBuy.addActionListener(this);
		this.btnQueren.addActionListener(this);
		this.btnCancel.addActionListener(this);

		this.btnXq.addActionListener(this);
		this.btnPing.addActionListener(this);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				//System.exit(0);
			}
		});
	}

	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.btnCreate){
			FrmdingManager1_create dlg=new FrmdingManager1_create(this,"��������",true);
			dlg.setVisible(true);
			if(dlg.getPub()!=null){//ˢ�±��
				this.reloadTable();
			}
		
		}
		else if(e.getSource()==this.btnBuy){
			FrmdingManager1_buy dlg=new FrmdingManager1_buy(this,"������Ʒ",true);
			dlg.setVisible(true);
			if(dlg.getPub()!=null){//ˢ�±��
				this.reloadTable();
			}
		}

		else if(e.getSource()==this.btnQueren){
			
			FrmdingManager1_queren dlg=new FrmdingManager1_queren(this,"�µ�",true);
			dlg.setVisible(true);
			if(dlg.getPub()!=null){//ˢ�±��
				this.reloadTable();
			}
		
		}
		
		else if(e.getSource()==this.btnCancel){
			
			FrmdingManager1_cancel dlg=new FrmdingManager1_cancel(this,"ȡ������",true);
			dlg.setVisible(true);
			if(dlg.getPub()!=null){//ˢ�±��
				this.reloadTable();
			}
		
		}
		
		
		else if(e.getSource()==this.btnXq){
			Frmxiadan1 dlg=new Frmxiadan1(this,"��������",true);
			dlg.setVisible(true);
			if(dlg.getPub()!=null){//ˢ�±��
				this.reloadTable();
	}
		}
		else if(e.getSource()==this.btnPing){
			int i=this.dataTable.getSelectedRow();
			if(i<0) {
				JOptionPane.showMessageDialog(null,  "��ѡ�񶩵�","��ʾ",JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			Frmxiadan1_pingjia dlg=new Frmxiadan1_pingjia(this,"��������",true);
			dlg.setVisible(true);
			if(dlg.getPub()!=null){//ˢ�±��
				this.reloadTable();
	}
		}
	}
}