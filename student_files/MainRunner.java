
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import uni.UniParser;
import uni.TokenMgrError;
import uni.ParseException;

public class MainRunner {

	public static void main(String[] args) {
		
		for (int i = 1; i <= 1; i++ ) {
			File f = new File("tests"+System.getProperty("file.separator")+"input"+i+".txt");
			try {
				FileInputStream is = new FileInputStream(f);
				UniParser parser = new UniParser(is);
				
				try {
					parser.University();
					System.out.println(f.getName()+" OK");
					System.out.println("------------------------------------");
				} catch (TokenMgrError e) {
					System.err.print(f.getName()+" failed in the Scanner: ");
					System.err.println(e.getMessage());
					System.err.println("------------------------------------");
				} catch (ParseException e) {
					System.err.print(f.getName()+" failed in the Parser: ");
					System.err.println(e.getMessage());
					System.err.println("------------------------------------");
				}
			} catch (FileNotFoundException e) {
				System.err.println("Cannot find "+f.getName());
				System.err.println("------------------------------------");
			}
		}
	}
}
