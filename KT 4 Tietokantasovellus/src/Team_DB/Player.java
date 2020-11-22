package Team_DB;


public class Player {
	private String fname;
	private String lname;
	private String classification;

	public Player() {
		this.fname = "Not set";
		this.lname = "Not set";
		this.classification = "Unknown";
	}

	public Player(String fname, String lname, String classification) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.classification = classification;
	}

	public String getFname() {
		return fname;
	}

	public String getLname() {
		return lname;
	}

	public String getClassification() {
		return classification;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}
	
	@Override
	public String toString() {
		return "Player [fname=" + fname + ", lname=" + lname + ", classification=" + classification + "]";
	}

}
