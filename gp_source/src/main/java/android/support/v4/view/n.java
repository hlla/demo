package android.support.v4.view;

import android.os.Build.VERSION;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.LayoutInflater.Factory2;
import java.lang.reflect.Field;

public final class n
{
  private static boolean a;
  private static Field b;
  
  public static void a(LayoutInflater paramLayoutInflater, LayoutInflater.Factory2 paramFactory2)
  {
    paramLayoutInflater.setFactory2(paramFactory2);
    if (Build.VERSION.SDK_INT < 21)
    {
      LayoutInflater.Factory localFactory = paramLayoutInflater.getFactory();
      if ((localFactory instanceof LayoutInflater.Factory2)) {
        b(paramLayoutInflater, (LayoutInflater.Factory2)localFactory);
      }
    }
    else
    {
      return;
    }
    b(paramLayoutInflater, paramFactory2);
  }
  
  private static void b(LayoutInflater paramLayoutInflater, LayoutInflater.Factory2 paramFactory2)
  {
    if (!a) {}
    try
    {
      Field localField = LayoutInflater.class.getDeclaredField("mFactory2");
      b = localField;
      localField.setAccessible(true);
      a = true;
      if (b == null) {}
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;)
      {
        try
        {
          b.set(paramLayoutInflater, paramFactory2);
          return;
        }
        catch (IllegalAccessException paramFactory2)
        {
          StringBuilder localStringBuilder2;
          StringBuilder localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("forceSetFactory2 could not set the Factory2 on LayoutInflater ");
          localStringBuilder1.append(paramLayoutInflater);
          localStringBuilder1.append("; inflation may have unexpected results.");
          Log.e("LayoutInflaterCompatHC", localStringBuilder1.toString(), paramFactory2);
        }
        localNoSuchFieldException = localNoSuchFieldException;
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("forceSetFactory2 Could not find field 'mFactory2' on class ");
        localStringBuilder2.append(LayoutInflater.class.getName());
        localStringBuilder2.append("; inflation may have unexpected results.");
        Log.e("LayoutInflaterCompatHC", localStringBuilder2.toString(), localNoSuchFieldException);
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/view/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */