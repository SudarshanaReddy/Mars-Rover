package position;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoverInstruction {
    private RoverPosition roverPosition;
    private String roverInstruction;
}
