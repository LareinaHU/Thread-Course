import java.text.SimpleDateFormat;
import java.util.Date;

public class testDateSleep {
    public static void main(String[] args) throws InterruptedException {
        Date date = new Date(System.currentTimeMillis());
        while(true){
            try {
                Thread.sleep(1000);
                System.out.println(new SimpleDateFormat("HH:MM:SS").format(date));
                date = new Date(System.currentTimeMillis());
            }catch (InterruptedException e){
                e.printStackTrace();
            }


        }
    }
}
