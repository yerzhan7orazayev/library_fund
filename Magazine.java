
public class Magazine extends Publication {
	
	// Variable Declaration
	private int year;
	private String month;
	private int pageNumber;
	private String articles;
	
	// Constructors
	public Magazine(String name, int year, String month, int pageNumber, String publisher, String articles) {
		
		this.name = name;
		this.setYear(year);
		this.setMonth(month);
		this.setPageNumber(pageNumber);
		this.publisher = publisher;
		this.setArticles(articles);
		
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public String getArticles() {
		return articles;
	}

	public void setArticles(String articles) {
		this.articles = articles;
	}
	
	
}
