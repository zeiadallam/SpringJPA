package com.postgrs.JPAJavaDemoApp.repo;

import com.postgrs.JPAJavaDemoApp.entity.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository<P> extends CrudRepository<Person, String> {
    List<Person> findByFirstName(String firstName);

//    Person findOne(Long id);
}
