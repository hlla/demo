package android.support.v7.widget;

import java.util.Arrays;

final class cm
  implements fi
{
  public int a;
  public int[] b;
  public int c;
  public int d;
  
  final void a()
  {
    int[] arrayOfInt = this.b;
    if (arrayOfInt != null) {
      Arrays.fill(arrayOfInt, -1);
    }
    this.a = 0;
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {
      throw new IllegalArgumentException("Layout positions must be non-negative");
    }
    if (paramInt2 >= 0)
    {
      int i = this.a;
      i += i;
      int[] arrayOfInt = this.b;
      if (arrayOfInt == null)
      {
        this.b = new int[4];
        Arrays.fill(this.b, -1);
      }
      for (;;)
      {
        arrayOfInt = this.b;
        arrayOfInt[i] = paramInt1;
        arrayOfInt[(i + 1)] = paramInt2;
        this.a += 1;
        return;
        int j = arrayOfInt.length;
        if (i >= j)
        {
          this.b = new int[i + i];
          System.arraycopy(arrayOfInt, 0, this.b, 0, j);
        }
      }
    }
    throw new IllegalArgumentException("Pixel distance must be non-negative");
  }
  
  final void a(RecyclerView paramRecyclerView, boolean paramBoolean)
  {
    this.a = 0;
    Object localObject = this.b;
    if (localObject != null) {
      Arrays.fill((int[])localObject, -1);
    }
    localObject = paramRecyclerView.u;
    if ((paramRecyclerView.g != null) && (localObject != null) && (((ff)localObject).j))
    {
      if (!paramBoolean) {
        break label109;
      }
      if (!paramRecyclerView.h.d()) {
        ((ff)localObject).a(paramRecyclerView.g.c(), this);
      }
    }
    for (;;)
    {
      int i = this.a;
      if (i > ((ff)localObject).k)
      {
        ((ff)localObject).k = i;
        ((ff)localObject).l = paramBoolean;
        paramRecyclerView.B.b();
      }
      return;
      label109:
      if (!paramRecyclerView.p()) {
        ((ff)localObject).a(this.c, this.d, paramRecyclerView.G, this);
      }
    }
  }
  
  final boolean a(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.b != null)
    {
      int j = this.a;
      int i = 0;
      for (;;)
      {
        bool1 = bool2;
        if (i >= j + j) {
          break label52;
        }
        if (this.b[i] == paramInt) {
          break;
        }
        i += 2;
      }
      bool1 = true;
    }
    label52:
    return bool1;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/cm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */