package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.support.v4.app.Fragment;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.modelbiz.l;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.ay;
import com.tencent.mm.u.ag.a;
import com.tencent.mm.u.ag.c;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.AddressView;
import com.tencent.mm.ui.applet.b;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.e;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.e.b;
import com.tencent.mm.ui.r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class a
  extends com.tencent.mm.ui.e<String, com.tencent.mm.storage.f>
  implements m.b
{
  public static final ColorStateList mYh;
  public static final ColorStateList mYi;
  b hAM;
  private String isc;
  protected MMSlideDelView.f jUm;
  protected MMSlideDelView.c jUn;
  protected MMSlideDelView.d jUp;
  private boolean jYI;
  protected List<String> jzO;
  View.OnClickListener lHM;
  protected MMSlideDelView.e nVv;
  StringBuilder sb;
  private int type;
  public HashMap<String, com.tencent.mm.storage.f> vSP;
  protected String vSQ;
  protected String vSR;
  private List<Object> vSS;
  private List<String> vST;
  private int vSU;
  protected int[] vSV;
  String[] vSW;
  protected AddressUI.a vSX;
  private Set<Integer> vSY;
  private int vSZ;
  private boolean vTa;
  a vTb;
  private boolean vTc;
  boolean vTd;
  private String vTe;
  LinkedList<View> vTf;
  boolean vTg;
  HashMap<View, ViewStub> vTh;
  private SparseArray<String> vTi;
  private SparseArray<Integer> vTj;
  private HashSet<String> vTk;
  private String[] vts;
  
  static
  {
    GMTrace.i(1744696246272L, 12999);
    mYh = com.tencent.mm.bg.a.S(aa.getContext(), R.e.aVa);
    mYi = com.tencent.mm.bg.a.S(aa.getContext(), R.e.aUo);
    GMTrace.o(1744696246272L, 12999);
  }
  
  public a(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    super(paramContext);
    GMTrace.i(1741340803072L, 12974);
    this.vSQ = null;
    this.vSR = null;
    this.jzO = null;
    this.vSU = 0;
    this.isc = "";
    this.vts = null;
    this.jUp = MMSlideDelView.bSe();
    this.vSY = new HashSet();
    this.vSZ = 0;
    this.vTa = true;
    this.hAM = null;
    this.jYI = false;
    this.vTc = false;
    this.vTd = false;
    this.vTf = new LinkedList();
    this.vTh = new HashMap();
    this.lHM = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        GMTrace.i(1839588179968L, 13706);
        v.v("MicroMsg.AddressAdapter", "on delView clicked");
        a.this.jUp.aFb();
        if (a.this.nVv != null) {
          a.this.nVv.aQ(((ViewStub)a.a(a.this).get(paramAnonymousView)).getTag());
        }
        GMTrace.o(1839588179968L, 13706);
      }
    };
    this.sb = new StringBuilder(32);
    this.vTi = new SparseArray();
    this.vTj = new SparseArray();
    this.vTk = new HashSet();
    this.vSP = new HashMap();
    this.context = paramContext;
    this.vSQ = paramString1;
    this.vSR = paramString2;
    this.type = paramInt;
    this.vTc = true;
    this.vSS = new LinkedList();
    this.vST = new LinkedList();
    this.vTe = com.tencent.mm.u.m.xL();
    this.TAG = "MiscroMsg.AddressDrawWithCacheAdapter";
    GMTrace.o(1741340803072L, 12974);
  }
  
  private int a(com.tencent.mm.storage.f paramf, int paramInt)
  {
    GMTrace.i(1743085633536L, 12987);
    if (paramInt < this.vSZ)
    {
      GMTrace.o(1743085633536L, 12987);
      return 32;
    }
    if (paramf == null)
    {
      v.e("MicroMsg.AddressAdapter", "contact is null, position:%d", new Object[] { Integer.valueOf(paramInt) });
      GMTrace.o(1743085633536L, 12987);
      return -1;
    }
    paramInt = paramf.field_showHead;
    GMTrace.o(1743085633536L, 12987);
    return paramInt;
  }
  
  private String b(com.tencent.mm.storage.f paramf, int paramInt)
  {
    GMTrace.i(1743219851264L, 12988);
    if (paramInt < this.vSZ)
    {
      paramf = getString(R.l.dCr);
      GMTrace.o(1743219851264L, 12988);
      return paramf;
    }
    if (paramf.field_showHead == 31)
    {
      GMTrace.o(1743219851264L, 12988);
      return "";
    }
    if (paramf.field_showHead == 123)
    {
      GMTrace.o(1743219851264L, 12988);
      return "#";
    }
    if (paramf.field_showHead == 33)
    {
      paramf = getString(R.l.dCf);
      GMTrace.o(1743219851264L, 12988);
      return paramf;
    }
    if (paramf.field_showHead == 43)
    {
      paramf = getString(R.l.eMt);
      GMTrace.o(1743219851264L, 12988);
      return paramf;
    }
    if (paramf.field_showHead == 32)
    {
      paramf = getString(R.l.dCr);
      GMTrace.o(1743219851264L, 12988);
      return paramf;
    }
    String str = (String)this.vTi.get(paramf.field_showHead);
    if (str != null)
    {
      GMTrace.o(1743219851264L, 12988);
      return str;
    }
    str = String.valueOf((char)paramf.field_showHead);
    this.vTi.put(paramf.field_showHead, str);
    GMTrace.o(1743219851264L, 12988);
    return str;
  }
  
  private boolean bXw()
  {
    GMTrace.i(1742414544896L, 12982);
    if ((this.vSQ.equals("@micromsg.qq.com")) || (this.vSQ.equals("@all.contact.without.chatroom")))
    {
      GMTrace.o(1742414544896L, 12982);
      return true;
    }
    GMTrace.o(1742414544896L, 12982);
    return false;
  }
  
  private String getString(int paramInt)
  {
    GMTrace.i(1743488286720L, 12990);
    String str2 = (String)this.vTi.get(paramInt);
    String str1 = str2;
    if (str2 == null)
    {
      str1 = this.context.getString(paramInt);
      this.vTi.put(paramInt, str1);
    }
    GMTrace.o(1743488286720L, 12990);
    return str1;
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.m paramm, Object paramObject)
  {
    GMTrace.i(1744159375360L, 12995);
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      v.d("MicroMsg.AddressAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramm, paramObject });
      GMTrace.o(1744159375360L, 12995);
      return;
    }
    ap.yY();
    if (paramm == c.wR()) {
      if ((!com.tencent.mm.u.o.eT((String)paramObject)) && (!this.vTk.contains((String)paramObject)))
      {
        super.o((String)paramObject, 2);
        if ((this.vTd) && (this.vSX != null))
        {
          this.vSX.vTG = true;
          v.d("MicroMsg.AddressAdapter", "ADDRESS onNotifyChange");
          GMTrace.o(1744159375360L, 12995);
        }
      }
      else
      {
        v.d("MicroMsg.AddressAdapter", "newcursor is stranger ，return");
      }
    }
    GMTrace.o(1744159375360L, 12995);
  }
  
  public final void a(MMSlideDelView.c paramc)
  {
    GMTrace.i(1741877673984L, 12978);
    this.jUn = paramc;
    GMTrace.o(1741877673984L, 12978);
  }
  
  public final void a(MMSlideDelView.e parame)
  {
    GMTrace.i(1741743456256L, 12977);
    this.nVv = parame;
    GMTrace.o(1741743456256L, 12977);
  }
  
  public final void a(MMSlideDelView.f paramf)
  {
    GMTrace.i(1741609238528L, 12976);
    this.jUm = paramf;
    GMTrace.o(1741609238528L, 12976);
  }
  
  public final SparseArray<String>[] a(HashSet<e.b<String, com.tencent.mm.storage.f>> paramHashSet, SparseArray<String>[] paramArrayOfSparseArray)
  {
    GMTrace.i(1743890939904L, 12993);
    paramHashSet = new SparseArray[paramArrayOfSparseArray.length];
    paramArrayOfSparseArray = new LinkedList();
    paramArrayOfSparseArray.add("weixin");
    long l = System.currentTimeMillis();
    ap.yY();
    paramArrayOfSparseArray = c.wR().b(this.vSQ, this.vSR, this.jzO, paramArrayOfSparseArray, bXw(), this.vTc);
    int i;
    if ((paramArrayOfSparseArray instanceof com.tencent.mm.bj.a.e))
    {
      com.tencent.mm.bj.a.d[] arrayOfd = ((com.tencent.mm.bj.a.e)paramArrayOfSparseArray).uKK;
      int k = arrayOfd.length;
      i = 0;
      while (i < k)
      {
        int j = 0;
        arrayOfd[i].yM(5000);
        paramHashSet[i] = new SparseArray();
        while (arrayOfd[i].moveToNext())
        {
          paramHashSet[i].put(j, arrayOfd[i].getString(0));
          j += 1;
        }
        i += 1;
      }
      this.vSZ = arrayOfd[0].getCount();
    }
    for (;;)
    {
      paramArrayOfSparseArray.close();
      v.d("MicroMsg.AddressAdapter", "refreshPosistion last :" + (System.currentTimeMillis() - l));
      GMTrace.o(1743890939904L, 12993);
      return paramHashSet;
      i = 0;
      paramHashSet[0] = new SparseArray();
      while (paramArrayOfSparseArray.moveToNext())
      {
        paramHashSet[0].put(i, paramArrayOfSparseArray.getString(0));
        i += 1;
      }
    }
  }
  
  public final ArrayList<com.tencent.mm.storage.f> ai(ArrayList<String> paramArrayList)
  {
    GMTrace.i(1743756722176L, 12992);
    long l = System.currentTimeMillis();
    Object localObject = new ArrayList();
    int i = 0;
    while (i < paramArrayList.size())
    {
      ((List)localObject).add((String)paramArrayList.get(i));
      i += 1;
    }
    paramArrayList = new ArrayList(((List)localObject).size());
    ap.yY();
    localObject = c.wR().cd((List)localObject);
    while (((Cursor)localObject).moveToNext())
    {
      com.tencent.mm.storage.f localf = new com.tencent.mm.storage.f();
      localf.b((Cursor)localObject);
      paramArrayList.add(localf);
    }
    ((Cursor)localObject).close();
    v.d("MicroMsg.AddressAdapter", "rebulidAllChangeData :" + (System.currentTimeMillis() - l));
    GMTrace.o(1743756722176L, 12992);
    return paramArrayList;
  }
  
  public final com.tencent.mm.bj.a.d<String> bOE()
  {
    GMTrace.i(16855867588608L, 125586);
    long l = System.currentTimeMillis();
    Object localObject = new LinkedList();
    ((LinkedList)localObject).add("weixin");
    ap.yY();
    localObject = c.wR().a(this.vSQ, this.vSR, this.jzO, (List)localObject, bXw(), this.vTc);
    v.d("MicroMsg.AddressAdapter", "kevin setCursor : " + (System.currentTimeMillis() - l));
    localObject = (com.tencent.mm.bj.a.d)localObject;
    GMTrace.o(16855867588608L, 125586);
    return (com.tencent.mm.bj.a.d<String>)localObject;
  }
  
  protected final void bXx()
  {
    GMTrace.i(1742548762624L, 12983);
    int k = getCount();
    if (k == 0)
    {
      GMTrace.o(1742548762624L, 12983);
      return;
    }
    this.vSZ = bOD();
    if (this.vts != null)
    {
      this.vSV = com.tencent.mm.u.o.a(this.vSQ, this.vSR, this.jzO, this.vts);
      this.vSW = com.tencent.mm.u.o.a(this.vSQ, this.vSR, this.vts, this.jzO);
    }
    for (;;)
    {
      this.vSY.clear();
      Object localObject1 = this.vSV;
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        k = localObject1[i];
        this.vSY.add(Integer.valueOf(k - 1));
        i += 1;
      }
      long l;
      if (bNB())
      {
        l = System.currentTimeMillis();
        localObject1 = new HashSet();
        this.vSV = new int[30];
        this.vSW = new String[30];
        j = this.vSZ;
        i = 0;
        if (j < k)
        {
          Object localObject2 = (com.tencent.mm.storage.f)yL(j);
          if (localObject2 != null)
          {
            localObject2 = b((com.tencent.mm.storage.f)localObject2, j);
            if (!((HashSet)localObject1).add(localObject2)) {
              break label266;
            }
            this.vSV[i] = (j - this.vSZ);
            this.vSW[i] = localObject2;
            i += 1;
          }
          label266:
          for (;;)
          {
            j += 1;
            break;
            v.d("MicroMsg.AddressAdapter", "newCursor getItem is null");
          }
        }
        v.d("MicroMsg.AddressAdapter", "newCursor resetShowHead by Memory : " + (System.currentTimeMillis() - l) + "favourCount : " + this.vSZ);
      }
      else
      {
        l = System.currentTimeMillis();
        this.vSV = com.tencent.mm.u.o.a(this.vSQ, this.vSR, this.jzO, this.isc);
        this.vSW = com.tencent.mm.u.o.a(this.vSQ, this.vSR, this.isc, this.jzO);
        v.d("MicroMsg.AddressAdapter", "kevin resetShowHead part1 : " + (System.currentTimeMillis() - l));
      }
    }
    GMTrace.o(1742548762624L, 12983);
  }
  
  public final void bXy()
  {
    GMTrace.i(1742682980352L, 12984);
    this.jUp.aFb();
    GMTrace.o(1742682980352L, 12984);
  }
  
  public final void bXz()
  {
    GMTrace.i(1744025157632L, 12994);
    super.o(null, 1);
    GMTrace.o(1744025157632L, 12994);
  }
  
  public final void cK(List<String> paramList)
  {
    GMTrace.i(1742011891712L, 12979);
    if (this.type != 2) {
      paramList.add(com.tencent.mm.u.m.xL());
    }
    ap.yY();
    Object localObject = c.wZ().AF("@t.qq.com");
    if (localObject != null) {
      paramList.add(((ay)localObject).name);
    }
    if ((this.type == 3) || (this.type == 5) || (this.type == 4) || (this.type == 1) || (this.type == 0))
    {
      localObject = com.tencent.mm.u.o.yu().iterator();
      while (((Iterator)localObject).hasNext()) {
        paramList.add((String)((Iterator)localObject).next());
      }
    }
    paramList.add("blogapp");
    this.jzO = paramList;
    GMTrace.o(1742011891712L, 12979);
  }
  
  public final void cU(String paramString, int paramInt)
  {
    GMTrace.i(1740938149888L, 12971);
    if (paramInt == 5) {
      this.vTk.add(paramString);
    }
    super.o(paramString, paramInt);
    GMTrace.o(1740938149888L, 12971);
  }
  
  public final int getCount()
  {
    GMTrace.i(1743354068992L, 12989);
    int i = super.getCount();
    GMTrace.o(1743354068992L, 12989);
    return i;
  }
  
  public final int getPositionForSection(int paramInt)
  {
    GMTrace.i(1742280327168L, 12981);
    int i = paramInt;
    if (this.vSV != null)
    {
      i = paramInt;
      if (paramInt >= 0)
      {
        i = paramInt;
        if (paramInt < this.vSV.length) {
          i = this.vSV[paramInt];
        }
      }
    }
    paramInt = this.vSZ;
    GMTrace.o(1742280327168L, 12981);
    return paramInt + i;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int j = -1;
    GMTrace.i(1742951415808L, 12986);
    int i;
    if (!this.vTg)
    {
      i = 0;
      while (i < 8)
      {
        this.vTf.add(r.eC(this.context).inflate(R.i.cTy, null));
        i += 1;
      }
      this.vTg = true;
    }
    com.tencent.mm.storage.f localf = (com.tencent.mm.storage.f)yL(paramInt);
    b localb;
    View localView;
    label255:
    label289:
    int k;
    if (paramView == null) {
      if (this.vTf.size() > 0)
      {
        paramView = (View)this.vTf.getFirst();
        this.vTf.removeFirst();
        localb = new b();
        localb.mRQ = ((TextView)paramView.findViewById(R.h.bGd));
        localb.mRR = ((TextView)paramView.findViewById(R.h.bGi));
        localb.mYm = ((AddressView)paramView.findViewById(R.h.cmc));
        localb.vTm = ((TextView)paramView.findViewById(R.h.bGa));
        localb.vTn = paramView.findViewById(R.h.bGh);
        paramViewGroup = localb.vTn.getLayoutParams();
        paramViewGroup.height = ((int)(com.tencent.mm.bg.a.U(this.context, R.f.aWL) * com.tencent.mm.bg.a.dL(this.context)));
        localb.vTn.setLayoutParams(paramViewGroup);
        this.vSX.krI.a(localb.mYm);
        paramView.setTag(localb);
        localView = paramView;
        if (localf != null)
        {
          paramView = (com.tencent.mm.storage.f)yL(paramInt - 1);
          paramViewGroup = (com.tencent.mm.storage.f)yL(paramInt + 1);
          if (paramView != null) {
            break label713;
          }
          i = -1;
          k = a(localf, paramInt);
          if (paramViewGroup != null) {
            break label726;
          }
          label302:
          if (!this.vTa) {
            break label786;
          }
          if (paramInt != 0) {
            break label739;
          }
          paramView = b(localf, paramInt);
          if (u.mA(paramView)) {
            break label786;
          }
          localb.mRQ.setVisibility(0);
          localb.mRQ.setText(paramView);
          label346:
          if ((!this.vTa) || (k == j)) {
            localb.vTn.setBackgroundResource(R.g.bgg);
          }
          com.tencent.mm.pluginsdk.ui.a.b.a(localb.mYm, localf.field_username);
          if (localf.field_verifyFlag == 0) {
            break label823;
          }
          if (ag.a.hlC == null) {
            break label811;
          }
          paramView = ag.a.hlC.eZ(localf.field_verifyFlag);
          if (paramView == null) {
            break label799;
          }
          paramView = l.il(paramView);
          localb.mYm.setMaskBitmap(paramView);
          label430:
          localb.mYm.updateTextColors();
          paramView = localf.uxg;
          if (paramView != null) {
            break label1037;
          }
        }
      }
    }
    try
    {
      Context localContext = this.context;
      if ((localf.field_conRemark == null) || (localf.field_conRemark.trim().equals(""))) {
        break label835;
      }
      paramView = localf.field_conRemark;
      label484:
      paramViewGroup = localf.field_username;
      if ((paramView == null) || (paramView.length() <= 0)) {
        break label1026;
      }
      label501:
      paramViewGroup = paramView;
      if ("".length() > 0)
      {
        paramViewGroup = paramView;
        if (!"".equals(paramView))
        {
          this.sb.append(paramView);
          this.sb.append("(");
          this.sb.append("");
          this.sb.append(")");
          paramViewGroup = this.sb.toString();
          this.sb.delete(0, this.sb.length());
        }
      }
      paramView = h.c(localContext, paramViewGroup, com.tencent.mm.bg.a.T(this.context, R.f.aXH));
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        paramView = null;
      }
    }
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = "";
    }
    localb.mYm.setName(paramViewGroup);
    label622:
    localb.mYm.setDescription(u.mz(localf.field_remarkDesc));
    localb.mYm.updatePositionFlag();
    paramViewGroup = localb.mYm;
    if (localb.mYm.getNickName() == null) {}
    for (paramView = "";; paramView = localb.mYm.getNickName().toString())
    {
      paramViewGroup.setContentDescription(paramView);
      GMTrace.o(1742951415808L, 12986);
      return localView;
      paramView = View.inflate(this.context, R.i.cTy, null);
      break;
      localb = (b)paramView.getTag();
      localView = paramView;
      break label255;
      label713:
      i = a(paramView, paramInt - 1);
      break label289;
      label726:
      j = a(paramViewGroup, paramInt + 1);
      break label302;
      label739:
      if ((paramInt > 0) && (k != i))
      {
        paramView = b(localf, paramInt);
        if (!u.mA(paramView))
        {
          localb.mRQ.setVisibility(0);
          localb.mRQ.setText(paramView);
          break label346;
        }
      }
      label786:
      localb.mRQ.setVisibility(8);
      break label346;
      label799:
      localb.mYm.setMaskBitmap(null);
      break label430;
      label811:
      localb.mYm.setMaskBitmap(null);
      break label430;
      label823:
      localb.mYm.setMaskBitmap(null);
      break label430;
      label835:
      paramViewGroup = com.tencent.mm.j.a.dM(localf.field_username);
      paramView = paramViewGroup;
      if (paramViewGroup != null) {
        break label484;
      }
      if ((localf.field_nickname == null) || (localf.field_nickname.length() <= 0))
      {
        paramViewGroup = localf.field_alias;
        paramView = paramViewGroup;
        if (!bf.mA(paramViewGroup)) {
          break label484;
        }
        paramView = localf.field_username;
        if (paramView == null) {
          paramViewGroup = null;
        }
        for (;;)
        {
          if (paramViewGroup != null)
          {
            paramView = paramViewGroup;
            if (paramViewGroup.length() != 0) {
              break;
            }
          }
          paramView = localf.field_username;
          break;
          if (paramView.toLowerCase().endsWith("@t.qq.com"))
          {
            paramViewGroup = "@" + paramView.replace("@t.qq.com", "");
          }
          else
          {
            paramViewGroup = paramView;
            if (paramView.toLowerCase().endsWith("@qqim"))
            {
              paramViewGroup = paramView.replace("@qqim", "");
              long l = Long.valueOf(paramViewGroup).longValue();
              if (l < 0L) {
                paramViewGroup = new com.tencent.mm.a.o(l).toString();
              }
            }
          }
        }
      }
      paramView = localf.field_nickname;
      break label484;
      label1026:
      paramView = paramViewGroup;
      break label501;
      label1037:
      localb.mYm.setName(paramView);
      break label622;
    }
  }
  
  public final void l(Fragment paramFragment)
  {
    GMTrace.i(1741475020800L, 12975);
    this.vSX = ((AddressUI.a)paramFragment);
    GMTrace.o(1741475020800L, 12975);
  }
  
  public final void notifyDataSetChanged()
  {
    GMTrace.i(1741206585344L, 12973);
    this.vTe = com.tencent.mm.u.m.xL();
    if (this.vSV == null) {
      bXx();
    }
    if (getCount() == 0)
    {
      GMTrace.o(1741206585344L, 12973);
      return;
    }
    this.vSZ = bOD();
    v.i("MicroMsg.AddressAdapter", "newcursor favourCount %d", new Object[] { Integer.valueOf(this.vSZ) });
    super.notifyDataSetChanged();
    GMTrace.o(1741206585344L, 12973);
  }
  
  public final void pause()
  {
    GMTrace.i(1741072367616L, 12972);
    this.vTk.clear();
    super.pause();
    GMTrace.o(1741072367616L, 12972);
  }
  
  public static abstract interface a {}
  
  protected static final class b
  {
    public TextView mRQ;
    public TextView mRR;
    public AddressView mYm;
    public TextView vTm;
    public View vTn;
    
    public b()
    {
      GMTrace.i(1716376305664L, 12788);
      GMTrace.o(1716376305664L, 12788);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/contact/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */