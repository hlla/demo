package com.google.android.finsky.bw;

import android.support.v4.g.i;
import android.view.View;
import java.util.ArrayDeque;

public final class as
{
  public final int a;
  public final i b;
  
  public as()
  {
    this(20);
  }
  
  public as(int paramInt)
  {
    this.a = paramInt;
    this.b = new i(paramInt);
  }
  
  public final void a(int paramInt, View paramView)
  {
    Object localObject = this.b;
    Integer localInteger = Integer.valueOf(paramInt);
    if (((i)localObject).a(localInteger) == null) {
      this.b.a(localInteger, new at());
    }
    localObject = (at)this.b.a(localInteger);
    if (((at)localObject).b.size() < ((at)localObject).a) {
      ((at)localObject).b.addFirst(paramView);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bw/as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */