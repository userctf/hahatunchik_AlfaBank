package Alpha_Beta_Gamma_Shtrih.Model;

public class Profile {
    private String docType; // Изменил название для соблюдения стандартов Java
    private int clientId;
    private int organizationId;
    private String segment;
    private String role;
    private int organizations;
    private String currentMethod;
    private boolean mobileApp;
    private int[][] signatures;
    private int[] common;
    private int[] special;
    private String[] availableMethods;
    private int claims;

    public Profile() {}

    public Profile(String docType, int clientId, int organizationId, String segment, String role, int organizations, String currentMethod, boolean mobileApp,
                   int[][] signatures, String[] availableMethods, int claims) {
        this.docType = docType;
        this.clientId = clientId;
        this.organizationId = organizationId; // Исправили здесь
        this.segment = segment;
        this.role = role;
        this.organizations = organizations;
        this.mobileApp = mobileApp;
        this.signatures = signatures;
        this.common = this.signatures[0]; // Убедитесь, что signatures не пустой
        this.special = this.signatures[1]; // Убедитесь, что signatures не пустой
        this.availableMethods = availableMethods;
        this.claims = claims;
    }

    // Геттеры и сеттеры
    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

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

    public int[][] getSignatures() {
        return signatures;
    }

    public void setSignatures(int[][] signatures) {

        this.signatures = signatures;
        this.common = signatures.length > 0 ? signatures[0] : null;  // Защита от пустого массива
        this.special = signatures.length > 1 ? signatures[1] : null; // Защита от пустого массива
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
