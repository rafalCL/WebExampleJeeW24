package pl.coderslab.webexamplejeew24.examples;

import java.util.UUID;

public class UuidExample {
    public static void main(String[] args) {
        UUID uuid = UUID.randomUUID();
        String uuidStr = uuid.toString();
        System.out.println(uuidStr);
    }
}
