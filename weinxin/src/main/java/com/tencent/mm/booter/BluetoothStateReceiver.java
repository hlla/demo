package com.tencent.mm.booter;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.plugin.report.service.g;

public class BluetoothStateReceiver
  extends BroadcastReceiver
{
  public BluetoothStateReceiver()
  {
    GMTrace.i(505061310464L, 3763);
    GMTrace.o(505061310464L, 3763);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    GMTrace.i(505195528192L, 3764);
    paramContext = BluetoothAdapter.getDefaultAdapter();
    if (paramContext != null)
    {
      if (paramContext.getState() != 12) {
        break label73;
      }
      g.oSF.i(11921, new Object[] { Integer.valueOf(1) });
    }
    for (;;)
    {
      new StringBuilder("[oneliang]bluetoothAdapter state:").append(paramContext.getState());
      GMTrace.o(505195528192L, 3764);
      return;
      label73:
      if (paramContext.getState() == 10) {
        g.oSF.i(11921, new Object[] { Integer.valueOf(0) });
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/booter/BluetoothStateReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */