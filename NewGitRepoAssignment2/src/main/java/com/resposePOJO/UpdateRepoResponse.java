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
public class UpdateRepoResponse {
	
	@JsonProperty("id")
	public Integer id;
	@JsonProperty("node_id")
	public String nodeId;
	@JsonProperty("name")
	public String name;
	@JsonProperty("full_name")
	public String fullName;
	@JsonProperty("private")
	public Boolean _private;
	@JsonProperty("owner")
	public Owner owner;
	@JsonProperty("html_url")
	public String htmlUrl;
	@JsonProperty("description")
	public String description;
	@JsonProperty("fork")
	public Boolean fork;
	@JsonProperty("url")
	public String url;
	@JsonProperty("forks_url")
	public String forksUrl;
	@JsonProperty("keys_url")
	public String keysUrl;
	@JsonProperty("collaborators_url")
	public String collaboratorsUrl;
	@JsonProperty("teams_url")
	public String teamsUrl;
	@JsonProperty("hooks_url")
	public String hooksUrl;
	@JsonProperty("issue_events_url")
	public String issueEventsUrl;
	@JsonProperty("events_url")
	public String eventsUrl;
	@JsonProperty("assignees_url")
	public String assigneesUrl;
	@JsonProperty("branches_url")
	public String branchesUrl;
	@JsonProperty("tags_url")
	public String tagsUrl;
	@JsonProperty("blobs_url")
	public String blobsUrl;
	@JsonProperty("git_tags_url")
	public String gitTagsUrl;
	@JsonProperty("git_refs_url")
	public String gitRefsUrl;
	@JsonProperty("trees_url")
	public String treesUrl;
	@JsonProperty("statuses_url")
	public String statusesUrl;
	@JsonProperty("languages_url")
	public String languagesUrl;
	@JsonProperty("stargazers_url")
	public String stargazersUrl;
	@JsonProperty("contributors_url")
	public String contributorsUrl;
	@JsonProperty("subscribers_url")
	public String subscribersUrl;
	@JsonProperty("subscription_url")
	public String subscriptionUrl;
	@JsonProperty("commits_url")
	public String commitsUrl;
	@JsonProperty("git_commits_url")
	public String gitCommitsUrl;
	@JsonProperty("comments_url")
	public String commentsUrl;
	@JsonProperty("issue_comment_url")
	public String issueCommentUrl;
	@JsonProperty("contents_url")
	public String contentsUrl;
	@JsonProperty("compare_url")
	public String compareUrl;
	@JsonProperty("merges_url")
	public String mergesUrl;
	@JsonProperty("archive_url")
	public String archiveUrl;
	@JsonProperty("downloads_url")
	public String downloadsUrl;
	@JsonProperty("issues_url")
	public String issuesUrl;
	@JsonProperty("pulls_url")
	public String pullsUrl;
	@JsonProperty("milestones_url")
	public String milestonesUrl;
	@JsonProperty("notifications_url")
	public String notificationsUrl;
	@JsonProperty("labels_url")
	public String labelsUrl;
	@JsonProperty("releases_url")
	public String releasesUrl;
	@JsonProperty("deployments_url")
	public String deploymentsUrl;
	@JsonProperty("created_at")
	public String createdAt;
	@JsonProperty("updated_at")
	public String updatedAt;
	@JsonProperty("pushed_at")
	public String pushedAt;
	@JsonProperty("git_url")
	public String gitUrl;
	@JsonProperty("ssh_url")
	public String sshUrl;
	@JsonProperty("clone_url")
	public String cloneUrl;
	@JsonProperty("svn_url")
	public String svnUrl;
	@JsonProperty("homepage")
	public String homepage;
	@JsonProperty("size")
	public Integer size;
	@JsonProperty("stargazers_count")
	public Integer stargazersCount;
	@JsonProperty("watchers_count")
	public Integer watchersCount;
	@JsonProperty("language")
	public Object language;
	@JsonProperty("has_issues")
	public Boolean hasIssues;
	@JsonProperty("has_projects")
	public Boolean hasProjects;
	@JsonProperty("has_downloads")
	public Boolean hasDownloads;
	@JsonProperty("has_wiki")
	public Boolean hasWiki;
	@JsonProperty("has_pages")
	public Boolean hasPages;
	@JsonProperty("has_discussions")
	public Boolean hasDiscussions;
	@JsonProperty("forks_count")
	public Integer forksCount;
	@JsonProperty("mirror_url")
	public Object mirrorUrl;
	@JsonProperty("archived")
	public Boolean archived;
	@JsonProperty("disabled")
	public Boolean disabled;
	@JsonProperty("open_issues_count")
	public Integer openIssuesCount;
	@JsonProperty("license")
	public Object license;
	@JsonProperty("allow_forking")
	public Boolean allowForking;
	@JsonProperty("is_template")
	public Boolean isTemplate;
	@JsonProperty("web_commit_signoff_required")
	public Boolean webCommitSignoffRequired;
	@JsonProperty("topics")
	public List<Object> topics;
	@JsonProperty("visibility")
	public String visibility;
	@JsonProperty("forks")
	public Integer forks;
	@JsonProperty("open_issues")
	public Integer openIssues;
	@JsonProperty("watchers")
	public Integer watchers;
	@JsonProperty("default_branch")
	public String defaultBranch;
	@JsonProperty("permissions")
	public Permissions permissions;
	@JsonProperty("allow_squash_merge")
	public Boolean allowSquashMerge;
	@JsonProperty("allow_merge_commit")
	public Boolean allowMergeCommit;
	@JsonProperty("allow_rebase_merge")
	public Boolean allowRebaseMerge;
	@JsonProperty("allow_auto_merge")
	public Boolean allowAutoMerge;
	@JsonProperty("delete_branch_on_merge")
	public Boolean deleteBranchOnMerge;
	@JsonProperty("allow_update_branch")
	public Boolean allowUpdateBranch;
	@JsonProperty("use_squash_pr_title_as_default")
	public Boolean useSquashPrTitleAsDefault;
	@JsonProperty("squash_merge_commit_message")
	public String squashMergeCommitMessage;
	@JsonProperty("squash_merge_commit_title")
	public String squashMergeCommitTitle;
	@JsonProperty("merge_commit_message")
	public String mergeCommitMessage;
	@JsonProperty("merge_commit_title")
	public String mergeCommitTitle;
	@JsonProperty("security_and_analysis")
	public SecurityAndAnalysis securityAndAnalysis;
	@JsonProperty("network_count")
	public Integer networkCount;
	@JsonProperty("subscribers_count")
	public Integer subscribersCount;
	
	
	public class Owner {

		@JsonProperty("login")
		public String login;
		@JsonProperty("id")
		public Integer id;
		@JsonProperty("node_id")
		public String nodeId;
		@JsonProperty("avatar_url")
		public String avatarUrl;
		@JsonProperty("gravatar_id")
		public String gravatarId;
		@JsonProperty("url")
		public String url;
		@JsonProperty("html_url")
		public String htmlUrl;
		@JsonProperty("followers_url")
		public String followersUrl;
		@JsonProperty("following_url")
		public String followingUrl;
		@JsonProperty("gists_url")
		public String gistsUrl;
		@JsonProperty("starred_url")
		public String starredUrl;
		@JsonProperty("subscriptions_url")
		public String subscriptionsUrl;
		@JsonProperty("organizations_url")
		public String organizationsUrl;
		@JsonProperty("repos_url")
		public String reposUrl;
		@JsonProperty("events_url")
		public String eventsUrl;
		@JsonProperty("received_events_url")
		public String receivedEventsUrl;
		@JsonProperty("type")
		public String type;
		@JsonProperty("site_admin")
		public Boolean siteAdmin;
	}
	
	public class Permissions {

		@JsonProperty("admin")
		public Boolean admin;
		@JsonProperty("maintain")
		public Boolean maintain;
		@JsonProperty("push")
		public Boolean push;
		@JsonProperty("triage")
		public Boolean triage;
		@JsonProperty("pull")
		public Boolean pull;
	}
	
	public class SecretScanning {

		@JsonProperty("status")
		public String status;
	}
	
	public class SecretScanningPushProtection {

		@JsonProperty("status")
		public String status;
	}
	
	public class SecretScanningValidityChecks {

		@JsonProperty("status")
		public String status;
	}
	
	public class SecurityAndAnalysis {

		@JsonProperty("secret_scanning")
		public SecretScanning secretScanning;
		@JsonProperty("secret_scanning_push_protection")
		public SecretScanningPushProtection secretScanningPushProtection;
		@JsonProperty("dependabot_security_updates")
		public DependabotSecurityUpdates dependabotSecurityUpdates;
		@JsonProperty("secret_scanning_validity_checks")
		public SecretScanningValidityChecks secretScanningValidityChecks;
	}


	public class DependabotSecurityUpdates {

		@JsonProperty("status")
		public String status;
	}
}
