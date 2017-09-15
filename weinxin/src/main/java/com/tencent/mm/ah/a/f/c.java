package com.tencent.mm.ah.a.f;

import android.graphics.Bitmap;
import android.os.Looper;
import android.widget.ImageView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.ah.a.b;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.ref.WeakReference;
import java.util.Map;

public final class c
  implements Runnable
{
  private String arH;
  private Bitmap bitmap;
  private b hIZ;
  private com.tencent.mm.ah.a.c hJb;
  private String url;
  
  public c(String paramString1, com.tencent.mm.ah.a.c paramc, Bitmap paramBitmap, b paramb, String paramString2)
  {
    GMTrace.i(13732352622592L, 102314);
    this.url = paramString1;
    this.hJb = paramc;
    this.bitmap = paramBitmap;
    this.hIZ = paramb;
    this.arH = paramString2;
    GMTrace.o(13732352622592L, 102314);
  }
  
  public final void run()
  {
    GMTrace.i(13732486840320L, 102315);
    if ((!bf.mA(this.url)) && (this.hJb != null) && (this.bitmap != null) && (!this.bitmap.isRecycled()) && (this.hIZ != null))
    {
      Object localObject1 = this.hIZ;
      Object localObject2 = this.hJb;
      localObject1 = (String)((b)localObject1).hHR.get(Integer.valueOf(((com.tencent.mm.ah.a.c)localObject2).Hf()));
      if (this.url.equals(localObject1))
      {
        localObject2 = this.hJb;
        localObject1 = this.bitmap;
        if ((Looper.myLooper() == Looper.getMainLooper()) && (((com.tencent.mm.ah.a.c)localObject2).hHT != null))
        {
          localObject2 = (ImageView)((com.tencent.mm.ah.a.c)localObject2).hHT.get();
          if (localObject2 != null) {
            ((ImageView)localObject2).setImageBitmap((Bitmap)localObject1);
          }
        }
        this.hIZ.a(this.hJb);
        GMTrace.o(13732486840320L, 102315);
        return;
      }
      v.w("MicroMsg.imageloader.ImageShowTask", "[cpan] url is not equals view url.");
      GMTrace.o(13732486840320L, 102315);
      return;
    }
    v.w("MicroMsg.imageloader.ImageShowTask", "[cpan] run something is null.");
    GMTrace.o(13732486840320L, 102315);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ah/a/f/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */