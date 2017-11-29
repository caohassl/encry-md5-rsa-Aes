package hou.entity;

/**
 * @author houweitao
 * @date 2016年4月25日 上午11:54:27
 */

public class Person {
	private Student student;
	private Teacher teacher;

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Person: " + student + ",  " + teacher;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
}
