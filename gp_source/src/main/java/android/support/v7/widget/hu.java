package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;

final class hu
{
  public final View a;
  public final Context b;
  public final WindowManager.LayoutParams c = new WindowManager.LayoutParams();
  public final TextView d;
  public final int[] e = new int[2];
  public final int[] f = new int[2];
  public final Rect g = new Rect();
  
  hu(Context paramContext)
  {
    this.b = paramContext;
    this.a = LayoutInflater.from(this.b).inflate(2131623963, null);
    this.d = ((TextView)this.a.findViewById(2131428535));
    this.c.setTitle(getClass().getSimpleName());
    this.c.packageName = this.b.getPackageName();
    this.c.type = 1002;
    this.c.width = -2;
    this.c.height = -2;
    this.c.format = -3;
    this.c.windowAnimations = 2132017176;
    this.c.flags = 24;
  }
  
  final void a()
  {
    if (b()) {
      ((WindowManager)this.b.getSystemService("window")).removeView(this.a);
    }
  }
  
  final boolean b()
  {
    return this.a.getParent() != null;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/hu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */