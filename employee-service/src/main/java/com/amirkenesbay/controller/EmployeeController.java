package com.amirkenesbay.controller;

import com.amirkenesbay.dto.ApiResponseDto;
import com.amirkenesbay.dto.EmployeeDto;
import com.amirkenesbay.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> create(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto department = employeeService.create(employeeDto);
        return new ResponseEntity<>(department, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ApiResponseDto getById(@PathVariable("id") Long employeeId) {
        return employeeService.getById(employeeId);
    }
}