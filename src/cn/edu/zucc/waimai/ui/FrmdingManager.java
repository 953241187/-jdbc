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


public class FrmdingManager extends JDialog implements ActionListener{
	private dingdan state=null;
	private JPanel toolBar = new JPanel();
	private Button btnRecieve = new Button("商家接单");
	private Button btnPlan = new Button("分配骑手");
//	private Button btnFinish = new Button("完成订单");
	private Button btnXq = new Button("订单详情");
	
	private Object tblTitle[]={"订单编号","用户编号","骑手编号","原始总额","最终价","满减编号","优惠券编号","下单时间","配送地址编号","订单状态","用户评价"};
	private Object tblData[][];
	List<dingdan> pubs;
	DefaultTableModel tablmod=new DefaultTableModel();
	private JTable dataTable=new JTable(tablmod);
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
	
	public FrmdingManager(Frame f, String s, boolean b) {
		super(f, s, b);
		toolBar.setLayout(new FlowLayout(FlowLayout.LEFT));
	
		toolBar.add(btnRecieve);
		toolBar.add(btnPlan);
//		toolBar.add(btnFinish);
		toolBar.add(btnXq);

		
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

		this.btnRecieve.addActionListener(this);
		this.btnPlan.addActionListener(this);
//		this.btnFinish.addActionListener(this);

		this.btnXq.addActionListener(this);

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				//System.exit(0);
			}
		});
	}

	
	public void actionPerformed(ActionEvent e) {
	
		 if(e.getSource()==this.btnPlan){
			FrmdingManager_qishou dlg=new FrmdingManager_qishou(this,"分配骑手",true);
				dlg.setVisible(true);
					this.reloadTable();
				
		}
		else if(e.getSource()==this.btnXq){
			Frmxiadan dlg=new Frmxiadan(this,"订单详情",true);
			dlg.setVisible(true);
			if(dlg.getPub()!=null){//刷新表格
				this.reloadTable();
			}
		}
		else if(e.getSource()==this.btnRecieve){
			FrmdingManager1_recieve dlg=new FrmdingManager1_recieve(this,"取消订单",true);
			dlg.setVisible(true);
			if(dlg.getPub()!=null){//刷新表格
				this.reloadTable();
			}
		
		}
	}
}
		
//		if(e.getSource()==this.btnFinish){
//			
//			try {
//				(new dingdan9()).createtime();
//				this.setVisible(false);
//			} catch (BaseException e1) {
////				this.state=null;
//				JOptionPane.showMessageDialog(null, e1.getMessage(),"错误",JOptionPane.ERROR_MESSAGE);
//			}
//		}
//		
//		}
	
	
	
	
	
//		if(e.getSource()==this.btnXq){
//			try {
//				(new qishoufenpei()).createqishoufenpei(qishou);
//				this.setVisible(false);
//			} catch (BaseException e1) {
//				this.qishou=null;
//				JOptionPane.showMessageDialog(null, e1.getMessage(),"错误",JOptionPane.ERROR_MESSAGE);
//			}
//		
//		
//			
//			
//		}


