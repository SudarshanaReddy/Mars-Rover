package plateau;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import position.Position;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Plateau {

    private Position position = new Position();

    public void Plateau(final Position position) {
        this.position = position;
    }
}
