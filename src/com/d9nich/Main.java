package com.d9nich;

import com.d9nich.Structure.Structure;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Structure structure = generator();
        structure.add("123", "hi Dan");
        System.out.println(structure.showNumberOFCompare("123"));
        System.out.println(structure.getFullyOfMatrix());
    }

    private static Structure generator() {
        Structure structure = new Structure();
        Random random = new Random();
        for (int i = 0; i < 2000; i++) {
            StringBuilder key = new StringBuilder();
            for (int j = 0; j < random.nextInt(20); j++) {
                int choice = random.nextInt(('9' - '0' + 1) + ('Z' - 'A' + 1));
                key.append(((char) (choice < 10 ? '0' + choice : choice - 10 + 'A')));
            }
            structure.add(key.toString(), random.nextInt() + "");
        }
        return structure;
    }
}
