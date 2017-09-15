package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.f;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.e.a.lz;
import com.tencent.mm.e.a.lz.b;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.pluginsdk.model.app.am.a;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.protocal.c.rl;
import com.tencent.mm.protocal.c.rm;
import com.tencent.mm.protocal.c.rn;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.f.a;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.regex.Pattern;

final class n
  extends ag.a
{
  public static int[] lLm;
  protected TextView ipc;
  protected TextView ipd;
  protected TextView lLh;
  protected TextView mwR;
  private ArrayList<MMImageView> quE;
  protected ImageView stu;
  protected MMImageView vwA;
  ImageView vwJ;
  protected TextView vwP;
  protected ImageView vwW;
  protected ImageView vwX;
  protected TextView vwY;
  protected LinearLayout vwZ;
  public int vwx;
  protected ImageView vxA;
  protected TextView vxB;
  private int vxC;
  protected ImageView vxa;
  protected MMPinProgressBtn vxb;
  protected ImageView vxc;
  protected ImageView vxd;
  protected ImageView vxe;
  protected ChattingItemFooter vxf;
  protected ImageView vxg;
  protected LinearLayout vxh;
  protected ViewGroup vxi;
  protected TextView vxj;
  protected LinearLayout vxk;
  protected RelativeLayout vxl;
  protected FrameLayout vxm;
  protected LinearLayout vxn;
  protected LinearLayout vxo;
  protected ViewStub vxp;
  protected ImageView vxq;
  protected LinearLayout vxr;
  protected ImageView vxs;
  protected TextView vxt;
  protected TextView vxu;
  protected ImageView vxv;
  protected TextView vxw;
  protected TextView vxx;
  protected LinearLayout vxy;
  protected ImageView vxz;
  
  static
  {
    GMTrace.i(2367466504192L, 17639);
    lLm = new int[] { R.h.bAX, R.h.bAY, R.h.bAZ, R.h.bBa, R.h.bBb };
    GMTrace.o(2367466504192L, 17639);
  }
  
  public n(int paramInt)
  {
    super(paramInt);
    GMTrace.i(2366392762368L, 17631);
    this.vwx = 0;
    this.vxC = Integer.MAX_VALUE;
    this.quE = new ArrayList();
    GMTrace.o(2366392762368L, 17631);
  }
  
  private static void a(En_5b8fbb1e.a parama, n paramn, int paramInt, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3, int[] paramArrayOfInt1, String[] paramArrayOfString4, String[] paramArrayOfString5, int[] paramArrayOfInt2, String paramString)
  {
    GMTrace.i(2367332286464L, 17638);
    int i = 0;
    while (i <= 4)
    {
      localObject1 = (MMImageView)paramn.vxo.findViewById(lLm[i]);
      if (localObject1 != null)
      {
        ((MMImageView)localObject1).setImageDrawable(null);
        ((MMImageView)localObject1).setVisibility(8);
      }
      i += 1;
    }
    Object localObject1 = (ImageView)paramn.vxo.findViewById(R.h.bBc);
    Object localObject2 = (TextView)paramn.vxo.findViewById(R.h.bAW);
    if (localObject1 != null) {
      ((ImageView)localObject1).setVisibility(8);
    }
    if (localObject2 != null) {
      ((TextView)localObject2).setVisibility(8);
    }
    i = 0;
    if (i < paramInt)
    {
      if (paramInt == 1)
      {
        localObject1 = (MMImageView)paramn.vxo.findViewById(lLm[i]);
        ((MMImageView)localObject1).setImageResource(R.k.dvy);
        label157:
        ((MMImageView)localObject1).setVisibility(0);
        an.bDb().a(parama.vzN, paramArrayOfString1[i], bf.NA(), paramArrayOfString2[i], paramArrayOfString3[i], paramArrayOfInt1[i], paramString);
        localObject2 = com.tencent.mm.ah.n.GT().m("Note_" + paramArrayOfString1[i], "", "");
        if (!FileOp.aO((String)localObject2)) {
          break label324;
        }
        localObject2 = com.tencent.mm.ah.n.GT().a((String)localObject2, com.tencent.mm.bg.a.getDensity(aa.getContext()));
        if ((localObject2 == null) || (((Bitmap)localObject2).isRecycled())) {
          break label313;
        }
        ((MMImageView)localObject1).setImageBitmap((Bitmap)localObject2);
      }
      for (;;)
      {
        i += 1;
        break;
        localObject1 = (MMImageView)paramn.vxo.findViewById(lLm[(i + 1)]);
        ((MMImageView)localObject1).setImageResource(R.k.dvx);
        break label157;
        label313:
        ((MMImageView)localObject1).setImageResource(R.k.dvx);
        continue;
        label324:
        an.bDb().a(parama.vzN, paramArrayOfString1[i], bf.NA(), paramArrayOfString4[i], paramArrayOfString5[i], paramArrayOfInt2[i], paramString);
        com.tencent.mm.ah.n.GT().m("Note_" + paramArrayOfString1[i], "", "");
        com.tencent.mm.bg.a.fromDPToPix(parama.uRf.uRz, 45);
        if (FileOp.aO((String)localObject2))
        {
          localObject2 = com.tencent.mm.ah.n.GT().a((String)localObject2, com.tencent.mm.bg.a.getDensity(aa.getContext()));
          if ((localObject2 != null) && (!((Bitmap)localObject2).isRecycled())) {
            ((MMImageView)localObject1).setImageBitmap((Bitmap)localObject2);
          } else {
            ((MMImageView)localObject1).setImageResource(R.k.dvx);
          }
        }
        else
        {
          v.i("MicroMsg.AppMsgViewHolder", "thumb file not exist!");
        }
      }
    }
    GMTrace.o(2367332286464L, 17638);
  }
  
  static void a(En_5b8fbb1e.a parama, n paramn, f.a parama1, au paramau, boolean paramBoolean)
  {
    GMTrace.i(2367198068736L, 17637);
    Object localObject1 = new lz();
    ((lz)localObject1).fSV.type = 0;
    ((lz)localObject1).fSV.fSX = parama1.hhG;
    com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject1);
    Object localObject2 = ((lz)localObject1).fSW.fTf;
    paramn.vxl.setVisibility(8);
    String[] arrayOfString1 = new String[4];
    String[] arrayOfString2 = new String[4];
    int[] arrayOfInt1 = new int[4];
    String[] arrayOfString3 = new String[4];
    String[] arrayOfString4 = new String[4];
    int[] arrayOfInt2 = new int[4];
    String[] arrayOfString5 = new String[4];
    Object localObject3;
    int i;
    int k;
    Object localObject4;
    label268:
    String str;
    if (localObject2 != null)
    {
      parama1 = bf.ap(((com.tencent.mm.protocal.b.a.c)localObject2).desc, parama1.description);
      localObject3 = ((com.tencent.mm.protocal.b.a.c)localObject2).hkc.iterator();
      i = 0;
      localObject1 = null;
      k = 0;
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (rl)((Iterator)localObject3).next();
        if ((bf.mA(((rl)localObject4).tvP)) || (!((rl)localObject4).tvP.equals(".htm")) || (bf.mA(((rl)localObject4).twC)) || (!((rl)localObject4).twC.equals("WeNoteHtmlFile"))) {
          switch (((rl)localObject4).aMw)
          {
          case 3: 
          case 6: 
          case 4: 
          case 5: 
          case 7: 
          default: 
          case 1: 
            do
            {
              do
              {
                break;
              } while (k != 0);
              str = ((rl)localObject4).desc;
            } while (bf.mA(str));
            if (bf.mA(str.replaceAll("\n", "").trim())) {
              break label1209;
            }
            localObject1 = ((rl)localObject4).desc.replaceAll("&lt;", "<").replaceAll("&gt;", ">");
          }
        }
      }
    }
    label636:
    label1200:
    label1203:
    label1209:
    for (;;)
    {
      k = 1;
      break;
      if (paramBoolean)
      {
        paramn.vxl.setVisibility(0);
        paramn.vwA.setVisibility(0);
        paramn.vwA.setImageResource(R.g.bbX);
      }
      if (i < 4)
      {
        arrayOfString1[i] = ((rl)localObject4).hho;
        arrayOfString2[i] = ((rl)localObject4).tvw;
        arrayOfInt1[i] = ((int)((rl)localObject4).twg);
        arrayOfString3[i] = ((rl)localObject4).tvA;
        arrayOfString4[i] = ((rl)localObject4).tvC;
        arrayOfInt2[i] = ((int)((rl)localObject4).tvV);
        arrayOfString5[i] = ((rl)localObject4).lII;
      }
      i += 1;
      break;
      if (!bf.mA(parama1)) {
        break label268;
      }
      parama1 = aa.getContext().getString(R.l.dHf) + ((rl)localObject4).title;
      break label268;
      if (localObject1 != null)
      {
        localObject4 = ((String)localObject1).split("\n", 2);
        localObject3 = new ArrayList();
        if (localObject4.length > 0)
        {
          int m = localObject4.length;
          j = 0;
          while (j < m)
          {
            str = localObject4[j];
            if (str.length() > 0) {
              ((ArrayList)localObject3).add(str);
            }
            j += 1;
          }
        }
        if (((ArrayList)localObject3).size() != 1) {
          break label1203;
        }
      }
      for (int j = 1;; j = 0)
      {
        if ((((ArrayList)localObject3).size() == 1) && (((com.tencent.mm.protocal.b.a.c)localObject2).hkc.size() == 2))
        {
          localObject2 = aa.getContext().getString(R.l.ejH);
          parama1 = (f.a)localObject1;
          localObject1 = localObject2;
          localObject1 = ((String)localObject1).trim();
          localObject2 = localObject1;
          if (localObject1 != null) {
            localObject2 = ((String)localObject1).replaceAll("&lt;", "<").replaceAll("&gt;", ">");
          }
          localObject1 = h.c(paramn.mwR.getContext(), (CharSequence)localObject2, (int)paramn.mwR.getTextSize());
          paramn.mwR.setText((CharSequence)localObject1);
          if ((parama1 == null) || (parama1.length() <= 100)) {
            break label1200;
          }
          parama1 = parama1.substring(0, 100).replaceAll("&lt;", "<").replaceAll("&gt;", ">");
        }
        for (;;)
        {
          parama1 = h.c(paramn.ipd.getContext(), parama1, (int)paramn.ipd.getTextSize());
          paramn.ipd.setText(parama1);
          if (i > 0)
          {
            paramn.vxl.setVisibility(8);
            if ((j != 0) || (k == 0))
            {
              paramn.ipd.setVisibility(8);
              paramn.mwR.setMaxLines(2);
              paramn.vxq.setVisibility(8);
              paramn.vxp.setLayoutResource(R.i.cXV);
            }
            try
            {
              paramn.vxo = ((LinearLayout)paramn.vxp.inflate());
              if (i > 4)
              {
                j = 4;
                a(parama, paramn, j, arrayOfString5, arrayOfString2, arrayOfString1, arrayOfInt1, arrayOfString4, arrayOfString3, arrayOfInt2, paramau.field_talker);
                parama = (ImageView)paramn.vxo.findViewById(R.h.bBc);
                paramn = (TextView)paramn.vxo.findViewById(R.h.bAW);
                paramn.setTextSize(0, aa.getContext().getResources().getDimensionPixelSize(R.f.aXH));
                if (i > 4)
                {
                  if (parama != null) {
                    parama.setVisibility(0);
                  }
                  if (paramn != null)
                  {
                    paramn.setText("(" + i + ")");
                    paramn.setVisibility(0);
                  }
                }
                GMTrace.o(2367198068736L, 17637);
                return;
                if (i > 0)
                {
                  localObject1 = (String)((ArrayList)localObject3).get(0);
                  if (((ArrayList)localObject3).size() > 1)
                  {
                    parama1 = (String)((ArrayList)localObject3).get(1);
                    break;
                  }
                  parama1 = null;
                  break;
                }
                localObject2 = (String)((ArrayList)localObject3).get(0);
                localObject3 = parama1.split(Pattern.quote((String)localObject2), 2);
                parama1 = localObject3[0].trim();
                localObject1 = localObject2;
                if (localObject3.length <= 1) {
                  break;
                }
                parama1 = (localObject3[0].trim() + "\n" + localObject3[1].trim()).trim();
                localObject1 = localObject2;
                break;
                localObject1 = aa.getContext().getString(R.l.ejH);
                j = 0;
                break label636;
                paramn.ipd.setMaxLines(1);
                paramn.ipd.setVisibility(0);
                paramn.mwR.setMaxLines(1);
              }
            }
            catch (Exception parama1)
            {
              for (;;)
              {
                paramn.vxp.setVisibility(0);
                continue;
                j = i;
              }
            }
          }
          paramn.vxp.setVisibility(8);
          paramn.vxq.setVisibility(0);
          GMTrace.o(2367198068736L, 17637);
          return;
        }
      }
    }
  }
  
  static void a(En_5b8fbb1e.a parama, n paramn, f.a parama1, boolean paramBoolean)
  {
    GMTrace.i(16777618653184L, 125003);
    paramn.ipc.setVisibility(8);
    Object localObject1;
    label60:
    Object localObject2;
    Object localObject4;
    label224:
    Object localObject3;
    Iterator localIterator;
    int i;
    if ((parama1.title != null) && (parama1.title.trim().length() > 0))
    {
      localObject1 = parama1.title;
      paramn.mwR.setVisibility(0);
      paramn.mwR.setMaxLines(2);
      paramn.ipd.setMaxLines(4);
      paramn.vxe.setVisibility(8);
      paramn.vxa.setVisibility(4);
      if (paramBoolean) {
        paramn.vwA.setVisibility(8);
      }
      localObject2 = new lz();
      ((lz)localObject2).fSV.type = 0;
      ((lz)localObject2).fSV.fSX = parama1.hhG;
      com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject2);
      localObject4 = ((lz)localObject2).fSW.fTf;
      if (localObject4 == null) {
        break label1312;
      }
      localObject2 = h.b(paramn.mwR.getContext(), bf.ap(((com.tencent.mm.protocal.b.a.c)localObject4).title, parama1.title), paramn.mwR.getTextSize());
      paramn.mwR.setText((CharSequence)localObject2);
      localObject2 = ((com.tencent.mm.protocal.b.a.c)localObject4).desc;
      if (localObject2 != null) {
        break label608;
      }
      v.e("MicroMsg.AppMsgViewHolder", "recordMsg desc is null !! recordInfo = [%s]", new Object[] { parama1.hhG });
      localObject3 = localObject2;
      if (localObject2 != null)
      {
        localObject3 = localObject2;
        if (((String)localObject2).length() > 100) {
          localObject3 = ((String)localObject2).substring(0, 100);
        }
      }
      paramn.ipd.setText(h.b(paramn.ipd.getContext(), bf.ap((String)localObject3, parama1.description), paramn.ipd.getTextSize()));
      localIterator = ((com.tencent.mm.protocal.b.a.c)localObject4).hkc.iterator();
      localObject3 = null;
      localObject2 = null;
      i = 0;
    }
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label1166;
      }
      rl localrl = (rl)localIterator.next();
      if ((bf.mA(localrl.tvP)) || (!localrl.tvP.equals(".htm")) || (bf.mA(localrl.twC)) || (!localrl.twC.equals("WeNoteHtmlFile")))
      {
        Object localObject5;
        int j;
        if (localrl.twu.twM.txi != null)
        {
          localObject5 = parama.uRf.uRz.getString(R.l.eIx);
          j = 1;
          localObject4 = localObject2;
          parama1 = (f.a)localObject3;
        }
        for (;;)
        {
          i = j;
          localObject3 = parama1;
          localObject2 = localObject4;
          localObject1 = localObject5;
          switch (localrl.aMw)
          {
          case 1: 
          case 9: 
          case 12: 
          case 13: 
          case 15: 
          default: 
            i = j;
            localObject3 = parama1;
            localObject2 = localObject4;
            localObject1 = localObject5;
            break;
          case 2: 
            i = j;
            localObject3 = parama1;
            localObject2 = localObject4;
            localObject1 = localObject5;
            if (!paramBoolean) {
              break;
            }
            paramn.vwA.setVisibility(0);
            paramn.vwA.setImageResource(R.g.bbX);
            i = j;
            localObject3 = parama1;
            localObject2 = localObject4;
            localObject1 = localObject5;
            break;
            paramn.mwR.setVisibility(8);
            localObject1 = null;
            break label60;
            label608:
            localObject2 = ((String)localObject2).replaceAll("&lt;", "<").replaceAll("&gt;", ">");
            break label224;
            j = i;
            parama1 = (f.a)localObject3;
            localObject4 = localObject2;
            localObject5 = localObject1;
            if (localrl.twu.twM.fOl != null) {
              if (localObject2 == null)
              {
                localObject4 = localrl.tww;
                j = i;
                parama1 = (f.a)localObject3;
                localObject5 = localObject1;
              }
              else
              {
                j = i;
                parama1 = (f.a)localObject3;
                localObject4 = localObject2;
                localObject5 = localObject1;
                if (localObject2 != localrl.tww)
                {
                  parama1 = localrl.tww;
                  j = i;
                  localObject4 = localObject2;
                  localObject5 = localObject1;
                }
              }
            }
            break;
          }
        }
        i = j;
        localObject3 = parama1;
        localObject2 = localObject4;
        localObject1 = localObject5;
        if (paramBoolean)
        {
          paramn.vwA.setVisibility(0);
          paramn.vwA.setImageResource(R.k.dtj);
          i = j;
          localObject3 = parama1;
          localObject2 = localObject4;
          localObject1 = localObject5;
          continue;
          i = j;
          localObject3 = parama1;
          localObject2 = localObject4;
          localObject1 = localObject5;
          if (paramBoolean)
          {
            paramn.vwA.setVisibility(0);
            paramn.vwA.setImageResource(R.k.dtk);
            i = j;
            localObject3 = parama1;
            localObject2 = localObject4;
            localObject1 = localObject5;
            continue;
            if (paramBoolean)
            {
              paramn.vwA.setVisibility(0);
              paramn.vwA.setImageResource(R.k.dth);
            }
            paramn.vxe.setVisibility(0);
            paramn.vxe.setImageResource(R.g.bkU);
            i = j;
            localObject3 = parama1;
            localObject2 = localObject4;
            localObject1 = localObject5;
            continue;
            paramn.vwA.setVisibility(0);
            paramn.vwA.setImageResource(R.k.dsV);
            i = j;
            localObject3 = parama1;
            localObject2 = localObject4;
            localObject1 = localObject5;
            continue;
            if (paramBoolean)
            {
              paramn.vwA.setVisibility(0);
              paramn.vwA.setImageResource(R.k.dsW);
            }
            paramn.vxe.setVisibility(0);
            paramn.vxe.setImageResource(R.g.bhn);
            i = j;
            localObject3 = parama1;
            localObject2 = localObject4;
            localObject1 = localObject5;
            continue;
            i = j;
            localObject3 = parama1;
            localObject2 = localObject4;
            localObject1 = localObject5;
            if (paramBoolean)
            {
              paramn.vwA.setVisibility(0);
              paramn.vwA.setImageResource(com.tencent.mm.pluginsdk.c.LB(localrl.tvP));
              i = j;
              localObject3 = parama1;
              localObject2 = localObject4;
              localObject1 = localObject5;
              continue;
              i = j;
              localObject3 = parama1;
              localObject2 = localObject4;
              localObject1 = localObject5;
              if (paramBoolean)
              {
                paramn.vwA.setVisibility(0);
                paramn.vwA.setImageResource(R.k.dte);
                i = j;
                localObject3 = parama1;
                localObject2 = localObject4;
                localObject1 = localObject5;
                continue;
                i = j;
                localObject3 = parama1;
                localObject2 = localObject4;
                localObject1 = localObject5;
                if (paramBoolean)
                {
                  paramn.vwA.setVisibility(0);
                  paramn.vwA.setImageResource(R.g.ber);
                  i = j;
                  localObject3 = parama1;
                  localObject2 = localObject4;
                  localObject1 = localObject5;
                }
              }
            }
          }
        }
      }
    }
    label1166:
    if ((localObject2 != null) && (localObject3 == null) && (i == 0)) {
      parama1 = parama.uRf.uRz.getString(R.l.eiU, new Object[] { localObject2 });
    }
    for (;;)
    {
      if (!bf.mA(parama1)) {
        paramn.mwR.setText(parama1);
      }
      paramn.vwA.setVisibility(8);
      paramn.vxl.setVisibility(8);
      GMTrace.o(16777618653184L, 125003);
      return;
      parama1 = (f.a)localObject1;
      if (localObject2 != null)
      {
        parama1 = (f.a)localObject1;
        if (localObject3 != null)
        {
          parama1 = (f.a)localObject1;
          if (localObject2 != localObject3)
          {
            parama1 = (f.a)localObject1;
            if (i == 0)
            {
              parama1 = parama.uRf.uRz.getString(R.l.eiT, new Object[] { localObject2, localObject3 });
              continue;
              label1312:
              parama1 = (f.a)localObject1;
            }
          }
        }
      }
    }
  }
  
  public static void a(n paramn, Boolean paramBoolean, au paramau, String paramString1, final String paramString2)
  {
    GMTrace.i(2366929633280L, 17635);
    final long l = paramau.field_msgId;
    com.tencent.mm.pluginsdk.model.app.b localb = an.abF().eb(l);
    if (localb == null)
    {
      v.w("MicroMsg.AppMsgViewHolder", "attach info is null, msgId: %s, attachName: %s", new Object[] { Long.valueOf(l), paramString2 });
      GMTrace.o(2366929633280L, 17635);
      return;
    }
    if (paramBoolean.booleanValue()) {
      if (localb.field_status == 101L)
      {
        paramn.vxd.setVisibility(0);
        paramn.vxb.setVisibility(0);
      }
    }
    for (;;)
    {
      if (paramau.field_status == 5)
      {
        paramn.vxd.setVisibility(8);
        paramn.vxc.setVisibility(8);
      }
      paramn.vxd.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(2383706849280L, 17760);
          if (this.vxD.booleanValue())
          {
            l = l;
            paramAnonymousView = this.vxE;
            localb = an.abF().eb(l);
            if (localb == null)
            {
              v.e("MicroMsg.AppMsgLogic", "ERR:" + g.sd() + " getinfo failed: " + paramAnonymousView);
              GMTrace.o(2383706849280L, 17760);
              return;
            }
            if (localb.field_status != 101L)
            {
              v.e("MicroMsg.AppMsgLogic", "ERR:" + g.sd() + " get status failed: " + paramAnonymousView + " status:" + localb.field_status);
              GMTrace.o(2383706849280L, 17760);
              return;
            }
            localb.field_status = 102L;
            localb.field_lastModifyTime = bf.Nz();
            an.abF().c(localb, new String[0]);
            GMTrace.o(2383706849280L, 17760);
            return;
          }
          long l = l;
          paramAnonymousView = this.vxE;
          com.tencent.mm.pluginsdk.model.app.b localb = an.abF().eb(l);
          if (localb == null)
          {
            v.e("MicroMsg.AppMsgLogic", "ERR:" + g.sd() + " getinfo failed: " + paramAnonymousView);
            GMTrace.o(2383706849280L, 17760);
            return;
          }
          if (localb.field_status != 101L)
          {
            v.e("MicroMsg.AppMsgLogic", "ERR:" + g.sd() + " get status failed: " + paramAnonymousView + " status:" + localb.field_status);
            GMTrace.o(2383706849280L, 17760);
            return;
          }
          if ((bf.mA(localb.field_clientAppDataId)) && (!bf.mA(localb.field_mediaSvrId))) {}
          for (localb.field_status = 102L;; localb.field_status = 105L)
          {
            localb.field_lastModifyTime = bf.Nz();
            an.abF().c(localb, new String[0]);
            GMTrace.o(2383706849280L, 17760);
            return;
          }
        }
      });
      paramn.vxc.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(2186675224576L, 16292);
          if (!this.vxD.booleanValue())
          {
            long l = l;
            paramAnonymousView = this.vxE;
            com.tencent.mm.pluginsdk.model.app.b localb = an.abF().eb(l);
            if (localb == null)
            {
              v.e("MicroMsg.AppMsgLogic", "ERR:" + g.sd() + " getinfo failed: " + paramAnonymousView);
              GMTrace.o(2186675224576L, 16292);
              return;
            }
            if (localb.field_status != 105L)
            {
              v.e("MicroMsg.AppMsgLogic", "ERR:" + g.sd() + " get status failed: " + paramAnonymousView + " status:" + localb.field_status);
              GMTrace.o(2186675224576L, 16292);
              return;
            }
            localb.field_status = 101L;
            localb.field_lastModifyTime = bf.Nz();
            an.abF().c(localb, new String[0]);
            an.bDe().run();
          }
          GMTrace.o(2186675224576L, 16292);
        }
      });
      GMTrace.o(2366929633280L, 17635);
      return;
      if (localb.field_status == 102L)
      {
        paramn.vxd.setVisibility(8);
        paramn.vxb.setVisibility(8);
      }
      else
      {
        paramn.vxd.setVisibility(8);
        paramn.vxb.setVisibility(8);
        continue;
        if (localb.field_status == 101L)
        {
          paramn.vxd.setVisibility(0);
          paramn.vxc.setVisibility(8);
        }
        else if (localb.field_status == 105L)
        {
          paramn.vxd.setVisibility(8);
          paramn.vxc.setVisibility(0);
        }
        else
        {
          paramn.vxd.setVisibility(8);
          paramn.vxc.setVisibility(8);
        }
      }
    }
  }
  
  public static void a(n paramn, String paramString, int paramInt)
  {
    GMTrace.i(2366795415552L, 17634);
    int i = com.tencent.mm.pluginsdk.model.app.l.Mf(paramString);
    if ((i == -1) || (i >= 100) || (paramInt <= 0))
    {
      paramn.vxb.setVisibility(8);
      GMTrace.o(2366795415552L, 17634);
      return;
    }
    paramn.vxb.setVisibility(0);
    paramn.vxb.setProgress(i);
    GMTrace.o(2366795415552L, 17634);
  }
  
  public final n q(View paramView, boolean paramBoolean)
  {
    GMTrace.i(2366526980096L, 17632);
    super.dl(paramView);
    this.vwA = ((MMImageView)paramView.findViewById(R.h.bzG));
    this.ipc = ((TextView)paramView.findViewById(R.h.bzI));
    this.mwR = ((TextView)paramView.findViewById(R.h.bzJ));
    this.ipd = ((TextView)paramView.findViewById(R.h.bzu));
    this.lLh = ((TextView)paramView.findViewById(R.h.bzD));
    this.vwW = ((ImageView)paramView.findViewById(R.h.bzA));
    this.vwY = ((TextView)paramView.findViewById(R.h.bzC));
    this.vwX = ((ImageView)paramView.findViewById(R.h.bzB));
    this.vwZ = ((LinearLayout)paramView.findViewById(R.h.bzz));
    this.vxa = ((ImageView)paramView.findViewById(R.h.bzE));
    this.vxb = ((MMPinProgressBtn)paramView.findViewById(R.h.bAn));
    this.vxc = ((ImageView)this.mgy.findViewById(R.h.bAg));
    this.vxd = ((ImageView)this.mgy.findViewById(R.h.bBs));
    this.vxe = ((ImageView)paramView.findViewById(R.h.bzv));
    this.vwP = ((TextView)paramView.findViewById(R.h.bzr));
    this.vxg = ((ImageView)paramView.findViewById(R.h.bzy));
    this.mdQ = ((CheckBox)paramView.findViewById(R.h.bzW));
    this.nQv = paramView.findViewById(R.h.bAQ);
    this.phd = ((TextView)paramView.findViewById(R.h.bBz));
    this.vxf = ((ChattingItemFooter)paramView.findViewById(R.h.aTR));
    this.vxh = ((LinearLayout)paramView.findViewById(R.h.bpB));
    this.vxi = ((ViewGroup)paramView.findViewById(R.h.cch));
    this.vxj = ((TextView)paramView.findViewById(R.h.ccf));
    this.vxk = ((LinearLayout)paramView.findViewById(R.h.bzK));
    this.vxm = ((FrameLayout)paramView.findViewById(R.h.bzX));
    this.vxn = ((LinearLayout)paramView.findViewById(R.h.bzs));
    this.stu = ((ImageView)paramView.findViewById(R.h.bAe));
    this.vxl = ((RelativeLayout)paramView.findViewById(R.h.bzF));
    this.vxp = ((ViewStub)paramView.findViewById(R.h.coy));
    this.vxq = ((ImageView)paramView.findViewById(R.h.bAj));
    if (!paramBoolean)
    {
      this.vwJ = ((ImageView)this.mgy.findViewById(R.h.bBr));
      this.oCh = ((ProgressBar)this.mgy.findViewById(R.h.cKO));
    }
    this.vxy = ((LinearLayout)paramView.findViewById(R.h.bzk));
    this.vxz = ((ImageView)paramView.findViewById(R.h.bzl));
    this.vxA = ((ImageView)paramView.findViewById(R.h.bMm));
    this.vxB = ((TextView)paramView.findViewById(R.h.bzn));
    this.vxr = ((LinearLayout)paramView.findViewById(R.h.bzj));
    this.vxs = ((ImageView)paramView.findViewById(R.h.bzh));
    this.vxt = ((TextView)paramView.findViewById(R.h.bzi));
    this.vxu = ((TextView)paramView.findViewById(R.h.bzm));
    this.vxv = ((ImageView)paramView.findViewById(R.h.bzo));
    this.vxw = ((TextView)paramView.findViewById(R.h.bzq));
    this.vxx = ((TextView)paramView.findViewById(R.h.bzp));
    if ((this.mwR != null) && (Build.VERSION.SDK_INT >= 16)) {
      this.vxC = this.mwR.getMaxLines();
    }
    this.vwx = ag.eT(aa.getContext());
    GMTrace.o(2366526980096L, 17632);
    return this;
  }
  
  public final void reset()
  {
    GMTrace.i(2366661197824L, 17633);
    if (this.mwR != null) {
      this.mwR.setMaxLines(this.vxC);
    }
    GMTrace.o(2366661197824L, 17633);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */