package bwi.prog2B.SS2017.wi16b027_Can.ExerciseSheet06.util.io;

import java.io.FileWriter;
import java.io.IOException;

import bwi.prog2B.SS2017.wi16b027_Can.ExerciseSheet05.util.MyFormatter;
import bwi.prog2B.SS2017.wi16b027_Can.ExerciseSheet06.util.formatters.CSVTrackFormatter;

public class MyWriter<T> extends Object {
	
	protected FileWriter out;
	private MyFormatter<T> theFormat;

	public MyWriter(FileWriter file, MyFormatter<T> theFormat) {
		if (file == null)
			throw new IllegalArgumentException("expected non-null FileWriter");
		if (theFormat == null)
			throw new IllegalArgumentException("expected non-null MyFormatter");

		this.out = file;
		this.theFormat = theFormat;
	}

	public final boolean put(T t) {
		try {
			out.write(theFormat.format(t) + "\n");
			return true;
		} catch (IOException e) {
			return false;
		}
	}

	public void close() throws IOException {
		out.close();
	}
}// end of class
