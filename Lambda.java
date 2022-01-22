package com.bajaj.helloworld;

interface FunType{
	public void run1();
}

interface Int{
	public int run2(String s);
}
interface StrtoInt{
	public void run3(String s);
}
interface Int_Str{
	public void run4(Integer i);
}
interface Str_Str{
	public void run5(String s);
}

public class Lambda {
	public static void main(String args[]) {
		FunType a=()->System.out.println("just void");
		a.run1();
		
		//length of string
		Int b=(s)->s.length();
		System.out.println(b.run2("bannu"));
		
		StrtoInt c=(s)->System.out.println(s.length());
		c.run3("bannu");
		
	    //even odd , input-integer, output-string so void
		Int_Str n1=i->{if(i%2==0) System.out.println("even");
		               else System.out.println("odd");
		              };
		n1.run4(20);
		n1.run4(61);
		
		//positive negative input integer return string
		Int_Str n2=i->{if(i>0) System.out.println("positive");
		else System.out.println("negative");
		};
		n2.run4(81);
		n2.run4(-10);
		
		//make string to uppercase input string output string so void
		Str_Str a1=s->System.out.println(s.toUpperCase());
		a1.run5("bannu");
	}
}
