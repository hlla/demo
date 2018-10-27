package com.google.android.finsky.bc;

import android.support.v4.app.Fragment;
import android.support.v4.app.o;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.google.android.finsky.bc.a.m;
import com.google.android.finsky.bc.a.n;
import com.google.android.finsky.bc.a.p;
import com.google.android.finsky.be.q;
import com.google.android.finsky.be.r;
import com.google.android.finsky.be.y;
import com.google.android.finsky.dialogbuilderlayout.i;
import com.google.android.finsky.e.aq;
import com.google.wireless.android.finsky.dfe.e.a.ch;
import com.google.wireless.android.finsky.dfe.e.a.ci;
import com.google.wireless.android.finsky.dfe.e.a.co;
import com.google.wireless.android.finsky.dfe.e.a.dy;
import com.google.wireless.android.finsky.dfe.e.a.fd;
import java.util.ArrayList;
import java.util.List;

public final class v
  implements d
{
  private final com.google.android.finsky.dialogbuilderlayout.w a;
  private final h b;
  private final n c;
  private final ArrayList d = new ArrayList();
  private final q e;
  private final r f;
  private final g g;
  private final boolean h;
  private final com.google.android.finsky.be.w i;
  private final View j;
  private final y k;
  
  public v(boolean paramBoolean, n paramn, q paramq, g paramg, com.google.android.finsky.be.w paramw, h paramh, y paramy, com.google.android.finsky.dialogbuilderlayout.w paramw1, View paramView, r paramr)
  {
    this.h = paramBoolean;
    this.c = paramn;
    this.e = paramq;
    this.g = paramg;
    this.i = paramw;
    this.b = paramh;
    this.k = paramy;
    this.a = paramw1;
    this.j = paramView;
    this.f = paramr;
  }
  
  public final void a()
  {
    ArrayList localArrayList = this.d;
    int n = localArrayList.size();
    int m = 0;
    while (m < n)
    {
      ((p)localArrayList.get(m)).ad_();
      m += 1;
    }
  }
  
  public final void a(b paramb, dy paramdy, ci paramci, boolean paramBoolean)
  {
    Object localObject3 = (fd)paramdy.b(fd.d);
    a();
    this.d.clear();
    this.k.a(paramBoolean);
    this.f.a();
    this.i.a();
    if ((this.h) && (this.j.getVisibility() == 4))
    {
      if ((this.a.j() != null) && (this.a.j().getWindow() != null))
      {
        localObject1 = this.a.j().getWindow();
        localObject2 = ((Window)localObject1).getAttributes();
        ((WindowManager.LayoutParams)localObject2).flags |= 0x2;
        ((WindowManager.LayoutParams)localObject2).flags |= 0x400;
        ((Window)localObject1).setAttributes((WindowManager.LayoutParams)localObject2);
      }
      localObject1 = this.a;
      if ((localObject1 instanceof i)) {
        ((i)localObject1).ai = false;
      }
      this.j.setVisibility(0);
    }
    this.a.V();
    Object localObject1 = new ArrayList();
    Object localObject2 = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    ViewGroup localViewGroup = this.a.R();
    ch[] arrayOfch = ((fd)localObject3).c;
    int n = arrayOfch.length;
    int m = 0;
    aq localaq;
    if (m >= n)
    {
      localViewGroup = this.a.ab();
      arrayOfch = ((fd)localObject3).a;
      n = arrayOfch.length;
      m = 0;
      if (m >= n)
      {
        localViewGroup = this.a.ad();
        localObject3 = ((fd)localObject3).b;
        n = localObject3.length;
        m = 0;
        while (m < n)
        {
          arrayOfch = localObject3[m];
          localObject4 = this.c.a(arrayOfch);
          if (localObject4 != null)
          {
            this.e.a(arrayOfch.c, null);
            localObject4 = ((m)localObject4).a(paramb, localViewGroup);
            this.b.a(arrayOfch.g, (View)localObject4, paramb);
            localArrayList.add(localObject4);
          }
          m += 1;
        }
        this.a.a((List)localObject1, (List)localObject2, localArrayList, paramci, paramdy.h);
        this.k.a();
        b();
        return;
      }
      localObject4 = arrayOfch[m];
      localObject5 = this.c.a((ch)localObject4);
      if (localObject5 == null) {}
      for (;;)
      {
        m += 1;
        break;
        if ((localObject5 instanceof p)) {
          this.d.add((p)localObject5);
        }
        localaq = this.e.a(((ch)localObject4).q, ((ch)localObject4).y);
        localObject5 = ((m)localObject5).a(paramb, localViewGroup);
        this.b.a(((ch)localObject4).y, (View)localObject5, paramb, this.g);
        this.k.a((View)localObject5, ((ch)localObject4).y, localaq);
        ((List)localObject2).add(localObject5);
      }
    }
    Object localObject4 = arrayOfch[m];
    Object localObject5 = this.c.a((ch)localObject4);
    if (localObject5 == null) {}
    for (;;)
    {
      m += 1;
      break;
      if ((localObject5 instanceof p)) {
        this.d.add((p)localObject5);
      }
      localaq = this.e.a(((ch)localObject4).q, ((ch)localObject4).y);
      localObject5 = ((m)localObject5).a(paramb, localViewGroup);
      this.b.a(((ch)localObject4).y, (View)localObject5, paramb);
      this.k.a((View)localObject5, ((ch)localObject4).y, localaq);
      ((List)localObject1).add(localObject5);
    }
  }
  
  public final void b()
  {
    ArrayList localArrayList = this.d;
    int n = localArrayList.size();
    int m = 0;
    while (m < n)
    {
      ((p)localArrayList.get(m)).c();
      m += 1;
    }
  }
  
  public final void c()
  {
    this.a.U();
    this.e.h();
  }
  
  public final boolean d()
  {
    return this.a.bx_();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bc/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */