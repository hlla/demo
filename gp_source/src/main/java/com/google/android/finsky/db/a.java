package com.google.android.finsky.db;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.finsky.dfemodel.DfeToc;
import com.google.android.finsky.dfemodel.Document;
import com.google.android.finsky.ds.a.hj;
import com.google.android.finsky.e.u;
import com.google.android.finsky.frameworkviews.bn;
import com.google.android.finsky.frameworkviews.bp;
import com.google.android.finsky.frameworkviews.bq;
import com.google.android.finsky.headerlistlayout.FinskyHeaderListLayout;
import com.google.android.finsky.headerlistlayout.n;
import com.google.android.finsky.pagesystem.ContentFrame;
import com.google.android.finsky.recyclerview.PlayRecyclerView;
import com.google.android.finsky.stream.a.d;
import com.google.android.finsky.stream.base.view.j;
import com.google.android.finsky.utils.ah;
import com.google.android.play.headerlist.PlayHeaderListLayout;
import com.google.wireless.android.a.b.a.a.bt;
import com.google.wireless.android.finsky.dfe.nano.gn;
import java.util.ArrayList;
import java.util.List;

public final class a
  extends com.google.android.finsky.pagesystem.b
  implements com.google.android.finsky.da.i, bn
{
  public com.google.android.finsky.accounts.c a;
  public com.google.android.finsky.stream.a.f ac;
  public com.google.android.finsky.dfemodel.h ad;
  public b.a ae;
  public b.a af;
  public com.google.android.finsky.da.g ag;
  public com.google.android.finsky.notification.c ah;
  public com.google.android.finsky.stream.a.w ai;
  private d aj;
  private ah ak;
  private com.google.android.finsky.dfemodel.f am;
  private int an = -1;
  private boolean ao;
  private boolean ap;
  private PlayRecyclerView aq;
  private final bt ar = u.a(29);
  public b.a c;
  
  protected final void R()
  {
    ((c)com.google.android.finsky.dt.b.a(this, c.class)).a(this);
  }
  
  public final void S()
  {
    if (this.ao)
    {
      this.bi.a(3, 1, 0, true);
      this.bi.a_(by_().getString(2131952762));
    }
    for (;;)
    {
      this.bi.q();
      return;
      this.bi.a(3, false);
      this.bi.a_(by_().getString(2131952768));
    }
  }
  
  public final int U()
  {
    if (this.ao) {
      return this.aW.getResources().getColor(2131100189);
    }
    return com.google.android.finsky.bw.h.a(j(), 3);
  }
  
  protected final int V()
  {
    return 2131624426;
  }
  
  protected final void W()
  {
    this.am = com.google.android.finsky.dfemodel.h.a(this.d.a(), this.ba.b.q, false, false);
    this.am.a(this);
    this.am.a(this);
    this.am.r();
  }
  
  protected final void X()
  {
    Object localObject;
    if (this.aj == null)
    {
      localObject = new ArrayList();
      if (!this.ap) {
        break label150;
      }
    }
    label150:
    for (int i = k().getDimensionPixelSize(2131167561);; i = 0)
    {
      ((List)localObject).add(new j(i, i));
      ((List)localObject).addAll(com.google.android.finsky.stream.a.w.a(this.aq.getContext()));
      this.aj = this.ac.a(com.google.android.finsky.dfemodel.h.a(this.am), this.aW, (com.google.android.finsky.navigationmanager.c)this.af.a(), this, this.bg, 2, null, this, null, false, false, false, true, null, null, false, com.google.android.finsky.stream.a.w.a(), (List)localObject, false);
      this.aj.a(this.aq);
      localObject = this.ak;
      if (localObject != null) {
        this.aj.a((ah)localObject);
      }
      return;
    }
  }
  
  public final View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    paramViewGroup = (FinskyHeaderListLayout)this.aX;
    paramViewGroup.a(new b(paramViewGroup.getContext()));
    this.aq = ((PlayRecyclerView)this.aX.findViewById(2131429008));
    this.aq.setLayoutManager(new LinearLayoutManager());
    this.ag.a(this);
    this.ap = this.ab.cY().a(12659870L);
    if (this.ap) {
      paramLayoutInflater.setBackgroundColor(k().getColor(2131100189));
    }
    return paramLayoutInflater;
  }
  
  protected final com.google.android.finsky.layoutswitcher.e a(ContentFrame paramContentFrame)
  {
    if (this.ab.cY().a(12657032L)) {
      return ((n)this.ae.a()).a(paramContentFrame, this);
    }
    return ((n)this.ae.a()).a(paramContentFrame, this, this, this.bg);
  }
  
  public final void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.J = true;
  }
  
  public final void a(List paramList)
  {
    if ((this.aq != null) && (paramList.isEmpty()))
    {
      paramList = this.am;
      if ((paramList != null) && (paramList.a()))
      {
        paramList = this.am.a;
        if (paramList != null) {
          break label230;
        }
      }
    }
    label164:
    label230:
    label274:
    for (;;)
    {
      this.aq.setAdapter(new com.google.android.finsky.recyclerview.b());
      Object localObject;
      if (this.ab.cY().a(12659870L))
      {
        paramList = (bp)this.aX.findViewById(2131429656);
        localObject = new bq();
        ((bq)localObject).e = k().getString(2131952205);
        ((bq)localObject).c = k().getString(2131952769);
        ((bq)localObject).d = 2131886224;
        paramList.a((bq)localObject, null);
        this.aq.setEmptyView((View)paramList);
      }
      for (;;)
      {
        this.aj = null;
        this.aj = null;
        paramList = this.ah;
        localObject = new com.google.wireless.android.finsky.dfe.n.a.e();
        ((com.google.wireless.android.finsky.dfe.n.a.e)localObject).a |= 0x1;
        ((com.google.wireless.android.finsky.dfe.n.a.e)localObject).b = 0;
        paramList.a((com.google.wireless.android.finsky.dfe.n.a.e)localObject, this.a.cS());
        return;
        this.aq.setEmptyView(this.aX.findViewById(2131428626));
      }
      int i = 0;
      for (;;)
      {
        if (i >= paramList.a()) {
          break label274;
        }
        if (paramList.a(i).bs())
        {
          if (paramList.a(i).bv().a.length != 0) {
            break label164;
          }
          break;
        }
        i += 1;
      }
    }
  }
  
  public final int ai()
  {
    return 3;
  }
  
  public final void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    this.ao = this.ab.cY().a(12652671L);
    S();
    paramBundle = this.am;
    if ((paramBundle == null) || (!paramBundle.a()))
    {
      au();
      W();
    }
    for (;;)
    {
      ((com.google.android.finsky.actionbar.f)this.c.a()).a();
      return;
      X();
    }
  }
  
  public final void f()
  {
    super.f();
    this.aq = null;
    if (this.aj != null)
    {
      this.ak = new ah();
      this.aj.b(this.ak);
      this.aj = null;
    }
    Object localObject = this.ag;
    if (localObject != null) {
      ((com.google.android.finsky.da.g)localObject).b(this);
    }
    localObject = this.am;
    if (localObject != null)
    {
      ((com.google.android.finsky.dfemodel.g)localObject).b(this);
      this.am.b(this);
    }
  }
  
  public final int getHeaderListSpacerHeight()
  {
    if (this.an < 0)
    {
      this.an = FinskyHeaderListLayout.a(this.aW, 2, 0);
      int i = this.aW.getResources().getDimensionPixelSize(2131166823);
      this.an -= i;
    }
    return this.an;
  }
  
  public final bt getPlayStoreUiElement()
  {
    return this.ar;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/db/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */