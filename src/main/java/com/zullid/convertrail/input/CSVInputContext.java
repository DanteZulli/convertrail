package com.zullid.convertrail.input;

import java.io.File;

public class CSVInputContext {
    
    private CSVInputStrategy strategy;

    public CSVInputContext(CSVInputStrategy strategy) {
        this.strategy = strategy;
    }

    public File getCSV() {
        return strategy.readCSV();
    }
}