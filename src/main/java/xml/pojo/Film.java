package xml.pojo;

public class Film {

	private String title;
	private String runTime;
	private String genre;
	private String director;
	private String famousFilm;
	private String studio;
	private String year;

	public Film() {
		super();
		this.director = "";
		this.runTime = " ";
		this.famousFilm = " ";
		
	}

	@Override
	public String toString() {
		
		return "Title: " + this.title + "[" + this.runTime + " mins]\n"
				+ "Genre: " + this.genre + "\nDirector: " + this.director + " known for " + this.famousFilm
				+ "\nStudio: " + this.studio + "\nYear: " + this.year;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getFamousFilm() {
		return famousFilm;
	}

	public void setFamousFilm(String famousFilm) {
		this.famousFilm = famousFilm;
	}

	public String getStudio() {
		return studio;
	}

	public void setStudio(String studio) {
		this.studio = studio;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
	
	public String getRunTime() {
		return runTime;
	}

	public void setRunTime(String duration) {
		this.runTime = duration;
	}
	
	
	
}
