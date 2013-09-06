package com.vinfai.basic.oxm.jaxb2.sample1.adpater;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import com.vinfai.basic.oxm.jaxb2.sample1.MyAdress;

public class MapConvertorAdpter extends XmlAdapter<MyElement[], Map<String,MyAdress>>{

	@Override
	public MyElement[] marshal(Map<String, MyAdress> map) throws Exception {
		MyElement[] els= new MyElement[map.entrySet().size()];
		int k = 0 ;
		for(Map.Entry<String, MyAdress> ad : map.entrySet()){
			MyElement e = new MyElement(ad.getKey(),ad.getValue());
			els[k] = e;
			k++;
		}
		return els;
	}

	@Override
	public Map<String, MyAdress> unmarshal(MyElement[] elements) throws Exception {
		Map<String,MyAdress> map  = new HashMap<String, MyAdress>();
		for(MyElement e : elements){
			map.put(e.getKey(), (MyAdress)e.getValue());
		}
		return null;
	}
	
	
}
