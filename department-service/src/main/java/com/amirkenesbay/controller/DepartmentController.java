package com.amirkenesbay.controller;

import com.amirkenesbay.dto.DepartmentDto;
import com.amirkenesbay.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/departments")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentDto> create(@RequestBody DepartmentDto departmentDto) {
        DepartmentDto department = departmentService.create(departmentDto);
        return new ResponseEntity<>(department, HttpStatus.CREATED);
    }

    @GetMapping("{department-code}")
    public DepartmentDto getByCode(@PathVariable("department-code") String departmentCode) {
        return departmentService.getByCode(departmentCode);
    }
}