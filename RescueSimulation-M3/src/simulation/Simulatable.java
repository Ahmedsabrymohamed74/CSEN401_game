package simulation;

import exceptions.IncompatibleTargetException;

public interface Simulatable {
public void cycleStep() throws IncompatibleTargetException;
}
