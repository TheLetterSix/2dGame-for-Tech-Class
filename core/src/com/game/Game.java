package com.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.game.gamestates.Play;
import com.game.states.StateManager;

public class Game extends ApplicationAdapter {
	private Play play;
	private OrthographicCamera camera;

	public static int width;
	public static int height;
	
	public static float scale;
	
	public void create () {
	    Gdx.graphics.setWindowedMode(1280, 1024);

		width = Gdx.graphics.getWidth();
		height = Gdx.graphics.getHeight();
		
		camera = new OrthographicCamera(8,8);
		scale = Gdx.graphics.getHeight() / camera.viewportHeight;
		//camera.position.set(width*0.5f, height*0.5f, 0);
		camera.update();
		
		play = new Play();
		StateManager.addState(play);
	}

	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		StateManager.renderStates(camera);
		StateManager.updateStates(camera);
	}
	
	public void dispose () {
		StateManager.onClose();
	}
}
