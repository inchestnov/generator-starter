package com.github.inchestnov.generatorstarter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeneratorStarterConfiguration {

    @Bean
    public Generator generator() {
        return new GeneratorBean();
    }

    @Bean
    public MaleNamePool maleNamePool() {
        return new MaleNamePoolBean();
    }

    @Bean
    public FemaleNamePool femaleNamePool() {
        return new FemaleNamePoolBean();
    }

    @Bean
    public SurnamePool surnamePool() {
        return new SurnamePoolBean();
    }

    @Bean
    public NamePool namePool() {
        return new NamePoolBean(maleNamePool(), femaleNamePool(), surnamePool());
    }

    @Bean
    public CityPool cityPool() {
        return new CityPoolBean();
    }

    @Bean
    public AgePool agePool() {
        return new AgePoolBean();
    }

}
