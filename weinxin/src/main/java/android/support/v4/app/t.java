package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.content.c.a;
import android.support.v4.content.c.b;
import android.support.v4.e.j;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

public final class t
  extends s
{
  public static boolean DEBUG = false;
  boolean ny;
  final String oV;
  public k ph;
  boolean pp;
  final j<a> ru = new j();
  final j<a> rv = new j();
  boolean rw;
  
  t(String paramString, k paramk, boolean paramBoolean)
  {
    this.oV = paramString;
    this.ph = paramk;
    this.ny = paramBoolean;
  }
  
  private a a(int paramInt, Bundle paramBundle, s.a<Object> parama)
  {
    paramBundle = new a(paramInt, paramBundle, parama);
    paramBundle.rz = parama.K(paramInt);
    return paramBundle;
  }
  
  private a b(int paramInt, Bundle paramBundle, s.a<Object> parama)
  {
    try
    {
      this.rw = true;
      paramBundle = a(paramInt, null, parama);
      a(paramBundle);
      return paramBundle;
    }
    finally
    {
      this.rw = false;
    }
  }
  
  public final <D> android.support.v4.content.c<D> J(int paramInt)
  {
    if (this.rw) {
      throw new IllegalStateException("Called while creating a loader");
    }
    a locala = (a)this.ru.get(paramInt);
    if (locala != null)
    {
      if (locala.rF != null) {
        return locala.rF.rz;
      }
      return locala.rz;
    }
    return null;
  }
  
  public final <D> android.support.v4.content.c<D> a(int paramInt, s.a<D> parama)
  {
    if (this.rw) {
      throw new IllegalStateException("Called while creating a loader");
    }
    a locala = (a)this.ru.get(paramInt);
    if (DEBUG) {
      new StringBuilder("initLoader in ").append(this).append(": args=").append(null);
    }
    if (locala == null)
    {
      locala = b(paramInt, null, parama);
      parama = locala;
      if (DEBUG) {
        new StringBuilder("  Created new loader ").append(locala);
      }
    }
    for (parama = locala;; parama = locala)
    {
      if ((parama.rA) && (this.ny)) {
        parama.c(parama.rz, parama.mData);
      }
      return parama.rz;
      if (DEBUG) {
        new StringBuilder("  Re-using existing loader ").append(locala);
      }
      locala.ry = parama;
    }
  }
  
  final void a(a parama)
  {
    this.ru.put(parama.dX, parama);
    if (this.ny) {
      parama.start();
    }
  }
  
  public final <D> android.support.v4.content.c<D> b(int paramInt, s.a<D> parama)
  {
    if (this.rw) {
      throw new IllegalStateException("Called while creating a loader");
    }
    a locala1 = (a)this.ru.get(paramInt);
    if (DEBUG) {
      new StringBuilder("restartLoader in ").append(this).append(": args=").append(null);
    }
    a locala2;
    if (locala1 != null)
    {
      locala2 = (a)this.rv.get(paramInt);
      if (locala2 == null) {
        break label381;
      }
      if (!locala1.rA) {
        break label146;
      }
      if (DEBUG) {
        new StringBuilder("  Removing last inactive loader: ").append(locala1);
      }
      locala2.rB = false;
      locala2.destroy();
    }
    for (;;)
    {
      locala1.rz.tu = true;
      this.rv.put(paramInt, locala1);
      for (;;)
      {
        return b(paramInt, null, parama).rz;
        label146:
        if (locala1.ny) {
          break;
        }
        this.ru.put(paramInt, null);
        locala1.destroy();
      }
      if (DEBUG) {
        new StringBuilder("  Canceling: ").append(locala1);
      }
      if ((locala1.ny) && (locala1.rz != null) && (locala1.rE))
      {
        if (DEBUG) {
          new StringBuilder("onLoadCanceled: ").append(locala1);
        }
        if ((!locala1.qx) && (locala1.rG.ru.get(locala1.dX) == locala1))
        {
          locala2 = locala1.rF;
          if (locala2 != null)
          {
            if (DEBUG) {
              new StringBuilder("  Switching to pending loader: ").append(locala2);
            }
            locala1.rF = null;
            locala1.rG.ru.put(locala1.dX, null);
            locala1.destroy();
            locala1.rG.a(locala2);
          }
        }
      }
      if (locala1.rF != null)
      {
        if (DEBUG) {
          new StringBuilder("  Removing pending loader: ").append(locala1.rF);
        }
        locala1.rF.destroy();
        locala1.rF = null;
      }
      locala1.rF = a(paramInt, null, parama);
      return locala1.rF.rz;
      label381:
      if (DEBUG) {
        new StringBuilder("  Making last loader inactive: ").append(locala1);
      }
    }
  }
  
  public final boolean bc()
  {
    int j = this.ru.size();
    int i = 0;
    boolean bool2 = false;
    if (i < j)
    {
      a locala = (a)this.ru.valueAt(i);
      if ((locala.ny) && (!locala.rB)) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        bool2 |= bool1;
        i += 1;
        break;
      }
    }
    return bool2;
  }
  
  final void bd()
  {
    if (DEBUG) {
      new StringBuilder("Starting in ").append(this);
    }
    if (this.ny)
    {
      new RuntimeException("here").fillInStackTrace();
      new StringBuilder("Called doStart when already started: ").append(this);
    }
    for (;;)
    {
      return;
      this.ny = true;
      int i = this.ru.size() - 1;
      while (i >= 0)
      {
        ((a)this.ru.valueAt(i)).start();
        i -= 1;
      }
    }
  }
  
  final void be()
  {
    if (DEBUG) {
      new StringBuilder("Stopping in ").append(this);
    }
    if (!this.ny)
    {
      new RuntimeException("here").fillInStackTrace();
      new StringBuilder("Called doStop when not started: ").append(this);
      return;
    }
    int i = this.ru.size() - 1;
    while (i >= 0)
    {
      ((a)this.ru.valueAt(i)).stop();
      i -= 1;
    }
    this.ny = false;
  }
  
  final void bf()
  {
    if (DEBUG) {
      new StringBuilder("Retaining in ").append(this);
    }
    if (!this.ny)
    {
      new RuntimeException("here").fillInStackTrace();
      new StringBuilder("Called doRetain when not started: ").append(this);
    }
    for (;;)
    {
      return;
      this.pp = true;
      this.ny = false;
      int i = this.ru.size() - 1;
      while (i >= 0)
      {
        a locala = (a)this.ru.valueAt(i);
        if (DEBUG) {
          new StringBuilder("  Retaining: ").append(locala);
        }
        locala.pp = true;
        locala.rC = locala.ny;
        locala.ny = false;
        locala.ry = null;
        i -= 1;
      }
    }
  }
  
  final void bg()
  {
    int i = this.ru.size() - 1;
    while (i >= 0)
    {
      ((a)this.ru.valueAt(i)).rD = true;
      i -= 1;
    }
  }
  
  final void bh()
  {
    int i = this.ru.size() - 1;
    while (i >= 0)
    {
      a locala = (a)this.ru.valueAt(i);
      if ((locala.ny) && (locala.rD))
      {
        locala.rD = false;
        if (locala.rA) {
          locala.c(locala.rz, locala.mData);
        }
      }
      i -= 1;
    }
  }
  
  final void bi()
  {
    if (!this.pp)
    {
      if (DEBUG) {
        new StringBuilder("Destroying Active in ").append(this);
      }
      i = this.ru.size() - 1;
      while (i >= 0)
      {
        ((a)this.ru.valueAt(i)).destroy();
        i -= 1;
      }
      this.ru.clear();
    }
    if (DEBUG) {
      new StringBuilder("Destroying Inactive in ").append(this);
    }
    int i = this.rv.size() - 1;
    while (i >= 0)
    {
      ((a)this.rv.valueAt(i)).destroy();
      i -= 1;
    }
    this.rv.clear();
  }
  
  public final void destroyLoader(int paramInt)
  {
    if (this.rw) {
      throw new IllegalStateException("Called while creating a loader");
    }
    if (DEBUG) {
      new StringBuilder("destroyLoader in ").append(this).append(" of ").append(paramInt);
    }
    int i = this.ru.indexOfKey(paramInt);
    a locala;
    if (i >= 0)
    {
      locala = (a)this.ru.valueAt(i);
      this.ru.removeAt(i);
      locala.destroy();
    }
    paramInt = this.rv.indexOfKey(paramInt);
    if (paramInt >= 0)
    {
      locala = (a)this.rv.valueAt(paramInt);
      this.rv.removeAt(paramInt);
      locala.destroy();
    }
    if ((this.ph != null) && (!bc())) {
      this.ph.pg.aX();
    }
  }
  
  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    int j = 0;
    String str;
    int i;
    a locala;
    if (this.ru.size() > 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Active Loaders:");
      str = paramString + "    ";
      i = 0;
      while (i < this.ru.size())
      {
        locala = (a)this.ru.valueAt(i);
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  #");
        paramPrintWriter.print(this.ru.keyAt(i));
        paramPrintWriter.print(": ");
        paramPrintWriter.println(locala.toString());
        locala.dump(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
        i += 1;
      }
    }
    if (this.rv.size() > 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Inactive Loaders:");
      str = paramString + "    ";
      i = j;
      while (i < this.rv.size())
      {
        locala = (a)this.rv.valueAt(i);
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  #");
        paramPrintWriter.print(this.rv.keyAt(i));
        paramPrintWriter.print(": ");
        paramPrintWriter.println(locala.toString());
        locala.dump(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
        i += 1;
      }
    }
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("LoaderManager{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" in ");
    android.support.v4.e.c.a(this.ph, localStringBuilder);
    localStringBuilder.append("}}");
    return localStringBuilder.toString();
  }
  
  final class a
    implements c.a<Object>, c.b<Object>
  {
    final int dX;
    Object mData;
    boolean ny;
    boolean pp;
    boolean qx;
    boolean rA;
    boolean rB;
    boolean rC;
    boolean rD;
    boolean rE;
    a rF;
    final Bundle rx;
    s.a<Object> ry;
    android.support.v4.content.c<Object> rz;
    
    public a(Bundle paramBundle, s.a<Object> parama)
    {
      this.dX = paramBundle;
      this.rx = parama;
      s.a locala;
      this.ry = locala;
    }
    
    public final void b(android.support.v4.content.c<Object> paramc, Object paramObject)
    {
      if (t.DEBUG) {
        new StringBuilder("onLoadComplete: ").append(this);
      }
      if (this.qx) {}
      do
      {
        do
        {
          return;
        } while (t.this.ru.get(this.dX) != this);
        a locala = this.rF;
        if (locala != null)
        {
          if (t.DEBUG) {
            new StringBuilder("  Switching to pending loader: ").append(locala);
          }
          this.rF = null;
          t.this.ru.put(this.dX, null);
          destroy();
          t.this.a(locala);
          return;
        }
        if ((this.mData != paramObject) || (!this.rA))
        {
          this.mData = paramObject;
          this.rA = true;
          if (this.ny) {
            c(paramc, paramObject);
          }
        }
        paramc = (a)t.this.rv.get(this.dX);
        if ((paramc != null) && (paramc != this))
        {
          paramc.rB = false;
          paramc.destroy();
          t.this.rv.remove(this.dX);
        }
      } while ((t.this.ph == null) || (t.this.bc()));
      t.this.ph.pg.aX();
    }
    
    final void c(android.support.v4.content.c<Object> paramc, Object paramObject)
    {
      String str;
      if (this.ry != null)
      {
        if (t.this.ph == null) {
          break label176;
        }
        str = t.this.ph.pg.qy;
        t.this.ph.pg.qy = "onLoadFinished";
      }
      for (;;)
      {
        try
        {
          if (t.DEBUG)
          {
            StringBuilder localStringBuilder1 = new StringBuilder("  onLoadFinished in ").append(paramc).append(": ");
            StringBuilder localStringBuilder2 = new StringBuilder(64);
            android.support.v4.e.c.a(paramObject, localStringBuilder2);
            localStringBuilder2.append("}");
            localStringBuilder1.append(localStringBuilder2.toString());
          }
          this.ry.a(paramc, paramObject);
          if (t.this.ph != null) {
            t.this.ph.pg.qy = str;
          }
          this.rB = true;
          return;
        }
        finally
        {
          if (t.this.ph != null) {
            t.this.ph.pg.qy = str;
          }
        }
        label176:
        str = null;
      }
    }
    
    final void destroy()
    {
      a locala = this;
      if (t.DEBUG) {
        new StringBuilder("  Destroying: ").append(locala);
      }
      locala.qx = true;
      boolean bool = locala.rB;
      locala.rB = false;
      Object localObject;
      if ((locala.ry != null) && (locala.rz != null) && (locala.rA) && (bool))
      {
        if (t.DEBUG) {
          new StringBuilder("  Reseting: ").append(locala);
        }
        if (locala.rG.ph == null) {
          break label245;
        }
        localObject = locala.rG.ph.pg.qy;
        locala.rG.ph.pg.qy = "onLoaderReset";
      }
      for (;;)
      {
        if (locala.rG.ph != null) {
          locala.rG.ph.pg.qy = ((String)localObject);
        }
        locala.ry = null;
        locala.mData = null;
        locala.rA = false;
        if (locala.rz != null)
        {
          if (locala.rE)
          {
            locala.rE = false;
            locala.rz.a(locala);
            locala.rz.a(locala);
          }
          localObject = locala.rz;
          ((android.support.v4.content.c)localObject).onReset();
          ((android.support.v4.content.c)localObject).tv = true;
          ((android.support.v4.content.c)localObject).ny = false;
          ((android.support.v4.content.c)localObject).tu = false;
          ((android.support.v4.content.c)localObject).tw = false;
          ((android.support.v4.content.c)localObject).tx = false;
        }
        if (locala.rF != null)
        {
          locala = locala.rF;
          break;
        }
        return;
        label245:
        localObject = null;
      }
    }
    
    public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
    {
      String str = paramString;
      paramString = this;
      for (;;)
      {
        paramPrintWriter.print(str);
        paramPrintWriter.print("mId=");
        paramPrintWriter.print(paramString.dX);
        paramPrintWriter.print(" mArgs=");
        paramPrintWriter.println(paramString.rx);
        paramPrintWriter.print(str);
        paramPrintWriter.print("mCallbacks=");
        paramPrintWriter.println(paramString.ry);
        paramPrintWriter.print(str);
        paramPrintWriter.print("mLoader=");
        paramPrintWriter.println(paramString.rz);
        if (paramString.rz != null) {
          paramString.rz.dump(str + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
        }
        if ((paramString.rA) || (paramString.rB))
        {
          paramPrintWriter.print(str);
          paramPrintWriter.print("mHaveData=");
          paramPrintWriter.print(paramString.rA);
          paramPrintWriter.print("  mDeliveredData=");
          paramPrintWriter.println(paramString.rB);
          paramPrintWriter.print(str);
          paramPrintWriter.print("mData=");
          paramPrintWriter.println(paramString.mData);
        }
        paramPrintWriter.print(str);
        paramPrintWriter.print("mStarted=");
        paramPrintWriter.print(paramString.ny);
        paramPrintWriter.print(" mReportNextStart=");
        paramPrintWriter.print(paramString.rD);
        paramPrintWriter.print(" mDestroyed=");
        paramPrintWriter.println(paramString.qx);
        paramPrintWriter.print(str);
        paramPrintWriter.print("mRetaining=");
        paramPrintWriter.print(paramString.pp);
        paramPrintWriter.print(" mRetainingStarted=");
        paramPrintWriter.print(paramString.rC);
        paramPrintWriter.print(" mListenerRegistered=");
        paramPrintWriter.println(paramString.rE);
        if (paramString.rF == null) {
          break;
        }
        paramPrintWriter.print(str);
        paramPrintWriter.println("Pending Loader ");
        paramPrintWriter.print(paramString.rF);
        paramPrintWriter.println(":");
        paramString = paramString.rF;
        str = str + "  ";
      }
    }
    
    final void start()
    {
      if ((this.pp) && (this.rC)) {
        this.ny = true;
      }
      do
      {
        do
        {
          return;
        } while (this.ny);
        this.ny = true;
        if (t.DEBUG) {
          new StringBuilder("  Starting: ").append(this);
        }
        if ((this.rz == null) && (this.ry != null)) {
          this.rz = this.ry.K(this.dX);
        }
      } while (this.rz == null);
      if ((this.rz.getClass().isMemberClass()) && (!Modifier.isStatic(this.rz.getClass().getModifiers()))) {
        throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.rz);
      }
      if (!this.rE)
      {
        localc = this.rz;
        int i = this.dX;
        if (localc.ts != null) {
          throw new IllegalStateException("There is already a listener registered");
        }
        localc.ts = this;
        localc.dX = i;
        localc = this.rz;
        if (localc.tt != null) {
          throw new IllegalStateException("There is already a listener registered");
        }
        localc.tt = this;
        this.rE = true;
      }
      android.support.v4.content.c localc = this.rz;
      localc.ny = true;
      localc.tv = false;
      localc.tu = false;
      localc.onStartLoading();
    }
    
    final void stop()
    {
      if (t.DEBUG) {
        new StringBuilder("  Stopping: ").append(this);
      }
      this.ny = false;
      if ((!this.pp) && (this.rz != null) && (this.rE))
      {
        this.rE = false;
        this.rz.a(this);
        this.rz.a(this);
        android.support.v4.content.c localc = this.rz;
        localc.ny = false;
        localc.onStopLoading();
      }
    }
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder(64);
      localStringBuilder.append("LoaderInfo{");
      localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
      localStringBuilder.append(" #");
      localStringBuilder.append(this.dX);
      localStringBuilder.append(" : ");
      android.support.v4.e.c.a(this.rz, localStringBuilder);
      localStringBuilder.append("}}");
      return localStringBuilder.toString();
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v4/app/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */