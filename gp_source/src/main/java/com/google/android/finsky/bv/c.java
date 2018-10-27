package com.google.android.finsky.bv;

import android.accounts.Account;
import android.content.res.Resources;
import android.text.Html;
import android.text.TextUtils;
import com.google.android.finsky.dfemodel.DfeToc;
import com.google.android.finsky.dfemodel.Document;
import com.google.android.finsky.ds.a.de;
import com.google.android.finsky.ds.a.fb;
import com.google.android.finsky.ds.a.o;
import com.google.android.finsky.e.af;
import com.google.android.finsky.e.aq;
import com.google.android.finsky.frameworkviews.s;
import com.google.android.finsky.library.r;

public final class c
{
  private final com.google.android.finsky.bo.c a;
  private com.google.android.finsky.library.c b;
  private final r c;
  
  public c(r paramr, com.google.android.finsky.library.c paramc, com.google.android.finsky.bo.c paramc1)
  {
    this.c = paramr;
    this.b = paramc;
    this.a = paramc1;
  }
  
  private static void a(int paramInt, aq paramaq, af paramaf)
  {
    paramaf.a(new com.google.android.finsky.e.f(paramaq).a(paramInt));
  }
  
  public static void a(Document paramDocument, com.google.android.finsky.navigationmanager.c paramc, aq paramaq, af paramaf, DfeToc paramDfeToc)
  {
    de localde = paramDocument.a;
    int i = localde.g;
    int j = localde.r;
    paramc.a(paramDocument.ce().b, "", i, paramDfeToc, paramaq, 0, paramaf);
    if (j == 64) {
      a(144, paramaq, paramaf);
    }
    if (j == 5) {
      a(143, paramaq, paramaf);
    }
  }
  
  public final s a(Document paramDocument, Resources paramResources, boolean paramBoolean, Account paramAccount, DfeToc paramDfeToc)
  {
    Object localObject4 = null;
    boolean bool = paramDocument.am();
    Object localObject3 = paramDocument.U();
    Object localObject2 = "";
    Object localObject1;
    if (localObject3 == null)
    {
      localObject3 = "";
      paramBoolean = false;
      if (!paramBoolean) {
        localObject1 = null;
      }
      for (;;)
      {
        paramAccount = this.b.a(paramAccount);
        if (!this.c.a(paramDocument, paramDfeToc, paramAccount)) {
          paramAccount = (Account)localObject4;
        }
        for (;;)
        {
          paramResources = new s();
          paramResources.a = new String[2];
          paramResources.c = new String[3];
          paramResources.b = 0;
          paramResources.d = 0;
          int i;
          if (!TextUtils.isEmpty((CharSequence)localObject3))
          {
            paramDfeToc = paramResources.a;
            i = paramResources.b;
            paramResources.b = (i + 1);
            paramDfeToc[i] = localObject3;
          }
          if (!TextUtils.isEmpty(paramAccount))
          {
            paramDfeToc = paramResources.c;
            i = paramResources.d;
            paramResources.d = (i + 1);
            paramDfeToc[i] = paramAccount;
          }
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            paramAccount = paramResources.c;
            i = paramResources.d;
            paramResources.d = (i + 1);
            paramAccount[i] = localObject2;
          }
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            paramAccount = paramResources.c;
            i = paramResources.d;
            paramResources.d = (i + 1);
            paramAccount[i] = localObject1;
          }
          paramResources.e = paramDocument.a.r;
          if ((this.a.cY().a(12633045L)) && (!this.a.cY().a(12644393L)))
          {
            i = paramDocument.a.r;
            if (i != 64) {
              break label340;
            }
          }
          for (;;)
          {
            if ((paramDocument.cc()) && (!TextUtils.isEmpty(paramDocument.cd()))) {
              paramResources.f = Html.fromHtml(paramDocument.cd());
            }
            label340:
            do
            {
              return paramResources;
            } while (i != 5);
          }
          paramAccount = (Account)localObject4;
          if (bool) {
            paramAccount = paramResources.getString(2131953053);
          }
        }
        if (!bool) {
          localObject1 = paramResources.getString(2131952398);
        } else {
          localObject1 = null;
        }
      }
    }
    if (paramBoolean) {}
    for (localObject2 = ((o)localObject3).s;; localObject2 = null)
    {
      if (!((o)localObject3).e()) {
        localObject1 = null;
      }
      for (;;)
      {
        paramBoolean = ((o)localObject3).e;
        localObject3 = localObject2;
        localObject2 = localObject1;
        break;
        if (!bool) {
          localObject1 = ((o)localObject3).p;
        } else {
          localObject1 = null;
        }
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bv/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */