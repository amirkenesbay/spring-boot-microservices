package com.amirkenesbay.service;

import com.amirkenesbay.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:8080", value = "DEPARTMENT-SERVICE")
public interface APIClient {
    @GetMapping("/api/v1/departments/{department-code}")
    DepartmentDto getDepartmentCode(@PathVariable("department-code") String departmentCode);
}