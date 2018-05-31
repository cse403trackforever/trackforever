#!/usr/bin/python3

import GenericScore as gen_score
import GoogleCode as code_score

texdoc = ['\\documentclass{article}\n', '%for graphics\n', '\\usepackage{pgfplots}\n', '\\pgfplotsset{compat=1.10}\n', '\n', '%paragraph formatting\n', '\\setlength{\\parindent}{0pt}\n', '\\setlength{\\parskip}{1em}\n', '\n', '%table lists\n', '\\usepackage{booktabs}\n', '\\newcommand{\\tabitem}{~~\\llap{\\textbullet}~~}\n', '\\usepackage{makecell}\n', '\\renewcommand\\theadalign{cl}\n', '\\usepackage{adjustbox}\n', '\n', '\n', '\n', '\\begin{document}\n', '\t\\begin{titlepage}\n', '\t\t\\title{Track Forever Results}\n', '\t\t\\date{\\today}\n', '\t\t\\author{ Christopher Addison (cjteam) \\\\\n', '\t\t\tWilliam Cao (pastor13) \\\\\n', '\t\t\tDavid Dupre (djdupre) \\\\\n', '\t\t\tJared Le (jaredtle) \\\\\n', '\t\t\tChristine Ta (cta95) }\n', '\t\t\\maketitle\n', '\t\\end{titlepage}\n', '\t\n', '\t\\section{Introduction}\n', '\tThe following report has been automatically generated. Its purpose is to provide \n', '\tillustrations of the effectiveness of Track Forever. In order to generate these results, \n', '\tseveral projects were selected from public issue trackers and imported into Track Forever. \n', '\tAt this point, issues were manually evaluated according to the following rubric.\n', '\t\n', '\t\\begin{adjustbox}{center}\n', '\t\t\\renewcommand{\\arraystretch}{1.5}\n', '\t\t\\begin{tabular}{ p{6cm} | c | l }\n', '\t\t\tTest & Possible Points & Grading \\\\ \\hline\n', '\t\t\tDid the issue successfully import? & - &  \n', '\t\t\t\\makecell[{{p{4cm}}}]{\n', '\t\t\t\tPass/fail based on random sampling. If this fails, all other categories receive automatic zeroes. \\\\\n', '\t\t\t\tCSV script accepts 0 for missing, 1 for present.} \\\\\n', '\t\t\t\\hline\n', '\t\t\t\\makecell[l]{\n', '\t\t\t\tWas important information preserved? \\\\\n', '\t\t\t\t\\tabitem Time submitted/updated \\\\\n', '\t\t\t\t\\tabitem Labels, Status \\\\\n', '\t\t\t\t\\tabitem Comment/Summary field contents \\\\\n', '\t\t\t\t\\tabitem Hyperlinks, embedded objects}\n', '\t\t\t& 4 & \\makecell[{{p{4cm}}}]{Partial credit available based on fraction of information preserved. See items listed to the left. \\\\\n', '\t\t\t\tOne error in any category loses the whole point.\n', '\t\t\t} \\\\\n', '\t\t\t\\hline\n', '\t\t\t\\makecell[l]{\n', '\t\t\t\tWas user information preserved? \\\\\n', '\t\t\t\t\\tabitem Submitter/commenter IDs \\\\\n', '\t\t\t\t\\tabitem Assignee IDs\n', '\t\t\t} & 2 & \\makecell[{{p{4cm}}}]{\n', '\t\t\t\tPartial credit, with 1 point for each bullet. One missing ID loses the whole point.\n', '\t\t\t} \\\\\n', '\t\t\t\\hline\n', '\t\t\t\\makecell[{{p{6cm}}}]{\n', '\t\t\t\tAre there any rendering errors on the webpage? \\\\\n', '\t\t\t\t\\tabitem No markdown/formatting errors \\\\\n', '\t\t\t\t\\tabitem No missing character symbols \\\\\n', '\t\t\t\t\\tabitem All elements resize properly\n', '\t\t\t} & 3 & \\makecell[{{p{4cm}}}]{\n', '\t\t\t\tPartial credit, with 1 point for each bullet. One error in any category loses the whole point.\n', '\t\t\t} \\\\\n', '\t\t\t\\hline\n', '\t\t\t\\makecell[{{p{6cm}}}]{\n', '\t\t\t\tAre there any other pieces of information not preserved? \\\\\n', '\t\t\t\t\\tabitem Platform specific features \\\\\n', '\t\t\t\t\\tabitem Other minor information\n', '\t\t\t} & 2 & \\makecell[{{p{4cm}}}]{\n', '\t\t\t\tRemove 1 point for every type of information not preserved, up to 2 points.\n', '\t\t\t}\n', '\t\t\\end{tabular}\n', '\t\\end{adjustbox}\n', '\t\n', '\tThis part must be done manually. Quality of the conversion is a measurement that only humans can make.\n', '\t\n', '\tFor each issue evaluated, the results from the rubric were written into a CSV file. \n', '\tAn automated script then tabulated the results and generated this report.\n', '\t\n']
texdoc += ['\\pagebreak']
try:
	f = open('report.tex', 'w+')
except:
	print('Unable to create report.tex')

def scoreGeneric(tex_document, relative_path, issue_tracker_name, project_name):
	gen_score.set_relative_path(relative_path)
	if (gen_score.calculate() != 0):
		tex_document += gen_score.get_table(issue_tracker_name, project_name)
		tex_document += gen_score.get_graph()
		gen_score.reset()

def scoreGoogleCode(tex_document, relative_path, issue_tracker_name, project_name):
	code_score.set_relative_path(relative_path)
	if (code_score.calculate() != 0):
		tex_document += code_score.get_table(issue_tracker_name, project_name)
		tex_document += code_score.get_graph()
		code_score.reset()

scoreGeneric(texdoc, ['GitHub', 'Microsoft Dotnet'], 'GitHub', 'Microsoft Dotnet')
scoreGeneric(texdoc, ['GitHub', 'Defects4J'], 'GitHub', 'Defects4J')
scoreGeneric(texdoc, ['Google Code', 'Appscale'], 'Google Code', 'Appscale')
scoreGeneric(texdoc, ['Google Code', 'Openbookproject'], 'Google Code', 'Openbookproject')
scoreGeneric(texdoc, ['Redmine', 'Project 1'], 'Redmine', 'Project 1')
scoreGeneric(texdoc, ['Redmine', 'Project 2'], 'Redmine', 'Project 2')

texdoc += ['\\end{document}']

for i in range(len(texdoc)):
	f.write(texdoc[i])

f.close()

# print(texdoc)