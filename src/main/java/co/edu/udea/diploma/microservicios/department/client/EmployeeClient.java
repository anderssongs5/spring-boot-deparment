package co.edu.udea.diploma.microservicios.department.client;

import java.util.List;

import co.edu.udea.diploma.microservicios.department.model.Employee;

public interface EmployeeClient {

	List<Employee> findByDepartment(final Long organizationId);
}
