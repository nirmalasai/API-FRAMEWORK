package POJOClassForSerializationAndDeserialization;

public class Spouse {

		String spName;
		String spEmail;
		int id;
		long phNumber;
		
		
		public Spouse(String spName, String spEmail, int id, long phNumber) {
			super();
			this.spName = spName;
			this.spEmail = spEmail;
			this.id = id;
			this.phNumber = phNumber;
		}
		
		
		public Spouse() {
			super();
		}


		public String getSpName() {
			return spName;
		}
		public void setSpName(String spName) {
			this.spName = spName;
		}
		public String getSpEmail() {
			return spEmail;
		}
		public void setSpEmail(String spEmail) {
			this.spEmail = spEmail;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public long getPhNumber() {
			return phNumber;
		}
		public void setPhNumber(long phNumber) {
			this.phNumber = phNumber;
		}
	

}
