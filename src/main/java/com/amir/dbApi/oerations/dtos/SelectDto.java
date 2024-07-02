package com.amir.dbApi.oerations.dtos;

import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.Map;

public class SelectDto {

    @NotNull(message = "You must specify at least one column.")
    private List<String> cols;

    private Map<String, Object> where;

    public SelectDto() {}

    public SelectDto(List<String> cols, Map<String, Object> where) {
        this.cols = cols;
        this.where = where;
    }

    public List<String> getCols() {
        return cols;
    }

    public void setCols(List<String> cols) {
        this.cols = cols;
    }

    public Map<String, Object> getWhere() {
        return where;
    }

    public void setWhere(Map<String, Object> where) {
        this.where = where;
    }

    @Override
    public String toString() {
        return "SelectDto{" +
                "cols=" + cols +
                ", where=" + where +
                '}';
    }
}
