package com.resposePOJO;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@JsonInclude(JsonInclude.Include.NON_NULL)


public class GetRepoResponse {

	@JsonProperty("id")
	private Integer id;
	@JsonProperty("node_id")
	private String nodeId;
	@JsonProperty("name")
	private String name;
	@JsonProperty("full_name")
	private String fullName;
	@JsonProperty("private")
	private Boolean _private;
	@JsonProperty("owner")
	private Owner owner;
	@JsonProperty("html_url")
	private String htmlUrl;
	@JsonProperty("description")
	private Object description;
	@JsonProperty("fork")
	private Boolean fork;
	@JsonProperty("url")
	private String url;
	@JsonProperty("forks_url")
	private String forksUrl;
	@JsonProperty("keys_url")
	private String keysUrl;
	@JsonProperty("collaborators_url")
	private String collaboratorsUrl;
	@JsonProperty("teams_url")
	private String teamsUrl;
	@JsonProperty("hooks_url")
	private String hooksUrl;
	@JsonProperty("issue_events_url")
	private String issueEventsUrl;
	@JsonProperty("events_url")
	private String eventsUrl;
	@JsonProperty("assignees_url")
	private String assigneesUrl;
	@JsonProperty("branches_url")
	private String branchesUrl;
	@JsonProperty("tags_url")
	private String tagsUrl;
	@JsonProperty("blobs_url")
	private String blobsUrl;
	@JsonProperty("git_tags_url")
	private String gitTagsUrl;
	@JsonProperty("git_refs_url")
	private String gitRefsUrl;
	@JsonProperty("trees_url")
	private String treesUrl;
	@JsonProperty("statuses_url")
	private String statusesUrl;
	@JsonProperty("languages_url")
	private String languagesUrl;
	@JsonProperty("stargazers_url")
	private String stargazersUrl;
	@JsonProperty("contributors_url")
	private String contributorsUrl;
	@JsonProperty("subscribers_url")
	private String subscribersUrl;
	@JsonProperty("subscription_url")
	private String subscriptionUrl;
	@JsonProperty("commits_url")
	private String commitsUrl;
	@JsonProperty("git_commits_url")
	private String gitCommitsUrl;
	@JsonProperty("comments_url")
	private String commentsUrl;
	@JsonProperty("issue_comment_url")
	private String issueCommentUrl;
	@JsonProperty("contents_url")
	private String contentsUrl;
	@JsonProperty("compare_url")
	private String compareUrl;
	@JsonProperty("merges_url")
	private String mergesUrl;
	@JsonProperty("archive_url")
	private String archiveUrl;
	@JsonProperty("downloads_url")
	private String downloadsUrl;
	@JsonProperty("issues_url")
	private String issuesUrl;
	@JsonProperty("pulls_url")
	private String pullsUrl;
	@JsonProperty("milestones_url")
	private String milestonesUrl;
	@JsonProperty("notifications_url")
	private String notificationsUrl;
	@JsonProperty("labels_url")
	private String labelsUrl;
	@JsonProperty("releases_url")
	private String releasesUrl;
	@JsonProperty("deployments_url")
	private String deploymentsUrl;
	@JsonProperty("created_at")
	private String createdAt;
	@JsonProperty("updated_at")
	private String updatedAt;
	@JsonProperty("pushed_at")
	private String pushedAt;
	@JsonProperty("git_url")
	private String gitUrl;
	@JsonProperty("ssh_url")
	private String sshUrl;
	@JsonProperty("clone_url")
	private String cloneUrl;
	@JsonProperty("svn_url")
	private String svnUrl;
	@JsonProperty("homepage")
	private Object homepage;
	@JsonProperty("size")
	private Integer size;
	@JsonProperty("stargazers_count")
	private Integer stargazersCount;
	@JsonProperty("watchers_count")
	private Integer watchersCount;
	@JsonProperty("language")
	private String language;
	@JsonProperty("has_issues")
	private Boolean hasIssues;
	@JsonProperty("has_projects")
	private Boolean hasProjects;
	@JsonProperty("has_downloads")
	private Boolean hasDownloads;
	@JsonProperty("has_wiki")
	private Boolean hasWiki;
	@JsonProperty("has_pages")
	private Boolean hasPages;
	@JsonProperty("has_discussions")
	private Boolean hasDiscussions;
	@JsonProperty("forks_count")
	private Integer forksCount;
	@JsonProperty("mirror_url")
	private Object mirrorUrl;
	@JsonProperty("archived")
	private Boolean archived;
	@JsonProperty("disabled")
	private Boolean disabled;
	@JsonProperty("open_issues_count")
	private Integer openIssuesCount;
	@JsonProperty("license")
	private Object license;
	@JsonProperty("allow_forking")
	private Boolean allowForking;
	@JsonProperty("is_template")
	private Boolean isTemplate;
	@JsonProperty("web_commit_signoff_required")
	private Boolean webCommitSignoffRequired;
	@JsonProperty("topics")
	private List<Object> topics;
	@JsonProperty("visibility")
	private String visibility;
	@JsonProperty("forks")
	private Integer forks;
	@JsonProperty("open_issues")
	private Integer openIssues;
	@JsonProperty("watchers")
	private Integer watchers;
	@JsonProperty("default_branch")
	private String defaultBranch;
	@JsonProperty("permissions")
	private Permissions permissions;
	@JsonProperty("temp_clone_token")
	private String tempCloneToken;
	@JsonProperty("allow_squash_merge")
	private Boolean allowSquashMerge;
	@JsonProperty("allow_merge_commit")
	private Boolean allowMergeCommit;
	@JsonProperty("allow_rebase_merge")
	private Boolean allowRebaseMerge;
	@JsonProperty("allow_auto_merge")
	private Boolean allowAutoMerge;
	@JsonProperty("delete_branch_on_merge")
	private Boolean deleteBranchOnMerge;
	@JsonProperty("allow_update_branch")
	private Boolean allowUpdateBranch;
	@JsonProperty("use_squash_pr_title_as_default")
	private Boolean useSquashPrTitleAsDefault;
	@JsonProperty("squash_merge_commit_message")
	private String squashMergeCommitMessage;
	@JsonProperty("squash_merge_commit_title")
	private String squashMergeCommitTitle;
	@JsonProperty("merge_commit_message")
	private String mergeCommitMessage;
	@JsonProperty("merge_commit_title")
	private String mergeCommitTitle;
	@JsonProperty("security_and_analysis")
	private SecurityAndAnalysis securityAndAnalysis;
	@JsonProperty("network_count")
	private Integer networkCount;
	@JsonProperty("subscribers_count")
	private Integer subscribersCount;
	
	public class SecurityAndAnalysis {

		@JsonProperty("secret_scanning")
		private SecretScanning secretScanning;
		@JsonProperty("secret_scanning_push_protection")
		private SecretScanningPushProtection secretScanningPushProtection;
		@JsonProperty("dependabot_security_updates")
		private DependabotSecurityUpdates dependabotSecurityUpdates;
		@JsonProperty("secret_scanning_validity_checks")
		private SecretScanningValidityChecks secretScanningValidityChecks;
	}
	public static class SecretScanning {

		@JsonProperty("status")
		private String status;
	}
	public static class SecretScanningPushProtection {

		@JsonProperty("status")
		private String status;
	}
	public static class DependabotSecurityUpdates {

		@JsonProperty("status")
		private String status;
	}
	public static class SecretScanningValidityChecks {

		@JsonProperty("status")
		private String status;
	}
	
	public class Permissions {

		@JsonProperty("admin")
		private Boolean admin;
		@JsonProperty("maintain")
		private Boolean maintain;
		@JsonProperty("push")
		private Boolean push;
		@JsonProperty("triage")
		private Boolean triage;
		@JsonProperty("pull")
		private Boolean pull;
	}
	public class Owner {

		@JsonProperty("login")
		private String login;
		@JsonProperty("id")
		private Integer id;
		@JsonProperty("node_id")
		private String nodeId;
		@JsonProperty("avatar_url")
		private String avatarUrl;
		@JsonProperty("gravatar_id")
		private String gravatarId;
		@JsonProperty("url")
		private String url;
		@JsonProperty("html_url")
		private String htmlUrl;
		@JsonProperty("followers_url")
		private String followersUrl;
		@JsonProperty("following_url")
		private String followingUrl;
		@JsonProperty("gists_url")
		private String gistsUrl;
		@JsonProperty("starred_url")
		private String starredUrl;
		@JsonProperty("subscriptions_url")
		private String subscriptionsUrl;
		@JsonProperty("organizations_url")
		private String organizationsUrl;
		@JsonProperty("repos_url")
		private String reposUrl;
		@JsonProperty("events_url")
		private String eventsUrl;
		@JsonProperty("received_events_url")
		private String receivedEventsUrl;
		@JsonProperty("type")
		private String type;
		@JsonProperty("site_admin")
		private Boolean siteAdmin;
	}
}
