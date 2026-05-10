package com.nt.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Table(name="BANK_ACCOUNT")
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class BankAccount {
	@Id
	@SequenceGenerator(name="gen1",sequenceName = "ACCNO_SEQ",initialValue = 100000, allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
 	private long accNo;
	
	@Column(length = 20)
	@NonNull
	private String HolderName;
	
	@NonNull
	private Double balance;
	
	@NonNull
	@Column(length = 20)
	private String bankName;
	
	@NonNull
	@Column(length = 10)
	private String accountType;
	
	//for Versioning
	
	@Version
	private Integer updateCount;
	
	//for timestamp
	
	@CreationTimestamp
	@Column(insertable = true)
	private LocalDateTime openedDate;
	
	@UpdateTimestamp
	@Column(insertable = false)
	private LocalDateTime lastlyUpdatedOn;
	

}
