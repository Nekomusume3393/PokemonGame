package pokemon.pokedex.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class XDate {
	
	public static final String PATTERN_FULL = "yyyy-MM-dd HH:mm:ss";
	public static final String PATTERN_SHORT = "yyyy-MM-dd";
	
	private static final SimpleDateFormat formater = new SimpleDateFormat();
	
	public static Date now() {
		return new Date();
	}
	
	public static Date parse(String dateTime, String pattern) {
		formater.applyLocalizedPattern(pattern);
		try {
			return formater.parse(dateTime);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Date parse(String dateTime) {
		return parse(dateTime, PATTERN_SHORT);
	}
	
	public static String format(Date dateTime, String pattern) {
		if (dateTime == null) {
			return null;
		}
		formater.applyPattern(pattern);
		return formater.format(dateTime);
	}
	
	public static String format(Date dateTime) {
		return format(dateTime, PATTERN_SHORT);
	}
	
	// Summary of the XDate class:
	// - now: Returns the current date and time as a Date object.
	// - parse: Parses a date string into a Date object using the specified pattern, or a default pattern if none is provided.
	// - format: Formats a Date object into a string using the specified pattern, or a default pattern if none is provided.
	// - The class uses SimpleDateFormat for date parsing and formatting, allowing for flexible date handling in the application.
	
}