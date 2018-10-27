package com.google.android.finsky.bf;

import android.content.Context;
import com.google.android.finsky.dc.a;
import com.google.android.finsky.dc.c;
import com.google.wireless.android.finsky.b.e;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public final class i
  extends f
{
  private final Context a;
  private int k = -2;
  private final a l;
  
  public i(Context paramContext, String paramString1, String paramString2, a parama, e parame)
  {
    super(paramString1, paramString2, parame.i, parame.f, "", parame.d, g.a(parame), parame.h, parame.g);
    this.l = parama;
    this.a = paramContext;
  }
  
  public final String a(String paramString)
  {
    return this.a.getString(2131952761, new Object[] { paramString });
  }
  
  public final void a(OutputStream paramOutputStream)
  {
    paramOutputStream.flush();
    paramOutputStream.close();
  }
  
  public final boolean a()
  {
    return true;
  }
  
  public final boolean a(boolean paramBoolean)
  {
    return false;
  }
  
  public final File b()
  {
    return new File(c.a(this.h), c.a(this.l.a, c(), this.h));
  }
  
  public final int c()
  {
    int i = -1;
    for (;;)
    {
      int m;
      int j;
      try
      {
        if (this.k == -2)
        {
          String str = this.h;
          boolean bool = this.l.a;
          File[] arrayOfFile = c.a(str).listFiles();
          m = i;
          if (arrayOfFile != null)
          {
            int n = arrayOfFile.length;
            j = 0;
            m = i;
            if (j < n)
            {
              Integer localInteger = c.a(arrayOfFile[j].getName(), str, bool);
              m = i;
              if (localInteger == null) {
                break label124;
              }
              m = i;
              if (localInteger.intValue() <= i) {
                break label124;
              }
              m = localInteger.intValue();
              break label124;
            }
          }
          this.k = m;
        }
        else
        {
          i = this.k;
          return i;
        }
      }
      finally {}
      label124:
      j += 1;
      i = m;
    }
  }
  
  public final boolean d()
  {
    return true;
  }
  
  public final boolean e()
  {
    this.l.a();
    return this.l.c == 4;
  }
  
  public final boolean f()
  {
    return true;
  }
  
  public final OutputStream g()
  {
    File localFile = this.l.c();
    localFile.delete();
    return new FileOutputStream(localFile);
  }
  
  public final void h()
  {
    File localFile = this.l.c();
    if (localFile != null) {
      localFile.delete();
    }
  }
  
  public final File i()
  {
    return this.l.c();
  }
  
  public final a j()
  {
    return this.l;
  }
  
  public final boolean k()
  {
    return false;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bf/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */