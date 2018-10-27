package android.support.v7.app;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ac;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.bj;
import android.support.v7.widget.hl;
import android.support.v7.widget.hn;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.ViewGroup;
import android.view.Window.Callback;
import java.util.ArrayList;

final class ax
  extends a
{
  public bj a;
  public boolean b;
  public Window.Callback c;
  private boolean d;
  private boolean e;
  private final hl f = new az(this);
  private final Runnable g = new ay(this);
  private ArrayList h = new ArrayList();
  
  ax(Toolbar paramToolbar, CharSequence paramCharSequence, Window.Callback paramCallback)
  {
    this.a = new hn(paramToolbar, false);
    this.c = new bc(this, paramCallback);
    this.a.a(this.c);
    paramToolbar.setOnMenuItemClickListener(this.f);
    this.a.a(paramCharSequence);
  }
  
  public final void a()
  {
    a(2, 2);
  }
  
  public final void a(float paramFloat)
  {
    ac.g(this.a.a(), paramFloat);
  }
  
  public final void a(int paramInt)
  {
    this.a.d(paramInt);
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    int i = this.a.o();
    this.a.c(i & (paramInt2 ^ 0xFFFFFFFF) | paramInt1 & paramInt2);
  }
  
  public final void a(Drawable paramDrawable)
  {
    this.a.b(paramDrawable);
  }
  
  public final void a(c paramc)
  {
    this.h.add(paramc);
  }
  
  public final void a(CharSequence paramCharSequence)
  {
    this.a.b(paramCharSequence);
  }
  
  public final void a(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      a(i, 4);
      return;
    }
  }
  
  public final boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = false;
    Menu localMenu = n();
    if (localMenu != null) {
      if (paramKeyEvent == null) {
        break label67;
      }
    }
    label67:
    for (int i = paramKeyEvent.getDeviceId();; i = -1)
    {
      if (KeyCharacterMap.load(i).getKeyboardType() != 1) {}
      for (bool = true;; bool = false)
      {
        localMenu.setQwertyMode(bool);
        bool = localMenu.performShortcut(paramInt, paramKeyEvent, 0);
        return bool;
      }
    }
  }
  
  public final boolean a(KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getAction() == 1) {
      i();
    }
    return true;
  }
  
  public final int b()
  {
    return this.a.o();
  }
  
  public final void b(int paramInt)
  {
    this.a.e(paramInt);
  }
  
  public final void b(Drawable paramDrawable)
  {
    this.a.d(paramDrawable);
  }
  
  public final void b(CharSequence paramCharSequence)
  {
    this.a.c(paramCharSequence);
  }
  
  public final void b(boolean paramBoolean) {}
  
  public final int c()
  {
    return this.a.s();
  }
  
  public final void c(Drawable paramDrawable)
  {
    this.a.c(paramDrawable);
  }
  
  public final void c(CharSequence paramCharSequence)
  {
    this.a.a(paramCharSequence);
  }
  
  public final void c(boolean paramBoolean) {}
  
  public final void d()
  {
    this.a.f(8);
  }
  
  public final void d(boolean paramBoolean)
  {
    if (paramBoolean != this.d)
    {
      this.d = paramBoolean;
      int j = this.h.size();
      int i = 0;
      while (i < j)
      {
        ((c)this.h.get(i)).a(paramBoolean);
        i += 1;
      }
    }
  }
  
  public final void e() {}
  
  public final Context f()
  {
    return this.a.b();
  }
  
  public final boolean i()
  {
    return this.a.k();
  }
  
  public final boolean j()
  {
    return this.a.l();
  }
  
  public final boolean k()
  {
    this.a.a().removeCallbacks(this.g);
    ac.a(this.a.a(), this.g);
    return true;
  }
  
  public final boolean l()
  {
    if (this.a.c())
    {
      this.a.d();
      return true;
    }
    return false;
  }
  
  final void m()
  {
    this.a.a().removeCallbacks(this.g);
  }
  
  final Menu n()
  {
    if (!this.e)
    {
      this.a.a(new ba(this), new bb(this));
      this.e = true;
    }
    return this.a.t();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/app/ax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */