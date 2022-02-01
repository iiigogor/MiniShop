package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);

    Product b1 = new Book(1, "JAVA", 1000, "Netology1");
    Product b2 = new Book(2, "PHP", 2000, "Netology2");
    Product b3 = new Book(3, "C++", 3000, "Netology3");

    Product s1 = new Smartphone(4, "REDMI", 30000, "XIAOMI");
    Product s2 = new Smartphone(5, "X20", 25000, "XIAOMI");
    Product s3 = new Smartphone(6, "IPh13", 65000, "APPLE");

    @BeforeEach
    public void setUp() {
        manager.add(b1);
        manager.add(b2);
        manager.add(b3);
        manager.add(s1);
        manager.add(s2);
        manager.add(s3);

    }

    @Test
    void shouldSearchByAuthorBook() {
        Product[] expected = new Product[]{b1};
        Product[] actual = manager.searchBy("Netology1");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByNameBook() {
        Product[] expected = new Product[]{b3};
        Product[] actual = manager.searchBy("C++");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByTrademarkSmartphone() {
        Product[] expected = new Product[]{s3};
        Product[] actual = manager.searchBy("APPLE");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByNameSmartphone() {
        Product[] expected = new Product[]{s2};
        Product[] actual = manager.searchBy("X20");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchAfterDelete() {
        repository.removeById(6);
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy(s3.getName());
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchAllByTrademarkSmartphone() {
        Product[] expected = new Product[]{s1, s2};
        Product[] actual = manager.searchBy("XIAOMI");
        assertArrayEquals(expected, actual);
    }

    @Test
    void lookForAmissingProduct() {
        Product[] expected = {};
        Product[] actual = manager.searchBy("samsung");
        assertArrayEquals(expected, actual);
    }

    //тест из разбора задач
    @Test
    void shouldReturnEmptyArray() {
        Product[] actual = manager.searchBy("b5");
        assertEquals(0, actual.length);
    }
}