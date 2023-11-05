package pr5.state_pattern.context;

import pr5.state_pattern.state.TrafficLightState;
import pr5.state_pattern.concrete_states.RedState;

public class TrafficLight {
    private TrafficLightState currentState;

    public TrafficLight() {
        currentState = new RedState();
    }

    public TrafficLightState getCurrentState() {
        return currentState;
    }

    public void changeState() {
        currentState = currentState.nextState();
    }
}
