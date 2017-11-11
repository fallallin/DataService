package co.com.kallsonys.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static Date converStringToDate(String strDate) {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		try {

			Date date = formatter.parse(strDate);
			return date;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
