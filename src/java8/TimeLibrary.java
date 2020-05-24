package java8;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class TimeLibrary {

	public static void main(String[] args) throws InterruptedException {

		// LocalDate now1 = LocalDate.now();
		LocalDate now1 = LocalDate.of(2020, 04, 9);
		LocalDate now3 = LocalDate.now();
		now3.with(TemporalAdjusters.firstDayOfMonth());
		// System.out.println(now1.plusDays(3));
		// System.out.println(now1.plus(3, ChronoUnit.DECADES));
		String date = "2020-05-09";
		String date2 = "22/09/2020";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate now2 = LocalDate.parse(date);
		LocalDate now4 = LocalDate.parse(date2, formatter);
		System.out.println(now2);
		System.out.println("formatteddate: " + formatter.format(now2));
		Period period1 = now2.until(now1);
		System.out.println("period1: " + period1);
		Period period2 = Period.between(now1, now2);
		System.out.println("period2: " + period2);
		System.out.println(period1.getDays());
		long period3 = ChronoUnit.DAYS.between(now1, now2);
		System.out.println("period 3: " + period3);

		Instant ins1 = Instant.now();
		System.out.println("************************");
		System.out.println(ins1);
		Thread.sleep(2000);
		Instant ins2 = Instant.now();
		Duration duration = Duration.between(ins1, ins2);
		System.out.println(duration.getSeconds());
		ZonedDateTime zone = ZonedDateTime.now();
		System.out.println("zone: " + zone);
		System.out.println(ZoneId.systemDefault());
		System.out.println(ins1.atZone(ZoneId.of("America/Chicago")));
	}
}
