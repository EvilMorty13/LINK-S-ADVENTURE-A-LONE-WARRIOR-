package EnemyDeath;

import java.util.ArrayList;

public class soulCoordinateChange {
    public void posChange(ArrayList<Death> deaths){
        for(Death d : deaths){
            d.x-=4;
        }
    }
    public void negChange(ArrayList<Death> deaths){
        for(Death d : deaths){
            d.x+=4;
        }
    }
}
