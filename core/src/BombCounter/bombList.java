package BombCounter;

import java.util.ArrayList;

public class bombList {
    ArrayList<showBomb> bombs = new ArrayList<>();
    public ArrayList<showBomb> get(){
        bombs.add(new showBomb(1,-30,615));
        bombs.add(new showBomb(2,0,615));
        bombs.add(new showBomb(3,30,615));
        bombs.add(new showBomb(4,60,615));
        bombs.add(new showBomb(5,90,615));
        return bombs;
    }
}
