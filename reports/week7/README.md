# Generating a project report

Due to the nature of this project, generating a report requires manual evaluation of performance. However, creation of the final formatted PDF, and all associated figures, is automated as much as possible.

In order to generate results, projects must first be imported into Track Forever. The imported issues must then be compared against the original issues, to look for any missing information, improper rendering, or other issues that may arise. For each compared issue, a rubric is filled out and then added to a comma-separated-value file (CSV). Finally, the automated script tabulates the results and generates a report.

## Instructions for running the script
0. Requirements: 
* [Python 3.x.x](https://www.python.org/download/releases/3.0/)
* [Latex Distribution](https://miktex.org/download) <br>

1. Run **GenerateReport.py** located in the **Initial Results** directory<br>
* ```./GenerateReport.py``` if on Linux <br>
* ```python GenerateReport.py``` if on Windows (if that doesn't work, try ```py -3 GenerateReport.py```) <br>
*NOTE*: This assumes that you have the python PATH set correctly in your environment variables.

2. This will generate a file called **report.tex**.
3. Do one of the following: <br> 
* Open this up in your Latex distribution and compile it. A file called **report.pdf** should be generated within the same directory.
* Convert it using **pdflatex.exe** located in ```C:\Program Files\MiKTeX 2.9\miktex\bin\x64\``` if you are using Miktex on a 64-bit Windows installation. <br>
Example: ```"C:\Program Files\MiKTeX 2.9\miktex\bin\x64\pdflatex.exe" report.tex```


## How to evaluate and record results
Once issues for a particular project have been converted, they must be manually compared to the original. For each issue, 4 values must be determined (each between 0 and 1.0). 

* The first value represents whether all important information was preserved
* The second value represents whether there are any visible errors in the final converted text
* The third value represents whether the submitter, commenter, and assignees can all be identified
* The final value represents whether the the issue is readable (*i.e.* was the issue imported at all?)

If the issue was not imported at all, all values should be set to 0.

These numbers, along with the ID number for the issue they are associated with, are entered into a CSV file in the order listed above. For example:

> 4231,1,1,1,1
>
> 1321,0.5,1,1,1
>
> 1235,0,0,0,0

In **GenerateReport.py**, you must follow the format in the code and specify in the arguments on the relative file path to get to the directory that contains the *.csv* files. <br>
In addition, you must specify the issue tracker name and project name in the *get_table* method. <br>
The script will perform the calculations and generate a Latex file that represents the values in the *.csv* files. <br>
**NOTE**: Improperly formatted data will not be parsed. Please refer to ```Initial Results/GitHub/Microsoft Dotnet/eval-dotnet.csv``` as an example.
