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
    		
    		System.out.println("Employee Created Successfully");
    		Employee findEmp  = em.find(Employee.class, employee.getId());
    		System.out.println("Employee Details:");
    		System.out.println("Id: " + findEmp.getId());
    		System.out.println("Name: " + findEmp.getName());
    		System.out.println("Email: " + findEmp.getEmail());
    		
    		IDCard findIdcard = em.find(IDCard.class, idcard.getId());
    		System.out.println("ID Card Details: ");
    		System.out.println("Card Number: " + findIdcard.getCardNumber());
    		System.out.println("Issue Date: " + findIdcard.getIssueDate());
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    		e.printStackTrace();
    	}finally {
    		em.close();
    		emf.close();
    	}
    }
}
