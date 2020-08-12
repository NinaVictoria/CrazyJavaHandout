/**
 * @author Nina
 * DateTime 2020/8/12 15:33
 * Description 工厂类，用于创建ICourse对象
 */
public class CourseFactory {
    public ICourse create(Class<? extends ICourse> clazz) {
        try {
            if (null != clazz) {
                return clazz.getConstructor().newInstance();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
