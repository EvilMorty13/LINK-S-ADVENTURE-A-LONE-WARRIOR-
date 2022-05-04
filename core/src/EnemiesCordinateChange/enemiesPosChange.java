package EnemiesCordinateChange;

import java.util.ArrayList;
import EnemyMovement.*;

public class enemiesPosChange {
    public void change(ArrayList<enemiesHorizontalMovement> enemies){
        for(enemiesHorizontalMovement en : enemies){
            en.posX-=4;
            en.limX1-=4;
            en.limX2-=4;
        }
    }
    public void change2(ArrayList<enemiesVerticalMovement> enemies){
        for(enemiesVerticalMovement en : enemies){
            en.posX-=4;
        }
    }
}
