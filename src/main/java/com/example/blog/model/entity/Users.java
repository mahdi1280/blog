package com.example.blog.model.entity;

import com.example.blog.enums.Roles;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Users  implements Serializable {
    private int id;
    private String email;
    private String password;
    private String name;
    private String cover;
    private boolean enable = true;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private Collection<Posts> posts= new ArrayList<>();
    private Collection<Roles> roles = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Column(unique = true)
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }
    @Column(name = "created_at" , updatable = false)
    @CreationTimestamp
    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
    @Column(name = "updated_at")
    @UpdateTimestamp
    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }

    @OneToMany(mappedBy = "users",fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    public Collection<Posts> getPosts() {
        return posts;
    }

    public void setPosts(Collection<Posts> posts) {
        this.posts = posts;
    }

    @Column(columnDefinition = "boolean default true")
    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    @ElementCollection(targetClass = Roles.class)
    @CollectionTable(name = "authorities" , joinColumns = @JoinColumn(name = "email" , referencedColumnName = "email"))
    @Enumerated(value = EnumType.STRING)
    public Collection<Roles> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Roles> roles) {
        this.roles = roles;
    }
}
