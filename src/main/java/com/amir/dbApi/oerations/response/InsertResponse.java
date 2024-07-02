package com.amir.dbApi.oerations.response;

public class InsertResponse extends DbResponse {
    private int affectedRows;

    public InsertResponse(String message) {
        super(DbResponse.FAIL, message);
    }

    public InsertResponse(int affectedRows) {
        super(DbResponse.SUCCESS, "Data inserted successfully");
        this.affectedRows = affectedRows;
    }

    public int getAffectedRows() {
        return affectedRows;
    }

    public void setAffectedRows(int affectedRows) {
        this.affectedRows = affectedRows;
    }
}
