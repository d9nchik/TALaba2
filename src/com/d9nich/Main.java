package com.d9nich;

import com.d9nich.Structure.Structure;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Structure structure = generator();
        System.out.println(structure.show("123"));
    }
    private static Structure generator(){
        Structure structure = new Structure();
        Random random = new Random();
        for (int i = 0; i <20000 ; i++) {
            structure.add(random.nextInt()+" ", random.nextInt()+" ");
        }
        return structure;
    }
}
