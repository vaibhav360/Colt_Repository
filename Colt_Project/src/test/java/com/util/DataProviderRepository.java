package com.util;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.testng.annotations.DataProvider;

public class DataProviderRepository {

	@DataProvider(name = "getData")
	public static Object[][] setData() throws IOException, IllegalArgumentException, IllegalAccessException {
		// Rows - Number of times your test has to be repeated.
		// Columns - Number of parameters in test data.
		ExcelReader ex = new ExcelReader("TestData_WithContractTerm.xlsx", "sheet2");
		Object[][] data = new Object[ex.getRowCount()][ex.getColCount()];
		for (int i = 0; i < ex.getRowCount(); i++) {
			for (int j = 0; j < ex.getColCount(); j++) {
				data[i][j] = ex.readExcel(i + 1, j);
				System.out.println(i + " " + j);
			}
		}
		return data;
	}

	@DataProvider(name = "testDataProvider")
	public static Iterator<Object[]> loginDataProvider() throws IOException {
		
		Collection<Object[]> modelData = new ArrayList<Object[]>() {
			{
				ExcelReader ex = new ExcelReader("TestData_WithContractTerm.xlsx", "sheet2");
				for (int i = 0; i < ex.getRowCount(); i++) {
					DataModelCPQ cpqModel = new DataModelCPQ();
					cpqModel.setQuoteName(ex.readExcel(i + 1, 0));
					cpqModel.setCustomer(ex.readExcel(i + 1, 1));
					cpqModel.setCountry(ex.readExcel(i + 1, 2));
					cpqModel.setSegment(ex.readExcel(i + 1, 3));
					cpqModel.setContract_Term(ex.readExcel(i + 1, 4));
					cpqModel.setCoverage(ex.readExcel(i + 1, 5));
					cpqModel.setBuilding_Type(ex.readExcel(i + 1, 6));
					cpqModel.setSite_A_Add(ex.readExcel(i + 1, 7));
					cpqModel.setSite_B_Add(ex.readExcel(i + 1, 8));
					cpqModel.setLongLining_A(ex.readExcel(i + 1, 9));
					cpqModel.setIc_Site_A(ex.readExcel(i + 1, 10));
					cpqModel.setDual_Entry_Site_A(ex.readExcel(i + 1, 11));
					cpqModel.setOutsideBHI_Site_A(ex.readExcel(i + 1, 12));
					cpqModel.setLongLining_B(ex.readExcel(i + 1, 13));
					cpqModel.setIc_Site_B(ex.readExcel(i + 1, 14));
					cpqModel.setDual_Entry_Site_B(ex.readExcel(i + 1, 15));
					cpqModel.setOutsideBHI_Site_B(ex.readExcel(i + 1, 16));
					cpqModel.setSync(ex.readExcel(i + 1, 17));
					cpqModel.setResiliency(ex.readExcel(i + 1, 18));
					cpqModel.setBandWidth(ex.readExcel(i + 1, 19));
					cpqModel.setLag_Site_A(ex.readExcel(i + 1, 20));
					cpqModel.setDiversity(ex.readExcel(i + 1, 21));
					cpqModel.setPam(ex.readExcel(i + 1, 22));
					cpqModel.setPr(ex.readExcel(i + 1, 23));
					cpqModel.setFastTrack(ex.readExcel(i + 1, 24));
					cpqModel.setCos(ex.readExcel(i + 1, 25));
					add(new Object[] { cpqModel });				
					

				}
			}

		};
		return modelData.iterator();
	}

	public static int getObject(Object obj) throws IllegalArgumentException, IllegalAccessException {
		for (Field field : obj.getClass().getDeclaredFields()) {
			// field.setAccessible(true); // if you want to modify private fields
			System.out.println(field.getName() + " - " + field.getType() + " - " + field.get(obj));
		}
		return 0;
	}
}
