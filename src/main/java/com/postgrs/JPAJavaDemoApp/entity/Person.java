package com.postgrs.JPAJavaDemoApp.entity;

import ch.qos.logback.classic.db.names.ColumnName;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "Student")
@Table(
        name ="student_table",
        uniqueConstraints = {
                @UniqueConstraint(name = "Student_email_UN",columnNames = "email"),
        }
)

public class Person {
    @Id
    @SequenceGenerator(
            name = "Student_Sequence",
            sequenceName = "Student_Sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "Student_Sequence"
    )
    private Long id;
    @Column(
            nullable = false,
            columnDefinition = "Text"
    )
    private String firstName;
    @Column(
            nullable = false,
            columnDefinition = "Text"
    )
    private String lastName;
    @Column(
            columnDefinition = "Text")
    private String email;
    @Column(
            nullable = false,
            columnDefinition = "Text"
    )
    private Integer age;

    public Person(Long id, String firstName, String lastName, String email, Integer age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }

    public Person() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
