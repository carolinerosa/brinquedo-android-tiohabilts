package com.example.legoclone;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class GameLoop extends View implements Runnable {
	private Thread thread;
	private int interval = 16;
	
	private float cx;	// Center of touch's X axis.
	private float cy;	// Center of touch's Y axis.
	
	private Bitmap pic;
	
	private Random random = new Random();
	
	private int left;
	private int top;
	private int right;
	private int bottom;
	private int size = 50;
	
	public GameLoop (Context context) {
		super(context);
		
		setBackgroundColor(Color.BLACK);
		
		setClickable(true);
		setLongClickable(true);
		setFocusable(true);
		
		try {
			InputStream is = context.getAssets().open("mugi_chibi.jpg");
			pic = BitmapFactory.decodeStream(is);
		} catch (IOException e) {
			Log.e("IO Exception", "Couldn't load image");
		}
		
		thread = new Thread(this);
		thread.start();
	}
	
	private void update() {
		left = random.nextInt(getWidth());
		top = random.nextInt(getHeight());
		right = left + size ;
		bottom = top + size;
		
		if (TriggerEvents.ifBetweenValuesFLOAT(cx, left, right)) {
			
		}
		
		if (TriggerEvents.ifBetweenValuesFLOAT(cy, top, bottom)) {
			
		}
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (event.getAction() == MotionEvent.ACTION_DOWN) {
			Log.i("Touch event", "Screen touch event");
			cx = event.getX();
			cy = event.getY();
		}
		if (event.getAction() == MotionEvent.ACTION_MOVE) {
			Log.i("Touch event", "Screen move event");
			cx = event.getX();
			cy = event.getY();
		}
		if (event.getAction() == MotionEvent.ACTION_UP) {
			Log.i("Touch event", "Remove touch event");
		}
		
		return super.onTouchEvent(event);
	}
	
	@Override
	public void draw(Canvas canvas) {
		super.draw(canvas);
		
		canvas.drawBitmap(pic, null, new Rect(left, top, right, bottom), null);
	}
	
	@Override
	public void run () {
		while (true) {
			try {
				Thread.sleep(interval);
			} catch (InterruptedException e) {
				Log.e("Interrupt thread", "Game loop stopped running");
			}
			update();
		}
	}
}
