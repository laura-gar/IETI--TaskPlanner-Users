package com.taskplanner.users.entities;

import com.taskplanner.users.dto.UserDto;
import com.taskplanner.users.utils.RoleEnum;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Laura Garcia
 */
@Document(collection = "users")
public class User {
    @Id
    private String id;
    private String name;
    @Indexed(unique = true)
    private String email;
    private Date createdAt;
    private String lastName;
    private String password;
    private List<RoleEnum> roles = new ArrayList<>();

    public User() {
        this.createdAt = Date.from(Instant.now());
    }

    public User(String name, String lastName,  String email, String password) {
        this();
        this.name = name;
        this.email = email;
        this.lastName = lastName;
        System.out.println("CREATE");
        hashPassword(password);
    }

    public User(UserDto userDto){
        this(userDto.getName(), userDto.getLastName(), userDto.getEmail(), userDto.getPassword());
    }

    public void update(UserDto user) {
        name = user.getName();
        lastName = user.getLastName();
        email = user.getEmail();
        hashPassword(user.getPassword());
    }

    private void hashPassword(String password){
        if(password != null){
            System.out.println("ConvertPassword");
            this.password = BCrypt.hashpw(password, BCrypt.gensalt());
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getPassword() {
        return password;
    }

    public List<RoleEnum> getRoles() {
        return roles;
    }

    public void addRole(RoleEnum role){
        if(!roles.contains(role)){
            roles.add(role);
        }
    }
}
