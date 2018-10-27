package android.support.v4.app;

import android.a.b.ah;
import android.a.b.n;
import android.a.b.t;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.content.h;
import android.support.v4.g.e;
import android.support.v4.g.f;
import android.support.v4.g.w;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

final class bv
  extends bt
{
  private final n a;
  private final by b;
  
  bv(n paramn, ah paramah)
  {
    this.a = paramn;
    this.b = by.a(paramah);
  }
  
  private final h a(int paramInt, Bundle paramBundle, bu parambu, h paramh)
  {
    try
    {
      this.b.a = true;
      h localh = parambu.a(paramInt, paramBundle);
      if (localh != null)
      {
        if (!localh.getClass().isMemberClass()) {}
        while (Modifier.isStatic(localh.getClass().getModifiers()))
        {
          paramBundle = new bw(paramInt, paramBundle, localh, paramh);
          this.b.b.b(paramInt, paramBundle);
          return paramBundle.a(this.a, parambu);
        }
        paramBundle = new StringBuilder();
        paramBundle.append("Object returned from onCreateLoader must not be a non-static inner member class: ");
        paramBundle.append(localh);
        throw new IllegalArgumentException(paramBundle.toString());
      }
    }
    finally
    {
      this.b.a = false;
    }
    throw new IllegalArgumentException("Object returned from onCreateLoader must not be null");
  }
  
  public final h a(int paramInt, Bundle paramBundle, bu parambu)
  {
    if (this.b.a) {
      throw new IllegalStateException("Called while creating a loader");
    }
    if (Looper.getMainLooper() != Looper.myLooper()) {
      throw new IllegalStateException("initLoader must be called on the main thread");
    }
    bw localbw = this.b.a(paramInt);
    if (localbw == null) {
      return a(paramInt, paramBundle, parambu, null);
    }
    return localbw.a(this.a, parambu);
  }
  
  public final void a()
  {
    by localby = this.b;
    int j = localby.b.b();
    int i = 0;
    while (i < j)
    {
      ((bw)localby.b.c(i)).c();
      i += 1;
    }
  }
  
  public final void a(int paramInt)
  {
    if (this.b.a) {
      throw new IllegalStateException("Called while creating a loader");
    }
    if (Looper.getMainLooper() != Looper.myLooper()) {
      throw new IllegalStateException("destroyLoader must be called on the main thread");
    }
    Object localObject = this.b.a(paramInt);
    if (localObject != null)
    {
      ((bw)localObject).a(true);
      localObject = this.b.b;
      paramInt = e.a(((w)localObject).c, ((w)localObject).d, paramInt);
      if ((paramInt >= 0) && (localObject.e[paramInt] != w.a))
      {
        ((w)localObject).e[paramInt] = w.a;
        ((w)localObject).b = true;
      }
    }
  }
  
  @Deprecated
  public final void a(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    by localby = this.b;
    if (localby.b.b() > 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Loaders:");
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append("    ");
      String str = ((StringBuilder)localObject1).toString();
      int i = 0;
      if (i < localby.b.b())
      {
        bw localbw = (bw)localby.b.c(i);
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  #");
        paramPrintWriter.print(localby.b.b(i));
        paramPrintWriter.print(": ");
        paramPrintWriter.println(localbw.toString());
        paramPrintWriter.print(str);
        paramPrintWriter.print("mId=");
        paramPrintWriter.print(localbw.h);
        paramPrintWriter.print(" mArgs=");
        paramPrintWriter.println(localbw.g);
        paramPrintWriter.print(str);
        paramPrintWriter.print("mLoader=");
        paramPrintWriter.println(localbw.i);
        localObject1 = localbw.i;
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(str);
        ((StringBuilder)localObject2).append("  ");
        ((h)localObject1).a(((StringBuilder)localObject2).toString(), paramFileDescriptor, paramPrintWriter, paramArrayOfString);
        if (localbw.j != null)
        {
          paramPrintWriter.print(str);
          paramPrintWriter.print("mCallbacks=");
          paramPrintWriter.println(localbw.j);
          localObject1 = localbw.j;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(str);
          ((StringBuilder)localObject2).append("  ");
          paramPrintWriter.print(((StringBuilder)localObject2).toString());
          paramPrintWriter.print("mDeliveredData=");
          paramPrintWriter.println(((bx)localObject1).b);
        }
        paramPrintWriter.print(str);
        paramPrintWriter.print("mData=");
        localObject2 = localbw.c;
        localObject1 = localObject2;
        if (localObject2 == t.a) {
          localObject1 = null;
        }
        localObject2 = new StringBuilder(64);
        f.a(localObject1, (StringBuilder)localObject2);
        ((StringBuilder)localObject2).append("}");
        paramPrintWriter.println(((StringBuilder)localObject2).toString());
        paramPrintWriter.print(str);
        paramPrintWriter.print("mStarted=");
        if (localbw.b > 0) {}
        for (boolean bool = true;; bool = false)
        {
          paramPrintWriter.println(bool);
          i += 1;
          break;
        }
      }
    }
  }
  
  public final h b(int paramInt)
  {
    Object localObject = this.b;
    if (((by)localObject).a) {
      throw new IllegalStateException("Called while creating a loader");
    }
    localObject = ((by)localObject).a(paramInt);
    if (localObject != null) {
      return ((bw)localObject).i;
    }
    return null;
  }
  
  public final h b(int paramInt, Bundle paramBundle, bu parambu)
  {
    if (this.b.a) {
      throw new IllegalStateException("Called while creating a loader");
    }
    if (Looper.getMainLooper() != Looper.myLooper()) {
      throw new IllegalStateException("restartLoader must be called on the main thread");
    }
    Object localObject = this.b.a(paramInt);
    if (localObject != null) {}
    for (localObject = ((bw)localObject).a(false);; localObject = null) {
      return a(paramInt, paramBundle, parambu, (h)localObject);
    }
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("LoaderManager{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" in ");
    f.a(this.a, localStringBuilder);
    localStringBuilder.append("}}");
    return localStringBuilder.toString();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/app/bv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */