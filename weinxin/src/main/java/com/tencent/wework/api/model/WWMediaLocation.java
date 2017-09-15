package com.tencent.wework.api.model;

import android.os.Bundle;

public class WWMediaLocation
  extends WWMediaMessage.WWMediaObject
{
  public String hCm;
  public double latitude;
  public double longitude;
  public double xjX;
  
  public final boolean checkArgs()
  {
    if (!super.checkArgs()) {}
    while ((this.hCm == null) || (this.hCm.length() == 0) || (this.hCm.length() > 10240)) {
      return false;
    }
    return true;
  }
  
  public final void toBundle(Bundle paramBundle)
  {
    paramBundle.putString("_wwlocobject_address", this.hCm);
    paramBundle.putDouble("_wwlocobject_longitude", this.longitude);
    paramBundle.putDouble("_wwlocobject_latitude", this.latitude);
    paramBundle.putDouble("_wwlocobject_zoom", this.xjX);
    super.toBundle(paramBundle);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/wework/api/model/WWMediaLocation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */