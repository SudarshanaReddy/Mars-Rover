package position;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoverPosition {
    private Position position = new Position();
    private String direction;

    @Override
    public String toString() {
        return position.getX() + " " + position.getY() + " " + direction;
    }
}
