package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.database.Cursor;
import android.database.MergeCursor;
import android.util.SparseArray;
import android.widget.ListView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.l;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.d;
import com.tencent.mm.ui.contact.a.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class c
  extends o
  implements m.b
{
  private Cursor ips;
  private int oQp;
  private a vTV;
  private int vTW;
  private int vTX;
  private int vTY;
  private int vTZ;
  private int vUa;
  private int vUb;
  private HashMap<String, Integer> vUc;
  private SparseArray<String> vUd;
  
  public c(MMBaseSelectContactUI paramMMBaseSelectContactUI, List<String> paramList, boolean paramBoolean, a parama)
  {
    this(paramMMBaseSelectContactUI, paramList, true, paramBoolean, parama, false);
    GMTrace.i(16855733370880L, 125585);
    GMTrace.o(16855733370880L, 125585);
  }
  
  public c(MMBaseSelectContactUI paramMMBaseSelectContactUI, List<String> paramList, boolean paramBoolean1, boolean paramBoolean2, a parama, boolean paramBoolean3)
  {
    super(paramMMBaseSelectContactUI, paramList, paramBoolean1, paramBoolean2, paramBoolean3);
    GMTrace.i(16855599153152L, 125584);
    this.vTW = Integer.MAX_VALUE;
    this.oQp = Integer.MAX_VALUE;
    this.vTX = Integer.MAX_VALUE;
    this.vTY = Integer.MAX_VALUE;
    this.vTZ = Integer.MAX_VALUE;
    this.vUa = Integer.MAX_VALUE;
    this.vUb = Integer.MAX_VALUE;
    this.vUc = null;
    this.vUd = null;
    v.i("MicroMsg.AlphabetContactAdapter", "create!");
    if (parama != null) {}
    for (this.vTV = parama;; this.vTV = new a())
    {
      ap.yY();
      com.tencent.mm.u.c.wR().a(this);
      atX();
      GMTrace.o(16855599153152L, 125584);
      return;
    }
  }
  
  private void aD(int paramInt, String paramString)
  {
    GMTrace.i(1762010333184L, 13128);
    this.vUc.put(paramString, Integer.valueOf(paramInt));
    this.vUd.put(paramInt, paramString);
    GMTrace.o(1762010333184L, 13128);
  }
  
  private static a aE(int paramInt, String paramString)
  {
    GMTrace.i(1762547204096L, 13132);
    com.tencent.mm.ui.contact.a.g localg = new com.tencent.mm.ui.contact.a.g(paramInt);
    localg.mbB = paramString;
    GMTrace.o(1762547204096L, 13132);
    return localg;
  }
  
  private void atX()
  {
    GMTrace.i(1761876115456L, 13127);
    this.vTW = Integer.MAX_VALUE;
    this.oQp = Integer.MAX_VALUE;
    this.vTX = Integer.MAX_VALUE;
    this.vTY = Integer.MAX_VALUE;
    this.vTZ = Integer.MAX_VALUE;
    this.vUb = Integer.MAX_VALUE;
    label73:
    int j;
    int i;
    ArrayList localArrayList;
    Object localObject1;
    label187:
    Object localObject2;
    if (this.vUc != null)
    {
      this.vUc.clear();
      if (this.vUd == null) {
        break label386;
      }
      this.vUd.clear();
      j = 0;
      i = 0;
      localArrayList = new ArrayList();
      if (!this.vTV.vUi) {
        break label486;
      }
      ap.yY();
      localObject1 = com.tencent.mm.u.c.wR().h(bf.f(this.vTV.vUl.split(",")), false);
      localArrayList.add(localObject1);
      j = ((Cursor)localObject1).getCount();
      v.d("MicroMsg.AlphabetContactAdapter", "ap: recent like count %d", new Object[] { Integer.valueOf(j) });
      if (j <= 0) {
        break label400;
      }
      this.vUb = 0;
      i = j + 1 + 0;
      aD(this.vUb, "☆");
      ap.yY();
      localObject2 = com.tencent.mm.u.c.wR().ci(bf.f(this.vTV.vUk.split(",")));
      localArrayList.add(localObject2);
      j = ((Cursor)localObject2).getCount();
      if (j <= 0) {
        break label409;
      }
      this.vTX = i;
      i += j + 1;
      aD(this.vTX, "☆");
    }
    Object localObject3;
    int k;
    for (;;)
    {
      localObject3 = bf.f(this.vTV.vUk.split(","));
      ap.yY();
      localArrayList.add(com.tencent.mm.u.c.wR().h((List)localObject3, true));
      localObject2 = com.tencent.mm.u.o.u((List)localObject3);
      localObject3 = com.tencent.mm.u.o.t((List)localObject3);
      if ((localObject2 == null) || (localObject3 == null)) {
        break label426;
      }
      k = 0;
      j = i;
      i = k;
      while (i < localObject2.length)
      {
        k = j;
        if (i < localObject3.length)
        {
          aD(localObject3[i] + j, localObject2[i]);
          k = j + 1;
        }
        i += 1;
        j = k;
      }
      this.vUc = new HashMap();
      break;
      label386:
      this.vUd = new SparseArray();
      break label73;
      label400:
      this.vUb = Integer.MAX_VALUE;
      break label187;
      label409:
      this.vTX = Integer.MAX_VALUE;
    }
    ((Cursor)localObject1).getCount();
    for (;;)
    {
      label426:
      v.d("MicroMsg.AlphabetContactAdapter", "headerPosMap=%s", new Object[] { this.vUc.toString() });
      this.ips = new MergeCursor((Cursor[])localArrayList.toArray(new Cursor[0]));
      notifyDataSetChanged();
      GMTrace.o(1761876115456L, 13127);
      return;
      label486:
      if (this.vTV.vUj)
      {
        this.vUa = 0;
        j = 1;
        aD(this.vUa, "nonLimit");
      }
      if ((this.vTV.vUm) && (this.vTV.vUn != null))
      {
        localObject1 = bf.f(this.vTV.vUn.split(";"));
        ap.yY();
        localObject1 = com.tencent.mm.u.c.wR().ce((List)localObject1);
        localArrayList.add(localObject1);
        i = ((Cursor)localObject1).getCount();
        if (i > 0)
        {
          this.vTW = j;
          i = j + (i + 1);
          aD(this.oQp, "↑");
          if (!this.vTV.vUf) {
            break label991;
          }
          ap.yY();
          localObject1 = com.tencent.mm.u.c.wR().cj(this.jzO);
          localArrayList.add(localObject1);
          j = ((Cursor)localObject1).getCount();
          if (j <= 0) {
            break label985;
          }
          this.vTX = i;
          aD(this.vTX, "☆");
          i += j + 1;
          label681:
          ap.yY();
          localObject1 = com.tencent.mm.u.c.wR();
          localObject2 = this.vTV.vSQ;
          localObject3 = this.jzO;
          if (this.vWx) {
            break label994;
          }
        }
      }
      label974:
      label985:
      label991:
      label994:
      for (boolean bool = true;; bool = false)
      {
        localObject1 = ((ar)localObject1).a((String)localObject2, "", (List)localObject3, false, bool);
        localArrayList.add(localObject1);
        localObject2 = com.tencent.mm.u.o.a(this.vTV.vSQ, "", "", this.jzO);
        localObject3 = com.tencent.mm.u.o.a(this.vTV.vSQ, "", this.jzO, "");
        j = i;
        if (localObject2 == null) {
          break label1014;
        }
        j = i;
        if (localObject3 == null) {
          break label1014;
        }
        j = 0;
        int m;
        for (k = i; j < localObject2.length; k = m)
        {
          m = k;
          if (j < localObject3.length)
          {
            aD(localObject3[j] + k, localObject2[j]);
            m = k + 1;
          }
          j += 1;
        }
        this.vTW = Integer.MAX_VALUE;
        i = j;
        break;
        i = j;
        if (!this.vTV.vUe) {
          break;
        }
        localObject1 = g.cL(this.jzO);
        if (((List)localObject1).size() == 0) {
          ap.yY();
        }
        for (localObject1 = com.tencent.mm.u.c.wR().aJZ();; localObject1 = com.tencent.mm.u.c.wR().ce((List)localObject1))
        {
          localArrayList.add(localObject1);
          i = ((Cursor)localObject1).getCount();
          if (i <= 0) {
            break label974;
          }
          this.oQp = j;
          i = j + (i + 1);
          aD(this.oQp, "↑");
          break;
          ap.yY();
        }
        this.oQp = Integer.MAX_VALUE;
        i = j;
        break;
        this.vTX = Integer.MAX_VALUE;
        break label681;
      }
      j = i + (((Cursor)localObject1).getCount() + localObject2.length);
      label1014:
      i = j;
      if (this.vTV.vUg)
      {
        ap.yY();
        localObject1 = com.tencent.mm.u.c.wR().c("@all.chatroom.contact", "", this.jzO);
        localArrayList.add(localObject1);
        i = ((Cursor)localObject1).getCount();
        if (i <= 0) {
          break label1191;
        }
        this.vTY = j;
        i = j + (i + 1);
        aD(this.vTY, this.vWg.getActivity().getString(R.l.dCj));
      }
      for (;;)
      {
        if (!this.vTV.vUh) {
          break label1200;
        }
        ap.yY();
        localObject1 = com.tencent.mm.u.c.wR().c("@verify.contact", "", this.jzO);
        localArrayList.add(localObject1);
        if (((Cursor)localObject1).getCount() <= 0) {
          break label1202;
        }
        this.vTZ = i;
        aD(this.vTZ, this.vWg.getActivity().getString(R.l.dCA));
        break;
        label1191:
        this.vTY = Integer.MAX_VALUE;
        i = j;
      }
      label1200:
      continue;
      label1202:
      this.vTZ = Integer.MAX_VALUE;
    }
  }
  
  public final int TL(String paramString)
  {
    GMTrace.i(1762144550912L, 13129);
    if (paramString.equals("↑"))
    {
      GMTrace.o(1762144550912L, 13129);
      return 0;
    }
    if (this.vUc != null)
    {
      if (this.vUc.containsKey(paramString))
      {
        int i = ((Integer)this.vUc.get(paramString)).intValue();
        int j = this.vWg.bcP().getHeaderViewsCount();
        GMTrace.o(1762144550912L, 13129);
        return i + j;
      }
      GMTrace.o(1762144550912L, 13129);
      return -1;
    }
    GMTrace.o(1762144550912L, 13129);
    return -1;
  }
  
  public final void a(int paramInt, m paramm, Object paramObject)
  {
    GMTrace.i(1762815639552L, 13134);
    atX();
    notifyDataSetChanged();
    GMTrace.o(1762815639552L, 13134);
  }
  
  protected final boolean c(a parama)
  {
    GMTrace.i(1762949857280L, 13135);
    int j = parama.position + 1;
    int k = this.vUb;
    int m = this.vTW;
    int n = this.oQp;
    int i1 = this.vTX;
    int i2 = this.vTY;
    int i3 = this.vTZ;
    int i = 0;
    while (i < 6)
    {
      if (j == new int[] { k, m, n, i1, i2, i3 }[i])
      {
        GMTrace.o(1762949857280L, 13135);
        return true;
      }
      i += 1;
    }
    if (this.vUd.indexOfKey(j) >= 0)
    {
      GMTrace.o(1762949857280L, 13135);
      return true;
    }
    GMTrace.o(1762949857280L, 13135);
    return false;
  }
  
  public final void finish()
  {
    GMTrace.i(1762681421824L, 13133);
    super.finish();
    v.i("MicroMsg.AlphabetContactAdapter", "finish!");
    if (this.ips != null)
    {
      this.ips.close();
      this.ips = null;
    }
    ap.yY();
    com.tencent.mm.u.c.wR().b(this);
    GMTrace.o(1762681421824L, 13133);
  }
  
  public final int getCount()
  {
    GMTrace.i(1762278768640L, 13130);
    int i = this.ips.getCount();
    int j = this.vUc.size();
    GMTrace.o(1762278768640L, 13130);
    return i + j;
  }
  
  protected final a hf(int paramInt)
  {
    GMTrace.i(1762412986368L, 13131);
    Object localObject;
    if (paramInt == this.vUb)
    {
      localObject = aE(paramInt, this.vWg.getActivity().getString(R.l.dCM));
      GMTrace.o(1762412986368L, 13131);
      return (a)localObject;
    }
    if (paramInt == this.vTW)
    {
      localObject = aE(paramInt, this.vTV.vUo);
      GMTrace.o(1762412986368L, 13131);
      return (a)localObject;
    }
    if (paramInt == this.oQp)
    {
      localObject = aE(paramInt, this.vWg.getActivity().getString(R.l.dCy));
      GMTrace.o(1762412986368L, 13131);
      return (a)localObject;
    }
    if (paramInt == this.vTX)
    {
      localObject = aE(paramInt, this.vWg.getActivity().getString(R.l.dCr));
      GMTrace.o(1762412986368L, 13131);
      return (a)localObject;
    }
    if (paramInt == this.vTY)
    {
      localObject = aE(paramInt, this.vWg.getActivity().getString(R.l.dCj));
      GMTrace.o(1762412986368L, 13131);
      return (a)localObject;
    }
    if (paramInt == this.vTZ)
    {
      localObject = aE(paramInt, this.vWg.getActivity().getString(R.l.dCA));
      GMTrace.o(1762412986368L, 13131);
      return (a)localObject;
    }
    if (paramInt == this.vUa)
    {
      localObject = new j(paramInt);
      GMTrace.o(1762412986368L, 13131);
      return (a)localObject;
    }
    if (this.vUd.indexOfKey(paramInt) >= 0)
    {
      localObject = aE(paramInt, (String)this.vUd.get(paramInt));
      GMTrace.o(1762412986368L, 13131);
      return (a)localObject;
    }
    int k = paramInt;
    int i = 0;
    int j;
    int m;
    do
    {
      j = i;
      if (i > this.vUd.size()) {
        break;
      }
      j = i;
      if (this.vUd.indexOfKey(k) >= 0) {
        j = i + 1;
      }
      m = k - 1;
      k = m;
      i = j;
    } while (m >= 0);
    i = paramInt - j;
    if (this.ips.moveToPosition(i))
    {
      v.d("MicroMsg.AlphabetContactAdapter", "create contact item position=%d | index=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      localObject = new x();
      ((x)localObject).b(this.ips);
      d locald = new d(paramInt);
      locald.jht = ((x)localObject);
      locald.vWh = bcI();
      locald.vWi = this.vWi;
      GMTrace.o(1762412986368L, 13131);
      return locald;
    }
    v.i("MicroMsg.AlphabetContactAdapter", "create contact item error: position=%d | index=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    GMTrace.o(1762412986368L, 13131);
    return null;
  }
  
  public static final class a
  {
    public String vSQ;
    public boolean vUe;
    public boolean vUf;
    public boolean vUg;
    public boolean vUh;
    public boolean vUi;
    public boolean vUj;
    public String vUk;
    public String vUl;
    public boolean vUm;
    public String vUn;
    public String vUo;
    
    public a()
    {
      GMTrace.i(1746306859008L, 13011);
      this.vUe = false;
      this.vUf = false;
      this.vUg = false;
      this.vUh = false;
      this.vUi = false;
      this.vUj = false;
      this.vSQ = "@all.contact.without.chatroom";
      this.vUm = false;
      this.vUn = "";
      this.vUo = "";
      GMTrace.o(1746306859008L, 13011);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/contact/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */