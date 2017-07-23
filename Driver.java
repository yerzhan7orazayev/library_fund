import java.io.*;
import java.util.*;

public class Driver {
	
	static int id = 0;
	static ArrayList<Entry> table = new ArrayList<Entry>();
	static List<String> menuChoiceList = Arrays.asList("1", "2", "3", "4", "5");
	static ArrayList<Integer> idList = new ArrayList<Integer>();
	
	public static void main (String[] args) throws Exception {
		// Display the list of menu
		System.out.println("���� ��������� �������:\n\n"
				+ "1. �������� ������������������ ������� � �����\n"
				+ "2. ���������� ������ ������� � ����\n"
				+ "3. �������� ���������� ���������� �������\n"
				+ "4. �������� ���������� �������\n"
				+ "5. �����");
		
		userPrompt();
	}
	
	public static void userPrompt () throws Exception {
		
		// Prompt the user to enter the menu number
		System.out.println("\n��� ���������� �������� �������� ��������������� ����� �� ���� (1-5): ");
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String menuChoice = reader.readLine();
		
		
		// Invalid input from the user
		while ( !menuChoiceList.contains(menuChoice) ) {
			
		// Error message :(
		System.out.println("������! �������� ����� ����� 1-5 � ������� �����... ");
		menuChoice = reader.readLine();
		
		}
		
		
		
		// Display the table of publications already registered in the system
		if ( menuChoice.equals("1") ) {
			
			// code for displaying table
			displayTable();
			
			//System.out.println("Table should be displayed...");
			
			
			userPrompt();
		}
		
		
		
		// Inserting new publication details into the system
		else if ( menuChoice.equals("2") ) {
			
			id++;
			//System.out.println(id);
			idList.add( id );
			
			// User prompt for publication insertion
			System.out.println("����� ������� ������ ��������?\n"
					+ "1. �����\n"
					+ "2. ������\n"
					+ "3. �������");
			
			String insertionChoice = reader.readLine();
			
			// If invalid input is provided by the user
			while ( !Arrays.asList("1", "2", "3" ).contains( insertionChoice ) ) {
				
				// Error message :(
				System.out.println("������! �������� ����� ����� 1-3 � ������� �����... ");
				insertionChoice = reader.readLine();
				
			}
			
			
			// Insertion of books
			if ( insertionChoice.equals("1") ) {
				
				// code for inserting the book
				insertBook();
				
			}
			
			// Insertion of magazines
			else if ( insertionChoice.equals("2") ) {
				
				// code for inserting the magazine
				insertMagazine();
				
			}
			
			// Insertion of brochures
			else {
				
				// code for inserting the brochure
				insertBrochure();
				
			}

			userPrompt();
		}
		
		
		
		// Displaying the details of selected publication
		else if ( menuChoice.equals("3") ) {
			
			// code for displaying the certain publication details
			displayPublication();
			userPrompt();
		}
		
		
		
		// Deleting the certain publication from the system
		else if ( menuChoice.equals("4") ) {
			
			// code for deleting the publication
			deletePublication();
			userPrompt();
		}
		
		
		
		// Exiting the program
		else {
		
			System.out.println("��������� �����������");
			System.exit(0);
		}
		
	}
	
	public static void insertBook () throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				
		// User prompts
		System.out.println("������� ��� ������ �����: ");
		String author = reader.readLine();
		
		System.out.println("������� ������������ �����: ");
		String name = reader.readLine();
		
		System.out.println("������� ��� ������������ �����: ");
		int year;
		while (true) {
			try {
				year = Integer.parseInt( reader.readLine() );
				break;
			}
			
			catch ( NumberFormatException exception ) {
				System.out.println("������� ��� ������� � ������...");
			}
			
		}

		
		System.out.println("������� ���������� ������� �����: ");
		int pageNumber;
		
		while (true) {
			try {
				pageNumber = Integer.parseInt( reader.readLine() );
				break;
			}
			
			catch ( NumberFormatException exception ) {
				System.out.println("������� ���������� ������� � ������...");
			}
			
		}

		
		
		System.out.println("������� ������������ �����: ");
		String publisher = reader.readLine();
		
		System.out.println("������� ���� �����: ");
		String genre = reader.readLine();
		
		System.out.println("������� ������� ���������� �����: ");
		String summary = reader.readLine();
		
		Book book = new Book(author, name, year, pageNumber, publisher, genre, summary);
		
		Entry entry = new Entry( id, "�����", name, year, pageNumber, publisher, book );
		
		table.add( entry );
		
	}
	
	public static void insertMagazine () throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				
		// User prompts

		System.out.println("������� ������������ �������: ");
		String name = reader.readLine();
		
		System.out.println("������� ��� ������������ �������: ");
		int year;
		while (true) {
			try {
				year = Integer.parseInt( reader.readLine() );
				break;
			}
			
			catch ( NumberFormatException exception ) {
				System.out.println("������� ��� ������� � ������...");
			}
			
		}
		
		System.out.println("������� ����� ������������ �������: ");
		String month = reader.readLine();
		
		System.out.println("������� ���������� ������� �������: ");
		int pageNumber;
		
		while (true) {
			try {
				pageNumber = Integer.parseInt( reader.readLine() );
				break;
			}
			
			catch ( NumberFormatException exception ) {
				System.out.println("������� ���������� ������� � ������...");
			}
			
		}
		
		System.out.println("������� ������������ �������: ");
		String publisher = reader.readLine();
		
		System.out.println("������� ������ ������ ����� �������: ");
		String articles = reader.readLine();
		
		Magazine magazine = new Magazine( name, year, month, pageNumber, publisher, articles );
		
		Entry entry = new Entry( id, "������", name, (year + " " + month), pageNumber, publisher, magazine );
		
		table.add( entry );
	}
	
	public static void insertBrochure () throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				
		// User prompts

		System.out.println("������� ������������ �������: ");
		String name = reader.readLine();
		
		System.out.println("������� ��� ������������ �������: ");
		int year;
		while (true) {
			try {
				year = Integer.parseInt( reader.readLine() );
				break;
			}
			
			catch ( NumberFormatException exception ) {
				System.out.println("������� ��� ������� � ������...");
			}
			
		}
		
		System.out.println("������� ����� ������������ �������: ");
		String month = reader.readLine();
		
		System.out.println("������� ������������ �������: ");
		String publisher = reader.readLine();
		
		System.out.println("������� ������� �������� �������: ");
		String summary = reader.readLine();
		
		Brochure brochure = new Brochure( name, year, month, publisher, summary);

		Entry entry = new Entry( id, "�������", name, (year + " " + month), 0 , publisher, brochure );
		
		table.add( entry );
	}

	public static void displayTable () {
		
		System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.printf( "%5s %15s %30s %30s %30s %30s", "ID", "��� �������", "������������", "����� �������", "���������� �������", "������������");
		System.out.println();
		System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
		for ( Entry entry: table ) {
			
			System.out.format( "%5s %15s %30s %30s %30s %30s", entry.getId(), entry.getType(), 
					entry.getName(), entry.getTime(), entry.getPageNumber(), entry.getPublisher() );
			System.out.println();			
		}
		System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");	
	}
	
	public static void displayPublication() throws Exception {
		
		System.out.println("������� ������������� ������ ��� ��������� ����������: ");
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int idChoice = Integer.parseInt( reader.readLine() );
		
		while ( !idList.contains( idChoice ) ) {
			
			// Error message :(
			System.out.println("������! ������� ��������� ������������� ������ �� �������... ");
			idChoice = Integer.parseInt( reader.readLine() );
			
		}
		
		for (Entry entry: table) {
			
			if ( idChoice == entry.getId() ) {
				
				if ( entry.getType().equals("�����") ) {
					
					String details = "����� �����: " + entry.book.getAuthor() + "\n"
							+ "������������ �����: " + entry.book.getName() + "\n"
									+ "��� ������������: " + entry.book.getYear() + "\n"
											+ "���������� �������: " + entry.book.getPageNumber() + "\n"
													+ "������������: " + entry.book.getPublisher() + "\n"
															+ "���� �����: " + entry.book.getGenre() + "\n"
																	+ "������� ����������: " + entry.book.getSummary();
					System.out.println( details );				
					
				}
				
				else if ( entry.getType().equals("������") ) {
					
					String details = "������������ �������: " + entry.magazine.getName() + "\n"
							+ "��� � ����� ������������: " + (entry.magazine.getYear() + " " + entry.magazine.getMonth()) + "\n"
											+ "���������� �������: " + entry.magazine.getPageNumber() + "\n"
													+ "������������: " + entry.magazine.getPublisher() + "\n"
															+ "������ ������: " + entry.magazine.getArticles();
					System.out.println( details );	
					
					
				}
				
				else {
					
					String details = "������������ �������: " + entry.brochure.getName() + "\n"
							+ "��� � ����� ������������: " + (entry.brochure.getYear() + " " + entry.brochure.getMonth()) + "\n"
											+ "������������: " + entry.brochure.getPublisher() + "\n"
															+ "������� �������� �������: " + entry.brochure.getSummary();
					System.out.println( details );	
					
				}
				
			}
			
		}
		
	}
	
	public static void deletePublication() throws Exception {
		
		System.out.println("������� ������������� ������ ��� ��������: ");
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int idChoice = Integer.parseInt( reader.readLine() );
		
		while ( !idList.contains( idChoice ) ) {
			
			// Error message :(
			System.out.println("������! ������� ��������� ������������� ������ �� �������... ");
			idChoice = Integer.parseInt( reader.readLine() );
			
		}
		
		Iterator<Entry> iterator  = table.iterator();
		
		while( iterator.hasNext() ) {
				
			if ( idChoice == iterator.next().getId() ) {
					
				iterator.remove();
					
				System.out.println("��������� ������� ������� �������.");
			}
		}

		
	}
	
}

