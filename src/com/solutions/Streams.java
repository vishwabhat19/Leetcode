package com.solutions;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
Use Streams to output the frequency of each String
 */

class Student {
	Integer studentId;
	String name;
	Integer marks;

	public Student(Integer studentId, String name, Integer marks)
	{
		this.studentId = studentId;
		this.name = name;
		this.marks = marks;
	}

	public Integer getStudentId()
	{
		return studentId;
	}

	public void setStudentId(Integer studentId)
	{
		this.studentId = studentId;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Integer getMarks()
	{
		return marks;
	}

	public void setMarks(Integer marks)
	{
		this.marks = marks;
	}

	@Override public String toString()
	{
		return "Student{" +
				"studentId=" + studentId +
				", name='" + name + '\'' +
				", marks=" + marks +
				'}';
	}
}
public class Streams
{
	public static void main(String[] args)
	{
		String s[] = {"batman", "superman", "batman", "batman"};
		Map<String, Long> map = Arrays.stream(s).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		Student s1 = new Student(1, "Krishna", 100);
		Student s2 = new Student(2, "Rama", 96);
		Student s3 = new Student(3, "Vishnu", 50);
		Student s4 = new Student(4, "Krishna", 1000);

		List<Student> list = Arrays.asList(new Student[]{s1,s2,s3});
		list.forEach(student -> System.out.println(student.getName()));

		//Sort the students based on their marks.
		List<Student> sortedList = list.stream().sorted(Comparator.comparing(Student::getMarks)).collect(Collectors.toList());
		System.out.println("Sorted List by Marks");
		sortedList.forEach(student -> System.out.println(student.getName()+" "+student.getMarks()));

		//Filter out duplicate students using Student name
		Map<String, Student> map1 = list.stream().collect(Collectors.toMap(Student::getName, Function.identity(), (st1,st2) -> st1));
		System.out.println("Removing duplicates");
		map.entrySet().stream().forEach(e -> System.out.println(e.getKey()+" "+e.getValue()));


	}
}
