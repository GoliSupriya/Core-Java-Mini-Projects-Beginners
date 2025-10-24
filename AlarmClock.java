import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import java.time.*;
import java.io.File;
import java.io.IOException;

public class AlarmClock {
    public static void main(String[] args) {

        // Java alarm clock
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime alarmtime = null;
        String filepath = "C:\\Users\\91801\\Downloads\\Hi Nanna.wav";

        while (alarmtime == null) {

            try {

                System.out.print("enter an alarm time(HH:mm:ss): ");
                String inputTime = scanner.nextLine();

                alarmtime = LocalTime.parse(inputTime, formatter);
                System.out.println("Alarm set for " + alarmtime);

            } catch (DateTimeParseException e) {
                System.out.println("Invalid format please use HH:mm:ss");
            }

        }

        Alarm alarm = new Alarm(alarmtime, filepath, scanner);
        Thread alarmthread = new Thread(alarm);
        alarmthread.start();

    }
}

class Alarm implements Runnable {

    private final LocalTime alarmTime;
    private final String filepath1;
    private final Scanner scanner;

    Alarm(LocalTime alarmTime, String filepath1, Scanner scanner) {
        this.alarmTime = alarmTime;
        this.filepath1 = filepath1;
        this.scanner = scanner;
    }

    @Override
    public void run() {

        while (LocalTime.now().isBefore(alarmTime)) {

            try {
                Thread.sleep(1000);

                int hours = LocalTime.now().getHour();
                int minutes = LocalTime.now().getMinute();
                int seconds = LocalTime.now().getSecond();

                System.out.printf("\r%02d:%02d:%02d", hours, minutes, seconds);
            } catch (InterruptedException e) {
                System.out.println("Thread was interrrupted");
            }

        }

        System.out.println("\n*Alarm noises*");
        playSound(filepath1);
    }

    private void playSound(String filepath1) {
        File audio = new File(filepath1);

        try (AudioInputStream audiostream = AudioSystem.getAudioInputStream(audio)) {
            Clip clip = AudioSystem.getClip();
            clip.open(audiostream);
            clip.start();
            System.out.println("press enter to stop the alarm");
            scanner.nextLine();
            clip.stop();
            scanner.close();

        } catch (UnsupportedAudioFileException e) {
            System.out.println("Audio file is not supported");
        } catch (LineUnavailableException e) {
            System.out.println("Audio unavailable");
        } catch (IOException e) {
            System.out.println("Error reading file");
        }

    }
}
