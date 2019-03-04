package com.date;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;

public class Date {

	public static void main(String[] args) throws IOException {
	LocalDate localDate=LocalDate.now();
	//System.out.println(localDate.isLeapYear());
	LocalDateTime loDateTime=LocalDateTime.now();
	//System.out.println(loDateTime.getMonthValue());
	LocalDate localDate2=localDate.of(2019, Month.JANUARY,9);
	LocalDate endOfMonth=localDate2.with(TemporalAdjusters.lastDayOfYear());
	//System.out.println(endOfMonth);
	
	Clock clock=Clock.systemDefaultZone();
	//System.out.println(clock.instant().toString());
	
	
////////////	FILES RELATED*********************////////////////////////
	
//	Files.list(Paths.get("/Users/ravi.kumar/Desktop")).filter(Files::isRegularFile)
//    .forEach(System.out::println);
	
	Files.list(Paths.get("/Users/ravi.kumar/Desktop"))
    .forEach(System.out::println);
	System.out.println("----------------------------");
	
	Files.newDirectoryStream(Paths.get("/Users/ravi.kumar/Desktop"),path->path.toString().endsWith(".zip"))
    .forEach(System.out::println);
	
	System.out.println("******************************");
	Path path=Paths.get("/Users/ravi.kumar/Desktop/date copy.txt");
	try(BufferedWriter writer=Files.newBufferedWriter(path))
	{
		//writer.write("How Are You::");
		System.out.println("success::");
	}
	
	String content = "Hello World !!";
	 
	Files.write(Paths.get("/Users/ravi.kumar/Desktop/output.txt"), content.getBytes());
	System.out.println("Hello::");

	}

}
