package com.tencent.mm.pluginsdk.k.a.b;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.pluginsdk.k.a.d.f;
import com.tencent.mm.pluginsdk.k.a.d.f.a;
import com.tencent.mm.pluginsdk.k.a.d.f.d;
import com.tencent.mm.pluginsdk.k.a.d.t;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

final class k
  extends f<a>
{
  private final f<a>.a sEz;
  
  k()
  {
    GMTrace.i(848658694144L, 6323);
    this.sEz = new f.a(this, 0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), new t());
    GMTrace.o(848658694144L, 6323);
  }
  
  final void a(a parama)
  {
    GMTrace.i(848792911872L, 6324);
    if (Mr(parama.sDr))
    {
      v.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptExecutor", "URLKey(%s) is already decrypting, skip repeated task", new Object[] { parama.sDr });
      GMTrace.o(848792911872L, 6324);
      return;
    }
    if (((parama.sDs) && (parama.fEu == parama.sDv) && (parama.sDv >= 0)) || ((!parama.sDs) && (parama.sDt))) {}
    for (int i = 1; i == 0; i = 0)
    {
      GMTrace.o(848792911872L, 6324);
      return;
    }
    v.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptExecutor", "request#URLKey(%s) posted to decryptWorker", new Object[] { parama.sDr });
    super.b(parama);
    GMTrace.o(848792911872L, 6324);
  }
  
  protected final f<a>.a bDn()
  {
    GMTrace.i(848927129600L, 6325);
    f.a locala = this.sEz;
    GMTrace.o(848927129600L, 6325);
    return locala;
  }
  
  private static final class a
    extends f.d<a>
  {
    protected a(a parama)
    {
      super();
      GMTrace.i(844766380032L, 6294);
      GMTrace.o(844766380032L, 6294);
    }
    
    public final void run()
    {
      GMTrace.i(844900597760L, 6295);
      v.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptTask", "%s: decryptTask, entered", new Object[] { ((a)Qv()).sDr });
      Object localObject1 = (a)Qv();
      int i = ((a)localObject1).fEs;
      int j = ((a)localObject1).fEt;
      int k = ((a)localObject1).fEu;
      label854:
      label873:
      label940:
      label950:
      label953:
      label956:
      for (;;)
      {
        try
        {
          localObject1 = (a)Qv();
          localObject1 = new l(((a)localObject1).fEs, ((a)localObject1).fEt, ((a)localObject1).filePath, ((a)localObject1).sDs, ((a)localObject1).sDt, ((a)localObject1).sDu, ((a)localObject1).sDv, ((a)localObject1).sDy, ((a)localObject1).fEv, ((a)localObject1).sDw, ((a)localObject1).sDx, ((a)localObject1).sDA, ((a)localObject1).sDz, ((a)localObject1).url, ((a)localObject1).sDB, ((a)localObject1).sDC, ((a)localObject1).fEu);
          if (((l)localObject1).sEa)
          {
            v.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), do fileDecompress", new Object[] { ((l)localObject1).sDr });
            ((l)localObject1).sEA = (((l)localObject1).filePath + ".decompressed");
            ((l)localObject1).state = 32;
            if (((l)localObject1).bDq() == null) {
              break label950;
            }
            ((l)localObject1).state = 16;
            v.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), file already valid", new Object[] { ((l)localObject1).sDr });
            break label950;
            v.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: verify(), file_state " + ((l)localObject1).bDr(), new Object[] { ((l)localObject1).sDr });
            if (16 == ((l)localObject1).state)
            {
              localObject1 = ((l)localObject1).bDo().bDp().bDq();
              if (bf.mA((String)localObject1)) {
                break label873;
              }
              b.c.sDY.b(i, j, (String)localObject1, k);
              if (!Thread.interrupted()) {
                break label940;
              }
              v.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptTask", "%s: decrypting and interrupted", new Object[] { ((a)Qv()).sDr });
              com.tencent.mm.pluginsdk.k.a.e.a.Mx(((a)Qv()).filePath);
              com.tencent.mm.pluginsdk.k.a.e.a.Mx(((a)Qv()).filePath + ".decrypted");
              com.tencent.mm.pluginsdk.k.a.e.a.Mx(((a)Qv()).filePath + ".decompressed");
              GMTrace.o(844900597760L, 6295);
            }
          }
          else
          {
            if (((l)localObject1).sEb)
            {
              v.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), do fileDecrypt", new Object[] { ((l)localObject1).sDr });
              ((l)localObject1).sEA = (((l)localObject1).filePath + ".decrypted");
              ((l)localObject1).state = 32;
              if (((l)localObject1).bDq() == null) {
                break label953;
              }
              ((l)localObject1).state = 16;
              v.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), file already valid", new Object[] { ((l)localObject1).sDr });
              break label953;
            }
            v.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), just check sum", new Object[] { ((l)localObject1).sDr });
            ((l)localObject1).sEA = ((l)localObject1).filePath;
            ((l)localObject1).state = 32;
            if (((l)localObject1).bDq() == null) {
              break label956;
            }
            ((l)localObject1).state = 16;
            v.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), file already valid", new Object[] { ((l)localObject1).sDr });
            break label956;
          }
          if (((l)localObject1).sEb)
          {
            ((l)localObject1).sEA = ((l)localObject1).filePath;
            ((l)localObject1).sEB = (((l)localObject1).filePath + ".decrypted");
            ((l)localObject1).state = 1;
            continue;
          }
          if (!((l)localObject2).sEa) {
            break label854;
          }
        }
        finally
        {
          if (Thread.interrupted())
          {
            v.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptTask", "%s: decrypting and interrupted", new Object[] { ((a)Qv()).sDr });
            com.tencent.mm.pluginsdk.k.a.e.a.Mx(((a)Qv()).filePath);
            com.tencent.mm.pluginsdk.k.a.e.a.Mx(((a)Qv()).filePath + ".decrypted");
            com.tencent.mm.pluginsdk.k.a.e.a.Mx(((a)Qv()).filePath + ".decompressed");
          }
        }
        ((l)localObject2).sEA = ((l)localObject2).filePath;
        ((l)localObject2).sEB = (((l)localObject2).filePath + ".decompressed");
        ((l)localObject2).state = 2;
        continue;
        ((l)localObject2).sEA = ((l)localObject2).filePath;
        ((l)localObject2).state = 4;
        continue;
        com.tencent.mm.pluginsdk.k.a.e.a.Mx(((a)Qv()).filePath + ".decrypted");
        com.tencent.mm.pluginsdk.k.a.e.a.Mx(((a)Qv()).filePath + ".decompressed");
        continue;
        GMTrace.o(844900597760L, 6295);
        return;
        continue;
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/k/a/b/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */