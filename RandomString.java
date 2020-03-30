package com.mezzanine.server.mezzanineserver;

import java.security.SecureRandom;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;

public class RandomString {

    /**
     * Generate a random string.
     */
    String nextString() {
        for (int idx = 0; idx < buf.length; ++idx)
            buf[idx] = symbols[random.nextInt(symbols.length)];
        return new String(buf);
    }

    private static final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String lower = upper.toLowerCase(Locale.ROOT);
    private static final String digits = "0123456789";
    private static final String specialChars = "!@#$%^&*()_+-=.,/';:?><~*/-+";
    private static final String alphaNum = upper + lower + digits;
    private static final String specialAlphaNum = upper + lower + digits + specialChars;

    private final Random random;

    private final char[] symbols;
    private final char[] buf;

    RandomString(int length, Random random, String symbols) {
        if (length < 1) throw new IllegalArgumentException();
        if (symbols.length() < 2) throw new IllegalArgumentException();
        this.random = Objects.requireNonNull(random);
        this.symbols = symbols.toCharArray();
        this.buf = new char[length];
    }

    /**
     * Create an alphanumeric string generator with special chars.
     */
    RandomString(int length, Random random) {
        this(length, random, specialAlphaNum);
    }

    /**
     * Create an alphanumeric string generator with or without special chars.
     */
    RandomString(int length, Random random, Boolean specialChars) {
        this(length, random, specialChars ? specialAlphaNum : alphaNum);
    }

    /**
     * Create an alphanumeric strings from a secure generator.
     */
    RandomString(int length) {
        this(length, new SecureRandom());
    }
}
