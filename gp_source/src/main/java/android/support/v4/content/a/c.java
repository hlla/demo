package android.support.v4.content.a;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.Base64;
import android.util.TypedValue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

public final class c
{
  public static List a(Resources paramResources, int paramInt)
  {
    int j = 0;
    TypedArray localTypedArray;
    if (paramInt != 0) {
      localTypedArray = paramResources.obtainTypedArray(paramInt);
    }
    for (;;)
    {
      try
      {
        if (localTypedArray.length() == 0) {
          break label152;
        }
        ArrayList localArrayList = new ArrayList();
        if (Build.VERSION.SDK_INT >= 21)
        {
          i = localTypedArray.getType(0);
          if (i != 1)
          {
            localArrayList.add(a(paramResources.getStringArray(paramInt)));
            return localArrayList;
          }
          if (j >= localTypedArray.length()) {
            continue;
          }
          paramInt = localTypedArray.getResourceId(j, 0);
          if (paramInt == 0) {
            break label167;
          }
          localArrayList.add(a(paramResources.getStringArray(paramInt)));
        }
      }
      finally
      {
        localTypedArray.recycle();
      }
      TypedValue localTypedValue = new TypedValue();
      localTypedArray.getValue(0, localTypedValue);
      int i = localTypedValue.type;
      continue;
      label152:
      paramResources = Collections.emptyList();
      localTypedArray.recycle();
      return paramResources;
      return Collections.emptyList();
      label167:
      j += 1;
    }
  }
  
  private static List a(String[] paramArrayOfString)
  {
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(Base64.decode(paramArrayOfString[i], 0));
      i += 1;
    }
    return localArrayList;
  }
  
  static void a(XmlPullParser paramXmlPullParser)
  {
    int i = 1;
    while (i > 0) {
      switch (paramXmlPullParser.next())
      {
      default: 
        break;
      case 2: 
        i += 1;
        break;
      case 3: 
        i -= 1;
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/content/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */