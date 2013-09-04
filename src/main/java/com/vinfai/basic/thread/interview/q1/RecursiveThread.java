package com.vinfai.basic.thread.interview.q1;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 有三个线程ID分别是A、B、C,请有多线编程实现，在屏幕上循环打印10次ABCABC…
 */
public class RecursiveThread implements Runnable{
	
	private int flag ;
	private String view ;
	private static final Object lock = new Object();
	private static AtomicInteger count = new AtomicInteger(0);
	public RecursiveThread(int flag,String view) {
		this.flag = flag;
		this.view = view;
	}
	
	@Override
	public void run() {
		synchronized (lock){
			try{
				while(count.intValue()<30){
					if(count.intValue()%3==flag){
						System.out.println(view);
						count.incrementAndGet();
						lock.notifyAll();
					}else{
						lock.wait();
					}
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	
	public static void main(String[] args){
	
		Thread t1 = new Thread(new RecursiveThread(0, "A"));
		Thread t2 = new Thread(new RecursiveThread(1, "B"));
		Thread t3 = new Thread(new RecursiveThread(2, "C"));
		t1.start();
		t2.start();
		t3.start();
		
	}
}
