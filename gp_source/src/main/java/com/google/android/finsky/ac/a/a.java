package com.google.android.finsky.ac.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Build.VERSION;
import com.google.android.finsky.dfemodel.Document;
import com.google.android.finsky.ds.a.bf;
import com.google.android.finsky.ds.a.de;
import com.google.android.finsky.ds.a.o;
import com.google.android.finsky.f.c;
import com.google.android.finsky.utils.t;

public final class a
  implements com.google.android.finsky.ac.a
{
  private final c a;
  private final Context b;
  private final com.google.android.finsky.dt.a c;
  
  public a(Context paramContext, com.google.android.finsky.dt.a parama, c paramc)
  {
    this.b = paramContext;
    this.c = parama;
    this.a = paramc;
  }
  
  public final boolean a(Document paramDocument)
  {
    if ((this.c.df()) && (!this.a.a(paramDocument)))
    {
      Object localObject = this.b.getPackageManager();
      try
      {
        localObject = ((PackageManager)localObject).getPackageInfo(paramDocument.a.s, 4202560);
        if (((PackageInfo)localObject).signatures != null)
        {
          int j = ((PackageInfo)localObject).signatures.length;
          String[] arrayOfString = new String[j];
          int i = 0;
          for (;;)
          {
            if (i >= j) {
              return a(arrayOfString, paramDocument.U().d) ^ true;
            }
            arrayOfString[i] = t.a(localObject.signatures[i].toByteArray());
            i += 1;
          }
        }
        return true;
      }
      catch (NameNotFoundException paramDocument) {}
    }
    return false;
  }
  
  public final boolean a(String[] paramArrayOfString, bf[] paramArrayOfbf)
  {
    boolean bool2 = false;
    boolean bool1;
    int j;
    if (Build.VERSION.SDK_INT >= 21)
    {
      i = paramArrayOfbf.length;
      bool1 = bool2;
      if (i != 0)
      {
        j = paramArrayOfString.length;
        bool1 = bool2;
        if (j != 0)
        {
          bool1 = bool2;
          if (j <= i)
          {
            i = 0;
            while (i < paramArrayOfString.length)
            {
              j = 0;
              for (;;)
              {
                bool1 = bool2;
                if (j >= paramArrayOfbf.length) {
                  break label104;
                }
                if (paramArrayOfString[i].equals(paramArrayOfbf[j].a[0])) {
                  break;
                }
                j += 1;
              }
              i += 1;
            }
            bool1 = true;
          }
        }
      }
    }
    label104:
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramArrayOfbf.length == 0);
      bool1 = bool2;
    } while (paramArrayOfString.length == 0);
    int i = 0;
    label127:
    if (i < paramArrayOfString.length)
    {
      j = 0;
      for (;;)
      {
        bool1 = bool2;
        if (j >= paramArrayOfbf.length) {
          break;
        }
        int k = 0;
        for (;;)
        {
          String[] arrayOfString = paramArrayOfbf[j].a;
          if (k >= arrayOfString.length) {
            break label197;
          }
          if (paramArrayOfString[i].equals(arrayOfString[k])) {
            break;
          }
          k += 1;
        }
        i += 1;
        break label127;
        label197:
        j += 1;
      }
    }
    return true;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ac/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */