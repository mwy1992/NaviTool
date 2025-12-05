package com.ecarx.xui.adaptapi.navigation.ehp.v2;

import com.ecarx.xui.adaptapi.navigation.ehp.v2.profile.IProfShortValue;

public interface IHznProfShoMessage extends IV2Message {
  int Offset();
  
  int getAccuracy();
  
  int getDistance1();
  
  int getPathIndex();
  
  IProfShortValue getValue0();
  
  int getValue1();
  
  int isControlPoint();
  
  int isRetransmission();
  
  int isUpdate();
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\navigation\ehp\v2\IHznProfShoMessage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */