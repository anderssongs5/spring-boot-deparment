package co.edu.udea.diploma.microservicios.department.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import co.edu.udea.diploma.microservicios.department.model.Department;

public interface DepartmentCRUDRepository extends CrudRepository<Department, String> {

	List<Department> findByOrganizationId(Long organizationId);
}
