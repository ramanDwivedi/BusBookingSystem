package org.spring.busreservation.domain;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "users")
@JsonIgnoreProperties({"tickets"})
public class User implements Serializable {
    @Id
    @TableGenerator(name="TABLE_GENERATOR", table="PRIMARY_KEY_SEQUENCES", pkColumnName="SEQUENCE_NAME", 
    valueColumnName="SEQUENCE_COUNT",pkColumnValue="AFFILIATE_COURSE_SEQ", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator="TABLE_GENERATOR")    
    private Long u_id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;
    private String firstname;
    private String lastname;
    @Column(name="PHONENUMBER")
    private String phoneNumber;

    @ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinTable(name="ROLE_USER", joinColumns = @JoinColumn(name="user_id"),
    inverseJoinColumns = @JoinColumn(name="role_id"))
    private List<Role> roles;
    @Column(name="ACTIVATIONHASH")
    private String activationHash;
    @OneToMany(targetEntity=Ticket.class,
    	    cascade = CascadeType.ALL,
    	    fetch=FetchType.LAZY,
    	    orphanRemoval=true)
    private List<Ticket> tickets;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getU_id() {
		return u_id;
	}

	public void setU_id(Long u_id) {
		this.u_id = u_id;
	}

	public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getActivationHash() {
        return activationHash;
    }

    public void setActivationHash(String activationHash) {
        this.activationHash = activationHash;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
