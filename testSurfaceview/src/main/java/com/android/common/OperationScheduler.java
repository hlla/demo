package com.android.common;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.http.AndroidHttpClient;
import android.text.format.Time;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class OperationScheduler
{
  private static final String PREFIX = "OperationScheduler_";
  private final SharedPreferences mStorage;
  
  public OperationScheduler(SharedPreferences paramSharedPreferences)
  {
    this.mStorage = paramSharedPreferences;
  }
  
  private long getTimeBefore(String paramString, long paramLong)
  {
    long l2 = this.mStorage.getLong(paramString, 0L);
    long l1 = l2;
    if (l2 > paramLong)
    {
      SharedPreferencesCompat.apply(this.mStorage.edit().putLong(paramString, paramLong));
      l1 = paramLong;
    }
    return l1;
  }
  
  public static Options parseOptions(String paramString, Options paramOptions)
    throws IllegalArgumentException
  {
    String[] arrayOfString = paramString.split(" +");
    int j = arrayOfString.length;
    int i = 0;
    if (i < j)
    {
      Object localObject = arrayOfString[i];
      if (((String)localObject).length() == 0) {}
      for (;;)
      {
        i += 1;
        break;
        if (((String)localObject).startsWith("backoff="))
        {
          localObject = ((String)localObject).substring(8).split("\\+");
          if (localObject.length > 3) {
            throw new IllegalArgumentException("bad value for backoff: [" + paramString + "]");
          }
          if ((localObject.length > 0) && (localObject[0].length() > 0)) {
            paramOptions.backoffFixedMillis = parseSeconds(localObject[0]);
          }
          if ((localObject.length > 1) && (localObject[1].length() > 0)) {
            paramOptions.backoffIncrementalMillis = parseSeconds(localObject[1]);
          }
          if ((localObject.length > 2) && (localObject[2].length() > 0)) {
            paramOptions.backoffExponentialMillis = ((int)parseSeconds(localObject[2]));
          }
        }
        else if (((String)localObject).startsWith("max="))
        {
          paramOptions.maxMoratoriumMillis = parseSeconds(((String)localObject).substring(4));
        }
        else if (((String)localObject).startsWith("min="))
        {
          paramOptions.minTriggerMillis = parseSeconds(((String)localObject).substring(4));
        }
        else if (((String)localObject).startsWith("period="))
        {
          paramOptions.periodicIntervalMillis = parseSeconds(((String)localObject).substring(7));
        }
        else
        {
          paramOptions.periodicIntervalMillis = parseSeconds((String)localObject);
        }
      }
    }
    return paramOptions;
  }
  
  private static long parseSeconds(String paramString)
    throws NumberFormatException
  {
    return (Float.parseFloat(paramString) * 1000.0F);
  }
  
  protected long currentTimeMillis()
  {
    return System.currentTimeMillis();
  }
  
  public long getLastAttemptTimeMillis()
  {
    return Math.max(this.mStorage.getLong("OperationScheduler_lastSuccessTimeMillis", 0L), this.mStorage.getLong("OperationScheduler_lastErrorTimeMillis", 0L));
  }
  
  public long getLastSuccessTimeMillis()
  {
    return this.mStorage.getLong("OperationScheduler_lastSuccessTimeMillis", 0L);
  }
  
  public long getNextTimeMillis(Options paramOptions)
  {
    if (!this.mStorage.getBoolean("OperationScheduler_enabledState", true)) {
      l1 = Long.MAX_VALUE;
    }
    int k;
    long l2;
    long l5;
    long l3;
    do
    {
      return l1;
      if (this.mStorage.getBoolean("OperationScheduler_permanentError", false)) {
        return Long.MAX_VALUE;
      }
      k = this.mStorage.getInt("OperationScheduler_errorCount", 0);
      l2 = currentTimeMillis();
      l4 = getTimeBefore("OperationScheduler_lastSuccessTimeMillis", l2);
      l5 = getTimeBefore("OperationScheduler_lastErrorTimeMillis", l2);
      l1 = this.mStorage.getLong("OperationScheduler_triggerTimeMillis", Long.MAX_VALUE);
      l2 = getTimeBefore("OperationScheduler_moratoriumSetTimeMillis", l2);
      l3 = getTimeBefore("OperationScheduler_moratoriumTimeMillis", paramOptions.maxMoratoriumMillis + l2);
      l2 = l1;
      if (paramOptions.periodicIntervalMillis > 0L) {
        l2 = Math.min(l1, paramOptions.periodicIntervalMillis + l4);
      }
      l2 = Math.max(Math.max(l2, l3), paramOptions.minTriggerMillis + l4);
      l1 = l2;
    } while (k <= 0);
    int j = k - 1;
    int i = j;
    if (j > 30) {
      i = 30;
    }
    long l4 = paramOptions.backoffFixedMillis + paramOptions.backoffIncrementalMillis * k + (paramOptions.backoffExponentialMillis << i);
    long l1 = l4;
    if (l3 > 0L)
    {
      l1 = l4;
      if (l4 > l3) {
        l1 = l3;
      }
    }
    return Math.max(l2, l5 + l1);
  }
  
  public void onPermanentError()
  {
    SharedPreferencesCompat.apply(this.mStorage.edit().putBoolean("OperationScheduler_permanentError", true));
  }
  
  public void onSuccess()
  {
    resetTransientError();
    resetPermanentError();
    SharedPreferencesCompat.apply(this.mStorage.edit().remove("OperationScheduler_errorCount").remove("OperationScheduler_lastErrorTimeMillis").remove("OperationScheduler_permanentError").remove("OperationScheduler_triggerTimeMillis").putLong("OperationScheduler_lastSuccessTimeMillis", currentTimeMillis()));
  }
  
  public void onTransientError()
  {
    SharedPreferences.Editor localEditor = this.mStorage.edit();
    localEditor.putLong("OperationScheduler_lastErrorTimeMillis", currentTimeMillis());
    localEditor.putInt("OperationScheduler_errorCount", this.mStorage.getInt("OperationScheduler_errorCount", 0) + 1);
    SharedPreferencesCompat.apply(localEditor);
  }
  
  public void resetPermanentError()
  {
    SharedPreferencesCompat.apply(this.mStorage.edit().remove("OperationScheduler_permanentError"));
  }
  
  public void resetTransientError()
  {
    SharedPreferencesCompat.apply(this.mStorage.edit().remove("OperationScheduler_errorCount"));
  }
  
  public void setEnabledState(boolean paramBoolean)
  {
    SharedPreferencesCompat.apply(this.mStorage.edit().putBoolean("OperationScheduler_enabledState", paramBoolean));
  }
  
  public boolean setMoratoriumTimeHttp(String paramString)
  {
    try
    {
      long l = Long.valueOf(paramString).longValue();
      setMoratoriumTimeMillis(currentTimeMillis() + l * 1000L);
      return true;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      try
      {
        setMoratoriumTimeMillis(AndroidHttpClient.parseDate(paramString));
        return true;
      }
      catch (IllegalArgumentException paramString) {}
    }
    return false;
  }
  
  public void setMoratoriumTimeMillis(long paramLong)
  {
    SharedPreferencesCompat.apply(this.mStorage.edit().putLong("OperationScheduler_moratoriumTimeMillis", paramLong).putLong("OperationScheduler_moratoriumSetTimeMillis", currentTimeMillis()));
  }
  
  public void setTriggerTimeMillis(long paramLong)
  {
    SharedPreferencesCompat.apply(this.mStorage.edit().putLong("OperationScheduler_triggerTimeMillis", paramLong));
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("[OperationScheduler:");
    Iterator localIterator = new TreeMap(this.mStorage.getAll()).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      String str = (String)((Map.Entry)localObject).getKey();
      if (str.startsWith("OperationScheduler_")) {
        if (str.endsWith("TimeMillis"))
        {
          Time localTime = new Time();
          localTime.set(((Long)((Map.Entry)localObject).getValue()).longValue());
          localStringBuilder.append(" ").append(str.substring("OperationScheduler_".length(), str.length() - 10));
          localStringBuilder.append("=").append(localTime.format("%Y-%m-%d/%H:%M:%S"));
        }
        else
        {
          localStringBuilder.append(" ").append(str.substring("OperationScheduler_".length()));
          localObject = ((Map.Entry)localObject).getValue();
          if (localObject == null) {
            localStringBuilder.append("=(null)");
          } else {
            localStringBuilder.append("=").append(localObject.toString());
          }
        }
      }
    }
    return "]";
  }
  
  public static class Options
  {
    public int backoffExponentialMillis = 0;
    public long backoffFixedMillis = 0L;
    public long backoffIncrementalMillis = 5000L;
    public long maxMoratoriumMillis = 86400000L;
    public long minTriggerMillis = 0L;
    public long periodicIntervalMillis = 0L;
    
    public String toString()
    {
      if (this.backoffExponentialMillis > 0) {
        return String.format("OperationScheduler.Options[backoff=%.1f+%.1f+%.1f max=%.1f min=%.1f period=%.1f]", new Object[] { Double.valueOf(this.backoffFixedMillis / 1000.0D), Double.valueOf(this.backoffIncrementalMillis / 1000.0D), Double.valueOf(this.backoffExponentialMillis / 1000.0D), Double.valueOf(this.maxMoratoriumMillis / 1000.0D), Double.valueOf(this.minTriggerMillis / 1000.0D), Double.valueOf(this.periodicIntervalMillis / 1000.0D) });
      }
      return String.format("OperationScheduler.Options[backoff=%.1f+%.1f max=%.1f min=%.1f period=%.1f]", new Object[] { Double.valueOf(this.backoffFixedMillis / 1000.0D), Double.valueOf(this.backoffIncrementalMillis / 1000.0D), Double.valueOf(this.maxMoratoriumMillis / 1000.0D), Double.valueOf(this.minTriggerMillis / 1000.0D), Double.valueOf(this.periodicIntervalMillis / 1000.0D) });
    }
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/common/OperationScheduler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */