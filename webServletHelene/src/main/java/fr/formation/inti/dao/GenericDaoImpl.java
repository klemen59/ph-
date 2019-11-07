package fr.formation.inti.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import fr.formation.inti.entities.Patient;
import fr.formation.inti.utils.ConnectionUtils;
import fr.formation.inti.utils.Constants;



/**
 * Notre classe EmployeeDaoImpl suit le modèle de conception Singleton qui
 * garantit qu'une seule instance de cette classe sera créée dans l'application.
 * Lors de la première création de classe, la méthode getEntityManager () est
 * chargée de créer une instance de EntityManager.
 * 
 * @author 
 * @param <T>
 * @param <I>
 *
 */
public class GenericDaoImpl<T, I extends Serializable> implements IGenericDao<T, I> {
	private Session currentSession;
	private Transaction currentTransaction;
	
	private Class clazz; 
	
	
	
	public Class getClazz() {
		return clazz;
	}

	public void setClazz(Class clazz) {
		this.clazz = clazz;
	}

	public Session openCurrentSession() {
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }
 
    public Session openCurrentSessionwithTransaction() {
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }
     
    public void closeCurrentSession() {
        currentSession.close();
    }
     
    public void closeCurrentSessionwithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }
    private static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        return sessionFactory;
    }
 
    public Session getCurrentSession() {
        return currentSession;
    }
 
    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }
 
    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }
 
    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }

	public List<T> getAll() {
		Query q = getCurrentSession().createQuery("FROM " + clazz.getName());		
		List<T> employees = q.list();
		return employees;
	}
	
	
	public void persist(T e) {
		getCurrentSession().persist(e);
	}

	public I save(T e) {
		
		return (I) getCurrentSession().save(e);
	}

	public void update(T e) {
		getCurrentSession().update(e);
	}

	public void delete(T e) {
		getCurrentSession().delete(e);
	}

	public T findById(I id) {
		T emp = (T) getCurrentSession().get(clazz.getName(), id);
		return emp;
	} 
	

	public void deleteByID(I id) {
		try {
			T e = findById(id);
			delete(e);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void close() {
		getSessionFactory().close();
	}

}
