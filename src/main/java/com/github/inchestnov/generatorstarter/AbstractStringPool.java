package com.github.inchestnov.generatorstarter;

import com.github.inchestnov.generatorstarter.utils.CommonRandom;
import org.springframework.core.io.Resource;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.github.inchestnov.generatorstarter.utils.Preconditions.checkNotNull;

public abstract class AbstractStringPool {

    protected List<String> strings;

    @PostConstruct
    private void init() {
        Resource resource = getResource();
        checkNotNull(resource, "Resource is null");

        if (!resource.exists())
            throw new RuntimeException("Resource " + resource.getFilename() + " does not exists");

        try {
            BufferedReader bufferedReader
                    = new BufferedReader(new InputStreamReader(resource.getInputStream()));

            String line = bufferedReader.readLine();
            strings = new ArrayList<>(Arrays.asList(line.split(",")));
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    protected abstract Resource getResource();

    protected String getRandomValue() {
        return CommonRandom.getRandomValue(strings);
    }

}
