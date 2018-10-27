package android.support.v7.app;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.view.b;
import android.view.KeyEvent;

public abstract class a
{
  public b a(android.support.v7.view.c paramc)
  {
    return null;
  }
  
  public abstract void a();
  
  public void a(float paramFloat)
  {
    if (paramFloat != 0.0F) {
      throw new UnsupportedOperationException("Setting a non-zero elevation is not supported in this action bar configuration.");
    }
  }
  
  public void a(int paramInt) {}
  
  public abstract void a(int paramInt1, int paramInt2);
  
  public abstract void a(Drawable paramDrawable);
  
  public abstract void a(c paramc);
  
  public abstract void a(CharSequence paramCharSequence);
  
  public abstract void a(boolean paramBoolean);
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public boolean a(KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public abstract int b();
  
  public void b(int paramInt) {}
  
  public abstract void b(Drawable paramDrawable);
  
  public abstract void b(CharSequence paramCharSequence);
  
  public void b(boolean paramBoolean) {}
  
  public abstract int c();
  
  public void c(Drawable paramDrawable) {}
  
  public void c(CharSequence paramCharSequence) {}
  
  public void c(boolean paramBoolean) {}
  
  public abstract void d();
  
  public void d(boolean paramBoolean) {}
  
  public void e() {}
  
  public Context f()
  {
    return null;
  }
  
  public void g()
  {
    throw new UnsupportedOperationException("Hide on content scroll is not supported in this action bar configuration.");
  }
  
  public void h() {}
  
  public boolean i()
  {
    return false;
  }
  
  public boolean j()
  {
    return false;
  }
  
  public boolean k()
  {
    return false;
  }
  
  public boolean l()
  {
    return false;
  }
  
  void m() {}
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/app/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */