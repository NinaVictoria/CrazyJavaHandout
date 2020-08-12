package com.nina;

/**
 * @author Nina
 * DateTime 2020/8/12 16:03
 * Description 抽象工厂是用户的主入口,易于扩展
 */
public interface CourseFactory {
    INote createNote();

    IVideo createVideo();
}
