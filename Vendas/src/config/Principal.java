package config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import config.*;
import model.*;
public class Principal {

	public static void main(String[] args) {
	    
Funcionario cont = new Funcionario();

      cont.setId(1);
      Session session = HibernateUtil.getSession();
		Transaction trx = session.beginTransaction();
		
		session.delete(cont);
		
		trx.commit();
		session.close();
         
	}
	

}

