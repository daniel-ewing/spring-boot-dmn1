package com.dewing.spring.boot.dmn1.configuration;

import org.camunda.bpm.dmn.feel.impl.scala.function.FeelCustomFunctionProvider;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.camunda.bpm.engine.impl.cfg.ProcessEnginePlugin;
import org.camunda.bpm.spring.boot.starter.configuration.Ordering;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Order(Ordering.DEFAULT_ORDER + 1)
public class DmnConfigurator implements ProcessEnginePlugin {
    @Override
    public void preInit(ProcessEngineConfigurationImpl processEngineConfiguration) {
        synchronized (DmnConfigurator.class) {
            List<FeelCustomFunctionProvider> feelCustomFunctionProviders = processEngineConfiguration.getDmnFeelCustomFunctionProviders();
            if (feelCustomFunctionProviders == null) {
                feelCustomFunctionProviders = new ArrayList<>();
            }
            feelCustomFunctionProviders.add(new CustomFunctionProvider());
            processEngineConfiguration.setDmnFeelCustomFunctionProviders(feelCustomFunctionProviders);
        }
    }

    @Override
    public void postInit(ProcessEngineConfigurationImpl processEngineConfiguration) {

    }

    @Override
    public void postProcessEngineBuild(ProcessEngine processEngine) {

    }
}
