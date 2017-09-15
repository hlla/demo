package com.tencent.mm.platformtools;

import com.tencent.gmtrace.GMTrace;
import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class r
{
  public static boolean ihQ;
  public static boolean ihR;
  public static boolean ihS;
  public static boolean ihT;
  public static boolean ihU;
  public static boolean ihV;
  public static boolean ihW;
  public static boolean ihX;
  public static boolean ihY;
  public static boolean ihZ;
  public static boolean iiA;
  public static int iiB;
  public static int iiC;
  public static int iiD;
  public static String iiE;
  public static String iiF;
  public static String iiG;
  public static String iiH;
  public static boolean iiI;
  public static boolean iiJ;
  public static boolean iiK;
  public static boolean iiL;
  public static String iiM;
  public static String iiN;
  public static String iiO;
  public static String iiP;
  public static String iiQ;
  public static boolean iiR;
  public static boolean iiS;
  public static boolean iiT;
  public static int iiU;
  public static boolean iiV;
  public static boolean iiW;
  public static boolean iiX;
  public static boolean iiY;
  public static boolean iiZ;
  public static boolean iia;
  public static boolean iib;
  public static String iic;
  public static boolean iid;
  public static boolean iie;
  public static boolean iif;
  public static boolean iig;
  public static int iih;
  public static boolean iii;
  public static boolean iij;
  public static boolean iik;
  public static String iil;
  public static String iim;
  public static boolean iin;
  public static boolean iio;
  public static boolean iip;
  public static boolean iiq;
  public static boolean iir;
  public static boolean iis;
  public static boolean iit;
  public static int iiu;
  public static int iiv;
  public static boolean iiw;
  public static String iix;
  public static String iiy;
  public static boolean iiz;
  private static HashMap<Integer, ConcurrentLinkedQueue<Integer>> ijA;
  public static boolean ijB;
  public static boolean ijC;
  public static boolean ijD;
  public static boolean ija;
  public static boolean ijb;
  public static boolean ijc;
  public static boolean ijd;
  public static String ije;
  public static int ijf;
  public static boolean ijg;
  public static boolean ijh;
  public static int iji;
  public static boolean ijj;
  public static String ijk;
  public static boolean ijl;
  public static boolean ijm;
  public static int ijn;
  public static int ijo;
  public static boolean ijp;
  public static String ijq;
  public static String ijr;
  public static boolean ijs;
  public static boolean ijt;
  public static String iju;
  public static String ijv;
  public static boolean ijw;
  public static boolean ijx;
  public static boolean ijy;
  public static boolean ijz;
  public static double lat;
  public static double lng;
  
  static
  {
    GMTrace.i(13453313966080L, 100235);
    ihQ = false;
    ihR = false;
    ihS = false;
    ihT = false;
    ihU = false;
    ihV = false;
    ihW = false;
    ihX = false;
    ihY = false;
    ihZ = false;
    iia = false;
    iib = false;
    iic = "";
    iid = false;
    iie = false;
    iif = false;
    iig = false;
    iih = 0;
    iii = false;
    iij = false;
    iik = false;
    iil = "";
    iim = "";
    iin = false;
    iio = false;
    iip = false;
    iiq = false;
    iir = false;
    iis = false;
    iit = false;
    iiu = 0;
    iiv = 0;
    iiw = false;
    iix = null;
    iiy = null;
    iiz = false;
    iiA = false;
    iiB = 0;
    iiC = 0;
    iiD = 0;
    iiE = "";
    iiF = "";
    iiG = null;
    iiH = null;
    iiI = false;
    iiJ = false;
    iiK = false;
    iiL = false;
    lat = 0.0D;
    lng = 0.0D;
    iiM = "";
    iiN = "";
    iiO = "";
    iiP = "";
    iiQ = "";
    iiR = false;
    iiS = false;
    iiT = false;
    iiU = 0;
    iiV = false;
    iiW = false;
    iiX = false;
    iiY = false;
    iiZ = false;
    ija = false;
    ijb = true;
    ijc = false;
    ijd = false;
    ije = "";
    ijf = 0;
    ijg = false;
    ijh = false;
    iji = -1;
    ijj = false;
    ijk = "";
    ijl = false;
    ijm = false;
    ijn = 5;
    ijo = 0;
    ijp = false;
    ijq = "";
    ijr = "";
    ijs = false;
    ijt = false;
    iju = "";
    ijv = "";
    ijw = false;
    ijx = false;
    ijy = false;
    ijz = false;
    ijA = new HashMap();
    ijB = false;
    ijC = false;
    ijD = false;
    GMTrace.o(13453313966080L, 100235);
  }
  
  public static void bf(int paramInt1, int paramInt2)
  {
    GMTrace.i(13453179748352L, 100234);
    synchronized (ijA)
    {
      ConcurrentLinkedQueue localConcurrentLinkedQueue2 = (ConcurrentLinkedQueue)ijA.get(Integer.valueOf(paramInt1));
      ConcurrentLinkedQueue localConcurrentLinkedQueue1 = localConcurrentLinkedQueue2;
      if (localConcurrentLinkedQueue2 == null)
      {
        localConcurrentLinkedQueue1 = new ConcurrentLinkedQueue();
        ijA.put(Integer.valueOf(paramInt1), localConcurrentLinkedQueue1);
      }
      localConcurrentLinkedQueue1.add(Integer.valueOf(paramInt2));
      GMTrace.o(13453179748352L, 100234);
      return;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/platformtools/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */