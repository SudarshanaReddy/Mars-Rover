package instructionimpl;

import constants.MarsConstants;
import plateau.Plateau;
import position.RoverPosition;

public class RoverControlImpl implements RoverControl {

    /**
     * This method is to rotate the rover 90 degrees based on the moveDirection
     * @param plateau
     * @param roverPosition
     * @param moveDirection
     * @throws Exception
     */
    @Override
    public void turn(Plateau plateau, RoverPosition roverPosition, Character moveDirection) throws Exception {
        if(isValidMove(plateau,roverPosition)) {
            rotateRover(roverPosition, moveDirection.toString());
        } else {
            throw new Exception("invalid move");
        }
    }

    /**
     *
     * @param plateau
     * @param roverPosition
     */
    @Override
    public void move(Plateau plateau, RoverPosition roverPosition) throws Exception {
        if(isValidMove(plateau, roverPosition)) {
            if(roverPosition.getDirection().equals(MarsConstants.NORTH)) {
                setRoverPosition(roverPosition.getPosition().getX(),roverPosition.getPosition().getY()+1,roverPosition.getDirection(), roverPosition);
            } else if(roverPosition.getDirection().equals(MarsConstants.EAST)) {
                setRoverPosition(roverPosition.getPosition().getX()+1,roverPosition.getPosition().getY(),roverPosition.getDirection(), roverPosition);
            } else if(roverPosition.getDirection().equals(MarsConstants.WEST)) {
                setRoverPosition(roverPosition.getPosition().getX()-1,roverPosition.getPosition().getY(),roverPosition.getDirection(), roverPosition);
            } else if(roverPosition.getDirection().equals(MarsConstants.SOUTH)) {
                setRoverPosition(roverPosition.getPosition().getX(),roverPosition.getPosition().getY()-1,roverPosition.getDirection(), roverPosition);
            }
        } else {
            throw new Exception("Failed to move the rover");
        }

    }

    /**
     * This method is to determine the whether the move is valid or ont
     * @param plateau
     * @param roverPosition
     * @return
     */
    @Override
    public boolean isValidMove(Plateau plateau, RoverPosition roverPosition) {
        if((roverPosition.getPosition().getX() >=0 && roverPosition.getPosition().getY() >=0) &&
           (roverPosition.getPosition().getX()<=plateau.getPosition().getX() &&
                   roverPosition.getPosition().getY()<=plateau.getPosition().getY())) {
            return true;
        }
        return false;
    }

    /**
     * This method is a helper method to move the rover from current position to either Left or Right
     * @param roverPosition
     * @param moveDirection
     * @throws Exception
     */
    private void rotateRover(final RoverPosition roverPosition, final String moveDirection) throws Exception {
        if(moveDirection.equals(MarsConstants.LEFT)){
            if(roverPosition.getDirection().equals(MarsConstants.NORTH)) {
                //left north => west
                roverPosition.setDirection(MarsConstants.WEST);
            } else if(roverPosition.getDirection().equals(MarsConstants.EAST)) {
                //left east => north
                roverPosition.setDirection(MarsConstants.NORTH);
            } else if(roverPosition.getDirection().equals(MarsConstants.SOUTH)) {
                //left south => east
                roverPosition.setDirection(MarsConstants.EAST);
            } else if(roverPosition.getDirection().equals(MarsConstants.WEST)) {
                //left west => south
                roverPosition.setDirection(MarsConstants.SOUTH);
            }
        } else if(moveDirection.equals(MarsConstants.RIGHT)) {
            if(roverPosition.getDirection().equals(MarsConstants.NORTH)) {
                //right north => east
                roverPosition.setDirection(MarsConstants.EAST);
            } else if(roverPosition.getDirection().equals(MarsConstants.EAST)) {
                //right east => south
                roverPosition.setDirection(MarsConstants.SOUTH);
            } else if(roverPosition.getDirection().equals(MarsConstants.SOUTH)){
                //right south => west
                roverPosition.setDirection(MarsConstants.WEST);
            } else if(roverPosition.getDirection().equals(MarsConstants.WEST)){
                //right west => north
                roverPosition.setDirection(MarsConstants.NORTH);
            }
        }
    }

    /**
     * This method is to set the to the rover to new coordinates
     * @param x
     * @param y
     * @param direction
     * @param roverPosition
     */
    private void setRoverPosition(int x, int y, String direction, final RoverPosition roverPosition) {
        roverPosition.getPosition().setX(x);
        roverPosition.getPosition().setY(y);
        roverPosition.setDirection(direction);
    }
}
