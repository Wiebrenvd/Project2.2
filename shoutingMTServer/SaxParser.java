
package shoutingMTServer;

import JSONUtilities.JSONWriter;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.time.*;
import java.time.DayOfWeek;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
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
            String s= writer.toString();
            if(s.contains("STN")&& s.contains("DATE")&&s.contains("TIME")&&s.contains("TEMP")&&s.contains("DEWP")
                    &&s.contains("STP")&&s.contains("SLP")&&s.contains("VISIB")&&s.contains("WDSP")&&s.contains("PRCP")&&s.contains("SNDP")&&s.contains("FRSHTT")&&s.contains("CLDC")&&s.contains("WNDDIR")){
                // System.out.println(s);
                ShoutingMTServer.insertData.add(s);
                writer.clear();
            }
           else{
               writer.clear();
            }

            //System.out.println("End Element :" + qName);
        }
    }

    @Override
    public void characters(char c[], int start, int length) throws SAXException {

        if (stn) {
            
            writer.add("STN" , new String(c, start, length));
            stn=false;

        }
        else if (date) {
            writer.add("DATE" , new String(c, start, length));

            date = false;
        }
        else if (time) {
            writer.add("TIME" , new String(c, start, length));


            time = false;
        }
        else if (temp) {
            writer.add("TEMP" , new String(c, start, length));

            temp = false;
        }
        else if (dewp) {
            writer.add("DEWP" , new String(c, start, length));

            dewp = false;
        }
        else if (stp) {
            writer.add("STP" , new String(c, start, length));

            stp = false;
        }
        else if (slp) {
            writer.add( "SLP" , new String(c, start, length));

            slp= false;
        }
        else if (visib) {
            writer.add("VISIB" , new String(c, start, length));

            visib = false;
        }
        else if (wdsp) {
           writer.add("WDSP" , new String(c, start, length));

            wdsp = false;
        }
        else if (prcp) {
            writer.add("PRCP" , new String(c, start, length));

            prcp = false;
        }
        else if (sndp) {
            writer.add("SNDP" , new String(c, start, length));

            sndp = false;
        }
        else if (frshtt) {
            writer.add("FRSHTT" , new String(c, start, length));

            frshtt = false;
        }
        else if (cldc) {
            writer.add("CLDC" , new String(c, start, length));

            cldc = false;
        }
        else if (wnddir) {
            writer.add("WNDDIR" , new String(c, start, length));

            wnddir = false;

        }




    }
}