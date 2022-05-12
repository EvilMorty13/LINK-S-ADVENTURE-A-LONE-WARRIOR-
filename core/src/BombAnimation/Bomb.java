package BombAnimation;

import Sound.SoundManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import Sound.*;
import Play.smoke;

public class Bomb {
    public float x;
    public float y;
    public Animation bomb=null;
    public Animation smokeAnimation;
    public static final int damageLimit=100;
    float blastTime;
    public boolean remove=false;
    public Bomb(float x,float y){
        this.x=x;
        this.y=y;
        TextureRegion[][] tempBomb = TextureRegion.split(new Texture("Bomb/Bomb.png"),100,100);
        TextureRegion[] tempArr = new TextureRegion[4];
        int indx=0;
        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                tempArr[indx++]=tempBomb[i][j];
            }
        }
        bomb = new Animation(1f,tempArr);
        smokeAnimation = new smoke().smokeAnimation;
    }
    public void update(float time){
        blastTime+=time;
        if(bomb.isAnimationFinished(blastTime)){
            SoundManager.BombBlow.play();
            //SoundManager.BombBlow.dispose();
            remove=true;
        }
    }
    public void render(SpriteBatch batch){
        batch.draw((TextureRegion) bomb.getKeyFrame(blastTime,true),x,y);
        batch.draw((TextureRegion) smokeAnimation.getKeyFrame(blastTime,true),x,y);
    }
}
