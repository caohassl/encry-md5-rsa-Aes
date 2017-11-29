package hou;

import org.junit.Test;

import hou.entity.Person;
import hou.entity.Student;
import hou.main.BeanFactory;
import hou.main.ClassPathXmlApplicationContext;

/**
 * @author houweitao
 * @date 2016年4月25日 上午11:58:05
 * @Source http://www.cnblogs.com/fingerboy/p/5425813.html
 */

public class TestBean {

	@Test
	public void func1() {

		BeanFactory bf = new ClassPathXmlApplicationContext("/applicationContext.xml");
		Person s = (Person) bf.getBean("person");
		Person s1 = (Person) bf.getBean("person");
		System.out.println(s.equals(s1) );
		System.out.println(s1);
		Student stu1 = (Student) bf.getBean("student");
		Student stu2 = (Student) bf.getBean("student");
		String name = stu1.getName();
		System.out.println(name);
		System.out.println(stu1 == stu2);
	}

	@Test
	public void allBeans() {
		ClassPathXmlApplicationContext cl = new ClassPathXmlApplicationContext("/applicationContext.xml");
		cl.showDatil();
	}
}
