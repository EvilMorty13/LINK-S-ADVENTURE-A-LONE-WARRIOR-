package KeysCollect;

import java.util.ArrayList;

public class keysList {
    ArrayList<showKeys> keys = new ArrayList<>();
    public ArrayList<showKeys> get(){
        keys.add(new showKeys(1,358,538));
        keys.add(new showKeys(2,502,178));
        keys.add(new showKeys(3,1706,122));
        return keys;
    }
}
