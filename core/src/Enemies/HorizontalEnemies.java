package Enemies;
import EnemyHorizontalMovesCollections.*;
import EnemyMovement.*;

import java.util.ArrayList;

public class HorizontalEnemies {
    public enemyH1 enH1 = new enemyH1();
    public enemyH2 enH2 = new enemyH2();
    public enemyH3 enH3 = new enemyH3();
    public enemyH4 enH4 = new enemyH4();
    public enemyH5 enH5 = new enemyH5();
    public enemyH6 enH6 = new enemyH6();
    public enemyH7 enH7 = new enemyH7();
    public enemyH8 enH8 = new enemyH8();
    public ArrayList<enemiesHorizontalMovement> enemies = new ArrayList<>();
    public ArrayList<enemiesHorizontalMovement> get(){
        enemies.add(new enemiesHorizontalMovement(enH1.posX, enH1.posY, enH1.limX1, enH1.limX2));
        enemies.add(new enemiesHorizontalMovement(enH2.posX, enH2.posY, enH2.limX1, enH2.limX2));
        enemies.add(new enemiesHorizontalMovement(enH3.posX, enH3.posY, enH3.limX1, enH3.limX2));
        enemies.add(new enemiesHorizontalMovement(enH4.posX, enH4.posY, enH4.limX1, enH4.limX2));
        enemies.add(new enemiesHorizontalMovement(enH5.posX, enH5.posY, enH5.limX1, enH5.limX2));
        enemies.add(new enemiesHorizontalMovement(enH6.posX, enH6.posY, enH6.limX1, enH6.limX2));
        enemies.add(new enemiesHorizontalMovement(enH7.posX, enH7.posY, enH7.limX1, enH7.limX2));
        enemies.add(new enemiesHorizontalMovement(enH8.posX, enH8.posY, enH8.limX1, enH8.limX2));
        return enemies;
    }
}
