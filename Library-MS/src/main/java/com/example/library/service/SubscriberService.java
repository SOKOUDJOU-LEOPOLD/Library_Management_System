package com.example.library.service;

import com.example.library.DTO.SubscriberDTO;
import com.example.library.entity.Subscriber;

import java.util.List;
import java.util.Optional;

public interface SubscriberService {
    List<SubscriberDTO> getSubscribers();

    SubscriberDTO addSubscriber(Subscriber subscriber);

    Optional<Subscriber> findById(int id);

    void updateSubscriber(Subscriber newSubscriber);

    void deleteById(int id);
}
