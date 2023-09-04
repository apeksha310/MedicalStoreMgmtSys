package MedicalShop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.ListIterator;

class h1_record extends transaction {
	public int sr_no;
	protected String batch_no;
	protected int qty_in_stock;
	void insert_h1() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/medicalshop","dhk","704785");
			PreparedStatement ps=null;
			ps=conn.prepareStatement("insert into h1(bill_no,batch_no,qty_in_stock) values(?,?,?)");	
			ps.setInt(1,this.bill_no);
			ps.setString(2,this.batch_no);
			ps.setInt(3,this.qty_in_stock);
			ps.executeUpdate();
			conn.close();
			ps.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	void deleteBill() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/medicalshop","dhk","704785");
			PreparedStatement ps=null;
			ps=conn.prepareStatement("delete from h1 where bill_no=?");	
			ps.setInt(1,this.bill_no);
			ps.executeUpdate();
			super.deleteBill();
			conn.close();
			ps.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	LinkedList<h1_record> getH1Records(){
		LinkedList<h1_record> get_rec=new LinkedList<h1_record>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/medicalshop","dhk","704785");
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery("select * from h1 order by serial_no desc");
			while(rs.next()) {
				h1_record ret_h1=new h1_record();
				LinkedList<transaction> lt=new LinkedList<transaction>();
				transaction gt=new transaction();
				gt.bill_no=rs.getInt("bill_no");
				lt=gt.getBillTransaction();
				ListIterator<transaction> litr=lt.listIterator();
				while(litr.hasNext()) {
					gt=litr.next();
					if(gt.batch.equals(rs.getString("batch_no"))) {
						ret_h1.sr_no=rs.getInt("serial_no");
						ret_h1.bill_no=gt.bill_no;
						ret_h1.cust_name=gt.cust_name;
						ret_h1.cust_addr=gt.cust_addr;
						ret_h1.doct_name=gt.doct_name;
						ret_h1.bill_dt=gt.bill_dt;
						ret_h1.med_name=gt.med_name;
						ret_h1.batch=gt.batch;
						ret_h1.quantity=gt.quantity;
						ret_h1.qty_in_stock=rs.getInt("qty_in_stock");
						ret_h1.exp_dt=gt.exp_dt;
						get_rec.add(ret_h1);
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return get_rec;
	}
}
