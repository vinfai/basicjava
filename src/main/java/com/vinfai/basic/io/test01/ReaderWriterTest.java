package com.vinfai.basic.io.test01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.Comparator;

public class ReaderWriterTest {
	
	public static void main(String[] args) {
		String basepath = "E:/gitrepository/basicjava/src/main/resources/";
		FileInputStream fis = null;
		FileOutputStream fos = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		String inencode = "GBK";
		String outdecode = "UTF-8";
		try {
			 fis = new FileInputStream(new File(basepath+"io_test01_source.txt"));
			 br = new BufferedReader(new InputStreamReader(fis,inencode));
			 fos = new FileOutputStream(new File(basepath+"io_test01_target.txt"));
			 bw = new BufferedWriter(new OutputStreamWriter(fos,outdecode));
			String temp = null;
			while((temp=br.readLine())!=null){
				bw.write(temp);
				bw.newLine();
			}
			bw.flush();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			if(br!=null){
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(fos!=null){
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			/*Collections.sort(null, new Comparator(Object o1,Object o2) {
				@Override
				public int compare(Object o1, Object o2) {
					return 0;
				}
				
			});*/
		}
	}
	
}
