
 package com.latteIceCream.latte.domain;

 import org.hibernate.annotations.CreationTimestamp;
 import org.hibernate.annotations.UpdateTimestamp;
 import org.springframework.security.crypto.bcrypt.BCrypt;
 import jakarta.persistence.*;
 import java.util.Date;

 @Entity
 public class User

 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50, unique = true)
    private String username;

    @Column(nullable = false, length = 30, unique = true)
    private String phone_number;

    @Column(nullable = false, length = 60, unique = true, name = "PASSWD_HASH")
    private String password;

    @Column(nullable = false, length = 50, unique = true)
    private String salt;

    @Column(nullable = false, length = 30)
    private String role;

    @CreationTimestamp
    private Date created_at;

    @UpdateTimestamp
    private Date updated_at;

    public User() {}

    public User(String username, String phone_number, String password, String role)

    {

      this.username = username;
      this.phone_number = phone_number;
      this.salt = BCrypt.gensalt();
      this.password = BCrypt.hashpw(password, this.salt);
      this.created_at = new Date();
      this.role = role;

    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPhone_number() { return phone_number; }
    public void setPhone_number(String phone_number) { this.phone_number = phone_number; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Date getCreated_at() { return created_at; }
    public void setCreated_at(Date created_at) { this.created_at = created_at; }

    public Date getUpdated_at() { return updated_at; }
    public void setUpdated_at(Date updated_at) { this.updated_at = updated_at; }

    public String getSalt() { return salt; }
    public void setSalt(String salt) { this.salt = salt; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public boolean verifiedPassword(String password, String password_hash)

    {

      boolean correctPasswd = BCrypt.checkpw(password, password_hash);
      if(!correctPasswd){ System.out.println("Incorrect password. Try Again."); }
      return correctPasswd;

    }

 }
