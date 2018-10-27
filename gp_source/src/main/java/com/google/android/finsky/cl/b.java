package com.google.android.finsky.cl;

import android.accounts.Account;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.finsky.billing.common.PurchaseFlowConfig;
import com.google.android.finsky.billing.common.PurchaseParams;
import com.google.android.finsky.bo.f;
import com.google.android.finsky.dfemodel.DfeToc;
import com.google.android.finsky.dfemodel.Document;
import com.google.android.finsky.dfemodel.t;
import com.google.android.finsky.ds.a.aw;
import com.google.android.finsky.ds.a.bb;
import com.google.android.finsky.ds.a.bp;
import com.google.android.finsky.ds.a.ig;
import com.google.android.finsky.ds.a.iz;
import com.google.android.finsky.ds.a.kr;
import com.google.android.finsky.e.af;
import com.google.android.finsky.notification.m;
import com.google.wireless.android.finsky.a.b.e;
import com.google.wireless.android.finsky.dfe.e.a.fm;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public abstract interface b
{
  public abstract PendingIntent a(m paramm, Context paramContext, int paramInt, af paramaf);
  
  public abstract Intent a(int paramInt, e parame, Bundle paramBundle, af paramaf);
  
  public abstract Intent a(Account paramAccount, Context paramContext, PurchaseParams
          paramPurchaseParams, f paramf);
  
  public abstract Intent a(Account paramAccount, Context paramContext, PurchaseParams
          paramPurchaseParams, t paramt, String paramString, f paramf);
  
  public abstract Intent a(Account paramAccount, Context paramContext, f paramf, af paramaf,
                           Document paramDocument, PurchaseParams paramPurchaseParams, fm
                                   paramfm, boolean paramBoolean, int paramInt);
  
  public abstract Intent a(Account paramAccount, Context paramContext, f paramf, af paramaf,
                           boolean paramBoolean);
  
  public abstract Intent a(Account paramAccount, Context paramContext, Document paramDocument, aw
          paramaw, af paramaf);
  
  public abstract Intent a(Account paramAccount, Context paramContext, Document paramDocument, iz paramiz, af paramaf);
  
  public abstract Intent a(Account paramAccount, PurchaseParams paramPurchaseParams);
  
  public abstract Intent a(Account paramAccount, PurchaseParams paramPurchaseParams, af paramaf);
  
  public abstract Intent a(Account paramAccount, Document paramDocument, String paramString, int
          paramInt1, int paramInt2, af paramaf);
  
  public abstract Intent a(Account paramAccount, Document paramDocument, String paramString1, int paramInt1, t paramt, String paramString2, String paramString3, boolean paramBoolean, int paramInt2, int paramInt3, af paramaf);
  
  public abstract Intent a(Account paramAccount, String paramString1, String paramString2, af paramaf);
  
  public abstract Intent a(Activity paramActivity, Account paramAccount);
  
  public abstract Intent a(Context paramContext);
  
  public abstract Intent a(Context paramContext, int paramInt, DfeToc paramDfeToc);
  
  public abstract Intent a(Context paramContext, int paramInt, af paramaf);
  
  public abstract Intent a(Context paramContext, Document paramDocument, int paramInt1, int
          paramInt2, HashMap paramHashMap);
  
  public abstract Intent a(Context paramContext, Document paramDocument, ig paramig, String
          paramString, af paramaf);
  
  public abstract Intent a(Context paramContext, Document paramDocument, af paramaf);
  
  public abstract Intent a(Context paramContext, Document paramDocument, String paramString,
                           boolean paramBoolean, af paramaf);
  
  public abstract Intent a(Context paramContext, bb parambb, String paramString, PurchaseFlowConfig paramPurchaseFlowConfig, af paramaf);
  
  public abstract Intent a(Context paramContext, kr paramkr, int paramInt1, int paramInt2, String
          paramString, af paramaf);
  
  public abstract Intent a(Context paramContext, af paramaf);
  
  public abstract Intent a(Context paramContext, af paramaf, String paramString, DfeToc paramDfeToc);
  
  public abstract Intent a(Context paramContext, String paramString);
  
  public abstract Intent a(Context paramContext, String paramString1, int paramInt, String
          paramString2, af paramaf);
  
  public abstract Intent a(Context paramContext, String paramString, DfeToc paramDfeToc);
  
  public abstract Intent a(Context paramContext, String paramString, bp parambp, int paramInt, af
          paramaf);
  
  public abstract Intent a(Context paramContext, String paramString, bp parambp, long paramLong,
                           byte[] paramArrayOfByte, af paramaf);
  
  public abstract Intent a(Context paramContext, String paramString, af paramaf);
  
  public abstract Intent a(Context paramContext, String paramString1, String paramString2, int
          paramInt, af paramaf);
  
  public abstract Intent a(Context paramContext, String paramString1, String paramString2,
                           Document paramDocument, boolean paramBoolean, af paramaf);
  
  public abstract Intent a(Context paramContext, String paramString1, String paramString2,
                           Document paramDocument, boolean paramBoolean1, af paramaf, boolean
                                   paramBoolean2, String paramString3);
  
  public abstract Intent a(Context paramContext, String paramString1, String paramString2, af
          paramaf);
  
  public abstract Intent a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, af paramaf);
  
  public abstract Intent a(Context paramContext, Collection paramCollection, af paramaf);
  
  public abstract Intent a(String paramString1, String paramString2, String paramString3, af
          paramaf);
  
  public abstract Intent a(ArrayList paramArrayList, af paramaf, Context paramContext);
  
  public abstract m a();
  
  public abstract m a(String paramString);
  
  public abstract m a(String paramString1, String paramString2, String paramString3, String
          paramString4);
  
  public abstract Intent b(Account paramAccount, Context paramContext, Document paramDocument, aw
          paramaw, af paramaf);
  
  public abstract Intent b(Context paramContext);
  
  public abstract Intent b(Context paramContext, af paramaf);
  
  public abstract Intent b(Context paramContext, String paramString);
  
  public abstract Intent b(Context paramContext, String paramString, af paramaf);
  
  public abstract Intent b(Context paramContext, Collection paramCollection, af paramaf);
  
  public abstract Intent c(Context paramContext);
  
  public abstract Intent c(Context paramContext, af paramaf);
  
  public abstract Intent c(Context paramContext, String paramString, af paramaf);
  
  public abstract Intent d(Context paramContext);
  
  public abstract Intent d(Context paramContext, af paramaf);
  
  public abstract Intent e(Context paramContext);
  
  public abstract Intent f(Context paramContext);
  
  public abstract Intent g(Context paramContext);
  
  public abstract Intent h(Context paramContext);
  
  public abstract Intent i(Context paramContext);
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/cl/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */