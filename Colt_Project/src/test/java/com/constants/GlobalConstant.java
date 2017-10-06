package com.constants;


public class GlobalConstant {
	
	public enum FileNames {
		TestDataRelativePath("src/test/resources/testdata/"),
		C4C_TEST_DATA("C4C_Data"),
		CONFIG("application"),
		CPQ_TEST_DATA("CPQ_Data"),
		CSV_SHEET("Deal Pricing Upload");
		
		
		private String value;
		private FileNames(String value) {
			this.value = value;
		}
		
		public String toString() {
			return value;
		}
	}
	
	public final static String BUILDING_RETAIL = "Retail Building";
	public final static String BUILDING_KEY = "DC - Key";
	public final static String BUILDING_STANDARD = "DC- Standard";
	public final static String DEAL_PRICE_UPLOAD_SHEET = System.getProperty("user.dir")+"\\TestData\\Deal Pricing Upload.csv";
	

}
