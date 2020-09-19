package org.spring.busreservation.domain;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
public class Invoice {
    @Id
    @TableGenerator(name="TABLE_GENERATOR", table="PRIMARY_KEY_SEQUENCES", pkColumnName="SEQUENCE_NAME", 
    valueColumnName="SEQUENCE_COUNT",pkColumnValue="AFFILIATE_COURSE_SEQ", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator="TABLE_GENERATOR")
    private Long i_id;
    @NotNull
    private BigDecimal priceGross;
    @Min(0)
    private BigDecimal taxPercent;
    @OneToOne(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinTable(name="TICKET_INVOICE", joinColumns = @JoinColumn(name="invoice_id"),
    inverseJoinColumns = @JoinColumn(name="ticket_id"))  
    private Ticket ticket;

    public Long getI_id() {
		return i_id;
	}

	public void setI_id(Long i_id) {
		this.i_id = i_id;
	}


    public BigDecimal getPriceGross() {
        return priceGross;
    }

    public void setPriceGross(BigDecimal priceGross) {
        this.priceGross = priceGross;
    }

    public BigDecimal getTaxPercent() {
        return taxPercent;
    }

    public void setTaxPercent(BigDecimal taxPercent) {
        this.taxPercent = taxPercent;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
