package obstacleDetectionConditon;
import ObstacleDetection.*;
public class obstacleDetectionConditionRight {
    public float check(float HeroX,float HeroY,obstacle5 obs5,obstacle6 obs6,obstacle7 obs7,obstacle8 obs8,obstacle9 obs9,obstacle10 obs10,obstacle11 obs11,obstacle12 obs12,obstacle14 obs14,obstacle15 obs15,obstacle16 obs16,obstacle17 obs17,obstacle17_bridge obs17_bridge,obstacle18 obs18,obstacle19 obs19,obstacle20 obs20,obstacle21 obs21,obstacle22 obs22,obstacle23 obs23,obstacle24 obs24,obstacle25 obs25,obstacle26 obs26){
        if(HeroY>obs5.limitY1 && HeroY<obs5.limitY2 && HeroX<obs5.limitX2 && HeroX>=obs5.limitX1) HeroX=obs5.limitX1;
        else if(HeroY<obs6.limitY && HeroX<obs6.limitX2 && HeroX>=obs6.limitX1) HeroX=obs6.limitX1;
        else if(HeroY>obs7.limitY1 && HeroY<obs7.limitY2 && HeroX<obs7.limitX2 && HeroX>=obs7.limitX1) HeroX=obs7.limitX1;
        else if(HeroY>obs8.limitY1 && HeroY<obs8.limitY2 && HeroX<obs8.limitX2 && HeroX>=obs8.limitX1) HeroX=obs8.limitX1;
        else if(HeroY>obs9.limitY1 && HeroY<obs9.limitY2 && HeroX<obs9.limitX2 && HeroX>=obs9.limitX1) HeroX=obs9.limitX1;
        else if(HeroY>=obs10.limitY1 && HeroY<=obs10.limitY2 && HeroX<obs10.limitX2 && HeroX>=obs10.limitX1) HeroX=obs10.limitX1;
        else if(HeroY>obs11.limitY1 && HeroY<obs11.limitY2 && HeroX<obs11.limitX2 && HeroX>=obs11.limitX1) HeroX=obs11.limitX1;
        else if(HeroY>obs12.limitY1 && HeroY<obs12.limitY2 && HeroX<obs12.limitX2 && HeroX>=obs12.limitX1) HeroX=obs12.limitX1;
        else if(HeroY>obs14.limitY1 && HeroY<obs14.limitY2 && HeroX<obs14.limitX2 && HeroX>=obs14.limitX1) HeroX=obs14.limitX1;
        else if(HeroY>obs15.limitY1 && HeroY<obs15.limitY2 && HeroX<obs15.limitX2 && HeroX>=obs15.limitX1) HeroX=obs15.limitX1;
        else if(HeroY>obs16.limitY1 && HeroY<obs16.limitY2 && HeroX<obs16.limitX2 && HeroX>=obs16.limitX1) HeroX=obs16.limitX1;
        else if(HeroY>obs17.limitY1 && HeroY<obs17.limitY2 && HeroX<obs17.limitX2 && HeroX>=obs17.limitX1) HeroX=obs17.limitX1;
        else if(HeroY>obs17_bridge.limitY1 && HeroY<obs17_bridge.limitY2 && HeroX<obs17_bridge.limitX2 && HeroX>=obs17_bridge.limitX1) HeroX=obs17_bridge.limitX1;
        else if(HeroY>obs18.limitY1 && HeroY<obs18.limitY2 && HeroX<obs18.limitX2 && HeroX>=obs18.limitX1) HeroX=obs18.limitX1;
        else if(HeroY>obs19.limitY1 && HeroY<obs19.limitY2 && HeroX<obs19.limitX2 && HeroX>=obs19.limitX1) HeroX=obs19.limitX1;
        else if(HeroY>obs20.limitY1 && HeroY<obs20.limitY2 && HeroX<obs20.limitX2 && HeroX>=obs20.limitX1) HeroX=obs20.limitX1;
        else if(HeroY>obs21.limitY1 && HeroY<obs21.limitY2 && HeroX<obs21.limitX2 && HeroX>=obs21.limitX1) HeroX=obs21.limitX1;
        else if(HeroY>obs22.limitY1 && HeroY<obs22.limitY2 && HeroX<obs22.limitX2 && HeroX>=obs22.limitX1) HeroX=obs22.limitX1;
        else if(HeroY>obs23.limitY1 && HeroY<obs23.limitY2 && HeroX<obs23.limitX2 && HeroX>=obs23.limitX1) HeroX=obs23.limitX1;
        else if(HeroY>obs24.limitY1 && HeroY<obs24.limitY2 && HeroX<obs24.limitX2 && HeroX>=obs24.limitX1) HeroX=obs24.limitX1;
        else if(HeroY>obs25.limitY1 && HeroY<obs25.limitY2 && HeroX>=obs25.limitX) HeroX=obs25.limitX;
        else if(HeroY>obs26.limitY1 && HeroY<obs26.limitY2 && HeroX<obs26.limitX2 && HeroX>=obs26.limitX1) HeroX=obs26.limitX1;
        return HeroX;
    }
}
