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
		Map<String,Long> map = Arrays.stream(s).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		map.entrySet().stream().forEach(System.out::println);

		//Remove Duplicates from a array
		List<String> distinctList = Arrays.stream(s).distinct().collect(Collectors.toList());
		System.out.println("Distinct List");
		distinctList.stream().forEach(System.out::println);

		Student s1 = new Student(1, "Krishna", 1);
		Student s2 = new Student(2, "Rama", 1);
		Student s3 = new Student(3, "Vishnu", 1);
		Student s4 = new Student(4, "Krishna", 1);
		Student s5 = new Student(3, "Vishwa", 1);


		List<Student> list = Arrays.asList(new Student[]{s1,s2,s3,s4,s5});


		//Sort the students based on their marks.
		List<Student> sortedList = list.stream().sorted(Comparator.comparing(Student::getMarks)).collect(Collectors.toList());
		System.out.println("Sorted List by Marks");
		sortedList.forEach(student -> System.out.println(student.getName()+" "+student.getMarks()));

		//Filter out duplicate students using Student name
		Map<String,Student> mapDistinct = list.stream().collect(Collectors.toMap(Student::getName, student -> student, (st1,st2) -> st1));
		System.out.println("Removing duplicates");
		mapDistinct.entrySet().stream().forEach(e -> System.out.println(e.getKey()+" "+e.getValue()));

		//Return the Student with the least marks
		Student student = list.stream().min(Comparator.comparing(Student::getMarks)).get();
		System.out.println("The student with minimum mark is: "+student.getName()+" and his marks are: "+student.getMarks());

		//Return the student with highest marks
		Student studentHighestMarks	 = list.stream().max(Comparator.comparing(Student::getMarks)).get();

		System.out.println("Student with Highest Marks is: "+studentHighestMarks);

		//Student with names starting from V
		List<Student> studentsWithV = list.stream().filter(stu -> stu.getName().charAt(0) == 'V').collect(Collectors.toList());

		studentsWithV.forEach(System.out::println);

		//Get a total of all the marks in this list
		int totalMarks = list.stream().mapToInt(Student::getMarks).sum();

		System.out.println("Total Marks: "+totalMarks);
		




	}
}
