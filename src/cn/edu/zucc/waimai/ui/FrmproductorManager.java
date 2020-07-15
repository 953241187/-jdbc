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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import cn.edu.zucc.util.BaseException;
import cn.edu.zucc.model.productor;
import cn.edu.zucc.waimai.comtrol.example.yaoqiu3;

public class FrmproductorManager extends JDialog implements ActionListener {
	private JPanel toolBar = new JPanel();
	private Button btnAdd = new Button("添加商家");
	private Button btnModify = new Button("修改商家");
	private Button btnDelete = new Button("删除商家");
	private Object tblTitle[]={"商类ID","商品类别","商家名称"};
	private Object tblData[][];
	List<productor> pubs;
	DefaultTableModel tablmod=new DefaultTableModel();
	private JTable dataTable=new JTable(tablmod);
	private void reloadTable(){
		try {
			pubs=(new yaoqiu3()).loadAllPublisher();
			tblData =new Object[pubs.size()][3];
			for(int i=0;i<pubs.size();i++){
				tblData[i][0]=pubs.get(i).getProductor_id()+"";
				tblData[i][1]=pubs.get(i).getProductor_name();
				tblData[i][2]=pubs.get(i).getProductor_star();
			}
			tablmod.setDataVector(tblData,tblTitle);
			this.dataTable.validate();
			this.dataTable.repaint();
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public FrmproductorManager(Frame f, String s, boolean b) {
		super(f, s, b);
		toolBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		toolBar.add(btnAdd);
		toolBar.add(btnModify);
		toolBar.add(this.btnDelete);
		this.getContentPane().add(toolBar, BorderLayout.NORTH);
		//提取现有数据
		this.reloadTable();
		this.getContentPane().add(new JScrollPane(this.dataTable), BorderLayout.CENTER);
		
		// 屏幕居中显示
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
		FrmproductorManager_AddPub dlg=new FrmproductorManager_AddPub(this,"添加商家",true);
		dlg.setVisible(true);
		if(dlg.getPub()!=null){//刷新表格
			this.reloadTable();
		}
	}
	else if(e.getSource()==this.btnModify){
		int i=this.dataTable.getSelectedRow();
		if(i<0) {
			JOptionPane.showMessageDialog(null,  "请选择商家","提示",JOptionPane.ERROR_MESSAGE);
			return;
		}
		productor p=this.pubs.get(i);
		FrmproductorManager_ModifyPub dlg=new FrmproductorManager_ModifyPub(this,"添加商家类别",true,p);
		dlg.setVisible(true);
		if(dlg.getPub()!=null){//刷新表格
			this.reloadTable();
		}
	}
	else if(e.getSource()==this.btnDelete){
		int i=this.dataTable.getSelectedRow();
		if(i<0) {
			JOptionPane.showMessageDialog(null,  "请选择商家","提示",JOptionPane.ERROR_MESSAGE);
			return;
		}
		productor p=this.pubs.get(i);
		if(JOptionPane.showConfirmDialog(this,"确定删除"+p.getProductor_name()+"吗？","确认",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
			try {
				(new yaoqiu3()).deletePublisher(p.getProductor_id());
				this.reloadTable();
			} catch (BaseException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(),"错误",JOptionPane.ERROR_MESSAGE);
			}
			
		}
	}
}
	
}

