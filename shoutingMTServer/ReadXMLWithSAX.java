package shoutingMTServer;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.Date;
import java.util.List;


public class ReadXMLWithSAX {
    public static String stn_id;
    public static String date_measurement;
    public static String time_measurement;
    public  static String temperature;
    public static String dew_point;
    public static String stp;
    public static String sea_pressure;
    public static String visibilty;
    public static String wind_speed;
    public static String precipation;
    public static String snow;
    public static String occurances;
    public static String citizenry;
    public static String wind_direction;
    public static void main(String[] args) throws ParserConfigurationException, SAXException {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            SAXHandler SAXHandler = new SAXHandler();
            saxParser.parse("test.xml", SAXHandler);
            List<Measurement> measurements = SAXHandler.getMeasurements();
            for (Measurement measurement : measurements) {
                stn_id = measurement.getStn();
                date_measurement = measurement.getDate();
                time_measurement = measurement.getTime();
                temperature = measurement.getTemperature();
                dew_point = measurement.getDew_point();
                stp = measurement.getStp();
                sea_pressure = measurement.getSea_pressure();
                snow = measurement.getSnow();
                visibilty = measurement.getVisibility();
                wind_speed = measurement.getWind_speed();
                precipation = measurement.getPercipation();
                citizenry = measurement.getCitizenry();
                occurances = measurement.getOccurances();
                wind_direction = measurement.getWind_direction();
                System.out.println(wind_direction);
                if (stn_id == "" || date_measurement == "" || time_measurement == "" || temperature == "" || dew_point == "" || stp == "" || sea_pressure == "" || visibilty == "" || wind_speed == "" || precipation == "" || snow == "" || occurances == "" || citizenry == "" || wind_direction == "") {
                    System.out.println("Data not complete");
                } else {
                    ShoutingMTServer.xmlData.add("(" + stn_id + ",'" + date_measurement + "','" + time_measurement + "'," + temperature + "," + dew_point + "," + stp + "," + sea_pressure + "," + visibilty + "," + wind_speed + "," + precipation + "," + snow + "," + occurances + "," + citizenry + "," + wind_direction + ")");
                }
            }
        }


        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
}


