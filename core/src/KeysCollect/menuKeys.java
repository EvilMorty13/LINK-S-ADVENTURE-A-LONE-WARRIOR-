package KeysCollect;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class menuKeys {
    Texture img;
    public float x,y;
    public menuKeys(float x,float y){
        this.x=x;
        this.y=y;
        img = new Texture("Icon/Key_Icon.png");
    }
    public void render(SpriteBatch batch){
        batch.draw(img,x,y);
    }
}
