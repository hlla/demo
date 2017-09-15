package com.tencent.mm.compatible.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.v;

@TargetApi(8)
public final class c
  implements b.b
{
  private Context context;
  private AudioManager gSi;
  public b.a gSj;
  private AudioManager.OnAudioFocusChangeListener gSk;
  
  public c(Context paramContext)
  {
    GMTrace.i(13784026447872L, 102699);
    this.gSk = new AudioManager.OnAudioFocusChangeListener()
    {
      public final void onAudioFocusChange(int paramAnonymousInt)
      {
        GMTrace.i(13784831754240L, 102705);
        if (c.this.gSj != null)
        {
          v.d("MicroMsg.AudioFocusHelper", "jacks change: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          c.this.gSj.cX(paramAnonymousInt);
        }
        GMTrace.o(13784831754240L, 102705);
      }
    };
    this.context = paramContext;
    GMTrace.o(13784026447872L, 102699);
  }
  
  public final void a(b.a parama)
  {
    GMTrace.i(13783892230144L, 102698);
    this.gSj = parama;
    GMTrace.o(13783892230144L, 102698);
  }
  
  public final boolean rY()
  {
    GMTrace.i(13784294883328L, 102701);
    if ((this.gSi == null) && (this.context != null)) {
      this.gSi = ((AudioManager)this.context.getSystemService("audio"));
    }
    boolean bool;
    if (this.gSi != null) {
      if (1 == this.gSi.abandonAudioFocus(this.gSk)) {
        bool = true;
      }
    }
    for (;;)
    {
      v.j("MicroMsg.AudioFocusHelper", "jacks abandonFocus: %B, %x", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.gSk.hashCode()) });
      GMTrace.o(13784294883328L, 102701);
      return bool;
      bool = false;
      continue;
      bool = false;
    }
  }
  
  public final boolean requestFocus()
  {
    GMTrace.i(13784160665600L, 102700);
    if ((this.gSi == null) && (this.context != null)) {
      this.gSi = ((AudioManager)this.context.getSystemService("audio"));
    }
    boolean bool;
    if (this.gSi != null) {
      if (1 == this.gSi.requestAudioFocus(this.gSk, 3, 2)) {
        bool = true;
      }
    }
    for (;;)
    {
      v.j("MicroMsg.AudioFocusHelper", "jacks requestFocus: %B, %x", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.gSk.hashCode()) });
      GMTrace.o(13784160665600L, 102700);
      return bool;
      bool = false;
      continue;
      bool = false;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/compatible/util/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */