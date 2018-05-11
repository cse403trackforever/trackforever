import GenericScore as gen_score
import GoogleCode as code_score

texdoc = ['\\documentclass{article}\n', '\n', '%for graphics\n', '\\usepackage{pgfplots}\n', '\\pgfplotsset{compat=1.10}\n', '\n', '%paragraph formatting\n', '\\setlength{\\parindent}{0pt}\n', '\\setlength{\\parskip}{1em}\n', '\n', '\n', '\\begin{document}\n', '\n', '\\title{Track Forever Initial Results}\n', '\\date{\\today}\n', '\\author{ Christopher Addison (cjteam) \\\\\n', '         William Cao (pastor13) \\\\\n', '         David Dupre (djdupre) \\\\\n', '         Jared Le (jaredtle) \\\\\n', '         Christine Ta (cta95) }\n', '\\maketitle\n', '\n', '\n', '\\section{Introduction}\n', '    The following report has been automatically generated. Its purpose is to provide \n', '    illustrations of the effectiveness of Track Forever. In order to generate these results, \n', '    several projects were selected from public issue trackers and imported into Track Forever. \n', '    At this point, issues were manually evaluated according to the following rubric.\n', '\n', '    \\begin{center}\n', '        \\renewcommand{\\arraystretch}{1.5}\n', '        \\begin{tabular}{ p{6cm} | c | l }\n', '        Test & Weight & Pass/Fail \\\\ \\hline\n', '        Was important information preserved (Not including user information)? & 2 & Yes/No \\\\\n', '        Are there any visible errors in the final converted text? & 1 & Yes/No \\\\\n', '        Can the submitter, commenter, and assignees all be identified (if they exist)? & 1 & Yes/No \\\\\n', '        Is the issue readable? & 1 & Yes/No \\\\\n', '        \\end{tabular}\n', '    \\end{center}\n', '\n', '    This part must be done manually. Quality of the conversion is a measurement that only humans can make.\n', '\n', '    For each issue evaluated, the results from the rubric were written into a CSV file. \n', '    An automated script then tabulated the results and generated this report.']
texdoc +=['\\pagebreak']
try:
	f = open('report.tex', 'w+')
except:
	print('Unable to create report.tex')

gen_score.set_relative_path(['GitHub', 'Microsoft DotNet'])
if (gen_score.calculate() != 0):
	texdoc += gen_score.get_table('GitHub', 'Microsoft DotNet')
	texdoc += gen_score.get_graph()
	texdoc +=['\\pagebreak']
	gen_score.reset()

gen_score.set_relative_path(['GitHub', 'Minecraft Forge'])
if (gen_score.calculate() != 0):
	texdoc += gen_score.get_table('GitHub', 'Minecraft Forge')
	texdoc += gen_score.get_graph()
	texdoc +=['\\pagebreak']
	gen_score.reset()

code_score.set_relative_path(['Google Code', 'Appscale'])
if (code_score.calculate() != 0):
	texdoc += code_score.get_table('Google Code', 'Appscale')
	texdoc += code_score.get_graph()
	texdoc +=['\\pagebreak']
	code_score.reset()

code_score.set_relative_path(['Google Code', 'OpenBookProject'])
if (code_score.calculate() != 0):
	texdoc += code_score.get_table('Google Code', 'OpenBookProject')
	texdoc += code_score.get_graph()
	texdoc +=['\\pagebreak']
	code_score.reset()
	code_score.set_relative_path(['Google Code', 'OpenBookProjectBiased'])
if (code_score.calculate() != 0):
	texdoc += code_score.get_table('Google Code', 'OpenBookProject (Ignoring Import Errors)')
	texdoc += code_score.get_graph()
	texdoc +=['\\pagebreak']
	code_score.reset()

gen_score.set_relative_path(['Redmine', 'Project1'])
if (gen_score.calculate() != 0):
	texdoc += gen_score.get_table('Redmine', 'Project1')
	texdoc += gen_score.get_graph()
	texdoc +=['\\pagebreak']
	gen_score.reset()

gen_score.set_relative_path(['Redmine', 'Project2'])
if (gen_score.calculate() != 0):
	texdoc += gen_score.get_table('Redmine', 'Project2')
	texdoc += gen_score.get_graph()
	texdoc +=['\\pagebreak']
	gen_score.reset()


texdoc += ['\\end{document}']

for i in range(len(texdoc)):
	f.write(texdoc[i])

f.close()

print(texdoc)