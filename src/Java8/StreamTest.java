package Java8;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
        List<OnlieClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlieClass(1, "spring boot", true));
        springClasses.add(new OnlieClass(2, "spring data jpa", true));
        springClasses.add(new OnlieClass(3, "spring mvc", false));
        springClasses.add(new OnlieClass(4, "spring core", false));
        springClasses.add(new OnlieClass(5, "rest api development", false));

        List<OnlieClass> javaClasses = new ArrayList<>();
        javaClasses.add(new OnlieClass(6, "The Java", true));
        javaClasses.add(new OnlieClass(7, "The Java, Code manipulation", true));
        javaClasses.add(new OnlieClass(8, "The Java, 8 to 11", false));

        List<List<OnlieClass>> keesunEvents = new ArrayList<>();
        keesunEvents.add(springClasses);
        keesunEvents.add(javaClasses);

        System.out.println("spring으로 시작하는 수업");
        springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .forEach(oc -> System.out.println(oc.getId()));

        System.out.println("close되지 않는 수업");
        springClasses.stream()
                .filter(Predicate.not(OnlieClass::isClosed))
                .forEach(System.out::println);

        System.out.println("수업 이름만 모아서 스트림 만들기");
        springClasses.stream()
                .map(oc -> oc.getTitle())
                .forEach(System.out::println);
        System.out.println("두 수업 목록에 들어있는 모든 수업 아이디 출력");
        keesunEvents.stream().flatMap(Collection::stream)
                        .forEach(oc -> System.out.println(oc.getId()));
        System.out.println("10부터 1씩 증가하는무제한 스트림 중에서 앞에 10 개 빼고 최대 10개 까지만");
        Stream.iterate(10, i -> i+1).skip(0).limit(10).forEach(System.out::println);
        System.out.println("자바 수업 중에 Test가 들어있는 수업이 있는지 확인");
        System.out.println(javaClasses.stream().anyMatch(oc -> oc.getTitle().contains("Test")));
        System.out.println("스프링 수업 중에 제목에 spring이 들어간 것만 모아서 List로 만들기(filter를 먼저 수행)");
        List<String> list = springClasses.stream().filter(oc -> oc.getTitle().contains("spring"))
                .map(OnlieClass::getTitle).collect(Collectors.toList());
        list.forEach(System.out::println);
        System.out.println("map을 먼저 수행");
        List<String> list2 = springClasses.stream().map(OnlieClass::getTitle)
                .filter(oc -> oc.contains("spring"))
                .collect(Collectors.toList());
        list2.forEach(System.out::println);


    }
}
