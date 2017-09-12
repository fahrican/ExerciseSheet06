package bwi.prog2B.SS2017.wi16b027_Can.ExerciseSheet06.entities;

import bwi.prog.utils.TextIO;
import bwi.prog2B.SS2017.wi16b027_Can.ExerciseSheet06.util.ConsoleScanable;

public class Track extends Object implements ConsoleScanable, Comparable<Track> {

	private int duration;
	private Artist performer = new Artist();
	private String title;
	private Artist writer = new Artist();
	private int year = 0;

	public Track() {
		// TODO Auto-generated constructor stub
		this.setDuration(0);
		this.setYear(1900);
	}

	public Track(String title) {

		this.setTitle(title);
	}

	public Track(Track t) {

		this.setTitle(t.getTitle());
		setDuration(t.duration);
		this.year = t.year;
		this.performer.setName(t.getPerformer().getName());
		this.writer.setName(t.getWriter().getName());
	}

	public int getDuration() {
		return this.duration;
	}

	public void setDuration(int duration) {

		if (duration < 0) {
			this.duration = 0;
		} else {
			this.duration = duration;
		}
	}

	public Artist getPerformer() {
		return this.performer;
	}

	public void setPerformer(Artist performer) {

		if (performer == null) {
			return;
		}
		this.performer = performer;

	}

	//
	// title stands for the title (exactly 10 chars wide) if not set, return
	// unknown
	// writer stands for the writer name (exactly 10 chars wide)
	// performer stands for the performer name (exactly 10 chars wide)
	// min is the duration's amount of full minutes (at least two digits,
	// leading zeros)
	// sec is the duration's remaining amount of seconds (at least two digits,
	// leading zeros)
	public String getString() {
		return String.format("%10.10s by %10.10s performed by %10.10s (%02d:%02d)",
				(this.title != null) ? this.getTitle() : "unknown",
				(this.getWriter() != null && this.getWriter().getName() != null) ? this.getWriter().getName()
						: "unknown",
				(this.getPerformer() != null && this.getPerformer().getName() != null) ? this.getPerformer().getName()
						: "unknown",
				(this.getDuration() / 60), (this.getDuration() - (this.getDuration() / 60) * 60));
	}

	public String getTitle() {

		if (this.title == null) {
			return String.format("unknown title");
		} else {
			return this.title;
		}
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Artist getWriter() {
		return this.writer;
	}

	public void setWriter(Artist writer) {

		if (writer == null) {
			return;
		} else {

			this.writer = writer;
		}
	}

	public int getYear() {
		return this.year;
	}

	// sets the production year of this track valid years are between 1900 and
	// 2999
	// other values are ignored, the object remains unchanged
	public void setYear(int year) {

		if (year >= 1900 && year <= 2999) {
			this.year = year;
		}
	}

	public boolean writerIsKnown() {

		if (this.writer != null && this.writer.getName() != null) {
			return true;
		}
		return false;
	}

	// returns a String representation of this track the string representation
	// of this track is described in getString()
	@Override
	public String toString() {
		return this.getString();
	}

	public static boolean validateDuration(int duration) {
		
		if (duration > 0) {
			return true;
		}
		return false;
	}

	public static final boolean validateTitle(String title) {
		return true;
	}

	public static boolean validateYear(int year) {
		
		if (year > 1593) {
			return true;
		}
		return false;
	}
	
	private boolean validateDuration(String input) {
		
		if (input == null || input.isEmpty()){
			return false;
		}
		
		for (int i = 0; i < input.length(); i++) {
			if (!Character.isDigit(input.charAt(i))) {
				return false;
			}
		}

		return true;
	}
	
	@Override
	public boolean scan() {
		boolean fieldChanged = false, objectChanged = false;
		String input;

		// scanning title
		do {
			TextIO.putf("current title: %s\n", this.title);
			TextIO.putf("enter new title (leave empty to keep):");
			input = TextIO.getlnString();
			if (input.isEmpty()) { // keep old value?
				fieldChanged = false;
				break;
			}
			fieldChanged = true;
			break;
		} while (true);
		if (fieldChanged) {
			setTitle(input);
		}

		objectChanged = objectChanged || fieldChanged;
		fieldChanged = false; // set up for next field

		// scan duration
		do {
			TextIO.putf("current duration: %s\n", this.duration);
			TextIO.putf("enter new duration (leave empty to keep):");
			input = TextIO.getln();
			if (input.isEmpty()) { // keep old value?
				fieldChanged = false;
				break;
			}

			if (!validateDuration(input)) {
				TextIO.putf("not a valid duration (%s).\n", input);
				continue;
			}

			fieldChanged = true;
			break;
		} while (true);

		if (fieldChanged) {
			setDuration(Integer.parseInt(input));
		}

		objectChanged = objectChanged || fieldChanged;
		return objectChanged;
	}

	@Override
	public int compareTo(Track o) {
		// TODO Auto-generated method stub
		return this.getTitle().compareTo(o.getTitle());
	}

}// end of class
