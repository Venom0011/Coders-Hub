package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;




import com.model.login;
import com.model.register;
import com.model.superadmin;
import com.model.upload;

public class daoclass {

	// Register Connection
	public int create(List<register> lstreg) {
		register regmodel=lstreg.get(0);
		int i=0;
		Connection con=Datasource.getConnection();
		try {
			PreparedStatement pstate=con.prepareStatement("insert into Login values(?,?)");
		
			pstate.setString(1, regmodel.getEmail());
			pstate.setString(2, regmodel.getPassword());
			
			
			i=pstate.executeUpdate();
		}
		catch(SQLException e){
		}
		
		return i;
	}
	
	//Login Connection
	public boolean validateData(List<login> lstlogin) {
		boolean b=false;
		login lobj=lstlogin.get(0);
		
		Connection con=Datasource.getConnection();
		
		try {
			System.out.println("done");
			PreparedStatement pstate=con.prepareStatement("select * from Login where email=? and pass=?");
			pstate.setString(1, lobj.getEmail());
			pstate.setString(2, lobj.getPassword());
			ResultSet rs=pstate.executeQuery();
			if(rs.next()) {
				b=true;
			}
			System.out.println("done");
		}
		catch(SQLException e){
			System.out.println(e);
		}
	return b;
	}
	
	// Upload Connection
	
	public boolean uploaddata(upload u) {
		boolean b=false;
		Connection con=Datasource.getConnection();
		
		try {
			System.out.println("done");
			PreparedStatement pstate=con.prepareStatement("insert into upload(fname,email,mob,projectname,descrip,pic) values(?,?,?,?,?,?)");
			System.out.println("done");
			pstate.setString(1, u.getFname());
			pstate.setString(2, u.getEmail());
			pstate.setString(3, u.getMobno());
			pstate.setString(4, u.getProjectname());
			pstate.setString(5, u.getDesc());
			pstate.setString(6, u.getPic());
		
		
			pstate.executeUpdate();
			b=true;
			System.out.println("Success");
		}catch(SQLException e) {
			System.out.println(e);
			b=false;
		}
		return b;
	}
	
	public List<upload> getallproducts(){
		List<upload> users = new ArrayList<>();		
		try (Connection connection = Datasource.getConnection();

				
			PreparedStatement preparedStatement = connection.prepareStatement("select * from upload");) {
			System.out.println(preparedStatement);
			
			ResultSet rs = preparedStatement.executeQuery();

			
			while (rs.next()) {
				int id = rs.getInt("id");
				String fname = rs.getString("fname");
				String email = rs.getString("email");
				String mobno=rs.getString("mob");
				String projectname=rs.getString("projectname");
				String desc=rs.getString("descrip");
				String pic=rs.getString("pic");
				users.add( new upload (id,fname,email,mobno,projectname,desc,pic));
				System.out.println("done");
			}
		} catch (SQLException e) {
				System.out.println(e);
		}
		return users;
	}
	
	public boolean supervalidateData(List<superadmin> lstlogin) {
		boolean b=false;
		superadmin lobj=lstlogin.get(0);
		
		Connection con=Datasource.getConnection();
		
		try {
			System.out.println("done");
			PreparedStatement pstate=con.prepareStatement("select * from superadmin where email=? and pass=?");
			pstate.setString(1, lobj.getEmail());
			pstate.setString(2, lobj.getPass());
			ResultSet rs=pstate.executeQuery();
			if(rs.next()) {
				b=true;
			}
			System.out.println("done");
		}
		catch(SQLException e){
			System.out.println(e);
		}
	return b;
	}
	
	public boolean deleteproject(int id) {
		boolean b=false;
	try {
		Connection con=Datasource.getConnection();
		
		String sql="delete from upload where id=?";
		PreparedStatement pstate=con.prepareStatement(sql);
		pstate.setInt(1, id);
		
		int i=pstate.executeUpdate();
		if(i==1) {
			b=true;
		}
		
		
	} catch (Exception e) {
	e.printStackTrace();
	}	
		
		return b;
	}
	
	public upload getprojectbyId(int id) {
		upload u=null;
		try (Connection connection = Datasource.getConnection();

				
				PreparedStatement preparedStatement = connection.prepareStatement("select * from upload where id=?");) {
				System.out.println(preparedStatement);
				
				preparedStatement.setInt(1, id);
				ResultSet rs = preparedStatement.executeQuery();

				
				while (rs.next()) {
					u=new upload();
					u.setPid(rs.getInt(1));
					u.setFname(rs.getString(2));
					u.setEmail(rs.getString(3));
					u.setMobno(rs.getString(4));
					u.setProjectname(rs.getString(5));
					u.setDesc(rs.getString(6));
					u.setPic(rs.getString(7));
					System.out.println("done");
				}
			} catch (SQLException e) {
					System.out.println(e);
			}
		
		return u;
		
	}
	
}
