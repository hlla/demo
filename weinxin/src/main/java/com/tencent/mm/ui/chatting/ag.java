package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.ActionBarActivity;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.ci;
import com.tencent.mm.e.a.gh;
import com.tencent.mm.e.a.mn;
import com.tencent.mm.e.a.mn.a;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.i.e;
import com.tencent.mm.modelbiz.g.a;
import com.tencent.mm.modelbiz.w;
import com.tencent.mm.pluginsdk.l.a;
import com.tencent.mm.pluginsdk.l.k;
import com.tencent.mm.pluginsdk.ui.chat.k.a;
import com.tencent.mm.pluginsdk.ui.chat.k.b;
import com.tencent.mm.protocal.c.bph;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.f.a;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.j;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.l;
import java.util.LinkedList;
import java.util.Map;

public abstract class ag
{
  protected final int klJ;
  protected boolean sWq;
  private final long vAg;
  public boolean vvA;
  
  public ag(int paramInt)
  {
    GMTrace.i(2120371666944L, 15798);
    this.vAg = 120000L;
    this.klJ = paramInt;
    GMTrace.o(2120371666944L, 15798);
  }
  
  protected static boolean Tm(String paramString)
  {
    GMTrace.i(2125740376064L, 15838);
    if (((!o.fh(paramString)) && (!o.fx(paramString)) && (!o.eV(paramString)) && (!o.fF(paramString))) || (o.dH(paramString)))
    {
      GMTrace.o(2125740376064L, 15838);
      return true;
    }
    GMTrace.o(2125740376064L, 15838);
    return false;
  }
  
  public static String a(au paramau, boolean paramBoolean1, boolean paramBoolean2)
  {
    String str1 = null;
    GMTrace.i(2122519150592L, 15814);
    if (paramau == null)
    {
      GMTrace.o(2122519150592L, 15814);
      return null;
    }
    if (paramau.field_isSend == 1)
    {
      paramau = m.xL();
      GMTrace.o(2122519150592L, 15814);
      return paramau;
    }
    if (paramBoolean1) {
      str1 = ay.gi(paramau.field_content);
    }
    for (;;)
    {
      String str2 = str1;
      if (bf.mA(str1)) {
        str2 = paramau.field_talker;
      }
      GMTrace.o(2122519150592L, 15814);
      return str2;
      if (paramBoolean2) {
        str1 = paramau.field_bizChatUserId;
      }
    }
  }
  
  protected static void a(int paramInt, a parama, au paramau, String paramString, boolean paramBoolean, cw paramcw)
  {
    GMTrace.i(2124666634240L, 15830);
    if (paramau.field_isSend == 1)
    {
      parama.vwV.setTag(new ds(paramau, paramBoolean, paramInt, paramString, 5, (byte)0));
      parama.vwV.setOnClickListener(paramcw);
      switch (paramau.field_status)
      {
      default: 
        v.e("MicroMsg.ChattingItem", "getMsgStateResId: not found this state");
        paramInt = -1;
      }
      while (paramInt != -1)
      {
        parama.vwV.setImageResource(paramInt);
        parama.vwV.setVisibility(0);
        parama.vwV.setContentDescription(aa.getContext().getString(R.l.eBn));
        if (parama.oCh == null) {
          break label177;
        }
        parama.oCh.setVisibility(8);
        GMTrace.o(2124666634240L, 15830);
        return;
        paramInt = -1;
        continue;
        paramInt = R.g.bki;
      }
      parama.vwV.setVisibility(8);
    }
    label177:
    GMTrace.o(2124666634240L, 15830);
  }
  
  protected static void a(En_5b8fbb1e.a parama, View paramView, au paramau, f.a parama1, String paramString, long paramLong)
  {
    GMTrace.i(2123190239232L, 15819);
    if (!com.tencent.mm.pluginsdk.model.app.g.LX(parama1.appId))
    {
      paramView.setTag(new k.b());
      GMTrace.o(2123190239232L, 15819);
      return;
    }
    if (parama.vvA) {}
    for (int i = 2;; i = 1)
    {
      k.a locala = new k.a();
      locala.appId = parama1.appId;
      locala.fTc = "message";
      locala.fwG = paramString;
      locala.fTz = c(parama, paramau);
      locala.sOQ = parama1.type;
      locala.scene = i;
      locala.sOR = parama1.mediaTagName;
      locala.fTG = paramLong;
      a(parama, paramView, locala);
      GMTrace.o(2123190239232L, 15819);
      return;
    }
  }
  
  private static void a(En_5b8fbb1e.a parama, View paramView, Object paramObject)
  {
    GMTrace.i(2123324456960L, 15820);
    paramView.setTag(paramObject);
    paramView.setOnClickListener(parama.vzN.vDj);
    GMTrace.o(2123324456960L, 15820);
  }
  
  protected static void a(En_5b8fbb1e.a parama, View paramView, String paramString)
  {
    GMTrace.i(2123056021504L, 15818);
    if (!com.tencent.mm.pluginsdk.model.app.g.LX(paramString))
    {
      paramView.setTag(new k.b());
      GMTrace.o(2123056021504L, 15818);
      return;
    }
    k.b localb = new k.b();
    localb.appId = paramString;
    localb.fTc = "message";
    a(parama, paramView, localb);
    GMTrace.o(2123056021504L, 15818);
  }
  
  private static void a(En_5b8fbb1e.a parama, ImageView paramImageView, Bitmap paramBitmap)
  {
    GMTrace.i(2123592892416L, 15822);
    paramBitmap = new BitmapDrawable(paramBitmap);
    int i = (int)parama.getResources().getDimension(R.f.aXV);
    paramBitmap.setBounds(0, 0, i, i);
    paramImageView.setImageDrawable(paramBitmap);
    GMTrace.o(2123592892416L, 15822);
  }
  
  protected static void a(En_5b8fbb1e.a parama, ImageView paramImageView, String paramString)
  {
    GMTrace.i(2123458674688L, 15821);
    paramString = com.tencent.mm.pluginsdk.model.app.g.b(paramString, 2, com.tencent.mm.bg.a.getDensity(parama.uRf.uRz));
    if ((paramString != null) && (!paramString.isRecycled()))
    {
      a(parama, paramImageView, paramString);
      GMTrace.o(2123458674688L, 15821);
      return;
    }
    a(parama, paramImageView, BitmapFactory.decodeResource(parama.getResources(), R.g.bhR));
    GMTrace.o(2123458674688L, 15821);
  }
  
  private static void a(En_5b8fbb1e.a parama, TextView paramTextView, Bitmap paramBitmap)
  {
    GMTrace.i(2123861327872L, 15824);
    paramBitmap = new BitmapDrawable(paramBitmap);
    int i = (int)parama.getResources().getDimension(R.f.aXV);
    paramBitmap.setBounds(0, 0, i, i);
    paramTextView.setCompoundDrawables(paramBitmap, null, null, null);
    GMTrace.o(2123861327872L, 15824);
  }
  
  protected static void a(En_5b8fbb1e.a parama, TextView paramTextView, String paramString)
  {
    GMTrace.i(2123727110144L, 15823);
    paramString = com.tencent.mm.pluginsdk.model.app.g.b(paramString, 2, com.tencent.mm.bg.a.getDensity(parama.uRf.uRz));
    if ((paramString != null) && (!paramString.isRecycled()))
    {
      a(parama, paramTextView, paramString);
      GMTrace.o(2123727110144L, 15823);
      return;
    }
    a(parama, paramTextView, BitmapFactory.decodeResource(parama.getResources(), R.g.bhR));
    GMTrace.o(2123727110144L, 15823);
  }
  
  protected static void a(En_5b8fbb1e.a parama, f.a parama1, au paramau, com.tencent.mm.pluginsdk.model.app.f paramf)
  {
    GMTrace.i(2124935069696L, 15832);
    l.k localk = l.a.szQ;
    int i;
    ActionBarActivity localActionBarActivity;
    String str;
    if (localk != null)
    {
      if (!parama.vzR) {
        break label89;
      }
      i = 2;
      paramau = c(parama, paramau);
      localActionBarActivity = parama.uRf.uRz;
      str = parama1.appId;
      if (paramf != null) {
        break label95;
      }
    }
    label89:
    label95:
    for (parama = null;; parama = paramf.field_packageName)
    {
      localk.a(localActionBarActivity, str, parama, paramau, parama1.type, parama1.mediaTagName, i);
      GMTrace.o(2124935069696L, 15832);
      return;
      i = 1;
      break;
    }
  }
  
  protected static void a(En_5b8fbb1e.a parama, f.a parama1, String paramString, com.tencent.mm.pluginsdk.model.app.f paramf, long paramLong)
  {
    GMTrace.i(2124800851968L, 15831);
    int j;
    int i;
    label43:
    label54:
    mn localmn;
    mn.a locala;
    if (parama.vvA)
    {
      j = 2;
      if ((paramf == null) || (!com.tencent.mm.pluginsdk.model.app.p.n(parama.uRf.uRz, paramf.field_packageName))) {
        break label208;
      }
      i = 3;
      if (parama1.type != 2) {
        break label215;
      }
      i = 4;
      localmn = new mn();
      localmn.fTD.context = parama.uRf.uRz;
      localmn.fTD.scene = j;
      localmn.fTD.fTE = parama1.appId;
      locala = localmn.fTD;
      if (paramf != null) {
        break label229;
      }
    }
    label208:
    label215:
    label229:
    for (parama = null;; parama = paramf.field_packageName)
    {
      locala.packageName = parama;
      localmn.fTD.msgType = parama1.type;
      localmn.fTD.fOl = paramString;
      localmn.fTD.fTF = i;
      localmn.fTD.mediaTagName = parama1.mediaTagName;
      localmn.fTD.fTG = paramLong;
      localmn.fTD.fTH = "";
      com.tencent.mm.sdk.b.a.uql.m(localmn);
      GMTrace.o(2124800851968L, 15831);
      return;
      j = 1;
      break;
      i = 6;
      break label43;
      if (parama1.type != 5) {
        break label54;
      }
      i = 1;
      break label54;
    }
  }
  
  protected static void a(a parama, En_5b8fbb1e.a parama1, String paramString, au paramau)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    GMTrace.i(2122787586048L, 15816);
    if (parama.ipb == null)
    {
      GMTrace.o(2122787586048L, 15816);
      return;
    }
    if ((o.fE(paramString)) && (!paramString.equals(o.hlg[0])))
    {
      parama.ipb.setVisibility(8);
      GMTrace.o(2122787586048L, 15816);
      return;
    }
    if ((paramau != null) && (!bf.mA(paramau.gxD)))
    {
      if (parama1.vzR) {
        localObject1 = parama1.bTW();
      }
      localObject1 = new ds(paramString, 9, (String)localObject1);
      ((ds)localObject1).vLf = paramau.gxD;
      com.tencent.mm.pluginsdk.ui.a.b.g(parama.ipb, paramau.gxD, R.g.bcA);
    }
    for (;;)
    {
      parama.ipb.setVisibility(0);
      parama.ipb.setTag(localObject1);
      bd.dm(parama.ipb);
      parama.ipb.setOnClickListener(parama1.vzN.vDb);
      parama.ipb.setOnLongClickListener(parama1.vzN.vDd);
      parama.ipb.setContentDescription(com.tencent.mm.u.n.eK(paramString) + parama1.uRf.uRz.getString(R.l.dJf));
      if (parama.vAh == null) {
        break label443;
      }
      if ((paramau.gxv != null) && (paramau.gxv.contains("watch_msg_source_type")))
      {
        parama1 = (String)bg.q(paramau.gxv, "msgsource").get(".msgsource.watch_msg_source_type");
        try
        {
          i = Integer.valueOf(parama1).intValue();
          if ((i > 0) && (i <= 4))
          {
            parama.vAh.setVisibility(0);
            GMTrace.o(2122787586048L, 15816);
            return;
            if ((paramau != null) && (parama1.sLe))
            {
              localObject1 = new ds(paramau.field_bizChatUserId, 1, null);
              com.tencent.mm.ah.n.GX().a(parama1.iv(paramau.field_bizChatUserId), parama.ipb, parama1.vzN.kuE);
              continue;
            }
            localObject1 = localObject2;
            if (parama1.vzR) {
              localObject1 = parama1.bTW();
            }
            localObject1 = new ds(paramString, 1, (String)localObject1);
            o(parama.ipb, paramString);
          }
        }
        catch (Exception parama1)
        {
          for (;;)
          {
            int i = 0;
          }
          parama.vAh.setVisibility(8);
          GMTrace.o(2122787586048L, 15816);
          return;
        }
      }
    }
    parama.vAh.setVisibility(8);
    label443:
    GMTrace.o(2122787586048L, 15816);
  }
  
  protected static void a(a parama, CharSequence paramCharSequence)
  {
    GMTrace.i(2122653368320L, 15815);
    if ((parama == null) || (parama.phd == null))
    {
      GMTrace.o(2122653368320L, 15815);
      return;
    }
    if (paramCharSequence == null)
    {
      parama.phd.setVisibility(8);
      GMTrace.o(2122653368320L, 15815);
      return;
    }
    parama.phd.setText(paramCharSequence);
    parama.phd.setVisibility(0);
    GMTrace.o(2122653368320L, 15815);
  }
  
  protected static boolean a(En_5b8fbb1e.a parama, com.tencent.mm.pluginsdk.model.app.f paramf)
  {
    GMTrace.i(2125203505152L, 15834);
    l.k localk = l.a.szQ;
    if ((!com.tencent.mm.pluginsdk.model.app.g.a(parama.uRf.uRz, paramf)) && (localk != null))
    {
      if (!bf.mA(paramf.geY))
      {
        boolean bool = com.tencent.mm.pluginsdk.model.app.q.aR(parama.uRf.uRz, paramf.geY);
        v.i("MicroMsg.ChattingItem", "oversea game info and gpdownload url is not empty, jump to google play directy:[%s], jump result: [%b]", new Object[] { paramf.geY, Boolean.valueOf(bool) });
        if (bool)
        {
          GMTrace.o(2125203505152L, 15834);
          return true;
        }
      }
      if (parama.vvA) {}
      for (int i = 2;; i = 1)
      {
        gh localgh = new gh();
        localgh.fLs.actionCode = 2;
        localgh.fLs.scene = i;
        localgh.fLs.appId = paramf.field_appId;
        localgh.fLs.context = parama.uRf.uRz;
        com.tencent.mm.sdk.b.a.uql.m(localgh);
        parama = parama.uRf.uRz;
        localk.B(paramf.field_appId, i, i);
        GMTrace.o(2125203505152L, 15834);
        return true;
      }
    }
    GMTrace.o(2125203505152L, 15834);
    return false;
  }
  
  protected static boolean a(cv paramcv, long paramLong)
  {
    GMTrace.i(2126008811520L, 15840);
    if (paramLong > 0L)
    {
      Cursor localCursor;
      int i;
      int j;
      if (paramcv.vDD == -1L)
      {
        paramcv.vDD = 0L;
        localCursor = paramcv.getCursor();
        i = localCursor.getPosition();
        j = localCursor.getCount();
        v.i("MicroMsg.ChattingListAdapter", "curPos %d, curCount %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        if (localCursor.moveToLast())
        {
          paramcv.vDI = null;
          paramcv.vDI = cv.a(paramcv.vDI, localCursor);
          if (paramcv.vDI.field_isSend != 1) {
            break label184;
          }
          if ((paramcv.vDI.gxu & 0x4) != 4) {
            paramcv.vDD = paramcv.vDI.field_msgId;
          }
        }
        label145:
        if (j >= 0) {
          break label197;
        }
        if (j > 0) {
          localCursor.moveToPosition(0);
        }
      }
      for (;;)
      {
        if (paramcv.vDD != paramLong) {
          break label235;
        }
        GMTrace.o(2126008811520L, 15840);
        return true;
        label184:
        if (localCursor.moveToPrevious()) {
          break;
        }
        break label145;
        label197:
        if (i >= j)
        {
          if (j > 0) {
            localCursor.moveToPosition(j - 1);
          }
        }
        else {
          localCursor.moveToPosition(i);
        }
      }
    }
    label235:
    GMTrace.o(2126008811520L, 15840);
    return false;
  }
  
  protected static boolean ao(au paramau)
  {
    GMTrace.i(15952984932352L, 118859);
    long l = paramau.field_createTime;
    if (System.currentTimeMillis() - l > 120000L) {}
    for (int i = 1; i != 0; i = 0)
    {
      GMTrace.o(15952984932352L, 118859);
      return false;
    }
    i = com.tencent.mm.i.g.sV().getInt("ShowRevokeMsgEntry", 1);
    v.d("MicroMsg.ChattingItem", "[oneliang][isRevokeMsgEnable] enable:%d", new Object[] { Integer.valueOf(i) });
    if (1 == i)
    {
      GMTrace.o(15952984932352L, 118859);
      return true;
    }
    GMTrace.o(15952984932352L, 118859);
    return false;
  }
  
  protected static PackageInfo ay(Context paramContext, String paramString)
  {
    GMTrace.i(2124532416512L, 15829);
    if ((paramString == null) || (paramString.length() == 0)) {
      paramString = null;
    }
    while (paramString == null)
    {
      GMTrace.o(2124532416512L, 15829);
      return null;
      paramString = com.tencent.mm.pluginsdk.model.app.g.aJ(paramString, true);
      if (paramString == null) {
        paramString = null;
      } else {
        paramString = paramString.field_packageName;
      }
    }
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 0);
      GMTrace.o(2124532416512L, 15829);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      v.printErrStackTrace("MicroMsg.ChattingItem", paramContext, "", new Object[0]);
      GMTrace.o(2124532416512L, 15829);
    }
    return null;
  }
  
  protected static String b(En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2122384932864L, 15813);
    String str = paramau.field_talker;
    paramau = str;
    if (parama.sLe)
    {
      paramau = str;
      if (parama.vtp != null) {
        paramau = parama.vtp.field_bizChatServId;
      }
    }
    GMTrace.o(2122384932864L, 15813);
    return paramau;
  }
  
  protected static void b(En_5b8fbb1e.a parama, View paramView, Object paramObject)
  {
    GMTrace.i(2123995545600L, 15825);
    paramView.setTag(paramObject);
    paramView.setOnClickListener(parama.vzN.vDb);
    GMTrace.o(2123995545600L, 15825);
  }
  
  protected static void b(En_5b8fbb1e.a parama, f.a parama1, au paramau)
  {
    GMTrace.i(2125069287424L, 15833);
    l.k localk = l.a.szQ;
    if (localk != null) {
      if (!parama.vzR) {
        break label79;
      }
    }
    label79:
    for (int i = 2;; i = 1)
    {
      String str = c(parama, paramau);
      parama = parama.uRf.uRz;
      localk.a(parama1.appId, str, parama1.type, i, parama1.mediaTagName, paramau.field_msgSvrId);
      GMTrace.o(2125069287424L, 15833);
      return;
    }
  }
  
  protected static boolean bUg()
  {
    GMTrace.i(2125874593792L, 15839);
    String str = com.tencent.mm.i.g.sV().getValue("ShowSendOK");
    if (bf.mA(str)) {}
    for (int i = 0; 1 == i; i = bf.PX(str))
    {
      GMTrace.o(2125874593792L, 15839);
      return true;
    }
    GMTrace.o(2125874593792L, 15839);
    return false;
  }
  
  protected static String c(En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2125337722880L, 15835);
    String str = parama.bTW();
    parama = str;
    if (o.dH(str)) {
      parama = ay.gi(paramau.field_content);
    }
    GMTrace.o(2125337722880L, 15835);
    return parama;
  }
  
  protected static void c(En_5b8fbb1e.a parama, View paramView, Object paramObject)
  {
    GMTrace.i(2124129763328L, 15826);
    paramView.setTag(paramObject);
    paramView.setOnClickListener(parama.vzN.vDn);
    GMTrace.o(2124129763328L, 15826);
  }
  
  public static int eT(Context paramContext)
  {
    GMTrace.i(2121445408768L, 15806);
    float f = com.tencent.mm.bg.a.dI(paramContext);
    int i;
    if (f == 0.875F) {
      i = com.tencent.mm.bg.a.U(paramContext, R.f.aZh);
    }
    for (;;)
    {
      GMTrace.o(2121445408768L, 15806);
      return i;
      if (f == 1.125F) {
        i = com.tencent.mm.bg.a.U(paramContext, R.f.aZd);
      } else if (f == 1.25F) {
        i = com.tencent.mm.bg.a.U(paramContext, R.f.aZi);
      } else if (f == 1.375F) {
        i = com.tencent.mm.bg.a.U(paramContext, R.f.aZb);
      } else if ((f == 1.625F) || (f == 1.875F) || (f == 2.025F)) {
        i = com.tencent.mm.bg.a.U(paramContext, R.f.aZc);
      } else {
        i = com.tencent.mm.bg.a.U(paramContext, R.f.aZg);
      }
    }
  }
  
  public static int eU(Context paramContext)
  {
    GMTrace.i(2121579626496L, 15807);
    float f = com.tencent.mm.bg.a.dI(paramContext);
    int i;
    if ((f != 0.875F) && (f != 1.125F)) {
      if (f == 1.25F) {
        i = com.tencent.mm.bg.a.U(paramContext, R.f.aZa);
      }
    }
    for (;;)
    {
      GMTrace.o(2121579626496L, 15807);
      return i;
      if (f == 1.375F) {
        i = com.tencent.mm.bg.a.U(paramContext, R.f.aYY);
      } else if ((f == 1.625F) || (f == 1.875F) || (f == 2.025F)) {
        i = com.tencent.mm.bg.a.U(paramContext, R.f.aZc);
      } else {
        i = com.tencent.mm.bg.a.U(paramContext, R.f.aYZ);
      }
    }
  }
  
  public static void o(ImageView paramImageView, String paramString)
  {
    GMTrace.i(2121311191040L, 15805);
    if (bf.mA(paramString))
    {
      paramImageView.setImageResource(R.g.ber);
      GMTrace.o(2121311191040L, 15805);
      return;
    }
    com.tencent.mm.pluginsdk.ui.a.b.a(paramImageView, paramString);
    GMTrace.o(2121311191040L, 15805);
  }
  
  public static void p(ImageView paramImageView, String paramString)
  {
    GMTrace.i(2121713844224L, 15808);
    if (bf.mA(paramString))
    {
      paramImageView.setImageResource(R.g.bcX);
      GMTrace.o(2121713844224L, 15808);
      return;
    }
    com.tencent.mm.pluginsdk.ui.a.b.m(paramImageView, paramString);
    GMTrace.o(2121713844224L, 15808);
  }
  
  public static void v(com.tencent.mm.storage.a.c paramc)
  {
    GMTrace.i(2125471940608L, 15836);
    ci localci = new ci();
    localci.fFE.fFF = paramc;
    localci.fFE.scene = 0;
    com.tencent.mm.sdk.b.a.uql.m(localci);
    GMTrace.o(2125471940608L, 15836);
  }
  
  public abstract View a(LayoutInflater paramLayoutInflater, View paramView);
  
  protected String a(En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2122250715136L, 15812);
    String str = parama.vzN.fJC;
    if (!a(parama))
    {
      GMTrace.o(2122250715136L, 15812);
      return str;
    }
    if (parama.vzR)
    {
      parama = ay.gi(paramau.field_content);
      if ((str == null) || (parama == null) || (parama.length() <= 0)) {
        break label89;
      }
    }
    for (;;)
    {
      GMTrace.o(2122250715136L, 15812);
      return parama;
      if (paramau != null) {
        parama = paramau.field_bizChatUserId;
      } else {
        label89:
        parama = str;
      }
    }
  }
  
  protected final void a(En_5b8fbb1e.a parama, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, boolean paramBoolean, long paramLong1, long paramLong2, au paramau)
  {
    GMTrace.i(2124398198784L, 15828);
    if (((paramString1 == null) || (paramString1.length() == 0)) && ((paramString2 == null) || (paramString2.length() == 0)))
    {
      v.e("MicroMsg.ChattingItem", "url, lowUrl both are empty");
      GMTrace.o(2124398198784L, 15828);
      return;
    }
    String str;
    if (al.isMobile(parama.uRf.uRz))
    {
      str = paramString1;
      if (paramString2 != null)
      {
        if (paramString2.length() > 0) {
          break label336;
        }
        str = paramString1;
      }
    }
    for (;;)
    {
      paramString1 = new Intent();
      paramString1.putExtra("msg_id", paramLong1);
      paramString1.putExtra("rawUrl", str);
      paramString1.putExtra("version_name", paramString3);
      paramString1.putExtra("version_code", paramInt);
      paramString1.putExtra("usePlugin", paramBoolean);
      paramString1.putExtra("geta8key_username", parama.bTW());
      paramString1.putExtra("KPublisherId", "msg_" + Long.toString(paramLong2));
      paramString1.putExtra("KAppId", paramString4);
      paramString1.putExtra("pre_username", a(parama, paramau));
      paramString1.putExtra("prePublishId", "msg_" + Long.toString(paramLong2));
      if (paramau != null) {
        paramString1.putExtra("preUsername", a(parama, paramau));
      }
      paramString1.putExtra("preChatName", parama.bTW());
      paramString1.putExtra("preChatTYPE", com.tencent.mm.u.p.G(a(parama, paramau), parama.bTW()));
      paramString1.putExtra("preMsgIndex", 0);
      d.b(parama.uRf.uRz, "webview", ".ui.tools.WebViewUI", paramString1);
      GMTrace.o(2124398198784L, 15828);
      return;
      if (paramString1 != null)
      {
        str = paramString1;
        if (paramString1.length() > 0) {}
      }
      else
      {
        label336:
        str = paramString2;
      }
    }
  }
  
  public abstract void a(a parama, int paramInt, En_5b8fbb1e.a parama1, au paramau, String paramString);
  
  public final void a(a parama, int paramInt, En_5b8fbb1e.a parama1, au paramau, boolean paramBoolean)
  {
    GMTrace.i(2121848061952L, 15809);
    this.sWq = paramBoolean;
    String str = null;
    if (bUf())
    {
      str = a(parama1, paramau);
      a(parama, parama1, paramau, str);
      a(parama, parama1, str, paramau);
    }
    a(parama, paramInt, parama1, paramau, str);
    GMTrace.o(2121848061952L, 15809);
  }
  
  protected void a(a parama, En_5b8fbb1e.a parama1, au paramau, String paramString)
  {
    GMTrace.i(2122116497408L, 15811);
    if ((paramString == null) || (parama.phd == null) || (paramau == null))
    {
      GMTrace.o(2122116497408L, 15811);
      return;
    }
    com.tencent.mm.modelbiz.f localf = null;
    Object localObject = null;
    if ((paramau.field_isSend == 0) && (!bf.mA(paramau.gxD)))
    {
      localf = w.DG().ig(paramau.gxD);
      int i = 1;
      if ((localf != null) && (!bf.mA(localf.field_openId)) && (!bf.mA(localf.field_nickname)))
      {
        paramString = localf.field_nickname;
        i = 0;
        if (i == 0)
        {
          localObject = paramString;
          if (!com.tencent.mm.modelbiz.h.a(localf)) {}
        }
        else
        {
          w.DI().a(new d(parama1.vzN, paramau.gxD));
          w.DI().U(parama1.vzN.fJC, paramau.gxD);
          localObject = paramString;
        }
      }
    }
    for (;;)
    {
      a(parama, (CharSequence)localObject);
      GMTrace.o(2122116497408L, 15811);
      return;
      v.i("MicroMsg.ChattingItem", "fillingUsername:need getKfInfo");
      paramString = (String)localObject;
      break;
      localObject = localf;
      if (a(parama1))
      {
        localObject = localf;
        if (parama1.vHm) {
          if (parama1.vHe) {
            localObject = com.tencent.mm.pluginsdk.ui.d.h.b(parama1.uRf.uRz, parama1.eK(paramau.field_bizChatUserId), parama.phd.getTextSize());
          } else {
            localObject = com.tencent.mm.pluginsdk.ui.d.h.b(parama1.uRf.uRz, parama1.eK(paramString), parama.phd.getTextSize());
          }
        }
      }
    }
  }
  
  public abstract boolean a(ContextMenu paramContextMenu, View paramView, au paramau);
  
  public abstract boolean a(MenuItem paramMenuItem, En_5b8fbb1e.a parama, au paramau);
  
  public abstract boolean a(View paramView, En_5b8fbb1e.a parama, au paramau);
  
  protected boolean a(En_5b8fbb1e.a parama)
  {
    GMTrace.i(2122921803776L, 15817);
    if ((parama.vzR) || (parama.sLe))
    {
      GMTrace.o(2122921803776L, 15817);
      return true;
    }
    GMTrace.o(2122921803776L, 15817);
    return false;
  }
  
  public final boolean a(En_5b8fbb1e.a parama, f.a parama1, au paramau)
  {
    GMTrace.i(2124263981056L, 15827);
    if (bf.mA(parama1.hjt))
    {
      GMTrace.o(2124263981056L, 15827);
      return false;
    }
    a.a(a.a.vvc, paramau, parama1.hjA, parama1.hjz);
    String str = paramau.field_imgPath;
    Intent localIntent = new Intent();
    localIntent.putExtra("IsAd", false);
    localIntent.putExtra("KStremVideoUrl", parama1.hjt);
    localIntent.putExtra("KThumUrl", parama1.hjy);
    localIntent.putExtra("KThumbPath", str);
    localIntent.putExtra("KSta_StremVideoAduxInfo", parama1.hjz);
    localIntent.putExtra("KSta_StremVideoPublishId", parama1.hjA);
    localIntent.putExtra("KSta_SourceType", 2);
    if (parama.vzR) {}
    for (int i = a.b.vvl.value;; i = a.b.vvk.value)
    {
      localIntent.putExtra("KSta_Scene", i);
      localIntent.putExtra("KSta_FromUserName", a(parama, paramau));
      localIntent.putExtra("KSta_ChatName", parama.bTW());
      localIntent.putExtra("KSta_MsgId", paramau.field_msgSvrId);
      localIntent.putExtra("KSta_SnsStatExtStr", parama1.fUO);
      if (parama.vzR) {
        localIntent.putExtra("KSta_ChatroomMembercount", j.eC(parama.bTW()));
      }
      localIntent.putExtra("KMediaId", "fakeid_" + paramau.field_msgId);
      localIntent.putExtra("KMediaVideoTime", parama1.hju);
      localIntent.putExtra("StremWebUrl", parama1.hjx);
      localIntent.putExtra("StreamWording", parama1.hjw);
      localIntent.putExtra("KMediaTitle", parama1.title);
      d.b(parama.uRf.uRz, "sns", ".ui.VideoAdPlayerUI", localIntent);
      GMTrace.o(2124263981056L, 15827);
      return true;
    }
  }
  
  public final int bUe()
  {
    GMTrace.i(2121176973312L, 15804);
    int i = this.klJ;
    GMTrace.o(2121176973312L, 15804);
    return i;
  }
  
  protected boolean bUf()
  {
    GMTrace.i(2121982279680L, 15810);
    GMTrace.o(2121982279680L, 15810);
    return true;
  }
  
  public static class a
  {
    public ImageView ipb;
    public TextView kvw;
    public CheckBox mdQ;
    public View mgy;
    public View nQv;
    public ProgressBar oCh;
    public TextView phd;
    public int type;
    public ViewStub vAh;
    public View vAi;
    public View vAj;
    public int vAk;
    public long vAl;
    public ImageView vwV;
    
    public a(int paramInt)
    {
      this(paramInt, (byte)0);
      GMTrace.i(2165200388096L, 16132);
      GMTrace.o(2165200388096L, 16132);
    }
    
    private a(int paramInt, byte paramByte)
    {
      GMTrace.i(2165334605824L, 16133);
      this.type = paramInt;
      this.vAl = 0L;
      GMTrace.o(2165334605824L, 16133);
    }
    
    public static void I(View paramView, int paramInt)
    {
      GMTrace.i(2165737259008L, 16136);
      if (paramView != null)
      {
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
        localLayoutParams.width = paramInt;
        paramView.setLayoutParams(localLayoutParams);
        paramView.requestLayout();
      }
      GMTrace.o(2165737259008L, 16136);
    }
    
    public final void dl(View paramView)
    {
      GMTrace.i(2165468823552L, 16134);
      this.mgy = paramView;
      this.kvw = ((TextView)paramView.findViewById(R.h.bBt));
      this.ipb = ((ImageView)paramView.findViewById(R.h.bzM));
      this.vAi = paramView.findViewById(R.h.bAA);
      this.vAj = paramView.findViewById(R.h.bzX);
      this.vwV = ((ImageView)paramView.findViewById(R.h.bBp));
      this.vAh = ((ViewStub)paramView.findViewById(R.h.bBl));
      GMTrace.o(2165468823552L, 16134);
    }
    
    public final void le(boolean paramBoolean)
    {
      GMTrace.i(2165603041280L, 16135);
      if (paramBoolean) {}
      for (int i = 0;; i = 8)
      {
        if ((this.mdQ != null) && (this.mdQ.getVisibility() != i)) {
          this.mdQ.setVisibility(i);
        }
        if ((this.nQv != null) && (this.nQv.getVisibility() != i)) {
          this.nQv.setVisibility(i);
        }
        GMTrace.o(2165603041280L, 16135);
        return;
      }
    }
  }
  
  public static abstract class b
    extends ag
  {
    public b(int paramInt)
    {
      super();
      GMTrace.i(2254857830400L, 16800);
      GMTrace.o(2254857830400L, 16800);
    }
  }
  
  public static abstract class c
    extends ag
  {
    public c(int paramInt)
    {
      super();
      GMTrace.i(2279822327808L, 16986);
      GMTrace.o(2279822327808L, 16986);
    }
    
    protected final String a(En_5b8fbb1e.a parama, au paramau)
    {
      GMTrace.i(2280090763264L, 16988);
      parama = parama.vzN.hrv;
      GMTrace.o(2280090763264L, 16988);
      return parama;
    }
    
    protected final boolean a(En_5b8fbb1e.a parama)
    {
      GMTrace.i(2279956545536L, 16987);
      GMTrace.o(2279956545536L, 16987);
      return false;
    }
  }
  
  private static final class d
    implements g.a
  {
    private String slg;
    public cv vzN;
    
    protected d(cv paramcv, String paramString)
    {
      GMTrace.i(2260226539520L, 16840);
      this.slg = paramString;
      this.vzN = paramcv;
      GMTrace.o(2260226539520L, 16840);
    }
    
    public final String Dz()
    {
      GMTrace.i(2260494974976L, 16842);
      String str = this.slg;
      GMTrace.o(2260494974976L, 16842);
      return str;
    }
    
    public final void c(LinkedList<bph> paramLinkedList)
    {
      int k = 0;
      GMTrace.i(2260360757248L, 16841);
      w.DI().b(this);
      v.d("MicroMsg.ChattingItem", "onKFSceneEnd.");
      int i;
      if ((paramLinkedList != null) && (paramLinkedList.size() > 0))
      {
        v.i("MicroMsg.ChattingItem", "onKFSceneEnd, workers size : %d. callbackid=%s", new Object[] { Integer.valueOf(paramLinkedList.size()), this.slg });
        if (this.vzN != null)
        {
          i = k;
          if (paramLinkedList != null)
          {
            if (paramLinkedList.size() != 0) {
              break label114;
            }
            i = k;
          }
          if (i != 0) {
            ae.v(new Runnable()
            {
              public final void run()
              {
                GMTrace.i(2264118853632L, 16869);
                ag.d.this.vzN.notifyDataSetChanged();
                GMTrace.o(2264118853632L, 16869);
              }
            });
          }
        }
      }
      GMTrace.o(2260360757248L, 16841);
      return;
      label114:
      int j = 0;
      for (;;)
      {
        i = k;
        if (j >= paramLinkedList.size()) {
          break;
        }
        bph localbph = (bph)paramLinkedList.get(j);
        if ((localbph != null) && (!bf.mA(localbph.ume)) && (localbph.ume.equals(this.slg)))
        {
          v.i("MicroMsg.ChattingItem", "needCallback find match kfopenid");
          if (!bf.mA(localbph.tLN))
          {
            v.i("MicroMsg.ChattingItem", "needCallback: true");
            i = 1;
            break;
          }
        }
        j += 1;
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */