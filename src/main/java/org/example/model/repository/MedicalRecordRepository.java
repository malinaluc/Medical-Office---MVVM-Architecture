package org.example.model.repository;

import org.example.model.entity.MedicalRecord;
import org.example.model.entity.Medic;
import org.example.model.entity.User;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.List;

import static org.example.utils.ExtensionFunctions.logDebug;


public class MedicalRecordRepository extends AbstractRepository<MedicalRecord> {

    public List<MedicalRecord> allMedicalRecordByMedicUserId(Integer userId) {
        try (var session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<MedicalRecord> cq = cb.createQuery(MedicalRecord.class);
            Root<MedicalRecord> root = cq.from(MedicalRecord.class);

            // Joining medic table
            Join<MedicalRecord, Medic> medicJoin = root.join("idMedic");

            // Joining user table through medic table
            Join<Medic, User> userJoin = medicJoin.join("idUser");

            // Specify the selection criteria
            cq.select(root).where(cb.equal(userJoin.get("idUser"), userId));

            Query<MedicalRecord> query = session.createQuery(cq);
            return query.getResultList();
        } catch (Exception e) {
            logDebug("---allMedicalRecordByMedicUserId--- " + e);
            return null;
        }
    }

    public List<MedicalRecord> allMedicalRecordByUserId(Integer userId) {
        try (var session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<MedicalRecord> cq = cb.createQuery(MedicalRecord.class);
            Root<MedicalRecord> root = cq.from(MedicalRecord.class);

            // Specify the selection criteria
            cq.select(root).where(cb.equal(root.get("idAsistent"), userId));

            Query<MedicalRecord> query = session.createQuery(cq);
            return query.getResultList();
        } catch (Exception e) {
            logDebug("---allMedicalRecordByUserId--- " + e);
            return null;
        }
    }

    public List<MedicalRecord> allMedicalRecordByMedicID(Integer userId) {
        try (var session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<MedicalRecord> cq = cb.createQuery(MedicalRecord.class);
            Root<MedicalRecord> root = cq.from(MedicalRecord.class);

            // Specify the selection criteria
            cq.select(root).where(cb.equal(root.get("idMedic"), userId));

            Query<MedicalRecord> query = session.createQuery(cq);
            return query.getResultList();
        } catch (Exception e) {
            logDebug("---allMedicalRecordByMedicID--- " + e);
            return null;
        }
    }

    public void updateFisa(MedicalRecord MedicalRecord) {
        update(MedicalRecord);
    }

    public List<MedicalRecord> allMedicalRecordByDiagnostic(String diagnostic) {
        try (var session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<MedicalRecord> cq = cb.createQuery(MedicalRecord.class);
            Root<MedicalRecord> root = cq.from(MedicalRecord.class);

            // Specify the selection criteria
            cq.select(root).where(cb.equal(root.get("diagnostic"), diagnostic));

            Query<MedicalRecord> query = session.createQuery(cq);
            return query.getResultList();
        } catch (Exception e) {
            logDebug("---allMedicalRecordByDiagnostic--- " + e);
            return null;
        }
    }

    public List<MedicalRecord> allMedicalRecordByTratament(String tratament) {
        try (var session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<MedicalRecord> cq = cb.createQuery(MedicalRecord.class);
            Root<MedicalRecord> root = cq.from(MedicalRecord.class);

            // Specify the selection criteria
            cq.select(root).where(cb.equal(root.get("treatment"), tratament));

            Query<MedicalRecord> query = session.createQuery(cq);
            return query.getResultList();
        } catch (Exception e) {
            logDebug("---allMedicalRecordByTratament--- " + e);
            return null;
        }
    }

    public List<MedicalRecord> allMedicalRecordByPatientName(String name){
        try (var session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<MedicalRecord> cq = cb.createQuery(MedicalRecord.class);
            Root<MedicalRecord> root = cq.from(MedicalRecord.class);

            // Specify the selection criteria
            cq.select(root).where(cb.equal(root.get("patientName"), name));

            Query<MedicalRecord> query = session.createQuery(cq);
            return query.getResultList();
        } catch (Exception e) {
            logDebug("---allMedicalRecordByTratament--- " + e);
            return null;
        }
    }

    public List<MedicalRecord> allMedicalRecordByVarsta(Integer varsta) {
        try (var session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<MedicalRecord> cq = cb.createQuery(MedicalRecord.class);
            Root<MedicalRecord> root = cq.from(MedicalRecord.class);

            // Specify the selection criteria
            cq.select(root).where(cb.equal(root.get("patientAge"), varsta));

            Query<MedicalRecord> query = session.createQuery(cq);
            return query.getResultList();
        } catch (Exception e) {
            logDebug("---allMedicalRecordByVarstaa-- " + e);
            return null;
        }
    }
}
