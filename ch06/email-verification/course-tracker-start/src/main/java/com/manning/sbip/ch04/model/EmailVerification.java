package com.manning.sbip.ch04.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "CT_EMAIL_VERIFICATIONS")
@NoArgsConstructor
public class EmailVerification {
    @Id
    @GeneratedValue(generator = "UUID_GENERATOR")
    @GenericGenerator(name = "UUID_GENERATOR", strategy = "org.hibernate.id.UUIDGenerator")
    private String verificationId;
    private String username;

    public EmailVerification(String username) {
        this.username = username;
    }
}
