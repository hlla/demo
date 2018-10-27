package android.support.v7.preference;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.support.v14.preference.SwitchPreference;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

final class ah
{
  private static final HashMap a = new HashMap();
  private static final Class[] b = { Context.class, AttributeSet.class };
  private final Object[] c = new Object[2];
  private final Context d;
  private String[] e;
  private ai f;
  
  public ah(Context paramContext, ai paramai)
  {
    this.d = paramContext;
    this.f = paramai;
    paramContext = new StringBuilder();
    paramContext.append(Preference.class.getPackage().getName());
    paramContext.append(".");
    paramContext = paramContext.toString();
    paramai = new StringBuilder();
    paramai.append(SwitchPreference.class.getPackage().getName());
    paramai.append(".");
    this.e = new String[] { paramContext, paramai.toString() };
  }
  
  private final Preference a(String paramString, AttributeSet paramAttributeSet)
  {
    try
    {
      if (paramString.indexOf('.') != -1) {
        return a(paramString, null, paramAttributeSet);
      }
      Preference localPreference = a(paramString, this.e, paramAttributeSet);
      return localPreference;
    }
    catch (InflateException paramString)
    {
      throw paramString;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramAttributeSet.getPositionDescription());
      localStringBuilder.append(": Error inflating class (not found)");
      localStringBuilder.append(paramString);
      paramString = new InflateException(localStringBuilder.toString());
      paramString.initCause(localClassNotFoundException);
      throw paramString;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramAttributeSet.getPositionDescription());
      localStringBuilder.append(": Error inflating class ");
      localStringBuilder.append(paramString);
      paramString = new InflateException(localStringBuilder.toString());
      paramString.initCause(localException);
      throw paramString;
    }
  }
  
  private final Preference a(String paramString, String[] paramArrayOfString, AttributeSet paramAttributeSet)
  {
    Object localObject2 = (Constructor)a.get(paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null) {}
    label87:
    do
    {
      try
      {
        localClassLoader = this.d.getClassLoader();
        if (paramArrayOfString != null) {
          break label87;
        }
        localObject2 = localClassLoader.loadClass(paramString);
      }
      catch (ClassNotFoundException paramString)
      {
        for (;;)
        {
          try
          {
            ClassLoader localClassLoader;
            int j;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append((String)localObject2);
            localStringBuilder.append(paramString);
            localObject2 = localClassLoader.loadClass(localStringBuilder.toString());
            paramArrayOfString = (String[])localObject2;
            localObject2 = paramArrayOfString;
            if (paramArrayOfString != null) {
              continue;
            }
            if (localObject1 != null) {
              break;
            }
            paramArrayOfString = new StringBuilder();
            paramArrayOfString.append(paramAttributeSet.getPositionDescription());
            paramArrayOfString.append(": Error inflating class ");
            paramArrayOfString.append(paramString);
            throw new InflateException(paramArrayOfString.toString());
          }
          catch (ClassNotFoundException localClassNotFoundException)
          {
            int i;
            i += 1;
          }
          paramString = paramString;
          throw paramString;
          paramArrayOfString = null;
        }
      }
      catch (Exception paramArrayOfString)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramAttributeSet.getPositionDescription());
        ((StringBuilder)localObject1).append(": Error inflating class ");
        ((StringBuilder)localObject1).append(paramString);
        paramString = new InflateException(((StringBuilder)localObject1).toString());
        paramString.initCause(paramArrayOfString);
        throw paramString;
      }
      localObject1 = ((Class)localObject2).getConstructor(b);
      ((Constructor)localObject1).setAccessible(true);
      a.put(paramString, localObject1);
      paramArrayOfString = this.c;
      paramArrayOfString[1] = paramAttributeSet;
      return (Preference)((Constructor)localObject1).newInstance(paramArrayOfString);
      j = paramArrayOfString.length;
    } while (j == 0);
    i = 0;
    localObject1 = null;
    for (;;)
    {
      if (i < j) {
        localObject2 = paramArrayOfString[i];
      }
    }
    throw localClassNotFoundException;
  }
  
  private final Preference a(XmlPullParser paramXmlPullParser, PreferenceGroup arg2)
  {
    Object localObject1;
    int i;
    Object localObject2;
    synchronized (this.c)
    {
      localObject1 = Xml.asAttributeSet(paramXmlPullParser);
      this.c[0] = this.d;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramXmlPullParser.getPositionDescription());
    localStringBuilder.append(": No start tag found!");
    throw new InflateException(localStringBuilder.toString());
  }
  
  private final void a(XmlPullParser paramXmlPullParser, Preference paramPreference, AttributeSet paramAttributeSet)
  {
    int i = paramXmlPullParser.getDepth();
    int j = paramXmlPullParser.next();
    if (j != 3) {}
    do
    {
      if (j == 1) {
        break label189;
      }
      if (j != 2) {
        break;
      }
      Object localObject = paramXmlPullParser.getName();
      if (!"intent".equals(localObject))
      {
        if (!"extra".equals(localObject))
        {
          localObject = a((String)localObject, paramAttributeSet);
          ((PreferenceGroup)paramPreference).a((Preference)localObject);
          a(paramXmlPullParser, (Preference)localObject, paramAttributeSet);
          break;
        }
        this.d.getResources().parseBundleExtra("extra", paramAttributeSet, paramPreference.h());
      }
      try
      {
        j = paramXmlPullParser.getDepth();
        int k;
        do
        {
          do
          {
            k = paramXmlPullParser.next();
            if (k == 1) {
              break;
            }
          } while (k != 3);
          k = paramXmlPullParser.getDepth();
        } while (k > j);
      }
      catch (IOException paramXmlPullParser)
      {
        paramPreference = new XmlPullParserException("Error parsing preference");
        paramPreference.initCause(paramXmlPullParser);
        throw paramPreference;
      }
      try
      {
        localObject = Intent.parseIntent(this.d.getResources(), paramXmlPullParser, paramAttributeSet);
        paramPreference.q = ((Intent)localObject);
      }
      catch (IOException paramXmlPullParser)
      {
        paramPreference = new XmlPullParserException("Error parsing preference");
        paramPreference.initCause(paramXmlPullParser);
        throw paramPreference;
      }
    } while (paramXmlPullParser.getDepth() > i);
    label189:
  }
  
  public final Preference a(int paramInt)
  {
    XmlResourceParser localXmlResourceParser = this.d.getResources().getXml(paramInt);
    try
    {
      Preference localPreference = a(localXmlResourceParser, null);
      return localPreference;
    }
    finally
    {
      localXmlResourceParser.close();
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/preference/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */