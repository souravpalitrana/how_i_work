package howiwork.emi.c.imran.howiwork;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MovingBackGround extends SurfaceView implements
		SurfaceHolder.Callback {
	private Bitmap backGround;

	public MovingBackGround(Context context) {
		super(context);
		backGround = BitmapFactory.decodeResource(context.getResources(),
				R.drawable.looper_background);
		setWillNotDraw(false);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		doDrawRunning(canvas);
		invalidate();
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {

	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {

	}

	/**
	 * Draws current state of the game Canvas.
	 */

	private int mBGFarMoveY = 0;
	private int mBGNearMoveY = 0;

	private void doDrawRunning(Canvas canvas) {
		mBGFarMoveY = mBGFarMoveY - 1;
		mBGNearMoveY = mBGNearMoveY - 4;
		int newFarY = backGround.getHeight() - (-mBGFarMoveY);
		if (newFarY <= 0) {
			mBGFarMoveY = 0;
			canvas.drawBitmap(backGround, 0, mBGFarMoveY, null);
		} else {
			canvas.drawBitmap(backGround, 0, mBGFarMoveY, null);
			canvas.drawBitmap(backGround, 0, newFarY,null);
		}

	}
}
