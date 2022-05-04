package EnemyMovement;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class enemiesHorizontalMovement {
    public float posX,posY;
    public float limX1,limX2;
    Animation rightMoves;
    Animation leftMoves;
    float movementTime;
    boolean rightSide=true;
    boolean leftSide=false;
    public enemiesHorizontalMovement(float posX,float posY,float limX1,float limX2){
        this.posX=posX;
        this.posY=posY;
        this.limX1=limX1;
        this.limX2=limX2;
        TextureRegion[][] tempLeftToRight = TextureRegion.split(new Texture("Enemy_Movement_Right.png"),100,100);
        TextureRegion[][] tempRightToLeft = TextureRegion.split(new Texture("Enemy_Movement_Left.png"),100,100);
        TextureRegion[] LeftToRightArray = new TextureRegion[4];
        TextureRegion[] RightToLeftArray = new TextureRegion[4];
        int indx=0;
        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                LeftToRightArray[indx]=tempLeftToRight[i][j];
                RightToLeftArray[indx]=tempRightToLeft[i][j];
                indx++;
            }
        }
        rightMoves = new Animation(0.8f,LeftToRightArray);
        leftMoves = new Animation(0.8f,RightToLeftArray);
    }
    public void update(float time){
        movementTime+=time;
        if(rightSide){
            posX+=1.5;
            if(posX>=limX2){
                rightSide=false;
                leftSide=true;
            }
        }
        else if(leftSide){
            posX-=1.5;
            if(posX<=limX1){
                leftSide=false;
                rightSide=true;
            }
        }
    }
    public void render(SpriteBatch batch){
        if(rightSide) batch.draw((TextureRegion) rightMoves.getKeyFrame(movementTime,true),posX,posY);
        else if(leftSide) batch.draw((TextureRegion) leftMoves.getKeyFrame(movementTime,true),posX,posY);
    }
}
