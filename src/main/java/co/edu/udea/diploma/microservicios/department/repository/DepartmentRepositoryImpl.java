package co.edu.udea.diploma.microservicios.department.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import co.edu.udea.diploma.microservicios.department.model.Department;

public class DepartmentRepositoryImpl implements DepartmentRepository {

	private List<Department> departments = new ArrayList<>();

	@Override
	public Department add(Department department) {
		department.setId((long) (departments.size() + 1));
		departments.add(department);
		return department;
	}

	@Override
	public Department findById(Long id) {
		Optional<Department> department = departments.stream().filter(a -> a.getId().equals(id)).findFirst();
		if (department.isPresent())
			return department.get();
		else
			return null;
	}

	@Override
	public List<Department> findAll() {
		return departments;
	}

	@Override
	public List<Department> findByOrganization(Long organizationId) {
		return departments.stream().filter(a -> a.getOrganizationId().equals(organizationId))
				.collect(Collectors.toList());
	}
}
