package com.bridgelabz.bookstoreapplication.Service;

import com.bridgelabz.bookstoreapplication.DTO.BookModelDTO;
import com.bridgelabz.bookstoreapplication.DTO.UserLoginDTO;
import com.bridgelabz.bookstoreapplication.Model.BookModel;
import com.bridgelabz.bookstoreapplication.Model.UserLogin;

import java.util.List;

public interface IBookModelService {

    List<BookModel> findAllBooks();

    BookModel findBookById(int Id);

    BookModel addBook(BookModelDTO bookModelDTO);

    BookModel updateBookData(int Id,BookModelDTO bookModelDTO);

    void deleteBookById(int Id);
}
