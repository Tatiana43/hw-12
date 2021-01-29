package ru.netology.domain;

import org.junit.jupiter.api.Test;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductManagerTest {

    @Test
    public void shouldSearchBookByName() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        Book book1 = new Book(1, "Java", 999, "Levinski");
        Book book2 = new Book(2, "Java", 99, "Levinski");
        Book book3 = new Book(3, "Kotlin", 300, "Levinski");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] actual = manager.searchBy("Java");
        Product[] expected = new Product[]{book1, book2};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldSearchBookByAuthor() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        Book book1 = new Book(1, "Java", 999, "Levinski");
        Book book2 = new Book(2, "Java", 99, "Levinski");
        Book book3 = new Book(3, "Kotlin", 300, "Levinski");
        Book book4 = new Book(4, "Kotlin", 300, "Green");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);

        Product[] actual = manager.searchBy("levinski");
        Product[] expected = new Product[]{book1, book2, book3};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldSearchSmartphoneByName() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        Smartphone smartphone1 = new Smartphone(1, "s20", 9999, "Samsung");
        Smartphone smartphone2 = new Smartphone(2, "8.3", 9999, "Nokia");
        Smartphone smartphone3 = new Smartphone(3, "12", 30000, "iPhone");
        Smartphone smartphone4 = new Smartphone(4, "Redmi A5", 15000, "Xiaomi");

        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        manager.add(smartphone4);

        Product[] actual = manager.searchBy("redmi a5");
        Product[] expected = new Product[]{smartphone4};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldSearchSmartphoneByProductionCompany() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        Smartphone smartphone1 = new Smartphone(1, "s20", 9999, "Samsung");
        Smartphone smartphone2 = new Smartphone(2, "8.3", 9999, "Nokia");
        Smartphone smartphone3 = new Smartphone(3, "12", 30000, "iPhone");
        Smartphone smartphone4 = new Smartphone(4, "Redmi A5", 15000, "Xiaomi");
        Smartphone smartphone5 = new Smartphone(5, "s10", 15000, "Samsung");

        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        manager.add(smartphone4);
        manager.add(smartphone5);

        Product[] actual = manager.searchBy("Samsung");
        Product[] expected = new Product[]{smartphone1, smartphone5};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldFindNoBook() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        Book book1 = new Book(1, "Java", 999, "Levinski");
        Book book2 = new Book(2, "Java", 99, "Levinski");
        Book book3 = new Book(3, "Kotlin", 300, "Levinski");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] actual = manager.searchBy("C++");
        Product[] expected = new Product[]{};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldFindNoSmartphone() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        Smartphone smartphone1 = new Smartphone(1, "s20", 9999, "Samsung");
        Smartphone smartphone2 = new Smartphone(2, "8.3", 9999, "Nokia");
        Smartphone smartphone3 = new Smartphone(3, "12", 30000, "iPhone");
        Smartphone smartphone4 = new Smartphone(4, "Redmi A5", 15000, "Xiaomi");
        Smartphone smartphone5 = new Smartphone(5, "s10", 15000, "Samsung");

        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        manager.add(smartphone4);
        manager.add(smartphone5);

        Product[] actual = manager.searchBy("ASUS");
        Product[] expected = new Product[]{};
        assertArrayEquals(actual, expected);
    }

}
