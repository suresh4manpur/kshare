package com.skill.designpattern.creational;

public class Builder {
	public static void main(String[] args) {
		
		Student student = new Student.StudentBuilder().name("Suresh").city("Gaya").email("sk4manpur@gmail.coom").build();
		System.out.println(student);

	}
}



class Student {
	String name;
	String email;
	String city;
	int age;

	private String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return super.toString();
	}
	public  StudentBuilder getStudentBuilder(){
		return new StudentBuilder();
	}
	static class StudentBuilder {
		private Student student;

		public StudentBuilder() {
			this.student = new Student();
		}

		public StudentBuilder name(String name) {
			student.setName(name);
			return this;
		}

		public StudentBuilder email(String email) {
			student.setEmail(email);
			return this;
		}

		public StudentBuilder city(String city) {
			student.setCity(city);
			return this;
		}

		public Student build() {
			return student;
		}

	}
}
