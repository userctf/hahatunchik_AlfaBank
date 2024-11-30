package Alpha_Beta_Gamma_Shtrih.Model;

public class SignMethodOut {
    private String[] signMethod; // one of "SMS", "PayControl", "КЭП на токене", "КЭП в приложении"

    public String[] getSignMethod() {
        return signMethod;
    }

    public void setSignMethod(String[] signMethod) {
        this.signMethod = signMethod;
    }

    public SignMethodOut(String[] signMethod) {
        this.signMethod = signMethod;
    }
    
}