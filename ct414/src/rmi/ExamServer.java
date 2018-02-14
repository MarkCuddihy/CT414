// ExamServer.java

package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.UUID;

public interface ExamServer extends Remote {

	// Return an access token that allows access to the server for some time period
	public UUID login(int studentid, String password) throws 
		UnauthorizedAccess, RemoteException;

	// Return a summary list of Assessments currently available for this studentid
	public List<String> getAvailableSummary(UUID token, int studentid) throws
		UnauthorizedAccess, NoMatchingAssessment, RemoteException;

	// Return an Assessment object associated with a particular course code
	public Assessment getAssessment(UUID token, int studentid, String courseCode) throws
		UnauthorizedAccess, NoMatchingAssessment, RemoteException;

	// Submit a completed assessment
	public void submitAssessment(UUID token, int studentid, Assessment completed) throws 
		UnauthorizedAccess, NoMatchingAssessment, RemoteException;

}

