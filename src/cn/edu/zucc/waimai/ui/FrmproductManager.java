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
import cn.edu.zucc.model.product;
import cn.edu.zucc.model.productor;
import cn.edu.zucc.waimai.comtrol.example.yaoqiu1;
import cn.edu.zucc.waimai.comtrol.example.yaoqiu2;
import cn.edu.zucc.waimai.comtrol.example.yaoqiu3;
import cn.edu.zucc.waimai.comtrol.example.yaoqiu4;
import cn.edu.zucc.waimai.comtrol.example.yaoqiu5;

public class FrmproductManager extends JDialog implements ActionListener{
	private JPanel toolBar = new JPanel();
	private Button btnAdd = new Button("添加");
	private Button btnModify = new Button("修改");
	private Button btnStop = new Button("下架");
	private JComboBox cmbState=new JComboBox(new String[]{"上架中","已借出","已删除"});
	private JTextField edtKeyword = new JTextField(10);
	private Button btnSearch = new Button("查询");
	private Object tblTitle[]={"商品编码","商品名称","商品类别","商品价格","会员价格","商品状态"};
	private Object tblData[][];
	List<product> books=null;
	DefaultTableModel tablmod=new DefaultTableModel();
	private JTable dataTable=new JTable(tablmod);
	private void reloadTable(){
		try {
			books=(new yaoqiu2()).searchproduct(this.edtKeyword.getText(), this.cmbState.getSelectedItem().toString());
			tblData =new Object[books.size()][6];
			for(int i=0;i<books.size();i++){
				tblData[i][0]=books.get(i).getProduct_id();
				tblData[i][1]=books.get(i).getProduct_name();
				tblData[i][2]=books.get(i).getProductor_name();
				tblData[i][3]=books.get(i).getProduct_price();
				tblData[i][4]=books.get(i).getLeibie_id();
				tblData[i][5]=books.get(i).getYouhui_name();
			}
			tablmod.setDataVector(tblData,tblTitle);
			this.dataTable.validate();
			this.dataTable.repaint();
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public FrmproductManager(Frame f, String s, boolean b) {
		super(f, s, b);
		toolBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		toolBar.add(btnAdd);
		toolBar.add(btnModify);
		toolBar.add(btnStop);
//		toolBar.add(cmbState);
		toolBar.add(edtKeyword);
		toolBar.add(btnSearch);
		
		
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
		this.btnStop.addActionListener(this);
		this.btnSearch.addActionListener(this);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				//System.exit(0);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==this.btnAdd){
			FrmproductManager_Addproduct dlg=new FrmproductManager_Addproduct(this,"添加图书",true);
			dlg.setVisible(true);
			if(dlg.getBook()!=null){//刷新表格
				this.reloadTable();
			}
		}
		else if(e.getSource()==this.btnModify){
			int i=this.dataTable.getSelectedRow();
			if(i<0) {
				JOptionPane.showMessageDialog(null,  "请选择图书","提示",JOptionPane.ERROR_MESSAGE);
				return;
			}
			product book=this.books.get(i);
			
			FrmproductManager_Modifyproduct dlg=new FrmproductManager_Modifyproduct(this,"修改图书",true,book);
			dlg.setVisible(true);
			if(dlg.getBook()!=null){//刷新表格
				this.reloadTable();
			}
		}
		else if(e.getSource()==this.btnStop){
			int i=this.dataTable.getSelectedRow();
			if(i<0) {
				JOptionPane.showMessageDialog(null,  "请选商品","提示",JOptionPane.ERROR_MESSAGE);
				return;
			}
			product book=this.books.get(i);
			if(!"上架中".equals(book.getYouhui_name())){
				JOptionPane.showMessageDialog(null,  "当前商品没有‘上架中’","提示",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(JOptionPane.showConfirmDialog(this,"确定删除"+book.getProduct_name()+"吗？","确认",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
				book.setYouhui_name("已删除");
				try {
					(new yaoqiu2()).modifyBook(book);
					this.reloadTable();
				} catch (BaseException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(),"错误",JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		else if(e.getSource()==this.btnSearch){
			this.reloadTable();
		}
	}
}