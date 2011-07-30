package net.slipp.support;

import java.util.Date;
import java.util.TimeZone;

public class DateTimeUtils {
	public static Date now(){
		return new Date(System.currentTimeMillis() + TimeZone.getTimeZone("GMT+9").getRawOffset());
	}
}
