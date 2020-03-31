package com.d9nich.Structure;

import java.util.Objects;

class Pair {
    private String key;
    private String value;
    private Pair nextElement;

    public Pair(String key, String value) {
        this(key, value, null);
    }

    public Pair(String key, String value, Pair nextElement) {
        this.key = key;
        this.value = value;
        this.nextElement = nextElement;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public Pair getNextElement() {
        return nextElement;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setNextElement(Pair nextElement) {
        this.nextElement = nextElement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return key.equals(pair.key) &&
                value.equals(pair.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }
}
