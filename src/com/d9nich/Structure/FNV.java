package com.d9nich.Structure;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class FNV {
    private FNV(){}
    private final static BigInteger PRIME = new BigInteger("811c9dc5", 16);
    private final static BigInteger OFFSET_BASIS =new BigInteger("01000193", 16);
    private final static BigInteger MOD32 = new BigInteger("2").pow(32);
    public static BigInteger  fNV_32(byte[] data){
        BigInteger hash = PRIME;
        for (byte b : data) {
            hash = hash.multiply(OFFSET_BASIS).mod(MOD32);
            hash = hash.xor(BigInteger.valueOf((int) b & 0xff));
        }

        return hash;
    }
    public static byte[] stringToByte(String line){
        byte[] storage = new byte[line.length()*2];
        int capacity =0;
        for (int i = 0; i < line.length(); i++) {
            byte[] temp = ByteBuffer.allocate(2).putChar(line.charAt(i)).array();
            for (int j = 0; j < 2; j++)
                storage[capacity++]=temp[j];
        }
        return storage;
    }
}
