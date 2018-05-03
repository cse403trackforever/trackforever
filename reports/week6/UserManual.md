# Track Forever User Manual

## Table of Contents
1. [Introduction](#introduction)
2. [Usage Guide](#usage-guide)
	1. [Getting Started](#getting-started)
		1. [Local Installation](#local-installation)
		2. [Using the Web App](#using-the-web-app)
		3. [Offline Usage](#offline-usage)
	3. [Compatible Issue Trackers](#compatible-issue-trackers)
3. [Server Management](#server-management)
	1. [Remote Installation](#remote-installation)
	2. [Configuring the Server](#configuring-the-server)
	3. [Connecting Clients](#connecting-clients)
4. [Contributing and Extending](#contributing-and-extending)
5. [Other Information](#other-information)
	1. [Authors](#authors)
	2. [Running the Test Suite](#running-the-test-suite)
		1. [Running Tests for the Server](#running-tests-for-the-server)
		2. [Running Tests for the Client](#running-tests-for-the-client)

---


## Introduction

Track Forever is a tool designed to help developers maintain their issues and bug reports across various popular industry issue trackers. It provides an open-source, GUI-driven, and extensible system for importing and exporting issues into a JSON-based format, which can then be safely archived or copied to remote systems.

Track Forever also supports first-class collaboration between developers through an (otherwise optional) remote server module. Developers can update their tracked issues, online or offline, and intelligently sync their changes with those from other developers. Track Forever also supports a robust two-factor authentication system with built-in compatibility with popular industry issue trackers.

## Usage Guide

### Getting Started

#### Local Installation
Clone the repository and its sub-modules. The git command is:
`git clone --recursive https://github.com/cse403trackforever/trackforever.git`

Install the [Node.js](https://nodejs.org/en/download/) runtime environment.

Navigate to `trackforever/webapp` and run `npm install`, then `npm start`.

Open the web app in a browser by connecting to `https://localhost/4200`.

#### Using the Web App

##### Authentication
- Sign into a Track Forever account
- An account can be created using an email, Facebook, Google, Twitter, or GitHub account

##### Configuring Your Profile
- A user may set their password, picture, and preferences
- There will also be an option to enter the address for a Track Forever collaboration server
- Make sure to claim GitHub, JIRA, etc. usernames in the *Profile* page.

##### Importing Issues from a New Project
- To import a new project, click the **Import** button
- Select the type of the new project (See the [Supported Trackers](#compatible-issue-trackers) section below) and follow the required steps to import the project

##### Viewing All Projects
- Once signed in, the home page will display a list of all projects

##### Viewing a Project and Associated Issues
- From the project list, select the relevant project
- A *Project Details* page for the selected project will display a list of all of its issues
- Filters can be applied to narrow down the list of issues

##### Viewing Details of an Issue
- From the *Project Details* page, select the relevant issue
- The *Issue Details* page will open, allowing the user to view and edit the issue

#### Offline Usage
##### Downloading Issues for Offline Viewing
- On the (top right?) there is a **Sync** button which synchronizes the the client with the state of the server and caches the issues for offline viewing. Any issues fetched while online will also be cached.

##### Re-syncing Issues
- Once online again, the **Sync** button will synchronize the state between the client and the server.

### Compatible Issue Trackers
The following issue trackers have built-in support within Track Forever:
* [Google Code](https://code.google.com/archive/)
* [GitHub Issues](https://help.github.com/articles/about-issues/)
* [Redmine](https://redmine.org/)

To add additional issue trackers, see the section on [Contributing and Extending](#contributing-and-extending)




## Server Management


### Remote Installation
The server runs using a java `jar` file. To compile the `jar`, use the command in the root directory:
`gradle server`

Once compiled, run the server using the following command, replacing `address` with the address for the server to listen on and `port` with the listening port:
`java server.jar [address] [port]`

### Configuring the Server
The **first** user that connects to the server will have to configure the server and will be granted **administrator** permissions.

Administrative operations include:
- Adding users to the server
- Granting or removing user permissions (***this is a dangerous operation***)

### Connecting Clients
Clients must configure their connection (hostname or IP address) to a collaboration server within their profile. In order to connect, press the **Connect To Server** button located in the **Client** interface, under the **Remote** menu.

If the server requires authentication, then an administrator must add the user before the user is allowed to connect. Once authenticated, the user may sync and load issues as specified [above](#using-the-web-app).



## Contributing and Extending
Track Forever was made with compatibility and extensibility in mind. Therefore, both the web-app client and the import/export modules can be replaced or extended upon.

To create a user interface, use the REST API, documented [here](https://github.com/cse403trackforever/trackforever/wiki/RESTful-API-Specification)

To create a new import/export module, follow the guide [here](https://guide.com)




## Other Information

### Authors
Track Forever is a project created by the following people:
* [Christopher Addison](https://github.com/cjteam123)
* [William Cao](https://github.com/WilliamCao13)
* [David Dupre](https://github.com/djdupre)
* [Jared Le](https://github.com/jaredtle)
* [Christine Ta](https://github.com/christineta)

For more information, visit the [GitHub page](https://github.com/cse403trackforever/trackforever)


### Running the Test Suite
#### Running Tests for the Server
- Running `gradle test` will run tests on the server implementation. For these to run, the project must first be initialized with Gradle.
#### Running Tests for the Client
- Running `npm test` will run tests on the client implementation.


