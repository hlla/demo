package com.tencent.mm.pluginsdk.model;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Looper;
import android.widget.Toast;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.l;
import com.tencent.mm.f.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.x.l;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.mm.y.n;
import junit.framework.Assert;

public final class o
  implements e
{
  private Context context;
  private ProgressDialog kng;
  private String path;
  private Runnable sAS;
  private Runnable sAT;
  
  public o(Context paramContext, String paramString)
  {
    GMTrace.i(726252126208L, 5411);
    this.sAS = null;
    this.sAT = null;
    this.context = paramContext;
    this.path = paramString;
    this.kng = null;
    ap.vd().a(157, this);
    GMTrace.o(726252126208L, 5411);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, k paramk)
  {
    GMTrace.i(726654779392L, 5414);
    v.i("MicroMsg.ProcessUploadHDHeadImg", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    ap.vd().b(157, this);
    if ((this.kng != null) && (this.kng.isShowing()) && ((this.context instanceof Activity)) && (!((Activity)this.context).isFinishing())) {}
    try
    {
      this.kng.dismiss();
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        Toast.makeText(this.context, R.l.eUD, 0).show();
        if (this.sAS != null) {
          new ad(Looper.getMainLooper()).post(this.sAS);
        }
        GMTrace.o(726654779392L, 5414);
        return;
      }
    }
    catch (IllegalArgumentException paramk)
    {
      for (;;)
      {
        v.e("MicroMsg.ProcessUploadHDHeadImg", "dismiss dialog err" + paramk.getMessage());
      }
      if (this.sAT != null) {
        new ad(Looper.getMainLooper()).post(this.sAT);
      }
      if ((paramString != null) && (paramString.length() > 0))
      {
        paramString = a.dn(paramString);
        if (paramString != null)
        {
          paramString.a(this.context, null, null);
          GMTrace.o(726654779392L, 5414);
          return;
        }
      }
      if ((paramInt1 == 4) && (paramInt2 == -4))
      {
        Toast.makeText(this.context, R.l.dYN, 0).show();
        GMTrace.o(726654779392L, 5414);
        return;
      }
      Toast.makeText(this.context, R.l.eUC, 0).show();
      GMTrace.o(726654779392L, 5414);
    }
  }
  
  public final boolean a(Runnable paramRunnable1, Runnable paramRunnable2)
  {
    GMTrace.i(726520561664L, 5413);
    if ((this.context != null) && (this.path != null) && (this.path.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.sAS = paramRunnable1;
      this.sAT = paramRunnable2;
      paramRunnable1 = new l(1, this.path);
      ap.vd().a(paramRunnable1, 0);
      v.i("MicroMsg.ProcessUploadHDHeadImg", "post is null ? %B", new Object[] { Boolean.valueOf(false) });
      GMTrace.o(726520561664L, 5413);
      return true;
    }
  }
  
  public final boolean b(int paramInt, Runnable paramRunnable)
  {
    GMTrace.i(726386343936L, 5412);
    if ((this.context != null) && (this.path != null) && (this.path.length() > 0))
    {
      bool = true;
      Assert.assertTrue(bool);
      this.sAS = paramRunnable;
      Object localObject = this.context;
      this.context.getString(R.l.dIG);
      this.kng = g.a((Context)localObject, this.context.getString(R.l.eUE), true, null);
      localObject = new l(paramInt, this.path);
      ap.vd().a((k)localObject, 0);
      if (paramRunnable != null) {
        break label146;
      }
    }
    label146:
    for (boolean bool = true;; bool = false)
    {
      v.i("MicroMsg.ProcessUploadHDHeadImg", "post is null ? %B", new Object[] { Boolean.valueOf(bool) });
      GMTrace.o(726386343936L, 5412);
      return true;
      bool = false;
      break;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/model/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */