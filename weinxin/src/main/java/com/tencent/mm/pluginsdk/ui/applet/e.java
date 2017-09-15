package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.content.res.Resources;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.chatroom.b.a;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.plugin.comm.a.c;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.aa;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public final class e
{
  private Context context;
  public com.tencent.mm.ui.base.preference.f isp;
  private View nrp;
  private View nuV;
  public View.OnClickListener oOv;
  public ContactListExpandPreference.a qQn;
  String sKM;
  private HashMap<String, Preference> sKN;
  boolean sKO;
  boolean sKP;
  public f sKQ;
  g.b sKR;
  private View.OnClickListener sKS;
  private View.OnClickListener sKT;
  private View.OnClickListener sKU;
  private g.b sKV;
  private g.a sKW;
  private f.a sKX;
  public String username;
  
  public e(Context paramContext)
  {
    GMTrace.i(962877980672L, 7174);
    this.sKN = new HashMap();
    this.sKO = false;
    if (this.sKO) {
      bool = true;
    }
    this.sKP = bool;
    this.sKR = null;
    this.oOv = null;
    this.qQn = null;
    this.sKU = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        GMTrace.i(960193626112L, 7154);
        v.d("MicroMsg.ContactListArchor", "OnClickListener = onClick ");
        GMTrace.o(960193626112L, 7154);
      }
    };
    this.sKV = new g.b()
    {
      public final boolean kF(int paramAnonymousInt)
      {
        GMTrace.i(967575601152L, 7209);
        if ((!e.this.sKQ.sLm) || (!e.this.sKQ.xo(paramAnonymousInt)))
        {
          GMTrace.o(967575601152L, 7209);
          return true;
        }
        if (!e.this.sKQ.xn(paramAnonymousInt)) {
          v.d("MicroMsg.ContactListArchor", "onItemLongClick " + paramAnonymousInt);
        }
        GMTrace.o(967575601152L, 7209);
        return true;
      }
    };
    this.sKW = new g.a()
    {
      public final void xm(int paramAnonymousInt)
      {
        int j = 1;
        GMTrace.i(966636077056L, 7202);
        if ((e.this.qQn != null) && (e.this.sKQ != null))
        {
          f localf = e.this.sKQ;
          if (localf.sLm) {
            if ((!localf.ktA) && (paramAnonymousInt == localf.sLk + 2))
            {
              i = 1;
              if (i != 0) {
                break label416;
              }
              localf = e.this.sKQ;
              if ((localf.ktA) || (paramAnonymousInt != localf.sLk)) {
                break label162;
              }
            }
          }
          label162:
          for (int i = 1;; i = 0)
          {
            if (i == 0) {
              break label167;
            }
            e.this.qQn.kI(paramAnonymousInt);
            GMTrace.o(966636077056L, 7202);
            return;
            i = 0;
            break;
            if ((!localf.ktA) && (paramAnonymousInt == localf.sLk + 1))
            {
              i = 1;
              break;
            }
            i = 0;
            break;
          }
          label167:
          localf = e.this.sKQ;
          if ((!localf.ktA) && (paramAnonymousInt == localf.sLk + 1)) {
            i = j;
          }
          while (i != 0)
          {
            if (!e.this.sKQ.sLm) {
              break label416;
            }
            if (o.dH(e.this.username))
            {
              e.this.qQn.kG(paramAnonymousInt);
              GMTrace.o(966636077056L, 7202);
              return;
              i = 0;
            }
            else
            {
              e.this.sKQ.xn(0);
              GMTrace.o(966636077056L, 7202);
              return;
            }
          }
          if ((e.this.sKQ.ktA) && (e.this.sKQ.xo(paramAnonymousInt)))
          {
            e.this.qQn.kG(paramAnonymousInt);
            GMTrace.o(966636077056L, 7202);
            return;
          }
          if ((e.this.sKQ.ktA) && (!e.this.sKQ.xo(paramAnonymousInt)))
          {
            e.this.qQn.ajm();
            GMTrace.o(966636077056L, 7202);
            return;
          }
          if ((!e.this.sKQ.ktA) && (e.this.sKQ.xo(paramAnonymousInt))) {
            e.this.qQn.kH(paramAnonymousInt);
          }
        }
        label416:
        GMTrace.o(966636077056L, 7202);
      }
    };
    this.sKX = new f.a()
    {
      public final void bBT()
      {
        GMTrace.i(948919336960L, 7070);
        if (e.this.isp != null) {
          e.this.isp.notifyDataSetChanged();
        }
        GMTrace.o(948919336960L, 7070);
      }
    };
    this.context = paramContext;
    this.sKQ = new f(this.context);
    this.sKQ.sLb = this.sKX;
    GMTrace.o(962877980672L, 7174);
  }
  
  private static String xl(int paramInt)
  {
    GMTrace.i(963146416128L, 7176);
    if (paramInt >= 0)
    {
      str = "pref_contact_list_row_" + paramInt;
      GMTrace.o(963146416128L, 7176);
      return str;
    }
    String str = "unkown";
    if (paramInt == -1) {
      str = "header";
    }
    for (;;)
    {
      str = "pref_contact_list_row_" + str;
      GMTrace.o(963146416128L, 7176);
      return str;
      if (paramInt == -2) {
        str = "footer";
      }
    }
  }
  
  public final void aVC()
  {
    GMTrace.i(963280633856L, 7177);
    if ((this.isp == null) || (this.sKM == null))
    {
      GMTrace.o(963280633856L, 7177);
      return;
    }
    Object localObject1 = this.sKN.keySet().iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      this.isp.Td((String)localObject2);
    }
    this.sKN.clear();
    int m = this.isp.indexOf(this.sKM);
    int k = 0;
    if (this.nrp != null) {
      k = 1;
    }
    if (this.nuV != null) {
      if (this.sKO)
      {
        localObject1 = this.sKQ;
        if (((f)localObject1).sLj <= ((f)localObject1).sLr) {
          break label564;
        }
        i = 1;
        if (i == 0) {
          break label905;
        }
      }
    }
    label264:
    label277:
    label322:
    label564:
    label578:
    label587:
    label599:
    label680:
    label801:
    label902:
    label905:
    for (int i = 1;; i = 0)
    {
      int j = m;
      if (k != 0)
      {
        localObject1 = new ContactListCustomPreference(this.context);
        ((ContactListCustomPreference)localObject1).setKey(xl(-1));
        ((ContactListCustomPreference)localObject1).setCustomView(this.nrp);
        ((ContactListCustomPreference)localObject1).background = a.c.ben;
        ((ContactListCustomPreference)localObject1).oOv = this.sKS;
        this.isp.a((Preference)localObject1, m);
        this.sKN.put(((Preference)localObject1).igr, localObject1);
        j = m + 1;
      }
      Object localObject3;
      boolean bool2;
      boolean bool1;
      if (this.sKR != null)
      {
        localObject1 = this.sKR;
        if (this.oOv == null) {
          break label578;
        }
        localObject2 = this.oOv;
        localObject3 = this.sKQ.sLs;
        bool2 = this.sKQ.bEP();
        if ((!bf.mA((String)localObject3)) && ((localObject3 == null) || (((String)localObject3).equals(m.xL())))) {
          break label587;
        }
        bool1 = false;
        if (!this.sKQ.sLe) {
          break label902;
        }
        bool1 = this.sKQ.sLf;
      }
      for (;;)
      {
        int i2 = this.sKQ.sLk;
        if ((!bool2) || (bool1)) {}
        int n;
        Object localObject4;
        for (k = 2;; k = 1)
        {
          n = 0;
          localObject3 = this.sKQ;
          localObject4 = this.context;
          if (localObject4 != null) {
            break label599;
          }
          m = 0;
          i1 = 0;
          while ((i1 < this.sKQ.getCount()) && (i1 < i2 + k))
          {
            localObject3 = new ContactListExpandPreference(this.context, 1);
            ((ContactListExpandPreference)localObject3).setKey(xl(n));
            localObject4 = ((ContactListExpandPreference)localObject3).sLF;
            ((g)localObject4).sKQ = this.sKQ;
            ((g)localObject4).row = n;
            ((g)localObject4).index = i1;
            ((ContactListExpandPreference)localObject3).sLF.sLG = m;
            ((ContactListExpandPreference)localObject3).sLF.krC = bool1;
            ((ContactListExpandPreference)localObject3).sLF.oOv = ((View.OnClickListener)localObject2);
            ((ContactListExpandPreference)localObject3).sLF.sKW = this.sKW;
            ((ContactListExpandPreference)localObject3).sLF.sLH = ((g.b)localObject1);
            this.isp.a((Preference)localObject3, j + n);
            this.sKN.put(((Preference)localObject3).igr, localObject3);
            i1 += m;
            n += 1;
          }
          i = 0;
          break;
          localObject1 = this.sKV;
          break label264;
          localObject2 = this.sKU;
          break label277;
          bool1 = true;
          break label322;
        }
        Display localDisplay = ((WindowManager)((Context)localObject4).getSystemService("window")).getDefaultDisplay();
        m = localDisplay.getWidth();
        int i1 = localDisplay.getHeight();
        float f2;
        if ((m / (((Context)localObject4).getResources().getDimension(a.b.aXC) + ((Context)localObject4).getResources().getDimension(a.b.aXy) * 2.0F) >= 5.0F) && (i1 > m))
        {
          ((f)localObject3).sLy = true;
          f2 = ((Context)localObject4).getResources().getDimension(a.b.aXy);
          if (!((f)localObject3).sLy) {
            break label801;
          }
        }
        for (float f1 = ((Context)localObject4).getResources().getDimension(a.b.aXC);; f1 = ((Context)localObject4).getResources().getDimension(a.b.aXA))
        {
          i1 = (int)(f1 + 2.0F * f2);
          i1 = (int)((m - ((Context)localObject4).getResources().getDimension(a.b.aXv) * 1.0F) / i1);
          v.i("MicroMsg.ContactsListArchAdapter", "[getWrapColNum] :%s", new Object[] { Integer.valueOf(i1) });
          f.sLa = i1;
          m = i1;
          if (i1 != 4) {
            break;
          }
          f.sKZ = 43;
          m = i1;
          break;
          ((f)localObject3).sLy = false;
          break label680;
        }
        if (i != 0)
        {
          localObject1 = new ContactListCustomPreference(this.context);
          ((ContactListCustomPreference)localObject1).setKey(xl(-2));
          ((ContactListCustomPreference)localObject1).setCustomView(this.nuV);
          ((ContactListCustomPreference)localObject1).oOv = this.sKT;
          this.isp.a((Preference)localObject1, j + n);
          this.sKN.put(((Preference)localObject1).igr, localObject1);
        }
        GMTrace.o(963280633856L, 7177);
        return;
      }
    }
  }
  
  final void zD(String paramString)
  {
    GMTrace.i(963012198400L, 7175);
    f localf = this.sKQ;
    localf.username = paramString;
    localf.fNX = o.dH(paramString);
    if ((!localf.fNX) && (j.a.sLL != null)) {
      localf.sLe = j.a.sLL.MK(paramString);
    }
    if (!localf.sLe) {
      localf.krF = ((a)h.h(a.class)).xa().fV(paramString);
    }
    if ((localf.sLe) && (j.a.sLL != null)) {
      localf.kuE = j.a.sLL.MM(localf.username);
    }
    this.sKQ.sLq = this.sKP;
    this.sKQ.notifyChanged();
    aVC();
    GMTrace.o(963012198400L, 7175);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/ui/applet/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */