
public class Book extends Publication {
	
	// Variable Declaration
	private String author;
	private int year;
	private int pageNumber;
	private String genre;
	private String summary;
	
	// Constructors
	
	public Book ( String author, String name, int year, int pageNumber, String publisher, String genre, String summary ) {
		this.setAuthor(author);
		this.name = name;
		this.setYear(year);
		this.setPageNumber(pageNumber);
		this.publisher = publisher;
		this.setGenre(genre);
		this.setSummary(summary);
				
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}
}
