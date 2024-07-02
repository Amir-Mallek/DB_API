package com.amir.dbApi.oerations.response;

public class DeleteResponse extends DbResponse {
    private int affectedRows;

    public DeleteResponse(String message) {
        super(DbResponse.FAIL, message);
    }

    public DeleteResponse(int affectedRows) {
        super(DbResponse.SUCCESS, "Data deleted successfully");
        this.affectedRows = affectedRows;
    }

    public int getAffectedRows() {
        return affectedRows;
    }

    public void setAffectedRows(int affectedRows) {
        this.affectedRows = affectedRows;
    }
}
