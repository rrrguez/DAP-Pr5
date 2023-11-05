package pr5.state_pattern.state;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public abstract class TrafficLightState {
    private int duration;

    public TrafficLightState(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public abstract TrafficLightState nextState();

    public abstract String getImagePath();

    public abstract void playSound();

    protected void playSoundFile(String soundFilePath) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundFilePath).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
