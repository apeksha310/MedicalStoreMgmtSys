package MedicalShop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.ListIterator;

import javax.swing.JOptionPane;

class medicine  {
	public String med_name;
	protected String comp_name;
	protected int tab_per_packet;
	protected double price_per_unit;
	protected int exp_period;
	protected String med_type;
	LinkedList<medicine> getMedInfo() {
		LinkedList<medicine> ret_med=new LinkedList<medicine>();
			if(this.med_name!=null) {	
			try { 
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/medicalshop","dhk","704785");	
				Statement stmt=conn.createStatement();	
				String med_info="select * from medicine where medicine_name='"+this.med_name+"'";
				ResultSet rs=stmt.executeQuery(med_info);
				rs.next();
				medicine gm=new medicine();
				gm.med_name=rs.getString("medicine_name");
				gm.comp_name=rs.getString("company_name");
				gm.tab_per_packet=rs.getInt("tab_per_packet");
				gm.price_per_unit=rs.getDouble("price_per_unit");
				gm.exp_period=rs.getInt("expiry_period");
				gm.med_type=rs.getString("medicine_type");
				ret_med.add(gm);
				conn.close();
				stmt.close();
				rs.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		else {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/medicalshop","dhk","704785");	
				Statement stmt=conn.createStatement();	
				ResultSet rs=stmt.executeQuery("select * from medicine");
				while(rs.next()) {
					medicine gm=new medicine();
					gm.med_name=rs.getString("medicine_name");
					gm.comp_name=rs.getString("company_name");
					gm.tab_per_packet=rs.getInt("tab_per_packet");
					gm.price_per_unit=rs.getDouble("price_per_unit");
					gm.exp_period=rs.getInt("expiry_period");
					gm.med_type=rs.getString("medicine_type");
					ret_med.add(gm);
				}
				conn.close();
				stmt.close();
				rs.close();
			}catch(Exception e)	{
				e.printStackTrace();
			}
		}
		return ret_med;
	}
	boolean is_h1()	{
		boolean out=false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/medicalshop","dhk","704785");	
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery("select medicine_type from medicine where medicine_name='"+this.med_name+"'");
			rs.next();
			if((rs.getString("medicine_type")).equals("H1"))
				out=true;
			else
				out=false;
			conn.close();
			stmt.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return out;
	}
	boolean isValidMedicine() {
		boolean action=false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/medicalshop","dhk","704785");	
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery("select count(medicine_name) from medicine where medicine_name='"+this.med_name+"'");
			rs.next();
			if((rs.getInt("count(medicine_name)"))==1)
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
	int addMedicine() {
		int action=0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/medicalshop","dhk","704785");
			PreparedStatement ps=null;
			ps=conn.prepareStatement("insert into medicine values(?,?,?,?,?,?)");
			ps.setString(1,this.med_name);
			ps.setString(2,this.comp_name);
			ps.setInt(3,this.tab_per_packet);
			ps.setDouble(4,this.price_per_unit);
			ps.setInt(5,this.exp_period);
			ps.setString(6,this.med_type);
			action=ps.executeUpdate();
			conn.close();
			ps.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Please Enter Valid Input");
		}
		return action;
	}
	String updateMedicine() {	
		String string="";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/medicalshop","dhk","704785");
			LinkedList<medicine> lm=new LinkedList<medicine>();
			medicine m=new medicine();
			m.med_name=this.med_name;
			if(this.tab_per_packet>0) {
				PreparedStatement ps=null;
				ps=conn.prepareStatement("update medicine set tab_per_packet=? where medicine_name=?");
				ps.setInt(1,this.tab_per_packet);
				ps.setString(2,this.med_name);
				if(ps.executeUpdate()==1)
					JOptionPane.showMessageDialog(null,"Updated Successfully\nTablets per Packet");
				ps.close();
				string=string+"a";
			}
			if(this.price_per_unit>0) {
				PreparedStatement ps=null;
				ps=conn.prepareStatement("update medicine set tab_per_packet=? where medicine_name=?");
				lm=m.getMedInfo();
				ListIterator<medicine> litr=lm.listIterator();
				m=litr.next();
				double price_per_unit=this.price_per_unit/(double)m.tab_per_packet;
				ps.setDouble(1,price_per_unit);
				ps.setString(2,this.med_name);
				if(ps.executeUpdate()==1)
					JOptionPane.showMessageDialog(null,"Updated Successfully\nPrice per unit");
				ps.close();
				string+="b";
			}
			if(this.exp_period>0) {
				PreparedStatement ps=null;
				ps=conn.prepareStatement("update medicine set tab_per_packet=? where medicine_name=?");
				ps.setInt(1,this.exp_period);
				ps.setString(2,this.med_name);
				if(ps.executeUpdate()==1)
					JOptionPane.showMessageDialog(null,"Updated Successfully\nExpiry Period");
				ps.close();
				string+="c";
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return string;
	}
	int deleteMedicine() {
		int action=0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/medicalshop","dhk","704785");
			PreparedStatement ps=null;
			ps=conn.prepareStatement("delete from medicine where medicine_name=?");
			ps.setString(1,this.med_name);
			action=ps.executeUpdate();
			conn.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return action;
	}
}
