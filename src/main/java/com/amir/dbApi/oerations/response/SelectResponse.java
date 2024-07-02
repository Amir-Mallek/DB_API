package com.amir.dbApi.oerations.response;

import java.util.List;
import java.util.Map;

public class SelectResponse extends DbResponse {
    private List<Map<String, Object>> data;

    public SelectResponse(String message) {
        super(DbResponse.FAIL, message);
    }

    public SelectResponse(List<Map<String, Object>> data) {
        super(DbResponse.SUCCESS, "Data fetched successfully");
        this.data = data;
    }

    public List<Map<String, Object>> getData() {
        return data;
    }

    public void setData(List<Map<String, Object>> data) {
        this.data = data;
    }
}
