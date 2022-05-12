package EnemyDeath;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Death {
    public float x,y;
    public Animation deathAnimation;
    float showTime;
    public boolean remove = false;
    public Death(float x,float y){
        this.x=x;
        this.y=y;
        TextureRegion[][] tempDeath = TextureRegion.split(new Texture("EnemySoul/Spirit.png"),100,100);
        TextureRegion[] deathArray = new TextureRegion[6];
        int index=0;
        for(int i=0;i<3;i++){
            for(int j=0;j<2;j++){
                deathArray[index++]=tempDeath[i][j];
            }
        }
        deathAnimation = new Animation(1f,deathArray);
    }
    public void update(float time){
        showTime+=time;
        if(deathAnimation.isAnimationFinished(showTime)) remove=true;
    }
    public void render(SpriteBatch batch){
        batch.draw((TextureRegion) deathAnimation.getKeyFrame(showTime,true),x,y);
    }
}
