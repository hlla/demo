package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.view.View;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a;
import com.google.android.gms.signin.e;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class h
{
  public final Account akV;
  public final Set<Scope> amq;
  private final int amr;
  private final View ams;
  public final String amt;
  final String amu;
  final Set<Scope> aqm;
  public final Map<a<?>, a> aqn;
  public final e aqo;
  public Integer aqp;
  
  public h(Account paramAccount, Set<Scope> paramSet, Map<a<?>, a> paramMap, int paramInt, View paramView, String paramString1, String paramString2, e parame)
  {
    this.akV = paramAccount;
    if (paramSet == null) {}
    for (paramAccount = Collections.EMPTY_SET;; paramAccount = Collections.unmodifiableSet(paramSet))
    {
      this.amq = paramAccount;
      paramAccount = paramMap;
      if (paramMap == null) {
        paramAccount = Collections.EMPTY_MAP;
      }
      this.aqn = paramAccount;
      this.ams = paramView;
      this.amr = paramInt;
      this.amt = paramString1;
      this.amu = paramString2;
      this.aqo = parame;
      paramAccount = new HashSet(this.amq);
      paramSet = this.aqn.values().iterator();
      while (paramSet.hasNext()) {
        paramAccount.addAll(((a)paramSet.next()).amK);
      }
    }
    this.aqm = Collections.unmodifiableSet(paramAccount);
  }
  
  public static final class a
  {
    public final Set<Scope> amK;
    public final boolean aqq;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/google/android/gms/common/internal/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */