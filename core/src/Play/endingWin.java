package Play;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.MainGame;

public class endingWin implements Screen {
    MainGame game;
    Texture backgroundImg;
    float time;
    Animation dialogue1;
    Animation dialogue2;
    boolean done=false;
    boolean done2=false;
    float time2;
    Texture continue16;
    endingWin2 endWin2;

    public endingWin(MainGame game){
        this.game=game;
        TextureRegion[][] tempDialogue1 = TextureRegion.split(new Texture("Ending.png"),500,100);
        TextureRegion[][] tempDialogue2 = TextureRegion.split(new Texture("continue.png"),500,100);

        TextureRegion[] dialogueArray = new TextureRegion[18];
        TextureRegion[] dialogueArray2 = new TextureRegion[15];

        for(int i=0;i<18;i++){
            dialogueArray[i]=tempDialogue1[i][0];
        }
        for(int i=0;i<15;i++){
            dialogueArray2[i]=tempDialogue2[i][0];
        }
        dialogue1=new Animation(0.2f,dialogueArray);
        dialogue2=new Animation(0.2f,dialogueArray2);

        endWin2=new endingWin2();
    }
    @Override
    public void show() {
        backgroundImg=new Texture("endingWinBackground.jpg");
        continue16=new Texture("Continue_16.png");
    }


    @Override
    public void render(float delta) {
        time+=delta;
        time2+=0.5f;
        game.batch.begin();
        ScreenUtils.clear(0,0,0,0);
        game.batch.draw(backgroundImg,0,0);
        if(dialogue1.isAnimationFinished(time)) done=true;
        game.batch.draw((TextureRegion) dialogue1.getKeyFrame(time,false),500f,400f);
        //if(dialogue1.isAnimationFinished(time)) game.batch.draw((TextureRegion) dialogue2.getKeyFrame(1f,false),600f,300f);
        if(done){
            endWin2.update(0.2f);
            endWin2.render(game.batch);
        }
        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
