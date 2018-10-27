package com.google.android.finsky.e;

import android.accounts.Account;
import android.content.Intent;
import android.os.Bundle;

public final class a
{
  private final i a;
  
  public a(i parami)
  {
    this.a = parami;
  }
  
  public final af a(Account paramAccount)
  {
    return af.a(paramAccount, null, this.a);
  }
  
  public final af a(Account paramAccount, String paramString)
  {
    return af.a(paramAccount, paramString, this.a);
  }
  
  public final af a(Bundle paramBundle)
  {
    i locali = this.a;
    return af.a(paramBundle, af.a(null, locali), locali);
  }
  
  public final af a(Bundle paramBundle, Intent paramIntent)
  {
    i locali = this.a;
    return af.a(paramBundle, paramIntent, af.a(null, locali), locali);
  }
  
  public final af a(Bundle paramBundle, Intent paramIntent, af paramaf)
  {
    return af.a(paramBundle, paramIntent, paramaf, this.a);
  }
  
  public final af a(Bundle paramBundle, af paramaf)
  {
    return af.a(paramBundle, paramaf, this.a);
  }
  
  public final af a(com.google.android.finsky.e.a.a parama)
  {
    i locali = this.a;
    return new af(parama.c, parama.d, parama.e, parama.a, locali);
  }
  
  public final af a(String paramString)
  {
    return af.a(paramString, this.a);
  }
  
  public final af b(String paramString)
  {
    return new af(-1L, null, false, paramString, this.a);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/e/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */