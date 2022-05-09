package HerosAnimation;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class LinksAnimation {
    public Animation RightMovement;
    public Animation LeftMovement;
    public Animation UpMovement;
    public Animation DownMovement;

    public Animation RightSwordMovement;
    public Animation LeftSwordMovement;
    public Animation UpSwordMovement;
    public Animation DownSwordMovement;

    public LinksAnimation(){
        //Character Movement Animation

        TextureRegion[][] tempRight = TextureRegion.split(new Texture("Movement/Movement_Right.png"),100,100);
        TextureRegion[][] tempLeft = TextureRegion.split(new Texture("Movement/Movement_Left.png"),100,100);
        TextureRegion[][] tempDown = TextureRegion.split(new Texture("Movement/Movement_Down.png"),100,100);
        TextureRegion[][] tempUp = TextureRegion.split(new Texture("Movement/Movement_Up.png"),100,100);

        //Character Sword Animation

        TextureRegion[][] tempRightSword = TextureRegion.split(new Texture("Sword/Right_Sword.png"),100,100);
        TextureRegion[][] tempLeftSword = TextureRegion.split(new Texture("Sword/Left_Sword.png"),100,100);
        TextureRegion[][] tempUpSword = TextureRegion.split(new Texture("Sword/Up_Sword.png"),100,100);
        TextureRegion[][] tempDownSword = TextureRegion.split(new Texture("Sword/Down_Sword.png"),100,100);



        TextureRegion[] moveRight = new TextureRegion[6];
        TextureRegion[] moveLeft = new TextureRegion[6];
        TextureRegion[] moveUp = new TextureRegion[8];
        TextureRegion[] moveDown = new TextureRegion[8];

        TextureRegion[] RightSword = new TextureRegion[5];
        TextureRegion[] LeftSword = new TextureRegion[5];
        TextureRegion[] UpSword = new TextureRegion[5];
        TextureRegion[] DownSword = new TextureRegion[6];

        int indx=0;
        for(int i=0;i<3;i++){
            for(int j=0;j<2;j++){
                moveRight[indx]=tempRight[i][j];
                moveLeft[indx]=tempLeft[i][j];

                DownSword[indx]=tempDownSword[i][j];
                if(indx<5){
                    RightSword[indx]=tempRightSword[i][j];
                    LeftSword[indx]=tempLeftSword[i][j];
                    UpSword[indx]=tempUpSword[i][j];
                }
                indx++;
            }
        }

        indx=0;
        for(int i=0;i<4;i++){
            for(int j=0;j<2;j++){
                moveUp[indx]=tempUp[i][j];
                moveDown[indx]=tempDown[i][j];
                indx++;
            }
        }

        RightMovement = new Animation(0.08f,moveRight);
        LeftMovement = new Animation(0.08f,moveLeft);
        UpMovement = new Animation(0.08f,moveUp);
        DownMovement = new Animation(0.08f,moveDown);


        RightSwordMovement = new Animation(0.08f,RightSword);
        LeftSwordMovement = new Animation(0.08f,LeftSword);
        UpSwordMovement = new Animation(0.08f,UpSword);
        DownSwordMovement = new Animation(0.08f,DownSword);
    }
}
