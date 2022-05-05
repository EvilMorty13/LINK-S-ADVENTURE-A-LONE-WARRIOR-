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
    Animation rightSword;
    Animation leftSword;
    Animation upSword;
    Animation downSword;
    float movementTime;
    float HeroX,HeroY;
    boolean movement=true;
    boolean rightSide=true;
    boolean leftSide=false;
    boolean attack=false,rightAttack=false,leftAttack=false,upAttack=false,downAttack=false;
    public enemiesHorizontalMovement(float posX,float posY,float limX1,float limX2){
        this.posX=posX;
        this.posY=posY;
        this.limX1=limX1;
        this.limX2=limX2;
        TextureRegion[][] tempLeftToRight = TextureRegion.split(new Texture("Enemy_Movement_Right.png"),100,100);
        TextureRegion[][] tempRightToLeft = TextureRegion.split(new Texture("Enemy_Movement_Left.png"),100,100);
        TextureRegion[][] tempRightSword = TextureRegion.split(new Texture("Enemy_Sword_Right.png"),100,100);
        TextureRegion[][] tempLeftSword = TextureRegion.split(new Texture("Enemy_Sword_Left.png"),100,100);
        TextureRegion[][] tempDownSword = TextureRegion.split(new Texture("Enemy_Sword_Down.png"),100,100);
        TextureRegion[][] tempUpSword = TextureRegion.split(new Texture("Enemy_Sword_Up.png"),100,100);

        TextureRegion[] LeftToRightArray = new TextureRegion[4];
        TextureRegion[] RightToLeftArray = new TextureRegion[4];
        TextureRegion[] RightSwordArray = new TextureRegion[5];
        TextureRegion[] LeftSwordArray = new TextureRegion[5];
        TextureRegion[] UpSwordArray = new TextureRegion[5];
        TextureRegion[] DownSwordArray = new TextureRegion[4];

        int indx=0;
        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                LeftToRightArray[indx]=tempLeftToRight[i][j];
                RightToLeftArray[indx]=tempRightToLeft[i][j];
                RightSwordArray[indx]=tempRightSword[i][j];
                LeftSwordArray[indx]=tempLeftSword[i][j];
                UpSwordArray[indx]=tempUpSword[i][j];
                DownSwordArray[indx]=tempDownSword[i][j];
                indx++;
            }
        }
        RightSwordArray[indx]=tempRightSword[2][0];
        LeftSwordArray[indx]=tempLeftSword[2][0];
        UpSwordArray[indx]=tempUpSword[2][0];

        rightMoves = new Animation(0.8f,LeftToRightArray);
        leftMoves = new Animation(0.8f,RightToLeftArray);
        rightSword = new Animation(0.8f,RightSwordArray);
        leftSword = new Animation(0.8f,LeftSwordArray);
        upSword = new Animation(0.8f,UpSwordArray);
        downSword = new Animation(0.8f,DownSwordArray);
    }
    public void update(float time,float HeroX,float HeroY){
        movementTime+=time;
        this.HeroX=HeroX;
        this.HeroY=HeroY;
        float rangeX1=posX-42,rangeX2=posX+42,rangeY1=posY-38,rangeY2=posY+38;
        if(HeroX>=posX-25 && HeroX<=posX+25){
            if(HeroY>posY+10 && HeroY<=rangeY2){
                movement=false;
                attack=true;
                rightAttack=false;
                leftAttack=false;
                upAttack=true;
                downAttack=false;

            }
            else if(HeroY<posY && HeroY>=rangeY1){
                movement=false;
                attack=true;
                rightAttack=false;
                leftAttack=false;
                upAttack=false;
                downAttack=true;
            }
            else{
                movement = true;
                attack = false;
                rightAttack = false;
                leftAttack = false;
                upAttack = false;
                downAttack = false;
            }
        }
        else if(HeroY>=posY-25 && HeroY<=posY+25){
            if(HeroX>posX && HeroX<=rangeX2){
                movement=false;
                attack=true;
                rightAttack=true;
                leftAttack=false;
                upAttack=false;
                downAttack=false;
            }
            else if(HeroX>=rangeX1 && HeroX<posX){
                movement=false;
                attack=true;
                rightAttack=false;
                leftAttack=true;
                upAttack=false;
                downAttack=false;
            }
            else{
                movement = true;
                attack = false;
                rightAttack = false;
                leftAttack = false;
                upAttack = false;
                downAttack = false;
            }
        }
        else{
            movement=true;
            attack=false;
            rightAttack = false;
            leftAttack = false;
            upAttack = false;
            downAttack = false;
        }

        if(movement) {
            if (rightSide) {
                posX += 1.5;
                if (posX >= limX2) {
                    rightSide = false;
                    leftSide = true;
                }
            } else if (leftSide) {
                posX -= 1.5;
                if (posX <= limX1) {
                    leftSide = false;
                    rightSide = true;
                }
            }
        }
    }
    public void render(SpriteBatch batch){
        if(movement){
            if(rightSide) batch.draw((TextureRegion) rightMoves.getKeyFrame(movementTime,true),posX,posY);
            else if(leftSide) batch.draw((TextureRegion) leftMoves.getKeyFrame(movementTime,true),posX,posY);
        }
        else if(attack){
            if(rightAttack){
                rightSide=true;
                leftSide=false;
                batch.draw((TextureRegion) rightSword.getKeyFrame(movementTime,true),posX,posY);
            }
            else if(leftAttack){
                leftSide=true;
                rightSide=false;
                batch.draw((TextureRegion) leftSword.getKeyFrame(movementTime,true),posX,posY);
            }
            else if(upAttack) batch.draw((TextureRegion) upSword.getKeyFrame(movementTime,true),posX,posY);
            else if(downAttack) batch.draw((TextureRegion) downSword.getKeyFrame(movementTime,true),posX,posY);
        }

    }
}
