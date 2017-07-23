import java.io.*;
import java.util.*;

public class Driver {
	
	static int id = 0;
	static ArrayList<Entry> table = new ArrayList<Entry>();
	static List<String> menuChoiceList = Arrays.asList("1", "2", "3", "4", "5");
	static ArrayList<Integer> idList = new ArrayList<Integer>();
	
	public static void main (String[] args) throws Exception {
		// Display the list of menu
		System.out.println("Ìåíþ äîñòóïíûõ êîììàíä:\n\n"
				+ "1. Ïðîñìîòð çàðåãèñòðèðîâàííûõ èçäàíèé â ôîíäå\n"
				+ "2. Äîáàâëåíèå íîâîãî èçäàíèÿ â ôîíä\n"
				+ "3. Ïðîñìîòð èíôîðìàöèè âûáðàííîãî èçäàíèÿ\n"
				+ "4. Óäàëåíèå âûáðàííîãî èçäàíèÿ\n"
				+ "5. Âûõîä");
		
		userPrompt();
	}
	
	public static void userPrompt () throws Exception {
		
		// Prompt the user to enter the menu number
		System.out.println("\nÄëÿ âûïîëíåíèÿ êîììàíäû âûáåðèòå ñîîòâåòñòâóþùèé íîìåð èç ìåíþ (1-5): ");
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String menuChoice = reader.readLine();
		
		
		// Invalid input from the user
		while ( !menuChoiceList.contains(menuChoice) ) {
			
		// Error message :(
		System.out.println("Îøèáêà! Âûáåðèòå ÷èñëî ìåæäó 1-5 è ââåäèòå ñíîâà... ");
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
			System.out.println("Êàêîå èçäàíèå õîòèòå äîáàâèòü?\n"
					+ "1. Êíèãà\n"
					+ "2. Æóðíàë\n"
					+ "3. Áðîøþðà");
			
			String insertionChoice = reader.readLine();
			
			// If invalid input is provided by the user
			while ( !Arrays.asList("1", "2", "3" ).contains( insertionChoice ) ) {
				
				// Error message :(
				System.out.println("Îøèáêà! Âûáåðèòå ÷èñëî ìåæäó 1-3 è ââåäèòå ñíîâà... ");
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
		
			System.out.println("Ïðîãðàììà çàâåðøèëàñü");
			System.exit(0);
		}
		
	}
	
	public static void insertBook () throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				
		// User prompts
		System.out.println("Ââåäèòå èìÿ àâòîðà êíèãè: ");
		String author = reader.readLine();
		
		System.out.println("Ââåäèòå íàèìåíîâàíèå êíèãè: ");
		String name = reader.readLine();
		
		System.out.println("Ââåäèòå ãîä èçäàòåëüñòâà êíèãè: ");
		int year;
		while (true) {
			try {
				year = Integer.parseInt( reader.readLine() );
				break;
			}
			
			catch ( NumberFormatException exception ) {
				System.out.println("Ââåäèòå ãîä èçäàíèÿ â öèôðàõ...");
			}
			
		}

		
		System.out.println("Ââåäèòå êîëè÷åñòâî ñòðàíèö êíèãè: ");
		int pageNumber;
		
		while (true) {
			try {
				pageNumber = Integer.parseInt( reader.readLine() );
				break;
			}
			
			catch ( NumberFormatException exception ) {
				System.out.println("Ââåäèòå êîëè÷åñòâî ñòðàíèö â öèôðàõ...");
			}
			
		}

		
		
		System.out.println("Ââåäèòå èçäàòåëüñòâî êíèãè: ");
		String publisher = reader.readLine();
		
		System.out.println("Ââåäèòå æàíð êíèãè: ");
		String genre = reader.readLine();
		
		System.out.println("Ââåäèòå êðàòêîå ñîäåðæàíèå êíèãè: ");
		String summary = reader.readLine();
		
		Book book = new Book(author, name, year, pageNumber, publisher, genre, summary);
		
		Entry entry = new Entry( id, "Êíèãà", name, year, pageNumber, publisher, book );
		
		table.add( entry );
		
	}
	
	public static void insertMagazine () throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				
		// User prompts

		System.out.println("Ââåäèòå íàèìåíîâàíèå æóðíàëà: ");
		String name = reader.readLine();
		
		System.out.println("Ââåäèòå ãîä èçäàòåëüñòâà æóðíàëà: ");
		int year;
		while (true) {
			try {
				year = Integer.parseInt( reader.readLine() );
				break;
			}
			
			catch ( NumberFormatException exception ) {
				System.out.println("Ââåäèòå ãîä èçäàíèÿ â öèôðàõ...");
			}
			
		}
		
		System.out.println("Ââåäèòå ìåñÿö èçäàòåëüñòâà æóðíàëà: ");
		String month = reader.readLine();
		
		System.out.println("Ââåäèòå êîëè÷åñòâî ñòðàíèö æóðíàëà: ");
		int pageNumber;
		
		while (true) {
			try {
				pageNumber = Integer.parseInt( reader.readLine() );
				break;
			}
			
			catch ( NumberFormatException exception ) {
				System.out.println("Ââåäèòå êîëè÷åñòâî ñòðàíèö â öèôðàõ...");
			}
			
		}
		
		System.out.println("Ââåäèòå èçäàòåëüñòâî æóðíàëà: ");
		String publisher = reader.readLine();
		
		System.out.println("Ââåäèòå ñïèñîê ñòàòåé ÷åðåç çàïèòóþ: ");
		String articles = reader.readLine();
		
		Magazine magazine = new Magazine( name, year, month, pageNumber, publisher, articles );
		
		Entry entry = new Entry( id, "Æóðíàë", name, (year + " " + month), pageNumber, publisher, magazine );
		
		table.add( entry );
	}
	
	public static void insertBrochure () throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				
		// User prompts

		System.out.println("Ââåäèòå íàèìåíîâàíèå áðîøþðû: ");
		String name = reader.readLine();
		
		System.out.println("Ââåäèòå ãîä èçäàòåëüñòâà áðîøþðû: ");
		int year;
		while (true) {
			try {
				year = Integer.parseInt( reader.readLine() );
				break;
			}
			
			catch ( NumberFormatException exception ) {
				System.out.println("Ââåäèòå ãîä èçäàíèÿ â öèôðàõ...");
			}
			
		}
		
		System.out.println("Ââåäèòå ìåñÿö èçäàòåëüñòâà áðîøþðû: ");
		String month = reader.readLine();
		
		System.out.println("Ââåäèòå èçäàòåëüñòâî áðîøþðû: ");
		String publisher = reader.readLine();
		
		System.out.println("Ââåäèòå êðàòêîå îïèñàíèå áðîøþðû: ");
		String summary = reader.readLine();
		
		Brochure brochure = new Brochure( name, year, month, publisher, summary);

		Entry entry = new Entry( id, "Áðîøþðà", name, (year + " " + month), 0 , publisher, brochure );
		
		table.add( entry );
	}

	public static void displayTable () {
		
		System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.printf( "%5s %15s %30s %30s %30s %30s", "ID", "Òèï èçäàíèÿ", "Íàèìåíîâàíèå", "Âðåìÿ èçäàíèÿ", "Êîëè÷åñòâî ñòðàíèö", "Èçäàòåëüñòâî");
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
		
		System.out.println("Óêàæèòå èäåíòèôèêàòîð çàïèñè äëÿ ïîäðîáíîé èíôîðìàöèè: ");
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int idChoice = Integer.parseInt( reader.readLine() );
		
		while ( !idList.contains( idChoice ) ) {
			
			// Error message :(
			System.out.println("Îøèáêà! Óêàæèòå äîñòóïíûé èäåíòèôèêàòîð çàïèñè èç òàáëèöû... ");
			idChoice = Integer.parseInt( reader.readLine() );
			
		}
		
		for (Entry entry: table) {
			
			if ( idChoice == entry.getId() ) {
				
				if ( entry.getType().equals("Êíèãà") ) {
					
					String details = "Àâòîð êíèãè: " + entry.book.getAuthor() + "\n"
							+ "Íàèìåíîâàíèå êíèãè: " + entry.book.getName() + "\n"
									+ "Ãîä èçäàòåëüñòâà: " + entry.book.getYear() + "\n"
											+ "Êîëè÷åñòâî ñòðàíèö: " + entry.book.getPageNumber() + "\n"
													+ "Èçäàòåëüñòâî: " + entry.book.getPublisher() + "\n"
															+ "Æàíð êíèãè: " + entry.book.getGenre() + "\n"
																	+ "Êðàòêîå ñîäåðæàíèå: " + entry.book.getSummary();
					System.out.println( details );				
					
				}
				
				else if ( entry.getType().equals("Æóðíàë") ) {
					
					String details = "Íàèìåíîâàíèå æóðíàëà: " + entry.magazine.getName() + "\n"
							+ "Ãîä è ìåñÿö èçäàòåëüñòâà: " + (entry.magazine.getYear() + " " + entry.magazine.getMonth()) + "\n"
											+ "Êîëè÷åñòâî ñòðàíèö: " + entry.magazine.getPageNumber() + "\n"
													+ "Èçäàòåëüñòâî: " + entry.magazine.getPublisher() + "\n"
															+ "Ñïèñîê ñòàòåé: " + entry.magazine.getArticles();
					System.out.println( details );	
					
					
				}
				
				else {
					
					String details = "Íàèìåíîâàíèå áðîøþðû: " + entry.brochure.getName() + "\n"
							+ "Ãîä è ìåñÿö èçäàòåëüñòâà: " + (entry.brochure.getYear() + " " + entry.brochure.getMonth()) + "\n"
											+ "Èçäàòåëüñòâî: " + entry.brochure.getPublisher() + "\n"
															+ "Êðàòêîå îïèñàíèå áðîøþðû: " + entry.brochure.getSummary();
					System.out.println( details );	
					
				}
				
			}
			
		}
		
	}
	
	public static void deletePublication() throws Exception {
		
		System.out.println("Óêàæèòå èäåíòèôèêàòîð çàïèñè äëÿ óäàëåíèÿ: ");
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int idChoice = Integer.parseInt( reader.readLine() );
		
		while ( !idList.contains( idChoice ) ) {
			
			// Error message :(
			System.out.println("Îøèáêà! Óêàæèòå äîñòóïíûé èäåíòèôèêàòîð çàïèñè èç òàáëèöû... ");
			idChoice = Integer.parseInt( reader.readLine() );
			
		}
		
		Iterator<Entry> iterator  = table.iterator();
		
		while( iterator.hasNext() ) {
				
			if ( idChoice == iterator.next().getId() ) {
					
				iterator.remove();
					
				System.out.println("Âûáðàííîå èçäàíèå óñïåøíî óäàëåíî.");
			}
		}

		
	}
	
}

