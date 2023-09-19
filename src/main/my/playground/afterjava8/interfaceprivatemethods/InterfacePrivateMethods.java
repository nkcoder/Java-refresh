package my.playground.afterjava8.interfaceprivatemethods;

public class InterfacePrivateMethods implements Animal {
    public static void main(String[] args) {
        InterfacePrivateMethods ipm = new InterfacePrivateMethods();
        ipm.bark();
    }
}

interface Animal {
    default void bark() {
        think();
        System.out.println("hello");
    }

    private void think() {
        System.out.println("thinking...");
    }
}
