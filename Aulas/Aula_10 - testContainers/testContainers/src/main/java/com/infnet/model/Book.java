package com.infnet.model;

@Table("books")
public record Book(
        @Id Long id,
        String isbn,
        String title,
        String author,
        Double price
) {
    public static Book of(String isbn, String title, String author, Double price) {
        return new Book(null, isbn, title, author, price);
    }
}