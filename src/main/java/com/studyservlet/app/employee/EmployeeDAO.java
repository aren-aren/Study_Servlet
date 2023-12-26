package com.studyservlet.app.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.studyservlet.app.util.DBConnector;

public class EmployeeDAO {
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
