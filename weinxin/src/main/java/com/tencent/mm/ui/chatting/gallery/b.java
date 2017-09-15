package com.tencent.mm.ui.chatting.gallery;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.c.a;
import com.tencent.mm.ah.f;
import com.tencent.mm.e.a.cb;
import com.tencent.mm.e.a.cb.b;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.model.app.l.a;
import com.tencent.mm.protocal.c.bdq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.f.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bm;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI;
import com.tencent.mm.ui.chatting.En_5b8fbb1e;
import com.tencent.mm.ui.chatting.a.c;
import com.tencent.mm.ui.chatting.a.d;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

@SuppressLint({"UseSparseArrays"})
public final class b
  extends com.tencent.mm.ui.base.t
{
  public static long jZq;
  public static boolean sLe;
  public ImageGalleryUI vNW;
  protected a vNX;
  private String vNY;
  boolean vNZ;
  public boolean vOa;
  public d vOb;
  public i vOc;
  public h vOd;
  public c vOe;
  boolean vOf;
  protected boolean vOg;
  private ArrayList<au> vOh;
  
  static
  {
    GMTrace.i(2419811418112L, 18029);
    jZq = -1L;
    sLe = false;
    GMTrace.o(2419811418112L, 18029);
  }
  
  public b(ImageGalleryUI paramImageGalleryUI, long paramLong1, String paramString1, boolean paramBoolean1, long paramLong2, boolean paramBoolean2, String paramString2, Boolean paramBoolean)
  {
    GMTrace.i(2414040055808L, 17986);
    this.vNZ = true;
    this.vOa = false;
    this.vOg = true;
    this.vOh = new ArrayList();
    String str = "MicroMsg.ImageGalleryAdapter, invalid argument, context = " + paramImageGalleryUI + ", currentMsgId = " + paramLong1 + ", talker = " + paramString1 + ", stack = " + bf.bJP();
    if ((paramImageGalleryUI != null) && (paramLong1 > 0L) && (paramString1 != null) && (paramString1.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(str, bool);
      this.vNW = paramImageGalleryUI;
      sLe = paramBoolean1;
      jZq = paramLong2;
      this.vNX = new a(paramLong1, paramString1, this, paramBoolean);
      this.vOa = paramBoolean2;
      this.vNY = paramString2;
      this.vOb = new d(this);
      this.vOc = new i(this);
      this.vOd = new h(this);
      GMTrace.o(2414040055808L, 17986);
      return;
    }
  }
  
  public static boolean a(Context paramContext, au paramau, boolean paramBoolean)
  {
    GMTrace.i(15333838553088L, 114246);
    if (paramau == null)
    {
      GMTrace.o(15333838553088L, 114246);
      return false;
    }
    r localr = com.tencent.mm.modelvideo.o.KW().lt(paramau.field_imgPath);
    boolean bool = false;
    if (localr != null)
    {
      int i = 0;
      if (com.tencent.mm.u.o.dH(localr.Lf())) {
        i = com.tencent.mm.u.j.eC(localr.Lf());
      }
      bool = localr.Ll();
      com.tencent.mm.plugin.report.service.g.oSF.a(106L, 216L, 1L, false);
      com.tencent.mm.plugin.report.service.g.oSF.i(12084, new Object[] { Integer.valueOf(localr.hrb), Integer.valueOf(localr.hZV * 1000), Integer.valueOf(0), Integer.valueOf(2), localr.Lf(), Integer.valueOf(i), r.ls(localr.Li()), Long.valueOf(localr.hZS) });
    }
    if (!bool)
    {
      v.w("MicroMsg.ImageGalleryAdapter", "do export video but video had not download finish.");
      if (paramBoolean) {
        Toast.makeText(paramContext, paramContext.getString(R.l.fad), 1).show();
      }
      GMTrace.o(15333838553088L, 114246);
      return false;
    }
    com.tencent.mm.modelvideo.o.KW();
    paramau = com.tencent.mm.modelvideo.t.lJ(com.tencent.mm.modelvideo.s.lw(paramau.field_imgPath));
    if (bf.mA(paramau))
    {
      if (paramBoolean) {
        Toast.makeText(paramContext, paramContext.getString(R.l.fad), 1).show();
      }
      GMTrace.o(15333838553088L, 114246);
      return false;
    }
    if (paramBoolean) {
      Toast.makeText(paramContext, paramContext.getString(R.l.fae, new Object[] { paramau }), 1).show();
    }
    com.tencent.mm.pluginsdk.ui.tools.k.b(paramau, paramContext);
    GMTrace.o(15333838553088L, 114246);
    return true;
  }
  
  public static boolean a(au paramau, com.tencent.mm.ah.d paramd)
  {
    GMTrace.i(2415650668544L, 17998);
    if ((paramau == null) || (paramd == null))
    {
      GMTrace.o(2415650668544L, 17998);
      return false;
    }
    boolean bool = com.tencent.mm.ah.n.GU().a(paramd.hEG, paramau.field_msgId, 1);
    GMTrace.o(2415650668544L, 17998);
    return bool;
  }
  
  public static boolean aR(au paramau)
  {
    GMTrace.i(2414845362176L, 17992);
    if (paramau == null)
    {
      GMTrace.o(2414845362176L, 17992);
      return false;
    }
    if ((paramau.field_type == 3) || (paramau.field_type == 39) || (paramau.field_type == 13))
    {
      GMTrace.o(2414845362176L, 17992);
      return true;
    }
    GMTrace.o(2414845362176L, 17992);
    return false;
  }
  
  public static boolean aS(au paramau)
  {
    GMTrace.i(2414979579904L, 17993);
    if (paramau == null)
    {
      GMTrace.o(2414979579904L, 17993);
      return false;
    }
    if (aY(paramau))
    {
      GMTrace.o(2414979579904L, 17993);
      return false;
    }
    if ((paramau.field_type == 43) || (paramau.field_type == 44) || (paramau.field_type == 62))
    {
      GMTrace.o(2414979579904L, 17993);
      return true;
    }
    GMTrace.o(2414979579904L, 17993);
    return false;
  }
  
  public static boolean aT(au paramau)
  {
    GMTrace.i(2415113797632L, 17994);
    if (paramau == null)
    {
      GMTrace.o(2415113797632L, 17994);
      return false;
    }
    if (paramau.field_type == 62)
    {
      GMTrace.o(2415113797632L, 17994);
      return true;
    }
    GMTrace.o(2415113797632L, 17994);
    return false;
  }
  
  public static boolean aU(au paramau)
  {
    GMTrace.i(2415248015360L, 17995);
    if (paramau == null)
    {
      GMTrace.o(2415248015360L, 17995);
      return false;
    }
    if (paramau.field_type == 49)
    {
      GMTrace.o(2415248015360L, 17995);
      return true;
    }
    GMTrace.o(2415248015360L, 17995);
    return false;
  }
  
  public static boolean aV(au paramau)
  {
    GMTrace.i(2415382233088L, 17996);
    if (paramau == null)
    {
      GMTrace.o(2415382233088L, 17996);
      return false;
    }
    if (paramau.field_type == 268435505)
    {
      GMTrace.o(2415382233088L, 17996);
      return true;
    }
    GMTrace.o(2415382233088L, 17996);
    return false;
  }
  
  public static b aX(au paramau)
  {
    GMTrace.i(2416053321728L, 18001);
    b localb = b.vOB;
    if (paramau == null) {
      localb = b.vOB;
    }
    if (aV(paramau))
    {
      paramau = b.vOF;
      GMTrace.o(2416053321728L, 18001);
      return paramau;
    }
    if (aR(paramau))
    {
      paramau = b.vOC;
      GMTrace.o(2416053321728L, 18001);
      return paramau;
    }
    if (aY(paramau))
    {
      paramau = b.vOE;
      GMTrace.o(2416053321728L, 18001);
      return paramau;
    }
    if (aS(paramau))
    {
      paramau = b.vOD;
      GMTrace.o(2416053321728L, 18001);
      return paramau;
    }
    if (aT(paramau))
    {
      paramau = b.vOD;
      GMTrace.o(2416053321728L, 18001);
      return paramau;
    }
    paramau = b.vOB;
    GMTrace.o(2416053321728L, 18001);
    return paramau;
  }
  
  private static boolean aY(au paramau)
  {
    GMTrace.i(2416187539456L, 18002);
    if (paramau != null)
    {
      paramau = com.tencent.mm.modelvideo.t.lI(paramau.field_imgPath);
      if ((paramau != null) && (paramau.iae != null) && ((!bf.mA(paramau.iae.hjt)) || (paramau.iae.txr > 0) || (!bf.mA(paramau.iae.hjw)) || (!bf.mA(paramau.iae.hjx)) || (!bf.mA(paramau.iae.hjv)) || (!bf.mA(paramau.iae.hjy)) || (!bf.mA(paramau.iae.hjz)) || (!bf.mA(paramau.iae.hjA))))
      {
        GMTrace.o(2416187539456L, 18002);
        return true;
      }
    }
    GMTrace.o(2416187539456L, 18002);
    return false;
  }
  
  public static int b(au paramau, com.tencent.mm.ah.d paramd)
  {
    GMTrace.i(2417529716736L, 18012);
    if (paramau.field_isSend == 1)
    {
      if (paramd.GC())
      {
        paramau = com.tencent.mm.ah.e.a(paramd);
        if ((paramau != null) && (paramau.hEG > 0L) && (paramau.GB()) && (com.tencent.mm.a.e.aO(com.tencent.mm.ah.n.GT().m(paramau.hEH, "", ""))))
        {
          GMTrace.o(2417529716736L, 18012);
          return 1;
        }
      }
      GMTrace.o(2417529716736L, 18012);
      return 0;
    }
    if (paramd.GB())
    {
      if (paramd.GC())
      {
        paramau = com.tencent.mm.ah.e.a(paramd);
        if ((paramau != null) && (paramau.hEG > 0L) && (paramau.GB()) && (com.tencent.mm.a.e.aO(com.tencent.mm.ah.n.GT().m(paramau.hEH, "", ""))))
        {
          GMTrace.o(2417529716736L, 18012);
          return 1;
        }
      }
      GMTrace.o(2417529716736L, 18012);
      return 0;
    }
    GMTrace.o(2417529716736L, 18012);
    return 0;
  }
  
  public static boolean b(Context paramContext, au paramau, boolean paramBoolean)
  {
    GMTrace.i(15333972770816L, 114247);
    if (aV(paramau)) {}
    for (Object localObject = bb(paramau); (localObject == null) || (((String)localObject).length() == 0); localObject = d.a(paramau, (com.tencent.mm.ah.d)localObject, false))
    {
      v.e("MicroMsg.ImageGalleryAdapter", "doRestransmitMsg fail, bigImgPath is null, msgLocalId = " + paramau.field_msgId);
      if (paramBoolean) {
        Toast.makeText(paramContext, paramContext.getString(R.l.eOa), 1).show();
      }
      GMTrace.o(15333972770816L, 114247);
      return false;
      if ((paramau == null) || (paramau.field_msgId == 0L))
      {
        v.e("MicroMsg.ImageGalleryAdapter", "msg is null");
        if (paramBoolean) {
          Toast.makeText(paramContext, paramContext.getString(R.l.eOa), 1).show();
        }
        GMTrace.o(15333972770816L, 114247);
        return false;
      }
      localObject = d.bg(paramau);
      if ((localObject == null) || (((com.tencent.mm.ah.d)localObject).hEG == 0L))
      {
        StringBuilder localStringBuilder = new StringBuilder("doRestransmitMsg fail, msgLocalId = ");
        if (paramau == null)
        {
          paramau = "null";
          localStringBuilder = localStringBuilder.append(paramau).append(", imgLocalId = ");
          if (localObject != null) {
            break label253;
          }
        }
        label253:
        for (paramau = "null";; paramau = Long.valueOf(((com.tencent.mm.ah.d)localObject).hEG))
        {
          v.e("MicroMsg.ImageGalleryAdapter", paramau);
          if (paramBoolean) {
            Toast.makeText(paramContext, paramContext.getString(R.l.eOa), 1).show();
          }
          GMTrace.o(15333972770816L, 114247);
          return false;
          paramau = Long.valueOf(paramau.field_msgId);
          break;
        }
      }
    }
    if (!com.tencent.mm.platformtools.d.a((String)localObject, paramContext, paramBoolean, R.l.eaP))
    {
      if (paramBoolean) {
        Toast.makeText(paramContext, paramContext.getString(R.l.eOa), 1).show();
      }
      GMTrace.o(15333972770816L, 114247);
      return false;
    }
    GMTrace.o(15333972770816L, 114247);
    return true;
  }
  
  public static String bb(au paramau)
  {
    Object localObject1 = null;
    GMTrace.i(2417261281280L, 18010);
    Object localObject2 = f.a.ek(paramau.field_content);
    if (localObject2 == null)
    {
      GMTrace.o(2417261281280L, 18010);
      return null;
    }
    paramau = (au)localObject1;
    if (((f.a)localObject2).fCN != null)
    {
      paramau = (au)localObject1;
      if (((f.a)localObject2).fCN.length() > 0)
      {
        localObject2 = an.abF().LV(((f.a)localObject2).fCN);
        paramau = (au)localObject1;
        if (localObject2 != null) {
          paramau = ((com.tencent.mm.pluginsdk.model.app.b)localObject2).field_fileFullPath;
        }
      }
    }
    GMTrace.o(2417261281280L, 18010);
    return paramau;
  }
  
  public static boolean c(Context paramContext, List<au> paramList)
  {
    GMTrace.i(2416590192640L, 18005);
    if ((paramContext == null) || (paramList == null) || (paramList.size() <= 0))
    {
      GMTrace.o(2416590192640L, 18005);
      return false;
    }
    boolean bool1;
    int i;
    label58:
    au localau;
    boolean bool2;
    if (paramList.size() <= 1)
    {
      bool1 = true;
      paramList = paramList.iterator();
      i = 0;
      if (!paramList.hasNext()) {
        break label126;
      }
      localau = (au)paramList.next();
      if (!aS(localau)) {
        break label114;
      }
      bool2 = a(paramContext, localau, bool1);
      label95:
      if ((i != 0) || (!bool2)) {
        break label196;
      }
      i = 1;
    }
    label114:
    label126:
    label196:
    for (;;)
    {
      break label58;
      bool1 = false;
      break;
      bool2 = b(paramContext, localau, bool1);
      break label95;
      if ((i == 0) && (!bool1)) {
        Toast.makeText(paramContext, paramContext.getString(R.l.eOb), 1).show();
      }
      for (;;)
      {
        GMTrace.o(2416590192640L, 18005);
        return true;
        if ((i != 0) && (!bool1)) {
          Toast.makeText(paramContext, paramContext.getString(R.l.egG, new Object[] { com.tencent.mm.compatible.util.e.gSp }), 1).show();
        }
      }
    }
  }
  
  public final au Bh(int paramInt)
  {
    GMTrace.i(2414576926720L, 17990);
    au localau = this.vNX.Bs(paramInt);
    GMTrace.o(2414576926720L, 17990);
    return localau;
  }
  
  public final void Bi(int paramInt)
  {
    GMTrace.i(2415784886272L, 17999);
    au localau = Bh(paramInt);
    Object localObject = aX(localau);
    switch (2.vOl[localObject.ordinal()])
    {
    default: 
      ba(localau);
      GMTrace.o(2415784886272L, 17999);
      return;
    case 1: 
    case 2: 
      aZ(localau);
      GMTrace.o(2415784886272L, 17999);
      return;
    }
    localObject = bb(localau);
    Intent localIntent = new Intent(this.vNW, MsgRetransmitUI.class);
    localIntent.putExtra("Retr_File_Name", (String)localObject);
    localIntent.putExtra("Retr_Msg_Id", localau.field_msgId);
    localIntent.putExtra("Retr_Msg_Type", 16);
    localIntent.putExtra("Retr_Msg_content", localau.field_content);
    localIntent.putExtra("Retr_Compress_Type", 0);
    this.vNW.startActivity(localIntent);
    GMTrace.o(2415784886272L, 17999);
  }
  
  public final void Bj(int paramInt)
  {
    GMTrace.i(2415919104000L, 18000);
    au localau = Bh(paramInt);
    Object localObject = aX(localau);
    switch (2.vOl[localObject.ordinal()])
    {
    }
    for (;;)
    {
      GMTrace.o(2415919104000L, 18000);
      return;
      localObject = new Intent(this.vNW, ChattingSendDataToDeviceUI.class);
      ((Intent)localObject).putExtra("Retr_Msg_Id", localau.field_msgId);
      this.vNW.startActivity((Intent)localObject);
    }
  }
  
  public final void Bk(int paramInt)
  {
    GMTrace.i(2416992845824L, 18008);
    au localau = Bh(paramInt);
    cb localcb = new cb();
    com.tencent.mm.pluginsdk.model.e.a(localcb, localau);
    localcb.fFr.activity = this.vNW;
    localcb.fFr.fFy = 44;
    com.tencent.mm.sdk.b.a.uql.m(localcb);
    if (localcb.fFs.ret == 0)
    {
      if (localau.bMc()) {
        com.tencent.mm.ui.chatting.a.a(a.c.vvo, a.d.vvu, localau, 0);
      }
      com.tencent.mm.modelstat.b.hTV.t(localau);
    }
    GMTrace.o(2416992845824L, 18008);
  }
  
  public final View Bl(int paramInt)
  {
    GMTrace.i(2418335023104L, 18018);
    View localView3 = super.Ag(paramInt);
    if (localView3 == null)
    {
      v.e("MicroMsg.ImageGalleryAdapter", "position : %s getVideoViewByPosition is null", new Object[] { Integer.valueOf(paramInt) });
      GMTrace.o(2418335023104L, 18018);
      return null;
    }
    View localView2 = localView3.findViewById(R.h.cLy);
    View localView1 = localView2;
    if (localView2 == null) {
      localView1 = localView3.findViewById(R.h.cLx);
    }
    if ((localView1 == null) || (localView1.getVisibility() == 8))
    {
      GMTrace.o(2418335023104L, 18018);
      return null;
    }
    GMTrace.o(2418335023104L, 18018);
    return localView1;
  }
  
  public final void Bm(int paramInt)
  {
    GMTrace.i(2418469240832L, 18019);
    this.vOc.h(Bh(paramInt), paramInt);
    GMTrace.o(2418469240832L, 18019);
  }
  
  public final void Bn(int paramInt)
  {
    GMTrace.i(2418603458560L, 18020);
    this.vOc.i(Bh(paramInt), paramInt);
    GMTrace.o(2418603458560L, 18020);
  }
  
  public final void Bo(int paramInt)
  {
    GMTrace.i(2419006111744L, 18023);
    this.vOc.Bg(paramInt);
    GMTrace.o(2419006111744L, 18023);
  }
  
  public final void Bp(int paramInt)
  {
    GMTrace.i(2419274547200L, 18025);
    au localau = Bh(paramInt);
    if ((localau == null) || (!aR(localau)))
    {
      GMTrace.o(2419274547200L, 18025);
      return;
    }
    Object localObject = this.vOb;
    com.tencent.mm.ah.d locald = d.bg(localau);
    if ((locald == null) || (localau == null))
    {
      GMTrace.o(2419274547200L, 18025);
      return;
    }
    if (k.bXo().eU(localau.field_msgId))
    {
      localObject = k.bXo();
      ((k)localObject).vRG.remove(Long.valueOf(localau.field_msgId));
      com.tencent.mm.ah.n.GU().a(locald.hEG, localau.field_msgId, (c.a)localObject);
      com.tencent.mm.ah.n.GU().e(locald.hEG, localau.field_msgId);
      GMTrace.o(2419274547200L, 18025);
      return;
    }
    com.tencent.mm.ah.n.GU().a(locald.hEG, localau.field_msgId, (c.a)localObject);
    com.tencent.mm.ah.n.GU().e(locald.hEG, localau.field_msgId);
    GMTrace.o(2419274547200L, 18025);
  }
  
  public final void Bq(int paramInt)
  {
    GMTrace.i(2419408764928L, 18026);
    this.vOd.Bw(paramInt);
    GMTrace.o(2419408764928L, 18026);
  }
  
  public final void V(int paramInt)
  {
    GMTrace.i(2414174273536L, 17987);
    if ((this.vOb != null) && (aR(Bh(paramInt)))) {
      this.vOb.vPp.V(paramInt);
    }
    GMTrace.o(2414174273536L, 17987);
  }
  
  public final void a(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    GMTrace.i(2419542982656L, 18027);
    paramViewGroup.removeView((View)paramObject);
    super.a(paramViewGroup, paramInt, paramObject);
    GMTrace.o(2419542982656L, 18027);
  }
  
  public final boolean aW(au paramau)
  {
    GMTrace.i(2415516450816L, 17997);
    if (paramau == null)
    {
      GMTrace.o(2415516450816L, 17997);
      return false;
    }
    com.tencent.mm.ah.d locald = e(paramau, false);
    if (locald != null)
    {
      if ((paramau == null) || (locald == null))
      {
        GMTrace.o(2415516450816L, 17997);
        return false;
      }
      if ((com.tencent.mm.ah.n.GU().a(locald.hEG, paramau.field_msgId, 0)) || (a(paramau, locald)))
      {
        GMTrace.o(2415516450816L, 17997);
        return true;
      }
      GMTrace.o(2415516450816L, 17997);
      return false;
    }
    paramau = i.bl(paramau);
    if (paramau != null)
    {
      if (paramau == null)
      {
        GMTrace.o(2415516450816L, 17997);
        return false;
      }
      int i = paramau.status;
      int j = com.tencent.mm.modelvideo.t.f(paramau);
      if (((i == 112) || (i == 122)) && (j < 100)) {}
      for (boolean bool = true;; bool = false)
      {
        v.i("MicroMsg.ImageGalleryAdapter", "it is video downloading %b, status %d, download progress %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j) });
        GMTrace.o(2415516450816L, 17997);
        return bool;
      }
    }
    GMTrace.o(2415516450816L, 17997);
    return false;
  }
  
  public final void aZ(au paramau)
  {
    GMTrace.i(2416321757184L, 18003);
    ap.yY();
    if (!com.tencent.mm.u.c.isSDCardAvailable())
    {
      com.tencent.mm.ui.base.s.eP(this.vNW);
      GMTrace.o(2416321757184L, 18003);
      return;
    }
    r localr = com.tencent.mm.modelvideo.t.lI(paramau.field_imgPath);
    if (localr == null)
    {
      v.e("MicroMsg.ImageGalleryAdapter", "videoInfo should not be null");
      GMTrace.o(2416321757184L, 18003);
      return;
    }
    Intent localIntent = new Intent(this.vNW, MsgRetransmitUI.class);
    localIntent.putExtra("Retr_length", localr.hZV);
    localIntent.putExtra("Retr_File_Name", paramau.field_imgPath);
    localIntent.putExtra("Retr_video_isexport", localr.hZZ);
    if (aT(paramau)) {}
    for (int i = 11;; i = 1)
    {
      localIntent.putExtra("Retr_Msg_Type", i);
      localIntent.putExtra("Retr_Msg_Id", paramau.field_msgId);
      localIntent.putExtra("Retr_From", "gallery");
      this.vNW.startActivity(localIntent);
      GMTrace.o(2416321757184L, 18003);
      return;
    }
  }
  
  public final void al(int paramInt, boolean paramBoolean)
  {
    GMTrace.i(2418066587648L, 18016);
    this.vOb.al(paramInt, paramBoolean);
    GMTrace.o(2418066587648L, 18016);
  }
  
  public final int ani()
  {
    GMTrace.i(2414442708992L, 17989);
    int i = this.vNX.hOq;
    GMTrace.o(2414442708992L, 17989);
    return i;
  }
  
  public final int bSt()
  {
    GMTrace.i(2417798152192L, 18014);
    int i = this.vNX.vOn;
    GMTrace.o(2417798152192L, 18014);
    return 100000 - i;
  }
  
  public final int bSu()
  {
    GMTrace.i(2417932369920L, 18015);
    int i = this.vNX.vOn;
    int j = this.vNX.hOq;
    GMTrace.o(2417932369920L, 18015);
    return 100000 - i + j - 1;
  }
  
  public final au bWA()
  {
    GMTrace.i(2418737676288L, 18021);
    au localau = Bh(this.vNW.bWV());
    GMTrace.o(2418737676288L, 18021);
    return localau;
  }
  
  public final j bWB()
  {
    GMTrace.i(2418871894016L, 18022);
    Object localObject2 = this.vOb.Bf(this.vNW.bWV());
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this.vOc.Bf(this.vNW.bWV());
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = this.vOd.Bf(this.vNW.bWV());
    }
    GMTrace.o(2418871894016L, 18022);
    return (j)localObject2;
  }
  
  public final void bWC()
  {
    GMTrace.i(16136326348800L, 120225);
    this.vOc.onResume();
    GMTrace.o(16136326348800L, 120225);
  }
  
  public final void bWy()
  {
    GMTrace.i(17913771720704L, 133468);
    this.vNX.lo(false);
    GMTrace.o(17913771720704L, 133468);
  }
  
  public final boolean bWz()
  {
    GMTrace.i(2417663934464L, 18013);
    boolean bool = this.vNX.vOo;
    GMTrace.o(2417663934464L, 18013);
    return bool;
  }
  
  public final void ba(au paramau)
  {
    GMTrace.i(2416455974912L, 18004);
    com.tencent.mm.ah.d locald = d.bg(paramau);
    if ((paramau == null) || (paramau.field_msgId == 0L) || (locald == null) || (locald.hEG == 0L))
    {
      localObject = new StringBuilder("doRestransmitMsg fail, msgLocalId = ");
      if (paramau == null)
      {
        paramau = "null";
        localObject = ((StringBuilder)localObject).append(paramau).append(", imgLocalId = ");
        if (locald != null) {
          break label117;
        }
      }
      label117:
      for (paramau = "null";; paramau = Long.valueOf(locald.hEG))
      {
        v.e("MicroMsg.ImageGalleryAdapter", paramau);
        GMTrace.o(2416455974912L, 18004);
        return;
        paramau = Long.valueOf(paramau.field_msgId);
        break;
      }
    }
    Object localObject = d.a(paramau, locald, false);
    if ((localObject == null) || (((String)localObject).length() == 0))
    {
      v.e("MicroMsg.ImageGalleryAdapter", "doRestransmitMsg fail, bigImgPath is null, msgLocalId = " + paramau.field_msgId + ", imgLocalId = " + locald.hEG);
      GMTrace.o(2416455974912L, 18004);
      return;
    }
    if (bf.mA(this.vNY))
    {
      v.i("MicroMsg.ImageGalleryAdapter", "directly send user is empty, select one");
      Intent localIntent = new Intent(this.vNW, MsgRetransmitUI.class);
      localIntent.putExtra("Retr_File_Name", (String)localObject);
      localIntent.putExtra("Retr_Msg_Id", paramau.field_msgId);
      localIntent.putExtra("Retr_Msg_Type", 0);
      localIntent.putExtra("Retr_Compress_Type", b(paramau, locald));
      this.vNW.startActivity(localIntent);
      GMTrace.o(2416455974912L, 18004);
      return;
    }
    v.i("MicroMsg.ImageGalleryAdapter", "directly send user %s", new Object[] { this.vNY });
    int i;
    if (paramau.field_isSend == 1) {
      if (locald.GC())
      {
        i = 1;
        paramau = m.xL();
        localObject = com.tencent.mm.ah.n.GT().m(com.tencent.mm.ah.e.c(locald), "", "");
        if (!bf.mA((String)localObject))
        {
          v.i("MicroMsg.ImageGalleryAdapter", "connector click[img]: to[%s] fileName[%s]", new Object[] { locald, localObject });
          paramau = new com.tencent.mm.ah.k(paramau, this.vNY, (String)localObject, i);
          ap.vd().a(paramau, 0);
          bm.zN().c(bm.hnE, null);
        }
        if (!this.vNZ) {
          break label568;
        }
        paramau = new Intent(this.vNW, En_5b8fbb1e.class);
        paramau.addFlags(67108864);
        paramau.putExtra("Chat_User", this.vNY);
        this.vNW.startActivity(paramau);
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.g.oSF.i(10424, new Object[] { Integer.valueOf(3), Integer.valueOf(4), this.vNY });
      GMTrace.o(2416455974912L, 18004);
      return;
      i = 0;
      break;
      if (!locald.GC())
      {
        i = 0;
        break;
      }
      paramau = com.tencent.mm.ah.e.a(locald);
      if (!com.tencent.mm.a.e.aO(com.tencent.mm.ah.n.GT().m(paramau.hEH, "", "")))
      {
        i = 0;
        break;
      }
      i = 1;
      break;
      label568:
      com.tencent.mm.ui.base.g.bk(this.vNW, this.vNW.getString(R.l.dIq));
    }
  }
  
  public final View c(int paramInt, View paramView)
  {
    GMTrace.i(2417127063552L, 18009);
    final au localau = Bh(paramInt);
    final j localj;
    Object localObject;
    if (paramView == null)
    {
      paramView = View.inflate(this.vNW, R.i.dfx, null);
      localj = new j(this, paramView);
      paramView.setTag(localj);
      localObject = aX(localau);
      localj.kC = paramInt;
      localj.vRb = ((b)localObject);
      j.M(localj.mgy, 0);
      switch (j.5.vOl[localObject.ordinal()])
      {
      default: 
        label112:
        j.M(localj.vRy, 8);
        j.M(localj.vRp, 8);
        j.M(localj.vRv, 8);
        j.M(localj.vRu, 8);
        v.d("MicroMsg.ImageGalleryAdapter", "position:%d, type: %s", new Object[] { Integer.valueOf(paramInt), localObject });
        switch (2.vOl[localObject.ordinal()])
        {
        }
        break;
      }
    }
    for (;;)
    {
      this.vOg = false;
      GMTrace.o(2417127063552L, 18009);
      return paramView;
      localj = (j)paramView.getTag();
      break;
      j.M(localj.vRj, 8);
      j.M(localj.vRd, 8);
      break label112;
      localj.bXn();
      j.M(localj.vRj, 0);
      j.M(localj.vRd, 8);
      if (localj.vRd == null) {
        break label112;
      }
      j.M(localj.vRf, 8);
      break label112;
      localj.bXm();
      j.M(localj.vRj, 8);
      j.M(localj.vRd, 0);
      break label112;
      j.M(localj.mgy, 8);
      j.M(localj.vRj, 8);
      j.M(localj.vRd, 8);
      break label112;
      this.vOb.a(localj, localau, paramInt);
      continue;
      j.M(localj.vRy, 0);
      j.M(localj.vRp, 8);
      j.M(localj.vRu, 8);
      j.M(localj.vRv, 8);
      j.M(localj.vRn, 8);
      Bitmap localBitmap = com.tencent.mm.platformtools.j.mu(bb(localau));
      localObject = localBitmap;
      if (localBitmap == null)
      {
        localObject = com.tencent.mm.platformtools.j.mu(com.tencent.mm.ah.n.GT().v(localau.field_imgPath, true));
        j.M(localj.vRu, 0);
        new ad().post(new Runnable()
        {
          public final void run()
          {
            GMTrace.i(16263564754944L, 121173);
            l.a(localau, new l.a()
            {
              public final void dD(int paramAnonymous2Int1, int paramAnonymous2Int2)
              {
                GMTrace.i(16263296319488L, 121171);
                if (paramAnonymous2Int1 == paramAnonymous2Int2)
                {
                  v.d("MicroMsg.ImageGalleryAdapter", "appmsgImg download finish! msgid: %s", new Object[] { Long.valueOf(b.1.this.hkK.field_msgId) });
                  j.M(b.1.this.vOi.vRu, 8);
                  Bitmap localBitmap = com.tencent.mm.platformtools.j.mu(b.bb(b.1.this.hkK));
                  if (localBitmap != null)
                  {
                    b.1.this.vOi.vRy.qAx = false;
                    b.1.this.vOi.vRy.dZ(localBitmap.getWidth(), localBitmap.getHeight());
                    b.1.this.vOi.vRy.setImageBitmap(localBitmap);
                    b.1.this.vOi.vRy.invalidate();
                  }
                }
                GMTrace.o(16263296319488L, 121171);
              }
            });
            GMTrace.o(16263564754944L, 121173);
          }
        });
      }
      if (localObject == null)
      {
        v.w("MicroMsg.ImageGalleryAdapter", "get image fail");
        localj.vRy.setVisibility(8);
        localj.bXl().vRv.setVisibility(0);
        localj.bXl().vRx.setImageResource(R.k.dxj);
        localj.bXl().vRw.setText(this.vNW.getString(R.l.esn));
      }
      else
      {
        localj.vRy.qAx = false;
        localj.vRy.dZ(((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
        localj.vRy.setImageBitmap((Bitmap)localObject);
        localj.vRy.invalidate();
        continue;
        this.vOc.a(localj, localau, paramInt);
        continue;
        this.vOd.a(localj, localau, paramInt);
      }
    }
  }
  
  public final void detach()
  {
    GMTrace.i(2417395499008L, 18011);
    this.vOb.detach();
    this.vOc.detach();
    this.vOd.detach();
    super.detach();
    GMTrace.o(2417395499008L, 18011);
  }
  
  public final com.tencent.mm.ah.d e(au paramau, boolean paramBoolean)
  {
    GMTrace.i(2414711144448L, 17991);
    paramau = this.vOb.e(paramau, paramBoolean);
    GMTrace.o(2414711144448L, 17991);
    return paramau;
  }
  
  public final int getCount()
  {
    GMTrace.i(2414308491264L, 17988);
    a locala = this.vNX;
    int i = locala.hOq;
    int j = locala.vOn;
    GMTrace.o(2414308491264L, 17988);
    return i - j + 100000 + 1;
  }
  
  public final MultiTouchImageView ng(int paramInt)
  {
    GMTrace.i(2418200805376L, 18017);
    Object localObject = super.Ag(paramInt);
    if (localObject == null)
    {
      v.e("MicroMsg.ImageGalleryAdapter", "position : %s getMultiTouchImageViewByPosition is null", new Object[] { Integer.valueOf(paramInt) });
      GMTrace.o(2418200805376L, 18017);
      return null;
    }
    localObject = ((View)localObject).findViewById(R.h.Kd);
    if ((localObject == null) || (((View)localObject).getVisibility() == 8))
    {
      GMTrace.o(2418200805376L, 18017);
      return null;
    }
    localObject = (MultiTouchImageView)localObject;
    GMTrace.o(2418200805376L, 18017);
    return (MultiTouchImageView)localObject;
  }
  
  public final void notifyDataSetChanged()
  {
    GMTrace.i(2419140329472L, 18024);
    super.notifyDataSetChanged();
    GMTrace.o(2419140329472L, 18024);
  }
  
  public static final class a
  {
    private String fJC;
    public int hOq;
    public ad handler;
    private int rNq;
    private List<au> vOm;
    public int vOn;
    protected boolean vOo;
    protected int vOp;
    protected int vOq;
    protected int vOr;
    protected long vOs;
    private b vOt;
    public HashMap<Long, com.tencent.mm.ah.d> vOu;
    public HashMap<Long, com.tencent.mm.ah.d> vOv;
    
    public a(final long paramLong, String paramString, final b paramb, Boolean paramBoolean)
    {
      GMTrace.i(2469471977472L, 18399);
      this.vOo = false;
      this.vOu = new HashMap();
      this.vOv = new HashMap();
      this.handler = new ad();
      this.fJC = paramString;
      this.vOm = new LinkedList();
      this.vOt = paramb;
      ap.yY();
      paramString = com.tencent.mm.u.c.wT().cA(paramLong);
      if (paramString.field_msgId == 0L)
      {
        Assert.assertTrue("MicroMsg.AutoList <init>, currentMsg does not exist, currentMsgId = " + paramLong + ", stack = " + bf.bJP(), false);
        GMTrace.o(2469471977472L, 18399);
        return;
      }
      this.vOm.add(paramString);
      ap.vL().D(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(2430951489536L, 18112);
          b.a.this.eQ(paramLong);
          if (paramb.booleanValue()) {
            b.a.this.handler.postDelayed(new Runnable()
            {
              public final void run()
              {
                GMTrace.i(2432696320000L, 18125);
                b.a.this.bWD();
                if (b.a.1.this.vOy.vOe != null) {
                  b.a.1.this.vOy.vOe.TZ();
                }
                GMTrace.o(2432696320000L, 18125);
              }
            }, 0L);
          }
          GMTrace.o(2430951489536L, 18112);
        }
      });
      paramb.vNW.vQm = new ImageGalleryUI.a()
      {
        public final void i(Boolean paramAnonymousBoolean)
        {
          GMTrace.i(2425985433600L, 18075);
          v.i("MicroMsg.AutoList", "isPlaying : " + paramAnonymousBoolean);
          if (!paramAnonymousBoolean.booleanValue())
          {
            b.a.this.bWD();
            if (paramb.vOe != null) {
              paramb.vOe.TZ();
            }
          }
          GMTrace.o(2425985433600L, 18075);
        }
      };
      GMTrace.o(2469471977472L, 18399);
    }
    
    private void cC(List<au> paramList)
    {
      GMTrace.i(2469606195200L, 18400);
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      int i = 0;
      while (i < paramList.size())
      {
        if (b.aR((au)paramList.get(i)))
        {
          localArrayList1.add(Long.valueOf(((au)paramList.get(i)).field_msgSvrId));
          if (((au)paramList.get(i)).field_isSend == 1) {
            localArrayList2.add(Long.valueOf(((au)paramList.get(i)).field_msgId));
          }
        }
        i += 1;
      }
      this.vOu.putAll(com.tencent.mm.ah.n.GT().a((Long[])localArrayList1.toArray(new Long[0])));
      this.vOv.putAll(com.tencent.mm.ah.n.GT().b((Long[])localArrayList2.toArray(new Long[0])));
      GMTrace.o(2469606195200L, 18400);
    }
    
    private void o(long paramLong, boolean paramBoolean)
    {
      GMTrace.i(2470008848384L, 18403);
      v.i("MicroMsg.AutoList", "start loadMsgInfo, currentMsgId = " + paramLong + ", forward = " + paramBoolean);
      if (b.sLe) {
        ap.yY();
      }
      for (List localList = com.tencent.mm.u.c.wU().b(this.fJC, b.jZq, paramLong, paramBoolean); (localList == null) || (localList.size() == 0); localList = com.tencent.mm.u.c.wT().c(this.fJC, paramLong, paramBoolean))
      {
        v.w("MicroMsg.AutoList", "loadMsgInfo fail, addedMsgList is null, forward = " + paramBoolean);
        GMTrace.o(2470008848384L, 18403);
        return;
        ap.yY();
      }
      v.i("MicroMsg.AutoList", "loadMsgInfo done, new added list, size = " + localList.size() + ", forward = " + paramBoolean);
      paramLong = System.currentTimeMillis();
      cC(localList);
      v.i("MicroMsg.AutoList", "loadImgInfo spent : %s", new Object[] { Long.valueOf(System.currentTimeMillis() - paramLong) });
      if (paramBoolean)
      {
        this.vOm.addAll(localList);
        GMTrace.o(2470008848384L, 18403);
        return;
      }
      this.vOm.addAll(0, localList);
      this.rNq -= localList.size();
      if (this.rNq < 0)
      {
        v.e("MicroMsg.AutoList", "loadMsgInfo fail, min should not be minus, min = " + this.rNq);
        GMTrace.o(2470008848384L, 18403);
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder("min from ");
      int i = this.rNq;
      v.i("MicroMsg.AutoList", localList.size() + i + " to " + this.rNq);
      GMTrace.o(2470008848384L, 18403);
    }
    
    public final int Br(int paramInt)
    {
      GMTrace.i(2469740412928L, 18401);
      int i = this.vOn;
      GMTrace.o(2469740412928L, 18401);
      return paramInt - 100000 + i;
    }
    
    public final au Bs(int paramInt)
    {
      GMTrace.i(2469874630656L, 18402);
      paramInt = Br(paramInt);
      int i = this.rNq + this.vOm.size() - 1;
      if ((paramInt < this.rNq) || (paramInt > i))
      {
        v.e("MicroMsg.AutoList", "get, invalid pos " + paramInt + ", min = " + this.rNq + ", max = " + i);
        GMTrace.o(2469874630656L, 18402);
        return null;
      }
      v.d("MicroMsg.AutoList", "get, pos = " + paramInt);
      if (paramInt == this.rNq)
      {
        localau = (au)this.vOm.get(0);
        if (this.vOo) {
          o(localau.field_msgId, false);
        }
        GMTrace.o(2469874630656L, 18402);
        return localau;
      }
      if ((paramInt == i) && (i < this.hOq - 1))
      {
        localau = (au)this.vOm.get(this.vOm.size() - 1);
        if (this.vOo) {
          o(localau.field_msgId, true);
        }
        GMTrace.o(2469874630656L, 18402);
        return localau;
      }
      au localau = (au)this.vOm.get(paramInt - this.rNq);
      GMTrace.o(2469874630656L, 18402);
      return localau;
    }
    
    public final void bWD()
    {
      GMTrace.i(16018751619072L, 119349);
      this.vOo = true;
      this.hOq = this.vOp;
      this.rNq = this.vOq;
      this.vOn = this.vOr;
      v.i("MicroMsg.AutoList", "totalCount %s min %s start %s", new Object[] { Integer.valueOf(this.hOq), Integer.valueOf(this.rNq), Integer.valueOf(this.vOn) });
      long l = System.currentTimeMillis();
      v.i("MicroMsg.AutoList", "min spent : %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      l = System.currentTimeMillis();
      o(this.vOs, true);
      v.i("MicroMsg.AutoList", "loadMsgInfo spent : %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      l = System.currentTimeMillis();
      o(this.vOs, false);
      v.i("MicroMsg.AutoList", "loadMsgInfo spent : %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      this.vOt.notifyDataSetChanged();
      if (this.vOt.vNW.isFinishing())
      {
        GMTrace.o(16018751619072L, 119349);
        return;
      }
      this.vOt.c(99999, (View)this.vOt.vlX.get(99999));
      GMTrace.o(16018751619072L, 119349);
    }
    
    public final void eQ(long paramLong)
    {
      GMTrace.i(16018617401344L, 119348);
      long l = System.currentTimeMillis();
      v.i("MicroMsg.AutoList", "isBizChat = " + b.sLe);
      if (b.sLe)
      {
        ap.yY();
        this.vOp = com.tencent.mm.u.c.wU().ai(this.fJC, b.jZq);
        v.i("MicroMsg.AutoList", "<init>, totalCount = " + this.vOp);
        v.i("MicroMsg.AutoList", "totalCount spent : %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        l = System.currentTimeMillis();
        if (!b.sLe) {
          break label257;
        }
        ap.yY();
      }
      for (this.vOq = com.tencent.mm.u.c.wU().m(this.fJC, b.jZq, paramLong);; this.vOq = com.tencent.mm.u.c.wT().G(this.fJC, paramLong))
      {
        v.i("MicroMsg.AutoList", "min spent : %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        if (System.currentTimeMillis() - l > 1000L)
        {
          ap.yY();
          v.w("MicroMsg.AutoList", "explain : %s", new Object[] { com.tencent.mm.u.c.wT().H(this.fJC, paramLong) });
        }
        this.vOr = this.vOq;
        this.vOs = paramLong;
        GMTrace.o(16018617401344L, 119348);
        return;
        ap.yY();
        this.vOp = com.tencent.mm.u.c.wT().Ay(this.fJC);
        break;
        label257:
        ap.yY();
      }
    }
    
    public final void lo(boolean paramBoolean)
    {
      GMTrace.i(17913637502976L, 133467);
      this.vOo = false;
      GMTrace.o(17913637502976L, 133467);
    }
    
    public final String toString()
    {
      GMTrace.i(2470143066112L, 18404);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("AutoList, Size = " + this.vOm.size());
      ((StringBuilder)localObject).append("; Content = {");
      Iterator localIterator = this.vOm.iterator();
      while (localIterator.hasNext())
      {
        ((StringBuilder)localObject).append(((au)localIterator.next()).field_msgId);
        ((StringBuilder)localObject).append(",");
      }
      ((StringBuilder)localObject).append("}");
      localObject = ((StringBuilder)localObject).toString();
      GMTrace.o(2470143066112L, 18404);
      return (String)localObject;
    }
  }
  
  public static enum b
  {
    static
    {
      GMTrace.i(2464908574720L, 18365);
      vOB = new b("unkown", 0);
      vOC = new b("image", 1);
      vOD = new b("video", 2);
      vOE = new b("sight", 3);
      vOF = new b("appimage", 4);
      vOG = new b[] { vOB, vOC, vOD, vOE, vOF };
      GMTrace.o(2464908574720L, 18365);
    }
    
    private b()
    {
      GMTrace.i(2464774356992L, 18364);
      GMTrace.o(2464774356992L, 18364);
    }
  }
  
  public static abstract interface c
  {
    public abstract void TZ();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/gallery/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */