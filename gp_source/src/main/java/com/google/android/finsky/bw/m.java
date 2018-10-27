package com.google.android.finsky.bw;

import android.content.res.Resources;

public final class m
{
  public static String a(long paramLong, Resources paramResources)
  {
    long l = 0L;
    if (paramLong >= 0L)
    {
      int i = 0;
      while (paramLong >= 990L)
      {
        l = 0x3FF & paramLong;
        paramLong >>= 10;
        i += 1;
      }
      switch (i)
      {
      default: 
        paramResources = "";
      }
      for (;;)
      {
        if (paramLong < 10L)
        {
          d = paramLong;
          paramLong = Math.round((l / 1024.0D + d) * 10.0D);
          localStringBuilder = new StringBuilder(String.valueOf(paramResources).length() + 25);
          localStringBuilder.append(paramLong / 10.0D);
          localStringBuilder.append(" ");
          localStringBuilder.append(paramResources);
          return localStringBuilder.toString();
        }
        double d = paramLong;
        paramLong = Math.round(l / 1024.0D + d);
        StringBuilder localStringBuilder = new StringBuilder(String.valueOf(paramResources).length() + 12);
        localStringBuilder.append((int)paramLong);
        localStringBuilder.append(" ");
        localStringBuilder.append(paramResources);
        return localStringBuilder.toString();
        if (paramResources != null)
        {
          paramResources = paramResources.getString(2131952238);
        }
        else
        {
          paramResources = "EB";
          continue;
          if (paramResources != null)
          {
            paramResources = paramResources.getString(2131952959);
          }
          else
          {
            paramResources = "PB";
            continue;
            if (paramResources != null)
            {
              paramResources = paramResources.getString(2131953413);
            }
            else
            {
              paramResources = "TB";
              continue;
              if (paramResources != null)
              {
                paramResources = paramResources.getString(2131952356);
              }
              else
              {
                paramResources = "GB";
                continue;
                if (paramResources != null)
                {
                  paramResources = paramResources.getString(2131952601);
                }
                else
                {
                  paramResources = "MB";
                  continue;
                  if (paramResources != null)
                  {
                    paramResources = paramResources.getString(2131952521);
                  }
                  else
                  {
                    paramResources = "KB";
                    continue;
                    if (paramResources != null) {
                      paramResources = paramResources.getString(2131951826);
                    } else {
                      paramResources = "B";
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return "";
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bw/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */