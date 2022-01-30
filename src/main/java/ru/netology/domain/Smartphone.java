package ru.netology.domain;

import java.util.Objects;

public class Smartphone extends Product {
    private String trademark;

    public Smartphone() {
        super();
    }

    public Smartphone(int id, String name, int price, String trademark) {
        super(id, name, price);
        this.trademark = trademark;
    }

    public String getTrademark() {
        return trademark;
    }

    public void setTrademark(String trademark) {
        this.trademark = trademark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Smartphone that = (Smartphone) o;
        return trademark.equals(that.trademark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), trademark);
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "trademark='" + trademark + '\'' +
                '}';
    }
}
