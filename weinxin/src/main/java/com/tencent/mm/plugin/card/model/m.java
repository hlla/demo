package com.tencent.mm.plugin.card.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.platformtools.i;
import com.tencent.mm.platformtools.i.a;
import com.tencent.mm.platformtools.i.b;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import java.io.File;
import java.io.IOException;

public final class m
  implements i
{
  public static final String kdJ;
  public static final String kdK;
  private final String TAG;
  private String mPicUrl;
  
  static
  {
    GMTrace.i(4925119528960L, 36695);
    kdJ = e.hgk + "card";
    kdK = kdJ + File.separator + "video";
    GMTrace.o(4925119528960L, 36695);
  }
  
  public m(String paramString)
  {
    GMTrace.i(4923240480768L, 36681);
    this.TAG = "MicroMsg.CardSimpleGetPicStrategy";
    this.mPicUrl = null;
    this.mPicUrl = paramString;
    GMTrace.o(4923240480768L, 36681);
  }
  
  public static String ss(String paramString)
  {
    GMTrace.i(4923643133952L, 36684);
    paramString = String.format("%s/%s", new Object[] { kdJ, g.n(paramString.getBytes()) });
    GMTrace.o(4923643133952L, 36684);
    return paramString;
  }
  
  public final void F(String paramString, boolean paramBoolean)
  {
    GMTrace.i(4924851093504L, 36693);
    GMTrace.o(4924851093504L, 36693);
  }
  
  public final i.b Nm()
  {
    GMTrace.i(4923374698496L, 36682);
    GMTrace.o(4923374698496L, 36682);
    return null;
  }
  
  public final String Nn()
  {
    GMTrace.i(4923508916224L, 36683);
    String str = String.format("%s/%s", new Object[] { kdJ, g.n(this.mPicUrl.getBytes()) });
    GMTrace.o(4923508916224L, 36683);
    return str;
  }
  
  public final String No()
  {
    GMTrace.i(4923777351680L, 36685);
    String str = this.mPicUrl;
    GMTrace.o(4923777351680L, 36685);
    return str;
  }
  
  public final String Np()
  {
    GMTrace.i(4923911569408L, 36686);
    String str = this.mPicUrl;
    GMTrace.o(4923911569408L, 36686);
    return str;
  }
  
  public final String Nq()
  {
    GMTrace.i(4924045787136L, 36687);
    String str = this.mPicUrl;
    GMTrace.o(4924045787136L, 36687);
    return str;
  }
  
  public final boolean Nr()
  {
    GMTrace.i(4924180004864L, 36688);
    GMTrace.o(4924180004864L, 36688);
    return true;
  }
  
  public final boolean Ns()
  {
    GMTrace.i(4924314222592L, 36689);
    GMTrace.o(4924314222592L, 36689);
    return false;
  }
  
  public final Bitmap Nt()
  {
    GMTrace.i(4924448440320L, 36690);
    v.d("MicroMsg.CardSimpleGetPicStrategy", "no sd card!");
    GMTrace.o(4924448440320L, 36690);
    return null;
  }
  
  public final void Nu()
  {
    GMTrace.i(4924716875776L, 36692);
    GMTrace.o(4924716875776L, 36692);
  }
  
  public final Bitmap a(Bitmap paramBitmap, i.a parama, String paramString)
  {
    GMTrace.i(4924582658048L, 36691);
    if (i.a.ihn == parama) {}
    try
    {
      d.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, Nn(), false);
      v.d("MicroMsg.CardSimpleGetPicStrategy", "get bitmap, from %s", new Object[] { parama.toString() });
      GMTrace.o(4924582658048L, 36691);
      return paramBitmap;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        try
        {
          paramString = new File(Nn());
          if (!paramString.exists()) {
            paramString.mkdirs();
          }
          v.w("MicroMsg.CardSimpleGetPicStrategy", " retry saving bitmap");
          d.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, Nn(), false);
        }
        catch (IOException paramString)
        {
          v.printErrStackTrace("MicroMsg.CardSimpleGetPicStrategy", paramString, "", new Object[0]);
          v.w("MicroMsg.CardSimpleGetPicStrategy", "save bitmap fail");
        }
      }
    }
  }
  
  public final void a(i.a parama, String paramString)
  {
    GMTrace.i(4924985311232L, 36694);
    GMTrace.o(4924985311232L, 36694);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/card/model/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */