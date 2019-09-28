package com.turan.po;

import java.io.Serializable;
import java.util.Date;

/**
 * gps_info
 * @author 
 */
public class GpsInfo implements Serializable {
    /**
     * 自增主键
     */
    private Long id;

    /**
     * 记录唯一编号
     */
    private Long gpsNo;

    /**
     * 车辆id
     */
    private Long vehicleNo;

    /**
     * 报警标志
     */
    private Integer alarmMark;

    /**
     * 状态位
     */
    private Integer statusBit;

    /**
     * 纬度
     */
    private Integer latitude;

    /**
     * 经度
     */
    private Integer longitude;

    /**
     * 高程
     */
    private Integer height;

    /**
     * 速度
     */
    private Integer speed;

    /**
     * 方向
     */
    private Integer direction;

    /**
     * 时间
     */
    private Date time;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGpsNo() {
        return gpsNo;
    }

    public void setGpsNo(Long gpsNo) {
        this.gpsNo = gpsNo;
    }

    public Long getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(Long vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public Integer getAlarmMark() {
        return alarmMark;
    }

    public void setAlarmMark(Integer alarmMark) {
        this.alarmMark = alarmMark;
    }

    public Integer getStatusBit() {
        return statusBit;
    }

    public void setStatusBit(Integer statusBit) {
        this.statusBit = statusBit;
    }

    public Integer getLatitude() {
        return latitude;
    }

    public void setLatitude(Integer latitude) {
        this.latitude = latitude;
    }

    public Integer getLongitude() {
        return longitude;
    }

    public void setLongitude(Integer longitude) {
        this.longitude = longitude;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Integer getDirection() {
        return direction;
    }

    public void setDirection(Integer direction) {
        this.direction = direction;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        GpsInfo other = (GpsInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getGpsNo() == null ? other.getGpsNo() == null : this.getGpsNo().equals(other.getGpsNo()))
            && (this.getVehicleNo() == null ? other.getVehicleNo() == null : this.getVehicleNo().equals(other.getVehicleNo()))
            && (this.getAlarmMark() == null ? other.getAlarmMark() == null : this.getAlarmMark().equals(other.getAlarmMark()))
            && (this.getStatusBit() == null ? other.getStatusBit() == null : this.getStatusBit().equals(other.getStatusBit()))
            && (this.getLatitude() == null ? other.getLatitude() == null : this.getLatitude().equals(other.getLatitude()))
            && (this.getLongitude() == null ? other.getLongitude() == null : this.getLongitude().equals(other.getLongitude()))
            && (this.getHeight() == null ? other.getHeight() == null : this.getHeight().equals(other.getHeight()))
            && (this.getSpeed() == null ? other.getSpeed() == null : this.getSpeed().equals(other.getSpeed()))
            && (this.getDirection() == null ? other.getDirection() == null : this.getDirection().equals(other.getDirection()))
            && (this.getTime() == null ? other.getTime() == null : this.getTime().equals(other.getTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getGpsNo() == null) ? 0 : getGpsNo().hashCode());
        result = prime * result + ((getVehicleNo() == null) ? 0 : getVehicleNo().hashCode());
        result = prime * result + ((getAlarmMark() == null) ? 0 : getAlarmMark().hashCode());
        result = prime * result + ((getStatusBit() == null) ? 0 : getStatusBit().hashCode());
        result = prime * result + ((getLatitude() == null) ? 0 : getLatitude().hashCode());
        result = prime * result + ((getLongitude() == null) ? 0 : getLongitude().hashCode());
        result = prime * result + ((getHeight() == null) ? 0 : getHeight().hashCode());
        result = prime * result + ((getSpeed() == null) ? 0 : getSpeed().hashCode());
        result = prime * result + ((getDirection() == null) ? 0 : getDirection().hashCode());
        result = prime * result + ((getTime() == null) ? 0 : getTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", gpsNo=").append(gpsNo);
        sb.append(", vehicleNo=").append(vehicleNo);
        sb.append(", alarmMark=").append(alarmMark);
        sb.append(", statusBit=").append(statusBit);
        sb.append(", latitude=").append(latitude);
        sb.append(", longitude=").append(longitude);
        sb.append(", height=").append(height);
        sb.append(", speed=").append(speed);
        sb.append(", direction=").append(direction);
        sb.append(", time=").append(time);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}