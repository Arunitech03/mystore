package mystore.product.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name="storeusers")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String username;

    @Column
    @JsonIgnore
    private String password;

    @Column
    private long salary;

    @Column
    private int age;

}
