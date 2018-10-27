package com.google.android.finsky.dc;

import com.google.android.finsky.em.g;
import com.google.android.finsky.utils.FinskyLog;
import com.google.android.finsky.utils.ai;
import java.io.File;

public final class a
{
  public final boolean a;
  public long b;
  public int c;
  public int d;
  private String e;
  private final String f;
  
  public a(boolean paramBoolean, String paramString, int paramInt, long paramLong)
  {
    this.a = paramBoolean;
    this.f = paramString;
    this.d = paramInt;
    this.b = paramLong;
    this.c = 4;
    this.e = c.a(this.a, this.d, this.f);
  }
  
  private final void a(int paramInt)
  {
    if (paramInt == 5)
    {
      this.d = -1;
      this.b = -1L;
      this.e = "";
    }
    this.c = paramInt;
  }
  
  private final void a(String paramString)
  {
    try
    {
      FinskyLog.c("Failure %s while finalizing %s", new Object[] { paramString, toString() });
      FinskyLog.c(" file=%s, size=%d", new Object[] { this.e, Long.valueOf(this.b) });
      paramString = c.a(this.f);
      FinskyLog.c(" Contents of %s:", new Object[] { paramString.getAbsolutePath() });
      if (paramString.exists())
      {
        if (paramString.isDirectory())
        {
          paramString = paramString.listFiles();
          if (paramString != null)
          {
            int j = paramString.length;
            int i = 0;
            while (i < j)
            {
              Object localObject = paramString[i];
              FinskyLog.c("  name=%s size=%d", new Object[] { ((File)localObject).getName(), Long.valueOf(((File)localObject).length()) });
              i += 1;
            }
          }
          FinskyLog.c(" (listFiles() returned null)", new Object[0]);
          return;
        }
        FinskyLog.c(" (Is not a directory)", new Object[0]);
        return;
      }
    }
    catch (Exception paramString)
    {
      FinskyLog.b(paramString, "Unexpected exception", new Object[0]);
      return;
    }
    FinskyLog.c(" (Does not exist)", new Object[0]);
  }
  
  private final boolean h()
  {
    File localFile1 = b();
    if (localFile1 == null) {
      a("main file null");
    }
    File localFile2;
    do
    {
      return false;
      localFile2 = c();
      if (localFile2 == null)
      {
        a("temp file null");
        return false;
      }
    } while ((localFile2.exists()) || (localFile1.length() != this.b));
    return true;
  }
  
  public final void a()
  {
    if (this.c != 5)
    {
      if (!g.a()) {
        a(4);
      }
    }
    else {
      return;
    }
    File localFile = b();
    if ((localFile == null) || (!localFile.exists()) || (localFile.length() != this.b))
    {
      a(4);
      return;
    }
    a(3);
  }
  
  public final File b()
  {
    if ((g.a()) && (this.b > 0L))
    {
      File localFile = c.a(this.f);
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      return new File(localFile, this.e);
    }
    return null;
  }
  
  public final File c()
  {
    Object localObject = b();
    if (localObject != null)
    {
      File localFile = ((File)localObject).getParentFile();
      localObject = String.valueOf(((File)localObject).getName());
      if (((String)localObject).length() == 0) {}
      for (localObject = new String("temp.");; localObject = "temp.".concat((String)localObject)) {
        return new File(localFile, (String)localObject);
      }
    }
    return null;
  }
  
  public final boolean d()
  {
    a();
    if (this.c != 4)
    {
      int i = this.c;
      return (i == 5) || (i == 3);
    }
    Object localObject = b();
    if (localObject == null) {
      a("main file null");
    }
    for (;;)
    {
      a();
      break;
      File localFile = c();
      if (localFile == null)
      {
        a("temp file null");
      }
      else
      {
        if (localFile.length() != this.b)
        {
          localObject = String.valueOf(String.valueOf(localFile.length()));
          if (((String)localObject).length() == 0) {}
          for (localObject = new String("size mismatch: tempfile size=");; localObject = "size mismatch: tempfile size=".concat((String)localObject))
          {
            a((String)localObject);
            break;
          }
        }
        if (!localFile.renameTo((File)localObject)) {
          a("renameTo() returned false");
        }
      }
    }
  }
  
  public final boolean e()
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (this.c != 5)
    {
      a();
      bool1 = bool2;
      if (this.c != 3) {
        bool1 = false;
      }
    }
    return bool1;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject != null) && (getClass() == paramObject.getClass())) {
        paramObject = (a)paramObject;
      }
    }
    else {
      return (ai.a(this.e, ((a)paramObject).e)) && (ai.a(this.f, ((a)paramObject).f)) && (this.a == ((a)paramObject).a) && (this.d == ((a)paramObject).d) && (this.b == ((a)paramObject).b) && (this.c == ((a)paramObject).c);
    }
    return false;
  }
  
  public final void f()
  {
    File localFile = c();
    if (localFile != null) {
      localFile.delete();
    }
  }
  
  public final void g()
  {
    if (h()) {
      b().delete();
    }
  }
  
  public final String toString()
  {
    if (!this.a) {}
    for (String str2 = "Main";; str2 = "Patch")
    {
      String str3 = this.f;
      int i = this.d;
      int j = this.c;
      String str1;
      switch (j)
      {
      default: 
        str1 = Integer.toString(j);
      }
      for (;;)
      {
        return String.format("%s: %s v:%d %s", new Object[] { str2, str3, Integer.valueOf(i), str1 });
        str1 = "NOT_APPLICABLE";
        continue;
        str1 = "NOT_ON_STORAGE";
        continue;
        str1 = "DOWNLOADED";
        continue;
        str1 = "DOWNLOADING";
        continue;
        str1 = "DOWNLOAD_PENDING";
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/dc/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */