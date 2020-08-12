package com.nina;

/**
 * @author Nina
 * DateTime 2020/8/12 15:47
 * Description
 */
public class JavaCourseFactory implements ICourseFactory{
    @Override
    public ICourse create() {
        return new JavaCourse();
    }
}
