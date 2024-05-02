package org.example.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Medic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMedic;

    private String name;
    private String surname;

    //fk to User
    @ManyToOne
    @JoinColumn(name = "idUser", referencedColumnName = "idUser")
    private User idUser;

    private Integer startTimeProgram;
    private Integer endTimeProgram;

}
