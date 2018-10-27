package android.support.v4.content.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class b
{
  public int a;
  public final Shader b;
  private final ColorStateList c;
  
  private b(Shader paramShader, ColorStateList paramColorStateList, int paramInt)
  {
    this.b = paramShader;
    this.c = paramColorStateList;
    this.a = paramInt;
  }
  
  static b a(int paramInt)
  {
    return new b(null, null, paramInt);
  }
  
  public static b a(Resources paramResources, int paramInt, Resources.Theme paramTheme)
  {
    XmlResourceParser localXmlResourceParser;
    AttributeSet localAttributeSet;
    try
    {
      localXmlResourceParser = paramResources.getXml(paramInt);
      localAttributeSet = Xml.asAttributeSet(localXmlResourceParser);
      do
      {
        paramInt = localXmlResourceParser.next();
      } while ((paramInt != 2) && (paramInt != 1));
      if (paramInt != 2) {
        throw new XmlPullParserException("No start tag found");
      }
    }
    catch (Exception paramResources)
    {
      Log.e("ComplexColorCompat", "Failed to inflate ComplexColor.", paramResources);
      return null;
    }
    Object localObject = localXmlResourceParser.getName();
    int i1;
    switch (((String)localObject).hashCode())
    {
    case 1191572447: 
      paramResources = new StringBuilder();
      paramResources.append(localXmlResourceParser.getPositionDescription());
      paramResources.append(": unsupported complex color tag ");
      paramResources.append((String)localObject);
      throw new XmlPullParserException(paramResources.toString());
      localObject = localXmlResourceParser.getName();
      if (!((String)localObject).equals("gradient"))
      {
        paramResources = new StringBuilder();
        paramResources.append(localXmlResourceParser.getPositionDescription());
        paramResources.append(": invalid gradient color tag ");
        paramResources.append((String)localObject);
        throw new XmlPullParserException(paramResources.toString());
      }
      localObject = o.a(paramResources, paramTheme, localAttributeSet, android.support.a.a.q);
      float f1 = o.a((TypedArray)localObject, localXmlResourceParser, "startX", 8, 0.0F);
      float f2 = o.a((TypedArray)localObject, localXmlResourceParser, "startY", 9, 0.0F);
      float f3 = o.a((TypedArray)localObject, localXmlResourceParser, "endX", 10, 0.0F);
      float f4 = o.a((TypedArray)localObject, localXmlResourceParser, "endY", 11, 0.0F);
      float f5 = o.a((TypedArray)localObject, localXmlResourceParser, "centerX", 3, 0.0F);
      float f6 = o.a((TypedArray)localObject, localXmlResourceParser, "centerY", 4, 0.0F);
      paramInt = o.a((TypedArray)localObject, localXmlResourceParser, "type", 2, 0);
      int i = o.a((TypedArray)localObject, localXmlResourceParser, "startColor", 0);
      boolean bool1 = o.a(localXmlResourceParser, "centerColor");
      int j = o.a((TypedArray)localObject, localXmlResourceParser, "centerColor", 7);
      int k = o.a((TypedArray)localObject, localXmlResourceParser, "endColor", 1);
      int m = o.a((TypedArray)localObject, localXmlResourceParser, "tileMode", 6, 0);
      float f7 = o.a((TypedArray)localObject, localXmlResourceParser, "gradientRadius", 5, 0.0F);
      ((TypedArray)localObject).recycle();
      int n = localXmlResourceParser.getDepth() + 1;
      localObject = new ArrayList(20);
      ArrayList localArrayList = new ArrayList(20);
      for (;;)
      {
        i1 = localXmlResourceParser.next();
        if (i1 == 1) {
          break;
        }
        int i2 = localXmlResourceParser.getDepth();
        if (i2 < n) {
          break label875;
        }
        if ((i1 == 2) && (i2 <= n) && (localXmlResourceParser.getName().equals("item")))
        {
          TypedArray localTypedArray = o.a(paramResources, paramTheme, localAttributeSet, android.support.a.a.r);
          boolean bool2 = localTypedArray.hasValue(0);
          boolean bool3 = localTypedArray.hasValue(1);
          if (!bool2) {}
          while (!bool3)
          {
            paramResources = new StringBuilder();
            paramResources.append(localXmlResourceParser.getPositionDescription());
            paramResources.append(": <item> tag requires a 'color' attribute and a 'offset' ");
            paramResources.append("attribute!");
            throw new XmlPullParserException(paramResources.toString());
          }
          i1 = localTypedArray.getColor(0, 0);
          float f8 = localTypedArray.getFloat(1, 0.0F);
          localTypedArray.recycle();
          localArrayList.add(Integer.valueOf(i1));
          ((List)localObject).add(Float.valueOf(f8));
        }
      }
      if (localArrayList.size() > 0)
      {
        paramResources = new i(localArrayList, (List)localObject);
        break label884;
        paramResources = new LinearGradient(f1, f2, f3, f4, paramResources.a, paramResources.b, h.a(m));
        for (;;)
        {
          return new b(paramResources, null, 0);
          paramResources = new SweepGradient(f5, f6, paramResources.a, paramResources.b);
          continue;
          if (f7 <= 0.0F) {
            break;
          }
          paramResources = new RadialGradient(f5, f6, f7, paramResources.a, paramResources.b, h.a(m));
        }
        if (!bool1)
        {
          paramResources = new i(i, k);
        }
        else
        {
          paramResources = new i(i, j, k);
          break label888;
          paramResources = a.a(paramResources, localXmlResourceParser, localAttributeSet, paramTheme);
          return new b(null, paramResources, paramResources.getDefaultColor());
          if (!((String)localObject).equals("selector")) {
            break label920;
          }
          paramInt = 0;
        }
      }
      break;
    case 89650992: 
      if (((String)localObject).equals("gradient"))
      {
        paramInt = 1;
        break;
        throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
      }
      break;
    default: 
      label458:
      label622:
      label746:
      paramInt = -1;
    }
    for (;;)
    {
      switch (paramInt)
      {
      }
      break;
      label875:
      if (i1 != 3) {
        break label458;
      }
      break label622;
      for (;;)
      {
        label884:
        if (paramResources == null) {
          break label918;
        }
        label888:
        switch (paramInt)
        {
        }
        break;
        paramResources = null;
      }
      label918:
      break label746;
      label920:
      paramInt = -1;
      continue;
      paramInt = -1;
    }
  }
  
  public final boolean a()
  {
    return this.b != null;
  }
  
  public final boolean a(int[] paramArrayOfInt)
  {
    if (b())
    {
      ColorStateList localColorStateList = this.c;
      int i = localColorStateList.getColorForState(paramArrayOfInt, localColorStateList.getDefaultColor());
      if (i != this.a)
      {
        this.a = i;
        return true;
      }
    }
    return false;
  }
  
  public final boolean b()
  {
    if (this.b == null)
    {
      ColorStateList localColorStateList = this.c;
      if ((localColorStateList != null) && (localColorStateList.isStateful())) {
        return true;
      }
    }
    return false;
  }
  
  public final boolean c()
  {
    return (a()) || (this.a != 0);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/content/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */