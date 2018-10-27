package com.google.android.finsky.bb.a;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.support.v7.app.w;
import android.text.TextUtils;
import android.view.View;
import com.google.android.finsky.bb.b;
import com.google.android.finsky.bb.c;

public final class a
  implements com.google.android.finsky.bb.a
{
  public final Dialog a(Context paramContext, int paramInt)
  {
    paramContext = new com.google.android.wallet.ui.common.a(paramContext);
    paramContext.b(paramInt);
    paramContext.a(2131952812, null);
    return paramContext.a();
  }
  
  public final Dialog a(Context paramContext, b paramb)
  {
    int i = paramb.j;
    if (i != -1) {}
    for (paramContext = new com.google.android.wallet.ui.common.a(paramContext, i);; paramContext = new com.google.android.wallet.ui.common.a(paramContext))
    {
      Object localObject = paramb.a;
      if (localObject != null) {
        paramContext.a((View)localObject);
      }
      for (;;)
      {
        i = paramb.d;
        if (i == -1) {}
        for (;;)
        {
          if (!TextUtils.isEmpty(paramb.e)) {
            paramContext.b(paramb.e);
          }
          if (!TextUtils.isEmpty(paramb.i)) {
            paramContext.a(paramb.i, paramb.h);
          }
          if (!TextUtils.isEmpty(paramb.g)) {
            paramContext.b(paramb.g, paramb.f);
          }
          boolean bool = paramb.c;
          localObject = paramContext.a;
          if (localObject != null) {
            ((AlertDialog.Builder)localObject).setInverseBackgroundForced(bool);
          }
          while (paramContext.b != null)
          {
            paramb = paramb.b;
            if (paramb != null) {
              paramContext.b(paramb);
            }
            return paramContext.a();
          }
          throw null;
          localObject = paramContext.a;
          if (localObject != null) {
            ((AlertDialog.Builder)localObject).setIcon(i);
          } else {
            paramContext.b.a.h = i;
          }
        }
        if (!TextUtils.isEmpty(paramb.k)) {
          paramContext.a(paramb.k);
        }
      }
    }
  }
  
  public final Dialog a(Context paramContext, c paramc)
  {
    paramContext = new com.google.android.wallet.ui.common.a(paramContext);
    paramContext.a(paramc.d);
    paramContext.a(paramc.c, paramc.a, paramc.b);
    return paramContext.a();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bb/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */