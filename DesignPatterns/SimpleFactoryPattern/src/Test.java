/**
 * @author Nina
 * DateTime 2020/8/12 15:37
 * Description
 */
public class Test {
    public static void main(String[] args) {
        CourseFactory courseFactory = new CourseFactory();
        ICourse javaCourse = courseFactory.create(JavaCourse.class);
        javaCourse.record();
        ICourse pythonCourse = courseFactory.create(PythonCourse.class);
        pythonCourse.record();
    }
}
