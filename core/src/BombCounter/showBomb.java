package BombCounter;
import Play.*;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class showBomb {
    public int index;
    Texture bombImg;
    float x,y;
    public showBomb(int index,float x,float y){
        this.index=index;
        this.x=x;
        this.y=y;
        bombImg = new Texture("Icon/Bomb_Icon.png");
    }
    public void render(SpriteBatch batch){
        batch.draw(bombImg,x,y);
    }
}
