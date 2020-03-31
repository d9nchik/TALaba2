package com.d9nich.Structure;

import java.math.BigInteger;

public class Structure {
    private int conflicts = 0;
    private Pair[] pairs;

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
        } else if (show(key) != null) {
            System.out.println("Key already exist!");
        } else {
            conflicts++;
            pairs[i] = new Pair(key, value, pairs[i]);
            if (conflicts > pairs.length/2)
                matrixRebuild();
        }
    }

    private void matrixRebuild() {
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

    public String show(String key) {
        int i = Integer.parseInt(FNV.fNV_32(key.getBytes()).modPow(new BigInteger("1"),
                new BigInteger("" + pairs.length)).toString());
        Pair temporary = pairs[i];
        while (temporary != null) {
            if (temporary.getKey().equals(key))
                return temporary.getValue();
            temporary = temporary.getNextElement();
        }
        //System.out.println("Key not found!");
        return null;
    }
}
