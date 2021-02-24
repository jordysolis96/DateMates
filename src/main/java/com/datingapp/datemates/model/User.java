package com.datingapp.datemates.model;

import com.datingapp.datemates.model.Post;

import javax.persistence.*;
import java.awt.*;
import java.util.List;

@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private long PhoneNumber;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private String sexuality;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private TextArea bio;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Post> posts;


    public User(){}

    public User(long id, String username, String email, long PhoneNumber, int age, String sexuality, String gender, String location, TextArea bio, String password){
        this.id = id;
        this.username = username;
        this.email = email;
        this.PhoneNumber = PhoneNumber;
        this.sexuality = sexuality;
        this.gender = gender;
        this.location = location;
        this.bio = bio;
        this.age = age;

        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSexuality() {
        return sexuality;
    }

    public void setSexuality(String sexuality) {
        this.sexuality = sexuality;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public TextArea getBio() {
        return bio;
    }

    public void setBio(TextArea bio) {
        this.bio = bio;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}

