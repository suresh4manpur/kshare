package com.kshare.batch.upload;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class FileUtil {
	public static Date parseIntoDate(String dateStr) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date dt = null;
		if (dateStr != null && dateStr.trim().length() > 0) {
			try {
				dt = dateFormat.parse(dateStr);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		return new java.sql.Date(dt.getTime());

	}
}
