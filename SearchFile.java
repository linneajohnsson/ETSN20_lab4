import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class SearchFile{
	
	public SearchFile() {
		
	}
	
	public ArrayList<String> search(String pattern, String file) throws FileNotFoundException{
		Scanner fileScanner = new Scanner(new File(file));
		ArrayList<String> listOfLines = new ArrayList<String>();
		while(fileScanner.hasNextLine()) {
			String line = fileScanner.nextLine();
			if(line.contains(pattern)) {
				listOfLines.add(line);
			}
		}
		
		return listOfLines;
	}
	
	public static void main(String[] args) throws FileNotFoundException{
		SearchFile sf = new SearchFile();
		ArrayList<String> list = sf.search("Hej", "cat.txt");
		if(list.size() != 0) {
			for(int i = 0; i<list.size(); i++){
				System.out.println(list.get(i));
			}
		}else {
			System.out.println("The word was not found");
		}
	}
}
