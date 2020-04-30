package com.test.Kadmin.entities;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OngoingTransactions {
    @Id
    @GeneratedValue
    private Long id;
    private String identityCardNumber;
    private String oneTimeCode;

}
