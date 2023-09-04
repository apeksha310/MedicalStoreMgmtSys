package MedicalShop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.ListIterator;

import javax.swing.JOptionPane;

class stock extends medicine {
	public String batch_no;
	protected Date mfg_dt;
	protected Date exp_dt;
	protected int avai_in_stock;
	boolean isValidBatch() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/medicalshop","dhk","704785");	
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery("Select count(batch_no) from stock where batch_no='"+batch_no+"'");							
			rs.next();
			int count=rs.getInt("count(batch_no)");
			if(count==1) {
				conn.close();
				stmt.close();
				rs.close();
				return true;
			}
			else {
				conn.close();
				stmt.close();
				rs.close();
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	LinkedList<stock> getStockDetails()	{
		LinkedList<stock> ret_stk=new LinkedList<stock>();
		try {
			if(this.batch_no!=null) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/medicalshop","dhk","704785");	
				Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery("select * from stock where batch_no='"+this.batch_no+"'");
				rs.next();
				medicine gm=new medicine();
				gm.med_name=rs.getString("medicine_name");
				stock rst=new stock();
				LinkedList<medicine> lm=new LinkedList<medicine>();
				lm=gm.getMedInfo();
				ListIterator<medicine> litr=lm.listIterator();	
				gm=litr.next();
				rst.batch_no=this.batch_no;
				rst.med_name=gm.med_name;
				rst.comp_name=gm.comp_name;
				rst.tab_per_packet=gm.tab_per_packet;
				rst.price_per_unit=gm.price_per_unit;
				rst.exp_period=gm.exp_period;
				rst.med_type=gm.med_type;
				rst.mfg_dt=rs.getDate("mfg_date");
				rst.exp_dt=rs.getDate("exp_date");
				rst.avai_in_stock=rs.getInt("available_in_stock");
				ret_stk.add(rst);
				conn.close();
				stmt.close();
				rs.close();
			}
			else {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/medicalshop","dhk","704785");	
				Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery("select * from stock order by available_in_stock");
				while(rs.next()) {
					medicine gm=new medicine();
					gm.med_name=rs.getString("medicine_name");
					stock rst=new stock();
					LinkedList<medicine> lm=new LinkedList<medicine>();
					lm=gm.getMedInfo();
					ListIterator<medicine> litr=lm.listIterator();	
					gm=litr.next();
					rst.batch_no=rs.getString("batch_no");
					rst.med_name=gm.med_name;
					rst.comp_name=gm.comp_name;
					rst.tab_per_packet=gm.tab_per_packet;
					rst.price_per_unit=gm.price_per_unit;
					rst.exp_period=gm.exp_period;
					rst.med_type=gm.med_type;
					rst.mfg_dt=rs.getDate("mfg_date");
					rst.exp_dt=rs.getDate("exp_date");
					rst.avai_in_stock=rs.getInt("available_in_stock");
					ret_stk.add(rst);
				}
				conn.close();
				stmt.close();
				rs.close();
			}
		}catch(Exception e)		{
			e.printStackTrace();
		}
		return ret_stk;
	}
	int updateAvailableInStock() {
		int action=0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/medicalshop","dhk","704785");	
			PreparedStatement ps = conn.prepareStatement("update stock set available_in_stock=? where batch_no=?");
			ps.setInt(1,this.avai_in_stock);
			ps.setString(2,this.batch_no);
			action=ps.executeUpdate();
			conn.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}		
		return action;
	}
	int deleteBatch() {
		int action=0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/medicalshop","dhk","704785");
			PreparedStatement ps = conn.prepareStatement("delete from stock where batch_no=?");
			ps.setString(1,this.batch_no);
			action=ps.executeUpdate();
			conn.close();
			ps.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return action;
	}
	int updateStock() {
		int action=0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/medicalshop","dhk","704785");
			PreparedStatement ps = conn.prepareStatement("insert into stock values(?,?,?,?,?)");
			ps.setString(1,this.batch_no);
			ps.setString(2,this.med_name);
			ps.setString(3,new SimpleDateFormat("yyyy-MM-dd").format(this.mfg_dt));
			ps.setString(4,new SimpleDateFormat("yyyy-MM-dd").format(this.exp_dt));
			ps.setInt(5,this.avai_in_stock);
			action=ps.executeUpdate();
			conn.close();
			ps.close();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null,"Please Insert Correct Values");
		}
		return action;
	}
	boolean isMedicineAvailable() {
		boolean out=false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/medicalshop","dhk","704785");	
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery("Select count(batch_no) from stock where medicine_name='"+this.med_name+"'");							
			rs.next();
			int count=rs.getInt("count(batch_no)");
			if(count>0) {
				conn.close();
				stmt.close();
				rs.close();
				return true;
			}
			else {
				conn.close();
				stmt.close();
				rs.close();
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return out;
	}
}
