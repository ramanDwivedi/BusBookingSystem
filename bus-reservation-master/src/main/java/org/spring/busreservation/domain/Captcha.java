package org.spring.busreservation.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.util.Date;

@Entity
public class Captcha {
    @Id
    @TableGenerator(name="TABLE_GENERATOR", table="PRIMARY_KEY_SEQUENCES", pkColumnName="SEQUENCE_NAME", 
    valueColumnName="SEQUENCE_COUNT",pkColumnValue="AFFILIATE_COURSE_SEQ", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator="TABLE_GENERATOR")
    private Long ca_id;
    
	private String captcha;
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name="createdate")
    private Date createDate;
	public Long getCa_id() {
		return ca_id;
	}
	public void setCa_id(Long ca_id) {
		this.ca_id = ca_id;
	}

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
