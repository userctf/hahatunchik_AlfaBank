package Alpha_Beta_Gamma_Shtrih.Model;

public class Profile {
    //private String docType; // Изменил название для соблюдения стандартов Java
    private int clientId;
    private int organizationId;
    private String segment;
    private String role;
    private int organizations;
    private String currentMethod;
    private boolean mobileApp;
    private int[] common;
    private int[] special;
    private String[] availableMethods;
    private int claims;

    public Profile() {}

    public Profile(int clientId, int organizationId, String segment, String role, int organizations, String currentMethod, boolean mobileApp,
                    int[] common, int[] special, String[] availableMethods, int claims) {
        this.clientId = clientId;
        this.organizationId = organizationId; // Исправили здесь
        this.segment = segment;
        this.role = role;
        this.organizations = organizations;
        this.mobileApp = mobileApp;
        this.common = common; // Убедитесь, что signatures не пустой
        this.special = special; // Убедитесь, что signatures не пустой
        this.availableMethods = availableMethods;
        this.claims = claims;
    }

    // Геттеры и сеттеры

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(int organizationId) {
        this.organizationId = organizationId;
    }

    public String getSegment() {
        return segment;
    }

    public void setSegment(String segment) {
        this.segment = segment;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getOrganizations() {
        return organizations;
    }

    public void setOrganizations(int organizations) {
        this.organizations = organizations;
    }

    public String getCurrentMethod() {
        return currentMethod;
    }

    public void setCurrentMethod(String currentMethod) {
        this.currentMethod = currentMethod;
    }

    public boolean isMobileApp() {
        return mobileApp;
    }

    public void setMobileApp(boolean mobileApp) {
        this.mobileApp = mobileApp;
    }

    public void setCommon(int[] common) {
        this.common = common;
    }

    public void setSpecial(int[] special) {
        this.special = special;
    }

    public int[] getCommon() {
        return common;
    }

    public int[] getSpecial() {
        return special;
    }

    public String[] getAvailableMethods() {
        return availableMethods;
    }

    public void setAvailableMethods(String[] availableMethods) {
        this.availableMethods = availableMethods;
    }

    public int getClaims() {
        return claims;
    }

    public void setClaims(int claims) {
        this.claims = claims;
    }
}
