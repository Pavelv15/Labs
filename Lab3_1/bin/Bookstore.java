package bin;

import java.util.List;

record Book(String name,int price) {}

public class Bookstore {
    public static void main(String[] args) {
        List<Book> books = List.of(
                new Book("Мастер и Маргарита",500),
                new Book("Конец Детства",360),
                new Book("Сбрник сказок Пушкина", 700),
                new Book("Сирены Титана", 400),
                new Book("Академия",450),
                new Book("Архитектура компьютера",600)
        );
        System.out.println("Список книг: ");
        books.stream().sorted((c1,c2) -> c1.name().compareTo(c2.name())).map(book -> book.name()).forEach(System.out::println);

        int minPrice  = books.stream().mapToInt(book -> book.price()).min().getAsInt();
        System.out.println("Минимальная цена за книгу: "  + minPrice);

        int maxPrice  = books.stream().mapToInt(book -> book.price()).max().getAsInt();
        System.out.println("Максимальная цена за книгу: "  + maxPrice);

        double avgPrice =  books.stream().mapToInt(book -> book.price()).average().getAsDouble();
        System.out.println("Средняя цена за книгу " + avgPrice);
        System.out.print("Самая дешевая книга : ");
        books.stream().filter(book -> book.price() == minPrice).map(book -> book.name()).forEach(System.out::println);
        System.out.print("Самая дорогая  книга : ");
        books.stream().filter(book -> book.price() == maxPrice).map(book -> book.name()).forEach(System.out::println);

     }

}
