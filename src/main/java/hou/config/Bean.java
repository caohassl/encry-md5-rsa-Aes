package hou.config;

import java.util.ArrayList;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年4月25日 上午11:51:52
 */

public class Bean {
	private String name;
	private String className;
	private String scope = "singleton";
	private List<Property> properties = new ArrayList<Property>();

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Bean:  name:" + name + ", className:" + className + " scope:" + scope + " props:" + properties;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public List<Property> getProperties() {
		return properties;
	}

	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}

}
