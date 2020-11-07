package pectab;

import java.util.ArrayList;
import java.util.List;

public class Stream {

	private List<StreamElement> streamElements = new ArrayList<StreamElement>();

	public Stream() {
	}

	public List<StreamElement> getStreamElements() {
		return streamElements;
	}

	public static Stream parse(String streams) {

		Stream s = new Stream();
		String stream[];
		stream = streams.split("\\|");

		for (int i = 0; i < stream.length; i++) {
			StreamElement temp = StreamElement.parse(stream[i]);
			s.getStreamElements().add(temp);
		}

		return s;
	}

	@Override
	public String toString() {
		return "Stream{\n" + "streamElements=\n" + streamElements + '}';
	}

}
