package models;

import java.sql.Date;

public class Employee {
	private Integer employee_id;
	private String name;
	private String phone;
	private Date birthDay;
	private String cpf;
	private Integer position;
	private Integer user_id;

	public Employee(Integer employee_id, String name, String phone, Date birthDay, String cpf, Integer position,
			Integer user_id) {
		super();
		this.employee_id = employee_id;
		this.name = name;
		this.phone = phone;
		this.birthDay = birthDay;
		this.cpf = cpf;
		this.position = position;
		this.user_id = user_id;
	}

	public Integer getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(Integer employee_id) {
		this.employee_id = employee_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

}
