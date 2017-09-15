package com.tencent.mm.compatible.b;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Message;
import com.jg.JgMethodChecked;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.compatible.d.j;
import com.tencent.mm.compatible.d.k;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.compatible.util.l;
import com.tencent.mm.e.a.iv;
import com.tencent.mm.e.a.iv.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class e
{
  private static e gNf;
  public static boolean gNi;
  public static boolean gNj;
  public static boolean gNk;
  private static boolean gNl;
  private static int gNr;
  private static int gNs;
  private static HashMap<Integer, String> gNt;
  private static int gNu;
  private static int gNv;
  private static HashMap<Integer, String> gNw;
  private static final Object lock;
  public final AudioManager gNg;
  private int gNh;
  private int gNm;
  private final Set<a> gNn;
  private final int gNo;
  public ad gNp;
  private int gNq;
  
  static
  {
    GMTrace.i(13821473193984L, 102978);
    gNf = null;
    lock = new Object();
    gNi = false;
    gNj = false;
    gNk = false;
    gNl = false;
    gNr = 0;
    gNs = 0;
    gNt = new HashMap();
    gNu = 0;
    gNv = 0;
    gNw = new HashMap();
    GMTrace.o(13821473193984L, 102978);
  }
  
  @JgMethodChecked(author=20, fComment="checked", lastDate="20140429", reviewer=20, vComment={com.jg.EType.RECEIVERCHECK})
  public e(Context paramContext)
  {
    GMTrace.i(13817178226688L, 102946);
    this.gNh = -1;
    this.gNm = 0;
    this.gNn = new HashSet();
    this.gNo = 1000;
    this.gNp = new ad()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        GMTrace.i(16768760283136L, 124937);
        v.i("MicroMsg.MMAudioManager", "dkbt post delay BLUETOOTH_DEVICE_CONNECTED ");
        e.this.ea(3);
        GMTrace.o(16768760283136L, 124937);
      }
    };
    this.gNq = -1;
    this.gNg = ((AudioManager)paramContext.getSystemService("audio"));
    v.i("MicroMsg.MMAudioManager", "init dkbt %s", new Object[] { qM() });
    paramContext.registerReceiver(new BroadcastReceiver()new IntentFilter
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        GMTrace.i(13815030743040L, 102930);
        v.i("MicroMsg.MMAudioManager", "leonl onReceive action[ ACTION_AUDIO_BECOMING_NOISY ] ");
        e.this.ea(7);
        GMTrace.o(13815030743040L, 102930);
      }
    }, new IntentFilter("android.media.AUDIO_BECOMING_NOISY"));
    paramContext.registerReceiver(new BroadcastReceiver()new IntentFilter
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        GMTrace.i(13814762307584L, 102928);
        int i = paramAnonymousIntent.getIntExtra("state", -1);
        v.i("MicroMsg.MMAudioManager", "leonl onReceive action[ HEADSET_PLUG ] state = %s,mic = %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramAnonymousIntent.getIntExtra("microphone", -1)) });
        if (i == 0)
        {
          e.this.ea(6);
          GMTrace.o(13814762307584L, 102928);
          return;
        }
        if (i == 1) {
          e.this.qH();
        }
        GMTrace.o(13814762307584L, 102928);
      }
    }, new IntentFilter("android.intent.action.HEADSET_PLUG"));
    paramContext.registerReceiver(new BroadcastReceiver()new IntentFilter
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        GMTrace.i(13822949588992L, 102989);
        if (paramAnonymousIntent == null)
        {
          GMTrace.o(13822949588992L, 102989);
          return;
        }
        paramAnonymousContext = paramAnonymousIntent.getAction();
        e.gNk = paramAnonymousIntent.getBooleanExtra("existing", false);
        v.i("MicroMsg.MMAudioManager", "dkbt onReceive action[" + paramAnonymousContext + "] existing:" + e.gNk);
        GMTrace.o(13822949588992L, 102989);
      }
    }, new IntentFilter("com.htc.accessory.action.CONNECTION_EXISTING"));
    paramContext.registerReceiver(new BroadcastReceiver()new IntentFilter
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        GMTrace.i(13815836049408L, 102936);
        v.i("MicroMsg.MMAudioManager", "dkbt onReceive action[ BluetoothDevice.ACTION_ACL_CONNECTED ] ");
        if (f.ep(11))
        {
          e.gNi = true;
          e.this.gNp.sendEmptyMessageDelayed(0, 1000L);
        }
        GMTrace.o(13815836049408L, 102936);
      }
    }, new IntentFilter("android.bluetooth.device.action.ACL_CONNECTED"));
    paramContext.registerReceiver(new BroadcastReceiver()new IntentFilter
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        GMTrace.i(16768894500864L, 124938);
        v.i("MicroMsg.MMAudioManager", "dkbt onReceive action[ BluetoothDevice.ACTION_ACL_DISCONNECTED ] ");
        e.gNi = false;
        if (p.gRb.gPB == 1) {
          com.tencent.mm.compatible.c.a.a(e.this.gNg);
        }
        e.this.ea(4);
        GMTrace.o(16768894500864L, 124938);
      }
    }, new IntentFilter("android.bluetooth.device.action.ACL_DISCONNECTED"));
    if (f.eo(11)) {
      paramContext.registerReceiver(new BroadcastReceiver()new IntentFilter
      {
        public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
        {
          GMTrace.i(16768357629952L, 124934);
          if (paramAnonymousIntent == null)
          {
            GMTrace.o(16768357629952L, 124934);
            return;
          }
          paramAnonymousContext = paramAnonymousIntent.getAction();
          int i = paramAnonymousIntent.getIntExtra("android.bluetooth.profile.extra.STATE", -1);
          v.i("MicroMsg.MMAudioManager", "dkbt onReceive action[" + paramAnonymousContext + "] state:" + i);
          if (i == 2)
          {
            e.gNi = true;
            e.this.gNp.sendEmptyMessageDelayed(0, 1000L);
            GMTrace.o(16768357629952L, 124934);
            return;
          }
          if (i == 0)
          {
            e.gNi = false;
            if (p.gRb.gPB == 1) {
              com.tencent.mm.compatible.c.a.a(e.this.gNg);
            }
            e.this.ea(4);
          }
          GMTrace.o(16768357629952L, 124934);
        }
      }, new IntentFilter("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED"));
    }
    GMTrace.o(13817178226688L, 102946);
  }
  
  public static void ee(int paramInt)
  {
    GMTrace.i(18797192806400L, 140050);
    gNr += 1;
    v.e("MicroMsg.MMAudioManager", "mm audio track init [%d] mmInitCount[%d] mmReleaseCount[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(gNr), Integer.valueOf(gNs) });
    gNt.put(Integer.valueOf(paramInt), new ag().toString());
    qV();
    GMTrace.o(18797192806400L, 140050);
  }
  
  public static void ef(int paramInt)
  {
    GMTrace.i(18797327024128L, 140051);
    gNs += 1;
    v.e("MicroMsg.MMAudioManager", "mm audio track release [%d] mmInitCount[%d] mmReleaseCount[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(gNr), Integer.valueOf(gNs) });
    gNt.remove(Integer.valueOf(paramInt));
    GMTrace.o(18797327024128L, 140051);
  }
  
  public static void eg(int paramInt)
  {
    GMTrace.i(18797461241856L, 140052);
    gNu += 1;
    v.e("MicroMsg.MMAudioManager", "mm media player init [%d] mmMpInitCount[%d] mmMpReleaseCount[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(gNu), Integer.valueOf(gNv) });
    gNw.put(Integer.valueOf(paramInt), new ag().toString());
    qV();
    GMTrace.o(18797461241856L, 140052);
  }
  
  public static void eh(int paramInt)
  {
    GMTrace.i(18797595459584L, 140053);
    gNv += 1;
    v.e("MicroMsg.MMAudioManager", "mm media player release [%d] mmMpInitCount[%d] mmMpReleaseCount[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(gNu), Integer.valueOf(gNv) });
    gNw.remove(Integer.valueOf(paramInt));
    GMTrace.o(18797595459584L, 140053);
  }
  
  public static e qE()
  {
    GMTrace.i(14614968401920L, 108890);
    synchronized (lock)
    {
      if (gNf == null) {
        gNf = new e(aa.getContext());
      }
      ??? = gNf;
      GMTrace.o(14614968401920L, 108890);
      return (e)???;
    }
  }
  
  @TargetApi(14)
  private static boolean qJ()
  {
    GMTrace.i(13817849315328L, 102951);
    try
    {
      if (Build.VERSION.SDK_INT >= 14)
      {
        int i = BluetoothAdapter.getDefaultAdapter().getProfileConnectionState(1);
        v.i("MicroMsg.MMAudioManager", "isConnectHeadset getProfileConnectionState: %s", new Object[] { Integer.valueOf(i) });
        if (i == 2)
        {
          GMTrace.o(13817849315328L, 102951);
          return true;
        }
        GMTrace.o(13817849315328L, 102951);
        return false;
      }
      boolean bool = gNi;
      if (bool)
      {
        GMTrace.o(13817849315328L, 102951);
        return true;
      }
      if (p.gRb.gPM == 1)
      {
        bool = BluetoothAdapter.getDefaultAdapter().isEnabled();
        GMTrace.o(13817849315328L, 102951);
        return bool;
      }
    }
    catch (Exception localException)
    {
      v.e("MicroMsg.MMAudioManager", "dkbt exception in isConnectDevice()");
      GMTrace.o(13817849315328L, 102951);
    }
    return false;
  }
  
  public static int qK()
  {
    GMTrace.i(13818117750784L, 102953);
    ((AudioManager)aa.getContext().getSystemService("audio")).isBluetoothScoOn();
    GMTrace.o(13818117750784L, 102953);
    return 0;
  }
  
  public static boolean qL()
  {
    GMTrace.i(13818251968512L, 102954);
    v.d("MicroMsg.MMAudioManager", "dkbt isBluetoothCanUse existing:" + gNk + " , isUseHTCAccessory = " + gNl);
    if ((gNk) && (!gNl))
    {
      GMTrace.o(13818251968512L, 102954);
      return false;
    }
    v.d("MicroMsg.MMAudioManager", "dkbt isACLConnected:" + gNi);
    if (!qJ())
    {
      v.i("MicroMsg.MMAudioManager", "dkbt isACLConnected =  " + gNi + " , isConnectHeadset() = " + qJ());
      GMTrace.o(13818251968512L, 102954);
      return false;
    }
    Object localObject = BluetoothAdapter.getDefaultAdapter();
    if (localObject == null)
    {
      v.d("MicroMsg.MMAudioManager", "dkbt BluetoothAdapter.getDefaultAdapter() == null");
      GMTrace.o(13818251968512L, 102954);
      return false;
    }
    if (!((BluetoothAdapter)localObject).isEnabled())
    {
      v.i("MicroMsg.MMAudioManager", "dkbt !adp.isEnabled()");
      GMTrace.o(13818251968512L, 102954);
      return false;
    }
    localObject = ((BluetoothAdapter)localObject).getBondedDevices();
    if ((localObject == null) || (((Set)localObject).size() == 0))
    {
      v.e("MicroMsg.MMAudioManager", "dkbt setDev == null || setDev.size() == 0");
      GMTrace.o(13818251968512L, 102954);
      return false;
    }
    localObject = ((Set)localObject).iterator();
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
    } while (((BluetoothDevice)((Iterator)localObject).next()).getBondState() != 12);
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        v.i("MicroMsg.MMAudioManager", "dkbt hasBond == false");
        GMTrace.o(13818251968512L, 102954);
        return false;
      }
      v.i("MicroMsg.MMAudioManager", "alvinluo isBluetoothCanUse: %b", new Object[] { Boolean.valueOf(true) });
      GMTrace.o(13818251968512L, 102954);
      return true;
    }
  }
  
  private void qR()
  {
    GMTrace.i(13819728363520L, 102965);
    if (this.gNg != null)
    {
      int i = this.gNg.getMode();
      boolean bool = this.gNg.isSpeakerphoneOn();
      Object localObject1 = k.rj().ej(98305);
      Object localObject2 = k.rj().ej(94209);
      if (localObject1 == null)
      {
        k.rj().set(98305, Boolean.valueOf(bool));
        v.d("MicroMsg.MMAudioManager", "storeAudioConfig spearkeron " + bool);
      }
      if (localObject2 == null)
      {
        k.rj().set(94209, Integer.valueOf(i));
        v.d("MicroMsg.MMAudioManager", "storeAudioConfig inmode " + i);
      }
    }
    GMTrace.o(13819728363520L, 102965);
  }
  
  private static void qV()
  {
    GMTrace.i(18797729677312L, 140054);
    iv localiv = new iv();
    if (gNr - gNs > 1)
    {
      localiv.fOt.fOu = true;
      localiv.fOt.fOv = gNt.size();
    }
    if (gNu - gNv > 1)
    {
      localiv.fOt.fOw = true;
      localiv.fOt.fOx = gNw.size();
    }
    if ((localiv.fOt.fOw) || (localiv.fOt.fOu))
    {
      v.e("MicroMsg.MMAudioManager", "check media leak audio[%b %d] mediaplayer[%b %d]", new Object[] { Boolean.valueOf(localiv.fOt.fOu), Integer.valueOf(localiv.fOt.fOv), Boolean.valueOf(localiv.fOt.fOw), Integer.valueOf(localiv.fOt.fOx) });
      com.tencent.mm.sdk.b.a.uql.m(localiv);
    }
    GMTrace.o(18797729677312L, 140054);
  }
  
  public static String qW()
  {
    GMTrace.i(18797863895040L, 140055);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("AudioTrack: \r\n");
    ((StringBuffer)localObject).append("leak: ").append(gNt.size()).append("init: ").append(gNr).append("release: ").append(gNs).append("\r\n");
    ((StringBuffer)localObject).append("--------leak map-----------\r\n");
    Iterator localIterator;
    if (!gNt.isEmpty())
    {
      localIterator = gNt.values().iterator();
      while (localIterator.hasNext()) {
        ((StringBuffer)localObject).append((String)localIterator.next()).append("\r\n");
      }
    }
    ((StringBuffer)localObject).append("MediaPlayer: \r\n");
    ((StringBuffer)localObject).append("leak: ").append(gNw.size()).append("init: ").append(gNu).append("release: ").append(gNv).append("\r\n");
    ((StringBuffer)localObject).append("--------leak map-----------\r\n");
    if (!gNw.isEmpty())
    {
      localIterator = gNw.values().iterator();
      while (localIterator.hasNext()) {
        ((StringBuffer)localObject).append((String)localIterator.next()).append("\r\n");
      }
    }
    localObject = ((StringBuffer)localObject).toString();
    v.e("MicroMsg.MMAudioManager", "leak? %s", new Object[] { localObject });
    GMTrace.o(18797863895040L, 140055);
    return (String)localObject;
  }
  
  public final void a(a parama)
  {
    GMTrace.i(13816775573504L, 102943);
    if (parama != null) {
      this.gNn.add(parama);
    }
    GMTrace.o(13816775573504L, 102943);
  }
  
  public final boolean a(boolean paramBoolean, int paramInt)
  {
    GMTrace.i(13818923057152L, 102959);
    int i = this.gNg.getStreamMaxVolume(paramInt);
    v.d("MicroMsg.MMAudioManager", "maxVolumn:" + i);
    i /= 3;
    int j = this.gNg.getStreamVolume(paramInt);
    if (j < i) {
      this.gNg.setStreamVolume(paramInt, i, 0);
    }
    v.i("MicroMsg.MMAudioManager", "StreamType:" + paramInt + "  current:" + j);
    paramBoolean = c(paramBoolean, true);
    GMTrace.o(13818923057152L, 102959);
    return paramBoolean;
  }
  
  public final int aA(boolean paramBoolean)
  {
    int j = 0;
    GMTrace.i(13817983533056L, 102952);
    int i;
    if (paramBoolean)
    {
      i = 3;
      if (!qI()) {
        break label42;
      }
      i = j;
    }
    label42:
    for (;;)
    {
      GMTrace.o(13817983533056L, 102952);
      return i;
      i = 0;
      break;
    }
  }
  
  @TargetApi(11)
  public final boolean aB(boolean paramBoolean)
  {
    int i = 2;
    int k = 0;
    int j = 0;
    GMTrace.i(13818788839424L, 102958);
    v.d("MicroMsg.MMAudioManager", "IPCall dkbt shiftSpeaker:%b -> %b  %s", new Object[] { Boolean.valueOf(qN()), Boolean.valueOf(paramBoolean), qM() });
    if (ao.oS())
    {
      v.v("MicroMsg.MMAudioManager", "shiftSpeaker return when calling blue:%d", new Object[] { Integer.valueOf(this.gNh) });
      GMTrace.o(13818788839424L, 102958);
      return false;
    }
    if (gNj)
    {
      setMode(3);
      GMTrace.o(13818788839424L, 102958);
      return false;
    }
    qR();
    if (p.gQT.gOB)
    {
      if (paramBoolean)
      {
        if (Build.VERSION.SDK_INT < 11) {}
        for (i = j;; i = 3)
        {
          if (p.gQT.gOC >= 0) {
            i = p.gQT.gOC;
          }
          v.d("MicroMsg.MMAudioManager", "IPCall doShiftSpeaker useSpeakerMode:" + i);
          if (i != this.gNg.getMode()) {
            setMode(i);
          }
          if (!this.gNg.isSpeakerphoneOn()) {
            setSpeakerphoneOn(true);
          }
          GMTrace.o(13818788839424L, 102958);
          return paramBoolean;
        }
      }
      if (Build.VERSION.SDK_INT < 11) {
        if (p.gRb.gPM == 1) {
          v.d("MicroMsg.MMAudioManager", "doShiftSpeaker htc usePhoneMode : 0");
        }
      }
      for (i = 0;; i = 3)
      {
        if (p.gQT.gOD >= 0) {
          i = p.gQT.gOD;
        }
        v.d("MicroMsg.MMAudioManager", "IPCall doShiftSpeaker usePhoneMode:" + i);
        if (i != this.gNg.getMode()) {
          setMode(i);
        }
        if (!this.gNg.isSpeakerphoneOn()) {
          break;
        }
        setSpeakerphoneOn(false);
        break;
      }
    }
    if (p.gQT.gND)
    {
      if (p.gQT.qX())
      {
        if (p.gQT.gNF >= 0) {
          setMode(p.gQT.gNF);
        }
        for (;;)
        {
          if (p.gQT.gNH > 0) {
            setSpeakerphoneOn(paramBoolean);
          }
          GMTrace.o(13818788839424L, 102958);
          return paramBoolean;
          if (p.gQT.gNG >= 0) {
            if (paramBoolean) {
              setMode(0);
            } else {
              setMode(2);
            }
          }
        }
      }
      if (p.gQT.qY())
      {
        if (paramBoolean)
        {
          if (p.gQT.rb()) {
            setSpeakerphoneOn(true);
          }
          if (p.gQT.ra() >= 0) {
            setMode(p.gQT.ra());
          }
        }
        for (;;)
        {
          GMTrace.o(13818788839424L, 102958);
          return paramBoolean;
          if (p.gQT.rd()) {
            setSpeakerphoneOn(false);
          }
          if (p.gQT.rc() >= 0) {
            setMode(p.gQT.rc());
          }
        }
      }
    }
    if (paramBoolean)
    {
      if (Build.VERSION.SDK_INT < 11) {}
      for (i = k;; i = 3)
      {
        if (p.gQT.gOc >= 0) {
          i = p.gQT.gOc;
        }
        v.d("MicroMsg.MMAudioManager", "IPCall doShiftSpeaker useSpeakerMode:" + i);
        if (i != this.gNg.getMode()) {
          setMode(i);
        }
        if (!this.gNg.isSpeakerphoneOn()) {
          setSpeakerphoneOn(true);
        }
        GMTrace.o(13818788839424L, 102958);
        return paramBoolean;
      }
    }
    if (Build.VERSION.SDK_INT < 11)
    {
      if (p.gRb.gPM != 1) {
        break label771;
      }
      v.d("MicroMsg.MMAudioManager", "doShiftSpeaker htc usePhoneMode : 0");
      i = 0;
    }
    for (;;)
    {
      j = i;
      if (Build.VERSION.SDK_INT >= 11)
      {
        j = i;
        if (l.qq())
        {
          j = i;
          if (2 == p.gRb.gPN) {
            j = 2;
          }
        }
      }
      if (p.gQT.gOd >= 0) {
        j = p.gQT.gOd;
      }
      v.d("MicroMsg.MMAudioManager", "IPCall doShiftSpeaker usePhoneMode:" + j);
      if (j != this.gNg.getMode()) {
        setMode(j);
      }
      if (!this.gNg.isSpeakerphoneOn()) {
        break;
      }
      setSpeakerphoneOn(false);
      break;
      i = 3;
      continue;
      label771:
      i = 2;
    }
  }
  
  public final void b(a parama)
  {
    GMTrace.i(13816909791232L, 102944);
    if (parama != null) {
      this.gNn.remove(parama);
    }
    GMTrace.o(13816909791232L, 102944);
  }
  
  @TargetApi(11)
  public final boolean c(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 1;
    int k = 0;
    int j = 0;
    GMTrace.i(13818654621696L, 102957);
    int m = this.gNg.getMode();
    v.i("MicroMsg.MMAudioManager", "dkbt shiftSpeaker:%b -> %b  %s", new Object[] { Boolean.valueOf(qN()), Boolean.valueOf(paramBoolean1), qM() });
    if (ao.oS())
    {
      v.v("MicroMsg.MMAudioManager", "shiftSpeaker return when calling Mode:%d blue:%d", new Object[] { Integer.valueOf(m), Integer.valueOf(this.gNh) });
      GMTrace.o(13818654621696L, 102957);
      return false;
    }
    if ((qI()) || (gNj))
    {
      v.i("MicroMsg.MMAudioManager", "dkbt shiftSpeaker isBluetoothOn");
      if (!paramBoolean2) {
        setMode(0);
      }
      for (;;)
      {
        GMTrace.o(13818654621696L, 102957);
        return false;
        v.d("MicroMsg.MMAudioManager", "Bluetooth is on and now is in VoIP , set 3 MODE_IN_COMMUNICATION..");
        setMode(3);
      }
    }
    qR();
    if (paramBoolean2)
    {
      if (p.gQT.gND)
      {
        if (p.gQT.qX())
        {
          if (p.gQT.gNF >= 0) {
            setMode(p.gQT.gNF);
          }
          for (;;)
          {
            if (p.gQT.gNH > 0) {
              setSpeakerphoneOn(paramBoolean1);
            }
            GMTrace.o(13818654621696L, 102957);
            return paramBoolean1;
            if (p.gQT.gNG >= 0) {
              if (paramBoolean1) {
                setMode(0);
              } else {
                setMode(2);
              }
            }
          }
        }
        if (p.gQT.qY())
        {
          if (paramBoolean1)
          {
            if (p.gQT.rb()) {
              setSpeakerphoneOn(true);
            }
            if (p.gQT.ra() >= 0) {
              setMode(p.gQT.ra());
            }
          }
          for (;;)
          {
            GMTrace.o(13818654621696L, 102957);
            return paramBoolean1;
            if (p.gQT.rd()) {
              setSpeakerphoneOn(false);
            }
            if (p.gQT.rc() >= 0) {
              setMode(p.gQT.rc());
            }
          }
        }
      }
    }
    else if ((p.gQT.gND) && (p.gQT.qZ()))
    {
      if (paramBoolean1)
      {
        localObject = p.gQT;
        i = j;
        if (((com.tencent.mm.compatible.d.a)localObject).qZ())
        {
          k = ((com.tencent.mm.compatible.d.a)localObject).gNJ & 0x10;
          localObject = new StringBuilder("enableSpeaker ");
          if (k <= 0) {
            break label489;
          }
        }
        label489:
        for (paramBoolean2 = true;; paramBoolean2 = false)
        {
          v.d("VoipAudioInfo", paramBoolean2);
          i = j;
          if (k > 0) {
            i = 1;
          }
          if (i != 0) {
            setSpeakerphoneOn(true);
          }
          if (p.gQT.re() >= 0) {
            setMode(p.gQT.re());
          }
          GMTrace.o(13818654621696L, 102957);
          return paramBoolean1;
        }
      }
      Object localObject = p.gQT;
      if (((com.tencent.mm.compatible.d.a)localObject).qZ())
      {
        j = ((com.tencent.mm.compatible.d.a)localObject).gNJ & 0x1;
        localObject = new StringBuilder("disableSpeaker ");
        if (j > 0)
        {
          paramBoolean2 = true;
          label535:
          v.d("VoipAudioInfo", paramBoolean2);
          if (j <= 0) {
            break label591;
          }
        }
      }
      for (;;)
      {
        if (i != 0) {
          setSpeakerphoneOn(false);
        }
        if (p.gQT.rf() < 0) {
          break;
        }
        setMode(p.gQT.rf());
        break;
        paramBoolean2 = false;
        break label535;
        label591:
        i = 0;
        continue;
        i = 0;
      }
    }
    if (paramBoolean2)
    {
      if (paramBoolean1)
      {
        if (Build.VERSION.SDK_INT < 11)
        {
          i = k;
          if (p.gQT.gOc >= 0) {
            i = p.gQT.gOc;
          }
          v.d("MicroMsg.MMAudioManager", "voip doShiftSpeaker useSpeakerMode:" + i);
          if (i != this.gNg.getMode()) {
            setMode(i);
          }
          if (i != this.gNg.getMode())
          {
            if (this.gNm != 0) {
              break label728;
            }
            this.gNm = 1;
          }
        }
        for (;;)
        {
          if (!this.gNg.isSpeakerphoneOn()) {
            setSpeakerphoneOn(true);
          }
          GMTrace.o(13818654621696L, 102957);
          return paramBoolean1;
          i = 3;
          break;
          label728:
          if (this.gNm == 2) {
            this.gNm = 3;
          }
        }
      }
      if (Build.VERSION.SDK_INT < 11)
      {
        if (p.gRb.gPM != 1) {
          break label1020;
        }
        v.d("MicroMsg.MMAudioManager", "doShiftSpeaker htc usePhoneMode : 0");
        i = 0;
      }
    }
    for (;;)
    {
      label782:
      j = i;
      if (Build.VERSION.SDK_INT >= 11)
      {
        j = i;
        if (l.qq())
        {
          j = i;
          if (2 == p.gRb.gPN) {
            j = 2;
          }
        }
      }
      if (p.gQT.gOd >= 0) {
        j = p.gQT.gOd;
      }
      v.d("MicroMsg.MMAudioManager", "voip doShiftSpeaker usePhoneMode:" + j);
      if (j != this.gNg.getMode()) {
        setMode(j);
      }
      if (j != this.gNg.getMode())
      {
        if (this.gNm != 0) {
          break label923;
        }
        this.gNm = 2;
      }
      for (;;)
      {
        if (!this.gNg.isSpeakerphoneOn()) {
          break label937;
        }
        setSpeakerphoneOn(false);
        break;
        i = 3;
        break label782;
        label923:
        if (this.gNm == 1) {
          this.gNm = 3;
        }
      }
      label937:
      break;
      setSpeakerphoneOn(paramBoolean1);
      if (qN() == paramBoolean1) {
        break;
      }
      if (paramBoolean1)
      {
        setMode(0);
        break;
      }
      if ((Build.VERSION.SDK_INT >= 11) && (l.qq()) && (2 != p.gRb.gPN))
      {
        setMode(3);
        break;
      }
      if (Build.VERSION.SDK_INT >= 11)
      {
        setMode(3);
        break;
      }
      setMode(2);
      break;
      label1020:
      i = 2;
    }
  }
  
  public final void ea(int paramInt)
  {
    GMTrace.i(13817044008960L, 102945);
    v.i("MicroMsg.MMAudioManager", "notify, new status: %d, current status: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.gNh) });
    Iterator localIterator = this.gNn.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).cW(paramInt);
    }
    GMTrace.o(13817044008960L, 102945);
  }
  
  public final void eb(int paramInt)
  {
    GMTrace.i(13819191492608L, 102961);
    if (this.gNg != null) {
      this.gNg.adjustStreamVolume(paramInt, 1, 5);
    }
    GMTrace.o(13819191492608L, 102961);
  }
  
  public final void ec(int paramInt)
  {
    GMTrace.i(13819325710336L, 102962);
    if (this.gNg != null) {
      this.gNg.adjustStreamVolume(paramInt, -1, 5);
    }
    GMTrace.o(13819325710336L, 102962);
  }
  
  public final void ed(int paramInt)
  {
    GMTrace.i(16768491847680L, 124935);
    if (this.gNg != null)
    {
      v.i("MicroMsg.MMAudioManager", "setStreamVolume streamType:%s,index:%s,flags:%s ", new Object[] { Integer.valueOf(8), Integer.valueOf(paramInt), Integer.valueOf(0) });
      this.gNg.setStreamVolume(8, paramInt, 0);
    }
    GMTrace.o(16768491847680L, 124935);
  }
  
  public final int getStreamMaxVolume(int paramInt)
  {
    GMTrace.i(13820399452160L, 102970);
    if (this.gNg != null)
    {
      paramInt = this.gNg.getStreamMaxVolume(paramInt);
      GMTrace.o(13820399452160L, 102970);
      return paramInt;
    }
    GMTrace.o(13820399452160L, 102970);
    return 5;
  }
  
  public final int getStreamVolume(int paramInt)
  {
    GMTrace.i(13820533669888L, 102971);
    if (this.gNg != null)
    {
      paramInt = this.gNg.getStreamVolume(paramInt);
      GMTrace.o(13820533669888L, 102971);
      return paramInt;
    }
    GMTrace.o(13820533669888L, 102971);
    return -1;
  }
  
  public final void qF()
  {
    GMTrace.i(13817312444416L, 102947);
    v.i("MicroMsg.MMAudioManager", "dkbt bluetoothStopped %s", new Object[] { qM() });
    gNj = false;
    ea(2);
    GMTrace.o(13817312444416L, 102947);
  }
  
  public final int qG()
  {
    GMTrace.i(13817446662144L, 102948);
    this.gNh = -1;
    if (!qL())
    {
      GMTrace.o(13817446662144L, 102948);
      return -1;
    }
    v.j("MicroMsg.MMAudioManager", "dkbt begin tryStartBluetooth %s", new Object[] { qM() });
    AudioManager localAudioManager = this.gNg;
    boolean bool;
    if (!localAudioManager.isBluetoothScoAvailableOffCall()) {
      bool = false;
    }
    for (;;)
    {
      v.i("MicroMsg.MMAudioManager", "dkbt end tryStartBluetooth %s ret:%s", new Object[] { qM(), Boolean.valueOf(bool) });
      v.d("MicroMsg.MMAudioManager", "dkbt  tryStartBluetooth " + qM() + " ret:" + bool);
      bool = qI();
      v.i("MicroMsg.MMAudioManager", "alvinluo isBluetoothOn: %b", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        break;
      }
      GMTrace.o(13817446662144L, 102948);
      return 1;
      if (ao.oS())
      {
        bool = false;
      }
      else
      {
        v.i("MicroMsg.BluetoothUtil", "start DeviceInfo mCommonInfo getStartBluetoothSco:%s ", new Object[] { Integer.valueOf(p.gRb.gPD) });
        if (((p.gRb.gPD == 1) || (p.gRb.gPD == -1)) && (!localAudioManager.isBluetoothScoOn()))
        {
          v.i("MicroMsg.BluetoothUtil", "BluetoothUtil am.isBluetoothScoOn is false and startBluetoothSco, stack: %s", new Object[] { bf.bJP() });
          localAudioManager.startBluetoothSco();
        }
        bool = true;
      }
    }
    GMTrace.o(13817446662144L, 102948);
    return 0;
  }
  
  public final void qH()
  {
    GMTrace.i(13817580879872L, 102949);
    gNj = false;
    v.j("MicroMsg.MMAudioManager", "dkbt begin stopBluetooth %s", new Object[] { qM() });
    com.tencent.mm.compatible.c.a.a(this.gNg);
    this.gNp.removeCallbacksAndMessages(Integer.valueOf(1));
    v.i("MicroMsg.MMAudioManager", "dkbt end stopBluetooth %s", new Object[] { qM() });
    GMTrace.o(13817580879872L, 102949);
  }
  
  public final boolean qI()
  {
    GMTrace.i(13817715097600L, 102950);
    if ((this.gNg.isBluetoothScoOn()) || (this.gNg.isBluetoothA2dpOn()) || (gNj))
    {
      GMTrace.o(13817715097600L, 102950);
      return true;
    }
    GMTrace.o(13817715097600L, 102950);
    return false;
  }
  
  public final String qM()
  {
    GMTrace.i(13818386186240L, 102955);
    if (this.gNg != null) {}
    for (int i = this.gNg.getMode();; i = 0)
    {
      String str = "mode:" + i + " isSpeakerphoneOn:" + this.gNg.isSpeakerphoneOn() + " isBluetoothOn:" + qI() + " btStatus:" + this.gNh;
      GMTrace.o(13818386186240L, 102955);
      return str;
    }
  }
  
  public final boolean qN()
  {
    GMTrace.i(13818520403968L, 102956);
    if (this.gNg.getMode() == 0)
    {
      GMTrace.o(13818520403968L, 102956);
      return true;
    }
    GMTrace.o(13818520403968L, 102956);
    return false;
  }
  
  public final boolean qO()
  {
    GMTrace.i(13819057274880L, 102960);
    if (this.gNg != null)
    {
      boolean bool = this.gNg.isWiredHeadsetOn();
      GMTrace.o(13819057274880L, 102960);
      return bool;
    }
    GMTrace.o(13819057274880L, 102960);
    return false;
  }
  
  public final void qP()
  {
    GMTrace.i(13819459928064L, 102963);
    if (this.gNg != null) {
      this.gNg.setStreamMute(3, true);
    }
    GMTrace.o(13819459928064L, 102963);
  }
  
  public final void qQ()
  {
    GMTrace.i(13819594145792L, 102964);
    if (this.gNg != null) {
      this.gNg.setStreamMute(3, false);
    }
    GMTrace.o(13819594145792L, 102964);
  }
  
  @Deprecated
  public final void qS()
  {
    GMTrace.i(13819862581248L, 102966);
    Object localObject2;
    if (this.gNg != null)
    {
      Object localObject1 = k.rj().ej(98305);
      localObject2 = k.rj().ej(94209);
      if (localObject1 != null)
      {
        v.d("MicroMsg.MMAudioManager", "resumeAudioConfig spearkeron: " + localObject1);
        setSpeakerphoneOn(((Boolean)localObject1).booleanValue());
        k.rj().set(98305, null);
      }
      if (localObject2 == null) {}
    }
    try
    {
      v.i("MicroMsg.MMAudioManager", "resumeAudioConfig oinmode: " + localObject2 + ",inmode:0");
      i = bf.getInt(String.valueOf(localObject2), 0);
      if ((i >= -1) && (i < 4))
      {
        setMode(i);
        k.rj().set(94209, null);
        GMTrace.o(13819862581248L, 102966);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i = 0;
        continue;
        setMode(0);
      }
    }
  }
  
  public final int qT()
  {
    GMTrace.i(13820265234432L, 102969);
    int i = this.gNm;
    this.gNm = 0;
    GMTrace.o(13820265234432L, 102969);
    return i;
  }
  
  public final int qU()
  {
    GMTrace.i(13820667887616L, 102972);
    if (this.gNq == -1) {}
    try
    {
      Field localField = Class.forName("android.media.AudioManager").getField("STREAM_BLUETOOTH_SCO");
      if ((localField != null) && (this.gNg != null)) {
        this.gNq = localField.getInt(this.gNg);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i;
        v.e("MicroMsg.MMAudioManager", "ClassNotFoundException  android.media.AudioManager,exception:" + localException.getMessage());
        this.gNq = 6;
      }
    }
    i = this.gNq;
    GMTrace.o(13820667887616L, 102972);
    return i;
  }
  
  public final void setMode(int paramInt)
  {
    GMTrace.i(13819996798976L, 102967);
    if (this.gNg != null)
    {
      v.i("MicroMsg.MMAudioManager", "set mode from %d to %d", new Object[] { Integer.valueOf(this.gNg.getMode()), Integer.valueOf(paramInt) });
      this.gNg.setMode(paramInt);
    }
    GMTrace.o(13819996798976L, 102967);
  }
  
  public final void setSpeakerphoneOn(boolean paramBoolean)
  {
    GMTrace.i(13820131016704L, 102968);
    v.j("MicroMsg.MMAudioManager", "setSpeakerphoneOn, on: " + paramBoolean, new Object[0]);
    if (this.gNg != null)
    {
      v.i("MicroMsg.MMAudioManager", "setSpeakerphoneOn on: " + paramBoolean);
      this.gNg.setSpeakerphoneOn(paramBoolean);
    }
    GMTrace.o(13820131016704L, 102968);
  }
  
  public static abstract interface a
  {
    public abstract void cW(int paramInt);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/compatible/b/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */