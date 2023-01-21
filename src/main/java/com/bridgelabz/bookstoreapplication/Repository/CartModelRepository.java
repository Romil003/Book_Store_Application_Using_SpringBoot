package com.bridgelabz.bookstoreapplication.Repository;

import com.bridgelabz.bookstoreapplication.Model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartModelRepository extends JpaRepository<Cart,Integer> {
}
