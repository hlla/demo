package com.google.android.finsky.be;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class t
{
  public final Bundle a;
  private u b;
  private final List c = new ArrayList();
  
  public t(Bundle paramBundle)
  {
    if ((paramBundle != null) && (paramBundle.containsKey("DialogPrimaryActionEnabledModel.tags")))
    {
      this.a = paramBundle.getBundle("DialogPrimaryActionEnabledModel.tags");
      return;
    }
    this.a = new Bundle();
  }
  
  private final void a()
  {
    if (this.b != null)
    {
      Iterator localIterator = this.c.iterator();
      String str;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        str = (String)localIterator.next();
      } while (this.a.getBoolean(str));
    }
    for (boolean bool = false;; bool = true)
    {
      this.b.a(bool);
      return;
    }
  }
  
  public final void a(String paramString, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.a.putBoolean(paramString, paramBoolean);
      a();
    }
  }
  
  public final void a(String[] paramArrayOfString, u paramu)
  {
    this.c.clear();
    this.b = null;
    this.b = paramu;
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0)) {
      Collections.addAll(this.c, paramArrayOfString);
    }
    a();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/be/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */