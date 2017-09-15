package com.tencent.mm.u;

import android.app.Notification;
import android.app.PendingIntent;
import android.graphics.Bitmap;

public abstract interface af
  extends ah
{
  public abstract int a(Notification paramNotification, boolean paramBoolean);
  
  public abstract Notification a(Notification paramNotification, int paramInt1, int paramInt2, PendingIntent paramPendingIntent, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, String paramString4);
  
  public abstract Notification a(Notification paramNotification, int paramInt1, PendingIntent paramPendingIntent1, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, int paramInt2, String paramString4, PendingIntent paramPendingIntent2, int paramInt3, String paramString5, PendingIntent paramPendingIntent3, String paramString6);
  
  public abstract Notification a(PendingIntent paramPendingIntent, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, String paramString4);
  
  public abstract void a(int paramInt, Notification paramNotification, boolean paramBoolean);
  
  public abstract void aw(boolean paramBoolean);
  
  public abstract void ax(boolean paramBoolean);
  
  public abstract int b(Notification paramNotification);
  
  public abstract void cancel(int paramInt);
  
  public abstract void cancelNotification(String paramString);
  
  public abstract void dN(int paramInt);
  
  public abstract void dO(int paramInt);
  
  public abstract void dP(int paramInt);
  
  public abstract void db(String paramString);
  
  public abstract void dc(String paramString);
  
  public abstract void j(int paramInt, String paramString);
  
  public abstract void l(String paramString, int paramInt);
  
  public abstract void notify(int paramInt, Notification paramNotification);
  
  public abstract void ox();
  
  public abstract String qh();
  
  public abstract void qi();
  
  public abstract boolean qj();
  
  public abstract void qk();
  
  public abstract void ql();
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/u/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */