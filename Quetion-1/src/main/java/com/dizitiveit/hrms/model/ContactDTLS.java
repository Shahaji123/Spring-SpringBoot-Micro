package com.dizitiveit.hrms.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class ContactDTLS {

	@Id
	@GeneratedValue
	private Integer contactId;
	private String contactName;
	private Long contactNumber;
	private String contactEmail;
//	@CreationTimestamp
//	@Temporal(TemporalType.DATE)
//	private Date createdDate;
//	@UpdateTimestamp
//	@Temporal(TemporalType.DATE)
//	private Date updatedDate;
//
//	public ContactDTLS(){
//		
//	}
}
