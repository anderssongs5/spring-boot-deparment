package co.edu.udea.diploma.microservicios.department.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.udea.diploma.microservicios.department.client.EmployeeClient2;
import co.edu.udea.diploma.microservicios.department.model.Department;
import co.edu.udea.diploma.microservicios.department.repository.DepartmentCRUDRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/departments")
public class DepartmentController {

	@Autowired
	DepartmentCRUDRepository repository;

	@Autowired
	EmployeeClient2 employeeClient2;

	@PostMapping("/")
	public ResponseEntity<Department> add(@RequestBody Department department) {
		log.info("Department add: {}", department);
		return ResponseEntity.ok(repository.save(department));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Department> findById(@PathVariable("id") String id) {
		log.info("Department find: id={}", id);
		return ResponseEntity.ok(repository.findById(id).get());
	}

	@GetMapping("/")
	public ResponseEntity<Iterable<Department>> findAll() {
		log.info("Department find");
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/organization/{organizationId}")
	public ResponseEntity<List<Department>> findByOrganization(@PathVariable("organizationId") Long organizationId) {
		log.info("Department find: organizationId={}", organizationId);
		return ResponseEntity.ok(repository.findByOrganizationId(organizationId));
	}

	@GetMapping("/organization/{organizationId}/with-employees")
	public List<Department> findByOrganizationWithEmployees(@PathVariable("organizationId") Long organizationId) {
		log.info("Department find: organizationId={}", organizationId);
		List<Department> departments = repository.findByOrganizationId(organizationId);
		departments.forEach(d -> d.setEmployees(employeeClient2.findByDepartment(d.getId())));
		return departments;
	}

}
