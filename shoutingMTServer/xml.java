package shoutingMTServer;

public class xml {
	
	public int stn_id;
	public String date_measurement;
	public String time_measurement;
	public float temperature;
	public float dew_point;
	public float sea_pressure;
	public float visibilty;
	public float wind_speed;
	public float precipation;
	public float snow;
	public int occurances;
	public float citizenry;
	public int wind_direction;
	
	public void dataclass(int stn_id,String date_measurement,String time_measurement,float temperature, 
			float dew_point,float sea_pressure,float visibilty,float wind_speed,float precipation,float snow,
			int occurances,float citizenry,int wind_direction){
		
		this.stn_id = stn_id;
		this.date_measurement = date_measurement;
		this.time_measurement = time_measurement;
		this.temperature = temperature;
		this.dew_point = dew_point;
		this.sea_pressure = sea_pressure;
		this.visibilty = visibilty;
		this.wind_speed = wind_speed;
		this.precipation = precipation;
		this.snow = snow;
		this.occurances = occurances;
		this.citizenry = citizenry;
		this.wind_direction = wind_direction;
	}
	
	
	
}
