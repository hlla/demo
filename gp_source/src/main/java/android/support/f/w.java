package android.support.f;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;

final class w
  extends Property
{
  private float a;
  private final float b;
  private final PathMeasure c;
  private final PointF d = new PointF();
  private final float[] e = new float[2];
  private final Property f;
  
  w(Property paramProperty, Path paramPath)
  {
    super(Float.class, paramProperty.getName());
    this.f = paramProperty;
    this.c = new PathMeasure(paramPath, false);
    this.b = this.c.getLength();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/f/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */