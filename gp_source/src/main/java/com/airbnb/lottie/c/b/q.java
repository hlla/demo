package com.airbnb.lottie.c.b;

import android.graphics.PointF;
import com.airbnb.lottie.c.a.z;
import org.json.JSONArray;

public final class q
  implements z
{
  public static final q a = new q();
  
  private static PointF a(int paramInt, JSONArray paramJSONArray)
  {
    if (paramInt >= paramJSONArray.length())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Invalid index ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(". There are only ");
      ((StringBuilder)localObject).append(paramJSONArray.length());
      ((StringBuilder)localObject).append(" points.");
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    Object localObject = paramJSONArray.optJSONArray(paramInt);
    paramJSONArray = ((JSONArray)localObject).opt(0);
    localObject = ((JSONArray)localObject).opt(1);
    if ((paramJSONArray instanceof Double)) {}
    for (float f1 = ((Double)paramJSONArray).floatValue();; f1 = ((Integer)paramJSONArray).intValue())
    {
      if ((localObject instanceof Double)) {}
      for (float f2 = ((Double)localObject).floatValue();; f2 = ((Integer)localObject).intValue()) {
        return new PointF(f1, f2);
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/airbnb/lottie/c/b/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */