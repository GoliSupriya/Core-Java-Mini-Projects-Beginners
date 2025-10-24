import java.util.Timer;
import java.util.TimerTask;
import java.util.Scanner;

public class CountDownTimer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of seconds for the countdown: ");
        int Inputcount = scanner.nextInt();
        scanner.close();
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            int count = Inputcount;

            @Override
            public void run() {
                System.out.println(count);

                count--;
                if (count < 0) {
                    System.out.println("Start studying");
                    timer.cancel();
                }

            }
        };

        timer.scheduleAtFixedRate(task, 0, 1000);
    }
}
