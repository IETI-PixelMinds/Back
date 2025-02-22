package org.adaschool.project.model;

import org.adaschool.project.dto.UserDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Document(collection = "users")
public class User {

    @Id
    private String id;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private String userType; // "carpintero/tienda"

    public User(){
    }

    public User(String id, String name, String lastName, String email, String password, String userType) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = new BCryptPasswordEncoder().encode(password);
        this.userType = userType;
    }

    public User(UserDTO userDTO){
        this.id = null;
        this.name = userDTO.getName();
        this.lastName = userDTO.getLastName();
        this.email = userDTO.getEmail();
        this.password = new BCryptPasswordEncoder().encode(userDTO.getPassword());
        this.userType = userDTO.getUserType();
    }

    // Getters y Setters
    public String getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getPasswordHash() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public void update(UserDTO userDTO){
        this.name = userDTO.getName();
        this.lastName = userDTO.getLastName();
        this.email = userDTO.getEmail();
        this.password = new BCryptPasswordEncoder().encode(userDTO.getPassword());
        this.userType = userDTO.getUserType();
    }
}