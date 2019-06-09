package co.edu.udea.diploma.microservicios.department.model;

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
public class Employee {

	private Long id;
	private String name;
	private int age;
	private String position;

	public Employee(String name, int age, String position) {
		this.name = name;
		this.age = age;
		this.position = position;
	}

}
