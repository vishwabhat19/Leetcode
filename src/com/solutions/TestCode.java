package com.solutions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestCode
{
	public static void main(String[] args)
	{
		/*
		Emp
		empname
		empstate
		empsalary

		List and add employees
		Pick the max salary in the list

		2. Who is in JK state add 2000 rupees to their salary?
		 */

		Employee e1 = new Employee("abc", "karnataka", 1000);
		Employee e2 = new Employee("xyz", "JK", 20000);
		Employee e3 = new Employee("efg", "TN", 1002020);
		Employee e4 = new Employee("ijk", "JK", 10000);
		Employee e5 = new Employee("lmn", "JK", 4000);


		List<Employee> list = Arrays.asList(new Employee[]{e1,e2,e3, e4, e5});

		Employee resultEmployee = list.stream().max(Comparator.comparing(Employee::getSalary)).get();

		System.out.println("Employee with the highest salary is: "+resultEmployee);

		System.out.println("Incremented Salaries");
		List<Employee> finalList = list.stream().filter(emp -> emp.getState().equalsIgnoreCase("JK")).map(e -> new Employee(e.getName(), e.getState(),e.getSalary()+2000)).collect(Collectors.toList());
		finalList.forEach(System.out::println);
		//Map with state and list of persons belonging to a particular state

		Map<String, List<Employee>> mapByState = list.stream().collect(Collectors.groupingBy(Employee::getState));
		mapByState.entrySet().stream().forEach(System.out::println);
	}


}

class Employee {

	private String name;
	private String state;
	private Integer salary;

	public Employee(String name, String state, Integer salary)
	{
		this.name = name;
		this.state = state;
		this.salary = salary;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getState()
	{
		return state;
	}

	public void setState(String state)
	{
		this.state = state;
	}

	public Integer getSalary()
	{
		return salary;
	}

	public void setSalary(Integer salary)
	{
		this.salary = salary;
	}

	@Override public String toString()
	{
		return "Employee{" +
				"name='" + name + '\'' +
				", state='" + state + '\'' +
				", salary=" + salary +
				'}';
	}
}