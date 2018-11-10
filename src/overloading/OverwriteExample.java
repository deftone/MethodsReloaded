package overloading;

import java.util.Arrays;
import java.util.List;

public class OverwriteExample {

    public static void main(String[] args) {
        List<Starship> ships = Arrays.asList(new Starship(), new KlingonShip(), new BirdOfPrey());

        for (Starship ship : ships) {
            System.out.println(ship.getType());
        }
    }

}


class Starship {
    /**
     * gets type of a star ship.
     *
     * @return name of type
     */
    String getType() {
        return "starship";
    }
}

class KlingonShip extends Starship {
    /**
     * {@inheritDoc}
     *
     * @return Klingon Ship
     */
    @Override
    String getType() {
        return super.getType() + " > battleship";
    }
}

class BirdOfPrey extends KlingonShip {
    /**
     * @return Bird of Prey
     */
    @Override
    String getType() {
        return super.getType() + " > Bird of Prey";
    }
}