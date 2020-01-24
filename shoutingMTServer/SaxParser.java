
package shoutingMTServer;
import JSONUtilities.JSONWriter;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.InputStream;
import java.io.StringReader;

class Saxparser implements Runnable {
    public void run()

    {

        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            UserHandler userhandler = new UserHandler();
            InputSource src = new InputSource();
            while(ShoutingMTServer.xmlData!=null){
                if(ShoutingMTServer.xmlData.size()>0){
                    String data=ShoutingMTServer.xmlData.get(0);
                    ShoutingMTServer.xmlData.remove(0);
                    if(data!=null){
                        src.setCharacterStream(new StringReader(data));
                        saxParser.parse(src,userhandler);

                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


class UserHandler extends DefaultHandler {
    boolean stn = false;
    boolean date = false;
    boolean time = false;
    boolean temp = false;
    boolean dewp = false;
    boolean stp = false;
    boolean slp = false;
    boolean visib = false;
    boolean wdsp = false;
    boolean prcp = false;
    boolean sndp = false;
    boolean frshtt = false;
    boolean cldc = false;
    boolean wnddir = false;
    JSONWriter writer= new JSONWriter();


    @Override
    public void startElement(String uri,
                             String localName, String qName, Attributes attributes) throws SAXException {

        if (qName.equalsIgnoreCase("stn")) {
            stn = true;
        }
        else if (qName.equalsIgnoreCase("date")) {
            date = true;
        }
        else if (qName.equalsIgnoreCase("time")) {
            time = true;
        }
        else if (qName.equalsIgnoreCase("temp")) {
            temp = true;
        }
        else if (qName.equalsIgnoreCase("dewp")) {
            dewp = true;
        }
        else if (qName.equalsIgnoreCase("stp")) {
            stp = true;
        }
        else if (qName.equalsIgnoreCase("slp")) {
            slp = true;
        }
        else if (qName.equalsIgnoreCase("visib")) {
            visib = true;
        }
        else if (qName.equalsIgnoreCase("wdsp")) {
            wdsp = true;
        }
        else if (qName.equalsIgnoreCase("prcp")) {
            prcp = true;
        }
        else if (qName.equalsIgnoreCase("sndp")) {
            sndp = true;
        }
        else if (qName.equalsIgnoreCase("frshtt")) {
            frshtt = true;
        }
        else if (qName.equalsIgnoreCase("cldc")) {
            cldc = true;
        }
        else if (qName.equalsIgnoreCase("wnddir")) {
            wnddir = true;
        }
    }

    @Override
    public void endElement(String uri,
                           String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("measurement")) {
            System.out.println("End Element :" + qName);
        }
    }

    @Override
    public void characters(char c[], int start, int length) throws SAXException {
        if (stn) {
            writer.add("STN: " , new String(c, start, length));
            writer.toString();
            stn=false;

        }
        else if (date) {
            writer.add("Date " , new String(c, start, length));
            writer.toString();
            date = false;
        }
        else if (time) {
            writer.add("time: " , new String(c, start, length));

            time = false;
        }
        else if (temp) {
            writer.add("temp: " , new String(c, start, length));

            temp = false;
        }
        else if (dewp) {
            writer.add("dewp: " , new String(c, start, length));

            dewp = false;
        }
        else if (stp) {
            writer.add("stp " , new String(c, start, length));

            stp = false;
        }
        else if (slp) {
            writer.add("slp " , new String(c, start, length));

            slp= false;
        }
        else if (visib) {
            writer.add("visib " , new String(c, start, length));
            writer.toString();
            visib = false;
        }
        else if (wdsp) {
           writer.add("wdsp " , new String(c, start, length));

            wdsp = false;
        }
        else if (prcp) {
            writer.add("prcp " , new String(c, start, length));

            prcp = false;
        }
        else if (sndp) {
            writer.add("sndp " , new String(c, start, length));

            sndp = false;
        }
        else if (frshtt) {
            writer.add("frhstt " , new String(c, start, length));

            frshtt = false;
        }
        else if (cldc) {
            writer.add("cldc " , new String(c, start, length));

            cldc = false;
        }
        else if (wnddir) {
            writer.add("wnddir " , new String(c, start, length));
            wnddir = false;
            writer.toString();
        }



    }
}