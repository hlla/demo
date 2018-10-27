package android.support.v7.preference;

import android.os.Handler;
import android.support.v7.widget.eu;
import android.support.v7.widget.ev;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class ae
  extends eu
  implements ac, p
{
  private Handler c;
  private PreferenceGroup d;
  private b e;
  private List f;
  private List g;
  private List h;
  private Runnable i = new af(this);
  private ag j = new ag();
  
  public ae(PreferenceGroup paramPreferenceGroup)
  {
    this(paramPreferenceGroup, new Handler());
  }
  
  private ae(PreferenceGroup paramPreferenceGroup, Handler paramHandler)
  {
    this.d = paramPreferenceGroup;
    this.c = paramHandler;
    this.e = new b(paramPreferenceGroup, this);
    this.d.t = this;
    this.g = new ArrayList();
    this.h = new ArrayList();
    this.f = new ArrayList();
    paramPreferenceGroup = this.d;
    if ((paramPreferenceGroup instanceof PreferenceScreen)) {
      b_(((PreferenceScreen)paramPreferenceGroup).d);
    }
    for (;;)
    {
      b();
      return;
      b_(true);
    }
  }
  
  private static ag a(Preference paramPreference, ag paramag)
  {
    ag localag = paramag;
    if (paramag == null) {
      localag = new ag();
    }
    localag.a = paramPreference.getClass().getName();
    localag.b = paramPreference.s;
    localag.c = paramPreference.B;
    return localag;
  }
  
  private final void a(List paramList, PreferenceGroup paramPreferenceGroup)
  {
    try
    {
      Collections.sort(paramPreferenceGroup.c);
      int m = paramPreferenceGroup.g();
      int k = 0;
      while (k < m)
      {
        Preference localPreference = paramPreferenceGroup.d(k);
        paramList.add(localPreference);
        Object localObject = a(localPreference, null);
        if (!this.f.contains(localObject)) {
          this.f.add(localObject);
        }
        if ((localPreference instanceof PreferenceGroup))
        {
          localObject = (PreferenceGroup)localPreference;
          if (((PreferenceGroup)localObject).q()) {
            a(paramList, (PreferenceGroup)localObject);
          }
        }
        localPreference.t = this;
        k += 1;
      }
      return;
    }
    finally {}
  }
  
  public final int a(String paramString)
  {
    int m = this.g.size();
    int k = 0;
    while (k < m) {
      if (!TextUtils.equals(paramString, ((Preference)this.g.get(k)).r)) {
        k += 1;
      } else {
        return k;
      }
    }
    return -1;
  }
  
  public final Preference a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < c())) {
      return (Preference)this.g.get(paramInt);
    }
    return null;
  }
  
  public final void a()
  {
    this.c.removeCallbacks(this.i);
    this.c.post(this.i);
  }
  
  public final void a(Preference paramPreference)
  {
    int k = this.g.indexOf(paramPreference);
    if (k != -1) {
      this.b.a(k, 1, paramPreference);
    }
  }
  
  public final int b(Preference paramPreference)
  {
    int m = this.g.size();
    int k = 0;
    if (k < m)
    {
      Preference localPreference = (Preference)this.g.get(k);
      if (localPreference == null) {}
      while (!localPreference.equals(paramPreference))
      {
        k += 1;
        break;
      }
      return k;
    }
    return -1;
  }
  
  public final long b(int paramInt)
  {
    if (this.a) {
      return a(paramInt).a_();
    }
    return -1L;
  }
  
  final void b()
  {
    Object localObject = this.h.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((Preference)((Iterator)localObject).next()).t = null;
    }
    localObject = new ArrayList(this.h.size());
    a((List)localObject, this.d);
    this.g = this.e.a(this.d);
    this.h = ((List)localObject);
    this.b.b();
    int m = ((List)localObject).size();
    int k = 0;
    while (k < m)
    {
      ((List)localObject).get(k);
      k += 1;
    }
  }
  
  public final int c()
  {
    return this.g.size();
  }
  
  public final int c(int paramInt)
  {
    this.j = a(a(paramInt), this.j);
    int k = this.f.indexOf(this.j);
    paramInt = k;
    if (k == -1)
    {
      paramInt = this.f.size();
      this.f.add(new ag(this.j));
    }
    return paramInt;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/preference/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */