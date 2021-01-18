package ru.job4j.gc;

import org.openjdk.jol.info.GraphLayout;
import org.openjdk.jol.vm.VM;

public class User {
    private int userNumber;
    private String nick;
    private double rating;

    public User(int userNumber, String nick, double rating) {
        this.userNumber = userNumber;
        this.nick = nick;
        this.rating = rating;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("User#" + userNumber +" destroyed");
    }
}

class UserGC {
    private static final long KB = 1000;
    private static final long MB = KB * KB;
    private static final Runtime ENVIRONMENT = Runtime.getRuntime();
    public static void info() {
        final long freeMemory = ENVIRONMENT.freeMemory();
        final long totalMemory = ENVIRONMENT.totalMemory();
        final long maxMemory = ENVIRONMENT.maxMemory();
        System.out.println("=== Environment state ===");
        System.out.printf("Free: %dMB%n", freeMemory / MB);
        System.out.printf("Total: %dMB%n", totalMemory / MB);
        System.out.printf("Max: %dMB%n", maxMemory / MB);
    }
    public static void main(String[] args) {
        info();
        System.out.println(VM.current().details());

        User user = new User(1, "A", 4.7);
        System.out.println(GraphLayout.parseInstance(user).toFootprint());
        // объект user занимает 80 байт
        for (int i = 0; i < 12500; i++) {
            new User(i, "A", 4.56);
        }
    }

}
