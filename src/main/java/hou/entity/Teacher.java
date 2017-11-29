package hou.entity;

/**
 * @author houweitao
 * @date 2016年4月25日 上午11:54:10
 */

public class Teacher {
	private Student student;

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Teacher: " + student;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
}
