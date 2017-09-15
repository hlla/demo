package com.tencent.mm.compatible.b;

import android.annotation.TargetApi;
import android.media.AudioRecord;
import android.media.audiofx.AcousticEchoCanceler;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.v;

public final class d
  implements f.a
{
  private AcousticEchoCanceler gNe;
  
  @TargetApi(16)
  public d(AudioRecord paramAudioRecord)
  {
    GMTrace.i(13815970267136L, 102937);
    this.gNe = null;
    boolean bool = AcousticEchoCanceler.isAvailable();
    v.d("MicroMsg.MMAcousticEchoCanceler", "available  " + bool);
    if (bool) {
      this.gNe = AcousticEchoCanceler.create(paramAudioRecord.getAudioSessionId());
    }
    GMTrace.o(13815970267136L, 102937);
  }
  
  @TargetApi(16)
  public final boolean isAvailable()
  {
    GMTrace.i(13816104484864L, 102938);
    boolean bool = AcousticEchoCanceler.isAvailable();
    GMTrace.o(13816104484864L, 102938);
    return bool;
  }
  
  @TargetApi(16)
  public final boolean qD()
  {
    GMTrace.i(13816238702592L, 102939);
    if (this.gNe != null) {}
    try
    {
      int i = this.gNe.setEnabled(true);
      if (i == 0)
      {
        GMTrace.o(13816238702592L, 102939);
        return true;
      }
      v.d("MicroMsg.MMAcousticEchoCanceler", "setEnabled failed " + i);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        v.printErrStackTrace("MicroMsg.MMAcousticEchoCanceler", localException, "", new Object[0]);
      }
    }
    GMTrace.o(13816238702592L, 102939);
    return false;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/compatible/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */