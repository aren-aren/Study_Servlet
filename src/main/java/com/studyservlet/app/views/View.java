package com.studyservlet.app.views;

import java.util.List;

import com.studyservlet.app.departments.DepartmentDTO;
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
}
