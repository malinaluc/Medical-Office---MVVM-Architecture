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
public class MedicalRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idfisaMedicala;

    private String patientName;
    private String symptoms;
    private String treatment;
    private String diagnostic;
    private Integer patientAge;

    //fk to Medic
    @ManyToOne
    @JoinColumn(name = "idMedic", referencedColumnName = "idMedic")
    private Medic idMedic;
    //fk to User

    @ManyToOne
    @JoinColumn(name = "idAsistent", referencedColumnName = "idUser")
    private User idAsistent;


}
