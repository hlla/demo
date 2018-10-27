package android.support.v7.preference;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class d
  extends Preference
{
  private long a;
  
  d(Context paramContext, List paramList, long paramLong)
  {
    super(paramContext);
    this.s = 2131624261;
    paramContext = android.support.v4.content.d.a(this.j, 2131230957);
    if ((paramContext == null) && (this.n != null)) {}
    for (;;)
    {
      this.n = paramContext;
      this.o = 0;
      b_();
      do
      {
        this.o = 2131230957;
        b(this.j.getString(2131952240));
        a(999);
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = paramList.iterator();
        paramContext = null;
        while (localIterator.hasNext())
        {
          Preference localPreference = (Preference)localIterator.next();
          paramList = localPreference.z;
          boolean bool = localPreference instanceof PreferenceGroup;
          if ((bool) && (!TextUtils.isEmpty(paramList))) {
            localArrayList.add((PreferenceGroup)localPreference);
          }
          if (!localArrayList.contains(localPreference.w))
          {
            if (!TextUtils.isEmpty(paramList)) {
              if (paramContext != null) {
                paramContext = this.j.getString(2131953402, new Object[] { paramContext, paramList });
              } else {
                paramContext = paramList;
              }
            }
          }
          else if (bool) {
            localArrayList.add((PreferenceGroup)localPreference);
          }
        }
        a(paramContext);
        this.a = (1000000L + paramLong);
        return;
      } while ((paramContext == null) || (this.n == paramContext));
    }
  }
  
  public final void a(ao paramao)
  {
    super.a(paramao);
    paramao.a = false;
  }
  
  public final long a_()
  {
    return this.a;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/preference/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */