
def generate(type,name,classname):
	cname = name[0].upper() + name[1:]
	if(type == 'String'):
		print('\tpublic void testSetAndGet' + cname + '(){')
		print('\t\tString ' + name + ' = ' + '"' + name + '";')
		print('\t\tassertNull(' + classname + '.get' + cname + '());')
		print('\t\t' + classname + '.set' + cname + '(' + name + ');')
		print('\t\tassertEquals(' + classname + '.get' + cname + '(), ' + name + ');')
		print('\t}')
	elif(type == 'int'):
		print('\tpublic void testSetAndGet' + cname + '(){')
		print('\t\tint ' + name + ' = ' + '1;')
		print('\t\t' + classname + '.set' + cname + '(' + name + ');')
		print('\t\tassertEquals(' + classname + '.get' + cname + '(), ' + name + ', 0);')
		print('\t}')
	print("")

packagename = 'com.usyd.gscp.domain'
classname = 'forumContent'
cclassname = classname[0].upper() + classname[1:]

print('package ' + packagename +';')
print("")
print("import junit.framework.TestCase;")
print("")
print('public class ' + cclassname + 'Test extends TestCase {')
print('\tprivate ' + cclassname + ' ' + classname + ';')
print('\tprotected void setUp() throws Exception {')
print('\t\t' + classname + ' = new ' + cclassname + '();')
print('\t}')

generate("int", "id", classname)
# generate("int", "contentId", classname)
generate("int", "userId", classname)
generate("String", "title", classname)
generate("String", "content", classname)
# generate("String", "name", classname)
# generate("String", "description", classname)
# generate("String", "image", classname)
# generate("String", "url", classname)
# generate("String", "path", classname)
# generate("int", "applicationId", classname)

print('}')

# generate("int", "id", "degree")
# generate("int", "uniId", "degree")
# generate("String", "name", "degree")
# generate("String", "description", "degree")
# generate("int", "degreeId", "application")
# generate("int", "studentId", "application")
# generate("int", "agentId", "application")
# generate("String", "title", "application")
# generate("String", "content", "application")
# generate("int", "status", "application")
