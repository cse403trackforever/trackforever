# Generating a project report

Due to the nature of this project, generating a report requires manual evaluation of performance. However, creation of the final formatted PDF, and all associated figures, is automated as much as possible.

In order to generate results, projects must first be imported into Track Forever. The imported issues must then be compared against the original issues, to look for any missing information, improper rendering, or other issues that may arise. For each compared issue, a rubric is filled out and then added to a comma-separated-value file (CSV). Finally, the automated script tabulates the results and generates a report.

## Instructions for running the script
0. Requirements: 
* [Python 3.x.x](https://www.python.org/download/releases/3.0/)
* [Latex Distribution](https://miktex.org/download) <br>

1. Run **GenerateReport.py** located in the current directory<br>
* ```./GenerateReport.py``` if on Linux <br>
* ```python GenerateReport.py``` if on Windows (if that doesn't work, try ```py -3 GenerateReport.py```) <br>
*NOTE*: This assumes that you have the python PATH set correctly in your environment variables.

2. This will generate a file called **report.tex**.
3. Do one of the following: <br> 
* Open this up in your Latex distribution and compile it. A file called **report.pdf** should be generated within the same directory.
* Convert it using **pdflatex.exe** located in ```C:\Program Files\MiKTeX 2.9\miktex\bin\x64\``` (default location) if you are using Miktex on a 64-bit Windows installation. <br>
Example: ```"C:\Program Files\MiKTeX 2.9\miktex\bin\x64\pdflatex.exe" report.tex```


## How to evaluate and record results
Once issues for a particular project have been converted, they must be manually compared to the original. For each issue, 4 values must be determined (each between 0 and 1.0). 

* The first value represents whether the issue was imported successfully (out of 1 point, unweighted).
* The second value represents whether important information was preserved (out of 4 points).
* The third value represents whether user identification was preserve (out of 2 points).
* The fourth value represents whether there were any rendering errors (out of 3 points).
* The final value represents whether there were any other pieces of information that may be specific to an issue tracker that ours did not import (out of 2 points).

If the issue was not imported at all, all values should be set to 0.

**For greater detail on how to manually evaluate each subcategory, please refer to [this document](./report.pdf).**
A list of all the projects evaluated and the fields used to import the project on the web application: <br>
**NOTE: For GitHub, make sure you search for all issues because the default only displays open issues!**
* **GitHub**
  - [Defects4J](https://github.com/rjust/defects4j/issues)
    - Owner: ```rjust```
    - Project Name: ```defects4j```
  - [Microsoft DotNet](https://github.com/Microsoft/dotnet/issues)
    - Owner: ```Microsoft```
    - Project Name: ```dotnet```
* **Google Code**
  - [Appscale](https://code.google.com/archive/p/appscale/issues)
    - Project Name: ```appscale```
  - [Openbookproject](https://code.google.com/archive/p/openbookproject/issues)
    - Project Name: ```openbookproject```
* **Redmine**
  - [Test Credit System](http://www.hostedredmine.com/projects/test-credit-system)
    - Server URL: ```http://www.hostedredmine.com```
    - Project Name: ```test-credit-system```
    - Project ID: ```1869```
  - [Operation Authority](http://www.hostedredmine.com/projects/operation-authority)
    - Server URL: ```http://www.hostedredmine.com```
    - Project Name: ```operation-authority```
    - Project ID: ```31998```

These numbers, along with the ID number for the issue they are associated with, are entered into a CSV file in the order listed above. For example:

> 234,1,4,2,3,2
>
> 1321,1,2,0,1,1
>
> 1235,0,0,0,0,0

In **GenerateReport.py**, you must specify the second argument in ```scoreGeneric()``` as the relative file path (as a list) to get to the directory that contains the *.csv* files. <br>
In addition, you should specify the issue tracker name and project name as the third and fourth parameters in the ```scoreGeneric()``` function. <br>
The script will perform the calculations and generate a Latex file that represents the values in the *.csv* files. <br>
**NOTE**: Improperly formatted data will not be parsed. <br>
Please refer to ```Results/Google Code/Appscale/appscale.csv``` as a properly formatted example.
