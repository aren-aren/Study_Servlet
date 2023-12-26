package com.studyservlet.app.location;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.studyservlet.app.util.DBConnector;

public class LocationDAO {
	public List<LocationDTO> getList() throws Exception {
		Connection con = DBConnector.getConnector();
		
		String sql = "SELECT * FROM LOCATIONS";
		
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		List<LocationDTO> locations = new ArrayList<LocationDTO>();
		
		while(rs.next()) {
			LocationDTO locationDTO = new LocationDTO();
			locationDTO.setLocation_id(rs.getInt("LOCATION_ID"));
			locationDTO.setStreet_address(rs.getString("STREET_ADDRESS"));
			locationDTO.setPostal_code(rs.getString("POSTAL_CODE"));
			locationDTO.setCity(rs.getString("CITY"));
			locationDTO.setState_province(rs.getString("STATE_PROVINCE"));
			locationDTO.setCountry_id(rs.getString("COUNTRY_ID"));
			locations.add(locationDTO);
		}
		
		DBConnector.disConnect(rs, st, con);
	
		return locations;
	}
	
	public LocationDTO getDetail(LocationDTO dto) throws Exception {
		Connection con = DBConnector.getConnector();
		String sql = "SELECT * FROM LOCATIONS WHERE LOCATION_ID = ?";
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, dto.getLocation_id());
		
		ResultSet rs = st.executeQuery();
		
		LocationDTO locationDTO = null;
		if(rs.next()) {
			locationDTO = new LocationDTO();

			locationDTO.setLocation_id(rs.getInt("LOCATION_ID"));
			locationDTO.setStreet_address(rs.getString("STREET_ADDRESS"));
			locationDTO.setPostal_code(rs.getString("POSTAL_CODE"));
			locationDTO.setCity(rs.getString("CITY"));
			locationDTO.setState_province(rs.getString("STATE_PROVINCE"));
			locationDTO.setCountry_id(rs.getString("COUNTRY_ID"));
		}
		
		return locationDTO;
	}
}
