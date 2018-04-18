# Track Forever User Manual

BRAINSTORM:
* Guide to JSON structure (just point to API docs?)
* How to run the tests (maybe)

---

## Table of contents
1. [Introduction](#introduction)
2. [Usage Guide](#usage-guide)
	1. [Getting Started](#getting-started)
		1. [Local Installation](#local-installation)
		2. [Using the Web App](#using-the-web-app)
	2. [Offline Usage](#offline-usage)
	3. [Compatible Issue Trackers](#compatible-issue-trackers)
3. [Server Management](#server-management)
	1. [Remote Installation](#remote-installation)
	2. [Connecting Clients](#connecting-clients)
4. [Contributing and Extending](#contributing-and-extending)
5. [Other Information](#other-information)
	1. [Authors](#authors)
	2. [Running the Test Suite](#running-the-test-suite)
6. [License](#license)

---



## Introduction

Track Forever is a tool designed to help developers maintain their issues and bug reports across various popular industry issue trackers. It provides an open-source, GUI-driven, and extensible system for importing and exporting issues into a JSON-based format, which can then be safely copied wherever the user requires.




## Usage Guide


### Getting Started

#### Local Installation
Clone the repository and its sub-modules. The git command is:
`git clone --recursive https://github.com/cse403trackforever/trackforever.git`

Install the [Node.js](https://nodejs.org) runtime environment.

Navigate to `trackforever/webapp` and run `npm install`, then `npm start`.

Open the web app in a browser by connecting to `https://localhost/4200`.

#### Using the Web App
- Authentification
- Config profile?
- How to import new issues
- How to view all issues of a project
- How to view issues assigned to me


### Offline Usage
[TODO]


### Compatible Issue Trackers
The following issue trackers have built-in support within Track Forever:
* [Google Code](https://code.google.com/archive/)
* [Github Issues](https://help.github.com/articles/about-issues/)

Additional Issue Trackers can be added by following [this guide](TODO LINK)




## Server Management


### Remote Installation
[TODO]


### Connecting Clients
[TODO]




## Contributing and Extending
Track Forever was made with compatibility in mind. Therefore, both the web-app client and the import/export modules can be replaced or expanded upon.

To create a user interface, use the REST API, documented [here](TODO LINK)

To create a new import/export module, follow the guide [here](TODO LINK)




## Other Information

### Authors
Track Forever is an educational project created during the Spring of 2018 by the following students at the University of Washington:
* Christopher Addison (cjteam)
* William Cao (pastor13)
* David Dupre (djdupre)
* Jared Le (jaredtle)
* Christine Ta (cta95)

For more information, visit:
- The [Github page](https://github.com/cse403trackforever/trackforever)
- The [Course page](https://courses.cs.washington.edu/courses/cse403/)


### Running the Test Suite
[TODO]




## License
[TODO]
boilerplate license language
maybe have separate license file?
