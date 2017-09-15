package com.tencent.mm.ui.chatting.gallery;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.util.SparseArray;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.l;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.e.a.kk;
import com.tencent.mm.e.a.kk.a;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelvideo.n;
import com.tencent.mm.modelvideo.q;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s.a;
import com.tencent.mm.modelvideo.s.a.a;
import com.tencent.mm.modelvideo.x.a;
import com.tencent.mm.network.aa;
import com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.f.e;
import com.tencent.mm.protocal.c.akp;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ad.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.ay.b;
import com.tencent.mm.u.d.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.chatting.ee;
import com.tencent.mm.ui.chatting.ee.a;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public final class i
  extends a
  implements s.a, d.a
{
  public static boolean vDR;
  public String filename;
  public com.tencent.mm.u.d iWx;
  private ai kli;
  int lIE;
  public long lastCheckTime;
  private com.tencent.mm.plugin.s.b nxW;
  private f.e qtP;
  public boolean qub;
  long quf;
  long qug;
  public ai quh;
  private long qul;
  int qum;
  private com.tencent.mm.plugin.sight.decode.ui.b sGl;
  public HashMap<String, a> vPL;
  private com.tencent.mm.sdk.b.c vQF;
  final SparseArray<r> vQG;
  public l vQH;
  public boolean vQI;
  public boolean vQJ;
  public boolean vQK;
  public int vQL;
  public long vQM;
  private int vQN;
  private int vQO;
  private boolean vQP;
  ad vQQ;
  private int vQR;
  public com.tencent.mm.sdk.b.c<kk> vQS;
  public boolean vQT;
  private int vQU;
  private int[] vQV;
  
  static
  {
    GMTrace.i(2480343613440L, 18480);
    vDR = false;
    GMTrace.o(2480343613440L, 18480);
  }
  
  public i(b paramb)
  {
    super(paramb);
    GMTrace.i(2473364291584L, 18428);
    this.vQG = new SparseArray();
    this.vQI = false;
    this.vQJ = false;
    this.vQK = false;
    this.vQL = 0;
    this.vQM = 0L;
    this.lastCheckTime = 0L;
    this.vQN = 0;
    this.vQO = 0;
    this.quf = 0L;
    this.qug = 0L;
    this.lIE = 0;
    this.vQP = false;
    this.vQQ = new ad(Looper.getMainLooper(), new ad.a()
    {
      public final boolean handleMessage(Message paramAnonymousMessage)
      {
        GMTrace.i(2437259722752L, 18159);
        if (paramAnonymousMessage.what == 1)
        {
          paramAnonymousMessage = i.this.vNV.bWB();
          if ((paramAnonymousMessage != null) && (!bf.mA(i.this.filename)))
          {
            v.i("MicroMsg.Imagegallery.handler.video", "%d ui on pause, pause video now. %s", new Object[] { Integer.valueOf(hashCode()), i.this.filename });
            if (!i.this.vQJ) {
              com.tencent.mm.modelvideo.t.d(i.this.filename, paramAnonymousMessage.bXn().vRm.getCurrentPosition(), i.this.qub);
            }
            i.this.a(paramAnonymousMessage);
            i.this.iWx.aS(false);
            if (i.this.qub)
            {
              com.tencent.mm.sdk.b.a.uql.c(i.this.vQS);
              i.this.vQH.bXp();
              i.this.qub = false;
            }
          }
          i.this.vQI = false;
        }
        GMTrace.o(2437259722752L, 18159);
        return false;
      }
    });
    this.vQR = 0;
    this.quh = new ai(new ai.a()
    {
      public final boolean oQ()
      {
        GMTrace.i(2439809859584L, 18178);
        if (!i.this.vQH.isStreaming())
        {
          GMTrace.o(2439809859584L, 18178);
          return false;
        }
        j localj = i.this.vNV.bWB();
        if (localj == null)
        {
          GMTrace.o(2439809859584L, 18178);
          return false;
        }
        if (localj.vRj == null)
        {
          GMTrace.o(2439809859584L, 18178);
          return false;
        }
        if (localj.bXn().vRj.getVisibility() != 0)
        {
          GMTrace.o(2439809859584L, 18178);
          return false;
        }
        boolean bool = true;
        if (localj.bXn().vRm.isPlaying()) {
          bool = i.this.b(localj);
        }
        if (bool)
        {
          int i = localj.bXn().vRm.getCurrentPosition() / 1000;
          bool = i.this.vQH.gK(i);
          GMTrace.o(2439809859584L, 18178);
          return bool;
        }
        GMTrace.o(2439809859584L, 18178);
        return false;
      }
    }, true);
    this.kli = new ai(new ai.a()
    {
      public final boolean oQ()
      {
        GMTrace.i(14662078824448L, 109241);
        j localj = i.this.vNV.bWB();
        if (localj == null)
        {
          GMTrace.o(14662078824448L, 109241);
          return false;
        }
        if (localj.vRj == null)
        {
          GMTrace.o(14662078824448L, 109241);
          return false;
        }
        if (localj.bXn().vRj.getVisibility() != 0)
        {
          GMTrace.o(14662078824448L, 109241);
          return false;
        }
        int i = i.this.vNV.vNW.bWV();
        if ((r)i.this.vQG.get(i) == null)
        {
          i.this.BC(i);
          GMTrace.o(14662078824448L, 109241);
          return false;
        }
        if (!localj.bXn().vRm.isPlaying())
        {
          v.i("MicroMsg.Imagegallery.handler.video", "it is not playing, stop offline timer");
          GMTrace.o(14662078824448L, 109241);
          return false;
        }
        i.this.vQL = localj.bXn().vRm.getCurrentPosition();
        i.this.BD(i.this.vQL / 1000);
        GMTrace.o(14662078824448L, 109241);
        return true;
      }
    }, true);
    this.sGl = new com.tencent.mm.plugin.sight.decode.ui.b()
    {
      public final void Ue()
      {
        GMTrace.i(14660065558528L, 109226);
        if (i.this.vNV.bWB() != null) {
          i.this.a(i.this.vNV.bWB());
        }
        i.this.vNV.vNW.vQt.KI();
        GMTrace.o(14660065558528L, 109226);
      }
      
      public final void hP(int paramAnonymousInt)
      {
        GMTrace.i(14660199776256L, 109227);
        localObject = null;
        try
        {
          String str = i.this.vNV.bWB().bXn().vRm.Lt();
          localObject = str;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            v.printErrStackTrace("MicroMsg.Imagegallery.handler.video", localException, "", new Object[0]);
            v.e("MicroMsg.Imagegallery.handler.video", "on seek get video path error: " + localException.toString());
            continue;
            boolean bool = i.this.vQH.am(paramAnonymousInt, true);
            continue;
            localObject = i.this.vNV.bWA();
            if ((localObject != null) && (((au)localObject).bMb())) {
              com.tencent.mm.modelvideo.t.d(((ce)localObject).field_imgPath, paramAnonymousInt * 1000, i.this.qub);
            }
            i.this.vNV.Bm(i.this.vNV.vNW.bWV());
          }
        }
        v.i("MicroMsg.Imagegallery.handler.video", "on seek to time[%d] isOnlinePlay[%b] videoPath[%s]", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(i.this.qub), localObject });
        if (!bf.mA((String)localObject)) {
          if (!i.this.qub)
          {
            i.this.K(paramAnonymousInt, true);
            bool = true;
            if (bool) {
              i.this.bs(false);
            }
            i.this.vNV.vNW.bWS();
            GMTrace.o(14660199776256L, 109227);
            return;
          }
        }
      }
    };
    this.vQS = new com.tencent.mm.sdk.b.c()
    {
      private boolean a(kk paramAnonymouskk)
      {
        GMTrace.i(14654562631680L, 109185);
        if (!i.this.vQH.GM(paramAnonymouskk.fQF.mediaId))
        {
          GMTrace.o(14654562631680L, 109185);
          return false;
        }
        Object localObject1;
        Object localObject2;
        int i;
        if ((paramAnonymouskk.fQF.fEO != 0) && (paramAnonymouskk.fQF.fEO != 44530))
        {
          v.w("MicroMsg.Imagegallery.handler.video", "stream download online video error. retCode: " + paramAnonymouskk.fQF.fEO);
          localObject1 = i.this;
          localObject2 = paramAnonymouskk.fQF.mediaId;
          i = paramAnonymouskk.fQF.fEO;
          v.i("MicroMsg.Imagegallery.handler.video", "download online video error. mediaId: " + (String)localObject2);
          ((i)localObject1).bji();
          paramAnonymouskk = ((i)localObject1).vQH;
          v.i("MicroMsg.OnlineVideoUIHelper", "deal stream error.");
          if (paramAnonymouskk.GM((String)localObject2))
          {
            paramAnonymouskk.hXL = 2;
            com.tencent.mm.modelvideo.o.KX().b(paramAnonymouskk.mediaId, paramAnonymouskk.bXs());
          }
          com.tencent.mm.plugin.report.service.g.oSF.a(354L, 9L, 1L, false);
          if (i == 55524)
          {
            v.w("MicroMsg.Imagegallery.handler.video", "download online video time out, quit imageGalleryUI.");
            ae.v(new i.17((i)localObject1));
          }
          for (;;)
          {
            GMTrace.o(14654562631680L, 109185);
            return false;
            ae.v(new i.2((i)localObject1, i));
          }
        }
        switch (paramAnonymouskk.fQF.fJB)
        {
        default: 
          v.w("MicroMsg.Imagegallery.handler.video", "unknown event opcode " + paramAnonymouskk.fQF.fJB);
        }
        for (;;)
        {
          GMTrace.o(14654562631680L, 109185);
          return false;
          localObject1 = i.this.vQH;
          long l2 = paramAnonymouskk.fQF.offset;
          long l1 = paramAnonymouskk.fQF.fQG;
          boolean bool = paramAnonymouskk.fQF.fQH;
          v.i("MicroMsg.OnlineVideoUIHelper", "deal moov ready moovPos[%d] needSeekTime[%d] timeDuration[%d] startDownload[%d %d]", new Object[] { Long.valueOf(l2), Integer.valueOf(((l)localObject1).hXP), Integer.valueOf(((l)localObject1).hXO), Long.valueOf(l1), Long.valueOf(((l)localObject1).hyY) });
          if (((l)localObject1).hXO != 0) {
            v.w("MicroMsg.OnlineVideoUIHelper", "moov had callback, do nothing.");
          }
          for (;;)
          {
            i.this.qub = true;
            break;
            if (l1 > ((l)localObject1).hyY) {}
            for (;;)
            {
              ((l)localObject1).hyY = l1;
              com.tencent.mm.plugin.report.service.g.oSF.a(354L, 5L, 1L, false);
              ((l)localObject1).qux = bf.NA();
              com.tencent.mm.modelvideo.o.KW();
              paramAnonymouskk = com.tencent.mm.modelvideo.s.lw(((l)localObject1).filename);
              try
              {
                if (((l)localObject1).hXN != null) {
                  break label573;
                }
                v.w("MicroMsg.OnlineVideoUIHelper", "parser is null, thread is error.");
              }
              catch (Exception paramAnonymouskk)
              {
                v.printErrStackTrace("MicroMsg.OnlineVideoUIHelper", paramAnonymouskk, "", new Object[0]);
                v.e("MicroMsg.OnlineVideoUIHelper", "deal moov ready error: " + paramAnonymouskk.toString());
              }
              break;
              l1 = ((l)localObject1).hyY;
            }
            label573:
            if (((l)localObject1).hXN.m(paramAnonymouskk, l2))
            {
              ((l)localObject1).hXO = ((l)localObject1).hXN.ilJ;
              v.i("MicroMsg.OnlineVideoUIHelper", "mp4 parse moov success. duration %d filename %s isFastStart %b", new Object[] { Integer.valueOf(((l)localObject1).hXO), ((l)localObject1).filename, Boolean.valueOf(bool) });
              if (!bool) {
                ae.v(new l.1((l)localObject1));
              }
              if (((l)localObject1).hXP == -1) {}
              for (((l)localObject1).hXM = 1;; ((l)localObject1).hXM = 2)
              {
                com.tencent.mm.plugin.report.service.g.oSF.a(354L, 7L, 1L, false);
                break;
              }
            }
            v.w("MicroMsg.OnlineVideoUIHelper", "mp4 parse moov error.");
            com.tencent.mm.modelvideo.o.KX();
            com.tencent.mm.modelcdntran.f.e(((l)localObject1).mediaId, 0, -1);
            com.tencent.mm.modelvideo.t.I(((l)localObject1).filename, 15);
            com.tencent.mm.plugin.report.service.g.oSF.a(354L, 8L, 1L, false);
            v.w("MicroMsg.OnlineVideoUIHelper", "%d rpt parse moov fail %s ", new Object[] { Integer.valueOf(localObject1.hashCode()), ((l)localObject1).filename });
            com.tencent.mm.plugin.report.service.g.oSF.i(13836, new Object[] { Integer.valueOf(302), Long.valueOf(bf.Nz()), "" });
          }
          localObject1 = i.this.vQH;
          localObject2 = paramAnonymouskk.fQF.mediaId;
          i = paramAnonymouskk.fQF.offset;
          int j = paramAnonymouskk.fQF.length;
          ((l)localObject1).hXV = false;
          if ((i < 0) || (j < 0)) {
            v.w("MicroMsg.OnlineVideoUIHelper", "deal data available error offset[%d], length[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          }
          while (!((l)localObject1).GM((String)localObject2))
          {
            if (paramAnonymouskk.fQF.length <= 0) {
              break;
            }
            i.this.bs(true);
            break;
          }
          localObject2 = ((l)localObject1).mediaId + i + "_" + j;
          localObject2 = (Integer)((l)localObject1).qut.get(localObject2);
          if ((localObject2 != null) && (((Integer)localObject2).intValue() > 0)) {
            ((l)localObject1).hXS = ((Integer)localObject2).intValue();
          }
          for (;;)
          {
            v.i("MicroMsg.OnlineVideoUIHelper", "deal data available. offset[%d] length[%d] cachePlayTime[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(((l)localObject1).hXS) });
            break;
            try
            {
              ((l)localObject1).hXS = ((l)localObject1).hXN.bi(i, j);
            }
            catch (Exception localException)
            {
              v.printErrStackTrace("MicroMsg.OnlineVideoUIHelper", localException, "", new Object[0]);
              v.e("MicroMsg.OnlineVideoUIHelper", "deal data available file pos to video time error: " + localException.toString());
            }
          }
          i.this.bs(true);
          continue;
          paramAnonymouskk = i.this.vQH;
          v.i("MicroMsg.OnlineVideoUIHelper", "deal stream finish. playStatus %d ", new Object[] { Integer.valueOf(paramAnonymouskk.hXM) });
          paramAnonymouskk.hXV = false;
          paramAnonymouskk.hXL = 3;
          if (paramAnonymouskk.hXM == 0)
          {
            v.w("MicroMsg.OnlineVideoUIHelper", "it had not moov callback and download finish start to play video.");
            paramAnonymouskk.bjp();
            com.tencent.mm.plugin.report.service.g.oSF.a(354L, 6L, 1L, false);
          }
          for (;;)
          {
            paramAnonymouskk.bXr();
            com.tencent.mm.plugin.report.service.g.oSF.a(354L, 26L, 1L, false);
            i.this.bs(true);
            break;
            if (paramAnonymouskk.hXM == 5)
            {
              v.w("MicroMsg.OnlineVideoUIHelper", "it had play error, it request all video data finish, start to play." + paramAnonymouskk.mediaId);
              paramAnonymouskk.bjp();
            }
          }
          localObject1 = i.this.vQH;
          String str = paramAnonymouskk.fQF.mediaId;
          i = paramAnonymouskk.fQF.offset;
          if (((l)localObject1).GM(str))
          {
            ((l)localObject1).quv = (i * 100 / ((l)localObject1).iyv);
            v.i("MicroMsg.OnlineVideoUIHelper", "deal progress callback. downloadedPercent : " + ((l)localObject1).quv);
          }
          if (((l)localObject1).quv >= 100)
          {
            ((l)localObject1).hXL = 3;
            continue;
            paramAnonymouskk = i.this.vQH;
            v.i("MicroMsg.OnlineVideoUIHelper", "deal had dup video.");
            paramAnonymouskk.bjp();
          }
        }
      }
    };
    this.vQT = false;
    this.vQU = 0;
    this.vQV = new int[] { 64536, 63536, 3400 };
    this.qtP = new f.e()
    {
      public final void aMf()
      {
        GMTrace.i(14661005082624L, 109233);
        v.i("MicroMsg.Imagegallery.handler.video", "%d on texture update.", new Object[] { Integer.valueOf(i.this.hashCode()) });
        try
        {
          i.this.vNV.bWB().a(true, 1.0F);
          GMTrace.o(14661005082624L, 109233);
          return;
        }
        catch (Exception localException)
        {
          v.e("MicroMsg.Imagegallery.handler.video", "texture view update. error " + localException.toString());
          GMTrace.o(14661005082624L, 109233);
        }
      }
    };
    this.nxW = new com.tencent.mm.plugin.s.b()
    {
      public final long aKf()
      {
        GMTrace.i(14655502155776L, 109192);
        v.i("MicroMsg.Imagegallery.handler.video", "%d video get online cache sec", new Object[] { Integer.valueOf(i.this.hashCode()) });
        ap.yY();
        com.tencent.mm.u.c.vr().a(w.a.uEo, Boolean.valueOf(true));
        try
        {
          if ((i.this.qub) && (i.this.vQH != null))
          {
            int i = i.this.vQH.hXS;
            long l = i;
            GMTrace.o(14655502155776L, 109192);
            return l;
          }
        }
        catch (Exception localException)
        {
          GMTrace.o(14655502155776L, 109192);
        }
        return 0L;
      }
    };
    this.vPL = new HashMap();
    this.vQH = new l(this);
    com.tencent.mm.sdk.b.a locala = com.tencent.mm.sdk.b.a.uql;
    paramb = new ee(ee.a.vMn, paramb.vNW);
    this.vQF = paramb;
    locala.b(paramb);
    com.tencent.mm.sdk.b.a.uql.b(this.vQS);
    this.iWx = new com.tencent.mm.u.d();
    GMTrace.o(2473364291584L, 18428);
  }
  
  private void a(final au paramau, final r paramr)
  {
    GMTrace.i(2474303815680L, 18435);
    if ((!aa.bn(this.vNV.vNW.uRf.uRz)) && (!vDR))
    {
      com.tencent.mm.ui.base.g.a(this.vNV.vNW.uRf.uRz, R.l.eZZ, R.l.dIG, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(2480880484352L, 18484);
          i.vDR = true;
          i.this.b(paramau, paramr);
          GMTrace.o(2480880484352L, 18484);
        }
      }, null);
      GMTrace.o(2474303815680L, 18435);
      return;
    }
    b(paramau, paramr);
    GMTrace.o(2474303815680L, 18435);
  }
  
  private boolean b(a parama)
  {
    GMTrace.i(2474706468864L, 18438);
    if (parama == null)
    {
      GMTrace.o(2474706468864L, 18438);
      return false;
    }
    com.tencent.mm.modelvideo.o.KW().a(this);
    if (this.vNV.vNW.bWV() == parama.pos)
    {
      parama = Bf(parama.pos);
      if (parama != null)
      {
        parama.bXn().vRu.setVisibility(8);
        parama.bXn().vRn.setVisibility(8);
        parama.bXn().vRl.setVisibility(8);
      }
      this.vQT = true;
      this.vNV.vNW.bWT();
      GMTrace.o(2474706468864L, 18438);
      return true;
    }
    this.vNV.Bo(parama.pos);
    GMTrace.o(2474706468864L, 18438);
    return false;
  }
  
  private void bXj()
  {
    GMTrace.i(2476182863872L, 18449);
    try
    {
      this.vNV.vNW.bWK().vQc.ptk = this.sGl;
      GMTrace.o(2476182863872L, 18449);
      return;
    }
    catch (Exception localException)
    {
      GMTrace.o(2476182863872L, 18449);
    }
  }
  
  private void bjf()
  {
    GMTrace.i(2475645992960L, 18445);
    v.i("MicroMsg.Imagegallery.handler.video", "clear timer");
    this.quh.KI();
    this.kli.KI();
    GMTrace.o(2475645992960L, 18445);
  }
  
  private void bjh()
  {
    GMTrace.i(2477122387968L, 18456);
    this.qul = bf.NA();
    v.d("MicroMsg.Imagegallery.handler.video", "notePlayVideo filename %s notePlayVideo %d ", new Object[] { this.filename, Long.valueOf(this.qul) });
    GMTrace.o(2477122387968L, 18456);
  }
  
  public static r bl(au paramau)
  {
    GMTrace.i(2473632727040L, 18430);
    if (!b.aS(paramau))
    {
      GMTrace.o(2473632727040L, 18430);
      return null;
    }
    paramau = com.tencent.mm.modelvideo.t.lI(paramau.field_imgPath);
    GMTrace.o(2473632727040L, 18430);
    return paramau;
  }
  
  private void cP(final String paramString, final int paramInt)
  {
    GMTrace.i(2474572251136L, 18437);
    ap.vL().D(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(2445312786432L, 18219);
        com.tencent.mm.modelvideo.t.J(paramString, paramInt);
        GMTrace.o(2445312786432L, 18219);
      }
    });
    GMTrace.o(2474572251136L, 18437);
  }
  
  public final void BC(int paramInt)
  {
    GMTrace.i(2475914428416L, 18447);
    this.vQG.remove(paramInt);
    GMTrace.o(2475914428416L, 18447);
  }
  
  protected final void BD(int paramInt)
  {
    GMTrace.i(2476853952512L, 18454);
    paramInt = Math.max(0, paramInt);
    this.vNV.vNW.bWK().vQc.seek(paramInt);
    GMTrace.o(2476853952512L, 18454);
  }
  
  protected final void K(int paramInt, boolean paramBoolean)
  {
    GMTrace.i(2476451299328L, 18451);
    j localj = this.vNV.bWB();
    if (localj == null)
    {
      GMTrace.o(2476451299328L, 18451);
      return;
    }
    bjh();
    localj.bXn().vRu.setVisibility(8);
    localj.bXn().vRm.c(paramInt * 1000, paramBoolean);
    this.vNV.vNW.lr(false);
    bs(false);
    GMTrace.o(2476451299328L, 18451);
  }
  
  protected final void KH()
  {
    GMTrace.i(2476585517056L, 18452);
    j localj = this.vNV.bWB();
    if (localj == null)
    {
      GMTrace.o(2476585517056L, 18452);
      return;
    }
    v.i("MicroMsg.Imagegallery.handler.video", "start to pause");
    this.vNV.vNW.lr(true);
    localj.bXn().vRu.setVisibility(0);
    localj.bXn().vRm.pause();
    bji();
    GMTrace.o(2476585517056L, 18452);
  }
  
  protected final void TJ(String paramString)
  {
    GMTrace.i(2476988170240L, 18455);
    if ((!this.vQT) && (!b((a)this.vPL.get(paramString)))) {
      v.w("MicroMsg.Imagegallery.handler.video", "show tool bar error.");
    }
    GMTrace.o(2476988170240L, 18455);
  }
  
  public final void a(s.a.a parama)
  {
    GMTrace.i(2476048646144L, 18448);
    Object localObject = parama.fyw;
    if ((bf.mA((String)localObject)) || (this.vPL == null))
    {
      GMTrace.o(2476048646144L, 18448);
      return;
    }
    parama = (a)this.vPL.get(localObject);
    if (parama == null)
    {
      GMTrace.o(2476048646144L, 18448);
      return;
    }
    au localau = parama.fCQ;
    if ((localau == null) || (localau.field_imgPath == null) || (!localau.field_imgPath.equals(localObject)))
    {
      GMTrace.o(2476048646144L, 18448);
      return;
    }
    localObject = bl(localau);
    if (localObject == null)
    {
      GMTrace.o(2476048646144L, 18448);
      return;
    }
    if ((localau.bMj()) || (((r)localObject).status == 198))
    {
      if (b(parama)) {
        Toast.makeText(this.vNV.vNW, R.l.faa, 0).show();
      }
      GMTrace.o(2476048646144L, 18448);
      return;
    }
    int i = com.tencent.mm.modelvideo.t.f((r)localObject);
    j localj = Bf(parama.pos);
    if ((this.vNV.vNW.bWV() == parama.pos) && (localj != null))
    {
      this.vNV.vNW.bWU();
      this.vQT = false;
      localj.bXn().vRn.setVisibility(0);
      localj.bXn().vRn.setProgress(i);
    }
    while (i < localj.bXn().vRn.wtn)
    {
      GMTrace.o(2476048646144L, 18448);
      return;
      if (localj == null)
      {
        GMTrace.o(2476048646144L, 18448);
        return;
      }
    }
    v.d("MicroMsg.Imagegallery.handler.video", "onNotifyChange, status:%d", new Object[] { Integer.valueOf(((r)localObject).status) });
    if (((((r)localObject).status == 199) || (((r)localObject).status == 199)) && (b(parama)))
    {
      this.vNV.vNW.eu(true);
      i = this.vNV.vNW.eS(localau.field_msgId);
    }
    switch (i)
    {
    default: 
      v.w("MicroMsg.Imagegallery.handler.video", "enterVideoOpCode[%d] is error", new Object[] { Integer.valueOf(i) });
      GMTrace.o(2476048646144L, 18448);
      return;
    case 0: 
    case 3: 
      a(localau, (r)localObject, this.vNV.vNW.bWV(), false);
      GMTrace.o(2476048646144L, 18448);
      return;
    case 1: 
      v.d("MicroMsg.Imagegallery.handler.video", "do restransmit video");
      com.tencent.mm.plugin.report.service.g.oSF.a(354L, 15L, 1L, false);
      this.vNV.aZ(localau);
      this.vNV.vNW.eT(-1L);
      if (this.qub)
      {
        i = this.vNV.bWB().vRm.getCurrentPosition();
        com.tencent.mm.modelvideo.t.d(this.filename, i, this.qub);
        this.vQP = true;
      }
      this.qub = false;
      GMTrace.o(2476048646144L, 18448);
      return;
    }
    com.tencent.mm.plugin.report.service.g.oSF.a(354L, 16L, 1L, false);
    b.a(this.vNV.vNW, localau, true);
    this.vNV.vNW.eT(-1L);
    if (this.qub)
    {
      i = this.vNV.bWB().vRm.getCurrentPosition();
      com.tencent.mm.modelvideo.t.d(this.filename, i, this.qub);
      this.vQP = true;
    }
    this.qub = false;
    GMTrace.o(2476048646144L, 18448);
  }
  
  public final void a(au paramau, r paramr, int paramInt, boolean paramBoolean)
  {
    GMTrace.i(2474169597952L, 18434);
    if ((paramau == null) || (paramr == null))
    {
      GMTrace.o(2474169597952L, 18434);
      return;
    }
    if (paramau.bMj())
    {
      Toast.makeText(this.vNV.vNW, R.l.faa, 0).show();
      GMTrace.o(2474169597952L, 18434);
      return;
    }
    Object localObject3;
    Object localObject1;
    if (paramr.iac == -1)
    {
      localObject3 = paramr.Lh();
      localObject1 = localObject3;
      if (!com.tencent.mm.a.e.aO((String)localObject3))
      {
        com.tencent.mm.modelvideo.o.KW();
        localObject1 = com.tencent.mm.modelvideo.s.lw(paramau.field_imgPath);
        if ((localObject1 != null) && (com.tencent.mm.a.e.aO((String)localObject1))) {
          break label341;
        }
        Toast.makeText(this.vNV.vNW, R.l.faa, 0).show();
        GMTrace.o(2474169597952L, 18434);
      }
    }
    else
    {
      com.tencent.mm.modelvideo.o.KW();
      localObject3 = com.tencent.mm.modelvideo.s.lw(paramau.field_imgPath);
      localObject1 = localObject3;
      if (paramau.field_isSend == 1)
      {
        localObject1 = localObject3;
        if (paramr.iaf != null)
        {
          localObject1 = localObject3;
          if (!paramr.iaf.tMG) {}
        }
      }
    }
    for (;;)
    {
      String str;
      boolean bool;
      try
      {
        str = FileOp.kl((String)localObject3);
        localObject1 = str;
        if (!str.endsWith("/")) {
          localObject1 = str + "/";
        }
        str = com.tencent.mm.a.e.aR((String)localObject3);
        localObject1 = (String)localObject1 + str + "_hd.mp4";
        bool = FileOp.aO((String)localObject1);
        v.i("MicroMsg.Imagegallery.handler.video", "local capture video, hdFilePath: %s, exist: %s", new Object[] { localObject1, Boolean.valueOf(bool) });
        if (!bool) {
          break label1194;
        }
      }
      catch (Exception localException)
      {
        v.e("MicroMsg.Imagegallery.handler.video", "try to get hd filePath error: %s", new Object[] { localException.getMessage() });
        localObject2 = localObject3;
      }
      break;
      label341:
      localObject3 = Bf(paramInt);
      if (localObject3 == null)
      {
        GMTrace.o(2474169597952L, 18434);
        return;
      }
      if (com.tencent.mm.u.o.dH(paramr.Lf())) {}
      for (int i = com.tencent.mm.u.j.eC(paramr.Lf());; i = 0)
      {
        bool = q.lp((String)localObject2);
        int j = this.vNV.vNW.eS(paramau.field_msgId);
        v.i("MicroMsg.Imagegallery.handler.video", "play video pos[%d], isOnlinePlay[%b] opcode[%d] resetByCompletion[%b]", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), Integer.valueOf(j), Boolean.valueOf(this.vQP) });
        if (!bool)
        {
          if ((p.gRb.gPZ == 1) && (com.tencent.mm.pluginsdk.l.b.a.a.b(paramr.getFileName(), this.vNV.vNW.uRf.uRz, bool)))
          {
            GMTrace.o(2474169597952L, 18434);
            return;
          }
          ap.yY();
          if ((((Integer)com.tencent.mm.u.c.vr().get(w.a.uDm, Integer.valueOf(0))).intValue() == 1) && (((j)localObject3).vRo != null))
          {
            ((j)localObject3).vRo.setVisibility(0);
            ((j)localObject3).vRo.setText(com.tencent.mm.plugin.sight.base.d.AL((String)localObject2));
          }
          int k = paramr.hZV;
          int m = paramr.hrb;
          paramau = paramr.Lf();
          str = r.ls(paramr.Li());
          long l = paramr.hZS;
          ((j)localObject3).qhY = k;
          ((j)localObject3).vRz = m;
          ((j)localObject3).vRA = i;
          ((j)localObject3).fOl = paramau;
          ((j)localObject3).fOo = str;
          ((j)localObject3).hZS = l;
          this.qub = paramBoolean;
          this.vQI = true;
          this.filename = paramr.getFileName();
          if (j == 3)
          {
            ((j)localObject3).bXn().vRm.bQ(true);
            if ((((j)localObject3).bXn().vRm.Lt() == null) || (!((j)localObject3).bXn().vRm.Lt().equals(localObject2)) || (((j)localObject3).bXn().vRm.isPlaying()) || (this.vQP)) {
              break label901;
            }
            ((j)localObject3).a(true, 1.0F);
            ((j)localObject3).bXn().vRm.start();
            bjh();
            if (!paramBoolean) {
              TJ(this.filename);
            }
            BD(((j)localObject3).bXn().vRm.getCurrentPosition() / 1000);
            bs(false);
            this.vQG.put(paramInt, paramr);
            this.vNV.vNW.lr(false);
            this.vNV.vNW.uRf.uRz.getWindow().addFlags(128);
            if (com.tencent.mm.compatible.util.d.ep(18)) {
              TJ(this.filename);
            }
            this.iWx.a(this);
          }
        }
        for (;;)
        {
          ((j)localObject3).bXn().vRn.setVisibility(8);
          GMTrace.o(2474169597952L, 18434);
          return;
          ((j)localObject3).bXn().vRm.bQ(false);
          break;
          label901:
          this.vQK = false;
          this.vQP = false;
          ((j)localObject3).bXn().vRm.setVideoPath((String)localObject2);
          if ((((j)localObject3).bXn().vRm instanceof VideoPlayerTextureView))
          {
            ((VideoPlayerTextureView)((j)localObject3).bXn().vRm).nxW = this.nxW;
            paramau = (VideoPlayerTextureView)((j)localObject3).bXn().vRm;
            if (this.qub) {
              break label1021;
            }
          }
          for (bool = false;; bool = com.tencent.mm.u.c.vr().c(w.a.uEo, false))
          {
            paramau.fz(bool);
            ((VideoPlayerTextureView)((j)localObject3).bXn().vRm).fA(paramBoolean);
            ((j)localObject3).a(true, 0.0F);
            break;
            label1021:
            ap.yY();
          }
          com.tencent.mm.plugin.report.service.g.oSF.i(12084, new Object[] { Integer.valueOf(paramr.hrb), Integer.valueOf(paramr.hZV * 1000), Integer.valueOf(0), Integer.valueOf(3), paramr.Lf(), Integer.valueOf(i), r.ls(paramr.Li()), Long.valueOf(paramr.hZS) });
          if (!com.tencent.mm.pluginsdk.l.b.a.a.c((String)localObject2, this.vNV.vNW.uRf.uRz, bool)) {
            Toast.makeText(this.vNV.vNW.uRf.uRz, this.vNV.vNW.getString(R.l.fag), 0).show();
          }
        }
      }
      label1194:
      Object localObject2 = localObject3;
    }
  }
  
  public final void a(j paramj)
  {
    GMTrace.i(2474974904320L, 18440);
    if (paramj == null)
    {
      GMTrace.o(2474974904320L, 18440);
      return;
    }
    bjf();
    v.d("MicroMsg.Imagegallery.handler.video", "pause video.");
    if (paramj.bXn().vRm.isPlaying())
    {
      paramj.bXn().vRm.pause();
      bji();
    }
    GMTrace.o(2474974904320L, 18440);
  }
  
  public final boolean a(j paramj, au paramau, int paramInt)
  {
    GMTrace.i(2473498509312L, 18429);
    super.a(paramj, paramau, paramInt);
    r localr = bl(paramau);
    if (paramau == null)
    {
      v.e("MicroMsg.Imagegallery.handler.video", "msg is null!!");
      GMTrace.o(2473498509312L, 18429);
      return false;
    }
    if (this.vPL != null) {
      this.vPL.put(paramau.field_imgPath, new a(paramau, paramInt));
    }
    while (localr == null)
    {
      GMTrace.o(2473498509312L, 18429);
      return false;
      v.e("MicroMsg.Imagegallery.handler.video", "mCacheMap is null!");
    }
    com.tencent.mm.modelvideo.o.KW();
    paramau = BackwardSupportUtil.b.c(com.tencent.mm.modelvideo.s.lx(paramau.field_imgPath), 1.0F);
    paramj.bXn().vRk.setImageBitmap(paramau);
    if (paramj.bXn().vRm.isPlaying()) {
      paramj.bXn().vRm.stop();
    }
    paramj.vRo.setVisibility(8);
    paramj.bXn().vRn.setVisibility(8);
    paramj.bXn().vRu.setVisibility(8);
    paramj.a(false, 0.0F);
    this.vQN = 0;
    this.quf = bf.NA();
    GMTrace.o(2473498509312L, 18429);
    return true;
  }
  
  protected final void as(final String paramString, final boolean paramBoolean)
  {
    GMTrace.i(2476317081600L, 18450);
    ae.v(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(2426253869056L, 18077);
        v.i("MicroMsg.Imagegallery.handler.video", "prepare video filename %s isOnlinePlay %b ", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
        if (i.this.vPL == null)
        {
          v.w("MicroMsg.Imagegallery.handler.video", "prepare video but cache map is null.");
          GMTrace.o(2426253869056L, 18077);
          return;
        }
        i.a locala = (i.a)i.this.vPL.get(paramString);
        if ((locala == null) || (locala.fCQ == null))
        {
          GMTrace.o(2426253869056L, 18077);
          return;
        }
        r localr = i.bl(locala.fCQ);
        if (i.this.vNV.vNW.bWV() == locala.pos)
        {
          i.this.a(locala.fCQ, localr, locala.pos, paramBoolean);
          i.this.TJ(paramString);
          GMTrace.o(2426253869056L, 18077);
          return;
        }
        v.w("MicroMsg.Imagegallery.handler.video", "playVideo, but currentItem is not correct.[%d, %d]", new Object[] { Integer.valueOf(i.this.vNV.vNW.bWV()), Integer.valueOf(locala.pos) });
        GMTrace.o(2426253869056L, 18077);
      }
    });
    GMTrace.o(2476317081600L, 18450);
  }
  
  public final void b(au paramau, r paramr)
  {
    GMTrace.i(2474438033408L, 18436);
    v.i("MicroMsg.Imagegallery.handler.video", "startDownloading [%d]", new Object[] { Integer.valueOf(hashCode()) });
    if ((paramau == null) || (paramr == null))
    {
      GMTrace.o(2474438033408L, 18436);
      return;
    }
    j localj = this.vNV.bWB();
    if (localj == null)
    {
      GMTrace.o(2474438033408L, 18436);
      return;
    }
    int i = this.vNV.vNW.eS(paramau.field_msgId);
    v.d("MicroMsg.Imagegallery.handler.video", "enterVideoOpCode : " + i);
    switch (i)
    {
    default: 
      v.w("MicroMsg.Imagegallery.handler.video", "enterVideoOpCode[%d] is error", new Object[] { Integer.valueOf(i) });
      GMTrace.o(2474438033408L, 18436);
      return;
    case 3: 
      v.i("MicroMsg.Imagegallery.handler.video", "%d mute play video [%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(i) });
    case 0: 
      l locall = this.vQH;
      String str1 = paramau.field_imgPath;
      com.tencent.mm.modelcontrol.d.Ev();
      if (!com.tencent.mm.modelcontrol.d.EA()) {
        i = 0;
      }
      while (i != 0)
      {
        v.i("MicroMsg.Imagegallery.handler.video", "start online play video.");
        this.qub = true;
        com.tencent.mm.modelvideo.o.KW().a(this);
        this.vNV.vNW.bWU();
        this.vQT = false;
        localj.bXn().vRl.setVisibility(8);
        localj.bXn().vRn.setVisibility(8);
        localj.bXn().vRu.setVisibility(0);
        GMTrace.o(2474438033408L, 18436);
        return;
        locall.reset();
        Object localObject1 = com.tencent.mm.modelvideo.t.lI(str1);
        if (localObject1 != null)
        {
          i = ((r)localObject1).hrb;
          if (i < locall.vRU.vRW)
          {
            v.i("MicroMsg.OnlineVideoUIHelper", "video size[%d] less than config size[%d], do not stream video", new Object[] { Integer.valueOf(i), Integer.valueOf(locall.vRU.vRW) });
            com.tencent.mm.modelvideo.t.b((r)localObject1, 9);
            com.tencent.mm.plugin.report.service.g.oSF.a(354L, 17L, 1L, false);
            i = 0;
            continue;
          }
        }
        com.tencent.mm.modelvideo.t.J(str1, 1);
        n.KU();
        com.tencent.mm.modelvideo.o.KX();
        if (bf.mA(str1)) {
          localObject1 = null;
        }
        for (;;)
        {
          if (localObject1 == null)
          {
            i = 0;
            break;
            r localr = com.tencent.mm.modelvideo.t.lI(str1);
            if (localr == null)
            {
              localObject1 = null;
            }
            else
            {
              localObject1 = bg.q(localr.Li(), "msg");
              if (localObject1 == null)
              {
                v.w("MicroMsg.OnlineVideoService", "cdntra parse video recv xml failed");
                localObject1 = null;
              }
              else
              {
                Object localObject2 = (String)((Map)localObject1).get(".msg.videomsg.$cdnvideourl");
                if (bf.mA((String)localObject2))
                {
                  v.w("MicroMsg.OnlineVideoService", "cdntra parse video recv xml failed");
                  localObject1 = null;
                }
                else
                {
                  int j = Integer.valueOf((String)((Map)localObject1).get(".msg.videomsg.$length")).intValue();
                  Object localObject3 = (String)((Map)localObject1).get(".msg.videomsg.$md5");
                  String str2 = (String)((Map)localObject1).get(".msg.videomsg.$aeskey");
                  String str3 = (String)((Map)localObject1).get(".msg.videomsg.$fileparam");
                  String str4 = com.tencent.mm.modelcdntran.d.a("downvideo", localr.hZS, localr.Lf(), localr.getFileName());
                  if (bf.mA(str4))
                  {
                    v.w("MicroMsg.OnlineVideoService", "cdntra genClientId failed not use cdn file:%s", new Object[] { localr.getFileName() });
                    localObject1 = null;
                  }
                  else
                  {
                    com.tencent.mm.modelvideo.o.KW();
                    String str5 = com.tencent.mm.modelvideo.s.lw(str1);
                    localObject1 = new com.tencent.mm.modelcdntran.i();
                    ((com.tencent.mm.modelcdntran.i)localObject1).filename = str1;
                    ((com.tencent.mm.modelcdntran.i)localObject1).hyZ = ((String)localObject3);
                    ((com.tencent.mm.modelcdntran.i)localObject1).hza = j;
                    ((com.tencent.mm.modelcdntran.i)localObject1).hzb = 1;
                    ((com.tencent.mm.modelcdntran.i)localObject1).fOl = localr.Lg();
                    ((com.tencent.mm.modelcdntran.i)localObject1).hzc = localr.Lf();
                    if (com.tencent.mm.u.o.dH(localr.Lf()))
                    {
                      i = com.tencent.mm.u.j.eC(localr.Lf());
                      label748:
                      ((com.tencent.mm.modelcdntran.i)localObject1).fOn = i;
                      ((com.tencent.mm.modelcdntran.i)localObject1).field_mediaId = str4;
                      ((com.tencent.mm.modelcdntran.i)localObject1).field_fullpath = str5;
                      ((com.tencent.mm.modelcdntran.i)localObject1).field_fileType = com.tencent.mm.modelcdntran.b.MediaType_VIDEO;
                      ((com.tencent.mm.modelcdntran.i)localObject1).field_totalLen = j;
                      ((com.tencent.mm.modelcdntran.i)localObject1).field_aesKey = str2;
                      ((com.tencent.mm.modelcdntran.i)localObject1).field_fileId = ((String)localObject2);
                      ((com.tencent.mm.modelcdntran.i)localObject1).field_priority = com.tencent.mm.modelcdntran.b.hxt;
                      ((com.tencent.mm.modelcdntran.i)localObject1).field_wxmsgparam = str3;
                      if (!com.tencent.mm.u.o.dH(localr.Lf())) {
                        break label989;
                      }
                      i = 1;
                      label825:
                      ((com.tencent.mm.modelcdntran.i)localObject1).field_chattype = i;
                      ((com.tencent.mm.modelcdntran.i)localObject1).hzd = localr.hzd;
                      localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().x(localr.Lf(), localr.fTG);
                      localObject3 = ay.gm(((ce)localObject2).gxv);
                      if (localObject3 == null) {
                        break label994;
                      }
                      i = ((ay.b)localObject3).hmH;
                      label893:
                      ((com.tencent.mm.modelcdntran.i)localObject1).initialDownloadLength = i;
                      ((com.tencent.mm.modelcdntran.i)localObject1).initialDownloadOffset = 0;
                      ((com.tencent.mm.modelcdntran.i)localObject1).hzf = ((ce)localObject2).field_createTime;
                      ((com.tencent.mm.modelcdntran.i)localObject1).fTG = ((ce)localObject2).field_msgSvrId;
                      if (localObject3 == null) {
                        break label999;
                      }
                    }
                    label989:
                    label994:
                    label999:
                    for (i = ((ay.b)localObject3).hmI;; i = 0)
                    {
                      ((com.tencent.mm.modelcdntran.i)localObject1).hzg = i;
                      if (((com.tencent.mm.modelcdntran.i)localObject1).initialDownloadLength > 0) {
                        com.tencent.mm.plugin.report.service.g.oSF.a(354L, 36L, 1L, false);
                      }
                      ((com.tencent.mm.modelcdntran.i)localObject1).field_autostart = false;
                      ((com.tencent.mm.modelcdntran.i)localObject1).field_requestVideoFormat = com.tencent.mm.modelcontrol.d.a(1, localr);
                      break;
                      i = 0;
                      break label748;
                      i = 0;
                      break label825;
                      i = 0;
                      break label893;
                    }
                  }
                }
              }
            }
          }
        }
        locall.mediaId = ((com.tencent.mm.modelcdntran.i)localObject1).field_mediaId;
        locall.iyv = ((com.tencent.mm.modelcdntran.i)localObject1).hza;
        locall.filename = str1;
        locall.hXL = 1;
        locall.hXO = 0;
        boolean bool = com.tencent.mm.modelvideo.o.Lb().Lu();
        com.tencent.mm.modelvideo.o.KX().a((com.tencent.mm.modelcdntran.i)localObject1, bool);
        locall.hyY = bf.NA();
        com.tencent.mm.plugin.report.service.g.oSF.a(354L, 1L, 1L, false);
        v.i("MicroMsg.OnlineVideoUIHelper", "download online video.[%s, %s] start time[%d]", new Object[] { locall.mediaId, str1, Long.valueOf(locall.hyY) });
        i = 1;
      }
      v.i("MicroMsg.Imagegallery.handler.video", "start offline play video.");
      this.qub = false;
      com.tencent.mm.modelvideo.o.KW().a(this, Looper.getMainLooper());
      com.tencent.mm.modelvideo.t.lE(paramau.field_imgPath);
      this.vNV.vNW.bWU();
      this.vQT = false;
      localj.bXn().vRl.setVisibility(8);
      localj.bXn().vRn.setVisibility(0);
      localj.bXn().vRn.setProgress(com.tencent.mm.modelvideo.t.f(paramr));
      GMTrace.o(2474438033408L, 18436);
      return;
    }
    if (paramr.Lk())
    {
      v.i("MicroMsg.Imagegallery.handler.video", "start complete online video");
      com.tencent.mm.modelvideo.t.lM(paramau.field_imgPath);
    }
    for (;;)
    {
      com.tencent.mm.modelvideo.o.KW().a(this, Looper.getMainLooper());
      this.vNV.vNW.bWU();
      this.vQT = false;
      localj.bXn().vRl.setVisibility(8);
      localj.bXn().vRn.setVisibility(0);
      localj.bXn().vRn.setProgress(com.tencent.mm.modelvideo.t.f(paramr));
      if (i != 2) {
        break;
      }
      com.tencent.mm.plugin.report.service.g.oSF.a(354L, 14L, 1L, false);
      GMTrace.o(2474438033408L, 18436);
      return;
      v.i("MicroMsg.Imagegallery.handler.video", "start complete offline video");
      cP(paramau.field_imgPath, 10);
      com.tencent.mm.modelvideo.t.lE(paramau.field_imgPath);
    }
    com.tencent.mm.plugin.report.service.g.oSF.a(354L, 11L, 1L, false);
    GMTrace.o(2474438033408L, 18436);
  }
  
  public final boolean b(j paramj)
  {
    GMTrace.i(2477390823424L, 18458);
    int i = this.vQL;
    this.vQL = paramj.bXn().vRm.getCurrentPosition();
    int j;
    if (i != this.vQL)
    {
      this.lastCheckTime = bf.NA();
      long l = paramj.bXn().vRm.bcq();
      if ((l > 0L) && (l != this.vQM))
      {
        this.vQM = l;
        j = this.vQN;
        switch (j)
        {
        default: 
          this.vQN = 0;
        }
      }
    }
    do
    {
      for (;;)
      {
        GMTrace.o(2477390823424L, 18458);
        return true;
        i = 21;
        for (;;)
        {
          v.w("MicroMsg.Imagegallery.handler.video", "%d rpt rptRepairEffect idKey %d errorTime %d filename %s", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(j), this.filename });
          com.tencent.mm.plugin.report.service.g.oSF.a(354L, i, 1L, false);
          com.tencent.mm.plugin.report.service.g.oSF.i(13836, new Object[] { Integer.valueOf(301), Long.valueOf(bf.Nz()), "" });
          break;
          i = 22;
          continue;
          i = 23;
        }
        if (this.vQN != -1)
        {
          this.vQN += 1;
          v.w("MicroMsg.Imagegallery.handler.video", "media play is playing[%d], but surface is not update!! repair time[%d]", new Object[] { Integer.valueOf(this.vQN), Integer.valueOf(this.vQO) });
          if (this.vQO >= 2) {
            this.vQH.bXq();
          }
          switch (this.vQN)
          {
          case 0: 
          case 1: 
          default: 
            v.w("MicroMsg.Imagegallery.handler.video", "rpt surface not update!!");
            v.w("MicroMsg.Imagegallery.handler.video", "%d rpt rptSurfaceNotUpdate %s", new Object[] { Integer.valueOf(hashCode()), this.filename });
            com.tencent.mm.plugin.report.service.g.oSF.i(13836, new Object[] { Integer.valueOf(300), Long.valueOf(bf.Nz()), "" });
            com.tencent.mm.plugin.report.service.g.oSF.a(354L, 20L, 1L, false);
            this.vQN = -1;
          }
        }
      }
      i = this.vQL / 1000;
      v.w("MicroMsg.Imagegallery.handler.video", "surface not update, it try seek time[%d] to repair.", new Object[] { Integer.valueOf(i) });
      K(i, true);
      this.vQO += 1;
      GMTrace.o(2477390823424L, 18458);
      return false;
      j = (this.vQL - 2000) / 1000;
      i = j;
      if (j < 0) {
        i = 0;
      }
      v.w("MicroMsg.Imagegallery.handler.video", "surface not update, it try seek time[%d] to repair.", new Object[] { Integer.valueOf(i) });
      K(i, true);
      this.vQO += 1;
      GMTrace.o(2477390823424L, 18458);
      return false;
      j = (this.vQL - 4000) / 1000;
      i = j;
      if (j < 0) {
        i = 0;
      }
      v.w("MicroMsg.Imagegallery.handler.video", "surface not update, it try seek time[%d] to repair.", new Object[] { Integer.valueOf(i) });
      K(i, true);
      this.vQO += 1;
      GMTrace.o(2477390823424L, 18458);
      return false;
      v.i("MicroMsg.Imagegallery.handler.video", "check time[%d, %d], play time[%d, %d]", new Object[] { Long.valueOf(this.lastCheckTime), Long.valueOf(bf.NA()), Integer.valueOf(i), Integer.valueOf(this.vQL) });
    } while ((this.lastCheckTime <= 0L) || (bf.aA(this.lastCheckTime) < 1500L));
    v.w("MicroMsg.Imagegallery.handler.video", "play time not update! request all video data to play. ");
    i = this.vNV.bWB().vRm.getCurrentPosition();
    bjf();
    com.tencent.mm.modelvideo.t.d(this.filename, i, this.qub);
    this.vNV.bWB().vRm.stop();
    this.vQH.bXq();
    paramj = (a)this.vPL.get(this.filename);
    if ((paramj == null) || (paramj.fCQ == null))
    {
      GMTrace.o(2477390823424L, 18458);
      return false;
    }
    r localr = bl(paramj.fCQ);
    a(paramj.fCQ, localr, paramj.pos, this.qub);
    this.lastCheckTime = 0L;
    GMTrace.o(2477390823424L, 18458);
    return false;
  }
  
  public final void bWI()
  {
    GMTrace.i(2474840686592L, 18439);
    v.i("MicroMsg.Imagegallery.handler.video", "stopAll. video handler hash code : " + hashCode());
    this.qug = bf.NA();
    SparseArray localSparseArray = this.vNV.vlX;
    int j = 0;
    int i = 0;
    if (j < localSparseArray.size())
    {
      int k = localSparseArray.keyAt(j);
      if ((localSparseArray.get(k) == null) || (((View)localSparseArray.get(k)).getTag() == null)) {
        break label422;
      }
      j localj = (j)((View)localSparseArray.get(k)).getTag();
      if ((localj.vRj == null) || (localj.bXn().vRj.getVisibility() != 0) || ((((View)localj.bXn().vRm).getVisibility() != 0) && (bf.mA(localj.bXn().vRm.Lt())) && ((!this.qub) || (!this.vQH.isStreaming())))) {
        break label422;
      }
      v.i("MicroMsg.Imagegallery.handler.video", "stop");
      bjf();
      if (localj != null)
      {
        bji();
        if (this.qub) {
          this.vQH.bXp();
        }
        if (!this.vQJ) {
          com.tencent.mm.modelvideo.t.d(this.filename, this.vQL - 1000, this.qub);
        }
        localj.bXn().vRn.setVisibility(8);
        localj.bXn().vRu.setVisibility(8);
        localj.bXn().vRm.stop();
        BD(0);
        localj.a(false, 0.0F);
        this.qub = false;
        this.vQT = false;
        this.vQP = false;
        this.filename = null;
        this.qum = 0;
        this.qul = 0L;
        this.vQU = 0;
        this.vQR = 0;
        this.vQO = 0;
        this.vQN = 0;
        this.vQM = 0L;
        this.lastCheckTime = 0L;
      }
      i = 1;
    }
    label422:
    for (;;)
    {
      j += 1;
      break;
      this.iWx.aS(false);
      if ((i == 0) && (this.qub))
      {
        this.vQH.bXp();
        this.qub = false;
      }
      bjf();
      this.vQG.clear();
      GMTrace.o(2474840686592L, 18439);
      return;
    }
  }
  
  public final void bXh()
  {
    GMTrace.i(2475243339776L, 18442);
    this.vQJ = false;
    this.lIE = 0;
    if (this.vNV != null) {}
    for (Object localObject = this.vNV.bWB(); localObject == null; localObject = null)
    {
      v.w("MicroMsg.Imagegallery.handler.video", "notify video prepared, but holder is null.");
      GMTrace.o(2475243339776L, 18442);
      return;
    }
    final int i = bf.ex(((j)localObject).bXn().vRm.getDuration());
    int j = this.vNV.vNW.bWK().vQc.ptr;
    v.i("MicroMsg.Imagegallery.handler.video", "%d videoDuration %d hadSetTotalTime %d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(j) });
    if ((j <= 0) || (Math.abs(j - i) >= 2)) {
      this.vNV.vNW.bWK().vQc.sD(i);
    }
    bXj();
    if ((i == 0) || (i >= 1800))
    {
      v.w("MicroMsg.Imagegallery.handler.video", "%d repair video duration[%d] error. filename[%s]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(i), this.filename });
      i = com.tencent.mm.modelvideo.t.u(i, this.filename);
      v.i("MicroMsg.Imagegallery.handler.video", "notify video prepared. isOnlinePlay[%b] playDuration[%d] playVideoWhenNotify[%b] hadPlayError[%b].", new Object[] { Boolean.valueOf(this.qub), Integer.valueOf(i), Boolean.valueOf(this.vQI), Boolean.valueOf(this.vQJ) });
      ((j)localObject).bXn().vRm.a(this.qtP);
      if (!this.vQI) {
        break label415;
      }
      if (this.qub) {
        break label356;
      }
      this.vQH.reset();
      bjh();
      K(i, true);
    }
    for (;;)
    {
      bs(false);
      GMTrace.o(2475243339776L, 18442);
      return;
      ap.vL().D(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(14661273518080L, 109235);
          Object localObject = i.this.filename;
          int i = i;
          localObject = com.tencent.mm.modelvideo.t.lI((String)localObject);
          if (localObject != null)
          {
            int j = ((r)localObject).hZV;
            if ((j <= 0) || (Math.abs(j - i) > 2))
            {
              ((r)localObject).hZV = i;
              ((r)localObject).fRM = 4096;
              v.i("MicroMsg.VideoLogic", "repair video duration ret %b, duration[%d, %d]", new Object[] { Boolean.valueOf(com.tencent.mm.modelvideo.t.e((r)localObject)), Integer.valueOf(j), Integer.valueOf(i) });
            }
          }
          GMTrace.o(14661273518080L, 109235);
        }
      });
      break;
      label356:
      localObject = this.vQH;
      if (i > 0)
      {
        v.i("MicroMsg.OnlineVideoUIHelper", "seek to last duration : " + i);
        ((l)localObject).hXP = i;
        ((l)localObject).hXR = true;
        ((l)localObject).hXM = 2;
      }
      this.vQH.gK(0);
    }
    label415:
    if (!this.qub) {
      K(i, false);
    }
    for (;;)
    {
      BD(i);
      this.vNV.vNW.lr(true);
      bjf();
      GMTrace.o(2475243339776L, 18442);
      return;
      this.vQH.am(i, false);
    }
  }
  
  public final void bXi()
  {
    GMTrace.i(2475377557504L, 18443);
    v.i("MicroMsg.Imagegallery.handler.video", "notify video completion. isOnlinePlay : " + this.qub);
    bjf();
    bji();
    Object localObject1;
    if ((this.qub) && (this.vNV != null) && (this.vNV.bWB() != null))
    {
      localObject1 = this.vNV.bWB().bXn().vRm;
      if ((localObject1 != null) && (((com.tencent.mm.pluginsdk.ui.tools.f)localObject1).getCurrentPosition() + 2000 < ((com.tencent.mm.pluginsdk.ui.tools.f)localObject1).getDuration())) {
        v.e("MicroMsg.Imagegallery.handler.video", "notify video completion, but cur pos[%d] is less than duration[%d]", new Object[] { Integer.valueOf(((com.tencent.mm.pluginsdk.ui.tools.f)localObject1).getCurrentPosition()), Integer.valueOf(((com.tencent.mm.pluginsdk.ui.tools.f)localObject1).getDuration()) });
      }
    }
    for (int i = 0;; i = 1)
    {
      if (i != 0)
      {
        ae.v(new Runnable()
        {
          public final void run()
          {
            GMTrace.i(2408537128960L, 17945);
            i.this.vQK = true;
            Object localObject = i.this;
            i.this.vQM = 0L;
            ((i)localObject).lastCheckTime = 0L;
            i.this.iWx.aS(false);
            i.this.bji();
            if (i.this.qub)
            {
              i.this.vQH.bXp();
              i.this.vQH.reset();
              i.this.qub = false;
              i.this.vQT = false;
            }
            com.tencent.mm.modelvideo.t.d(i.this.filename, 0, i.this.qub);
            if (i.this.vPL != null)
            {
              localObject = (i.a)i.this.vPL.get(i.this.filename);
              if (localObject != null)
              {
                j localj = i.this.vNV.bWB();
                localj.bXn().vRm.stop();
                i.this.vQL = 0;
                i.this.a(localj, ((i.a)localObject).fCQ, ((i.a)localObject).pos);
                i.this.BD(0);
                if (localj.bXn().vRu.getVisibility() != 8) {
                  localj.bXn().vRu.setVisibility(8);
                }
              }
            }
            GMTrace.o(2408537128960L, 17945);
          }
        });
        GMTrace.o(2475377557504L, 18443);
        return;
      }
      try
      {
        i = this.vNV.bWB().vRm.getCurrentPosition();
        com.tencent.mm.modelvideo.t.d(this.filename, i, this.qub);
        this.vNV.bWB().vRm.stop();
        this.vQH.bXq();
        i = this.vQR + 1;
        this.vQR = i;
        if (i <= 3)
        {
          localObject1 = (a)this.vPL.get(this.filename);
          if (localObject1 != null)
          {
            localObject2 = ((a)localObject1).fCQ;
            if (localObject2 != null) {}
          }
          else
          {
            GMTrace.o(2475377557504L, 18443);
            return;
          }
          Object localObject2 = bl(((a)localObject1).fCQ);
          a(((a)localObject1).fCQ, (r)localObject2, ((a)localObject1).pos, this.qub);
        }
        GMTrace.o(2475377557504L, 18443);
        return;
      }
      catch (Exception localException)
      {
        v.printErrStackTrace("MicroMsg.Imagegallery.handler.video", localException, "notify video completion error[%s]", new Object[] { localException.toString() });
        GMTrace.o(2475377557504L, 18443);
        return;
      }
    }
  }
  
  protected final boolean bjg()
  {
    GMTrace.i(2476719734784L, 18453);
    j localj = this.vNV.bWB();
    if (localj == null)
    {
      GMTrace.o(2476719734784L, 18453);
      return false;
    }
    boolean bool = true;
    if (!localj.bXn().vRm.isPlaying())
    {
      v.i("MicroMsg.Imagegallery.handler.video", "start to play");
      this.vNV.vNW.lr(false);
      localj.bXn().vRu.setVisibility(8);
      bool = localj.bXn().vRm.start();
      bjh();
    }
    if (localj.bXn().vRu.getVisibility() != 8) {
      localj.bXn().vRu.setVisibility(8);
    }
    GMTrace.o(2476719734784L, 18453);
    return bool;
  }
  
  public final void bji()
  {
    GMTrace.i(2477256605696L, 18457);
    if (this.qul > 0L) {
      this.qum = ((int)(this.qum + (bf.NA() - this.qul) / 1000L));
    }
    v.i("MicroMsg.Imagegallery.handler.video", "notePauseVideo filename %s playVideoDuration %d ", new Object[] { this.filename, Integer.valueOf(this.qum) });
    this.qul = 0L;
    GMTrace.o(2477256605696L, 18457);
  }
  
  protected final void bs(boolean paramBoolean)
  {
    GMTrace.i(14661407735808L, 109236);
    if (!this.vQJ)
    {
      if (this.qub)
      {
        if (paramBoolean)
        {
          ae.v(new Runnable()
          {
            public final void run()
            {
              GMTrace.i(14660333993984L, 109228);
              for (;;)
              {
                try
                {
                  if (!bf.mA(i.this.vNV.bWB().bXn().vRm.Lt())) {
                    continue;
                  }
                  i = com.tencent.mm.modelvideo.t.u(i.this.vQH.hXO, i.this.filename);
                  i.this.vQH.gK(i);
                }
                catch (Exception localException)
                {
                  int i;
                  v.printErrStackTrace("MicroMsg.Imagegallery.handler.video", localException, "start timer error[%s]", new Object[] { localException.toString() });
                  continue;
                }
                i.this.quh.v(500L, 500L);
                GMTrace.o(14660333993984L, 109228);
                return;
                i = i.this.vNV.bWB().bXn().vRm.getCurrentPosition() / 1000;
              }
            }
          });
          GMTrace.o(14661407735808L, 109236);
          return;
        }
        this.quh.v(500L, 500L);
        GMTrace.o(14661407735808L, 109236);
        return;
      }
      this.kli.v(500L, 500L);
    }
    GMTrace.o(14661407735808L, 109236);
  }
  
  public final void detach()
  {
    GMTrace.i(2475109122048L, 18441);
    v.i("MicroMsg.Imagegallery.handler.video", "detach.[%d]", new Object[] { Integer.valueOf(hashCode()) });
    this.qug = bf.NA();
    this.vQQ.removeMessages(1);
    bjf();
    com.tencent.mm.sdk.b.a.uql.c(this.vQF);
    com.tencent.mm.sdk.b.a.uql.c(this.vQS);
    bWI();
    this.vNV.vNW.uRf.uRz.getWindow().clearFlags(128);
    this.vNV.vNW.bWK().vQc.ptk = null;
    super.detach();
    this.vPL.clear();
    this.vPL = null;
    com.tencent.mm.modelvideo.o.KW().a(this);
    this.vQG.clear();
    l locall = this.vQH;
    locall.reset();
    locall.hXN = null;
    locall.vRT = null;
    locall.vRU = null;
    if (com.tencent.mm.plugin.s.e.aKi()) {
      ap.vL().D(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(14655904808960L, 109195);
          String str = com.tencent.mm.plugin.s.e.aKj();
          if (!bf.mA(str))
          {
            com.tencent.mm.plugin.report.service.g.oSF.A(14092, str);
            GMTrace.o(14655904808960L, 109195);
            return;
          }
          com.tencent.mm.plugin.report.service.g.oSF.A(14092, "0");
          GMTrace.o(14655904808960L, 109195);
        }
      });
    }
    com.tencent.mm.modelvideo.o.Lb().Lu();
    com.tencent.mm.modelvideo.o.Lb().run();
    GMTrace.o(2475109122048L, 18441);
  }
  
  public final void ec(int paramInt1, int paramInt2)
  {
    GMTrace.i(2475511775232L, 18444);
    boolean bool2 = this.qub;
    final Object localObject = this.vQH;
    boolean bool1;
    if ((!bf.mA(((l)localObject).mediaId)) && (((l)localObject).hXL == 1))
    {
      bool1 = true;
      v.e("MicroMsg.Imagegallery.handler.video", "notify video error, what %d, extras %d isOnlinePlay %b isLoading %b ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      this.vQJ = true;
      this.lIE = paramInt2;
      if (!this.qub) {
        break label290;
      }
      if (paramInt1 != -1) {
        break label199;
      }
      bjf();
      this.vNV.bWB().vRm.stop();
      this.vQH.bXq();
    }
    label199:
    label262:
    do
    {
      for (;;)
      {
        this.vQT = false;
        this.vNV.vNW.lr(true);
        this.vNV.bWB().bXn().vRu.setVisibility(0);
        bji();
        com.tencent.mm.plugin.report.service.g.oSF.a(354L, 18L, 1L, false);
        GMTrace.o(2475511775232L, 18444);
        return;
        bool1 = false;
        break;
        if (paramInt1 != -2) {
          break label262;
        }
        bjf();
        paramInt1 = this.vNV.bWB().vRm.getCurrentPosition();
        com.tencent.mm.modelvideo.t.d(this.filename, paramInt1, this.qub);
        this.vNV.bWB().vRm.stop();
        this.vQH.bXq();
      }
    } while (paramInt1 != -3);
    this.vQJ = false;
    this.vQH.bXq();
    GMTrace.o(2475511775232L, 18444);
    return;
    label290:
    com.tencent.mm.modelvideo.t.lL(this.filename);
    bji();
    if ((this.vNV != null) && (this.vNV.bWB() != null) && (this.vNV.bWB().vRm != null))
    {
      localObject = this.vNV.bWB().vRm.Lt();
      this.vNV.bWB().vRm.stop();
    }
    while (this.vQK)
    {
      v.i("MicroMsg.Imagegallery.handler.video", "%d had play completion don't show error tips", new Object[] { Integer.valueOf(hashCode()) });
      GMTrace.o(2475511775232L, 18444);
      return;
      localObject = "";
    }
    ae.v(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(2438736117760L, 18170);
        if ((i.this.vNV == null) || (i.this.vNV.bWB() == null) || (i.this.vPL == null))
        {
          v.w("MicroMsg.Imagegallery.handler.video", "show error alert but adapter is null.");
          GMTrace.o(2438736117760L, 18170);
          return;
        }
        i.this.vNV.bWB().a(false, 0.0F);
        if (!bf.mA(localObject)) {
          v.e("MicroMsg.Imagegallery.handler.video", "mediaplay play video error, use third player.[%s]", new Object[] { localObject });
        }
        try
        {
          Object localObject = new Intent();
          ((Intent)localObject).setAction("android.intent.action.VIEW");
          ((Intent)localObject).setDataAndType(Uri.fromFile(new File(localObject)), "video/*");
          i.this.vNV.vNW.startActivity((Intent)localObject);
          localObject = (i.a)i.this.vPL.get(i.this.filename);
          if ((localObject == null) || (((i.a)localObject).fCQ == null))
          {
            GMTrace.o(2438736117760L, 18170);
            return;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            v.e("MicroMsg.Imagegallery.handler.video", "startActivity fail, activity not found");
            com.tencent.mm.ui.base.g.h(i.this.vNV.vNW, R.l.eiD, R.l.eiE);
          }
          i.this.BC(localException.pos);
          GMTrace.o(2438736117760L, 18170);
        }
      }
    });
    com.tencent.mm.plugin.report.service.g.oSF.a(354L, 25L, 1L, false);
    GMTrace.o(2475511775232L, 18444);
  }
  
  public final void h(au paramau, int paramInt)
  {
    GMTrace.i(2473901162496L, 18432);
    v.i("MicroMsg.Imagegallery.handler.video", "toggle video");
    if (paramau == null)
    {
      GMTrace.o(2473901162496L, 18432);
      return;
    }
    if ((!b.aS(paramau)) && (!b.aT(paramau)))
    {
      GMTrace.o(2473901162496L, 18432);
      return;
    }
    r localr = bl(paramau);
    if (localr == null)
    {
      GMTrace.o(2473901162496L, 18432);
      return;
    }
    if ((this.qub) && (this.vQH != null) && (this.vQH.hXR))
    {
      v.i("MicroMsg.Imagegallery.handler.video", "%d it loading video data, do not response button click.", new Object[] { Integer.valueOf(hashCode()) });
      GMTrace.o(2473901162496L, 18432);
      return;
    }
    if (this.vNV.vNW.bWW())
    {
      a(Bf(paramInt));
      this.vNV.vNW.lr(true);
      this.vNV.vNW.vQt.KI();
      this.iWx.aS(false);
      v.i("MicroMsg.Imagegallery.handler.video", "toggle pause video.");
      GMTrace.o(2473901162496L, 18432);
      return;
    }
    ap.yY();
    if (!com.tencent.mm.u.c.isSDCardAvailable())
    {
      com.tencent.mm.ui.base.s.eP(this.vNV.vNW.uRf.uRz);
      GMTrace.o(2473901162496L, 18432);
      return;
    }
    if (this.qub) {}
    for (;;)
    {
      int i;
      try
      {
        if (this.vNV.bWB().vRm != null)
        {
          i = this.vNV.bWB().vRm.getCurrentPosition() / 1000;
          if (!this.vQH.gL(i)) {
            continue;
          }
          v.i("MicroMsg.Imagegallery.handler.video", "toggle play video");
          a(paramau, localr, paramInt, this.qub);
          if (this.vNV.vNW.vQs) {
            this.vNV.vNW.bWS();
          }
          bXj();
          GMTrace.o(2473901162496L, 18432);
        }
      }
      catch (Exception localException)
      {
        v.printErrStackTrace("MicroMsg.Imagegallery.handler.video", localException, "", new Object[0]);
        i = 0;
        continue;
        v.i("MicroMsg.Imagegallery.handler.video", "toggle start timer.");
        bs(false);
        continue;
      }
      if (paramau.field_isSend == 0)
      {
        if ((localr.status != 113) && (localr.status != 198)) {
          break label508;
        }
        a(paramau, localr);
      }
      for (;;)
      {
        if (paramau.field_isSend != 1) {
          break label590;
        }
        i = localr.status;
        if ((i != 111) && (i != 113) && (i != 112) && (i != 121) && (i != 122)) {
          break label592;
        }
        v.i("MicroMsg.Imagegallery.handler.video", "download video. msg talker[%s], info status[%d]", new Object[] { paramau.field_talker, Integer.valueOf(i) });
        a(paramau, localr);
        break;
        label508:
        if (localr.status == 199) {
          a(paramau, localr, paramInt, false);
        }
        if (localr.status == 111) {
          a(paramau, localr);
        }
        if (localr.status == 112) {
          a(paramau, localr);
        }
        if ((localr.status == 121) || (localr.status == 122)) {
          a(paramau, localr);
        }
      }
      label590:
      continue;
      label592:
      a(paramau, localr, paramInt, false);
    }
  }
  
  public final void i(au paramau, int paramInt)
  {
    GMTrace.i(2474035380224L, 18433);
    v.i("MicroMsg.Imagegallery.handler.video", "toggleVideoMenu pos ");
    r localr = com.tencent.mm.modelvideo.t.lI(paramau.field_imgPath);
    if ((localr != null) && (!localr.Ll()))
    {
      a(Bf(paramInt));
      this.vNV.vNW.lr(true);
      if (this.qub)
      {
        this.vQH.bXp();
        this.vQH.reset();
      }
      a(paramau, localr);
      if (this.vNV.vNW.eS(paramau.field_msgId) == 2)
      {
        cP(paramau.field_imgPath, 8);
        GMTrace.o(2474035380224L, 18433);
        return;
      }
      cP(paramau.field_imgPath, 5);
    }
    GMTrace.o(2474035380224L, 18433);
  }
  
  protected final void onResume()
  {
    GMTrace.i(16136460566528L, 120226);
    v.i("MicroMsg.Imagegallery.handler.video", "ui on resume, add online video event.");
    this.vQQ.removeMessages(1);
    com.tencent.mm.sdk.b.a.uql.b(this.vQS);
    if ((this.vNV != null) && (com.tencent.mm.compatible.util.d.eo(21)))
    {
      j localj = this.vNV.bWB();
      if ((localj != null) && (localj.vRm != null))
      {
        if ((localj.vRm instanceof VideoPlayerTextureView))
        {
          ((VideoPlayerTextureView)localj.vRm).aKv();
          GMTrace.o(16136460566528L, 120226);
          return;
        }
        if ((localj.vRm instanceof VideoTextureView)) {
          ((VideoTextureView)localj.vRm).aKv();
        }
      }
    }
    GMTrace.o(16136460566528L, 120226);
  }
  
  public final void pause(int paramInt)
  {
    GMTrace.i(2473766944768L, 18431);
    a(Bf(paramInt));
    this.iWx.aS(false);
    this.vNV.vNW.lr(true);
    GMTrace.o(2473766944768L, 18431);
  }
  
  public static final class a
  {
    public au fCQ;
    public int pos;
    
    public a(au paramau, int paramInt)
    {
      GMTrace.i(2433367408640L, 18130);
      this.fCQ = paramau;
      this.pos = paramInt;
      GMTrace.o(2433367408640L, 18130);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/gallery/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */