package Play;

import Sound.SoundManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import Sound.*;
public class smoke {
    Animation smokeAnimation;
    float smokeTime;
    public float x,y;
    public boolean done=false;
    public smoke(float x,float y){
        this.x=x;
        this.y=y;
        TextureRegion[][] tempSmoke = TextureRegion.split(new Texture("Smoke/Smoke.png"),100,100);
        TextureRegion[] smokeArray = new TextureRegion[6];
        int index=0;
        for(int i=0;i<3;i++){
            for(int j=0;j<2;j++){
                smokeArray[index++]=tempSmoke[i][j];
            }
        }
        smokeAnimation=new Animation(1f,smokeArray);
    }
    public void update(float time){
        smokeTime+=time;
        if(smokeAnimation.isAnimationFinished(smokeTime)) done=true;
    }
    public void render(SpriteBatch batch){
        batch.draw((TextureRegion) smokeAnimation.getKeyFrame(smokeTime,true),x,y);
    }
}
