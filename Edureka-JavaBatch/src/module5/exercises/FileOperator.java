package module5.exercises;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FileOperator {

	public static void main(String[] args) {
		String pathToFileString = "C:\\edureka\\testdata\\FileOpsTestdata.txt";
		Path path = Paths.get(pathToFileString);		
		String[] data = {"Test First Line " ,"Test Second Line"};
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Pls choose an option : ");
		System.out.println("(1) Create a file ");
		System.out.println("(2) Read a file ");
		System.out.println("(3) Add more to a file ");
		System.out.println("(4) Replace a file content ");
		System.out.println("(5) Delete a file ");
		System.out.println("(6) Exit this menu ");
		
		int choice = scanner.nextInt();
		

		switch (choice) {
		case 1: //Create a new file
			try {
				Files.write(path, Arrays.asList(data), StandardCharsets.UTF_8, StandardOpenOption.CREATE_NEW);
				System.out.println("File Created !! ");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case 2:  //Read that file
			try {
				List<String>  fileContentStrings = Files.readAllLines(path);
				System.out.println("Reading File, contents below ..");
				for(String line: fileContentStrings) {
					System.out.println(line);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case 3: //Add more to a file
			try {
				System.out.println("Appending to the same file ..");
				Files.write(path, Arrays.asList(new String[]{"Third Line ", "Fourth Line"}), StandardCharsets.UTF_8, StandardOpenOption.APPEND);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;

		case 4: //Replace File Contents
			try {
				System.out.println("Replacing contents of the same file ..");
				Files.write(path, Arrays.asList(new String[]{"*", "**", "***", "****", "*****", "******"}), StandardCharsets.UTF_8, StandardOpenOption.WRITE);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
						
			break;

		case 5: //Delete the file 
			try {
				System.out.println("Deleting the file ...");
				Files.delete(path);
				System.out.println("File DELETED...");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;

		case 6:
			System.exit(0);
			break;

		default:
			scanner.close();
			break;
		}
		
		

	}

}
