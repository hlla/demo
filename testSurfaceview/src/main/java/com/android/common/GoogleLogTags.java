package com.android.common;

import android.util.EventLog;

public class GoogleLogTags
{
  public static final int C2DM = 204005;
  public static final int EXP_DET_SNET = 206003;
  public static final int GLS_ACCOUNT_SAVED = 205009;
  public static final int GLS_ACCOUNT_TRIED = 205008;
  public static final int GLS_AUTHENTICATE = 205010;
  public static final int GOOGLE_HTTP_REQUEST = 203002;
  public static final int GOOGLE_MAIL_SWITCH = 205011;
  public static final int GTALKSERVICE = 204001;
  public static final int GTALK_CONNECTION = 204002;
  public static final int GTALK_CONN_CLOSE = 204003;
  public static final int GTALK_HEARTBEAT_RESET = 204004;
  public static final int SETUP_COMPLETED = 205007;
  public static final int SETUP_IO_ERROR = 205003;
  public static final int SETUP_NO_DATA_NETWORK = 205006;
  public static final int SETUP_REQUIRED_CAPTCHA = 205002;
  public static final int SETUP_RETRIES_EXHAUSTED = 205005;
  public static final int SETUP_SERVER_ERROR = 205004;
  public static final int SETUP_SERVER_TIMEOUT = 205001;
  public static final int SNET = 206001;
  public static final int SYNC_DETAILS = 203001;
  public static final int SYSTEM_UPDATE = 201001;
  public static final int SYSTEM_UPDATE_USER = 201002;
  public static final int TRANSACTION_EVENT = 202901;
  public static final int VENDING_RECONSTRUCT = 202001;
  
  public static void writeC2Dm(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    EventLog.writeEvent(204005, new Object[] { Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
  }
  
  public static void writeExpDetSnet(String paramString)
  {
    EventLog.writeEvent(206003, paramString);
  }
  
  public static void writeGlsAccountSaved(int paramInt)
  {
    EventLog.writeEvent(205009, paramInt);
  }
  
  public static void writeGlsAccountTried(int paramInt)
  {
    EventLog.writeEvent(205008, paramInt);
  }
  
  public static void writeGlsAuthenticate(int paramInt, String paramString)
  {
    EventLog.writeEvent(205010, new Object[] { Integer.valueOf(paramInt), paramString });
  }
  
  public static void writeGoogleHttpRequest(long paramLong, int paramInt1, String paramString, int paramInt2)
  {
    EventLog.writeEvent(203002, new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2) });
  }
  
  public static void writeGoogleMailSwitch(int paramInt)
  {
    EventLog.writeEvent(205011, paramInt);
  }
  
  public static void writeGtalkConnClose(int paramInt1, int paramInt2)
  {
    EventLog.writeEvent(204003, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public static void writeGtalkConnection(int paramInt)
  {
    EventLog.writeEvent(204002, paramInt);
  }
  
  public static void writeGtalkHeartbeatReset(int paramInt, String paramString)
  {
    EventLog.writeEvent(204004, new Object[] { Integer.valueOf(paramInt), paramString });
  }
  
  public static void writeGtalkservice(int paramInt)
  {
    EventLog.writeEvent(204001, paramInt);
  }
  
  public static void writeSetupCompleted()
  {
    EventLog.writeEvent(205007, new Object[0]);
  }
  
  public static void writeSetupIoError(String paramString)
  {
    EventLog.writeEvent(205003, paramString);
  }
  
  public static void writeSetupNoDataNetwork()
  {
    EventLog.writeEvent(205006, new Object[0]);
  }
  
  public static void writeSetupRequiredCaptcha(String paramString)
  {
    EventLog.writeEvent(205002, paramString);
  }
  
  public static void writeSetupRetriesExhausted()
  {
    EventLog.writeEvent(205005, new Object[0]);
  }
  
  public static void writeSetupServerError()
  {
    EventLog.writeEvent(205004, new Object[0]);
  }
  
  public static void writeSetupServerTimeout()
  {
    EventLog.writeEvent(205001, new Object[0]);
  }
  
  public static void writeSnet(String paramString)
  {
    EventLog.writeEvent(206001, paramString);
  }
  
  public static void writeSyncDetails(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    EventLog.writeEvent(203001, new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString2 });
  }
  
  public static void writeSystemUpdate(int paramInt1, int paramInt2, long paramLong, String paramString)
  {
    EventLog.writeEvent(201001, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong), paramString });
  }
  
  public static void writeSystemUpdateUser(String paramString)
  {
    EventLog.writeEvent(201002, paramString);
  }
  
  public static void writeTransactionEvent(String paramString)
  {
    EventLog.writeEvent(202901, paramString);
  }
  
  public static void writeVendingReconstruct(int paramInt)
  {
    EventLog.writeEvent(202001, paramInt);
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/common/GoogleLogTags.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */