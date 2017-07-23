
public class Entry {
	
	// Variable Declaration
	private int id;
	private String type;
	private String name;
	private String time;
	private int pageNumber;
	private String publisher;
	public Book book;
	public Magazine magazine;
	public Brochure brochure;
	
	
	// Constructors
	public Entry(int id, String type, String name, int time, int pageNumber, String publisher, Book book) {
		
		this.setId(id);
		this.setType(type);
		this.setName(name);
		this.setTime(Integer.toString(time));
		this.setPageNumber(pageNumber); 
		this.setPublisher(publisher);
		this.book = book;
	
	}
	
	public Entry(int id, String type, String name, String time, int pageNumber, String publisher, Magazine magazine) {
		
		this.setId(id);
		this.setType(type);
		this.setName(name);
		this.setTime(time);
		this.setPageNumber(pageNumber); 
		this.setPublisher(publisher);
		this.magazine = magazine;
	
	}
	
	public Entry(int id, String type, String name, String time, int pageNumber, String publisher, Brochure brochure) {
		
		this.setId(id);
		this.setType(type);
		this.setName(name);
		this.setTime(time);
		this.setPageNumber(pageNumber); 
		this.setPublisher(publisher);
		this.brochure = brochure;
	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

}
