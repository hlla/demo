package com.google.android.gms.iid;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.util.Base64;
import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;

public final class a
{
  static Map<String, a> atq = new HashMap();
  public static e atr;
  private static d ats;
  public static String atw;
  KeyPair att;
  public String atu = "";
  long atv;
  Context mContext;
  
  private a(Context paramContext, String paramString)
  {
    this.mContext = paramContext.getApplicationContext();
    this.atu = paramString;
  }
  
  static int F(Context paramContext)
  {
    try
    {
      int i = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionCode;
      return i;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      new StringBuilder("Never happens: can't find own package ").append(paramContext);
    }
    return 0;
  }
  
  public static a G(Context paramContext)
  {
    return a(paramContext, null);
  }
  
  public static a a(Context paramContext, Bundle paramBundle)
  {
    if (paramBundle == null) {
      paramBundle = "";
    }
    for (;;)
    {
      try
      {
        Context localContext = paramContext.getApplicationContext();
        if (atr == null)
        {
          atr = new e(localContext);
          ats = new d(localContext);
        }
        atw = Integer.toString(F(localContext));
        a locala = (a)atq.get(paramBundle);
        paramContext = locala;
        if (locala == null)
        {
          paramContext = new a(localContext, paramBundle);
          atq.put(paramBundle, paramContext);
        }
        return paramContext;
      }
      finally {}
      paramBundle = paramBundle.getString("subtype");
      while (paramBundle != null) {
        break;
      }
      paramBundle = "";
    }
  }
  
  static String a(KeyPair paramKeyPair)
  {
    paramKeyPair = paramKeyPair.getPublic().getEncoded();
    try
    {
      paramKeyPair = MessageDigest.getInstance("SHA1").digest(paramKeyPair);
      paramKeyPair[0] = ((byte)((paramKeyPair[0] & 0xF) + 112 & 0xFF));
      paramKeyPair = Base64.encodeToString(paramKeyPair, 0, 8, 11);
      return paramKeyPair;
    }
    catch (NoSuchAlgorithmException paramKeyPair) {}
    return null;
  }
  
  static String d(byte[] paramArrayOfByte)
  {
    return Base64.encodeToString(paramArrayOfByte, 11);
  }
  
  static e kD()
  {
    return atr;
  }
  
  static d kE()
  {
    return ats;
  }
  
  public static boolean kF()
  {
    String str = atr.get("appVersion");
    if ((str == null) || (!str.equals(atw))) {}
    long l;
    do
    {
      do
      {
        return true;
        str = atr.get("lastToken");
      } while (str == null);
      l = Long.parseLong(str);
    } while (System.currentTimeMillis() / 1000L - Long.valueOf(l).longValue() > 604800L);
    return false;
  }
  
  public final String b(String paramString1, String paramString2, Bundle paramBundle)
  {
    paramBundle.putString("scope", paramString2);
    paramBundle.putString("sender", paramString1);
    if ("".equals(this.atu)) {}
    for (paramString2 = paramString1;; paramString2 = this.atu)
    {
      if (!paramBundle.containsKey("legacy.register"))
      {
        paramBundle.putString("subscription", paramString1);
        paramBundle.putString("subtype", paramString2);
        paramBundle.putString("X-subscription", paramString1);
        paramBundle.putString("X-subtype", paramString2);
      }
      d locald = ats;
      if (this.att == null) {
        this.att = atr.ad(this.atu);
      }
      if (this.att == null)
      {
        this.atv = System.currentTimeMillis();
        this.att = atr.a(this.atu, this.atv);
      }
      KeyPair localKeyPair = this.att;
      paramString2 = locald.a(paramBundle, localKeyPair);
      paramString1 = paramString2;
      if (paramString2 != null)
      {
        paramString1 = paramString2;
        if (paramString2.hasExtra("google.messenger")) {
          paramString1 = locald.a(paramBundle, localKeyPair);
        }
      }
      return d.h(paramString1);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/google/android/gms/iid/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */