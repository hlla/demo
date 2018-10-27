package com.google.android.finsky.b;

import android.database.DataSetObservable;
import android.graphics.drawable.Drawable;
import com.google.android.finsky.ds.a.bv;

public final class f
{
  public final DataSetObservable a;
  public h b;
  public final int c;
  public final bv[] d;
  public final Drawable[] e;
  
  public f(int paramInt, h paramh)
  {
    this.c = paramInt;
    paramInt = this.c;
    this.e = new Drawable[paramInt];
    this.d = new bv[paramInt];
    this.a = new DataSetObservable();
    this.b = paramh;
  }
  
  public final void a(int paramInt, Drawable paramDrawable)
  {
    this.e[paramInt] = paramDrawable;
    this.a.notifyChanged();
  }
  
  public final void a(int paramInt, bv parambv, float paramFloat)
  {
    Object localObject = this.e[paramInt];
    if (localObject != null)
    {
      parambv.b = ((int)(((Drawable)localObject).getIntrinsicWidth() * paramFloat));
      parambv.a = ((int)(((Drawable)localObject).getIntrinsicHeight() * paramFloat));
      return;
    }
    localObject = this.d[paramInt];
    if (localObject != null)
    {
      parambv.b = ((bv)localObject).b;
      parambv.a = ((bv)localObject).a;
      return;
    }
    parambv.b = 0;
    parambv.a = 0;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/b/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */