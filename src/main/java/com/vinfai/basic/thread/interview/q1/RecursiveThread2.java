package com.vinfai.basic.thread.interview.q1;

import java.util.concurrent.Semaphore;

/**
 * 使用JDK5 concurrent信号量控制实际访问
 * 理解Semaphore原理
 * @author vinfai
 *
 */
public class RecursiveThread2 implements Runnable{
	
	public static void main(String[] args)throws Exception{
		//1.principle
	/*	Semaphore sm = new Semaphore(0);
		sm.release();
		int j = sm.availablePermits();
		System.out.println("availablePermits:"+j);
		sm.acquire();
		int i = sm.availablePermits();
		System.out.println("acquier:"+i);*/
		
		Thread t1 = new Thread(new RecursiveThread2(0,"A"));
		Thread t2 = new Thread(new RecursiveThread2(1,"B"));
		Thread t3 = new Thread(new RecursiveThread2(2,"C"));
		t1.start();
		t2.start();
		t3.start();
	}
	
	private int index;
	private String view;
	
	public RecursiveThread2(int index,String view) {
		this.index = index;
		this.view = view;
	}
	//ABC通过三个信号量来维护打印次序;第一个为A
	private static Semaphore[] semaphores = new Semaphore[]{
			new Semaphore(1),new Semaphore(0),new Semaphore(0)
	};
	AbstractStringBuilder
	public void run(){
		int count = 1 ;
		try{
			while(true){
				semaphores[index].acquire();// Acquires a permit from this semaphore,没有可用则等待,初始化只有semaphorce[0]可用,故先打印A;semaphores[0]=0;
				System.out.println(view);
				semaphores[(index+1)%3].release();//保证次序，释放第二个信号量的值 semaphores[1] = 1;
				count++;
				if(count>10){ //打印10次，跳出循环
					break;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
