package com.nina;

/**
 * @author Nina
 * DateTime 2020/8/12 15:49
 * Description
 */
public class Test {
    public static void main(String[] args) {
        ICourseFactory factory = new PythonCourseFactory();
        ICourse course = factory.create();
        course.record();

        factory = new JavaCourseFactory();
        course = factory.create();
        course.record();
    }

}
