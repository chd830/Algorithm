package Java8;

public class Lambda {
    public static void main(String[] args) {

    }
//    static class Apple {
//        int weight;
//        boolean isRed;
//        Apple(int weight, boolean isRed){
//            this.weight = weight;
//            this.isRed = isRed;
//        }
//
//        @Override
//        public String toString() {
//            return "Apple{" +
//                    "weight=" + weight +
//                    ", isRed=" + isRed +
//                    '}';
//        }
//
//        public int getWeight() {
//            return weight;
//        }
//
//        public void setWeight(int weight) {
//            this.weight = weight;
//        }
//
//        public boolean isRed() {
//            return isRed;
//        }
//
//        public void setRed(boolean red) {
//            isRed = red;
//        }
//    }
//    static List<Apple> list;
//    public static void main(String[] args) {
//        list = new ArrayList<>();
//        list.add(new Apple(150, true));
//        list.add(new Apple(138, true));
//        list.add(new Apple(164, false));
//        list.add(new Apple(122, false));
//        list.add(new Apple(161, true));
//
////        Consumer<Apple> appleConsumer = a -> System.out.println(a.getWeight()+"\t"+a.isRed);
//        Consumer<Apple> appleConsumer = a -> System.out.println("사과의 무게는 "+a.getWeight()+" g이고 색은 "+(a.isRed ? "붉은색" : "초록색") +"이다.");
//        forEach(list, appleConsumer);
//
//        System.out.println("------------------------------------------------");
//        Function<Apple, String> appleFunction = a -> { return a.isRed ? "붉은색" : "초록색"; };
//        for(Apple a : list)
//            System.out.println("사과의 무게는 "+a.getWeight()+"g 이고 색은 "+appleFunction.apply(a)+"이다.");
//        System.out.println("-------------------------------------------------");
//        Predicate<Apple> applePredicate = a -> a.isRed;
//        for(Apple a : list)
//            System.out.println("사과의 무게는 "+a.getWeight()+" g 이고 색은 "+(applePredicate.test(a) ? "붉은색" : "초록색")+"이다.");
//        System.out.println("-------------------------------------------------");
//        Supplier<Apple> appleSupplier = () -> new Apple(123, true);
//        Apple a = appleSupplier.get();
//        System.out.println(a);
//    }
//
//    static <T> void forEach(List<T> list, Function function) {
//        for(T t : list)
//            function.apply(t);
//    }
//    static <T> void forEach(List<T> list, Consumer<T> consumer) {
//        for(T t: list)
//            consumer.accept(t);
//    }
}
