package model.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import model.address.Address;

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
 	@ElementCollection//(fetch=FetchType.EAGER)Eager jarri ezkero bajatzeko orduan dana gordetzen dau, ez bakarrik lehenengo kapia
 	@JoinTable(name="user_addresses", //Honek sortuko daben taulian izena finkatzen dau
 				joinColumns= @JoinColumn(name="user_id")) //Honek foreign keyxan izena finkatzen dau
 	@GenericGenerator(name="sequence", strategy="sequence")
 
 	@CollectionId(columns = { @Column(name="ADDRESS_ID") }, generator = "sequence", type = @Type(type="long"))
	private Collection<Address> listOfAddresses = new ArrayList<Address>();
	private String description; 
	
	
	
	
	public Date getJoinedDate() {
		return joinedDate;
	}
	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}

	public Collection<Address> getListOfAddresses() {
		return listOfAddresses;
	}
	public void setListOfAddresses(Collection<Address> listOfAddresses) {
		this.listOfAddresses = listOfAddresses;
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
