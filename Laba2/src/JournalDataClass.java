public class JournalDataClass {
    String surname;
    String name;
    String birthDate;
    String phone;
    String address;


    public JournalDataClass(String surname, String name, String birthDate, String phone, String address) {
        this.surname = surname;
        this.name = name;
        this.birthDate = birthDate;
        this.phone = phone;
        this.address = address;

    }


    @Override
    public String toString() {
        return "Student{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
