package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.support.v7.c.a.a;
import android.util.AttributeSet;
import android.util.Log;
import org.xmlpull.v1.XmlPullParser;

final class af
  implements ai
{
  public final Drawable a(Context paramContext, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    try
    {
      paramContext = a.a(paramContext, paramContext.getResources(), paramXmlPullParser, paramAttributeSet, paramTheme);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      Log.e("AsldcInflateDelegate", "Exception while inflating <animated-selector>", paramContext);
    }
    return null;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */