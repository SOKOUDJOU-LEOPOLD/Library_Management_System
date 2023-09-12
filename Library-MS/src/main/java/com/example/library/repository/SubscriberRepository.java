package com.example.library.repository;

import com.example.library.entity.Borrowing;
import com.example.library.entity.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubscriberRepository extends JpaRepository<Subscriber, Integer> {

}
