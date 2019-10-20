package com.example.takeout.common;

import java.math.BigDecimal;

public class MapPoint {
     // 纬度
     private double lan;
     //经度
     private double lon;
     public MapPoint() { }
     public MapPoint(double lan, double lon) { this.lan = lan; this.lon = lon; }
     public double getLan() { return lan; }
     public void setLan(double lan) { this.lan = lan; }
     public double getLon() { return lon; }
     public void setLon(double lon) { this.lon = lon; }


    /**
     * 获取两个地点之间的距离,精确到小数点后两位km
     */ public static double getDistence(MapPoint start, MapPoint end) {
         // 得到起点经纬度,并转换为角度
         double startLon = (Math.PI / 180) * start.getLon(); double startLan = (Math.PI / 180) * start.getLan();
         // 得到终点经纬度,并转换为角度
         double endLon = (Math.PI / 180) * end.getLon(); double endtLan = (Math.PI / 180) * end.getLan();
         // 地球平均直径为12756km,半径为6378km
         double earthR = 6378;
         // 计算公式
         double distence = Math.acos(Math.sin(startLan) * Math.sin(endtLan) + Math.cos(startLan) * Math.cos(endtLan) * Math.cos(endLon - startLon)) * earthR;

         return BigDecimal.valueOf(distence).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
     }

}
