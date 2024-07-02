package com.amir.dbApi.oerations.response;

public class UpdateResponse extends DbResponse {
    private int affectedRows;

    public UpdateResponse(String message) {
        super(DbResponse.FAIL, message);
    }

    public UpdateResponse(int affectedRows) {
        super(DbResponse.SUCCESS, "Data updated successfully");
        this.affectedRows = affectedRows;
    }

    public int getAffectedRows() {
        return affectedRows;
    }

    public void setAffectedRows(int affectedRows) {
        this.affectedRows = affectedRows;
    }
}
