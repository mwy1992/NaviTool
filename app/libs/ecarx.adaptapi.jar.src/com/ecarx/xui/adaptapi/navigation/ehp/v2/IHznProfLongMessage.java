package com.ecarx.xui.adaptapi.navigation.ehp.v2;

import com.ecarx.xui.adaptapi.navigation.ehp.v2.profile.IProfLongValue;

public interface IHznProfLongMessage extends IV2Message {
  int getOffset();
  
  int getPathIndex();
  
  IProfLongValue getProfileValue();
  
  int isControlPoint();
  
  int isRetransmission();
  
  int isUpdate();
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\navigation\ehp\v2\IHznProfLongMessage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */