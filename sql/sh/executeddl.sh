ddDir='../ddl'

mysql -u user -p user -P 172.18.0.3

for ddl in $ddlDir;
do
    #mysql -u user -p user -P 172.18.0.3 < $ddl
    $ddl
done