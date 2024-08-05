package com.sambit.event.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sambit.event.management.model.Chat;
import com.sambit.event.management.model.Invitation;
import com.sambit.event.management.model.Project;
import com.sambit.event.management.model.User;
import com.sambit.event.management.request.InviteRequest;
import com.sambit.event.management.response.MessageResponse;
import com.sambit.event.management.service.InvitationService;
import com.sambit.event.management.service.ProjectService;
import com.sambit.event.management.service.UserService;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private InvitationService invitationService;
	
	@GetMapping
	public ResponseEntity<List<Project>>getProjects(
			@RequestParam(required = false) String category,
			@RequestParam(required = false) String tag,
			@RequestParam("Authorization") String jwt
	) throws Exception{
		User user = userService.findUserProfileByJwt(jwt);
		List<Project> projects = projectService.getProjectByTeam(user, category, tag);
		return new ResponseEntity<>(projects,HttpStatus.OK);
	}
	
	@GetMapping("/projetId")
	public ResponseEntity<Project>getProjectById(
			@PathVariable Long projectId,
			@RequestParam("Authorization") String jwt
	) throws Exception{
		User user = userService.findUserProfileByJwt(jwt);
		Project project = projectService.getProjectById(projectId);
		return new ResponseEntity<>(project,HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<Project>createProject(
			@RequestHeader("Authorization") String jwt,
			@RequestBody Project project
	) throws Exception{
		User user = userService.findUserProfileByJwt(jwt);
		Project createdProject = projectService.createProject(project, user);
		return new ResponseEntity<>(createdProject,HttpStatus.OK);
	}
	
	@PatchMapping("/{projectId}")
	public ResponseEntity<Project>updateProject(
			@PathVariable Long projectId,
			@RequestParam("Authorization") String jwt,
			@RequestBody Project project
	) throws Exception{
		User user = userService.findUserProfileByJwt(jwt);
		Project updatedProject = projectService.updatedProject(project, projectId);
		return new ResponseEntity<>(updatedProject,HttpStatus.OK);
	}
	
	@DeleteMapping("/{projectId}")
	public ResponseEntity<MessageResponse>deleteProject(
			@PathVariable Long projectId,
			@RequestParam("Authorization") String jwt
	) throws Exception{
		User user = userService.findUserProfileByJwt(jwt);
		projectService.deleteProject(projectId, user.getId());
		MessageResponse res = new MessageResponse("Project Deleted Successfully..!");
		return new ResponseEntity<>(res,HttpStatus.OK);
	}
	
	@GetMapping("/search")
	public ResponseEntity<List<Project>>searchProjects(
			@RequestParam(required = false) String keyword,
			@RequestParam("Authorization") String jwt
	) throws Exception{
		User user = userService.findUserProfileByJwt(jwt);
		List<Project> projects = projectService.searchProjects(keyword, user);
		return new ResponseEntity<>(projects,HttpStatus.OK);
	}
	
	@GetMapping("/{projectId}/chat")
	public ResponseEntity<Chat>getChatByProjectId(
			@PathVariable Long projectId,
			@RequestParam("Authorization") String jwt
	) throws Exception{
		User user = userService.findUserProfileByJwt(jwt);
		Chat chat = projectService.getChatByProjectId(projectId);
		return new ResponseEntity<>(chat,HttpStatus.OK);
	}
	
	@PostMapping("/invite")
	public ResponseEntity<MessageResponse>inviteProject(
			@RequestBody InviteRequest inviteRequest,
			@RequestParam("Authorization") String jwt,
			@RequestBody Project project
	) throws Exception{
		User user = userService.findUserProfileByJwt(jwt);
		invitationService.sendsInvitation(inviteRequest.getEmail(), inviteRequest.getProjectId());
		MessageResponse messageResponse = new MessageResponse("Invitaion Sent Successfully..!");
		return new ResponseEntity<>(messageResponse,HttpStatus.OK);
	}
	@GetMapping("/accept_invitation")
	public ResponseEntity<Invitation>acceptInvitaion(
			@RequestParam String token,
			@RequestParam("Authorization") String jwt,
			@RequestBody Project project
	) throws Exception{
		User user = userService.findUserProfileByJwt(jwt);
		Invitation invitaion = invitationService.acceptInvitation(token, user.getId());
		projectService.addUserToProject(invitaion.getProjectId(), user.getId());
		return new ResponseEntity<>(invitaion,HttpStatus.ACCEPTED);
	}
	
	
}
