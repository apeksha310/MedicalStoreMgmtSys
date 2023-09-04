package MedicalShop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

class customer {
	public int bill_no;
	protected String cust_name;
	protected String cust_addr;
	protected String doct_name;
	protected Date bill_dt;
	protected double bill_amt;
	int insertRecord() {
		int action=0;
		try {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/medicalshop","dhk","704785");
			PreparedStatement ps=null;
			ps=conn.prepareStatement("insert into customer values(?,?,?,?,?,?)");										
			ps.setInt(1,this.bill_no);
			ps.setString(2,this.cust_name);
			ps.setString(3,this.cust_addr);
			ps.setString(4,this.doct_name);
			ps.setString(5,sdf.format(this.bill_dt));
			ps.setDouble(6,this.bill_amt);	
			if((ps.executeUpdate()==1)) {
				action=1;
				conn.close();
				ps.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return action;
	}
	LinkedList<customer> getCustomer() {
		LinkedList<customer> l=new LinkedList<customer>();
		try {
			if(this.bill_no>0)	{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/medicalshop","dhk","704785");	
				Statement stmt=conn.createStatement();	
				String cust_info="select * from customer where bill_no='"+this.bill_no+"'";
				ResultSet rs=stmt.executeQuery(cust_info);
				while(rs.next()) {
				customer return_customer=new customer();
				return_customer.bill_no=rs.getInt("bill_no");
				return_customer.cust_name=rs.getString("customer_name");
				return_customer.cust_addr=rs.getString("customer_addr");
				return_customer.doct_name=rs.getString("doctor_name");
				return_customer.bill_dt=rs.getDate("bill_date");
				return_customer.bill_amt=rs.getDouble("bill_amt");
				l.add(return_customer);
				}
				conn.close();
				stmt.close();
				rs.close();
			}
			else {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/medicalshop","dhk","704785");	
				Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery("select * from customer order by bill_no desc");
				while(rs.next()) {
					customer return_customer=new customer();
					return_customer.bill_no=rs.getInt("bill_no");
					return_customer.cust_name=rs.getString("customer_name");
					return_customer.cust_addr=rs.getString("customer_addr");
					return_customer.doct_name=rs.getString("doctor_name");
					return_customer.bill_dt=rs.getDate("bill_date");
					return_customer.bill_amt=rs.getDouble("bill_amt");
					l.add(return_customer);
				}
				conn.close();
				stmt.close();
				rs.close();
			}
		}catch(Exception e)	{
			e.printStackTrace();
		}
		return l;
	}
	void deleteBill() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/medicalshop","dhk","704785");
			PreparedStatement ps=null;
			ps=conn.prepareStatement("delete from customer where bill_no=?");	
			ps.setInt(1,this.bill_no);
			ps.executeUpdate();
			conn.close();
			ps.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	int getMaxBillNo() {
		int max_bill_no=0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/medicalshop","dhk","704785");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select max(bill_no) from customer");
			rs.next();
			max_bill_no=rs.getInt("max(bill_no)");
			conn.close();
			stmt.close();
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return max_bill_no;
	}
	boolean isValidCustomer() {
		boolean action=false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/medicalshop","dhk","704785");	
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery("select count(bill_no) from customer where bill_no='"+this.bill_no+"'");
			rs.next();
			if((rs.getInt("count(bill_no)"))==1)
				action=true;
			else
				action=false;
			conn.close();
			stmt.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return action;
	}
}
