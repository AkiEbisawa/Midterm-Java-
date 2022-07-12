
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
public class Main {

	static String fileName = null;
	static Library lib = new Library();
	static Scanner in = new Scanner(System.in);
	static Boolean running = true;
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception  {
		
		Scanner scanner = new Scanner(System.in);
		
		System1<String, String> account = new System1<>("U123","P123");
		
		System.out.println("Welcome to store inventory");
		
		
		
while(true) {
			System.out.println("Enter your user ID");
			String user = scanner.nextLine();
			System.out.println("Enter your password");
			String pass = scanner.nextLine(); 
			
			if(user.equals(account.getUserId()) && pass.equals(account.getUserPassword())) {
				System.out.println("Welcome" + account.getUserId());
				break;
			}
			
			System.out.println("User not found\n\n"+ "Press [enter] key to try again or press [e] to exit\n\n");
			
			if(scanner.nextLine().toLowerCase().equals("e")) {
				System.out.println("Bye~");
				System.exit(0);
			}
		}
		
while(running) {
	System.out.println("\nEnter 0 for load library."
			+"\nEnter 1 for save and quit"
			+"\nEnter 2 for list all books in library"
			+"\nEnter 3 for add book to library");
	int answer = in.nextInt();
	switch(answer) {
	
	case 0:
		
		System.out.println("Enter the file name to load");
		fileName = in.next();
		loadScript(fileName);
		
		break;
		
	case 1:
		
		saveAndQuit();
		
		break;
		
	case 2:
		
		System.out.println(lib.toString());
		
		break;
		
	case 3:
		addBook();
		
		break;
	}
  }
	System.exit(0);
}
	private static void addBook() {
		
		int isbn;
		String title, author;
		double price;
		
		System.out.println("\nEnter title: ");
		title = in.next();
		
		System.out.println("\nEnter Author: ");
		author = in.next();
		
		System.out.println("\nEnter ISBN: ");
		isbn = in.nextInt();
		
		System.out.println("\nEnter Price: ");
		price = in.nextDouble();
		
		Book b = new Book(isbn,title,author,price);
		lib.addBook(b);
		
	}
	private static void saveAndQuit() {
		
		System.out.println("Enter file name:" );
		fileName = in.next();
		running = false;
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		try {
			fos = new FileOutputStream(fileName);
			out = new ObjectOutputStream(fos);
			out.writeObject(lib );
			fos.close();
			out.close();
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
	}
	private static void loadScript(String name ) {
		FileInputStream fis = null;
		ObjectInputStream in = null;
		
		File file = new File(fileName);
		
		if(file.exists()) {

		try {
		
			fis = new FileInputStream(file);
			in = new ObjectInputStream(fis);
			lib = (Library)in.readObject();
			fis.close();
			in.close();
		 
		} catch (IOException e) {
			e.printStackTrace();
		}
		 catch(ClassNotFoundException e) {
			e.printStackTrace();
		} 
		
		}else {
			System.out.println("\nThe file does not exist");	
	}
		
	}
}
