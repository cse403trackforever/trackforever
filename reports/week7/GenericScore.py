import os
import glob
from pathlib import Path

issues             = []
issue_scores       = []
category_scores    = []
relative_file_path = []
weights            = [2, 1, 1, 1]

# ID,Test1Grade,Test2Grade,Test3Grade,Test4Grade,Test5Grade...
# print(glob.glob('*.csv'))

def debug():
	print('Results:')
	print('Issue IDs (unordered): {0}'.format(issues))
	print('Issue Scores: {0}'.format(issue_scores))
	print('Total Score: {0}'.format(sum(issue_scores)))
	print('Score For Each Category'.format(category_scores))
	print('Final result: {0} / {1}'.format(sum(issue_scores) / len(issues), len(category_scores) + 1))

def set_relative_path(relative_path):
	global relative_file_path
	relative_file_path = os.path.join(*relative_path)
	relative_file_path = glob.glob(relative_file_path + '/*.csv')
	# global relative_file_path
	# relative_file_path = list(Path(relative_path).glob('*.csv'))

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
	for i in range(len(category_scores)):
		final_sum += category_scores[i] * weights[i]
	texTable = ['\\section{{Issue Tracker {0} : Project {1}}}\n'.format(issue_tracker_name, project_name), 
	'\\textbf{Conversion Quality Test}\n', 
	'\\begin{center}\n', 
	'\t\\renewcommand{\\arraystretch}{1.5}\n', 
	'\t\\begin{tabular}{ p{6cm} | c | l }\n', 
	'\t\tTest & Weight & Pass/Fail \\\\ \\hline\n', 
	'\t\tWas important information preserved (Not including user information)? & 2 & {0:.2f} \\\\\n'.format(category_scores[0] / len(issues)), 
	'\t\tAre there any visible errors in the final converted text? & 1 & {0:.2f} \\\\\n'.format(category_scores[1] / len(issues)), 
	'\t\tCan the submitter, commenter, and assignees all be identified (if they exist)? & 1 & {0:.2f} \\\\\n'.format(category_scores[2] / len(issues)), 
	'\t\tIs the issue readable? & 1 & {0:.2f} \\\\\n'.format(category_scores[3] / len(issues)), 
	'\t\\end{tabular}\n', 
	'\\end{center}\n', 
	'Final Score for issue tracker: {0:.2f} / {1:.2f} \\\\ \\\\'.format(final_sum / len(issues), sum(weights))]
	return texTable

def get_graph():
	texGraph = ['\t\\begin{tikzpicture}\n', 
	'\t\\begin{axis}[\n', 
	'\twidth=5in,\n', 
	'\theight=3in,\n', 
	'\tbar width=0.5in,\n',
	'\taxis x line=center,\n', 
	'\taxis y line=left,\n', 
	'\tenlargelimits=true,\n', 
	'\tymin=0,\n', 
	'\tymax=100,\n', 
	'\tnodes near coords,\n', 
	'\tylabel style={align=center},\n', 
	'\tylabel={Percentage Correct},\n', 
	'\tx tick label style={font=\\small,text width=1in,align=center},\n', 
	'\tsymbolic x coords={Information Preservation,Visible Errors,User Identification,Readability},\n', 
	'\txtick=data]\n', 
	'\t\\addplot[ybar] coordinates {\n', 
	'\t\t(Information Preservation,{0:.2f})\n'.format(100 * category_scores[0] / len(issues)), 
	'\t\t(Visible Errors,{0:.2f})\n'.format(100 * category_scores[1] / len(issues)), 
	'\t\t(User Identification,{0:.2f})\n'.format(100 * category_scores[2] / len(issues)), 
	'\t\t(Readability,{0:.2f})\n'.format(100 * category_scores[3] / len(issues)), 
	'\t};\n', 
	'\t\\end{axis}\n', 
	'\t\\end{tikzpicture}']
	return texGraph

def reset():
	issues.clear()
	issue_scores.clear()
	category_scores.clear()
	global relative_file_path
	relative_file_path = []

# calculate()
# debug()
# print(get_table('Google Code', 'spectacular'))
# print(get_graph())