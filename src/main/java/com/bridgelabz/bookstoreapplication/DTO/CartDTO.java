package com.bridgelabz.bookstoreapplication.DTO;

import lombok.ToString;

import javax.validation.constraints.NotNull;

@ToString
public class CartDTO {

    @NotNull(message = "User-Id cannot be empty")
    public int userId;

    @NotNull(message = "Book-Id cannot be empty")
    public int bookId;

    @NotNull(message = "Quantity cannot be empty")
    public long quantity;

    @NotNull(message = "Total Price cannot be empty")
    public long totalPrice;
}
