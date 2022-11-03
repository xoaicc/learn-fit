package Tut09.b;

public class GreetingConversation2 {
    public static void main(String[] args) {
        Person person = new Person(1, "Vuong");
        System.out.println(person.toString());

        MobilePhone phone = new MobilePhone("Apple", "Iphone12", 'R', 2021, true);
        System.out.println(phone.toString());

        PhoneOwnerShip pos = new PhoneOwnerShip(person, phone);
        System.out.println(pos.toString());
    }
}
