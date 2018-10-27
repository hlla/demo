package android.support.v7.widget;

import android.content.Context;
import android.support.v7.view.menu.ad;
import android.support.v7.view.menu.p;
import android.view.View;

public final class ek
{
  public final Context a;
  public final p b;
  public en c;
  public final ad d;
  
  public ek(Context paramContext, View paramView)
  {
    this(paramContext, paramView, (byte)0);
  }
  
  private ek(Context paramContext, View paramView, byte paramByte)
  {
    this(paramContext, paramView, '\000');
  }
  
  private ek(Context paramContext, View paramView, char paramChar)
  {
    this.a = paramContext;
    this.b = new p(paramContext);
    this.b.a(new el(this));
    this.d = new ad(paramContext, this.b, paramView, false, 2130969425, 0);
    paramContext = this.d;
    paramContext.b = 0;
    paramContext.c = new em();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/ek.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */