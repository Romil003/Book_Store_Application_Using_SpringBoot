package com.bridgelabz.bookstoreapplication.Controller;

import com.bridgelabz.bookstoreapplication.DTO.BookModelDTO;
import com.bridgelabz.bookstoreapplication.DTO.ResponseDTO;
import com.bridgelabz.bookstoreapplication.DTO.UserLoginDTO;
import com.bridgelabz.bookstoreapplication.Model.BookModel;
import com.bridgelabz.bookstoreapplication.Model.UserLogin;
import com.bridgelabz.bookstoreapplication.Service.IBookModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookModelController {

    @Autowired
    private IBookModelService iBookModelService;

    @GetMapping("/allBookData")
    public ResponseEntity<ResponseDTO> getAllBooks(){
        List<BookModel> bookModelList = iBookModelService.findAllBooks();
        ResponseDTO responseDTO = new ResponseDTO("Getting all books => ",bookModelList);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/getbyId/{Id}")
    public ResponseEntity<ResponseDTO> getBookById(@PathVariable int Id){
        BookModel bookModel = iBookModelService.findBookById(Id);
        ResponseDTO responseDTO = new ResponseDTO("Get all book data of Id : "+Id,bookModel);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/addBookData")
    public ResponseEntity<ResponseDTO> createBookData(@Valid @RequestBody BookModelDTO bookModelDTO){
        BookModel bookModel = iBookModelService.addBook(bookModelDTO);
        ResponseDTO responseDTO = new ResponseDTO("Creating book data : ",bookModel);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/editBookData/{Id}")
    public ResponseEntity<ResponseDTO> editBookData(@PathVariable int Id,@Valid @RequestBody BookModelDTO bookModelDTO){
        BookModel bookModel = iBookModelService.updateBookData(Id,bookModelDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updating Book data : ",bookModel);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);

    }

    @DeleteMapping("/deletebookbyid/{Id}")
    public ResponseEntity<ResponseDTO> deleteBookDataById(@PathVariable int Id){
        iBookModelService.deleteBookById(Id);
        ResponseDTO responseDTO = new ResponseDTO("Deleted successfully !!!");
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
}
