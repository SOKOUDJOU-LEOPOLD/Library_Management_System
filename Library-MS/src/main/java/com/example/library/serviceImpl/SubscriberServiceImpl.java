package com.example.library.serviceImpl;

import com.example.library.DTO.SubscriberDTO;
import com.example.library.entity.Subscriber;
import com.example.library.repository.SubscriberRepository;
import com.example.library.service.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SubscriberServiceImpl implements SubscriberService {

    @Autowired
    private SubscriberRepository subscriberRepository;
    @Override
    public List<SubscriberDTO> getSubscribers() {
        List<Subscriber> subscribers = subscriberRepository.findAll();
        List<SubscriberDTO> subscriberDTOS = subscribers.stream().map(s->mapToDTO(s)).collect(Collectors.toList());
        return subscriberDTOS;
    }

    @Override
    public SubscriberDTO addSubscriber(Subscriber subscriber) {
        return mapToDTO(subscriberRepository.save(subscriber));
    }

    @Override
    public Optional<Subscriber> findById(int id) {
        return subscriberRepository.findById(id);
    }

    @Override
    public void updateSubscriber(Subscriber newSubscriber) {
        subscriberRepository.save(newSubscriber);
    }

    @Override
    public void deleteById(int id) {
        subscriberRepository.deleteById(id);
    }


    private SubscriberDTO mapToDTO(Subscriber s) {

        SubscriberDTO subscriberDTO = new SubscriberDTO();
        subscriberDTO.setId(s.getSubNo());
        subscriberDTO.setName(s.getSubFname() + s.getSubLname());
        subscriberDTO.setUsername(s.getSubUsername());
        subscriberDTO.setEmail(s.getSubEmail());
        subscriberDTO.setPhoneNum(s.getSubPhone());
        subscriberDTO.setAddress(s.getSubAddress());
        subscriberDTO.setType(s.getSubType());

        return subscriberDTO;
    }


}
