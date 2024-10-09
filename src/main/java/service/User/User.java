package service.User;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
@NamedQuery(name="User.findByUsernamePass", query="select u from User u where u.username=:username and u.password=:password")
@NamedQuery(name="User.findByUsername", query="select u from User u where u.username=:username")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Integer id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}