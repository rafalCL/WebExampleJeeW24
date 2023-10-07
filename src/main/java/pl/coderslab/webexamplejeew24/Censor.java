package pl.coderslab.webexamplejeew24;

public class Censor {
    private static String[] NOT_ALLOWED = {"cholera", "kurde", "motyla noga"};

    public static String doCensor(final String message) {
        String censored = message;
        for(String notAllowed : NOT_ALLOWED) {
            final String stars = "*".repeat(notAllowed.length());
            censored = censored.replaceAll(notAllowed, stars);
        }

        return censored;
    }
}
