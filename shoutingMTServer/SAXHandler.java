package shoutingMTServer;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class SAXHandler extends DefaultHandler {
	private List<Measurement> measurements =  null;
	private Measurement measurement= null;
	private String elementValue;

	@Override
	public void startDocument() throws SAXException {
		measurements = new ArrayList<Measurement>();
	}
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (qName.equalsIgnoreCase("MEASUREMENT")) {
			measurement = new Measurement();

		}
	}
	@Override
	public void endElement (String uri, String localName, String qName) throws SAXException {
		if(qName.equalsIgnoreCase("MEASUREMENT")) {
			measurements.add(measurement);
		}
		if (qName.equalsIgnoreCase("STN")) {
			measurement.setStn(Integer.valueOf(elementValue));
		}
		if (qName.equalsIgnoreCase("DATE")) {
			measurement.setDate(Date.valueOf(elementValue));
		}
		if (qName.equalsIgnoreCase("TIME")) {
			measurement.setTime(elementValue);
		}
		if (qName.equalsIgnoreCase("TEMP")) {
			measurement.setTemperature(Float.valueOf(elementValue));
		}
		if (qName.equalsIgnoreCase("DEWP")) {
			measurement.setDew_point(Float.valueOf(elementValue));
		}
		if (qName.equalsIgnoreCase("STP")) {
			measurement.setStp(Float.valueOf(elementValue));
		}
		if (qName.equalsIgnoreCase("SLP")) {
			measurement.setSea_pressure(Float.valueOf(elementValue));
		}
		if (qName.equalsIgnoreCase("VISIB")) {
			measurement.setVisibility(Float.valueOf(elementValue));
		}
		if (qName.equalsIgnoreCase("WDSP")) {
			measurement.setWind_speed(Float.valueOf(elementValue));
		}
		if (qName.equalsIgnoreCase("PRCP")) {
			measurement.setPercipation(Float.valueOf(elementValue));
		}
		if (qName.equalsIgnoreCase("SNDP")) {
			measurement.setSnow(Float.valueOf(elementValue));
		}
		if (qName.equalsIgnoreCase("FRSHTT")) {
			measurement.setOccurances(Integer.valueOf(elementValue));
		}
		if (qName.equalsIgnoreCase("CLDC")) {
			measurement.setCitizenry(Float.valueOf(elementValue));
		}
		if ((qName.equalsIgnoreCase("WNDDIR"))){
			measurement.setWind_direction(Integer.valueOf(elementValue));
		}

	}
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		elementValue = new String(ch, start, length);
	}

	public List<Measurement> getMeasurements() {
		return measurements;
	}
}