package gameobjects.particularobject.bullet;

import gameobjects.particularobject.Bullet;
import states.GameWorldState;
import effects.Animation;
import effects.DataLoader;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class RedEyeBullet extends Bullet {
    private Animation forwardBulletAnim, backBulletAnim;

    public RedEyeBullet(float x, float y, GameWorldState gameWorld) {
        super(x, y, 30, 30, 1.0f, 10, gameWorld);
        forwardBulletAnim = DataLoader.getInstance().getAnimation("redeyebullet");
        backBulletAnim = DataLoader.getInstance().getAnimation("redeyebullet");
        backBulletAnim.flipAllImage();
    }

    @Override
    public Rectangle getBoundForCollisionWithEnemy() {
        return getBoundForCollisionWithMap();
    }

    @Override
    public void draw(Graphics2D g2) {
        if (getSpeedX() > 0) {
            forwardBulletAnim.Update(System.nanoTime());
            forwardBulletAnim.draw((int) (getPosX() - getGameWorld().camera.getPosX()), (int) getPosY() - (int) getGameWorld().camera.getPosY(), g2);
        } else {
            backBulletAnim.Update(System.nanoTime());
            backBulletAnim.draw((int) (getPosX() - getGameWorld().camera.getPosX()), (int) getPosY() - (int) getGameWorld().camera.getPosY(), g2);
        }
    }

    @Override
    public void Update() {
        super.Update();
    }

    @Override
    public void attack() {
    }
}
