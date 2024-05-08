package org.example.model.repository;

import org.example.model.entity.Medic;

public class MedicRepository extends AbstractRepository<Medic> {
    public Medic findMedicByID(Integer Id) {
        return findById(Id);
    }
}
