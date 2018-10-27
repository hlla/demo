package com.google.android.finsky.cc;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.j;
import android.text.TextUtils;
import com.google.android.finsky.bb.i;
import com.google.android.finsky.bb.o;

public final class a
  extends i
{
  public static void a(com.google.android.finsky.navigationmanager.c paramc, c paramc1)
  {
    Object localObject1 = new b();
    Object localObject2 = new StringBuilder();
    if (!TextUtils.isEmpty(paramc1.a)) {
      ((StringBuilder)localObject2).append(paramc1.a);
    }
    if (!TextUtils.isEmpty(paramc1.e))
    {
      if (((StringBuilder)localObject2).length() > 0) {
        ((StringBuilder)localObject2).append("<br/><br/>");
      }
      ((StringBuilder)localObject2).append(paramc1.e);
    }
    if (((StringBuilder)localObject2).length() == 0) {
      ((StringBuilder)localObject2).append(paramc1.b);
    }
    localObject1 = (b)((b)((b)((b)((o)localObject1).b(((StringBuilder)localObject2).toString())).c(paramc1.g)).d(2131952363)).b(false);
    if (!TextUtils.isEmpty(paramc1.f)) {
      ((o)localObject1).e(2131952551);
    }
    if (!TextUtils.isEmpty(paramc1.d))
    {
      localObject2 = paramc1.d;
      boolean bool = paramc1.c;
      ((o)localObject1).a.putString("title_icon_url", (String)localObject2);
      ((o)localObject1).a.putBoolean("title_icon_support_fife", bool);
    }
    a locala = (a)((o)localObject1).a();
    if (!TextUtils.isEmpty(paramc1.f))
    {
      localObject2 = locala.g;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new Bundle();
        locala.f((Bundle)localObject1);
      }
      ((Bundle)localObject1).putString("more_link_url", paramc1.f);
    }
    if (paramc.d()) {
      locala.a(paramc.l(), "IARC");
    }
  }
  
  protected final void R()
  {
    super.R();
    Object localObject = this.g;
    String str;
    if (localObject != null)
    {
      str = ((Bundle)localObject).getString("more_link_url");
      if (!(j() instanceof com.google.android.finsky.dj.a)) {
        break label62;
      }
    }
    label62:
    for (localObject = ((com.google.android.finsky.dj.a)j()).m();; localObject = null)
    {
      if ((!TextUtils.isEmpty(str)) && (localObject != null)) {
        ((com.google.android.finsky.navigationmanager.c)localObject).a(str);
      }
      return;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/cc/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */