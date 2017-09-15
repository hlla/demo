package com.tencent.mm.modelbiz;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.g;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aq.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ag.a;
import com.tencent.mm.u.ag.e;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class l
{
  public static String V(String paramString1, String paramString2)
  {
    GMTrace.i(4540585738240L, 33830);
    if ((paramString1 == null) || (!h.vG().uV()))
    {
      GMTrace.o(4540585738240L, 33830);
      return null;
    }
    paramString1 = w.DH().hO(paramString1);
    if (paramString1.field_brandIconURL != null)
    {
      paramString1 = paramString1.field_brandIconURL;
      GMTrace.o(4540585738240L, 33830);
      return paramString1;
    }
    GMTrace.o(4540585738240L, 33830);
    return paramString2;
  }
  
  public static Bitmap b(String paramString1, String paramString2, int paramInt)
  {
    GMTrace.i(4540183085056L, 33827);
    if (!h.vI().isSDCardAvailable())
    {
      paramString1 = fz(paramInt);
      GMTrace.o(4540183085056L, 33827);
      return paramString1;
    }
    if ((paramString1 == null) || (!h.vG().uV()))
    {
      GMTrace.o(4540183085056L, 33827);
      return null;
    }
    final String str = paramString2;
    if (paramString2 == null)
    {
      paramString2 = V(paramString1, null);
      str = paramString2;
      if (paramString2 == null)
      {
        GMTrace.o(4540183085056L, 33827);
        return null;
      }
    }
    paramString2 = w.DP();
    Object localObject;
    if (paramString2.hvK.containsKey(paramString1))
    {
      localObject = (Bitmap)((WeakReference)paramString2.hvK.get(paramString1)).get();
      if ((localObject == null) || (((Bitmap)localObject).isRecycled()))
      {
        localObject = V(paramString1, str);
        localObject = com.tencent.mm.sdk.platformtools.d.Pf(a.in(paramString1 + (String)localObject));
        if (localObject == null)
        {
          v.i("MicroMsg.BrandLogic", "not found brand icon local");
          paramString2 = null;
          label182:
          if (paramString2 == null) {
            break label291;
          }
          GMTrace.o(4540183085056L, 33827);
          return paramString2;
        }
        paramString2.e(paramString1, (Bitmap)localObject);
      }
    }
    for (;;)
    {
      paramString2 = (WeakReference)paramString2.hvK.get(paramString1);
      if (paramString2 == null) {
        break;
      }
      paramString2 = (Bitmap)paramString2.get();
      break label182;
      localObject = V(paramString1, str);
      localObject = com.tencent.mm.sdk.platformtools.d.Pf(a.in(paramString1 + (String)localObject));
      if (localObject == null)
      {
        v.i("MicroMsg.BrandLogic", "not found brand icon local");
        break;
      }
      paramString2.e(paramString1, (Bitmap)localObject);
    }
    label291:
    ae.v(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(4529043013632L, 33744);
        l.a locala = w.DP();
        String str1 = this.hvG;
        String str2 = str;
        if ((bf.mA(str1)) || (bf.mA(str2)))
        {
          v.e("MicroMsg.BrandLogic", "pushing for brand " + str1 + ", url " + str2);
          GMTrace.o(4529043013632L, 33744);
          return;
        }
        if (bf.az(bf.f((Integer)locala.hvJ.get(str1))) < 300L)
        {
          v.i("MicroMsg.BrandLogic", "downloading interval less than 5 mins for " + str1);
          GMTrace.o(4529043013632L, 33744);
          return;
        }
        locala.hvJ.put(str1, Integer.valueOf((int)bf.Nz()));
        if ((locala.hvL == null) || (locala.hvL.bJn())) {
          locala.hvL = new aq(1, "brand-logic");
        }
        str2 = l.V(str1, str2);
        locala.hvL.c(new l.b(str1, str2));
        GMTrace.o(4529043013632L, 33744);
      }
    });
    GMTrace.o(4540183085056L, 33827);
    return null;
  }
  
  private static Bitmap fz(int paramInt)
  {
    GMTrace.i(4540451520512L, 33829);
    if (paramInt <= 0)
    {
      GMTrace.o(4540451520512L, 33829);
      return null;
    }
    Object localObject = new BitmapFactory.Options();
    com.tencent.mm.sdk.platformtools.d.b((BitmapFactory.Options)localObject);
    Bitmap localBitmap = BitmapFactory.decodeStream(aa.getContext().getResources().openRawResource(paramInt), null, (BitmapFactory.Options)localObject);
    localObject = localBitmap;
    if (localBitmap != null) {
      localObject = com.tencent.mm.sdk.platformtools.d.a(localBitmap, false, localBitmap.getWidth() >> 1);
    }
    GMTrace.o(4540451520512L, 33829);
    return (Bitmap)localObject;
  }
  
  public static Bitmap il(String paramString)
  {
    boolean bool = false;
    GMTrace.i(4540048867328L, 33826);
    if ((bf.mA(paramString)) || (!h.vI().isSDCardAvailable()) || (!h.vG().uV()))
    {
      GMTrace.o(4540048867328L, 33826);
      return null;
    }
    a locala = w.DP();
    String str = String.format("%s%f", new Object[] { paramString, Float.valueOf(1.5F) });
    Bitmap localBitmap1;
    if (locala.hvK.containsKey(str))
    {
      Bitmap localBitmap2 = (Bitmap)((WeakReference)locala.hvK.get(str)).get();
      if (localBitmap2 != null)
      {
        localBitmap1 = localBitmap2;
        if (!localBitmap2.isRecycled()) {}
      }
      else
      {
        localBitmap1 = BackwardSupportUtil.b.c(paramString, 1.5F);
        locala.hvK.remove(str);
        locala.hvK.put(str, new WeakReference(localBitmap1));
      }
    }
    for (;;)
    {
      if (localBitmap1 == null) {
        bool = true;
      }
      v.i("MicroMsg.BrandLogic", "get verify user icon = %s, is null ? %s", new Object[] { paramString, String.valueOf(bool) });
      GMTrace.o(4540048867328L, 33826);
      return localBitmap1;
      localBitmap1 = BackwardSupportUtil.b.c(paramString, 1.5F);
      locala.hvK.put(str, new WeakReference(localBitmap1));
    }
  }
  
  public static Bitmap im(String paramString)
  {
    GMTrace.i(4540317302784L, 33828);
    if (!h.vI().isSDCardAvailable())
    {
      paramString = fz(0);
      GMTrace.o(4540317302784L, 33828);
      return paramString;
    }
    if ((paramString == null) || (!h.vG().uV()))
    {
      GMTrace.o(4540317302784L, 33828);
      return null;
    }
    Object localObject = w.DP();
    if (((a)localObject).hvK.containsKey(paramString))
    {
      localObject = (Bitmap)((WeakReference)((a)localObject).hvK.get(paramString)).get();
      if (localObject != null)
      {
        paramString = (String)localObject;
        if (!((Bitmap)localObject).isRecycled()) {}
      }
      else
      {
        GMTrace.o(4540317302784L, 33828);
        return null;
      }
    }
    else
    {
      paramString = null;
    }
    GMTrace.o(4540317302784L, 33828);
    return paramString;
  }
  
  public static final class a
  {
    List<a> hvI;
    Map<String, Integer> hvJ;
    Map<String, WeakReference<Bitmap>> hvK;
    aq hvL;
    
    public a()
    {
      GMTrace.i(4552396898304L, 33918);
      this.hvI = new ArrayList();
      this.hvJ = new HashMap();
      this.hvK = new HashMap();
      this.hvL = null;
      GMTrace.o(4552396898304L, 33918);
    }
    
    public static String in(String paramString)
    {
      GMTrace.i(4552933769216L, 33922);
      if (h.vG().uV())
      {
        paramString = ((n)h.h(n.class)).xo() + "/brand_" + g.n(paramString.getBytes());
        GMTrace.o(4552933769216L, 33922);
        return paramString;
      }
      GMTrace.o(4552933769216L, 33922);
      return "";
    }
    
    public final void DB()
    {
      GMTrace.i(4552799551488L, 33921);
      this.hvI.clear();
      GMTrace.o(4552799551488L, 33921);
    }
    
    public final void a(a parama)
    {
      GMTrace.i(4552531116032L, 33919);
      this.hvI.add(parama);
      GMTrace.o(4552531116032L, 33919);
    }
    
    public final void b(a parama)
    {
      GMTrace.i(4552665333760L, 33920);
      this.hvI.remove(parama);
      GMTrace.o(4552665333760L, 33920);
    }
    
    final void e(String paramString, Bitmap paramBitmap)
    {
      GMTrace.i(4553067986944L, 33923);
      Bitmap localBitmap1;
      if (this.hvK.containsKey(paramString)) {
        localBitmap1 = (Bitmap)((WeakReference)this.hvK.get(paramString)).get();
      }
      for (;;)
      {
        Bitmap localBitmap3;
        if (localBitmap1 != null)
        {
          localBitmap3 = localBitmap1;
          if (!localBitmap1.isRecycled()) {
            break label113;
          }
        }
        try
        {
          localBitmap1 = Bitmap.createScaledBitmap(paramBitmap, 128, 128, true);
          localBitmap1 = com.tencent.mm.sdk.platformtools.d.a(localBitmap1, true, localBitmap1.getWidth() >> 1);
          this.hvK.remove(paramString);
          this.hvK.put(paramString, new WeakReference(localBitmap1));
          localBitmap3 = localBitmap1;
          label113:
          if (localBitmap3 == paramBitmap)
          {
            GMTrace.o(4553067986944L, 33923);
            return;
            localBitmap1 = null;
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          for (;;)
          {
            Bitmap localBitmap2 = paramBitmap;
          }
          v.i("MicroMsg.BrandLogic", "recycle bitmap:%s", new Object[] { paramBitmap.toString() });
          paramBitmap.recycle();
          GMTrace.o(4553067986944L, 33923);
        }
      }
    }
    
    public static abstract interface a
    {
      public abstract void io(String paramString);
    }
  }
  
  private static final class b
    implements aq.a
  {
    public byte[] hqE;
    private final String hvM;
    private final String url;
    
    public b(String paramString1, String paramString2)
    {
      GMTrace.i(4536827641856L, 33802);
      this.hqE = null;
      this.hvM = paramString1;
      this.url = paramString2;
      GMTrace.o(4536827641856L, 33802);
    }
    
    public final boolean Bn()
    {
      GMTrace.i(4536961859584L, 33803);
      if ((bf.mA(this.hvM)) || (bf.mA(this.url)))
      {
        GMTrace.o(4536961859584L, 33803);
        return false;
      }
      Object localObject1;
      Object localObject2;
      try
      {
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        localObject1 = b.k(this.url, 3000, 5000);
        if (localObject1 == null)
        {
          GMTrace.o(4536961859584L, 33803);
          return false;
        }
        localObject2 = new byte['Ѐ'];
        for (;;)
        {
          int i = ((InputStream)localObject1).read((byte[])localObject2);
          if (i == -1) {
            break;
          }
          localByteArrayOutputStream.write((byte[])localObject2, 0, i);
        }
        ((InputStream)localObject1).close();
      }
      catch (Exception localException1)
      {
        v.e("MicroMsg.BrandLogic", "exception:%s", new Object[] { bf.g(localException1) });
        v.e("MicroMsg.BrandLogic", "get url:" + this.url + " failed.");
        this.hqE = null;
        GMTrace.o(4536961859584L, 33803);
        return false;
      }
      this.hqE = localException1.toByteArray();
      localException1.close();
      if (bf.bm(this.hqE))
      {
        v.e("MicroMsg.BrandLogic", "imgBuff null brand:" + this.hvM);
        GMTrace.o(4536961859584L, 33803);
        return false;
      }
      l.a locala;
      String str;
      if (h.vG().uV())
      {
        ag.a.hlB.aH(this.hqE.length, 0);
        locala = w.DP();
        localObject1 = this.hvM;
        str = this.url;
        localObject2 = this.hqE;
      }
      try
      {
        str = (String)localObject1 + str;
        localObject2 = com.tencent.mm.sdk.platformtools.d.bd((byte[])localObject2);
        com.tencent.mm.sdk.platformtools.d.a((Bitmap)localObject2, 100, Bitmap.CompressFormat.PNG, l.a.in(str), false);
        locala.e((String)localObject1, (Bitmap)localObject2);
        v.i("MicroMsg.BrandLogic", "update brand icon for  " + (String)localObject1 + ", done");
        locala.hvJ.remove(localObject1);
        GMTrace.o(4536961859584L, 33803);
        return true;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          v.e("MicroMsg.BrandLogic", "exception:%s", new Object[] { bf.g(localException2) });
        }
      }
    }
    
    public final boolean Bo()
    {
      GMTrace.i(4537096077312L, 33804);
      l.a locala = w.DP();
      String str = this.hvM;
      int i = 0;
      try
      {
        while (i < locala.hvI.size())
        {
          ((l.a.a)locala.hvI.get(i)).io(str);
          i += 1;
        }
        return false;
      }
      catch (Exception localException)
      {
        v.e("MicroMsg.BrandLogic", "exception:%s", new Object[] { bf.g(localException) });
        GMTrace.o(4537096077312L, 33804);
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelbiz/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */