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

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import cn.edu.zucc.util.BaseException;
import cn.edu.zucc.model.address;
import cn.edu.zucc.model.productor;
import cn.edu.zucc.model.user;
import cn.edu.zucc.waimai.comtrol.example.yaoqiu4;
import cn.edu.zucc.waimai.comtrol.example.yaoqiu6;

public class FrmaddressManager extends JDialog implements ActionListener{
	private JPanel toolBar = new JPanel();
	private Button btnAdd = new Button("��ӵ�ַ");
	private Button btnStop = new Button("ɾ����ַ");
	private Object tblTitle[]={"��ַ���","ʡ","��","��","��ϸ��ַ","��ϵ��","��ϵ�绰"};
	private Object tblData[][];
	List<address> pubs;
	DefaultTableModel tablmod=new DefaultTableModel();
	private JTable dataTable=new JTable(tablmod);
	
	
	private void reloadTable(){
		try {
			pubs=(new yaoqiu6()).loadaddress();
			tblData =new Object[pubs.size()][7];
			for(int i=0;i<pubs.size();i++){
				tblData[i][0]=pubs.get(i).getAddress_id()+"";
				tblData[i][1]=pubs.get(i).getProvince();
				tblData[i][2]=pubs.get(i).getCity();
				tblData[i][3]=pubs.get(i).getArea();
				tblData[i][4]=pubs.get(i).getAddress();
				tblData[i][5]=pubs.get(i).getLink_people();
				tblData[i][6]=pubs.get(i).getPhone();
			}
			tablmod.setDataVector(tblData,tblTitle);
			this.dataTable.validate();
			this.dataTable.repaint();
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public FrmaddressManager(FrmMain f, String s, boolean b) {
		super(f, s, b);
		toolBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		toolBar.add(btnAdd);
		toolBar.add(this.btnStop);
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
		this.btnStop.addActionListener(this);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				//System.exit(0);
			}
		});
	}
	


	

	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.btnAdd){
			FrmaddressManager_Add dlg=new FrmaddressManager_Add(this,"��ӵ�ַ",true);
			dlg.setVisible(true);
			if(dlg.getPub()!=null){//ˢ�±��
				this.reloadTable();
			}
		}
		else if(e.getSource()==this.btnStop){
			int i=this.dataTable.getSelectedRow();
			if(i<0) {
				JOptionPane.showMessageDialog(null,  "��ѡ���ַ","��ʾ",JOptionPane.ERROR_MESSAGE);
				return;
			}
			address p=this.pubs.get(i);
			if(JOptionPane.showConfirmDialog(this,"ȷ��ɾ��"+p.getLink_people()+"��","ȷ��",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
				try {
					(new yaoqiu6()).deleteaddress(p.getAddress_id());
					this.reloadTable();
				} catch (BaseException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(),"����",JOptionPane.ERROR_MESSAGE);
				}
	}

}
}
}