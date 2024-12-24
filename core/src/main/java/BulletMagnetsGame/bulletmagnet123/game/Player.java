package BulletMagnetsGame.bulletmagnet123.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.github.tommyettinger.digital.Hasher;

public class Player {

    private Animation<TextureRegion> myColumnOfNineFrames;

    TextureRegion currentFrame;

    private Vector2 velocity = new Vector2();
    final Vector2 position = new Vector2();
    public float MOVEMENT_SPEED = 1.0f;
    private float stateTime = 0f;

    TextureRegion[][] playerImageRegion;


    public Rectangle player_rect;
    Texture playerTexture;

    public enum State {
        IDLE, RUN, ATTACK, DEATH
    }

    public Player(String name,String texturePath, int FRAME_HEIGHT, int FRAME_WIDTH) {
        playerTexture = new Texture(texturePath);


        player_rect = new Rectangle();
        player_rect.set(position.x, position.y, FRAME_WIDTH, FRAME_HEIGHT);
        playerImageRegion = TextureRegion.split(playerTexture, FRAME_WIDTH, FRAME_HEIGHT);
        Array<TextureRegion> frames = new Array<>(9);
        for (int row = 0; row < 9; row++) {
            frames.add(playerImageRegion[row][0]); // column 0
        }

        myColumnOfNineFrames = new Animation<>(0.1f,frames, Animation.PlayMode.LOOP);



    }



    public void getReady() {
        stateTime = 0f;
    }


    public void render(SpriteBatch batch) {
        player_rect.set(position.x, position.y, 1028, 1028); // Update player rectangle

        currentFrame = myColumnOfNineFrames.getKeyFrame(stateTime, true);
        batch.draw(
            currentFrame,
            position.x,
            position.y
        );
    }





    public void update(float deltaTime) {
        stateTime += deltaTime;
        // Save the old position
        float oldX = position.x;
        float oldY = position.y;

        // Update X position
        position.x += velocity.x * deltaTime;
        player_rect.setX(position.x);

        // Update Y position (vertical movement)
        position.y += velocity.y * deltaTime;
        player_rect.setY(position.y);
    }




    public float getPositionX() {
        return position.x;
    }

    public float getPositionY() {
        return position.y;
    }




    public void stop() {
        velocity.set(0, 0);

    }

    public void moveLeft() {
        System.out.println("Position before: " + position);
        position.x -= MOVEMENT_SPEED;

        System.out.println("Position after: " + position);
    }

    public void moveRight() {
        System.out.println("Position before: " + position);
        position.x += MOVEMENT_SPEED;

        System.out.println("Position after: " + position);
    }

    public void moveUp() {
        System.out.println("Position before: " + position);

        position.y += MOVEMENT_SPEED;

        System.out.println("Position after: " + position);
    }

    public void moveDown() {
        System.out.println("Position before: " + position);
        position.y -= MOVEMENT_SPEED;

        System.out.println("Position after: " + position);
    }

}
