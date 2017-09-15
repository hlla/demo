package com.tencent.mm.pluginsdk.k.a.b;

import android.os.Looper;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.a.bb;
import com.tencent.mm.e.a.bc;
import com.tencent.mm.e.a.lc;
import com.tencent.mm.pluginsdk.k.a.d.a.a;
import com.tencent.mm.pluginsdk.k.a.d.l;
import com.tencent.mm.pluginsdk.k.a.d.m;
import com.tencent.mm.pluginsdk.k.a.d.m.a;
import com.tencent.mm.pluginsdk.k.a.d.o;
import com.tencent.mm.pluginsdk.k.a.d.o.a;
import com.tencent.mm.pluginsdk.k.a.d.q;
import com.tencent.mm.protocal.c.avf;
import com.tencent.mm.protocal.c.avh;
import com.tencent.mm.protocal.c.avi;
import com.tencent.mm.protocal.c.bab;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.bp;
import com.tencent.mm.u.bp.a;
import com.tencent.mm.y.d.a;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public final class b
{
  private final com.tencent.mm.pluginsdk.k.a.d.d rXh;
  private final Set<b> sDD;
  private final k sDE;
  
  public b()
  {
    GMTrace.i(845303250944L, 6298);
    this.sDD = Collections.newSetFromMap(new android.support.v4.e.a(i.sEg.length));
    this.sDE = new k();
    this.rXh = new com.tencent.mm.pluginsdk.k.a.d.d()
    {
      public final void Jg(String paramAnonymousString)
      {
        GMTrace.i(14459007401984L, 107728);
        o localo = o.a.sFk;
        if (localo.rWt) {}
        for (boolean bool = localo.sFi.isDownloading(paramAnonymousString);; bool = false)
        {
          if (!bool) {
            i.Mp(paramAnonymousString);
          }
          GMTrace.o(14459007401984L, 107728);
          return;
        }
      }
      
      public final String Qo()
      {
        GMTrace.i(14459141619712L, 107729);
        GMTrace.o(14459141619712L, 107729);
        return "CheckResUpdate";
      }
      
      public final void a(String paramAnonymousString, l paramAnonymousl)
      {
        GMTrace.i(14458738966528L, 107726);
        v.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "networkEventListener.onComplete, urlkey = " + paramAnonymousString);
        paramAnonymousString = o.a.sFk.Mt(paramAnonymousString);
        if (paramAnonymousString == null)
        {
          GMTrace.o(14458738966528L, 107726);
          return;
        }
        j.u(paramAnonymousString.field_reportId, 10L);
        j.u(paramAnonymousString.field_reportId, 15L);
        if (((!paramAnonymousString.field_fileCompress) || (paramAnonymousString.field_fileEncrypt)) && (paramAnonymousString.field_fileUpdated)) {
          if (paramAnonymousString.field_maxRetryTimes <= paramAnonymousString.field_retryTimes) {
            break label260;
          }
        }
        label260:
        for (int i = j.a.sEu;; i = j.a.sEs)
        {
          j.a(paramAnonymousString.field_resType, paramAnonymousString.field_subType, paramAnonymousString.field_url, bf.getInt(paramAnonymousString.field_fileVersion, 0), i, true, bf.mz(paramAnonymousString.field_groupId2).equals("NewXml"), false, paramAnonymousString.field_sampleId);
          if ((paramAnonymousString.field_fileCompress) || (paramAnonymousString.field_fileEncrypt)) {
            break;
          }
          paramAnonymousl = new bb();
          paramAnonymousl.fEr.filePath = paramAnonymousString.field_filePath;
          paramAnonymousl.fEr.fEv = paramAnonymousString.field_fileUpdated;
          paramAnonymousl.fEr.fEu = bf.getInt(paramAnonymousString.field_fileVersion, 0);
          paramAnonymousl.fEr.fEs = paramAnonymousString.field_resType;
          paramAnonymousl.fEr.fEt = paramAnonymousString.field_subType;
          com.tencent.mm.sdk.b.a.uql.a(paramAnonymousl, Looper.getMainLooper());
          paramAnonymousString.field_fileUpdated = false;
          o.a.sFk.e(paramAnonymousString);
          GMTrace.o(14458738966528L, 107726);
          return;
        }
        v.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "networkEventListener, addDecryptRequest");
        b.this.a(paramAnonymousString);
        GMTrace.o(14458738966528L, 107726);
      }
      
      public final void b(String paramAnonymousString, l paramAnonymousl)
      {
        GMTrace.i(14458873184256L, 107727);
        i.Mp(paramAnonymousString);
        paramAnonymousString = o.a.sFk.Mt(paramAnonymousString);
        if (paramAnonymousString == null)
        {
          GMTrace.o(14458873184256L, 107727);
          return;
        }
        int j = 1;
        int i = j;
        if (paramAnonymousl != null)
        {
          i = j;
          if (paramAnonymousl.sFc != null)
          {
            if (!(paramAnonymousl.sFc instanceof com.tencent.mm.pluginsdk.k.a.c.a)) {
              break label150;
            }
            j.u(paramAnonymousString.field_reportId, 7L);
            i = 0;
          }
        }
        for (;;)
        {
          if (i != 0) {
            j.u(paramAnonymousString.field_reportId, 11L);
          }
          j.u(paramAnonymousString.field_reportId, 44L);
          j.a(paramAnonymousString.field_resType, paramAnonymousString.field_subType, paramAnonymousString.field_url, bf.getInt(paramAnonymousString.field_fileVersion, 0), j.a.sEt, false, "NewXml".equalsIgnoreCase(paramAnonymousString.field_groupId2), false, paramAnonymousString.field_sampleId);
          GMTrace.o(14458873184256L, 107727);
          return;
          label150:
          i = j;
          if ((paramAnonymousl.sFc instanceof com.tencent.mm.pluginsdk.k.a.c.c))
          {
            j.u(paramAnonymousString.field_reportId, 16L);
            i = 0;
          }
        }
      }
    };
    o.a.sFk.a("CheckResUpdate", this.rXh);
    GMTrace.o(845303250944L, 6298);
  }
  
  public static String dF(int paramInt1, int paramInt2)
  {
    GMTrace.i(845437468672L, 6299);
    q localq = o.a.sFk.Mt(i.dG(paramInt1, paramInt2));
    if (localq == null)
    {
      v.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, get null info, return", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      GMTrace.o(845437468672L, 6299);
      return null;
    }
    v.v("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, queried primeInfo { deleted = %b, filepath = %s, md5 = %s, compress = %b, encrypt = %b, originalMd5 = %s }", new Object[] { Boolean.valueOf(localq.field_deleted), localq.field_filePath, localq.field_md5, Boolean.valueOf(localq.field_fileCompress), Boolean.valueOf(localq.field_fileEncrypt), localq.field_originalMd5 });
    if ((!localq.field_fileCompress) && (!localq.field_fileEncrypt))
    {
      if ((!localq.field_deleted) && (!bf.mA(localq.field_filePath)) && (bf.mz(com.tencent.mm.a.g.aV(localq.field_filePath)).equals(localq.field_md5)))
      {
        v.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, not need decrypt and file valid, return path(%s)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), localq.field_filePath });
        str = localq.field_filePath;
        GMTrace.o(845437468672L, 6299);
        return str;
      }
      v.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, not need decrypt and file invalid, return null", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      GMTrace.o(845437468672L, 6299);
      return null;
    }
    String str = null;
    if (localq.field_fileCompress) {
      str = localq.field_filePath + ".decompressed";
    }
    while (bf.mA(str))
    {
      v.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, need decrypt or decompress, filePath invalid return null ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      GMTrace.o(845437468672L, 6299);
      return null;
      if (localq.field_fileEncrypt) {
        str = localq.field_filePath + ".decrypted";
      }
    }
    if ((!bf.mA(localq.field_originalMd5)) && (bf.mz(com.tencent.mm.a.g.aV(str)).equals(localq.field_originalMd5)))
    {
      v.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, need decrypt or decompress, file valid, ret = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str });
      GMTrace.o(845437468672L, 6299);
      return str;
    }
    v.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, need decrypt, return null ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    GMTrace.o(845437468672L, 6299);
    return null;
  }
  
  public final void R(int paramInt1, int paramInt2, int paramInt3)
  {
    GMTrace.i(14457933660160L, 107720);
    e(paramInt1, paramInt2, paramInt3, true);
    GMTrace.o(14457933660160L, 107720);
  }
  
  final void a(final int paramInt, final avf paramavf, final boolean paramBoolean)
  {
    GMTrace.i(845705904128L, 6301);
    final String str = i.dG(paramInt, paramavf.tUe);
    if (paramavf.tXc == null)
    {
      v.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "onReceiveDeleteOperation(), resource.Info = null");
      GMTrace.o(845705904128L, 6301);
      return;
    }
    v.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "receive delete-op, fromNewXml(%b), %d.%d, file version (%d)", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), Integer.valueOf(paramavf.tUe), Integer.valueOf(paramavf.tXc.tXm) });
    j.u(paramavf.tXe, 3L);
    final int i = paramavf.tXc.tXm;
    final int j = paramavf.tUe;
    final int k = paramavf.tXe;
    paramavf = paramavf.tXf;
    o.a.sFk.y(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(845169033216L, 6297);
        q localq = o.a.sFk.Mt(str);
        int i = paramInt;
        int j = j;
        int k = i;
        int m = k;
        String str1 = paramavf;
        boolean bool2 = paramBoolean;
        v.i("MicroMsg.ResDownloader.CheckResUpdate.DoDeleteLogic", "record " + localq);
        v.i("MicroMsg.ResDownloader.CheckResUpdate.DoDeleteLogic", "delete version %d", new Object[] { Integer.valueOf(k) });
        boolean bool1 = false;
        String str2;
        if (localq != null) {
          if (bf.getInt(localq.field_fileVersion, 0) <= k)
          {
            bool1 = true;
            str2 = i.dG(i, j);
            String str3 = i.Mo(str2);
            v.i("MicroMsg.ResDownloader.CheckResUpdate.DoDeleteLogic", "doDelete(%b), filePath(%s)", new Object[] { Boolean.valueOf(bool1), str3 });
            if (!bool1) {
              break label458;
            }
            o.a.sFk.Mv(str2);
            b.c.sDY.f(i, j, 2, bool2);
            if (!(com.tencent.mm.pluginsdk.k.a.e.a.Mx(str3) & true & com.tencent.mm.pluginsdk.k.a.e.a.Mx(str3 + ".decompressed") & com.tencent.mm.pluginsdk.k.a.e.a.Mx(str3 + ".decrypted"))) {
              break label405;
            }
            if (localq != null)
            {
              j.u(localq.field_reportId, 21L);
              j.a(localq.field_resType, localq.field_subType, k, bool2, localq.field_sampleId);
            }
          }
        }
        for (;;)
        {
          if (localq != null) {
            break label435;
          }
          localq = new q();
          localq.field_urlKey = str2;
          localq.field_resType = i;
          localq.field_subType = j;
          localq.field_deleted = true;
          localq.field_fileVersion = String.valueOf(k);
          localq.field_reportId = m;
          localq.field_sampleId = str1;
          o.a.sFk.e(localq);
          GMTrace.o(845169033216L, 6297);
          return;
          j.u(localq.field_reportId, 47L);
          j.u(localq.field_reportId, 22L);
          break;
          j.u(m, 47L);
          j.u(m, 22L);
          bool1 = true;
          break;
          label405:
          if (localq != null)
          {
            j.u(localq.field_reportId, 22L);
            j.u(localq.field_reportId, 47L);
          }
        }
        label435:
        localq.field_deleted = true;
        localq.field_fileVersion = String.valueOf(k);
        o.a.sFk.e(localq);
        label458:
        GMTrace.o(845169033216L, 6297);
      }
    });
    GMTrace.o(845705904128L, 6301);
  }
  
  final void a(q paramq)
  {
    GMTrace.i(845571686400L, 6300);
    v.d("MicroMsg.ResDownloader.CheckResUpdateHelper", "addDecryptRequest, urlkey = " + paramq.field_urlKey);
    k localk = this.sDE;
    if (localk.Mr(paramq.field_urlKey))
    {
      v.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptExecutor", "URLKey(%s) is already decrypting, skip repeated task");
      GMTrace.o(845571686400L, 6300);
      return;
    }
    localk.a(new a(paramq.field_urlKey, paramq.field_resType, paramq.field_subType, bf.getInt(paramq.field_fileVersion, 0), paramq.field_fileUpdated, paramq.field_filePath, paramq.field_fileEncrypt, paramq.field_fileCompress, paramq.field_encryptKey, paramq.field_keyVersion, paramq.field_eccSignature, paramq.field_originalMd5, bf.mz(paramq.field_groupId2).equals("NewXml"), paramq.field_reportId, paramq.field_sampleId, paramq.field_url, paramq.field_maxRetryTimes, paramq.field_retryTimes));
    GMTrace.o(845571686400L, 6300);
  }
  
  final void b(final int paramInt1, final int paramInt2, final String paramString, final int paramInt3)
  {
    GMTrace.i(846108557312L, 6304);
    o.a.sFk.y(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(853893185536L, 6362);
        b localb = b.this;
        int i = paramInt1;
        int j = paramInt2;
        String str = paramString;
        int k = paramInt3;
        Object localObject = i.dG(i, j);
        localObject = o.a.sFk.Mt((String)localObject);
        if (localObject == null)
        {
          GMTrace.o(853893185536L, 6362);
          return;
        }
        boolean bool = ((q)localObject).field_fileUpdated;
        ((q)localObject).field_fileUpdated = false;
        o.a.sFk.e((q)localObject);
        if (k == bf.getInt(((q)localObject).field_fileVersion, 0))
        {
          if (o.a.sFk.handler == null)
          {
            v.f("MicroMsg.ResDownloader.CheckResUpdateHelper", "sendEventFileCached: get null eventThread ");
            GMTrace.o(853893185536L, 6362);
            return;
          }
          o.a.sFk.handler.post(new b.8(localb, i, j, str, k, bool));
        }
        GMTrace.o(853893185536L, 6362);
      }
    });
    GMTrace.o(846108557312L, 6304);
  }
  
  final void b(int paramInt, final avf paramavf, boolean paramBoolean)
  {
    GMTrace.i(845840121856L, 6302);
    final String str = i.dG(paramInt, paramavf.tUe);
    if (paramavf.tXc == null)
    {
      v.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "onReceiveCacheOperation(), resource.Info = null, return");
      GMTrace.o(845840121856L, 6302);
      return;
    }
    int i = paramavf.tUe;
    int j = paramavf.tXc.tXm;
    if (paramavf.tXc.tXo == null) {}
    for (Object localObject = "null";; localObject = String.valueOf(paramavf.tXc.tXo.size()))
    {
      v.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "receive cache-op, urlKey = %d.%d,  fromNewXml = %b, file version = %d, eccSignatureList.size = %s, reportId = %s, sampleId = %s, url = %s, data = %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Boolean.valueOf(paramBoolean), Integer.valueOf(j), localObject, Integer.valueOf(paramavf.tXe), paramavf.tXf, paramavf.tXc.mrm, paramavf.tXc.tsy });
      if (paramavf.tXc.tXo == null) {
        break;
      }
      localObject = paramavf.tXc.tXo.iterator();
      while (((Iterator)localObject).hasNext())
      {
        bab localbab = (bab)((Iterator)localObject).next();
        v.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "cache-op, sigInfo: version(%d), signature(%s) ", new Object[] { Integer.valueOf(localbab.jMp), localbab.tZH.bGP() });
      }
    }
    j.eh(paramavf.tXe);
    if (!paramBoolean) {
      j.u(paramavf.tXe, 1L);
    }
    if ((paramavf.tla != 0) && (paramavf.tla <= bf.Nz()))
    {
      v.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "recourse(%s) is expired before do download, expireTime = %d, fileVersion = %d", new Object[] { str, Integer.valueOf(paramavf.tla), Integer.valueOf(paramavf.tXc.tXm) });
      j.u(paramavf.tXe, 14L);
      j.u(paramavf.tXe, 44L);
      j.a(paramInt, paramavf.tUe, paramavf.tXc.mrm, paramavf.tXc.tXm, j.a.sEw, false, paramBoolean, false, paramavf.tXf);
      GMTrace.o(845840121856L, 6302);
      return;
    }
    if ((bf.mA(paramavf.tXc.mrm)) && (paramavf.tXc.tsy == null))
    {
      v.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "cache-op, invalid cache operation, url and data is null or nil, skip");
      GMTrace.o(845840121856L, 6302);
      return;
    }
    localObject = new g.a(paramavf.tXc.mrm);
    ((a.a)localObject).sDr = str;
    ((g.a)localObject).fEs = paramInt;
    ((g.a)localObject).fEt = paramavf.tUe;
    ((a.a)localObject).hUP = paramavf.tla;
    ((g.a)localObject).fEu = paramavf.tXc.tXm;
    ((a.a)localObject).fFN = paramavf.tXc.tsQ;
    ((g.a)localObject).sEa = i.a.wY(paramavf.tXc.tXn);
    ((g.a)localObject).sEb = i.a.wX(paramavf.tXc.tXn);
    ((g.a)localObject).sDz = paramavf.tXe;
    ((g.a)localObject).sDA = paramavf.tXf;
    if (paramavf.tXg > 0) {}
    for (paramInt = paramavf.tXg;; paramInt = 3)
    {
      ((a.a)localObject).sDB = paramInt;
      ((g.a)localObject).sEc = paramavf.sEc;
      ((a.a)localObject).networkType = paramavf.tXh;
      ((g.a)localObject).fEy = paramBoolean;
      if (!bf.bV(paramavf.tXc.tXo)) {
        ((g.a)localObject).sDw = ((bab)paramavf.tXc.tXo.get(0)).tZH.sWU;
      }
      if ((paramavf.tXd != null) && (!bf.mA(paramavf.tXd.tXl)))
      {
        ((g.a)localObject).sDu = paramavf.tXd.tXl;
        ((g.a)localObject).sDv = paramavf.tXd.tXk;
      }
      if ((paramavf.tXc.tsy != null) && (paramavf.tXc.tsy.sWU.length > 0)) {
        ((g.a)localObject).sDZ = paramavf.tXc.tsy.toByteArray();
      }
      ((g.a)localObject).sDx = paramavf.tXc.tXp;
      ((g.a)localObject).fileSize = paramavf.tXc.trj;
      ((a.a)localObject).priority = paramavf.tII;
      paramavf = new g(((g.a)localObject).url, ((g.a)localObject).sDr, ((g.a)localObject).fEu, ((g.a)localObject).networkType, ((g.a)localObject).sDB, ((g.a)localObject).hUP, ((g.a)localObject).fFN, ((g.a)localObject).fEs, ((g.a)localObject).fEt, ((g.a)localObject).sDz, ((g.a)localObject).sDA, ((g.a)localObject).sDw, ((g.a)localObject).sDx, ((g.a)localObject).sEa, ((g.a)localObject).sEb, ((g.a)localObject).sDu, ((g.a)localObject).sDv, ((g.a)localObject).sEc, ((g.a)localObject).sDZ, ((g.a)localObject).fileSize, ((g.a)localObject).fEy, ((g.a)localObject).fEv, ((g.a)localObject).priority);
      v.d("MicroMsg.ResDownloader.CheckResUpdateHelper", "request (%s)", new Object[] { paramavf.toString() });
      o.a.sFk.y(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(860738289664L, 6413);
          f.a.a(o.a.sFk.Mt(str), paramavf);
          GMTrace.o(860738289664L, 6413);
        }
      });
      GMTrace.o(845840121856L, 6302);
      return;
    }
  }
  
  final Set<b> bDi()
  {
    GMTrace.i(15304444870656L, 114027);
    synchronized (this.sDD)
    {
      Set localSet2 = Collections.newSetFromMap(new android.support.v4.e.a(this.sDD.size()));
      Iterator localIterator = this.sDD.iterator();
      if (localIterator.hasNext()) {
        localSet2.add((b)localIterator.next());
      }
    }
    GMTrace.o(15304444870656L, 114027);
    return localSet;
  }
  
  final void c(final int paramInt, final avf paramavf, boolean paramBoolean)
  {
    GMTrace.i(845974339584L, 6303);
    final String str1 = i.dG(paramInt, paramavf.tUe);
    if (paramavf.tXd == null)
    {
      v.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "onReceiveDecryptOperation(), resource.Key = null");
      GMTrace.o(845974339584L, 6303);
      return;
    }
    if (bf.mA(paramavf.tXd.tXl))
    {
      v.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "encryptKey null, skip");
      GMTrace.o(845974339584L, 6303);
      return;
    }
    v.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "receive decrypt-op, fromNewXml(%b), %d.%d, key version (%d)", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), Integer.valueOf(paramavf.tUe), Integer.valueOf(paramavf.tXd.tXk) });
    v.d("MicroMsg.ResDownloader.CheckResUpdateHelper", "key (%s)", new Object[] { paramavf.tXd.tXl });
    j.u(paramavf.tXe, 4L);
    final String str2 = paramavf.tXc.tXp;
    final String str3 = paramavf.tXd.tXl;
    paramInt = paramavf.tXd.tXk;
    final int i = paramavf.tXe;
    paramavf = paramavf.tXf;
    o.a.sFk.y(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(846645428224L, 6308);
        q localq = o.a.sFk.Mt(str1);
        String str1 = str2;
        String str2 = str3;
        int i = paramInt;
        int j = i;
        String str3 = paramavf;
        if (localq == null)
        {
          localq = new q();
          localq.field_keyVersion = i;
          localq.field_encryptKey = str2;
          localq.field_reportId = j;
          localq.field_sampleId = str3;
          localq.field_originalMd5 = str1;
          o.a.sFk.e(localq);
          j.u(j, 51L);
          j.u(j, 45L);
          GMTrace.o(846645428224L, 6308);
          return;
        }
        if (localq.field_keyVersion < i)
        {
          localq.field_keyVersion = i;
          localq.field_encryptKey = str2;
          localq.field_reportId = j;
          localq.field_sampleId = str3;
          if (bf.mA(localq.field_originalMd5)) {
            localq.field_originalMd5 = str1;
          }
          o.a.sFk.e(localq);
          f.b.a(localq, true);
        }
        GMTrace.o(846645428224L, 6308);
      }
    });
    GMTrace.o(845974339584L, 6303);
  }
  
  public final void e(final int paramInt1, final int paramInt2, final int paramInt3, final boolean paramBoolean)
  {
    GMTrace.i(16133507776512L, 120204);
    o.a.sFk.y(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(14458336313344L, 107723);
        q localq = o.a.sFk.Mt(i.dG(paramInt1, paramInt2));
        if ((localq != null) && (String.valueOf(paramInt3).equals(localq.field_fileVersion))) {
          if (paramBoolean) {
            break label77;
          }
        }
        label77:
        for (boolean bool = true;; bool = false)
        {
          localq.field_needRetry = bool;
          o.a.sFk.e(localq);
          GMTrace.o(14458336313344L, 107723);
          return;
        }
      }
    });
    GMTrace.o(16133507776512L, 120204);
  }
  
  final void f(final int paramInt1, final int paramInt2, final int paramInt3, final boolean paramBoolean)
  {
    GMTrace.i(846242775040L, 6305);
    if (o.a.sFk.handler == null)
    {
      v.f("MicroMsg.ResDownloader.CheckResUpdateHelper", "sendEventPreOperation: get null eventThread ");
      GMTrace.o(846242775040L, 6305);
      return;
    }
    o.a.sFk.handler.post(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(14459410055168L, 107731);
        bc localbc = new bc();
        localbc.fEw.fEx = paramInt3;
        localbc.fEw.fEs = paramInt1;
        localbc.fEw.fEt = paramInt2;
        localbc.fEw.fEy = paramBoolean;
        com.tencent.mm.sdk.b.a.uql.m(localbc);
        GMTrace.o(14459410055168L, 107731);
      }
    });
    GMTrace.o(846242775040L, 6305);
  }
  
  public static final class a
    implements com.tencent.mm.pluginsdk.k.a.d.g
  {
    private final bp.a rWG;
    private final com.tencent.mm.sdk.b.c sDV;
    private final h sDW;
    
    public a()
    {
      GMTrace.i(857919717376L, 6392);
      this.sDV = new com.tencent.mm.sdk.b.c() {};
      this.rWG = new bp.a()
      {
        public final void a(d.a paramAnonymousa)
        {
          GMTrace.i(851074613248L, 6341);
          paramAnonymousa = com.tencent.mm.platformtools.n.a(paramAnonymousa.hsc.tdz);
          if (bf.mA(paramAnonymousa))
          {
            v.w("MicroMsg.ResDownloader.CheckResUpdateHelper", "msg content is null");
            GMTrace.o(851074613248L, 6341);
            return;
          }
          v.d("MicroMsg.CheckResUpdateNewXmlParser", "receive msg: \n" + paramAnonymousa);
          Map localMap;
          if (!bf.mA(paramAnonymousa))
          {
            localMap = bg.q(paramAnonymousa, "sysmsg");
            j.u(0L, 0L);
            if (localMap != null) {
              break label186;
            }
            paramAnonymousa = "null";
            v.i("MicroMsg.CheckResUpdateNewXmlParser", "parsed values.size = %s", new Object[] { paramAnonymousa });
            if (localMap != null) {
              break label199;
            }
            j.u(0L, 30L);
          }
          for (;;)
          {
            if ((localMap != null) && (localMap.size() > 0) && (bf.mz((String)localMap.get(".sysmsg.$type")).equalsIgnoreCase("resourcemgr")))
            {
              e.f(".sysmsg", "delete", localMap);
              e.f(".sysmsg", "cache", localMap);
              e.f(".sysmsg", "decrypt", localMap);
            }
            GMTrace.o(851074613248L, 6341);
            return;
            label186:
            paramAnonymousa = String.valueOf(localMap.size());
            break;
            label199:
            j.u(0L, 31L);
          }
        }
      };
      this.sDW = new h();
      GMTrace.o(857919717376L, 6392);
    }
    
    public final String Qo()
    {
      GMTrace.i(858322370560L, 6395);
      GMTrace.o(858322370560L, 6395);
      return "CheckResUpdate";
    }
    
    public final void bwG()
    {
      GMTrace.i(858053935104L, 6393);
      com.tencent.mm.sdk.b.a.uql.b(this.sDV);
      ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.messenger.foundation.a.n.class)).getSysCmdMsgExtension().a("resourcemgr", this.rWG, true);
      com.tencent.mm.kernel.h.vL().e(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(18810748796928L, 140151);
          p.acB();
          GMTrace.o(18810748796928L, 140151);
        }
      }, 10000L);
      GMTrace.o(858053935104L, 6393);
    }
    
    public final com.tencent.mm.pluginsdk.k.a.d.h bwH()
    {
      GMTrace.i(858590806016L, 6397);
      h localh = this.sDW;
      GMTrace.o(858590806016L, 6397);
      return localh;
    }
    
    public final m.a c(com.tencent.mm.pluginsdk.k.a.d.k paramk)
    {
      GMTrace.i(858456588288L, 6396);
      if (!(paramk instanceof c))
      {
        v.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "get mismatch NetworkRequest type, return null");
        GMTrace.o(858456588288L, 6396);
        return null;
      }
      v.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "return CheckResUpdateNetworkRequestHandler");
      paramk = new d((c)paramk);
      GMTrace.o(858456588288L, 6396);
      return paramk;
    }
    
    public final void onAccountRelease()
    {
      GMTrace.i(858188152832L, 6394);
      com.tencent.mm.sdk.b.a.uql.c(this.sDV);
      ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.messenger.foundation.a.n.class)).getSysCmdMsgExtension().b("resourcemgr", this.rWG, true);
      GMTrace.o(858188152832L, 6394);
    }
  }
  
  public static abstract interface b
  {
    public abstract boolean bDj();
  }
  
  private static final class c
  {
    public static final b sDY;
    
    static
    {
      GMTrace.i(854161620992L, 6364);
      sDY = new b();
      GMTrace.o(854161620992L, 6364);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/k/a/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */