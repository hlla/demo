package com.tencent.wework.api.model;

import android.os.Bundle;

public class WWMediaConversation
  extends WWMediaMessage.WWMediaObject
{
  public long date;
  public String lKS;
  public String name;
  public byte[] xjV;
  public WWMediaMessage.WWMediaObject xjW;
  
  public final boolean checkArgs()
  {
    if (!super.checkArgs()) {}
    while (((this.xjV != null) && (this.xjV.length > 10485760)) || ((this.lKS != null) && (this.lKS.length() > 10240)) || ((this.lKS != null) && (getFileSize(this.lKS) > 10485760)) || (this.xjW == null) || (!this.xjW.checkArgs())) {
      return false;
    }
    return true;
  }
  
  public final void toBundle(Bundle paramBundle)
  {
    super.toBundle(paramBundle);
    paramBundle.putString("_wwconvobject_name", this.name);
    paramBundle.putLong("_wwconvobject_date", this.date);
    paramBundle.putByteArray("_wwconvobject_avatarData", this.xjV);
    paramBundle.putString("_wwconvobject_avatarPath", this.lKS);
    paramBundle.putBundle("_wwconvobject_message", BaseMessage.b(this.xjW));
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/wework/api/model/WWMediaConversation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */