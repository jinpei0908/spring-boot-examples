package com.example.pageable.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1")
public class PageableController {

    @GetMapping("pageable")
    public String get(@PageableDefault(sort = "updated_date", direction = Sort.Direction.DESC) Pageable pageable) {
        return pageable.toString();
    }

    @GetMapping("sort")
    public String get(@SortDefault(sort = "updated_date", direction = Sort.Direction.DESC) Sort sort) {
        return sort.toString();
    }
}
