
package rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

//
public class ExamEngine implements ExamServer {
	
	 // users accounts
	private static List<Student> Students = new ArrayList<Student>();
	//access token
	private UUID UUIDtoken = UUID.randomUUID();;
		
	// Constructor is required
	public ExamEngine() {
		super();
		//init students
		Students.add(new Student(000, "hunter2"));
		Students.add(new Student(001, "hunter2"));
		Students.add(new Student(002, "hunter2"));
		System.out.println("Students initialized");
	}

	// Implement the methods defined in the ExamServer interface...
	// Return an access token that allows access to the server for some time period
	public UUID login(int studentid, String password) throws 
	UnauthorizedAccess, RemoteException {

		// TBD: You need to implement this method!
		// For the moment method just returns an empty or null value to allow it to compile
		
		//find student
		int i = 0;
		while(Students.iterator().hasNext()) {
			if(Students.get(i).getId() == studentid){
				break;
			}
			i++;
		}
		//if no student found throw exception
		if(i>= Students.size())throw new UnauthorizedAccess("Invalid ID");
		
		//check students password
		if(Students.get(i).getPassword().equals(password)) {
			//return access token if correct
			System.out.println("User: "+studentid+" logged in successfully");
			return UUIDtoken;
		//else throw exception
		}else throw new UnauthorizedAccess("Invalid Password");
			
	}

	// Return a summary list of Assessments currently available for this studentid
	public List<String> getAvailableSummary(UUID token, int studentid) throws
	UnauthorizedAccess, NoMatchingAssessment, RemoteException {

		// TBD: You need to implement this method!
		// For the moment method just returns an empty or null value to allow it to compile

		//check access token
		if(token.equals(UUIDtoken)==false) {
			throw new UnauthorizedAccess("Invalid Access Token");
		}
		
		
		return null;
	}

	// Return an Assessment object associated with a particular course code
	public Assessment getAssessment(UUID token, int studentid, String courseCode) throws
	UnauthorizedAccess, NoMatchingAssessment, RemoteException {

		// TBD: You need to implement this method!
		// For the moment method just returns an empty or null value to allow it to compile

		return null;
	}

	// Submit a completed assessment
	public void submitAssessment(UUID token, int studentid, Assessment completed) throws 
	UnauthorizedAccess, NoMatchingAssessment, RemoteException {

		// TBD: You need to implement this method!
	}

	public static void main(String[] args) {
		//removed security manager to test
		/*if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}*/
		try {
			String name = "ExamServer";
			ExamServer engine = new ExamEngine();
			ExamServer stub =
					(ExamServer) UnicastRemoteObject.exportObject(engine, 0);
			Registry registry = LocateRegistry.getRegistry();
			registry.rebind(name, stub);
			System.out.println("ExamEngine bound");
		} catch (Exception e) {
			System.err.println("ExamEngine exception:");
			e.printStackTrace();
		}
	}
}
