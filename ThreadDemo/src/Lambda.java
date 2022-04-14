public class Lambda {


        public static void main(String[] args) {
            Ilike like = new Ilike() {
                @Override
                public void lambda() {

                }
            };
        like = () -> {
            System.out.println("THis is a raining day!");
        };

    }
}

interface Ilike {
    void lambda();
}


