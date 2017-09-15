package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import com.tencent.gmtrace.GMTrace;
import java.util.List;

public final class aw
{
  private SensorManager sFM;
  private a utX;
  
  public aw(Context paramContext)
  {
    GMTrace.i(13876099809280L, 103385);
    this.sFM = ((SensorManager)paramContext.getSystemService("sensor"));
    GMTrace.o(13876099809280L, 103385);
  }
  
  public final boolean M(Runnable paramRunnable)
  {
    GMTrace.i(13876234027008L, 103386);
    if (this.sFM == null)
    {
      GMTrace.o(13876234027008L, 103386);
      return false;
    }
    List localList = this.sFM.getSensorList(1);
    if ((localList != null) && (localList.size() > 0))
    {
      this.utX = new a(paramRunnable);
      this.sFM.registerListener(this.utX, 2, 3);
      GMTrace.o(13876234027008L, 103386);
      return true;
    }
    GMTrace.o(13876234027008L, 103386);
    return false;
  }
  
  public final void bJx()
  {
    GMTrace.i(13876368244736L, 103387);
    if ((this.sFM != null) && (this.utX != null)) {
      this.sFM.unregisterListener(this.utX, 2);
    }
    GMTrace.o(13876368244736L, 103387);
  }
  
  static final class a
    implements SensorListener
  {
    private Runnable nDP;
    private float[] sFP;
    
    public a(Runnable paramRunnable)
    {
      GMTrace.i(13870999535616L, 103347);
      this.sFP = new float[] { 0.0F, 0.0F, 0.0F };
      this.nDP = paramRunnable;
      GMTrace.o(13870999535616L, 103347);
    }
    
    public final void onAccuracyChanged(int paramInt1, int paramInt2)
    {
      GMTrace.i(13871133753344L, 103348);
      GMTrace.o(13871133753344L, 103348);
    }
    
    public final void onSensorChanged(int paramInt, float[] paramArrayOfFloat)
    {
      int i = 0;
      GMTrace.i(13871267971072L, 103349);
      float[] arrayOfFloat = new float[3];
      paramInt = 0;
      while (paramInt < 3)
      {
        arrayOfFloat[paramInt] = Math.abs(paramArrayOfFloat[paramInt] - this.sFP[paramInt]);
        int j = i;
        if (this.sFP[paramInt] != 0.0F)
        {
          j = i;
          if (arrayOfFloat[paramInt] > 1.0F)
          {
            j = 1;
            v.d("MicroMsg.ShakeManager", "isONShake:" + arrayOfFloat[paramInt]);
          }
        }
        this.sFP[paramInt] = paramArrayOfFloat[paramInt];
        paramInt += 1;
        i = j;
      }
      if (i != 0) {
        this.nDP.run();
      }
      GMTrace.o(13871267971072L, 103349);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/sdk/platformtools/aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */