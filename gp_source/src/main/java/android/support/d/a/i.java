package android.support.d.a;

import android.animation.TypeEvaluator;

public final class i
  implements TypeEvaluator
{
  public static final i a = new i();
  
  public final Object evaluate(float paramFloat, Object paramObject1, Object paramObject2)
  {
    int i = ((Integer)paramObject1).intValue();
    float f1 = (i >> 24 & 0xFF) / 255.0F;
    int j = ((Integer)paramObject2).intValue();
    float f2 = (float)Math.pow((i >> 16 & 0xFF) / 255.0F, 2.2D);
    float f3 = (float)Math.pow((i >> 8 & 0xFF) / 255.0F, 2.2D);
    float f4 = (float)Math.pow((i & 0xFF) / 255.0F, 2.2D);
    double d2 = Math.pow((j >> 16 & 0xFF) / 255.0F, 2.2D);
    double d3 = Math.pow((j >> 8 & 0xFF) / 255.0F, 2.2D);
    double d1 = Math.pow((j & 0xFF) / 255.0F, 2.2D);
    d2 = Math.pow(f2 + ((float)d2 - f2) * paramFloat, 0.45454545454545453D);
    d3 = Math.pow(((float)d3 - f3) * paramFloat + f3, 0.45454545454545453D);
    d1 = Math.pow(f4 + ((float)d1 - f4) * paramFloat, 0.45454545454545453D);
    return Integer.valueOf(Math.round((((j >> 24 & 0xFF) / 255.0F - f1) * paramFloat + f1) * 255.0F) << 24 | Math.round((float)d2 * 255.0F) << 16 | Math.round((float)d3 * 255.0F) << 8 | Math.round((float)d1 * 255.0F));
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/d/a/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */