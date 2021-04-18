package com.postgrs.JPAJavaDemoApp.repo;

import com.postgrs.JPAJavaDemoApp.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository<P> extends JpaRepository<Person, Long> {
    List<Person> findByFirstName(String firstName);

    Person findByEmail(String email);

//    Person findOne(Long id);
}
