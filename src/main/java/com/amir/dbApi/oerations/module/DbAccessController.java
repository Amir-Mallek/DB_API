package com.amir.dbApi.oerations.module;

import com.amir.dbApi.oerations.dtos.DeleteDto;
import com.amir.dbApi.oerations.dtos.InsertDto;
import com.amir.dbApi.oerations.dtos.SelectDto;
import com.amir.dbApi.oerations.dtos.UpdateDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/{schema}/{table}")
public class DbAccessController {

    @GetMapping
    public String selectQuery(
            @PathVariable String schema,
            @PathVariable String table,
            @Valid @RequestBody SelectDto selectDto
    ) {
        System.out.println(selectDto);
        return "Select query";
    }

    @PostMapping
    public String insertQuery(
            @PathVariable String schema,
            @PathVariable String table,
            @Valid @RequestBody InsertDto insertDto
    ) {
        System.out.println(insertDto);
        return "Insert query";
    }

    @PutMapping
    public String updateQuery(
            @PathVariable String schema,
            @PathVariable String table,
            @Valid @RequestBody UpdateDto updateDto
    ) {
        System.out.println(updateDto);
        return "Update query";
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
