package com.kodilla.patterns2.facade.api;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class OrderFacadeLoggingAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderFacadeLoggingAspect.class);

    @Before("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))")
    public void logBeforeProcessOrder() {
        LOGGER.info("Logging before processOrder() method call in OrderFacade");
    }
}