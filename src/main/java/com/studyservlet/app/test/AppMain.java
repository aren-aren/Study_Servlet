package com.studyservlet.app.test;

import com.studyservlet.app.util.DBConnector;

public class AppMain {

	public static void main(String[] args) {
		DBConnector connector = new DBConnector();
		connector.getConnector();

	}

}
