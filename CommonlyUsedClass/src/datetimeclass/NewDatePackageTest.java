package datetimeclass;

import java.time.*;

/**
 * @author Nina
 * DateTime 2020/7/25 17:10
 * Description Java 8 add a new package: java.time
 */
public class NewDatePackageTest {
    public static void main(String[] args) {
        //===Clock===
        //获取当前Clock
        Clock clock = Clock.systemUTC();
        System.out.println("当前时刻为:" + clock.instant());
        //获取clock对应的毫秒数
        System.out.println(clock.millis());
        System.out.println(System.currentTimeMillis());

        //===Duration===
        Duration duration = Duration.ofSeconds(6000);
        System.out.println("6000秒相当于:" + duration.toMinutes() + "分钟");
        System.out.println("6000秒相当于:" + duration.toHours() + "小时");
        System.out.println("6000秒相当于:" + duration.toDays() + "天");
        //在Clock的基础上加6000秒，返回新的clock
        Clock clock1 = Clock.offset(clock, duration);
        System.out.println("当前时间加上6000秒为:" + clock1.instant());

        //===Instant===
        Instant instant = Instant.now();
        System.out.println(instant);
        //instant加6000秒，返回新的instant
        Instant instant1 = instant.plusSeconds(6000);
        System.out.println(instant1);
        //根据字符串解析Instant对象
        Instant instant2 = Instant.parse("2020-02-23T10:12:35.235Z");
        System.out.println(instant2);
        //在instant2的基础上增加5小时4分钟
        Instant instant3 = instant2.plus(Duration.ofHours(5).plusMinutes(4));
        System.out.println(instant3);
        //获取instant35天前的时刻
        Instant instant4 = instant3.minus(Duration.ofDays(5));
        System.out.println(instant4);

        //===LocalDate===
        //获取当前日期
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        //获取2014年的第146天
        localDate = LocalDate.ofYearDay(2014, 146);
        System.out.println(localDate);
        //设置为2014年5月21日
        localDate = LocalDate.of(2014, Month.MAY, 21);
        System.out.println(localDate);

        //===LocalTime
        //获取当前时间
        LocalTime localTime = LocalTime.now();
        //设置为22时33分
        localTime = LocalTime.of(22, 33);
        System.out.println(localTime);
        //返回一天中的第5503秒
        localTime = LocalTime.ofSecondOfDay(5503);
        System.out.println(localTime);

        //===LocalDateTime===
        //获取当前日期时间
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        //当前日期加上25小时3分钟‘
        LocalDateTime future = localDateTime.plusHours(25).plusMinutes(3);
        System.out.println(future);

        //===Year,YearMonth,MonthDay===
        Year year = Year.now();
        System.out.println("当前年份：" + year);
        year = year.plusYears(5);
        System.out.println("再过五年是：" + year);
        //更具指定月份获取YearMonth
        YearMonth yearMonth = year.atMonth(10);
        System.out.println(yearMonth);
        //当前年月再加5年减3个月
        yearMonth = yearMonth.plusYears(5).plusMonths(3);
        System.out.println(yearMonth);
        //获取月日
        MonthDay monthDay = MonthDay.now();
        System.out.println(monthDay);
        //设置为5月21日
        MonthDay monthDay1 = monthDay.with(Month.MAY).withDayOfMonth(23);
        System.out.println(monthDay1);

    }
}
