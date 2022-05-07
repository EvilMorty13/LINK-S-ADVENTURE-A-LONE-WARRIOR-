package BombCounter;

import java.util.ArrayList;

public class bombList {
    ArrayList<showBomb> bombs = new ArrayList<>();
    public ArrayList<showBomb> get(){
        bombs.add(new showBomb(1,-30,-25));
        bombs.add(new showBomb(2,0,-25));
        bombs.add(new showBomb(3,30,-25));
        bombs.add(new showBomb(4,60,-25));
        bombs.add(new showBomb(5,90,-25));
        return bombs;
    }
}
