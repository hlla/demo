package com.google.android.play.image;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.g.i;
import android.text.TextUtils;
import com.android.volley.n;
import com.android.volley.r;
import com.android.volley.w;
import com.google.android.play.utils.b.a;
import com.google.android.play.utils.b.j;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.BlockingDeque;

public class ah
  implements x
{
  public final HashMap a = new HashMap();
  public i b;
  public final af c;
  public at d;
  public aa e;
  public final Handler f = new Handler(Looper.getMainLooper());
  public final HashMap g = new HashMap();
  public boolean h;
  public final int i;
  public ab j;
  public Runnable k;
  public bz l;
  private final r m;
  private ac n;
  
  public ah(r paramr, int paramInt1, int paramInt2, bz parambz)
  {
    this.m = paramr;
    this.d = new at(this);
    paramr = this.d;
    int i1 = 0;
    Object localObject = paramr.c;
    if (i1 >= localObject.length)
    {
      for (;;)
      {
        i1 = i2;
        if (paramr.b.isEmpty()) {
          break;
        }
        paramr.b.remove();
      }
      for (;;)
      {
        localObject = paramr.c;
        if (i1 >= localObject.length) {
          break;
        }
        localObject[i1] = new au(paramr, paramr.b, paramr.d);
        paramr.c[i1].start();
        i1 += 1;
      }
      i1 = ((Integer)j.e.b()).intValue();
      float f1;
      if (i1 == -1) {
        f1 = paramInt1 * paramInt2 * 4;
      }
      for (paramInt1 = Math.max(3145728, (int)(((Float)j.f.b()).floatValue() * f1));; paramInt1 = i1 * 1024 * 1024)
      {
        this.i = Math.max(((Integer)j.p.b()).intValue(), paramInt1 / 6);
        this.c = new af(paramInt1);
        this.b = new i(50);
        this.l = parambz;
        return;
      }
    }
    localObject = localObject[i1];
    if (localObject == null) {}
    for (;;)
    {
      i1 += 1;
      break;
      ((au)localObject).a = true;
      ((au)localObject).interrupt();
    }
  }
  
  private final void a(ao paramao, String paramString, ap paramap, int paramInt1, int paramInt2)
  {
    ai localai = new ai(paramao);
    paramao.c = localai;
    this.d.a(paramString, paramap, paramInt1, paramInt2, localai);
  }
  
  private final void a(String paramString, ar paramar, ao paramao)
  {
    as localas = (as)this.g.get(paramString);
    if (localas == null)
    {
      paramar = paramar.a();
      this.m.a(paramar);
      this.g.put(paramString, new as(this, paramar, paramao));
      return;
    }
    localas.a.add(paramao);
  }
  
  public aq a(String paramString, int paramInt1, int paramInt2, int paramInt3, com.android.volley.x paramx, w paramw)
  {
    return new aq(paramString, paramx, paramInt1, paramInt2, paramInt3, paramw);
  }
  
  public final y a(String paramString, int paramInt1, int paramInt2, z paramz)
  {
    return a(paramString, paramInt1, paramInt2, true, paramz, false);
  }
  
  public final y a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, z paramz, boolean paramBoolean2)
  {
    int i1;
    if (paramInt1 > 0) {
      i1 = br.a().b.a();
    }
    for (String str = bg.a(paramString, paramInt1, paramInt2, i1);; str = paramString)
    {
      Object localObject2 = new aj(this, paramInt1, paramInt2, str, paramString, i1, paramBoolean2);
      if (TextUtils.isEmpty(paramString)) {
        return new ao(this, null, null, null, paramInt1, paramInt2, null);
      }
      Object localObject1;
      if (!paramBoolean2)
      {
        localObject1 = this.b;
        if (localObject1 != null) {
          if (((i)localObject1).a(paramString) != null) {
            localObject1 = (Bitmap)((WeakReference)this.b.a(paramString)).get();
          }
        }
      }
      for (;;)
      {
        if ((localObject1 != null) && ((((Bitmap)localObject1).getWidth() * 1.25D >= paramInt1) || (((Bitmap)localObject1).getHeight() * 1.25D >= paramInt2)))
        {
          localObject2 = this.e;
          if (localObject2 != null) {
            ((aa)localObject2).a();
          }
          return new ao(this, (Bitmap)localObject1, paramString, str, paramInt1, paramInt2, paramz);
        }
        if (localObject1 == null)
        {
          localObject1 = this.e;
          if (localObject1 != null) {
            ((aa)localObject1).a(false);
          }
        }
        for (paramz = new ao(this, null, paramString, str, paramInt1, paramInt2, paramz);; paramz = new ao(this, (Bitmap)localObject1, paramString, str, paramInt1, paramInt2, paramz))
        {
          if (!paramBoolean2) {}
          for (localObject1 = (ap)this.c.a.a(paramString);; localObject1 = null)
          {
            if (localObject1 != null)
            {
              if ((i1 >= ((ap)localObject1).c) && (paramInt1 <= ((ap)localObject1).d * 1.25D) && (paramInt2 <= ((ap)localObject1).a * 1.25D))
              {
                a(paramz, paramString, (ap)localObject1, paramInt1, paramInt2);
                return paramz;
              }
              if (!paramBoolean1) {}
              for (;;)
              {
                a(str, (ar)localObject2, paramz);
                paramz.d = true;
                break;
                a(paramz, paramString, (ap)localObject1, paramInt1, paramInt2);
              }
            }
            if (paramBoolean1)
            {
              paramString = this.n;
              if (paramString != null) {
                paramString.a(paramz, this.c);
              }
            }
            a(str, (ar)localObject2, paramz);
            paramz.d = true;
            return paramz;
          }
          if (!paramBoolean1) {
            break;
          }
          aa localaa = this.e;
          if (localaa != null) {
            localaa.a(true);
          }
        }
        localObject1 = null;
        continue;
        localObject1 = null;
        continue;
        localObject1 = null;
      }
      if (paramInt2 > 0) {
        break;
      }
      i1 = -1;
    }
  }
  
  public final void a(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.g.keySet().iterator();
    if (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (((as)this.g.get(str)).b == null) {}
      for (;;)
      {
        localArrayList.add(str);
        break;
        if (((as)this.g.get(str)).b.ab_() >= paramInt) {
          break;
        }
      }
    }
    int i1 = localArrayList.size();
    paramInt = 0;
    while (paramInt < i1)
    {
      localObject = (String)localArrayList.get(paramInt);
      this.g.remove(localObject);
      paramInt += 1;
    }
  }
  
  public final void a(aa paramaa)
  {
    this.e = paramaa;
  }
  
  public final void a(ab paramab)
  {
    this.j = paramab;
  }
  
  public final void a(ac paramac)
  {
    this.n = paramac;
  }
  
  public final y b(String paramString, int paramInt1, int paramInt2, z paramz)
  {
    return a(paramString, paramInt1, paramInt2, false, paramz, false);
  }
  
  public final void b()
  {
    this.c.a();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/play/image/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */