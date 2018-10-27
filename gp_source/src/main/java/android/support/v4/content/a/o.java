package android.support.v4.content.a;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import org.xmlpull.v1.XmlPullParser;

public final class o
{
  public static float a(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, String paramString, int paramInt, float paramFloat)
  {
    float f = paramFloat;
    if (a(paramXmlPullParser, paramString)) {
      f = paramTypedArray.getFloat(paramInt, paramFloat);
    }
    return f;
  }
  
  public static int a(Context paramContext, int paramInt1, int paramInt2)
  {
    TypedValue localTypedValue = new TypedValue();
    paramContext.getTheme().resolveAttribute(paramInt1, localTypedValue, true);
    if (localTypedValue.resourceId == 0) {
      return paramInt2;
    }
    return paramInt1;
  }
  
  public static int a(TypedArray paramTypedArray, int paramInt1, int paramInt2)
  {
    return paramTypedArray.getInt(paramInt1, paramTypedArray.getInt(paramInt2, Integer.MAX_VALUE));
  }
  
  public static int a(TypedArray paramTypedArray, int paramInt1, int paramInt2, int paramInt3)
  {
    return paramTypedArray.getResourceId(paramInt1, paramTypedArray.getResourceId(paramInt2, paramInt3));
  }
  
  public static int a(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, String paramString, int paramInt)
  {
    int i = 0;
    if (a(paramXmlPullParser, paramString)) {
      i = paramTypedArray.getColor(paramInt, 0);
    }
    return i;
  }
  
  public static int a(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, String paramString, int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (a(paramXmlPullParser, paramString)) {
      i = paramTypedArray.getInt(paramInt1, paramInt2);
    }
    return i;
  }
  
  public static TypedArray a(Resources paramResources, Resources.Theme paramTheme, AttributeSet paramAttributeSet, int[] paramArrayOfInt)
  {
    if (paramTheme != null) {
      return paramTheme.obtainStyledAttributes(paramAttributeSet, paramArrayOfInt, 0, 0);
    }
    return paramResources.obtainAttributes(paramAttributeSet, paramArrayOfInt);
  }
  
  public static b a(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, Resources.Theme paramTheme, String paramString, int paramInt)
  {
    if (a(paramXmlPullParser, paramString))
    {
      paramXmlPullParser = new TypedValue();
      paramTypedArray.getValue(paramInt, paramXmlPullParser);
      if ((paramXmlPullParser.type >= 28) && (paramXmlPullParser.type <= 31)) {
        paramTypedArray = b.a(paramXmlPullParser.data);
      }
      do
      {
        return paramTypedArray;
        paramXmlPullParser = b.a(paramTypedArray.getResources(), paramTypedArray.getResourceId(paramInt, 0), paramTheme);
        paramTypedArray = paramXmlPullParser;
      } while (paramXmlPullParser != null);
    }
    return b.a(0);
  }
  
  public static TypedValue a(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, String paramString)
  {
    if (a(paramXmlPullParser, paramString)) {
      return paramTypedArray.peekValue(0);
    }
    return null;
  }
  
  public static boolean a(TypedArray paramTypedArray, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    return paramTypedArray.getBoolean(paramInt1, paramTypedArray.getBoolean(paramInt2, paramBoolean));
  }
  
  public static boolean a(XmlPullParser paramXmlPullParser, String paramString)
  {
    return paramXmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", paramString) != null;
  }
  
  public static int b(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, String paramString, int paramInt)
  {
    int i = 0;
    if (a(paramXmlPullParser, paramString)) {
      i = paramTypedArray.getResourceId(paramInt, 0);
    }
    return i;
  }
  
  public static String b(TypedArray paramTypedArray, int paramInt1, int paramInt2)
  {
    String str2 = paramTypedArray.getString(paramInt1);
    String str1 = str2;
    if (str2 == null) {
      str1 = paramTypedArray.getString(paramInt2);
    }
    return str1;
  }
  
  public static CharSequence c(TypedArray paramTypedArray, int paramInt1, int paramInt2)
  {
    CharSequence localCharSequence2 = paramTypedArray.getText(paramInt1);
    CharSequence localCharSequence1 = localCharSequence2;
    if (localCharSequence2 == null) {
      localCharSequence1 = paramTypedArray.getText(paramInt2);
    }
    return localCharSequence1;
  }
  
  public static String c(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, String paramString, int paramInt)
  {
    if (a(paramXmlPullParser, paramString)) {
      return paramTypedArray.getString(paramInt);
    }
    return null;
  }
  
  public static CharSequence[] d(TypedArray paramTypedArray, int paramInt1, int paramInt2)
  {
    CharSequence[] arrayOfCharSequence2 = paramTypedArray.getTextArray(paramInt1);
    CharSequence[] arrayOfCharSequence1 = arrayOfCharSequence2;
    if (arrayOfCharSequence2 == null) {
      arrayOfCharSequence1 = paramTypedArray.getTextArray(paramInt2);
    }
    return arrayOfCharSequence1;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/content/a/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */