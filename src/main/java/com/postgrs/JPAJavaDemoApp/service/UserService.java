package com.postgrs.JPAJavaDemoApp.service;

import com.postgrs.JPAJavaDemoApp.entity.Person;
import com.postgrs.JPAJavaDemoApp.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {

   UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public List<Person> getAllPersons() {
        return (List<Person>) userRepository.findAll();
    }

    @Transactional
    public List<Person> findByName(String name) {
        return userRepository.findByFirstName(name);
    }

//    @Transactional
//    public Person getById(Long id) {
//        return userRepository.findOne(id);
//    }

    @Transactional
    public void deletePerson(Long personId) {
        userRepository.delete(personId);
    }

    @Transactional
    public boolean addPerson(Person person) {
        return userRepository.save(person) != null;
    }

    @Transactional
    public boolean updatePerson(Person person) {
        return userRepository.save(person) != null;
    }
}
