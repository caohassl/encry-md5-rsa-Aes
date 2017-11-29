package hou.config;

/**
 * @author houweitao
 * @date 2016年4月25日 上午11:54:59
 */

public class Property {
	private String name;
	private String value;
	private String ref;

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Property: name:" + name + ", value:" + value + ", ref:" + ref;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

}
