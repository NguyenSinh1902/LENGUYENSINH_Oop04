package encapsulation;

public class PersonTest {
    public static void main(String[] args) {
        Person person = new Person("Sinh", 18);
        person.setAge(-18);

        System.out.println(person);
    }
}
