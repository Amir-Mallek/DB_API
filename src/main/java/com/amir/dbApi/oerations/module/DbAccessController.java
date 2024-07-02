package com.amir.dbApi.oerations.module;

import com.amir.dbApi.oerations.dtos.SelectDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/{schema}/{table}")
public class DbAccessController {

    @GetMapping
    public String selectQuery(
            @PathVariable String schema,
            @PathVariable String table,
            @RequestBody SelectDto selectDto
    ) {
        System.out.println(selectDto);
        return "Select query";
    }
}
