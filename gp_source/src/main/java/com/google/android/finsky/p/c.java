package com.google.android.finsky.p;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;

public final class c
  implements OnCompletionListener, OnErrorListener, OnPreparedListener
{
  public int a = 1;
  public final MediaPlayer b;
  public OnCompletionListener c = null;
  public OnPreparedListener d = null;
  public final j e;
  private final WakeLock f;
  
  public c(Context paramContext, j paramj)
  {
    this(paramContext, paramj, new MediaPlayer());
  }
  
  private c(Context paramContext, j paramj, MediaPlayer paramMediaPlayer)
  {
    this.b = paramMediaPlayer;
    this.b.setOnPreparedListener(this);
    this.b.setOnCompletionListener(this);
    this.b.setOnErrorListener(this);
    this.e = paramj;
    this.f = ((PowerManager)paramContext.getSystemService("power")).newWakeLock(6, "MediaPlayerWrapper");
  }
  
  public final void a()
  {
    this.b.start();
    this.a = 5;
    this.e.b(5);
    if (!this.f.isHeld()) {
      this.f.acquire(600000L);
    }
  }
  
  public final void b()
  {
    if (this.f.isHeld()) {
      this.f.release();
    }
  }
  
  public final void onCompletion(MediaPlayer paramMediaPlayer)
  {
    this.a = 8;
    this.e.b(8);
    OnCompletionListener localOnCompletionListener = this.c;
    if (localOnCompletionListener != null) {
      localOnCompletionListener.onCompletion(paramMediaPlayer);
    }
    b();
  }
  
  public final boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    this.a = 9;
    this.e.b(9);
    b();
    return false;
  }
  
  public final void onPrepared(MediaPlayer paramMediaPlayer)
  {
    this.a = 4;
    this.e.b(4);
    OnPreparedListener localOnPreparedListener = this.d;
    if (localOnPreparedListener != null) {
      localOnPreparedListener.onPrepared(paramMediaPlayer);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/p/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */