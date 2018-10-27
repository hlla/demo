package android.support.v4.a;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.support.v4.content.a.f;
import android.support.v4.e.r;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

class j
{
  protected static Typeface a(Context paramContext, InputStream paramInputStream)
  {
    Object localObject = null;
    File localFile = n.a(paramContext);
    paramContext = (Context)localObject;
    if (localFile != null) {}
    try
    {
      if (n.a(localFile, paramInputStream))
      {
        paramContext = Typeface.createFromFile(localFile.getPath());
        localFile.delete();
        return paramContext;
      }
      localFile.delete();
      return null;
    }
    catch (RuntimeException paramContext)
    {
      paramContext = paramContext;
      localFile.delete();
      return null;
    }
    finally
    {
      paramContext = finally;
      localFile.delete();
      throw paramContext;
    }
  }
  
  protected static r a(r[] paramArrayOfr, int paramInt)
  {
    return (r)a(paramArrayOfr, paramInt, new k());
  }
  
  private static Object a(Object[] paramArrayOfObject, int paramInt, m paramm)
  {
    if ((paramInt & 0x1) == 0) {}
    Object localObject1;
    for (int i = 400;; i = 700)
    {
      if ((paramInt & 0x2) == 0) {}
      for (int i1 = 0;; i1 = 1)
      {
        int m = paramArrayOfObject.length;
        localObject1 = null;
        paramInt = Integer.MAX_VALUE;
        int j = 0;
        if (j >= m) {
          break;
        }
        Object localObject2 = paramArrayOfObject[j];
        int n = Math.abs(paramm.b(localObject2) - i);
        if (paramm.a(localObject2) == i1) {}
        for (int k = 0;; k = 1)
        {
          k += n + n;
          if (localObject1 == null)
          {
            localObject1 = localObject2;
            paramInt = k;
          }
          for (;;)
          {
            j += 1;
            break;
            if (paramInt > k)
            {
              localObject1 = localObject2;
              paramInt = k;
            }
          }
        }
      }
    }
    return localObject1;
  }
  
  public Typeface a(Context paramContext, Resources paramResources, int paramInt1, String paramString, int paramInt2)
  {
    paramString = null;
    File localFile = n.a(paramContext);
    paramContext = paramString;
    if (localFile != null) {}
    try
    {
      if (n.a(localFile, paramResources, paramInt1))
      {
        paramContext = Typeface.createFromFile(localFile.getPath());
        localFile.delete();
        return paramContext;
      }
      localFile.delete();
      return null;
    }
    catch (RuntimeException paramContext)
    {
      paramContext = paramContext;
      localFile.delete();
      return null;
    }
    finally
    {
      paramContext = finally;
      localFile.delete();
      throw paramContext;
    }
  }
  
  public Typeface a(Context paramContext, CancellationSignal paramCancellationSignal, r[] paramArrayOfr, int paramInt)
  {
    paramCancellationSignal = null;
    if (paramArrayOfr.length > 0) {
      paramCancellationSignal = a(paramArrayOfr, paramInt);
    }
    try
    {
      paramCancellationSignal = paramContext.getContentResolver().openInputStream(paramCancellationSignal.d);
      n.a(paramCancellationSignal);
    }
    catch (IOException paramContext)
    {
      try
      {
        paramContext = a(paramContext, paramCancellationSignal);
        n.a(paramCancellationSignal);
        paramCancellationSignal = paramContext;
        return paramCancellationSignal;
      }
      catch (IOException paramContext)
      {
        for (;;)
        {
          paramContext = paramContext;
        }
      }
      finally
      {
        for (;;)
        {
          paramContext = finally;
        }
      }
      paramContext = paramContext;
      paramCancellationSignal = null;
      n.a(paramCancellationSignal);
      return null;
    }
    finally
    {
      paramContext = finally;
      paramCancellationSignal = null;
    }
    throw paramContext;
  }
  
  public Typeface a(Context paramContext, android.support.v4.content.a.e parame, Resources paramResources, int paramInt)
  {
    parame = (f)a(parame.a, paramInt, new l());
    if (parame != null) {
      return e.a(paramContext, paramResources, parame.c, parame.a, paramInt);
    }
    return null;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/a/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */