package com.ozalp.portfolio.aop;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.hibernate.Session;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
public class HibernateFilterAspect {

    private final EntityManager entityManager;

    @Before("execution(* com.ozalp.portfolio.business.managers.*.*(..))")
    public void activateFilters() {
        Session session = entityManager.unwrap(Session.class);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        boolean isAdmin = auth != null && auth.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ADMIN"));

        if (isAdmin) {
            session.disableFilter("showableFilter");
        } else {
            session.enableFilter("showableFilter");
        }
    }
}