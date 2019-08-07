package com.thbs.simplecrudoperation.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thbs.simplecrudoperation.EmployeeDTO.EmployeeDTO;
import com.thbs.simplecrudoperation.Exception.EmployeeNotFoundException;
import com.thbs.simplecrudoperation.entity.EmployeeEntity;
import com.thbs.simplecrudoperation.model.Employee;
import com.thbs.simplecrudoperation.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public EmployeeDTO saveEmployee(Employee employee) {
		EmployeeEntity emp = new EmployeeEntity();
		emp.setEid(employee.getEid());
		emp.setEname(employee.getEname());
		emp.setEmail(employee.getEmail());

		EmployeeEntity savedEmployee = employeeRepository.save(emp);

		EmployeeDTO empDTO = new EmployeeDTO();
		empDTO.setEid(employee.getEid());
		empDTO.setEname(employee.getEname());
		empDTO.setEmail(employee.getEmail());

		return empDTO;

	}

	public EmployeeDTO getEmployee(int eid) {
		Optional<EmployeeEntity> optionalEmployee = employeeRepository.findById(eid);

		if (optionalEmployee.isPresent()) {
			EmployeeEntity employeeEntity = optionalEmployee.get();

			EmployeeDTO empDTO = new EmployeeDTO();
			empDTO.setEid(employeeEntity.getEid());
			empDTO.setEname(employeeEntity.getEname());
			empDTO.setEmail(employeeEntity.getEmail());
			return empDTO;
		}

		else {
			throw new EmployeeNotFoundException("employee is not found with this Unique ID");
		}

	}

	public void deleteEmployee(Employee employee) {
		EmployeeEntity emp = new EmployeeEntity();
		emp.setEid(employee.getEid());
		emp.setEname(employee.getEname());
		emp.setEmail(employee.getEmail());

		employeeRepository.delete(emp);
	}
}
