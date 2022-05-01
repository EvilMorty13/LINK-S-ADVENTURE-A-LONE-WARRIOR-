package BombAnimation;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Bomb {
    public float x;
    public float y;
    public Animation bomb=null;
    float blastTime;
    public boolean remove=false;
    public Bomb(float x,float y){
        this.x=x;
        this.y=y;
        TextureRegion[][] tempBomb = TextureRegion.split(new Texture("Bomb.png"),100,100);
        TextureRegion[] tempArr = new TextureRegion[5];
        int indx=0;
        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                tempArr[indx++]=tempBomb[i][j];
            }
        }
        tempArr[indx]=tempBomb[2][0];
        bomb = new Animation(1f,tempArr);
    }
    public void update(float time){
        blastTime+=time;
        if(bomb.isAnimationFinished(blastTime)) remove=true;
    }
    public void render(SpriteBatch batch){
        batch.draw((TextureRegion) bomb.getKeyFrame(blastTime,true),x,y);
    }
}
