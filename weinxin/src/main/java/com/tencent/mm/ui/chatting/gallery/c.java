package com.tencent.mm.ui.chatting.gallery;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.n;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelbiz.e;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.f.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.k;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class c
  extends k<au>
  implements View.OnClickListener
{
  private static Map<String, Integer> ssz;
  private static Map<String, Integer> vOJ;
  private LayoutInflater Du;
  public boolean hPG;
  protected com.tencent.mm.ah.a.a.c kuE;
  String kuX;
  Context mContext;
  boolean sLe;
  private boolean sWq;
  long vNv;
  private final ImageGalleryGridUI vOH;
  boolean vOI;
  
  static
  {
    GMTrace.i(2482893750272L, 18499);
    HashMap localHashMap = new HashMap();
    ssz = localHashMap;
    localHashMap.put("avi", Integer.valueOf(R.k.dti));
    ssz.put("m4v", Integer.valueOf(R.k.dti));
    ssz.put("vob", Integer.valueOf(R.k.dti));
    ssz.put("mpeg", Integer.valueOf(R.k.dti));
    ssz.put("mpe", Integer.valueOf(R.k.dti));
    ssz.put("asx", Integer.valueOf(R.k.dti));
    ssz.put("asf", Integer.valueOf(R.k.dti));
    ssz.put("f4v", Integer.valueOf(R.k.dti));
    ssz.put("flv", Integer.valueOf(R.k.dti));
    ssz.put("mkv", Integer.valueOf(R.k.dti));
    ssz.put("wmv", Integer.valueOf(R.k.dti));
    ssz.put("wm", Integer.valueOf(R.k.dti));
    ssz.put("3gp", Integer.valueOf(R.k.dti));
    ssz.put("mp4", Integer.valueOf(R.k.dti));
    ssz.put("rmvb", Integer.valueOf(R.k.dti));
    ssz.put("rm", Integer.valueOf(R.k.dti));
    ssz.put("ra", Integer.valueOf(R.k.dti));
    ssz.put("ram", Integer.valueOf(R.k.dti));
    ssz.put("mp3pro", Integer.valueOf(R.k.dsX));
    ssz.put("vqf", Integer.valueOf(R.k.dsX));
    ssz.put("cd", Integer.valueOf(R.k.dsX));
    ssz.put("md", Integer.valueOf(R.k.dsX));
    ssz.put("mod", Integer.valueOf(R.k.dsX));
    ssz.put("vorbis", Integer.valueOf(R.k.dsX));
    ssz.put("au", Integer.valueOf(R.k.dsX));
    ssz.put("amr", Integer.valueOf(R.k.dsX));
    ssz.put("silk", Integer.valueOf(R.k.dsX));
    ssz.put("wma", Integer.valueOf(R.k.dsX));
    ssz.put("mmf", Integer.valueOf(R.k.dsX));
    ssz.put("mid", Integer.valueOf(R.k.dsX));
    ssz.put("midi", Integer.valueOf(R.k.dsX));
    ssz.put("mp3", Integer.valueOf(R.k.dsX));
    ssz.put("aac", Integer.valueOf(R.k.dsX));
    ssz.put("ape", Integer.valueOf(R.k.dsX));
    ssz.put("aiff", Integer.valueOf(R.k.dsX));
    ssz.put("aif", Integer.valueOf(R.k.dsX));
    ssz.put("doc", Integer.valueOf(R.k.dtm));
    ssz.put("docx", Integer.valueOf(R.k.dtm));
    ssz.put("ppt", Integer.valueOf(R.k.dtb));
    ssz.put("pptx", Integer.valueOf(R.k.dtb));
    ssz.put("xls", Integer.valueOf(R.k.dsT));
    ssz.put("xlsx", Integer.valueOf(R.k.dsT));
    ssz.put("pdf", Integer.valueOf(R.k.dsZ));
    ssz.put("unknown", Integer.valueOf(R.k.dtf));
    localHashMap = new HashMap();
    vOJ = localHashMap;
    localHashMap.put("doc", Integer.valueOf(R.e.aSK));
    vOJ.put("docx", Integer.valueOf(R.e.aSK));
    vOJ.put("ppt", Integer.valueOf(R.e.aSN));
    vOJ.put("pptx", Integer.valueOf(R.e.aSN));
    vOJ.put("xls", Integer.valueOf(R.e.aSQ));
    vOJ.put("xlsx", Integer.valueOf(R.e.aSQ));
    vOJ.put("pdf", Integer.valueOf(R.e.aSM));
    vOJ.put("unknown", Integer.valueOf(R.e.aSO));
    vOJ.put("mp3pro", Integer.valueOf(R.e.aSL));
    vOJ.put("vqf", Integer.valueOf(R.e.aSL));
    vOJ.put("cd", Integer.valueOf(R.e.aSL));
    vOJ.put("md", Integer.valueOf(R.e.aSL));
    vOJ.put("mod", Integer.valueOf(R.e.aSL));
    vOJ.put("vorbis", Integer.valueOf(R.e.aSL));
    vOJ.put("au", Integer.valueOf(R.e.aSL));
    vOJ.put("amr", Integer.valueOf(R.e.aSL));
    vOJ.put("silk", Integer.valueOf(R.e.aSL));
    vOJ.put("wma", Integer.valueOf(R.e.aSL));
    vOJ.put("mmf", Integer.valueOf(R.e.aSL));
    vOJ.put("mid", Integer.valueOf(R.e.aSL));
    vOJ.put("midi", Integer.valueOf(R.e.aSL));
    vOJ.put("mp3", Integer.valueOf(R.e.aSL));
    vOJ.put("aac", Integer.valueOf(R.e.aSL));
    vOJ.put("ape", Integer.valueOf(R.e.aSL));
    vOJ.put("aiff", Integer.valueOf(R.e.aSL));
    vOJ.put("aif", Integer.valueOf(R.e.aSL));
    GMTrace.o(2482893750272L, 18499);
  }
  
  public c(Context paramContext, au paramau, String paramString)
  {
    super(paramContext, paramau);
    GMTrace.i(2481283137536L, 18487);
    this.kuE = null;
    this.vOI = false;
    this.hPG = false;
    this.vOH = ((ImageGalleryGridUI)paramContext);
    this.kuX = paramString;
    this.sLe = e.dr(this.kuX);
    if (this.sLe) {
      this.vNv = paramau.field_bizChatId;
    }
    ap.yY();
    this.sWq = com.tencent.mm.u.c.isSDCardAvailable();
    this.Du = LayoutInflater.from(paramContext);
    paramau = new com.tencent.mm.ah.a.a.c.a();
    paramau.hIy = 1;
    paramau.hIS = true;
    paramau.hIA = (com.tencent.mm.bg.a.dO(paramContext) / 3);
    paramau.hIz = (com.tencent.mm.bg.a.dO(paramContext) / 3);
    paramau.hIM = R.e.aVr;
    this.kuE = paramau.Hh();
    GMTrace.o(2481283137536L, 18487);
  }
  
  private static String bc(au paramau)
  {
    GMTrace.i(2482356879360L, 18495);
    Object localObject1;
    if ((paramau.bMb()) || (paramau.bMc()))
    {
      com.tencent.mm.modelvideo.o.KW();
      localObject1 = s.lx(paramau.field_imgPath);
    }
    for (;;)
    {
      v.i("MicroMsg.ImageGalleryGridAdapter", "MsgInfoForMonetUri imgPath : %s", new Object[] { localObject1 });
      Object localObject2 = localObject1;
      if (paramau.bMf())
      {
        Object localObject3 = f.a.ek(paramau.field_content);
        localObject2 = null;
        paramau = (au)localObject2;
        if (localObject3 != null)
        {
          paramau = (au)localObject2;
          if (((f.a)localObject3).fCN != null)
          {
            paramau = (au)localObject2;
            if (((f.a)localObject3).fCN.length() > 0)
            {
              localObject3 = an.abF().LV(((f.a)localObject3).fCN);
              paramau = (au)localObject2;
              if (localObject3 != null) {
                paramau = ((com.tencent.mm.pluginsdk.model.app.b)localObject3).field_fileFullPath;
              }
            }
          }
        }
        localObject2 = localObject1;
        if (paramau != null) {
          localObject2 = paramau;
        }
      }
      GMTrace.o(2482356879360L, 18495);
      return (String)localObject2;
      localObject2 = n.GT().b(paramau.field_imgPath, false, false);
      localObject1 = localObject2;
      if (!u.mA((String)localObject2))
      {
        localObject1 = localObject2;
        if (!((String)localObject2).endsWith("hd"))
        {
          localObject1 = localObject2;
          if (FileOp.aO((String)localObject2 + "hd")) {
            localObject1 = (String)localObject2 + "hd";
          }
        }
      }
    }
  }
  
  private static int f(f.a parama)
  {
    GMTrace.i(2482088443904L, 18493);
    if (parama == null)
    {
      v.i("MicroMsg.ImageGalleryGridAdapter", "getIconId:" + R.k.dte);
      i = R.k.dtf;
      GMTrace.o(2482088443904L, 18493);
      return i;
    }
    if ((parama.type == 5) || (parama.type == 7) || (parama.type == 15))
    {
      i = R.k.dtg;
      GMTrace.o(2482088443904L, 18493);
      return i;
    }
    if (parama.type == 3)
    {
      i = R.k.dsX;
      GMTrace.o(2482088443904L, 18493);
      return i;
    }
    if ((parama.type == 6) && (ssz.containsKey(u.mz(parama.hhh))))
    {
      v.i("MicroMsg.ImageGalleryGridAdapter", "getIconId:" + ssz.get(u.mz(parama.hhh)));
      i = ((Integer)ssz.get(u.mz(parama.hhh))).intValue();
      GMTrace.o(2482088443904L, 18493);
      return i;
    }
    int i = R.k.dtf;
    GMTrace.o(2482088443904L, 18493);
    return i;
  }
  
  private static int g(f.a parama)
  {
    GMTrace.i(2482222661632L, 18494);
    if (parama == null)
    {
      v.i("MicroMsg.ImageGalleryGridAdapter", "getIconId:" + R.e.aSO);
      i = R.e.aSO;
      GMTrace.o(2482222661632L, 18494);
      return i;
    }
    if ((parama.type == 5) || (parama.type == 7) || (parama.type == 15))
    {
      i = R.e.aSP;
      GMTrace.o(2482222661632L, 18494);
      return i;
    }
    if ((parama.type == 6) && (vOJ.containsKey(u.mz(parama.hhh))))
    {
      v.i("MicroMsg.ImageGalleryGridAdapter", "getIconId:" + vOJ.get(u.mz(parama.hhh)));
      i = ((Integer)vOJ.get(u.mz(parama.hhh))).intValue();
      GMTrace.o(2482222661632L, 18494);
      return i;
    }
    int i = R.e.aSO;
    GMTrace.o(2482222661632L, 18494);
    return i;
  }
  
  public final void OL()
  {
    GMTrace.i(2481551572992L, 18489);
    if (this.sLe)
    {
      ap.yY();
      setCursor(com.tencent.mm.u.c.wU().ad(this.kuX, this.vNv));
      GMTrace.o(2481551572992L, 18489);
      return;
    }
    ap.yY();
    setCursor(com.tencent.mm.u.c.wT().Ak(this.kuX));
    GMTrace.o(2481551572992L, 18489);
  }
  
  protected final void OM()
  {
    GMTrace.i(2481685790720L, 18490);
    if (this.sLe)
    {
      ap.yY();
      setCursor(com.tencent.mm.u.c.wU().ad(this.kuX, this.vNv));
      GMTrace.o(2481685790720L, 18490);
      return;
    }
    ap.yY();
    setCursor(com.tencent.mm.u.c.wT().Ak(this.kuX));
    GMTrace.o(2481685790720L, 18490);
  }
  
  public final boolean areAllItemsEnabled()
  {
    GMTrace.i(2481417355264L, 18488);
    GMTrace.o(2481417355264L, 18488);
    return false;
  }
  
  public final long getItemId(int paramInt)
  {
    GMTrace.i(2481820008448L, 18491);
    long l = paramInt;
    GMTrace.o(2481820008448L, 18491);
    return l;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    GMTrace.i(2481954226176L, 18492);
    if (paramView == null)
    {
      paramView = this.Du.inflate(R.i.dfv, paramViewGroup, false);
      paramViewGroup = new a();
      paramViewGroup.ppc = ((ImageView)paramView.findViewById(R.h.bVs));
      paramViewGroup.vND = paramView.findViewById(R.h.cMd);
      paramViewGroup.vON = ((TextView)paramView.findViewById(R.h.bPx));
      paramViewGroup.vON.setVisibility(8);
      paramViewGroup.vOM = ((ImageView)paramView.findViewById(R.h.bPq));
      paramViewGroup.vNE = ((TextView)paramView.findViewById(R.h.cMb));
      paramViewGroup.vND.setVisibility(8);
      paramViewGroup.vNG = paramView.findViewById(R.h.cFj);
      paramViewGroup.vNG.setVisibility(8);
      paramViewGroup.vOO = paramView.findViewById(R.h.bPB);
      paramViewGroup.vOO.setVisibility(8);
      paramViewGroup.vNF = ((ImageView)paramView.findViewById(R.h.bVv));
      paramViewGroup.mdQ = ((CheckBox)paramView.findViewById(R.h.cji));
      paramViewGroup.mdR = paramView.findViewById(R.h.cjj);
      paramView.setTag(paramViewGroup);
    }
    au localau;
    for (;;)
    {
      paramViewGroup.vNG.setVisibility(8);
      paramViewGroup.vND.setVisibility(8);
      paramViewGroup.vOO.setVisibility(8);
      paramViewGroup.vON.setVisibility(8);
      localau = (au)getItem(paramInt);
      if (localau != null) {
        break;
      }
      GMTrace.o(2481954226176L, 18492);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
    Object localObject2;
    Object localObject1;
    int i;
    if (this.sWq)
    {
      if (!(this.vOH instanceof ImageGalleryGridUI)) {
        throw new IllegalArgumentException("the context should be ImageGalleryGridUI");
      }
      localObject2 = localau.field_content;
      localObject1 = null;
      if (localObject2 != null) {
        localObject1 = f.a.B((String)localObject2, localau.field_reserved);
      }
      if (this.vOH.vOP == paramInt)
      {
        paramViewGroup.vNF.setVisibility(0);
        if ((b.aU(localau)) && (localObject1 != null) && (((f.a)localObject1).type != 3))
        {
          paramViewGroup.vOM.setImageDrawable(this.vOH.getResources().getDrawable(f((f.a)localObject1)));
          paramViewGroup.ppc.setImageResource(g((f.a)localObject1));
          paramViewGroup.ppc.setPadding(0, 0, 0, 0);
          paramInt = paramViewGroup.ppc.getMeasuredWidth();
          i = paramViewGroup.ppc.getMeasuredHeight();
          if ((paramInt > 0) && (i > 0)) {
            break label775;
          }
          label443:
          if (!b.aS(localau)) {
            break label809;
          }
          if (paramViewGroup != null)
          {
            paramViewGroup.vND.setVisibility(0);
            localObject1 = i.bl(localau);
            if (localObject1 != null) {
              paramViewGroup.vNE.setText(u.ha(((r)localObject1).hZV));
            }
          }
          label490:
          paramViewGroup.mdQ.setChecked(g.a.vPK.bj(localau));
          paramViewGroup.mdQ.setTag(localau);
          paramViewGroup.mdR.setTag(paramViewGroup);
          paramViewGroup.mdR.setOnClickListener(this);
          if (!g.a.vPK.vPI) {
            break label980;
          }
          paramViewGroup.mdQ.setVisibility(0);
          paramViewGroup.mdR.setVisibility(0);
          paramViewGroup.vNF.setVisibility(0);
        }
      }
    }
    for (;;)
    {
      GMTrace.o(2481954226176L, 18492);
      return paramView;
      if ((localObject1 != null) && (((f.a)localObject1).type == 3)) {
        paramViewGroup.vOM.setImageDrawable(this.vOH.getResources().getDrawable(f((f.a)localObject1)));
      }
      n.GX().a(bc(localau), paramViewGroup.ppc, this.kuE, new com.tencent.mm.ah.a.c.i()
      {
        public final void a(String paramAnonymousString, Bitmap paramAnonymousBitmap, Object... paramAnonymousVarArgs)
        {
          GMTrace.i(2437528158208L, 18161);
          ae.v(new Runnable()
          {
            public final void run()
            {
              GMTrace.i(2440883601408L, 18186);
              GMTrace.o(2440883601408L, 18186);
            }
          });
          GMTrace.o(2437528158208L, 18161);
        }
      });
      break;
      paramViewGroup.vNF.setVisibility(0);
      paramViewGroup.vNF.setBackgroundResource(R.g.bfQ);
      if ((b.aU(localau)) && (localObject1 != null) && (((f.a)localObject1).type != 3))
      {
        paramViewGroup.vOM.setImageDrawable(this.vOH.getResources().getDrawable(f((f.a)localObject1)));
        paramViewGroup.ppc.setImageResource(g((f.a)localObject1));
        break;
      }
      if ((localObject1 != null) && (((f.a)localObject1).type == 3)) {
        paramViewGroup.vOM.setImageDrawable(this.vOH.getResources().getDrawable(f((f.a)localObject1)));
      }
      n.GX().a(bc(localau), paramViewGroup.ppc, this.kuE);
      break;
      label775:
      localObject2 = paramViewGroup.vNF.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject2).width = paramInt;
      ((ViewGroup.LayoutParams)localObject2).height = i;
      paramViewGroup.vNF.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      break label443;
      label809:
      if (b.aT(localau))
      {
        paramViewGroup.vNG.setVisibility(0);
        break label490;
      }
      if ((!b.aU(localau)) || (paramViewGroup == null)) {
        break label490;
      }
      paramViewGroup.vOO.setVisibility(0);
      paramViewGroup.vON.setVisibility(0);
      if (localObject1 == null) {
        break label490;
      }
      v.i("MicroMsg.ImageGalleryGridAdapter", "initFileName--->content:%s", new Object[] { u.mz(((f.a)localObject1).title) });
      if (((f.a)localObject1).type != 24)
      {
        paramViewGroup.vON.setText(h.b(this.mContext, u.mz(((f.a)localObject1).title), paramViewGroup.vON.getTextSize()));
        break label490;
      }
      paramViewGroup.vON.setText(h.b(paramViewGroup.vON.getContext(), paramViewGroup.vON.getContext().getString(R.l.ejH), paramViewGroup.vON.getTextSize()));
      break label490;
      paramViewGroup.ppc.setImageResource(R.g.bhN);
      break label490;
      label980:
      paramViewGroup.mdQ.setVisibility(8);
      paramViewGroup.mdR.setVisibility(8);
      paramViewGroup.vNF.setVisibility(8);
    }
  }
  
  public final void notifyDataSetChanged()
  {
    GMTrace.i(2482491097088L, 18496);
    super.notifyDataSetChanged();
    this.vOI = false;
    GMTrace.o(2482491097088L, 18496);
  }
  
  public final void onClick(View paramView)
  {
    GMTrace.i(2482625314816L, 18497);
    paramView = (a)paramView.getTag();
    if (paramView.mdQ == null)
    {
      GMTrace.o(2482625314816L, 18497);
      return;
    }
    au localau = (au)paramView.mdQ.getTag();
    if (localau == null)
    {
      GMTrace.o(2482625314816L, 18497);
      return;
    }
    g localg = g.a.vPK;
    if (localg.bj(localau))
    {
      localg.bi(localau);
      if (!g.a.vPK.bj(localau)) {
        break label163;
      }
      paramView.mdQ.setChecked(true);
      paramView.vNF.setBackgroundResource(R.e.aUk);
    }
    for (;;)
    {
      if ((!this.hPG) && (g.a.vPK.vOh.size() > 1))
      {
        com.tencent.mm.plugin.report.service.g.oSF.a(219L, 20L, 1L, true);
        this.hPG = true;
      }
      GMTrace.o(2482625314816L, 18497);
      return;
      localg.bh(localau);
      break;
      label163:
      paramView.mdQ.setChecked(false);
      paramView.vNF.setBackgroundResource(R.g.bfQ);
    }
  }
  
  protected static final class a
  {
    public CheckBox mdQ;
    public View mdR;
    public ImageView ppc;
    public View vND;
    public TextView vNE;
    public ImageView vNF;
    public View vNG;
    public ImageView vOM;
    public TextView vON;
    public View vOO;
    
    protected a()
    {
      GMTrace.i(2466653405184L, 18378);
      GMTrace.o(2466653405184L, 18378);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/gallery/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */