
 package com.latteIceCream.latte.domain;

 import com.latteIceCream.latte.domain.superclasses.DomainEntity;

 import jakarta.persistence.Entity;
 import jakarta.persistence.Column;
 import jakarta.persistence.ManyToOne;

 import org.springframework.security.crypto.bcrypt.BCrypt;

 @Entity
 public class User extends DomainEntity

 {

    @Column(nullable = false, length = 50, unique = true)
    private String username;

    @Column(nullable = false, length = 30, unique = true)
    private String phone_number;

    @Column(nullable = false, length = 60, unique = true, name = "PASSWD_HASH")
    private String password;

    @Column(nullable = false, length = 50, unique = true)
    private String salt;

    @ManyToOne
    private Role role;

    public User() {}

    public User(String username, String phone_number, String password, Role role)

    {

       this.username = username;
       this.phone_number = phone_number;
       this.salt = BCrypt.gensalt();
       this.password = BCrypt.hashpw(password, this.salt);
       this.role = role;

    }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPhone_number() { return phone_number; }
    public void setPhone_number(String phone_number) { this.phone_number = phone_number; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getSalt() { return salt; }
    public void setSalt(String salt) { this.salt = salt; }

    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }

    public boolean verifiedPassword(String password, String password_hash)

    {

      boolean correctPasswd = BCrypt.checkpw(password, password_hash);
      if(!correctPasswd){ System.out.println("Incorrect password. Try Again."); }
      return correctPasswd;

    }

 }
