package com.example.legoclone;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Picture;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class GameLoop extends View implements Runnable {
	private Thread thread;
	private int interval = 16;
	
	private float cx;	// Center of touch's X axis.
	private float cy;	// Center of touch's Y axis.
	
	private Paint paint = new Paint();
	private Bitmap pic;
	
	private Random random = new Random();
	
	public GameLoop (Context context) {
		super(context);
		
		setBackgroundColor(Color.BLACK);
		
		setClickable(true);
		setLongClickable(true);
		setFocusable(true);
		
		paint.setColor(Color.WHITE);
		try {
			InputStream is = context.getAssets().open("mugi_chibi.jpg");
			pic = BitmapFactory.decodeStream(is);
		} catch (IOException e) {
			Log.e("IO Exception", "Couldn't load image");
		}
		
		thread = new Thread(this);
		thread.start();
	}
	
	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
	}
	
	private void update() {
		if (cx == 1) {
			
		}
		
		if (cy == 1) {
			
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
