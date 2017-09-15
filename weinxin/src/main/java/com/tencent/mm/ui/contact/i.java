package com.tencent.mm.ui.contact;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.e.b.af;
import com.tencent.mm.j.a;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.modelbiz.d;
import com.tencent.mm.modelbiz.d.a;
import com.tencent.mm.modelbiz.d.a.b;
import com.tencent.mm.modelbiz.w;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ar;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class i
  extends LinearLayout
  implements d.a
{
  private Context context;
  private LinearLayout lHH;
  private List<String> vVC;
  private Map<String, View> vVD;
  private a vVE;
  
  public i(Context paramContext, a parama)
  {
    super(paramContext);
    GMTrace.i(1734227263488L, 12921);
    this.lHH = null;
    this.context = paramContext;
    this.vVE = parama;
    init();
    GMTrace.o(1734227263488L, 12921);
  }
  
  private void init()
  {
    int j = 0;
    GMTrace.i(1734495698944L, 12923);
    Object localObject2 = w.DH();
    Object localObject1 = new ArrayList();
    Object localObject3 = new StringBuilder();
    d.a((StringBuilder)localObject3);
    d.c((StringBuilder)localObject3);
    ((StringBuilder)localObject3).append(" and bizinfo.type").append(" = 2 ");
    ((StringBuilder)localObject3).append(" order by ");
    ((StringBuilder)localObject3).append(d.Dk());
    localObject3 = ((StringBuilder)localObject3).toString();
    v.i("MicroMsg.BizInfoStorage", "getEnterpriseFatherBizLst sql %s", new Object[] { localObject3 });
    localObject2 = ((d)localObject2).rawQuery((String)localObject3, new String[0]);
    if (localObject2 != null)
    {
      if (((Cursor)localObject2).moveToFirst()) {
        do
        {
          ((ArrayList)localObject1).add(((Cursor)localObject2).getString(0));
        } while (((Cursor)localObject2).moveToNext());
      }
      ((Cursor)localObject2).close();
    }
    this.vVC = ((List)localObject1);
    if ((this.vVC == null) || (this.vVC.size() <= 0))
    {
      v.e("MicroMsg.EnterpriseBizView", "bizList is null");
      GMTrace.o(1734495698944L, 12923);
      return;
    }
    v.i("MicroMsg.EnterpriseBizView", "biz list size = %s", new Object[] { Integer.valueOf(this.vVC.size()) });
    this.vVD = new HashMap();
    int i = j;
    if (this.lHH == null)
    {
      View.inflate(getContext(), R.i.daQ, this);
      this.lHH = ((LinearLayout)findViewById(R.h.bGk));
      i = j;
    }
    while (i < this.vVC.size())
    {
      localObject1 = (String)this.vVC.get(i);
      localObject2 = new j(getContext(), (String)localObject1);
      this.lHH.addView((View)localObject2);
      this.vVD.put(localObject1, localObject2);
      if (i == this.vVC.size() - 1) {
        ((j)localObject2).findViewById(R.h.bMc).setBackgroundResource(R.g.bhb);
      }
      i += 1;
    }
    GMTrace.o(1734495698944L, 12923);
  }
  
  public final void a(final d.a.b paramb)
  {
    GMTrace.i(1734629916672L, 12924);
    if (paramb.hvo == null)
    {
      GMTrace.o(1734629916672L, 12924);
      return;
    }
    if (!paramb.hvo.CH())
    {
      v.i("MicroMsg.EnterpriseBizView", "onEvent, not enterprise father");
      GMTrace.o(1734629916672L, 12924);
      return;
    }
    ae.v(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(1735569440768L, 12931);
        ap.yY();
        Object localObject = c.wR().Rb(paramb.htS);
        if ((i.a(i.this) != null) && (i.a(i.this).size() > 0) && (i.a(i.this).contains(paramb.htS)))
        {
          if ((localObject == null) || ((int)((a)localObject).gTG <= 0) || (!a.ez(((af)localObject).field_type)))
          {
            v.i("MicroMsg.EnterpriseBizView", "remove enterprise biz view item, %s", new Object[] { paramb.htS });
            i.a(i.this).remove(paramb.htS);
            if (i.a(i.this).size() > 0)
            {
              localObject = (View)i.b(i.this).get(paramb.htS);
              if ((localObject != null) && (i.c(i.this) != null))
              {
                i.c(i.this).removeView((View)localObject);
                i.b(i.this).remove(localObject);
              }
              GMTrace.o(1735569440768L, 12931);
              return;
            }
            if (i.d(i.this) != null)
            {
              if (i.b(i.this) != null) {
                i.b(i.this).clear();
              }
              if (i.c(i.this) != null) {
                i.c(i.this).removeAllViews();
              }
              i.d(i.this).BF(i.a(i.this).size());
              GMTrace.o(1735569440768L, 12931);
            }
          }
        }
        else
        {
          if ((localObject == null) || ((int)((a)localObject).gTG <= 0) || (!a.ez(((af)localObject).field_type)))
          {
            GMTrace.o(1735569440768L, 12931);
            return;
          }
          if (i.a(i.this) != null) {
            i.a(i.this).clear();
          }
          if (i.b(i.this) != null) {
            i.b(i.this).clear();
          }
          if (i.c(i.this) != null) {
            i.c(i.this).removeAllViews();
          }
          i.e(i.this);
          if (i.d(i.this) != null) {
            i.d(i.this).BF(i.a(i.this).size());
          }
        }
        GMTrace.o(1735569440768L, 12931);
      }
    });
    GMTrace.o(1734629916672L, 12924);
  }
  
  public final int bXL()
  {
    GMTrace.i(1734361481216L, 12922);
    if (this.vVC == null)
    {
      GMTrace.o(1734361481216L, 12922);
      return 0;
    }
    int i = this.vVC.size();
    GMTrace.o(1734361481216L, 12922);
    return i;
  }
  
  public static abstract interface a
  {
    public abstract void BF(int paramInt);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/contact/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */