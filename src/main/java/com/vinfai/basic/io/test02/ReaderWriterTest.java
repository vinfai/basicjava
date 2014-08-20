package com.vinfai.basic.io.test02;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class ReaderWriterTest {
	
	public ReaderWriterTest(){
		System.out.println("ReaderWriterTest");
	}
	public static void main(String[] args) {
		BufferedReader reader = null;
		BufferedWriter writer = null;
		String basepath = "E:/gitrepository/basicjava/src/main/resources/io_test02_source.txt";
		String basepath2 = "E:/gitrepository/basicjava/src/main/resources/io_test02_target.txt";
		try{
			/*TreeMap<Integer, String> map = new TreeMap<Integer, String>(Collections.reverseOrder());
			map.put(237, "#随便啦#237");
			map.put(226, "#刘德华#226");
			map.put(267, "#周杰伦#267");
			map.put(243, "#张信哲#243");
			//map.put(null, "1");*/
//			TreeMap<Integer,String> map = readVal(basepath, "GBK");
			writeVal(basepath2,"GBK",readVal(basepath, "GBK"));
			/*Iterator<Integer> iter = map.keySet().iterator();
			while(iter.hasNext()){
				String t = map.get(iter.next());
				System.out.println(t);
			}*/
//			FilterInputStream
			//BufferedInputStream
//			JMSAppender
//			System.out
		}
		finally{
			if(reader!=null){
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(writer!=null){
				try {
					writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public static TreeMap<Integer,String> readVal(String fileName,String encode){
		int indexVal = Integer.MAX_VALUE;
		BufferedReader br = null;
		TreeMap<Integer,String> map = new TreeMap<Integer, String>(Collections.reverseOrder());
		try {
			 br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),encode));
			 String temp = null;
			 while((temp = br.readLine())!=null){
				String[] vals = temp.split("#");
				int len = vals.length;
				if(vals.length<=2){
					map.put(indexVal, temp);
					continue;
				}
				Integer sum = Integer.valueOf(vals[len-1])+Integer.valueOf(vals[len-2])+Integer.valueOf(vals[len-3]);
				StringBuffer b = new StringBuffer();
				b.append("#");
				for(int i=0;i<vals.length-3;i++){
					b.append(vals[i]);
				}
				b.append("#");
				b.append(sum);
				map.put(sum, b.toString());
			 }
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(br!=null){
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return map;
	}
	
	public static void writeVal(String fileName,String encode,TreeMap<Integer,String> map){
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName),encode));
			Iterator<Entry<Integer, String>> iter = map.entrySet().iterator();
			while(iter.hasNext()){
				Entry<Integer,String> entry = iter.next();
				bw.write(entry.getValue());
				bw.newLine();
			}
			bw.flush();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(bw!=null){
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
}
