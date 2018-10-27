package android.support.v7.preference;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class b
{
  public final ae a;
  private final Context b;
  private boolean c = false;
  
  b(PreferenceGroup paramPreferenceGroup, ae paramae)
  {
    this.a = paramae;
    this.b = paramPreferenceGroup.j;
  }
  
  final List a(PreferenceGroup paramPreferenceGroup)
  {
    int j = 0;
    this.c = false;
    if (paramPreferenceGroup.b != Integer.MAX_VALUE) {}
    for (int k = 1;; k = 0)
    {
      ArrayList localArrayList = new ArrayList();
      Object localObject1 = new ArrayList();
      int n = paramPreferenceGroup.g();
      int m = 0;
      while (m < n)
      {
        Object localObject2 = paramPreferenceGroup.d(m);
        int i;
        if (!((Preference)localObject2).A)
        {
          i = j;
          m += 1;
          j = i;
        }
        else
        {
          if (k == 0) {
            label87:
            localArrayList.add(localObject2);
          }
          for (;;)
          {
            if ((localObject2 instanceof PreferenceGroup))
            {
              localObject2 = (PreferenceGroup)localObject2;
              i = j;
              if (!((PreferenceGroup)localObject2).q()) {
                break;
              }
              localObject2 = a((PreferenceGroup)localObject2);
              if ((k != 0) && (this.c)) {
                throw new IllegalArgumentException("Nested expand buttons are not supported!");
              }
              localObject2 = ((List)localObject2).iterator();
              i = j;
              if (!((Iterator)localObject2).hasNext()) {
                break;
              }
              Preference localPreference = (Preference)((Iterator)localObject2).next();
              if (k == 0) {
                label190:
                localArrayList.add(localPreference);
              }
              for (;;)
              {
                j += 1;
                break;
                if (j < paramPreferenceGroup.b) {
                  break label190;
                }
                ((List)localObject1).add(localPreference);
              }
            }
            i = j + 1;
            break;
            if (j < paramPreferenceGroup.b) {
              break label87;
            }
            ((List)localObject1).add(localObject2);
          }
        }
      }
      if ((k != 0) && (j > paramPreferenceGroup.b))
      {
        localObject1 = new d(this.b, (List)localObject1, paramPreferenceGroup.a_());
        ((Preference)localObject1).u = new c(this, paramPreferenceGroup);
        localArrayList.add(localObject1);
      }
      this.c |= k;
      return localArrayList;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/preference/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */