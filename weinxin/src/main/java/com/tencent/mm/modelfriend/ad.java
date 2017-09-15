package com.tencent.mm.modelfriend;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;

public final class ad
{
  public String fER;
  int fRM;
  public long hBJ;
  public int hBK;
  int hBL;
  String hBM;
  String hBN;
  String hBO;
  String hBP;
  String hBQ;
  public String hBR;
  String hBS;
  String hBT;
  String hre;
  String hrf;
  public int hrg;
  public int hrh;
  public String username;
  
  public ad()
  {
    GMTrace.i(4420460871680L, 32935);
    this.fRM = -1;
    this.hBJ = 0L;
    this.hBK = 0;
    this.hBL = 0;
    this.username = "";
    this.fER = "";
    this.hBM = "";
    this.hBN = "";
    this.hBO = "";
    this.hBP = "";
    this.hBQ = "";
    this.hBR = "";
    this.hBS = "";
    this.hBT = "";
    this.hre = "";
    this.hrf = "";
    this.hrg = 0;
    this.hrh = 0;
    GMTrace.o(4420460871680L, 32935);
  }
  
  public final ContentValues FP()
  {
    GMTrace.i(4420729307136L, 32937);
    ContentValues localContentValues = new ContentValues();
    if ((this.fRM & 0x1) != 0) {
      localContentValues.put("qq", Long.valueOf(this.hBJ));
    }
    int i;
    if ((this.fRM & 0x2) != 0)
    {
      i = this.hBK;
      if (i == 0) {
        localContentValues.put("wexinstatus", Integer.valueOf(65536));
      }
    }
    else
    {
      if ((this.fRM & 0x4) != 0) {
        localContentValues.put("groupid", Integer.valueOf(this.hBL));
      }
      if ((this.fRM & 0x8) != 0) {
        localContentValues.put("username", getUsername());
      }
      if ((this.fRM & 0x10) != 0) {
        localContentValues.put("nickname", FQ());
      }
      if ((this.fRM & 0x20) != 0)
      {
        if (this.hBM != null) {
          break label406;
        }
        str = "";
        label149:
        localContentValues.put("pyinitial", str);
      }
      if ((this.fRM & 0x40) != 0)
      {
        if (this.hBN != null) {
          break label414;
        }
        str = "";
        label176:
        localContentValues.put("quanpin", str);
      }
      if ((this.fRM & 0x80) != 0) {
        localContentValues.put("qqnickname", FR());
      }
      if ((this.fRM & 0x100) != 0) {
        localContentValues.put("qqpyinitial", FS());
      }
      if ((this.fRM & 0x200) != 0) {
        localContentValues.put("qqquanpin", FT());
      }
      if ((this.fRM & 0x400) != 0) {
        localContentValues.put("qqremark", FU());
      }
      if ((this.fRM & 0x800) != 0) {
        localContentValues.put("qqremarkpyinitial", FV());
      }
      if ((this.fRM & 0x1000) != 0) {
        localContentValues.put("qqremarkquanpin", FW());
      }
      if ((this.fRM & 0x4000) != 0) {
        if (this.hrf != null) {
          break label422;
        }
      }
    }
    label406:
    label414:
    label422:
    for (String str = "";; str = this.hrf)
    {
      localContentValues.put("reserved2", str);
      if ((this.fRM & 0x8000) != 0) {
        localContentValues.put("reserved3", Integer.valueOf(this.hrg));
      }
      if ((this.fRM & 0x10000) != 0) {
        localContentValues.put("reserved4", Integer.valueOf(this.hrh));
      }
      GMTrace.o(4420729307136L, 32937);
      return localContentValues;
      localContentValues.put("wexinstatus", Integer.valueOf(i));
      break;
      str = this.hBM;
      break label149;
      str = this.hBN;
      break label176;
    }
  }
  
  public final String FQ()
  {
    GMTrace.i(4420997742592L, 32939);
    if (this.fER == null)
    {
      GMTrace.o(4420997742592L, 32939);
      return "";
    }
    String str = this.fER;
    GMTrace.o(4420997742592L, 32939);
    return str;
  }
  
  public final String FR()
  {
    GMTrace.i(4421131960320L, 32940);
    if (this.hBO == null)
    {
      GMTrace.o(4421131960320L, 32940);
      return "";
    }
    String str = this.hBO;
    GMTrace.o(4421131960320L, 32940);
    return str;
  }
  
  public final String FS()
  {
    GMTrace.i(4421266178048L, 32941);
    if (this.hBP == null)
    {
      GMTrace.o(4421266178048L, 32941);
      return "";
    }
    String str = this.hBP;
    GMTrace.o(4421266178048L, 32941);
    return str;
  }
  
  public final String FT()
  {
    GMTrace.i(4421400395776L, 32942);
    if (this.hBQ == null)
    {
      GMTrace.o(4421400395776L, 32942);
      return "";
    }
    String str = this.hBQ;
    GMTrace.o(4421400395776L, 32942);
    return str;
  }
  
  public final String FU()
  {
    GMTrace.i(4421534613504L, 32943);
    if (this.hBR == null)
    {
      GMTrace.o(4421534613504L, 32943);
      return "";
    }
    String str = this.hBR;
    GMTrace.o(4421534613504L, 32943);
    return str;
  }
  
  public final String FV()
  {
    GMTrace.i(4421668831232L, 32944);
    if (this.hBS == null)
    {
      GMTrace.o(4421668831232L, 32944);
      return "";
    }
    String str = this.hBS;
    GMTrace.o(4421668831232L, 32944);
    return str;
  }
  
  public final String FW()
  {
    GMTrace.i(4421803048960L, 32945);
    if (this.hBT == null)
    {
      GMTrace.o(4421803048960L, 32945);
      return "";
    }
    String str = this.hBT;
    GMTrace.o(4421803048960L, 32945);
    return str;
  }
  
  public final void FX()
  {
    GMTrace.i(4422071484416L, 32947);
    this.hrg |= 0x1;
    GMTrace.o(4422071484416L, 32947);
  }
  
  public final void b(Cursor paramCursor)
  {
    GMTrace.i(4420595089408L, 32936);
    this.hBJ = paramCursor.getLong(0);
    int i = paramCursor.getInt(1);
    if (i == 65536) {}
    for (this.hBK = 0;; this.hBK = i)
    {
      this.hBL = paramCursor.getInt(2);
      this.username = paramCursor.getString(3);
      this.fER = paramCursor.getString(4);
      this.hBM = paramCursor.getString(5);
      this.hBN = paramCursor.getString(6);
      this.hBO = paramCursor.getString(7);
      this.hBP = paramCursor.getString(8);
      this.hBQ = paramCursor.getString(9);
      this.hBR = paramCursor.getString(10);
      this.hBS = paramCursor.getString(11);
      this.hBT = paramCursor.getString(12);
      this.hre = paramCursor.getString(13);
      this.hrf = paramCursor.getString(14);
      this.hrg = paramCursor.getInt(15);
      this.hrh = paramCursor.getInt(16);
      GMTrace.o(4420595089408L, 32936);
      return;
    }
  }
  
  public final String getDisplayName()
  {
    GMTrace.i(4421937266688L, 32946);
    if ((FU() == null) || (FU().length() <= 0))
    {
      str = FR();
      GMTrace.o(4421937266688L, 32946);
      return str;
    }
    String str = FU();
    GMTrace.o(4421937266688L, 32946);
    return str;
  }
  
  public final String getUsername()
  {
    GMTrace.i(4420863524864L, 32938);
    if (this.username == null)
    {
      GMTrace.o(4420863524864L, 32938);
      return "";
    }
    String str = this.username;
    GMTrace.o(4420863524864L, 32938);
    return str;
  }
  
  public final String toString()
  {
    GMTrace.i(4422205702144L, 32948);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("groupID\t:").append(this.hBL).append("\n");
    ((StringBuilder)localObject).append("qq\t:").append(this.hBJ).append("\n");
    ((StringBuilder)localObject).append("username\t:").append(this.username).append("\n");
    ((StringBuilder)localObject).append("nickname\t:").append(this.fER).append("\n");
    ((StringBuilder)localObject).append("wexinStatus\t:").append(this.hBK).append("\n");
    ((StringBuilder)localObject).append("reserved3\t:").append(this.hrg).append("\n");
    ((StringBuilder)localObject).append("reserved4\t:").append(this.hrh).append("\n");
    localObject = ((StringBuilder)localObject).toString();
    GMTrace.o(4422205702144L, 32948);
    return (String)localObject;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelfriend/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */