public class TestLambda {


    public static void main(String[] args) {
        Ilove aa = i -> System.out.println("I love ----- > " + i);
        aa.love(3);
    }

}

interface Ilove {
    void love(int i);
}

//匿名内部类
//    public static void main(String[] args) {
//        Ilove aa = new Ilove() {
//            @Override
//            public void love(int i) {
//                System.out.println("I love ----- > " + i);
//            }
//        };
//        aa.love(3);
//    }
//
//}
