package com.thbs.simplecrudoperation.service;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mockitoSession;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.thbs.simplecrudoperation.EmployeeDTO.EmployeeDTO;
import com.thbs.simplecrudoperation.Exception.EmployeeNotFoundException;
import com.thbs.simplecrudoperation.entity.EmployeeEntity;
import com.thbs.simplecrudoperation.model.Employee;
import com.thbs.simplecrudoperation.repository.EmployeeRepository;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class EmployeeServiceTest {

	@InjectMocks
	public EmployeeService employeeService;

	@Mock
	public EmployeeRepository employeeRepository;

	@Test
	void employeeSave() {

		Employee employee = new Employee();
		employee.setEid(1);
		employee.setEname("kiran");
		employee.setEmail("kiran_veeranna@thbs.com");

		EmployeeEntity employeeEntity = new EmployeeEntity();
		employeeEntity.setEid(1);
		employeeEntity.setEname("kiran");
		employeeEntity.setEmail("kiran_veeranna@thbs.com");

		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setEid(1);
		employeeDTO.setEname("kiran");
		employeeDTO.setEmail("kiran_veeranna@thbs.com");

		Mockito.when(employeeRepository.save(Mockito.any(EmployeeEntity.class))).thenReturn(employeeEntity);

		EmployeeDTO dto = employeeService.saveEmployee(employee);

		assertEquals(1, dto.getEid());

		Mockito.verify(employeeRepository).save(Mockito.any(EmployeeEntity.class));

	}

	@Test
	void getEmployeeTest() {

		EmployeeEntity employeeEntity = new EmployeeEntity();
		employeeEntity.setEid(1);
		employeeEntity.setEname("kiran");
		employeeEntity.setEmail("kiran_veeranna@thbs.com");

		Mockito.when(employeeRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(employeeEntity));

		EmployeeDTO employeeDTO = employeeService.getEmployee(1);
		assertEquals(1, employeeDTO.getEid());

		Mockito.verify(employeeRepository).findById(Mockito.anyInt());

	}

	@Test
	void getEmployeeTestException() throws EmployeeNotFoundException {

		Mockito.when(employeeRepository.findById(Mockito.anyInt())).thenReturn(Optional.empty());

		assertThrows(EmployeeNotFoundException.class, () -> {

			employeeService.getEmployee(1);
		});

		// Mockito.verify(employeeRepository).findById(Mockito.anyInt());

	}

	@Test
	void deleteTest() {

		Employee employee = new Employee();
		employee.setEid(1);
		employee.setEname("kiran");
		employee.setEmail("kiran_veeranna@thbs.com");

		Mockito.doNothing().when(employeeRepository).delete(Mockito.any(EmployeeEntity.class));

		employeeService.deleteEmployee(employee);

	}

}
