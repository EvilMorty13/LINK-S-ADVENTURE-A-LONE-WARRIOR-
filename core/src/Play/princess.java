package Play;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class princess {
    Animation princessCry;
    float cryTime;
    float princessX,princessY;
    public princess(float princessX,float princessY){
        this.princessX=princessX;
        this.princessY=princessY;
        TextureRegion[][] tempCry = TextureRegion.split(new Texture("Princess_Crying.png"),100,100);
        TextureRegion[] cryArray = new TextureRegion[6];
        int index=0;
        for(int i=0;i<3;i++){
            for(int j=0;j<2;j++){
                cryArray[index++]=tempCry[i][j];
            }
        }
        princessCry=new Animation(1f,cryArray);
    }
    public void update(float time,float x,float y){
        cryTime+=time;
        princessX=x;
        princessY=y;
    }
    public void render(SpriteBatch batch){
        batch.draw((TextureRegion) princessCry.getKeyFrame(cryTime,true),princessX,princessY);
    }
}
