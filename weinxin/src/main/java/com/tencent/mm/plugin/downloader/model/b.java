package com.tencent.mm.plugin.downloader.model;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Iterator;
import java.util.Vector;

public final class b
{
  public static Vector<m> kEB;
  public static m kEC;
  
  static
  {
    GMTrace.i(18596000432128L, 138551);
    kEB = new Vector();
    GMTrace.o(18596000432128L, 138551);
  }
  
  b()
  {
    GMTrace.i(18594389819392L, 138539);
    GMTrace.o(18594389819392L, 138539);
  }
  
  public static void a(m paramm)
  {
    GMTrace.i(18594524037120L, 138540);
    if ((paramm != null) && (!kEB.contains(paramm))) {
      kEB.add(paramm);
    }
    GMTrace.o(18594524037120L, 138540);
  }
  
  public static void akF()
  {
    GMTrace.i(18594926690304L, 138543);
    kEC = null;
    GMTrace.o(18594926690304L, 138543);
  }
  
  public static void b(m paramm)
  {
    GMTrace.i(18594658254848L, 138541);
    if ((kEB != null) && (paramm != null)) {
      kEB.remove(paramm);
    }
    GMTrace.o(18594658254848L, 138541);
  }
  
  public static void c(m paramm)
  {
    GMTrace.i(18594792472576L, 138542);
    kEC = paramm;
    GMTrace.o(18594792472576L, 138542);
  }
  
  public final void aX(final long paramLong)
  {
    GMTrace.i(18595329343488L, 138546);
    v.i("MicroMsg.FileDownloaderCallbackManager", "notifyTaskRemoved: %d", new Object[] { Long.valueOf(paramLong) });
    ae.v(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(18604858802176L, 138617);
        if (b.kEB != null)
        {
          Iterator localIterator = b.kEB.iterator();
          while (localIterator.hasNext()) {
            ((m)localIterator.next()).onTaskRemoved(paramLong);
          }
        }
        if (b.kEC != null) {
          b.kEC.onTaskRemoved(paramLong);
        }
        GMTrace.o(18604858802176L, 138617);
      }
    });
    GMTrace.o(18595329343488L, 138546);
  }
  
  public final void aY(final long paramLong)
  {
    GMTrace.i(18595731996672L, 138549);
    v.i("MicroMsg.FileDownloaderCallbackManager", "notifyTaskPaused: %d", new Object[] { Long.valueOf(paramLong) });
    ae.v(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(18592779206656L, 138527);
        if (b.kEB != null)
        {
          Iterator localIterator = b.kEB.iterator();
          while (localIterator.hasNext()) {
            ((m)localIterator.next()).onTaskPaused(paramLong);
          }
        }
        if (b.kEC != null) {
          b.kEC.onTaskPaused(paramLong);
        }
        GMTrace.o(18592779206656L, 138527);
      }
    });
    GMTrace.o(18595731996672L, 138549);
  }
  
  public final void aZ(final long paramLong)
  {
    GMTrace.i(18595866214400L, 138550);
    ae.v(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(18598953222144L, 138573);
        if (b.kEB != null)
        {
          Iterator localIterator = b.kEB.iterator();
          while (localIterator.hasNext()) {
            ((m)localIterator.next()).bg(paramLong);
          }
        }
        GMTrace.o(18598953222144L, 138573);
      }
    });
    GMTrace.o(18595866214400L, 138550);
  }
  
  public final void b(final long paramLong, String paramString, final boolean paramBoolean)
  {
    GMTrace.i(18595463561216L, 138547);
    v.i("MicroMsg.FileDownloaderCallbackManager", "notifyTaskFinished: %d", new Object[] { Long.valueOf(paramLong) });
    ae.v(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(18603785060352L, 138609);
        if (b.kEB != null)
        {
          Iterator localIterator = b.kEB.iterator();
          while (localIterator.hasNext()) {
            ((m)localIterator.next()).c(paramLong, paramBoolean, this.kEE);
          }
        }
        if (b.kEC != null) {
          b.kEC.c(paramLong, paramBoolean, this.kEE);
        }
        GMTrace.o(18603785060352L, 138609);
      }
    });
    GMTrace.o(18595463561216L, 138547);
  }
  
  public final void c(final long paramLong, int paramInt, final boolean paramBoolean)
  {
    GMTrace.i(18595597778944L, 138548);
    v.i("MicroMsg.FileDownloaderCallbackManager", "notifyTaskFailed: %d, errCode : %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    ae.v(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(18598416351232L, 138569);
        if (b.kEB != null)
        {
          Iterator localIterator = b.kEB.iterator();
          while (localIterator.hasNext()) {
            ((m)localIterator.next()).d(paramLong, paramBoolean, this.kEE);
          }
        }
        if (b.kEC != null) {
          b.kEC.d(paramLong, paramBoolean, this.kEE);
        }
        GMTrace.o(18598416351232L, 138569);
      }
    });
    GMTrace.o(18595597778944L, 138548);
  }
  
  public final void h(final long paramLong, String paramString)
  {
    GMTrace.i(18595060908032L, 138544);
    v.i("MicroMsg.FileDownloaderCallbackManager", "notifyTaskStarted: %d, %s", new Object[] { Long.valueOf(paramLong), paramString });
    ae.v(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(18609153769472L, 138649);
        if (b.kEB != null)
        {
          Iterator localIterator = b.kEB.iterator();
          while (localIterator.hasNext()) {
            ((m)localIterator.next()).onTaskStarted(paramLong, this.hZl);
          }
        }
        if (b.kEC != null) {
          b.kEC.onTaskStarted(paramLong, this.hZl);
        }
        GMTrace.o(18609153769472L, 138649);
      }
    });
    GMTrace.o(18595060908032L, 138544);
  }
  
  public final void i(final long paramLong, String paramString)
  {
    GMTrace.i(18595195125760L, 138545);
    v.i("MicroMsg.FileDownloaderCallbackManager", "notifyTaskStarted: %d, %s", new Object[] { Long.valueOf(paramLong), paramString });
    ae.v(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(18615193567232L, 138694);
        if (b.kEB != null)
        {
          Iterator localIterator = b.kEB.iterator();
          while (localIterator.hasNext()) {
            ((m)localIterator.next()).j(paramLong, this.hZl);
          }
        }
        if (b.kEC != null) {
          b.kEC.j(paramLong, this.hZl);
        }
        GMTrace.o(18615193567232L, 138694);
      }
    });
    GMTrace.o(18595195125760L, 138545);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/downloader/model/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */