package assessment1_PS1;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "idcard")
public class IDCard {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int cardNumber;
	private String issueDate;
	@OneToOne(mappedBy = "idcard")
	private Employee employee;
	public IDCard() {
		super();
	}
	public IDCard(int cardNumber, String issueDate) {
		super();
		this.cardNumber = cardNumber;
		this.issueDate = issueDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	@Override
	public String toString() {
		return "IDCard [id=" + id + ", cardNumber=" + cardNumber + ", issueDate=" + issueDate + ", employee=" + employee
				+ "]";
	}
	
}
