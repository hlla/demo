package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.ah.a.a.c;
import com.tencent.mm.ah.n;
import com.tencent.mm.e.b.af;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.comm.a.c;
import com.tencent.mm.plugin.comm.a.d;
import com.tencent.mm.plugin.comm.a.e;
import com.tencent.mm.plugin.comm.a.g;
import com.tencent.mm.pluginsdk.ui.d;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class f
  extends BaseAdapter
{
  public static int sKZ;
  public static int sLa;
  boolean fNX;
  private List<String> fPh;
  private List<x> jIy;
  q krF;
  boolean ktA;
  c kuE;
  private Context mContext;
  a sLb;
  private ArrayList<x> sLd;
  boolean sLe;
  public boolean sLf;
  public boolean sLg;
  private List<Object> sLh;
  private Set<String> sLi;
  int sLj;
  int sLk;
  d sLl;
  public boolean sLm;
  public boolean sLn;
  public boolean sLo;
  private boolean sLp;
  boolean sLq;
  int sLr;
  String sLs;
  private final int sLt;
  public boolean sLu;
  private boolean sLv;
  private boolean sLw;
  boolean sLx;
  public boolean sLy;
  String username;
  
  static
  {
    GMTrace.i(941268926464L, 7013);
    sKZ = 44;
    sLa = 5;
    GMTrace.o(941268926464L, 7013);
  }
  
  public f(Context paramContext)
  {
    GMTrace.i(939389878272L, 6999);
    this.fPh = new ArrayList();
    this.sLd = new ArrayList();
    this.sLe = false;
    this.sLf = false;
    this.sLg = false;
    this.jIy = new ArrayList();
    this.sLh = new ArrayList();
    this.sLi = new HashSet();
    this.sLj = 0;
    this.sLk = 0;
    this.sLm = false;
    this.sLn = false;
    this.sLo = false;
    this.sLp = true;
    this.sLq = false;
    this.sLr = 12;
    this.sLu = false;
    this.kuE = null;
    this.sLv = true;
    this.sLw = false;
    this.sLx = true;
    this.sLy = false;
    this.mContext = paramContext;
    this.ktA = false;
    this.sLt = paramContext.getResources().getDimensionPixelSize(com.tencent.mm.plugin.comm.a.b.aWz);
    GMTrace.o(939389878272L, 6999);
  }
  
  private void bBT()
  {
    GMTrace.i(940195184640L, 7005);
    if (this.sLb != null) {
      this.sLb.bBT();
    }
    GMTrace.o(940195184640L, 7005);
  }
  
  private void bEQ()
  {
    GMTrace.i(939926749184L, 7003);
    if (this.sLd == null)
    {
      GMTrace.o(939926749184L, 7003);
      return;
    }
    v.d("MicroMsg.ContactsListArchAdapter", "initData memberContactList.size %d", new Object[] { Integer.valueOf(this.sLd.size()) });
    this.sLi.clear();
    this.jIy.clear();
    if (this.sLd.size() > 0)
    {
      Iterator localIterator = this.sLd.iterator();
      while (localIterator.hasNext())
      {
        x localx = (x)localIterator.next();
        this.jIy.add(localx);
        this.sLi.add(localx.field_username);
      }
    }
    this.sLk = this.jIy.size();
    GMTrace.o(939926749184L, 7003);
  }
  
  private b cP(View paramView)
  {
    GMTrace.i(940329402368L, 7006);
    b localb = new b();
    localb.sLz = ((ImageView)paramView.findViewById(a.d.cyU));
    localb.ipb = ((ImageView)paramView.findViewById(a.d.czd));
    localb.pkN = ((ImageView)paramView.findViewById(a.d.kBP));
    localb.jUr = ((TextView)paramView.findViewById(a.d.kBR));
    localb.kuG = ((TextView)paramView.findViewById(a.d.czc));
    localb.jUu = ((ImageView)paramView.findViewById(a.d.kBQ));
    localb.ipb.setScaleType(ImageView.ScaleType.CENTER_CROP);
    paramView.setTag(localb);
    GMTrace.o(940329402368L, 7006);
    return localb;
  }
  
  public final void ad(ArrayList<x> paramArrayList)
  {
    GMTrace.i(939792531456L, 7002);
    this.sLp = false;
    this.sLd = paramArrayList;
    GMTrace.o(939792531456L, 7002);
  }
  
  public final boolean bEP()
  {
    GMTrace.i(939524096000L, 7000);
    if (this.sLe)
    {
      bool = this.sLg;
      GMTrace.o(939524096000L, 7000);
      return bool;
    }
    boolean bool = o.dH(this.username);
    GMTrace.o(939524096000L, 7000);
    return bool;
  }
  
  public final void bw(List<String> paramList)
  {
    GMTrace.i(939658313728L, 7001);
    this.sLp = true;
    this.fPh = paramList;
    GMTrace.o(939658313728L, 7001);
  }
  
  public final int getCount()
  {
    GMTrace.i(940866273280L, 7010);
    if (this.sLq)
    {
      i = Math.min(this.sLr, this.sLj);
      GMTrace.o(940866273280L, 7010);
      return i;
    }
    int i = this.sLj;
    GMTrace.o(940866273280L, 7010);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    GMTrace.i(941000491008L, 7011);
    if (paramInt < this.sLk)
    {
      if (this.sLe)
      {
        localObject = this.sLh.get(paramInt);
        GMTrace.o(941000491008L, 7011);
        return localObject;
      }
      Object localObject = this.jIy.get(paramInt);
      GMTrace.o(941000491008L, 7011);
      return localObject;
    }
    GMTrace.o(941000491008L, 7011);
    return null;
  }
  
  public final long getItemId(int paramInt)
  {
    GMTrace.i(941134708736L, 7012);
    long l = paramInt;
    GMTrace.o(941134708736L, 7012);
    return l;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    GMTrace.i(940463620096L, 7007);
    x localx;
    int i;
    if (paramInt < this.sLk) {
      if (this.sLe)
      {
        paramViewGroup = getItem(paramInt);
        localx = null;
        i = 0;
      }
    }
    for (;;)
    {
      View localView;
      b localb;
      if (paramView == null)
      {
        localView = View.inflate(this.mContext, a.e.dmA, null);
        localb = cP(localView);
      }
      for (;;)
      {
        label61:
        int j;
        if ((sLa == 4) || (this.sLy))
        {
          j = this.mContext.getResources().getDimensionPixelSize(com.tencent.mm.plugin.comm.a.b.aXC);
          localb.ipb.getLayoutParams().height = j;
          localb.ipb.getLayoutParams().width = j;
          label116:
          localb.sLz.setVisibility(8);
          if (i != 0) {
            break label833;
          }
          localb.ipb.setVisibility(0);
          if (!this.fNX) {
            break label633;
          }
          if (bf.mA(localx.field_conRemark)) {
            break label603;
          }
          paramView = localx.field_conRemark;
          label164:
          Object localObject = paramView;
          if (bf.mA(paramView)) {
            localObject = localx.field_conRemark;
          }
          paramView = (View)localObject;
          if (bf.mA((String)localObject)) {
            paramView = localx.tK();
          }
          paramView = com.tencent.mm.pluginsdk.ui.d.h.b(this.mContext, paramView, localb.jUr.getTextSize());
          label215:
          if (!(paramView instanceof SpannableString)) {
            break label692;
          }
          localb.jUr.setVisibility(8);
          localb.kuG.setVisibility(0);
          localb.kuG.setText(paramView);
          label250:
          localb.ipb.setContentDescription("");
          if (!this.sLe) {
            break label723;
          }
          n.GX().a(j.a.sLL.bq(paramViewGroup), localb.ipb, this.kuE);
          localb.ipb.setBackgroundDrawable(null);
          label301:
          if (!this.sLe) {
            break label779;
          }
          if ((!this.ktA) || ((this.sLs != null) && (this.sLs.equals(j.a.sLL.br(paramViewGroup))))) {
            break label766;
          }
          localb.pkN.setVisibility(0);
        }
        for (;;)
        {
          if ((!this.sLe) || (paramViewGroup == null)) {
            localb.jUu.setVisibility(8);
          }
          localb.klJ = i;
          GMTrace.o(940463620096L, 7007);
          return localView;
          localx = (x)getItem(paramInt);
          paramViewGroup = null;
          i = 0;
          break;
          if ((paramInt == this.sLk) && (this.sLn))
          {
            paramViewGroup = null;
            localx = null;
            i = 3;
            break;
          }
          if ((paramInt == this.sLk + 1) && (this.sLm))
          {
            paramViewGroup = null;
            localx = null;
            i = 4;
            break;
          }
          if ((paramInt == this.sLk + 1) && (this.sLo) && (!this.sLm))
          {
            paramViewGroup = null;
            localx = null;
            i = 5;
            break;
          }
          if ((paramInt != this.sLk + 2) || (!this.sLo) || (!this.sLm)) {
            break label1418;
          }
          paramViewGroup = null;
          localx = null;
          i = 5;
          break;
          localb = (b)paramView.getTag();
          if (localb != null) {
            break label1412;
          }
          localb = cP(paramView);
          localView = paramView;
          break label61;
          j = this.mContext.getResources().getDimensionPixelSize(com.tencent.mm.plugin.comm.a.b.aXA);
          localb.ipb.getLayoutParams().height = j;
          localb.ipb.getLayoutParams().width = j;
          break label116;
          label603:
          paramView = localx.field_username;
          if (this.krF == null)
          {
            paramView = null;
            break label164;
          }
          paramView = this.krF.eK(paramView);
          break label164;
          label633:
          if (this.sLe)
          {
            paramView = com.tencent.mm.pluginsdk.ui.d.h.b(this.mContext, j.a.sLL.bp(paramViewGroup), localb.jUr.getTextSize());
            break label215;
          }
          paramView = com.tencent.mm.pluginsdk.ui.d.h.b(this.mContext, localx.tL(), localb.jUr.getTextSize());
          break label215;
          label692:
          localb.jUr.setVisibility(0);
          localb.kuG.setVisibility(8);
          localb.jUr.setText(paramView);
          break label250;
          label723:
          com.tencent.mm.pluginsdk.ui.a.b.a(localb.ipb, localx.field_username);
          paramView = (com.tencent.mm.pluginsdk.ui.a)localb.ipb.getDrawable();
          if (this.sLl == null) {
            break label301;
          }
          this.sLl.a(paramView);
          break label301;
          label766:
          localb.pkN.setVisibility(8);
          continue;
          label779:
          if ((this.ktA) && ((this.sLs == null) || (!this.sLs.equals(localx.field_username))))
          {
            localb.pkN.setVisibility(0);
          }
          else
          {
            localb.pkN.setVisibility(8);
            continue;
            label833:
            if (i == 3)
            {
              paramView = localb.jUr;
              if (paramInt == 0)
              {
                j = 8;
                label853:
                paramView.setVisibility(j);
                paramView = localb.kuG;
                if (paramInt != 0) {
                  break label912;
                }
              }
              label912:
              for (paramInt = 8;; paramInt = 4)
              {
                paramView.setVisibility(paramInt);
                localb.pkN.setVisibility(8);
                if (!this.ktA) {
                  break label917;
                }
                localb.ipb.setVisibility(4);
                break;
                j = 4;
                break label853;
              }
              label917:
              localb.ipb.setVisibility(0);
              if (this.sLe)
              {
                n.GX().a("", localb.ipb, this.kuE);
                localb.ipb.setBackgroundDrawable(null);
              }
              localb.ipb.setImageResource(a.c.bcs);
              localb.ipb.setContentDescription(this.mContext.getString(a.g.kCn));
            }
            else if (i == 4)
            {
              paramView = localb.jUr;
              if (1 == paramInt)
              {
                j = 8;
                label1013:
                paramView.setVisibility(j);
                paramView = localb.kuG;
                if (1 != paramInt) {
                  break label1080;
                }
              }
              label1080:
              for (paramInt = 8;; paramInt = 4)
              {
                paramView.setVisibility(paramInt);
                localb.pkN.setVisibility(8);
                if ((!this.ktA) && (this.sLk != 0)) {
                  break label1085;
                }
                localb.ipb.setVisibility(4);
                break;
                j = 4;
                break label1013;
              }
              label1085:
              localb.ipb.setVisibility(0);
              if (this.sLe)
              {
                n.GX().a("", localb.ipb, this.kuE);
                localb.ipb.setBackgroundDrawable(null);
              }
              localb.ipb.setImageResource(a.c.bct);
              localb.ipb.setContentDescription(this.mContext.getString(a.g.kCr));
            }
            else if (i == 5)
            {
              paramView = localb.jUr;
              if (paramInt == 0)
              {
                j = 8;
                label1180:
                paramView.setVisibility(j);
                paramView = localb.kuG;
                if (paramInt != 0) {
                  break label1239;
                }
              }
              label1239:
              for (paramInt = 8;; paramInt = 4)
              {
                paramView.setVisibility(paramInt);
                localb.pkN.setVisibility(8);
                if (!this.ktA) {
                  break label1244;
                }
                localb.ipb.setVisibility(4);
                break;
                j = 4;
                break label1180;
              }
              label1244:
              localb.ipb.setVisibility(0);
              if (this.sLe)
              {
                n.GX().a("", localb.ipb, this.kuE);
                localb.ipb.setBackgroundDrawable(null);
              }
              localb.ipb.setImageResource(a.c.kBM);
              localb.ipb.setContentDescription(this.mContext.getString(a.g.kDb));
            }
            else if (i == 2)
            {
              if (this.sLe) {
                n.GX().a("", localb.ipb, this.kuE);
              }
              localb.jUr.setVisibility(4);
              localb.kuG.setVisibility(4);
              localb.pkN.setVisibility(8);
              localb.ipb.setVisibility(4);
              localb.ipb.setImageResource(a.c.bhb);
              localb.ipb.setBackgroundResource(a.c.bhb);
            }
          }
        }
        label1412:
        localView = paramView;
      }
      label1418:
      paramViewGroup = null;
      localx = null;
      i = 2;
    }
  }
  
  public final void notifyChanged()
  {
    GMTrace.i(940732055552L, 7009);
    label383:
    label567:
    int i;
    if ((this.fPh != null) || (this.sLd != null))
    {
      if (!this.sLp) {
        break label1347;
      }
      if (this.fPh != null)
      {
        v.d("MicroMsg.ContactsListArchAdapter", "initData memberList.size %d", new Object[] { Integer.valueOf(this.fPh.size()) });
        this.sLi.clear();
        this.jIy.clear();
        this.sLh.clear();
        if (this.fPh.size() > 0)
        {
          Object localObject1 = this.fPh.iterator();
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (String)((Iterator)localObject1).next();
            if (this.sLe) {
              this.sLh.add(j.a.sLL.ML((String)localObject2));
            }
            for (;;)
            {
              this.sLi.add(localObject2);
              break;
              localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rb((String)localObject2);
              if ((localObject3 != null) && (!bf.mA(((af)localObject3).field_username)) && (((af)localObject3).field_username.equals(localObject2))) {
                this.jIy.add(localObject3);
              } else {
                this.jIy.add(new x(this.username));
              }
            }
          }
          int j;
          if ((this.sLv) && (!bf.mA(this.sLs)) && (this.fPh.contains(this.sLs)))
          {
            if (this.sLe)
            {
              localObject1 = this.sLh.iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject2 = ((Iterator)localObject1).next();
                if (this.sLs.equals(j.a.sLL.br(localObject2)))
                {
                  this.sLh.remove(localObject2);
                  this.sLh.add(0, localObject2);
                  break label690;
                }
              }
            }
          }
          else
          {
            if ((!this.sLw) || (this.sLe)) {
              break label1124;
            }
            localObject1 = bf.ap((String)com.tencent.mm.kernel.h.vI().vr().get(2, null), "");
            if (this.fPh.contains(localObject1))
            {
              this.sLi.remove(localObject1);
              localObject2 = this.jIy.iterator();
              while (((Iterator)localObject2).hasNext())
              {
                localObject3 = (x)((Iterator)localObject2).next();
                if (((String)localObject1).equals(((af)localObject3).field_username)) {
                  this.jIy.remove(localObject3);
                }
              }
            }
            localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rb((String)localObject1);
            if ((localObject2 == null) || (bf.mA(((af)localObject2).field_username)) || (!((af)localObject2).field_username.equals(localObject1))) {
              break label754;
            }
            this.jIy.add(1, localObject2);
            this.sLi.add(localObject1);
            if ((!this.sLx) || (this.jIy.size() < 3)) {
              break label1124;
            }
            j = this.jIy.size();
            localObject1 = new LinkedList();
            i = 0;
            label620:
            if (i >= j) {
              break label901;
            }
            localObject2 = (x)this.jIy.get(i);
            if (((af)localObject2).field_showHead <= 0) {
              break label776;
            }
            ((LinkedList)localObject1).add(((af)localObject2).field_showHead);
          }
          for (;;)
          {
            i += 1;
            break label620;
            localObject1 = this.jIy.iterator();
            label690:
            if (!((Iterator)localObject1).hasNext()) {
              break label383;
            }
            localObject2 = (x)((Iterator)localObject1).next();
            if (!this.sLs.equals(((af)localObject2).field_username)) {
              break;
            }
            this.jIy.remove(localObject2);
            this.jIy.add(0, localObject2);
            break label383;
            label754:
            this.jIy.add(1, new x((String)localObject1));
            break label567;
            label776:
            if (!bf.mA(((af)localObject2).field_conRemark)) {
              ((LinkedList)localObject1).add(((af)localObject2).field_conRemark);
            } else if (!bf.mA(((af)localObject2).field_conRemarkPYShort)) {
              ((LinkedList)localObject1).add(((af)localObject2).field_conRemarkPYShort);
            } else if (!bf.mA(((af)localObject2).field_conRemarkPYFull)) {
              ((LinkedList)localObject1).add(((af)localObject2).field_conRemarkPYFull);
            } else if (!bf.mA(((x)localObject2).pB())) {
              ((LinkedList)localObject1).add(((x)localObject2).pB());
            } else if (!bf.mA(((af)localObject2).field_username)) {
              ((LinkedList)localObject1).add(((af)localObject2).field_username);
            }
          }
          label901:
          v.v("MicroMsg.ContactsListArchAdapter", "klem, order list:%s", new Object[] { ((LinkedList)localObject1).toString() });
          Object localObject2 = new ArrayList();
          ((List)localObject2).add(this.jIy.get(0));
          ((List)localObject2).add(this.jIy.get(1));
          Object localObject3 = new LinkedList();
          ((List)localObject3).add(((LinkedList)localObject1).get(0));
          ((List)localObject3).add(((LinkedList)localObject1).get(0));
          int k = this.jIy.size();
          i = 2;
          while (i < k)
          {
            String str = (String)((LinkedList)localObject1).get(i);
            int m = ((List)localObject2).size();
            j = 1;
            while ((j < m) && (str.compareToIgnoreCase((String)((List)localObject3).get(j)) >= 0)) {
              j += 1;
            }
            ((List)localObject3).add(j, str);
            ((List)localObject2).add(j, this.jIy.get(i));
            i += 1;
          }
          this.jIy.clear();
          this.jIy = ((List)localObject2);
        }
        label1124:
        if (!this.sLe) {
          break label1210;
        }
        this.sLk = this.sLh.size();
      }
      if (this.sLk != 0) {
        break label1354;
      }
      this.sLj = sLa;
    }
    for (;;)
    {
      v.d("MicroMsg.ContactsListArchAdapter", "Number Size  contactSize :" + this.sLk + " realySize : " + this.sLj);
      bBT();
      GMTrace.o(940732055552L, 7009);
      return;
      label1210:
      if (this.fNX)
      {
        if ((bf.mA(this.sLs)) || ((this.sLs != null) && (!this.sLs.equals(m.xL()))))
        {
          if (this.jIy.size() >= sKZ) {}
          for (i = sKZ;; i = this.jIy.size())
          {
            this.sLk = i;
            break;
          }
        }
        if (this.jIy.size() >= sKZ - 1) {}
        for (i = sKZ - 1;; i = this.jIy.size())
        {
          this.sLk = i;
          break;
        }
      }
      this.sLk = this.jIy.size();
      break;
      label1347:
      bEQ();
      break;
      label1354:
      if ((this.sLn) && (this.sLm) && (this.sLo)) {
        this.sLj = (((this.sLk + 2) / sLa + 1) * sLa);
      } else if (((this.sLn) && (this.sLm) && (!this.sLo)) || ((this.sLn) && (!this.sLm) && (this.sLo)) || ((!this.sLn) && (this.sLm) && (this.sLo))) {
        this.sLj = (((this.sLk + 1) / sLa + 1) * sLa);
      } else if (((this.sLn) && (!this.sLm) && (!this.sLo)) || ((!this.sLn) && (this.sLm) && (!this.sLo)) || ((!this.sLn) && (!this.sLm) && (this.sLo))) {
        this.sLj = ((this.sLk / sLa + 1) * sLa);
      } else if ((!this.sLn) && (!this.sLm) && (!this.sLo)) {
        this.sLj = (((this.sLk - 1) / sLa + 1) * sLa);
      }
    }
  }
  
  public final boolean xn(int paramInt)
  {
    GMTrace.i(940060966912L, 7004);
    if (!this.ktA)
    {
      if (paramInt < this.sLk)
      {
        this.ktA = true;
        bBT();
      }
      GMTrace.o(940060966912L, 7004);
      return true;
    }
    GMTrace.o(940060966912L, 7004);
    return false;
  }
  
  public final boolean xo(int paramInt)
  {
    GMTrace.i(940597837824L, 7008);
    if (paramInt < this.sLk)
    {
      GMTrace.o(940597837824L, 7008);
      return true;
    }
    GMTrace.o(940597837824L, 7008);
    return false;
  }
  
  public static abstract interface a
  {
    public abstract void bBT();
  }
  
  final class b
  {
    public ImageView ipb;
    public TextView jUr;
    public ImageView jUu;
    public int klJ;
    public TextView kuG;
    public ImageView pkN;
    public ImageView sLz;
    
    b()
    {
      GMTrace.i(959925190656L, 7152);
      GMTrace.o(959925190656L, 7152);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/ui/applet/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */