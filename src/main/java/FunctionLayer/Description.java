package FunctionLayer;

public class Description {
    private int useId;
    private String useDesc;
    private String useCode;

    public Description(int useId, String useDesc, String useCode) {
        this.useId = useId;
        this.useDesc = useDesc;
        this.useCode = useCode;
    }

    public int getUseId() {
        return useId;
    }

    public void setUseId(int useId) {
        this.useId = useId;
    }

    public String getUseDesc() {
        return useDesc;
    }

    public void setUseDesc(String useDesc) {
        this.useDesc = useDesc;
    }

    public String getUseCode() {
        return useCode;
    }

    public void setUseCode(String useCode) {
        this.useCode = useCode;
    }
}
