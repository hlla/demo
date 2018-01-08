package com.android.launcher2;

import android.content.Context;
import android.graphics.Canvas;
import android.opengl.GLES20;
import android.util.AttributeSet;
import android.view.View;

public class DarkenView
  extends View
{
  final Drawer mDrawer = new Drawer();
  
  public DarkenView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public DarkenView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    DrawGLFunction.call(paramCanvas, this.mDrawer);
  }
  
  protected void finalize()
    throws Throwable
  {
    super.finalize();
    DrawGLFunction.destroy(this.mDrawer);
  }
  
  public float getAlpha()
  {
    return this.mDrawer.mAlpha;
  }
  
  public boolean onSetAlpha(int paramInt)
  {
    if (paramInt == 255) {
      return true;
    }
    Drawer.access$002(this.mDrawer, paramInt / 255.0F);
    return true;
  }
  
  static class Drawer
    extends DrawGLFunction.Callback
  {
    private float mAlpha = 0.0F;
    
    public void drawGL(float[] paramArrayOfFloat)
    {
      if (this.mAlpha == 0.0F) {
        return;
      }
      GLES20.glClearColor(0.0F, 0.0F, 0.0F, this.mAlpha);
      GLES20.glClear(16384);
    }
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/DarkenView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */