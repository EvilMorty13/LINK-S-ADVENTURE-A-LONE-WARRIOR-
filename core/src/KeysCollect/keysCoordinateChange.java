package KeysCollect;

import java.util.ArrayList;

public class keysCoordinateChange {
    public void posChange(ArrayList<showKeys> keys){
        for(showKeys k : keys){
            k.x-=4;
        }
    }
    public void negChange(ArrayList<showKeys> keys){
        for(showKeys k : keys){
            k.x+=4;
        }
    }
}
