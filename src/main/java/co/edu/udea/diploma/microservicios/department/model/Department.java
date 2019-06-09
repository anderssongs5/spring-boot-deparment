package co.edu.udea.diploma.microservicios.department.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Department {

	private Long id;
	private Long organizationId;
	private String name;
	private List<Employee> employees = new ArrayList<>();

	public Department(Long organizationId, String name) {
		super();
		this.organizationId = organizationId;
		this.name = name;
	}

}
