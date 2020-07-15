package cn.edu.zucc.waimai.ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;



import cn.edu.zucc.waimai.comtrol.example.yaoqiu2;
import cn.edu.zucc.waimai.comtrol.example.yaoqiu3;
import cn.edu.zucc.model.product;
import cn.edu.zucc.model.productor;
import cn.edu.zucc.util.BaseException;

public class FrmproductManager_Addproduct extends JDialog implements ActionListener {
	private product book=null;
	
	private JPanel toolBar = new JPanel();
	private JPanel workPane = new JPanel();
	private Button btnOk = new Button("确定");
	private Button btnCancel = new Button("取消");
	private JLabel labelId = new JLabel("商品编码：");
	private JLabel labelName = new JLabel("商品名称：");
	private JLabel labelPrice = new JLabel("商品单价：");
	private JLabel labelYouhui = new JLabel("优惠价格：");
	private JLabel labelPub = new JLabel("商品类别：");
	
	private JTextField edtId = new JTextField(20);
	private JTextField edtName = new JTextField(20);
	private JTextField edtPrice = new JTextField(20);
	private JTextField edtYouhui = new JTextField(20);
	private Map<String,productor> pubMap_name=new HashMap<String,productor>();
	private Map<String,productor> pubMap_id=new HashMap<String,productor>();
	
	
	private JComboBox cmbPub=null;
	public FrmproductManager_Addproduct(JDialog f, String s, boolean b) {
		super(f, s, b);
		toolBar.setLayout(new FlowLayout(FlowLayout.RIGHT));
		toolBar.add(btnOk);
		toolBar.add(btnCancel);
		this.getContentPane().add(toolBar, BorderLayout.SOUTH);
		workPane.add(labelId);
		workPane.add(edtId);
		workPane.add(labelName);
		workPane.add(edtName);
		workPane.add(labelPrice);
		workPane.add(edtPrice);
		workPane.add(labelYouhui);
		workPane.add(edtYouhui);
		workPane.add(labelPub);
		try {
		List<productor> pubs=(new yaoqiu3()).loadAllPublisher();
		String[] strpubs=new String[pubs.size()+1];
		strpubs[0]="";
		for(int i=0;i<pubs.size();i++){
			strpubs[i+1]=pubs.get(i).getProductor_name();
			this.pubMap_id.put(pubs.get(i).getProductor_id(),pubs.get(i));
			this.pubMap_name.put(pubs.get(i).getProductor_name(), pubs.get(i));
		}
		this.cmbPub=new JComboBox(strpubs);
		workPane.add(this.cmbPub);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.getContentPane().add(workPane, BorderLayout.CENTER);
		this.setSize(360, 180);
		// 屏幕居中显示
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		this.setLocation((int) (width - this.getWidth()) / 2,
				(int) (height - this.getHeight()) / 2);

		this.validate();
		this.btnOk.addActionListener(this);
		this.btnCancel.addActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.btnCancel) {
			this.setVisible(false);
			return;
		}
		else if(e.getSource()==this.btnOk){
			String id=this.edtId.getText();
			String name=this.edtName.getText();
			float price=0;
			int youhui=0;
			try{
				price=Float.parseFloat(this.edtPrice.getText());
			}catch(Exception ex){
				JOptionPane.showMessageDialog(null, "单价输入不正确","错误",JOptionPane.ERROR_MESSAGE);
				return;
			}
			try{
				youhui=Integer.parseInt(this.edtYouhui.getText());
			}catch(Exception ex){
				JOptionPane.showMessageDialog(null, "单价输入不正确","错误",JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			product b=new product();
			b.setProduct_id(id);
			b.setProduct_name(name);
			b.setProduct_price(price);
			b.setLeibie_id(youhui);
			if(this.cmbPub.getSelectedIndex()>=0){
				productor p=this.pubMap_name.get(this.cmbPub.getSelectedItem().toString());
				if(p!=null) b.setProductor_id(p.getProductor_id());
			}
			
			
			try {
				(new yaoqiu2()).createBook(b);
				this.book=b;
				this.setVisible(false);
			} catch (BaseException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(),"错误",JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
	public product getBook() {
		return book;
	}

}
