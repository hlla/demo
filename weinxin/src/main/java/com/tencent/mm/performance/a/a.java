package com.tencent.mm.performance.a;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.performance.d.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Set;

public final class a
  extends com.tencent.mm.performance.d.a
{
  public static String TYPE;
  private boolean ifO;
  public Set<a> ifP;
  private Object ifQ;
  public Instrumentation ifR;
  
  static
  {
    GMTrace.i(13146894893056L, 97952);
    TYPE = "ActivityMonitorController";
    GMTrace.o(13146894893056L, 97952);
  }
  
  public a()
  {
    GMTrace.i(13143405232128L, 97926);
    this.ifO = false;
    this.ifP = null;
    this.ifQ = null;
    this.ifR = null;
    GMTrace.o(13143405232128L, 97926);
  }
  
  public final void MY()
  {
    try
    {
      GMTrace.i(13144210538496L, 97932);
      Iterator localIterator = this.ifP.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      GMTrace.o(13144210538496L, 97932);
    }
    finally {}
  }
  
  public final void MZ()
  {
    try
    {
      GMTrace.i(13144478973952L, 97934);
      Iterator localIterator = this.ifP.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      GMTrace.o(13144478973952L, 97934);
    }
    finally {}
  }
  
  public final void Na()
  {
    try
    {
      GMTrace.i(13144613191680L, 97935);
      Iterator localIterator = this.ifP.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      GMTrace.o(13144613191680L, 97935);
    }
    finally {}
  }
  
  public final boolean Nb()
  {
    GMTrace.i(13145015844864L, 97938);
    boolean bool;
    try
    {
      this.ifQ = c.ao("android.app.ActivityThread", "currentActivityThread");
      if (this.ifQ == null) {
        throw new IllegalStateException("Failed to get CurrentActivityThread.");
      }
    }
    catch (Exception localException1)
    {
      bool = false;
    }
    for (;;)
    {
      this.ifO = bool;
      GMTrace.o(13145015844864L, 97938);
      return bool;
      this.ifR = ((Instrumentation)c.a(this.ifQ.getClass(), "mInstrumentation", this.ifQ));
      if (this.ifR == null) {
        throw new IllegalStateException("Failed to get Instrumentation instance.");
      }
      bool = this.ifR.getClass().equals(b.class);
      if (bool)
      {
        GMTrace.o(13145015844864L, 97938);
        return true;
      }
      if ((!this.ifR.getClass().equals(Instrumentation.class)) && (!this.ifR.getClass().getName().startsWith(aa.getPackageName()))) {
        throw new IllegalStateException("Not original Instrumentation instance, give up monitoring.");
      }
      Object localObject2 = this.ifQ.getClass();
      b localb = new b((byte)0);
      Object localObject1 = this.ifQ;
      try
      {
        localObject2 = ((Class)localObject2).getDeclaredField("mInstrumentation");
        ((Field)localObject2).setAccessible(true);
        ((Field)localObject2).set(localObject1, localb);
        bool = true;
      }
      catch (Exception localException2)
      {
        v.printErrStackTrace("MicroMsg.ReflectHelper", localException2, "", new Object[0]);
        bool = true;
      }
    }
  }
  
  public final String Nc()
  {
    GMTrace.i(13145150062592L, 97939);
    String str = TYPE;
    GMTrace.o(13145150062592L, 97939);
    return str;
  }
  
  public final void Nd()
  {
    GMTrace.i(13145284280320L, 97940);
    GMTrace.o(13145284280320L, 97940);
  }
  
  public final void a(Activity paramActivity, Intent paramIntent, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        GMTrace.i(13144344756224L, 97933);
        Iterator localIterator = this.ifP.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        a locala = (a)localIterator.next();
        if (paramBoolean) {
          locala.c(paramActivity, paramIntent);
        } else {
          locala.d(paramActivity, paramIntent);
        }
      }
      finally {}
    }
    GMTrace.o(13144344756224L, 97933);
  }
  
  public final void a(Activity paramActivity, Bundle paramBundle, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        GMTrace.i(13143673667584L, 97928);
        Iterator localIterator = this.ifP.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        a locala = (a)localIterator.next();
        if (paramBoolean) {
          locala.a(paramActivity, paramBundle);
        } else {
          locala.b(paramActivity, paramBundle);
        }
      }
      finally {}
    }
    GMTrace.o(13143673667584L, 97928);
  }
  
  public final void a(Activity paramActivity, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        GMTrace.i(13143807885312L, 97929);
        Iterator localIterator = this.ifP.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        a locala = (a)localIterator.next();
        if (paramBoolean) {
          locala.h(paramActivity);
        } else {
          locala.i(paramActivity);
        }
      }
      finally {}
    }
    GMTrace.o(13143807885312L, 97929);
  }
  
  public final void a(a parama)
  {
    try
    {
      GMTrace.i(13143539449856L, 97927);
      if (parama == null) {
        throw new IllegalArgumentException("callback is null");
      }
    }
    finally {}
    if (!this.ifO) {
      GMTrace.o(13143539449856L, 97927);
    }
    for (;;)
    {
      return;
      this.ifP.add(parama);
      GMTrace.o(13143539449856L, 97927);
    }
  }
  
  public final void b(Activity paramActivity, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        GMTrace.i(13143942103040L, 97930);
        Iterator localIterator = this.ifP.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        a locala = (a)localIterator.next();
        if (paramBoolean) {
          locala.j(paramActivity);
        } else {
          locala.k(paramActivity);
        }
      }
      finally {}
    }
    GMTrace.o(13143942103040L, 97930);
  }
  
  public final void c(Activity paramActivity, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        GMTrace.i(13144076320768L, 97931);
        Iterator localIterator = this.ifP.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        a locala = (a)localIterator.next();
        if (paramBoolean) {
          locala.l(paramActivity);
        } else {
          locala.m(paramActivity);
        }
      }
      finally {}
    }
    GMTrace.o(13144076320768L, 97931);
  }
  
  public final void d(Activity paramActivity, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        GMTrace.i(13144747409408L, 97936);
        Iterator localIterator = this.ifP.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        a locala = (a)localIterator.next();
        if (paramBoolean) {
          locala.n(paramActivity);
        } else {
          locala.o(paramActivity);
        }
      }
      finally {}
    }
    GMTrace.o(13144747409408L, 97936);
  }
  
  public final void e(Activity paramActivity, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        GMTrace.i(13144881627136L, 97937);
        Iterator localIterator = this.ifP.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        a locala = (a)localIterator.next();
        if (paramBoolean) {
          locala.p(paramActivity);
        } else {
          locala.q(paramActivity);
        }
      }
      finally {}
    }
    GMTrace.o(13144881627136L, 97937);
  }
  
  public static abstract class a
  {
    public a()
    {
      GMTrace.i(13147029110784L, 97953);
      GMTrace.o(13147029110784L, 97953);
    }
    
    public void a(Activity paramActivity, Bundle paramBundle)
    {
      GMTrace.i(13147163328512L, 97954);
      GMTrace.o(13147163328512L, 97954);
    }
    
    public void b(Activity paramActivity, Bundle paramBundle)
    {
      GMTrace.i(13147297546240L, 97955);
      GMTrace.o(13147297546240L, 97955);
    }
    
    public void c(Activity paramActivity, Intent paramIntent)
    {
      GMTrace.i(13148237070336L, 97962);
      GMTrace.o(13148237070336L, 97962);
    }
    
    public void d(Activity paramActivity, Intent paramIntent)
    {
      GMTrace.i(13148371288064L, 97963);
      GMTrace.o(13148371288064L, 97963);
    }
    
    public void h(Activity paramActivity)
    {
      GMTrace.i(13147431763968L, 97956);
      GMTrace.o(13147431763968L, 97956);
    }
    
    public void i(Activity paramActivity)
    {
      GMTrace.i(13147565981696L, 97957);
      GMTrace.o(13147565981696L, 97957);
    }
    
    public void j(Activity paramActivity)
    {
      GMTrace.i(13147700199424L, 97958);
      GMTrace.o(13147700199424L, 97958);
    }
    
    public void k(Activity paramActivity)
    {
      GMTrace.i(13147834417152L, 97959);
      GMTrace.o(13147834417152L, 97959);
    }
    
    public void l(Activity paramActivity)
    {
      GMTrace.i(13147968634880L, 97960);
      GMTrace.o(13147968634880L, 97960);
    }
    
    public void m(Activity paramActivity)
    {
      GMTrace.i(13148102852608L, 97961);
      GMTrace.o(13148102852608L, 97961);
    }
    
    public void n(Activity paramActivity)
    {
      GMTrace.i(13148505505792L, 97964);
      GMTrace.o(13148505505792L, 97964);
    }
    
    public void o(Activity paramActivity)
    {
      GMTrace.i(13148639723520L, 97965);
      GMTrace.o(13148639723520L, 97965);
    }
    
    public void p(Activity paramActivity)
    {
      GMTrace.i(13148773941248L, 97966);
      GMTrace.o(13148773941248L, 97966);
    }
    
    public void q(Activity paramActivity)
    {
      GMTrace.i(13148908158976L, 97967);
      GMTrace.o(13148908158976L, 97967);
    }
  }
  
  private class b
    extends Instrumentation
  {
    private b()
    {
      GMTrace.i(13141794619392L, 97914);
      GMTrace.o(13141794619392L, 97914);
    }
    
    public void callActivityOnCreate(Activity paramActivity, Bundle paramBundle)
    {
      GMTrace.i(13141928837120L, 97915);
      a.this.a(paramActivity, paramBundle, true);
      a.this.ifR.callActivityOnCreate(paramActivity, paramBundle);
      a.this.a(paramActivity, paramBundle, false);
      GMTrace.o(13141928837120L, 97915);
    }
    
    public void callActivityOnDestroy(Activity paramActivity)
    {
      GMTrace.i(13143136796672L, 97924);
      a.this.e(paramActivity, true);
      a.this.ifR.callActivityOnDestroy(paramActivity);
      a.this.e(paramActivity, false);
      GMTrace.o(13143136796672L, 97924);
    }
    
    public void callActivityOnNewIntent(Activity paramActivity, Intent paramIntent)
    {
      GMTrace.i(13142599925760L, 97920);
      a.this.a(paramActivity, paramIntent, true);
      a.this.ifR.callActivityOnNewIntent(paramActivity, paramIntent);
      a.this.a(paramActivity, paramIntent, false);
      GMTrace.o(13142599925760L, 97920);
    }
    
    public void callActivityOnPause(Activity paramActivity)
    {
      GMTrace.i(13142197272576L, 97917);
      a.this.b(paramActivity, true);
      a.this.ifR.callActivityOnPause(paramActivity);
      a.this.b(paramActivity, false);
      GMTrace.o(13142197272576L, 97917);
    }
    
    public void callActivityOnRestart(Activity paramActivity)
    {
      GMTrace.i(13142465708032L, 97919);
      a.this.MY();
      a.this.ifR.callActivityOnRestart(paramActivity);
      a.this.MY();
      GMTrace.o(13142465708032L, 97919);
    }
    
    public void callActivityOnRestoreInstanceState(Activity paramActivity, Bundle paramBundle)
    {
      GMTrace.i(13142868361216L, 97922);
      a.this.Na();
      a.this.ifR.callActivityOnRestoreInstanceState(paramActivity, paramBundle);
      a.this.Na();
      GMTrace.o(13142868361216L, 97922);
    }
    
    public void callActivityOnResume(Activity paramActivity)
    {
      GMTrace.i(13142063054848L, 97916);
      a.this.a(paramActivity, true);
      a.this.ifR.callActivityOnResume(paramActivity);
      a.this.a(paramActivity, false);
      GMTrace.o(13142063054848L, 97916);
    }
    
    public void callActivityOnSaveInstanceState(Activity paramActivity, Bundle paramBundle)
    {
      GMTrace.i(13142734143488L, 97921);
      a.this.MZ();
      a.this.ifR.callActivityOnSaveInstanceState(paramActivity, paramBundle);
      a.this.MZ();
      GMTrace.o(13142734143488L, 97921);
    }
    
    public void callActivityOnStart(Activity paramActivity)
    {
      GMTrace.i(13142331490304L, 97918);
      a.this.c(paramActivity, true);
      a.this.ifR.callActivityOnStart(paramActivity);
      a.this.c(paramActivity, false);
      GMTrace.o(13142331490304L, 97918);
    }
    
    public void callActivityOnStop(Activity paramActivity)
    {
      GMTrace.i(13143002578944L, 97923);
      a.this.d(paramActivity, true);
      a.this.ifR.callActivityOnStop(paramActivity);
      a.this.d(paramActivity, false);
      GMTrace.o(13143002578944L, 97923);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/performance/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */