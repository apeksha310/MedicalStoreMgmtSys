package MedicalShop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.LinkedList;
import java.util.ListIterator;


class transaction extends customer{
	protected String batch;
	protected String med_name;
	protected String comp_name;
	protected Date mfg_dt;
	protected Date exp_dt;
	protected int quantity;
	double tab_bill;
	int insert() {
		int action=0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/medicalshop","dhk","704785");
			PreparedStatement ps=null;
			ps=conn.prepareStatement("insert into transactions values(?,?,?,?,?,?,?,?)");
			ps.setInt(1,this.bill_no);
			ps.setString(2,this.batch);
			ps.setString(3,this.med_name);
			ps.setString(4,this.comp_name);
			ps.setDate(5,(java.sql.Date) this.mfg_dt);
			ps.setDate(6,(java.sql.Date) this.exp_dt);
			ps.setInt(7,this.quantity);
			ps.setDouble(8,this.tab_bill);
			action=ps.executeUpdate();
			conn.close();
			ps.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return action;
	}
	void deleteBill() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/medicalshop","dhk","704785");
			PreparedStatement ps=null;
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery("select * from transactions where bill_no='"+this.bill_no+"'");
			while(rs.next()) {
				stock rollback_stock=new stock();
				rollback_stock.batch_no=rs.getString("batch_no");
				LinkedList<stock> stk=new LinkedList<stock>();
				stk=rollback_stock.getStockDetails();
				ListIterator<stock> iter=stk.listIterator();
				rollback_stock=iter.next();
				rollback_stock.avai_in_stock=rollback_stock.avai_in_stock+rs.getInt("quantity");
				rollback_stock.updateAvailableInStock();
			}
			ps=conn.prepareStatement("delete from transactions where bill_no=?");	
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

	LinkedList<transaction> getBillTransaction(){
		LinkedList<transaction> ret_trans=new LinkedList<transaction>();
		int i=0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/medicalshop","dhk","704785");
			Statement stmt=conn.createStatement();
			if(this.bill_no>0) {
				ResultSet rs=stmt.executeQuery("select * from transactions where bill_no='"+this.bill_no+"'");
				while(rs.next())  {
					transaction gt=new transaction();
					LinkedList<customer> get_cust=new LinkedList<customer>();
					customer cust=new customer();
					cust.bill_no=rs.getInt("bill_no");
					get_cust=cust.getCustomer();
					ListIterator<customer> litr=get_cust.listIterator();
					cust=litr.next();
					gt.bill_no=rs.getInt("bill_no");
					gt.cust_name=cust.cust_name;
					gt.cust_addr=cust.cust_addr;
					gt.doct_name=cust.doct_name;
					gt.bill_dt=cust.bill_dt;
					gt.batch=rs.getString("batch_no");
					gt.med_name=rs.getString("med_name"); 
					gt.comp_name=rs.getString("comp_name");
					gt.mfg_dt=rs.getDate("tmfg_date"); 
					gt.exp_dt=rs.getDate("texp_date"); 
					gt.quantity=rs.getInt("quantity");
					gt.tab_bill=rs.getDouble("tab_bill");
					ret_trans.add(i++,gt);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ret_trans;
	}
}
