package com.google.android.gms.ads.internal.w;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import com.google.android.gms.ads.internal.q.a.a;

@a
@TargetApi(14)
public final class ag
  implements AudioManager.OnAudioFocusChangeListener
{
  public float a = 1.0F;
  private final AudioManager b;
  private boolean c;
  private boolean d;
  private boolean e;
  private final ah f;
  
  public ag(Context paramContext, ah paramah)
  {
    this.b = ((AudioManager)paramContext.getSystemService("audio"));
    this.f = paramah;
  }
  
  public final float a()
  {
    if (!this.e) {}
    for (float f1 = this.a;; f1 = 0.0F)
    {
      if (!this.c) {
        return 0.0F;
      }
      return f1;
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
    d();
  }
  
  public final void b()
  {
    this.d = true;
    d();
  }
  
  public final void c()
  {
    this.d = false;
    d();
  }
  
  final void d()
  {
    boolean bool1 = true;
    boolean bool2 = true;
    int i;
    if (this.d) {
      if (!this.e) {
        if (this.a > 0.0F) {
          i = 1;
        }
      }
    }
    for (;;)
    {
      boolean bool3;
      if (i != 0)
      {
        bool3 = this.c;
        if (!bool3)
        {
          localAudioManager = this.b;
          if (localAudioManager != null) {}
        }
      }
      do
      {
        do
        {
          do
          {
            this.f.d();
            return;
          } while (bool3);
          if (localAudioManager.requestAudioFocus(this, 3, 2) == 1) {}
          for (bool1 = bool2;; bool1 = false)
          {
            this.c = bool1;
            break;
          }
        } while (i != 0);
        bool2 = this.c;
      } while (!bool2);
      AudioManager localAudioManager = this.b;
      if ((localAudioManager != null) && (bool2)) {
        if (localAudioManager.abandonAudioFocus(this) != 0) {
          break label149;
        }
      }
      for (;;)
      {
        this.c = bool1;
        this.f.d();
        return;
        label149:
        bool1 = false;
      }
      i = 0;
      continue;
      i = 0;
      continue;
      i = 0;
    }
  }
  
  public final void onAudioFocusChange(int paramInt)
  {
    if (paramInt > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.c = bool;
      this.f.d();
      return;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/w/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */