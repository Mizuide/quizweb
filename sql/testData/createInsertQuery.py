import os
import json

ddlDirPath = '../ddl'

currentFile = os.path.dirname(os.path.abspath(__file__))
currentDir = os.path.normpath(os.path.join(currentFile, '.')) 
jsonList = [os.path.join(currentDir,x) for x in os.listdir(currentDir) if os.path.splitext(x)[1] == '.json']
ddlDir = os.path.join(currentDir,'../ddl')
sqlDir = os.path.join(currentDir,'../firstSql')

def createSqlFile():
    ddlNameList = [fileName for fileName in os.listdir(ddlDir)]
    for ddlName in ddlNameList:
        with open(os.path.join(ddlDir,ddlName),'r') as ddlFile:
                with open(os.path.join(sqlDir,ddlName),'w') as sqlFile:
                    sqlFile.write(ddlFile.read())


def appendInitialSet(jsonDic):
    for table,columns in jsonDic.items():
       with open(os.path.join(sqlDir,table+'.sql'),'a') as f:
            #insertQuery
            query =[]
            for column in columns:
                query.append('\nINSERT INTO '+table+' (')
                query += [name + ',' for name in column.keys()]
                query[len(query)-1] = query[len(query)-1].replace(',','')
                query.append(') VALUES (') 
                for v in column.values():
                    if type(v) != str:
                        query.append(str(v)+',')
                    elif type(v) == str:
                        query.append('"'+v+'"'+',')
                query[len(query)-1] = query[len(query)-1].replace(',','')
                query.append(');') 
            f.writelines(query)
            
createSqlFile()

for x in jsonList:
    with open(x,'r') as f:
        jsonDict = json.load(f) 
        appendInitialSet(jsonDict)



