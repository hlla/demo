package ct;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;

final class bv
  implements SensorEventListener
{
  private static volatile bv e;
  private final SensorManager a;
  private final boolean b;
  private boolean c;
  private double d;
  
  private bv(Context paramContext)
  {
    this.a = ((SensorManager)paramContext.getSystemService("sensor"));
    if (this.a != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.b = bool;
      return;
    }
  }
  
  public static bv a(Context paramContext)
  {
    if (e == null) {
      e = new bv(paramContext);
    }
    return e;
  }
  
  public final void a()
  {
    if (!this.b) {}
    while (!this.c) {
      return;
    }
    this.c = false;
    this.d = NaN.0D;
    this.a.unregisterListener(this);
  }
  
  public final void a(Handler paramHandler)
  {
    if (!this.b) {}
    for (;;)
    {
      return;
      if (!this.c) {
        try
        {
          Sensor localSensor = this.a.getDefaultSensor(11);
          if (localSensor != null)
          {
            this.a.registerListener(this, localSensor, 3, paramHandler);
            this.c = true;
            return;
          }
        }
        catch (Exception paramHandler) {}catch (Error paramHandler) {}
      }
    }
  }
  
  public final double b()
  {
    if (this.c) {
      try
      {
        double d1 = this.d;
        return d1;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    return NaN.0D;
  }
  
  public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public final void onSensorChanged(SensorEvent paramSensorEvent)
  {
    try
    {
      double d1;
      if (paramSensorEvent.sensor.getType() == 11)
      {
        float[] arrayOfFloat1 = new float[16];
        float[] arrayOfFloat2 = new float[3];
        SensorManager.getRotationMatrixFromVector(arrayOfFloat1, paramSensorEvent.values);
        SensorManager.getOrientation(arrayOfFloat1, arrayOfFloat2);
        d1 = arrayOfFloat2[0];
        d1 = d1 * 180.0D / 3.1415926D;
      }
      try
      {
        this.d = d1;
        return;
      }
      finally
      {
        paramSensorEvent = finally;
        throw paramSensorEvent;
      }
      return;
    }
    catch (Exception paramSensorEvent)
    {
      return;
    }
    catch (Error paramSensorEvent) {}
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/ct/bv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */