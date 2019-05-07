package FunctionLayer;

public class ItemForList {
    private String desc;
    private String length;
    private String unit;

    public ItemForList(String desc, String length, String unit) {
        this.desc = desc;
        this.length = length;
        this.unit = unit;
    }

    public ItemForList() {
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return  desc + " " + length + "  " + unit ;
    }
}
