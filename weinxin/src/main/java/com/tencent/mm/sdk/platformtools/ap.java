package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.gmtrace.GMTrace;

public final class ap
{
  public static void B(Context paramContext, int paramInt)
  {
    GMTrace.i(13951261736960L, 103945);
    a(paramContext, paramInt, b.utc, false, null);
    GMTrace.o(13951261736960L, 103945);
  }
  
  public static void a(Context paramContext, int paramInt, a parama)
  {
    GMTrace.i(13950993301504L, 103943);
    a(paramContext, paramInt, b.utd, false, parama);
    GMTrace.o(13950993301504L, 103943);
  }
  
  public static void a(Context paramContext, int paramInt, b paramb, boolean paramBoolean, final a parama)
  {
    GMTrace.i(13950859083776L, 103942);
    if ((paramContext == null) || (paramb == null))
    {
      v.e("MicroMsg.PlaySound", "play Err context:%s pathId:%d speekeron:%s looping:%b listener:%s", new Object[] { paramContext, Integer.valueOf(paramInt), paramb, Boolean.valueOf(false), parama });
      GMTrace.o(13950859083776L, 103942);
      return;
    }
    String str = paramContext.getString(paramInt);
    final MediaPlayer localMediaPlayer = new MediaPlayer();
    if (paramb != b.utc) {
      if (paramb != b.utd) {
        break label247;
      }
    }
    for (int i = 3;; i = 0)
    {
      localMediaPlayer.setAudioStreamType(i);
      v.i("MicroMsg.PlaySound", "play start mp:%d path:%s context:%s pathId:%d speakerOn:%s looping:%b listener:%s ", new Object[] { Integer.valueOf(localMediaPlayer.hashCode()), str, paramContext, Integer.valueOf(paramInt), paramb, Boolean.valueOf(false), parama });
      try
      {
        paramContext = paramContext.getAssets().openFd(str);
        localMediaPlayer.setDataSource(paramContext.getFileDescriptor(), paramContext.getStartOffset(), paramContext.getLength());
        paramContext.close();
        localMediaPlayer.setLooping(false);
        localMediaPlayer.prepare();
        localMediaPlayer.start();
        localMediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener()
        {
          public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
          {
            GMTrace.i(13930726424576L, 103792);
            v.i("MicroMsg.PlaySound", "onError, what: %d, extra: %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
            if (paramAnonymousMediaPlayer != null) {}
            try
            {
              paramAnonymousMediaPlayer.release();
              if (this.sVQ != null) {
                this.sVQ.release();
              }
            }
            catch (Exception paramAnonymousMediaPlayer)
            {
              for (;;) {}
            }
            GMTrace.o(13930726424576L, 103792);
            return false;
          }
        });
        localMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
        {
          public final void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
          {
            GMTrace.i(13881736953856L, 103427);
            if (paramAnonymousMediaPlayer == null) {}
            for (int i = -1;; i = paramAnonymousMediaPlayer.hashCode())
            {
              v.i("MicroMsg.PlaySound", "play completion mp:%d  path:%s", new Object[] { Integer.valueOf(i), this.hZl });
              if (paramAnonymousMediaPlayer != null) {
                paramAnonymousMediaPlayer.release();
              }
              if (localMediaPlayer != null) {
                localMediaPlayer.release();
              }
              if (parama != null) {
                parama.oW();
              }
              GMTrace.o(13881736953856L, 103427);
              return;
            }
          }
        });
        GMTrace.o(13950859083776L, 103942);
        return;
      }
      catch (Exception paramContext)
      {
        label247:
        v.e("MicroMsg.PlaySound", "play failed pathId:%d e:%s", new Object[] { Integer.valueOf(paramInt), paramContext.getMessage() });
        v.printErrStackTrace("MicroMsg.PlaySound", paramContext, "", new Object[0]);
        localMediaPlayer.release();
        GMTrace.o(13950859083776L, 103942);
      }
    }
  }
  
  public static void b(Context paramContext, int paramInt, a parama)
  {
    GMTrace.i(13951127519232L, 103944);
    a(paramContext, paramInt, b.utc, false, parama);
    GMTrace.o(13951127519232L, 103944);
  }
  
  public static abstract interface a
  {
    public abstract void oW();
  }
  
  private static enum b
  {
    static
    {
      GMTrace.i(13949248471040L, 103930);
      utc = new b("NOTSET", 0);
      utd = new b("ON", 1);
      ute = new b("OFF", 2);
      utf = new b[] { utc, utd, ute };
      GMTrace.o(13949248471040L, 103930);
    }
    
    private b()
    {
      GMTrace.i(13949114253312L, 103929);
      GMTrace.o(13949114253312L, 103929);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/sdk/platformtools/ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */