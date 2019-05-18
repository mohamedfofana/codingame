package main.java.codingame.tri;

import java.util.Arrays;
import java.util.Comparator;

public class TriPersonAgeNom {
	Person[] people;
	public void sortPeople() {
		people = new Person[] {
				new Person("mark", 12 ),
				new Person("aaron", 40 )
		};
		Arrays.sort(people, new PersonComparator() );
	}
	class PersonComparator implements Comparator<Person> {            
		public int compare( Person a, Person b ) {
			if (a.getAge() == b.getAge() ) {
				return ( a.getName().compareTo( b.getName() ) );
			}
			return  (a.getAge() < b.getAge()) ? -1 : 1;
		}
	}
	class Person {
		private String name;
		private int age;

		Person( String name, int age ) { 
			this.name = name;
			this.age = age;
		}   

		public String getName() {
			return this.name;
		}   

		public int getAge() {
			return this.age;
		}   
		public String toString() {
			return this.name+" ("+this.age+")";
		}
	}
}
