package com.github.inchestnov.generatorstarter;

import com.github.inchestnov.generatorstarter.utils.CommonRandom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NamePoolBean implements NamePool {

    private MaleNamePool maleNamePool;
    private FemaleNamePool femaleNamePool;
    private SurnamePool surnamePool;

    @Autowired
    public NamePoolBean(MaleNamePool maleNamePool, FemaleNamePool femaleNamePool, SurnamePool surnamePool) {
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
