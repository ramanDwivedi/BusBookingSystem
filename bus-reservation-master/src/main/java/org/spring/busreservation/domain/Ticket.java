package org.spring.busreservation.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Ticket {
    @Id
    @TableGenerator(name="TABLE_GENERATOR", table="PRIMARY_KEY_SEQUENCES", pkColumnName="SEQUENCE_NAME", 
    valueColumnName="SEQUENCE_COUNT",pkColumnValue="AFFILIATE_COURSE_SEQ", allocationSize=1)
    
    @GeneratedValue(strategy = GenerationType.TABLE, generator="TABLE_GENERATOR")    
    private Long t_id;
    @NotEmpty
    private String ticketNumber;
    @ManyToOne(targetEntity=Connection.class,
    cascade = CascadeType.ALL,
    fetch=FetchType.EAGER)
    @JoinColumn(name="TICKET_CONNECTION", referencedColumnName="ca_id")
    private Connection connection;
    @NotNull
    private BigDecimal price;
    @NotNull
    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private Date reservationDate;
    @ManyToOne(targetEntity=User.class,
    	    cascade = CascadeType.ALL,
    	    fetch=FetchType.EAGER)
    	    @JoinColumn(name="TICKET_USER", referencedColumnName="u_id")
    private User user;
    @OneToOne(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinTable(name="TICKET_INVOICE", joinColumns = @JoinColumn(name="ticket_id"),
    inverseJoinColumns = @JoinColumn(name="invoice_id"))   
    private Invoice invoice;
   public Long getT_id() {
		return t_id;
	}

	public void setT_id(Long t_id) {
		this.t_id = t_id;
	}

	public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
}
