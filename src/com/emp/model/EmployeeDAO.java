package com.emp.model;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.*;
import javax.servlet.ServletOutputStream;
import javax.sql.DataSource;




public class EmployeeDAO implements EmployeeDAO_interface{
	
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/G2DB");
		}catch(NamingException e){
			e.printStackTrace();
		}
	}
	private static final String INSERT_STMT =
			//Insert into  EMPLOYEE (EMP_NO,EMP_ACC,EMP_PWD,EMP_TITLE,EMP_NAME,EMP_IS_DELETE) values ('EMP' || lpad(SEQ_EMP_NO.NEXTVAL, 6,'0'),'2VLwRwro','XCkD3nh7','0','丁孟穎',0);
			"INSERT INTO employee(emp_no,emp_acc,emp_pwd,emp_title,emp_name,emp_is_delete) values('EMP' || lpad(SEQ_EMP_NO.NEXTVAL, 6,'0'),?,?,?,?,?)";
	private static final String GET_ALL_STMT =
			"SELECT EMP_NO,EMP_ACC,EMP_PWD,EMP_TITLE,EMP_NAME,EMP_IS_DELETE FROM EMPLOYEE";
	private static final String GET_ONE_STMT = 
			"SELECT EMP_NO,EMP_ACC,EMP_PWD,EMP_TITLE,EMP_NAME,EMP_IS_DELETE FROM EMPLOYEE WHERE EMP_NO = ?";
	private static final String UPDATE = 
			"UPDATE EMPLOYEE SET EMP_PWD=213123,EMP_TITLE=2,EMP_NAME=123,EMP_IS_DELETE=1 where emp_no = 'EMP000001'";
	@Override
	public void insert(EmployeeVO employeeVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, employeeVO.getEmp_acc());
			pstmt.setString(2, employeeVO.getEmp_pwd());
			pstmt.setInt(3, employeeVO.getEmp_title());
			pstmt.setString(4,employeeVO.getEmp_name());
			pstmt.setInt(5,employeeVO.getEmp_is_delete());


			pstmt.executeUpdate();

			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public EmployeeVO findByPrimaryKey(String emp_no) {
		EmployeeVO empVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setString(1, emp_no);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo �]�٬� Domain objects
				empVO = new EmployeeVO();
				empVO.setEmp_no(rs.getString("emp_no"));
				empVO.setEmp_acc(rs.getString("emp_acc"));
				empVO.setEmp_pwd(rs.getString("emp_pwd"));
				empVO.setEmp_title(rs.getInt("emp_title"));
				empVO.setEmp_name(rs.getString("emp_name"));
				empVO.setEmp_is_delete(rs.getInt("emp_is_delete"));
				//empVO.setEmp_pic(null);
			}

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return empVO;
		
	}

	@Override
	public List<EmployeeVO> getAll() {

		List<EmployeeVO> list = new ArrayList<EmployeeVO>();
		EmployeeVO empVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO �]�٬� Domain objects
				empVO = new EmployeeVO();
				empVO.setEmp_no(rs.getString("emp_no"));
				empVO.setEmp_acc(rs.getString("emp_acc"));
				empVO.setEmp_pwd(rs.getString("emp_pwd"));
				empVO.setEmp_title(rs.getInt("emp_title"));
				empVO.setEmp_name(rs.getString("emp_name"));
				empVO.setEmp_is_delete(rs.getInt("emp_is_delete"));
				list.add(empVO); // Store the row in the list
			}

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	}

	@Override
	public void update(EmployeeVO empVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

//			pstmt.setString(1, empVO.getEmp_pwd());
//			pstmt.setInt(2, empVO.getEmp_title());
//			pstmt.setString(3,empVO.getEmp_name());
//			pstmt.setInt(4,empVO.getEmp_is_delete());
//			pstmt.setString(5,empVO.getEmp_no());
			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		
	}
	

}
