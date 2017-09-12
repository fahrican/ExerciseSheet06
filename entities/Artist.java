package bwi.prog2B.SS2017.wi16b027_Can.ExerciseSheet06.entities;

public class Artist extends Object {

	private String name;
	
	public Artist() {
		// TODO Auto-generated constructor stub
		this.setName("unknown");;
	}
	
	public Artist(Artist a) {
		// TODO Auto-generated constructor stub
		this.name = a.name;
	}
	
	public Artist(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		
		if (name != null && !name.trim().isEmpty()) {
			this.name = name;
		}
		else {
			this.setName("unknown");
		}
	}
	
}//end of class
