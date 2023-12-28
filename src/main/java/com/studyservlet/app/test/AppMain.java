package com.studyservlet.app.test;

import java.sql.Date;
import java.util.Map;

import com.studyservlet.app.employee.EmployeeDAO;
import com.studyservlet.app.employee.EmployeeDTO;

import oracle.sql.DATE;

public class AppMain {

	public static void main(String[] args) {
		EmployeeDAO dao = new EmployeeDAO();
		
		EmployeeDTO dto = new EmployeeDTO();
		dto.setEmployee_id(Integer.parseInt("207"));
		dto.setFirst_name("Daniel");
		dto.setLast_name("Last");
		dto.setEmail("email@mailiam.mai");
		dto.setPhone_number("010-1231-4521");
		dto.setHire_date(Date.valueOf("2023-12-27"));
		dto.setJob_id("IT_PROG");
		dto.setSalary(Double.parseDouble("5000"));
		dto.setCommission_pct(0.12);
		dto.setManager_id(205);
		dto.setDepartment_id(60);
		
		try {
			int result = dao.add(dto);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
