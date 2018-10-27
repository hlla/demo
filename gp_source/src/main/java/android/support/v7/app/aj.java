package android.support.v7.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.hf;

final class aj
  implements f
{
  aj(aa paramaa) {}
  
  public final Drawable a()
  {
    hf localhf = hf.a(this.a.m(), null, new int[] { 2130968952 });
    Drawable localDrawable = localhf.a(0);
    localhf.c.recycle();
    return localDrawable;
  }
  
  public final void a(int paramInt)
  {
    a locala = this.a.a();
    if (locala != null) {
      locala.b(paramInt);
    }
  }
  
  public final void a(Drawable paramDrawable, int paramInt)
  {
    a locala = this.a.a();
    if (locala != null)
    {
      locala.c(paramDrawable);
      locala.b(paramInt);
    }
  }
  
  public final Context b()
  {
    return this.a.m();
  }
  
  public final boolean c()
  {
    a locala = this.a.a();
    return (locala != null) && ((locala.b() & 0x4) != 0);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/app/aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */