package com.d9nich.Structure;

import java.math.BigInteger;

public class Structure {
    private int conflicts = 0;
    private Pair[] pairs;
    private int fullyOfMatrix = 0;

    public Structure(int sizeOfStructure) {
        pairs = new Pair[sizeOfStructure];
    }

    public Structure() {
        this(100);
    }

    public void add(String key, String value) {
        int i = Integer.parseInt(FNV.fNV_32(key.getBytes()).modPow(new BigInteger("1"),
                new BigInteger("" + pairs.length)).toString());
        if (pairs[i] == null) {
            pairs[i] = new Pair(key, value);
            fullyOfMatrix++;
        } else if (show(key) != null) {
            System.out.println("Key already exist!");
        } else {
            conflicts++;
            pairs[i] = new Pair(key, value, pairs[i]);
            if (fullyOfMatrix > pairs.length * 0.8)
                matrixRebuild();
        }
    }

    private void matrixRebuild() {
        fullyOfMatrix = 0;
        Structure permanent = new Structure(pairs.length * 2);
        for (Pair pair : pairs)
            if (pair != null) {
                Pair copingVariable = pair;
                while (copingVariable != null) {
                    permanent.add(copingVariable.getKey(), copingVariable.getValue());
                    copingVariable = copingVariable.getNextElement();
                }
            }
        pairs = permanent.pairs;
    }

    public int showNumberOFCompare(String key) {
        int i = Integer.parseInt(FNV.fNV_32(key.getBytes()).modPow(new BigInteger("1"),
                new BigInteger("" + pairs.length)).toString());
        Pair temporary = pairs[i];
        int counterOfIf = 1;
        while (temporary != null) {
            if (temporary.getKey().equals(key)) {
                return counterOfIf;
            }
            temporary = temporary.getNextElement();
            counterOfIf += 2;
        }
        return counterOfIf;
    }

    public String show(String key) {
        int i = Integer.parseInt(FNV.fNV_32(key.getBytes()).modPow(new BigInteger("1"),
                new BigInteger("" + pairs.length)).toString());
        Pair temporary = pairs[i];

        while (temporary != null) {
            if (temporary.getKey().equals(key)) {
                return temporary.getValue();
            }
            temporary = temporary.getNextElement();
        }
        return null;
    }

    public double getFullyOfMatrix() {
        return fullyOfMatrix / (double) pairs.length;
    }
}
