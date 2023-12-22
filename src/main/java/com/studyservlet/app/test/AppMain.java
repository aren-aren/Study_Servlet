package com.studyservlet.app.test;

import java.util.List;

import com.studyservlet.app.departments.DepartmentDAO;
import com.studyservlet.app.departments.DepartmentDTO;
import com.studyservlet.app.regions.RegionDAO;
import com.studyservlet.app.regions.RegionDTO;
import com.studyservlet.app.views.View;

public class AppMain {

	public static void main(String[] args) {

		DepartmentDAO departmentDAO = new DepartmentDAO();
		RegionDAO regionDAO = new RegionDAO();
		View view = new View();
		
		try {
//			List<RegionDTO> list = regionDAO.getList();
//			view.regionView(list);
//			System.out.println("=======================================================");
//			List<DepartmentDTO> dlist = departmentDAO.getList();
//			view.departmentView(dlist);
			
//			RegionDTO regionDTO = new RegionDTO();
//			regionDTO.setRegion_id(6);
//			regionDTO = regionDAO.getDetail(regionDTO);
//			
//			if(regionDTO != null) {
//				System.out.println(regionDTO.getRegion_name());
//			} else {
//				System.out.println("없는 아이디");
//			}
			
			DepartmentDTO departmentDTO = new DepartmentDTO();
			departmentDTO.setDepartment_id(20);
			departmentDTO = departmentDAO.getDetail(departmentDTO);
			
			if(departmentDTO != null) {
				System.out.println(departmentDTO.getDepartment_name());
			} else {
				System.out.println("없는 아이디");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
