package Tut10.a;

public class GreetingConversation {
    public MobilePhone mp;
    public Person ps;

    private static final GreetingConversation greetingConversation = new GreetingConversation();

    private GreetingConversation() {}

    public static GreetingConversation getInstance() {
        return greetingConversation;
    }

    public static void main(String[] args) {
        GreetingConversation gcs1 = GreetingConversation.getInstance();
        GreetingConversation gcs2 = GreetingConversation.getInstance();
        GreetingConversation gcs3 = GreetingConversation.getInstance();

        gcs1.mp = new MobilePhone("Apple", "Iphone 12 Pro MAX", 'W', 2021, true);
        System.out.println(gcs1.mp.toString());

        gcs2.ps = new Person(1, "Vuong", gcs1.mp);
        System.out.println(gcs2.ps.toString());

        gcs3.mp = new MobilePhone("Samsung", "Galaxy Note 20 Ultra");
        System.out.println(gcs3.mp.toString());
    }
}
