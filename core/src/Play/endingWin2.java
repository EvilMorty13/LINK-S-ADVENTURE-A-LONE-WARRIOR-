package Play;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class endingWin2 {
    float showTime;
    Animation dialogue2;
    float x=800,y=-15;
    public endingWin2(){
        TextureRegion[][] tempDialogue2 = TextureRegion.split(new Texture("continue.png"),500,100);
        TextureRegion[] dialogueArray2 = new TextureRegion[15];
        for(int i=0;i<15;i++){
            dialogueArray2[i]=tempDialogue2[i][0];
        }
        dialogue2=new Animation(2.5f,dialogueArray2);
    }
    public void update(float time){
        showTime+=time;
    }
    public void render(SpriteBatch batch){
        batch.draw((TextureRegion) dialogue2.getKeyFrame(showTime,false),x,y);
    }
}
