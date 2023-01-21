package com.bridgelabz.bookstoreapplication.Model;

import com.bridgelabz.bookstoreapplication.DTO.BookModelDTO;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Books")
@Data
public class BookModel {

    @Id
    @GeneratedValue
    private int Id;

    @Column(name = "Book_name")
    private String bookName;

    @Column(name = "Book_Author")
    private String bookAuthor;

    @Column(name = "Book_Description")
    private String bookDescription;

    @Column(name = "Book_Image")
    private String bookImage;

    @Column(name = "Book_Price")
    private String bookPrice;

    @Column(name = "Book_Quantity")
    private long bookQuantity;

    public BookModel() {
    }

    public BookModel(BookModelDTO bookModelDTO) {
        this.bookName = bookModelDTO.bookName;
        this.bookAuthor = bookModelDTO.bookAuthor;
        this.bookDescription = bookModelDTO.bookDescription;
        this.bookImage = bookModelDTO.bookImage;
        this.bookPrice = bookModelDTO.bookPrice;
        this.bookQuantity = bookModelDTO.bookQuantity;
    }
}
