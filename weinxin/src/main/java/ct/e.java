package ct;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArraySet;

public final class e
  implements a, n, Runnable
{
  private Set a = null;
  private BlockingQueue b = null;
  private q c;
  
  public e()
  {
    bd.a();
    this.a = new CopyOnWriteArraySet();
    this.a.add("dispatcher.3g.qq.com");
    this.b = new ArrayBlockingQueue(10);
    this.c = r.a();
    try
    {
      if (c()) {
        a(true);
      }
      for (;;)
      {
        j.a().a(this);
        return;
        a(false);
      }
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  private void a(boolean paramBoolean)
  {
    try
    {
      new StringBuilder("before add, queue size:").append(this.b.size());
      bd.a();
      this.b.add(new i(paramBoolean));
      bd.a();
      new StringBuilder("after add, queue size:").append(this.b.size());
      bd.a();
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        bd.d();
      }
    }
  }
  
  private static boolean c()
  {
    boolean bool2 = false;
    try
    {
      SharedPreferences localSharedPreferences = p.a.getSharedPreferences("Access_Preferences", 0);
      boolean bool1 = bool2;
      if (localSharedPreferences != null)
      {
        long l = localSharedPreferences.getLong("lastScheduleTime", 0L);
        bool1 = bool2;
        if (System.currentTimeMillis() - l > 86400000L)
        {
          localSharedPreferences.edit().putLong("lastScheduleTime", System.currentTimeMillis()).commit();
          bd.a();
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public final ao a()
  {
    return b.a.b().b.f;
  }
  
  public final t.a a(String paramString)
  {
    if (this.a.contains(paramString))
    {
      t.a locala = u.a().a(paramString);
      if (locala != null)
      {
        paramString = locala;
        if (!locala.b()) {
          return paramString;
        }
        bd.c();
        a(true);
      }
    }
    paramString = null;
    return paramString;
  }
  
  public final void a(List paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      try
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          String str = (String)paramList.next();
          this.a.add(str);
        }
        return;
      }
      catch (Exception paramList) {}
    }
  }
  
  public final void b()
  {
    bd.b();
    a(false);
  }
  
  public final void run()
  {
    
    for (;;)
    {
      try
      {
        u.a();
        bd.a();
        Object localObject1 = (i)this.b.take();
        bd.a();
        boolean bool1 = ((i)localObject1).a;
        try
        {
          bd.b();
          localObject1 = bc.a();
          if ((TextUtils.isEmpty((CharSequence)localObject1)) || (((String)localObject1).equals("unknown")))
          {
            bd.c();
            continue;
          }
          if (!h.a)
          {
            bd.b();
            continue;
          }
          if (!bool1)
          {
            bool1 = u.a().a(this.a);
            boolean bool2 = c();
            if (bool1) {
              break label518;
            }
            if (!bool2) {
              break label523;
            }
            break label518;
            if (i == 0)
            {
              bd.b();
              continue;
            }
          }
          localObject1 = new f();
          ((f)localObject1).b = p.b;
          ((f)localObject1).c = p.c;
          ((f)localObject1).d = p.d;
          ((f)localObject1).a = p.g;
          Object localObject2 = p.f;
          ((f)localObject1).e = p.e;
          localObject2 = this.a;
          ((f)localObject1).h = new ArrayList();
          ((f)localObject1).h.addAll((Collection)localObject2);
          ((f)localObject1).g = bc.a();
          ((f)localObject1).i = bc.c();
          ((f)localObject1).j = bc.d();
          localObject2 = ((f)localObject1).a();
          if (localObject2 != null)
          {
            u.a().a(((g)localObject2).a);
            b.a locala = b.a.b();
            d locald = ((g)localObject2).b;
            if (locald != null)
            {
              new StringBuilder("updateSdkCfInfo...SdkCfgInfo:").append(locald);
              bd.b();
              if ((locald.a < 2000) || (locald.a > 60000))
              {
                new StringBuilder("updateSdkCfInfo...connectTimeout:").append(locald.a).append(" is checked to 20s");
                bd.c();
                locald.a = 20000;
              }
              if ((locald.b < 2000) || (locald.b > 60000))
              {
                new StringBuilder("updateSdkCfInfo...readTimeout:").append(locald.b).append(" is checked to 20s");
                bd.c();
                locald.b = 20000;
              }
              locala.b = locald;
              locala.b.b();
            }
            locala = b.a.b();
            localObject2 = ((g)localObject2).c;
            if (localObject2 != null)
            {
              locala.a = ((c)localObject2);
              locala.a.b();
            }
          }
          new StringBuilder("scheduler...end. apn:").append(((f)localObject1).g).append(", retCode:").append(((f)localObject1).k).append(",failInfo:").append(((f)localObject1).l);
          bd.b();
          this.c.a((f)localObject1);
        }
        catch (Exception localException) {}
        continue;
        i = 1;
      }
      catch (Throwable localThrowable)
      {
        return;
      }
      label518:
      continue;
      label523:
      int i = 0;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/ct/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */