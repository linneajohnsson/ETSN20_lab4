import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class SearchFile{
	
	
	public static void search(String pattern, String file){
		Scanner fileScanner;
		boolean patternFound = false;
		try {
			fileScanner = new Scanner(new File(file));
			while(fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				
				if(line.contains(pattern)) {
					System.out.println(line);
					patternFound = true;
				}
			}
			if(!patternFound){
				System.out.println("File: " + file + " does not contain pattern: " + pattern);
			}
			fileScanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException{
		String pattern;
		String file;
		if(args.length !=3 || !args[0].equals("search") || !args[2].contains(".")) {
			throw new Error("Wrong input format! " + 
					"Should be of the syntax: search <pattern> <file>");
		}	
		pattern = args[1];
		file = args[2];
		search(pattern, file);
	}
}
