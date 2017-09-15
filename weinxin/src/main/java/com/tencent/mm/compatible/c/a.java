package com.tencent.mm.compatible.c;

import android.media.AudioManager;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.compatible.d.j;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;

public final class a
{
  public static boolean a(AudioManager paramAudioManager)
  {
    GMTrace.i(13776107601920L, 102640);
    if (ao.oS())
    {
      GMTrace.o(13776107601920L, 102640);
      return false;
    }
    v.i("MicroMsg.BluetoothUtil", "stop DeviceInfo mCommonInfo getStartBluetoothSco:%s,getStopBluetoothInBU:%s ", new Object[] { Integer.valueOf(p.gRb.gPD), Integer.valueOf(p.gRb.gPC) });
    if (((p.gRb.gPC == 1) || (p.gRb.gPD == -1)) && (paramAudioManager.isBluetoothScoOn()))
    {
      v.i("MicroMsg.BluetoothUtil", "BluetoothUtil stopBluetoothSco stack: %s", new Object[] { bf.bJP() });
      paramAudioManager.stopBluetoothSco();
    }
    GMTrace.o(13776107601920L, 102640);
    return true;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/compatible/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */