package Alpha_Beta_Gamma_Shtrih.Model;

public class SignMethodIn {
    private Profile profile;
    private String documentType; // 'common' or 'special'

    // Конструкторы, геттеры и сеттеры
    public SignMethodIn() {
    }

    public SignMethodIn(Profile profile, String documentType) {
        this.profile = profile;
        this.documentType = documentType;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public String getAge() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }
}