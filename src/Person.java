public class Person {
    private final Name name;
    private final int age;
    private final Address address;
    private final Gender gender;

    Person(String firstName, String lastName, Gender gender, int age, String city, String state, String country) {
        this.name = new Name(firstName, lastName);
        this.age = age;
        this.address = new Address(city, state, country);
        this.gender = gender;
    }


    public String invitationName() {
        return gender + " " + name.toFirstLast();
    }

    public String invitationNameLastFirst() {
        System.out.println(gender);
        return gender + " " + name.toLsasFirst();
    }
}
