package com.bridgelabz.bookstoreapplication.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

@ToString
public class OrderDTO {

    @JsonFormat(pattern = "dd MMM yyyy")
    @NotNull(message = "startDate should not be empty")
    @PastOrPresent(message = "Order Date should be past or today's date")
    public LocalDate orderDate;

    @NotNull(message = "Price cannot be empty")
    public long price;

    @NotNull(message = "Quantity cannot be empty")
    public long quantity;

    @NotNull(message = "Address cannot be empty")
    public String address;

    @NotNull(message = "User-Id cannot be empty")
    public int userId;

    @NotNull(message = "Book-Id cannot be empty")
    public int bookId;

    @NotNull(message = "Cancel order cannot be empty")
    public boolean cancelOrder;
}
