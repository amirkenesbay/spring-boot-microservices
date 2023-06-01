package com.amirkenesbay.service;

import com.amirkenesbay.dto.DepartmentDto;
import com.amirkenesbay.entity.Department;
import com.amirkenesbay.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final ModelMapper modelMapper;
    private final DepartmentRepository departmentRepository;

    public DepartmentDto create(DepartmentDto dto) {
        Department department = mapToEntity(dto);
        Department newDepartment = departmentRepository.save(department);

        DepartmentDto departmentDto = mapToDto(newDepartment);
        return departmentDto;
    }

    public DepartmentDto getByCode(String departmentCode) {
        Department department = departmentRepository.findByDepartmentCode(departmentCode);

        DepartmentDto departmentDto = mapToDto(department);
        return departmentDto;
    }

    private Department mapToEntity(DepartmentDto departmentDto) {
        return modelMapper.map(departmentDto, Department.class);
    }

    private DepartmentDto mapToDto(Department department) {
        return modelMapper.map(department, DepartmentDto.class);
    }
}
