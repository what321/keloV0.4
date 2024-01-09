package edu.ciit.iot.database;

import java.util.List;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String idString = "001";
		List<Operater> listOperaters = DBtool.query(idString);
		Operater operater = listOperaters.get(0);
		System.out.println(operater.getName());

	}

}
