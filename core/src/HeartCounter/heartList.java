package HeartCounter;

import java.util.ArrayList;

public class heartList {
    ArrayList<showHeart> hearts = new ArrayList<>();
    public ArrayList<showHeart> get(){
        hearts.add(new showHeart(1,1180,0));
        hearts.add(new showHeart(2,1210,0));
        hearts.add(new showHeart(3,1240,0));
        return hearts;
    }
}
