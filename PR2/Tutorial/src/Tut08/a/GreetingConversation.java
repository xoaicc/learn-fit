package Tut08.a;

public class GreetingConversation {
    public static void main(String[] args) {
        MobilePhone phone = new MobilePhone("Apple", "Iphone12", 'R', 2021, true);
        System.out.println(phone.toString());

        Person person = new Person(1, "Vuong", phone);
        System.out.println(person.toString());
    }
}
