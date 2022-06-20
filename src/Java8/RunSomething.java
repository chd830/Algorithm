package Java8;// 추상메소드가 하나만 있기 때문에 함수형 인터페이스.
// static이나 default는 추상메소드가 아님

// 자바에서 제공해주는 어노테이션 위반하지 않으면 아무 에러가 생기지 않는다.
@FunctionalInterface
public interface RunSomething {

//    abstract void doIt();
    abstract int doIt(int number);

    static void printName() {
        System.out.println("MY NAME");
    }
    default void printAge() {
        System.out.println("MY AGE");
    }
}
