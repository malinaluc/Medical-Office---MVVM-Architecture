package org.example.model.repository;

import org.example.model.entity.Consultation;
import org.example.model.entity.MedicalRecord;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

import static org.example.utils.ExtensionFunctions.logDebug;

public class ConsultationRepository extends AbstractRepository<Consultation> {

    public List<Consultation> allConsultationsByMedicId(Integer medicID){
        try (var session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Consultation> cq = cb.createQuery(Consultation.class);
            Root<Consultation> root = cq.from(Consultation.class);

            // Specify the selection criteria
            cq.select(root).where(cb.equal(root.get("idMedic"), medicID));

            Query<Consultation> query = session.createQuery(cq);
            return query.getResultList();
        } catch (Exception e) {
            logDebug("---allConsultationsByMedicId--- " + e);
            return null;
        }
    }
}
