package com.vinfai.basic.thread.interview.q1;

import java.io.IOException;
//线程顺序执行
public class ThreadJoinTest {

	public static void main(String[] args) throws IOException, InterruptedException{
		
		Thread t1 = new Thread(new Runner("t1"));
		Thread t2 = new Thread(new Runner("t2"));
		Thread t3 = new Thread(new Runner("t3"));
		t1.start();
		t1.join();
		t2.start();
		t2.join();
		t3.start();
		t3.join();
		System.out.println("main thread.");
		/**
		 * result:
		 * 	Thread-0 : t1;
			Thread-1 : t2;
			Thread-2 : t3;
			main thread.

		 */
	}

}

class Runner implements Runnable{
	private String name ;
	
	public Runner(String name){
		this.name = name;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+" : "+name+";");
	}
}