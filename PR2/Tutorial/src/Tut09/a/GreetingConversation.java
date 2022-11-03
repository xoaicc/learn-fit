package Tut09.a;

public class GreetingConversation {
    public static void main(String[] args) {
        MobilePhone phone1 = new MobilePhone("Apple", "Iphone12", 'R', 2021, true);
        System.out.println(phone1.toString());

        Person person = new Person(1, "Vuong", phone1);
        System.out.println(person.toString());

        MobilePhone phone2 = new MobilePhone("Apple", "Iphone12");
        System.out.println(phone2.toString());
    }
}
