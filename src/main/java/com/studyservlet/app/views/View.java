package com.studyservlet.app.views;

import java.util.List;

import com.studyservlet.app.country.CountryDTO;
import com.studyservlet.app.departments.DepartmentDTO;
import com.studyservlet.app.employee.EmployeeDTO;
import com.studyservlet.app.location.LocationDTO;
import com.studyservlet.app.regions.RegionDTO;

public class View {
	
	//Regions를 출력
	public void regionView(List<RegionDTO> list) {
		for(RegionDTO region : list) {
			System.out.println(region.getRegion_id() + " : " + region.getRegion_name());
			System.out.println("---------------------------");
		}
	}
	
	public void departmentView(List<DepartmentDTO> list) {
		for(DepartmentDTO department : list) {
			System.out.println(department.getDepartment_id() + " : " + department.getDepartment_name() + " : " + department.getManager_id() + " : " + department.getLocation_id());
			System.out.println("---------------------------------------");
		}
	}
	
	public void employeeView(List<EmployeeDTO> list) {
		for(EmployeeDTO employee : list) {
			System.out.println(employee);
			System.out.println("---------------------------------------");
		}
	}
	
	public void locationView(List<LocationDTO> list) {
		for(LocationDTO location : list) {
			System.out.println(location);
			System.out.println("---------------------------------------");
		}
	}
	
	public void countryView(List<CountryDTO> list) {
		for(CountryDTO country : list) {
			System.out.println(country);
			System.out.println("---------------------------------------");
		}
	}
}
