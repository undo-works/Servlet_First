package first.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import first.bean.Customer;

public class CustomerSearchDBAccess extends ControlDBAccess{
	
	public ArrayList<Customer>searchCustomerByTel(String tel)throws Exception{
		Connection con = createConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Customer> list = new ArrayList<Customer>();
		try{
				String sql = 	"SELECT CUSTID, CUSTNAME, KANA, ADDRESS " +
								"FROM CUSTOMER WHERE TEL = ?;";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,tel);
				rs = pstmt.executeQuery();
				while(rs.next() == true) {
					int id = rs.getInt("CUSTID");
					String name = rs.getString("CUSTNAME");
					String kana = rs.getString("KANA");
					String address = rs.getString("ADDRESS");
					Customer bean = new Customer(id, name, kana, tel, address);
					list.add(bean);
				}
		} catch(SQLException e) {
			throw new Exception("顧客情報検索処理に失敗しました！");
		} finally {
			try{
				if(rs != null) {
					rs.close();
				}
			} catch(SQLException e) {
				throw new Exception("顧客情報検索処理に失敗しました！");
			}
			try{
				if(pstmt != null) {
					pstmt.close();
				}
			} catch(SQLException e) {
				throw new Exception("顧客情報検索処理に失敗しました！");
			}
		}
		closeConnection(con);
		return list;
	}
	/*
	public ArrayList<Customer>searchCustomerByKana(String kana)throws Exception{
		Connection con = createConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//kana = "%" + kana + "%";
		ArrayList<Customer> list = new ArrayList<Customer>();
		try{
				String sql = 	"SELECT CUSTID, CUSTNAME, KANA, TEL, ADDRESS " +
								"FROM CUSTOMER WHERE KANA LIKE ?;";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,"%" + kana + "%");
				rs = pstmt.executeQuery();
				while(rs.next() == true) {
					int id = rs.getInt("CUSTID");
					String name = rs.getString("CUSTNAME");
					String kana2 = rs.getString("KANA");
					String tel = rs.getString("TEL");
					String address = rs.getString("ADDRESS");
					Customer bean = new Customer(id, name, kana2, tel, address);
					list.add(bean);
				}
		} catch(SQLException e) {
			throw new Exception("顧客情報検索処理に失敗しました！");
		} finally {
			try{
				if(rs != null) {
					rs.close();
				}
			} catch(SQLException e) {
				throw new Exception("顧客情報検索処理に失敗しました！");
			}
			try{
				if(pstmt != null) {
					pstmt.close();
				}
			} catch(SQLException e) {
				throw new Exception("顧客情報検索処理に失敗しました！");
			}
		}
		closeConnection(con);
		return list;
	}
	public ArrayList<Customer>searchCustomer(String tel,String kana)throws Exception{
		Connection con = createConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Customer> list = new ArrayList<Customer>();
		try{
				String sql = 	"SELECT CUSTID, CUSTNAME, KANA, TEL, ADDRESS " +
								"FROM CUSTOMER WHERE TEL = ? AND KANA LIKE ?;";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,tel);
				pstmt.setString(2,"%" + kana + "%");
				rs = pstmt.executeQuery();
				while(rs.next() == true) {
					int id = rs.getInt("CUSTID");
					String name = rs.getString("CUSTNAME");
					String kana2 = rs.getString("KANA");
					String address = rs.getString("ADDRESS");
					Customer bean = new Customer(id, name, kana2, tel, address);
					list.add(bean);
				}
		} catch(SQLException e) {
			throw new Exception("顧客情報検索処理に失敗しました！");
		} finally {
			try{
				if(rs != null) {
					rs.close();
				}
			} catch(SQLException e) {
				throw new Exception("顧客情報検索処理に失敗しました！");
			}
			try{
				if(pstmt != null) {
					pstmt.close();
				}
			} catch(SQLException e) {
				throw new Exception("顧客情報検索処理に失敗しました！");
			}
		}
		closeConnection(con);
		return list;
	}

	public Customer searchCustomerByCustId(int custId)throws Exception{
		Connection con = createConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Customer customer = null;
		try{
				String sql = 	"SELECT CUSTNAME, KANA, TEL, ADDRESS " +
								"FROM CUSTOMER WHERE CUSTID = ?;";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1,custId);
				rs = pstmt.executeQuery();
				if(rs.next() == true) {
					String name = rs.getString("CUSTNAME");
					String kana = rs.getString("KANA");
					String tel = rs.getString("TEL");
					String address = rs.getString("ADDRESS");
					customer = new Customer(custId, name, kana, tel, address);
				}
		} catch(SQLException e) {
			throw new Exception("顧客情報検索処理に失敗しました！");
		} finally {
			try{
				if(rs != null) {
					rs.close();
				}
			} catch(SQLException e) {
				throw new Exception("顧客情報検索処理に失敗しました！");
			}
			try{
				if(pstmt != null) {
					pstmt.close();
				}
			} catch(SQLException e) {
				throw new Exception("顧客情報検索処理に失敗しました！");
			}
		}
		closeConnection(con);
		return customer;
	}

	public ArrayList<Customer>searchAllCustomer()throws Exception{
		Connection con = createConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Customer> list = new ArrayList<Customer>();
		try{
				String sql = 	"SELECT CUSTID, CUSTNAME, KANA, TEL, ADDRESS " +
								"FROM CUSTOMER;";
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next() == true) {
					int id = rs.getInt("CUSTID");
					String name = rs.getString("CUSTNAME");
					String kana = rs.getString("KANA");
					String tel = rs.getString("TEL");
					String address = rs.getString("ADDRESS");
					Customer bean = new Customer(id, name, kana, tel, address);
					list.add(bean);
				}
		} catch(SQLException e) {
			throw new Exception("顧客情報検索処理に失敗しました！");
		} finally {
			try{
				if(rs != null) {
					rs.close();
				}
			} catch(SQLException e) {
				throw new Exception("顧客情報検索処理に失敗しました！");
			}
			try{
				if(pstmt != null) {
					pstmt.close();
				}
			} catch(SQLException e) {
				throw new Exception("顧客情報検索処理に失敗しました！");
			}
		}
		closeConnection(con);
		return list;
	}*/
}