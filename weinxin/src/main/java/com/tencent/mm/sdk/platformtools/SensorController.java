package com.tencent.mm.sdk.platformtools;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.jg.JgMethodChecked;
import com.tencent.gmtrace.GMTrace;

public class SensorController
  extends BroadcastReceiver
  implements SensorEventListener
{
  private static float utM;
  private static float utO;
  public static boolean utV;
  public static double utW;
  private Context context;
  private SensorManager hVs;
  private float qfF;
  private float utN;
  private a utP;
  private Sensor utQ;
  private final boolean utR;
  private boolean utS;
  public boolean utT;
  private float utU;
  
  static
  {
    GMTrace.i(13872207495168L, 103356);
    utM = 4.2949673E9F;
    utO = 0.5F;
    utV = false;
    utW = -1.0D;
    GMTrace.o(13872207495168L, 103356);
  }
  
  public SensorController(Context paramContext)
  {
    GMTrace.i(13871402188800L, 103350);
    this.utS = false;
    this.utT = false;
    this.qfF = -1.0F;
    this.utU = -1.0F;
    if (paramContext == null)
    {
      this.utR = false;
      GMTrace.o(13871402188800L, 103350);
      return;
    }
    this.context = paramContext;
    this.hVs = ((SensorManager)paramContext.getSystemService("sensor"));
    this.utQ = this.hVs.getDefaultSensor(8);
    if (this.utQ != null) {
      this.qfF = Math.min(10.0F, this.utQ.getMaximumRange());
    }
    if (this.qfF < 0.0F)
    {
      v.e("MicroMsg.SensorController", "error, getMaximumRange return %s, set to 1", new Object[] { Float.valueOf(this.qfF) });
      this.qfF = 1.0F;
    }
    if (this.utQ != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.utR = bool;
      this.utN = (utO + 1.0F);
      GMTrace.o(13871402188800L, 103350);
      return;
    }
  }
  
  @JgMethodChecked(author=20, fComment="checked", lastDate="20140429", reviewer=20, vComment={com.jg.EType.RECEIVERCHECK})
  public final void a(a parama)
  {
    GMTrace.i(13871536406528L, 103351);
    v.i("MicroMsg.SensorController", "sensor callback set, isRegistered:" + this.utT + ", proximitySensor: " + this.utQ + ", maxValue: " + this.qfF);
    if (!this.utT)
    {
      this.utU = -1.0F;
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.HEADSET_PLUG");
      this.context.registerReceiver(this, localIntentFilter);
      this.hVs.registerListener(this, this.utQ, 2);
      this.utT = true;
    }
    this.utP = parama;
    GMTrace.o(13871536406528L, 103351);
  }
  
  public final void bJw()
  {
    GMTrace.i(13871670624256L, 103352);
    v.i("MicroMsg.SensorController", "sensor callback removed");
    try
    {
      this.context.unregisterReceiver(this);
      this.hVs.unregisterListener(this, this.utQ);
      this.hVs.unregisterListener(this);
      this.utT = false;
      this.utP = null;
      this.utU = -1.0F;
      GMTrace.o(13871670624256L, 103352);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        v.v("MicroMsg.SensorController", "sensor receiver has already unregistered");
      }
    }
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt)
  {
    GMTrace.i(13871804841984L, 103353);
    GMTrace.o(13871804841984L, 103353);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    GMTrace.i(13872073277440L, 103355);
    if (paramIntent == null)
    {
      GMTrace.o(13872073277440L, 103355);
      return;
    }
    paramContext = paramIntent.getAction();
    if ((paramContext != null) && (paramContext.equals("android.intent.action.HEADSET_PLUG")))
    {
      int i = paramIntent.getIntExtra("state", 0);
      if (i == 1) {
        this.utS = true;
      }
      if (i == 0) {
        this.utS = false;
      }
    }
    GMTrace.o(13872073277440L, 103355);
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    GMTrace.i(13871939059712L, 103354);
    if ((paramSensorEvent == null) || (paramSensorEvent.sensor == null) || (this.utQ == null))
    {
      GMTrace.o(13871939059712L, 103354);
      return;
    }
    if (this.utS)
    {
      GMTrace.o(13871939059712L, 103354);
      return;
    }
    float f2 = paramSensorEvent.values[0];
    double d = 3.0D;
    v.i("MicroMsg.SensorController", "newValue: %s, maxValue: %s, divideRatio: %s, configNearFarDivideRatio: %s, lastValue: %s, maxRange: %s", new Object[] { Float.valueOf(f2), Float.valueOf(this.qfF), Double.valueOf(3.0D), Double.valueOf(utW), Float.valueOf(this.utU), Float.valueOf(this.utQ.getMaximumRange()) });
    if (utW > 0.0D) {
      d = utW;
    }
    if ((utW > 0.0D) || (this.qfF < 0.0F)) {}
    float f3;
    for (float f1 = this.utQ.getMaximumRange();; f1 = this.qfF)
    {
      f3 = Math.max(0.1F, (float)(f1 / d));
      v.i("MicroMsg.SensorController", "onSensorChanged, near threshold: %s, max: %s", new Object[] { Float.valueOf(f3), Float.valueOf(f1) });
      switch (paramSensorEvent.sensor.getType())
      {
      default: 
        GMTrace.o(13871939059712L, 103354);
        return;
      }
    }
    if (this.utP == null)
    {
      GMTrace.o(13871939059712L, 103354);
      return;
    }
    if (f2 == this.utU)
    {
      GMTrace.o(13871939059712L, 103354);
      return;
    }
    if (f2 < f3)
    {
      v.i("MicroMsg.SensorController", "sensor near-far event near false");
      this.utP.cS(false);
    }
    for (;;)
    {
      this.utU = f2;
      break;
      v.i("MicroMsg.SensorController", "sensor near-far event far true");
      this.utP.cS(true);
    }
  }
  
  public static abstract interface a
  {
    public abstract void cS(boolean paramBoolean);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/sdk/platformtools/SensorController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */