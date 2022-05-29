package parser;

import constants.MarsConstants;
import plateau.Plateau;
import position.Position;
import position.RoverInstruction;
import position.RoverPosition;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

public class FileUtility {
    public static void readFile(Plateau plateau, List<RoverInstruction> roverInstructionArrayList) throws Exception {
        try{
            ClassLoader classLoader = FileUtility.class.getClassLoader();
            File file = new File(classLoader.getResource(MarsConstants.FILE_NAME).getFile());
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = bufferedReader.readLine();
            String[] plateauCoordinates = line.split("\\s+");
            Position position = null;
            RoverPosition roverPosition = null;
            RoverInstruction roverInstruction = new RoverInstruction();
            plateau.getPosition().setX(Integer.parseInt(line.split("\\s+")[0]));
            plateau.getPosition().setY(Integer.parseInt(line.split("\\s+")[1]));
            while (line!=null) {
                line = bufferedReader.readLine();
                if(line!=null && !line.contains(MarsConstants.LEFT) && !line.contains(MarsConstants.RIGHT) && !line.contains(MarsConstants.MOVE)) {
                    position = new Position(Integer.parseInt(line.split("\\s+")[0]),
                            Integer.parseInt(line.split("\\s+")[1]));
                    roverPosition = new RoverPosition(position, line.split("\\s+")[2]);
                    roverInstruction.setRoverPosition(roverPosition);
                } else if(line!=null) {
                    roverInstruction.setRoverInstruction(line);
                    roverInstructionArrayList.add(roverInstruction);
                    roverInstruction = new RoverInstruction();
                }
            }
        } catch (Exception exception) {
            throw new Exception("Failed to read file");
        }

    }
}
