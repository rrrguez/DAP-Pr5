package pr5.state_pattern.concrete_states;

import pr5.state_pattern.state.TrafficLightState;

public class RedState extends TrafficLightState {
    public RedState() {
        super(10);
    }

    @Override
    public TrafficLightState nextState() {
        return new YellowState();
    }

    @Override
    public String getImagePath() {
        return "images/red.png";
    }

    @Override
    public void playSound() {
        playSoundFile("sounds/red.wav");
    }
}
