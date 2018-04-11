package plugin

import plugin.api.GitHubAPI
import java.io.InputStream
import kotlin.test.Test

class GitHubPluginTest {
    @Test
    fun test() {
        val api = object : GitHubAPI {
            override val issues: InputStream
                get() = """[
                    {
                        "url": "https://api.github.com/repos/cse403trackforever/trackforever/issues/5",
                        "repository_url": "https://api.github.com/repos/cse403trackforever/trackforever",
                        "labels_url": "https://api.github.com/repos/cse403trackforever/trackforever/issues/5/labels{/name}",
                        "comments_url": "https://api.github.com/repos/cse403trackforever/trackforever/issues/5/comments",
                        "events_url": "https://api.github.com/repos/cse403trackforever/trackforever/issues/5/events",
                        "html_url": "https://github.com/cse403trackforever/trackforever/pull/5",
                        "id": 313058833,
                        "number": 5,
                        "title": "[Add] testing hooks",
                        "user": {
                            "login": "cjteam123",
                            "id": 9428660,
                            "avatar_url": "https://avatars0.githubusercontent.com/u/9428660?v=4",
                            "gravatar_id": "",
                            "url": "https://api.github.com/users/cjteam123",
                            "html_url": "https://github.com/cjteam123",
                            "followers_url": "https://api.github.com/users/cjteam123/followers",
                            "following_url": "https://api.github.com/users/cjteam123/following{/other_user}",
                            "gists_url": "https://api.github.com/users/cjteam123/gists{/gist_id}",
                            "starred_url": "https://api.github.com/users/cjteam123/starred{/owner}{/repo}",
                            "subscriptions_url": "https://api.github.com/users/cjteam123/subscriptions",
                            "organizations_url": "https://api.github.com/users/cjteam123/orgs",
                            "repos_url": "https://api.github.com/users/cjteam123/repos",
                            "events_url": "https://api.github.com/users/cjteam123/events{/privacy}",
                            "received_events_url": "https://api.github.com/users/cjteam123/received_events",
                            "type": "User",
                            "site_admin": false
                        },
                        "labels": [

                        ],
                        "state": "open",
                        "locked": false,
                        "assignee": null,
                        "assignees": [

                        ],
                        "milestone": null,
                        "comments": 6,
                        "created_at": "2018-04-10T19:29:20Z",
                        "updated_at": "2018-04-11T05:32:54Z",
                        "closed_at": null,
                        "author_association": "CONTRIBUTOR",
                        "pull_request": {
                            "url": "https://api.github.com/repos/cse403trackforever/trackforever/pulls/5",
                            "html_url": "https://github.com/cse403trackforever/trackforever/pull/5",
                            "diff_url": "https://github.com/cse403trackforever/trackforever/pull/5.diff",
                            "patch_url": "https://github.com/cse403trackforever/trackforever/pull/5.patch"
                        },
                        "body": ""
                    },
                    {
                        "url": "https://api.github.com/repos/cse403trackforever/trackforever/issues/4",
                        "repository_url": "https://api.github.com/repos/cse403trackforever/trackforever",
                        "labels_url": "https://api.github.com/repos/cse403trackforever/trackforever/issues/4/labels{/name}",
                        "comments_url": "https://api.github.com/repos/cse403trackforever/trackforever/issues/4/comments",
                        "events_url": "https://api.github.com/repos/cse403trackforever/trackforever/issues/4/events",
                        "html_url": "https://github.com/cse403trackforever/trackforever/pull/4",
                        "id": 313037094,
                        "number": 4,
                        "title": "[Add] basic TrackForever structures",
                        "user": {
                            "login": "cjteam123",
                            "id": 9428660,
                            "avatar_url": "https://avatars0.githubusercontent.com/u/9428660?v=4",
                            "gravatar_id": "",
                            "url": "https://api.github.com/users/cjteam123",
                            "html_url": "https://github.com/cjteam123",
                            "followers_url": "https://api.github.com/users/cjteam123/followers",
                            "following_url": "https://api.github.com/users/cjteam123/following{/other_user}",
                            "gists_url": "https://api.github.com/users/cjteam123/gists{/gist_id}",
                            "starred_url": "https://api.github.com/users/cjteam123/starred{/owner}{/repo}",
                            "subscriptions_url": "https://api.github.com/users/cjteam123/subscriptions",
                            "organizations_url": "https://api.github.com/users/cjteam123/orgs",
                            "repos_url": "https://api.github.com/users/cjteam123/repos",
                            "events_url": "https://api.github.com/users/cjteam123/events{/privacy}",
                            "received_events_url": "https://api.github.com/users/cjteam123/received_events",
                            "type": "User",
                            "site_admin": false
                        },
                        "labels": [

                        ],
                        "state": "open",
                        "locked": false,
                        "assignee": null,
                        "assignees": [

                        ],
                        "milestone": null,
                        "comments": 0,
                        "created_at": "2018-04-10T18:21:54Z",
                        "updated_at": "2018-04-10T18:21:54Z",
                        "closed_at": null,
                        "author_association": "CONTRIBUTOR",
                        "pull_request": {
                            "url": "https://api.github.com/repos/cse403trackforever/trackforever/pulls/4",
                            "html_url": "https://github.com/cse403trackforever/trackforever/pull/4",
                            "diff_url": "https://github.com/cse403trackforever/trackforever/pull/4.diff",
                            "patch_url": "https://github.com/cse403trackforever/trackforever/pull/4.patch"
                        },
                        "body": ""
                    },
                    {
                        "url": "https://api.github.com/repos/cse403trackforever/trackforever/issues/1",
                        "repository_url": "https://api.github.com/repos/cse403trackforever/trackforever",
                        "labels_url": "https://api.github.com/repos/cse403trackforever/trackforever/issues/1/labels{/name}",
                        "comments_url": "https://api.github.com/repos/cse403trackforever/trackforever/issues/1/comments",
                        "events_url": "https://api.github.com/repos/cse403trackforever/trackforever/issues/1/events",
                        "html_url": "https://github.com/cse403trackforever/trackforever/issues/1",
                        "id": 311718419,
                        "number": 1,
                        "title": "TEST_ISSUE",
                        "user": {
                            "login": "jaredtle",
                            "id": 29386164,
                            "avatar_url": "https://avatars3.githubusercontent.com/u/29386164?v=4",
                            "gravatar_id": "",
                            "url": "https://api.github.com/users/jaredtle",
                            "html_url": "https://github.com/jaredtle",
                            "followers_url": "https://api.github.com/users/jaredtle/followers",
                            "following_url": "https://api.github.com/users/jaredtle/following{/other_user}",
                            "gists_url": "https://api.github.com/users/jaredtle/gists{/gist_id}",
                            "starred_url": "https://api.github.com/users/jaredtle/starred{/owner}{/repo}",
                            "subscriptions_url": "https://api.github.com/users/jaredtle/subscriptions",
                            "organizations_url": "https://api.github.com/users/jaredtle/orgs",
                            "repos_url": "https://api.github.com/users/jaredtle/repos",
                            "events_url": "https://api.github.com/users/jaredtle/events{/privacy}",
                            "received_events_url": "https://api.github.com/users/jaredtle/received_events",
                            "type": "User",
                            "site_admin": false
                        },
                        "labels": [
                            {
                                "id": 888940053,
                                "url": "https://api.github.com/repos/cse403trackforever/trackforever/labels/bug",
                                "name": "bug",
                                "color": "d73a4a",
                                "default": true
                            }
                        ],
                        "state": "open",
                        "locked": false,
                        "assignee": {
                            "login": "jaredtle",
                            "id": 29386164,
                            "avatar_url": "https://avatars3.githubusercontent.com/u/29386164?v=4",
                            "gravatar_id": "",
                            "url": "https://api.github.com/users/jaredtle",
                            "html_url": "https://github.com/jaredtle",
                            "followers_url": "https://api.github.com/users/jaredtle/followers",
                            "following_url": "https://api.github.com/users/jaredtle/following{/other_user}",
                            "gists_url": "https://api.github.com/users/jaredtle/gists{/gist_id}",
                            "starred_url": "https://api.github.com/users/jaredtle/starred{/owner}{/repo}",
                            "subscriptions_url": "https://api.github.com/users/jaredtle/subscriptions",
                            "organizations_url": "https://api.github.com/users/jaredtle/orgs",
                            "repos_url": "https://api.github.com/users/jaredtle/repos",
                            "events_url": "https://api.github.com/users/jaredtle/events{/privacy}",
                            "received_events_url": "https://api.github.com/users/jaredtle/received_events",
                            "type": "User",
                            "site_admin": false
                        },
                        "assignees": [
                            {
                                "login": "jaredtle",
                                "id": 29386164,
                                "avatar_url": "https://avatars3.githubusercontent.com/u/29386164?v=4",
                                "gravatar_id": "",
                                "url": "https://api.github.com/users/jaredtle",
                                "html_url": "https://github.com/jaredtle",
                                "followers_url": "https://api.github.com/users/jaredtle/followers",
                                "following_url": "https://api.github.com/users/jaredtle/following{/other_user}",
                                "gists_url": "https://api.github.com/users/jaredtle/gists{/gist_id}",
                                "starred_url": "https://api.github.com/users/jaredtle/starred{/owner}{/repo}",
                                "subscriptions_url": "https://api.github.com/users/jaredtle/subscriptions",
                                "organizations_url": "https://api.github.com/users/jaredtle/orgs",
                                "repos_url": "https://api.github.com/users/jaredtle/repos",
                                "events_url": "https://api.github.com/users/jaredtle/events{/privacy}",
                                "received_events_url": "https://api.github.com/users/jaredtle/received_events",
                                "type": "User",
                                "site_admin": false
                            }
                        ],
                        "milestone": null,
                        "comments": 0,
                        "created_at": "2018-04-05T18:22:28Z",
                        "updated_at": "2018-04-05T18:22:28Z",
                        "closed_at": null,
                        "author_association": "CONTRIBUTOR",
                        "body": "TEST_DESCRIPTION"
                    }
                ]""".byteInputStream()

            override fun fetchComments(issueId: Int): InputStream = when (issueId) {
                1 -> "[]"
                2 -> "[]"
                3 -> "[]"
                4 -> "[]"
                5 -> """
                    [
                        {
                            "url": "https://api.github.com/repos/cse403trackforever/trackforever/issues/comments/380328080",
                            "html_url": "https://github.com/cse403trackforever/trackforever/pull/5#issuecomment-380328080",
                            "issue_url": "https://api.github.com/repos/cse403trackforever/trackforever/issues/5",
                            "id": 380328080,
                            "user": {
                                "login": "djdupre",
                                "id": 29697135,
                                "avatar_url": "https://avatars1.githubusercontent.com/u/29697135?v=4",
                                "gravatar_id": "",
                                "url": "https://api.github.com/users/djdupre",
                                "html_url": "https://github.com/djdupre",
                                "followers_url": "https://api.github.com/users/djdupre/followers",
                                "following_url": "https://api.github.com/users/djdupre/following{/other_user}",
                                "gists_url": "https://api.github.com/users/djdupre/gists{/gist_id}",
                                "starred_url": "https://api.github.com/users/djdupre/starred{/owner}{/repo}",
                                "subscriptions_url": "https://api.github.com/users/djdupre/subscriptions",
                                "organizations_url": "https://api.github.com/users/djdupre/orgs",
                                "repos_url": "https://api.github.com/users/djdupre/repos",
                                "events_url": "https://api.github.com/users/djdupre/events{/privacy}",
                                "received_events_url": "https://api.github.com/users/djdupre/received_events",
                                "type": "User",
                                "site_admin": false
                            },
                            "created_at": "2018-04-11T05:03:18Z",
                            "updated_at": "2018-04-11T05:03:18Z",
                            "author_association": "CONTRIBUTOR",
                            "body": "I don't like how these testing hooks require us to spam null checks everywhere. Can we instead separate the code that fetches the raw JSON into another file? I think something like this would be nice:\r\n```Kotlin\r\nclass GoogleCodePlugin(projectName: String, private val api: GoogleCodeAPI = GoogleCodeDefaultAPI(projectName)) : Plugin { ... }\r\n```\r\nThen when we want to test we pass in a dummy API that gives back raw JSON."
                        },
                        {
                            "url": "https://api.github.com/repos/cse403trackforever/trackforever/issues/comments/380328391",
                            "html_url": "https://github.com/cse403trackforever/trackforever/pull/5#issuecomment-380328391",
                            "issue_url": "https://api.github.com/repos/cse403trackforever/trackforever/issues/5",
                            "id": 380328391,
                            "user": {
                                "login": "cjteam123",
                                "id": 9428660,
                                "avatar_url": "https://avatars0.githubusercontent.com/u/9428660?v=4",
                                "gravatar_id": "",
                                "url": "https://api.github.com/users/cjteam123",
                                "html_url": "https://github.com/cjteam123",
                                "followers_url": "https://api.github.com/users/cjteam123/followers",
                                "following_url": "https://api.github.com/users/cjteam123/following{/other_user}",
                                "gists_url": "https://api.github.com/users/cjteam123/gists{/gist_id}",
                                "starred_url": "https://api.github.com/users/cjteam123/starred{/owner}{/repo}",
                                "subscriptions_url": "https://api.github.com/users/cjteam123/subscriptions",
                                "organizations_url": "https://api.github.com/users/cjteam123/orgs",
                                "repos_url": "https://api.github.com/users/cjteam123/repos",
                                "events_url": "https://api.github.com/users/cjteam123/events{/privacy}",
                                "received_events_url": "https://api.github.com/users/cjteam123/received_events",
                                "type": "User",
                                "site_admin": false
                            },
                            "created_at": "2018-04-11T05:05:33Z",
                            "updated_at": "2018-04-11T05:05:33Z",
                            "author_association": "CONTRIBUTOR",
                            "body": "Yeah, I can do that tomorrow. That's a much better idea."
                        },
                        {
                            "url": "https://api.github.com/repos/cse403trackforever/trackforever/issues/comments/380328570",
                            "html_url": "https://github.com/cse403trackforever/trackforever/pull/5#issuecomment-380328570",
                            "issue_url": "https://api.github.com/repos/cse403trackforever/trackforever/issues/5",
                            "id": 380328570,
                            "user": {
                                "login": "djdupre",
                                "id": 29697135,
                                "avatar_url": "https://avatars1.githubusercontent.com/u/29697135?v=4",
                                "gravatar_id": "",
                                "url": "https://api.github.com/users/djdupre",
                                "html_url": "https://github.com/djdupre",
                                "followers_url": "https://api.github.com/users/djdupre/followers",
                                "following_url": "https://api.github.com/users/djdupre/following{/other_user}",
                                "gists_url": "https://api.github.com/users/djdupre/gists{/gist_id}",
                                "starred_url": "https://api.github.com/users/djdupre/starred{/owner}{/repo}",
                                "subscriptions_url": "https://api.github.com/users/djdupre/subscriptions",
                                "organizations_url": "https://api.github.com/users/djdupre/orgs",
                                "repos_url": "https://api.github.com/users/djdupre/repos",
                                "events_url": "https://api.github.com/users/djdupre/events{/privacy}",
                                "received_events_url": "https://api.github.com/users/djdupre/received_events",
                                "type": "User",
                                "site_admin": false
                            },
                            "created_at": "2018-04-11T05:06:49Z",
                            "updated_at": "2018-04-11T05:06:49Z",
                            "author_association": "CONTRIBUTOR",
                            "body": "I'll do it for the Google Code plugin"
                        },
                        {
                            "url": "https://api.github.com/repos/cse403trackforever/trackforever/issues/comments/380328746",
                            "html_url": "https://github.com/cse403trackforever/trackforever/pull/5#issuecomment-380328746",
                            "issue_url": "https://api.github.com/repos/cse403trackforever/trackforever/issues/5",
                            "id": 380328746,
                            "user": {
                                "login": "cjteam123",
                                "id": 9428660,
                                "avatar_url": "https://avatars0.githubusercontent.com/u/9428660?v=4",
                                "gravatar_id": "",
                                "url": "https://api.github.com/users/cjteam123",
                                "html_url": "https://github.com/cjteam123",
                                "followers_url": "https://api.github.com/users/cjteam123/followers",
                                "following_url": "https://api.github.com/users/cjteam123/following{/other_user}",
                                "gists_url": "https://api.github.com/users/cjteam123/gists{/gist_id}",
                                "starred_url": "https://api.github.com/users/cjteam123/starred{/owner}{/repo}",
                                "subscriptions_url": "https://api.github.com/users/cjteam123/subscriptions",
                                "organizations_url": "https://api.github.com/users/cjteam123/orgs",
                                "repos_url": "https://api.github.com/users/cjteam123/repos",
                                "events_url": "https://api.github.com/users/cjteam123/events{/privacy}",
                                "received_events_url": "https://api.github.com/users/cjteam123/received_events",
                                "type": "User",
                                "site_admin": false
                            },
                            "created_at": "2018-04-11T05:08:11Z",
                            "updated_at": "2018-04-11T05:08:11Z",
                            "author_association": "CONTRIBUTOR",
                            "body": "Should we make a general api interface, or one for each plugin?"
                        },
                        {
                            "url": "https://api.github.com/repos/cse403trackforever/trackforever/issues/comments/380329819",
                            "html_url": "https://github.com/cse403trackforever/trackforever/pull/5#issuecomment-380329819",
                            "issue_url": "https://api.github.com/repos/cse403trackforever/trackforever/issues/5",
                            "id": 380329819,
                            "user": {
                                "login": "djdupre",
                                "id": 29697135,
                                "avatar_url": "https://avatars1.githubusercontent.com/u/29697135?v=4",
                                "gravatar_id": "",
                                "url": "https://api.github.com/users/djdupre",
                                "html_url": "https://github.com/djdupre",
                                "followers_url": "https://api.github.com/users/djdupre/followers",
                                "following_url": "https://api.github.com/users/djdupre/following{/other_user}",
                                "gists_url": "https://api.github.com/users/djdupre/gists{/gist_id}",
                                "starred_url": "https://api.github.com/users/djdupre/starred{/owner}{/repo}",
                                "subscriptions_url": "https://api.github.com/users/djdupre/subscriptions",
                                "organizations_url": "https://api.github.com/users/djdupre/orgs",
                                "repos_url": "https://api.github.com/users/djdupre/repos",
                                "events_url": "https://api.github.com/users/djdupre/events{/privacy}",
                                "received_events_url": "https://api.github.com/users/djdupre/received_events",
                                "type": "User",
                                "site_admin": false
                            },
                            "created_at": "2018-04-11T05:16:03Z",
                            "updated_at": "2018-04-11T05:16:03Z",
                            "author_association": "CONTRIBUTOR",
                            "body": "I think each plugin may need its own unique api interface. For example Google Code needs a fetchIssuesPage function but other plugins probably do not."
                        },
                        {
                            "url": "https://api.github.com/repos/cse403trackforever/trackforever/issues/comments/380330011",
                            "html_url": "https://github.com/cse403trackforever/trackforever/pull/5#issuecomment-380330011",
                            "issue_url": "https://api.github.com/repos/cse403trackforever/trackforever/issues/5",
                            "id": 380330011,
                            "user": {
                                "login": "cjteam123",
                                "id": 9428660,
                                "avatar_url": "https://avatars0.githubusercontent.com/u/9428660?v=4",
                                "gravatar_id": "",
                                "url": "https://api.github.com/users/cjteam123",
                                "html_url": "https://github.com/cjteam123",
                                "followers_url": "https://api.github.com/users/cjteam123/followers",
                                "following_url": "https://api.github.com/users/cjteam123/following{/other_user}",
                                "gists_url": "https://api.github.com/users/cjteam123/gists{/gist_id}",
                                "starred_url": "https://api.github.com/users/cjteam123/starred{/owner}{/repo}",
                                "subscriptions_url": "https://api.github.com/users/cjteam123/subscriptions",
                                "organizations_url": "https://api.github.com/users/cjteam123/orgs",
                                "repos_url": "https://api.github.com/users/cjteam123/repos",
                                "events_url": "https://api.github.com/users/cjteam123/events{/privacy}",
                                "received_events_url": "https://api.github.com/users/cjteam123/received_events",
                                "type": "User",
                                "site_admin": false
                            },
                            "created_at": "2018-04-11T05:17:31Z",
                            "updated_at": "2018-04-11T05:17:31Z",
                            "author_association": "CONTRIBUTOR",
                            "body": "That's true. Then, specific for each plugin it is."
                        }
                    ]"""
                else -> throw Exception("Unknown index")
            }.byteInputStream()
        }

        val plugin = GitHubPlugin("", "", api)
        plugin.import()

        // TODO: test output
    }
}