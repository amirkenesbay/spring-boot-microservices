package com.amirkenesbay.service;

import com.amirkenesbay.dto.ApiResponseDto;
import com.amirkenesbay.dto.DepartmentDto;
import com.amirkenesbay.dto.EmployeeDto;
import com.amirkenesbay.entity.Employee;
import com.amirkenesbay.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final ModelMapper modelMapper;
    private final EmployeeRepository employeeRepository;
    private final APIClient apiClient;

    public EmployeeDto create(EmployeeDto dto) {
        Employee employee = mapToEntity(dto);
        Employee newEmployee = employeeRepository.save(employee);

        EmployeeDto employeeDto = mapToDto(newEmployee);
        return employeeDto;
    }

    public ApiResponseDto getById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow();
//        ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity(
//                "http://localhost:8080/api/v1/departments/" + employee.getDepartmentCode(), DepartmentDto.class);

//        DepartmentDto departmentDto = responseEntity.getBody();

//        DepartmentDto departmentDto = webClient.get()
//                .uri("http://localhost:8080/api/v1/departments/" + employee.getDepartmentCode())
//                .retrieve()
//                .bodyToMono(DepartmentDto.class)
//                .block();

        DepartmentDto departmentDto = apiClient.getDepartmentCode(employee.getDepartmentCode());
        EmployeeDto employeeDto = mapToDto(employee);

        ApiResponseDto apiResponseDto = new ApiResponseDto();
        apiResponseDto.setEmployeeDto(employeeDto);
        apiResponseDto.setDepartmentDto(departmentDto);
        return apiResponseDto;
    }

    private Employee mapToEntity(EmployeeDto employeeDto) {
        return modelMapper.map(employeeDto, Employee.class);
    }

    private EmployeeDto mapToDto(Employee employee) {
        return modelMapper.map(employee, EmployeeDto.class);
    }
}
