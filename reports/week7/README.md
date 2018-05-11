# Generating a project report

Due to the nature of this project, generating a report requires manual evaluation of performance. However, creation of the final formatted PDF, and all associated figures, is automated as much as possible.

In order to generate results, projects must first be imported into Track Forever. The imported issues must then be compared against the original issues, to look for any missing information, improper rendering, or other issues that may arise. For each compared issue, a rubric is filled out and then added to a comma-separated-value file (CSV). Finally, the automated script tabulates the results and generates a report.

## Instructions for running the script
Requirements: Python 3.x.x, Latex Distribution\
Visit [this link](https://www.python.org/download/releases/3.0/) to download Python.\
Visit [this link](https://miktex.org/download) to download a Latex distribution.

Afterwards, run **GenerateReport.py**.\
This will generate a file called **report.tex**.\
Either open this up in your Latex distribution and save it as a .PDF or convert it using **pdflatex.exe** located in ```C:\Program Files\MiKTeX 2.9\miktex\bin\x64\``` if you are using Miktex on a 64-bit Windows installation.


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

This CSV file can then be passed to the script as detailed above.
