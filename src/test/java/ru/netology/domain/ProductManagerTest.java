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


}
