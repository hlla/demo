package com.tencent.mm.ui.chatting.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.t;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.ah.a.a.c.a;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.n;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.f.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.chatting.gallery.g;
import com.tencent.mm.ui.chatting.gallery.g.a;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class a
  extends RecyclerView.a
{
  public List<c> jjH;
  private com.tencent.mm.ah.a.a.c kuE;
  private String kuX;
  Context mContext;
  boolean sLe;
  private boolean sWq;
  long vNv;
  public boolean vNw;
  public b vNx;
  public boolean vNy;
  
  public a(Context paramContext, List<c> paramList, String paramString)
  {
    GMTrace.i(14928232579072L, 111224);
    this.jjH = null;
    this.kuE = null;
    this.sWq = true;
    this.sLe = false;
    this.vNy = false;
    this.jjH = paramList;
    this.kuX = paramString;
    ap.yY();
    this.sWq = com.tencent.mm.u.c.isSDCardAvailable();
    this.mContext = paramContext;
    ad(paramContext, 4);
    GMTrace.o(14928232579072L, 111224);
  }
  
  public a(Context paramContext, List<c> paramList, String paramString, long paramLong)
  {
    GMTrace.i(14928366796800L, 111225);
    this.jjH = null;
    this.kuE = null;
    this.sWq = true;
    this.sLe = false;
    this.vNy = false;
    this.jjH = paramList;
    this.vNv = paramLong;
    this.kuX = paramString;
    ap.yY();
    this.sWq = com.tencent.mm.u.c.isSDCardAvailable();
    this.sLe = true;
    this.mContext = paramContext;
    ad(paramContext, 4);
    GMTrace.o(14928366796800L, 111225);
  }
  
  private void ad(Context paramContext, int paramInt)
  {
    GMTrace.i(14928501014528L, 111226);
    c.a locala = new c.a();
    locala.hIy = 1;
    locala.hIS = true;
    locala.hIA = (com.tencent.mm.bg.a.dO(paramContext) / 4);
    locala.hIz = (com.tencent.mm.bg.a.dO(paramContext) / 4);
    locala.hIM = R.e.aVr;
    this.kuE = locala.Hh();
    GMTrace.o(14928501014528L, 111226);
  }
  
  private static long eP(long paramLong)
  {
    GMTrace.i(15332362158080L, 114235);
    Date localDate = new Date(paramLong);
    paramLong = com.tencent.mm.ui.gridviewheaders.a.bYY().a(localDate);
    GMTrace.o(15332362158080L, 114235);
    return paramLong;
  }
  
  public final c Ba(int paramInt)
  {
    GMTrace.i(14929440538624L, 111233);
    c localc = (c)this.jjH.get(paramInt);
    GMTrace.o(14929440538624L, 111233);
    return localc;
  }
  
  public final RecyclerView.t a(ViewGroup paramViewGroup, int paramInt)
  {
    GMTrace.i(14928769449984L, 111228);
    if (paramInt == Integer.MAX_VALUE)
    {
      paramViewGroup = new a(LayoutInflater.from(paramViewGroup.getContext()).inflate(R.i.ddQ, paramViewGroup, false));
      GMTrace.o(14928769449984L, 111228);
      return paramViewGroup;
    }
    paramViewGroup = new d(LayoutInflater.from(paramViewGroup.getContext()).inflate(R.i.dfv, paramViewGroup, false));
    GMTrace.o(14928769449984L, 111228);
    return paramViewGroup;
  }
  
  public final void a(RecyclerView.t paramt, int paramInt)
  {
    GMTrace.i(14929037885440L, 111230);
    if (!this.sWq)
    {
      v.e("MicroMsg.MediaHistoryGalleryAdapter", "[onBindViewHolder] isSDCardAvailable:%s", new Object[] { Boolean.valueOf(this.sWq) });
      GMTrace.o(14929037885440L, 111230);
      return;
    }
    c localc = Ba(paramInt);
    if (paramt.abi == Integer.MAX_VALUE)
    {
      if ((paramInt == getItemCount() - 1) || (eP(Ba(paramInt + 1).hTb) != eP(localc.hTb)))
      {
        ((a)paramt).ioE.setVisibility(8);
        GMTrace.o(14929037885440L, 111230);
        return;
      }
      ((a)paramt).ioE.setVisibility(0);
      ((a)paramt).ioE.setText(eO(localc.hTb));
      if (this.vNw)
      {
        ((a)paramt).jJa.setVisibility(0);
        GMTrace.o(14929037885440L, 111230);
        return;
      }
      ((a)paramt).jJa.setVisibility(8);
      GMTrace.o(14929037885440L, 111230);
      return;
    }
    ((d)paramt).ppc.setTag(Integer.valueOf(paramInt));
    ((d)paramt).mdR.setTag(Integer.valueOf(paramInt));
    n.GX().a(localc.imagePath, ((d)paramt).ppc, this.kuE);
    if (localc.nyS)
    {
      ((d)paramt).vND.setVisibility(0);
      ((d)paramt).vNE.setVisibility(0);
      ((d)paramt).vNE.setText(bf.ap(localc.vNA.vNB, ""));
    }
    while (this.vNy)
    {
      ((d)paramt).mdR.setVisibility(0);
      ((d)paramt).mdQ.setVisibility(0);
      if (g.a.vPK.bj(localc.fTa))
      {
        ((d)paramt).vNF.setVisibility(0);
        ((d)paramt).mdQ.setChecked(true);
        GMTrace.o(14929037885440L, 111230);
        return;
        ((d)paramt).vNE.setVisibility(8);
        ((d)paramt).vND.setVisibility(8);
      }
      else
      {
        ((d)paramt).vNF.setVisibility(8);
        ((d)paramt).mdQ.setChecked(false);
        GMTrace.o(14929037885440L, 111230);
        return;
      }
    }
    ((d)paramt).mdR.setVisibility(8);
    ((d)paramt).mdQ.setVisibility(8);
    GMTrace.o(14929037885440L, 111230);
  }
  
  public final void a(RecyclerView.t paramt, int paramInt, List paramList)
  {
    GMTrace.i(14928903667712L, 111229);
    if ((paramList != null) && (paramList.size() > 0) && ((paramt instanceof d)))
    {
      if (((Integer)paramList.get(0)).intValue() == 0)
      {
        ((d)paramt).mdQ.setVisibility(0);
        ((d)paramt).mdR.setVisibility(0);
        GMTrace.o(14928903667712L, 111229);
        return;
      }
      ((d)paramt).mdQ.setChecked(false);
      ((d)paramt).mdQ.setVisibility(8);
      ((d)paramt).mdR.setVisibility(8);
      GMTrace.o(14928903667712L, 111229);
      return;
    }
    super.a(paramt, paramInt, paramList);
    GMTrace.o(14928903667712L, 111229);
  }
  
  public final String eO(long paramLong)
  {
    GMTrace.i(14929172103168L, 111231);
    Object localObject = new Date(paramLong);
    localObject = com.tencent.mm.ui.gridviewheaders.a.bYY().a((Date)localObject, this.mContext);
    GMTrace.o(14929172103168L, 111231);
    return (String)localObject;
  }
  
  public final int getItemCount()
  {
    GMTrace.i(14929306320896L, 111232);
    int i = this.jjH.size();
    GMTrace.o(14929306320896L, 111232);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    GMTrace.i(14928635232256L, 111227);
    paramInt = Ba(paramInt).type;
    GMTrace.o(14928635232256L, 111227);
    return paramInt;
  }
  
  public final class a
    extends RecyclerView.t
  {
    TextView ioE;
    ProgressBar jJa;
    
    public a(View paramView)
    {
      super();
      GMTrace.i(14929977409536L, 111237);
      this.ioE = ((TextView)paramView.findViewById(R.h.bHD));
      this.jJa = ((ProgressBar)paramView.findViewById(R.h.cbB));
      GMTrace.o(14929977409536L, 111237);
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(boolean paramBoolean, a.c paramc, int paramInt);
  }
  
  public static final class c
  {
    public au fTa;
    public long hTb;
    public String imagePath;
    boolean nyS;
    public int type;
    public a vNA;
    
    public c(long paramLong)
    {
      GMTrace.i(14926621966336L, 111212);
      this.type = 0;
      this.vNA = new a();
      this.hTb = paramLong;
      this.type = Integer.MAX_VALUE;
      GMTrace.o(14926621966336L, 111212);
    }
    
    public c(au paramau)
    {
      GMTrace.i(14926487748608L, 111211);
      this.type = 0;
      this.vNA = new a();
      this.fTa = paramau;
      Object localObject1;
      Object localObject2;
      if ((paramau.bMb()) || (paramau.bMc()))
      {
        this.nyS = true;
        o.KW();
        localObject1 = s.lx(paramau.field_imgPath);
        localObject2 = t.lI(paramau.field_imgPath);
        if (localObject2 != null) {
          this.vNA.vNB = bf.ha(((r)localObject2).hZV);
        }
        this.vNA.fSK = f.a.B(paramau.field_content, paramau.field_reserved);
      }
      for (;;)
      {
        Object localObject3 = localObject1;
        if (paramau.bMf())
        {
          Object localObject4 = f.a.ek(paramau.field_content);
          localObject3 = null;
          localObject2 = localObject3;
          if (localObject4 != null)
          {
            localObject2 = localObject3;
            if (((f.a)localObject4).fCN != null)
            {
              localObject2 = localObject3;
              if (((f.a)localObject4).fCN.length() > 0)
              {
                localObject4 = an.abF().LV(((f.a)localObject4).fCN);
                localObject2 = localObject3;
                if (localObject4 != null) {
                  localObject2 = ((b)localObject4).field_fileFullPath;
                }
              }
            }
          }
          localObject3 = localObject1;
          if (localObject2 != null) {
            localObject3 = localObject2;
          }
        }
        this.imagePath = ((String)localObject3);
        this.hTb = paramau.field_createTime;
        GMTrace.o(14926487748608L, 111211);
        return;
        localObject2 = n.GT().b(paramau.field_imgPath, false, false);
        localObject1 = localObject2;
        if (!bf.mA((String)localObject2))
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
    
    public final boolean equals(Object paramObject)
    {
      GMTrace.i(14926353530880L, 111210);
      if ((this.fTa != null) && ((paramObject instanceof au)) && (paramObject != null))
      {
        if (this.fTa.field_msgId == ((au)paramObject).field_msgId)
        {
          GMTrace.o(14926353530880L, 111210);
          return true;
        }
        GMTrace.o(14926353530880L, 111210);
        return false;
      }
      boolean bool = super.equals(paramObject);
      GMTrace.o(14926353530880L, 111210);
      return bool;
    }
    
    final class a
    {
      public f.a fSK;
      public String vNB;
      
      a()
      {
        GMTrace.i(14931051151360L, 111245);
        GMTrace.o(14931051151360L, 111245);
      }
    }
  }
  
  public final class d
    extends RecyclerView.t
  {
    CheckBox mdQ;
    View mdR;
    ImageView ppc;
    View vND;
    TextView vNE;
    ImageView vNF;
    View vNG;
    
    public d(View paramView)
    {
      super();
      GMTrace.i(14930514280448L, 111241);
      this.ppc = ((ImageView)paramView.findViewById(R.h.bVs));
      this.vND = paramView.findViewById(R.h.cMd);
      this.vNG = paramView.findViewById(R.h.cFj);
      this.vNE = ((TextView)paramView.findViewById(R.h.cMb));
      this.vNF = ((ImageView)paramView.findViewById(R.h.bVv));
      this.mdQ = ((CheckBox)paramView.findViewById(R.h.cji));
      this.mdR = paramView.findViewById(R.h.cjj);
      this.mdR.setVisibility(8);
      this.mdQ.setVisibility(8);
      this.vND.setVisibility(8);
      this.vNE.setVisibility(8);
      this.vNG.setVisibility(8);
      this.ppc.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(14930380062720L, 111240);
          Object localObject = a.this.Ba(((Integer)paramAnonymousView.getTag()).intValue());
          if (localObject == null)
          {
            GMTrace.o(14930380062720L, 111240);
            return;
          }
          a locala = a.this;
          Intent localIntent = new Intent();
          localIntent.putExtra("key_biz_chat_id", locala.vNv);
          localIntent.putExtra("key_is_biz_chat", locala.sLe);
          if (localObject == null)
          {
            v.e("MicroMsg.MediaHistoryGalleryAdapter", "[enterGallery] item == null");
            GMTrace.o(14930380062720L, 111240);
            return;
          }
          localObject = ((a.c)localObject).fTa;
          if (localObject == null)
          {
            v.e("MicroMsg.MediaHistoryGalleryAdapter", "[enterGallery] msg == null");
            GMTrace.o(14930380062720L, 111240);
            return;
          }
          int k = locala.mContext.getResources().getConfiguration().orientation;
          int j = 0;
          int i = 0;
          int[] arrayOfInt = new int[2];
          if (paramAnonymousView != null)
          {
            j = paramAnonymousView.getWidth();
            i = paramAnonymousView.getHeight();
            paramAnonymousView.getLocationInWindow(arrayOfInt);
          }
          localIntent.addFlags(536870912);
          localIntent.putExtra("img_gallery_msg_id", ((ce)localObject).field_msgId).putExtra("img_gallery_msg_svr_id", ((ce)localObject).field_msgSvrId).putExtra("img_gallery_talker", ((ce)localObject).field_talker).putExtra("img_gallery_chatroom_name", ((ce)localObject).field_talker).putExtra("img_gallery_orientation", k);
          if (paramAnonymousView != null) {
            localIntent.putExtra("img_gallery_width", j).putExtra("img_gallery_height", i).putExtra("img_gallery_left", arrayOfInt[0]).putExtra("img_gallery_top", arrayOfInt[1]).putExtra("img_gallery_enter_from_grid", true);
          }
          for (;;)
          {
            d.a(locala.mContext, "com.tencent.mm.ui.chatting.gallery.ImageGalleryUI", localIntent);
            ((Activity)locala.mContext).overridePendingTransition(0, 0);
            GMTrace.o(14930380062720L, 111240);
            return;
            localIntent.putExtra("img_gallery_back_from_grid", true);
          }
        }
      });
      this.mdR.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(14926219313152L, 111209);
          boolean bool;
          if (!a.d.this.mdQ.isChecked())
          {
            bool = true;
            if (g.a.vPK.vOh.size() >= 9) {
              break label146;
            }
            a.d.this.mdQ.setChecked(bool);
            if (bool) {
              break label132;
            }
            a.d.this.vNF.setVisibility(8);
          }
          for (;;)
          {
            if (a.this.vNx != null)
            {
              int i = ((Integer)paramAnonymousView.getTag()).intValue();
              paramAnonymousView = a.this.Ba(i);
              a.this.vNx.a(bool, paramAnonymousView, i);
            }
            GMTrace.o(14926219313152L, 111209);
            return;
            bool = false;
            break;
            label132:
            a.d.this.vNF.setVisibility(0);
            continue;
            label146:
            if (!bool) {
              a.d.this.mdQ.setChecked(false);
            }
          }
        }
      });
      GMTrace.o(14930514280448L, 111241);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */