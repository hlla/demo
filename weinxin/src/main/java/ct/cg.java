package ct;

import android.annotation.SuppressLint;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.CellSignalStrengthCdma;
import android.telephony.CellSignalStrengthGsm;
import android.telephony.CellSignalStrengthLte;
import android.telephony.CellSignalStrengthWcdma;
import android.telephony.NeighboringCellInfo;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import java.util.Collections;
import java.util.List;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

public final class cg
  extends cj
{
  public int a = 0;
  public int b = 0;
  public int c = 0;
  public int d = 0;
  public int e = 0;
  public int f = 0;
  public int g = Integer.MAX_VALUE;
  public int h = Integer.MAX_VALUE;
  private final long i = System.currentTimeMillis();
  private List<NeighboringCellInfo> j;
  
  @SuppressLint({"NewApi"})
  @Nullable
  public static cg a(bk parambk, CellInfo paramCellInfo)
  {
    int k = -88;
    Object localObject;
    if ((!parambk.d()) || (paramCellInfo == null)) {
      localObject = null;
    }
    cg localcg;
    for (;;)
    {
      return (cg)localObject;
      TelephonyManager localTelephonyManager = parambk.a();
      localcg = new cg();
      if ((paramCellInfo instanceof CellInfoCdma)) {}
      try
      {
        paramCellInfo = (CellInfoCdma)paramCellInfo;
        localObject = paramCellInfo.getCellIdentity();
        localcg.a = 2;
        localcg.a(parambk, localTelephonyManager);
        localcg.c = ((CellIdentityCdma)localObject).getSystemId();
        localcg.d = ((CellIdentityCdma)localObject).getNetworkId();
        localcg.e = ((CellIdentityCdma)localObject).getBasestationId();
        localcg.g = ((CellIdentityCdma)localObject).getLatitude();
        localcg.h = ((CellIdentityCdma)localObject).getLongitude();
        n = paramCellInfo.getCellSignalStrength().getDbm();
        m = k;
        if (n > -110)
        {
          m = k;
          if (n < -40) {
            m = n;
          }
        }
        localcg.f = m;
        return localcg;
      }
      catch (Exception parambk)
      {
        int n;
        int m;
        return localcg;
        if ((paramCellInfo instanceof CellInfoGsm)) {}
        try
        {
          paramCellInfo = (CellInfoGsm)paramCellInfo;
          localcg.a = 1;
          localObject = paramCellInfo.getCellIdentity();
          localcg.a(parambk, localTelephonyManager);
          localcg.d = ((CellIdentityGsm)localObject).getLac();
          localcg.e = ((CellIdentityGsm)localObject).getCid();
          localcg.b = ((CellIdentityGsm)localObject).getMcc();
          localcg.c = ((CellIdentityGsm)localObject).getMnc();
          n = paramCellInfo.getCellSignalStrength().getDbm();
          m = k;
          if (n > -110)
          {
            m = k;
            if (n < -40) {
              m = n;
            }
          }
          localcg.f = m;
          return localcg;
        }
        catch (Exception parambk)
        {
          return localcg;
          if ((paramCellInfo instanceof CellInfoWcdma)) {}
          try
          {
            paramCellInfo = (CellInfoWcdma)paramCellInfo;
            localcg.a = 1;
            localObject = paramCellInfo.getCellIdentity();
            localcg.a(parambk, localTelephonyManager);
            localcg.d = ((CellIdentityWcdma)localObject).getLac();
            localcg.e = ((CellIdentityWcdma)localObject).getCid();
            localcg.b = ((CellIdentityWcdma)localObject).getMcc();
            localcg.c = ((CellIdentityWcdma)localObject).getMnc();
            n = paramCellInfo.getCellSignalStrength().getDbm();
            m = k;
            if (n > -110)
            {
              m = k;
              if (n < -40) {
                m = n;
              }
            }
            localcg.f = m;
            return localcg;
          }
          catch (Exception parambk)
          {
            return localcg;
            localObject = localcg;
            if ((paramCellInfo instanceof CellInfoLte))
            {
              try
              {
                paramCellInfo = (CellInfoLte)paramCellInfo;
                localcg.a = 1;
                localObject = paramCellInfo.getCellIdentity();
                localcg.a(parambk, localTelephonyManager);
                localcg.d = ((CellIdentityLte)localObject).getTac();
                localcg.e = ((CellIdentityLte)localObject).getCi();
                localcg.b = ((CellIdentityLte)localObject).getMcc();
                localcg.c = ((CellIdentityLte)localObject).getMnc();
                k = paramCellInfo.getCellSignalStrength().getDbm();
                if ((k <= -110) || (k >= -40)) {
                  break label499;
                }
              }
              catch (Exception parambk)
              {
                for (;;)
                {
                  return localcg;
                  k = -88;
                }
              }
              catch (Error parambk)
              {
                return localcg;
              }
              localcg.f = k;
              return localcg;
            }
          }
          catch (Error parambk)
          {
            return localcg;
          }
        }
        catch (Error parambk)
        {
          label499:
          return localcg;
        }
      }
      catch (Error parambk) {}
    }
    return localcg;
  }
  
  @Nullable
  public static cg a(bk parambk, CellLocation paramCellLocation, SignalStrength paramSignalStrength)
  {
    if ((!parambk.d()) || (paramCellLocation == null)) {
      return null;
    }
    TelephonyManager localTelephonyManager = parambk.a();
    cg localcg = new cg();
    if ((paramCellLocation instanceof CdmaCellLocation)) {}
    try
    {
      paramCellLocation = (CdmaCellLocation)paramCellLocation;
      localcg.a = 2;
      localcg.a(parambk, localTelephonyManager);
      localcg.c = paramCellLocation.getSystemId();
      localcg.d = paramCellLocation.getNetworkId();
      localcg.e = paramCellLocation.getBaseStationId();
      localcg.g = paramCellLocation.getBaseStationLatitude();
      localcg.h = paramCellLocation.getBaseStationLongitude();
      if (paramSignalStrength == null)
      {
        localcg.f = -1;
        return localcg;
      }
      localcg.f = paramSignalStrength.getCdmaDbm();
      return localcg;
    }
    catch (Exception parambk)
    {
      try
      {
        paramCellLocation = (GsmCellLocation)paramCellLocation;
        localcg.a = 1;
        localcg.a(parambk, localTelephonyManager);
        localcg.d = paramCellLocation.getLac();
        localcg.e = paramCellLocation.getCid();
        if (paramSignalStrength == null)
        {
          localcg.f = -1;
          return localcg;
        }
        localcg.f = (paramSignalStrength.getGsmSignalStrength() * 2 - 113);
        return localcg;
      }
      catch (Exception parambk) {}
      parambk = parambk;
      return localcg;
    }
    return localcg;
  }
  
  private void a(bk parambk, TelephonyManager paramTelephonyManager)
  {
    parambk = parambk.g();
    int k = parambk.k;
    int m = parambk.l;
    if ((k > 0) && (m >= 0))
    {
      this.b = k;
      this.c = m;
      return;
    }
    int[] arrayOfInt = new int[2];
    ct.a(paramTelephonyManager, arrayOfInt);
    parambk.k = arrayOfInt[0];
    parambk.l = arrayOfInt[1];
  }
  
  @NonNull
  public final List<NeighboringCellInfo> a()
  {
    try
    {
      if (this.j == null) {
        this.j = Collections.emptyList();
      }
      List localList = this.j;
      return localList;
    }
    finally {}
  }
  
  public final void a(@Nullable List<NeighboringCellInfo> paramList)
  {
    if (paramList != null) {}
    for (;;)
    {
      try
      {
        this.j = Collections.unmodifiableList(paramList);
        return;
      }
      finally {}
      this.j = Collections.emptyList();
    }
  }
  
  public final String toString()
  {
    return "TxCellInfo [PhoneType=" + this.a + ", MCC=" + this.b + ", MNC=" + this.c + ", LAC=" + this.d + ", CID=" + this.e + ", RSSI=" + this.f + ", LAT=" + this.g + ", LNG=" + this.h + ", mTime=" + this.i + "]";
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/ct/cg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */