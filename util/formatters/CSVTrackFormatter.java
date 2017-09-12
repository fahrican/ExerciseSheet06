package bwi.prog2B.SS2017.wi16b027_Can.ExerciseSheet06.util.formatters;

import bwi.prog2B.SS2017.wi16b027_Can.ExerciseSheet06.entities.Track;
import bwi.prog2B.SS2017.wi16b027_Can.ExerciseSheet06.util.MyFormatter;

public class CSVTrackFormatter extends Object implements MyFormatter<Track> {
	
	private Track csvTrack;
	
	public CSVTrackFormatter() {
		// TODO Auto-generated constructor stub
	}
	
	//	comma separated list of all column names in the following order:
	//
	//	    Title
	//	    Writer
	//	    Performer
	//	    duration
	//	    year 
	@Override
	public String header() {
		// TODO Auto-generated method stub
		return String.format("1.%s\n, 2.%s\n, 3.%s\n, 4.%d\n, 5.%d", 
				this.csvTrack.getTitle(), this.csvTrack.getWriter().getName(), 
				this.csvTrack.getPerformer().getName(), this.csvTrack.getDuration(), this.csvTrack.getYear());
	}

	//The csv representation of a track is "title","performer","writer","year","duration"; (without quotes)
	@Override
	public String format(Track t) {
		// TODO Auto-generated method stub
		return String.format("%s, %s, %s, %d, %d", 
				this.csvTrack.getTitle(), this.csvTrack.getPerformer().getName(), this.csvTrack.getWriter().getName(),
				this.csvTrack.getYear(), this.csvTrack.getDuration());
	}

	@Override
	public String topSeparator() {
		// TODO Auto-generated method stub
		return "                                                           ";
	}
	
	//the string representation is "CSV format [Title, Writer, Performer, duration, year]" (without quotes)
	public String toString() {
		return String.format("CSV format [%s, %s, %s, %d, %d]", 
				this.csvTrack.getTitle(), this.csvTrack.getWriter().getName(), this.csvTrack.getPerformer().getName(),
				this.csvTrack.getDuration(), this.csvTrack.getYear());
	}

}//end of class
