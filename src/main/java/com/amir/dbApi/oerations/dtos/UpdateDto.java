package com.amir.dbApi.oerations.dtos;

import java.util.Map;

public class UpdateDto {
    private Map<String, Object> mods;
    private Map<String, Object> where;

    public UpdateDto() {}

    public UpdateDto(Map<String, Object> mods, Map<String, Object> where) {
        this.mods = mods;
        this.where = where;
    }

    public Map<String, Object> getMods() {
        return mods;
    }

    public void setMods(Map<String, Object> mods) {
        this.mods = mods;
    }

    public Map<String, Object> getWhere() {
        return where;
    }

    public void setWhere(Map<String, Object> where) {
        this.where = where;
    }

    @Override
    public String toString() {
        return "UpdateDto{" +
                "mods=" + mods +
                ", where=" + where +
                '}';
    }
}
