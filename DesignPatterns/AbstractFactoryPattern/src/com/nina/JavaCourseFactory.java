package com.nina;

/**
 * @author Nina
 * DateTime 2020/8/12 16:07
 * Description
 */
public class JavaCourseFactory implements CourseFactory {
    @Override
    public INote createNote() {
        return new JavaNote();
    }

    @Override
    public IVideo createVideo() {
        return new JavaVideo();
    }
}
