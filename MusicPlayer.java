import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sound.sampled.Clip;

public class MusicPlayer {
    public static void main(String[] args) {
        System.out.println("Welcome to the Music Player!");
        String filepath = "C:\\Users\\91801\\Downloads\\Hi Nanna.wav";
        File file = new File(filepath);

        try (AudioInputStream audioStream = AudioSystem.getAudioInputStream(file)) {
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();

            System.out.println("Playing music... Press Enter to stop.");
            System.in.read(); // keeps the program running while music plays
            clip.close();

        } catch (UnsupportedAudioFileException e) {
            System.out.println("The specified audio file is not supported: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("An error occurred while trying to play the music file: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}
