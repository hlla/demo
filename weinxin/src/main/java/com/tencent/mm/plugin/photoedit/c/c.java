package com.tencent.mm.plugin.photoedit.c;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public abstract interface c<T>
  extends Cloneable
{
  public abstract void a(Canvas paramCanvas, boolean paramBoolean, Object... paramVarArgs);
  
  public abstract void aSb();
  
  public abstract Bitmap aSd();
  
  public abstract boolean aSe();
  
  public abstract void ge(boolean paramBoolean);
  
  public abstract int gf(boolean paramBoolean);
  
  public abstract void h(Canvas paramVarArgs);
  
  public abstract void onCreate();
  
  public abstract void onDestroy();
  
  public abstract T pop();
  
  public abstract void v(Bitmap paramBitmap);
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/photoedit/c/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */