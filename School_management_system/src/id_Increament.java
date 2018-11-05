import java.sql.ResultSet;

public class id_Increament {
	
	public int id_Incrementable(){
	int id =1;
	
	java.sql.PreparedStatement prSt=null;
	
	ResultSet rS = null ;
	
	 
	try{
		prSt=three.connects().prepareStatement("SELECT MAX(id) FROM pooya_table");
		rS=prSt.executeQuery();
		while (rS.next()){
			id=rS.getInt(1) +1;
			
		}
		
	}catch(Exception e){
		System.err.println(e);
	}
	finally{
		try{
			rS.close();
			prSt.close();
			
		}catch(Exception e){
			System.err.println(e);
		}
	}

	return id;
}


	
}
