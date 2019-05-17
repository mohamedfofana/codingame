package main.java.codingame;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class OccurenceObjectInArray {
	public  static Map<Person, Integer> getOccurences(Person[] ps){
		Map<Person, Integer> occurences = new HashMap<Person, Integer>();
		Arrays.sort(ps, new PersonComparator());
		int i = 0;
		while (i < ps.length) {
			int occur = 1;
			while (i+1 < ps.length && ps[i].equals(ps[i+1])) {
				++occur;
				i++;
			}
			occurences.put(ps[i], occur);
			i++;
		}
		return occurences;
	}
	
	public static void main(String[] args) {
		Person[] people;
		people = new Person[] {
				new Person("dupont", 17 ),
				new Person("aaron", 40 ),
				new Person("mark", 12 ),
				new Person("aaron", 40 ),
				new Person("meta", 12 ),
				new Person("meta", 12 ),
				new Person("aaron", 40 ),
				new Person("aaron", 40 ),
				new Person("meta", 12 ),
				new Person("pierre", 10 ),
				new Person("arman", 40 ),
				new Person("arman", 40 ),
				new Person("aaron", 40 ),
				new Person("dupont", 17 )
		};
		System.out.println(getOccurences(people));
	}
}
class PersonComparator implements Comparator<Person> {            
	public int compare( Person a, Person b ) {
		if (a.getAge() == b.getAge() ) {
			return ( a.getName().compareTo( b.getName() ) );
		}
		return  (a.getAge() < b.getAge()) ? -1 : 1;
	}
}
class Person{
	private int age;
	private String name;
	public Person(String name, int age) {
		this.age = age;
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public String getName() {
		return name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public boolean equals(Object obj) {
		Person p = (Person) obj;
		return this.age == p.age && this.name.equals(p.name);
	}
	@Override
	public String toString() {
		return this.name + " - " + this.age;
	}
}