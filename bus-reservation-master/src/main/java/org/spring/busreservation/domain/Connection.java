package org.spring.busreservation.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@JsonIgnoreProperties({"tickets"})
public class Connection {
    @Id
    @TableGenerator(name="TABLE_GENERATOR", table="PRIMARY_KEY_SEQUENCES", pkColumnName="SEQUENCE_NAME", 
    valueColumnName="SEQUENCE_COUNT",pkColumnValue="AFFILIATE_COURSE_SEQ", allocationSize=1)
    
    @GeneratedValue(strategy = GenerationType.TABLE, generator="TABLE_GENERATOR")
    @Column(name="ca_id")
    private Long c_id;
    @NotNull
    private String startPlace;
    @NotNull
    private String endPlace;
    @Min(0)
    private double distance;
    @NotNull
    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private Date departureDate;
    @NotNull
    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private Date arrivalDate;
    @Min(0)
    private int places; 
    @OneToMany(targetEntity=Ticket.class,
    cascade = CascadeType.ALL,
    fetch=FetchType.LAZY,
    orphanRemoval=true)
    @JoinColumn(name="TICKET_CONNECTION", referencedColumnName="ca_id")
    private List<Ticket> tickets;

    

    public Long getC_id() {
		return c_id;
	}

	public void setC_id(Long c_id) {
		this.c_id = c_id;
	}

	public String getStartPlace() {
        return startPlace;
    }

    public void setStartPlace(String startPlace) {
        this.startPlace = startPlace;
    }

    public String getEndPlace() {
        return endPlace;
    }

    public void setEndPlace(String endPlace) {
        this.endPlace = endPlace;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public int getPlaces() {
        return places;
    }

    public void setPlaces(int places) {
        this.places = places;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
