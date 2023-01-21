package com.bridgelabz.bookstoreapplication.Repository;

import com.bridgelabz.bookstoreapplication.Model.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookModelRepository extends JpaRepository<BookModel,Integer> {
}
