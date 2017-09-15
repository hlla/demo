package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.widget.CompoundButton;

public final class c
{
  private static final c Be = new b();
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 23)
    {
      Be = new a();
      return;
    }
    if (i >= 21)
    {
      Be = new d();
      return;
    }
  }
  
  public static Drawable a(CompoundButton paramCompoundButton)
  {
    return Be.a(paramCompoundButton);
  }
  
  public static void a(CompoundButton paramCompoundButton, ColorStateList paramColorStateList)
  {
    Be.a(paramCompoundButton, paramColorStateList);
  }
  
  public static void a(CompoundButton paramCompoundButton, PorterDuff.Mode paramMode)
  {
    Be.a(paramCompoundButton, paramMode);
  }
  
  static final class a
    extends c.d
  {
    public final Drawable a(CompoundButton paramCompoundButton)
    {
      return paramCompoundButton.getButtonDrawable();
    }
  }
  
  static class b
    implements c.c
  {
    public Drawable a(CompoundButton paramCompoundButton)
    {
      return d.a(paramCompoundButton);
    }
    
    public void a(CompoundButton paramCompoundButton, ColorStateList paramColorStateList)
    {
      if ((paramCompoundButton instanceof t)) {
        ((t)paramCompoundButton).e(paramColorStateList);
      }
    }
    
    public void a(CompoundButton paramCompoundButton, PorterDuff.Mode paramMode)
    {
      if ((paramCompoundButton instanceof t)) {
        ((t)paramCompoundButton).b(paramMode);
      }
    }
  }
  
  static abstract interface c
  {
    public abstract Drawable a(CompoundButton paramCompoundButton);
    
    public abstract void a(CompoundButton paramCompoundButton, ColorStateList paramColorStateList);
    
    public abstract void a(CompoundButton paramCompoundButton, PorterDuff.Mode paramMode);
  }
  
  static class d
    extends c.b
  {
    public final void a(CompoundButton paramCompoundButton, ColorStateList paramColorStateList)
    {
      paramCompoundButton.setButtonTintList(paramColorStateList);
    }
    
    public final void a(CompoundButton paramCompoundButton, PorterDuff.Mode paramMode)
    {
      paramCompoundButton.setButtonTintMode(paramMode);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v4/widget/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */