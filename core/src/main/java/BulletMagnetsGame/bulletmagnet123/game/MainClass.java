package BulletMagnetsGame.bulletmagnet123.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class MainClass extends Game {
    public static final float PPM = 100;
    private SpriteBatch batch;
    private Texture image;
    private Player player;
    Stage stage;
    Viewport viewport;

    Screen screen;


    Controller controller;

    Camera camera = new OrthographicCamera();



    @Override
    public void create() {
        batch = new SpriteBatch();
        image = new Texture("libgdx.png");
        player = new Player("Player", "neo_zero_char_01.png", 32, 32);
        stage = new Stage(new ExtendViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()));
        Gdx.input.setInputProcessor(stage);
        controller = new Controller(stage);




    }

    @Override
    public void render() {
        viewport = new FitViewport(Gdx.graphics.getWidth()/ PPM, Gdx.graphics.getHeight() / PPM, camera);

        camera = new OrthographicCamera();
        World world = new World(new Vector2(0, 0), false);

        batch.setProjectionMatrix(camera.combined);
        float deltaTime = Gdx.graphics.getDeltaTime();
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        batch.begin();

        camera.update();

        stage.act(deltaTime);
        stage.draw();
        batch.draw(image, 140, 210);
        player.render(batch);
        player.update(deltaTime);
        controller.setPosition(75, 75);
        controller.draw();



        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
    }
}
