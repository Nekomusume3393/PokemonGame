package pokemon.pokedex.util;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class TimeRange {
	
	private Date begin = new Date();
	private Date end = new Date();

	private TimeRange(LocalDate begin, LocalDate end) {
		this.begin = Date.from(begin.atStartOfDay(ZoneId.systemDefault()).toInstant());
		this.end = Date.from(end.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}
	
	public static TimeRange today() {
		LocalDate begin = LocalDate.now();
		return new TimeRange(begin, begin.plusDays(1));
	}
	
	public static TimeRange thisWeek() {
		LocalDate now = LocalDate.now();
		LocalDate begin = now.minusDays(now.getDayOfWeek().getValue() - 1);
		return new TimeRange(begin, begin.plusDays(7));
	}
	
	public static TimeRange thisMonth() {
		LocalDate now = LocalDate.now();
		LocalDate begin = now.withDayOfMonth(1);
		return new TimeRange(begin, begin.plusDays(now.lengthOfMonth()));
	}
	
	public static TimeRange thisQuarter() {
		LocalDate now = LocalDate.now();
		int firstMonth = now.getMonth().firstMonthOfQuarter().getValue();
		LocalDate begin = now.withMonth(firstMonth).withDayOfMonth(1);
		return new TimeRange(begin, begin.plusMonths(3));
	}
	
	public static TimeRange thisYear() {
		LocalDate now = LocalDate.now();
		LocalDate begin = now.withMonth(1).withDayOfMonth(1);
		return new TimeRange(begin, begin.plusMonths(12));
	}
	
	// Summary of the TimeRange class:
	// - Represents a range of time defined by a start and end date.
	// - Provides static methods to create common time ranges:
	//   - today: Represents the current day.
	//   - thisWeek: Represents the current week, starting from Monday.
	//   - thisMonth: Represents the current month.
	//   - thisQuarter: Represents the current quarter of the year.
	//   - thisYear: Represents the current year.
	// - Uses LocalDate to handle date calculations and conversions to Date objects.
	
}