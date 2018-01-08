package com.sec.dtl.launcher;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.Display;
import android.view.WindowManager;
import java.util.Vector;

public final class GyroForShadow
{
  public static final float MAX_OFFSET = 70.0F;
  private static Vector<VectorListener> mListeners = new Vector();
  static float mPrevX = 0.0F;
  static float mPrevY = 0.0F;
  private static Display sDisplay;
  private static SensorManager sSensorManager;
  private static final SensorEventListener sel = new SensorEventListener()
  {
    public void onAccuracyChanged(Sensor paramAnonymousSensor, int paramAnonymousInt) {}
    
    public void onSensorChanged(SensorEvent paramAnonymousSensorEvent)
    {
      switch (paramAnonymousSensorEvent.sensor.getType())
      {
      case 2: 
      case 3: 
      default: 
      case 4: 
        do
        {
          return;
          f2 = paramAnonymousSensorEvent.values[1];
          f1 = paramAnonymousSensorEvent.values[0];
        } while (Math.sqrt(f2 * f2 + f1 * f1) < 0.05000000074505806D);
        float f2 = Math.max(-1.0F, Math.min(1.0F, GyroForShadow.mPrevX + 0.07F * f2));
        GyroForShadow.mPrevX = f2;
        float f3 = Math.max(-1.0F, Math.min(1.0F, GyroForShadow.mPrevY + 0.07F * f1));
        GyroForShadow.mPrevY = f3;
        float f1 = (float)Math.sqrt(f2 * f2 + f3 * f3 + 1.0F * 1.0F);
        f2 /= f1;
        f3 /= f1;
        f1 = 1.0F / f1;
        int i = 0;
        while (i < GyroForShadow.mListeners.size())
        {
          ((GyroForShadow.VectorListener)GyroForShadow.mListeners.get(i)).onVectorChanged(f2, f3, f1, GyroForShadow.mPrevX);
          i += 1;
        }
      }
      GyroForShadow.onAccelerometerChanged(paramAnonymousSensorEvent.values[0], paramAnonymousSensorEvent.values[1], paramAnonymousSensorEvent.values[2]);
    }
  };
  
  public static void initialize(Context paramContext)
  {
    sSensorManager = (SensorManager)paramContext.getSystemService("sensor");
    sDisplay = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
  }
  
  private static void onAccelerometerChanged(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f1 = paramFloat1;
    float f2 = paramFloat2;
    switch (sDisplay.getRotation())
    {
    default: 
      paramFloat2 = f2;
      paramFloat1 = f1;
      f1 = (float)Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2 + paramFloat3 * paramFloat3);
      paramFloat1 /= f1;
      paramFloat2 /= f1;
      paramFloat3 /= f1;
      if (Math.abs(paramFloat1) < 0.001F) {
        paramFloat1 = 0.0F;
      }
      break;
    }
    for (;;)
    {
      paramFloat3 = (float)Math.sqrt(paramFloat1 * paramFloat1 + 0.0F * 0.0F + 1.0F * 1.0F);
      paramFloat1 /= paramFloat3;
      paramFloat2 = 0.0F / paramFloat3;
      paramFloat3 = 1.0F / paramFloat3;
      f1 = (float)Math.sqrt(2.0D);
      int i = 0;
      while (i < mListeners.size())
      {
        ((VectorListener)mListeners.get(i)).onVectorChanged(paramFloat1, paramFloat2, paramFloat3, paramFloat1 * f1);
        i += 1;
      }
      f1 = -paramFloat2;
      paramFloat2 = paramFloat1;
      paramFloat1 = f1;
      break;
      paramFloat1 = -paramFloat1;
      paramFloat2 = -paramFloat2;
      break;
      f1 = -paramFloat1;
      paramFloat1 = paramFloat2;
      paramFloat2 = f1;
      break;
      paramFloat2 = Math.max(-1.0F, Math.min(1.0F, -paramFloat1)) * 1.0F;
      paramFloat1 = paramFloat2;
      if (paramFloat3 < 0.3F) {
        paramFloat1 = paramFloat2 * Math.max(0.0F, paramFloat3 / 0.3F);
      }
    }
  }
  
  public static void pauseSensor()
  {
    if (mListeners.size() > 0) {
      stopSensor();
    }
  }
  
  public static void registerListener(VectorListener paramVectorListener)
  {
    
    if (!mListeners.contains(paramVectorListener)) {
      mListeners.add(paramVectorListener);
    }
  }
  
  public static void resumeSensor()
  {
    if (mListeners.size() > 0) {
      startSensor();
    }
  }
  
  public static void startSensor()
  {
    new Thread()
    {
      public void run()
      {
        GyroForShadow.sSensorManager.registerListener(GyroForShadow.sel, GyroForShadow.sSensorManager.getDefaultSensor(4), 2);
      }
    }.start();
    mPrevX = 0.0F;
    mPrevY = 0.0F;
  }
  
  public static void stopSensor()
  {
    sSensorManager.unregisterListener(sel);
  }
  
  public static void unregisterListener(VectorListener paramVectorListener)
  {
    mListeners.remove(paramVectorListener);
    if (mListeners.size() == 0) {
      stopSensor();
    }
  }
  
  public static abstract class VectorListener
  {
    public abstract void onVectorChanged(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/sec/dtl/launcher/GyroForShadow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */