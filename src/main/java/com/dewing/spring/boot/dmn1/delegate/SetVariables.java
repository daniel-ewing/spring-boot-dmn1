package com.dewing.spring.boot.dmn1.delegate;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Slf4j
public class SetVariables implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        if (log.isDebugEnabled()) log.debug("-----> execute: Enter");

        Map<String, Object> variables = delegateExecution.getVariables();

        variables = setVarRandomValue(variables,"timeOfDay", (int)Math.floor((Math.random() * 24)));

        delegateExecution.setVariables(variables);

        if (log.isDebugEnabled()) log.debug("-----> execute: Exit");
    }

    private Map<String, Object> setVarRandomValue(Map<String, Object> variables, String varName, int varValue) {
        Object var = variables.get(varName);
        if (var == null || ((String) var).equals("")) {
            variables.put(varName, varValue);
        }

        return variables;
    }
}