package geekbrains.jt.homework2;

public class Person {

    private String surname, phoneNumber, email;

    public Person(String surname, String phoneNumber, String email  ) {
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }
}
