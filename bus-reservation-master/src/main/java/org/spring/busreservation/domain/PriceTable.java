package org.spring.busreservation.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;
import javax.validation.constraints.Min;
import java.math.BigDecimal;

@Entity(name="pricetable")
public class PriceTable {
    @Id
    @TableGenerator(name="TABLE_GENERATOR", table="PRIMARY_KEY_SEQUENCES", pkColumnName="SEQUENCE_NAME", 
    valueColumnName="SEQUENCE_COUNT",pkColumnValue="AFFILIATE_COURSE_SEQ", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator="TABLE_GENERATOR")
    private Long p_id;
    @Min(0)
    @Column(name="priceperkilometer")
    private BigDecimal pricePerKilometer;
    @Min(0)
    @Column(name="taxpercent")
    private BigDecimal taxPercent;

    public Long getP_id() {
		return p_id;
	}

	public void setP_id(Long p_id) {
		this.p_id = p_id;
	}

	public BigDecimal getPricePerKilometer() {
        return pricePerKilometer;
    }

    public void setPricePerKilometer(BigDecimal pricePerKilometer) {
        this.pricePerKilometer = pricePerKilometer;
    }

    public BigDecimal getTaxPercent() {
        return taxPercent;
    }

    public void setTaxPercent(BigDecimal taxPercent) {
        this.taxPercent = taxPercent;
    }
}
