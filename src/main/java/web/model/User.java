package web.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @NotEmpty(message = "Поле Name не должно остаться пустым")
    @Size(min = 2, max = 15, message = "Длина name должна быть в диапазоне от 2 до 15 символов")
    @Column(name = "name")
    private String name;
    @NotEmpty(message = "Поле surname не должно остаться пустым")
    @Size(min = 2, max = 15, message = "Длина surname должна быть в диапазоне от 2 до 15 символов")
    @Column(name = "surname")
    private String surName;
    @Min(value = 10, message = "age должен быть не менее 10")
    @Max(value = 120, message = "age должен быть не более 120")
    @Column(name = "age")
    private int age;


    public User() {
    }

    public User(String name, String surName, int age) {
        this.name = name;
        this.surName = surName;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Name: " + name + " Surname: " + surName + " Age: " + age;
    }
}
