package shoutingMTServer;

import java.util.Date;

public class Measurement {


        private int stn;
        private Date date;
        private String time;
        private float temperature;
        private float stp;
        private float dew_point;
        private float sea_pressure;
        private float wind_speed;
        private float percipation;
        private float snow;
        private float visibility;
        private int occurances;
        private float citizenry;
        private int wind_direction;


        public float getPercipation() {
            return percipation;
        }

        public void setPercipation(float percipation) {
            this.percipation = percipation;
        }

        public int getStn() {
            return stn;
        }

        public void setStn(int stn) {
            this.stn = stn;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public float getTemperature() {
            return temperature;
        }

        public void setTemperature(float temperature) {
            this.temperature = temperature;
        }

        public float getDew_point() {
            return dew_point;
        }

        public void setDew_point(float dew_point) {
            this.dew_point = dew_point;
        }

        public float getSea_pressure() {
            return sea_pressure;
        }

        public void setSea_pressure(float sea_pressure) {
            this.sea_pressure = sea_pressure;
        }

        public float getWind_speed() {
            return wind_speed;
        }

        public void setWind_speed(float wind_speed) {
            this.wind_speed = wind_speed;
        }

        public float getSnow() {
            return snow;
        }

        public void setSnow(float snow) {
            this.snow = snow;
        }

        public int getOccurances() {
            return occurances;
        }

        public void setOccurances(int occurances) {
            this.occurances = occurances;
        }

        public float getCitizenry() {
            return citizenry;
        }

        public void setCitizenry(float citizenry) {
            this.citizenry = citizenry;
        }

        public int getWind_direction() {
            return wind_direction;
        }

        public void setWind_direction(int wind_direction) {
            this.wind_direction = wind_direction;
        }

    public float getStp() {
        return stp;
    }

    public void setStp(float stp) {
        this.stp = stp;
    }

    public float getVisibility() {
        return visibility;
    }

    public void setVisibility(float visibility) {
        this.visibility = visibility;
    }
}


