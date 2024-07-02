package com.amir.dbApi.oerations.dtos;

import java.util.Map;

public class DeleteDto {
    private Map<String, Object> where;

    public DeleteDto() {}

    public DeleteDto(Map<String, Object> where) {
        this.where = where;
    }

    public Map<String, Object> getWhere() {
        return where;
    }

    public void setWhere(Map<String, Object> where) {
        this.where = where;
    }

    @Override
    public String toString() {
        return "DeleteDto{" +
                "where=" + where +
                '}';
    }
}
