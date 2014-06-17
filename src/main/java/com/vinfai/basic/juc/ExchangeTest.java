package com.vinfai.basic.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExchangeTest {

	public static void main(String[] args) {
		Exchanger<List<String>> exchanger = new Exchanger<List<String>>();
		List<String> produceList = new ArrayList<String>();
		List<String> customList = new ArrayList<String>();
		ExecutorService service = Executors.newFixedThreadPool(2);
		service.execute(new ExchangeProducer(produceList, exchanger));
		service.execute(new ExchangeCustomer(customList, exchanger));
		
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		service.shutdown();
	}
}

class ExchangeProducer implements Runnable{
	
	private List<String> data;
	private Exchanger<List<String>> exchanger;
	
	public ExchangeProducer(List<String> data,Exchanger<List<String>> exchg){
		this.data = data;
		this.exchanger = exchg;
	}

	@Override
	public void run() {
		//cycle 循环
		int cycle = 2;
		for(int i=0;i<cycle;i++){
			System.out.printf("produce cycle times %d\n", i);
			//每次exchanger数据
			for(int j=0;j<5;j++){
				String _data = new Random().nextInt()*1000+"";
				System.out.println("produce data:"+_data+" in cycle "+i);
				data.add(_data);
			}
			try {
				exchanger.exchange(data);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("data list size after exchange:"+data.size());
		}
	}
}

class ExchangeCustomer implements Runnable{
	private List<String> data;
	private Exchanger<List<String>> exchanger;
	public ExchangeCustomer(List<String> data,Exchanger<List<String>> exchg){
		this.data = data;
		this.exchanger = exchg;
	}
	@Override
	public void run() {
		int cycle = 2;
		for(int i=0;i<cycle;i++){
			System.out.println("customer. current cycle "+i);
			try {
				data = exchanger.exchange(data);
				System.out.println("exchange data now.");
				for(int j=0;j<data.size();j++){
					System.out.println("custom data "+data.get(j)+" in cycle "+i);
				}
				data.clear();//清空数据
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}