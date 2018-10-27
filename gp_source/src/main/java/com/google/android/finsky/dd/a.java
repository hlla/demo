package com.google.android.finsky.dd;

import android.content.Context;
import com.google.android.finsky.bo.c;
import com.google.android.finsky.bo.f;
import com.google.android.finsky.dfemodel.Document;
import com.google.android.finsky.ds.a.de;
import com.google.android.finsky.utils.FinskyLog;

public final class a
{
  private final Context a;
  private final c b;
  
  public a(c paramc, Context paramContext)
  {
    this.b = paramc;
    this.a = paramContext;
  }
  
  private final String b(Document paramDocument)
  {
    if (paramDocument.a.r == 1) {
      return this.a.getString(2131951790);
    }
    return this.a.getString(2131951789);
  }
  
  public final String a(Document paramDocument)
  {
    int i = paramDocument.an();
    FinskyLog.a("Item is not available. Reason: %s", new Object[] { Integer.valueOf(i) });
    switch (i)
    {
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 13: 
    case 14: 
    case 15: 
    case 16: 
    case 17: 
    case 18: 
    case 19: 
    case 20: 
    case 23: 
    default: 
      i = 2131951788;
    }
    for (;;)
    {
      return this.a.getString(i);
      if (this.b.cY().a(12626607L)) {
        return this.a.getString(2131951791);
      }
      return b(paramDocument);
      i = 2131951785;
      continue;
      i = 2131951792;
      continue;
      i = 2131951787;
      continue;
      i = 2131951794;
      continue;
      i = 2131951786;
      continue;
      i = 2131951784;
      continue;
      return b(paramDocument);
      i = 2131951793;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/dd/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */