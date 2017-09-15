package com.tencent.mm.ui.chatting.c;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Looper;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.b;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.g;
import android.support.v7.widget.RecyclerView.h;
import android.view.View;
import android.widget.Toast;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.f;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.c.a;
import com.tencent.mm.ah.n;
import com.tencent.mm.e.a.cb;
import com.tencent.mm.e.a.cb.a;
import com.tencent.mm.e.a.cb.b;
import com.tencent.mm.e.a.gg;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.s.a;
import com.tencent.mm.modelvideo.s.a.a;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.model.app.l.a;
import com.tencent.mm.protocal.c.akp;
import com.tencent.mm.protocal.c.ru;
import com.tencent.mm.protocal.c.sd;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.chatting.a.d;
import com.tencent.mm.ui.chatting.ab;
import com.tencent.mm.ui.chatting.b.a.a;
import com.tencent.mm.ui.chatting.dx;
import com.tencent.mm.ui.chatting.dx.a;
import com.tencent.mm.ui.chatting.gallery.b;
import com.tencent.mm.ui.chatting.gallery.g.a;
import com.tencent.mm.ui.chatting.gallery.g.b;
import com.tencent.mm.ui.chatting.gallery.i;
import com.tencent.mm.ui.chatting.z;
import com.tencent.mm.y.k;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public final class e
  implements c.a, s.a, a.a, g.b
{
  static int count;
  public ArrayList<com.tencent.mm.ui.chatting.a.a.c> jmq;
  public int kTl;
  public String kuX;
  public Context mContext;
  public ad mHandler;
  private com.tencent.mm.sdk.b.c vHY;
  public long vNv;
  public int vSo;
  public com.tencent.mm.ui.chatting.b.a.b vSs;
  com.tencent.mm.ui.chatting.a.a vSt;
  private GridLayoutManager vSu;
  boolean vSv;
  public int vSw;
  public boolean vSx;
  
  static
  {
    GMTrace.i(14936151425024L, 111283);
    count = 0;
    GMTrace.o(14936151425024L, 111283);
  }
  
  public e(Context paramContext)
  {
    GMTrace.i(14931856457728L, 111251);
    this.jmq = null;
    this.vHY = new com.tencent.mm.sdk.b.c() {};
    this.vSv = false;
    this.vSw = 0;
    this.mHandler = new ad(Looper.getMainLooper());
    this.vSx = false;
    this.vSo = 0;
    this.kTl = 0;
    this.mContext = paramContext;
    this.jmq = new ArrayList();
    GMTrace.o(14931856457728L, 111251);
  }
  
  static String c(au paramau, r paramr)
  {
    GMTrace.i(18820680908800L, 140225);
    Object localObject;
    if (paramr.iac == -1)
    {
      paramr = paramr.Lh();
      localObject = paramr;
      if (!com.tencent.mm.a.e.aO(paramr))
      {
        o.KW();
        localObject = s.lw(paramau.field_imgPath);
      }
    }
    String str;
    do
    {
      do
      {
        do
        {
          GMTrace.o(18820680908800L, 140225);
          return (String)localObject;
          o.KW();
          str = s.lw(paramau.field_imgPath);
          localObject = str;
        } while (paramau.field_isSend != 1);
        localObject = str;
      } while (paramr.iaf == null);
      localObject = str;
    } while (!paramr.iaf.tMG);
    for (;;)
    {
      try
      {
        paramr = FileOp.kl(str);
        paramau = paramr;
        if (!paramr.endsWith("/")) {
          paramau = paramr + "/";
        }
        paramr = com.tencent.mm.a.e.aR(str);
        paramau = paramau + paramr + "_hd.mp4";
        boolean bool = FileOp.aO(paramau);
        v.i("MicroMsg.MediaHistoryGalleryPresenter", "local capture video, hdFilePath: %s, exist: %s", new Object[] { paramau, Boolean.valueOf(bool) });
        if (!bool) {
          break label227;
        }
        localObject = paramau;
      }
      catch (Exception paramau)
      {
        v.e("MicroMsg.MediaHistoryGalleryPresenter", "try to get hd filePath error: %s", new Object[] { paramau.getMessage() });
        localObject = str;
      }
      break;
      label227:
      paramau = str;
    }
  }
  
  private void cI(final List<au> paramList)
  {
    GMTrace.i(14933735505920L, 111265);
    com.tencent.mm.plugin.report.service.g.oSF.i(11627, new Object[] { Integer.valueOf(5) });
    final TreeSet localTreeSet = new TreeSet();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      localTreeSet.add(Long.valueOf(((au)localIterator.next()).field_msgId));
    }
    com.tencent.mm.ui.base.g.b(this.mContext, this.mContext.getString(R.l.dWV), "", this.mContext.getString(R.l.ebn), this.mContext.getString(R.l.dGk), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        GMTrace.i(18815312199680L, 140185);
        v.i("MicroMsg.MediaHistoryGalleryPresenter", "delete message");
        z.a(e.this.mContext, localTreeSet, new dx()
        {
          public final void a(dx.a paramAnonymous2a)
          {
            GMTrace.i(18815714852864L, 140188);
            if (paramAnonymous2a == dx.a.vLq) {
              e.this.jmq.removeAll(e.5.this.iXE);
            }
            GMTrace.o(18815714852864L, 140188);
          }
          
          public final void b(dx.a paramAnonymous2a)
          {
            GMTrace.i(18815849070592L, 140189);
            v.i("MicroMsg.MediaHistoryGalleryPresenter", "[requestExitSelectedMode] %s del size:%s job:%s", new Object[] { Thread.currentThread(), Integer.valueOf(e.5.this.iXE.size()), paramAnonymous2a });
            if (paramAnonymous2a == dx.a.vLq) {
              e.this.vSs.bWl();
            }
            GMTrace.o(18815849070592L, 140189);
          }
          
          public final void bUu()
          {
            GMTrace.i(18815580635136L, 140187);
            GMTrace.o(18815580635136L, 140187);
          }
          
          public final boolean bUv()
          {
            GMTrace.i(18815983288320L, 140190);
            GMTrace.o(18815983288320L, 140190);
            return true;
          }
        });
        GMTrace.o(18815312199680L, 140185);
      }
    }, null);
    GMTrace.o(14933735505920L, 111265);
  }
  
  public static void cJ(List<au> paramList)
  {
    GMTrace.i(14933869723648L, 111266);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      au localau = (au)paramList.next();
      com.tencent.mm.ui.chatting.a.a(com.tencent.mm.ui.chatting.a.c.vvo, a.d.vvt, localau, 0);
    }
    GMTrace.o(14933869723648L, 111266);
  }
  
  public final void Bc(int paramInt)
  {
    GMTrace.i(14932661764096L, 111257);
    v.i("MicroMsg.MediaHistoryGalleryPresenter", "[handleSelectedItem] type:%s", new Object[] { Integer.valueOf(paramInt) });
    final ArrayList localArrayList = g.a.vPK.vOh;
    switch (paramInt)
    {
    }
    for (;;)
    {
      GMTrace.o(14932661764096L, 111257);
      return;
      this.vSs.bWo();
      final Object localObject1 = new ArrayList();
      Object localObject2 = localArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (au)((Iterator)localObject2).next();
        if ((!b.aT((au)localObject3)) && (!b.aU((au)localObject3))) {
          ((List)localObject1).add(localObject3);
        }
      }
      if (((List)localObject1).size() != localArrayList.size())
      {
        com.tencent.mm.ui.base.g.a(this.mContext, R.l.enK, R.l.dIG, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            GMTrace.i(18815043764224L, 140183);
            e.this.cF(localObject1);
            GMTrace.o(18815043764224L, 140183);
          }
        }, null);
        GMTrace.o(14932661764096L, 111257);
        return;
      }
      cF((List)localObject1);
      GMTrace.o(14932661764096L, 111257);
      return;
      com.tencent.mm.plugin.report.service.g.oSF.a(219L, 18L, 1L, true);
      final Object localObject3 = new cb();
      if (com.tencent.mm.pluginsdk.model.g.a(this.mContext, (cb)localObject3, this.kuX, localArrayList, false))
      {
        b((cb)localObject3);
        cJ(localArrayList);
      }
      for (;;)
      {
        this.vSs.bWl();
        GMTrace.o(14932661764096L, 111257);
        return;
        if (localArrayList.size() > 1)
        {
          Context localContext = this.mContext;
          if (((cb)localObject3).fFr.fFx >= 0)
          {
            localObject1 = this.mContext.getString(R.l.eig);
            label330:
            if (((cb)localObject3).fFr.fFx < 0) {
              break label405;
            }
          }
          label405:
          for (localObject2 = this.mContext.getString(R.l.dXc);; localObject2 = this.mContext.getString(R.l.eFS))
          {
            com.tencent.mm.ui.base.g.b(localContext, (String)localObject1, "", (String)localObject2, this.mContext.getString(R.l.dXa), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                GMTrace.i(18817459683328L, 140201);
                if ((localObject3.fFr.type == 14) && (localObject3.fFr.fFt.txF.size() == 0))
                {
                  GMTrace.o(18817459683328L, 140201);
                  return;
                }
                e.this.b(localObject3);
                e.cJ(localArrayList);
                GMTrace.o(18817459683328L, 140201);
              }
            }, null);
            break;
            localObject1 = this.mContext.getString(R.l.eif);
            break label330;
          }
        }
        com.tencent.mm.ui.base.g.h(this.mContext, ((cb)localObject3).fFr.fFx, 0);
      }
      com.tencent.mm.plugin.report.service.g.oSF.a(219L, 19L, 1L, true);
      boolean bool = this.kuX.toLowerCase().endsWith("@chatroom");
      ab.a(this.mContext, localArrayList, bool, this.kuX, new dx()
      {
        public final void a(dx.a paramAnonymousa)
        {
          GMTrace.i(18816654376960L, 140195);
          GMTrace.o(18816654376960L, 140195);
        }
        
        public final void b(dx.a paramAnonymousa)
        {
          GMTrace.i(18816788594688L, 140196);
          GMTrace.o(18816788594688L, 140196);
        }
        
        public final void bUu()
        {
          GMTrace.i(18816520159232L, 140194);
          GMTrace.o(18816520159232L, 140194);
        }
        
        public final boolean bUv()
        {
          GMTrace.i(18816922812416L, 140197);
          GMTrace.o(18816922812416L, 140197);
          return true;
        }
      });
      this.vSs.bWl();
      GMTrace.o(14932661764096L, 111257);
      return;
      cI(localArrayList);
    }
  }
  
  public final String Oi()
  {
    GMTrace.i(14932527546368L, 111256);
    String str = this.mContext.getString(R.l.dCS);
    GMTrace.o(14932527546368L, 111256);
    return str;
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject)
  {
    GMTrace.i(18819741384704L, 140218);
    GMTrace.o(18819741384704L, 140218);
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, k paramk)
  {
    GMTrace.i(18819472949248L, 140216);
    v.d("MicroMsg.MediaHistoryGalleryPresenter", "[onImgTaskProgress] offset:%s totalLen:%s", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    GMTrace.o(18819472949248L, 140216);
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, String paramString, k paramk)
  {
    GMTrace.i(18819607166976L, 140217);
    v.i("MicroMsg.MediaHistoryGalleryPresenter", "[onImgTaskEnd] mNeedDownloadCount:%s imgLocalId:%s msgLocalId:%s err[%s:%s:%s]", new Object[] { Integer.valueOf(this.vSw), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), paramString });
    if (!this.vSs.bWq())
    {
      GMTrace.o(18819607166976L, 140217);
      return;
    }
    this.vSw -= 1;
    ap.yY();
    paramObject = com.tencent.mm.u.c.wT().cA(paramLong2);
    if (!b.b(this.mContext, (au)paramObject, false)) {
      this.vSx = true;
    }
    if (bXt())
    {
      if (!this.vSx)
      {
        this.mHandler.post(new Runnable()
        {
          public final void run()
          {
            GMTrace.i(18816251723776L, 140192);
            if (e.this.vSs != null) {
              e.this.vSs.bWp();
            }
            GMTrace.o(18816251723776L, 140192);
          }
        });
        GMTrace.o(18819607166976L, 140217);
        return;
      }
      this.mHandler.post(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(18819070296064L, 140213);
          if (e.this.vSs != null) {
            e.this.vSs.Be(R.l.enT);
          }
          GMTrace.o(18819070296064L, 140213);
        }
      });
    }
    GMTrace.o(18819607166976L, 140217);
  }
  
  public final void a(s.a.a parama)
  {
    GMTrace.i(18820009820160L, 140220);
    if (!this.vSs.bWq())
    {
      GMTrace.o(18820009820160L, 140220);
      return;
    }
    r localr = t.lI(parama.fyw);
    v.d("MicroMsg.MediaHistoryGalleryPresenter", "[notifyChanged] mNeedDownloadCount:%s statusType:%s %s", new Object[] { Integer.valueOf(this.vSw), parama.iam, parama.fyw });
    if (localr != null) {
      if (localr.Ll())
      {
        this.vSw -= 1;
        ap.yY();
        parama = com.tencent.mm.u.c.wT().cA(localr.hZW);
        b.a(this.mContext, parama, false);
      }
    }
    while (bXt()) {
      if (this.vSx)
      {
        this.mHandler.post(new Runnable()
        {
          public final void run()
          {
            GMTrace.i(18821486215168L, 140231);
            if (e.this.vSs != null) {
              e.this.vSs.Be(R.l.enT);
            }
            GMTrace.o(18821486215168L, 140231);
          }
        });
        GMTrace.o(18820009820160L, 140220);
        return;
        v.e("MicroMsg.MediaHistoryGalleryPresenter", "[notifyChanged] videoInfo is null!");
        bWn();
        this.vSs.Be(0);
      }
      else
      {
        this.mHandler.post(new Runnable()
        {
          public final void run()
          {
            GMTrace.i(18817057030144L, 140198);
            if (e.this.vSs != null) {
              e.this.vSs.bWp();
            }
            GMTrace.o(18817057030144L, 140198);
          }
        });
      }
    }
    GMTrace.o(18820009820160L, 140220);
  }
  
  public final RecyclerView.a ak(String paramString, long paramLong)
  {
    GMTrace.i(14932393328640L, 111255);
    this.kuX = paramString;
    this.vNv = paramLong;
    if (paramLong == -1L) {}
    for (this.vSt = new com.tencent.mm.ui.chatting.a.a(this.mContext, this.jmq, paramString);; this.vSt = new com.tencent.mm.ui.chatting.a.a(this.mContext, this.jmq, paramString, paramLong))
    {
      this.vSt.vNx = new com.tencent.mm.ui.chatting.a.a.b()
      {
        public final void a(boolean paramAnonymousBoolean, com.tencent.mm.ui.chatting.a.a.c paramAnonymousc, int paramAnonymousInt)
        {
          GMTrace.i(18817191247872L, 140199);
          v.i("MicroMsg.MediaHistoryGalleryPresenter", "[onCheck] isChecked :%s pos:%s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf(paramAnonymousInt) });
          if ((paramAnonymousBoolean) && (g.a.vPK.vOh.size() >= 9))
          {
            Toast.makeText(e.this.mContext, e.this.mContext.getResources().getString(R.l.enO, new Object[] { Integer.valueOf(9) }), 1).show();
            e.this.vSt.bc(paramAnonymousInt);
            GMTrace.o(18817191247872L, 140199);
            return;
          }
          if (paramAnonymousBoolean) {
            g.a.vPK.bh(paramAnonymousc.fTa);
          }
          for (;;)
          {
            e.this.vSs.Bd(g.a.vPK.vOh.size());
            GMTrace.o(18817191247872L, 140199);
            return;
            g.a.vPK.bi(paramAnonymousc.fTa);
          }
        }
      };
      paramString = this.vSt;
      GMTrace.o(14932393328640L, 111255);
      return paramString;
    }
  }
  
  public final void b(cb paramcb)
  {
    GMTrace.i(14934003941376L, 111267);
    paramcb.fFr.fFy = 45;
    paramcb.fFr.activity = ((Activity)this.mContext);
    com.tencent.mm.sdk.b.a.uql.m(paramcb);
    if ((paramcb.fFs.ret == -2) || (paramcb.fFs.ret > 0))
    {
      GMTrace.o(14934003941376L, 111267);
      return;
    }
    if (paramcb.fFs.ret <= 0)
    {
      if (14 != paramcb.fFr.type)
      {
        v.d("MicroMsg.MediaHistoryGalleryPresenter", "not record type, do not report");
        GMTrace.o(14934003941376L, 111267);
        return;
      }
      if (paramcb.fFr.fFu == null)
      {
        v.e("MicroMsg.MediaHistoryGalleryPresenter", "want to report record fav, but type count is null");
        GMTrace.o(14934003941376L, 111267);
        return;
      }
      com.tencent.mm.plugin.report.service.g.oSF.i(11142, new Object[] { Integer.valueOf(paramcb.fFr.fFu.txQ), Integer.valueOf(paramcb.fFr.fFu.txR), Integer.valueOf(paramcb.fFr.fFu.txS), Integer.valueOf(paramcb.fFr.fFu.txT), Integer.valueOf(paramcb.fFr.fFu.txU), Integer.valueOf(paramcb.fFr.fFu.txV), Integer.valueOf(paramcb.fFr.fFu.txW), Integer.valueOf(paramcb.fFr.fFu.txX), Integer.valueOf(paramcb.fFr.fFu.txY), Integer.valueOf(paramcb.fFr.fFu.txZ), Integer.valueOf(paramcb.fFr.fFu.tya), Integer.valueOf(paramcb.fFr.fFu.tyb), Integer.valueOf(paramcb.fFr.fFu.tyc), Integer.valueOf(paramcb.fFr.fFu.tyd), Integer.valueOf(paramcb.fFr.fFu.tye) });
    }
    GMTrace.o(14934003941376L, 111267);
  }
  
  public final void bWG()
  {
    GMTrace.i(14933467070464L, 111263);
    this.vSv = true;
    GMTrace.o(14933467070464L, 111263);
  }
  
  public final int bWj()
  {
    GMTrace.i(14932795981824L, 111258);
    int i = g.a.vPK.vOh.size();
    GMTrace.o(14932795981824L, 111258);
    return i;
  }
  
  public final void bWk()
  {
    GMTrace.i(14932930199552L, 111259);
    this.vSt.vNy = true;
    g.a.vPK.vPI = true;
    GridLayoutManager localGridLayoutManager = (GridLayoutManager)eW(this.mContext);
    int i = localGridLayoutManager.fa();
    int j = localGridLayoutManager.fb();
    this.vSt.b(i, j - i + 1, Integer.valueOf(0));
    GMTrace.o(14932930199552L, 111259);
  }
  
  public final void bWl()
  {
    GMTrace.i(14933064417280L, 111260);
    this.vSt.vNy = false;
    g.a.vPK.clear();
    g.a.vPK.vPI = false;
    this.vSt.aab.notifyChanged();
    GMTrace.o(14933064417280L, 111260);
  }
  
  public final boolean bWm()
  {
    GMTrace.i(14933198635008L, 111261);
    boolean bool = g.a.vPK.vPI;
    GMTrace.o(14933198635008L, 111261);
    return bool;
  }
  
  public final void bWn()
  {
    GMTrace.i(18819875602432L, 140219);
    n.GU().a(this);
    o.KW().a(this);
    this.vSs.bWn();
    GMTrace.o(18819875602432L, 140219);
  }
  
  public final boolean bXt()
  {
    GMTrace.i(18820278255616L, 140222);
    if (this.vSw == 0)
    {
      GMTrace.o(18820278255616L, 140222);
      return true;
    }
    GMTrace.o(18820278255616L, 140222);
    return false;
  }
  
  public final void cF(final List<au> paramList)
  {
    GMTrace.i(18820144037888L, 140221);
    com.tencent.mm.sdk.f.e.post(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(18818264989696L, 140207);
        Object localObject2 = paramList;
        int i;
        Object localObject3;
        label73:
        Object localObject4;
        if (localObject2 == null)
        {
          i = 0;
          if (paramList.size() == i)
          {
            e.this.mHandler.post(new Runnable()
            {
              public final void run()
              {
                GMTrace.i(18814775328768L, 140181);
                e.this.vSs.Be(R.l.enS);
                GMTrace.o(18814775328768L, 140181);
              }
            });
            GMTrace.o(18818264989696L, 140207);
          }
        }
        else
        {
          localObject3 = ((List)localObject2).iterator();
          i = 0;
          for (;;)
          {
            if (((Iterator)localObject3).hasNext())
            {
              localObject1 = (au)((Iterator)localObject3).next();
              if (((au)localObject1).bMj())
              {
                i += 1;
              }
              else if (b.aS((au)localObject1))
              {
                localObject4 = i.bl((au)localObject1);
                if (localObject4 == null) {
                  break label1009;
                }
                v.i("MicroMsg.MediaHistoryGalleryPresenter", "[checkLegal] getStatus:%s", new Object[] { Integer.valueOf(((r)localObject4).status) });
              }
            }
          }
        }
        label296:
        label380:
        label632:
        label703:
        label708:
        label1009:
        for (Object localObject1 = e.c((au)localObject1, (r)localObject4);; localObject1 = null)
        {
          if ((localObject4 == null) || (((r)localObject4).status == 198) || (!FileOp.aO((String)localObject1))) {
            i += 1;
          }
          for (;;)
          {
            break label73;
            localObject4 = com.tencent.mm.ui.chatting.gallery.d.bg((au)localObject1);
            if (localObject4 != null) {
              v.i("MicroMsg.MediaHistoryGalleryPresenter", "[checkLegal] getStatus:%s", new Object[] { Integer.valueOf(((com.tencent.mm.ah.d)localObject4).status) });
            }
            if (((ce)localObject1).field_type == 268435505)
            {
              localObject1 = b.bb((au)localObject1);
              v.i("MicroMsg.MediaHistoryGalleryPresenter", "[checkLegal] is appmsg! null?%s,exists:%s", new Object[] { Boolean.valueOf(bf.mA((String)localObject1)), Boolean.valueOf(new File(bf.ap((String)localObject1, "")).exists()) });
              if (FileOp.aO((String)localObject1)) {
                break label380;
              }
              i += 1;
            }
            for (;;)
            {
              break;
              localObject1 = com.tencent.mm.ui.chatting.gallery.d.a((au)localObject1, (com.tencent.mm.ah.d)localObject4, false);
              v.i("MicroMsg.MediaHistoryGalleryPresenter", "[checkLegal] null?%s,exists:%s", new Object[] { Boolean.valueOf(bf.mA((String)localObject1)), Boolean.valueOf(new File(bf.ap((String)localObject1, "")).exists()) });
              if ((localObject4 == null) || (((com.tencent.mm.ah.d)localObject4).status == -1) || (!FileOp.aO((String)localObject1))) {
                break label296;
              }
            }
            v.i("MicroMsg.MediaHistoryGalleryPresenter", "[checkLegal] count:%s size:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(((List)localObject2).size()) });
            break;
            localObject1 = e.this;
            if (i > 0) {}
            for (boolean bool1 = true;; bool1 = false)
            {
              ((e)localObject1).vSx = bool1;
              localObject2 = e.this.cG(paramList);
              localObject1 = e.this.cH(paramList);
              v.i("MicroMsg.MediaHistoryGalleryPresenter", "[innerHandleSave] needDownloadImageList size:%s needDownloadVideoList:%s", new Object[] { Integer.valueOf(((List)localObject2).size()), Integer.valueOf(((List)localObject1).size()) });
              e.this.vSw = (((List)localObject2).size() + ((List)localObject1).size());
              if ((al.isWifi(aa.getContext())) || (e.this.vSw != paramList.size())) {
                break;
              }
              e.this.mHandler.post(new Runnable()
              {
                public final void run()
                {
                  GMTrace.i(18820949344256L, 140227);
                  e.this.vSs.Be(R.l.enS);
                  GMTrace.o(18820949344256L, 140227);
                }
              });
              GMTrace.o(18818264989696L, 140207);
              return;
            }
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (au)((Iterator)localObject2).next();
              localObject4 = e.this;
              com.tencent.mm.ah.d locald = com.tencent.mm.ui.chatting.gallery.d.bg((au)localObject3);
              if (localObject3 == null)
              {
                bool1 = true;
                if (locald != null) {
                  break label703;
                }
              }
              for (boolean bool2 = true;; bool2 = false)
              {
                v.e("MicroMsg.MediaHistoryGalleryPresenter", "[downloadImg] %s %s ", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
                if (localObject3 == null) {
                  break;
                }
                if (((ce)localObject3).field_type != 268435505) {
                  break label708;
                }
                l.a((au)localObject3, new e.3((e)localObject4, (au)localObject3));
                break;
                bool1 = false;
                break label632;
              }
              if ((locald != null) && (n.GU().a(locald.hEG, ((ce)localObject3).field_msgId, 0, Integer.valueOf(-1), -1, (c.a)localObject4, 0) == -2))
              {
                v.w("MicroMsg.MediaHistoryGalleryPresenter", "[downloadImg] this img has download! %s", new Object[] { locald.hEH });
                ((e)localObject4).vSw -= 1;
                b.b(((e)localObject4).mContext, (au)localObject3, false);
              }
            }
            localObject1 = ((List)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (au)((Iterator)localObject1).next();
              localObject3 = e.this;
              localObject4 = i.bl((au)localObject2);
              if (localObject4 == null)
              {
                v.e("MicroMsg.MediaHistoryGalleryPresenter", "[saveVideo] info == null");
              }
              else
              {
                o.KW().a((s.a)localObject3, Looper.getMainLooper());
                if (((r)localObject4).Lk())
                {
                  v.i("MicroMsg.MediaHistoryGalleryPresenter", "start complete online video");
                  t.lM(((ce)localObject2).field_imgPath);
                }
                else
                {
                  v.i("MicroMsg.MediaHistoryGalleryPresenter", "start complete offline video");
                  t.J(((ce)localObject2).field_imgPath, 10);
                  t.lE(((ce)localObject2).field_imgPath);
                }
              }
            }
            if ((e.this.vSx) && (e.this.vSw == 0)) {
              e.this.mHandler.post(new Runnable()
              {
                public final void run()
                {
                  GMTrace.i(18819338731520L, 140215);
                  e.this.vSs.Be(R.l.enT);
                  GMTrace.o(18819338731520L, 140215);
                }
              });
            }
            if ((e.this.bXt()) && (!e.this.vSx)) {
              e.this.mHandler.post(new Runnable()
              {
                public final void run()
                {
                  GMTrace.i(18821754650624L, 140233);
                  if (e.this.vSs != null) {
                    e.this.vSs.bWp();
                  }
                  GMTrace.o(18821754650624L, 140233);
                }
              });
            }
            GMTrace.o(18818264989696L, 140207);
            return;
          }
        }
      }
    }, "handleSave");
    GMTrace.o(18820144037888L, 140221);
  }
  
  public final LinkedList<au> cG(List<au> paramList)
  {
    GMTrace.i(18820412473344L, 140223);
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      au localau = (au)paramList.next();
      if (b.aR(localau))
      {
        if (!com.tencent.mm.ui.chatting.gallery.d.bg(localau).GB())
        {
          localLinkedList.add(localau);
        }
        else
        {
          this.vSw -= 1;
          b.b(this.mContext, localau, false);
        }
      }
      else if (localau.field_type == 268435505) {
        if ((!bf.mA(b.bb(localau))) && (new File(b.bb(localau)).exists()))
        {
          this.vSw -= 1;
          b.b(this.mContext, localau, false);
        }
        else
        {
          localLinkedList.add(localau);
        }
      }
    }
    GMTrace.o(18820412473344L, 140223);
    return localLinkedList;
  }
  
  public final LinkedList<au> cH(List<au> paramList)
  {
    GMTrace.i(18820546691072L, 140224);
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      au localau = (au)paramList.next();
      if (b.aS(localau)) {
        if (!i.bl(localau).Ll())
        {
          localLinkedList.add(localau);
        }
        else
        {
          this.vSw -= 1;
          b.a(this.mContext, localau, false);
        }
      }
    }
    GMTrace.o(18820546691072L, 140224);
    return localLinkedList;
  }
  
  public final void clear()
  {
    GMTrace.i(14933601288192L, 111264);
    GMTrace.o(14933601288192L, 111264);
  }
  
  public final <T extends RecyclerView.h> T eW(Context paramContext)
  {
    GMTrace.i(14932124893184L, 111253);
    if (this.vSu == null)
    {
      this.vSu = new GridLayoutManager(paramContext, 4);
      this.vSu.WL = new GridLayoutManager.b()
      {
        public final int aT(int paramAnonymousInt)
        {
          GMTrace.i(14946888843264L, 111363);
          if (((com.tencent.mm.ui.chatting.a.a.c)e.this.jmq.get(paramAnonymousInt)).type == Integer.MAX_VALUE)
          {
            GMTrace.o(14946888843264L, 111363);
            return 4;
          }
          GMTrace.o(14946888843264L, 111363);
          return 1;
        }
      };
    }
    paramContext = this.vSu;
    GMTrace.o(14932124893184L, 111253);
    return paramContext;
  }
  
  public final RecyclerView.g eX(final Context paramContext)
  {
    GMTrace.i(14932259110912L, 111254);
    paramContext = new RecyclerView.g()
    {
      public final void a(Rect paramAnonymousRect, View paramAnonymousView, RecyclerView paramAnonymousRecyclerView)
      {
        GMTrace.i(14940580610048L, 111316);
        int i = (int)paramContext.getResources().getDimension(R.f.aXI);
        paramAnonymousRect.bottom = i;
        paramAnonymousRect.top = i;
        paramAnonymousRect.left = i;
        paramAnonymousRect.right = i;
        GMTrace.o(14940580610048L, 111316);
      }
    };
    GMTrace.o(14932259110912L, 111254);
    return paramContext;
  }
  
  public final void onDetach()
  {
    GMTrace.i(14931990675456L, 111252);
    this.vHY.dead();
    this.vSs.a(null);
    this.vSs = null;
    n.GU().a(this);
    o.KW().a(this);
    g.a.vPK.detach();
    GMTrace.o(14931990675456L, 111252);
  }
  
  public final void onResume()
  {
    GMTrace.i(14933332852736L, 111262);
    if ((this.vSv) && (g.a.vPK.vPI))
    {
      this.vSs.Bd(g.a.vPK.vOh.size());
      this.vSt.aab.notifyChanged();
    }
    GMTrace.o(14933332852736L, 111262);
  }
  
  public final void r(final boolean paramBoolean, final int paramInt)
  {
    GMTrace.i(14934138159104L, 111268);
    if ((!paramBoolean) && (this.kTl + this.vSo == this.jmq.size()))
    {
      v.i("MicroMsg.MediaHistoryGalleryPresenter", "[loadData] that's all msg :%s offset:%s", new Object[] { Integer.valueOf(this.kTl), Integer.valueOf(paramInt) });
      GMTrace.o(14934138159104L, 111268);
      return;
    }
    this.vSt.vNw = true;
    this.vSs.ln(paramBoolean);
    h.vJ();
    h.vL().D(new Runnable()
    {
      /* Error */
      public final void run()
      {
        // Byte code:
        //   0: ldc2_w 45
        //   3: ldc 47
        //   5: invokestatic 39	com/tencent/gmtrace/GMTrace:i	(JI)V
        //   8: aload_0
        //   9: getfield 25	com/tencent/mm/ui/chatting/c/e$7:vRY	Z
        //   12: ifeq +47 -> 59
        //   15: aload_0
        //   16: getfield 23	com/tencent/mm/ui/chatting/c/e$7:vSy	Lcom/tencent/mm/ui/chatting/c/e;
        //   19: getfield 51	com/tencent/mm/ui/chatting/c/e:vNv	J
        //   22: ldc2_w 52
        //   25: lcmp
        //   26: ifne +278 -> 304
        //   29: aload_0
        //   30: getfield 23	com/tencent/mm/ui/chatting/c/e$7:vSy	Lcom/tencent/mm/ui/chatting/c/e;
        //   33: astore 7
        //   35: invokestatic 59	com/tencent/mm/u/ap:yY	()Lcom/tencent/mm/u/c;
        //   38: pop
        //   39: aload 7
        //   41: invokestatic 65	com/tencent/mm/u/c:wT	()Lcom/tencent/mm/plugin/messenger/foundation/a/a/c;
        //   44: aload_0
        //   45: getfield 23	com/tencent/mm/ui/chatting/c/e$7:vSy	Lcom/tencent/mm/ui/chatting/c/e;
        //   48: getfield 69	com/tencent/mm/ui/chatting/c/e:kuX	Ljava/lang/String;
        //   51: invokeinterface 75 2 0
        //   56: putfield 78	com/tencent/mm/ui/chatting/c/e:kTl	I
        //   59: aload_0
        //   60: getfield 27	com/tencent/mm/ui/chatting/c/e$7:hyF	I
        //   63: iflt +279 -> 342
        //   66: aload_0
        //   67: getfield 23	com/tencent/mm/ui/chatting/c/e$7:vSy	Lcom/tencent/mm/ui/chatting/c/e;
        //   70: getfield 78	com/tencent/mm/ui/chatting/c/e:kTl	I
        //   73: aload_0
        //   74: getfield 27	com/tencent/mm/ui/chatting/c/e$7:hyF	I
        //   77: isub
        //   78: sipush 200
        //   81: if_icmple +261 -> 342
        //   84: aload_0
        //   85: getfield 23	com/tencent/mm/ui/chatting/c/e$7:vSy	Lcom/tencent/mm/ui/chatting/c/e;
        //   88: getfield 78	com/tencent/mm/ui/chatting/c/e:kTl	I
        //   91: aload_0
        //   92: getfield 27	com/tencent/mm/ui/chatting/c/e$7:hyF	I
        //   95: isub
        //   96: istore_1
        //   97: ldc 80
        //   99: ldc 82
        //   101: iconst_2
        //   102: anewarray 4	java/lang/Object
        //   105: dup
        //   106: iconst_0
        //   107: aload_0
        //   108: getfield 27	com/tencent/mm/ui/chatting/c/e$7:hyF	I
        //   111: invokestatic 88	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   114: aastore
        //   115: dup
        //   116: iconst_1
        //   117: iload_1
        //   118: invokestatic 88	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   121: aastore
        //   122: invokestatic 93	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   125: new 95	java/util/LinkedList
        //   128: dup
        //   129: invokespecial 96	java/util/LinkedList:<init>	()V
        //   132: astore 8
        //   134: aload_0
        //   135: getfield 23	com/tencent/mm/ui/chatting/c/e$7:vSy	Lcom/tencent/mm/ui/chatting/c/e;
        //   138: getfield 51	com/tencent/mm/ui/chatting/c/e:vNv	J
        //   141: ldc2_w 52
        //   144: lcmp
        //   145: ifne +204 -> 349
        //   148: invokestatic 59	com/tencent/mm/u/ap:yY	()Lcom/tencent/mm/u/c;
        //   151: pop
        //   152: invokestatic 65	com/tencent/mm/u/c:wT	()Lcom/tencent/mm/plugin/messenger/foundation/a/a/c;
        //   155: aload_0
        //   156: getfield 23	com/tencent/mm/ui/chatting/c/e$7:vSy	Lcom/tencent/mm/ui/chatting/c/e;
        //   159: getfield 69	com/tencent/mm/ui/chatting/c/e:kuX	Ljava/lang/String;
        //   162: aload_0
        //   163: getfield 23	com/tencent/mm/ui/chatting/c/e$7:vSy	Lcom/tencent/mm/ui/chatting/c/e;
        //   166: getfield 100	com/tencent/mm/ui/chatting/c/e:jmq	Ljava/util/ArrayList;
        //   169: invokevirtual 106	java/util/ArrayList:size	()I
        //   172: aload_0
        //   173: getfield 23	com/tencent/mm/ui/chatting/c/e$7:vSy	Lcom/tencent/mm/ui/chatting/c/e;
        //   176: getfield 109	com/tencent/mm/ui/chatting/c/e:vSo	I
        //   179: isub
        //   180: iload_1
        //   181: invokeinterface 113 4 0
        //   186: astore 7
        //   188: lconst_0
        //   189: lstore_3
        //   190: aload 7
        //   192: invokeinterface 119 1 0
        //   197: ifeq +200 -> 397
        //   200: new 121	com/tencent/mm/storage/au
        //   203: dup
        //   204: invokespecial 122	com/tencent/mm/storage/au:<init>	()V
        //   207: astore 9
        //   209: aload 9
        //   211: aload 7
        //   213: invokevirtual 126	com/tencent/mm/storage/au:b	(Landroid/database/Cursor;)V
        //   216: new 128	java/util/Date
        //   219: dup
        //   220: aload 9
        //   222: getfield 133	com/tencent/mm/e/b/ce:field_createTime	J
        //   225: invokespecial 136	java/util/Date:<init>	(J)V
        //   228: astore 10
        //   230: invokestatic 142	com/tencent/mm/ui/gridviewheaders/a:bYY	()Lcom/tencent/mm/ui/gridviewheaders/a;
        //   233: aload 10
        //   235: invokevirtual 146	com/tencent/mm/ui/gridviewheaders/a:a	(Ljava/util/Date;)J
        //   238: lstore 5
        //   240: lload_3
        //   241: lload 5
        //   243: lcmp
        //   244: ifeq +39 -> 283
        //   247: aload 8
        //   249: new 148	com/tencent/mm/ui/chatting/a/a$c
        //   252: dup
        //   253: aload 9
        //   255: getfield 133	com/tencent/mm/e/b/ce:field_createTime	J
        //   258: invokespecial 149	com/tencent/mm/ui/chatting/a/a$c:<init>	(J)V
        //   261: invokevirtual 153	java/util/LinkedList:add	(Ljava/lang/Object;)Z
        //   264: pop
        //   265: aload_0
        //   266: getfield 23	com/tencent/mm/ui/chatting/c/e$7:vSy	Lcom/tencent/mm/ui/chatting/c/e;
        //   269: astore 10
        //   271: aload 10
        //   273: aload 10
        //   275: getfield 109	com/tencent/mm/ui/chatting/c/e:vSo	I
        //   278: iconst_1
        //   279: iadd
        //   280: putfield 109	com/tencent/mm/ui/chatting/c/e:vSo	I
        //   283: aload 8
        //   285: new 148	com/tencent/mm/ui/chatting/a/a$c
        //   288: dup
        //   289: aload 9
        //   291: invokespecial 156	com/tencent/mm/ui/chatting/a/a$c:<init>	(Lcom/tencent/mm/storage/au;)V
        //   294: invokevirtual 153	java/util/LinkedList:add	(Ljava/lang/Object;)Z
        //   297: pop
        //   298: lload 5
        //   300: lstore_3
        //   301: goto -111 -> 190
        //   304: aload_0
        //   305: getfield 23	com/tencent/mm/ui/chatting/c/e$7:vSy	Lcom/tencent/mm/ui/chatting/c/e;
        //   308: astore 7
        //   310: invokestatic 59	com/tencent/mm/u/ap:yY	()Lcom/tencent/mm/u/c;
        //   313: pop
        //   314: aload 7
        //   316: invokestatic 160	com/tencent/mm/u/c:wU	()Lcom/tencent/mm/storage/o;
        //   319: aload_0
        //   320: getfield 23	com/tencent/mm/ui/chatting/c/e$7:vSy	Lcom/tencent/mm/ui/chatting/c/e;
        //   323: getfield 69	com/tencent/mm/ui/chatting/c/e:kuX	Ljava/lang/String;
        //   326: aload_0
        //   327: getfield 23	com/tencent/mm/ui/chatting/c/e$7:vSy	Lcom/tencent/mm/ui/chatting/c/e;
        //   330: getfield 51	com/tencent/mm/ui/chatting/c/e:vNv	J
        //   333: invokevirtual 166	com/tencent/mm/storage/o:ai	(Ljava/lang/String;J)I
        //   336: putfield 78	com/tencent/mm/ui/chatting/c/e:kTl	I
        //   339: goto -280 -> 59
        //   342: sipush 200
        //   345: istore_1
        //   346: goto -249 -> 97
        //   349: invokestatic 59	com/tencent/mm/u/ap:yY	()Lcom/tencent/mm/u/c;
        //   352: pop
        //   353: invokestatic 160	com/tencent/mm/u/c:wU	()Lcom/tencent/mm/storage/o;
        //   356: aload_0
        //   357: getfield 23	com/tencent/mm/ui/chatting/c/e$7:vSy	Lcom/tencent/mm/ui/chatting/c/e;
        //   360: getfield 69	com/tencent/mm/ui/chatting/c/e:kuX	Ljava/lang/String;
        //   363: aload_0
        //   364: getfield 23	com/tencent/mm/ui/chatting/c/e$7:vSy	Lcom/tencent/mm/ui/chatting/c/e;
        //   367: getfield 51	com/tencent/mm/ui/chatting/c/e:vNv	J
        //   370: aload_0
        //   371: getfield 23	com/tencent/mm/ui/chatting/c/e$7:vSy	Lcom/tencent/mm/ui/chatting/c/e;
        //   374: getfield 100	com/tencent/mm/ui/chatting/c/e:jmq	Ljava/util/ArrayList;
        //   377: invokevirtual 106	java/util/ArrayList:size	()I
        //   380: aload_0
        //   381: getfield 23	com/tencent/mm/ui/chatting/c/e$7:vSy	Lcom/tencent/mm/ui/chatting/c/e;
        //   384: getfield 109	com/tencent/mm/ui/chatting/c/e:vSo	I
        //   387: isub
        //   388: iload_1
        //   389: invokevirtual 169	com/tencent/mm/storage/o:b	(Ljava/lang/String;JII)Landroid/database/Cursor;
        //   392: astore 7
        //   394: goto -206 -> 188
        //   397: aload 7
        //   399: invokeinterface 172 1 0
        //   404: new 95	java/util/LinkedList
        //   407: dup
        //   408: invokespecial 96	java/util/LinkedList:<init>	()V
        //   411: astore 9
        //   413: aload 8
        //   415: invokevirtual 173	java/util/LinkedList:size	()I
        //   418: aload_0
        //   419: getfield 23	com/tencent/mm/ui/chatting/c/e$7:vSy	Lcom/tencent/mm/ui/chatting/c/e;
        //   422: getfield 109	com/tencent/mm/ui/chatting/c/e:vSo	I
        //   425: isub
        //   426: iload_1
        //   427: if_icmpne +330 -> 757
        //   430: aload 8
        //   432: iconst_0
        //   433: invokevirtual 177	java/util/LinkedList:get	(I)Ljava/lang/Object;
        //   436: checkcast 148	com/tencent/mm/ui/chatting/a/a$c
        //   439: getfield 180	com/tencent/mm/ui/chatting/a/a$c:hTb	J
        //   442: lstore_3
        //   443: invokestatic 142	com/tencent/mm/ui/gridviewheaders/a:bYY	()Lcom/tencent/mm/ui/gridviewheaders/a;
        //   446: pop
        //   447: lload_3
        //   448: invokestatic 184	com/tencent/mm/ui/gridviewheaders/a:eX	(J)J
        //   451: lstore 5
        //   453: ldc 80
        //   455: ldc -70
        //   457: iconst_3
        //   458: anewarray 4	java/lang/Object
        //   461: dup
        //   462: iconst_0
        //   463: aload 8
        //   465: invokevirtual 173	java/util/LinkedList:size	()I
        //   468: invokestatic 88	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   471: aastore
        //   472: dup
        //   473: iconst_1
        //   474: lload 5
        //   476: invokestatic 191	java/lang/Long:valueOf	(J)Ljava/lang/Long;
        //   479: aastore
        //   480: dup
        //   481: iconst_2
        //   482: lload_3
        //   483: invokestatic 191	java/lang/Long:valueOf	(J)Ljava/lang/Long;
        //   486: aastore
        //   487: invokestatic 93	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   490: aload_0
        //   491: getfield 23	com/tencent/mm/ui/chatting/c/e$7:vSy	Lcom/tencent/mm/ui/chatting/c/e;
        //   494: getfield 51	com/tencent/mm/ui/chatting/c/e:vNv	J
        //   497: ldc2_w 52
        //   500: lcmp
        //   501: ifne +186 -> 687
        //   504: invokestatic 59	com/tencent/mm/u/ap:yY	()Lcom/tencent/mm/u/c;
        //   507: pop
        //   508: invokestatic 65	com/tencent/mm/u/c:wT	()Lcom/tencent/mm/plugin/messenger/foundation/a/a/c;
        //   511: aload_0
        //   512: getfield 23	com/tencent/mm/ui/chatting/c/e$7:vSy	Lcom/tencent/mm/ui/chatting/c/e;
        //   515: getfield 69	com/tencent/mm/ui/chatting/c/e:kuX	Ljava/lang/String;
        //   518: lload 5
        //   520: lload_3
        //   521: invokeinterface 195 6 0
        //   526: astore 7
        //   528: new 128	java/util/Date
        //   531: dup
        //   532: lload_3
        //   533: invokespecial 136	java/util/Date:<init>	(J)V
        //   536: astore 10
        //   538: invokestatic 142	com/tencent/mm/ui/gridviewheaders/a:bYY	()Lcom/tencent/mm/ui/gridviewheaders/a;
        //   541: aload 10
        //   543: invokevirtual 146	com/tencent/mm/ui/gridviewheaders/a:a	(Ljava/util/Date;)J
        //   546: lstore_3
        //   547: aload 7
        //   549: invokeinterface 119 1 0
        //   554: ifeq +196 -> 750
        //   557: new 121	com/tencent/mm/storage/au
        //   560: dup
        //   561: invokespecial 122	com/tencent/mm/storage/au:<init>	()V
        //   564: astore 11
        //   566: aload 11
        //   568: aload 7
        //   570: invokevirtual 126	com/tencent/mm/storage/au:b	(Landroid/database/Cursor;)V
        //   573: new 128	java/util/Date
        //   576: dup
        //   577: aload 11
        //   579: getfield 133	com/tencent/mm/e/b/ce:field_createTime	J
        //   582: invokespecial 136	java/util/Date:<init>	(J)V
        //   585: astore 12
        //   587: invokestatic 142	com/tencent/mm/ui/gridviewheaders/a:bYY	()Lcom/tencent/mm/ui/gridviewheaders/a;
        //   590: aload 12
        //   592: invokevirtual 146	com/tencent/mm/ui/gridviewheaders/a:a	(Ljava/util/Date;)J
        //   595: lstore 5
        //   597: lload_3
        //   598: lload 5
        //   600: lcmp
        //   601: ifeq +118 -> 719
        //   604: invokestatic 142	com/tencent/mm/ui/gridviewheaders/a:bYY	()Lcom/tencent/mm/ui/gridviewheaders/a;
        //   607: aload 10
        //   609: invokevirtual 146	com/tencent/mm/ui/gridviewheaders/a:a	(Ljava/util/Date;)J
        //   612: lload 5
        //   614: lcmp
        //   615: ifeq +104 -> 719
        //   618: aload 9
        //   620: new 148	com/tencent/mm/ui/chatting/a/a$c
        //   623: dup
        //   624: aload 11
        //   626: getfield 133	com/tencent/mm/e/b/ce:field_createTime	J
        //   629: invokespecial 149	com/tencent/mm/ui/chatting/a/a$c:<init>	(J)V
        //   632: invokevirtual 153	java/util/LinkedList:add	(Ljava/lang/Object;)Z
        //   635: pop
        //   636: aload_0
        //   637: getfield 23	com/tencent/mm/ui/chatting/c/e$7:vSy	Lcom/tencent/mm/ui/chatting/c/e;
        //   640: astore 12
        //   642: aload 12
        //   644: aload 12
        //   646: getfield 109	com/tencent/mm/ui/chatting/c/e:vSo	I
        //   649: iconst_1
        //   650: iadd
        //   651: putfield 109	com/tencent/mm/ui/chatting/c/e:vSo	I
        //   654: lload 5
        //   656: lstore_3
        //   657: aload 9
        //   659: new 148	com/tencent/mm/ui/chatting/a/a$c
        //   662: dup
        //   663: aload 11
        //   665: invokespecial 156	com/tencent/mm/ui/chatting/a/a$c:<init>	(Lcom/tencent/mm/storage/au;)V
        //   668: invokevirtual 153	java/util/LinkedList:add	(Ljava/lang/Object;)Z
        //   671: pop
        //   672: goto -125 -> 547
        //   675: astore 8
        //   677: aload 7
        //   679: invokeinterface 172 1 0
        //   684: aload 8
        //   686: athrow
        //   687: invokestatic 59	com/tencent/mm/u/ap:yY	()Lcom/tencent/mm/u/c;
        //   690: pop
        //   691: invokestatic 160	com/tencent/mm/u/c:wU	()Lcom/tencent/mm/storage/o;
        //   694: aload_0
        //   695: getfield 23	com/tencent/mm/ui/chatting/c/e$7:vSy	Lcom/tencent/mm/ui/chatting/c/e;
        //   698: getfield 69	com/tencent/mm/ui/chatting/c/e:kuX	Ljava/lang/String;
        //   701: aload_0
        //   702: getfield 23	com/tencent/mm/ui/chatting/c/e$7:vSy	Lcom/tencent/mm/ui/chatting/c/e;
        //   705: getfield 51	com/tencent/mm/ui/chatting/c/e:vNv	J
        //   708: lload 5
        //   710: lload_3
        //   711: invokevirtual 198	com/tencent/mm/storage/o:a	(Ljava/lang/String;JJJ)Landroid/database/Cursor;
        //   714: astore 7
        //   716: goto -188 -> 528
        //   719: aload 8
        //   721: invokevirtual 173	java/util/LinkedList:size	()I
        //   724: ifle +23 -> 747
        //   727: aload 9
        //   729: invokevirtual 173	java/util/LinkedList:size	()I
        //   732: ifne +15 -> 747
        //   735: aload 9
        //   737: iconst_0
        //   738: aload 8
        //   740: iconst_0
        //   741: invokevirtual 201	java/util/LinkedList:remove	(I)Ljava/lang/Object;
        //   744: invokevirtual 204	java/util/LinkedList:add	(ILjava/lang/Object;)V
        //   747: goto -90 -> 657
        //   750: aload 7
        //   752: invokeinterface 172 1 0
        //   757: aload 8
        //   759: invokevirtual 173	java/util/LinkedList:size	()I
        //   762: istore_1
        //   763: aload 9
        //   765: invokevirtual 173	java/util/LinkedList:size	()I
        //   768: istore_2
        //   769: aload_0
        //   770: getfield 23	com/tencent/mm/ui/chatting/c/e$7:vSy	Lcom/tencent/mm/ui/chatting/c/e;
        //   773: getfield 100	com/tencent/mm/ui/chatting/c/e:jmq	Ljava/util/ArrayList;
        //   776: iconst_0
        //   777: aload 9
        //   779: invokevirtual 208	java/util/ArrayList:addAll	(ILjava/util/Collection;)Z
        //   782: pop
        //   783: aload_0
        //   784: getfield 23	com/tencent/mm/ui/chatting/c/e$7:vSy	Lcom/tencent/mm/ui/chatting/c/e;
        //   787: getfield 100	com/tencent/mm/ui/chatting/c/e:jmq	Ljava/util/ArrayList;
        //   790: aload 9
        //   792: invokevirtual 173	java/util/LinkedList:size	()I
        //   795: aload 8
        //   797: invokevirtual 208	java/util/ArrayList:addAll	(ILjava/util/Collection;)Z
        //   800: pop
        //   801: aload 8
        //   803: invokevirtual 211	java/util/LinkedList:clear	()V
        //   806: aload 9
        //   808: invokevirtual 211	java/util/LinkedList:clear	()V
        //   811: aload_0
        //   812: getfield 23	com/tencent/mm/ui/chatting/c/e$7:vSy	Lcom/tencent/mm/ui/chatting/c/e;
        //   815: iconst_0
        //   816: putfield 109	com/tencent/mm/ui/chatting/c/e:vSo	I
        //   819: ldc 80
        //   821: ldc -43
        //   823: iconst_1
        //   824: anewarray 4	java/lang/Object
        //   827: dup
        //   828: iconst_0
        //   829: aload_0
        //   830: getfield 23	com/tencent/mm/ui/chatting/c/e$7:vSy	Lcom/tencent/mm/ui/chatting/c/e;
        //   833: getfield 100	com/tencent/mm/ui/chatting/c/e:jmq	Ljava/util/ArrayList;
        //   836: invokevirtual 106	java/util/ArrayList:size	()I
        //   839: invokestatic 88	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   842: aastore
        //   843: invokestatic 93	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   846: new 13	com/tencent/mm/ui/chatting/c/e$7$1
        //   849: dup
        //   850: aload_0
        //   851: iload_1
        //   852: iload_2
        //   853: iadd
        //   854: invokespecial 216	com/tencent/mm/ui/chatting/c/e$7$1:<init>	(Lcom/tencent/mm/ui/chatting/c/e$7;I)V
        //   857: invokestatic 222	com/tencent/mm/sdk/platformtools/ae:v	(Ljava/lang/Runnable;)V
        //   860: ldc2_w 45
        //   863: ldc 47
        //   865: invokestatic 42	com/tencent/gmtrace/GMTrace:o	(JI)V
        //   868: return
        //   869: astore 8
        //   871: aload 7
        //   873: invokeinterface 172 1 0
        //   878: aload 8
        //   880: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	881	0	this	7
        //   96	758	1	i	int
        //   768	86	2	j	int
        //   189	522	3	l1	long
        //   238	471	5	l2	long
        //   33	839	7	localObject1	Object
        //   132	332	8	localLinkedList	LinkedList
        //   675	127	8	localCollection	java.util.Collection
        //   869	10	8	localObject2	Object
        //   207	600	9	localObject3	Object
        //   228	380	10	localObject4	Object
        //   564	100	11	localau	au
        //   585	60	12	localObject5	Object
        // Exception table:
        //   from	to	target	type
        //   190	240	675	finally
        //   247	283	675	finally
        //   283	298	675	finally
        //   547	597	869	finally
        //   604	654	869	finally
        //   657	672	869	finally
        //   719	747	869	finally
      }
    });
    GMTrace.o(14934138159104L, 111268);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/c/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */