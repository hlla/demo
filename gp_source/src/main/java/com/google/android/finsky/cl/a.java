package com.google.android.finsky.cl;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.v;
import com.google.android.finsky.billing.common.PurchaseParams;
import com.google.android.finsky.dfemodel.Document;
import com.google.android.finsky.e.af;
import com.google.android.finsky.e.aq;

public abstract interface a
{
  public abstract Intent a(int paramInt, String paramString);
  
  public abstract Intent a(int paramInt, String paramString1, String paramString2);
  
  public abstract Intent a(Uri paramUri);
  
  public abstract Intent a(Uri paramUri, String paramString);
  
  public abstract Intent a(Document paramDocument, String paramString);
  
  public abstract Intent a(Class paramClass, String paramString1, String paramString2);
  
  public abstract String a(int paramInt);
  
  public abstract void a(Context paramContext, aq paramaq, af paramaf, String paramString1,
                         boolean paramBoolean, String paramString2);
  
  public abstract void a(Context paramContext, String paramString1, boolean paramBoolean, String paramString2);
  
  public abstract void a(String paramString, int paramInt1, int paramInt2, v paramv, Fragment paramFragment);
  
  public abstract boolean a();
  
  public abstract boolean a(int paramInt, Intent paramIntent);
  
  public abstract boolean a(Activity paramActivity, Intent paramIntent);
  
  public abstract boolean a(Context paramContext, Account paramAccount, Document paramDocument, v
          paramv, Fragment paramFragment, int paramInt, PurchaseParams paramPurchaseParams);
  
  public abstract boolean a(Intent paramIntent);
  
  public abstract boolean a(Document paramDocument, Account paramAccount);
  
  public abstract boolean a(String paramString1, String paramString2);
  
  public abstract Intent b(int paramInt, String paramString);
  
  public abstract Intent b(int paramInt, String paramString1, String paramString2);
  
  public abstract Intent b(Intent paramIntent);
  
  public abstract Intent b(Uri paramUri);
  
  public abstract Intent b(Uri paramUri, String paramString);
  
  public abstract Intent b(Document paramDocument, String paramString);
  
  public abstract Intent b(Class paramClass, String paramString1, String paramString2);
  
  public abstract Intent b(String paramString1, String paramString2);
  
  public abstract String b();
  
  public abstract boolean b(int paramInt);
  
  public abstract boolean b(int paramInt, Intent paramIntent);
  
  public abstract Intent c(Uri paramUri, String paramString);
  
  public abstract boolean c(int paramInt);
  
  public abstract boolean c(String paramString1, String paramString2);
  
  public abstract Intent d(String paramString1, String paramString2);
  
  public abstract String d(int paramInt);
  
  public abstract int e(int paramInt);
  
  public abstract int f(int paramInt);
  
  public abstract int g(int paramInt);
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/cl/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */