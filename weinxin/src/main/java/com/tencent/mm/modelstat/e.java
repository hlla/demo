package com.tencent.mm.modelstat;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Pair;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.o;
import com.tencent.mm.at.b.1;
import com.tencent.mm.kernel.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.l;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import junit.framework.Assert;

public class e
{
  private static e hUY;
  private int hUZ;
  public int hVa;
  public int hVb;
  public int hVc;
  public int hVd;
  public ArrayList<Pair<Float, Float>> hVe;
  public ArrayList<Pair<Float, Float>> hVf;
  public long startTime;
  
  public e()
  {
    GMTrace.i(1374657970176L, 10242);
    this.startTime = 0L;
    this.hUZ = -1;
    this.hVa = 20000;
    this.hVb = 3000;
    this.hVc = 1000;
    this.hVd = 20;
    this.hVe = new ArrayList();
    this.hVf = new ArrayList();
    GMTrace.o(1374657970176L, 10242);
  }
  
  public static e JY()
  {
    GMTrace.i(1374792187904L, 10243);
    if (hUY == null) {}
    try
    {
      if (hUY == null) {
        hUY = new e();
      }
      e locale = hUY;
      GMTrace.o(1374792187904L, 10243);
      return locale;
    }
    finally {}
  }
  
  public static boolean k(float paramFloat1, float paramFloat2)
  {
    GMTrace.i(16012711821312L, 119304);
    if (Math.abs(paramFloat1 - paramFloat2) < Math.pow(0.1D, 2.0D))
    {
      GMTrace.o(16012711821312L, 119304);
      return true;
    }
    GMTrace.o(16012711821312L, 119304);
    return false;
  }
  
  public final void a(final int paramInt1, final boolean paramBoolean1, final boolean paramBoolean2, final float paramFloat1, final float paramFloat2, final int paramInt2)
  {
    GMTrace.i(1374926405632L, 10244);
    v.i("MicroMsg.IndoorReporter", "report scene:%d agps:%b mars:%b lon:%f lat:%f acc:%d", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(paramInt2) });
    if (com.tencent.mm.kernel.h.vG().uV())
    {
      com.tencent.mm.kernel.h.vG();
      if (!a.uP()) {}
    }
    else
    {
      GMTrace.o(1374926405632L, 10244);
      return;
    }
    com.tencent.mm.at.b localb = com.tencent.mm.at.b.IB();
    int i;
    if (paramBoolean2)
    {
      i = 1;
      if (com.tencent.mm.kernel.h.vG().uV())
      {
        com.tencent.mm.kernel.h.vG();
        if (!a.uP()) {
          break label177;
        }
      }
    }
    for (;;)
    {
      if ((this.hVf.size() != 0) || (this.hVe.size() != 0) || (kR(com.tencent.mm.i.g.sV().getValue("AndroidIndoorSensorReport")))) {
        break label214;
      }
      GMTrace.o(1374926405632L, 10244);
      return;
      i = 0;
      break;
      label177:
      com.tencent.mm.kernel.h.vJ();
      com.tencent.mm.kernel.h.vL().D(new b.1(localb, i, paramFloat1, paramFloat2, paramInt1, paramInt2, 0, "", ""));
    }
    label214:
    if (!com.tencent.mm.sdk.a.b.bIk())
    {
      com.tencent.mm.kernel.h.vG();
      i = com.tencent.mm.a.h.aw(a.uH() + 5, 100);
      if (i > this.hUZ)
      {
        com.tencent.mm.kernel.h.vG();
        v.d("MicroMsg.IndoorReporter", "report uin:%s hash:%d config:%d", new Object[] { Long.valueOf(new o(a.uH()).longValue()), Integer.valueOf(i), Integer.valueOf(this.hUZ) });
        GMTrace.o(1374926405632L, 10244);
        return;
      }
    }
    com.tencent.mm.kernel.h.vJ();
    com.tencent.mm.kernel.h.vL().D(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(1394790629376L, 10392);
        for (;;)
        {
          try
          {
            boolean bool;
            if (com.tencent.mm.kernel.h.vG().uV())
            {
              com.tencent.mm.kernel.h.vG();
              bool = a.uP();
              if (!bool) {}
            }
            else
            {
              GMTrace.o(1394790629376L, 10392);
              return;
            }
            long l = bf.NA();
            if ((e.this.startTime != 0L) && (l - e.this.startTime < 1800000L))
            {
              v.e("MicroMsg.IndoorReporter", "Ignore this Report,Another Report is Running & not timeout:%d.", new Object[] { Long.valueOf(l - e.this.startTime) });
              GMTrace.o(1394790629376L, 10392);
              return;
            }
            if (paramBoolean2)
            {
              localObject1 = e.this.hVe;
              break label754;
              if (i >= ((List)localObject1).size()) {
                break label748;
              }
              if ((!e.k(paramFloat1, ((Float)((Pair)((List)localObject1).get(i)).first).floatValue())) || (!e.k(paramFloat2, ((Float)((Pair)((List)localObject1).get(i)).second).floatValue()))) {
                break label759;
              }
              localObject1 = (Pair)((List)localObject1).get(i);
              if (localObject1 == null)
              {
                v.d("MicroMsg.IndoorReporter", "Ignore this report, no hit any Point");
                GMTrace.o(1394790629376L, 10392);
              }
            }
            else
            {
              localObject1 = e.this.hVf;
              break label754;
            }
            e.this.startTime = l;
            final Object localObject3 = new StringBuilder();
            com.tencent.mm.kernel.h.vG();
            localObject3 = new o(a.uH()).toString() + "_" + e.this.startTime;
            final Object localObject1 = new StringBuilder().append(((Pair)localObject1).first).append(",").append(((Pair)localObject1).second).append(",").append(paramInt1).append(",");
            final e.c localc;
            final Object localObject4;
            if (paramBoolean1)
            {
              i = 1;
              if (paramBoolean2)
              {
                j = 10;
                localObject1 = j + i + "," + paramFloat1 + "," + paramFloat2 + ",0," + paramInt2 + "," + e.this.startTime + ",";
                localc = new e.c(e.this);
                localObject4 = aa.getContext();
                i = e.this.hVb;
                j = e.this.hVd;
                if (localc.aPM == null) {
                  localc.aPM = ((WifiManager)((Context)localObject4).getSystemService("wifi"));
                }
                localc.hVF = i;
                localc.hVd = j;
                localc.startTime = bf.NA();
                localc.hVG = true;
                localc.thread.start();
                localObject4 = new e.b(e.this);
                bool = ((e.b)localObject4).r(aa.getContext(), e.this.hVc);
                if (bool) {
                  continue;
                }
                v.e("MicroMsg.IndoorReporter", "Ignore this report. Error:start wifi:%b sensor:%b  ", new Object[] { Boolean.valueOf(true), Boolean.valueOf(bool) });
                ((e.b)localObject4).JZ();
                localc.JZ();
                com.tencent.mm.plugin.report.service.g.oSF.A(13381, (String)localObject1 + (String)localObject3 + ",-10002,ERROR:StartFailed.");
                GMTrace.o(1394790629376L, 10392);
              }
            }
            else
            {
              i = 2;
              continue;
            }
            int j = 20;
            continue;
            com.tencent.mm.kernel.h.vJ();
            new ai(com.tencent.mm.kernel.h.vL().nIe.getLooper(), new ai.a()
            {
              boolean hVm;
              
              public final boolean oQ()
              {
                GMTrace.i(1390764097536L, 10362);
                boolean bool = l.cB(aa.getContext());
                long l1 = bf.NA();
                long l2 = l1 - e.this.startTime;
                if (l2 <= e.this.hVa)
                {
                  if (bool)
                  {
                    this.hVm = false;
                    GMTrace.o(1390764097536L, 10362);
                    return true;
                  }
                  if (!this.hVm)
                  {
                    this.hVm = true;
                    GMTrace.o(1390764097536L, 10362);
                    return true;
                  }
                }
                v.i("MicroMsg.IndoorReporter", "Stop Now goingbg:%b fg:%b runtime:%d", new Object[] { Boolean.valueOf(this.hVm), Boolean.valueOf(bool), Long.valueOf(l2) });
                e.this.startTime = 0L;
                String str = localObject4.JZ();
                Object localObject = localc.JZ();
                try
                {
                  StringBuilder localStringBuilder;
                  if ((bf.mA(str)) || (bf.mA((String)localObject)))
                  {
                    v.e("MicroMsg.IndoorReporter", "get Res Failed [%s][%s]", new Object[] { str, localObject });
                    localObject = com.tencent.mm.plugin.report.service.g.oSF;
                    localStringBuilder = new StringBuilder().append(localObject1).append(localObject3);
                    if (!bf.mA(str)) {}
                    for (str = ",-10011,ERROR:StopFailed.";; str = ",-10012,ERROR:StopFailed.")
                    {
                      ((com.tencent.mm.plugin.report.service.g)localObject).A(13381, str);
                      GMTrace.o(1390764097536L, 10362);
                      return false;
                    }
                  }
                  localObject = str + (String)localObject;
                  int j = (int)Math.ceil(((String)localObject).length() / 5400.0D);
                  int i = 0;
                  if (i < j)
                  {
                    localStringBuilder = new StringBuilder().append(localObject1).append(localObject3).append("_").append(l1).append("_").append(j).append("_");
                    if (l2 > e.this.hVa) {}
                    for (str = "1";; str = "2")
                    {
                      str = str + "," + (i + 1) + "," + ((String)localObject).substring(i * 5400, Math.min((i + 1) * 5400, ((String)localObject).length()));
                      v.i("MicroMsg.IndoorReporter", "reportKV [%d/%d] res:%d kv:%d [%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(((String)localObject).length()), Integer.valueOf(str.length()), str });
                      com.tencent.mm.plugin.report.service.g.oSF.A(13381, str);
                      i += 1;
                      break;
                    }
                  }
                  return false;
                }
                catch (Exception localException)
                {
                  v.e("MicroMsg.IndoorReporter", "reprot Stop exception:%s", new Object[] { localException.getMessage() });
                  GMTrace.o(1390764097536L, 10362);
                }
              }
            }, true).v(3000L, 3000L);
            GMTrace.o(1394790629376L, 10392);
            return;
          }
          catch (Exception localException)
          {
            v.e("MicroMsg.IndoorReporter", "reprot Start exception:%s", new Object[] { localException.getMessage() });
            GMTrace.o(1394790629376L, 10392);
            return;
          }
          label748:
          Object localObject2 = null;
          continue;
          label754:
          int i = 0;
          continue;
          label759:
          i += 1;
        }
      }
    });
    GMTrace.o(1374926405632L, 10244);
  }
  
  public final boolean kR(String paramString)
  {
    GMTrace.i(1375060623360L, 10245);
    if (bf.mA(paramString))
    {
      GMTrace.o(1375060623360L, 10245);
      return false;
    }
    for (;;)
    {
      int j;
      int i;
      try
      {
        String[] arrayOfString1 = paramString.split(",");
        this.hUZ = bf.getInt(arrayOfString1[0], -1);
        if (this.hUZ > 101) {
          Assert.assertTrue(false);
        }
        this.hVa = bf.getInt(arrayOfString1[1], 20000);
        this.hVb = bf.getInt(arrayOfString1[2], 3000);
        this.hVc = bf.getInt(arrayOfString1[3], 1000);
        this.hVd = bf.getInt(arrayOfString1[4], 20);
        j = bf.getInt(arrayOfString1[5], 0);
        i = 0;
        if (i < j)
        {
          String[] arrayOfString2 = arrayOfString1[(i + 6)].split(";");
          if ("1".equals(arrayOfString2[0])) {
            this.hVe.add(new Pair(Float.valueOf(bf.Qa(arrayOfString2[1])), Float.valueOf(bf.Qa(arrayOfString2[2]))));
          } else {
            this.hVf.add(new Pair(Float.valueOf(bf.Qa(arrayOfString2[1])), Float.valueOf(bf.Qa(arrayOfString2[2]))));
          }
        }
      }
      catch (Exception localException)
      {
        v.e("MicroMsg.IndoorReporter", "parseConfig e:%s  [%s]", new Object[] { localException.getMessage(), paramString });
        GMTrace.o(1375060623360L, 10245);
        return false;
      }
      v.i("MicroMsg.IndoorReporter", "parseConfig: max:%d wifiFreq:%d sensorFreq:%d maxWifiCount:%d cnt:%d mars:%d earth:%d", new Object[] { Integer.valueOf(this.hVa), Integer.valueOf(this.hVb), Integer.valueOf(this.hVc), Integer.valueOf(this.hVd), Integer.valueOf(j), Integer.valueOf(this.hVe.size()), Integer.valueOf(this.hVf.size()) });
      GMTrace.o(1375060623360L, 10245);
      return true;
      i += 1;
    }
  }
  
  static final class a
  {
    public int accuracy;
    public float[] values;
    
    public a(SensorEvent paramSensorEvent)
    {
      GMTrace.i(16866873442304L, 125668);
      this.accuracy = 0;
      if (paramSensorEvent != null)
      {
        this.accuracy = paramSensorEvent.accuracy;
        this.values = new float[paramSensorEvent.values.length];
        System.arraycopy(paramSensorEvent.values, 0, this.values, 0, paramSensorEvent.values.length);
      }
      GMTrace.o(16866873442304L, 125668);
    }
  }
  
  final class b
  {
    ArrayList<e.a> hVA;
    ArrayList<e.a> hVB;
    ArrayList<float[]> hVC;
    private SensorEventListener hVD;
    private SensorManager hVs;
    public long hVt;
    e.a hVu;
    e.a hVv;
    e.a hVw;
    private Long hVx;
    ArrayList<Long> hVy;
    ArrayList<e.a> hVz;
    private HandlerThread handlerThread;
    long hnB;
    
    b()
    {
      GMTrace.i(1397206548480L, 10410);
      this.hVt = 0L;
      this.handlerThread = null;
      this.hVu = null;
      this.hVv = null;
      this.hVw = null;
      this.hVx = null;
      this.hnB = 0L;
      this.hVy = new ArrayList();
      this.hVz = new ArrayList();
      this.hVA = new ArrayList();
      this.hVB = new ArrayList();
      this.hVC = new ArrayList();
      this.hVD = new SensorEventListener()
      {
        public final void onAccuracyChanged(Sensor paramAnonymousSensor, int paramAnonymousInt)
        {
          GMTrace.i(1391569403904L, 10368);
          GMTrace.o(1391569403904L, 10368);
        }
        
        public final void onSensorChanged(SensorEvent paramAnonymousSensorEvent)
        {
          GMTrace.i(1391703621632L, 10369);
          if (paramAnonymousSensorEvent == null)
          {
            GMTrace.o(1391703621632L, 10369);
            return;
          }
          long l1 = bf.NA();
          if (paramAnonymousSensorEvent.sensor.getType() == 1) {
            e.b.this.hVu = new e.a(paramAnonymousSensorEvent);
          }
          for (;;)
          {
            long l2 = l1 - e.b.this.hnB;
            if ((e.b.this.hVu != null) && (e.b.this.hVv != null) && (e.b.this.hVw != null) && ((l2 > e.b.this.hVt) || (l2 < 0L)))
            {
              paramAnonymousSensorEvent = new float[9];
              SensorManager.getRotationMatrix(paramAnonymousSensorEvent, null, e.b.this.hVu.values, e.b.this.hVv.values);
              float[] arrayOfFloat = new float[3];
              SensorManager.getOrientation(paramAnonymousSensorEvent, arrayOfFloat);
              e.b.this.hnB = l1;
              e.b.this.hVy.add(Long.valueOf(l1));
              e.b.this.hVz.add(e.b.this.hVu);
              e.b.this.hVA.add(e.b.this.hVv);
              e.b.this.hVB.add(e.b.this.hVw);
              e.b.this.hVC.add(arrayOfFloat);
              int i = e.b.this.hVz.size() - 1;
              v.i("MicroMsg.IndoorReporter", "RES ,  %d  acc[%d,%f,%f,%f]  ", new Object[] { Integer.valueOf(e.b.this.hVz.size()), Integer.valueOf(((e.a)e.b.this.hVz.get(i)).accuracy), Float.valueOf(((e.a)e.b.this.hVz.get(i)).values[0]), Float.valueOf(((e.a)e.b.this.hVz.get(i)).values[1]), Float.valueOf(((e.a)e.b.this.hVz.get(i)).values[2]) });
              v.v("MicroMsg.IndoorReporter", "Res:%d acc[%d,%f,%f,%f] mag[%d,%f,%f,%f] gyr[%d,%f,%f,%f] ori[%f,%f,%f]", new Object[] { Long.valueOf(l2), Integer.valueOf(e.b.this.hVu.accuracy), Float.valueOf(e.b.this.hVu.values[0]), Float.valueOf(e.b.this.hVu.values[1]), Float.valueOf(e.b.this.hVu.values[2]), Integer.valueOf(e.b.this.hVv.accuracy), Float.valueOf(e.b.this.hVv.values[0]), Float.valueOf(e.b.this.hVv.values[1]), Float.valueOf(e.b.this.hVv.values[2]), Integer.valueOf(e.b.this.hVw.accuracy), Float.valueOf(e.b.this.hVw.values[0]), Float.valueOf(e.b.this.hVw.values[1]), Float.valueOf(e.b.this.hVw.values[2]), Float.valueOf(arrayOfFloat[0]), Float.valueOf(arrayOfFloat[1]), Float.valueOf(arrayOfFloat[2]) });
            }
            GMTrace.o(1391703621632L, 10369);
            return;
            if (paramAnonymousSensorEvent.sensor.getType() == 2) {
              e.b.this.hVv = new e.a(paramAnonymousSensorEvent);
            } else if (paramAnonymousSensorEvent.sensor.getType() == 4) {
              e.b.this.hVw = new e.a(paramAnonymousSensorEvent);
            }
          }
        }
      };
      GMTrace.o(1397206548480L, 10410);
    }
    
    private static String a(e.a parama)
    {
      GMTrace.i(16866739224576L, 125667);
      try
      {
        new String();
        parama = String.format("%d;%.3f;%.3f;%.3f;", new Object[] { Integer.valueOf(parama.accuracy), Float.valueOf(parama.values[0]), Float.valueOf(parama.values[1]), Float.valueOf(parama.values[2]) });
        GMTrace.o(16866739224576L, 125667);
        return parama;
      }
      catch (Exception parama)
      {
        GMTrace.o(16866739224576L, 125667);
      }
      return "0;0;0;0;";
    }
    
    public final String JZ()
    {
      GMTrace.i(1397474983936L, 10412);
      try
      {
        if (this.hVs != null)
        {
          this.hVs.unregisterListener(this.hVD);
          this.hVs = null;
        }
        try
        {
          if (this.handlerThread != null)
          {
            this.handlerThread.quit();
            this.handlerThread = null;
          }
          v.i("MicroMsg.IndoorReporter", "stop sampling Res Count: %d", new Object[] { Integer.valueOf(this.hVy.size()) });
          String str = this.hVx + ";" + this.hVy.size() + ";#";
          int i = 0;
          while (i < this.hVy.size())
          {
            str = str + (((Long)this.hVy.get(i)).longValue() - this.hVx.longValue()) + ";";
            str = str + a((e.a)this.hVz.get(i));
            v.i("MicroMsg.IndoorReporter", "%d accResArr [%d,%f,%f,%f]  %s", new Object[] { Integer.valueOf(i), Integer.valueOf(((e.a)this.hVz.get(i)).accuracy), Float.valueOf(((e.a)this.hVz.get(i)).values[0]), Float.valueOf(((e.a)this.hVz.get(i)).values[1]), Float.valueOf(((e.a)this.hVz.get(i)).values[2]), a((e.a)this.hVz.get(i)) });
            str = str + a((e.a)this.hVB.get(i));
            str = str + a((e.a)this.hVA.get(i));
            str = str + String.format("%.3f;%.3f;%.3f;#", new Object[] { Float.valueOf(((float[])this.hVC.get(i))[0]), Float.valueOf(((float[])this.hVC.get(i))[1]), Float.valueOf(((float[])this.hVC.get(i))[2]) });
            i += 1;
          }
          v.i("MicroMsg.IndoorReporter", "stop  Res: %d [%s]", new Object[] { Integer.valueOf(str.length()), str });
          GMTrace.o(1397474983936L, 10412);
          return str;
        }
        catch (Exception localException1)
        {
          for (;;) {}
        }
      }
      catch (Exception localException2)
      {
        for (;;) {}
      }
    }
    
    public final boolean r(Context paramContext, int paramInt)
    {
      GMTrace.i(1397340766208L, 10411);
      try
      {
        if (this.hVs == null) {
          this.hVs = ((SensorManager)paramContext.getSystemService("sensor"));
        }
        if (this.handlerThread == null)
        {
          this.handlerThread = com.tencent.mm.sdk.f.e.cE("MicroMsg.IndoorReporter", 1);
          this.handlerThread.start();
        }
        paramContext = new Handler(this.handlerThread.getLooper());
        bool1 = this.hVs.registerListener(this.hVD, this.hVs.getDefaultSensor(1), 3, paramContext);
        boolean bool2 = this.hVs.registerListener(this.hVD, this.hVs.getDefaultSensor(4), 3, paramContext);
        boolean bool3 = this.hVs.registerListener(this.hVD, this.hVs.getDefaultSensor(2), 3, paramContext);
        if ((!bool1) || (!bool2) || (!bool3)) {
          break label226;
        }
        bool1 = true;
      }
      catch (Exception paramContext)
      {
        try
        {
          for (;;)
          {
            boolean bool1;
            if (this.hVs == null) {
              break label179;
            }
            this.hVs.unregisterListener(this.hVD);
            this.hVs = null;
            try
            {
              if (this.handlerThread == null) {
                break label199;
              }
              this.handlerThread.quit();
              this.handlerThread = null;
              this.hVt = paramInt;
              this.hVx = Long.valueOf(bf.NA());
              GMTrace.o(1397340766208L, 10411);
              return bool1;
              bool1 = false;
              continue;
              paramContext = paramContext;
              v.e("MicroMsg.IndoorReporter", "start except:%s", new Object[] { paramContext.getMessage() });
              bool1 = false;
            }
            catch (Exception paramContext)
            {
              for (;;) {}
            }
          }
        }
        catch (Exception paramContext)
        {
          for (;;) {}
        }
      }
      if (bool1) {}
    }
  }
  
  final class c
  {
    public WifiManager aPM;
    public int hVF;
    public boolean hVG;
    public List<String> hVH;
    public int hVd;
    public long startTime;
    Thread thread;
    
    c()
    {
      GMTrace.i(1378281848832L, 10269);
      this.hVF = 0;
      this.hVd = 0;
      this.hVG = false;
      this.startTime = 0L;
      this.hVH = new ArrayList();
      this.thread = com.tencent.mm.sdk.f.e.b(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(1394522193920L, 10390);
          v.i("MicroMsg.IndoorReporter", "start wifi");
          for (;;)
          {
            int k;
            int i;
            try
            {
              if (!e.c.this.hVG) {
                break label419;
              }
              long l = bf.NA();
              List localList = e.c.this.aPM.getScanResults();
              Object localObject1 = "";
              if ((localList == null) || (localList.size() <= 0)) {
                break label432;
              }
              Collections.sort(localList, new Comparator() {});
              k = 0;
              i = 0;
              j = i;
              localObject2 = localObject1;
              if (k < localList.size())
              {
                localObject2 = (ScanResult)localList.get(k);
                if ((localObject2 == null) || (bf.mA(((ScanResult)localObject2).BSSID)) || (bf.mA(((ScanResult)localObject2).SSID))) {
                  break label429;
                }
                String str = ((ScanResult)localObject2).SSID.replace(";", "").replace(" ", "").replace(",", "").replace("#", "");
                localObject2 = (String)localObject1 + str + ";" + ((ScanResult)localObject2).BSSID + ";" + ((ScanResult)localObject2).level + ";";
                i += 1;
                if (i >= e.c.this.hVd) {
                  break label448;
                }
                localObject1 = localObject2;
                break label441;
              }
              localObject1 = new StringBuilder().append(l - e.c.this.startTime).append(";");
              if (localList != null)
              {
                i = localList.size();
                localObject1 = i + ";" + j + ";" + (String)localObject2;
                v.i("MicroMsg.IndoorReporter", "%d %s", new Object[] { Integer.valueOf(((String)localObject1).length()), localObject1 });
                e.c.this.hVH.add(localObject1);
                e.c.this.aPM.startScan();
                Thread.sleep(e.c.this.hVF);
                continue;
              }
              i = 0;
            }
            catch (Exception localException)
            {
              v.e("MicroMsg.IndoorReporter", "Except:%s", new Object[] { localException.getMessage() });
              GMTrace.o(1394522193920L, 10390);
              return;
            }
            continue;
            label419:
            GMTrace.o(1394522193920L, 10390);
            return;
            label429:
            break label441;
            label432:
            int j = 0;
            Object localObject2 = localException;
            continue;
            label441:
            k += 1;
            continue;
            label448:
            j = i;
          }
        }
      }, "MicroMsg.IndoorReporter_WIFI_Scan");
      GMTrace.o(1378281848832L, 10269);
    }
    
    public final String JZ()
    {
      GMTrace.i(1378416066560L, 10270);
      this.hVG = false;
      try
      {
        if ((this.thread != null) && (this.thread.isAlive())) {
          this.thread.join(500L);
        }
        String str = this.hVH.size() + ";#";
        int i = 0;
        while (i < this.hVH.size())
        {
          str = str + (String)this.hVH.get(i) + "#";
          i += 1;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          v.e("MicroMsg.IndoorReporter", "stop, join Thread failed:%s ", new Object[] { localException.getMessage() });
        }
        GMTrace.o(1378416066560L, 10270);
        return localException;
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelstat/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */