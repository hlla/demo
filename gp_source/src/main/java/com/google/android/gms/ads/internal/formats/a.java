package com.google.android.gms.ads.internal.formats;

import android.graphics.Color;
import com.google.android.gms.ads.internal.formats.a.b;
import java.util.ArrayList;
import java.util.List;

@com.google.android.gms.ads.internal.q.a.a
public final class a
  extends b
{
  private static final int i = Color.rgb(12, 174, 206);
  private static final int j = Color.rgb(204, 204, 204);
  private static final int k = i;
  public final boolean a;
  public final int b;
  public final List c = new ArrayList();
  public final int d;
  public final String e;
  public final int f;
  public final int g;
  public final int h;
  private final List l = new ArrayList();
  
  public a(String paramString, List paramList, Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.e = paramString;
    if (paramList != null)
    {
      m = 0;
      while (m < paramList.size())
      {
        paramString = (h)paramList.get(m);
        this.c.add(paramString);
        this.l.add(paramString);
        m += 1;
      }
    }
    if (paramInteger1 == null) {}
    for (int m = j;; m = paramInteger1.intValue())
    {
      this.f = m;
      if (paramInteger2 == null) {}
      for (m = k;; m = paramInteger2.intValue())
      {
        this.g = m;
        if (paramInteger3 != null) {}
        for (m = paramInteger3.intValue();; m = 12)
        {
          this.h = m;
          this.b = paramInt1;
          this.d = paramInt2;
          this.a = paramBoolean;
          return;
        }
      }
    }
  }
  
  public final String a()
  {
    return this.e;
  }
  
  public final List b()
  {
    return this.l;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/formats/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */