package com.tencent.mm.compatible.d;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.v;

public final class a
{
  public boolean gND;
  public int gNE;
  public int gNF;
  public int gNG;
  public int gNH;
  public int gNI;
  public int gNJ;
  public int gNK;
  public int gNL;
  public int gNM;
  public int gNN;
  public int gNO;
  public int gNP;
  public int gNQ;
  public int gNR;
  public int gNS;
  public int gNT;
  public int gNU;
  public int gNV;
  public int gNW;
  public int gNX;
  public int gNY;
  public int gNZ;
  public int gOA;
  public boolean gOB;
  public int gOC;
  public int gOD;
  public int gOE;
  public int gOF;
  public int gOG;
  public int gOH;
  public int gOI;
  public int gOJ;
  public int gOK;
  public int gOL;
  public int gOa;
  public int gOb;
  public int gOc;
  public int gOd;
  public int gOe;
  public int gOf;
  public int gOg;
  public boolean gOh;
  public int gOi;
  public int gOj;
  public int gOk;
  public int gOl;
  public int gOm;
  public int gOn;
  public int gOo;
  public int gOp;
  public int gOq;
  public int gOr;
  public int gOs;
  public int gOt;
  public int gOu;
  public int gOv;
  public int gOw;
  public short[] gOx;
  public short[] gOy;
  public boolean gOz;
  
  public a()
  {
    GMTrace.i(13807782985728L, 102876);
    this.gND = false;
    this.gOx = new short[15];
    this.gOy = new short[2];
    this.gOB = false;
    reset();
    GMTrace.o(13807782985728L, 102876);
  }
  
  public final void dump()
  {
    GMTrace.i(13809259380736L, 102887);
    v.d("VoipAudioInfo", "streamtype " + this.gNE);
    v.d("VoipAudioInfo", "smode " + this.gNF);
    v.d("VoipAudioInfo", "omode " + this.gNG);
    v.d("VoipAudioInfo", "ospeaker " + this.gNH);
    v.d("VoipAudioInfo", "operating" + this.gNI);
    v.d("VoipAudioInfo", "moperating" + this.gNJ);
    v.d("VoipAudioInfo", "mstreamtype" + this.gNK);
    v.d("VoipAudioInfo", "mVoiceRecordMode" + this.gNL);
    v.d("VoipAudioInfo", "agcMode :" + this.gOp);
    v.d("VoipAudioInfo", "nsMode:" + this.gNO);
    v.d("VoipAudioInfo", "aecMode:" + this.gNN);
    v.d("VoipAudioInfo", "volumMode:" + this.gNP);
    v.d("VoipAudioInfo", "micMode:" + this.gOa);
    v.d("VoipAudioInfo", "sourceMode:" + this.gOb);
    v.d("VoipAudioInfo", "speakerMode:" + this.gOc);
    v.d("VoipAudioInfo", "phoneMode:" + this.gOd);
    v.d("VoipAudioInfo", "voipstreamType:" + this.gOe);
    v.d("VoipAudioInfo", "speakerstreamtype:" + this.gOf);
    v.d("VoipAudioInfo", "phonestreamtype:" + this.gOg);
    v.d("VoipAudioInfo", "ringphonestream:" + this.gOi);
    v.d("VoipAudioInfo", "ringphonemode:" + this.gOj);
    v.d("VoipAudioInfo", "ringspeakerstream:" + this.gOk);
    v.d("VoipAudioInfo", "ringspeakermode:" + this.gOl);
    v.d("VoipAudioInfo", "agcModeNew :" + this.gOo);
    v.d("VoipAudioInfo", "nsModeNew:" + this.gOn);
    v.d("VoipAudioInfo", "aecModeNew:" + this.gOm);
    v.d("VoipAudioInfo", "agctargetdb:" + this.gOq);
    v.d("VoipAudioInfo", "agcgaindb:" + this.gOr);
    v.d("VoipAudioInfo", "agcflag:" + this.gOs);
    v.d("VoipAudioInfo", "agclimiter:" + this.gOt);
    v.d("VoipAudioInfo", "inputVolumeScale:" + this.gNQ);
    v.d("VoipAudioInfo", "outputVolumeScale:" + this.gNR);
    v.d("VoipAudioInfo", "inputVolumeScaleForSpeaker:" + this.gNS);
    v.d("VoipAudioInfo", "outputVolumeScaleForSpeaker:" + this.gNT);
    v.d("VoipAudioInfo", "ehanceHeadsetEC:" + this.gNW);
    v.d("VoipAudioInfo", "setECModeLevelForHeadSet:" + this.gNX);
    v.d("VoipAudioInfo", "setECModeLevelForSpeaker:" + this.gNY);
    v.d("VoipAudioInfo", "enableSpeakerEnhanceEC:" + this.gNZ);
    v.d("VoipAudioInfo", "enableRecTimer:" + this.gOu);
    v.d("VoipAudioInfo", "enablePlayTimer:" + this.gOv);
    v.d("VoipAudioInfo", "setPlayerPrecorrectCofOnOrOff:" + this.gOw);
    v.d("VoipAudioInfo", "outputVolumeGainForPhone:" + this.gNU);
    v.d("VoipAudioInfo", "outputVolumeGainForSpeaker:" + this.gNV);
    v.d("VoipAudioInfo", "noisegateon" + this.gOz);
    v.d("VoipAudioInfo", "noisegatestrength[0]" + this.gOy[0]);
    v.d("VoipAudioInfo", "noisegatestrength[1]" + this.gOy[1]);
    v.d("VoipAudioInfo", "spkecenable:" + this.gOA);
    v.d("VoipAudioInfo", "agcRxFlag:" + this.gOI);
    v.d("VoipAudioInfo", "agcRxTargetdb:" + this.gOJ);
    v.d("VoipAudioInfo", "agcRxGaindb:" + this.gOK);
    v.d("VoipAudioInfo", "agcRxLimiter:" + this.gOL);
    GMTrace.o(13809259380736L, 102887);
  }
  
  public final boolean qX()
  {
    GMTrace.i(13808051421184L, 102878);
    if (((this.gNF >= 0) && (this.gNG < 0)) || ((this.gNF < 0) && (this.gNG >= 0)) || (this.gNH > 0))
    {
      GMTrace.o(13808051421184L, 102878);
      return true;
    }
    GMTrace.o(13808051421184L, 102878);
    return false;
  }
  
  public final boolean qY()
  {
    GMTrace.i(13808185638912L, 102879);
    if (this.gNI >= 0)
    {
      GMTrace.o(13808185638912L, 102879);
      return true;
    }
    GMTrace.o(13808185638912L, 102879);
    return false;
  }
  
  public final boolean qZ()
  {
    GMTrace.i(13808319856640L, 102880);
    if (this.gNJ >= 0)
    {
      GMTrace.o(13808319856640L, 102880);
      return true;
    }
    GMTrace.o(13808319856640L, 102880);
    return false;
  }
  
  public final int ra()
  {
    GMTrace.i(13808454074368L, 102881);
    if (qY())
    {
      int i = (this.gNI & 0xE0) >> 5;
      v.d("VoipAudioInfo", "getEnableMode " + i);
      if (i == 7)
      {
        GMTrace.o(13808454074368L, 102881);
        return -1;
      }
      GMTrace.o(13808454074368L, 102881);
      return i;
    }
    GMTrace.o(13808454074368L, 102881);
    return -1;
  }
  
  public final boolean rb()
  {
    GMTrace.i(13808588292096L, 102882);
    if (qY())
    {
      int i = this.gNI & 0x10;
      StringBuilder localStringBuilder = new StringBuilder("enableSpeaker ");
      if (i > 0) {}
      for (boolean bool = true;; bool = false)
      {
        v.d("VoipAudioInfo", bool);
        if (i <= 0) {
          break;
        }
        GMTrace.o(13808588292096L, 102882);
        return true;
      }
      GMTrace.o(13808588292096L, 102882);
      return false;
    }
    GMTrace.o(13808588292096L, 102882);
    return false;
  }
  
  public final int rc()
  {
    GMTrace.i(13808722509824L, 102883);
    if (qY())
    {
      int i = (this.gNI & 0xE) >> 1;
      v.d("VoipAudioInfo", "getDisableMode " + i);
      if (i == 7)
      {
        GMTrace.o(13808722509824L, 102883);
        return -1;
      }
      GMTrace.o(13808722509824L, 102883);
      return i;
    }
    GMTrace.o(13808722509824L, 102883);
    return -1;
  }
  
  public final boolean rd()
  {
    GMTrace.i(13808856727552L, 102884);
    if (qY())
    {
      int i = this.gNI & 0x1;
      StringBuilder localStringBuilder = new StringBuilder("disableSpeaker ");
      if (i > 0) {}
      for (boolean bool = true;; bool = false)
      {
        v.d("VoipAudioInfo", bool);
        if (i <= 0) {
          break;
        }
        GMTrace.o(13808856727552L, 102884);
        return true;
      }
      GMTrace.o(13808856727552L, 102884);
      return false;
    }
    GMTrace.o(13808856727552L, 102884);
    return false;
  }
  
  public final int re()
  {
    GMTrace.i(13808990945280L, 102885);
    if (qZ())
    {
      int i = (this.gNJ & 0xE0) >> 5;
      v.d("VoipAudioInfo", "getEnableMode " + i);
      if (i == 7)
      {
        GMTrace.o(13808990945280L, 102885);
        return -1;
      }
      GMTrace.o(13808990945280L, 102885);
      return i;
    }
    GMTrace.o(13808990945280L, 102885);
    return -1;
  }
  
  public final void reset()
  {
    GMTrace.i(13807917203456L, 102877);
    this.gND = false;
    this.gNE = -1;
    this.gNF = -1;
    this.gNG = -1;
    this.gNH = -1;
    this.gNI = -1;
    this.gNJ = -1;
    this.gNK = -1;
    this.gNM = -1;
    this.gNL = -1;
    this.gOp = -1;
    this.gNN = -1;
    this.gNO = -1;
    this.gNP = -1;
    this.gOa = -1;
    this.gOb = -1;
    this.gOc = -1;
    this.gOd = -1;
    this.gOe = -1;
    this.gOf = -1;
    this.gOg = -1;
    this.gOh = false;
    this.gOi = -1;
    this.gOj = -1;
    this.gOl = -1;
    this.gOk = -1;
    this.gOo = -1;
    this.gOm = -1;
    this.gOn = -1;
    this.gOq = -1;
    this.gOr = -1;
    this.gOs = -1;
    this.gOt = -1;
    this.gNQ = -1;
    this.gNR = -1;
    this.gNS = -1;
    this.gNT = -1;
    this.gNW = -1;
    this.gNX = -1;
    this.gNY = -1;
    this.gNZ = -1;
    this.gOu = 0;
    this.gOv = 0;
    this.gOw = -1;
    this.gNV = -1;
    this.gNU = -1;
    this.gOz = false;
    this.gOy[0] = -1;
    this.gOy[1] = -1;
    this.gOA = -1;
    this.gOI = -1;
    this.gOJ = -1;
    this.gOK = -1;
    this.gOL = -1;
    GMTrace.o(13807917203456L, 102877);
  }
  
  public final int rf()
  {
    GMTrace.i(13809125163008L, 102886);
    if (qZ())
    {
      int i = (this.gNJ & 0xE) >> 1;
      v.d("VoipAudioInfo", "getDisableMode " + i);
      if (i == 7)
      {
        GMTrace.o(13809125163008L, 102886);
        return -1;
      }
      GMTrace.o(13809125163008L, 102886);
      return i;
    }
    GMTrace.o(13809125163008L, 102886);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/compatible/d/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */