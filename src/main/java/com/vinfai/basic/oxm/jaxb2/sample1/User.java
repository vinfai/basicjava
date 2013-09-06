package com.vinfai.basic.oxm.jaxb2.sample1;

import java.util.Date;
import java.util.Map;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.vinfai.basic.oxm.jaxb2.sample1.adpater.MapConvertorAdpter;
import com.vinfai.basic.oxm.jaxb2.sample1.adpater.MyDateForamt;

//@XmlType(propOrder={"name","id","birthday"})
@XmlRootElement(namespace="http://www.vinfai.cn",name="user")
public class User {
	
	private Long id;
	
	private Date birthday;
	
	private String name;
	
	private Map<String, MyAdress> roleMap;
	
	@XmlAttribute
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@XmlElement(name="firstName",required=true)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@XmlJavaTypeAdapter(MyDateForamt.class)
	//@XmlElement
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String toString(){
		return id+" # "+name+"#"+birthday;
	}

	@XmlJavaTypeAdapter(MapConvertorAdpter.class)
	public Map<String, MyAdress> getRoleMap() {
		return roleMap;
	}

	public void setRoleMap(Map<String, MyAdress> roleMap) {
		this.roleMap = roleMap;
	}
	
}
