package entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@NamedQueries({
        @NamedQuery(name = "User.all", query = "select us from UserEntity us order by us.idUser"),
        @NamedQuery(name = "User.byUsername", query = "select us from UserEntity us where us.name = :username and us.password = :password")
})
@Entity
@Table(name="user")
public class UserEntity  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_user")
    private int idUser;

    @Column(name="name",nullable = false)
    @Size(max = 100)
    private String name;

    public String getName() {
        return name;
    }
    @Column(name="surname",nullable = false)
    @Size(max = 100)
    private String surname;

    @Column(name="email",nullable = false)
    @Size(max = 100)
    private String email;

    @Column(name="password",nullable = false)
    @Size(max = 200)
    private String password;

    @OneToMany (mappedBy = "user",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<CommentEntity> comments;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL, orphanRemoval=true)
    @JoinColumn(name="id_adress")
    private AdressEntity address;

    public UserEntity() {
    }

    public UserEntity(String name, String surname, String email, String password) {

        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.comments = new ArrayList<>();

    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setComments(List<CommentEntity> comments) {
        this.comments = comments;
    }
    public void setAddress(AdressEntity address) {
        this.address = address;
    }

    public int getIdUser() {
        return idUser;
    }
    public String getSurname() {
        return surname;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public List<CommentEntity> getComments() {
        return comments;
    }
    public AdressEntity getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return idUser == that.idUser && name.equals(that.name) && surname.equals(that.surname) && email.equals(that.email) &&
                password.equals(that.password) && address.equals(that.address) && Objects.equals(comments, that.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser, name, surname, email, password, address, comments);
    }
}
