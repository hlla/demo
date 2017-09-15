package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
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
import com.tencent.mm.bj.g;
import com.tencent.mm.e.b.af;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.d.b.b;
import com.tencent.mm.plugin.fts.d.d.b;
import com.tencent.mm.plugin.fts.d.e;
import com.tencent.mm.plugin.fts.d.f;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.n;
import java.util.List;
import java.util.regex.Pattern;

public final class c
  extends a
{
  private static final Pattern hOV;
  public i iIW;
  private List<String> iIX;
  public CharSequence ioW;
  public CharSequence ioX;
  public String[] lYu;
  public String username;
  public CharSequence vYp;
  private b vYq;
  a vYr;
  
  static
  {
    GMTrace.i(1774626799616L, 13222);
    hOV = Pattern.compile(";");
    GMTrace.o(1774626799616L, 13222);
  }
  
  public c(int paramInt)
  {
    super(3, paramInt);
    GMTrace.i(1773955710976L, 13217);
    this.vYq = new b();
    this.vYr = new a();
    GMTrace.o(1773955710976L, 13217);
  }
  
  public final a.b Oc()
  {
    GMTrace.i(1774224146432L, 13219);
    b localb = this.vYq;
    GMTrace.o(1774224146432L, 13219);
    return localb;
  }
  
  protected final a.a Od()
  {
    GMTrace.i(1774358364160L, 13220);
    a locala = this.vYr;
    GMTrace.o(1774358364160L, 13220);
    return locala;
  }
  
  public final boolean axZ()
  {
    GMTrace.i(1774492581888L, 13221);
    boolean bool = this.iIW.lYI;
    GMTrace.o(1774492581888L, 13221);
    return bool;
  }
  
  public final void br(Context paramContext)
  {
    List localList = null;
    int k = 1;
    boolean bool1 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    GMTrace.i(1774089928704L, 13218);
    int i;
    if (this.iIW != null) {
      if ((this.lYu != null) && (this.lYu.length > 0))
      {
        this.iIX = bf.f(this.lYu);
        i = 1;
        j = i;
        if (this.jht == null)
        {
          ap.yY();
          this.jht = com.tencent.mm.u.c.wR().QW(this.iIW.lYb);
          j = i;
          if (this.jht == null)
          {
            ap.yY();
            this.jht = com.tencent.mm.u.c.wR().Ra(this.iIW.lYb);
          }
        }
      }
    }
    for (int j = i;; j = 0)
    {
      if (this.jht != null) {
        break label173;
      }
      v.i("MicroMsg.ChatroomDataItem", "filling dataItem Occur Error Contact is null, position=%d", new Object[] { Integer.valueOf(this.position) });
      GMTrace.o(1774089928704L, 13218);
      return;
      i = 0;
      break;
    }
    label173:
    this.username = this.jht.field_username;
    i locali;
    Object localObject;
    Resources localResources;
    String str1;
    if (j != 0)
    {
      locali = this.iIW;
      localObject = this.jht;
      String[] arrayOfString = this.lYu;
      localResources = paramContext.getResources();
      str1 = n.a((x)localObject, ((af)localObject).field_username);
      switch (locali.hOZ)
      {
      default: 
        bool1 = false;
        i = 0;
        localObject = localList;
        localList = bf.f(arrayOfString);
        if (i != 0)
        {
          this.ioW = com.tencent.mm.pluginsdk.ui.d.h.c(paramContext, str1, com.tencent.mm.bg.a.T(paramContext, R.f.aXr));
          this.ioW = f.b(com.tencent.mm.plugin.fts.d.b.a.a(this.ioW, this.fRC, localList, bool1, bool2)).mbY;
          this.ioX = ((CharSequence)localObject);
          GMTrace.o(1774089928704L, 13218);
          return;
        }
        break;
      case 3: 
      case 7: 
        bool1 = true;
      case 2: 
      case 6: 
        label305:
        label360:
        bool3 = true;
        bool2 = bool1;
        bool1 = bool3;
      }
    }
    for (;;)
    {
      localResources.getString(R.l.ePA);
      localObject = localList;
      i = k;
      break label305;
      ap.yY();
      localObject = com.tencent.mm.u.c.wO().a("SELECT memberlist FROM chatroom WHERE chatroomname=?;", new String[] { ((af)localObject).field_username }, 2);
      String str2;
      if (((Cursor)localObject).moveToFirst())
      {
        str2 = ((Cursor)localObject).getString(0);
        ((Cursor)localObject).close();
        if (str2 == null) {
          localObject = null;
        }
      }
      for (;;)
      {
        if ((localObject != null) && (localObject.length > 0)) {
          this.vYp = ("(" + localObject.length + ")");
        }
        if ((localObject == null) || (locali.lYF == null)) {
          break;
        }
        localObject = e.a(paramContext, locali.lYF, (String[])localObject, this.iIX, d.b.maS, this.fRC);
        localObject = TextUtils.concat(new CharSequence[] { localResources.getString(R.l.ePy), localObject });
        bool1 = false;
        i = 0;
        break label305;
        localObject = hOV.split(str2);
        continue;
        ((Cursor)localObject).close();
        localObject = null;
      }
      this.ioW = com.tencent.mm.pluginsdk.ui.d.h.c(paramContext, str1, com.tencent.mm.bg.a.T(paramContext, R.f.aXr));
      break label360;
      this.ioW = n.a(this.jht, this.jht.field_username);
      this.vYp = ("(" + this.iIW.lYy + ")");
      GMTrace.o(1774089928704L, 13218);
      return;
      bool1 = false;
      bool2 = bool3;
    }
  }
  
  public final class a
    extends a.a
  {
    public View ipa;
    public ImageView ipb;
    public TextView ipc;
    public TextView ipd;
    public CheckBox ipe;
    public TextView mbJ;
    
    public a()
    {
      super();
      GMTrace.i(1771942445056L, 13202);
      GMTrace.o(1771942445056L, 13202);
    }
  }
  
  public final class b
    extends a.b
  {
    public b()
    {
      super();
      GMTrace.i(1766171082752L, 13159);
      GMTrace.o(1766171082752L, 13159);
    }
    
    public final boolean Oe()
    {
      GMTrace.i(1766573735936L, 13162);
      if (c.this.iIW != null) {
        ((l)com.tencent.mm.kernel.h.j(l.class)).updateTopHitsRank(c.this.fRC, c.this.iIW, 1);
      }
      GMTrace.o(1766573735936L, 13162);
      return false;
    }
    
    public final View a(Context paramContext, ViewGroup paramViewGroup)
    {
      GMTrace.i(1766305300480L, 13160);
      if (com.tencent.mm.bg.a.dM(paramContext)) {}
      for (paramViewGroup = LayoutInflater.from(paramContext).inflate(R.i.dny, paramViewGroup, false);; paramViewGroup = LayoutInflater.from(paramContext).inflate(R.i.dnx, paramViewGroup, false))
      {
        c.a locala = (c.a)c.this.vYr;
        locala.ipb = ((ImageView)paramViewGroup.findViewById(R.h.bqF));
        locala.ipc = ((TextView)paramViewGroup.findViewById(R.h.cIY));
        locala.ipc.setMaxWidth(com.tencent.mm.bg.a.fromDPToPix(paramContext, 200));
        locala.ipd = ((TextView)paramViewGroup.findViewById(R.h.bHU));
        locala.mbJ = ((TextView)paramViewGroup.findViewById(R.h.cIA));
        locala.ipa = paramViewGroup.findViewById(R.h.cBJ);
        locala.ipe = ((CheckBox)paramViewGroup.findViewById(R.h.cBy));
        if (c.this.jYD) {
          locala.ipa.setBackgroundResource(R.g.beo);
        }
        paramViewGroup.setTag(locala);
        GMTrace.o(1766305300480L, 13160);
        return paramViewGroup;
      }
    }
    
    public final void a(Context paramContext, a.a parama, a parama1, boolean paramBoolean1, boolean paramBoolean2)
    {
      GMTrace.i(1766439518208L, 13161);
      paramContext = (c.a)parama;
      parama = (c)parama1;
      if ((parama.username != null) && (parama.username.length() > 0))
      {
        com.tencent.mm.pluginsdk.ui.a.b.a(paramContext.ipb, parama.username);
        e.a(parama.ioW, paramContext.ipc);
        e.a(parama.ioX, paramContext.ipd);
        e.a(parama.vYp, paramContext.mbJ);
        if (!c.this.vWh) {
          break label165;
        }
        if (!paramBoolean1) {
          break label145;
        }
        paramContext.ipe.setChecked(true);
        paramContext.ipe.setEnabled(false);
      }
      for (;;)
      {
        paramContext.ipe.setVisibility(0);
        GMTrace.o(1766439518208L, 13161);
        return;
        paramContext.ipb.setImageResource(R.g.ber);
        break;
        label145:
        paramContext.ipe.setChecked(paramBoolean2);
        paramContext.ipe.setEnabled(true);
      }
      label165:
      paramContext.ipe.setVisibility(8);
      GMTrace.o(1766439518208L, 13161);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/contact/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */