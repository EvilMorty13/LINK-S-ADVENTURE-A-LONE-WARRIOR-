package HeartCounter;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class showHeart {
    public int index;
    Texture heartImg;
    float x,y;
    public showHeart(int index,float x,float y){
        this.index=index;
        this.x=x;
        this.y=y;
        heartImg=new Texture("Heart.png");
    }
    public void render(SpriteBatch batch){
        batch.draw(heartImg,x,y,30,30);
    }
}
