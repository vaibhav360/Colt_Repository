package com.util;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

import org.testng.Assert;

import com.util.DriverTestCase.BuildingType;
import com.util.DriverTestCase.CurrencyType;

public class Utilities {

	// Get absolute path
	public static String getPath() {
		String path = "";
		File file = new File("");
		String absolutePathOfFirstFile = file.getAbsolutePath();
		path = absolutePathOfFirstFile.replaceAll("\\\\+", "/");
		return path;
	}

	// Creating file name
	public static String getFileName(String file) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
		Calendar cal = Calendar.getInstance();
		String fileName = file + dateFormat.format(cal.getTime());
		return fileName;
	}

	// Get absolute path
	public static String getPathUpload() {
		String path = "";
		File file = new File("");
		String absolutePathOfFirstFile = file.getAbsolutePath();
		path = absolutePathOfFirstFile.replaceAll("/", "//");
		return path;
	}

	// Get random integer
	public static int getRandomInteger(int aStart, int aEnd) {
		Random aRandom = new Random();
		if (aStart > aEnd) {
			throw new IllegalArgumentException("Start cannot exceed End.");
		}
		// get the range, casting to long to avoid overflow problems
		long range = (long) aEnd - (long) aStart + 1;
		// compute a fraction of the range, 0 <= frac < range
		long fraction = (long) (range * aRandom.nextDouble());
		int randomNumber = (int) (fraction + aStart);
		return randomNumber;
	}

	// Get random string
	public static String randomString(int len) {
		String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		return sb.toString();
	}

	public static Double currencyConvertor(String dbPrice, String dbCurrency, String expectedCurrency) {
		Double price = Double.parseDouble(dbPrice);
		Double tmp=0.0;

		CurrencyType expectedCurrecyType = CurrencyType.valueOf(expectedCurrency);

		CurrencyType dbCurrecyType = CurrencyType.valueOf(dbCurrency);

		switch (expectedCurrecyType) {
		case EUR:
			switch (dbCurrecyType) {
			case EUR:
				tmp = price;
				break;
			case GBP:
				tmp = price * 0.841993;
				break;
			case USD:
				tmp = price * 1.334005;
				break;
			case SEK:
				tmp = price * 8.67667;
				break;
			case CHF:
				tmp = price * 1.2344;
				break;
			case DKK:
				tmp = price * 7.457935;
				break;
			default:
				Assert.fail("Currency type fetched from DB is not found");
			}
			break;
		case GBP:
			switch (dbCurrecyType) {
			case GBP:
				tmp = price ;
				break;
			case USD:
				tmp = price * 1.58434215;
				break;
			case SEK:
				tmp = price *10.3049194;
				break;
			case CHF:
				tmp = price * 1.466045442;
				break;
			case DKK:
				tmp = price * 8.857478625;
				break;
			case EUR:
				tmp = price * 1.18765833;
				break;
			default:
				Assert.fail("Currency type fetched from DB is not found");
			}
			break;
		case USD:
			switch (dbCurrecyType) {
			case USD:
				tmp = price ;
				break;
			case GBP:
				tmp = price * 0.631176795;
				break;
			case SEK:
				tmp = price * 6.504225996;
				break;
			case CHF:
				tmp = price * 0.925333863;
				break;
			case DKK:
				tmp = price * 5.590634968;
				break;
			case EUR:
				tmp = price * 0.749622378;
				break;
			default:
				Assert.fail("Currency type fetched from DB is not found");
			}
			break;
		default:
			Assert.fail("Currency type not found");
		}
		
		double finalValue = (double)Math.round( tmp * 100.0 ) / 100.0;
		return finalValue;

	}

}
