package EnemyMovement;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class enemiesVerticalMovement {
    public float posX,posY;
    public float limY1,limY2;
    float HeroX,HeroY;
    Animation upMoves=null;
    Animation downMoves=null;
    Animation rightSword;
    Animation leftSword;
    Animation upSword;
    Animation downSword;
    float movementTime;
    boolean movement=true;
    boolean upSide=true;
    boolean downSide=false;
    public int linkAttack=0;
    public boolean remove=false;
    public boolean attack=false,rightAttack=false,leftAttack=false,upAttack=false,downAttack=false;
    public enemiesVerticalMovement(float posX,float posY,float limY1,float limY2){
        this.posX=posX;
        this.posY=posY;
        this.limY1=limY1;
        this.limY2=limY2;
        TextureRegion[][] tempDownToUp = TextureRegion.split(new Texture("Enemy_Movement_Up.png"),100,100);
        TextureRegion[][] tempUpToDown = TextureRegion.split(new Texture("Enemy_Movement_Down.png"),100,100);
        TextureRegion[][] tempRightSword = TextureRegion.split(new Texture("Enemy_Sword_Right.png"),100,100);
        TextureRegion[][] tempLeftSword = TextureRegion.split(new Texture("Enemy_Sword_Left.png"),100,100);
        TextureRegion[][] tempDownSword = TextureRegion.split(new Texture("Enemy_Sword_Down.png"),100,100);
        TextureRegion[][] tempUpSword = TextureRegion.split(new Texture("Enemy_Sword_Up.png"),100,100);

        TextureRegion[] DownToUpArr = new TextureRegion[4];
        TextureRegion[] UpToDownArr = new TextureRegion[4];
        TextureRegion[] RightSwordArray = new TextureRegion[5];
        TextureRegion[] LeftSwordArray = new TextureRegion[5];
        TextureRegion[] UpSwordArray = new TextureRegion[5];
        TextureRegion[] DownSwordArray = new TextureRegion[4];

        int indx=0;
        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                DownToUpArr[indx]=tempDownToUp[i][j];
                UpToDownArr[indx]=tempUpToDown[i][j];
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

        upMoves=new Animation(0.8f,DownToUpArr);
        downMoves=new Animation(0.8f,UpToDownArr);
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
        if(movement){
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
        if(linkAttack>=50){
            remove=true;
            linkAttack=0;
        }
    }
    public void render(SpriteBatch batch){
        if(movement){
            if(upSide) batch.draw((TextureRegion) upMoves.getKeyFrame(movementTime,true),posX,posY);
            else if(downSide) batch.draw((TextureRegion) downMoves.getKeyFrame(movementTime,true),posX,posY);
        }
        else if(attack){
            if(rightAttack) batch.draw((TextureRegion) rightSword.getKeyFrame(movementTime,true),posX,posY);
            else if(leftAttack) batch.draw((TextureRegion) leftSword.getKeyFrame(movementTime,true),posX,posY);
            else if(upAttack){
                upSide=true;
                downSide=false;
                batch.draw((TextureRegion) upSword.getKeyFrame(movementTime,true),posX,posY);
            }
            else if(downAttack){
                downSide=true;
                upSide=false;
                batch.draw((TextureRegion) downSword.getKeyFrame(movementTime,true),posX,posY);
            }
        }
    }
}
