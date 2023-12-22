package com.studyservlet.app.regions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.studyservlet.app.util.DBConnector;

public class RegionDAO {

	public List<RegionDTO> getList() throws Exception {
		Connection con = DBConnector.getConnector();
		
		String sql = "SELECT * FROM REGIONS";
		
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		List<RegionDTO> regions = new ArrayList<RegionDTO>();
		
		while(rs.next()) {
			RegionDTO dto = new RegionDTO();
			dto.setRegion_id(rs.getInt("REGION_ID"));
			dto.setRegion_name(rs.getString("REGION_NAME"));
			regions.add(dto);
		}
		
		DBConnector.disConnect(rs, st, con);
	
		return regions;
	}
	
	public RegionDTO getDetail(RegionDTO dto) throws Exception {
		Connection con = DBConnector.getConnector();
		String sql = "SELECT * FROM REGIONS WHERE REGION_ID = ?";
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, dto.getRegion_id());
		
		ResultSet rs = st.executeQuery();
		
		RegionDTO regionDTO = null;
		if(rs.next()) {
			regionDTO = new RegionDTO();
			regionDTO.setRegion_id(rs.getInt("REGION_ID"));
			regionDTO.setRegion_name(rs.getString("REGION_NAME"));
		}
		
		return regionDTO;
	}
	
}
