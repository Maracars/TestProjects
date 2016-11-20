package model.UserDetails;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity//(name="USER_DETAILS") Entitatian izena, default klasian izena
@Table (name="USER_DETAILS") //Tablian izena

public class UserDetails {
	@Id @GeneratedValue// PK zein izan bihar dan esan, generatedvaluekin berak sortzen dau baloria
	@Column(name="USER_ID") // Honek ez dia derrigorrak, izena aldatu nahi bada bakarrik
	//Anotazinuak hemen edo getterretan jarri leizke.
	private Integer userId;
	private String username;
	// @Temporal(TemporalType.DATE edo TemporalType.TIME) 
	//Berez timestamp moduan gordeko dau, time, date edo timestamp aukeratu leike
 	private Date joinedDate;
	private String address;
	private String description; 
	
	
	
	
	public Date getJoinedDate() {
		return joinedDate;
	}
	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Transient

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	@Column(name="USER_NAME")
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	

}
