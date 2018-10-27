package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.support.d.a.b;
import android.util.AttributeSet;
import android.util.Log;
import org.xmlpull.v1.XmlPullParser;

final class ag
  implements ai
{
  public final Drawable a(Context paramContext, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    try
    {
      paramContext = b.a(paramContext, paramContext.getResources(), paramXmlPullParser, paramAttributeSet, paramTheme);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", paramContext);
    }
    return null;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */