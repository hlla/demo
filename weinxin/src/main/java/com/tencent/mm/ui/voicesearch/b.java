package com.tencent.mm.ui.voicesearch;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.bg.a;
import com.tencent.mm.e.b.af;
import com.tencent.mm.modelbiz.l;
import com.tencent.mm.modelsimple.aa;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.protocal.c.avu;
import com.tencent.mm.protocal.c.awm;
import com.tencent.mm.protocal.c.awo;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ag.a;
import com.tencent.mm.u.ag.c;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bh;
import com.tencent.mm.u.c;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.applet.b.b;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.base.MaskLayout.a;
import com.tencent.mm.ui.p.a;
import com.tencent.mm.ui.r;
import com.tencent.mm.x.d;
import com.tencent.mm.y.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@SuppressLint({"DefaultLocale"})
public final class b
  extends com.tencent.mm.ui.k<x>
  implements e
{
  private Context context;
  public com.tencent.mm.ui.applet.b hAM;
  private b.b hAN;
  private LinkedList<awm> hkc;
  private ProgressDialog isb;
  private List<String> jzO;
  private int showType;
  public String vSQ;
  public String[] vts;
  public String wpS;
  private boolean wpT;
  private x wpU;
  private boolean wpV;
  public boolean wpW;
  private boolean wpX;
  
  public b(Context paramContext, int paramInt)
  {
    super(paramContext, new x());
    GMTrace.i(2833738891264L, 21113);
    this.wpT = false;
    this.wpU = null;
    this.hkc = new LinkedList();
    this.jzO = null;
    this.wpV = true;
    this.isb = null;
    this.wpW = false;
    this.showType = 1;
    this.hAM = new com.tencent.mm.ui.applet.b(new com.tencent.mm.ui.applet.b.a()
    {
      public final Bitmap jg(String paramAnonymousString)
      {
        GMTrace.i(2846086922240L, 21205);
        paramAnonymousString = com.tencent.mm.x.b.a(paramAnonymousString, false, -1);
        GMTrace.o(2846086922240L, 21205);
        return paramAnonymousString;
      }
    });
    this.hAN = null;
    this.wpX = false;
    this.context = paramContext;
    this.showType = paramInt;
    this.wpU = new x();
    this.wpU.setUsername("_find_more_public_contact_");
    this.wpU.tl();
    this.vSQ = "@micromsg.with.all.biz.qq.com";
    GMTrace.o(2833738891264L, 21113);
  }
  
  public static String Ut(String paramString)
  {
    GMTrace.i(14473771352064L, 107838);
    String str = paramString.trim();
    paramString = str;
    if (str.startsWith("@")) {
      paramString = str.substring(1) + "%@micromsg.with.all.biz.qq.com";
    }
    v.d("MicroMsg.SearchResultAdapter", "translateQueryText [" + paramString + "]");
    GMTrace.o(14473771352064L, 107838);
    return paramString;
  }
  
  public final awm Ce(int paramInt)
  {
    GMTrace.i(2834678415360L, 21120);
    try
    {
      v.d("MicroMsg.SearchResultAdapter", "position " + paramInt + " size " + this.hkc.size() + "  " + (paramInt - ani()));
      awm localawm = (awm)this.hkc.get(paramInt - ani() - 1);
      GMTrace.o(2834678415360L, 21120);
      return localawm;
    }
    catch (Exception localException)
    {
      v.printErrStackTrace("MicroMsg.SearchResultAdapter", localException, "", new Object[0]);
      GMTrace.o(2834678415360L, 21120);
    }
    return null;
  }
  
  public final boolean Cf(int paramInt)
  {
    GMTrace.i(2835215286272L, 21124);
    if (this.wpT)
    {
      int i = ani();
      if ((paramInt == i) && (paramInt < i + aBO()))
      {
        GMTrace.o(2835215286272L, 21124);
        return true;
      }
    }
    GMTrace.o(2835215286272L, 21124);
    return false;
  }
  
  public final void OL()
  {
    GMTrace.i(2835617939456L, 21127);
    aa(new Runnable()
    {
      public final void run()
      {
        int i = 0;
        GMTrace.i(2847563317248L, 21216);
        Object localObject2;
        Object localObject3;
        if ((b.g(b.this) != null) && (b.g(b.this).length != 0))
        {
          localObject1 = new ArrayList();
          localObject2 = b.g(b.this);
          int j = localObject2.length;
          while (i < j)
          {
            localObject3 = localObject2[i];
            if (b.this.Uu((String)localObject3)) {
              ((List)localObject1).add(localObject3);
            }
            i += 1;
          }
          if (((List)localObject1).size() > 0)
          {
            localObject2 = b.this;
            ap.yY();
            b.a((b)localObject2, c.wR().a((String[])((List)localObject1).toArray(new String[((List)localObject1).size()]), b.h(b.this), b.a(b.this)));
            GMTrace.o(2847563317248L, 21216);
            return;
          }
          localObject1 = b.this;
          ap.yY();
          b.b((b)localObject1, c.wR().aJZ());
          GMTrace.o(2847563317248L, 21216);
          return;
        }
        if (b.i(b.this) != null)
        {
          if (!b.h(b.this).equals("@all.chatroom.contact"))
          {
            localObject1 = ap.yY().hkt.a(b.i(b.this), b.h(b.this), b.a(b.this), true);
            b.c(b.this, (Cursor)localObject1);
            GMTrace.o(2847563317248L, 21216);
            return;
          }
          localObject1 = ap.yY().hkt.a(b.i(b.this), "@micromsg.with.all.biz.qq.com", b.a(b.this), false);
          localObject2 = new ArrayList();
          localObject3 = new ArrayList();
          while (((Cursor)localObject1).moveToNext())
          {
            String str = ((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndex("username"));
            if (!str.endsWith("@chatroom")) {
              ((ArrayList)localObject2).add(str);
            } else {
              ((ArrayList)localObject3).add(str);
            }
          }
          if (!((Cursor)localObject1).isClosed()) {
            ((Cursor)localObject1).close();
          }
          if ((((ArrayList)localObject2).size() != 0) || (((ArrayList)localObject3).size() != 0)) {}
          for (localObject1 = ap.yY().hkt.a(b.i(b.this), (ArrayList)localObject2, null, (ArrayList)localObject3, b.a(b.this));; localObject1 = c.wR().aJZ())
          {
            b.d(b.this, (Cursor)localObject1);
            GMTrace.o(2847563317248L, 21216);
            return;
            ap.yY();
          }
        }
        Object localObject1 = b.this;
        ap.yY();
        b.e((b)localObject1, c.wR().aJZ());
        GMTrace.o(2847563317248L, 21216);
      }
    });
    GMTrace.o(2835617939456L, 21127);
  }
  
  protected final void OM()
  {
    GMTrace.i(2835752157184L, 21128);
    aEP();
    OL();
    GMTrace.o(2835752157184L, 21128);
  }
  
  public final void Us(final String paramString)
  {
    GMTrace.i(2835081068544L, 21123);
    aa(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(2842463043584L, 21178);
        if (b.b(b.this).isHidden())
        {
          b.b(b.this).tm();
          if (b.c(b.this))
          {
            aa localaa = new aa(paramString, 3);
            ap.vd().a(localaa, 0);
            b.d(b.this);
            GMTrace.o(2842463043584L, 21178);
          }
        }
        else
        {
          b.b(b.this).tl();
        }
        GMTrace.o(2842463043584L, 21178);
      }
    });
    GMTrace.o(2835081068544L, 21123);
  }
  
  public final boolean Uu(String paramString)
  {
    GMTrace.i(2836691681280L, 21135);
    if ((this.jzO != null) && (paramString != null))
    {
      Iterator localIterator = this.jzO.iterator();
      while (localIterator.hasNext()) {
        if (((String)localIterator.next()).equals(paramString))
        {
          GMTrace.o(2836691681280L, 21135);
          return false;
        }
      }
    }
    GMTrace.o(2836691681280L, 21135);
    return true;
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, final com.tencent.mm.y.k paramk)
  {
    GMTrace.i(2836423245824L, 21133);
    v.d("MicroMsg.SearchResultAdapter", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (paramk.getType() != 106)
    {
      v.e("MicroMsg.SearchResultAdapter", "error type");
      GMTrace.o(2836423245824L, 21133);
      return;
    }
    if (this.isb != null)
    {
      this.isb.dismiss();
      this.isb = null;
    }
    this.wpX = false;
    if (p.a.a(this.context, paramInt1, paramInt2, paramString, 7))
    {
      this.wpV = false;
      GMTrace.o(2836423245824L, 21133);
      return;
    }
    if ((paramInt1 == 4) && (paramInt2 == -4))
    {
      aa(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(2849173929984L, 21228);
          b.b(b.this, false);
          GMTrace.o(2849173929984L, 21228);
        }
      });
      GMTrace.o(2836423245824L, 21133);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      aa(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(2847294881792L, 21214);
          b.b(b.this, false);
          GMTrace.o(2847294881792L, 21214);
        }
      });
      GMTrace.o(2836423245824L, 21133);
      return;
    }
    aa(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(2842194608128L, 21176);
        Object localObject1 = ((aa)paramk).Jy();
        v.d("MicroMsg.SearchResultAdapter", "count " + ((awo)localObject1).tCj);
        if (((awo)localObject1).tCj > 0)
        {
          localObject1 = ((awo)localObject1).tCk.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (awm)((Iterator)localObject1).next();
            if (o.eW(((awm)localObject2).tLd))
            {
              if (b.f(b.this) == null) {
                b.a(b.this, new LinkedList());
              }
              b.f(b.this).add(localObject2);
            }
          }
        }
        Object localObject2 = com.tencent.mm.platformtools.n.a(((awo)localObject1).trH);
        v.d("MicroMsg.SearchResultAdapter", "user " + (String)localObject2);
        if (bf.mz((String)localObject2).length() > 0)
        {
          awm localawm = new awm();
          localawm.trH = ((awo)localObject1).trH;
          localawm.tLd = ((awo)localObject1).tLd;
          localawm.hAo = ((awo)localObject1).hAo;
          localawm.tJy = ((awo)localObject1).tJy;
          localawm.hAq = ((awo)localObject1).hAq;
          localawm.hAu = ((awo)localObject1).hAu;
          localawm.hAn = ((awo)localObject1).hAn;
          localawm.hAm = ((awo)localObject1).hAm;
          localawm.hAl = ((awo)localObject1).hAl;
          localawm.tLe = ((awo)localObject1).tLe;
          localawm.tLh = ((awo)localObject1).tLh;
          localawm.tLf = ((awo)localObject1).tLf;
          localawm.tLg = ((awo)localObject1).tLg;
          localawm.tLj = ((awo)localObject1).tLj;
          com.tencent.mm.x.n.Bl().g((String)localObject2, com.tencent.mm.platformtools.n.a(((awo)localObject1).tdB));
          if (b.f(b.this) == null) {
            b.a(b.this, new LinkedList());
          }
          b.f(b.this).clear();
          if (o.eW(localawm.tLd)) {
            b.f(b.this).add(localawm);
          }
          v.d("MicroMsg.SearchResultAdapter", "count " + b.f(b.this).size());
        }
        b.b(b.this, false);
        GMTrace.o(2842194608128L, 21176);
      }
    });
    GMTrace.o(2836423245824L, 21133);
  }
  
  protected final int aBO()
  {
    int i = 0;
    GMTrace.i(2834544197632L, 21119);
    if (this.wpT)
    {
      if (this.wpU.isHidden()) {}
      for (;;)
      {
        GMTrace.o(2834544197632L, 21119);
        return i + 1;
        i = this.hkc.size();
      }
    }
    GMTrace.o(2834544197632L, 21119);
    return 0;
  }
  
  public final void aa(final Runnable paramRunnable)
  {
    GMTrace.i(2836557463552L, 21134);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      paramRunnable.run();
      notifyDataSetChanged();
      GMTrace.o(2836557463552L, 21134);
      return;
    }
    ae.v(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(2841926172672L, 21174);
        paramRunnable.run();
        b.this.notifyDataSetChanged();
        GMTrace.o(2841926172672L, 21174);
      }
    });
    GMTrace.o(2836557463552L, 21134);
  }
  
  public final void cK(final List<String> paramList)
  {
    GMTrace.i(2833873108992L, 21114);
    aa(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(2846758010880L, 21210);
        if (b.a(b.this) == null) {
          b.a(b.this, new ArrayList());
        }
        b.a(b.this).clear();
        b.a(b.this).addAll(paramList);
        b.a(b.this).add("officialaccounts");
        b.a(b.this).add("helper_entry");
        GMTrace.o(2846758010880L, 21210);
      }
    });
    GMTrace.o(2833873108992L, 21114);
  }
  
  public final void cW(List<String> paramList)
  {
    GMTrace.i(2836154810368L, 21131);
    this.vts = ((String[])paramList.toArray(new String[paramList.size()]));
    this.wpS = null;
    aEP();
    OL();
    GMTrace.o(2836154810368L, 21131);
  }
  
  public final void detach()
  {
    GMTrace.i(2834141544448L, 21116);
    if (this.hAM != null)
    {
      this.hAM.detach();
      this.hAM = null;
    }
    GMTrace.o(2834141544448L, 21116);
  }
  
  public final int getItemViewType(int paramInt)
  {
    GMTrace.i(2834409979904L, 21118);
    if (this.showType == 2)
    {
      GMTrace.o(2834409979904L, 21118);
      return 2;
    }
    if (Cf(paramInt))
    {
      GMTrace.o(2834409979904L, 21118);
      return 1;
    }
    GMTrace.o(2834409979904L, 21118);
    return 0;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    GMTrace.i(2835483721728L, 21126);
    boolean bool1 = nF(paramInt);
    boolean bool2 = Cf(paramInt);
    Object localObject3;
    if ((this.wpT) && (bool1))
    {
      paramViewGroup = paramView;
      Object localObject1;
      if (paramView != null)
      {
        localObject1 = (a)paramView.getTag();
        paramViewGroup = paramView;
        if (bool2)
        {
          paramViewGroup = paramView;
          if (((a)localObject1).wqa == null) {
            paramViewGroup = null;
          }
        }
      }
      if (paramViewGroup == null) {
        if (bool2)
        {
          paramViewGroup = View.inflate(this.context, R.i.cZl, null);
          paramView = new a();
          paramView.jXN = ((TextView)paramViewGroup.findViewById(R.h.bGf));
          paramView.wqa = ((ProgressBar)paramViewGroup.findViewById(R.h.cAM));
          paramViewGroup.setTag(paramView);
        }
      }
      for (;;)
      {
        if (!bool2)
        {
          if (this.hAN == null) {
            this.hAN = new b.b()
            {
              public final int Fi()
              {
                GMTrace.i(2846489575424L, 21208);
                if (b.f(b.this) == null)
                {
                  GMTrace.o(2846489575424L, 21208);
                  return 0;
                }
                int i = b.f(b.this).size();
                GMTrace.o(2846489575424L, 21208);
                return i;
              }
              
              public final String fE(int paramAnonymousInt)
              {
                GMTrace.i(2846355357696L, 21207);
                if (paramAnonymousInt < 0)
                {
                  v.e("MicroMsg.SearchResultAdapter", "pos is invalid");
                  GMTrace.o(2846355357696L, 21207);
                  return null;
                }
                Object localObject = b.this.Ce(b.e(b.this) + paramAnonymousInt + 1);
                if (localObject == null)
                {
                  GMTrace.o(2846355357696L, 21207);
                  return null;
                }
                localObject = ((awm)localObject).trH.tXF;
                GMTrace.o(2846355357696L, 21207);
                return (String)localObject;
              }
            };
          }
          if (this.hAM != null) {
            this.hAM.a(paramInt - ani() - 1, this.hAN);
          }
          localObject1 = Ce(paramInt);
          paramView.mRQ.setVisibility(8);
          if (localObject1 == null)
          {
            GMTrace.o(2835483721728L, 21126);
            return paramViewGroup;
            paramViewGroup = View.inflate(this.context, R.i.cZq, null);
            paramView = new a();
            paramView.mRQ = ((TextView)paramViewGroup.findViewById(R.h.bGd));
            paramView.kvj = ((MaskLayout)paramViewGroup.findViewById(R.h.bGb));
            paramView.jXN = ((TextView)paramViewGroup.findViewById(R.h.bGf));
            paramView.ipe = ((CheckBox)paramViewGroup.findViewById(R.h.bGg));
            paramView.vYb = ((TextView)paramViewGroup.findViewById(R.h.bFZ));
            paramViewGroup.setTag(paramView);
            continue;
            paramView = (a)paramViewGroup.getTag();
          }
          else
          {
            paramView.vYb.setVisibility(8);
            a.b.a((ImageView)paramView.kvj.view, ((awm)localObject1).trH.tXF);
            if (((awm)localObject1).tLd != 0) {
              if (ag.a.hlC != null)
              {
                localObject3 = ag.a.hlC.eZ(((awm)localObject1).tLd);
                if (localObject3 != null)
                {
                  localObject3 = l.il((String)localObject3);
                  paramView.kvj.d((Bitmap)localObject3, MaskLayout.a.vmg);
                  localObject1 = bf.mz(((awm)localObject1).tJy.tXF);
                }
              }
            }
          }
        }
      }
      for (;;)
      {
        try
        {
          paramView.jXN.setText(h.b(this.context, (CharSequence)localObject1, paramView.jXN.getTextSize()));
          GMTrace.o(2835483721728L, 21126);
          return paramViewGroup;
          paramView.kvj.bSx();
          break;
          paramView.kvj.bSx();
          break;
          paramView.kvj.bSx();
        }
        catch (Exception localException1)
        {
          v.printErrStackTrace("MicroMsg.SearchResultAdapter", localException1, "", new Object[0]);
          paramView.jXN.setText("");
          continue;
        }
        if (this.wpX) {
          paramView.wqa.setVisibility(0);
        }
        for (;;)
        {
          v.d("MicroMsg.SearchResultAdapter", "refresh  " + this.wpV);
          if (((this.hkc != null) && (this.hkc.size() != 0)) || (this.wpV)) {
            break label627;
          }
          paramView.jXN.setText(this.context.getString(R.l.dCw));
          paramView.jXN.setTextColor(this.context.getResources().getColor(R.e.aUz));
          break;
          paramView.wqa.setVisibility(8);
        }
        label627:
        paramView.jXN.setText(this.context.getString(R.l.dCx));
        paramView.jXN.setTextColor(a.S(this.context, R.e.aVa));
      }
    }
    if (this.showType == 2)
    {
      if (paramView == null)
      {
        paramView = View.inflate(this.context, R.i.dpo, null);
        paramViewGroup = new a();
        paramViewGroup.jXN = ((TextView)paramView.findViewById(R.h.bGf));
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        Object localObject2 = kK(paramInt);
        paramViewGroup.jXN.setTextColor(a.S(this.context, R.e.aVa));
        try
        {
          localObject2 = this.context.getString(R.l.faK, new Object[] { com.tencent.mm.u.n.a((x)localObject2, ((af)localObject2).field_username) });
          paramViewGroup.jXN.setText(h.b(this.context, (CharSequence)localObject2, paramViewGroup.jXN.getTextSize()));
          paramViewGroup.jXN.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
          GMTrace.o(2835483721728L, 21126);
          return paramView;
          paramViewGroup = (a)paramView.getTag();
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            paramViewGroup.jXN.setText("");
          }
        }
      }
    }
    if (paramView != null)
    {
      paramViewGroup = (a)paramView.getTag();
      if (paramViewGroup == null) {
        paramView = null;
      }
    }
    for (;;)
    {
      if (paramView == null)
      {
        paramViewGroup = r.eC(this.context).inflate(R.i.cZq, null);
        paramView = new a();
        paramView.mRQ = ((TextView)paramViewGroup.findViewById(R.h.bGd));
        paramView.kvj = ((MaskLayout)paramViewGroup.findViewById(R.h.bGb));
        paramView.jXN = ((TextView)paramViewGroup.findViewById(R.h.bGf));
        paramView.ipe = ((CheckBox)paramViewGroup.findViewById(R.h.bGg));
        paramView.vYb = ((TextView)paramViewGroup.findViewById(R.h.bFZ));
        paramViewGroup.setTag(paramView);
      }
      for (;;)
      {
        x localx = kK(paramInt);
        if (paramView.mRQ != null) {
          paramView.mRQ.setVisibility(8);
        }
        localObject3 = paramView.jXN;
        Context localContext = this.context;
        if (!o.fE(localx.field_username)) {
          paramInt = R.e.aVa;
        }
        for (;;)
        {
          ((TextView)localObject3).setTextColor(a.S(localContext, paramInt));
          a.b.a((ImageView)paramView.kvj.view, localx.field_username);
          paramView.vYb.setVisibility(8);
          if (localx.field_verifyFlag != 0) {
            if (ag.a.hlC != null)
            {
              localObject3 = ag.a.hlC.eZ(localx.field_verifyFlag);
              if (localObject3 != null)
              {
                localObject3 = l.il((String)localObject3);
                paramView.kvj.d((Bitmap)localObject3, MaskLayout.a.vmg);
              }
            }
          }
          try
          {
            for (;;)
            {
              paramView.jXN.setText(h.b(this.context, com.tencent.mm.u.n.a(localx, localx.field_username), paramView.jXN.getTextSize()));
              GMTrace.o(2835483721728L, 21126);
              return paramViewGroup;
              paramInt = R.e.aVb;
              break;
              paramView.kvj.bSx();
              continue;
              paramView.kvj.bSx();
              continue;
              paramView.kvj.bSx();
            }
          }
          catch (Exception localException3)
          {
            for (;;)
            {
              paramView.jXN.setText("");
            }
          }
        }
        View localView = paramView;
        paramView = paramViewGroup;
        paramViewGroup = localView;
      }
      continue;
      paramViewGroup = null;
    }
  }
  
  public final int getViewTypeCount()
  {
    GMTrace.i(2834275762176L, 21117);
    GMTrace.o(2834275762176L, 21117);
    return 3;
  }
  
  public final boolean isEnabled(int paramInt)
  {
    GMTrace.i(2835349504000L, 21125);
    if ((Cf(paramInt)) && ((this.hkc == null) || (this.hkc.size() == 0)) && (!this.wpV))
    {
      GMTrace.o(2835349504000L, 21125);
      return false;
    }
    GMTrace.o(2835349504000L, 21125);
    return true;
  }
  
  public final x kK(int paramInt)
  {
    GMTrace.i(2834812633088L, 21121);
    if (nF(paramInt))
    {
      localx = (x)aBP();
      GMTrace.o(2834812633088L, 21121);
      return localx;
    }
    x localx = (x)super.getItem(paramInt);
    GMTrace.o(2834812633088L, 21121);
    return localx;
  }
  
  public final void lM(boolean paramBoolean)
  {
    GMTrace.i(2834007326720L, 21115);
    this.wpW = paramBoolean;
    if (paramBoolean) {
      this.wpU.tl();
    }
    GMTrace.o(2834007326720L, 21115);
  }
  
  public final void lN(final boolean paramBoolean)
  {
    GMTrace.i(2834946850816L, 21122);
    aa(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(2842731479040L, 21180);
        b.a(b.this, paramBoolean);
        GMTrace.o(2842731479040L, 21180);
      }
    });
    GMTrace.o(2834946850816L, 21122);
  }
  
  public final void onPause()
  {
    GMTrace.i(2836020592640L, 21130);
    ap.vd().b(106, this);
    GMTrace.o(2836020592640L, 21130);
  }
  
  public final void onResume()
  {
    GMTrace.i(2835886374912L, 21129);
    ap.vd().a(106, this);
    GMTrace.o(2835886374912L, 21129);
  }
  
  protected static final class a
  {
    public CheckBox ipe;
    public TextView jXN;
    public MaskLayout kvj;
    public TextView mRQ;
    public TextView vYb;
    public ProgressBar wqa;
    
    public a()
    {
      GMTrace.i(2841657737216L, 21172);
      GMTrace.o(2841657737216L, 21172);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/voicesearch/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */