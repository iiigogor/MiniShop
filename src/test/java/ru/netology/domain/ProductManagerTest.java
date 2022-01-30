package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);

    Product B1 = new Book(1, "JAVA", 1000, "Netology1");
    Product B2 = new Book(2, "PHP", 2000, "Netology2");
    Product B3 = new Book(3, "C++", 3000, "Netology3");

    Product S1 = new Smartphone(4, "REDMI", 30000, "XIAOMI");
    Product S2 = new Smartphone(5, "X20", 25000, "NOKIA");
    Product S3 = new Smartphone(6, "IPh13", 65000, "APPLE");

    @BeforeEach
    public void setUp() {
        manager.add(B1);
        manager.add(B2);
        manager.add(B3);
        manager.add(S1);
        manager.add(S2);
        manager.add(S3);

    }
    @Test
    void shouldSearchByAuthorBook() {
        Product[] expected = new Product[]{B1};
        Product[] actual = manager.searchBy("Netology1");
        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldSearchByNameBook() {
        Product[] expected = new Product[]{B3};
        Product[] actual = manager.searchBy("C++");
        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldSearchByTrademarkSmartphone() {
        Product[] expected = new Product[]{S3};
        Product[] actual = manager.searchBy("APPLE");
        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldSearchByNameSmartphone() {
        Product[] expected = new Product[]{S2};
        Product[] actual = manager.searchBy("X20");
        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldSearchAfterDelete() {
        //int id=6;
        repository.removeById(6);
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy(S3.getName());
        assertArrayEquals(expected, actual);
    }
}