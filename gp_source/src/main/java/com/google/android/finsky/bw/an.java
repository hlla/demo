package com.google.android.finsky.bw;

import android.content.Context;
import android.view.ViewGroup.LayoutParams;
import com.google.android.finsky.dfemodel.Document;
import com.google.android.finsky.ds.a.bu;
import com.google.android.finsky.ds.a.bv;
import com.google.android.play.image.FifeImageView;
import com.google.android.play.image.bg;
import com.google.android.play.image.x;
import com.google.android.play.image.y;
import com.google.android.play.image.z;
import java.util.List;

public final class an
{
  public static bu a(Document paramDocument, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      bu localbu = a(paramDocument.c(paramArrayOfInt[i]), paramInt1, paramInt2);
      if (localbu == null) {
        i += 1;
      } else {
        return localbu;
      }
    }
    return null;
  }
  
  public static bu a(Document paramDocument, int[] paramArrayOfInt)
  {
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      bu localbu = paramDocument.e(paramArrayOfInt[i]);
      if (localbu == null) {
        i += 1;
      } else {
        return localbu;
      }
    }
    return null;
  }
  
  public static bu a(List paramList, int paramInt1, int paramInt2)
  {
    bu localbu = null;
    Object localObject2 = localbu;
    Object localObject3;
    Object localObject1;
    if (paramList != null)
    {
      localObject2 = localbu;
      if (!paramList.isEmpty())
      {
        if (paramList.size() == 1) {
          break label369;
        }
        localObject3 = null;
        int i2 = 0;
        int i1 = 0;
        localObject1 = null;
        int k = Integer.MAX_VALUE;
        int m = Integer.MAX_VALUE;
        int n = 0;
        while (n < paramList.size())
        {
          localbu = (bu)paramList.get(n);
          localObject2 = localbu;
          if (localbu.h) {
            break label360;
          }
          localObject2 = localbu.d;
          int i6;
          Object localObject4;
          int i5;
          if (localObject2 == null)
          {
            i6 = k;
            localObject4 = localObject1;
            i5 = i1;
            k = i2;
            localObject1 = localObject3;
            n += 1;
            localObject3 = localObject1;
            i2 = k;
            i1 = i5;
            localObject1 = localObject4;
            k = i6;
          }
          else
          {
            int i3 = ((bv)localObject2).b;
            int i4 = ((bv)localObject2).a;
            int j;
            int i;
            if (i3 < paramInt1)
            {
              j = m;
              i = k;
              localObject2 = localObject1;
            }
            for (;;)
            {
              localObject1 = localObject3;
              k = i2;
              i5 = i1;
              localObject4 = localObject2;
              i6 = i;
              m = j;
              if (i3 < i1) {
                break;
              }
              localObject1 = localObject3;
              k = i2;
              i5 = i1;
              localObject4 = localObject2;
              i6 = i;
              m = j;
              if (i4 < i2) {
                break;
              }
              k = i4;
              localObject1 = localbu;
              i5 = i3;
              localObject4 = localObject2;
              i6 = i;
              m = j;
              break;
              localObject2 = localObject1;
              i = k;
              j = m;
              if (i4 >= paramInt2)
              {
                localObject2 = localObject1;
                i = k;
                j = m;
                if (m >= i3)
                {
                  localObject2 = localObject1;
                  i = k;
                  j = m;
                  if (k >= i4)
                  {
                    localObject2 = localbu;
                    i = i4;
                    j = i3;
                  }
                }
              }
            }
          }
        }
        if (localObject1 != null) {
          break label366;
        }
        if (localObject3 != null) {
          break label363;
        }
        localObject2 = (bu)paramList.get(0);
      }
    }
    label360:
    return (bu)localObject2;
    label363:
    return (bu)localObject3;
    label366:
    return (bu)localObject1;
    label369:
    return (bu)paramList.get(0);
  }
  
  public static y a(Context paramContext, Document paramDocument, x paramx, int paramInt1, int paramInt2, z paramz, int[] paramArrayOfInt)
  {
    if (paramDocument != null) {
      return a(paramContext, a(paramDocument, paramInt1, 0, paramArrayOfInt), paramx, paramInt1, paramInt2, paramz);
    }
    return null;
  }
  
  public static y a(Context paramContext, bu parambu, x paramx, int paramInt1, int paramInt2, z paramz)
  {
    if (parambu != null)
    {
      float f = bg.a(paramContext) * bg.a();
      return paramx.a(parambu.g, (int)(paramInt1 * f), (int)(f * paramInt2), false, paramz, false);
    }
    return null;
  }
  
  public static void a(FifeImageView paramFifeImageView, bu parambu)
  {
    parambu = parambu.d;
    if (parambu != null)
    {
      int i = parambu.b;
      if (i > 0)
      {
        int j = parambu.a;
        if ((j > 0) && (i > j))
        {
          parambu = paramFifeImageView.getLayoutParams();
          float f = parambu.height;
          parambu.width = ((int)(i / j * f));
          paramFifeImageView.requestLayout();
        }
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bw/an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */