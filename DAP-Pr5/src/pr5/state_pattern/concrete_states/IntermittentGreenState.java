package pr5.state_pattern.concrete_states;

import pr5.state_pattern.state.TrafficLightState;

class IntermittentGreenState extends TrafficLightState {
    public IntermittentGreenState() {
        super(3);
    }

    @Override
    public TrafficLightState nextState() {
        return new RedState();
    }

    @Override
    public String getImagePath() {
        return "images/intermittent_green.gif";
    }

    @Override
    public void playSound() {
        playSoundFile("sounds/intermittent_green.wav");
    }
}
