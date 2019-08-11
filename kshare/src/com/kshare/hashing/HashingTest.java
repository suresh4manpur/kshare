package com.kshare.hashing;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class HashingTest {
	

	public static void main(String[] args) {
		
		Map<Employee, String> map = new HashMap<>();
		String result1 = map.put(new Employee(1, "Suresh"), "One");
		System.out.println("result1 : " + result1);
		map.put(new Employee(2, "Mahesh"), "Two");
		String result = map.put(new Employee(3, "Raju"), "Three");

		System.out.println("Result : " + result);

		System.out.println("Size = " + map.size());

		Set<Employee> empls = map.keySet();

		for (Employee emp : empls) {
			System.out.println(emp);
			System.out.println("Key : " + map.get(emp));
		}
	}
}

/**
 * @author Suresh
 *
 */
class Employee {
	int id;
	String name;

	public Employee(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	@Override
	public int hashCode() {

		return 7;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public String toString() {
		return "id : " + id + ", name : " + name;
	};
}