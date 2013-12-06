package com.vinfai.spring.aop.proxyfactory;

public class Person implements IPerson {
	
	private String name;
	
	private Integer age;
	
	public Person(String name){
		this.name = name;
	}
	@Override
	public String dosay() {
		System.out.println("do say hello."+name);
		return "hello!"+name;
	}
	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Integer getAge() {
		return age;
	}



	public void setAge(Integer age) {
		this.age = age;
	}



	

}
