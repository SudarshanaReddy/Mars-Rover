import instructionimpl.RoverControl;
import instructionimpl.RoverControlImpl;
import parser.FileUtility;
import plateau.Plateau;
import position.RoverInstruction;
import position.RoverPosition;

import java.util.ArrayList;
import java.util.List;

public class MarsRover extends FileUtility {

    private static Plateau plateau = new Plateau();
    private static List<RoverInstruction> roverInstructionList = new ArrayList<>();

    private static RoverControl roverControl = new RoverControlImpl();

    public static void main(String[] args) throws Exception {
        readFile(plateau, roverInstructionList);
        for (RoverInstruction roverInstruction : roverInstructionList) {
            process(roverInstruction);
        }
    }

    /**
     * This method is to process the each instruction
     * @param roverInstruction
     * @throws Exception
     */
    private static void process(final RoverInstruction roverInstruction) throws Exception {
        try {
            final RoverPosition roverPosition = roverInstruction.getRoverPosition();
            final String instruction = roverInstruction.getRoverInstruction();
            for(int i=0;i<instruction.length();i++) {
                if(roverInstruction.getRoverInstruction().charAt(i) == 'L') {
                    roverControl.turn(plateau,roverPosition, roverInstruction.getRoverInstruction().charAt(i));
                } else if(roverInstruction.getRoverInstruction().charAt(i) == 'R') {
                    roverControl.turn(plateau,roverPosition, roverInstruction.getRoverInstruction().charAt(i));
                } else {
                    roverControl.move(plateau,roverInstruction.getRoverPosition());
                }
            }
            System.out.println(roverPosition.toString());
        }catch (Exception exception) {
            throw new Exception("Failed to instruct rover:"+exception.getMessage());
        }

    }
}
