package com.google.android.finsky.ci;

import com.google.common.base.aa;
import com.google.common.base.ab;
import com.google.common.base.ad;
import com.google.common.base.af;
import com.google.common.base.f;
import com.google.common.base.x;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class h
{
  public static String a(String paramString)
  {
    if (!b(paramString))
    {
      if (".config.".length() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        x.a(bool, "The separator may not be the empty string.");
        if (".config.".length() != 1) {}
        for (Object localObject = new aa(new ad(".config."));; localObject = new aa(new ab((f)localObject)))
        {
          x.a(paramString);
          paramString = new af((aa)localObject, paramString);
          x.a(paramString);
          if ((paramString instanceof List)) {}
          for (paramString = ((List)paramString).get(0);; paramString = paramString.next())
          {
            return (String)paramString;
            paramString = paramString.iterator();
            x.a(paramString);
            x.a(true, "numberToAdvance must be nonnegative");
            if (!paramString.hasNext())
            {
              paramString = new StringBuilder(91);
              paramString.append("position (");
              paramString.append(0);
              paramString.append(") must be less than the number of elements that remained (");
              paramString.append(0);
              paramString.append(")");
              throw new IndexOutOfBoundsException(paramString.toString());
            }
          }
          localObject = new com.google.common.base.h(".config.".charAt(0));
          x.a(localObject);
        }
      }
    }
    return "";
  }
  
  public static Set a(Iterable paramIterable)
  {
    HashSet localHashSet = new HashSet();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      localHashSet.add(a((String)paramIterable.next()));
    }
    return localHashSet;
  }
  
  public static boolean b(String paramString)
  {
    return (paramString.startsWith("config.")) || (paramString.isEmpty());
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ci/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */