package com.amir.dbApi.oerations.module;

import com.amir.dbApi.oerations.dtos.DeleteDto;
import com.amir.dbApi.oerations.dtos.InsertDto;
import com.amir.dbApi.oerations.dtos.SelectDto;
import com.amir.dbApi.oerations.dtos.UpdateDto;
import com.amir.dbApi.oerations.response.InsertResponse;
import com.amir.dbApi.oerations.response.SelectResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/{schema}/{table}")
public class DbAccessController {
    private final QueryMakerService queryMaker;
    private final QueryExecutionService queryExecutioner;

    @Autowired
    public DbAccessController(QueryExecutionService queryExecutioner, QueryMakerService queryMaker) {
        this.queryExecutioner = queryExecutioner;
        this.queryMaker = queryMaker;
    }

    @GetMapping
    public SelectResponse selectQuery(
            @PathVariable String schema,
            @PathVariable String table,
            @Valid @RequestBody SelectDto selectDto
    ) {
        return queryExecutioner.fetch(schema, table, selectDto);
    }

    @PostMapping
    public InsertResponse insertQuery(
            @PathVariable String schema,
            @PathVariable String table,
            @Valid @RequestBody InsertDto insertDto
    ) {
        return queryExecutioner.save(schema, table, insertDto);
    }

    @PutMapping
    public String updateQuery(
            @PathVariable String schema,
            @PathVariable String table,
            @Valid @RequestBody UpdateDto updateDto
    ) {
        return queryMaker.updateSql(schema, table, updateDto.getMods().keySet(),
                updateDto.getWhere()==null?null:updateDto.getWhere().keySet());
    }

    @DeleteMapping
    public String deleteQuery(
            @PathVariable String schema,
            @PathVariable String table,
            @Valid @RequestBody DeleteDto deleteDto
    ) {
        System.out.println(deleteDto);
        return "Delete query";
    }
}
