package com.amir.dbApi.oerations.module;

import com.amir.dbApi.oerations.dtos.DeleteDto;
import com.amir.dbApi.oerations.dtos.InsertDto;
import com.amir.dbApi.oerations.dtos.SelectDto;
import com.amir.dbApi.oerations.dtos.UpdateDto;
import com.amir.dbApi.oerations.response.DeleteResponse;
import com.amir.dbApi.oerations.response.InsertResponse;
import com.amir.dbApi.oerations.response.SelectResponse;
import com.amir.dbApi.oerations.response.UpdateResponse;
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

    private final QueryExecutionService queryExecutioner;

    @Autowired
    public DbAccessController(QueryExecutionService queryExecutioner) {
        this.queryExecutioner = queryExecutioner;
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
    public UpdateResponse updateQuery(
            @PathVariable String schema,
            @PathVariable String table,
            @Valid @RequestBody UpdateDto updateDto
    ) {
        return queryExecutioner.update(schema, table, updateDto);
    }

    @DeleteMapping
    public DeleteResponse deleteQuery(
            @PathVariable String schema,
            @PathVariable String table,
            @Valid @RequestBody DeleteDto deleteDto
    ) {
        return queryExecutioner.remove(schema, table, deleteDto);
    }
}
