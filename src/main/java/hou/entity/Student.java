package hou.entity;

/**
 * @author houweitao
 * @date 2016年4月25日 上午11:53:51
 */

public class Student {
	private String name;

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Student: name" + name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
