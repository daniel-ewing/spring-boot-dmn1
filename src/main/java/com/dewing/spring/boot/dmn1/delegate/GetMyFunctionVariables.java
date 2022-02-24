package com.dewing.spring.boot.dmn1.delegate;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class GetMyFunctionVariables implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        if (log.isDebugEnabled()) log.debug("-----> execute: Enter");

        Map<String, Object> variables = delegateExecution.getVariables();
        Object x = delegateExecution.getVariable("x");
        Object y = delegateExecution.getVariable("y");
        Object z = delegateExecution.getVariable("z");

        if (log.isDebugEnabled()) log.debug("x: {}, y: {}, z: {}", x, y, z);

        if (log.isDebugEnabled()) log.debug("-----> execute: Exit");
    }
}
