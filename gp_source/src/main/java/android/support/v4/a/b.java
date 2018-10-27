package android.support.v4.a;

import android.graphics.Path;
import java.util.ArrayList;

public final class b
{
  public static Path a(String paramString)
  {
    Path localPath = new Path();
    localObject = b(paramString);
    if (localObject != null) {}
    try
    {
      d.a((d[])localObject, localPath);
      return localPath;
    }
    catch (RuntimeException localRuntimeException)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Error in parsing ");
      ((StringBuilder)localObject).append(paramString);
      throw new RuntimeException(((StringBuilder)localObject).toString(), localRuntimeException);
    }
    return null;
  }
  
  private static void a(ArrayList paramArrayList, char paramChar, float[] paramArrayOfFloat)
  {
    paramArrayList.add(new d(paramChar, paramArrayOfFloat));
  }
  
  public static boolean a(d[] paramArrayOfd1, d[] paramArrayOfd2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramArrayOfd1 != null)
    {
      bool1 = bool2;
      if (paramArrayOfd2 != null)
      {
        bool1 = bool2;
        if (paramArrayOfd1.length == paramArrayOfd2.length)
        {
          int i = 0;
          while (i < paramArrayOfd1.length)
          {
            d locald1 = paramArrayOfd1[i];
            int j = locald1.b;
            d locald2 = paramArrayOfd2[i];
            bool1 = bool2;
            if (j != locald2.b) {
              break label96;
            }
            bool1 = bool2;
            if (locald1.a.length != locald2.a.length) {
              break label96;
            }
            i += 1;
          }
          bool1 = true;
        }
      }
    }
    label96:
    return bool1;
  }
  
  static float[] a(float[] paramArrayOfFloat, int paramInt)
  {
    if (paramInt >= 0)
    {
      int i = Math.min(paramInt, paramArrayOfFloat.length);
      float[] arrayOfFloat = new float[paramInt];
      System.arraycopy(paramArrayOfFloat, 0, arrayOfFloat, 0, i);
      return arrayOfFloat;
    }
    throw new IllegalArgumentException();
  }
  
  public static d[] a(d[] paramArrayOfd)
  {
    if (paramArrayOfd != null)
    {
      d[] arrayOfd = new d[paramArrayOfd.length];
      int i = 0;
      while (i < paramArrayOfd.length)
      {
        arrayOfd[i] = new d(paramArrayOfd[i]);
        i += 1;
      }
      return arrayOfd;
    }
    return null;
  }
  
  public static d[] b(String paramString)
  {
    ArrayList localArrayList;
    int i;
    int j;
    if (paramString != null)
    {
      localArrayList = new ArrayList();
      i = 1;
      j = 0;
      if (i < paramString.length()) {
        break label182;
      }
      if ((i - j == 1) && (j < paramString.length())) {
        a(localArrayList, paramString.charAt(j), new float[0]);
      }
      return (d[])localArrayList.toArray(new d[localArrayList.size()]);
    }
    label182:
    for (;;)
    {
      int k;
      if (i < paramString.length())
      {
        k = paramString.charAt(i);
        if (((k - 65) * (k - 90) > 0) && ((k - 97) * (k - 122) > 0)) {}
        while ((k == 101) || (k == 69))
        {
          i += 1;
          break;
        }
      }
      String str = paramString.substring(j, i).trim();
      if (str.length() <= 0) {}
      for (;;)
      {
        k = i + 1;
        j = i;
        i = k;
        break;
        float[] arrayOfFloat = c(str);
        a(localArrayList, str.charAt(0), arrayOfFloat);
      }
      return null;
    }
  }
  
  private static float[] c(String paramString)
  {
    if ((paramString.charAt(0) == 'z') || (paramString.charAt(0) == 'Z')) {
      return new float[0];
    }
    label160:
    label171:
    label310:
    label390:
    for (;;)
    {
      int n;
      int i2;
      int i1;
      int k;
      try
      {
        float[] arrayOfFloat = new float[paramString.length()];
        Object localObject = new c();
        int i4 = paramString.length();
        n = 1;
        int m = 0;
        if (n >= i4) {
          return a(arrayOfFloat, m);
        }
        ((c)localObject).b = false;
        i2 = 0;
        j = 0;
        i = 0;
        i1 = n;
        if (i1 < paramString.length()) {}
        switch (paramString.charAt(i1))
        {
        default: 
          ((c)localObject).b = true;
          k = 1;
          break label310;
          ((c)localObject).b = true;
          k = 1;
          break label310;
          ((c)localObject).a = i1;
          j = ((c)localObject).a;
          if (n < j)
          {
            i = m + 1;
            arrayOfFloat[m] = Float.parseFloat(paramString.substring(n, j));
            boolean bool = ((c)localObject).b;
            if (!bool)
            {
              n = j + 1;
              m = i;
              continue;
            }
            n = j;
            m = i;
            continue;
          }
          i = m;
          continue;
          k = i;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("error in parsing \"");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("\"");
        throw new RuntimeException(((StringBuilder)localObject).toString(), localNumberFormatException);
      }
      int i = j;
      int j = 0;
      for (;;)
      {
        if (k != 0) {
          break label390;
        }
        int i3 = i1 + 1;
        i1 = i;
        i = k;
        i2 = j;
        j = i1;
        i1 = i3;
        break;
        k = i;
        i = j;
        j = 1;
        continue;
        k = 1;
        break label310;
        if (j != 0) {
          break label160;
        }
        j = 0;
        k = i;
        i = 1;
        continue;
        k = i;
        if (i1 == n) {
          break label310;
        }
        if (i2 == 0) {
          break label171;
        }
        k = i;
        i = j;
        j = 0;
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */