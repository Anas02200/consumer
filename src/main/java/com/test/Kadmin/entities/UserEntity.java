package com.test.Kadmin.entities;



import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserEntity {
	@Id
	@GeneratedValue
	private Long Id;

	private String name;
	@Column(unique = true)
	private String identityCardNumber;
	private String cardNumber;
	@Column(unique = true)
	private String token;

}
