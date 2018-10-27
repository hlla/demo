package com.airbnb.lottie.a;

import android.graphics.PointF;
import android.os.Build.VERSION;
import android.support.v4.g.w;
import android.support.v4.view.b.e;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import com.airbnb.lottie.c.a.z;
import com.airbnb.lottie.d.g;
import com.airbnb.lottie.d.h;
import com.airbnb.lottie.i;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class b
{
  private static w a;
  
  public static a a(JSONObject paramJSONObject, i parami, float paramFloat, z paramz)
  {
    Object localObject1;
    Object localObject2;
    label66:
    Object localObject4;
    if (paramJSONObject.has("t"))
    {
      float f1 = (float)paramJSONObject.optDouble("t", 0.0D);
      localObject1 = paramJSONObject.opt("s");
      if (localObject1 != null)
      {
        localObject1 = paramz.a(localObject1, paramFloat);
        localObject2 = paramJSONObject.opt("e");
        if (localObject2 != null)
        {
          paramz = paramz.a(localObject2, paramFloat);
          localObject4 = paramJSONObject.optJSONObject("o");
          localObject2 = paramJSONObject.optJSONObject("i");
          if (localObject4 == null)
          {
            localObject2 = null;
            localObject4 = null;
            label93:
            if (paramJSONObject.optInt("h", 0) == 1)
            {
              paramz = a.a;
              paramJSONObject = (JSONObject)localObject1;
              label111:
              paramFloat = f1;
            }
          }
        }
      }
    }
    for (;;)
    {
      return new a(parami, localObject1, paramJSONObject, paramz, paramFloat, null);
      if (localObject4 != null)
      {
        float f2 = -paramFloat;
        ((PointF)localObject4).x = g.a(((PointF)localObject4).x, f2, paramFloat);
        ((PointF)localObject4).y = g.a(((PointF)localObject4).y, -100.0F, 100.0F);
        ((PointF)localObject2).x = g.a(((PointF)localObject2).x, f2, paramFloat);
        ((PointF)localObject2).y = g.a(((PointF)localObject2).y, -100.0F, 100.0F);
        int i = h.a(((PointF)localObject4).x, ((PointF)localObject4).y, ((PointF)localObject2).x, ((PointF)localObject2).y);
        WeakReference localWeakReference = a(i);
        if (localWeakReference != null) {}
        for (paramJSONObject = (Interpolator)localWeakReference.get();; paramJSONObject = null)
        {
          label255:
          float f3;
          float f4;
          if (localWeakReference == null)
          {
            f2 = ((PointF)localObject4).x / paramFloat;
            f3 = ((PointF)localObject4).y / paramFloat;
            f4 = ((PointF)localObject2).x / paramFloat;
            paramFloat = ((PointF)localObject2).y / paramFloat;
            if (Build.VERSION.SDK_INT >= 21) {
              paramJSONObject = new PathInterpolator(f2, f3, f4, paramFloat);
            }
          }
          for (;;)
          {
            try
            {
              localObject2 = new WeakReference(paramJSONObject);
            }
            catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
            {
              continue;
            }
            try
            {
              a.b(i, localObject2);
              localObject2 = paramJSONObject;
              paramJSONObject = paramz;
              paramz = (z)localObject2;
              break;
            }
            finally {}
            paramJSONObject = new e(f2, f3, f4, paramFloat);
            continue;
            if (paramJSONObject == null) {
              break label255;
            }
          }
        }
      }
      localObject2 = a.a;
      paramJSONObject = paramz;
      paramz = (z)localObject2;
      break label111;
      if (localObject2 != null)
      {
        localObject4 = com.airbnb.lottie.d.b.a((JSONObject)localObject4, paramFloat);
        localObject2 = com.airbnb.lottie.d.b.a((JSONObject)localObject2, paramFloat);
        break label93;
      }
      localObject2 = null;
      localObject4 = null;
      break label93;
      paramz = null;
      break label66;
      localObject1 = null;
      break;
      paramJSONObject = paramz.a(paramJSONObject, paramFloat);
      paramFloat = 0.0F;
      paramz = null;
      localObject1 = paramJSONObject;
    }
  }
  
  private static WeakReference a(int paramInt)
  {
    try
    {
      if (a == null) {
        a = new w();
      }
      WeakReference localWeakReference = (WeakReference)a.a(paramInt, null);
      return localWeakReference;
    }
    finally {}
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/airbnb/lottie/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */