package com.bajaj.helloworld;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class studentdetails implements Comparable<studentdetails>{
	String name;
	String address;
	int mobile;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getMobile() {
		return mobile;
	}
	public void setMobile(int mobile) {
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "studentdetails [name=" + name + ", address=" + address + ", mobile=" + mobile + "]";
	}
	public studentdetails(String name, String address, int mobile) {
		super();
		this.name = name;
		this.address = address;
		this.mobile = mobile;
	}
	@Override
	public int compareTo(studentdetails o) {
		// TODO Auto-generated method stub
			return this.name.compareTo(o.name);
	}
}

public class Mystream {
	public static void main(String args[]) {
		List<studentdetails> s=new ArrayList<studentdetails>();
		s.add(new studentdetails("ansar","mumbai",5341));
		s.add(new studentdetails("bannu","chennai",8372));
		s.add(new studentdetails("viswa","mumbai",7363));
		s.add(new studentdetails("cherry","pune",8474));
		s.add(new studentdetails("harshit","mumbai",7535));
		Stream<studentdetails> str=s.stream();
		
		//printing all student details
		str.forEach(i->System.out.println(i));
		
		//printing all names by collecting into list
		List<String> l=s.stream().map(i->i.name)
				.collect(Collectors.toList());
		l.stream().forEach(i->System.out.println(i));
		
		//details of student with address mumbai
		System.out.println("printing mumbai...");
		s.stream().filter(i->"mumbai".equals(i.getAddress()))
		.forEach(i->System.out.println(i));
		
		//count of students in mumbai
		long c=s.stream().filter(i->"mumbai".equals(i.getAddress()))
				.map(i->i.getName()).count();
		System.out.println(c);
		
		//distinct address of students
		System.out.println("distinct.......");
		s.stream().map(i->i.getAddress())
		.distinct().forEach(i->System.out.println(i));
		
		//details of student with mobile 7363
		s.stream().filter(i->i.getMobile()==7363)
		.forEach(j->System.out.println(j));
		
		//making students names to uppercase
		s.stream().map(i->i.getName())
		.map(i->i.toUpperCase())
		.forEach(i->System.out.println(i));
		//or 
		s.stream()
		.map(i->i.getName().toUpperCase())
		.forEach(i->System.out.println(i));
		
		//maximum phn number
		//Collection<Integer> collection= Arrays.asList(100,200,5000,200);
		//Collection<String> col=Arrays.asList("ab","cd","ae");
	    //Optional<Integer> m=collection.stream().max((i,j)->i.compareTo(j));
		//System.out.println(m.get());
		Optional<Integer> m1=s.stream().map(i->i.getMobile())
				            .max((i,j)->i.compareTo(j));
		System.out.println(m1.get());
		
		//min phn number
		Optional<Integer> m2=s.stream().map(i->i.getMobile())
	            .min((i,j)->i.compareTo(j));
        System.out.println(m2.get());
      
		//sorting mobile no
		s.stream().map(i->i.getName()).sorted()
		.forEach(i->System.out.println(i));
		
		//sorting according to names using comparable 
		s.stream().sorted().forEach(i->System.out.println(i));
		
		//sorting desc for mobile using comparator
		s.stream().sorted(new Comparator<studentdetails>(){
			@Override
			public int compare(studentdetails o1, studentdetails o2) {
				// TODO Auto-generated method stub
				return o1.mobile-o2.mobile;
			}
		}).forEach(i->System.out.println(i));
		
		//adding all elements likes mobile
		int sum=s.stream().map(i->i.getMobile()).reduce(0,(i,j)->i+j);
		System.out.println(sum);
		
		//mul all elements likes mobile
		long mul=s.stream().map(i->i.getMobile()).reduce(0,(i,j)->i*j);
		System.out.println(mul);
			
		}
	}
	

