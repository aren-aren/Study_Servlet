package com.studyservlet.app.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.studyservlet.app.util.DBConnector;

public class EmployeeDAO {
	
	//사원을 추가
	public int add(EmployeeDTO dto) throws Exception {
		Connection con = DBConnector.getConnector();
		String sql = "INSERT INTO EMPLOYEES"
				+ " VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)";
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, dto.getEmployee_id());
		st.setString(2, dto.getFirst_name());
		st.setString(3, dto.getLast_name());
		st.setString(4, dto.getEmail());
		st.setString(5, dto.getPhone_number());
		st.setDate(6, dto.getHire_date());
		st.setString(7, dto.getJob_id());
		st.setDouble(8, dto.getSalary());
		st.setDouble(9, dto.getCommission_pct());
		st.setInt(10, dto.getManager_id());
		st.setInt(11, dto.getDepartment_id());
		
		int result = st.executeUpdate();
		
		DBConnector.disConnect(st, con);
		
		return result;
	}
	
	public Map<String, Integer> getSalary() throws Exception{
		Map<String, Integer> map = new HashMap<String, Integer>();
		Connection con = DBConnector.getConnector();
		
		String sql = "SELECT SUM(SALARY) S, COUNT(EMPLOYEE_ID) C FROM EMPLOYEES";
		
		PreparedStatement st =con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		rs.next();
		
		map.put("sum", rs.getInt("S"));
		map.put("count", rs.getInt("C"));
		
		DBConnector.disConnect(rs, st, con);
		
		return map;
	}
	
	public List<EmployeeDTO> getList() throws Exception {
		Connection con = DBConnector.getConnector();
		
		String sql = "SELECT * FROM EMPLOYEES";
		
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		List<EmployeeDTO> employees = new ArrayList<EmployeeDTO>();
		
		while(rs.next()) {
			EmployeeDTO employeeDTO = new EmployeeDTO();
			employeeDTO.setEmployee_id(rs.getInt("EMPLOYEE_ID"));
			employeeDTO.setFirst_name(rs.getString("FIRST_NAME"));
			employeeDTO.setLast_name(rs.getString("LAST_NAME"));
			employeeDTO.setEmail(rs.getString("EMAIL"));
			employeeDTO.setPhone_number(rs.getString("PHONE_NUMBER"));
			employeeDTO.setHire_date(rs.getDate("HIRE_DATE"));
			employeeDTO.setJob_id(rs.getString("JOB_ID"));
			employeeDTO.setSalary(rs.getDouble("Salary"));
			employeeDTO.setCommission_pct(rs.getDouble("COMMISSION_PCT"));
			employeeDTO.setManager_id(rs.getInt("MANAGER_ID"));
			employeeDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
			
			employees.add(employeeDTO);
		}
		
		DBConnector.disConnect(rs, st, con);
	
		return employees;
	}
	
	public EmployeeDTO getDetail(EmployeeDTO dto) throws Exception {
		Connection con = DBConnector.getConnector();
		String sql = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID = ?";
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, dto.getEmployee_id());
		
		ResultSet rs = st.executeQuery();
		
		EmployeeDTO employeeDTO = null;
		if(rs.next()) {
			employeeDTO = new EmployeeDTO();

			employeeDTO.setEmployee_id(rs.getInt("EMPLOYEE_ID"));
			employeeDTO.setFirst_name(rs.getString("FIRST_NAME"));
			employeeDTO.setLast_name(rs.getString("LAST_NAME"));
			employeeDTO.setEmail(rs.getString("EMAIL"));
			employeeDTO.setPhone_number(rs.getString("PHONE_NUMBER"));
			employeeDTO.setHire_date(rs.getDate("HIRE_DATE"));
			employeeDTO.setJob_id(rs.getString("JOB_ID"));
			employeeDTO.setSalary(rs.getDouble("Salary"));
			employeeDTO.setCommission_pct(rs.getDouble("COMMISSION_PCT"));
			employeeDTO.setManager_id(rs.getInt("MANAGER_ID"));
			employeeDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
		}
		
		return employeeDTO;
	}
}
