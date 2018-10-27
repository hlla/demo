package android.support.v7.c.a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.g.h;
import android.support.v4.g.w;
import android.util.StateSet;

final class c
  extends o
{
  private w D;
  public h a;
  
  c(c paramc, a parama, Resources paramResources)
  {
    super(paramc, parama, paramResources);
    if (paramc != null)
    {
      this.a = paramc.a;
      this.D = paramc.D;
      return;
    }
    this.a = new h();
    this.D = new w();
  }
  
  static long a(int paramInt1, int paramInt2)
  {
    return paramInt1 << 32 | paramInt2;
  }
  
  final int a(int paramInt)
  {
    int i = 0;
    if (paramInt >= 0) {
      i = ((Integer)this.D.a(paramInt, Integer.valueOf(0))).intValue();
    }
    return i;
  }
  
  final int a(int paramInt1, int paramInt2, Drawable paramDrawable, boolean paramBoolean)
  {
    int i = super.a(paramDrawable);
    long l2 = a(paramInt1, paramInt2);
    if (!paramBoolean) {}
    for (long l1 = 0L;; l1 = 8589934592L)
    {
      long l3 = i;
      this.a.c(l2, Long.valueOf(l3 | l1));
      if (paramBoolean)
      {
        l2 = a(paramInt2, paramInt1);
        this.a.c(l2, Long.valueOf(l1 | l3 | 0x100000000));
      }
      return i;
    }
  }
  
  final int a(int[] paramArrayOfInt)
  {
    int j = super.b(paramArrayOfInt);
    int i = j;
    if (j < 0) {
      i = super.b(StateSet.WILD_CARD);
    }
    return i;
  }
  
  final int a(int[] paramArrayOfInt, Drawable paramDrawable, int paramInt)
  {
    int i = super.a(paramArrayOfInt, paramDrawable);
    this.D.b(i, Integer.valueOf(paramInt));
    return i;
  }
  
  final void a()
  {
    this.a = ((h)this.a.clone());
    this.D = ((w)this.D.clone());
  }
  
  public final Drawable newDrawable()
  {
    return new a(this, null);
  }
  
  public final Drawable newDrawable(Resources paramResources)
  {
    return new a(this, paramResources);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/c/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */