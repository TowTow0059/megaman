package gameobjects.camera;

import gameobjects.GameObject;
import gameobjects.particularobject.human.MegaMan;
import states.GameWorldState;

public class Camera extends GameObject {
    private float widthView;
    private float heightView;
    private boolean isLocked = false;

    public Camera(float x, float y, float widthView, float heightView, GameWorldState gameWorld) {
        super(x, y, gameWorld);
        this.widthView = widthView;
        this.heightView = heightView;
    }

    public void lock() {
        isLocked = true;
    }

    @Override
    public void Update() {
        if (!isLocked) {
            MegaMan mainCharacter = getGameWorld().megaMan;

            if (mainCharacter.getPosX() - getPosX() > 400) setPosX(mainCharacter.getPosX() - 400);
            if (mainCharacter.getPosX() - getPosX() < 200) setPosX(mainCharacter.getPosX() - 200);

            if (mainCharacter.getPosY() - getPosY() > 400) setPosY(mainCharacter.getPosY() - 400); // bottom
            else if (mainCharacter.getPosY() - getPosY() < 250) setPosY(mainCharacter.getPosY() - 250);// top
        }
    }

    public float getWidthView() {
        return widthView;
    }

    public float getHeightView() {
        return heightView;
    }
}
