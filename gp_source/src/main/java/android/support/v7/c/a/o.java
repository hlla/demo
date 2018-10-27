package android.support.v7.c.a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.StateSet;

class o
  extends k
{
  private int[][] a;
  
  o(o paramo, n paramn, Resources paramResources)
  {
    super(paramo, paramn, paramResources);
    if (paramo != null)
    {
      this.a = paramo.a;
      return;
    }
    this.a = new int[this.q.length][];
  }
  
  final int a(int[] paramArrayOfInt, Drawable paramDrawable)
  {
    int i = a(paramDrawable);
    this.a[i] = paramArrayOfInt;
    return i;
  }
  
  void a()
  {
    int i = this.a.length;
    int[][] arrayOfInt1 = new int[i][];
    i -= 1;
    if (i >= 0)
    {
      int[] arrayOfInt = this.a[i];
      if (arrayOfInt != null) {}
      for (arrayOfInt = (int[])arrayOfInt.clone();; arrayOfInt = null)
      {
        arrayOfInt1[i] = arrayOfInt;
        i -= 1;
        break;
      }
    }
    this.a = arrayOfInt1;
  }
  
  final int b(int[] paramArrayOfInt)
  {
    int[][] arrayOfInt = this.a;
    int k = this.x;
    int i = 0;
    while (i < k)
    {
      j = i;
      if (StateSet.stateSetMatches(arrayOfInt[i], paramArrayOfInt)) {
        return j;
      }
      i += 1;
    }
    int j = -1;
    return j;
  }
  
  public final void b(int paramInt1, int paramInt2)
  {
    super.b(paramInt1, paramInt2);
    int[][] arrayOfInt = new int[paramInt2][];
    System.arraycopy(this.a, 0, arrayOfInt, 0, paramInt1);
    this.a = arrayOfInt;
  }
  
  public Drawable newDrawable()
  {
    return new n(this, null);
  }
  
  public Drawable newDrawable(Resources paramResources)
  {
    return new n(this, paramResources);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/c/a/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */