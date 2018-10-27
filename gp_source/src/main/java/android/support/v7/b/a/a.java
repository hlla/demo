package android.support.v7.b.a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.content.d;
import android.support.v7.widget.ae;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.util.Xml;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class a
{
  private static final ThreadLocal a = new ThreadLocal();
  private static final Object b = new Object();
  private static final WeakHashMap c = new WeakHashMap(0);
  
  public static ColorStateList a(Context paramContext, int paramInt)
  {
    Object localObject1;
    if (Build.VERSION.SDK_INT >= 23) {
      localObject1 = paramContext.getColorStateList(paramInt);
    }
    Object localObject2;
    do
    {
      return (ColorStateList)localObject1;
      localObject2 = d(paramContext, paramInt);
      localObject1 = localObject2;
    } while (localObject2 != null);
    ColorStateList localColorStateList = c(paramContext, paramInt);
    if (localColorStateList != null) {}
    synchronized (b)
    {
      localObject2 = (SparseArray)c.get(paramContext);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new SparseArray();
        c.put(paramContext, localObject1);
      }
      ((SparseArray)localObject1).append(paramInt, new b(localColorStateList, paramContext.getResources().getConfiguration()));
      return localColorStateList;
      return d.b(paramContext, paramInt);
    }
  }
  
  public static Drawable b(Context paramContext, int paramInt)
  {
    return ae.a().a(paramContext, paramInt);
  }
  
  private static ColorStateList c(Context paramContext, int paramInt)
  {
    Object localObject3 = paramContext.getResources();
    Object localObject2 = (TypedValue)a.get();
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new TypedValue();
      a.set(localObject1);
    }
    ((Resources)localObject3).getValue(paramInt, (TypedValue)localObject1, true);
    if ((((TypedValue)localObject1).type < 28) || (((TypedValue)localObject1).type > 31))
    {
      localObject1 = paramContext.getResources();
      localObject2 = ((Resources)localObject1).getXml(paramInt);
      try
      {
        paramContext = paramContext.getTheme();
        localObject3 = Xml.asAttributeSet((XmlPullParser)localObject2);
        do
        {
          paramInt = ((XmlPullParser)localObject2).next();
        } while ((paramInt != 2) && (paramInt != 1));
        if (paramInt != 2) {
          throw new XmlPullParserException("No start tag found");
        }
      }
      catch (Exception paramContext)
      {
        Log.e("AppCompatResources", "Failed to inflate ColorStateList, leaving it to the framework", paramContext);
        return null;
      }
      paramContext = android.support.v4.content.a.a.a((Resources)localObject1, (XmlPullParser)localObject2, (AttributeSet)localObject3, paramContext);
      return paramContext;
    }
    return null;
  }
  
  private static ColorStateList d(Context paramContext, int paramInt)
  {
    synchronized (b)
    {
      SparseArray localSparseArray = (SparseArray)c.get(paramContext);
      if ((localSparseArray != null) && (localSparseArray.size() > 0))
      {
        b localb = (b)localSparseArray.get(paramInt);
        if (localb != null)
        {
          if (localb.a.equals(paramContext.getResources().getConfiguration()))
          {
            paramContext = localb.b;
            return paramContext;
          }
          localSparseArray.remove(paramInt);
        }
      }
      return null;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/b/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */