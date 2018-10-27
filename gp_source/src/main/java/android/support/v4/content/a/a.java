package android.support.v4.content.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.StateSet;
import java.lang.reflect.Array;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class a
{
  public static ColorStateList a(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    Object localObject1 = paramXmlPullParser.getName();
    if (!((String)localObject1).equals("selector"))
    {
      paramResources = new StringBuilder();
      paramResources.append(paramXmlPullParser.getPositionDescription());
      paramResources.append(": invalid color state list tag ");
      paramResources.append((String)localObject1);
      throw new XmlPullParserException(paramResources.toString());
    }
    int i1 = paramXmlPullParser.getDepth() + 1;
    localObject1 = new int[20][];
    Object localObject2 = new int[20];
    int j = 0;
    int i;
    do
    {
      int k;
      while ((i != 2) || (k > i1) || (!paramXmlPullParser.getName().equals("item")))
      {
        i = paramXmlPullParser.next();
        if (i == 1) {
          break label511;
        }
        k = paramXmlPullParser.getDepth();
        if (k < i1) {
          break;
        }
      }
      Object localObject3 = android.support.a.a.a;
      if (paramTheme == null) {}
      for (localObject3 = paramResources.obtainAttributes(paramAttributeSet, (int[])localObject3);; localObject3 = paramTheme.obtainStyledAttributes(paramAttributeSet, (int[])localObject3, 0, 0))
      {
        int i2 = ((TypedArray)localObject3).getColor(android.support.a.a.d, -65281);
        float f;
        if (((TypedArray)localObject3).hasValue(android.support.a.a.c)) {
          f = ((TypedArray)localObject3).getFloat(android.support.a.a.c, 1.0F);
        }
        for (;;)
        {
          ((TypedArray)localObject3).recycle();
          int i3 = paramAttributeSet.getAttributeCount();
          localObject3 = new int[i3];
          i = 0;
          k = 0;
          if (k >= i3)
          {
            int[] arrayOfInt = StateSet.trimStateSet((int[])localObject3, i);
            k = Math.round(f * Color.alpha(i2));
            i = j + 1;
            if (i > localObject2.length)
            {
              localObject3 = new int[j.a(j)];
              System.arraycopy(localObject2, 0, localObject3, 0, j);
              localObject2 = localObject3;
            }
            for (;;)
            {
              localObject2[j] = (0xFFFFFF & i2 | k << 24);
              if (i > localObject1.length)
              {
                localObject3 = (Object[])Array.newInstance(localObject1.getClass().getComponentType(), j.a(j));
                System.arraycopy(localObject1, 0, localObject3, 0, j);
                localObject1 = localObject3;
              }
              for (;;)
              {
                localObject1[j] = arrayOfInt;
                localObject1 = (int[][])localObject1;
                j = i;
                break;
              }
            }
          }
          int n = paramAttributeSet.getAttributeNameResource(k);
          if (n != 16843173) {
            if (n != 16843551) {
              if (n != 2130968636)
              {
                int m = n;
                if (!paramAttributeSet.getAttributeBooleanValue(k, false)) {
                  m = -n;
                }
                localObject3[i] = m;
                i += 1;
              }
            }
          }
          for (;;)
          {
            k += 1;
            break;
            continue;
          }
          if (((TypedArray)localObject3).hasValue(android.support.a.a.b)) {
            f = ((TypedArray)localObject3).getFloat(android.support.a.a.b, 1.0F);
          } else {
            f = 1.0F;
          }
        }
      }
    } while (i != 3);
    label511:
    paramResources = new int[j];
    paramXmlPullParser = new int[j][];
    System.arraycopy(localObject2, 0, paramResources, 0, j);
    System.arraycopy(localObject1, 0, paramXmlPullParser, 0, j);
    return new ColorStateList(paramXmlPullParser, paramResources);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/content/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */