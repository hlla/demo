package com.google.android.finsky.p;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.List;

public final class d
  implements OnAudioFocusChangeListener
{
  public final j a = new e(this, new Handler(Looper.getMainLooper()));
  public final c b;
  public final List c = new ArrayList();
  private int d = -1;
  private final AudioManager e;
  private final OnCompletionListener f = new h(this);
  private final OnPreparedListener g = new g(this);
  private boolean h = false;
  
  d(Context paramContext)
  {
    this.e = ((AudioManager)paramContext.getSystemService("audio"));
    this.b = new c(paramContext, this.a);
    paramContext = this.b;
    paramContext.d = this.g;
    paramContext.c = this.f;
  }
  
  public final void a()
  {
    c localc = this.b;
    int i = localc.a;
    if (i == 5) {}
    for (;;)
    {
      localc.b.pause();
      localc.a = 6;
      localc.e.b(6);
      localc.b();
      e();
      do
      {
        return;
      } while (i != 4);
    }
  }
  
  public final void a(j paramj)
  {
    if (!this.c.contains(paramj)) {
      this.c.add(paramj);
    }
  }
  
  public final void b()
  {
    if (this.b.a == 6)
    {
      d();
      this.b.a();
    }
  }
  
  public final void b(j paramj)
  {
    this.c.remove(paramj);
  }
  
  public final void c()
  {
    c localc = this.b;
    localc.b.reset();
    localc.a = 1;
    localc.e.b(1);
    localc.b();
    e();
  }
  
  public final void d()
  {
    if (this.d != 1)
    {
      AudioManager localAudioManager = this.e;
      if ((localAudioManager != null) && (localAudioManager.requestAudioFocus(this, 3, 1) == 1)) {
        this.d = 1;
      }
    }
  }
  
  public final void e()
  {
    if (this.d != -1)
    {
      AudioManager localAudioManager = this.e;
      if (localAudioManager != null)
      {
        localAudioManager.abandonAudioFocus(this);
        this.d = -1;
      }
    }
  }
  
  public final void onAudioFocusChange(int paramInt)
  {
    this.d = paramInt;
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
      } while (!this.h);
      b();
      this.h = false;
      return;
      a();
      return;
    } while (this.b.a != 5);
    a();
    this.h = true;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/p/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */