package android.support.v4.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class al
  extends l
{
  private int e;
  private LayoutInflater f;
  private int g;
  
  @Deprecated
  public al(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.e = paramInt;
    this.g = paramInt;
    this.f = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
  }
  
  public View a(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
  {
    return this.f.inflate(this.g, paramViewGroup, false);
  }
  
  public final View b(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
  {
    return this.f.inflate(this.e, paramViewGroup, false);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/widget/al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */