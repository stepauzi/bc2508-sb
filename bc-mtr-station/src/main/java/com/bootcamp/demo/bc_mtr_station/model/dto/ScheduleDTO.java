package com.bootcamp.demo.bc_mtr_station.model.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ScheduleDTO {
  @JsonProperty("sys_time")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime sysTime;
  @JsonProperty("curr_time")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime currTime;

  @JsonProperty("isdelay")
  private String isDelay;
  private Long status;
  private String message;

  @JsonProperty("data")
  private Map<String, StationInfo> stationMap;

  @Getter
  public static class StationInfo {
    @JsonProperty("sys_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime sysTime;
    @JsonProperty("curr_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime currTime;
    @JsonProperty("UP")
    private List<TrainInfo> upTrains;
    @JsonProperty("DOWN")
    private List<TrainInfo> downTrains;

    @Getter
    public static class TrainInfo {
      private String seq;
      private String dest;
      private String plat;
      @JsonProperty(value = "time")
      @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
      private LocalDateTime arrivalTime;
      private String ttnt;
      private String valid;
      private String source;
    }
  }

}
