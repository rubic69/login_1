package lt.affecto.login.model;

// default package
// Generated Jul 23, 2014 2:52:01 PM by Hibernate Tools 3.6.0

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import lt.affecto.login.util.HibernateUtil;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/** 
 * Home object for domain model class User.
 * @see .User
 * @author Hibernate Tools
 */

public class UserHome {

	private static final Logger log = Logger.getLogger(UserHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public boolean exist(String name, String pass) {
		log.debug("Starting exist() metod");
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            log.debug("Created session");
            Transaction trans = session.beginTransaction();
            log.debug("beg intransaction");
            Query query = session.createQuery("SELECT u FROM User u where u.name = :name AND u.pass = :pass");
            log.debug("SELECT is working");
            query.setParameter("name", name);
            query.setParameter("pass", pass);
            log.debug("gavo varda ir pw");
            List<?> list = query.list();
            if (!list.isEmpty()) {
            	log.debug("Saraso dydis" + list.size());
            	return true;
            }
            trans.commit();
            log.debug("persist successful");
        } catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
		return false;
    }
	
	/*public void persist(User transientInstance) {
		log.debug("persisting User instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}*/

	/*public void remove(User persistentInstance) {
		log.debug("removing User instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}*/

	/*public User merge(User detachedInstance) {
		log.debug("merging User instance");
		try {
			User result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}*/

	/*public User findById(Integer id) {
		log.debug("getting User instance with id: " + id);
		try {
			User instance = entityManager.find(User.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}*/
}
