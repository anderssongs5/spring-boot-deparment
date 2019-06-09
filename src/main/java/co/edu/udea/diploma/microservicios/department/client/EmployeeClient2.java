package co.edu.udea.diploma.microservicios.department.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import co.edu.udea.diploma.microservicios.department.model.Employee;

@FeignClient(value = "employee-service")
public interface EmployeeClient2 {

	@GetMapping("/employees/department/{departmentId}")
	List<Employee> findByDepartment(@PathVariable("departmentId") Long departmentId);
}
