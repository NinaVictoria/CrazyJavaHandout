package com.nina;

/**
 * @author Nina
 * DateTime 2020/8/12 16:08
 * Description
 */
public class Test {
    public static void main(String[] args) {
        CourseFactory factory = new JavaCourseFactory();
        factory.createNote().edit();
        factory.createVideo().record();

        factory = new PythonCourseFactory();
        factory.createNote().edit();
        factory.createVideo().record();

    }
}
