package shoutingMTServer;

import java.util.Date;

public class Measurement {


        private String stn;
        private String date;
        private String time;
        private String temperature;
        private String stp;
        private String dew_point;
        private String sea_pressure;
        private String wind_speed;
        private String percipation;
        private String snow;
        private String visibility;
        private String occurances;
        private String citizenry;
        private String wind_direction;


        public String getPercipation() {
            return percipation;
        }

        public void setPercipation(String percipation) {
            this.percipation = percipation;
        }

        public String getStn() {
            return stn;
        }

        public void setStn(String stn) {
            this.stn = stn;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getTemperature() {
            return temperature;
        }

        public void setTemperature(String temperature) {
            this.temperature = temperature;
        }

        public String getDew_point() {
            return dew_point;
        }

        public void setDew_point(String dew_point) {
            this.dew_point = dew_point;
        }

        public String getSea_pressure() {
            return sea_pressure;
        }

        public void setSea_pressure(String sea_pressure) {
            this.sea_pressure = sea_pressure;
        }

        public String getWind_speed() {
            return wind_speed;
        }

        public void setWind_speed(String wind_speed) {
            this.wind_speed = wind_speed;
        }

        public String getSnow() {
            return snow;
        }

        public void setSnow(String snow) {
            this.snow = snow;
        }

        public String getOccurances() {
            return occurances;
        }

        public void setOccurances(String occurances) {
            this.occurances = occurances;
        }

        public String getCitizenry() {
            return citizenry;
        }

        public void setCitizenry(String citizenry) {
            this.citizenry = citizenry;
        }

        public String getWind_direction() {
            return wind_direction;
        }

        public void setWind_direction(String wind_direction) {
            this.wind_direction = wind_direction;
        }

    public String getStp() {
        return stp;
    }

    public void setStp(String stp) {
        this.stp = stp;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }
}


