package no.hvl.dat109.expo.utils;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import no.hvl.dat109.expo.eao.AdminEAO;
import no.hvl.dat109.expo.eao.InstituteEAO;
import no.hvl.dat109.expo.eao.StandEAO;
import no.hvl.dat109.expo.eao.StudyEAO;
import no.hvl.dat109.expo.entities.Admin;
import no.hvl.dat109.expo.entities.Expo;
import no.hvl.dat109.expo.entities.Institute;
import no.hvl.dat109.expo.entities.Stand;
import no.hvl.dat109.expo.entities.Study;

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

	public static String editStandFromDoPost(HttpServletRequest request, StandEAO standEAO) {
		String standId = request.getParameter("standId");
		if(standId != null) {
			
			Stand stand = standEAO.findStand(standId);
			
			String choice = request.getParameter("editStand");
			
			
			if(choice != null) {
				
				
				if(choice.equals("edit")) {
					String newStandName = request.getParameter("standName");
					
					String standAuthors = request.getParameter("standAuthors");
					
					if(newStandName != null) {
						stand.setStandName(newStandName);
					}
					if(standAuthors != null) {
						stand.setAuthors(standAuthors);
					}
					
//					Part part = request.getPart("standPoster");
//					if(part != null) {
//						String path = getServletContext().getRealPath("img/standPosters/poster_2019_" + stand.getStandId() + ".png");
//				        File file = new File(path);
//				        FileUtils.copyInputStreamToFile(part.getInputStream(),file);
//					}
					
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

	public static String setupConfirmMessageForBaseAdminPage(HttpServletRequest request) {
		String change = request.getParameter("change");
		if(change != null) {
			if(change.equals("openedStandRegistration")) {
				return "Åpnet for registrering av stands!";
			} else if(change.equals("closedStandRegistration")) {
				return "Lukket for registrering av stands!";
			} else if(change.equals("openedVoteRegistration")) {
				return "Åpnet for registrering av stemmer!";
			} else if(change.equals("closedVoteRegistration")) {
				return "Lukket for registrering av stemmer!";
			} else if(change.equals("addedAdmin")) {
				return "La til ny admin!";
			}
			
		}
		return "";
	}

	public static String performBaseAdminTask(HttpServletRequest request, Expo expo, AdminEAO adminEAO) {
		String standChoice = request.getParameter("standRegistration");
		String voteChoice = request.getParameter("voteRegistration");
		
		/*
		 * Åpning og lukking foreløpig ikke implementert
		 */
		//TODO: Implementer åpning og lukking
		if(standChoice != null) {
			if(standChoice.equals("open")) {
				expo.setStandRegistrationOpen(true);
				return "openedStandRegistration";
			} else if (standChoice.equals("close")) {
				expo.setStandRegistrationOpen(false);
				return "closedStandRegistration";
			}
		}
		
		if(voteChoice != null) {
			if(voteChoice.equals("open")) {
				expo.setVoteRegistrationOpen(true);
				return "openedVoteRegistration";
			} else if(voteChoice.equals("close")) {
				expo.setVoteRegistrationOpen(false);
				return "closedVoteRegistration";
			}
		}
		
		String newAdmin = request.getParameter("newAdminName");
		String newAdminPass = request.getParameter("newAdminPass");
		if(newAdmin != null && newAdminPass != null) {
			adminEAO.addAdmin(new Admin(newAdmin, PasswordUtil.krypterPassord(newAdminPass)));
			return "addedAdmin";
		}
		
		return "";
	}

}
