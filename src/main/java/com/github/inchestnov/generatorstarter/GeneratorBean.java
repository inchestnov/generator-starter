package com.github.inchestnov.generatorstarter;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import static com.github.inchestnov.generatorstarter.utils.Preconditions.checkNotNull;

@Component
public class GeneratorBean implements Generator {

    private final ApplicationContext applicationContext;

    public GeneratorBean(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public <T> T generate(Class<T> instanceClass) {
        checkNotNull(instanceClass, "Class cannot be null");

        Generated annotation = instanceClass.getAnnotation(Generated.class);
        if (annotation == null)
            throw new IllegalArgumentException("Class " + instanceClass.getSimpleName() + " not allow generating");

        Class<? extends Factory<?>> instanceFactory = annotation.factory();
        Factory<?> factoryImpl = SpringContext.getBean(instanceFactory);

        return (T) factoryImpl.create();
    }

}
