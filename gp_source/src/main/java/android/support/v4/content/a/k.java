package android.support.v4.content.a;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.v4.g.i;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class k
{
  public static Typeface a(Context paramContext, int paramInt1, TypedValue paramTypedValue, int paramInt2, l paraml, boolean paramBoolean)
  {
    Resources localResources = paramContext.getResources();
    localResources.getValue(paramInt1, paramTypedValue, true);
    return a(paramContext, localResources, paramTypedValue, paramInt1, paramInt2, paraml, null, paramBoolean);
  }
  
  private static Typeface a(Context paramContext, Resources paramResources, TypedValue paramTypedValue, int paramInt1, int paramInt2, l paraml, Handler paramHandler, boolean paramBoolean)
  {
    if (paramTypedValue.string == null)
    {
      paramContext = new StringBuilder();
      paramContext.append("Resource \"");
      paramContext.append(paramResources.getResourceName(paramInt1));
      paramContext.append("\" (");
      paramContext.append(Integer.toHexString(paramInt1));
      paramContext.append(") is not a Font: ");
      paramContext.append(paramTypedValue);
      throw new Resources.NotFoundException(paramContext.toString());
    }
    paramHandler = paramTypedValue.string.toString();
    int i;
    Object localObject2;
    String str1;
    String str2;
    int j;
    int k;
    boolean bool;
    if (paramHandler.startsWith("res/"))
    {
      paramTypedValue = (Typeface)android.support.v4.a.e.a.a(android.support.v4.a.e.a(paramResources, paramInt1, paramInt2));
      if (paramTypedValue == null)
      {
        try
        {
          if (!paramHandler.toLowerCase().endsWith(".xml"))
          {
            paramResources = android.support.v4.a.e.a(paramContext, paramResources, paramInt1, paramHandler, paramInt2);
            paramContext = paramResources;
            if (paraml == null) {
              break label864;
            }
            if (paramResources == null)
            {
              paraml.a(-3, null);
              return paramResources;
            }
            paraml.a(paramResources, null);
            return paramResources;
          }
        }
        catch (XmlPullParserException paramContext)
        {
          paramResources = new StringBuilder();
          paramResources.append("Failed to parse xml resource ");
          paramResources.append(paramHandler);
          Log.e("ResourcesCompat", paramResources.toString(), paramContext);
          if (paraml != null) {
            paraml.a(-3, null);
          }
          return null;
          paramTypedValue = paramResources.getXml(paramInt1);
          do
          {
            i = paramTypedValue.next();
          } while ((i != 2) && (i != 1));
          if (i != 2) {
            throw new XmlPullParserException("No start tag found");
          }
        }
        catch (IOException paramContext)
        {
          for (;;)
          {
            paramResources = new StringBuilder();
            paramResources.append("Failed to read xml resource ");
            paramResources.append(paramHandler);
            Log.e("ResourcesCompat", paramResources.toString(), paramContext);
          }
          paramTypedValue.require(2, null, "font-family");
          if (!paramTypedValue.getName().equals("font-family")) {
            break label824;
          }
        }
        Object localObject1 = paramResources.obtainAttributes(Xml.asAttributeSet(paramTypedValue), android.support.a.a.e);
        localObject2 = ((TypedArray)localObject1).getString(0);
        str1 = ((TypedArray)localObject1).getString(4);
        str2 = ((TypedArray)localObject1).getString(5);
        i = ((TypedArray)localObject1).getResourceId(1, 0);
        j = ((TypedArray)localObject1).getInteger(2, 1);
        k = ((TypedArray)localObject1).getInteger(3, 500);
        ((TypedArray)localObject1).recycle();
        if (localObject2 != null) {
          break label879;
        }
        localObject1 = new ArrayList();
        while (paramTypedValue.next() != 3) {
          if (paramTypedValue.getEventType() == 2)
          {
            if (paramTypedValue.getName().equals("font"))
            {
              localObject2 = paramResources.obtainAttributes(Xml.asAttributeSet(paramTypedValue), android.support.a.a.f);
              if (!((TypedArray)localObject2).hasValue(8)) {}
              for (i = android.support.a.a.j;; i = android.support.a.a.o)
              {
                k = ((TypedArray)localObject2).getInt(i, 400);
                if (!((TypedArray)localObject2).hasValue(6)) {}
                for (i = android.support.a.a.h;; i = android.support.a.a.m)
                {
                  if (((TypedArray)localObject2).getInt(i, 0) != 1) {
                    break label866;
                  }
                  bool = true;
                  label510:
                  if (!((TypedArray)localObject2).hasValue(9)) {}
                  for (i = android.support.a.a.k;; i = android.support.a.a.p)
                  {
                    if (!((TypedArray)localObject2).hasValue(7)) {}
                    for (j = android.support.a.a.i;; j = android.support.a.a.n)
                    {
                      str1 = ((TypedArray)localObject2).getString(j);
                      j = ((TypedArray)localObject2).getInt(i, 0);
                      if (!((TypedArray)localObject2).hasValue(5)) {}
                      for (i = android.support.a.a.g;; i = android.support.a.a.l)
                      {
                        int m = ((TypedArray)localObject2).getResourceId(i, 0);
                        str2 = ((TypedArray)localObject2).getString(i);
                        ((TypedArray)localObject2).recycle();
                        for (;;)
                        {
                          if (paramTypedValue.next() == 3)
                          {
                            ((List)localObject1).add(new f(str2, k, bool, str1, j, m));
                            break;
                          }
                          c.a(paramTypedValue);
                        }
                      }
                    }
                  }
                }
              }
            }
            c.a(paramTypedValue);
          }
        }
        if (((List)localObject1).isEmpty()) {
          break label874;
        }
        paramTypedValue = new e((f[])((List)localObject1).toArray(new f[((List)localObject1).size()]));
        label729:
        if (paramTypedValue != null) {
          return android.support.v4.a.e.a(paramContext, paramTypedValue, paramResources, paramInt1, paramInt2, paraml, null, paramBoolean);
        }
        Log.e("ResourcesCompat", "Failed to find font-family tag");
        if (paraml == null) {
          break label872;
        }
        paraml.a(-3, null);
        break label872;
      }
    }
    for (;;)
    {
      if (paramTypedValue.next() == 3)
      {
        paramTypedValue = new g(new android.support.v4.e.a((String)localObject2, str1, str2, c.a(paramResources, i)), j, k);
        break label729;
      }
      c.a(paramTypedValue);
      continue;
      label824:
      c.a(paramTypedValue);
      paramTypedValue = null;
      break label729;
      paramContext = paramTypedValue;
      if (paraml != null)
      {
        paraml.a(paramTypedValue, null);
        return paramTypedValue;
        if (paraml != null) {
          paraml.a(-3, null);
        }
        paramContext = null;
      }
      label864:
      return paramContext;
      label866:
      bool = false;
      break label510;
      label872:
      return null;
      label874:
      paramTypedValue = null;
      break label729;
      label879:
      if ((str1 == null) || (str2 == null)) {
        break;
      }
    }
  }
  
  public static Drawable a(Resources paramResources, int paramInt, Resources.Theme paramTheme)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramResources.getDrawable(paramInt, paramTheme);
    }
    return paramResources.getDrawable(paramInt);
  }
  
  public static int b(Resources paramResources, int paramInt, Resources.Theme paramTheme)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return paramResources.getColor(paramInt, paramTheme);
    }
    return paramResources.getColor(paramInt);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/content/a/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */