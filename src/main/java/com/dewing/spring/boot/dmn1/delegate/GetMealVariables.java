package com.dewing.spring.boot.dmn1.delegate;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class GetMealVariables implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        if (log.isDebugEnabled()) log.debug("-----> execute: Enter");

        Map<String, Object> variables = delegateExecution.getVariables();
        Object age = variables.get("ageOfGuest");
        Object time = variables.get("timeOfDay");
        Object hunger = variables.get("hunger");
        HashMap<String, Object> mealResult = (HashMap<String, Object>)variables.get("mealResult");
        Object beverage = mealResult.get("beverage");
        Object food = mealResult.get("food");
        Object salad = mealResult.get("salad");

        if (log.isDebugEnabled()) log.debug("age: {}, time: {}, hunger: {}, beverage: {}, food: {}, salad: {}",
                (Integer)age, (Integer)time, (Integer)hunger, (String)beverage, (String)food, (Boolean)salad);

        if (log.isDebugEnabled()) log.debug("-----> execute: Exit");
    }
}
