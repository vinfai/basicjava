package com.vinfai.basic.scjp;
/**
 * 关于Override有几点要注意的地方： 
1.被覆盖方法的访问控制级别可以不一样。 
例如上例父类的showMess方法的访问级别为protected的，而子类覆盖的showMess方法访问级别则为public的。 

但子类的访问级别必须要高于父类被覆盖方法的访问级别，如果父类是public的而子类是protected的则是错误的。

2.方法被定义为private或static或final的则不能被覆盖。 

3.方法的返回类型：子类的返回类型可以是更具体的对象，例如可以将Employee类的返回类型改为Object也正确。而倒过来则错误。 

4.在方法调用时先会在子类中找覆盖的方法，如果子类中没有则会在父类中去找。 
 */
public class Parent {
	
	//修饰符改为 protected,public 则得到不同的值
	public int num(int i,int j){
		return i+j;
	}
	
	public static void main(String[] args) {
		Parent p = new Child();
		System.out.println(p.num(1, 2));
		byte[] arr1 ,arr2;
		byte arr3[][] = new byte[5][];
		byte[][] arr4;
	}
}

class Child extends Parent{
	
	public int num(int x,int y){
		return x-y;
	}
}
