package org.example.model.repository;

import org.example.model.entity.User;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import static org.example.utils.ExtensionFunctions.logDebug;

public class UserRepository extends AbstractRepository<User> {

    public User getUserByEmailAndPassword(String username, String password) {


        try (var session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<User> cq = cb.createQuery(User.class);
            Root<User> root = cq.from(User.class);
            cq.select(root).where(cb.equal(root.get("username"), username));
            TypedQuery<User> query = session.createQuery(cq);
            return query.getSingleResult();
        } catch (Exception e) {
            logDebug("---getUserByEmailAndPassword--- " + e);
        }
        return null;
    }

    public User findByID(Integer userID) {
        return findById(userID);
    }


}
