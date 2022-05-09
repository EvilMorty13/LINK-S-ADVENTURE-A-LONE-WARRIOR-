package KeysCollect;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class showKeys {
    public float x,y;
    public int index;
    float showTime;
    Animation key;
    public boolean remove=false;
    public showKeys(int index,float x,float y){
        this.index=index;
        this.x=x;
        this.y=y;
        TextureRegion[][] tempKeys = TextureRegion.split(new Texture("Key/Key.png"),100,100);
        TextureRegion[] keysArrays = new TextureRegion[10];
        int indx=0;
        for(int i=0;i<5;i++){
            for(int j=0;j<2;j++){
                keysArrays[indx++]=tempKeys[i][j];
            }
        }
        key = new Animation(1f,keysArrays);

    }
    public void update(float time,float HeroX,float HeroY){
        showTime+=time;
        if(x>=HeroX-15 && x<=HeroX+15 && y>=HeroY-15 && y<=HeroY+15) remove=true;
    }
    public void render(SpriteBatch batch){
        batch.draw((TextureRegion) key.getKeyFrame(showTime,true),x,y);
    }
}
