package com.amir.dbApi.oerations.module;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class QueryMakerService {

    public String varFields(int nb) {
        String res = "?,".repeat(nb);
        return res.substring(0, res.length() - 1);
    }

    public String valFields(List<String> columns) {
        return String.join(",", columns);
    }

    public String eqFields(Set<String> columns) {
        StringBuilder sb = new StringBuilder();
        for (String column : columns) {
            sb.append(column).append(" = ?,");
        }
        return sb.substring(0, sb.length() - 1);
    }

    public String whereClause(Set<String> columns) {
        if (columns == null || columns.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(" WHERE ");
        for (String column : columns) {
            sb.append(column).append(" = ? AND ");
        }
        return sb.substring(0, sb.length() - 5);
    }

    public String selectSql(
            String schema,
            String table,
            List<String> columns,
            Set<String> conditionColumns
    ) {
        return "SELECT " + valFields(columns) + " FROM " + schema + "." + table
                + whereClause(conditionColumns);
    }

    public String insertSql(
            String schema,
            String table,
            List<String> columns,
            int affectedRows
    ) {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO ").append(schema).append(".").append(table)
                .append(" (").append(valFields(columns)).append(") VALUES ");
        for (int i = 0; i < affectedRows; i++) {
            sb.append("(").append(varFields(columns.size())).append("),");
        }
        return sb.substring(0, sb.length() - 1);
    }

    public String updateSql(
            String schema,
            String table,
            Set<String> modificationColumns,
            Set<String> conditionColumns
    ) {
        return "UPDATE " + schema + "." + table + " SET " + eqFields(modificationColumns)
                + whereClause(conditionColumns);
    }

    public String deleteSql(
            String schema,
            String table,
            Set<String> conditionColumns
    ) {
        return "DELETE FROM " + schema + "." + table + whereClause(conditionColumns);
    }
}
