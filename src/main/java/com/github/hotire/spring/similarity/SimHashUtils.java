package com.github.hotire.spring.similarity;

import java.util.LinkedList;
import java.util.List;
import java.util.StringJoiner;

public class SimHashUtils {
    private static final int hashbits = 32;

    private static final int chunkSize = 4;
    private static final int overlapSize = 3;

    public static String doFilter(final String source) {
        return source.replaceAll("[.!,?)\"']+|[！，。？、~…）]+", "$0 ")
                     .trim()
                     .replaceAll("\\s+", " ");
    }

    public static List<String> tokens(final String source) {
        final List<String> binaryWords = new LinkedList<>();
        final String[] splitInput = source.split(" ");
        for (int position = 0; position < (splitInput.length - chunkSize + 1); position += chunkSize - overlapSize) {
            final StringJoiner joiner = new StringJoiner(" ");
            for (int i = 0; i < chunkSize; i++) {
                if (position + i < splitInput.length) {
                    joiner.add(splitInput[position + i]);
                }
            }
            binaryWords.add(joiner.toString());
        }
        return binaryWords;
    }

    public static long hash32(final String str) {
        int sum = 0;
        for (byte b : str.getBytes()) {
            sum = sum * 31 + (Byte.toUnsignedInt(b));
        }
        return Integer.toUnsignedLong(sum);
    }

    public static long simhash32(final String source) {
        final int[] bits = new int[hashbits];
        final List<String> tokens = tokens(source);
        for (String t : tokens) {
            long v = hash32(t);
            for (int i = hashbits; i >= 1; --i) {
                if (((v >> (hashbits - i)) & 1) == 1) {
                    ++bits[i - 1];
                } else {
                    --bits[i - 1];
                }
            }
        }

        long hash = 0x0000000000000000L;
        long one = 0x0000000000000001L;
        for (int i = hashbits; i >= 1; --i) {
            if (bits[i - 1] > 1) {
                hash |= one;
            }
            one = one << 1;
        }
        return hash;
    }

    public static String simhash32String(final String source) {
        return String.format("%08x", simhash32(source));
    }
}
