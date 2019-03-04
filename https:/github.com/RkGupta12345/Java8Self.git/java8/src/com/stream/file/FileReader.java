package com.stream.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.stream.Stream;

public class FileReader {

	public static void main(String[] args) throws IOException {

		FileReader.readStreamLinesUsingFiles();
		FileReader.readStreamLinesUsingFileReader();

	}

	private static void readStreamLinesUsingFiles() throws IOException {
		Stream<String> content = Files.lines(Paths.get("/Users/ravi.kumar/Desktop", "data.txt"));
		Optional<String> lines = content.filter(n -> n.contains("Never")).findFirst();
		if (lines.isPresent()) {
			System.out.println(lines.get());
		} else {
			System.out.println("failuree:::");
		}

		content.close();
	}
	
	private static void readStreamLinesUsingFileReader() throws IOException
	{
		File file=new File("/Users/ravi.kumar/Desktop/data.txt");
		java.io.FileReader fr=new java.io.FileReader(file);
		BufferedReader br=new BufferedReader(fr);
		String line;
		while((line=br.readLine())!=null)
		{
			if(line.contains("password"))
			{
				System.out.println(line.toUpperCase());
				
			}
			else {
				System.out.println("Failure2");
			}
		}
		br.close();
		fr.close();
		
		
	}

}
