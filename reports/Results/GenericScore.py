import os
import glob
from pathlib import Path

# I'm sorry for using globals. I regret everything.
issues             = []
issue_scores       = []
category_scores    = []
relative_file_path = []
points             = [1, 4, 2, 3, 2]
weights            = [0, 1, 1, 1, 1]

def set_relative_path(relative_path):
	global relative_file_path
	relative_file_path = os.path.join(*relative_path)
	relative_file_path = glob.glob(relative_file_path + '/*.csv')

def calculate():
	# print(relative_file_path)
	for csv_file in relative_file_path:
		try:
			f = open(csv_file)
			for line in f:
				data = line.split(',')
				if len(category_scores) == 0:
					for i in range(len(weights)):
						category_scores.append(0)
				if len(data) - 1 != len(category_scores):
					print('Malformed data detected. Skipping line: {0}'.format(line))
					continue
				issues.append(data[0])
				for i in range(len(category_scores)):
					category_scores[i] += float(data[i + 1])
				issue_score = [float(weights[i] * x) for x in data[1:]]
				issue_scores.append(sum(issue_score))
			f.close()
		except IOError as e:
			print('Cannot open file')
			continue
		except ValueError as e:
			print('Malformed data')
			sys.exit(1)
	return len([csv_file for csv_file in relative_file_path])

def get_table(issue_tracker_name, project_name):
	final_sum = 0
	max_score = 0
	for i in range(len(category_scores)):
		final_sum += category_scores[i] * weights[i]
	for i in range(len(points)):
		max_score += points[i] * weights[i]
	texTable = ['\\section{{Issue Tracker {0} : Project {1}}}\n'.format(issue_tracker_name, project_name), 
	'\\textbf{Conversion Quality Test}\\\\\n', 
	'\\begin{adjustbox}{center}\n', 
	'\t\\renewcommand{\\arraystretch}{1.5}\n', 
	'\t\\begin{tabular}{ p{6cm} | c | c }\n', 
	'\t\tTest & Possible Points & Grading \\\\ \\hline\n', 
	'\t\tDid the issue successfully import? & - & {0:.2f} \\\\\n'.format(category_scores[0] / len(issues)), 
	'\t\t\\hline\n', '\t\t\\makecell[l]{\n', 
	'\t\t\tWas important information preserved? \\\\\n', 
	'\t\t\t\\tabitem Time submitted/updated \\\\\n', 
	'\t\t\t\\tabitem Labels, Status \\\\\n', 
	'\t\t\t\\tabitem Comment/Summary field contents \\\\\n', 
	'\t\t\t\\tabitem Hyperlinks, embedded objects}\n', 
	'\t\t& 4 & {0:.2f} \\\\\n'.format(category_scores[1] / len(issues)), 
	'\t\t\\hline\n', 
	'\t\t\\makecell[l]{\n', 
	'\t\t\tWas user information preserved? \\\\\n', 
	'\t\t\t\\tabitem Submitter/commenter IDs \\\\\n', 
	'\t\t\t\\tabitem Assignee IDs\n', 
	'\t\t}} & 2 & {0:.2f} \\\\\n'.format(category_scores[2] / len(issues)), 
	'\t\t\\hline\n', 
	'\t\t\\makecell[{{p{6cm}}}]{\n', 
	'\t\t\tAre there any rendering errors on the webpage? \\\\\n', 
	'\t\t\t\\tabitem No markdown/formatting errors \\\\\n', 
	'\t\t\t\\tabitem No missing character symbols \\\\\n', 
	'\t\t\t\\tabitem All elements resize properly\n', 
	'\t\t}} & 3 & {0:.2f} \\\\\n'.format(category_scores[3] / len(issues)), 
	'\t\t\\hline\n', 
	'\t\t\\makecell[{{p{6cm}}}]{\n', 
	'\t\t\tAre there any other pieces of information not preserved? \\\\\n', 
	'\t\t\t\\tabitem Platform specific features \\\\\n', 
	'\t\t\t\\tabitem Other minor information\n', 
	'\t\t}} & 2 & {0:.2f} \\\\\n'.format(category_scores[4] / len(issues)), 
	'\t\\end{tabular}\n', 
	'\\end{adjustbox}\n', 
	'\\\\\n',
	'\\\\Total issues examined: {0}'.format(len(issues)), 
	'\\\\Final Score for issue tracker: {0:.2f} / {1:.2f} \\\\ \\\\'.format(final_sum / len(issues), max_score)]
	return texTable

def get_graph():
	texGraph = ['\\begin{adjustbox}{center}\n', 
	'\t\\begin{tikzpicture}\n', 
	'\t\\begin{axis}[\n', 
	'\ttitle={\\textbf{Conversion Quality Graph}},\n', 
	'\twidth=7in,\n', 
	'\theight=7in,\n', 
	'\tbar width=0.5in,\n', 
	'\taxis x line=center,\n', 
	'\taxis y line=left,\n', 
	'\tenlarge x limits,\n', 
	'\tymin=0,\n', 
	'\tymax=105,\n', 
	'\trestrict y to domain=0:100,\n', 
	'\tnodes near coords,\n', 
	'\tylabel style={align=center},\n', 
	'\tylabel={Percentage Correct},\n', 
	'\tx tick label style={font=\\small,text width=1in,align=center},\n', 
	'\tsymbolic x coords={Successful Import,Information Preservation,User Identification,Rendering Errors,Other Information Not Preserved},\n', 
	'\txtick=data]\n', 
	'\t\\addplot[ybar] coordinates {\n', 
	'\t\t(Successful Import,{0:.2f})\n'.format(100 * category_scores[0] / points[0] / len(issues)), 
	'\t\t(Information Preservation,{0:.2f})\n'.format(100 * category_scores[1] / points[1] / len(issues)), 
	'\t\t(User Identification,{0:.2f})\n'.format(100 * category_scores[2] / points[2] / len(issues)), 
	'\t\t(Rendering Errors,{0:.2f})\n'.format(100 * category_scores[3] / points[3] / len(issues)), 
	'\t\t(Other Information Not Preserved, {0:.2f})\n'.format(100 * category_scores[4] / points[4] / len(issues)), 
	'\t};\n', 
	'\t\\end{axis}\n', 
	'\t\\end{tikzpicture} \n', 
	'\\end{adjustbox}\n', 
	'\\\\']
	return texGraph

def reset():
	issues.clear()
	issue_scores.clear()
	category_scores.clear()
	global relative_file_path
	relative_file_path = []