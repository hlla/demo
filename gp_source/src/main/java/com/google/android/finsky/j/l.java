package com.google.android.finsky.j;

import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.j;
import com.google.android.finsky.utils.FinskyLog;
import com.google.android.wallet.ui.common.a;
import java.util.ArrayList;

public final class l
  extends j
{
  public ArrayList aa;
  public n ab;
  
  public static l a(i[] paramArrayOfi, i parami)
  {
    l locall = new l();
    Bundle localBundle = new Bundle();
    localBundle.putInt("sort_type", parami.k);
    parami = new ArrayList();
    int j = paramArrayOfi.length;
    int i = 0;
    if (i < j)
    {
      i locali = paramArrayOfi[i];
      if (!locali.h) {}
      for (;;)
      {
        i += 1;
        break;
        parami.add(Integer.valueOf(locali.k));
      }
    }
    localBundle.putIntegerArrayList("sort_options", parami);
    locall.f(localBundle);
    return locall;
  }
  
  public final void a(i parami)
  {
    this.g.putInt("sort_type", parami.k);
  }
  
  public final Dialog c(Bundle paramBundle)
  {
    paramBundle = new a(j(), 2132017708);
    paramBundle.a(k().getString(2131953359));
    this.aa = this.g.getIntegerArrayList("sort_options");
    int j = this.aa.indexOf(Integer.valueOf(this.g.getInt("sort_type")));
    int i = j;
    if (j == -1)
    {
      FinskyLog.a("Tried to set sort type of ordinal %d, but it isn't currently available in the dialog", new Object[] { Integer.valueOf(this.g.getInt("sort_type")) });
      i = 0;
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = this.aa;
    int k = localArrayList2.size();
    j = 0;
    while (j < k)
    {
      Integer localInteger = (Integer)localArrayList2.get(j);
      localArrayList1.add(i.values()[localInteger.intValue()].a(by_()));
      j += 1;
    }
    paramBundle.a((CharSequence[])localArrayList1.toArray(new CharSequence[localArrayList1.size()]), i, new m(this));
    return paramBundle.a();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/j/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */