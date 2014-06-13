package com.vinfai.basic.juc;

import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * DelayQueue
 *Examples of DelayQueue in Java
December 16, 2012
1.	DelayQueue is an unbounded queue. It extends Delayed interface.
2.	Element from DelayQueue can only be taken when its delay has expired.
3.	At the head of the queue , element with furthest expired delay time is found.
4.	An element is expired when its getDelay() method returns a value less than or equal to zero.
5.	Null is not permitted in DelayQueue. 
6.	In DelayQueue, only those object can be inserted which implements Delayed interface. 
http://www.concretepage.com/java/example_delayqueue_java 例子好多错
 */
public class DelayQueueTest {
	
	public static void main(String[] args) {
		DelayQueue<DelayElement> queue = new DelayQueue<DelayElement>();
		long now = System.currentTimeMillis();//毫秒
		DelayElement ele1 = new DelayElement(5000+now,"e1");
		queue.offer(ele1);
		DelayElement ele2 = new DelayElement(3000+now,"e2");
		queue.offer(ele2);
		DelayElement ele3 = new DelayElement(2000+now,"e3");
		queue.offer(ele3);
		DelayElement ele4 = new DelayElement(4000+now,"e4");
		queue.offer(ele4);
		
		Iterator<DelayElement> iter = queue.iterator();
		//orignal data
		while(iter.hasNext()){
			DelayElement ele = iter.next();
			System.out.println(ele.name+":"+ele.delayTime);
		}
		//
		/*while(queue.size()>0){
			try {
				DelayElement ele = queue.take();
				System.out.println("current time in ms: " + System.currentTimeMillis() + ", element:" + ele.name); 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}*/
		/*
		 * 多线程从队列中取数据，DelayQueue根据DelayElement的compareTo()进行排序
		 */
		ExecutorService service = Executors.newFixedThreadPool(3);
		service.execute(new DelayElementCustomer("customer01", queue));
		service.execute(new DelayElementCustomer("customer02", queue));
		service.execute(new DelayElementCustomer("customer03", queue));
		try {
			Thread.sleep(50000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		service.shutdown();
		
	}
}
class DelayElementCustomer implements Runnable{//Runnable
	private DelayQueue<DelayElement> delayQueue = null;
	private String customerName;
	public DelayElementCustomer(String customerName,DelayQueue<DelayElement> delayQueue){
		this.delayQueue = delayQueue;
		this.customerName = customerName;
	}
	
	@Override
	public void run() {
		while(true){
			try {
				DelayElement ele = delayQueue.take();
				System.out.println("Thread "+this.customerName+" take delayElement "+ele.name);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
class DelayElement implements Delayed{
	public long delayTime = 0L;
	public String name ;
	
	public DelayElement(long delayTime,String name){
		this.delayTime = delayTime;
		this.name = name;
	}
	
	@Override
	public long getDelay(TimeUnit unit) {//unit： TimeUnit.NANOSECONDS
		long delay = unit.convert(this.delayTime-System.currentTimeMillis(), TimeUnit.MILLISECONDS);//MILLISECONDS--> NONOSECONDS
		System.out.println(this.name+"delay long:"+delay);
		return delay;
	}

	@Override
	public int compareTo(Delayed obj) {
		DelayElement other = (DelayElement)obj;
		if(this.delayTime < other.delayTime){
			return -1;
		}else if(this.delayTime>other.delayTime){
			return 1;
		}
		return 0;
	}
	
}
