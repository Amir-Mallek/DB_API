package com.amir.dbApi.oerations.module;

import com.amir.dbApi.oerations.dtos.DeleteDto;
import com.amir.dbApi.oerations.dtos.InsertDto;
import com.amir.dbApi.oerations.dtos.SelectDto;
import com.amir.dbApi.oerations.dtos.UpdateDto;
import com.amir.dbApi.oerations.response.DeleteResponse;
import com.amir.dbApi.oerations.response.InsertResponse;
import com.amir.dbApi.oerations.response.SelectResponse;
import com.amir.dbApi.oerations.response.UpdateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class QueryExecutionService {

    private final QueryMakerService queryMaker;

    private final JdbcTemplate template;

    @Autowired
    public QueryExecutionService(QueryMakerService queryMaker, JdbcTemplate template) {
        this.queryMaker = queryMaker;
        this.template = template;
    }

    public SelectResponse fetch(
            String schema,
            String table,
            SelectDto selectDto
    ) {
        String sql;
        sql = queryMaker.selectSql(
                schema,
                table,
                selectDto.getCols(),
                (selectDto.getWhere() == null) ? null : selectDto.getWhere().keySet()
        );
        try {
            List<Map<String, Object>> data = (selectDto.getWhere() == null)
                    ? template.queryForList(sql)
                    : template.queryForList(sql, selectDto.getWhere().values().toArray());
            return new SelectResponse(data);
        } catch (Exception e) {
            return new SelectResponse(e.getCause().getMessage());
        }
    }

    public InsertResponse save(
            String schema,
            String table,
            InsertDto insertDto
    ) {
        String sql = queryMaker.insertSql(
                schema,
                table,
                insertDto.getCols(),
                insertDto.getValues().size()
        );
        List<Object> args = new ArrayList<>();
        for (Map<String, Object> row : insertDto.getValues()) {
            for (String col : insertDto.getCols()) {
                args.add(row.get(col));
            }
        }
        try {
            int affectedRows = template.update(sql, args.toArray());
            return new InsertResponse(affectedRows);
        } catch (Exception e) {
            return new InsertResponse(e.getCause().getMessage());
        }
    }

    public UpdateResponse update(
            String schema,
            String table,
            UpdateDto updateDto
    ) {
        String sql = queryMaker.updateSql(
                schema,
                table,
                updateDto.getMods().keySet(),
                (updateDto.getWhere() == null) ? null : updateDto.getWhere().keySet()
        );
        List<Object> args = new ArrayList<>(updateDto.getMods().values());
        if (updateDto.getWhere() != null) {
            args.addAll(updateDto.getWhere().values());
        }
        try {
            int affectedRows = template.update(sql, args.toArray());
            return new UpdateResponse(affectedRows);
        } catch (Exception e) {
            return new UpdateResponse(e.getCause().getMessage());
        }
    }

    public DeleteResponse remove(
            String schema,
            String table,
            DeleteDto deleteDto
    ) {
        String sql = queryMaker.deleteSql(
                schema,
                table,
                (deleteDto.getWhere() == null) ? null : deleteDto.getWhere().keySet()
        );
        try {
            int affectedRows = (deleteDto.getWhere() == null)
                    ? template.update(sql)
                    : template.update(sql, deleteDto.getWhere().values().toArray());
            return new DeleteResponse(affectedRows);
        } catch (Exception e) {
            return new DeleteResponse(e.getCause().getMessage());
        }
    }

}
