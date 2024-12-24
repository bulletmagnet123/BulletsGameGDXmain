package BulletMagnetsGame.bulletmagnet123.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class MainClass extends Game {
    private SpriteBatch batch;
    private Texture image;
    private Player player;


    @Override
    public void create() {
        batch = new SpriteBatch();
        image = new Texture("libgdx.png");
        player = new Player("Player", "neo_zero_char_01.png", 32, 32);
        SetScreen(new FirstScreen());
    }

    private void SetScreen(Screen screen) {

    }

    @Override
    public void render() {
        float deltaTime = Gdx.graphics.getDeltaTime();
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        batch.begin();
        batch.draw(image, 140, 210);
        player.render(batch);
        player.update(deltaTime);


        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
    }
}
