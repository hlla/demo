package com.google.android.finsky.aw;

import android.accounts.Account;
import android.text.TextUtils;
import com.google.android.finsky.bo.f;
import com.google.android.finsky.dfemodel.Document;
import com.google.android.finsky.ds.a.de;
import com.google.android.finsky.f.b;
import com.google.android.finsky.utils.FinskyLog;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class a
{
  private final com.google.android.finsky.accounts.a a;
  private final com.google.android.finsky.accounts.c b;
  private final b c;
  private final Map d = new HashMap();
  private final com.google.android.finsky.bo.c e;
  
  public a(com.google.android.finsky.accounts.c paramc, com.google.android.finsky.accounts.a parama, com.google.android.finsky.bo.c paramc1, b paramb)
  {
    this.b = paramc;
    this.a = parama;
    this.e = paramc1;
    this.c = paramb;
  }
  
  public final String a(Document paramDocument, String paramString)
  {
    if (paramDocument.a.r == 1)
    {
      String str2 = paramDocument.cC();
      if (str2 == null) {
        FinskyLog.e("DetailsAccountHelper: PackageName can not be null", new Object[0]);
      }
      String str1 = this.b.cS();
      boolean bool = TextUtils.isEmpty(paramString) ^ true;
      if (!bool)
      {
        paramDocument = this.c.a(str2).a(str1);
        paramString = (Set)this.d.get(str2);
        if (this.e.cY().a(12622972L)) {
          if (!str1.equals(paramDocument)) {}
        }
      }
      for (;;)
      {
        if (bool) {}
        for (;;)
        {
          FinskyLog.a("Selecting account %s for package %s. overriding=[%s]", new Object[] { FinskyLog.a(paramDocument), str2, Boolean.valueOf(bool) });
          do
          {
            return paramDocument;
          } while (str1.equals(paramDocument));
        }
        if (paramString != null)
        {
          if (paramString.contains(paramDocument)) {
            paramDocument = str1;
          }
        }
        else
        {
          continue;
          continue;
          paramDocument = paramString;
        }
      }
    }
    return this.b.cS();
  }
  
  public final Account b(Document paramDocument, String paramString)
  {
    return this.a.b(a(paramDocument, paramString));
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/aw/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */