package com.tencent.wework.api.model;

import android.os.Bundle;

public class WWMediaFile
  extends WWMediaMessage.WWMediaObject
{
  private int contentLengthLimit = 10485760;
  public byte[] fileData;
  public String filePath;
  public String fyw;
  
  public final boolean checkArgs()
  {
    if (!super.checkArgs()) {}
    while (((this.fileData == null) || (this.fileData.length == 0)) && ((this.filePath == null) || (this.filePath.length() == 0) || ((this.fileData != null) && (this.fileData.length > this.contentLengthLimit)) || ((this.filePath != null) && (getFileSize(this.filePath) > this.contentLengthLimit)))) {
      return false;
    }
    return true;
  }
  
  public final void toBundle(Bundle paramBundle)
  {
    paramBundle.putByteArray("_wwfileobject_fileData", this.fileData);
    paramBundle.putString("_wwfileobject_filePath", this.filePath);
    paramBundle.putString("_wwfileobject_fileName", this.fyw);
    super.toBundle(paramBundle);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/wework/api/model/WWMediaFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */