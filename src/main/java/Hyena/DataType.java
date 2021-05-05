package Hyena;

public class DataType {
    private String name;
    private String expression;

    public DataType(String name, String expression) {
        this.name = name;
        this.expression = expression;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    @Override
    public String toString() {
        return "DataType{" +
                "name='" + name + '\'' +
                ", expression='" + expression + '\'' +
                '}';
    }
}
