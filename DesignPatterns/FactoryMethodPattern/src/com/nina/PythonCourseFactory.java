package com.nina;

/**
 * @author Nina
 * DateTime 2020/8/12 15:48
 * Description
 */
public class PythonCourseFactory implements ICourseFactory{
    @Override
    public ICourse create() {
        return new PythonCourse();
    }
}
