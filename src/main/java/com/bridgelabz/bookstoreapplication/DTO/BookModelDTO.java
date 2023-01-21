package com.bridgelabz.bookstoreapplication.DTO;

import lombok.ToString;

import javax.persistence.Column;
import javax.validation.constraints.*;

@ToString
public class BookModelDTO {

    @NotNull(message = "Book Name cannot be empty")
    public String bookName;

    @NotNull(message = "Book Author name cannot be empty")
    public String bookAuthor;

    @NotNull(message = "Book Description cannot be empty")
    public String bookDescription;

    @NotNull(message = "Book Image cannot be empty")
    public String bookImage;

    @NotNull(message = "Book Price cannot be empty")
    public String bookPrice;

    @NotNull(message = "Book Quantity cannot be empty")
    public int bookQuantity;
}
