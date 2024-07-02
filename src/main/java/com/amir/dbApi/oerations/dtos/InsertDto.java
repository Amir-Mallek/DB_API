package com.amir.dbApi.oerations.dtos;

import java.util.List;
import java.util.Map;

public class InsertDto {
    private List<String> cols;
    private List<Map<String, Object>> values;
    private Map<String, Object> where;

    public InsertDto() {}

    public InsertDto(List<String> cols, List<Map<String, Object>> values, Map<String, Object> where) {
        this.cols = cols;
        this.values = values;
        this.where = where;
    }

    public List<String> getCols() {
        return cols;
    }

    public void setCols(List<String> cols) {
        this.cols = cols;
    }

    public List<Map<String, Object>> getValues() {
        return values;
    }

    public void setValues(List<Map<String, Object>> values) {
        this.values = values;
    }

    public Map<String, Object> getWhere() {
        return where;
    }

    public void setWhere(Map<String, Object> where) {
        this.where = where;
    }

    @Override
    public String toString() {
        return "InsertDto{" +
                "cols=" + cols +
                ", values=" + values +
                ", where=" + where +
                '}';
    }
}
