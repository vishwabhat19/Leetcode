package com.solutions;

import java.util.*;
import java.util.stream.Collectors;

public class TestInterview
{


	public static void main(String[] args)
	{
		
		Person p1 = new Person("abc", "male",21);
		Person p2 = new Person("xyz", "female",1);
		Person p3 = new Person("efg", "female",55);
		Person p4 = new Person("hig", "female",42);
		
		List<Person> list = Arrays.asList(new Person[]{p1,p2,p3,p4});
		
		List<Person> resultList = list.stream().filter(p -> p.getGender().equalsIgnoreCase("male")).collect(Collectors.toList());

		resultList.stream().forEach(System.out::println);

		//Sort the members using their age
		List<Person> sortedListByAge = list.stream().sorted(Comparator.comparing(Person::getAge)).collect(Collectors.toList());
		System.out.println("Sorted List By Age");
		sortedListByAge.forEach(System.out::println);

		//Count the number of male and Female Persons
		Map<String, Long> map = list.stream().collect(Collectors.groupingBy(Person::getGender, Collectors.counting()));
		map.entrySet().stream().forEach(e -> System.out.println(e.getKey()+" "+e.getValue()));

	}
}

class Person {

	String name;

	String gender;

	Integer age;

	public Person(String name, String gender, Integer age)
	{
		this.name = name;
		this.gender = gender;
		this.age = age;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getGender()
	{
		return gender;
	}

	public void setGender(String gender)
	{
		this.gender = gender;
	}

	public Integer getAge()
	{
		return age;
	}

	public void setAge(Integer age)
	{
		this.age = age;
	}

	@Override public String toString()
	{
		return "Person{" +
				"name='" + name + '\'' +
				", gender='" + gender + '\'' +
				", age=" + age +
				'}';
	}
}
