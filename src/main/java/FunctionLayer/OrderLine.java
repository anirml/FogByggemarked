package FunctionLayer;

public class OrderLine {
    private ItemForList item;
    private String number;
    private String comments;

    public OrderLine(ItemForList item, String number, String comments) {
        this.item = item;
        this.number = number;
        this.comments = comments;
    }

    public ItemForList getItem() {
        return item;
    }

    public void setItem(ItemForList item) {
        this.item = item;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "OrderLine{" +
                "item=" + item +
                ", number='" + number + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }
}
