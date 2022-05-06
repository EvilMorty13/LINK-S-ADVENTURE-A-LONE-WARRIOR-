package BombCounter;

import java.util.ArrayList;

public class bombList {
    ArrayList<showBomb> bombs = new ArrayList<>();
    public ArrayList<showBomb> get(){
        bombs.add(new showBomb(1,-30,-15));
        bombs.add(new showBomb(2,0,-15));
        bombs.add(new showBomb(3,30,-15));
        bombs.add(new showBomb(4,60,-15));
        bombs.add(new showBomb(5,90,-15));
        return bombs;
    }
}
