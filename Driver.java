import java.io.*;
import java.util.*;

public class Driver {
	
	static int id = 0;
	static ArrayList<Entry> table = new ArrayList<Entry>();
	static List<String> menuChoiceList = Arrays.asList("1", "2", "3", "4", "5");
	static ArrayList<Integer> idList = new ArrayList<Integer>();
	
	public static void main (String[] args) throws Exception {
		// Display the list of menu
		System.out.println("Меню доступных комманд:\n\n"
				+ "1. Просмотр зарегистрированных изданий в фонде\n"
				+ "2. Добавление нового издания в фонд\n"
				+ "3. Просмотр информации выбранного издания\n"
				+ "4. Удаление выбранного издания\n"
				+ "5. Выход");
		
		userPrompt();
	}
	
	public static void userPrompt () throws Exception {
		
		// Prompt the user to enter the menu number
		System.out.println("\nДля выполнения комманды выберите соответствующий номер из меню (1-5): ");
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String menuChoice = reader.readLine();
		
		
		// Invalid input from the user
		while ( !menuChoiceList.contains(menuChoice) ) {
			
		// Error message :(
		System.out.println("Ошибка! Выберите число между 1-5 и введите снова... ");
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
			System.out.println("Какое издание хотите добавить?\n"
					+ "1. Книга\n"
					+ "2. Журнал\n"
					+ "3. Брошюра");
			
			String insertionChoice = reader.readLine();
			
			// If invalid input is provided by the user
			while ( !Arrays.asList("1", "2", "3" ).contains( insertionChoice ) ) {
				
				// Error message :(
				System.out.println("Ошибка! Выберите число между 1-3 и введите снова... ");
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
		
			System.out.println("Программа завершилась");
			System.exit(0);
		}
		
	}
	
	public static void insertBook () throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				
		// User prompts
		System.out.println("Введите имя автора книги: ");
		String author = reader.readLine();
		
		System.out.println("Введите наименование книги: ");
		String name = reader.readLine();
		
		System.out.println("Введите год издательства книги: ");
		int year;
		while (true) {
			try {
				year = Integer.parseInt( reader.readLine() );
				break;
			}
			
			catch ( NumberFormatException exception ) {
				System.out.println("Введите год издания в цифрах...");
			}
			
		}

		
		System.out.println("Введите количество страниц книги: ");
		int pageNumber;
		
		while (true) {
			try {
				pageNumber = Integer.parseInt( reader.readLine() );
				break;
			}
			
			catch ( NumberFormatException exception ) {
				System.out.println("Введите количество страниц в цифрах...");
			}
			
		}

		
		
		System.out.println("Введите издательство книги: ");
		String publisher = reader.readLine();
		
		System.out.println("Введите жанр книги: ");
		String genre = reader.readLine();
		
		System.out.println("Введите краткое содержание книги: ");
		String summary = reader.readLine();
		
		Book book = new Book(author, name, year, pageNumber, publisher, genre, summary);
		
		Entry entry = new Entry( id, "Книга", name, year, pageNumber, publisher, book );
		
		table.add( entry );
		
	}
	
	public static void insertMagazine () throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				
		// User prompts

		System.out.println("Введите наименование журнала: ");
		String name = reader.readLine();
		
		System.out.println("Введите год издательства журнала: ");
		int year;
		while (true) {
			try {
				year = Integer.parseInt( reader.readLine() );
				break;
			}
			
			catch ( NumberFormatException exception ) {
				System.out.println("Введите год издания в цифрах...");
			}
			
		}
		
		System.out.println("Введите месяц издательства журнала: ");
		String month = reader.readLine();
		
		System.out.println("Введите количество страниц журнала: ");
		int pageNumber;
		
		while (true) {
			try {
				pageNumber = Integer.parseInt( reader.readLine() );
				break;
			}
			
			catch ( NumberFormatException exception ) {
				System.out.println("Введите количество страниц в цифрах...");
			}
			
		}
		
		System.out.println("Введите издательство журнала: ");
		String publisher = reader.readLine();
		
		System.out.println("Введите список статей через запитую: ");
		String articles = reader.readLine();
		
		Magazine magazine = new Magazine( name, year, month, pageNumber, publisher, articles );
		
		Entry entry = new Entry( id, "Журнал", name, (year + " " + month), pageNumber, publisher, magazine );
		
		table.add( entry );
	}
	
	public static void insertBrochure () throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				
		// User prompts

		System.out.println("Введите наименование брошюры: ");
		String name = reader.readLine();
		
		System.out.println("Введите год издательства брошюры: ");
		int year;
		while (true) {
			try {
				year = Integer.parseInt( reader.readLine() );
				break;
			}
			
			catch ( NumberFormatException exception ) {
				System.out.println("Введите год издания в цифрах...");
			}
			
		}
		
		System.out.println("Введите месяц издательства брошюры: ");
		String month = reader.readLine();
		
		System.out.println("Введите издательство брошюры: ");
		String publisher = reader.readLine();
		
		System.out.println("Введите краткое описание брошюры: ");
		String summary = reader.readLine();
		
		Brochure brochure = new Brochure( name, year, month, publisher, summary);

		Entry entry = new Entry( id, "Брошюра", name, (year + " " + month), 0 , publisher, brochure );
		
		table.add( entry );
	}

	public static void displayTable () {
		
		System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.printf( "%5s %15s %30s %30s %30s %30s", "ID", "Тип издания", "Наименование", "Время издания", "Количество страниц", "Издательство");
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
		
		System.out.println("Укажите идентификатор записи для подробной информации: ");
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int idChoice = Integer.parseInt( reader.readLine() );
		
		while ( !idList.contains( idChoice ) ) {
			
			// Error message :(
			System.out.println("Ошибка! Укажите доступный идентификатор записи из таблицы... ");
			idChoice = Integer.parseInt( reader.readLine() );
			
		}
		
		for (Entry entry: table) {
			
			if ( idChoice == entry.getId() ) {
				
				if ( entry.getType().equals("Книга") ) {
					
					String details = "Автор книги: " + entry.book.getAuthor() + "\n"
							+ "Наименование книги: " + entry.book.getName() + "\n"
									+ "Год издательства: " + entry.book.getYear() + "\n"
											+ "Количество страниц: " + entry.book.getPageNumber() + "\n"
													+ "Издательство: " + entry.book.getPublisher() + "\n"
															+ "Жанр книги: " + entry.book.getGenre() + "\n"
																	+ "Краткое содержание: " + entry.book.getSummary();
					System.out.println( details );				
					
				}
				
				else if ( entry.getType().equals("Журнал") ) {
					
					String details = "Наименование журнала: " + entry.magazine.getName() + "\n"
							+ "Год и месяц издательства: " + (entry.magazine.getYear() + " " + entry.magazine.getMonth()) + "\n"
											+ "Количество страниц: " + entry.magazine.getPageNumber() + "\n"
													+ "Издательство: " + entry.magazine.getPublisher() + "\n"
															+ "Список статей: " + entry.magazine.getArticles();
					System.out.println( details );	
					
					
				}
				
				else {
					
					String details = "Наименование брошюры: " + entry.brochure.getName() + "\n"
							+ "Год и месяц издательства: " + (entry.brochure.getYear() + " " + entry.brochure.getMonth()) + "\n"
											+ "Издательство: " + entry.brochure.getPublisher() + "\n"
															+ "Краткое описание брошюры: " + entry.brochure.getSummary();
					System.out.println( details );	
					
				}
				
			}
			
		}
		
	}
	
	public static void deletePublication() throws Exception {
		
		System.out.println("Укажите идентификатор записи для удаления: ");
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int idChoice = Integer.parseInt( reader.readLine() );
		
		while ( !idList.contains( idChoice ) ) {
			
			// Error message :(
			System.out.println("Ошибка! Укажите доступный идентификатор записи из таблицы... ");
			idChoice = Integer.parseInt( reader.readLine() );
			
		}
		
		Iterator<Entry> iterator  = table.iterator();
		
		while( iterator.hasNext() ) {
				
			if ( idChoice == iterator.next().getId() ) {
					
				iterator.remove();
					
				System.out.println("Выбранное издание успешно удалено.");
			}
		}

		
	}
	
}

