package edu.ciit.iot.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//import com.mysql.cj.xdevapi.PreparableStatement;

public class DBtool {
	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/kelodb", "root","root");
			System.out.println("ÒÑ¿ªÆô");
			return connection;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	public static List<Operater> query(String id, String md5PWD) {
		List<Operater> operaterliList = new ArrayList<>();
		
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = DBtool.getConnection();
			statement = connection.createStatement();
			String sqlString = "SELECT * FROM operaterinfo where id= '"+ id +"' and password= '" + md5PWD + "'";
			resultSet = statement.executeQuery(sqlString);
			while (resultSet.next()) {
				Operater operater = new Operater();
				operater.setId(resultSet.getString(1));
				operater.setName(resultSet.getString(2));
				operater.setTel(resultSet.getString(3));
				operater.setAddr(resultSet.getString(4));
				if(resultSet.getBoolean(5)) {
					operater.setDelFlag(true);
					
				}else {
					operater.setDelFlag(false);
				}
				operater.setPassWord(resultSet.getString(6));
				
				operaterliList.add(operater);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			resultSet.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return operaterliList;
		
	}
	
	public static List<Operater> query(String id) {
		List<Operater> operaterliList = new ArrayList<>();
		
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = DBtool.getConnection();
			statement = connection.createStatement();
			String sqlString = "SELECT * FROM operaterinfo where id= '"+ id + "'";
			resultSet = statement.executeQuery(sqlString);
			while (resultSet.next()) {
				Operater operater = new Operater();
				operater.setId(resultSet.getString(1));
				operater.setName(resultSet.getString(2));
				operater.setTel(resultSet.getString(3));
				operater.setAddr(resultSet.getString(4));
				if(resultSet.getBoolean(5)) {
					operater.setDelFlag(true);
					
				}else {
					operater.setDelFlag(false);
				}
				operater.setPassWord(resultSet.getString(6));
				
				operaterliList.add(operater);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			resultSet.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return operaterliList;
		
	}
	
	
	public static List<Cylinder> queryCylinder(String id) {
		List<Cylinder> cylinderList = new ArrayList<>();
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			connection = DBtool.getConnection();
			statement = connection.createStatement();
			String sqlString = "SELECT * FROM cylinderinfo where id= '"+ id +"'";
			resultSet = statement.executeQuery(sqlString);
			while (resultSet.next()) {
				Cylinder cylinder = new Cylinder();
				cylinder.setId(resultSet.getString(1));
				cylinder.setFactory(resultSet.getString(2));
				cylinder.setRightUnit(resultSet.getString(3));
				cylinder.setGasType(resultSet.getString(4));
				cylinder.setTareWeight(resultSet.getInt(5));
				cylinder.setMaxWight(resultSet.getInt(6));
				cylinderList.add(cylinder);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			resultSet.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cylinderList;
	}
	
	public static void recode(OperateRecorder operateRecorder) {
//		List<OperateRecorder> operateRecorders = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Statement statement = null;
		
		try {
			connection = DBtool.getConnection();
			statement = connection.createStatement();
			String sqlString = 
					"insert into operaterecord (operaterId,cylinderId,gasType,beginWeight,endWeight,operateDate) values (?,?,?,?,?,?)";
			
			preparedStatement = connection.prepareStatement(sqlString);
			
			preparedStatement.setString(1, operateRecorder.getOperateId());
			preparedStatement.setString(2, operateRecorder.getCylinderId());
			preparedStatement.setString(3, operateRecorder.getGasType());
			preparedStatement.setInt(4, operateRecorder.getBeginWeight());
			preparedStatement.setInt(5, operateRecorder.getEndWight());
			preparedStatement.setString(6, operateRecorder.getOperateData());
//			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
//			resultSet.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void addCylinder(Cylinder cylinder) {
//		List<OperateRecorder> operateRecorders = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Statement statement = null;
		
		try {
			connection = DBtool.getConnection();
			statement = connection.createStatement();
			String sqlString = 
					"insert into cylinderinfo (id,factory,rightunit,gasType,tareweight,maxweight) values (?,?,?,?,?,?)";
			
			preparedStatement = connection.prepareStatement(sqlString);
			
			preparedStatement.setString(1, cylinder.getId());
			preparedStatement.setString(2, cylinder.getFactory());
			preparedStatement.setString(3, cylinder.getRightUnit());
			preparedStatement.setString(4, cylinder.getGasType());
			preparedStatement.setInt(5, cylinder.getTareWeight());
			preparedStatement.setInt(6, cylinder.getMaxWight());
		
			preparedStatement.executeUpdate();
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
//			resultSet.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static boolean updateCylinder(Cylinder cylinder) {
		
		
//		List<OperateRecorder> operateRecorders = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Statement statement = null;
		
		try {
			connection = DBtool.getConnection();
			statement = connection.createStatement();
			String sqlString = 
					"update cylinderinfo set factory = ?,rightunit=?,gasType=?,tareweight=?,maxweight=? where id=?";
			
			preparedStatement = connection.prepareStatement(sqlString);
			
			
			preparedStatement.setString(1, cylinder.getFactory());
			preparedStatement.setString(2, cylinder.getRightUnit());
			preparedStatement.setString(3, cylinder.getGasType());
			preparedStatement.setInt(4, cylinder.getTareWeight());
			preparedStatement.setInt(5, cylinder.getMaxWight());
			preparedStatement.setString(6, cylinder.getId());
		
			preparedStatement.executeUpdate();
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		try {
//			resultSet.close();
			statement.close();
			connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
public static boolean deleteCylinder(String id) {
		
		
//		List<OperateRecorder> operateRecorders = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Statement statement = null;
		
		try {
			connection = DBtool.getConnection();
			statement = connection.createStatement();
			String sqlString = 
					"delete from cylinderinfo where id=?";
			
			preparedStatement = connection.prepareStatement(sqlString);
			
			preparedStatement.setString(1, id);
		
			preparedStatement.executeUpdate();
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		try {
//			resultSet.close();
			statement.close();
			connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	

}
