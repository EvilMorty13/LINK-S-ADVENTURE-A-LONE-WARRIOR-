package HeartCounter;

import java.util.ArrayList;

public class heartList {
    ArrayList<showHeart> hearts = new ArrayList<>();
    public ArrayList<showHeart> get(){
        hearts.add(new showHeart(1,10,680));
        hearts.add(new showHeart(2,40,680));
        hearts.add(new showHeart(3,70,680));
        return hearts;
    }
}
