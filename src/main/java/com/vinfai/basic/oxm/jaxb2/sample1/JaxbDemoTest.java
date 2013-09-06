package com.vinfai.basic.oxm.jaxb2.sample1;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
/**
 * http://www.cnblogs.com/hoojo/archive/2011/04/26/2029011.html
 * http://blog.csdn.net/kongxx/article/details/7544640
 * @author vinfai
 *
 */
public class JaxbDemoTest {
	static String outFile = "F:\\user.xml";
	public static void main(String args[]){
		try {
			Class[] clazz = new Class[]{User.class,Town.class,MyAdress.class};
			JAXBContext jc  = JAXBContext.newInstance(clazz);
			Marshaller marshaller = jc.createMarshaller();
			
			//Object to xml
			User user = new User();
			user.setId(1L);
			user.setName("JACK");
			user.setBirthday(new Date());
			Map<String, MyAdress> map = new HashMap<String, MyAdress>();
			MyAdress ad = new MyAdress("city", "province", "town");
			map.put("myaddress", ad);
			map.put("myaddress2", ad);
			user.setRoleMap(map);
			User user2 = new User();
			user2.setId(2L);
			user2.setName("JACK2");
			user2.setBirthday(new Date());
			user2.setRoleMap(map);
			List<User> ls = new ArrayList<User>();
			ls.add(user);
			ls.add(user2);
			Town t = new Town();
			t.setName("adfasdf");
			t.setLocation("aaaa location");
			t.setUserList(ls);
			
			
			
			
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "vv");
			marshaller.marshal(t,new File(outFile));
			
			//xml to obj
//			Unmarshaller unmarshaller = jc.createUnmarshaller();
//			User user4 = (User)unmarshaller.unmarshal(new File(outFile));
//			System.out.println(user2);
			
			Unmarshaller  unmarshaller  = jc.createUnmarshaller();
			Town _t = (Town)unmarshaller.unmarshal(new File(outFile));
			System.out.println(_t.toString());
			
			
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
	}

}
