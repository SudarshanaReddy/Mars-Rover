package instructionimpl;

import plateau.Plateau;
import position.RoverPosition;

public interface RoverControl {
    void turn(final Plateau plateau, final RoverPosition roverPosition, final Character moveDirection) throws Exception;
    void move(final Plateau plateau, final RoverPosition roverPosition) throws Exception;
    boolean isValidMove(final Plateau plateau, final RoverPosition roverPosition);
}
