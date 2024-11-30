package Alpha_Beta_Gamma_Shtrih.Model;

public class User {
    private String name;
    private int age;

    // Конструкторы, геттеры и сеттеры
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
