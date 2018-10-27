package com.airbnb.lottie.d;

import android.graphics.PointF;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b
{
  public static float a(Object paramObject)
  {
    if ((paramObject instanceof Float)) {
      return ((Float)paramObject).floatValue();
    }
    if ((paramObject instanceof Integer)) {
      return ((Integer)paramObject).intValue();
    }
    if ((paramObject instanceof Double)) {
      return (float)((Double)paramObject).doubleValue();
    }
    if ((paramObject instanceof JSONArray)) {
      return (float)((JSONArray)paramObject).optDouble(0);
    }
    return 0.0F;
  }
  
  public static PointF a(JSONArray paramJSONArray, float paramFloat)
  {
    if (paramJSONArray.length() < 2)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unable to parse point for ");
      localStringBuilder.append(paramJSONArray);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return new PointF((float)paramJSONArray.optDouble(0, 1.0D) * paramFloat, (float)paramJSONArray.optDouble(1, 1.0D) * paramFloat);
  }
  
  public static PointF a(JSONObject paramJSONObject, float paramFloat)
  {
    return new PointF(a(paramJSONObject.opt("x")) * paramFloat, a(paramJSONObject.opt("y")) * paramFloat);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/airbnb/lottie/d/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */