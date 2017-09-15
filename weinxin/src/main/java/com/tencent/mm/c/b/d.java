package com.tencent.mm.c.b;

import android.media.AudioRecord;
import android.media.AudioRecord.OnRecordPositionUpdateListener;
import android.os.HandlerThread;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Arrays;

public final class d
  extends f
{
  public byte[] fAd;
  private int fAe;
  public int fAf;
  public boolean fAg;
  private AudioRecord.OnRecordPositionUpdateListener fAh;
  public boolean fzG;
  public AudioRecord fzU;
  public c.a fzV;
  private HandlerThread mHandlerThread;
  
  public d(AudioRecord paramAudioRecord, c.a parama, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    GMTrace.i(4483945857024L, 33408);
    this.mHandlerThread = null;
    this.fAd = null;
    this.fAh = new AudioRecord.OnRecordPositionUpdateListener()
    {
      public final void onMarkerReached(AudioRecord paramAnonymousAudioRecord)
      {
        GMTrace.i(4479785107456L, 33377);
        GMTrace.o(4479785107456L, 33377);
      }
      
      public final void onPeriodicNotification(AudioRecord paramAnonymousAudioRecord)
      {
        GMTrace.i(4479919325184L, 33378);
        if (d.this.fAx)
        {
          GMTrace.o(4479919325184L, 33378);
          return;
        }
        if (d.this.fzU != null)
        {
          if ((d.this.fzG) || (d.this.fAd == null)) {
            d.this.fAd = new byte[d.this.fAf];
          }
          int j = d.this.fzU.read(d.this.fAd, 0, d.this.fAf);
          v.d("MicroMsg.RecordModeAsyncCallback", "OnRecordPositionUpdateListener, read ret: " + j);
          if (d.this.fAb != null) {
            d.this.fAb.c(j, d.this.fAd);
          }
          int i = j;
          if (j > d.this.fAd.length) {
            i = d.this.fAd.length;
          }
          if ((d.this.fAg) && (i > 0)) {
            Arrays.fill(d.this.fAd, 0, i, (byte)0);
          }
          if ((d.this.fzV != null) && (i > 0)) {
            d.this.fzV.d(d.this.fAd, i);
          }
        }
        GMTrace.o(4479919325184L, 33378);
      }
    };
    this.fzU = paramAudioRecord;
    this.fzV = parama;
    this.fzG = paramBoolean;
    this.fAe = paramInt1;
    this.fAf = paramInt2;
    GMTrace.o(4483945857024L, 33408);
  }
  
  public final void au(boolean paramBoolean)
  {
    GMTrace.i(4484348510208L, 33411);
    this.fAg = paramBoolean;
    GMTrace.o(4484348510208L, 33411);
  }
  
  public final void oP()
  {
    GMTrace.i(4484214292480L, 33410);
    this.fzU.setRecordPositionUpdateListener(null);
    this.fzU = null;
    this.mHandlerThread.quit();
    this.mHandlerThread = null;
    GMTrace.o(4484214292480L, 33410);
  }
  
  public final boolean pf()
  {
    GMTrace.i(4484080074752L, 33409);
    if (this.mHandlerThread != null)
    {
      v.e("MicroMsg.RecordModeAsyncCallback", "alreay started record");
      GMTrace.o(4484080074752L, 33409);
      return false;
    }
    this.mHandlerThread = e.cE("RecordModeAsyncCallback_handlerThread", 10);
    this.mHandlerThread.start();
    this.fzU.setRecordPositionUpdateListener(this.fAh, ad.fetchFreeHandler(this.mHandlerThread.getLooper()));
    this.fzU.setPositionNotificationPeriod(this.fAe);
    if ((this.fzG) || (this.fAd == null)) {
      this.fAd = new byte[this.fAf];
    }
    int i = this.fzU.read(this.fAd, 0, this.fAf);
    v.d("MicroMsg.RecordModeAsyncCallback", "startRecord, read ret: " + i);
    if ((this.fzV != null) && (i > 0)) {
      this.fzV.d(this.fAd, i);
    }
    GMTrace.o(4484080074752L, 33409);
    return true;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/c/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */