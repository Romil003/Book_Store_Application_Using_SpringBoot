package com.bridgelabz.bookstoreapplication.Service;

import com.bridgelabz.bookstoreapplication.DTO.BookModelDTO;
import com.bridgelabz.bookstoreapplication.Exception.BookModelException;
import com.bridgelabz.bookstoreapplication.Model.BookModel;
import com.bridgelabz.bookstoreapplication.Repository.BookModelRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BookModelService implements IBookModelService{

    @Autowired
    private BookModelRepository bookModelRepository;

    @Override
    public List<BookModel> findAllBooks() {
        return bookModelRepository.findAll();
    }

    @Override
    public BookModel findBookById(int Id) {
        return bookModelRepository.findById(Id).orElseThrow(() -> new BookModelException("Book Not Found"));
    }

    @Override
    public BookModel addBook(BookModelDTO bookModelDTO) {
        BookModel bookModel = new BookModel(bookModelDTO);
        bookModelRepository.save(bookModel);
        log.info("Book data added successfully !!!");
        return bookModel;
    }

    @Override
    public BookModel updateBookData(int Id, BookModelDTO bookModelDTO) {
        BookModel bookModel = this.findBookById(Id);
        if (bookModel != null){
            bookModel.setBookName(bookModelDTO.bookName);
            bookModel.setBookAuthor(bookModelDTO.bookAuthor);
            bookModel.setBookDescription(bookModelDTO.bookDescription);
            bookModel.setBookImage(bookModelDTO.bookImage);
            bookModel.setBookPrice(bookModelDTO.bookPrice);
            bookModel.setBookQuantity(bookModelDTO.bookQuantity);
            bookModelRepository.save(bookModel);
            log.info("Book data updated successfully !!");
            return bookModel;
        }
        return null;
    }

    @Override
    public void deleteBookById(int Id) {
        bookModelRepository.deleteById(Id);
        log.info("Book data deleted successfully !!!");
    }
}
