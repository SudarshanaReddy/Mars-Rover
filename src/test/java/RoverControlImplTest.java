import instructionimpl.RoverControlImpl;
import lombok.experimental.StandardException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import plateau.Plateau;
import position.Position;
import position.RoverPosition;


public class RoverControlImplTest {

    final static Plateau plateau = new Plateau();
    final RoverPosition roverPosition = new RoverPosition();
    final RoverControlImpl roverControl = new RoverControlImpl();

    @BeforeClass
    public static void setPlateau() {
        final Position plateauCoordinates = new Position();
        plateauCoordinates.setX(5);
        plateauCoordinates.setY(5);
        plateau.setPosition(plateauCoordinates);
    }

    @Test
    public void isRoverInsidePlateauTest() {
        setRoverPosition(5,5, "N");
        Assert.assertEquals(true,roverControl.isValidMove(plateau,roverPosition));
    }

    @Test
    public void isRoverOutsidePlateauTest() {
        setRoverPosition(6,6, "N");
        Assert.assertEquals(false,roverControl.isValidMove(plateau,roverPosition));
    }

    /**
     * mover rover to north from current position
     * @throws Exception
     */
    @Test
    public void moveRoverNorth() throws Exception {
        setRoverPosition(0,0,TestConstants.NORTH);
        roverControl.move(plateau,roverPosition);
        Assert.assertEquals(0,roverPosition.getPosition().getX());
        Assert.assertEquals(1,roverPosition.getPosition().getY());
        Assert.assertEquals(TestConstants.NORTH,roverPosition.getDirection());
    }

    /**
     * mover rover to south from current position
     * @throws Exception
     */
    @Test
    public void moveRoverSouth() throws Exception {
        setRoverPosition(1,2,TestConstants.SOUTH);
        roverControl.move(plateau,roverPosition);
        Assert.assertEquals(1,roverPosition.getPosition().getX());
        Assert.assertEquals(1,roverPosition.getPosition().getY());
        Assert.assertEquals(TestConstants.SOUTH,roverPosition.getDirection());
    }

    /**
     * mover rover to east from current position
     * @throws Exception
     */
    @Test
    public void moveRoverEast() throws Exception {
        setRoverPosition(3,4,TestConstants.EAST);
        roverControl.move(plateau,roverPosition);
        Assert.assertEquals(4,roverPosition.getPosition().getX());
        Assert.assertEquals(4,roverPosition.getPosition().getY());
        Assert.assertEquals(TestConstants.EAST,roverPosition.getDirection());
    }

    /**
     * mover rover to east from current position
     * @throws Exception
     */
    @Test
    public void moveRoverWest() throws Exception {
        setRoverPosition(3,4,TestConstants.WEST);
        roverControl.move(plateau,roverPosition);
        Assert.assertEquals(2,roverPosition.getPosition().getX());
        Assert.assertEquals(4,roverPosition.getPosition().getY());
        Assert.assertEquals(TestConstants.WEST,roverPosition.getDirection());
    }

    /**
     * turn rover left of north from current position
     * @throws Exception
     */
    @Test
    public void turnRoverLeftToNorth() throws Exception {
        setRoverPosition(3,4,TestConstants.NORTH);
        roverControl.turn(plateau,roverPosition,TestConstants.LEFT.charAt(0));
        Assert.assertEquals(3,roverPosition.getPosition().getX());
        Assert.assertEquals(4,roverPosition.getPosition().getY());
        Assert.assertEquals(TestConstants.WEST,roverPosition.getDirection());
    }

    /**
     * turn rover right of north from current position
     * @throws Exception
     */
    @Test
    public void turnRoverRightToNorth() throws Exception {
        setRoverPosition(3,4,TestConstants.NORTH);
        roverControl.turn(plateau,roverPosition,TestConstants.RIGHT.charAt(0));
        Assert.assertEquals(3,roverPosition.getPosition().getX());
        Assert.assertEquals(4,roverPosition.getPosition().getY());
        Assert.assertEquals(TestConstants.EAST,roverPosition.getDirection());
    }

    /**
     * turn rover left of south from current position
     * @throws Exception
     */
    @Test
    public void turnRoverLeftToSouth() throws Exception {
        setRoverPosition(3,4,TestConstants.SOUTH);
        roverControl.turn(plateau,roverPosition,TestConstants.LEFT.charAt(0));
        Assert.assertEquals(3,roverPosition.getPosition().getX());
        Assert.assertEquals(4,roverPosition.getPosition().getY());
        Assert.assertEquals(TestConstants.EAST,roverPosition.getDirection());
    }

    /**
     * turn rover right of south from current position
     * @throws Exception
     */
    @Test
    public void turnRoverRightToSouth() throws Exception {
        setRoverPosition(3,4,TestConstants.SOUTH);
        roverControl.turn(plateau,roverPosition,TestConstants.RIGHT.charAt(0));
        Assert.assertEquals(3,roverPosition.getPosition().getX());
        Assert.assertEquals(4,roverPosition.getPosition().getY());
        Assert.assertEquals(TestConstants.WEST,roverPosition.getDirection());
    }

    /**
     * turn rover left of east from current position
     * @throws Exception
     */
    @Test
    public void turnRoverLeftToEast() throws Exception {
        setRoverPosition(3,4,TestConstants.EAST);
        roverControl.turn(plateau,roverPosition,TestConstants.LEFT.charAt(0));
        Assert.assertEquals(3,roverPosition.getPosition().getX());
        Assert.assertEquals(4,roverPosition.getPosition().getY());
        Assert.assertEquals(TestConstants.NORTH,roverPosition.getDirection());
    }

    /**
     * turn rover right of east from current position
     * @throws Exception
     */
    @Test
    public void turnRoverRightToEast() throws Exception {
        setRoverPosition(3,4,TestConstants.EAST);
        roverControl.turn(plateau,roverPosition,TestConstants.RIGHT.charAt(0));
        Assert.assertEquals(3,roverPosition.getPosition().getX());
        Assert.assertEquals(4,roverPosition.getPosition().getY());
        Assert.assertEquals(TestConstants.SOUTH,roverPosition.getDirection());
    }

    /**
     * turn rover left of west from current position
     * @throws Exception
     */
    @Test
    public void turnRoverLeftToWest() throws Exception {
        setRoverPosition(3,4,TestConstants.WEST);
        roverControl.turn(plateau,roverPosition,TestConstants.LEFT.charAt(0));
        Assert.assertEquals(3,roverPosition.getPosition().getX());
        Assert.assertEquals(4,roverPosition.getPosition().getY());
        Assert.assertEquals(TestConstants.SOUTH,roverPosition.getDirection());
    }

    /**
     * turn rover left of west from current position
     * @throws Exception
     */
    @Test
    public void turnRoverRightToWest() throws Exception {
        setRoverPosition(3,4,TestConstants.WEST);
        roverControl.turn(plateau,roverPosition,TestConstants.RIGHT.charAt(0));
        Assert.assertEquals(3,roverPosition.getPosition().getX());
        Assert.assertEquals(4,roverPosition.getPosition().getY());
        Assert.assertEquals(TestConstants.NORTH,roverPosition.getDirection());
    }

    /**
     * test exception in case of invalid move
     * @throws Exception
     */
    @Test(expected = Exception.class)
    public void inValidMove() throws Exception {
        setRoverPosition(-1,-1,TestConstants.WEST);
        roverControl.move(plateau,roverPosition);
    }

    /**
     * test exception in case of invalid move
     * @throws Exception
     */
    @Test(expected = Exception.class)
    public void inValidTurn() throws Exception {
        setRoverPosition(0,-1,TestConstants.WEST);
        roverControl.move(plateau,roverPosition);
    }


    private void setRoverPosition(int x ,int y, String direction){
        final Position roverCoordinates = new Position();
        roverCoordinates.setX(x);
        roverCoordinates.setY(y);
        roverPosition.setPosition(roverCoordinates);
        roverPosition.setDirection(direction);
    }
}
