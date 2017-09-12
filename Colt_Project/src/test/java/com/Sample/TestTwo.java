package com.Sample;

import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class TestTwo {

	public static void main(String args[]) throws Exception {

		Fillo fillo = new Fillo();
		Connection connection = fillo.getConnection("D:\\List_Price_Small.xlsx");
		String strQuery = "SELECT  * FROM Sheet1 WHERE Country = 'Germany' AND Coverage='Metro' "
				+ "AND Bandwidth='100G Unprotected' AND Pricing_Segment ='SME' AND Building_Type='RB-RB'";
		Recordset recordset = connection.executeQuery(strQuery);

		//System.out.println(recordset.toString());
		while (recordset.next()) {
			System.out.println(recordset.getField("Zone 1 NRC"));
		}

		recordset.close();
		connection.close();

	}
}
