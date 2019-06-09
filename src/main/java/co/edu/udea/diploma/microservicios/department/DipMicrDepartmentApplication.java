package co.edu.udea.diploma.microservicios.department;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import co.edu.udea.diploma.microservicios.department.model.Department;
import co.edu.udea.diploma.microservicios.department.repository.DepartmentRepository;
import co.edu.udea.diploma.microservicios.department.repository.DepartmentRepositoryImpl;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class DipMicrDepartmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(DipMicrDepartmentApplication.class, args);
	}

	@Bean
	DepartmentRepository repository() {
		DepartmentRepository repository = new DepartmentRepositoryImpl();
		repository.add(new Department(1L, "Development"));
		repository.add(new Department(1L, "Operations"));
		repository.add(new Department(2L, "Development"));
		repository.add(new Department(2L, "Operations"));
		return repository;
	}
}
