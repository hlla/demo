package android.support.v4.b.a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

class f
  extends d
{
  f(Drawable paramDrawable)
  {
    super(paramDrawable);
  }
  
  f(d.a parama, Resources paramResources)
  {
    super(parama, paramResources);
  }
  
  d.a bq()
  {
    return new a(this.tT);
  }
  
  public void jumpToCurrentState()
  {
    this.mDrawable.jumpToCurrentState();
  }
  
  private static final class a
    extends d.a
  {
    a(d.a parama)
    {
      super();
    }
    
    public final Drawable newDrawable(Resources paramResources)
    {
      return new f(this, paramResources);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v4/b/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */