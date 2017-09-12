package bwi.prog2B.SS2017.wi16b027_Can.ExerciseSheet06.util.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import bwi.prog.utils.TextIO;
import bwi.prog2B.SS2017.wi16b027_Can.ExerciseSheet06.entities.Track;
import bwi.prog2B.SS2017.wi16b027_Can.ExerciseSheet06.entities.Artist;
import bwi.prog2B.SS2017.wi16b027_Can.ExerciseSheet06.util.io.MyReader;

public class MyTrackCSVReader extends MyReader<Track> {

	private static final int DURATION = 3;
	private static final int PERFORMER = 2;
	private static final int TITLE = 0;
	private static final int WRITER = 1;
	private static final int YEAR = 4;

	public MyTrackCSVReader(BufferedReader in) {
		super(in);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Track get() {
		try {
			String track;
			String[] trackArray;
			Track t = new Track();

			if ((track = in.readLine()) != null) {
				trackArray = track.split(",");

				TextIO.put(track);
				t.setDuration(Integer.parseInt(trackArray[DURATION].trim()));
				t.setPerformer(new Artist(trackArray[PERFORMER].trim()));
				t.setTitle(trackArray[TITLE].trim());
				t.setWriter(new Artist(trackArray[WRITER].trim()));
				t.setYear(Integer.parseInt(trackArray[YEAR].trim()));

				return t;
			}
			return null;
		} catch (IOException e) {
			TextIO.putln("Error reading.");
			return null;
		} catch (Exception e) {
			TextIO.putln("Error parsing.");
			return null;
		}
	}

	public void close() throws IOException {
		in.close();
	}

}// end of class
