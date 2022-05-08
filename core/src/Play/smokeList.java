package Play;

import java.util.ArrayList;

public class smokeList {
    ArrayList<smoke> sm = new ArrayList<>();
    public ArrayList<smoke> get(){
        sm.add(new smoke(1230,250));
        sm.add(new smoke(1230,220));
        sm.add(new smoke(1230,190));
        sm.add(new smoke(1200,190));
        sm.add(new smoke(1170,190));
        sm.add(new smoke(1140,190));
        sm.add(new smoke(1110,190));
        sm.add(new smoke(1080,190));
        sm.add(new smoke(1050,190));
        sm.add(new smoke(1020,190));
        sm.add(new smoke(990,190));
        sm.add(new smoke(990,220));
        sm.add(new smoke(990,250));
        return sm;
    }
    public void positiveChange(){
        for(smoke s : sm){
            s.x-=4;
        }
    }
    public void negativeChange(){
        for(smoke s : sm){
            s.x+=4;
        }
    }
}
