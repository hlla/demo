package com.tencent.mm.compatible.b;

import android.annotation.TargetApi;
import android.media.AudioRecord;
import android.media.audiofx.NoiseSuppressor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.v;

public final class h
  implements f.a
{
  private NoiseSuppressor gNC;
  
  @TargetApi(16)
  public h(AudioRecord paramAudioRecord)
  {
    GMTrace.i(13814225436672L, 102924);
    this.gNC = null;
    boolean bool = NoiseSuppressor.isAvailable();
    v.d("MicroMsg.MMNoiseSuppressor", "available  " + bool);
    if (bool) {
      this.gNC = NoiseSuppressor.create(paramAudioRecord.getAudioSessionId());
    }
    GMTrace.o(13814225436672L, 102924);
  }
  
  @TargetApi(16)
  public final boolean isAvailable()
  {
    GMTrace.i(13814359654400L, 102925);
    boolean bool = NoiseSuppressor.isAvailable();
    GMTrace.o(13814359654400L, 102925);
    return bool;
  }
  
  @TargetApi(16)
  public final boolean qD()
  {
    GMTrace.i(13814493872128L, 102926);
    if (this.gNC != null) {}
    try
    {
      int i = this.gNC.setEnabled(true);
      if (i == 0)
      {
        GMTrace.o(13814493872128L, 102926);
        return true;
      }
      v.d("MicroMsg.MMNoiseSuppressor", "setEnabled failed " + i);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        v.printErrStackTrace("MicroMsg.MMNoiseSuppressor", localException, "", new Object[0]);
      }
    }
    GMTrace.o(13814493872128L, 102926);
    return false;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/compatible/b/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */