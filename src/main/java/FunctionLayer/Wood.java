package FunctionLayer;

public class Wood {

    private int woodId;
    private int woodDim1;
    private int woodDim2;
    private String woodDesc;
    private int woodLength;
    private String woodUnit;
    private double woodPrice;

    public Wood(int woodId, int woodDim1, int woodDim2, String woodDesc, int woodLength, String woodUnit, double woodPrice) {
        this.woodId = woodId;
        this.woodDim1 = woodDim1;
        this.woodDim2 = woodDim2;
        this.woodDesc = woodDesc;
        this.woodLength = woodLength;
        this.woodUnit = woodUnit;
        this.woodPrice = woodPrice;
    }

    public int getWoodId() {
        return woodId;
    }

    public void setWoodId(int woodId) {
        this.woodId = woodId;
    }

    public int getWoodDim1() {
        return woodDim1;
    }

    public void setWoodDim1(int woodDim1) {
        this.woodDim1 = woodDim1;
    }

    public int getWoodDim2() {
        return woodDim2;
    }

    public void setWoodDim2(int woodDim2) {
        this.woodDim2 = woodDim2;
    }

    public String getWoodDesc() {
        return woodDesc;
    }

    public void setWoodDesc(String woodDesc) {
        this.woodDesc = woodDesc;
    }

    public int getWoodLength() {
        return woodLength;
    }

    public void setWoodLength(int woodLength) {
        this.woodLength = woodLength;
    }

    public String getWoodUnit() {
        return woodUnit;
    }

    public void setWoodUnit(String woodUnit) {
        this.woodUnit = woodUnit;
    }

    public double getWoodPrice() {
        return woodPrice;
    }

    public void setWoodPrice(double woodPrice) {
        this.woodPrice = woodPrice;
    }

    @Override
    public String toString() {
        return "Wood{" +
                "woodId=" + woodId +
                ", woodDim1=" + woodDim1 +
                ", woodDim2=" + woodDim2 +
                ", woodDesc='" + woodDesc + '\'' +
                ", woodLength=" + woodLength +
                ", woodUnit='" + woodUnit + '\'' +
                ", woodPrice=" + woodPrice +
                '}';
    }

}
