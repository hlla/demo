package com.google.android.gms.ads.internal.w;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.q.a.a;

@a
final class y
  implements SensorEventListener
{
  public aa a;
  public Handler b;
  public final SensorManager c;
  private final Display d;
  private float[] e;
  private final float[] f;
  private final Object g;
  private final float[] h;
  
  y(Context paramContext)
  {
    this.c = ((SensorManager)paramContext.getSystemService("sensor"));
    this.d = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    this.f = new float[9];
    this.h = new float[9];
    this.g = new Object();
  }
  
  private final void a(int paramInt1, int paramInt2)
  {
    float[] arrayOfFloat = this.h;
    float f1 = arrayOfFloat[paramInt1];
    arrayOfFloat[paramInt1] = arrayOfFloat[paramInt2];
    arrayOfFloat[paramInt2] = f1;
  }
  
  final void a()
  {
    if (this.b != null)
    {
      this.c.unregisterListener(this);
      this.b.post(new z());
      this.b = null;
    }
  }
  
  final boolean a(float[] paramArrayOfFloat)
  {
    synchronized (this.g)
    {
      float[] arrayOfFloat = this.e;
      if (arrayOfFloat != null)
      {
        System.arraycopy(arrayOfFloat, 0, paramArrayOfFloat, 0, arrayOfFloat.length);
        return true;
      }
      return false;
    }
  }
  
  public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public final void onSensorChanged(SensorEvent arg1)
  {
    float[] arrayOfFloat = ???.values;
    if ((arrayOfFloat[0] != 0.0F) || (arrayOfFloat[1] != 0.0F) || (arrayOfFloat[2] != 0.0F)) {}
    for (;;)
    {
      synchronized (this.g)
      {
        if (this.e == null) {
          this.e = new float[9];
        }
        SensorManager.getRotationMatrixFromVector(this.f, arrayOfFloat);
        switch (this.d.getRotation())
        {
        default: 
          System.arraycopy(this.f, 0, this.h, 0, 9);
          a(1, 3);
          a(2, 6);
          a(5, 7);
        }
      }
      synchronized (this.g)
      {
        System.arraycopy(this.h, 0, this.e, 0, 9);
        ??? = this.a;
        if (??? != null) {
          ???.a();
        }
        return;
        SensorManager.remapCoordinateSystem(this.f, 130, 1, this.h);
        continue;
        SensorManager.remapCoordinateSystem(this.f, 129, 130, this.h);
        continue;
        SensorManager.remapCoordinateSystem(this.f, 2, 129, this.h);
        continue;
        localObject1 = finally;
        throw ((Throwable)localObject1);
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/w/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */