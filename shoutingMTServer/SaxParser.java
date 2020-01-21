
package shoutingMTServer;
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
            System.out.println("STN: " + new String(c, start, length));
            stn = false;
        }
        else if (date) {
            System.out.println("Date " + new String(c, start, length));
            date = false;
        }
        else if (time) {
            System.out.println("time: " + new String(c, start, length));
            time = false;
        }
        else if (temp) {
            System.out.println("temp: " + new String(c, start, length));
            temp = false;
        }
        else if (dewp) {
            System.out.println("dewp: " + new String(c, start, length));
            dewp = false;
        }
        else if (stp) {
            System.out.println("stp " + new String(c, start, length));
            stp = false;
        }
        else if (slp) {
            System.out.println("slp " + new String(c, start, length));
            slp= false;
        }
        else if (visib) {
            System.out.println("visib " + new String(c, start, length));
            visib = false;
        }
        else if (wdsp) {
            System.out.println("wdsp " + new String(c, start, length));
            wdsp = false;
        }
        else if (prcp) {
            System.out.println("wdsp " + new String(c, start, length));
            prcp = false;
        }
        else if (sndp) {
            System.out.println("sndp " + new String(c, start, length));
            sndp = false;
        }
        else if (frshtt) {
            System.out.println("frhstt " + new String(c, start, length));
            frshtt = false;
        }
        else if (cldc) {
            System.out.println("cldc " + new String(c, start, length));
            cldc = false;
        }
        else if (wnddir) {
            System.out.println("wnddir " + new String(c, start, length));
            wnddir = false;
        }



    }
}


