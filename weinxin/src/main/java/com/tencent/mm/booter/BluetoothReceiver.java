package com.tencent.mm.booter;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.jg.JgClassChecked;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.compatible.b.e;
import com.tencent.mm.compatible.d.j;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ap;
import java.util.Set;

@JgClassChecked(author=20, fComment="checked", lastDate="20140429", reviewer=20, vComment={com.jg.EType.RECEIVERCHECK})
public class BluetoothReceiver
  extends BroadcastReceiver
{
  public BluetoothReceiver()
  {
    GMTrace.i(501705867264L, 3738);
    GMTrace.o(501705867264L, 3738);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    GMTrace.i(501840084992L, 3739);
    if ((paramContext == null) || (paramIntent == null) || (bf.mA(paramIntent.getAction())))
    {
      GMTrace.o(501840084992L, 3739);
      return;
    }
    paramContext = BluetoothAdapter.getDefaultAdapter();
    if (paramContext == null)
    {
      v.d("MicroMsg.BluetoothReceiver", "getDefaultAdapter == null");
      GMTrace.o(501840084992L, 3739);
      return;
    }
    paramContext = paramContext.getBondedDevices();
    if ((paramContext == null) || (paramContext.size() == 0))
    {
      v.d("MicroMsg.BluetoothReceiver", "getBondedDevices == null");
      GMTrace.o(501840084992L, 3739);
      return;
    }
    if (bf.mA(paramIntent.getAction()))
    {
      GMTrace.o(501840084992L, 3739);
      return;
    }
    v.d("MicroMsg.BluetoothReceiver", "dkbt action :" + paramIntent.getAction());
    if (!ap.zb())
    {
      GMTrace.o(501840084992L, 3739);
      return;
    }
    try
    {
      i = paramIntent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1);
      v.d("MicroMsg.BluetoothReceiver", "dkbt  action :" + paramIntent.getAction() + " state:" + i + " isBluetoothScoOn :" + ap.yZ().qI() + " " + ap.yZ().qM());
      if (paramIntent.getAction().equalsIgnoreCase("android.media.SCO_AUDIO_STATE_CHANGED"))
      {
        v.d("MicroMsg.BluetoothReceiver", "just STATE_CHANGED not real STATE_UPDATED" + paramIntent.getAction());
        GMTrace.o(501840084992L, 3739);
        return;
      }
    }
    catch (Exception paramContext)
    {
      int i;
      for (;;)
      {
        v.e("MicroMsg.BluetoothReceiver", "%s", new Object[] { bf.g(paramContext) });
        i = 0;
      }
      if (i == 1)
      {
        v.d("MicroMsg.BluetoothReceiver", "sco connected!");
        paramContext = ap.yZ();
        v.i("MicroMsg.MMAudioManager", "dkbt bluetoothStartSucc %s", new Object[] { paramContext.qM() });
        e.gNj = true;
        paramContext.ea(1);
        GMTrace.o(501840084992L, 3739);
        return;
      }
      if (i == 0)
      {
        v.d("MicroMsg.BluetoothReceiver", "sco disconnected!getStopBluetoothInBR = %s", new Object[] { Integer.valueOf(p.gRb.gPB) });
        if (p.gRb.gPB == 1) {
          ap.yZ().qH();
        }
        ap.yZ().qF();
      }
      GMTrace.o(501840084992L, 3739);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/booter/BluetoothReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */