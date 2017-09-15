package com.tencent.mm.modelsimple;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ap;
import com.tencent.mm.x.l;
import com.tencent.mm.y.k;
import com.tencent.mm.y.n;
import java.io.File;

public final class al
{
  public static com.tencent.mm.y.e gUt;
  public static boolean hSG;
  private static int hSH;
  private static long hSI;
  
  static
  {
    GMTrace.i(1360028237824L, 10133);
    gUt = null;
    hSG = false;
    hSH = 3;
    hSI = 0L;
    GMTrace.o(1360028237824L, 10133);
  }
  
  public static void run()
  {
    GMTrace.i(1359625584640L, 10130);
    if (hSG)
    {
      v.i("MicroMsg.PostTaskUploadHDHeadImg", "is uploading hdHeadImg now!");
      GMTrace.o(1359625584640L, 10130);
      return;
    }
    if ((hSI == 0L) || (bf.aB(hSI) > 180000L))
    {
      hSI = bf.NB();
      hSH = 3;
    }
    if (hSH <= 0)
    {
      v.i("MicroMsg.PostTaskUploadHDHeadImg", "frequency limit");
      GMTrace.o(1359625584640L, 10130);
      return;
    }
    hSH -= 1;
    Object localObject = com.tencent.mm.compatible.util.e.gSw + "temp.avatar.hd";
    if (!new File((String)localObject).exists())
    {
      v.d("MicroMsg.PostTaskUploadHDHeadImg", "has uploaded HDHeadImg and delete it");
      GMTrace.o(1359625584640L, 10130);
      return;
    }
    if (gUt == null) {
      gUt = new com.tencent.mm.y.e()
      {
        public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, k paramAnonymousk)
        {
          GMTrace.i(1368483954688L, 10196);
          v.i("MicroMsg.PostTaskUploadHDHeadImg", "onSceneEnd errType:%d, erCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0)) {
            b.deleteFile(this.hSJ);
          }
          al.hSG = false;
          ap.vd().b(157, al.gUt);
          GMTrace.o(1368483954688L, 10196);
        }
      };
    }
    ap.vd().a(157, gUt);
    localObject = new l(1, (String)localObject);
    ap.vd().a((k)localObject, 0);
    hSG = true;
    GMTrace.o(1359625584640L, 10130);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelsimple/al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */