
public class System1<S1,S2> {
	
	private final S1 userId;
	private final S2 userPassword;
	
	public System1(S1 userId, S2 userPassword) {
		this.userId = userId;
		this.userPassword = userPassword; 
	}
	
	public S1 getUserId(){
		return userId;
	}
	
	public S2 getUserPassword(){
		return userPassword; 
	}
	
	

	}

