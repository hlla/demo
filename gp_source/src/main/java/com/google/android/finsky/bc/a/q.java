package com.google.android.finsky.bc.a;

import android.accounts.Account;
import android.support.v4.app.Fragment;
import android.support.v4.app.at;
import android.support.v4.app.v;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.finsky.bc.h;
import com.google.android.finsky.bd.e;
import com.google.android.finsky.be.n;
import com.google.android.finsky.billing.j.f;
import com.google.android.finsky.dfemodel.Document;
import com.google.android.finsky.dialogbuilderlayout.i;
import com.google.android.finsky.ds.a.de;
import com.google.android.finsky.e.af;
import com.google.android.finsky.e.y;
import com.google.android.finsky.uninstallmanager.v2.g;
import com.google.android.finsky.utils.FinskyLog;
import com.google.common.base.u;
import com.google.wireless.android.finsky.dfe.e.a.cp;
import com.google.wireless.android.finsky.dfe.e.a.cq;
import com.google.wireless.android.finsky.dfe.e.a.ee;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class q
  extends m
  implements e
{
  private final cp a;
  private final com.google.android.finsky.bd.a b;
  private final com.google.android.finsky.bd.d c;
  
  public q(cp paramcp, com.google.android.finsky.bd.a parama, com.google.android.finsky.bd.d paramd)
  {
    super(null);
    this.a = paramcp;
    this.b = parama;
    this.c = paramd;
  }
  
  public final int a()
  {
    throw new UnsupportedOperationException("FragmentContainerComponent has no fixed layout ID.");
  }
  
  public final View a(com.google.android.finsky.be.d paramd, ViewGroup paramViewGroup)
  {
    new y(b());
    paramd = this.c;
    if (paramd != null)
    {
      paramViewGroup = this.a.a;
      if (paramViewGroup != null) {
        break label542;
      }
    }
    for (;;)
    {
      paramd = this.c;
      paramd.b = this;
      paramViewGroup = paramd.k;
      if (paramViewGroup != null)
      {
        paramd.b.a(paramd.c.af, paramViewGroup);
        paramd.k = null;
      }
      paramd = this.b;
      cp localcp = this.a;
      paramd.d = localcp;
      com.google.android.finsky.bd.b localb = paramd.f;
      af localaf = paramd.g;
      paramViewGroup = localb.b.l().a("PhoneFragmentContainerUiHost.fragmentTag");
      paramd = paramViewGroup;
      if (paramViewGroup == null)
      {
        paramViewGroup = localb.c;
        if (!localcp.d()) {
          break label242;
        }
        paramd = paramViewGroup.e;
        if ((paramd == null) || (!paramd.a().a())) {
          throw new IllegalArgumentException("Fetch document model needs to be ready before starting apps permissions fragments.");
        }
        paramd = com.google.android.finsky.billing.g.c.a(paramViewGroup.a.name, (Document)paramViewGroup.e.a().b(), localaf);
      }
      for (;;)
      {
        paramViewGroup.a(paramd);
        localb.b.l().a().a(paramd, "PhoneFragmentContainerUiHost.fragmentTag").c();
        paramd = paramd.U;
        if (paramd.getParent() != null) {
          ((ViewGroup)paramd.getParent()).removeView(paramd);
        }
        return paramd;
        label242:
        if (localcp.f())
        {
          paramd = com.google.android.finsky.billing.f.k.a(paramViewGroup.a.name, paramViewGroup.b, paramViewGroup.c, localaf, com.google.wireless.android.finsky.dfe.e.d.a);
        }
        else if (localcp.h())
        {
          paramd = paramViewGroup.e;
          if ((paramd == null) || (!paramd.a().a())) {
            throw new IllegalArgumentException("Fetch document model needs to be ready before starting download network warning fragments.");
          }
          if (paramViewGroup.d == null) {
            throw new IllegalArgumentException("Download warning model needs to be ready before starting download network warning fragments.");
          }
          paramd = com.google.android.finsky.billing.j.b.a(paramViewGroup.a.name, localaf, ((Document)paramViewGroup.e.a().b()).a.I, paramViewGroup.d.a((Document)paramViewGroup.e.a().b()));
        }
        else
        {
          if (localcp.g())
          {
            paramd = paramViewGroup.e;
            if ((paramd == null) || (!paramd.a().a())) {
              throw new IllegalArgumentException("Fetch document model needs to be ready before starting download size warning fragments.");
            }
            paramd = paramViewGroup.d;
            if (paramd == null) {
              throw new IllegalArgumentException("Download warning model needs to be ready before starting download size warning fragments.");
            }
            if (paramd.a((Document)paramViewGroup.e.a().b()) < paramd.e.b) {}
            for (boolean bool = true;; bool = false)
            {
              paramd = f.a(localaf, bool, paramViewGroup.d.e.a());
              break;
            }
          }
          if (!localcp.e()) {
            break;
          }
          paramd = new ArrayList();
          paramd.add(paramViewGroup.c);
          paramd = g.a(paramViewGroup.a.name, paramd, localaf);
        }
      }
      label542:
      if (paramd.a == null) {
        paramd.a = new HashMap();
      }
      paramd.a.clear();
      int j = paramViewGroup.length;
      int i = 0;
      while (i < j)
      {
        localb = paramViewGroup[i];
        paramd.a.put(Integer.valueOf(localb.a), Integer.valueOf(localb.b));
        i += 1;
      }
    }
    throw new IllegalArgumentException("Unknown or unsupported FragmentType");
  }
  
  public final void a(TextView paramTextView, String paramString)
  {
    ee localee = this.a.d;
    if ((!TextUtils.isEmpty(paramString)) && (localee != null) && (paramTextView != null))
    {
      localee.a(paramString);
      this.e.a(localee, paramTextView, null, null);
    }
  }
  
  public final void a(com.google.android.finsky.be.d paramd, View paramView)
  {
    throw new UnsupportedOperationException("FragmentContainerComponent does not support view configuration.");
  }
  
  public final int b()
  {
    cp localcp = this.a;
    int i = localcp.c;
    if (!localcp.d())
    {
      if (!this.a.e())
      {
        if (!this.a.f())
        {
          if ((!this.a.g()) && (!this.a.h()))
          {
            FinskyLog.e("No valid ui element type for fragment container component type : %d", new Object[] { Integer.valueOf(i) });
            return 0;
          }
          return 6334;
        }
        return 1400;
      }
      return 5521;
    }
    return 790;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bc/a/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */