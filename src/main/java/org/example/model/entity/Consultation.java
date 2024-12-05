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
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idConsultation;

    private Integer startConsultationHour;
    private Integer endConsultationHour;
    private String namePatient;

    /*   ///fk to MedicalRecord
       @ManyToOne
       @JoinColumn(name = "idfisaMedicala", referencedColumnName = "idfisaMedicala")
       private MedicalRecord idMedicalRecord;
   */


    //fk to Medic
    @ManyToOne
    @JoinColumn(name = "idMedic", referencedColumnName = "idMedic")
    private Medic idMedic;


}
