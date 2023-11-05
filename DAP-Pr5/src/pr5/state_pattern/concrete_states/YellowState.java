package pr5.state_pattern.concrete_states;

import pr5.state_pattern.state.TrafficLightState;

class YellowState extends TrafficLightState {
    public YellowState() {
        super(3);
    }

    @Override
    public TrafficLightState nextState() {
        return new GreenState();
    }

    @Override
    public String getImagePath() {
        return "images/yellow.png";
    }

    @Override
    public void playSound() {
        playSoundFile("sounds/yellow.wav");
    }
}
