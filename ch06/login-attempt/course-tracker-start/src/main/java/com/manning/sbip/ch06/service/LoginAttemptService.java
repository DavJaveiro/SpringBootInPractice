package com.manning.sbip.ch06.service;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Service
public class LoginAttemptService {

    private static final int MAX_ATTEMPTS_COUNT = 3;

    // In this cache, the String type represents a username,
    // and the Integer type represents the failed login attempts
    private LoadingCache<String, Integer> loginAttemptCache;

    // Creates the cache and expires the cache contents after one day
    public LoginAttemptService() {
        loginAttemptCache = CacheBuilder.newBuilder().expireAfterWrite(1, TimeUnit.DAYS)
                .build(new CacheLoader<String, Integer>() {
                    @Override
                    public Integer load(final String key) {
                        return 0;
                    }
                });
    }


    // remove/limpa as tentativas de login do cache
    public void loginSucess(String username) {
        loginAttemptCache.invalidate(username);
    }

    // Increments the failed login attempt counter for the specified username
    public void loginFailed(String username) {
        int failedAttemptCounter = 0;

        try {
            failedAttemptCounter = loginAttemptCache.get(username);
        } catch (ExecutionException e) {
            failedAttemptCounter = 0; // se o usuário não tiver no cache, assume 0 para ele
        }
        failedAttemptCounter++;
        loginAttemptCache.put(username, failedAttemptCounter);
    }


    public boolean isBlocked(String username) {
        try {
            return loginAttemptCache.get(username) >= MAX_ATTEMPTS_COUNT;
        }
        catch (ExecutionException e) {
            return false;
        }
    }
}
