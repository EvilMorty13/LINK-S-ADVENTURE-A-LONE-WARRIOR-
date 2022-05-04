package EnemyMovement;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class enemiesVerticalMovement {
    public float posX,posY;
    public float limY1,limY2;
    Animation upMovement=null;
    Animation downMovement=null;
    float movementTime;
    boolean upSide=true;
    boolean downSide=false;
    public enemiesVerticalMovement(float posX,float posY,float limY1,float limY2){
        this.posX=posX;
        this.posY=posY;
        this.limY1=limY1;
        this.limY2=limY2;
        TextureRegion[][] tempDownToUp = TextureRegion.split(new Texture("Enemy_Movement_Up.png"),100,100);
        TextureRegion[][] tempUpToDown = TextureRegion.split(new Texture("Enemy_Movement_Down.png"),100,100);
        TextureRegion[] DownToUpArr = new TextureRegion[4];
        TextureRegion[] UpToDownArr = new TextureRegion[4];
        int indx=0;
        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                DownToUpArr[indx]=tempDownToUp[i][j];
                UpToDownArr[indx]=tempUpToDown[i][j];
                indx++;
            }
        }
        upMovement=new Animation(0.8f,DownToUpArr);
        downMovement=new Animation(0.8f,UpToDownArr);
    }
    public void update(float time){
        movementTime+=time;
        if(upSide){
            posY+=1.5;
            if(posY>=limY2){
                upSide=false;
                downSide=true;
            }
        }else if(downSide){
            posY-=1.5;
            if(posY<=limY1){
                upSide=true;
                downSide=false;
            }
        }
    }
    public void render(SpriteBatch batch){
        if(upSide) batch.draw((TextureRegion) upMovement.getKeyFrame(movementTime,true),posX,posY);
        else if(downSide) batch.draw((TextureRegion) downMovement.getKeyFrame(movementTime,true),posX,posY);
    }
}
