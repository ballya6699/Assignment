package util;


import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;


public class CSVReader
{
	public List<String> readFile(String filePath) throws IOException
	{		
		List<String> lines = java.nio.file.Files.readAllLines(Paths.get(filePath));
		return lines;
	}
}