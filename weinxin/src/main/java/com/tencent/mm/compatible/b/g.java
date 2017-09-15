package com.tencent.mm.compatible.b;

import android.annotation.TargetApi;
import android.media.AudioRecord;
import android.media.audiofx.AutomaticGainControl;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.v;

public final class g
  implements f.a
{
  private AutomaticGainControl gNB;
  
  @TargetApi(16)
  public g(AudioRecord paramAudioRecord)
  {
    GMTrace.i(13821875847168L, 102981);
    this.gNB = null;
    boolean bool = AutomaticGainControl.isAvailable();
    v.d("MicroMsg.MMAutomaticGainControl", "available  " + bool);
    if (bool) {
      this.gNB = AutomaticGainControl.create(paramAudioRecord.getAudioSessionId());
    }
    GMTrace.o(13821875847168L, 102981);
  }
  
  @TargetApi(16)
  public final boolean isAvailable()
  {
    GMTrace.i(13822010064896L, 102982);
    boolean bool = AutomaticGainControl.isAvailable();
    GMTrace.o(13822010064896L, 102982);
    return bool;
  }
  
  @TargetApi(16)
  public final boolean qD()
  {
    GMTrace.i(13822144282624L, 102983);
    if (this.gNB != null) {}
    try
    {
      int i = this.gNB.setEnabled(true);
      if (i == 0)
      {
        GMTrace.o(13822144282624L, 102983);
        return true;
      }
      v.d("MicroMsg.MMAutomaticGainControl", "setEnabled failed " + i);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        v.printErrStackTrace("MicroMsg.MMAutomaticGainControl", localException, "", new Object[0]);
      }
    }
    GMTrace.o(13822144282624L, 102983);
    return false;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/compatible/b/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */