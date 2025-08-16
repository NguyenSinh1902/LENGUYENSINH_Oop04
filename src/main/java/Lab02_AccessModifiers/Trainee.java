package Lab02_AccessModifiers;

public class Trainee {
    private String id;
    private String name;
    private String gender;
    private byte age;

    // Constructor(goi setter vua khoi tao, vua validate du lieu)
    public Trainee(String id, String name, String gender, byte age) {
        this.setId(id);
        this.setName(name);
        this.setGender(gender);
        this.setAge(age);
    }

    // Getter vs Setter

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID cannot be empty!");
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty!");
        }
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if (gender == null) {
            throw new IllegalArgumentException("Gender cannot be null!");
        }
        gender = gender.toLowerCase();
        if (!gender.equals("male") && !gender.equals("female")) {
            throw new IllegalArgumentException("Gender must be 'male' or 'female'!");
        }
        this.gender = gender;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        if (age < 6) {
            throw new IllegalArgumentException("Age must be >= 6!");
        }
        this.age = age;
    }

    @Override
    public String toString() {
        return "Trainee{id='" + id + "', name='" + name + "', gender='" + gender + "', age=" + age + "}";
    }
}
