package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class y
{
  public static final i rI = new l();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      rI = new k();
      return;
    }
    if (Build.VERSION.SDK_INT >= 20)
    {
      rI = new j();
      return;
    }
    if (Build.VERSION.SDK_INT >= 19)
    {
      rI = new q();
      return;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      rI = new p();
      return;
    }
    if (Build.VERSION.SDK_INT >= 14)
    {
      rI = new o();
      return;
    }
    if (Build.VERSION.SDK_INT >= 11)
    {
      rI = new n();
      return;
    }
    if (Build.VERSION.SDK_INT >= 9)
    {
      rI = new m();
      return;
    }
  }
  
  public static Bundle a(Notification paramNotification)
  {
    return rI.a(paramNotification);
  }
  
  public static void a(w paramw, ArrayList<a> paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      paramw.a((a)paramArrayList.next());
    }
  }
  
  public static void a(x paramx, r paramr)
  {
    if (paramr != null)
    {
      if (!(paramr instanceof c)) {
        break label37;
      }
      paramr = (c)paramr;
      ad.a(paramx, paramr.sB, paramr.sD, paramr.sC, paramr.rO);
    }
    label37:
    do
    {
      return;
      if ((paramr instanceof h))
      {
        paramr = (h)paramr;
        ad.a(paramx, paramr.sB, paramr.sD, paramr.sC, paramr.sA);
        return;
      }
    } while (!(paramr instanceof b));
    paramr = (b)paramr;
    ad.a(paramx, paramr.sB, paramr.sD, paramr.sC, paramr.rL, paramr.rM, paramr.rN);
  }
  
  public static final class a
    extends ab.a
  {
    public static final ab.a.a rK = new ab.a.a() {};
    public PendingIntent actionIntent;
    public int icon;
    public final Bundle mExtras;
    private final ag[] rJ;
    public CharSequence title;
    
    public a(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent)
    {
      this(paramInt, paramCharSequence, paramPendingIntent, new Bundle());
    }
    
    private a(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent, Bundle paramBundle)
    {
      this.icon = paramInt;
      this.title = y.d.d(paramCharSequence);
      this.actionIntent = paramPendingIntent;
      this.mExtras = paramBundle;
      this.rJ = null;
    }
    
    public final PendingIntent bk()
    {
      return this.actionIntent;
    }
    
    public final Bundle getExtras()
    {
      return this.mExtras;
    }
    
    public final int getIcon()
    {
      return this.icon;
    }
    
    public final CharSequence getTitle()
    {
      return this.title;
    }
  }
  
  public static final class b
    extends y.r
  {
    Bitmap rL;
    Bitmap rM;
    boolean rN;
  }
  
  public static final class c
    extends y.r
  {
    CharSequence rO;
  }
  
  public static final class d
  {
    public Context mContext;
    Bundle mExtras;
    int mPriority;
    public CharSequence rP;
    public CharSequence rQ;
    public PendingIntent rR;
    PendingIntent rS;
    RemoteViews rT;
    public Bitmap rU;
    public CharSequence rV;
    public int rW;
    boolean rX = true;
    public boolean rY;
    public y.r rZ;
    public CharSequence sa;
    int sc;
    int sd;
    boolean se;
    String sf;
    boolean sg;
    String sh;
    public ArrayList<y.a> si = new ArrayList();
    public boolean sj = false;
    public String sk;
    int sl = 0;
    int sm = 0;
    Notification sn;
    public Notification so = new Notification();
    public ArrayList<String> sp;
    
    public d(Context paramContext)
    {
      this.mContext = paramContext;
      this.so.when = System.currentTimeMillis();
      this.so.audioStreamType = -1;
      this.mPriority = 0;
      this.sp = new ArrayList();
    }
    
    protected static CharSequence d(CharSequence paramCharSequence)
    {
      if (paramCharSequence == null) {}
      while (paramCharSequence.length() <= 5120) {
        return paramCharSequence;
      }
      return paramCharSequence.subSequence(0, 5120);
    }
    
    public final d L(int paramInt)
    {
      this.so.icon = paramInt;
      return this;
    }
    
    public final d a(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent)
    {
      this.si.add(new y.a(paramInt, paramCharSequence, paramPendingIntent));
      return this;
    }
    
    public final d a(CharSequence paramCharSequence)
    {
      this.rP = d(paramCharSequence);
      return this;
    }
    
    public final d b(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      this.sc = paramInt1;
      this.sd = paramInt2;
      this.se = paramBoolean;
      return this;
    }
    
    public final d b(long paramLong)
    {
      this.so.when = paramLong;
      return this;
    }
    
    public final d b(CharSequence paramCharSequence)
    {
      this.rQ = d(paramCharSequence);
      return this;
    }
    
    public final Notification build()
    {
      y.i locali = y.rI;
      new y.e();
      return locali.b(this);
    }
    
    public final d c(CharSequence paramCharSequence)
    {
      this.so.tickerText = d(paramCharSequence);
      return this;
    }
    
    @Deprecated
    public final Notification getNotification()
    {
      return build();
    }
    
    public final void j(int paramInt, boolean paramBoolean)
    {
      if (paramBoolean)
      {
        localNotification = this.so;
        localNotification.flags |= paramInt;
        return;
      }
      Notification localNotification = this.so;
      localNotification.flags &= (paramInt ^ 0xFFFFFFFF);
    }
    
    public final d o(boolean paramBoolean)
    {
      j(16, paramBoolean);
      return this;
    }
  }
  
  protected static final class e {}
  
  public static final class f
    implements y.g
  {
    private Bitmap rU;
    private int sl = 0;
    public a sq;
    
    public final y.d a(y.d paramd)
    {
      if (Build.VERSION.SDK_INT < 21) {
        return paramd;
      }
      Bundle localBundle = new Bundle();
      if (this.rU != null) {
        localBundle.putParcelable("large_icon", this.rU);
      }
      if (this.sl != 0) {
        localBundle.putInt("app_color", this.sl);
      }
      if (this.sq != null) {
        localBundle.putBundle("car_conversation", y.rI.a(this.sq));
      }
      if (paramd.mExtras == null) {
        paramd.mExtras = new Bundle();
      }
      paramd.mExtras.putBundle("android.car.EXTENSIONS", localBundle);
      return paramd;
    }
    
    public static final class a
      extends ab.b
    {
      static final ab.b.a sx = new ab.b.a() {};
      private final String[] sr;
      private final ag ss;
      private final PendingIntent st;
      private final PendingIntent su;
      private final String[] sv;
      private final long sw;
      
      public a(String[] paramArrayOfString1, ag paramag, PendingIntent paramPendingIntent1, PendingIntent paramPendingIntent2, String[] paramArrayOfString2, long paramLong)
      {
        this.sr = paramArrayOfString1;
        this.ss = paramag;
        this.su = paramPendingIntent2;
        this.st = paramPendingIntent1;
        this.sv = paramArrayOfString2;
        this.sw = paramLong;
      }
      
      public final long getLatestTimestamp()
      {
        return this.sw;
      }
      
      public final String[] getMessages()
      {
        return this.sr;
      }
      
      public final String[] getParticipants()
      {
        return this.sv;
      }
      
      public final PendingIntent getReadPendingIntent()
      {
        return this.su;
      }
      
      public final PendingIntent getReplyPendingIntent()
      {
        return this.st;
      }
      
      public static final class a
      {
        public ag ss;
        public PendingIntent st;
        public PendingIntent su;
        public long sw;
        public final List<String> sy = new ArrayList();
        public final String sz;
        
        public a(String paramString)
        {
          this.sz = paramString;
        }
      }
    }
  }
  
  public static abstract interface g
  {
    public abstract y.d a(y.d paramd);
  }
  
  public static final class h
    extends y.r
  {
    ArrayList<CharSequence> sA = new ArrayList();
  }
  
  static abstract interface i
  {
    public abstract Bundle a(Notification paramNotification);
    
    public abstract Bundle a(ab.b paramb);
    
    public abstract Notification b(y.d paramd);
  }
  
  static class j
    extends y.q
  {
    public Notification b(y.d paramd)
    {
      z.a locala = new z.a(paramd.mContext, paramd.so, paramd.rP, paramd.rQ, paramd.rV, paramd.rT, paramd.rW, paramd.rR, paramd.rS, paramd.rU, paramd.sc, paramd.sd, paramd.se, paramd.rX, paramd.rY, paramd.mPriority, paramd.sa, paramd.sj, paramd.sp, paramd.mExtras, paramd.sf, paramd.sg, paramd.sh);
      y.a(locala, paramd.si);
      y.a(locala, paramd.rZ);
      return locala.build();
    }
  }
  
  static final class k
    extends y.j
  {
    public final Bundle a(ab.b paramb)
    {
      Parcelable[] arrayOfParcelable = null;
      int i = 0;
      if (paramb == null) {
        return null;
      }
      Bundle localBundle1 = new Bundle();
      Object localObject = arrayOfParcelable;
      if (paramb.getParticipants() != null)
      {
        localObject = arrayOfParcelable;
        if (paramb.getParticipants().length > 1) {
          localObject = paramb.getParticipants()[0];
        }
      }
      arrayOfParcelable = new Parcelable[paramb.getMessages().length];
      while (i < arrayOfParcelable.length)
      {
        Bundle localBundle2 = new Bundle();
        localBundle2.putString("text", paramb.getMessages()[i]);
        localBundle2.putString("author", (String)localObject);
        arrayOfParcelable[i] = localBundle2;
        i += 1;
      }
      localBundle1.putParcelableArray("messages", arrayOfParcelable);
      localObject = paramb.bm();
      if (localObject != null) {
        localBundle1.putParcelable("remote_input", aa.a((ai.a)localObject));
      }
      localBundle1.putParcelable("on_reply", paramb.getReplyPendingIntent());
      localBundle1.putParcelable("on_read", paramb.getReadPendingIntent());
      localBundle1.putStringArray("participants", paramb.getParticipants());
      localBundle1.putLong("timestamp", paramb.getLatestTimestamp());
      return localBundle1;
    }
    
    public final Notification b(y.d paramd)
    {
      aa.a locala = new aa.a(paramd.mContext, paramd.so, paramd.rP, paramd.rQ, paramd.rV, paramd.rT, paramd.rW, paramd.rR, paramd.rS, paramd.rU, paramd.sc, paramd.sd, paramd.se, paramd.rX, paramd.rY, paramd.mPriority, paramd.sa, paramd.sj, paramd.sk, paramd.sp, paramd.mExtras, paramd.sl, paramd.sm, paramd.sn, paramd.sf, paramd.sg, paramd.sh);
      y.a(locala, paramd.si);
      y.a(locala, paramd.rZ);
      return locala.build();
    }
  }
  
  static class l
    implements y.i
  {
    public Bundle a(Notification paramNotification)
    {
      return null;
    }
    
    public Bundle a(ab.b paramb)
    {
      return null;
    }
    
    public Notification b(y.d paramd)
    {
      Notification localNotification = paramd.so;
      localNotification.setLatestEventInfo(paramd.mContext, paramd.rP, paramd.rQ, paramd.rR);
      if (paramd.mPriority > 0) {
        localNotification.flags |= 0x80;
      }
      return localNotification;
    }
  }
  
  static final class m
    extends y.l
  {
    public final Notification b(y.d paramd)
    {
      Notification localNotification = paramd.so;
      Context localContext = paramd.mContext;
      CharSequence localCharSequence1 = paramd.rP;
      CharSequence localCharSequence2 = paramd.rQ;
      PendingIntent localPendingIntent1 = paramd.rR;
      PendingIntent localPendingIntent2 = paramd.rS;
      localNotification.setLatestEventInfo(localContext, localCharSequence1, localCharSequence2, localPendingIntent1);
      localNotification.fullScreenIntent = localPendingIntent2;
      if (paramd.mPriority > 0) {
        localNotification.flags |= 0x80;
      }
      return localNotification;
    }
  }
  
  static final class n
    extends y.l
  {
    public final Notification b(y.d paramd)
    {
      Object localObject2 = paramd.mContext;
      Notification localNotification = paramd.so;
      Object localObject1 = paramd.rP;
      CharSequence localCharSequence1 = paramd.rQ;
      CharSequence localCharSequence2 = paramd.rV;
      RemoteViews localRemoteViews = paramd.rT;
      int i = paramd.rW;
      PendingIntent localPendingIntent2 = paramd.rR;
      PendingIntent localPendingIntent1 = paramd.rS;
      paramd = paramd.rU;
      localObject2 = new Notification.Builder((Context)localObject2).setWhen(localNotification.when).setSmallIcon(localNotification.icon, localNotification.iconLevel).setContent(localNotification.contentView).setTicker(localNotification.tickerText, localRemoteViews).setSound(localNotification.sound, localNotification.audioStreamType).setVibrate(localNotification.vibrate).setLights(localNotification.ledARGB, localNotification.ledOnMS, localNotification.ledOffMS);
      if ((localNotification.flags & 0x2) != 0)
      {
        bool = true;
        localObject2 = ((Notification.Builder)localObject2).setOngoing(bool);
        if ((localNotification.flags & 0x8) == 0) {
          break label284;
        }
        bool = true;
        label180:
        localObject2 = ((Notification.Builder)localObject2).setOnlyAlertOnce(bool);
        if ((localNotification.flags & 0x10) == 0) {
          break label289;
        }
        bool = true;
        label201:
        localObject1 = ((Notification.Builder)localObject2).setAutoCancel(bool).setDefaults(localNotification.defaults).setContentTitle((CharSequence)localObject1).setContentText(localCharSequence1).setContentInfo(localCharSequence2).setContentIntent(localPendingIntent2).setDeleteIntent(localNotification.deleteIntent);
        if ((localNotification.flags & 0x80) == 0) {
          break label294;
        }
      }
      label284:
      label289:
      label294:
      for (boolean bool = true;; bool = false)
      {
        return ((Notification.Builder)localObject1).setFullScreenIntent(localPendingIntent1, bool).setLargeIcon(paramd).setNumber(i).getNotification();
        bool = false;
        break;
        bool = false;
        break label180;
        bool = false;
        break label201;
      }
    }
  }
  
  static final class o
    extends y.l
  {
    public final Notification b(y.d paramd)
    {
      return new ac.a(paramd.mContext, paramd.so, paramd.rP, paramd.rQ, paramd.rV, paramd.rT, paramd.rW, paramd.rR, paramd.rS, paramd.rU, paramd.sc, paramd.sd, paramd.se).build();
    }
  }
  
  static class p
    extends y.l
  {
    public Bundle a(Notification paramNotification)
    {
      return ad.a(paramNotification);
    }
    
    public Notification b(y.d paramd)
    {
      ad.a locala = new ad.a(paramd.mContext, paramd.so, paramd.rP, paramd.rQ, paramd.rV, paramd.rT, paramd.rW, paramd.rR, paramd.rS, paramd.rU, paramd.sc, paramd.sd, paramd.se, paramd.rY, paramd.mPriority, paramd.sa, paramd.sj, paramd.mExtras, paramd.sf, paramd.sg, paramd.sh);
      y.a(locala, paramd.si);
      y.a(locala, paramd.rZ);
      return locala.build();
    }
  }
  
  static class q
    extends y.p
  {
    public final Bundle a(Notification paramNotification)
    {
      return paramNotification.extras;
    }
    
    public Notification b(y.d paramd)
    {
      ae.a locala = new ae.a(paramd.mContext, paramd.so, paramd.rP, paramd.rQ, paramd.rV, paramd.rT, paramd.rW, paramd.rR, paramd.rS, paramd.rU, paramd.sc, paramd.sd, paramd.se, paramd.rX, paramd.rY, paramd.mPriority, paramd.sa, paramd.sj, paramd.sp, paramd.mExtras, paramd.sf, paramd.sg, paramd.sh);
      y.a(locala, paramd.si);
      y.a(locala, paramd.rZ);
      return locala.build();
    }
  }
  
  public static abstract class r
  {
    CharSequence sB;
    CharSequence sC;
    boolean sD = false;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v4/app/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */