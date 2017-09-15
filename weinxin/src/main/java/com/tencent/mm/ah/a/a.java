package com.tencent.mm.ah.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.widget.ImageView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.ah.a.c.e;
import com.tencent.mm.ah.a.c.h;
import com.tencent.mm.ah.a.c.i;
import com.tencent.mm.ah.a.c.j;
import com.tencent.mm.ah.a.c.l;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public final class a
{
  private static a hHN;
  public b hHK;
  private com.tencent.mm.ah.a.a.b hHL;
  private final i hHM;
  
  static
  {
    GMTrace.i(15695421112320L, 116940);
    hHN = null;
    GMTrace.o(15695421112320L, 116940);
  }
  
  public a(Context paramContext)
  {
    GMTrace.i(13723628470272L, 102249);
    this.hHM = new com.tencent.mm.ah.a.b.g();
    a(com.tencent.mm.ah.a.a.b.aX(paramContext));
    GMTrace.o(13723628470272L, 102249);
  }
  
  public a(com.tencent.mm.ah.a.a.b paramb)
  {
    GMTrace.i(13723762688000L, 102250);
    this.hHM = new com.tencent.mm.ah.a.b.g();
    a(paramb);
    GMTrace.o(13723762688000L, 102250);
  }
  
  public static a He()
  {
    try
    {
      GMTrace.i(15695286894592L, 116939);
      if (hHN == null) {
        hHN = new a(aa.getContext());
      }
      a locala = hHN;
      GMTrace.o(15695286894592L, 116939);
      return locala;
    }
    finally {}
  }
  
  private void a(ImageView paramImageView, com.tencent.mm.ah.a.a.c paramc)
  {
    GMTrace.i(13725641736192L, 102264);
    if ((paramImageView == null) || (paramc == null))
    {
      v.w("MicroMsg.imageloader.ImageLoader", "[cpan] should show default image view or options is null.");
      GMTrace.o(13725641736192L, 102264);
      return;
    }
    int i;
    Object localObject;
    if ((paramc.hIM > 0) || (paramc.hIN != null))
    {
      i = 1;
      if (i == 0) {
        break label184;
      }
      if (paramc.hIM != 0) {
        break label173;
      }
      localObject = this.hHL.hId;
      if (paramc.hIM == 0) {
        break label164;
      }
      localObject = ((Resources)localObject).getDrawable(paramc.hIM);
      label86:
      paramImageView.setBackgroundDrawable((Drawable)localObject);
      label92:
      if ((paramc.hII <= 0) && (paramc.hIJ == null)) {
        break label192;
      }
      i = 1;
      label108:
      if (i == 0) {
        break label222;
      }
      if (paramc.hII != 0) {
        break label205;
      }
      localObject = this.hHL.hId;
      if (paramc.hII == 0) {
        break label197;
      }
    }
    label164:
    label173:
    label184:
    label192:
    label197:
    for (paramc = ((Resources)localObject).getDrawable(paramc.hII);; paramc = paramc.hIJ)
    {
      paramImageView.setImageDrawable(paramc);
      GMTrace.o(13725641736192L, 102264);
      return;
      i = 0;
      break;
      localObject = paramc.hIN;
      break label86;
      paramImageView.setBackgroundResource(paramc.hIM);
      break label92;
      paramImageView.setBackgroundDrawable(null);
      break label92;
      i = 0;
      break label108;
    }
    label205:
    paramImageView.setImageResource(paramc.hII);
    GMTrace.o(13725641736192L, 102264);
    return;
    label222:
    if (paramc.hIP) {
      paramImageView.setImageDrawable(null);
    }
    GMTrace.o(13725641736192L, 102264);
  }
  
  private void a(com.tencent.mm.ah.a.a.b paramb)
  {
    try
    {
      GMTrace.i(13723896905728L, 102251);
      if (paramb == null) {
        throw new IllegalArgumentException("[cpan] image loader configuration is null.");
      }
    }
    finally {}
    if (this.hHL == null)
    {
      this.hHK = new b(paramb);
      this.hHL = paramb;
      GMTrace.o(13723896905728L, 102251);
    }
    for (;;)
    {
      return;
      v.w("MicroMsg.imageloader.ImageLoader", "[cpan] image loader had init.");
      GMTrace.o(13723896905728L, 102251);
    }
  }
  
  public final void a(String paramString, ImageView paramImageView)
  {
    GMTrace.i(13724031123456L, 102252);
    a(paramString, paramImageView, null, null, null, null, null, null);
    GMTrace.o(13724031123456L, 102252);
  }
  
  public final void a(String paramString, ImageView paramImageView, com.tencent.mm.ah.a.a.c paramc)
  {
    GMTrace.i(13724567994368L, 102256);
    a(paramString, paramImageView, paramc, null, null, null, null, null);
    GMTrace.o(13724567994368L, 102256);
  }
  
  public final void a(String paramString, ImageView paramImageView, com.tencent.mm.ah.a.a.c paramc, e parame, com.tencent.mm.ah.a.c.d paramd)
  {
    GMTrace.i(13724702212096L, 102257);
    a(paramString, paramImageView, paramc, null, null, null, parame, paramd);
    GMTrace.o(13724702212096L, 102257);
  }
  
  public final void a(String paramString, ImageView paramImageView, com.tencent.mm.ah.a.a.c paramc, com.tencent.mm.ah.a.c.g paramg)
  {
    GMTrace.i(13724299558912L, 102254);
    a(paramString, paramImageView, paramc, null, null, paramg, null, null);
    GMTrace.o(13724299558912L, 102254);
  }
  
  public final void a(String paramString, ImageView paramImageView, com.tencent.mm.ah.a.a.c paramc, i parami)
  {
    GMTrace.i(13724836429824L, 102258);
    a(paramString, paramImageView, paramc, parami, null, null, null, null);
    GMTrace.o(13724836429824L, 102258);
  }
  
  public final void a(String paramString, ImageView paramImageView, com.tencent.mm.ah.a.a.c paramc, i parami, j paramj, com.tencent.mm.ah.a.c.g paramg, e parame, com.tencent.mm.ah.a.c.d paramd)
  {
    GMTrace.i(13724970647552L, 102259);
    if (paramc == null) {
      paramc = this.hHL.hIg;
    }
    for (;;)
    {
      if (parami == null) {
        parami = this.hHM;
      }
      for (;;)
      {
        c localc = new c(paramImageView, paramString);
        if (bf.mA(paramString))
        {
          v.w("MicroMsg.imageloader.ImageLoader", "[cpan load image url is null.]");
          a(paramImageView, paramc);
          this.hHK.a(localc);
          parami.a(paramString, null, paramc.hIU);
          GMTrace.o(13724970647552L, 102259);
          return;
        }
        ad localad = paramc.handler;
        if ((localad == null) || (Looper.myLooper() == Looper.getMainLooper())) {
          localad = new ad();
        }
        parame = new com.tencent.mm.ah.a.f.b(paramString, localc, localad, paramc, parami, paramj, this.hHK, paramg, parame, paramd);
        parami = parame.jM(paramString);
        paramj = this.hHK.jI(parami);
        if ((paramImageView != null) && (paramj != null) && (!paramj.isRecycled()))
        {
          v.d("MicroMsg.imageloader.ImageLoader", "[cpan] load from cache. not need to load:%s", new Object[] { parami });
          parami = paramj;
          if (paramc.hID) {
            parami = com.tencent.mm.sdk.platformtools.d.c(paramj, paramc.hIE);
          }
          paramImageView.setImageBitmap(parami);
          parame.ao(0L);
          if (paramg != null) {
            paramg.a(paramString, paramImageView, new com.tencent.mm.ah.a.d.b(parami));
          }
          this.hHK.a(localc);
          GMTrace.o(13724970647552L, 102259);
          return;
        }
        if (paramImageView != null) {
          a(paramImageView, paramc);
        }
        if ((parame.hIg.hIu) || (!this.hHK.hHP.oV()))
        {
          paramImageView = this.hHK;
          if (bf.mA(paramString)) {
            break label611;
          }
          parami = (String)paramImageView.hHR.get(Integer.valueOf(localc.Hf()));
          if ((!bf.mA(parami)) && (paramString.equals(parami))) {
            break label611;
          }
          paramImageView.hHR.put(Integer.valueOf(localc.Hf()), paramString);
        }
        label611:
        for (int i = 1;; i = 0)
        {
          if (i != 0)
          {
            paramString = this.hHK;
            if ((paramString.hHS != null) && (parame.hJb != null))
            {
              paramImageView = (com.tencent.mm.ah.a.f.b)paramString.hHS.get(Integer.valueOf(parame.hJb.Hf()));
              if ((paramImageView != null) && (paramImageView.hJb != null) && (parame.hJb.Hf() == paramImageView.hJb.Hf()))
              {
                paramString.hHP.remove(paramImageView);
                v.d("MicroMsg.imageloader.ImageLoaderManager", "remove taks url:%s", new Object[] { paramImageView.url });
              }
              paramString.hHS.put(Integer.valueOf(parame.hJb.Hf()), parame);
            }
            paramString = this.hHK;
            boolean bool = paramc.hIs;
            if (((ExecutorService)paramString.hHO.hIo).isShutdown()) {
              paramString.hHP = com.tencent.mm.ah.a.a.a.aN(paramString.hHO.hIe, paramString.hHO.hIf);
            }
            paramString.hHP.execute(parame);
            if ((bool) && (com.tencent.mm.ah.a.g.b.Hk())) {
              paramString.hHQ.execute(new com.tencent.mm.ah.a.f.d());
            }
          }
          GMTrace.o(13724970647552L, 102259);
          return;
        }
      }
    }
  }
  
  public final void a(String paramString, ImageView paramImageView, com.tencent.mm.ah.a.c.g paramg)
  {
    GMTrace.i(13724165341184L, 102253);
    a(paramString, paramImageView, null, null, null, paramg, null, null);
    GMTrace.o(13724165341184L, 102253);
  }
  
  public final void a(String paramString, com.tencent.mm.ah.a.a.c paramc, com.tencent.mm.ah.a.c.c paramc1)
  {
    GMTrace.i(13725775953920L, 102265);
    paramString = new com.tencent.mm.ah.a.f.a(paramString, paramc, this.hHK, paramc1);
    this.hHK.hHP.execute(paramString);
    GMTrace.o(13725775953920L, 102265);
  }
  
  public final void b(String paramString, ImageView paramImageView, com.tencent.mm.ah.a.a.c paramc, com.tencent.mm.ah.a.c.g paramg)
  {
    GMTrace.i(13724433776640L, 102255);
    a(paramString, paramImageView, paramc, null, null, paramg, null, null);
    GMTrace.o(13724433776640L, 102255);
  }
  
  public final void bi(int paramInt)
  {
    GMTrace.i(13725104865280L, 102260);
    v.d("MicroMsg.imageloader.ImageLoader", "[cpan] on scroll state changed :%d", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt == 0) || (paramInt == 1))
    {
      v.d("MicroMsg.imageloader.ImageLoader", "[cpan] resume");
      this.hHK.hHP.resume();
      GMTrace.o(13725104865280L, 102260);
      return;
    }
    v.d("MicroMsg.imageloader.ImageLoader", "[cpan] pause");
    this.hHK.hHP.pause();
    GMTrace.o(13725104865280L, 102260);
  }
  
  public final void detach()
  {
    GMTrace.i(13725239083008L, 102261);
    if (this.hHK != null)
    {
      b localb = this.hHK;
      if (localb.hHO != null)
      {
        localb.hHO.hIh.clear();
        localb.hHO.hIi.Hi();
      }
    }
    GMTrace.o(13725239083008L, 102261);
  }
  
  public final void h(String paramString, Bitmap paramBitmap)
  {
    GMTrace.i(13725507518464L, 102263);
    if (this.hHK != null)
    {
      b localb = this.hHK;
      if (localb.hHO != null) {
        localb.hHO.hIh.b(paramString, paramBitmap);
      }
    }
    GMTrace.o(13725507518464L, 102263);
  }
  
  public final Bitmap jI(String paramString)
  {
    GMTrace.i(13725373300736L, 102262);
    if (this.hHK != null)
    {
      paramString = this.hHK.jI(paramString);
      GMTrace.o(13725373300736L, 102262);
      return paramString;
    }
    GMTrace.o(13725373300736L, 102262);
    return null;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ah/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */