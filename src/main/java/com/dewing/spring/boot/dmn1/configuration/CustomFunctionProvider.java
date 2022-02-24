package com.dewing.spring.boot.dmn1.configuration;

import org.camunda.bpm.dmn.feel.impl.scala.function.CustomFunction;
import org.camunda.bpm.dmn.feel.impl.scala.function.FeelCustomFunctionProvider;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CustomFunctionProvider implements FeelCustomFunctionProvider {

    protected Map<String, CustomFunction> functions = new HashMap<>();

    public CustomFunctionProvider() {
        functions.put("myFunction", myFunction());
        // TODO: Add more functions.
    }

    @Override
    public Optional<CustomFunction> resolveFunction(String functionName) {
        return Optional.ofNullable(functions.get(functionName));
    }

    @Override
    public Collection<String> getFunctionNames() {
        return functions.keySet();
    }

    private CustomFunction myFunction() {
        return CustomFunction.create()
                .setParams("x", "y")
                .setFunction(args -> {
                    long argX = (long) args.get(0);
                    long argY = (long) args.get(1);

                    return argX + argY;
                })
                .build();
    }

}
