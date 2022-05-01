package BombCordinateChange;

import java.util.ArrayList;
import BombAnimation.*;

public class BombCoordinateChangeNeg {
    public void change(ArrayList<Bomb> bombs){
        for(Bomb b : bombs){
            b.x+=4;
        }
    }
}
