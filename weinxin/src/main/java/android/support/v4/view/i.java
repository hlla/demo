package android.support.v4.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater.Factory;
import android.view.View;

final class i
{
  static class a
    implements LayoutInflater.Factory
  {
    final k xa;
    
    a(k paramk)
    {
      this.xa = paramk;
    }
    
    public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
    {
      return this.xa.onCreateView(null, paramString, paramContext, paramAttributeSet);
    }
    
    public String toString()
    {
      return getClass().getName() + "{" + this.xa + "}";
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v4/view/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */