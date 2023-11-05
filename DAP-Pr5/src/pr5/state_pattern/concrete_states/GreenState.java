package pr5.state_pattern.concrete_states;

import pr5.state_pattern.state.TrafficLightState;

class GreenState extends TrafficLightState {
    public GreenState() {
        super(7);
    }

    @Override
    public TrafficLightState nextState() {
        return new IntermittentGreenState();
    }

    @Override
    public String getImagePath() {
        return "images/green.png";
    }

    @Override
    public void playSound() {
        playSoundFile("sounds/green.wav");
    }
}
