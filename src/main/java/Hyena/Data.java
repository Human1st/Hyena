package Hyena;

public class Data {
    private DataType type;
    private String data;

    public Data(DataType type, String data) {
        this.type = type;
        this.data = data;
    }

    public DataType getType() {
        return type;
    }

    public void setType(DataType type) {
        this.type = type;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }



    @Override
    public String toString() {
        return "Data{" +
                "type=" + type +
                ", name='" + data + '\'' +
                '}';
    }
}
