package no.hvl.dat109.expo.utils;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.apache.commons.io.FileUtils;

import no.hvl.dat109.expo.eao.AdminEAO;
import no.hvl.dat109.expo.eao.ExpoEAO;
import no.hvl.dat109.expo.eao.InstituteEAO;
import no.hvl.dat109.expo.eao.StandEAO;
import no.hvl.dat109.expo.eao.StudyEAO;
import no.hvl.dat109.expo.entities.Admin;
import no.hvl.dat109.expo.entities.Expo;
import no.hvl.dat109.expo.entities.Institute;
import no.hvl.dat109.expo.entities.Stand;
import no.hvl.dat109.expo.entities.Study;
import no.hvl.dat109.expo.servlet.admin.AdminEditStandServlet;

@MultipartConfig
public class AdminTasks {

	public static String setupMessageConfirmingStandEdit(HttpServletRequest request) {
		String edited = request.getParameter("edit");
		if(edited != null) {
			if(edited.equals("edited")) {
				return "Endringene er lagret!";
			} else {
				//edited.equals("deleted")
				return "Stand fjernet fra databasen!";
			}
		} else {
			return "";
		}
	}

	public static void makeBrowseSelection(HttpServletRequest request, StandEAO standEAO, InstituteEAO instituteEAO,
			StudyEAO studyEAO) {
		String selectedInstitute = request.getParameter("selectedInstitute");
		String selectedStudy = request.getParameter("selectedStudy");
		
		List<Stand> currentStands = standEAO.findAllStand();
		
		request.setAttribute("studies",studyEAO.findAllStudy());
		request.setAttribute("institutes", instituteEAO.findAllInstitute());

		
		if(selectedInstitute != null && !selectedInstitute.equals("all")) {
			Institute selectedInst = instituteEAO.findInstitute(selectedInstitute);
			
			request.setAttribute("selectedInst", selectedInst);
			
			currentStands = selectedInst.getStudies().stream().
							flatMap(s -> s.getStands().stream()).collect(Collectors.toList());
			
		}
		if(selectedStudy != null && !selectedStudy.equals("all")) {
			Study selectedStud = studyEAO.findStudy(selectedStudy);
			request.setAttribute("selectedStud", selectedStud);
			
			currentStands = selectedStud.getStands();
		}
		
		request.setAttribute("currentStands", currentStands);
		
	}

	public static String editStandFromDoPost(HttpServletRequest request, StandEAO standEAO, StudyEAO studyEAO) {
		String standId = request.getParameter("standId");
		String newStandName = request.getParameter("standName");
		String standAuthors = request.getParameter("standAuthors");
		String selectedStudy = request.getParameter("selectedStudy");
		String choice = request.getParameter("editStand"); //Valgt mellom å redigere eller slette stand

		if(standId != null) {
			
			Stand stand = standEAO.findStand(standId);

			if(choice != null) {

				if(choice.equals("edit")) {

					if(newStandName != null) {
						stand.setStandName(newStandName);
					}
					if(standAuthors != null) {
						stand.setAuthors(standAuthors);
					}
					if(selectedStudy != null) {
						stand.setStudy(studyEAO.findStudy(selectedStudy));
					}
					try{
						Part part = request.getPart("standPoster");
						String year = standEAO.findStand(standId).getExpo().getExpoid();
						if(part != null) {
							String path = request.getServletContext().getRealPath("img/standPosters/poster_" + year + "_" + stand.getStandId() + ".png");
							File file = new File(path);
//							try (InputStream input = part.getInputStream()){
//						        Files.copy(input, file.toPath());
//						    }
							FileUtils.copyInputStreamToFile(part.getInputStream(),file);
						}
					}catch (Exception e){
						e.printStackTrace();
					}
					standEAO.updateStand(stand);
					return "edited";
				} else {
					//choice.equals("delete")
					standEAO.deleteStand(stand);
					return "deleted";
				}
			} 
		}
		return "";
		
	}
	
	private static final String openedStandRegistration = "openedStandRegistration";
	private static final String closedStandRegistration = "closedStandRegistration";
	private static final String openedVoteRegistration = "openedVoteRegistration";
	private static final String closedVoteRegistration = "closedVoteRegistration";
	private static final String addedAdmin = "addedAdmin";
	private static final String turnedVisitorRegistrationOn = "turnedVisitorRegistrationOn";
	private static final String turnedVisitorRegistrationOff = "turnedVisitorRegistrationOff";
	private static final String openedStatisticsToPublic = "openedStatistics";
	private static final String closedStatisticsToPublic = "closedStatistics";

	public static String setupConfirmMessageForBaseAdminPage(HttpServletRequest request) {
		String change = request.getParameter("change");
		if(change != null) {
			if(change.equals(openedStandRegistration)) {
				return "Åpnet for registrering av stands!";
			} else if(change.equals(closedStandRegistration)) {
				return "Lukket for registrering av stands!";
			} else if(change.equals(openedVoteRegistration)) {
				return "Åpnet for registrering av stemmer!";
			} else if(change.equals(closedVoteRegistration)) {
				return "Lukket for registrering av stemmer!";
			} else if(change.equals(addedAdmin)) {
				return "La til ny admin!";
			} else if(change.equals(turnedVisitorRegistrationOn)) {
				return "Besøkende må nå registrere seg!";
			} else if(change.equals(turnedVisitorRegistrationOff)) {
				return "Besøkende må nå IKKE registrere seg!";
			} else if(change.equals(openedStatisticsToPublic)) {
				return "Åpnet visning av resultater til publikum!";
			} else if(change.equals(closedStatisticsToPublic)) {
				return "Lukket visning av resultater til publikum!";
			}
			
		}
		return "";
	}

	public static String performBaseAdminTask(HttpServletRequest request, Expo expo, AdminEAO adminEAO, ExpoEAO expoEAO) {
		String standChoice = request.getParameter("standRegistration");
		String voteChoice = request.getParameter("voteRegistration");
		String registrationChoice = request.getParameter("visitorRegistration");
		String statisticsChoice = request.getParameter("openStatistics");
		
		String returnString = "";
		
		/*
		 * Åpning og lukking foreløpig ikke implementert
		 */
		//TODO: Implementer åpning og lukking
		if(standChoice != null) {
			if(standChoice.equals("open")) {
				expo.setStandRegistrationOpen(true);
				returnString = openedStandRegistration;
			} else if (standChoice.equals("close")) {
				expo.setStandRegistrationOpen(false);
				returnString = closedStandRegistration;
			}
		}
		
		if(voteChoice != null) {
			if(voteChoice.equals("open")) {
				expo.setVoteRegistrationOpen(true);
				returnString = openedVoteRegistration;
			} else if(voteChoice.equals("close")) {
				expo.setVoteRegistrationOpen(false);
				returnString = closedVoteRegistration;
			}
		}
		
		if(registrationChoice != null) {
			if(registrationChoice.equals("turnOn")) {
				expo.setVerificationRequired(true);
				returnString = turnedVisitorRegistrationOn;
			} else if(registrationChoice.equals("turnOff")) {
				expo.setVerificationRequired(false);
				returnString = turnedVisitorRegistrationOff;
			}
		}
		
		if(statisticsChoice != null) {
			if(statisticsChoice.equals("open")) {
				expo.setStatisticsOpenToPublic(true);
				returnString = openedStatisticsToPublic;
			} else if(statisticsChoice.equals("close")) {
				expo.setStatisticsOpenToPublic(false);
				returnString = closedStatisticsToPublic;
			}
		}
		
		String newAdmin = request.getParameter("newAdminName");
		String newAdminPass = request.getParameter("newAdminPass");
		if(newAdmin != null && newAdminPass != null) {
			adminEAO.addAdmin(new Admin(newAdmin, PasswordUtil.krypterPassord(newAdminPass)));
			returnString = addedAdmin;
		}
		expo = expoEAO.updateExpo(expo);
		
		return returnString;
	}

	public static void setupStandEdit(HttpServletRequest request, Stand stand, StudyEAO studyEAO,
			InstituteEAO instituteEAO) {
		
		request.setAttribute("time",System.currentTimeMillis());
		request.setAttribute("studies",studyEAO.findAllStudy());
		request.setAttribute("institutes", instituteEAO.findAllInstitute());
		
		request.setAttribute("stand", stand);
		
	}



}
