package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.e.b.af;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.d.b.b;
import com.tencent.mm.plugin.fts.d.e;
import com.tencent.mm.plugin.fts.d.f;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.n;
import java.util.List;
import java.util.regex.Pattern;

public class d
  extends a
{
  private static final Pattern ioV;
  public i iIW;
  public CharSequence ioW;
  public CharSequence ioX;
  public String[] lYu;
  public String username;
  private b vYt;
  private a vYu;
  
  static
  {
    GMTrace.i(1773284622336L, 13212);
    ioV = Pattern.compile(",");
    GMTrace.o(1773284622336L, 13212);
  }
  
  public d(int paramInt)
  {
    super(2, paramInt);
    GMTrace.i(1772747751424L, 13208);
    this.vYt = new b();
    this.vYu = new a();
    GMTrace.o(1772747751424L, 13208);
  }
  
  public a.b Oc()
  {
    GMTrace.i(1773016186880L, 13210);
    b localb = this.vYt;
    GMTrace.o(1773016186880L, 13210);
    return localb;
  }
  
  public a.a Od()
  {
    GMTrace.i(1773150404608L, 13211);
    a locala = this.vYu;
    GMTrace.o(1773150404608L, 13211);
    return locala;
  }
  
  public final void br(Context paramContext)
  {
    GMTrace.i(1772881969152L, 13209);
    int i;
    if (this.iIW != null) {
      if ((this.lYu != null) && (this.lYu.length > 0))
      {
        i = 1;
        j = i;
        if (this.jht == null)
        {
          ap.yY();
          this.jht = c.wR().QW(this.iIW.lYb);
          j = i;
          if (this.jht == null)
          {
            ap.yY();
            this.jht = c.wR().Ra(this.iIW.lYb);
          }
        }
      }
    }
    for (int j = i;; j = 0)
    {
      if (this.jht != null) {
        break label147;
      }
      v.i("MicroMsg.ContactDataItem", "filling dataItem Occur Error Contact is null, position=%d", new Object[] { Integer.valueOf(this.position) });
      GMTrace.o(1772881969152L, 13209);
      return;
      i = 0;
      break;
    }
    label147:
    this.username = this.jht.field_username;
    Object localObject2;
    Object localObject4;
    String[] arrayOfString;
    Resources localResources;
    Object localObject1;
    boolean bool1;
    boolean bool2;
    Object localObject3;
    if (j != 0)
    {
      localObject2 = this.iIW;
      localObject4 = this.jht;
      arrayOfString = this.lYu;
      localResources = paramContext.getResources();
      if (localObject4 == null) {
        break label966;
      }
      localObject1 = n.a((x)localObject4, ((af)localObject4).field_username);
      switch (((i)localObject2).hOZ)
      {
      case 8: 
      case 9: 
      case 10: 
      case 12: 
      case 13: 
      case 14: 
      default: 
        bool1 = false;
        bool2 = false;
        j = 0;
        localObject2 = null;
        localObject4 = null;
        i = 0;
        localObject3 = localObject1;
        localObject1 = localObject4;
      }
    }
    for (;;)
    {
      localObject4 = bf.f(arrayOfString);
      if (j != 0)
      {
        v.d("MicroMsg.ContactDataItem", "highlight first line");
        this.ioW = com.tencent.mm.pluginsdk.ui.d.h.c(paramContext, (CharSequence)localObject3, com.tencent.mm.bg.a.T(paramContext, R.f.aXH));
        this.ioW = f.b(com.tencent.mm.plugin.fts.d.b.a.a(this.ioW, this.fRC, (List)localObject4, bool2, bool1)).mbY;
        label382:
        if (i == 0) {
          break label848;
        }
        v.d("MicroMsg.ContactDataItem", "highlight second line");
        this.ioX = com.tencent.mm.pluginsdk.ui.d.h.c(paramContext, (CharSequence)localObject1, com.tencent.mm.bg.a.T(paramContext, R.f.aXr));
        this.ioX = f.b(com.tencent.mm.plugin.fts.d.b.a.a(this.ioX, this.fRC, (List)localObject4, bool2, bool1)).mbY;
        label437:
        if ((!bf.mA((String)localObject2)) && (this.ioX != null)) {
          this.ioX = TextUtils.concat(new CharSequence[] { localObject2, this.ioX });
        }
        GMTrace.o(1772881969152L, 13209);
        return;
        bool1 = true;
        label488:
        bool2 = true;
        label491:
        j = 1;
        localObject2 = null;
        localObject3 = localObject1;
        localObject1 = null;
        i = 0;
        continue;
        bool1 = true;
      }
      label511:
      for (bool2 = true;; bool2 = false)
      {
        localObject4 = ((af)localObject4).field_nickname;
        localObject2 = localResources.getString(R.l.ePA);
        localObject3 = localObject1;
        localObject1 = localObject4;
        j = 0;
        i = 1;
        break;
        localObject4 = ((af)localObject4).gkA;
        localObject2 = localResources.getString(R.l.ePw);
        bool2 = false;
        j = 0;
        localObject3 = localObject1;
        localObject1 = localObject4;
        i = 1;
        bool1 = false;
        break;
        localObject3 = ((x)localObject4).pA();
        localObject2 = localObject3;
        if (bf.mA((String)localObject3)) {
          localObject2 = ((af)localObject4).field_username;
        }
        localObject3 = localResources.getString(R.l.ePE);
        bool2 = false;
        j = 0;
        localObject4 = localObject1;
        localObject1 = localObject2;
        i = 1;
        bool1 = false;
        localObject2 = localObject3;
        localObject3 = localObject4;
        break;
        localObject2 = ((i)localObject2).content;
        if (!bf.mA((String)localObject2))
        {
          localObject4 = ((String)localObject2).split("​");
          j = localObject4.length;
          i = 0;
          label679:
          if (i < j)
          {
            localObject3 = localObject4[i];
            if (((String)localObject3).startsWith(this.fRC)) {
              localObject2 = localObject3;
            }
          }
        }
        for (;;)
        {
          localObject3 = localResources.getString(R.l.ePz);
          bool2 = false;
          j = 0;
          localObject4 = localObject1;
          localObject1 = localObject2;
          i = 1;
          bool1 = false;
          localObject2 = localObject3;
          localObject3 = localObject4;
          break;
          i += 1;
          break label679;
          localObject4 = ((i)localObject2).content;
          localObject2 = localResources.getString(R.l.ePx);
          bool2 = false;
          j = 0;
          localObject3 = localObject1;
          localObject1 = localObject4;
          i = 1;
          bool1 = false;
          break;
          localObject4 = ((i)localObject2).lYC;
          localObject2 = localResources.getString(R.l.ePD);
          bool2 = false;
          j = 0;
          localObject3 = localObject1;
          localObject1 = localObject4;
          i = 1;
          bool1 = false;
          break;
          this.ioW = com.tencent.mm.pluginsdk.ui.d.h.c(paramContext, (CharSequence)localObject3, com.tencent.mm.bg.a.T(paramContext, R.f.aXH));
          break label382;
          label848:
          this.ioX = com.tencent.mm.pluginsdk.ui.d.h.c(paramContext, (CharSequence)localObject1, com.tencent.mm.bg.a.T(paramContext, R.f.aXr));
          break label437;
          if (bf.mA(this.fEK)) {}
          for (localObject1 = n.c(this.jht);; localObject1 = n.E(this.jht.field_username, this.fEK))
          {
            this.ioW = com.tencent.mm.pluginsdk.ui.d.h.c(paramContext, (CharSequence)localObject1, com.tencent.mm.bg.a.T(paramContext, R.f.aXH));
            GMTrace.o(1772881969152L, 13209);
            return;
          }
        }
        bool1 = false;
        break label488;
        bool1 = false;
        bool2 = false;
        break label491;
        bool1 = false;
        break label511;
        bool1 = false;
      }
      label966:
      bool1 = false;
      bool2 = false;
      j = 0;
      localObject1 = null;
      localObject2 = null;
      localObject3 = null;
      i = 0;
    }
  }
  
  public class a
    extends a.a
  {
    public View ipa;
    public ImageView ipb;
    public TextView ipc;
    public TextView ipd;
    public CheckBox ipe;
    public CheckBox vYv;
    
    public a()
    {
      super();
      GMTrace.i(1766036865024L, 13158);
      GMTrace.o(1766036865024L, 13158);
    }
  }
  
  public class b
    extends a.b
  {
    public b()
    {
      super();
      GMTrace.i(1768587001856L, 13177);
      GMTrace.o(1768587001856L, 13177);
    }
    
    public final boolean Oe()
    {
      GMTrace.i(1768989655040L, 13180);
      if (d.this.iIW != null) {
        ((l)com.tencent.mm.kernel.h.j(l.class)).updateTopHitsRank(d.this.fRC, d.this.iIW, 1);
      }
      GMTrace.o(1768989655040L, 13180);
      return false;
    }
    
    public View a(Context paramContext, ViewGroup paramViewGroup)
    {
      GMTrace.i(1768721219584L, 13178);
      if (com.tencent.mm.bg.a.dM(paramContext)) {}
      for (paramContext = LayoutInflater.from(paramContext).inflate(R.i.dny, paramViewGroup, false);; paramContext = LayoutInflater.from(paramContext).inflate(R.i.dnx, paramViewGroup, false))
      {
        paramViewGroup = (d.a)d.this.Od();
        paramViewGroup.ipb = ((ImageView)paramContext.findViewById(R.h.bqF));
        paramViewGroup.ipc = ((TextView)paramContext.findViewById(R.h.cIY));
        paramViewGroup.ipd = ((TextView)paramContext.findViewById(R.h.bHU));
        paramViewGroup.ipa = paramContext.findViewById(R.h.cBJ);
        paramViewGroup.ipe = ((CheckBox)paramContext.findViewById(R.h.cBy));
        paramViewGroup.vYv = ((CheckBox)paramContext.findViewById(R.h.cCa));
        paramContext.setTag(paramViewGroup);
        GMTrace.o(1768721219584L, 13178);
        return paramContext;
      }
    }
    
    public void a(Context paramContext, a.a parama, a parama1, boolean paramBoolean1, boolean paramBoolean2)
    {
      GMTrace.i(1768855437312L, 13179);
      parama = (d.a)parama;
      parama1 = (d)parama1;
      if ((parama1.username != null) && (parama1.username.length() > 0))
      {
        com.tencent.mm.pluginsdk.ui.a.b.a(parama.ipb, parama1.username);
        e.a(parama1.ioW, parama.ipc);
        e.a(parama1.ioX, parama.ipd);
        if (!d.this.vWh) {
          break label216;
        }
        parama.ipe.setBackgroundResource(R.g.bgU);
        if (!paramBoolean1) {
          break label196;
        }
        parama.ipe.setChecked(true);
        parama.ipe.setEnabled(false);
        label112:
        parama.ipe.setVisibility(0);
        label120:
        if (!d.this.jYD) {
          break label275;
        }
        parama.ipa.setBackgroundResource(R.g.beo);
      }
      for (;;)
      {
        if (parama1.jht.field_deleteFlag == 1)
        {
          parama.ipd.setVisibility(0);
          parama.ipd.setText(paramContext.getString(R.l.dCa));
        }
        GMTrace.o(1768855437312L, 13179);
        return;
        parama.ipb.setImageResource(R.g.ber);
        break;
        label196:
        parama.ipe.setChecked(paramBoolean2);
        parama.ipe.setEnabled(true);
        break label112;
        label216:
        if (d.this.vWi)
        {
          parama.ipe.setVisibility(8);
          parama.vYv.setChecked(paramBoolean2);
          parama.vYv.setEnabled(true);
          parama.vYv.setVisibility(0);
          break label120;
        }
        parama.ipe.setVisibility(8);
        break label120;
        label275:
        parama.ipa.setBackgroundResource(R.g.ben);
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/contact/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */