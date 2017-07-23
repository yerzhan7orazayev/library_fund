
public class Brochure extends Publication {
	
	// Variable Declaration
	private int year;
	private String month;
	private String summary;
	
	// Constructors
	public Brochure( String name, int year, String month, String publisher, String summary ) {
		
		this.name = name;
		this.setYear(year);
		this.setMonth(month);
		this.publisher= publisher;
		this.setSummary(summary);
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

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

}
