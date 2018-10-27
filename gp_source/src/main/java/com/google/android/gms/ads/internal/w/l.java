package com.google.android.gms.ads.internal.w;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.TextureView;
import com.google.android.gms.ads.internal.q.a.a;

@a
@TargetApi(14)
public abstract class l
  extends TextureView
  implements ah
{
  public final w b = new w();
  public final ag c = new ag(paramContext, this);
  
  public l(Context paramContext)
  {
    super(paramContext);
  }
  
  public abstract void a();
  
  public abstract void a(float paramFloat1, float paramFloat2);
  
  public abstract void a(int paramInt);
  
  public abstract void b();
  
  public abstract void c();
  
  public abstract void d();
  
  public abstract int getCurrentPosition();
  
  public abstract int getDuration();
  
  public abstract String getPlayerName();
  
  public abstract int getVideoHeight();
  
  public abstract int getVideoWidth();
  
  public void setBufferForPlayback(int paramInt) {}
  
  public void setBufferForPlaybackAfterRebuffer(int paramInt) {}
  
  public void setHighWaterMark(int paramInt) {}
  
  public abstract void setListener(k paramk);
  
  public void setLowWaterMark(int paramInt) {}
  
  public abstract void setVideoPath(String paramString);
  
  public void setVolume(float paramFloat)
  {
    ag localag = this.c;
    localag.a = paramFloat;
    localag.d();
    d();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/w/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */