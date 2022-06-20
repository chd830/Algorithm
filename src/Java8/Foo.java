package Java8;

import java.util.*;
import java.util.stream.Collectors;

public class Foo {
    public static void main(String[] args) {
//////        // 익명 내부 클래스.
//////        Stream.RunSomething runSomething = new Stream.RunSomething() {
//////            @Override
//////            public void doIt() {
//////                System.out.println("HELLO");
//////            }
//////        };
//////
//////        // 인터페이스의 추상메소드가하나일 때 람다 형태로 변환
//////        Stream.RunSomething runSomething1 = () -> System.out.println("HELLO");
//////
//////        // 두 줄 이상일 때 {} 사용
//////        Stream.RunSomething runSomething2 = () -> {
//////            System.out.println("HELLO");
//////            System.out.println("LAMBDA");
//////        };
////
////        Stream.RunSomething run = (number) -> number + 10;
////
////        // 입력받은 값이 동일 할 때 결과 값도 동일해야 함
////        System.out.println(run.doIt(10));
////        System.out.println(run.doIt(10));
////        System.out.println(run.doIt(10));
////        System.out.println(run.doIt(10));
////        System.out.println(run.doIt(10));
////
////
////        // 외부에 있는 값을 변경하려고 하는 경우 퓨어한 함수가 아님. 상태 값에 의존하기 때문.
////        // 하지만 참조만하는 경우 final이라가정하고 진행함(람다 캡처링)
////        Stream.RunSomething run1 = new Stream.RunSomething() {
////            int baseNumber = 10;
////            @Override
////            public int doIt(int number) {
////                // 문법적으로는가능하지만 퓨어한 함수라고 할 수 없음
////                baseNumber++;
////
////                return number + baseNumber;
////            }
////        };
////
//
////        Stream.Plus10 plus10 = new Stream.Plus10();
////        System.out.println(plus10.apply(1));
////
////        Function<Integer, Integer> plusTen = a -> a+10;
////        System.out.println(plusTen.apply(1));
////
////        // andThen, compose를 함수 조합하는데 사용할 수 있음
////        Function<Integer, Integer> multiply2 = i -> 2*i;
////
////        // multiply2를 한 뒤 plus10을 진행하겠다.
////        plus10.compose(multiply2);
////        Function<Integer, Integer> multiply2AndPlus10 = plus10.compose(multiply2);
////        System.out.println(multiply2AndPlus10.apply(2));
////
////        // plus10을 한 후 multiply2를 진행하겠다.
////        plus10.andThen(multiply2);
////        Function<Integer, Integer> plus10AndMultiply2 = plus10.andThen(multiply2);
////        System.out.println(plus10AndMultiply2.apply(2));
//
////        Consumer<Integer> printT = i -> System.out.println(i);
////        printT.accept(10);
////
////        // T를반환함
////        Supplier<Integer> get10 = () -> 10;
////        System.out.println(get10.get());
////
////        // 인자를 받아서 true, false를 리턴
////        Predicate<String> startsWith = (s) -> s.startsWith("chong");
////        Predicate<Integer> isOdd = (num) -> num%2 == 1;
////
////        // 입력값과 반환값이 같을 때 Function대신 UnaryOperator를 사용할 수 있다.
////        UnaryOperator<Integer> plus10 = i -> i+10;
//
////        Stream.Plus10 plus10 = new Stream.Plus10;
////        System.out.println(plus10.apply(1));
//
////        Function<Integer, Integer> plus10 = (number) -> number+10;
////        Function<Integer, Integer> multiply = i -> i*2;
////        System.out.println(plus10.apply(1));
////        System.out.println(multiply.apply(1));
////
////        // *2 + 10
////        plus10.compose(multiply);
////        // +10 *2
////        plus10.andThen(multiply);
//
////        Supplier<Integer> get10 = () -> 10;
//        // 동일하게 동작. 왜 BiFunction만 Integer가 세개여야할까?
//        BiFunction<Integer, Integer, Integer> get10_1 = (a, b) -> a+b;
//        BinaryOperator<Integer> get10_2 = (Integer a, Integer b) -> a+b;
//        BinaryOperator<Integer> get10_3 = (a, b) -> a+b;
//
//    }
//    // 람다캡처링. 로컬 변수를 캡처(그대로 사용하는 것이 아니라 복사하여)하여 사용
//    public void run() {
//        int baseNumber = 10;
//
//        // 로컬 클래스
//        class LocalClass {
//            void printBaseNumber() {
//                int baseNumber = 11;
//                System.out.println(baseNumber);
//            }
//        }
//        // 익명 클래스
//        Consumer<Integer> integerConsumer = new Consumer<Integer>() {
//            @Override
//            public void accept(Integer integer) {
//                int baseNumber = 11;
//                System.out.println(baseNumber);
//            }
//        };
//        // 람다
//        IntConsumer printInt = (i) -> {
//            System.out.println(i+baseNumber);
//        };
//
//        // 람다만 Shadowing이 되지 않는다.람다 내에서 baseNumber라는 변수를 정의할 수 없다.
//        // 람다에서 지역변수를 사용하게 되면 그 값을 바꿀 수 없다 - Effective final. final은 아니지만 final처럼 사용됨.

        List<String> name = new ArrayList<>();
        name.add("keesun");
        name.add("whiteship");
        name.add("toby");
        name.add("foo");

        // 중개형 오퍼레이터는 종료 오퍼레이션이 오기전까지 진행되지 않음. lazy하게 처리됨
//        name.stream().map(s -> {
//            System.out.println(s);
//            return s.toUpperCase();
//        }).collect(Collectors.toList());
        System.out.println("=================");
//        name.forEach(System.out::println);
//        Spliterator<String> spliterator = name.spliterator();
//        Spliterator<String> spliterator1 = spliterator.trySplit();
//        while(spliterator.tryAdvance(System.out::println));
//        System.out.println("==========");
//        while(spliterator1.tryAdvance(System.out::println));
//
//        long k = name.stream().map(String::toUpperCase)
//                .filter(s -> s.startsWith("K"))
//                .count();
//        System.out.println(k);
//
//        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
//        name.sort(compareToIgnoreCase.reversed());
//        name.forEach(System.out::println);

//        Arrays.stream(new String[]{"c", "python", "java"})
//                .filter(word -> {
//                    System.out.println("Call filter method: " + word);
//                    return word.length() > 3;
//                })
//                .map(word -> {
//                    System.out.println("Call map method: " + word);
//                    return word.substring(0, 3);
//                }).findFirst();
        List<String> collect = name.parallelStream().map((s) -> {
            return s.toUpperCase();
        }).collect(Collectors.toList());
        collect.forEach(System.out::println);


    }
}
