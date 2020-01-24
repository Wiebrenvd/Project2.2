package JSONUtilities;



import java.util.ArrayList;

/**
 * This class takes data as a input and generates a JSON string.
 */
public class JSONWriter {

    public ArrayList<JSONDataEntry> dataEntries;

    public JSONWriter(){
        dataEntries = new ArrayList<>();
    }



    public void add(JSONDataEntry entry){
        if(referenceIsTaken(entry.getDataReference())) throw new IllegalArgumentException("Reference " + entry.getDataReference() + " is already taken.");
        dataEntries.add(entry);
    }

    public void add(String dataReference, int data){
        add(new JSONDataEntry(dataReference, data));
    }

    public void add(String dataReference, String data){
        add(new JSONDataEntry(dataReference, data));
    }

    public void add(String dataReference, double data){
        add(new JSONDataEntry(dataReference, data));
    }

    public void add(String dataReference, long data){
        add(new JSONDataEntry(dataReference, data));
    }

    public boolean referenceIsTaken(String dataReference){
        for(JSONDataEntry dataEntry : dataEntries)
            if(dataReference.equalsIgnoreCase(dataEntry.getDataReference()))
                return true;

        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(JSONDataEntry entry : dataEntries){
            sb.append(",").append(entry.toString());
        }
        return "{" + sb.toString().substring(1) + "}";
    }

    public void clear(){
        dataEntries.clear();
    }

    public boolean hasReferences(String... references){
        for(String reference : references)
            if(!referenceIsTaken(reference)) return false;

        return true;
    }

}