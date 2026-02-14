package assessment1_PS1;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ){
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
    	EntityManager em = emf.createEntityManager();
    	
    	try {
    		em.getTransaction().begin();
    		IDCard idcard = new IDCard(101,"24-09-2025");
    		Employee employee = new Employee("sohail","sohail.rcom6@gmail.com",idcard);
    		em.persist(employee);
    		idcard.setEmployee(employee);
    		em.getTransaction().commit();
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    		e.printStackTrace();
    	}finally {
    		em.close();
    		emf.close();
    	}
    }
}
