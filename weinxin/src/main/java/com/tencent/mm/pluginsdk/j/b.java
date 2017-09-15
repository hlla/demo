package com.tencent.mm.pluginsdk.j;

import android.app.Activity;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.y.e;
import java.util.HashSet;
import java.util.Set;

public abstract class b
  implements e
{
  public Activity activity;
  Set<Integer> sDi;
  
  public b(Activity paramActivity)
  {
    GMTrace.i(700616540160L, 5220);
    this.sDi = new HashSet();
    this.activity = paramActivity;
    GMTrace.o(700616540160L, 5220);
  }
  
  public final boolean a(p paramp)
  {
    GMTrace.i(700750757888L, 5221);
    if (paramp.action == 0)
    {
      GMTrace.o(700750757888L, 5221);
      return false;
    }
    switch (paramp.action)
    {
    case 3: 
    default: 
      GMTrace.o(700750757888L, 5221);
      return false;
    case 1: 
      bool = b(paramp);
      GMTrace.o(700750757888L, 5221);
      return bool;
    case 2: 
      bool = c(paramp);
      GMTrace.o(700750757888L, 5221);
      return bool;
    case 4: 
      bool = d(paramp);
      GMTrace.o(700750757888L, 5221);
      return bool;
    }
    boolean bool = e(paramp);
    GMTrace.o(700750757888L, 5221);
    return bool;
  }
  
  public abstract boolean b(p paramp);
  
  public abstract boolean c(p paramp);
  
  public abstract boolean d(p paramp);
  
  public abstract boolean e(p paramp);
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/j/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */