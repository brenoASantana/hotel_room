package models;

import java.sql.Date;

public class Employee {
	private Integer employeeId;
	private String name;
	private String phone;
	private Date birthDay;
	private String cpf;
	private Integer position;
	private Integer userId;

	public Employee(Integer employeeId, String name, String phone, Date birthDay, String cpf, Integer position,
			Integer userId) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.phone = phone;
		this.birthDay = birthDay;
		this.cpf = cpf;
		this.position = position;
		this.userId = userId;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}
