package android.support.v7.widget;

import android.view.View;

public final class ds
{
  public dn a;
  public fp b;
  public fw c;
  
  public static void a(View paramView)
  {
    ((fj)paramView.getLayoutParams()).b = true;
  }
  
  public final int a(int paramInt)
  {
    Object localObject = this.b;
    if ((paramInt < 0) || (paramInt >= ((fp)localObject).h.G.a()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("invalid position ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(". State ");
      localStringBuilder.append("item count is ");
      localStringBuilder.append(((fp)localObject).h.G.a());
      localStringBuilder.append(((fp)localObject).h.a());
      throw new IndexOutOfBoundsException(localStringBuilder.toString());
    }
    localObject = ((fp)localObject).h;
    int i = paramInt;
    if (((RecyclerView)localObject).G.e) {
      i = ((RecyclerView)localObject).h.a(paramInt, 0);
    }
    return i;
  }
  
  public final View a()
  {
    return this.a.a(this.b);
  }
  
  public final int b()
  {
    int i = -1;
    if (this.a.e != -1) {
      i = 1;
    }
    return i;
  }
  
  public final int c()
  {
    int i = -1;
    if (this.a.g != -1) {
      i = 1;
    }
    return i;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/ds.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */