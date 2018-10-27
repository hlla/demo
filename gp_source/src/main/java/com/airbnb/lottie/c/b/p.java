package com.airbnb.lottie.c.b;

import android.graphics.PointF;
import java.util.ArrayList;
import java.util.List;

public final class p
{
  public boolean a;
  public final List b = new ArrayList();
  public PointF c;
  
  public p() {}
  
  p(PointF paramPointF, boolean paramBoolean, List paramList)
  {
    this.c = paramPointF;
    this.a = paramBoolean;
    this.b.addAll(paramList);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ShapeData{numCurves=");
    localStringBuilder.append(this.b.size());
    localStringBuilder.append("closed=");
    localStringBuilder.append(this.a);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/airbnb/lottie/c/b/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */