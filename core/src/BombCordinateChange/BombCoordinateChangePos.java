package BombCordinateChange;

import java.util.ArrayList;
import BombAnimation.*;

public class BombCoordinateChangePos {
    public void change(ArrayList<Bomb> bombs){
        for(Bomb b : bombs){
            b.x-=4;
        }
    }
}
