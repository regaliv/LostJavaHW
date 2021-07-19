public class Main {

    static boolean isRandomInt;

    public static void main(String[] args) {


            double random = Math.random();
            random *= 1000001;
            int randomInt = (int) random;
        System.out.println("Это число нужно угадать "+randomInt);




        Thread timer = new Thread(new Runnable() {
            public void run() {
                try {
                    int i = 0;

                    while(!isRandomInt) {


                        System.out.println(i);
                        ++i;
                        Thread.sleep(1000L);
                    }
                } catch (Exception ignored) {
                }
            }
        });
        timer.start();

        Thread timer2 = new Thread(new Runnable() {
            public void run() {
                try {


                    while(!isRandomInt) {
                        double random = Math.random();
                        random *= 1000001;
                        int randomInt2 = (int) random;
                        System.out.println("Случайное сисло "+randomInt2);
                        if (randomInt2==randomInt){
                            isRandomInt=true;
                            System.out.println("Вот это число "+ randomInt);
                        }

                        Thread.sleep(1000L);
                    }
                } catch (Exception ignored) {
                }
            }
        });
        timer2.start();
    }
}