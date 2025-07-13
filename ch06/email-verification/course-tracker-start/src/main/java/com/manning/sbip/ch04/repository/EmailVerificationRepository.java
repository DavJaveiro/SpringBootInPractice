package com.manning.sbip.ch04.repository;

import com.manning.sbip.ch04.model.EmailVerification;
import org.springframework.data.repository.CrudRepository;

public interface EmailVerificationRepository extends CrudRepository<EmailVerification, String> {
    EmailVerification findByUsername(String userName);
    boolean existsByUsername(String userName);

    String username(String username);
}
