package JSONUtilities;

/**
 * Represents a data entry in a JSON string.
 */
public class JSONDataEntry {

    private enum Type {
        INTEGER, STRING, DOUBLE, LONG
    }

    private Type type;
    private String dataReference;
    private Object data;

    public JSONDataEntry(String dataReference, int data){
        type = Type.INTEGER;
        this.dataReference = dataReference;
        this.data = data;
    }

    public JSONDataEntry(String dataReference, String data){
        type = Type.STRING;
        this.dataReference = dataReference;
        this.data = data;
    }

    public JSONDataEntry(String dataReference, double data){
        type = Type.DOUBLE;
        this.dataReference = dataReference;
        this.data = data;
    }

    public JSONDataEntry(String dataReference, long data){
        type = Type.LONG;
        this.dataReference = dataReference;
        this.data = data;
    }

    public Type getType(){
        return type;
    }

    public String getDataReference(){
        return dataReference;
    }

    public int getInt(){
        if(type != Type.INTEGER) throw new IllegalStateException("Type is not INTEGER");
        return (int) data;
    }

    public String getString(){
        if(type != Type.STRING) throw new IllegalStateException("Type is not STRING");
        return (String) data;
    }

    public double getDouble(){
        if(type != Type.DOUBLE) throw new IllegalStateException("Type is not DOUBLE");
        return (double) data;
    }

    public long getLong(){
        if(type != Type.LONG) throw new IllegalStateException("Type is not LONG");
        return (long) data;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\"").append(dataReference).append("\":");
        if(type == Type.STRING){
            sb.append("\"").append(data).append("\"");
        } else {
            sb.append(data);
        }

        return sb.toString();
    }
}
