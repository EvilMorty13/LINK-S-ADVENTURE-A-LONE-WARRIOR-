package Enemies;
import EnemyHorizontalMovesCollections.*;
import EnemyMovement.*;
import EnemyVerticalMovesCollections.*;

import java.util.ArrayList;

public class VerticalEnemies {
    public enemyV1 enV1 = new enemyV1();
    public enemyV2 enV2 = new enemyV2();
    public enemyV3 enV3 = new enemyV3();
    public enemyV4 enV4 = new enemyV4();
    public enemyV5 enV5 = new enemyV5();
    public enemyV6 enV6 = new enemyV6();
    public enemyV7 enV7 = new enemyV7();
    public enemyV8 enV8 = new enemyV8();
    public enemyV9 enV9 = new enemyV9();
    ArrayList<enemiesVerticalMovement> enemies2 = new ArrayList<>();
    public ArrayList<enemiesVerticalMovement> get(){
        enemies2.add(new enemiesVerticalMovement(enV1.posX, enV1.posY, enV1.limY1, enV1.limY2));
        enemies2.add(new enemiesVerticalMovement(enV2.posX, enV2.posY, enV2.limY1, enV2.limY2));
        enemies2.add(new enemiesVerticalMovement(enV3.posX, enV3.posY, enV3.limY1, enV3.limY2));
        enemies2.add(new enemiesVerticalMovement(enV4.posX, enV4.posY, enV4.limY1, enV4.limY2));
        enemies2.add(new enemiesVerticalMovement(enV5.posX, enV5.posY, enV5.limY1, enV5.limY2));
        enemies2.add(new enemiesVerticalMovement(enV6.posX, enV6.posY, enV6.limY1, enV6.limY2));
        enemies2.add(new enemiesVerticalMovement(enV7.posX, enV7.posY, enV7.limY1, enV7.limY2));
        enemies2.add(new enemiesVerticalMovement(enV8.posX, enV8.posY, enV8.limY1, enV8.limY2));
        enemies2.add(new enemiesVerticalMovement(enV9.posX, enV9.posY, enV9.limY1, enV9.limY2));
        return enemies2;
    }
}
