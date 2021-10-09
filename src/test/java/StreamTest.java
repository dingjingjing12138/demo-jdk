import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.dingjj.collection.stream.Person;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;

/**
 * @author : dingjj@pingpongx.com
 * @description:
 * @date : 2021/9/17
 */
public class StreamTest {


    @Test
    public void testForEach() {

        List<Integer> list = Arrays.asList(7, 6, 9, 3, 8, 2, 1);

        // 遍历输出符合条件的元素
        list.stream().filter(x -> x > 6).forEach(System.out::println);
        // 匹配第一个
        Optional<Integer> findFirst = list.stream().filter(x -> x > 6).findFirst();

        // 匹配任意（适用于并行流）
        Optional<Integer> findAny = list.parallelStream().filter(x -> x > 6).findAny();
        // 是否包含符合特定条件的元素
        boolean anyMatch = list.stream().anyMatch(x -> x < 6);
        System.out.println("匹配第一个值：" + findFirst.get());
        System.out.println("匹配任意一个值：" + findAny.get());
        System.out.println("是否存在大于6的值：" + anyMatch);
    }

    @Test
    public void testFilter() {
        List<Integer> list = Arrays.asList(6, 7, 3, 8, 1, 2, 9);
        Stream<Integer> stream = list.stream();
        stream.filter(x -> x > 7).forEach(System.out::println);
    }

    @Test
    public void testFilter1() {

        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, 23, "male", "New York"));
        personList.add(new Person("Jack", 7000, 25, "male", "Washington"));
        personList.add(new Person("Lily", 7800, 21, "female", "Washington"));
        personList.add(new Person("Anni", 8200, 24, "female", "New York"));
        personList.add(new Person("Owen", 9500, 25, "male", "New York"));
        personList.add(new Person("Alisa", 7900, 26, "female", "New York"));

        List<String> fiterList = personList.stream().filter(x -> x.getSalary() > 8000).map(Person::getName)
            .collect(Collectors.toList());
        System.out.print("高于8000的员工姓名：" + fiterList);
    }

    @Test
    public void testOptions() {
        String str = "null";
        System.out.println(Optional.ofNullable(str).orElse("a"));
    }

    @Test
    public void compareDate() {

    }

    public static void main(String[] args) {

        String expireDate = "2020-11-09";
        System.out.println(calculateDate(expireDate));
    }

    private static final String LONG_TERM = "长期";

    private static String calculateDate(String expireDate) {

        if (LONG_TERM.equals(expireDate)) {
            return LONG_TERM;
        }
        LocalDate now = LocalDate.now();
        if (expireDate.length() == 10) {
            DateTimeFormatter sdf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate expiringDate = LocalDate.parse(expireDate, sdf);
            if (now.isAfter(expiringDate)) {
                System.out.println("证件过期。。。");
                return null;
            }
        } else {
            String[] split = expireDate.split("-");
            LocalDate specialDate = LocalDate
                .of(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));
            if (now.isAfter(specialDate)) {
                System.out.println("证件过期。。。");
                return null;
            }
        }
        return expireDate;
    }

    @Test
    public void testTime() {
        long expireAt = System.currentTimeMillis() + 9000 * 1000;
        Date date = new Date(expireAt);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        System.out.println(simpleDateFormat.format(date));
        LambdaQueryWrapper<String> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(String::length, 12);
        wrapper.like(String::getBytes,99);
    }
}
