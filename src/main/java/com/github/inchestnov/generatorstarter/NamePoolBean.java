package com.github.inchestnov.generatorstarter;

import com.github.inchestnov.generatorstarter.utils.CommonRandom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NamePoolBean implements NamePool {

    private com.github.inchestnov.generatorstarter.MaleNamePool maleNamePool;
    private com.github.inchestnov.generatorstarter.FemaleNamePool femaleNamePool;
    private com.github.inchestnov.generatorstarter.SurnamePool surnamePool;

    @Autowired
    public NamePoolBean(com.github.inchestnov.generatorstarter.MaleNamePool maleNamePool, com.github.inchestnov.generatorstarter.FemaleNamePool femaleNamePool, com.github.inchestnov.generatorstarter.SurnamePool surnamePool) {
        this.maleNamePool = maleNamePool;
        this.femaleNamePool = femaleNamePool;
        this.surnamePool = surnamePool;
    }

    @Override
    public String getRandomName() {
        return CommonRandom.getRandomBoolean() ? maleNamePool.getRandomMaleName()
                : femaleNamePool.getRandomFemaleName();
    }

    @Override
    public String getRandomSurname() {
        return surnamePool.getRandomSurname();
    }

}
