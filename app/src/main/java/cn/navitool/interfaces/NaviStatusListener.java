package cn.navitool.interfaces;

import java.util.List;
import org.json.JSONObject;
import cn.navitool.model.GuideInfo;
import cn.navitool.model.TrafficLightInfo;

public interface NaviStatusListener {
    void onNaviStatusChanged(int status); // IDLE, NAVI, CRUISE
    void onTrafficLightUpdate(List<TrafficLightInfo> lights);
    void onGuideInfoUpdate(GuideInfo info);
    void onOriginalPacketReceived(String json, JSONObject parsed); // 用于记录器
}
